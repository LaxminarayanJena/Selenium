import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
		WebElement tbl = driver.findElement(By.id("example"));

		//--------------find no of rows and cols--------------------------------
		List<WebElement> rows = tbl.findElements(By.tagName("tr"));
        List<WebElement> cols =tbl.findElements(By.tagName("th"));
		
        System.out.println("no of rows - " + (rows.size()-1));
		System.out.println("no of cols - " + cols.size());
		
		
		//----------------Find text of 5th row and 3rd col-----------------------
		
		String specificcell_value=driver.findElement(By.xpath("//tr[5]//td[3]")).getText();
		System.out.println(specificcell_value);
		
		//--------------print entire table data---------------------------------
		
		for (WebElement tdata: driver.findElements(By.tagName("tr"))) {
			   //System.out.println(tdata.getText());
			  }
		
		//--------------print specific col---------------------------------
		
				for (WebElement tdata: driver.findElements(By.xpath("//td[4]"))) {
					   //System.out.println(tdata.getText());
					  }
				
				
		//--------------print specific row value  on specific  row data---------------------------------
		//--------------print name whose age is 37 ---------------------------------
		
				System.out.println("name whose age is 37:");
				List allRows= driver.findElements(By.tagName("tr"));
				for(int i=1;i<allRows.size();i++)
				{
				     WebElement age=driver.findElement(By.xpath("//tr["+i+"]/td[4]"));
				     if(age.getText().equals("37"))
				     {
					WebElement name=driver.findElement(By.xpath("//tr["+i+"]/td[1]"));
					System.out.println(name.getText());
				     }
				}
		
				//--------------print entire row value  on specific  row data---------------------------------
				//--------------print entire row  whose age is 37 ---------------------------------
				
						System.out.println("name whose age is 37:");
						List allRows1= driver.findElements(By.tagName("tr"));
						for(int i=1;i<allRows1.size();i++)
						{
						     WebElement age=driver.findElement(By.xpath("//tr["+i+"]/td[4]"));
						     if(age.getText().equals("37"))
						     {
						    	 for (WebElement tdata: driver.findElements(By.xpath("//tr["+i+"]"))) {
									   System.out.println(tdata.getText());
									  }
						     }
						}
				
}
}