package com.example.demo;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Reporter;

import org.testng.annotations.AfterTest;

public class ContentRefresh {
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
	  wd.get("https://www.flipkart.com/search?q=iphone+13&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&as-pos=1&as-type=RECENT&suggestionId=iphone+13%7CMobiles&requestId=ee111f6f-1edd-495d-9c8a-eec51bb9a9d5&as-searchtext=iph");
	  long startTime = System.currentTimeMillis();
	  wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
      JavascriptExecutor js = (JavascriptExecutor) wd;

      //specify the WebElement till which the page has to be scrolled
      WebElement element = wd.findElement(By.xpath("//div[@class='CXW8mj']"));

      js.executeScript("arguments[0].scrollIntoView();", element);

	  long endTime = System.currentTimeMillis();
	  long totalTime = endTime - startTime;
	  System.out.println("Total Content Load Time while Scrolling: " + totalTime + " milliseconds");
	  Reporter.log("Total Content Load Time while Scrolling: " + totalTime + " milliseconds");
	
  }
 
}
