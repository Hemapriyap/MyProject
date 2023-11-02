package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class OrderConfirmationPage extends Baseclass{
	Actionclass action= new Actionclass();
	
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	
	
	@FindBy (xpath="//p[contains(text(),'Your order on My Shop is complete.')]")
	WebElement btnconfirmorder;
	
	public  String confirmorder() {
		String confmsg=btnconfirmorder.getText();
		return confmsg;
		
	}
}
