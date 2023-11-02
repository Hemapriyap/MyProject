package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class ShippingPage extends Baseclass{
	Actionclass action= new Actionclass();
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy (id="cgv")
	WebElement terms;
	
	@FindBy (xpath="//button/span[contains(text(), 'Proceed to checkout')]")
	WebElement btnproccedchkout;
	
	public void chktheterms() {
		action.click(getDriver(), terms);
		
	}
	
	public PaymentPage clickonproceedtochkout() {
		action.click(getDriver(), btnproccedchkout);
		return  new PaymentPage();
	}
	
	
	
}
