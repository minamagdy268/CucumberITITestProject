package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SD3_ResetStepDefn {
    Pg3_HomePage homePage = new Pg3_HomePage();
    @Given("user open login page")
    public void user_open_login_page(){
        WebElement loginBtn = Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));
        loginBtn.click();
    }
    @When("user click on Forgot Password?")
    public void click_forgot_password(){
        homePage.forgot_password().click();
    }
    @And("^user enter valid \"(.*)\"$")
    public void enter_vaid_email(String email){
        homePage.recovery_email().sendKeys(email);
    }
    @And("user click on RECOVER button")
    public void click_recover(){
        homePage.recoverybtn().click();
    }
    @Then("Email with instructions will be sent")
    public void success_recover(){
        String actualResult = homePage.sent_instruction().getText();
        System.out.println(actualResult);
        Assert.assertEquals("Email with instructions has been sent to you.",actualResult);
    }

}
