package org.example.pages;

import org.example.StepDefn.Hooks;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class Pg1_Register {

    public WebElement genderElm(){
        return Hooks.driver.findElement(By.id("gender-female"));
//        By gender = By.id("gender-female");
//        WebElement genderElm = driver.findElement(gender);
//        return genderElm;
    }
    public WebElement fisrtNameElm(){
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastNameElm(){
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement DateOfBirthDayElm(){
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement DateOfBirthMonthElm(){
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement DateOfBirthYearElm(){
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement emailElm(){
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement passwordElm(){
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement confirmPasswordElm(){
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement registerButtonElm(){
        return Hooks.driver.findElement(By.id("register-button"));
    }
public WebElement success_msg(){
         return Hooks.driver.findElement(By.className("result"));
}
}
