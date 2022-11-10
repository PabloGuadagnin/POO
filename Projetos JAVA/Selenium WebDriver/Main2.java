import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
                // Manipula a proporção do navegador, no caso: maximizado
                driver.manage().window().maximize();
                // Atribui o endereço ao objeto
                driver.get("https://www.mercadolivre.com.br/");
        
            WebElement busca = driver.findElement(By.className("nav-search-input"));
                busca.sendKeys("PlayStation 5");
        
                WebElement clickOk = driver.findElement(By.className("nav-search-btn"));
                clickOk.click();
        
                WebElement resultadoBusca = driver.findElement(By.className("shops__item-title"));
                String resultado = resultadoBusca.getText();

                System.out.println(resultado);
                resultado = resultado.toLowerCase();

              if (resultado.contains("playstation"))
              System.out.println("sucesso");

                    
        driver.close();
    }
}
