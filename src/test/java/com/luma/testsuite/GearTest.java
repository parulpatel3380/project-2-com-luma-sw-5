package com.luma.testsuite;

import com.luma.pages.GearPage;
import com.luma.pages.HomePage;
import com.luma.pages.OvernightDuffle_Page;
import com.luma.pages.ShoppingcartPage;
import com.luma.testbase.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {
    HomePage homePage;

    GearPage gearPage;
    OvernightDuffle_Page overNightDufflePage;

    ShoppingcartPage shoppingcartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        gearPage = new GearPage();
        overNightDufflePage = new OvernightDuffle_Page();
        shoppingcartPage = new ShoppingcartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        homePage.mouseHoverToGearMenu();
        homePage.clickOnBags();
        gearPage.clickOnProductGear();
        Assert.assertEquals(overNightDufflePage.getTextOvernightDuffle(), "Overnight Duffle");
        overNightDufflePage.changeQTY("3");
        overNightDufflePage.clickOnAddToCart();
        Assert.assertEquals(overNightDufflePage.getAddToCart(), "You added Overnight Duffle to your shopping cart.");
        overNightDufflePage.clickOnShoppingCart();
        Assert.assertEquals(shoppingcartPage.getOverNightDuffle(), "Overnight Duffle");
        Assert.assertEquals(shoppingcartPage.getQTYText(), "3");
        Assert.assertEquals(shoppingcartPage.getProductPrice(), "$135.00");
        shoppingcartPage.changeQTYOfOverNightDuffle("5");
        shoppingcartPage.clickOnUpdateShoppingCart();
        Assert.assertEquals(shoppingcartPage.getUpdateProductPrice(), "$225.00");


    }
}