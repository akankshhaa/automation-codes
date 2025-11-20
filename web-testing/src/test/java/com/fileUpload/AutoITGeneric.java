package com.fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

// ==================== AUTOIT GENERIC FILE UPLOAD ====================
// Why?
// ✔ Works for ALL browsers.
// ✔ File path is sent dynamically (best practice).
// ✔ Avoids creating multiple AutoIT EXEs for each file.
// ✔ Useful when upload popup must be handled by OS-level automation.

public class AutoITGeneric {

    public static void main(String[] args) {

        System.out.println("program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/automation-practice-form");

        WebElement uploadBtn = driver.findElement(By.id("uploadPicture"));
        bu.scrollByJS(driver, uploadBtn);

        // Why Actions?
        // Required to open OS upload popup reliably.
        bu.clickByActions(driver, uploadBtn);

        try {
            Thread.sleep(2000); // Wait for popup

            String filePath = System.getProperty("user.dir") + "\\FileUploads\\SampleFile.txt";

            // Why Runtime.getRuntime().exec() ?
            // ✔ Executes AutoIT EXE file.
            // ✔ We pass file path as argument → makes AutoIT generic.
            Runtime.getRuntime().exec(
                    System.getProperty("user.dir") + "\\FileUploads\\GenericUpload.exe" + " " + filePath
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to upload file");
        }

        System.out.println("program ends");
        driver.quit();
    }
}
