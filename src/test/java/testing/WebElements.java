package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElements {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * <input id="Email" type="email" autofocus=""
		 * placeholder="Email or phone" name="Email" spellcheck="false"
		 * value=""/> note- different xpath for gmail in chrome
		 * 
		 * Locators: 
		 * id email name 
		 * css #Email
		 * xpath - //tagname[@attribute='value'] //id[@id='Email'] 
		 * tagName 
		 * className
		 * linkText 
		 * partialLinkText
		 */
		
		/*
		Relative xpath-properties(attribute)
		Absolute xpath-location //tr//td//tr[2]//td
		parial xpath
		 */

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.navigate().to("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		//we can navigate forward, backward using navigate instead of get
		
		driver.manage().window().maximize();
		//manage is returning Options, windows is returning Window and maximize returning void
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//manage is returning options interface and timeouts is a method of options
				//TimeUnit is class
		
		
		/* WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait is a class
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).getText();
		//class for condition and class name isVisibilityofElement and it has all static methods to call directly
		 By is a class
		 */
		 
		

		
		WebElement email = driver.findElement(By.xpath(".//*[@id='identifierId']"));
		// By is a class and it contains id,name,linkText which are static
		// methods present in By classand we can call directly
		// String email throws eror
		// findElement is returning WebElement Type so we storing as WebElement
		// webElement is an interface
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("lnarayan.jena@gmail.com");
		// findElement is returning WebElement so we can use its methods
		// directly also		
		driver.findElement(By.xpath(".//*[@id='identifierNext']")).click();
		
		
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("ffff");
		Thread.sleep(1500);
		driver.findElement(By.xpath(".//*[@id='passwordNext']")).click();
		
		
		
		Thread.sleep(2000);  //Hard coded wait  otherwise text will not be printed
		//wait should be added when page is not loading but element changes
				//ex- auto suggestion in google, password after next button in gmail ajax,jquery,angular etc
				
				//-------------intresting example-----
				/*implicit wait doesnot work for wrong username text. only thread.sleep works 
				becuase wrong username text already present in dom. its a hidden element and not visible
				implicit wait works for presence of element not visibility of element
				
				we have to use explicit wait 
				
				*/
		
		System.out.print(driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]")).getText());

		
		
		
		//driver.close();//close current window
		//driver.quit();//close all windows
	}

	}


