package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
public class SD4_SearchStepDefn {
    SoftAssert soft = new SoftAssert();
    Pg3_HomePage search = new Pg3_HomePage();

    @Given("user click on search field")
    public void click_search() {
        search.search_field().click();
    }

    @When("user enter {string} and click enter")
    public void enter_productname(String productname) {
        search.search_field().sendKeys(productname);
        search.search_field().sendKeys(Keys.ENTER);
    }

    @Then("user get products contain {string}")
    public void search_result(String productname) {
        System.out.println(productname);
        String actualUrl = Hooks.driver.getCurrentUrl();
        System.out.println(actualUrl);
        soft.assertTrue(actualUrl.contains("https://demo.nopcommerce.com/search?q"));
        int count = search.result_count().size();
        System.out.println(" Displayed items :  " + count);

        for (int i = 0; i < count; i++) {
            String itemText = search.result_count().get(i).getText();
            System.out.println(itemText);
            soft.assertTrue(itemText.toLowerCase().contains(productname));
        }
        soft.assertAll();
    }
    @When("user enter sku {string} and click enter")
    public void userEnterSkuAndClickEnter(String sku) {
        search.search_field().sendKeys(sku);
        search.search_field().sendKeys(Keys.ENTER);
    }
    @And("user click on product from search result")
    public void ClickOnProduct() {
         search.result_count().get(0).click();
    }

    @Then("Used {string} shown in the product page")
    public void ShownInTheProductPage(String sku) {
       String actualskuText= search. sku_item().getText();
       String expectedsku= "SKU: "+sku;
       System.out.println("actual  "+actualskuText);
       System.out.println("expected "+expectedsku);
       soft.assertEquals(actualskuText,expectedsku);
       soft.assertAll();
    }
}

