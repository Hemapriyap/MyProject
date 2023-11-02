package com.mystore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class IndexPage extends Baseclass{
	Actionclass action= new Actionclass();
	
	@FindBy(xpath ="//a[@class='login']")
	WebElement btnsignIn;
	
	
			//img[@alt='My Shop']
	@FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement myStoreLogo;
	
	@FindBy(id ="search_query_top")
	WebElement txtsearch;
	
	
	@FindBy(name ="submit_search")
	WebElement btnsearch;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), btnsignIn, 10);
		action.click(getDriver(), btnsignIn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
//	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultpage searchProduct(String productName) throws Throwable {
		action.type(txtsearch, productName);
		action.scrollByVisibilityOfElement(getDriver(), btnsearch);
		action.click(getDriver(), btnsearch);
		Thread.sleep(3000);
		return new SearchResultpage();
	}
	
	
}
