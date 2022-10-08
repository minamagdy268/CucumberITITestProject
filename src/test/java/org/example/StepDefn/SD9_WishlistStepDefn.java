package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class SD9_WishlistStepDefn {
    SoftAssert soft = new SoftAssert();
    Pg3_HomePage wishlist = new Pg3_HomePage();
    @When("user click on wishlist icon")
    public void click_wishlist_icon(){
        wishlist.featured_product().click();
    }

    @Then("Product added to wishlist successfully")
    public void productAddedToWishlistSuccessfully() {

        String successMsg = wishlist.success_wishlist_msg().getText();
        String actSuccessMsgColor = wishlist.success_wishlist_msg().getCssValue("background-color");
        String HexactSuccessMsgColor = Color.fromString(actSuccessMsgColor).asHex();
        System.out.println(HexactSuccessMsgColor);
        System.out.println( successMsg );
        soft.assertTrue(successMsg.contains("The product has been added to your wishlist"));
        soft.assertEquals(HexactSuccessMsgColor,"#4bb07a");
        soft.assertAll();
    }

    @And("user click on wishlist tab")
    public void userClickOnWishlistTab() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(wishlist.success_wishlist_msg ()));
        wishlist.wishlist_tab ().click();
    }

    @Then("wishlist contain the added product")
    public void wishlistContainTheAddedProduct() {
        String Qty =  wishlist. wishlist_Qty ().getAttribute("value");
        Integer IntegerQty = Integer.parseInt(Qty);
        System.out.println(Qty);
        Assert.assertTrue(IntegerQty>0);
    }
}
