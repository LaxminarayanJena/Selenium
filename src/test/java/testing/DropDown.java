package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		WebElement dropdown = driver.findElement(By.xpath(".//*[@id='searchLanguage']"));
		Select select = new Select(dropdown);
		select.selectByValue("hi");
		Thread.sleep(3000);
		select.selectByVisibleText("Deutsch");
		// select.getOptions()

		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("no of drop down values are: " + values.size());
		System.out.println(values.get(0));
		// [[ChromeDriver: chrome on XP (fa68d6dc7f2ef5512c92f417a77295c3)] ->
		// tag name: option]

		System.out.println(values.get(1));
		System.out.println(values.get(0).getAttribute("lang"));
		// ar

		for (int i = 1; i < values.size(); i++) {
			System.out.println(values.get(i).getText());
		}
		// note- above code is working because there is only 1 dropdown
		// all option names get displayed

		// -------------------------finding total no of links in entire page ---
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("no of links in website  are: " + links.size());

		for (WebElement link : links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}

		// -------------------------finding total no of links in a particular block---
		System.out
				.println("----finding total no of links in a particular block-----------");
		WebElement block = driver.findElement(By
				.xpath(".//*[@id='www-wikipedia-org']/div[6]/div[3]"));

		List<WebElement> blocklinks = block.findElements(By.tagName("a"));
		// findElement is implemented inside WebDriver as well as WebElement

		System.out.println("no of links inside block only  are: "
				+ blocklinks.size());

		for (WebElement blocklink : blocklinks) {
			System.out.println(blocklink.getText());
			System.out.println(blocklink.getAttribute("href"));
		}

		driver.quit();

	}

}
