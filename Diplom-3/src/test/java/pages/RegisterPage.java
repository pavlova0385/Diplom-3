package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By nameField =
            By.xpath("//label[text()='Имя']/following-sibling::input");

    private final By emailField =
            By.xpath("//label[text()='Email']/following-sibling::input");

    private final By passwordField =
            By.xpath("//input[@type='password']");

    private final By registerButton =
            By.xpath("//button[text()='Зарегистрироваться']");

    private final By loginLink =
            By.xpath("//a[text()='Войти']");

    private final By passwordError =
            By.xpath("//*[contains(text(),'Некорректный пароль')]");

    private final By loginButton =
            By.xpath("//button[text()='Войти']");

    public void open() {
        driver.get("https://stellarburgers.education-services.ru/register");
    }

    public void register(String name,
                         String email,
                         String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        ).sendKeys(name);

        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();
    }

    public boolean isPasswordErrorVisible() {

        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(passwordError)
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginPageOpened() {

        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(loginButton)
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}