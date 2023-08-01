package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.Toolkit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imageload_Screenheight {
	WebDriver wd;
	 @BeforeTest
	  public void config() {
	  	WebDriverManager.chromedriver().setup();
	  	wd=new ChromeDriver();
	  	wd.manage().window().maximize();
	  	
	  }

		
		 @AfterTest public void quitbrowser() throws InterruptedException {
		 Thread.sleep(2000); wd.quit(); }
		 
	  	
	  	
	    @Test
	    public void test1() throws InterruptedException {
	   wd.get("https://www.flipkart.com/");
	   Thread.sleep(2000);
	   wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	   java.awt.Dimension screen_size =Toolkit.getDefaultToolkit().getScreenSize();
	   int height = (int) screen_size.getHeight();
	   int width = (int) screen_size.getWidth();
	   System.out.println("Resolution of the Screen:\n");
	   System.out.println("Screen Height "+height +" Screen width "+ width);
	   int img_height=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img")).getSize().getHeight();
	   int img_width=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img")).getSize().getWidth();
	   System.out.println("Resolution of the Image:\n");
	   System.out.println("Image Height "+img_height +" Image width "+img_width);
	   WebElement img=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img"));
	   if(img.isDisplayed())
	   {
		   if(img_height<height && img_width<width)
		   {
			   System.out.println("The images are loaded and visible till the screen height only");
			   Reporter.log("Images are loaded and visible till the screen height only");
		   }
		   else
		   {
			   System.out.println("The images are not loaded and visible till the screen height");
			   Reporter.log("Images are not loaded and visible till the screen height");
		   }
	   }
	    
	}
}


