package com.bs.ReusableComponents;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverHelper {

	WebDriver driver;
	public WebDriverHelper(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}
	
	public WebDriver newdriver(WebDriver driver) throws InterruptedException
	{
		Set<String> id = driver.getWindowHandles();
		Iterator<String> itr = id.iterator();
		Thread.sleep(1000);
		driver.switchTo().window(itr.next());
		return driver;
	}
}
