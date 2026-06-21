package tests;

import driver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest {

    private final String email = "ТВОЙ_EMAIL";
    private final String password = "ТВОЙ_ПАРОЛЬ";

    @Test
    public void loginFromMainPage(){

        MainPage main = new MainPage(driver);

        main.open();

        main.clickLoginButton();

        LoginPage login = new LoginPage(driver);

        login.login(email,password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/")
        );
    }

    @Test
    public void loginFromPersonalAccount(){

        MainPage main = new MainPage(driver);

        main.open();

        main.clickProfileButton();

        LoginPage login = new LoginPage(driver);

        login.login(email,password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/")
        );
    }

    @Test
    public void loginFromRegisterForm(){

        RegisterPage register =
                new RegisterPage(driver);

        register.open();

        register.clickLoginLink();

        LoginPage login = new LoginPage(driver);

        login.login(email,password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/")
        );
    }

    @Test
    public void loginFromForgotPassword(){

        driver.get(
                "https://stellarburgers.education-services.ru/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.clickForgotPasswordLink();

        driver.findElement(
                org.openqa.selenium.By.xpath("//a[text()='Войти']")
        ).click();

        loginPage.login(email,password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/")
        );
    }
}
