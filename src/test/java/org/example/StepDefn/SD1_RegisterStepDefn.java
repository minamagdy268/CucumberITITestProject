package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg1_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SD1_RegisterStepDefn {
   SoftAssert soft = new SoftAssert();
   Pg1_Register registeration = new Pg1_Register();
   @Given("user go to register page")
    public void user_go_to_register_page(){
       WebElement registerBtn = Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
       registerBtn.click();
   }
   @When("user select gender type")
   public void select_gender(){
      registeration.genderElm().click();
   }
   @And("user enter first name {string} and last name {string}")
   public void enter_Fname_Lname(String firstName, String lastName){
      registeration.fisrtNameElm().sendKeys(firstName);
      registeration.lastNameElm().sendKeys(lastName);
   }
   @And("user enter date of birth")
   public void enter_DateOfBirth(){
      Select dayValue = new Select(registeration.DateOfBirthDayElm());
      dayValue.selectByValue("22");
      Select monthValue = new Select(registeration.DateOfBirthMonthElm());
      monthValue.selectByValue("10");
      Select yearValue = new Select(registeration.DateOfBirthYearElm());
      yearValue.selectByValue("2002");
   }
   @And("user enter email {string} field")
   public void enter_Valid_Email(String email){
   registeration.emailElm().sendKeys(email);
   }
   @And("user fills Password fields {string} and {string}")
   public void enter_password(String password, String confirmPassword){
   registeration.passwordElm().sendKeys(password);
   registeration.confirmPasswordElm().sendKeys(confirmPassword);
   }
   @And("user clicks on register button")
   public void click_register(){
   registeration.registerButtonElm().click();
   }
   @Then("success message is displayed")
   public void success_message(){
      String expectedResult = "Your registration completed";
      String actualResult = registeration.success_msg().getText();
      String registerSuccessMsgColor = registeration.success_msg().getCssValue("color");
      String HexactSuccessColor = Color.fromString(registerSuccessMsgColor).asHex();
      System.out.println(HexactSuccessColor);
      System.out.println("Act Result: "+ actualResult);
      soft.assertTrue(actualResult.contains(expectedResult), "Assertion True");
      soft.assertEquals(HexactSuccessColor,"#4cb17c");
      soft.assertAll();

   }
}
