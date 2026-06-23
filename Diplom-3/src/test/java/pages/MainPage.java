package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By loginButton =
            By.xpath("//button[text()='Войти в аккаунт']");

    private final By profileButton =
            By.xpath("//p[text()='Личный Кабинет']");

    private final By bunsTab =
            By.xpath("//span[text()='Булки']");

    private final By saucesTab =
            By.xpath("//span[text()='Соусы']");

    private final By fillingsTab =
            By.xpath("//span[text()='Начинки']");

    private final By activeSaucesTab =
            By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Соусы']");

    private final By activeFillingsTab =
            By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Начинки']");

    private final By activeBunsTab =
            By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Булки']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Перейти в личный кабинет")
    public void clickProfileButton() {
        click(profileButton);
    }

    @Step("Перейти в раздел Соусы")
    public void clickSauces() {
        click(saucesTab);
    }

    @Step("Перейти в раздел Начинки")
    public void clickFillings() {
        click(fillingsTab);
    }

    @Step("Перейти в раздел Булки")
    public void clickBuns() {
        click(bunsTab);
    }

    @Step("Проверить, что раздел Соусы активен")
    public boolean isSaucesSelected() {
        return isDisplayed(activeSaucesTab);
    }

    @Step("Проверить, что раздел Начинки активен")
    public boolean isFillingsSelected() {
        return isDisplayed(activeFillingsTab);
    }

    @Step("Проверить, что раздел Булки активен")
    public boolean isBunsSelected() {
        return isDisplayed(activeBunsTab);
    }
}