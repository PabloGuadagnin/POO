import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // Manipula a proporção do navegador, no caso: maximizado
        driver.manage().window().maximize();
        // Atribui o endereço ao objeto
        driver.get("https://www.mercadolivre.com.br/");

        // Indica o caminho do arquivo que será lido
        String csv = "G:\\Meu Drive\\Rep.GitHub\\Projetos\\Projetos JAVA\\Selenium WebDriver\\teste.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            String linha = br.readLine();
            linha = br.readLine();

            while (linha != null) {

                for (int i = 0; i < 1; i++) {

                String tituloAtual = driver.getTitle();

                String[] palavra = linha.split(",");
                String tituloEsperado = palavra[0];
                String tituloErrado = palavra[1];

                System.out.println(tituloAtual + tituloErrado + tituloEsperado);

                linha = null;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        driver.close();
    }
}
