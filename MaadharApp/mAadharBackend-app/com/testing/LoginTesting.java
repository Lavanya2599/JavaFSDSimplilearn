package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTesting {
  WebDriver driver;
  @BeforeTest
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  	driver=new ChromeDriver();
	  	driver.manage().window().maximize();
	  	
  }

  @AfterTest
  public void afterClass() {
  }


  @Test
  public void signInTest() {
	  driver.get("http://localhost:4200/login");
	  driver.close();
  }

  @Test
  public void signUpTest() {
	  driver.get("http://localhost:4200/signup");
	  driver.close();
  }
}

