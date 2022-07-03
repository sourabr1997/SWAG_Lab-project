package com.MySeleniumProject_2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.MySeleniumProject_2.base.BaseClass_2;
import com.MySeleniumProject_2.dataProvider.DataProviders_2;
import com.MySeleniumProject_2.pageObject.LoginPage;
import com.MySeleniumProject_2.pageObject.ProductPage;

public class UserLoginScenario extends BaseClass_2 {
	ProductPage productPage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod 
	public void setup(String browserName) {
		launchApp(browserName);
	}
	
	@Test (dataProvider ="Login", dataProviderClass = DataProviders_2.class)
	public void userLogin(String uname, String pass) throws Throwable {
		loginPage = new LoginPage();
		//loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
		loginPage.login(uname,pass);
		System.out.println("Username is: "+uname +"Password is:"+pass);
		String actualURL=loginPage.verifyLogin();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}

}
