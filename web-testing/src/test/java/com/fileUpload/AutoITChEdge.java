package com.fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

// ==================== AUTOIT FILE UPLOAD (CHROME/EDGE SPECIFIC) ====================
// Why?
// ✔ Use only when <input type="file"> is NOT available.
// ✔ Selenium CANNOT handle Windows OS popups.
// ✔ AutoIT handles the file-picker popup.

public class AutoITChEdge {

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/automation-practice-form");

        WebElement uploadBtn = driver.findElement(By.id("uploadPicture"));
        bu.scrollByJS(driver, uploadBtn);

        // Why use Actions?
        // Normal click fails on hidden upload controls.
        bu.clickByActions(driver, uploadBtn);

        try {
            Thread.sleep(2000); // Wait for OS file dialog

            // Why Runtime.getRuntime().exec()?
            // ✔ It executes external programs (AutoIT EXE files).
            // ✔ Used to run AutoIT script that handles Windows popup.
            Runtime.getRuntime().exec(
                    System.getProperty("user.dir") + "\\FileUploads\\ChromeUpload.exe"
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to upload file");
        }

        System.out.println("program ends");
        driver.quit();
    }
}
