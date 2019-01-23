package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ajaxtest 
{
	@Test
	public void dragndrop()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b6b.00.03\\Desktop\\Selenium3Plus_Srikar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		WebElement from=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[3]/div/div/span"));
		WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		Actions act1=new Actions(driver);
		act1.clickAndHold(from).release(to).perform();
		
		WebDriverWait waiting=new WebDriverWait(driver, 20) ;
		waiting.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		
		String pricecheck=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(pricecheck);
		Assert.assertTrue(pricecheck.contains("$5999"));
		
	}

}
