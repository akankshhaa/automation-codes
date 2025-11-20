package com.alertHandling;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.BaseUtility;

public class WaitAlert {

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility obj = new BaseUtility();
        WebDriver driver = obj.startUp("ch", "https://demoqa.com/alerts");

        // Locate the second button → shows alert after 5 seconds
        WebElement btn = driver.findElement(By.id("timerAlertButton"));

        // Scroll to button
        obj.scrollByJS(driver, btn);

        // Click button → alert will appear after some delay
        btn.click();

        // Explicit wait until alert becomes present
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(20));
        wt.until(ExpectedConditions.alertIsPresent());

        // Switch to alert
        Alert alt = driver.switchTo().alert();

        // Read alert text
        String alerttext = alt.getText();
        System.out.println("alerttext = " + alerttext);

        // Click OK on alert
        alt.accept();  
        // alt.dismiss(); // for Cancel

        System.out.println("program ends");
//        driver.quit();
    }
}
