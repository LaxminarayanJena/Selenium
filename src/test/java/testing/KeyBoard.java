package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		//driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("hello1@gmail.com");
		Actions action = new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();;
		driver.findElement(By.xpath("//div[1]/h1")).click();
		//action.sendKeys(Keys.PAGE_UP).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL + "a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL + "c")).perform();
		driver.findElement(By.xpath(".//*[@id='Email']")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL + "v")).perform();


	}

}
