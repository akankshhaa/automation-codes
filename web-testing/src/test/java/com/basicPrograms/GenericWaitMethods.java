package com.basicPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.BaseUtility;

public class GenericWaitMethods {

    public static void main(String[] args) {
        
        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://www.ajio.com/");

        // Example simple wait method - Wait for and click on the "Sign In / Join Ajio" button
        bu.waitForVisibilityOfElementByType(driver, 10, By.xpath("//span[@id='loginAjio']"));

        // Clicking on the 'Sign In / Join Ajio' button...
        WebElement signInButton = driver.findElement(By.xpath("//span[@id='loginAjio']"));
        signInButton.click();

        // Example Dynamic Wait Based on Locator Type -  Wait for the mobile number input field to be visible
        bu.waitForVisibilityOfElementByType(driver, 10, "xpath", "//input[@id='mobileNumber']");

        // Enter the mobile number into the input field
        WebElement phoneNum = driver.findElement(By.xpath("//input[@id='mobileNumber']"));
        phoneNum.sendKeys("9876543210");
        // Example Wait and Return Element -  Wait for the 'Continue' button to become clickable and click it
        WebElement continueButton = bu.waitForVisibilityOfToolTip(driver, 10, By.xpath("//input[@class='login-btn' and @value='Continue']"));
        continueButton.click();

        System.out.println("Test completed.");
    }
}
