package com.bs.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	static Properties config;
	
	public ReadProperty()
	{
		config = new Properties();
		FileInputStream fs = null;
		try
		{
			fs=new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
			
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		try {
			config.load(fs);
			config.getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getdriver()
	{
		String browser = config.getProperty("browser");
		System.out.println(config.getProperty("browser"));
		if(browser != null)
		{
			return browser;
		}
		else
		{
			throw new RuntimeException("No browser mentioned.......");
		}
	}
	public String getUrl()
	{
		String url=config.getProperty("url");
		if(url!=null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("URL Not specified");
		}
	}
	public String pathsheet() {
		String path = config.getProperty("pathtosheet");
		if (path != null) {
			return path;
		} else {
			throw new RuntimeException("No path to excel sheet..");
		}
	}
	

}
