package com.MySeleniumProject_2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.base.BaseClass_2;

public class ProductPage extends BaseClass_2 {
	
	@FindBy (xpath ="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")WebElement product;
	@FindBy (xpath ="//*[@id=\"shopping_cart_container\"]/a/span")WebElement cart;
	

	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}

    
	public void addToCart() throws InterruptedException {
		Action_2.click(getDriver(), product);
		Thread.sleep(2000);
	}
	
	public YourCart clickOnCart() throws InterruptedException {
		Action_2.click(getDriver(), cart);
		Thread.sleep(5000);
		return new YourCart();
	}
		
	public String verifyCartItem() {
		String exptURL = Action_2.getCurrentURL(getDriver());
		return exptURL;
		}
}
