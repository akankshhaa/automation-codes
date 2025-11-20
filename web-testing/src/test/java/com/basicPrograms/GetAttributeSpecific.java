package com.basicPrograms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

public class GetAttributeSpecific {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/");

        // LOGIN FLOW
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 🔥 REFIND ELEMENTS AFTER LOGIN TO AVOID STALE ELEMENT ERROR
        List<WebElement> allTabs = driver.findElements(
                By.xpath("//ul[@class='nav navbar-nav']/li/a")
        );

        // 🔥 Get current URL to check which tab is active
        String currentUrl = driver.getCurrentUrl();

        // LOOP THROUGH ALL MENU LINKS
        for (int i = 0; i < allTabs.size(); i++) {

            // 🔥 Getting href attribute (instead of class)
            String hrefValue = allTabs.get(i).getAttribute("href");

            // LOGIC → check if selected tab
            if (hrefValue != null && currentUrl.contains(hrefValue)) {
                System.out.println("Selected tab: " + allTabs.get(i).getText());
            } else {
                System.out.println("Not selected tab: " + allTabs.get(i).getText());
            }
        }

        System.out.println("Program ends");
    }
}
