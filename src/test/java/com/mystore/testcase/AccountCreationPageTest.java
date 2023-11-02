package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends Baseclass{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage accountcreationPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider="email",dataProviderClass=Dataproviders.class,groups="Sanity")
	public void verifyeaccountpagetest(String email) throws Throwable {
		Log.startTestCase("verifyeaccountpagetest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountcreationPage=loginPage.createnewaccount(email);
		boolean result=accountcreationPage.validateaccountpage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyeaccountpagetest");
		
	}
}
