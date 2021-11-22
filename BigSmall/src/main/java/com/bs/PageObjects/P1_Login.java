package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_1_LoginPage;
import com.bs.Utility.ExtentReport;

public class P1_Login {
	
	WebDriver driver;
	ExtentReport er;
	public P1_Login(WebDriver driver, ExtentReport er)
	{
		this.driver=driver;
		this.er=er;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//home page signin
	public void clickonsignin(UI_0_Landingpage lploc)
	{
		lploc.getsignin().click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	//signin details
	public void details(UI_1_LoginPage lploc)
	{
		er.startTest("Login");
		lploc.email().sendKeys("poojithareddy1199@gmail.com");
		lploc.password().sendKeys("pooj@123");
		//lploc.sign_in().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	
	//forgotpassword
	public void forgotpassword(UI_1_LoginPage lploc)
	{
		lploc.forgot().click();
	}
	
	//recoverpassword
	public void reqpassword(UI_1_LoginPage lploc) throws InterruptedException
	{
		er.startTest("Reset Password");
		lploc.recoveryemail().sendKeys("poojithareddy1199@gmail.com");
		lploc.forgotpwdsubmit().click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("div[class='errors']")).getText());
		er.endTest();
	}
	public void getmessage()
	{
		System.out.println(driver.findElement(By.cssSelector("div[class='errors']")).getText());
	}

}
