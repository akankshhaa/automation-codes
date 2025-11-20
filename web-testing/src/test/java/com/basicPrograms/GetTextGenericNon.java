package com.basicPrograms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BaseUtility;

public class GetTextGenericNon {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();

        // STEP 1: Open website
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/");

        // STEP 2: Open login page
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // STEP 3: Enter email + password
        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("seleniumcheck@123");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("Akanksha@123");

        // STEP 4: Click Login
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // ============================================================
        //         WITHOUT GENERIC METHOD – Print All Menu Items
        // ============================================================

        List<WebElement> allVisibleTabs = driver.findElements(
                By.xpath("//ul[@class='nav navbar-nav']//li/a")
        );

        System.out.println("\n--- Menu Items WITHOUT Generic Method ---");
        for (WebElement item : allVisibleTabs) {
            System.out.println(item.getText());
        }

        // ============================================================
        //         WITH GENERIC METHOD – Store in ArrayList
        // ============================================================

        ArrayList<String> allMenuTexts = bu.getTextOfAllElementItems(allVisibleTabs);

        System.out.println("\n--- Menu Items WITH Generic Method (ArrayList) ---");
        System.out.println(allMenuTexts);

        // STEP 5: Logout
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        System.out.println("Program ends");
    }
}
