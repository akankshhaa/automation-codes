package com.actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.utilities.BaseUtility;

public class KeyboardActions {

    public static void main(String[] args) {

        System.out.println("Program starts");

        BaseUtility bu = new BaseUtility();
        WebDriver driver = bu.startUp("ch", "https://demoqa.com/text-box");

        Actions act = new Actions(driver);

        //==============================================
        // 1) TYPE TEXT INTO ELEMENT USING ACTIONS
        //==============================================
        WebElement input = driver.findElement(By.id("userName"));
        input.click();

        act.sendKeys(input, "Akanksha").perform();
        System.out.println("Typed name using Actions sendKeys");

        //==============================================
        // 2) PRESS ENTER KEY
        //==============================================
        act.sendKeys(Keys.ENTER).perform();
        System.out.println("ENTER key pressed");

        //==============================================
        // 3) HOLD CTRL KEY (keyDown)
        //==============================================
        act.keyDown(Keys.CONTROL).perform();
        System.out.println("CTRL key DOWN");

        //==============================================
        // 4) RELEASE CTRL KEY (keyUp)
        //==============================================
        act.keyUp(Keys.CONTROL).perform();
        System.out.println("CTRL key UP");

        //==============================================
        // 5) KEYBOARD SHORTCUT: CTRL + A
        //==============================================
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        System.out.println("CTRL + A performed (Select All)");

        //==============================================
        System.out.println("Program ends");
        driver.quit();
    }
}
