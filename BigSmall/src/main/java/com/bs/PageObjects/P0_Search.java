package com.bs.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bs.UIStore.UI_0_Landingpage;
import com.bs.Utility.ExtentReport;


public class P0_Search {
	WebDriver driver;

	public P0_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	ArrayList<String> productlist = new ArrayList<String>();
	public void getproducts(String path) throws IOException {

		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		int number_of_sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < number_of_sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row frow = rows.next(); 
				Iterator<Cell> cols = frow.cellIterator();
				int k = 0;
				int colnum = 0;
				while (cols.hasNext()) {
					Cell value = cols.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						colnum = k;
					}
					k++;
				}
				//System.out.println("Column number: " + colnum);
				while (rows.hasNext()) {
					Row r = rows.next();
					//System.out.println(r.getCell(colnum).getStringCellValue());
					productlist.add(r.getCell(colnum).getStringCellValue());

				}}
			workbook.close();
		}
	}

	public void searchforproducts(ExtentReport er) {
		// TODO Auto-generated method stub
		Iterator<String> name = productlist.iterator();
		UI_0_Landingpage lploc = new UI_0_Landingpage(driver);
		while (name.hasNext()) {
			String product = name.next();
			lploc.getsearchbox().sendKeys(product);
			lploc.getsearchbox().sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			er.startTest("Searching for "+product);	
			lploc.getsearchbox().clear();
			er.endTest();
		}
	}

}
