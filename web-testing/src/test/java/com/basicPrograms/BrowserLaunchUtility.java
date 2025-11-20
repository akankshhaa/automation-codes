package com.basicPrograms;

import org.openqa.selenium.WebDriver;
import com.utilities.BaseUtility;

public class BrowserLaunchUtility {

	public static void main(String[] args) {
		System.out.println("Program starts");

		// Step 1: Create object of BaseUtility
		BaseUtility bu = new BaseUtility();

		// Step 2: Open browser using reusable method
		WebDriver driver = bu.startUp("edge", "https://automationexercise.com/");

		// Step 3: Close browser
		bu.closeBrowser();

		System.out.println("Program ends");
	}
}
