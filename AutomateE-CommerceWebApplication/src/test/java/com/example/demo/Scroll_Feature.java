package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_Feature {
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
	    Thread.sleep(2000);
	    wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	    
	    String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) wd;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			System.out.print("Scrollbar is present.");
			Reporter.log("Scrollbar is present.");
		} else if (test == false){
			System.out.print("Scrollbar is not present.");
			Reporter.log("Scrollbar is not present.");
		}
	    
}
}