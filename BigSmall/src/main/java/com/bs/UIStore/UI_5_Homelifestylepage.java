package com.bs.UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_5_Homelifestylepage {

	public WebDriver driver;
	public UI_5_Homelifestylepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="h1.section-header--title.h1")
	WebElement header;
	public WebElement getheader()
	{
		return header;
	}
	
	@FindBy(xpath="//a[@data-dropdown-rel='home-lifestyle']")
	WebElement hlsbtn;
	public WebElement gethlsbtn()
	{
		return hlsbtn;
	}
	@FindBy(xpath="(//ul[@class='site-nav__dropdown text-left'])[5] //a")
	WebElement dropdown;
	public WebElement getdropdown()
	{
		return dropdown;
	}
}
