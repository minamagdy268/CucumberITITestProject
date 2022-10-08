package org.example.StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SD7_SliderStepDefn {
    Pg3_HomePage slider = new Pg3_HomePage();
    @When("User select the first slider")
    public void select_ft_sliderBtn() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(slider.ft_Slider_Btn_Elm().getText());
        slider.ft_Slider_Btn_Elm().click();
    }
    @And("User click on first slider")
    public void click_Ft_Slider() {
        slider.ft_SliderElm().click();
    }
    @Then("User redirected to first slider URl")
    public void ft_slider_Page(){
        Hooks.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String currentURL = Hooks.driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL,"https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    @When("User select the second slider")
    public void select_sec_sliderBtn() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(slider.sec_Slider_Btn_Elm().getText());
        slider.sec_Slider_Btn_Elm().click();
    }
    @And("User click on second slider")
    public void click_sec_Slider() throws InterruptedException {

        Thread.sleep(2000);
        slider.sec_SliderElm().click();
    }
    @Then("User redirected to second slider URl")
    public void sec_slider_Page(){
        Hooks.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String currentURL = Hooks.driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL,"https://demo.nopcommerce.com/iphone-6");
    }
}
