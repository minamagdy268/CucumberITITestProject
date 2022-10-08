package org.example.StepDefn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SD5_CurrencyStepDefn {
    Pg3_HomePage currency = new Pg3_HomePage();

    @Given("User click on currency list and select currency")
    public void currency_list() {
        currency.currency_list().click();
        Select currencyValue = new Select(currency.currency_list());
        currencyValue.selectByVisibleText("Euro");
    }

    @Then("Items price is in Euro")
    public void prices_currency() {
        int itesmSize = Hooks.driver.findElements(By.cssSelector("div[class=\"prices\"]")).size();
        System.out.println(" Displayed items size:  " + itesmSize);

        for (int i = 0; i < itesmSize; i++) {
            String itemText = Hooks.driver.findElements(By.cssSelector("div[class=\"prices\"]")).get(i).getText();
            System.out.println(itemText);
            Assert.assertTrue(currency.price_currency().get(i).getText().contains("€"),"Euro dislayed");

        }
    }
}
