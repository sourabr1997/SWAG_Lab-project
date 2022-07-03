package com.MySeleniumProject_2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.base.BaseClass_2;

public class CompletePage extends BaseClass_2{
	
	@FindBy (tagName=("h2")) WebElement header;
	
	public CompletePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String finalValidation() {
		String actHeader=Action_2.getText(getDriver(), header);
		return actHeader;
	}

}
