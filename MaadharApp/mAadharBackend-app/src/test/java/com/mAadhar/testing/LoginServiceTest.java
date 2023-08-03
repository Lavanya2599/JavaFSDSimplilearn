package com.mAadhar.testing;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class LoginServiceTest {
	WebDriver driver;
  @BeforeTest
  public void config() {
	  WebDriverManager.chromedriver().setup();
	  	driver=new ChromeDriver();
	  	driver.manage().window().maximize();
	  	
  }

  @AfterTest
  public void afterClass() {
	  driver.close();
  }


  @Test
  public void signInTest() {
	  driver.get("http://localhost:4200/login");
	 
  }

  @Test
  public void signUpTest() {
	  driver.get("http://localhost:4200/signup");
	  
  }
}
