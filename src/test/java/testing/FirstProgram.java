package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstProgram {

	public static void main(String[] args) {

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

		// Desired capabilities is a class help to decide capability of browser
		caps.setCapability("EnableNativeEvents", false);
		caps.setCapability("ignoreZoomSetting", true);

		System.setProperty("webdriver.ie.driver",
				"C:/lnjena/software/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(caps);
		// WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();

		driver.get("http://google.in");
		System.out.println(driver.getTitle());
		String actual_title = driver.getTitle();
		String expected_title = "Google";
		if ((actual_title).equals(expected_title)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		driver.quit();
	}

}

// shift + ctrl+f - arrange neatly
//shift + ctrl+O - import all jars
//http://seleniumhq.github.io/selenium/docs/api/java/index.html

/*
 * An instance of FirefoxDriver class has been created and the address of that
 * instance has been stored in the WebDriver type driver variable. As soon as
 * 'new' keyword create the instance in the heap area while execution it will
 * open the firefox browser with default setting. As well as FirefoxDriver class
 * will implement all the methods of WebDriver interface.new FirefoxDriver() -
 * when ever i create an object the very first thing that is called is
 * constructor.i just created an object and a constructor is called and it has
 * launched the browser
 * 
 * 
 * 
 * 
 * WebDriver driver = new FirefoxDriver(); In the above statement, WebDriver is
 * an interface. An interface contains empty methods that have been defined but
 * not implemented. These methods can be implemented by anyone as long as the
 * method type and signatures are not violated. Therefore, an interface is also
 * known as contract, because you can use an interface as you like but you
 * cannot change the way it has been defined. And, since it has empty methods
 * you won't actually need to instantiate it and so you cannot instantiate it.
 * FirefoxDriver is a class that has been written specifically for the Firefox
 * browser. It has methods that are implemented and it can be instantiated. It
 * can perform all functions (or methods) on the Firefox browser as defined in
 * the interface WebDriver. So in the above statement, we are actually telling
 * FirefoxDriver class that "hey you can automate the various methods that you
 * want on the Firefox browser but you need to stick to the contract defined in
 * WebDriver". So we declare a reference variable of type WebDriver and then use
 * it to instantiate FirefoxDriver, which means that the object (driver) is of
 * type WebDriver but points to the memory allocation to all data and methods in
 * FirefoxDriver (and, as mentioned above, the FirefoxDriver class already has
 * the implemented version of methods in WebDriver). So all good :) By using
 * this technique, we have made it easy for the tester to use any browser of his
 * or her liking. For example, to automate on IE driver, one will have to simply
 * write a statement like WebDriver driver = new IEDriver(); //where IEDriver is
 * the class written for IE
 */