package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_3_Corporategiftpage;
import com.bs.Utility.ExtentReport;



public class P3_CorporateGifts
{
	WebDriver driver;
	ExtentReport er;
	
	public P3_CorporateGifts(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncorporategift(UI_0_Landingpage lploc) {
		er.startTest("Corporate Gifts");
		lploc.getcorporategift().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	//customer details
	public void enterdetails(UI_3_Corporategiftpage cg)
	{
		cg.getname().sendKeys("Xyz");
		cg.getemail().sendKeys("xyz@gmail.com");
		cg.getphone().sendKeys("1234567890");
		cg.getenquiry().sendKeys("Sharing the quantity, budget etc...");
		//cg.getsubmit().click();
		er.endTest();
	}
	//verification text
	public void verification(UI_3_Corporategiftpage cg) {
		System.out.println(cg.getverification().getText());
	}
	
}

