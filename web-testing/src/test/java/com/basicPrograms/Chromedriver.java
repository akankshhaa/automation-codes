package com.basicPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromedriver {

	public static void main(String[] args) {

		// Step 1: Set ChromeDriver full path manually

		// WAY 1 — Using Absolute Path (NOT RECOMMENDED)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91862\\Desktop\\SSquareIT\\Automation\\web-testing\\drivers\\chromedriver.exe");

		// WAY 2 — Using Relative Path (./drivers) ((NOT RECOMMENDED))
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// WAY 3 — Using System.getProperty("user.dir") (RECOMMENDED)
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		// STEP 2: Launch Chrome
		WebDriver driver = new ChromeDriver();

		// STEP 3: Maximize the browser window
		driver.manage().window().maximize();

		// STEP 4: Open Facebook URL
		driver.get("https://automationexercise.com/");

		// STEP 5: Print the page title (to verify it opened correctly)
		System.out.println("Page Title: " + driver.getTitle());

	}

}
