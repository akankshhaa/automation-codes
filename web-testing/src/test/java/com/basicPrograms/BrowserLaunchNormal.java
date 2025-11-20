package com.basicPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserLaunchNormal {

	public static void main(String[] args) {
		System.out.println("Program starts");

		// Create object of current class
		BrowserLaunchNormal launcher = new BrowserLaunchNormal();

		// Call the method and pass browser name
		launcher.startup("ch"); // Opens Chrome

		System.out.println("Program ends");
	}

	// Method to open browser based on name
	public void startup(String bName) {
		WebDriver driver;

		if (bName.equalsIgnoreCase("chrome") || bName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("✅ Chrome browser opened successfully!");
		} else if (bName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("✅ Edge browser opened successfully!");
		} else {
			System.out.println("❌ Invalid browser name!");
			return;
		}

		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		System.out.println("Current Title: " + driver.getTitle());
		driver.quit();
	}
}
