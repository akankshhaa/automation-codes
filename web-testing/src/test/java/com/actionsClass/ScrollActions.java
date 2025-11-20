package com.actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import com.utilities.BaseUtility;

public class ScrollActions {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/");

        Actions act = new Actions(driver);

        // ===============================================
        // 1) scrollByAmount(x, y)
        // ===============================================
        driver.get("https://demoqa.com/automation-practice-form");

        act.scrollByAmount(0, 500).perform();
        System.out.println("Scrolled down by 500 pixels");

        act.scrollByAmount(0, -300).perform();
        System.out.println("Scrolled up by 300 pixels");

        // ===============================================
        // 2) scrollToElement(element)
        // ===============================================
        WebElement submitBtn = driver.findElement(By.id("submit"));

        act.scrollToElement(submitBtn).perform();
        System.out.println("Scrolled to Submit button element");

        // ===============================================
        // 3) scrollFromOrigin(origin, x, y)
        // ===============================================
        ScrollOrigin origin = ScrollOrigin.fromViewport();

        act.scrollFromOrigin(origin, 0, 300).perform();
        System.out.println("Advanced scroll performed from viewport origin");

        // ===============================================
        System.out.println("Program ends");
        driver.quit();
    }
}
