import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
     
public class sample {
 static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("https://www.zoopla.co.uk");
		driver.manage().window().maximize();
		WebDriverWait  wait=new WebDriverWait(driver,30); 
		WebElement acceptcookie=driver.findElement(By.xpath("//div[@class='ui-cookie-consent-choose__buttons']//button[@data-responsibility='acceptAll']"));
		//Thread.sleep(2000); 
		acceptcookie.click();
		WebElement inputlocation=driver.findElement(By.id("search-input-location"));
		inputlocation.sendKeys("London");
		WebElement submit=driver.findElement(By.xpath("//button[@value='Search']"));
		submit.click();
		List<WebElement> listofprices=driver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
		
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
			
	List<WebElement> lihouseprices	=driver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
	JavascriptExecutor js1=(JavascriptExecutor) driver;
	js1.executeScript("arguments[0].click();", lihouseprices.get(4));
	
	
//WebElement agentname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")));
		//agentname.click();
	Thread.sleep(2000);
		WebElement agentname=driver.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']//h4[@class='ui-agent__name']"));
		Thread.sleep(3000);
		System.out.println(agentname.getText());
		agentname.click();
		WebElement verifyagentname=driver.findElement(By.xpath("(//div[@id='content']//b)[1]"));
		System.out.println(verifyagentname.getText());

	

	}
}
