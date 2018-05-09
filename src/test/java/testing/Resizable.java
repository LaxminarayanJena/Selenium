package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/resizable/default.html");
WebElement rs= driver.findElement(By.xpath(".//*[@id='resizable']/div[3]"));
Thread.sleep(2000);
Actions action = new Actions(driver);
action.dragAndDropBy(rs, 400, 800).perform();;

	}

}
