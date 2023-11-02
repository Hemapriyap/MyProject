package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends Baseclass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launchAapp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider="credentials",dataProviderClass=Dataproviders.class,groups= {"Sanity","Smoke"})
	public void loginTest(String uname,String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage=new IndexPage();
		Log.info("User is in SignIn page");
		loginpage=indexPage.clickOnSignIn();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(uname, pswd);
		Log.info("User has entered username and password");
		String actualURL =homepage.getcurrenturl();
		String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
		Log.endTestCase("loginTest");
		
		
	}
}
