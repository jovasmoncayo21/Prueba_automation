package login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilerias.Objetos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilerias.Sesion;

import java.io.FileReader;
import java.util.Properties;

import static utilerias.Sesion.driver;
import static utilerias.Sesion.properties;

public class LoginSteps {


    public static void inicioSesion() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        properties.load(new FileReader("src\\test\\java\\resources\\Test.properties"));
        driver.get(properties.getProperty("URLDev"));

        //Bandera de inicio
        System.out.println("Ingreso de datos");

        //Ingreso a plataforma de KRM
        driver.findElement(By.xpath(Objetos.userAdmin)).sendKeys(properties.getProperty("userAdmin"));
        Thread.sleep(2000);

        //Ingreso de password
        driver.findElement(By.xpath(Objetos.password)).sendKeys(properties.getProperty("password"));
        Thread.sleep(2000);

        //Click boton Acceder
        driver.findElement(By.xpath(Objetos.btnAcceder)).click();
    }
}
