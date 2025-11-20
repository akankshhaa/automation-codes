package com.basicPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BaseUtility;

public class ImplicitWait {

    public static void main(String[] args) {
        System.out.println("🚀 Program starts");

        // Step 1: Create object of BaseUtility
        BaseUtility bu = new BaseUtility();

        // Step 2: Open browser using reusable method
        WebDriver driver = bu.startUp("edge", "https://automationexercise.com/login");

        // Step 3: Apply Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Step 4: Perform actions using XPath

        // Email field
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");

        // Password field
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");

        // Login button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Step 5: Close the browser
        bu.closeBrowser();

        System.out.println("🏁 Program ends");
    }
}
