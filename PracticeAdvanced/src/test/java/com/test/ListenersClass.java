package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public class ListenersClass implements ITestListener
{
	Logger log = LogManager.getLogger(ListenerTest.class);
	static ExtentReports reports;
	static ExtentTest tests;
	static WebDriver driver;
	
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+"This is on starting");
		log.info(result.getMethod().getMethodName()+"This is on starting");
		// TODO Auto-generated method stub
		tests=reports.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"This is on test passing");
		log.info(result.getMethod().getMethodName()+"This is on passing");
		tests.log(LogStatus.PASS, result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"This is when the test fails");
		log.info(result.getMethod().getMethodName()+"This is on failing");
		tests.log(LogStatus.FAIL, result.getMethod().getMethodName()+"is failing");
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\ErrorScreenShots\\"+result.getMethod().getMethodName()+".png";
		try {
			FileUtils.copyFile(src,new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tests.log(LogStatus.FAIL,result.getThrowable().getMessage());
		tests.log(LogStatus.FAIL,tests.addScreenCapture(dest));
	}




	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"This is when the test is being skipped");
		log.info(result.getMethod().getMethodName()+"This is on skipping");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"This is when the test fails but within success percentage");
		log.info(result.getMethod().getMethodName()+"This is on failing but within success percentage");
		
	}

	public void onStart(ITestContext context) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b6b.00.03\\Desktop\\Selenium3Plus_Srikar\\chromedriver.exe");
		driver=new ChromeDriver();
		// TODO Auto-generated method stub
		System.out.println("on start");
		log.info("This is on starting");
		reports=new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms").format(new Date())+".html");
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("on finishing the test");
		log.info("This is on finishing");

		
	}

}
