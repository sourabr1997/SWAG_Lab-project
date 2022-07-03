package com.MySeleniumProject_2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.base.BaseClass_2;

public class LoginPage extends BaseClass_2{
	
	@FindBy (xpath="//*[@id=\"user-name\"]") WebElement username;
	@FindBy (xpath="//*[@id=\"password\"]") WebElement password;
	@FindBy (xpath="//*[@id=\"login-button\"]") WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ProductPage login(String uname, String pass) {
		Action_2.type(username, uname);
		Action_2.type(password, pass);
		Action_2.click(getDriver(), loginbtn);
		return new ProductPage();
	}
	
	public String verifyLogin() {
		String actString=Action_2.getCurrentURL(getDriver());
		return actString;
		
	}


}