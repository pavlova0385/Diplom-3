package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//label[text()='Имя']/following-sibling::input")
    private WebElement nameField;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement emailField;

    @FindBy(xpath = "//label[text()='Пароль']/following-sibling::input")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement passwordError;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Открыть страницу регистрации")
    public RegisterPage open() {
        driver.get("https://stellarburgers.education-services.ru/register");
        return this;
    }

    @Step("Зарегистрировать пользователя")
    public RegisterPage register(String name, String email, String password) {

        nameField.clear();
        nameField.sendKeys(name);

        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        registerButton.click();

        return this;
    }

    @Step("Клик по ссылке Войти")
    public LoginPage clickLoginLink() {

        loginLink.click();

        return new LoginPage(driver);
    }

    @Step("Проверка открытия страницы логина")
    public boolean isLoginPageOpened() {

        try {
            wait.until(driver ->
                    driver.getCurrentUrl().contains("/login"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверка отображения ошибки пароля")
    public boolean isPasswordErrorVisible() {

        try {
            return passwordError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}