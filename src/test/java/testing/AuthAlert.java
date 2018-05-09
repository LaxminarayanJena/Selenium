package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthAlert {

	public static void main(String[] args) {
		
			WebDriver driver= new ChromeDriver();
			driver.get("http://grcdev:nearlythere@getproactiv-ca.stg01.grdev.com/");
			
			//username:password@url
			driver.manage().window().maximize();
	}

}
