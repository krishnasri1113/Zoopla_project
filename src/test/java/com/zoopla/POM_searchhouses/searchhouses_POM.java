package com.zoopla.POM_searchhouses;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.utilites.TestBase;
 
public class searchhouses_POM extends TestBase {
	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	public searchhouses_POM(WebDriver driver)
	{
		TestBase.driver=driver;
		PageFactory.initElements(driver,this);
	}
   @FindBy(xpath="//div[@class='ui-cookie-consent-choose__buttons']//button[@data-responsibility='acceptAll']")
   WebElement acceptcookies;
   @FindBy(id = "search-input-location")
   WebElement inputlocation;
   @FindBy(xpath="//button[@value='Search']")
   WebElement search;
   @FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']")
  List<WebElement> listofprices;
    @FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']")
   List<WebElement> lihousepricesaftersort;
   @FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']//h4[@class='ui-agent__name']")
public WebElement agentname;
   @FindBy(xpath="(//div[@id='content']//b)[1]")
public  WebElement verifyagentname;
   
   
   public void searchinputlocation_and_submit()
   {
	   brwutil.waitElementToVisible(acceptcookies);
	   brwutil.ufclick(acceptcookies);
	   brwutil.waitElementToVisible(inputlocation);
	   brwutil.ufSendKeys(inputlocation, System.getProperty("city"));
	   brwutil.waitElementToVisible(search);
	   brwutil.ufclick(search);
	   
   }
   public void listof_house_prices_by_descending() throws Exception
   {
	   brwutil.waitElementToVisible_list(listofprices);
	   System.out.println(listofprices.size());
		ArrayList<String> houseprices=new ArrayList<String>();
		for(int i=0;i<listofprices.size();i++)
		{
			//String homeprices=listofprices.get(i).getText();
			houseprices.add(listofprices.get(i).getText());
			
		}
			Collections.sort(houseprices,Collections.reverseOrder());
			System.out.println("The houses prices in descending order is:");
		
			for(String values:houseprices)
			{
				System.out.println(values);
			}
			Thread.sleep(3000);
			
   }
   public void select_the_fivth_property() throws Exception
   {

	  //brwutil.waitElementToVisible_list(lihousepricesaftersort);
	  System.out.println(lihousepricesaftersort.size());
	  Thread.sleep(3000);
	  for(int i=0;i<lihousepricesaftersort.size();i++)
	  {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", lihousepricesaftersort.get(4));
	  }
	  
   }
   public void click_agent_name()
   {
	   brwutil.waitElementToVisible(agentname);
	   //String actual=  agentname.getText();
	   brwutil.ufclick(agentname);
   }
   public void verify_agentname()
   {
	   brwutil.waitElementToVisible(verifyagentname);
	   //String expected=verifyagentname.getText();
   }
}
