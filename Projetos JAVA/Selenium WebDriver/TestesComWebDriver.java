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
        // Faz o programa esperar 10 segundos para conferir (bom para internet lenta)
        // new WebDriverWait(driver, Duration.ofSeconds(10));
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
     * Verifica se o Login está funcionando
     */
    @Test
    public void testeDeLogin() {
        WebElement btLogin = driver.findElement(By.partialLinkText("Entre"));
        btLogin.click();

        WebElement cxTexto = driver.findElement(By.name("user_id"));
        cxTexto.sendKeys("@hotmail.com");
    }

    /**
     * Responsável por fechar o navegador ao final dos testes
     */
    @After
    public void fechaNavegador() {
        driver.close();
    }
}