package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static void main(String[] args) {
	/*	1)driver.switchTo().frame(name_or_id)
                2)driver.switchTo().frame(index)
                          driver.switchTo().frame(0)
                3)driver.switchTo().frame(iframe_element)
                          driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Fill Quote']")));
         */
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		driver.manage().window().maximize();
		
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		System.out.println("total frame size is " + frames.size());
		for(WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("id"));
		}
		//driver.manage().timeouts().implicitlyWait(5L,TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		
		
		driver.findElement(By.xpath("html/body/form/input[3]")).click();
		driver.switchTo().defaultContent();
	}

}
