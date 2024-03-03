package com.Entrata;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.ActionHelper;
import com.entrata.base.TestBase;

public class Sample extends TestBase{
	
	    @Test
	    public void endToEndTest() throws Exception {
	    	setUp();
	    	openEntrataWebsite();
	    	clickWatchDemo();
	    	fillForm();
	    	tearDown();
	    }
	
	
	    //This test case open the Entrata Home page 
		//@Test
		public void openEntrataWebsite() {
			ActionHelper.waitForElementToBePresent(By.cssSelector("a[title='Entrata Home Page']"), 50);
			
			Assert.assertTrue(ActionHelper.driver.findElement(By.cssSelector("a[title='Entrata Home Page']")).isDisplayed());
		}
		
		//This test case Click on Watch Demo link and it open the registration form
		//@Test
		public void clickWatchDemo() {
			ActionHelper.maximaizeWindow();
			By watchDemo = By.cssSelector("a[href*='watch-demo.html']");
			ActionHelper.waitForElementToBePresent(watchDemo, 50);
			ActionHelper.clickOn("cssSelector", "a[href*='watch-demo.html']");
			ActionHelper.waitForElementToBePresent(By.xpath("//*[@id='FirstName']"), 50);
			
			Assert.assertTrue(ActionHelper.driver.findElement(By.xpath("//*[@id='FirstName']")).isDisplayed());
		}
		
		//This test case fill the Registartion form
		//@Test
		public void fillForm() {
			ActionHelper.scrollWindow(0, 150);
		
			ActionHelper.driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Mark");			
			ActionHelper.driver.findElement(By.cssSelector("#LastName")).sendKeys("Thomas");			
			ActionHelper.driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("markthomas125@gmail.com");
			ActionHelper.driver.findElement(By.cssSelector("#Company")).sendKeys("My company");			
			ActionHelper.driver.findElement(By.cssSelector("input#Phone")).sendKeys("7777777777");
			Select drop = new Select(ActionHelper.driver.findElement(By.cssSelector("select#Unit_Count__c")));
			drop.selectByValue("101 - 200");			
			ActionHelper.driver.findElement(By.cssSelector("input#Title")).sendKeys("8");			
			Select dropdown = new Select(ActionHelper.driver.findElement(By.cssSelector("#demoRequest")));
			dropdown.selectByValue("an Owner/Operator or Property Manager");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Assert.assertEquals("101 - 200", drop.getFirstSelectedOption().getText());
			Assert.assertEquals("an Owner/Operator or Property Manager", dropdown.getFirstSelectedOption().getText());
		}
}
