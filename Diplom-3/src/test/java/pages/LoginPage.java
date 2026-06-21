package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailField =
            By.xpath("//label[text()='Email']/following-sibling::input");

    private final By passwordField =
            By.xpath("//input[@type='password']");

    private final By loginButton =
            By.xpath("//button[text()='Войти']");

    private final By registerLink =
            By.xpath("//a[@href='/register']");

    private final By forgotPasswordLink =
            By.xpath("//a[@href='/forgot-password']");

    public void login(String email,
                      String password){

        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public void clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
    }
}
