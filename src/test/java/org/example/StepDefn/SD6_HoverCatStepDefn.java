package org.example.StepDefn;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SD6_HoverCatStepDefn {
    SoftAssert soft = new SoftAssert();
    Pg3_HomePage hover = new Pg3_HomePage();
    @When("User hover randomly on one of main categories")
        public void top_Caregories() throws InterruptedException {
        int randomNum = new Random().nextInt(3);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(hover.topCategories().get(randomNum)).perform();
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        hover.subCategories(randomNum).get(randomNum).click();
        Thread.sleep(2000);

        String MainCategoryText = hover.topCategories().get(randomNum).getText();
        System.out.println("Main category is selected:   " + MainCategoryText);
        int count = hover.subCategories(randomNum).size();
        System.out.println(count);
    }
    @Then("user redirected to sub category page")
    public void sunCategory(){

        String subCategoryText = hover.subPageTitle().getText();
        String subcategorytitle =  hover.subPageTitle().getText();
        String actualUrl = Hooks.driver.getCurrentUrl();
        System.out.println("sub category "+subCategoryText);
        System.out.println("sub category title "+ subcategorytitle);
        System.out.println(actualUrl);
        soft.assertEquals(true, actualUrl.contains(subCategoryText.toLowerCase().trim()));
        soft.assertTrue(subcategorytitle.contains(subCategoryText));
        soft.assertAll();
    }
}
