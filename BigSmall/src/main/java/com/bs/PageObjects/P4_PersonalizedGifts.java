package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_4_Personalizedgiftpage;
import com.bs.Utility.ExtentReport;



public class P4_PersonalizedGifts {

	WebDriver driver;
	ExtentReport er;
	public P4_PersonalizedGifts(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	//personalized gift
	public void clickonpersonalizedgift(UI_0_Landingpage lploc) {
		lploc.getpersonalizedgift().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	//add to cart
	public void addproduct(UI_4_Personalizedgiftpage pploc) {
		er.startTest("Personalized Gifts");
		pploc.prproduct().click();
		pploc.entername().sendKeys("Poojitha");
		pploc.addtocart().click();
		er.endTest();
	}
	//verify
	public void verify(UI_4_Personalizedgiftpage pploc) {
		//System.out.println("To Verify: "+pploc.getverification().getText());
	}
}
