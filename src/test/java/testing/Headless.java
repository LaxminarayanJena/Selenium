package testing;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Headless {

	public static void main(String[] args) {
		WebDriver driver = new PhantomJSDriver();
		//WebDriver driver = new FirefoxDriver();
		
		//WebDriver driver = new InternetExplorerDriver();
	
        driver.get("http://www.google.com");         
        WebElement element = driver.findElement(By.name("q"));	
        element.sendKeys("Guru99");					
        element.submit();         			
        System.out.println("Page title is: " + driver.getTitle());	
       
        driver.quit();			
}		
}