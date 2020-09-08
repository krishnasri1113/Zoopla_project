package com.zoopla.SearchhousesFunctionality;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.POM_searchhouses.searchhouses_POM;
import com.zoopla.utilites.TestBase;

public class searchhouses extends TestBase {
	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	searchhouses_POM searchhouses;
	
	@BeforeTest
	public void SettingtheEnvironment() throws Exception {
		driver.get(System.getProperty("QAEnvironmentURL"));
		 searchhouses=new searchhouses_POM(driver);
		
	}
	@Test(priority = 0)
	public void enter_input_location()
	{
		searchhouses.searchinputlocation_and_submit();
		log.info("enter input location");
		log.info("user submitted the inputlocation");
	}
	@Test(priority = 1)
	public void listof_house_prices_in_descending() throws Exception
	{
		searchhouses.listof_house_prices_by_descending();
		log.info("list of house prices are displayed by descending order");
		
	}
	@Test(priority = 2)
	public void click_on_the_fiveth_property() throws Exception
	{
		searchhouses.select_the_fivth_property();
		log.info("user clicked on fiveth proprty from list of houses");
	}
	
	@Test(priority = 3)
	public void click_and_verify_agentname()
	{
		String actual=searchhouses.agentname.getText();
		System.out.println(actual);
		searchhouses.click_agent_name();
		log.info("user cicked on agent name");
		searchhouses.verify_agentname();
		String expected=searchhouses.verifyagentname.getText();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
	}

}
