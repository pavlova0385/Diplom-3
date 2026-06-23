package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver(String browser){

        if(browser.equalsIgnoreCase("yandex")){

            System.setProperty(
                    "webdriver.chrome.driver",
                    "src/test/resources/yandexdriver.exe"
            );

            ChromeOptions options = new ChromeOptions();

            options.setBinary(
                    "C:\\Users\\Анна\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"
            );

            return new ChromeDriver(options);
        }

        return new ChromeDriver();
    }
}