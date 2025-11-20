package com.basicPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edgedriver {

	public static void main(String[] args) {

		// STEP 1: Set the path of the EdgeDriver executable
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");

		// STEP 2: Launch Microsoft Edge browser
		WebDriver driver = new EdgeDriver();

		// STEP 3: Maximize the browser window
		driver.manage().window().maximize();

		// STEP 4: Open Facebook website
		driver.get("https://automationexercise.com/");

		// STEP 5: Print the page title (to verify successful navigation)
		System.out.println("Page Title: " + driver.getTitle());

	}

}
