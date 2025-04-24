package login;

import main.Main;
import utilerias.Objetos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class Login extends Main {

    private static WebDriver driver = Main.driver;
    private static Properties properties = Main.properties;
    static WebDriverWait wait = new WebDriverWait(driver, 2000);

    public static void inicioSesion() throws InterruptedException {

        //Bandera de inicio
        System.out.println("Ingreso de datos");

        //Ingreso a plataforma de KRM
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Objetos.userAdmin)));
        driver.findElement(By.xpath(Objetos.userAdmin)).sendKeys(properties.getProperty("userAdmin"));
        Thread.sleep(2000);

        //Ingreso de password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Objetos.password)));
        driver.findElement(By.xpath(Objetos.password)).sendKeys(properties.getProperty("password"));
        Thread.sleep(2000);

        //Click boton Acceder
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Objetos.btnAcceder)));
        driver.findElement(By.xpath(Objetos.btnAcceder)).click();



    }
}
