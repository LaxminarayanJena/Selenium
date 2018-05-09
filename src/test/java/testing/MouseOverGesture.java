package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseOverGesture {

	public static void main(String[] args) {
		WebDriver driver =new InternetExplorerDriver();
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		WebElement menu=driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/a/span"));
		Actions action =new Actions(driver);
		action.moveToElement(menu).perform();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[4]/a/span"))).click();
		
//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[4]/a/span")).click();
		
		

	}

}
