package com.zoopla.utilites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.xml.sax.Locator;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilites extends TestBase {

	//@BeforeSuite
	@Parameters("browser")
	public  void launchbrowser(String  sBrowser)
	
	{
		
	  if(sBrowser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  TestBase.driver=new ChromeDriver();
		  TestBase.driver.manage().window().maximize();
		 
	  }
	  else if(sBrowser.equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  TestBase.driver=new FirefoxDriver();
		  TestBase.driver.manage().window().maximize();
		 
	  }
	}
	 
	public  void waitElementToVisible(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(TestBase.driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public  void waitElementToVisible_list(List<WebElement> ele)
	{
		WebDriverWait wait=new WebDriverWait(TestBase.driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public  void waitElementToVisible_locatedby(By loc)
	{
		WebDriverWait wait=new WebDriverWait(TestBase.driver,50);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	public  void ufSendKeys(WebElement ele,String KeyTosend)
	{
		ele.sendKeys(KeyTosend);
	}
	public  void ufclick(WebElement ele)
	{
		ele.click();
	}
	

}
