package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Actionclass;
import com.mystore.base.Baseclass;

public class LoginPage extends Baseclass{
	Actionclass action= new Actionclass();

	@FindBy(id="SubmitLogin")
	WebElement btnlogin;
	
	@FindBy(id ="email")
	WebElement txtemail;
	
	
	@FindBy(xpath ="//input[@id='passwd']")
	WebElement txtpasswd;
	
	@FindBy(id ="email_create")
	WebElement txtcreateemail;
	
	
	@FindBy(id ="SubmitCreate")
	WebElement btncreateacct;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public HomePage login(String uname,String pwd) {
		action.type(txtemail, uname);
		action.implicitWait(getDriver(), 30);
		action.type(txtpasswd, pwd);
		action.implicitWait(getDriver(), 30);
		action.click(getDriver(), btnlogin);
		
		return new HomePage();
		
	}
	public AddressPage logintochkout(String uname,String pwd) {
		action.type(txtemail, uname);
		action.implicitWait(getDriver(), 30);
		action.type(txtpasswd, pwd);
		action.findElement(getDriver(), txtpasswd);
		action.implicitWait(getDriver(), 30);
		action.click(getDriver(), btnlogin);		
		return new AddressPage();
		
	}
	
public AccountCreationPage createnewaccount(String newemail) {
	action.type(txtcreateemail, newemail);
	action.click(getDriver(), btncreateacct);
	return new AccountCreationPage();
	}
	
}

