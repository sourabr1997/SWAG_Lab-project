package com.MySeleniumProject_2.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.MySeleniumProject_2.actiondriver.Action_2;
import com.MySeleniumProject_2.utility.ExtentManager_2;
import com.MySeleniumProject_2.utility.Log_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

public class BaseClass_2 {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	public static WebDriver getDriver(){
		return driver.get();
	}
	
	@SuppressWarnings("restriction")
	@BeforeSuite (groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() throws IOException {
			ExtentManager_2.setExtent();
			DOMConfigurator.configure("log4j_2.xml");
			Log_2.info("This is beforeSuite Method");
			prop = new Properties();
			System.out.println("Super constructore invoked");
			try {
				FileInputStream input = new FileInputStream(System.getProperty("user.dir")+("\\Configuration\\Config_2.properties"));
				prop.load(input);
				System.out.println("driver: "+getDriver());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	
	
	
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		//String browserName = prop.getProperty("browser");
		
		if (browserName.contains("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}else if (browserName.contains("FireFox")) {
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}else if(browserName.contains("IE")) {
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		
		Action_2.implicitWait(getDriver(),20);
		Action_2.pageLoadTimeOut(getDriver(),30);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		
	}
	
	@AfterSuite (groups = {"Smoke", "Sanity", "Regression"})
	public void afterSuite1() throws IOException {
		Log_2.info("This is afterSuite Method");
		ExtentManager_2.endReport();
	}

}
