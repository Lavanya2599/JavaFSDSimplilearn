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

public class RegistrationOracle {
	WebDriver driver;
  @Test
  public void Oracle() throws InterruptedException {
	 try {    
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		System.out.println("Title:"+driver.getTitle());
		System.out.println("*====================================*");
		
//		Email Address 
		
		Thread.sleep(1000);
		WebElement email=driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:email::content\"]"));
		System.out.println("Email");
		email.sendKeys("Lavanya@gmail.com");
		
//		Password
		
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:password::content\"]"));
		System.out.println("Password");
		password.sendKeys("lavPassword@123");
		
//		Retype password
		
		Thread.sleep(1000);
		WebElement retypepassword = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:retypePassword::content\"]"));
		System.out.println("Retype Password");
		retypepassword.sendKeys("lavPassword@123");
		
//		Country
		
		Thread.sleep(1000);
		WebElement country = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:country::content\"]"));
		System.out.println("Country");
		country.sendKeys("India");
		
//		Name-firstname
		
		Thread.sleep(1000);
		WebElement firstname = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:firstName::content\"]"));
		System.out.println("First Name");
		firstname.sendKeys("Lavanya");
		
//		Name-lastname
		
		Thread.sleep(1000);
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:lastName::content\"]"));
		System.out.println("Last Name");
		lastname.sendKeys("S");
		
//		Job Title
		
		Thread.sleep(1000);
		WebElement job = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:jobTitle::content\"]"));
		System.out.println("Job Title");
		job.sendKeys("Software Engineer");
		
//		Work Phone
		
		Thread.sleep(1000);
		WebElement workphone =driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:workPhone::content\"]"));
		System.out.println("Work Phone");
		workphone.sendKeys("9234567899");
		
//		Company Name
		
		Thread.sleep(1000);
		WebElement company = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:companyName::content\"]"));
		System.out.println("Company Name");
		company.sendKeys("MPH Company");
		
//		Address- line 1
		
		Thread.sleep(1000);
		WebElement Address1 = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:address1::content\"]"));
		System.out.println("Address- line1");
		Address1.sendKeys("5/5");
		
//		Address - line 2

		Thread.sleep(1000);
		WebElement Address2 = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:address2::content\"]"));
		System.out.println("Address - line 2");
		Address2.sendKeys("Kalyan Nagar");
		
//		City
		
		Thread.sleep(1000);
		WebElement city = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:city::content\"]"));
		System.out.println("City");
		city.sendKeys("Bengaluru");
		
//		State/Province
		
		Thread.sleep(1000);
		WebElement state = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:state::content\"]"));
		System.out.println("State");
		state.sendKeys("Karnataka");
		
//		ZIP/Postal Code
		
		Thread.sleep(1000);
		WebElement pincode = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:postalCode::content\"]"));
		System.out.println("ZIP/Postal Code");
		pincode.sendKeys("560010");
		
//		Create Account Button
		
		Thread.sleep(3000);
		WebElement Createaccount = driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:b1\"]/a"));
		System.out.println("Create Account Button Clicked");
		Createaccount.click();
		
//		  Screenshot
		  
		  TakesScreenshot screenshot = (TakesScreenshot) driver;
		  File src = screenshot.getScreenshotAs(OutputType.FILE);		
			try {
				FileHandler.copy(src, new File("G://LavanyaS//Screenshots//Oracle.png"));
				System.out.println("Screenshot taken successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
//		  Close Browser
		  
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
	  driver=null;
  }

}
