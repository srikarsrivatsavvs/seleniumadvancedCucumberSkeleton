package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Datadriven {
	public static Object[][] excelfile() {
		Object[][] obj=null;
		File file = new File("src/test/resources/Book1.xlsx");
		try {
			InputStream stream = new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(stream);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			System.out.println("number of rows"+sheet.getLastRowNum());
			obj=new Object[sheet.getLastRowNum()][];
			
			for(int i=1;i<=sheet.getLastRowNum();i++)
			{
				obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++)
				{
				obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
}
			workbook.close();
			stream.close();
			
			
			
			
			
		}
		
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
		
		
		
		
		
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Training_b6b.00.03\\Desktop\\Selenium3Plus_Srikar\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://demowebshop.tricentis.com/");
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

	}
}
