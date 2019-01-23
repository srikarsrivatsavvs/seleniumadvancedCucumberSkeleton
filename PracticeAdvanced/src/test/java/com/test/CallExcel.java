package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CallExcel 
{
	@Test(dataProvider="dp1")
	public void testingofExcel(String username, String password)
	{
		System.out.println(username+password);
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] receiveData() throws InterruptedException
	{
		return Datadriven.excelfile();
	}

}
