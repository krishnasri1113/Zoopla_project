package com.zoopla.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CommonUtilites {
	public static Properties props=new Properties();
	static FileInputStream filein;
	 Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public void loadPropertyfiles(String PropertiesFilePath) throws Exception
	{
		log.info("TestData PropertyFile Path "+PropertiesFilePath);
		filein=new FileInputStream(PropertiesFilePath);
		props.load(filein);
		System.getProperties().putAll(props);
		
	}
	public void loadlog4jproperties(String PropertyFilePath) throws Exception
	{
		log.info("Log4j PropertyFile Path "+PropertyFilePath);
		filein=new FileInputStream(PropertyFilePath);
		props.load(filein);
		PropertyConfigurator.configure(props);
	}
	public void loadconfigproperties(String PropertiesFilePath) throws Exception
	{
		log.info("Config PropertyFile Path "+PropertiesFilePath);
		filein=new FileInputStream(PropertiesFilePath);
		props.load(filein);
		System.getProperties().putAll(props);
		
	}
	public static String ufTakescreenshot(WebDriver driver,String classname) throws Exception
 	{
 		TakesScreenshot ts=(TakesScreenshot)TestBase.driver;
 		File source=ts.getScreenshotAs(OutputType.FILE);
 	  String destinationimage=System.getProperty("user.dir")+"//Screenshot//"+classname+".png";
 	     File dest=new File(destinationimage);
 	     FileUtils.copyFile(source, dest);
 	     return destinationimage;
 	}

}
