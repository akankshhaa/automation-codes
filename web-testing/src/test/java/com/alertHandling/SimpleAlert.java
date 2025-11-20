package com.alertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

public class SimpleAlert {

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/alerts");

        // Locate Prompt Alert button (#4)
        WebElement btn4 = driver.findElement(By.id("promtButton"));

        // Scroll to button to avoid element not clickable issues
        bu.scrollByJS(driver, btn4);

        // Click button → prompt alert appears
        btn4.click();

        // Switch driver focus to alert popup
        Alert alt = driver.switchTo().alert();

        // Capture the alert message
        String alerttext = alt.getText();
        System.out.println("alerttext = " + alerttext);

        // Enter text inside the prompt alert
        alt.sendKeys("Hi Akanksha!");

        // Click OK on alert (accept = OK/Yes/Submit)
        alt.accept();

        // alt.dismiss(); // use this for Cancel

        System.out.println("program ends");
//        driver.quit();
    }
}
