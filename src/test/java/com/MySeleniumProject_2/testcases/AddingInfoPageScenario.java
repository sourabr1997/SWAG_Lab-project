package com.MySeleniumProject_2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MySeleniumProject_2.base.BaseClass_2;
import com.MySeleniumProject_2.dataProvider.DataProviders_2;
import com.MySeleniumProject_2.pageObject.CheckOutInfoPage;
import com.MySeleniumProject_2.pageObject.LoginPage;
import com.MySeleniumProject_2.pageObject.ProductPage;
import com.MySeleniumProject_2.pageObject.YourCart;

public class AddingInfoPageScenario extends BaseClass_2 {
	
	LoginPage loginPage;
	ProductPage productPage;
	YourCart yourCart;
	CheckOutInfoPage checkOutInfo;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		launchApp(browserName);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}

	@Test (dataProvider ="User_Details", dataProviderClass = DataProviders_2.class)
	public void AddingInfoToField(String firstName, String lastName, String code) throws InterruptedException {
	loginPage = new LoginPage();
	productPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
	productPage.addToCart();
	yourCart=productPage.clickOnCart();
	checkOutInfo=yourCart.clickOnCheckOut();
	//checkOutInfo.addInfo("abc", "xyz", "55555");
	checkOutInfo.addInfo(firstName, lastName, code);
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(code);
	String actURL=checkOutInfo.verifyOverview();
	String expURL = "https://www.saucedemo.com/checkout-step-two.html";
	Assert.assertEquals(actURL, expURL);

	
	
	}

}
