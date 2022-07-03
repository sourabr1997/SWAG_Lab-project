package com.MySeleniumProject_2.utility;

import java.io.IOException;

import com.MySeleniumProject_2.base.BaseClass_2;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.MySeleniumProject_2.actiondriver.Action_2;
/**
 * 
 *  
 */
public class ExtentManager_2 {
	
	public static ExtentSparkReporter htmlReporter; // latest change ExtentSparkReporter 
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+Action_2.getCurrentTime()+"html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config_2.xml");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("SWAG Labs Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK); 
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "SWAGLab_Project");
		extent.setSystemInfo("Tester", "Sourab");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}