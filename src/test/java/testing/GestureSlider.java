package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GestureSlider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/slider/default.html");
		Thread.sleep(2000);
		WebElement slider= driver.findElement(By.xpath(".//*[@id='slider']/span"));
		
		int width=slider.getSize().width;
		System.out.print(width);
		Actions action =new Actions(driver);
		action.dragAndDropBy(slider, 900, 0).perform();

	}

}
