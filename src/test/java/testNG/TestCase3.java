package testNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(priority=1, groups="med")
	public void doLogin()
	{
		//Assert.fail("login fail");
		//Assert.assertTrue(isElementPresent(""), "login not succesfull");
		//accepts boolean value
		System.out.println("login sucessfully");			
	}
	
	@Test(priority=2, dependsOnMethods="doLogin" , groups="low")
	//@Test(priority=2, dependsOnMethods={"doLogin",""})--->multiple methods
	public void composeEmail()
	{
		System.out.println("Executing composemail");
		throw new SkipException("skipping testcase");
		//skip testcase	
	}
	
	@Test(groups="high")
	public void validateData()
	{
		Assert.fail();
	}

}
