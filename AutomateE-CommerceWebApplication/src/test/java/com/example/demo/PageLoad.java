package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoad {
	WebDriver wd;
	 @BeforeTest
	  public void config() {
	  	WebDriverManager.chromedriver().setup();
	  	wd=new ChromeDriver();
	  	wd.manage().window().maximize();
	  	
	  }

	  @AfterTest
	  public void quitbrowser() {
	  	wd.quit();
	  }
	  	
	  	
	    @Test
	    public void test1() {
	    long start=System.currentTimeMillis();
	    wd.get("https://www.flipkart.com/");
	    wd.close();
	    long finish=System.currentTimeMillis();
	    long Loadtime=finish-start;
	    System.out.println("Load Time="+Loadtime+"milliseconds");
	    long expectedtime=30000;
	    if(Loadtime<expectedtime)
	    {
	    	System.out.println("Page loaded within the time limit");
	    	Reporter.log("Page loaded within the time limit");
	    }
	    else {
	    	System.out.println("Page load time exceeded the limit");
	    	Reporter.log("Page load time exceeded the limit");
	    }
	   
	    
	    
}}
