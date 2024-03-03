package com.entrata;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ActionHelper {
	
	public static RemoteWebDriver driver;
	/**
	 * This Method will launch specified browser. if no browser name is specified then it will launch Chrome browser by default
	 * 
	 * @param browserName to launch
	 */
	
	public static void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.setCapability(browserName, browserName);
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);	
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}else if(browserName.isEmpty()) {
			driver = new ChromeDriver();
		}
		
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
		
	}
	public static void scrollWindow(int x, int y) {
		driver.executeScript("window.scrollBy(arguments[0],arguments[1])", x,y);
	}

	public static void waitForElementToBePresent(By element, Integer time) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		
	}
	
	public static void clickOn(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("CssSelector")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
	}
	public static void maximaizeWindow() {
		driver.manage().window().maximize();
	}
	public static void closeBrowser() {
		driver.close();
		
	}
}