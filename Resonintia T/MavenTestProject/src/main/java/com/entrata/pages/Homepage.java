package com.entrata.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	@FindBy(css = "input#FirstName")
	public WebElement firstName;

	
	public void textfirstName(String Name) {
		firstName.sendKeys("Name");
	}
}
