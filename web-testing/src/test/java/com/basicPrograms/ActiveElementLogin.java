package com.basicPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;


public class ActiveElementLogin {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/login");
        
//        // =====================================================
//        // WAY 1 – Using variable + switchTo().activeElement()
//        // ===================================================== 
//
//
//        // Click to set focus manually (required!)
//        driver.findElement(By.xpath("//input[@data-qa='login-email']")).click();
//
//        // Email field is now active
//        WebElement ele = driver.switchTo().activeElement();
//        ele.sendKeys("seleniumcheck@123");
//
//        // TAB → move to password
//        ele.sendKeys(Keys.TAB);
//
//        // Password field becomes active
//        ele = driver.switchTo().activeElement();
//        ele.sendKeys("Akanksha@123");
//
//        // TAB → move to login button
//        ele.sendKeys(Keys.TAB);
//
//        // Login button is active → press ENTER
//        ele = driver.switchTo().activeElement();
//        ele.sendKeys(Keys.ENTER);

        
        // ================================
        // WAY 2 – Optimized Version
        // ================================

        // STEP 1: Click email to set active element
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).click();

        // STEP 2: Type email
        driver.switchTo().activeElement().sendKeys("seleniumcheck@123");

        // STEP 3: TAB → move to password
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        // STEP 4: Enter password
        driver.switchTo().activeElement().sendKeys("Akanksha@123");

        // STEP 5: TAB → move to login button
        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        // STEP 6: ENTER → login
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        
        System.out.println("Program ends");
        
        driver.quit();
    }
}
