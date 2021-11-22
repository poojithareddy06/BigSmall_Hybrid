package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.Utility.ExtentReport;


public class P8_Subscribe 
{
	WebDriver driver;
	ExtentReport er;

	public P8_Subscribe(WebDriver driver, ExtentReport er) 
	{
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}

	public void subscribetonewsletter(UI_0_Landingpage lploc) 
	{
		lploc.getemail().sendKeys("xyz@gmail.com");
		er.startTest("Subscribe to newsletter");
		lploc.getemail().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}

}
