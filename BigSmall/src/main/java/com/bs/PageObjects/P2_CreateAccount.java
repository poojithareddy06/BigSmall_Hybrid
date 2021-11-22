package com.bs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_1_LoginPage;
import com.bs.UIStore.UI_2_CreateAccountpage;
import com.bs.Utility.ExtentReport;


public class P2_CreateAccount {
	
	WebDriver driver;
	ExtentReport er;
	
	public P2_CreateAccount(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogin(UI_0_Landingpage lploc) {
		lploc.getsignin().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void clickoncreateaccount(UI_1_LoginPage lploc) {
		lploc.createaccount().click();;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void enterdetails()
	{
		er.startTest("Create Account");
		UI_2_CreateAccountpage cap = new UI_2_CreateAccountpage(driver);
		cap.getfirstname().sendKeys("Poojitha");
		cap.getlastname().sendKeys("Reddy");
		cap.getemail().sendKeys("xyz123@gmail.com");
		cap.createpassword().sendKeys("xyz123");
		//sploc.getcreateaccount().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void getmessage()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
	}

}
