package org.example.StepDefn;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;
    @Before
    public void open_Browser() throws InterruptedException {
        String path = System.getProperty("user.dir"); // get project path
        System.setProperty("webdriver.chrome.driver",path +"\\src\\main\\resources\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @After
    public void close_Browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
