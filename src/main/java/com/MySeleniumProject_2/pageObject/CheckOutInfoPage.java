package com.MySeleniumProject_2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.base.BaseClass_2;

public class CheckOutInfoPage extends BaseClass_2 {
	
	@FindBy (xpath ="//*[@id=\"first-name\"]") WebElement FirstName;
	@FindBy (xpath ="//*[@id=\"last-name\"]") WebElement LasttName;
	@FindBy (xpath ="//*[@id=\"postal-code\"]") WebElement ZipCode;
	@FindBy (xpath ="//*[@id=\"continue\"]") WebElement ContinueBtn;
	
	public CheckOutInfoPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckOutOverviewPage addInfo(String fname, String lname, String zipcode) throws InterruptedException {
		Action_2.type(FirstName, fname);
		Action_2.type(LasttName, lname);
		Action_2.type(ZipCode, zipcode);
		Action_2.click(getDriver(), ContinueBtn);
		
		Thread.sleep(5000);
		return new CheckOutOverviewPage();
		
	}
	
	public String verifyOverview() {
		String exptURL = Action_2.getCurrentURL(getDriver());
		return exptURL;
		}

}
