package com.basicPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utilities.BaseUtility;

public class ThreadSleep {
    
    // We must use "throws InterruptedException" because Thread.sleep can cause an interruption error.
    public static void main(String[] args) throws InterruptedException { 
        System.out.println("🚀 Program starts");

        // Step 1: Create BaseUtility object
        BaseUtility bu = new BaseUtility();

        // Step 2: Launch browser and open website
        WebDriver driver = bu.startUp("ch", "https://automationexercise.com/login");

        // Step 3: Perform actions using Thread.sleep()
        // Wait 3 seconds before typing email
        Thread.sleep(3000);  // 3 seconds pause
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");
        System.out.println("📧 Email entered");

        // Wait 2 seconds before typing password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Akanksha@123");
        System.out.println("🔐 Password entered");

        // Wait 3 seconds before clicking login button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        System.out.println("🖱️ Login button clicked");

        // Step 4: Close the browser
//        bu.closeBrowser();
        System.out.println("🏁 Program ends");
    }
}
