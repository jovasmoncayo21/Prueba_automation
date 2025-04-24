package main;

import login.Login;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static Properties properties = new Properties();
    public static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        properties.load(new FileReader("src\\test\\java\\Utilerias\\Test.properties"));
        driver.get(properties.getProperty("URLDev"));
    }

    @Test
    public void flujoPrincipal() throws InterruptedException, IOException, AWTException {

        Login.inicioSesion();







    }
}
