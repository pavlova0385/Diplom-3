package tests;

import client.UserClient;
import driver.BaseTest;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest {

    private final UserClient userClient = new UserClient();

    private String accessToken;

    @After
    public void tearDownUser() {

        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }

    @Test
    public void successfulRegistration() {

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.open();

        String email =
                "anna" + System.currentTimeMillis() + "@mail.ru";

        String password = "password123";

        registerPage.register(
                "Анна",
                email,
                password
        );
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(
                "После регистрации не открылась страница входа",
                registerPage.isLoginPageOpened()
        );


        User user =
                new User(email, password, "Анна");

        Response response =
                userClient.login(user);

        accessToken =
                response.path("accessToken");
    }

    @Test
    public void registrationWithShortPassword() {

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.open();

        String email =
                "anna" + System.currentTimeMillis() + "@mail.ru";

        registerPage.register(
                "Анна",
                email,
                "12345"
        );

        Assert.assertTrue(
                "Не появилась ошибка пароля",
                registerPage.isPasswordErrorVisible()
        );
    }
}