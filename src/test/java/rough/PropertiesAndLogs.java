package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PropertiesAndLogs {
public static WebDriver driver;
static Logger log=Logger.getLogger("devpinoyLogger");

	public static void main(String[] args) throws IOException {
		Properties OR = new Properties() ;
		Properties Config = new Properties() ;
		
		FileInputStream fis = new FileInputStream("C://TMNA//WebDriverTesting//src//test//resources//Properties//OR.Properties");
		//alt +enter file location
        OR.load(fis);
        log.debug("or file loaded");
        System.out.println(OR .getProperty("username"));
        
        FileInputStream config = new FileInputStream(System.getProperty("user.dir")+"/src//test//resources//Properties//Config.Properties");
        Config .load(config);      
        System.out.println(Config .getProperty("browser"));
        
        if(Config .getProperty("browser").equals("firefox"))
        {
        	driver= new FirefoxDriver();
        }
        if(Config .getProperty("browser").equals("chrome"))
        {
        	driver= new ChromeDriver();
        }
        else if(Config .getProperty("browser").equals("ie"))
        {
        	driver= new InternetExplorerDriver();
        }
        
        driver.get(Config .getProperty("testsiteurl"));
        driver.findElement(By.xpath(OR .getProperty("username"))).sendKeys("RAMESH@gmail.com");
       // driver.findElement(By.xpath(Locators.username)).sendKeys("RAMESH@gmail.com");
        //called from locators.java
        driver.findElement(By.cssSelector(OR .getProperty("nextBtn"))).click();
	}

}
