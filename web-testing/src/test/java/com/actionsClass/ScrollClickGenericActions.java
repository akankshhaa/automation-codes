package com.actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.BaseUtility;

public class ScrollClickGenericActions {

	public static void main(String[] args) {
		System.out.println("Program starts");

		// Start Chrome
		BaseUtility bu = new BaseUtility();
		WebDriver driver = bu.startUp("ch", "https://demoqa.com/webtables");

		// Locate the element
		WebElement editBtn = driver.findElement(By.xpath("//span[@id='edit-record-2']"));

		// Scroll to element using Actions
//        bu.scrollToElementByActions(driver, editBtn);   //not working
		
		bu.scrollByJS(driver, editBtn);

		// Click using Actions
		bu.clickByActions(driver, editBtn);
		System.out.println("Clicked Edit button using Actions!");

		// Locate input field
		WebElement firstNameInput = driver.findElement(By.id("firstName"));
		
		firstNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));  
        firstNameInput.sendKeys(Keys.DELETE);  
		
		// Send keys using Actions
		bu.sendKeysByActions(driver, firstNameInput, "Akanksha Vinchankar");
		System.out.println("Sent keys using Actions!");

//        driver.quit();
	}
}
