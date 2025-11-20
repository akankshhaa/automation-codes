package com.basicPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BaseUtility;

public class DisplayedEnabledSelected {

	public static void main(String[] args) {

		System.out.println("Program starts");

		BaseUtility bu = new BaseUtility();
		WebDriver driver = bu.startUp("ch", "https://demoqa.com/radio-button");

		// Locate label "Do you like the site?"
		WebElement label = driver.findElement(By.className("mb-3"));
		System.out.println("Label displayed: " + label.isDisplayed());

		// YES RADIO BUTTON
		WebElement yesRadioBtn = driver.findElement(By.id("yesRadio"));

		System.out.println("Yes Radio displayed: " + yesRadioBtn.isDisplayed());
		System.out.println("Yes Radio enabled: " + yesRadioBtn.isEnabled());

		// Normal click fails (input is hidden behind label)
		// yesRadioBtn.click();

		// JS Click (fallback when normal click doesn’t work)
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", yesRadioBtn);

		// OR using generic method
		bu.clickByJs(driver, yesRadioBtn);

		System.out.println("Yes Radio selected: " + yesRadioBtn.isSelected());

		// IMPRESSIVE RADIO BUTTON
		WebElement impressiveRadioBtn = driver.findElement(By.id("impressiveRadio"));
		System.out.println("Impressive displayed: " + impressiveRadioBtn.isDisplayed());
		System.out.println("Impressive enabled: " + impressiveRadioBtn.isEnabled());

		bu.clickByJs(driver, impressiveRadioBtn);
		System.out.println("Impressive selected: " + impressiveRadioBtn.isSelected());

		// NO RADIO BUTTON (Disabled)
		WebElement noRadioBtn = driver.findElement(By.id("noRadio"));
		System.out.println("No Radio displayed: " + noRadioBtn.isDisplayed());
		System.out.println("No Radio enabled: " + noRadioBtn.isEnabled());
		System.out.println("No Radio selected: " + noRadioBtn.isSelected());

		System.out.println("Program ends");
		driver.quit();
	}
}
