package com.basicPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BaseUtility;

public class GetAttribute {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/");

        // LOGIN FLOW
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


        // ============================================
        // FIND ALL MENU <a> TAGS USING XPath
        // ============================================
        List<WebElement> allTabs = driver.findElements(
        	    By.xpath("//ul[@class='nav navbar-nav']//li/a")
        );

        // PRINT class attribute for each item
        for (int i = 0; i < allTabs.size(); i++) {
            System.out.println(allTabs.get(i).getAttribute("href"));
        }

        System.out.println("Program ends");
    }
}
