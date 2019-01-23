package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cleartrip {
	@Test
	public void cleartt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Training_b6b.00.03\\Desktop\\Selenium3Plus_Srikar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartrip.com");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.id("FromTag"));
		Actions act1 = new Actions(driver);
		act1.sendKeys(from, "hyd").keyDown(Keys.SHIFT).sendKeys("er").keyUp(Keys.SHIFT).perform();
		Thread.sleep(7000);
		act1.sendKeys(Keys.ENTER).perform();
		String city = from.getAttribute("value");

		WebElement to = driver.findElement(By.id("ToTag"));
		to.sendKeys("ban");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ui-id-2"))));

		WebElement ul = driver.findElement(By.id("ui-id-2"));
		List<WebElement> list = ul.findElements(By.tagName("li"));

		for (WebElement e : list) {
			if (e.getText().contains("BKK")) {
				e.click();
				break;
			}
		}

		// Assert.assertTrue(city.contains("Hyderabad"));

	}
}
