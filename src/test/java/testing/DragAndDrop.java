package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		WebElement draggable= driver.findElement(By.xpath(".//*[@id='draggable']"));
		WebElement droppable= driver.findElement(By.xpath(".//*[@id='droppable']"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action =new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();

	}

}
