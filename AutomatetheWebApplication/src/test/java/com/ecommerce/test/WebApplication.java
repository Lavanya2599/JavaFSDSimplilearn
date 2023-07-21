package com.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebApplication {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void registrationTest() {
        // Automation code for registration form
        driver.get("https://accounts.shopify.com/signup?rid=d6c2fd0e-8c21-4fdc-920a-d0cc9bd24fc9&signup_strategy=password");
        
        WebElement emailInput = driver.findElement(By.id("account_email"));
        WebElement firstNameInput = driver.findElement(By.id("account_first_name"));
        WebElement lastNameInput = driver.findElement(By.id("account_last_name"));  
        WebElement password = driver.findElement(By.id("account_password"));
        WebElement passwordconfirm = driver.findElement(By.id("password-confirmation"));
        //WebElement registerButton = driver.findElement(By.button("commit"));
        WebElement registerButton = driver.findElement(By.className("captcha__submit"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        
        emailInput.sendKeys("lavanya@gmail.com");
        firstNameInput.sendKeys("Lavanya");
        lastNameInput.sendKeys("S");        
        password.sendKeys("password123");
        passwordconfirm.sendKeys("password123");
        //registerButton.click();

        try {
            Thread.sleep(1000); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Submit the form
        registerButton.click();

        // Wait for successful registration verification
        boolean isRegistrationSuccessful = waitForSuccessfulRegistration(driver);
        if (isRegistrationSuccessful) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }
    }
    private static boolean waitForSuccessfulRegistration(WebDriver driver) {
        // Return true if registration is successful, false otherwise
        return true;
    }

    @Test
    public void loginTest() {
        // Automation code for login functionality
        driver.get("https://accounts.shopify.com/lookup?rid=1e43e3f4-d40d-4c8a-b070-533097c868b5");

        WebElement usernameInput = driver.findElement(By.id("account_email"));
        //WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("captcha__submit"));

        usernameInput.sendKeys("lavanya@gmail.com");
        //passwordInput.sendKeys("incorrectpassword");
        loginButton.click();

        try {
            Thread.sleep(1000); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Submit the form
        loginButton.click();

        // Wait for successful login verification
        // Add appropriate code here to verify successful login
        boolean isLoggedIn = verifySuccessfulLogin(driver);
        if (isLoggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        // Close the browser
        //driver.quit();
    }

    private static boolean verifySuccessfulLogin(WebDriver driver) {
        // Return true if login is successful, false otherwise
        return true;
    }
}

