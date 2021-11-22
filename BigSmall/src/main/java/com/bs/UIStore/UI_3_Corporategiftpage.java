package com.bs.UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_3_Corporategiftpage {
		public WebDriver driver;
		public UI_3_Corporategiftpage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(id="contactFormName")
		WebElement name;
			public WebElement getname() 
			{
				return name;
			}
		
		@FindBy(id="contactFormEmail")
		WebElement email;
			public WebElement getemail() 
			{
				return email;
			}

		@FindBy(id="contactFormPhone")
		WebElement phone;
			public WebElement getphone()
			{
				return phone;
			}

		@FindBy(id="contactFormMessage")
		WebElement message;
			public WebElement getenquiry() 
			{
				return message;
			}
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement submit;
			public WebElement getsubmit() 
			{
				return submit;
			}
		
		@FindBy(xpath="//*[contains(text(),'Thanks for contacting us')]")
		WebElement verificationmsg;
			public WebElement getverification() 
			{
				return verificationmsg;
			}
}
