package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends Baseclass{
	private IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups="Smoke")
	  public void VerifyTitle() {
		Log.startTestCase("VerifyTitle");
		indexPage= new IndexPage();
		  String Title=indexPage.getMyStoreTitle();
				  Assert.assertEquals(Title, "My Shop");
				  Log.endTestCase("VerifyTitle");
	  }
	@Test(groups="Smoke")
public void logo() throws Throwable {
	Log.startTestCase("logo");
	boolean result= indexPage.validateLogo();
	Assert.assertFalse(result);
	Log.startTestCase("logo");
}
//	
}
