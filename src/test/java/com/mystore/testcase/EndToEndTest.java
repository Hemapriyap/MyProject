package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummarypage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultpage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends Baseclass{
	private IndexPage index;
	private SearchResultpage searchResultPage;
	private AddToCart addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummarypage orderSummary;
	private OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider="getProduct",dataProviderClass=Dataproviders.class,groups="Regression")
	
	public void endToEndTest(String productname,String qty,String size) throws Throwable {
		Log.startTestCase("endToEndTest");
	index= new IndexPage();
	searchResultPage=index.searchProduct(productname);
	addToCartPage=searchResultPage.clickOnProduct();
	addToCartPage.enterQuantity(qty);
	addToCartPage.selectSize(size);
	addToCartPage.clickOnAddToCart();
	orderPage=addToCartPage.clickOnCheckOut();
	loginPage=orderPage.clickonCheckout();
	addressPage=loginPage.logintochkout(prop.getProperty("username"), prop.getProperty("password"));
	shippingPage=addressPage.clickonchkout();
	shippingPage.chktheterms();
	paymentPage=shippingPage.clickonproceedtochkout();
	orderSummary=paymentPage.clickproceedchkout();
	orderConfirmationPage=orderSummary.clickconfirmorder();
	String actualMessage=orderConfirmationPage.confirmorder();
	String expectedMsg="Your order on My Shop is complete.";
	Assert.assertEquals(actualMessage, expectedMsg);
	Log.endTestCase("endToEndTest");
	}
}
	
