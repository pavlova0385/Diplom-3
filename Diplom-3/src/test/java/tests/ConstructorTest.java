package tests;

import driver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    public void openSaucesTab(){

        MainPage page = new MainPage(driver);

        page.open();

        page.clickSauces();

        Assert.assertTrue(page.isSaucesSelected());
    }

    @Test
    public void openFillingsTab(){

        MainPage page = new MainPage(driver);

        page.open();

        page.clickFillings();

        Assert.assertTrue(page.isFillingsSelected());
    }

    @Test
    public void openBunsTab(){

        MainPage page = new MainPage(driver);

        page.open();

        page.clickSauces();
        page.clickBuns();

        Assert.assertTrue(page.isBunsSelected());
    }
}
