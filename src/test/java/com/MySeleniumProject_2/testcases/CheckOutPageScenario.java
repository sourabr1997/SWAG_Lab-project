package com.MySeleniumProject_2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MySeleniumProject_2.base.BaseClass_2;
import com.MySeleniumProject_2.pageObject.CheckOutInfoPage;
import com.MySeleniumProject_2.pageObject.LoginPage;
import com.MySeleniumProject_2.pageObject.ProductPage;
import com.MySeleniumProject_2.pageObject.YourCart;
import com.beust.jcommander.Parameter;

public class CheckOutPageScenario extends BaseClass_2 {
	
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

	@Test
	public void addProductToCart() throws InterruptedException {
		loginPage = new LoginPage();
		productPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
		productPage.addToCart();
		yourCart=productPage.clickOnCart();
		checkOutInfo=yourCart.clickOnCheckOut();
		String actualURL2=yourCart.verifyCartItem();
		String expctURL2 = "https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actualURL2, expctURL2);
			
			
		
}
	

}
