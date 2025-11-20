package com.basicPrograms;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.BaseUtility;

public class ExplicitWait {

    public static void main(String[] args) {

        // Step 1: Create object of BaseUtility
        BaseUtility bu = new BaseUtility();

        // Step 2: Open browser using reusable method
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/login");

        // Step 3: Enter email (using id if available, otherwise XPath)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");

        // Step 4: Enter password
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");

        // Step 5: Explicit Wait — wait until login button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']")));

        // Step 6: Click on login button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Step 7: Close the browser
        bu.closeBrowser();
    }
}






