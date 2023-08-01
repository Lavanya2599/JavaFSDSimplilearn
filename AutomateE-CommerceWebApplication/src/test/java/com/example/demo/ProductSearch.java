package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductSearch {
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
	   wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	   wd.findElement(By.name("q")).click();
	   Thread.sleep(2000);
	   wd.findElement(By.name("q")).sendKeys("iPhone 13",Keys.ENTER);
	//   wd.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg")).click();
	   Thread.sleep(2000);
	   System.out.println("Product searched successfully");
	   Reporter.log("Product searched successfully");
	   
}}
