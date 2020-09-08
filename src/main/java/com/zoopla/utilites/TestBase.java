package com.zoopla.utilites;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(com.zoopla.Listeners.TestListener.class)			



public class TestBase {

	
	public static WebDriver driver=null;
	 public static BrowserUtilites brwutil=new BrowserUtilites();
	 public static CommonUtilites commonutil=new CommonUtilites();
	public static String sclassNameForScreenShot="";
	 Logger log=Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public  void Loaddependcies() throws Exception
	{
		
		commonutil.loadPropertyfiles(System.getProperty("user.dir")+"/src/main/resources/Properties/TestData.properties");
		commonutil.loadlog4jproperties(System.getProperty("user.dir")+"/src/main/resources/Properties/log4j.properties");
		commonutil.loadconfigproperties(System.getProperty("user.dir")+"/src/main/resources/Properties/Config.properties");
		log.info("launching the browser");
	     brwutil.launchbrowser("chrome");
		
	}
	@AfterSuite
	public void quitbrowser() throws Exception
	{
		
		driver.quit();
	}

	

}
