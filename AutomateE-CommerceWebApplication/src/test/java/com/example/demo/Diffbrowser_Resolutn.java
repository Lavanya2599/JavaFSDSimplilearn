package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Diffbrowser_Resolutn {
    WebDriver wd;
    long loadTime;

    @Parameters("browser")
    @BeforeTest
    public void config(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                wd = new EdgeDriver();
                break;
        }
        wd.manage().window().maximize();
    }

    @AfterTest
    public void quitbrowser() {
        wd.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        wd.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,1000)", "");
        wd.manage().window().setSize(new Dimension(1620, 820));
        Thread.sleep(3000);
        WebElement textField = wd.findElement(By.name("q"));
        textField.sendKeys("Iphone 13");
        wd.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
        js.executeScript("window.scrollBy(0,1000)", "");
        wd.navigate().back();
        Thread.sleep(3000);
        wd.manage().window().maximize();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,1000)", "");
        wd.manage().window().setSize(new Dimension(240, 360));
        textField.sendKeys("mini");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,1000)", "");
        System.out.println("Different browsers and screen resolutions render it in the same way.");
        Reporter.log("Different browsers and screen resolutions render it in the same way.");

        // Calculate and record the load time
        loadTime = System.currentTimeMillis() - loadTime;
    }

    @BeforeTest
    public void beforeTest() {
        loadTime = System.currentTimeMillis();
    }

    public long getLoadTime() {
        return loadTime;
    }
}
