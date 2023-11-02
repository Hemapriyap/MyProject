package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class HomePage extends Baseclass{
	Actionclass action= new Actionclass();

	@FindBy(xpath ="//span[text()='Order history and details']")
	WebElement btnordhistory;
	
	@FindBy(xpath ="//span[text()='Add my first address']")
	WebElement btnfirstadd;
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(),this);
	}
    public boolean validatewishlist() {
    	return action.isDisplayed(getDriver(),btnfirstadd);
    }
    
    public boolean validateorderhstry() {
    	return action.isDisplayed(getDriver(),btnordhistory);
    }
    public String getcurrenturl() {
    	String homepageURL=action.getCurrentURL(getDriver());
    	return homepageURL;
    }
}
