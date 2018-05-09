package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rightclick {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		WebElement rc= driver.findElement(By.xpath("//p[2]/img"));
		Actions action =new Actions(driver);
		action.contextClick(rc).perform();
		//right click
		
		
		WebElement menu=driver.findElement(By.xpath(".//*[@id='dm2m1i1tdT']"));
		Actions action1 =new Actions(driver);
		action1.moveToElement(menu).perform();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dm2m1i1tdT']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dm2m2i1tdT']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dm2m3i0tdT']"))).click();	

	}

}
