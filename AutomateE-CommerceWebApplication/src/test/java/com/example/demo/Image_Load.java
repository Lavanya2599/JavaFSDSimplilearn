package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_Load {
	WebDriver wd;
	 @BeforeTest
	  public void config() {
	  	WebDriverManager.chromedriver().setup();
	  	wd=new ChromeDriver();
	  	wd.manage().window().maximize();
	  	
	  }

	  @AfterTest
	  public void quitbrowser() throws InterruptedException {
		  Thread.sleep(2000);
	  	wd.quit();
	  }
	  @Test
	    public void test1() {
		  wd.get("https://www.flipkart.com/search?q=realme&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
     WebElement we1=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[4]/div/div/div/a/div[1]/div[1]/div/div/img"));
	  if(we1.isDisplayed())
	  {
		  System.out.println("Image is not present before scrolling"); 
    	  Reporter.log("Image is not present before scrolling");
	  }
	  JavascriptExecutor js = (JavascriptExecutor) wd;  
	   js.executeScript("window.scrollBy(0,500)");
	   if(we1.isDisplayed())
		  {
			  System.out.println("Image is present after scrolling"); 
	    	  Reporter.log("Image is present after scrolling");
		  }
	  }}

