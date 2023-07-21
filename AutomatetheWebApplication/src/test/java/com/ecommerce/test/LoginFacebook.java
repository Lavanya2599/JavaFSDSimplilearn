package com.ecommerce.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class LoginFacebook {
	WebDriver driver;
  @Test
  public void Login() throws InterruptedException{
	  
	  driver.get("https://www.facebook.com/login/");
	  driver.manage().window().maximize();
	  
	  System.out.println("Title : "+driver.getTitle());
	  System.out.println("*==============================*");
	  
//	  Email address or Phone Number
	  try {
	  Thread.sleep(2000);
	  WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	  email.sendKeys("Lavanya@gmail.com");
	  System.out.println("Email");
	
//	  Password
	  
	  Thread.sleep(2000);
	  WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
	  password.sendKeys("Lavanya@123");
	  System.out.println("password");
	  
//	  Login button
	  
	  Thread.sleep(2000);
	  WebElement login = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
	  login.click();
	  System.out.println("Login button Clicked");
	  
//	  Screenshot
	  
	  TakesScreenshot screenshot = (TakesScreenshot) driver;
	  File src = screenshot.getScreenshotAs(OutputType.FILE);		
		try {
			FileHandler.copy(src, new File("G://LavanyaS//Screenshots//facebook.png"));
			System.out.println("Screenshot taken successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
//	  Close Browser
	  
	  driver.close();
	  System.out.println("Browser Closed Successfully");
	  }
	  catch(NoSuchElementException e) {
		  e.printStackTrace();
	  }
  }
  
 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Downloads\\chromedriver.exe");
	  driver =new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver = null;
  }

}
