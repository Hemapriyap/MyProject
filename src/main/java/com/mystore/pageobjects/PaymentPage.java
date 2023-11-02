package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class PaymentPage extends Baseclass {
	Actionclass action= new Actionclass();
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	
	
	@FindBy (xpath="//a[contains(text(),'Pay by bank wire ')]")
	WebElement btnproccedchkout;
	
	public OrderSummarypage clickproceedchkout() {
		action.click(getDriver(), btnproccedchkout);
		return new OrderSummarypage();
	}
}
