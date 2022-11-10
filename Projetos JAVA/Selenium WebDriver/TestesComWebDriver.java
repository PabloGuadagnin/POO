import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestesComWebDriver {

    // Cria o objeto driver que será manipulado nos testes
    WebDriver driver = new ChromeDriver();

    /**
     * Responsável por abrir o navegador no início dos testes
     */
    @Before
    public void abreNavegador() {
        // Manipula a proporção do navegador, no caso: maximizado
        driver.manage().window().maximize();
        // Atribui o endereço ao objeto
        driver.get("https://www.mercadolivre.com.br/");
    }

    /**
     * Teste responsável por verificar o título do site
     */
    @Test
    public void verificaTitulo() {

        String tituloAtual = driver.getTitle();
        String tituloEsperado = "BLACK FRIDAY 2022 A partir de Outubro! No Mercado Livre";
        String tituloErrado = "Título Qualquer";

        assertEquals(tituloEsperado, tituloAtual);
        assertNotEquals(tituloEsperado, tituloErrado);
    }

    /**
     * Verifica se a busca está funcionando corretamente
     */
    @Test
    public void verificaSeBuscaEstaFuncionando() {

        WebElement busca = driver.findElement(By.className("nav-search-input"));
        busca.sendKeys("PlayStation 5");

        WebElement clickOk = driver.findElement(By.className("nav-search-btn"));
        clickOk.click();

        WebElement resultadoBusca = driver.findElement(By.className("shops__item-title"));
        String resultado = resultadoBusca.getText();
        resultado = resultado.toLowerCase();

        assertEquals(true, resultado.contains("playstation"));
        assertNotEquals(true, resultado.contains("schwarzenegger"));
    }

    /**
     * Verifica se o site está consultando emails válidos no banco
     * e informando que o email inserido é inválido
     * @throws InterruptedException
     */
    @Test
    public void testeDeConsultaDeEmail() throws InterruptedException {
        WebElement btLogin = driver.findElement(By.partialLinkText("Entre"));
        btLogin.click();

        WebElement btContinue = driver.findElement(By.className("andes-list__item-anchor"));
        Thread.sleep(500);
        btContinue.click();

        WebElement btComecar = driver.findElement(By.className("andes-button"));
        Thread.sleep(500);
        btComecar.click();

        WebElement cxTexto = driver.findElement(By.className("andes-form-control__field"));
        Thread.sleep(500);
        cxTexto.sendKeys("schwarzenegger@hotmail.com");

        WebElement btContinuar = driver.findElement(By.className("andes-button__content"));
        Thread.sleep(500);
        btContinuar.click();

        WebElement txt = driver.findElement(By.className("andes-form-control__message-fixed"));
        txt.getText();

        assertEquals("O e-mail ou usuário é inválido, por favor, volte a inseri-lo.", txt);
        assertNotEquals("ABCD.", txt);
    }

    /**
     * Testa se a mensagem de email digitado é inválido está aparecendo para o
     * usuário
     * @throws InterruptedException
     */
    @Test
    public void testeDeCadastroInvalido() throws InterruptedException {
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
        cxTexto.sendKeys("schwarzenegger");

        WebElement btEnviar = driver.findElement(By.className("andes-button__content"));
        btEnviar.click();

        WebElement txt = driver.findElement(By.className("andes-form-control__message"));
        String txtFormat = txt.getText();

        assertEquals("Utilize o formato nome@exemplo.com.", txtFormat);
        assertNotEquals("ABCD.", txtFormat);
    }

    /**
     * Responsável por fechar o navegador ao final dos testes
     */
    @After
    public void fechaNavegador() {
        driver.close();
    }
}