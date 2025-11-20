package com.actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utilities.BaseUtility;

public class MouseActions {

	public static void main(String[] args) {

		System.out.println("Program starts");

		BaseUtility bu = new BaseUtility();
		WebDriver driver = bu.startUp("ch", "https://demoqa.com/");

		Actions act = new Actions(driver);

		// ==============================================
		// 1) HOVER (moveToElement)
		// ==============================================
		driver.get("https://demoqa.com/tool-tips");
		WebElement hoverBtn = driver.findElement(By.id("toolTipButton"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "toolTipButton");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, hoverBtn);
		act.moveToElement(hoverBtn).perform();
		System.out.println("Hover action performed");

		// ==============================================
		// 2) DOUBLE CLICK
		// ==============================================
		driver.get("https://demoqa.com/buttons");
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "doubleClickBtn");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, doubleClickBtn);
		act.doubleClick(doubleClickBtn).perform();
		System.out.println("Double click action performed");

		// ==============================================
		// 3) RIGHT CLICK (contextClick)
		// ==============================================
		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "rightClickBtn");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, rightClickBtn);
		act.contextClick(rightClickBtn).perform();
		System.out.println("Right click action performed");

		// ==============================================
		// 4) NORMAL CLICK USING ACTIONS
		// ==============================================
		WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
		bu.waitForVisibilityOfElementByType(driver, 10, "xpath", "//button[text()='Click Me']");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, clickMeBtn);
		act.click(clickMeBtn).perform();
		System.out.println("Click action performed");

		// ==============================================
		// 5) DRAG AND DROP
		// ==============================================
		driver.get("https://demoqa.com/droppable");
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "draggable");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, src);
		act.dragAndDrop(src, dest).perform();
		System.out.println("Drag and drop action performed");

		// ==============================================
		// 5B) DRAG AND DROP BY (x,y) (Without destination)
		// ==============================================
		driver.get("https://demoqa.com/dragabble");
		WebElement dragItem = driver.findElement(By.id("dragBox"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "dragBox");
		bu.scrollByJS(driver, dragItem);
//        bu.scrollByUsingPageDown(driver, 1);  
		act.dragAndDropBy(dragItem, 120, 80).perform();
		System.out.println("DragAndDropBy (120,80) performed");

		// ==============================================
		// 6) CLICK AND HOLD + RELEASE
		// ==============================================
//        driver.navigate().refresh();   // is unstable on Chrome 142 with Selenium 4.29.0.
		driver.get("https://demoqa.com/droppable");
		src = driver.findElement(By.id("draggable"));
		dest = driver.findElement(By.id("droppable"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "draggable");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, src);
		act.clickAndHold(src).moveToElement(dest).release().perform();
		System.out.println("ClickHold + Release action performed");

		// ==============================================
		// 7) moveByOffset
		// ==============================================
		driver.get("https://demoqa.com/dragabble");
		WebElement dragBox = driver.findElement(By.id("dragBox"));
		bu.waitForVisibilityOfElementByType(driver, 10, "id", "dragBox");
//        bu.scrollByUsingPageDown(driver, 1);  
		bu.scrollByJS(driver, dragBox);
		act.clickAndHold(dragBox).moveByOffset(150, 80).release().perform();
		System.out.println("moveByOffset action performed");

		// ==============================================
		System.out.println("Program ends");
		bu.closeBrowser();
	}
}











