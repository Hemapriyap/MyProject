package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class OrderSummarypage extends Baseclass{
	Actionclass action= new Actionclass();
	
	
	public OrderSummarypage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	
	
	@FindBy (xpath="//Span[contains(text(),'I confirm my order')]")
	WebElement btnconfirmorder;
	
	public OrderConfirmationPage clickconfirmorder() {
		action.click(getDriver(), btnconfirmorder);
		return new OrderConfirmationPage();
	}
	
}
