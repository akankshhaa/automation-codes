package com.basicPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

public class GetTextList {

    public static void main(String[] args) {

        // STEP 1: Launch browser using BaseUtility
        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/");

        // STEP 2: Navigate to Login page
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // STEP 3: Enter login credentials
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");

        // STEP 4: Click Login button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


        // ===================== GET NAVIGATION MENU TEXT =====================

        // A) Locate the entire <ul> menu list (Main method)
        WebElement navList = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']"));

        /* ------------ OPTIONAL EXAMPLES (REFERENCE ONLY) ------------
         
           // B) Locate FIRST item in the list:
           // WebElement firstItem = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));

           // C) Locate element containing 'Cart':
           // WebElement cartLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Cart')]"));

           // D) CSS Selector for entire list:
           // WebElement navListCss = driver.findElement(By.cssSelector("ul.nav.navbar-nav"));

           // E) CSS Selector for FIRST list item:
           // WebElement firstItemCss = driver.findElement(By.cssSelector("ul.nav.navbar-nav li:nth-child(1) a"));

        ---------------------------------------------------------------- */

        // STEP 5: Extract visible text of full menu list
        String menuText = navList.getText();

        // STEP 6: Print the menu items
        System.out.println("Navigation Menu:");
        System.out.println(menuText);


        // ========================= LOGOUT =========================

        // Using exact attribute match
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        // Alternative flexible option (text contains 'Logout')
        // driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Logout')]")).click();
    }
}
