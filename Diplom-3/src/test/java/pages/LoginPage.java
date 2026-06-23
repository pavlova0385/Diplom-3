package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField =
            By.xpath("//input[contains(@class,'text input__textfield') and @type='text']");

    private final By passwordField =
            By.xpath("//input[@type='password']");

    private final By loginButton =
            By.xpath("//button[text()='Войти']");

    private final By registerLink =
            By.xpath("//a[@href='/register']");

    private final By forgotPasswordLink =
            By.xpath("//a[@href='/forgot-password']");

    private final By loginLinkFromForgotPassword =
            By.xpath("//a[@href='/login']");

    private final By profileButton =
            By.xpath("//p[text()='Личный Кабинет']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Авторизация пользователя")
    public void login(String email, String password) {

        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        click(loginButton);
    }

    @Step("Переход на регистрацию")
    public void clickRegisterLink() {
        click(registerLink);
    }

    @Step("Переход на восстановление пароля")
    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    @Step("Переход на страницу логина")
    public void clickLoginFromForgotPassword() {
        click(loginLinkFromForgotPassword);
    }

    @Step("Проверка авторизации")
    public boolean isUserLoggedIn() {
        return isDisplayed(profileButton);
    }
}