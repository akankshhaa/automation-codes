package com.fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

// ==================== FILE UPLOAD USING SENDKEYS ====================
// Why?
// ✔ Works only when <input type="file"> is present.
// ✔ Most stable and preferred in companies.
// ✔ No need of AutoIT, Robot, or any external tool.

public class SendKeys{

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/automation-practice-form");

        WebElement uploadBtn = driver.findElement(By.id("uploadPicture"));
        bu.scrollByJS(driver, uploadBtn);

        // Why absolute path?
        // sendKeys() requires full file path. Relative path fails.
        uploadBtn.sendKeys(System.getProperty("user.dir") + "\\FileUploads\\SampleFile.txt");

        System.out.println("program ends");
        driver.quit();
    }
}
