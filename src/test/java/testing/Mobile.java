package testing;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Mobile {
	static DesiredCapabilities  capabilities;
    static String deviceName;
    public static void main(String[] args) throws InterruptedException {
     //some Sample Devices. Complete list can be found here: https://code.google.com/p/chromium/codesearch#chromium/src/chrome/test/chromedriver/chrome/mobile_device_list.cc
     //pick any of the device

    // deviceName = "Google Nexus 5";
    // deviceName = "Samsung Galaxy S4";
    // deviceName = "Samsung Galaxy Note 3";
    // deviceName = "Samsung Galaxy Note II";
     //deviceName = "Apple iPhone 4";
    // deviceName = "Apple iPhone 5";
     deviceName = "Apple iPad";
     
     
 
     Map<String, String> mobileEmulation = new HashMap<String, String>();
     mobileEmulation.put("deviceName", deviceName);

     Map<String, Object> chromeOptions = new HashMap<String, Object>();
     chromeOptions.put("mobileEmulation", mobileEmulation);

     capabilities = DesiredCapabilities.chrome();
     capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
     WebDriver driver = new ChromeDriver(capabilities);

     driver.manage().window().maximize();
     
     /*
     driver.get("https://www.flipkart.com/");
     System.out.print(driver.getTitle());
     
     Thread.sleep(2000);
     
     driver.findElement(By.xpath("//img[@alt='menu']")).click();
     Thread.sleep(2200);
     driver.findElement(By.xpath("//*[text()[contains(.,'TVs & Appliances')]]")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[text()[contains(.,'Televisions')]]")).click();
     
     */
     
     driver.get("http://pathqa.corp.tmnas.com/path/");
     
    
		
		
		

    }}