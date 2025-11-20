package com.actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.BaseUtility;

public class ToolTip {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();


        /* =============================================
         *  WAY 1: Simple Approach (Actions + getText())
         * ============================================= */

        WebDriver driver = bu.startUp("ch", "https://demoqa.com/tool-tips");

        WebElement btn = driver.findElement(By.id("toolTipButton"));
//        WebElement btn = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        bu.scrollByJS(driver, btn);   // scroll to button

        Actions act = new Actions(driver);
        act.moveToElement(btn).perform();   // hover to show tooltip

        Thread.sleep(500);  // small wait for tooltip to appear

        String toolTip1 = driver.findElement(By.cssSelector(".tooltip-inner")).getText();
        System.out.println("WAY 1 Tooltip: " + toolTip1);

        driver.quit();  // end browser of WAY 1


        /* =============================================
         *  WAY 2: Using Explicit Wait (WebDriverWait)
         * ============================================= */

        driver = bu.startUp("ch", "https://demoqa.com/tool-tips");

        WebElement btn2 = driver.findElement(By.id("toolTipButton"));
        bu.scrollByJS(driver, btn2);

        Actions act2 = new Actions(driver);
        act2.moveToElement(btn2).perform();

        // Wait for tooltip to become visible
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner")));

        String toolTip2 = driver.findElement(By.cssSelector(".tooltip-inner")).getText();
        System.out.println("WAY 2 Tooltip: " + toolTip2);

        driver.quit();  // end browser of WAY 2


        /* =============================================
         *  WAY 3: Using Generic Method (From BaseUtility)
         * ============================================= */

        driver = bu.startUp("ch", "https://demoqa.com/tool-tips");

        WebElement btn3 = driver.findElement(By.id("toolTipButton"));
        bu.scrollByJS(driver, btn3);

        Actions act3 = new Actions(driver);
        act3.moveToElement(btn3).perform();

        Thread.sleep(500);

        // Using BaseUtility generic tooltip wait method
        WebElement toolTipElement =
                bu.waitForVisibilityOfToolTip(driver, 10, By.cssSelector(".tooltip-inner"));

        System.out.println("WAY 3 Tooltip Text: " + toolTipElement.getText());

        System.out.println("Program ends");
        driver.quit();
    }
}







