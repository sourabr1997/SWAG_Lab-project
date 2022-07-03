package com.MySeleniumProject_2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.base.BaseClass_2;

public class YourCart extends BaseClass_2{
	
	@FindBy (xpath ="//*[@id=\"checkout\"]")WebElement checkout;
	
	public YourCart() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckOutInfoPage clickOnCheckOut() throws InterruptedException {
		Action_2.click(getDriver(), checkout);
		Thread.sleep(5000);
		return new CheckOutInfoPage();
	}
	
	public String verifyCartItem() {
		String exptURL = Action_2.getCurrentURL(getDriver());
		return exptURL;
		}
	
	


}
