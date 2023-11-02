package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class OrderPage extends Baseclass{
	Actionclass action= new Actionclass();
	
	@FindBy(xpath="//td[@class='cart_unit']")
	WebElement unitprice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
     WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public double   getUnitPrice() {
		String unitprice1=unitprice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice=Double.parseDouble(unit);		
		return finalunitprice/100;
		
	}
	 
	public double   getTotalPrice() {
		String totalprice1=totalprice.getText();
		String total=totalprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finaltotalprice=Double.parseDouble(total);		
		return finaltotalprice/100;
		
	}
	
	public LoginPage clickonCheckout() {
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
	
}
