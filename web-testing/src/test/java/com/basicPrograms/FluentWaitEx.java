package com.basicPrograms;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.utilities.BaseUtility;

public class FluentWaitEx {

	public static void main(String[] args) {

		System.out.println("🚀 Program starts");
		
		  // Step 1: Create object of BaseUtility
        BaseUtility bu = new BaseUtility();

        // Step 2: Open browser and go to Automation Exercise login page
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/login");

        // Step 3: Create Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))       // total wait time
                .pollingEvery(Duration.ofSeconds(5))       // check every 5 seconds
                .ignoring(NoSuchElementException.class)    // ignore if element not found
                .ignoring(StaleElementReferenceException.class);

        // Step 4: Wait for Email field and enter value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-email']")));
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");

        // Step 5: Wait for Password field and enter value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-password']")));
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");

        // Step 6: Wait for Login button and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']")));
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Step 7: Close the browser
        bu.closeBrowser();

		System.out.println("🏁 Program ends");

	}

}
