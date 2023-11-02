package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Actionclass;
import com.mystore.utility.ExtentManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	//Actionclass action= new Actionclass();
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare Thread Local Driver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	@BeforeSuite(groups= {"Regression","Sanity","Smoke"})
	public void loadConfig() {
		DOMConfigurator.configure("log4j.xml");
		ExtentManager.setExtent();
try {
			
			prop=new Properties();
			System.out.println("Super Constructor Invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	public static void launchAapp(String browsername){
		
		

		//String browsername=prop.getProperty("browser");
		//String browsername="Chrome";
		if (browsername.contains("Chrome")) {
			 driver.set(new ChromeDriver());
			
        } else if (browsername.contains("Edge")) {
        	 driver.set(new EdgeDriver());
       
        } 
		
        //action.implicitWait(driver,10);
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		
		
	}
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void aftersuit() {
		
		ExtentManager.endReport();
	}

}
