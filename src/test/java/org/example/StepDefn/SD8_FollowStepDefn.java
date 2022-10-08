package org.example.StepDefn;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Pg3_HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class SD8_FollowStepDefn {
    Pg3_HomePage follow = new Pg3_HomePage();
    @When("User click on Facebook icon")
    public void follow_facebook(){
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].scrollIntoView();", follow.facebookElm());
        System.out.println(follow.facebookElm().getText());
        follow.facebookElm().click();
    }
    @Then("{string} Facebook page open in new tab")
    public void FacebookPageOpenInNewTab(String URL) {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String currentURL = Hooks.driver.getCurrentUrl();
        System.out.println("current url:  "+ currentURL);
        System.out.println("Expected Url: "+ URL);
        Assert.assertEquals(currentURL,URL);
    }
    @When("User click on Twitter icon")
    public void userCickOnTwitterIcon() {
        System.out.println(follow.twitterElm().getText());
        follow.twitterElm().click();
    }
    @Then("{string} Twitter page open in new tab")
    public void TwitterPageOpenInNewTab(String URL) {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String currentURL = Hooks.driver.getCurrentUrl();
        System.out.println("current url:  "+ currentURL);
        System.out.println("Expected Url: "+ URL);
        Assert.assertEquals(currentURL,URL);    }
    @When("User click on RSS icon")
    public void userCickOnRSSIcon() {
        System.out.println(follow.RssElm().getText());
        follow.RssElm().click();
    }

    @Then("{string} RSS page open in new tab")
    public void RSSPageOpenInNewTab(String URL) {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        int tabsCount = tabs.size();
        System.out.println(tabsCount);
        switch (tabsCount) {
            case 2:
                Hooks.driver.switchTo().window(tabs.get(1));
                String currentURL = Hooks.driver.getCurrentUrl();
                System.out.println("current url:  " + currentURL);
                System.out.println("Expected Url: " + URL);
                Assert.assertEquals(currentURL, URL);
            break;
        }
        String currentURL = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, URL);
}
    @When("User click on Youtube icon")
    public void userCickOnYoutubeIcon() {
        System.out.println(follow.youtubeElm().getText());
        follow.youtubeElm().click();
    }
    @Then("{string} Youtube page open in new tab")
    public void YoutubePageOpenInNewTab(String URL) {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String currentURL = Hooks.driver.getCurrentUrl();
        System.out.println("current url:  "+ currentURL);
        System.out.println("Expected Url: "+ URL);
        Assert.assertEquals(currentURL,URL);
    }


}
