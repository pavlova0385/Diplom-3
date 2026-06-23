package tests;

import client.UserClient;
import driver.BaseTest;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.UserGenerator;

public class LoginTest extends BaseTest {

    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    public void createUser() {

        userClient = new UserClient();

        user = UserGenerator.getRandomUser();

        Response response =
                userClient.create(user);

        accessToken =
                response.path("accessToken");
    }

    @After
    public void deleteUser() {

        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }

    @Test
    public void loginFromMainPage() {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                user.getEmail(),
                user.getPassword()
        );

        Assert.assertTrue(
                loginPage.isUserLoggedIn()
        );
    }

    @Test
    public void loginFromPersonalAccount() {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickProfileButton();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                user.getEmail(),
                user.getPassword()
        );

        Assert.assertTrue(
                loginPage.isUserLoggedIn()
        );
    }

    @Test
    public void loginFromRegisterForm() {

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.open();

        LoginPage loginPage =
                registerPage.clickLoginLink();

        loginPage.login(
                user.getEmail(),
                user.getPassword()
        );

        Assert.assertTrue(
                loginPage.isUserLoggedIn()
        );
    }

    @Test
    public void loginFromForgotPassword() {

        MainPage mainPage =
                new MainPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.clickForgotPasswordLink();
        loginPage.clickLoginFromForgotPassword();

        loginPage.login(
                user.getEmail(),
                user.getPassword()
        );

        Assert.assertTrue(
                loginPage.isUserLoggedIn()
        );
    }
}