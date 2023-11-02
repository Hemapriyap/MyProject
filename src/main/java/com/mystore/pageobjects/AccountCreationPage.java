package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class AccountCreationPage extends Baseclass{
	Actionclass action= new Actionclass();
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement labelcrtacct;
	
	
	public boolean validateaccountpage() {
		return action.isDisplayed(getDriver(), labelcrtacct);
		
		
	}
}
