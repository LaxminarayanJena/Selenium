package testing;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert {

	public static void main(String[] args) {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
		//WebDriver driver = new ChromeDriver();
	driver.get("http://www.rediffmail.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[1]/input")).click();
	System.out.println(driver.switchTo().alert().getText());
	//Alert is an interface and it has method accept, dismiss,getText
	driver.switchTo().alert().accept();
	
	

	}

}
