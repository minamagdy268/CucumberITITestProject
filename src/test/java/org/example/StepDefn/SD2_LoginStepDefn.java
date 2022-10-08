package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg2_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import org.testng.asserts.SoftAssert;

public class SD2_LoginStepDefn {
    SoftAssert soft = new SoftAssert();
    Pg2_Login login = new Pg2_Login();
    @Given("user go to login page")
    public void user_go_to_login_page(){
        System.out.println("Am I working ?!");    WebElement loginBtn = Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));
        loginBtn.click();
    }

   @When("^user login with valid \"(.*)\" and \"(.*)\"$")
   public void enter_login_credentials(String email, String password){
         login.emailElm().sendKeys(email);
         login.passwordElm().sendKeys(password);
   }
   @And("user press on login button")
    public void click_Loginbtn(){
         login.login_btnElm().click();
   }
   @Then("user login to the system successfully")
    public void success_login(){
        System.out.println("URL: " + Hooks.driver.getCurrentUrl());
        Hooks.driver.getCurrentUrl();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        soft.assertTrue(login.my_accountElm().isDisplayed(),"my account");
        soft.assertAll();
    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String email, String password) {
        login.emailElm().sendKeys(email);
        login.passwordElm().sendKeys(password);
    }

    @Then("user can't login to the system")
    public void userCanTLoginToTheSystem() {
     String unsuccessfulmsg=    login.UnsuccessfulLoginElm().getText();
     String unsuccessfulmsgColor= login.UnsuccessfulLoginElm().getCssValue("color");
     String HexaunsuccessfulmsgColor = Color.fromString(unsuccessfulmsgColor).asHex();
        System.out.println(unsuccessfulmsg);
        System.out.println( HexaunsuccessfulmsgColor );
        soft.assertTrue(unsuccessfulmsg.contains("Login was unsuccessful"));
        soft.assertEquals(HexaunsuccessfulmsgColor,"#e4434b");
        soft.assertAll();
    }
}
