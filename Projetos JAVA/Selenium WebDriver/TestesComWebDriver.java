import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TestesComWebDriver {

    // Cria o objeto driver que será manipulado nos testes
    WebDriver driver = new ChromeDriver();
    // Indica o caminho do arquivo que será lido
    String csv = "G:\\Meu Drive\\Rep.GitHub\\Projetos\\Projetos JAVA\\Selenium WebDriver\\teste.csv";

    /**
     * Responsável por abrir o navegador no início dos testes
     */
    @Before
    public void abreNavegador() {
        // Manipula a proporção do navegador, no caso: maximizado
        driver.manage().window().maximize();
        // Atribui o endereço ao objeto
        driver.get("https://www.mercadolivre.com.br/");
        // Fecha a mensagem de cookies do site
        WebElement clickOk = driver.findElement(By.className("cookie-consent-banner-opt-out__action--key-accept"));
        clickOk.click();
    }

    /**
     * Teste responsável por verificar o título do site
     * 
     * @throws IOException
     * @throws CsvValidationException
     */
    @Test
    public void verificaTitulo() throws CsvValidationException, IOException {

        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                String tituloAtual = driver.getTitle();

                String tituloEsperado = tableline[1];
                String tituloErrado = tableline[2];

                assertEquals(tituloEsperado, tituloAtual);
                assertNotEquals(tituloEsperado, tituloErrado);
            }
        }
    }

    /**
     * Verifica se a busca está funcionando corretamente
     * 
     * @throws InterruptedException
     * @throws IOException
     * @throws CsvValidationException
     */
    @Test
    public void verificaSeBuscaEstaFuncionando() throws InterruptedException, IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement busca = driver.findElement(By.className("nav-search-input"));
                busca.sendKeys(tableline[3]);

                WebElement clickOk = driver.findElement(By.className("nav-search-btn"));
                clickOk.click();

                Thread.sleep(1000);

                WebElement resultadoBusca = driver.findElement(By.className("shops__item-title"));
                String resultado = resultadoBusca.getText();
                resultado = resultado.toLowerCase();

                assertEquals(true, resultado.contains(tableline[4]));
                assertNotEquals(true, resultado.contains(tableline[5]));
            }
        }
    }

    /**
     * Testa se a mensagem de conta existente está aparecendo para o
     * usuário ao tentar cadastrar uma nova conta com email
     * já cadastrado
     * 
     * @throws InterruptedException
     * @throws IOException
     * @throws CsvValidationException
     */
    @Test
    public void testeDeCadastroExistente() throws InterruptedException, CsvValidationException, IOException {

        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement btCriaConta = driver.findElement(By.partialLinkText("Crie a sua conta"));
                btCriaConta.click();

                WebElement checkBox = driver.findElement(By.id("terms-and-conds"));
                Thread.sleep(500);
                checkBox.click();

                WebElement btContinuar = driver.findElement(By.className("andes-button__content"));
                btContinuar.click();

                WebElement btValidar = driver.findElement(By.className("andes-button__content"));
                Thread.sleep(500);
                btValidar.click();

                WebElement cxTexto = driver.findElement(By.name("email"));
                Thread.sleep(500);
                cxTexto.sendKeys(tableline[9]);

                WebElement btEnviar = driver.findElement(By.className("andes-button__content"));
                btEnviar.click();

                Thread.sleep(1000);

                WebElement txt = driver.findElement(By.className("andes-modal__title"));
                Thread.sleep(500);
                String txtFormat = txt.getText();

                assertEquals(tableline[10], txtFormat);
                assertNotEquals(tableline[2], txtFormat);
            }
        }
    }

    /**
     * Testa se a mensagem de email digitado é inválido está aparecendo para o
     * usuário ao tentar cadastrar uma nova conta
     * 
     * @throws InterruptedException
     * @throws IOException
     * @throws CsvValidationException
     */
    @Test
    public void testeDeCadastroInvalido() throws InterruptedException, CsvValidationException, IOException {

        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement btCriaConta = driver.findElement(By.partialLinkText("Crie a sua conta"));
                btCriaConta.click();

                WebElement checkBox = driver.findElement(By.id("terms-and-conds"));
                Thread.sleep(500);
                checkBox.click();

                WebElement btContinuar = driver.findElement(By.className("andes-button__content"));
                btContinuar.click();

                WebElement btValidar = driver.findElement(By.className("andes-button__content"));
                Thread.sleep(500);
                btValidar.click();

                WebElement cxTexto = driver.findElement(By.name("email"));
                Thread.sleep(500);
                cxTexto.sendKeys(tableline[5]);

                WebElement btEnviar = driver.findElement(By.className("andes-button__content"));
                btEnviar.click();

                WebElement txt = driver.findElement(By.className("andes-form-control__message"));
                String txtFormat = txt.getText();

                assertEquals(tableline[8], txtFormat);
                assertNotEquals(tableline[7], txtFormat);
            }
        }
    }

    /**
     * Responsável por fechar o navegador ao final dos testes
     */
    @After
    public void fechaNavegador() {
      //  driver.close();
    }
}