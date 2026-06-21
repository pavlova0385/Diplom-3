package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();

        String browser = System.getProperty("browser","chrome");

        driver = DriverFactory.getDriver(browser);

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){

        driver.quit();
    }
}
