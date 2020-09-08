package com.zoopla.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
//import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.zoopla.utilites.CommonUtilites;
import com.zoopla.utilites.TestBase;



public class TestListener extends ExtentManager  implements ITestListener{
	
	 public static ExtentReports reports=ExtentManager.createreport();
	
	 
	 public void onFinish(ITestContext Result) 					
	    {
		 
		 System.out.println("Testsuite ending "+Result.getName());
		    reports.endTest(logger);
		     reports.flush();
	    }		

	    public void onStart(ITestContext Result)					
	    {		
	           System.out.println("Testsuite started");
	            //createreport();
	    }	
	    		
 // When Test case get failed, this method is called.		
	    public void onTestFailure(ITestResult Result) 					
	    {		
	    System.out.println("The name of the testcase failed is :"+Result.getName());
	 
	    try {
			logger.log(LogStatus.FAIL,"Failed"+logger.addScreenCapture(CommonUtilites.ufTakescreenshot(TestBase.driver, TestBase.sclassNameForScreenShot+Result.getName())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }		

	    // When Test case get Skipped, this method is called.		
	    public void onTestSkipped(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());
	    logger.log(LogStatus.SKIP, Result.getName()+" skipped");
	    
	    
	    }		

	    // When Test case get Started, this method is called.		
	    public void onTestStart(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase started "+Result.getName());
	      //createreport();
	    logger=reports.startTest(Result.getMethod().getMethodName());
	    
	    }		

	    // When Test case get passed, this method is called.		
	    public void onTestSuccess(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase passed is :"+Result.getName());
	    logger.log(LogStatus.PASS, Result.getMethod().getMethodName()+" passed");
	    
	    
	    
	    }

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}		


}
