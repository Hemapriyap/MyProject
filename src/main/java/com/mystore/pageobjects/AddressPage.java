package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class AddressPage extends Baseclass{
	Actionclass action= new Actionclass();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement butchkout;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public ShippingPage clickonchkout() {
		action.click(getDriver(), butchkout);
		return new  ShippingPage();
	}
	
	
	
}
