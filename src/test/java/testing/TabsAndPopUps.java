package testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TabsAndPopUps {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='cee_closeBtn']/img")).click();

		/*------------	NEW CODE----------
		Set<String> handles=driver.getWindowHandles();
		ArrayList<String> ar= new ArrayList<String>(handles);
		System.out.print(ar);
		driver.switchTo().window(ar.get(2));
		
		
		
		
		
		*/
		System.out.println("------------printing first window id----------");
		Set<String> winids = driver.getWindowHandles();
		//Set is like list but stores unique values		
		Iterator<String> iterate = winids.iterator();
		
		// winids.iterator() returns Iterator<String>
		String first_window = iterate.next();
		// interate.next-1st window
		// 2 times iterate.next gives 2nd window id
		//.next() returns String
		System.out.println(first_window);
		
		driver.findElement(By.xpath(".//*[@id='loginsubmit']")).click(); 
		// clicking on login button
												
		System.out.println("------------printing second window id----------");

		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		
	/*	we have removed the datatype since it is already declared above oterhwise rename error
	 * int x=200;
		   x=200;
		   */
		
		System.out.println(iterate.next()); // first window id
		String second_window = iterate.next(); // second window id
		System.out.println(second_window);
		driver.switchTo().window(second_window);
		driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/a")).click(); 
		// clicking on apply now
																		
		System.out.println("------------printing third window id----------");
		
       // hdfc website got changed ....3rd window doesnot appear now
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		System.out.println(iterate.next()); // first window id
		System.out.println(iterate.next()); // second window id
		String third_window = (iterate.next());
		System.out.println(third_window);// third window id

		driver.switchTo().window(third_window);
		WebElement dropdown = driver.findElement(By
				.xpath(".//*[@id='eForm_form_propertyCity_value']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Ghaziabad");

		driver.close();
		driver.switchTo().window(second_window);
		driver.close();
		driver.switchTo().window(first_window);
		driver.close();

	}

}
