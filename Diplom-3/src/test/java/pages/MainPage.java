package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

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

    public void open(){
        driver.get("https://stellarburgers.education-services.ru/");
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickProfileButton(){
        driver.findElement(profileButton).click();
    }

    public void clickSauces(){
        driver.findElement(saucesTab).click();
    }

    public void clickFillings(){
        driver.findElement(fillingsTab).click();
    }

    public void clickBuns(){
        driver.findElement(bunsTab).click();
    }

    public boolean isSaucesSelected(){

        return driver.findElement(
                By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Соусы']")
        ).isDisplayed();
    }

    public boolean isFillingsSelected(){

        return driver.findElement(
                By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Начинки']")
        ).isDisplayed();
    }

    public boolean isBunsSelected(){

        return driver.findElement(
                By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='Булки']")
        ).isDisplayed();
    }
}
