package tests;

import login.LoginSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilerias.Sesion;

import java.io.FileReader;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--headless"); // <- importante para Jenkins
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(options);
        Sesion.driver = new ChromeDriver(options);
        Sesion.driver.manage().window().maximize();
        Sesion.properties.load(new FileReader("src\\test\\java\\resources\\Test.properties"));
    }

    @Test
    public void testInicioSesion() throws Exception {
        Sesion.driver.get(Sesion.properties.getProperty("URLDev"));
        LoginSteps.inicioSesion();

        /* Aquí puedes validar algo visual, por ejemplo si se muestra el dashboard o algo que confirme el login
        String titulo = Sesion.driver.getTitle();
        assertTrue("No se logró iniciar sesión correctamente", titulo.contains("Dashboard")); // ejemplo
        // Validación sencilla con assert
        org.junit.Assert.assertEquals("El título de la página no coincide", tituloEsperado, tituloActual);*/
    }

    @After
    public void tearDown() {
        if (Sesion.driver != null) {
            Sesion.driver.quit();
        }
    }
}
