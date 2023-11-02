package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class SearchResultpage extends Baseclass{

	
	public SearchResultpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
Actionclass action= new Actionclass();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCart clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCart();
	}

}
