package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultpage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends Baseclass {
	private IndexPage indexPage;
	private SearchResultpage searchresultPage;
	private AddToCart addtocartPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider="getProduct",dataProviderClass=Dataproviders.class,groups= {"Regression","Sanity"})
	public void verifyeaccountpagetest(String productname,String qty,String size) throws Throwable {
		Log.startTestCase("verifyeaccountpagetest");
		indexPage= new IndexPage();
		searchresultPage=indexPage.searchProduct(productname);
		addtocartPage=searchresultPage.clickOnProduct();
		addtocartPage.enterQuantity(qty);
		addtocartPage.selectSize(size);
		addtocartPage.clickOnAddToCart();
		boolean result=addtocartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("verifyeaccountpagetest");
		
		
	}
}
