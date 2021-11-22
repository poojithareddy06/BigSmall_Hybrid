package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_5_Homelifestylepage;
import com.bs.Utility.ExtentReport;


public class P5_HomeLifeStyle {

	WebDriver driver;
	ExtentReport er;
	
	public P5_HomeLifeStyle(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonhomelifestyle(UI_0_Landingpage lploc) {
		WebElement hls = lploc.gethomelifestyle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(hls).build().perform();
		er.startTest("Home & Lifestyle");
		lploc.gethomedecor().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}

	public void dropdown(UI_5_Homelifestylepage hlsloc) {
		er.startTest("Filter by new");
		hlsloc.gethlsbtn().click();
		hlsloc.getdropdown().sendKeys(Keys.DOWN);
		hlsloc.getdropdown().sendKeys(Keys.ENTER);
		er.endTest();
	}
}
