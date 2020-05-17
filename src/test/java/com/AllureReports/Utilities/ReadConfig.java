package com.AllureReports.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties pro;
	
	public ReadConfig()
	{
		File src = new File("F://GitRepository//AllureReports22Apr2020//src//test//java//Configuration//config.properties");
		//F:\GitRepository\AllureReports22Apr2020\src\test\java\Configuration\config.properties
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public static String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public static String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	public String getBrowser() {
		String browser=pro.getProperty("browser");
		return browser;
	}

	
	
	
}




