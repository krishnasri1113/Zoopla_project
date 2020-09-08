package com.zoopla.Listeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	public static ExtentReports reports;
     public static ExtentTest logger;
     public static ExtentReports createreport()
     {
     String spath=System.getProperty("user.dir")+"/ZooplaReport/Test_Automation_report.html";
	  return reports=new ExtentReports(spath);
     }
      


}
