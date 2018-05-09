package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelReader;


public class GmailParameterization {

	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void setUp(){
		
		driver = new FirefoxDriver();
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
		
	}
	
	
	@Test(dataProvider = "getData")
	public void doLogin(String username, String password,String Result) {

		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys(password);
		

	}

	@DataProvider
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\testdata.xlsx");
		String sheetName = "LoginTest";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println("Total rows are : " + rows + " and total cols are : " + cols);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;

	}

}
