package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static void main(String[] args) {
		
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
