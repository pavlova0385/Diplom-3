package tests;

import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void successfulRegistration() {

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.open();

        String email =
                "anna" + System.currentTimeMillis() + "@mail.ru";

        registerPage.register(
                "Анна",
                email,
                "password123"
        );

        Assert.assertTrue(
                "После регистрации не открылась страница входа",
                registerPage.isLoginPageOpened()
        );
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