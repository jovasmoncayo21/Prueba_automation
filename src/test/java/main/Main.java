package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class Main {

    public static Properties properties = new Properties();
    public static WebDriver driver;

    public static void main(String[] args) {

        System.out.println("Bienvendido a QA automation Test!");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Login básico
        driver.get("https://dev.krm.kapitalizer.mx/#/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("administrative");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("prueba123");
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/button[1]")).click();
    }
}