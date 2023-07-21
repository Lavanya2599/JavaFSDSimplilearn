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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class AddCartAmazon {
	WebDriver driver;
  @Test
  public void AddCart() {
	
	  try {
	  driver.get("https://www.amazon.com/");
	  driver.manage().window().maximize();
	  
	  System.out.println("Title : "+driver.getTitle());
	  System.out.println("*=================================*");
	  
//	  Search Bar
	  
	  driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("samsung");
	  System.out.println("Search bar");
	  
//	  Search Button
	  
	  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  System.out.println("searching...");
	  
//	  open 
	  
	  driver.findElement(By.linkText("SAMSUNG Galaxy A54 5G A Series Cell Phone, Factory Unlocked Android Smartphone, 128GB w/ 6.4” Fluid Display Screen, Hi Res Camera, Long Battery Life, Refined Design, US Version, 2023, Awesome Black")).click();
	  System.out.println("view the mobile details");
	  
//	  Add to Cart
	  
//	  driver.findElement(By.id("add-to-cart-button")).click();
	  driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	  System.out.println("add to cart successfully");
	  
//	  Screenshot
	  
	  TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("G://LavanyaS//Screenshots//Amazon.png"));
			System.out.println("Screenshot taken successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
//	 close browser
	  
	  driver.close();
	  System.out.println("browser closed successfully");
	  
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
