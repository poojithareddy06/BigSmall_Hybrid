package com.bs.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	String screenshotname;
	Screenshots screenshot = new Screenshots();
	
	public ExtentReport(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\ReportResult.html");	
	}
	
	public void startTest(String name)
	{
		test = report.startTest(name);
		try
		{
			test.log(LogStatus.PASS, test.addScreenCapture(screenshot.capture(driver)) + "Test Passed:" +name);;
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
	public void endTest()
	{
		report.endTest(test);
		report.flush();
	}

}
