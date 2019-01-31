package com.test;

import java.util.concurrent.TimeUnit;\

hellooooooo

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestingHdfc 
{
	@Test
	public void hdfclink() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b6b.00.03\\Desktop\\Selenium3Plus_Srikar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.linkText("Products"))).perform();
		Thread.sleep(3000);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
//		driver.findElement(By.cssSelector("a[href='/personal/products/accounts-and-deposits/savings-account']")).click();
	}

}
