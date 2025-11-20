package com.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {

	WebDriver driver;

	// ==================== BROWSER SETUP METHOD ====================

	public WebDriver startUp(String bName, String url) {
		if (bName.equalsIgnoreCase("chrome") || bName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser opened successfully!");
		} else if (bName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("Edge browser opened successfully!");
		} else {
			System.out.println("Invalid browser name!");
			return null;
		}
//	        driver.manage().window().maximize();
//	        driver.manage().window().minimize();
		Dimension d = new Dimension(80, 600); // width=800px, height=600px
		driver.manage().window().setSize(d);
		driver.get(url);
		return driver;
	}

	
	// ==================== GENERIC WAIT METHODS (Use OOPS concept here) ====================

	// 1️ Simple Wait Method (By locator)
	public void waitForVisibilityOfElementByType(WebDriver driver, long time, By obj) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}

	// 2️ Wait and Return Element (Useful for tooltips)
	public WebElement waitForVisibilityOfToolTip(WebDriver driver, long time, By obj) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wt.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}

	// 3️ Dynamic Wait Based on Locator Type
	public void waitForVisibilityOfElementByType(WebDriver driver, long time, String type, String expression) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));

		if (type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
		} else if (type.equalsIgnoreCase("className")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(expression)));
		} else if (type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
		} else if (type.equalsIgnoreCase("css")) {
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(expression)));
		} else {
			System.out.println("❌ Invalid locator type provided!");
		}
	}

	
	// ==================== GENERIC GET-TEXT METHOD ====================

	public ArrayList<String> getTextOfAllElementItems(List<WebElement> allTabs) {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement tab : allTabs) {
			list.add(tab.getText());
		}
		return list;
	}

	
	// ==================== CLICK USING JAVASCRIPT ====================

	public void clickByJs(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
	

	// ==================== SCROLLING METHODS ====================

	// Scroll to an element using JavaScript
	public void scrollByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele); // Scrolls to element
	}

	// Scroll using Keys.PAGE_DOWN
	public void scrollByUsingPageDown(WebDriver driver, int numOfScrolls) {
		WebElement ele = driver.findElement(By.tagName("body"));
		for (int i = 0; i < numOfScrolls; i++) {
			ele.sendKeys(Keys.PAGE_DOWN); // Simulate pressing the "Page Down" key
		}
	}

	
    // ==================== ACTIONS CLASS METHODS ====================
	
	// Scroll using Actions
    public void scrollToElementByActions(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
    }

    // Click using Actions
    public void clickByActions(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().perform();
    }

    // Scroll + Click using Actions
    public void scrollAndClickByActions(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().perform();
    }
    
    // Send keys using Actions
    public void sendKeysByActions(WebDriver driver, WebElement element, String text) {
        Actions act = new Actions(driver);
        act.click(element)   
               .sendKeys(text)  
               .perform();      
    }
	
    
    // ==================== ALERT HANDLING METHODS ====================
    
    // This method checks whether an alert is present within the given time.
    public boolean isAlertPresent(WebDriver driver, long time) {

        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));

        try {
            wt.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

	
	// ==================== CLOSE BROWSER ====================

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("🔒 Browser closed successfully!");
		}
	}

}
