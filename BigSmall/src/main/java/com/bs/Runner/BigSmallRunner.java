package com.bs.Runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bs.PageObjects.P0_Search;
import com.bs.PageObjects.P1_Login;
import com.bs.PageObjects.P2_CreateAccount;
import com.bs.PageObjects.P3_CorporateGifts;
import com.bs.PageObjects.P4_PersonalizedGifts;
import com.bs.PageObjects.P5_HomeLifeStyle;
import com.bs.PageObjects.P6_Wishlist;
import com.bs.PageObjects.P7_Giftcard;
import com.bs.PageObjects.P8_Subscribe;
import com.bs.PageObjects.P9_Aboutus;
import com.bs.ReusableComponents.WebDriverHelper;
import com.bs.UIStore.UI_0_Landingpage;
import com.bs.UIStore.UI_1_LoginPage;
import com.bs.UIStore.UI_3_Corporategiftpage;
import com.bs.UIStore.UI_4_Personalizedgiftpage;
import com.bs.UIStore.UI_5_Homelifestylepage;
import com.bs.UIStore.UI_7_Giftcardpage;
import com.bs.UIStore.UI_9_Aboutuspage;
import com.bs.Utility.ExtentReport;
import com.bs.Utility.ReadProperty;


public class BigSmallRunner {

	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper=null;
	ExtentReport er;
	UI_0_Landingpage lploc;
	UI_1_LoginPage loginloc;
	String wurl;
	
	private static Logger logger=LogManager.getLogger(BigSmallRunner.class.getName());
	
	@Test(priority =1)
	public void driver()
	{
		String browser = rp.getdriver();
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			helper=new WebDriverHelper(driver);
			driver.manage().window().maximize();
			logger.info("Setting driver");
			er=new ExtentReport(driver);
		}
	}
	
	@Test(priority=2)
	public void openwebsite()
	{
		String url = rp.getUrl();
		wurl=url;
		helper.openUrl(url);
		lploc = new UI_0_Landingpage(driver);
		er = new ExtentReport(driver);	
		logger.info("Opening website");
		
	}
	
	@Test(priority = 3)
	public void login() throws InterruptedException
	{
		loginloc=new UI_1_LoginPage(driver);
		P1_Login login = new P1_Login(driver,er);
		driver.get(wurl);
		login.clickonsignin(lploc);
		driver=helper.newdriver(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		login.details(loginloc);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		logger.info("Logged into account ");
		
	}
	
	@Test(priority = 4)
	public void createaccount() throws InterruptedException
	{
	
		loginloc = new UI_1_LoginPage(driver);
		P2_CreateAccount newacc = new P2_CreateAccount(driver,er);
		driver.get(wurl);
		newacc.clickonlogin(lploc);
		driver = helper.newdriver(driver);
		newacc.clickoncreateaccount(loginloc);
		driver = helper.newdriver(driver);
		newacc.enterdetails();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Creating Account");
		driver.get(wurl);
	}
	
	@Test(priority = 5)
	public void corporategifts() throws InterruptedException
	{
		driver.get(wurl);
		driver=helper.newdriver(driver);
		P3_CorporateGifts cg = new P3_CorporateGifts(driver,er);
		UI_3_Corporategiftpage cgp = new UI_3_Corporategiftpage(driver);
		cg.clickoncorporategift(lploc);
		cg.enterdetails(cgp);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver = helper.newdriver(driver);
		logger.info("Corporate Gifts details entered");
	
	}
	
	@Test(priority = 6)
	public void personalizedgifts() throws InterruptedException {

		// Locators for Personalized gifts
		driver.get(wurl);
		UI_4_Personalizedgiftpage pgp = new UI_4_Personalizedgiftpage(driver);
		P4_PersonalizedGifts pg = new P4_PersonalizedGifts(driver, er);
		pg.clickonpersonalizedgift(lploc);
		pg.addproduct(pgp);
		driver = helper.newdriver(driver);
		pg.verify(pgp);
		driver.get(wurl);
		logger.info("Added personalized gift successfully");
	}

	
	@Test(priority = 7)
	public void wishlist() throws InterruptedException
	{
		driver.get(wurl);
		P6_Wishlist wl = new P6_Wishlist(driver,er);
		wl.clickonwishlist(lploc);
		driver = helper.newdriver(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		logger.info("Product is in Wishlist");
		
	}
	
	@Test(priority = 8)
	public void giftcard() throws InterruptedException
	{
		driver.get(wurl);
		UI_7_Giftcardpage gcp = new UI_7_Giftcardpage(driver);
		P7_Giftcard gc = new P7_Giftcard(driver, er);
		gc.clickongiftcard(lploc);
		driver = helper.newdriver(driver);
		gc.checkCOD(gcp);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gc.getAvailability(gcp);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gc.addtowishlist(gcp);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Gift cards are available");
	
	}
	
	@Test(priority = 9)
	public void subscribe()
	{
		driver.get(wurl);
		P8_Subscribe nl = new P8_Subscribe(driver, er);
		nl.subscribetonewsletter(lploc);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		logger.info("Subscribed to Newsletter");
	
	}
	
	@Test(priority = 10)
	public void aboutus() throws InterruptedException
	{
		driver.get(wurl);
		P9_Aboutus au = new P9_Aboutus(driver, er);
		UI_9_Aboutuspage aup = new UI_9_Aboutuspage(driver);
		au.clickonaboutus(lploc);
		driver=helper.newdriver(driver);
		au.getaboutustitle(aup);
		logger.info("Title verified");
	}
	
	@Test(priority = 10, dataProvider = "getCredentials")
	public void searchprods(String path) throws InterruptedException, IOException {
		driver.get(wurl);
		
		P0_Search search = new P0_Search(driver);
		search.getproducts(path);
		search.searchforproducts(er);
		logger.info("Searched products from excel sheet");
	}

	@DataProvider
	public Object[][] getCredentials() {
		Object[][] data = new Object[1][1];
		data[0][0] = System.getProperty("user.dir") + rp.pathsheet();
		return data;
	}

	
	
	 @AfterTest
	    public void closeDriver() {
	        driver.quit();
	        driver=null;
	    }
	
}
