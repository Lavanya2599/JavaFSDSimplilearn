package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_Flipkart {
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
	    public void test1() throws InterruptedException {
		  wd.get("https://www.flipkart.com/");
		  //Thread.sleep(2000);
		  //wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		  String url=wd.getCurrentUrl();
		  String title=wd.getTitle();
		 Assert.assertEquals("https://www.flipkart.com/",url);
		System.out.println("Flipkart url matched!!");
		Reporter.log("Flipkart url matched!!");
		 Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",title);
		 System.out.println("Flipkart title matched!!");
			Reporter.log("Flipkart title matched!!");
			System.out.println("Navigated to Flipkart!!");
			Reporter.log("Navigated to Flipkart!!");
		 Thread.sleep(2000);
		  
		  
	  }}
