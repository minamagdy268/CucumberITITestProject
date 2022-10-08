package org.example.pages;

import org.example.StepDefn.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Pg2_Login {
    public WebElement emailElm(){
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement passwordElm(){
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement login_btnElm(){
        return Hooks.driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
    }
    public WebElement my_accountElm(){
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/customer/info\"]"));
    }
    public WebElement UnsuccessfulLoginElm(){
        return Hooks.driver.findElement(By.xpath("//div[contains(@class, 'message-error')]"));
    }

}
