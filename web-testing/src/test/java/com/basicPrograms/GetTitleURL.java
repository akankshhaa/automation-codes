package com.basicPrograms;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetTitleURL {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("🚀 Program starts");

		// Step 1: Launch Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step 2: Open the main Automation Exercise website
		driver.get("https://automationexercise.com/");

		// Step 3: Verify Title and URL of Home Page
		String actualTitle = driver.getTitle();
		String actualURL = driver.getCurrentUrl();

		String expectedTitle = "Automation Exercise";
		String expectedURL = "https://automationexercise.com/";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("✅ Home Page Title matched!");
		} else {
			System.out.println("❌ Home Page Title mismatch!");
			System.out.println("Expected: " + expectedTitle);
		}

		if (actualURL.equals(expectedURL)) {
			System.out.println("✅ Home Page URL matched!");
		} else {
			System.out.println("❌ Home Page URL mismatch!");
			System.out.println("Expected: " + expectedURL);
		}

		// Step 4: Click on Signup/Login link
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		// ✅ Step 5: Wait explicitly for URL to contain "/login"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("/login"));

		// Step 6: Verify Title and URL on Login Page
		String loginTitle = driver.getTitle();
		String loginURL = driver.getCurrentUrl();

		String expectedLoginURL = "https://automationexercise.com/login";

		if (loginURL.contains(expectedLoginURL)) {
			System.out.println("✅ Login Page URL matched!");
		} else {
			System.out.println("❌ Login Page URL mismatch!");
			System.out.println("Expected: " + expectedLoginURL);
			System.out.println("Found: " + loginURL);
		}

		// Step 7: Enter login credentials
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("seleniumcheck@123");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Akanksha@123");

		Thread.sleep(2000);

		// Step 8: Click Login button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

		System.out.println("✅ Login button clicked successfully!");

		// Step 9: Close browser
		driver.quit();
		System.out.println("🔒 Browser closed successfully!");
		System.out.println("🏁 Program ends");
	}
}
