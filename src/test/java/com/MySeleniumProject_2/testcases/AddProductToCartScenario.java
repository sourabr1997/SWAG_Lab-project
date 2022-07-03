package com.MySeleniumProject_2.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MySeleniumProject_2.base.BaseClass_2;
import com.MySeleniumProject_2.pageObject.LoginPage;
import com.MySeleniumProject_2.pageObject.ProductPage;
import com.MySeleniumProject_2.pageObject.YourCart;
import com.beust.jcommander.Parameter;

public class AddProductToCartScenario extends BaseClass_2{
	
LoginPage loginPage;
ProductPage productPage;
YourCart yourCart;

@Parameters("browser")
@BeforeMethod
public void setup(String browserName) {
	launchApp(browserName);
}

@Test
public void addProductToCart() throws InterruptedException {
	loginPage = new LoginPage();
	productPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
	productPage.addToCart();
	productPage.clickOnCart();
	String actURL=productPage.verifyCartItem();
	String exptURL ="https://www.saucedemo.com/cart.html";
	Assert.assertEquals(actURL, exptURL);
	}

@AfterMethod
public void tearDown() {
	getDriver().quit();
	
}


}
