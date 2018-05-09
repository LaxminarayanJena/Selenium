package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void createDBConnection()
	{
		System.out.println("open dbconnection");
	}

	@AfterTest
	public void closeDBConnection()
	{
		System.out.println("close dbconnection");
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		System.out.println("open browser");
		
	}
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("close browser");
			
	}
	
	@Test(priority=1, groups="high")
	public void doLogin()
	{
		System.out.println("Executing login Test");
	}
	@Test(priority=2, groups="high")
	public void composeEmail()
	{
		System.out.println("Executing composemail");
			
	}
	
	/*-----------------Notes-----------
	 1)it runs on alphabetically
	 2)add priority to run accordingly
	 * */
	 

}
