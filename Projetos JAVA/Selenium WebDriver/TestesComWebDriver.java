import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        busca.sendKeys("PS5");

        WebElement clickOk = driver.findElement(By.className("nav-search-btn"));
        clickOk.click();

        WebElement resultadoBusca = driver.findElement(By.className("shops__item-title"));
        String resultado = resultadoBusca.getText();

        boolean sucesso;
        if (resultado.toLowerCase().contains("Ps5"))
            sucesso = true;
            sucesso = false;

        boolean sucesso2;
        if (resultado.toLowerCase().contains("schwarzenegger"))
            sucesso2 = true;
            sucesso2 = false;
        
        assertEquals(true, sucesso);
        assertNotEquals(true, sucesso2);

    }

    /**
     * Responsável por fechar o navegador ao final dos testes
     */
    @After
    public void fechaNavegador() {
        driver.close();
    }

}