package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelReader;

public class ExcelParameterization {
	
	public static ExcelReader excel;

	
	@Test(dataProvider ="getData")
	public void doLogin(String username, String Password ,String result)
	{
		System.out.println(username + "----" + Password);
		
	}
	@DataProvider
	public static Object[][] getData()
	{
		
		if (excel==null){
			excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata.xlsx");
		}
		String sheetName="LoginTest";
		int rows= excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		System.out.println("Total rows are" + rows);
		System.out.println("Total columns are" + cols);
		
		excel.setCellData(sheetName, "result", 3, "fail");
		
		//System.out.println(excel.getCellData(sheetName, 0,2));
		//System.out.println(excel.getCellData(sheetName, 0,3));
		
		
		Object [][] data= new Object[rows-1][cols];
		//for rows 2 and for cols its is 0
		
		for(int rowNum =2 ; rowNum<=rows; rowNum++)
		{
			for(int colNum = 0; colNum< cols; colNum++)	
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		
		//data[0][0]="username1";
		//data[0][1]="password1";
		//data[1][0]="username2";
		//data[1][1]="password2";
		return data;
		 
	}
}
