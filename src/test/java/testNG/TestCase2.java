package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	@Test(groups="low")
	public void validateTitles()
	{
		String expected ="yahoo";
		String actual="gmail";
		
	/*	if(expected.equals(actual))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		Assert.assertEquals(actual, expected);
	}
}

/*NOte- if we use if else then it shows green even if test case fails
hence use assertEquals
*/