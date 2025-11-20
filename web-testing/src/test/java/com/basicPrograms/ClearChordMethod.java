package com.basicPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BaseUtility;

public class ClearChordMethod {

    public static void main(String[] args) {

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/webtables");
        
        
        // 1) Click Edit button of the FIRST row using XPath
        WebElement editBtn = driver.findElement(By.xpath("//span[@id='edit-record-2']"));
        bu.scrollByJS(driver,editBtn);
        editBtn.click();

        // 2) Locate First Name input using XPath
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));

        // 3) Clear First Name using CHORD (CTRL + A + DELETE)
        firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"));  
        firstName.sendKeys(Keys.DELETE);  
//        firstName.sendKeys(Keys.BACK_SPACE); // Alternative for DELETE (Not Recommended)
        
//        firstName.clear(); //Alternative for clear rather than chord (Not Recommended)

        // 4) Type new value
        firstName.sendKeys("Akanksha");

        // 5) Submit using XPath
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
//        submitBtn.click();
        bu.clickByJs(driver, submitBtn);
        
        System.out.println("First name updated successfully!");

//        driver.quit();
    }
}
