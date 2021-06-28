package com.extentReport;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicReport {
 ExtentReports extent;
 ExtentTest logger;
 ExtentSparkReporter htmlreporter;// might have issue
 //ExtentHtmlReporter htmlReporter;
 
 @BeforeTest
 public void init() {
	// String folder = System.getProperty("user.dir") + "/Reports/basicReport.html";
	 String destination = System.getProperty("user.dir") + "/Reports/"+"basicReport"+ System.currentTimeMillis()+".html";	
	 //htmlreporter=new ExtentSparkReporter("./Reports/basicReport.html");
	 htmlreporter=new ExtentSparkReporter(destination);
	 htmlreporter.config().setEncoding("UTF-8");
	 htmlreporter.config().setDocumentTitle("automated smoke test");
	 htmlreporter.config().setTheme(Theme.STANDARD);
	 
	 extent = new ExtentReports();
	 // this line is attatcing look and feel
	 extent.attachReporter(htmlreporter);
	 extent.setSystemInfo("User Name",System.getProperty("user.name"));
	 extent.setSystemInfo("Tester Name","Sajid");
	 extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	 extent.setSystemInfo("User Location", System.getProperty("user.country"));
		extent.setSystemInfo("OS name", System.getProperty("os.name"));
		extent.setSystemInfo("OS version", System.getProperty("os.version"));
		extent.setSystemInfo("JDK version", System.getProperty("java.version"));
		extent.setSystemInfo("Selenium version", "3.141.59");
		extent.setSystemInfo("Maven version", "3.15"); // you can write any thing.

 }
	
		@Test
		public void loginTest() {
			logger=	extent.createTest("loginTest", "this is for login test");
		}
		
		@Test
		public void registration() {
			logger=	extent.createTest("registration", "this is for registration test");
		}
		
		@Test
		public void creatUser() {
			logger=	extent.createTest("creatUser", "this is for creatUser test");
		}
		
		@Test
		public void logOut() {
			logger=	extent.createTest("logOut", "this is for logOut test");
			Assert.assertEquals(4, 6);
		}
		
		@AfterTest
		public void tearDown() {
			extent.flush();

		}
	

}
