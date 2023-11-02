package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultpage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends Baseclass{
	private IndexPage indexPage;
	private SearchResultpage searchresultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "searchProduct", dataProviderClass = Dataproviders.class,groups="Smoke")
	public void verifyeaccountpagetest(String ProdcutName) throws Throwable {
		Log.startTestCase("verifyeaccountpagetest");
		indexPage= new IndexPage();
		searchresultPage=indexPage.searchProduct(ProdcutName);
		boolean result=searchresultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("verifyeaccountpagetest");
		
	}
}
