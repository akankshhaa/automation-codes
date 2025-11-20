package com.alertHandling;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.BaseUtility;

public class GenericAlert {

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/alerts");

        // Locate timed alert button (#2)
        WebElement btn = driver.findElement(By.id("timerAlertButton"));

        // Scroll and click
        bu.scrollByJS(driver, btn);
        btn.click();

        // Using custom utility generic method → returns true/false
        bu.isAlertPresent(driver, 10);
        
        if (bu.isAlertPresent(driver, 10)) {

            // Switch to alert
            Alert alt = driver.switchTo().alert();

            // Read alert text
            String alerttext = alt.getText();
            System.out.println("alerttext = " + alerttext);

            // Accept the alert
            alt.accept();

        } else {
            // If alert not found within given time
            System.out.println("Alert not displayed");
        }

        System.out.println("program ends");
        driver.quit();
    }
}
