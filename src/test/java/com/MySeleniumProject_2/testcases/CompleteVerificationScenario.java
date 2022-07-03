package com.MySeleniumProject_2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MySeleniumProject_2.base.BaseClass_2;
import com.MySeleniumProject_2.dataProvider.DataProviders_2;
import com.MySeleniumProject_2.pageObject.CheckOutInfoPage;
import com.MySeleniumProject_2.pageObject.CheckOutOverviewPage;
import com.MySeleniumProject_2.pageObject.CompletePage;
import com.MySeleniumProject_2.pageObject.LoginPage;
import com.MySeleniumProject_2.pageObject.ProductPage;
import com.MySeleniumProject_2.pageObject.YourCart;
import com.MySeleniumProject_2.utility.Log_2;

public class CompleteVerificationScenario extends BaseClass_2 {
	LoginPage loginPage;
	ProductPage productPage;
	YourCart yourCart;
	CheckOutInfoPage checkOutInfo;
	CheckOutOverviewPage checkOutOverview;
	CompletePage completepage;

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
	public void completeVerification(String firstName, String lastName, String code) throws InterruptedException {
	
	Log_2.startTestCase("completeVerification");
	//Log_2.info("This is complete testcase");
	
	Log_2.info("we are at login page");
	loginPage = new LoginPage();
	Log_2.info("entering username and password");
	productPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
	Log_2.info("we are in productpage");
	Log_2.info("We added a product");
	productPage.addToCart();
	Log_2.info("We Clicked on cart icon");
	yourCart=productPage.clickOnCart();
	Log_2.info("We are in checkout page");
	checkOutInfo=yourCart.clickOnCheckOut();
	//checkOutOverview =checkOutInfo.addInfo("abc", "xyz", "55555");
	Log_2.info("We entered user information");
	checkOutOverview=checkOutInfo.addInfo(firstName, lastName, code);
	Thread.sleep(2000);
	Log_2.info("We are in checkout overview page");
	double expectedprice = checkOutOverview.verifyPrice();
	double actualprice = checkOutOverview.getActualFinalPrice();
	completepage=checkOutOverview.clickOnFinish();
	String actString =completepage.finalValidation();
	Log_2.info("We successfully completed this test case");
	String expetedString = "THANK YOU FOR YOUR ORDERSSSS";
	
	
	Log_2.endTestCase("End of completeVerification test case");
	//System.out.println(expectedprice);
	//System.out.println(actualprice);
	
	
	Assert.assertEquals(actString, expetedString);;
	
	}

}
