package testing;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Surety {
	 static String Environment = "QA";
	 static String URL;
	 static String URLPortal;
	 
	// static WebDriver driver = new ChromeDriver();

	 
	 		 	
	 
	
	 
	 
	 
	 public void LoginIW(PhantomJSDriver driver) throws InterruptedException{ 
			driver.get(URL);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);					 
			driver.findElement(By.xpath("//*[@id='WebPartWPQ2']/div[6]/a/font")).click();
			Thread.sleep(1000);
			WebElement dropdown3 = driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_SuretyCertificateDD']"));
			Select select4 = new Select(dropdown3);
			select4.selectByValue(Environment);

			driver.findElement(By.xpath("//*[@id='ctl00_PlaceHolderMain_btnRedirect']")).click();
			Thread.sleep(1500);
			System.out.println("Logged into "+Environment+" Environment");
		    }
	 
	 public void LoginPOS(PhantomJSDriver driver) throws InterruptedException{
			//Log into Portal
		 	driver.get(URLPortal);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(".//*[@id='ctl00_RootContent_controlLogin_UserName']")).sendKeys ("Shalini");
			driver.findElement(By.xpath(".//*[@id='ctl00_RootContent_controlLogin_Password']")).sendKeys("Password1");
			WebElement element1 = driver.findElement(By.id("ctl00_RootContent_controlLogin_LoginButton"));
			element1.click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_RootContent_NavList']/li[6]/a")).click();
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_RootContent_MyPhlyRootContent_ContinueLink']")).click();
			Thread.sleep(1500);
			
			//Entering into Phly Bond Portal
			
			System.out.println("------------printing first window id----------");
			Set<String> winids =driver.getWindowHandles();
			Iterator<String> iterate=winids.iterator();
			String first_window= iterate.next();
			System.out.println(first_window);
			
			System.out.println("------------printing second window id----------");

			winids =driver.getWindowHandles();
			iterate=winids.iterator();
		    System.out.println(iterate.next()); // first window id
		    driver.close();
		    String second_window=iterate.next(); // second window id
		    System.out.println(second_window);
		    driver.switchTo().window(second_window);
		    Thread.sleep(2500);
	 }
	 
	 public void environment()
	 {
		 if (Environment == "QA")
			{
				 URL ="http://servicesqa.corp.tmnas.com/Pages/OneShield-Testing.aspx";
				 URLPortal="http://phlycomqa.phlytst.com/myphly/login.aspx?ReturnUrl=%2fmyphly%2fmyphly.aspx%3fnav%3dtop&nav=top";
			}
			else if(Environment == "ModelOffice")
			{
				 URL ="http://servicesqa.corp.tmnas.com/Pages/OneShield-Testing.aspx";
				 URLPortal="https://phlycommo.phlyinc.com/myphly/login.aspx?ReturnUrl=%2fmyphly%2fmyphly.aspx%3fnav%3dtop&nav=top";
			}
			else{
				URL = "http://phlysuppqa.oneshield.com/oneshield/GatewayServlet?TX_NAME=Action.2&TX_CTRL_CODE=1&EXCHANGE_ID=1218";
				URLPortal = "http://phlysuppqa.oneshield.com/oneshield/GatewayServlet?TX_NAME=Action.2&TX_CTRL_CODE=1&EXCHANGE_ID=1218";
			}	
			 
	 }
	 
	 	 
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		try{
		System.out.println("Surety");
		 DesiredCapabilities dcap = new DesiredCapabilities();
		 String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" };
		 System.out.println("coming here......");
		 dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		 
		 PhantomJSDriver driver = new PhantomJSDriver(dcap);
	System.out.println("coming here");
	/*					
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver(); 
		//WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();

		int Counter = 0;
		Surety ob1=new Surety();
	    ob1.environment();
	    
//start from here	    
	    //Log into Portal
	    ob1.LoginPOS(driver);
		  
	    WebElement dropdown = driver.findElement(By.xpath("//div[@title='Please select the action you would like to perform.']//following::div[1]//child::select[1]"));
		Select select = new Select(dropdown);
		select.selectByIndex(0);
	    driver.findElement(By.xpath(".//*[@id='1010227']")).click();
	     
	     //Enter Bond Details
	     
	     driver.findElement(By.xpath("//input[contains(@title,'Class Code')]")).click();
	     driver.findElement(By.xpath("//option[contains(@title,'Washington')]")).click();
	     driver.findElement(By.xpath("//input[@title='Please enter the Class Code or Description to use when searching.']")).sendKeys("935");
	     driver.findElement(By.xpath("//a[@title='Search']")).click();
	     driver.findElement(By.xpath("//option[contains(@title,'Auction Company')]")).click();
	     
	     //Check Bond Amount
	     //String bondamount = driver.findElement(By.xpath("//select[@title='Please select the Bond Amount.']")).getText();
	     Select select1 = new Select(driver.findElement(By.xpath("//select[@title='Please select the Bond Amount.']")));
	     String option = select1.getFirstSelectedOption().getText();
	     
	     System.out.println("\n Bond Amount is "+option+"\n");
		     
	     if(option.contains("$5,000"))
	     {
	    	 System.out.println("Default Bond Amount selected is correct as $5000.00");
	     }
	     else
	     {
	    	 System.out.println("Default Bond Amount selected is incorrect");
	     }
	     		     
	     //Check Default Obligee selection
	     String obligeeLookup= driver.findElement(By.xpath("//*[text()[contains(.,'Washington State Business and Professions Division')]]")).getText();
	     if (obligeeLookup.contains("Washington State Business and Professions Division"))
	     {
	    	 System.out.println("Default Obligee is 'Washington State Business and Professions Division, Department of Licensing'");
	     }
	     else 
	     {
	    	 System.out.println("Default Obligee Check Failed");
	     }
	     //Set Effective and Expiration Date
	     
	     DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	     Date date = new Date();
	     String date1= dateFormat.format(date);
	     
	     driver.findElement(By.xpath("//input[@title='Bond Effective Date']")).clear();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@title='Bond Effective Date']")).sendKeys(date1);
	     System.out.println("Bond Effective Date: "+date1);
	     driver.findElement(By.xpath("//input[@title='Bond Expiration Date']")).sendKeys("");
	     
	     driver.findElement(By.xpath(".//*[@id='1045527']")).click();
		     
	     //Enter Applicant Information
	     driver.findElement(By.xpath("//input[@title='Last Name']")).sendKeys("SLOTT");
	     driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("ARLEEN");
	     driver.findElement(By.xpath("//input[@title='Address Line 1']")).sendKeys("411 N SAMPSON");
	     driver.findElement(By.xpath("//input[contains(@title,'Zone Improvement')]")).sendKeys("98926");
	     driver.findElement(By.xpath("//input[@title='City']")).sendKeys("Ellensburg");
	     Thread.sleep(5000);          
	     WebElement dropdown1 = driver.findElement(By.xpath("//div[@title='State']//following::div[1]//child::select[1]"));
		 Select select2 = new Select(dropdown1);
		 select2.selectByValue("48");
	     
		 driver.findElement(By.xpath("//input[@title='County']")).sendKeys("Kittitas");
		 
		 //check override box
		 
		 //driver.findElement(By.xpath("//div[contains(@title,'Address Verification']//following::span[1]//child::input[1]")).click();
		 List<WebElement> override= driver.findElements(By.xpath("//input[@type='checkbox']"));
	     override.get(0).click();
     
		 driver.findElement(By.xpath(".//*[@id='1030327']")).click();
		 		 		
		 //click on New Principal
		 driver.findElement(By.xpath(".//*[@id='1009627']")).click();
		
		 //Eligibility questions
		 driver.findElement(By.xpath(".//*[@id='ext-gen1072']")).click();
		 //WebElement EligQues = driver.findElement(By.xpath("//div[contains(@title='Has there ever been a claim or legal action against')]//following::div[1]//child::select[1]"));
		 //Select select3 = new Select(EligQues);
		 //select3.selectByValue("48");
		 List<WebElement> auth= driver.findElements(By.xpath("//input[@type='checkbox']"));
	     auth.get(2).click();
	     driver.findElement(By.xpath(".//*[@id='1036127']")).click();
     
	     //Fill Indemnitor Information
	     driver.findElement(By.xpath("//input[@title='No']")).click();
	     driver.findElement(By.xpath("//input[contains(@title,'Ownership')]")).sendKeys("100");
	     driver.findElement(By.xpath(".//*[@id='1030827']")).click();
			  
	     //Submission Number Generated
	     String SubmissionNumber= driver.findElement(By.xpath(".//*[@id='ext-gen1053']//child::div[2]//child::div")).getText();
	     System.out.println("Bond Submission Number is : "+SubmissionNumber);
	  
//till here 	
	     //String SubmissionNumber="26473990338";
	     
	     //Log into Surety IW
	     ob1.LoginIW(driver);
	 	       
		//Search for Submission Number		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'listSearchText')]")).sendKeys(SubmissionNumber);
		
		//Click on Go
		//driver.findElement(By.xpath(".//*[@id='ext-gen1036']")).click();
		driver.findElement(By.partialLinkText("Go")).click();
		Thread.sleep(3000);
					
		//select first one : Submission Number
		WebElement element = driver.findElement(By.xpath(".//*[@id='gridview-1031']/table/tbody/tr[2]/td[1]/div//child::a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
						
		//Accept & override the referrals (Rate Bond)
		driver.findElement(By.xpath(".//*[@id='ext-gen1023']/span")).click(); //Bond Details		
		if (driver.findElement(By.xpath(".//*[@id='1035327']")).isDisplayed()) //Rate Bond
		{
			driver.findElement(By.xpath(".//*[@id='1035327']")).click();
		};
		
		driver.findElement(By.xpath("//textarea[@title='Underwriter Comment']")).sendKeys ("Testing");
		Thread.sleep(3000);
		WebElement dropdown4 = driver.findElement(By.xpath(".//select[contains(@title,'Overridden')]"));
		Select select5 =new Select(dropdown4);
		select5.selectByValue("1");
		
		//Handling JavaScript alert
		
		//driver.findElement(By.partialLinkText("Accept")).click();		
		//driver.switchTo().alert().accept();
		WebElement alertElement = driver.findElement(By.partialLinkText("Accept"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertElement);
 
		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.accept();		
						
		//Generate Task
		driver.findElement(By.xpath(".//input[(@id='ext-gen1060') or (@title='No')]")).click();		
		driver.findElement(By.linkText("Next")).click();
		//Thread.sleep(3000);
		
		boolean POSenabled=driver.findElement(By.linkText("Send POS Approval")).isDisplayed();
		if (POSenabled == false)
		{
			Thread.sleep(3000);
		};
		String ratingTier= driver.findElement(By.xpath(".//*[@id='ext-gen1022']//child::div[1]//following::div[2]")).getText();
		System.out.println(" Rating Tier is "+ratingTier);
				
		String TotalPremium= driver.findElement(By.xpath(".//div[text()[contains(.,'Total Premium')]]//following::div[1]//child::div[1]")).getText();
		System.out.println(" Total Premium is "+TotalPremium);
		
		String Classcode= driver.findElement(By.xpath(".//div[text()[contains(.,'Class Code Rate')]]//following::div[1]//child::div[1]")).getText();
		System.out.println(" Class Code Rate is "+Classcode);
		
		//Send POS Approval
		driver.findElement(By.linkText("Send POS Approval")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//div[@id='ext-gen1058']//following::a[1]")).click();

		//Home Page :Checking Bond Status from Rated to Referred
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'listSearchText')]")).sendKeys(SubmissionNumber);
		
		//Click on Go
		driver.findElement(By.partialLinkText("Go")).click();
		Thread.sleep(1000);
					
		//select first one : Submission Number
		WebElement element11 = driver.findElement(By.xpath(".//*[@id='gridview-1031']/table/tbody/tr[2]/td[1]/div//child::a[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element11);
		
		String status=driver.findElement(By.xpath(".//div[text()[contains(.,'Status')]]//following::div[2]")).getText();
		System.out.println(status);
		if (status.equals("Bond Rated"))
		{
			System.out.println("Bond status is changed to Bond Rated");
		}
		else{
			System.out.println("Bond status is NOT changed to Bond Rated");
		}
		driver.findElement(By.xpath(".//*[@id='ext-gen1011']//following::a[1]")).click();

		//String SubmissionNumber="26512938038";
	
		// Login Surety Portal 
		ob1.LoginPOS(driver);
		
	    driver.findElement(By.xpath(".//*[@id='listSearchText_964746']")).sendKeys(SubmissionNumber);
		
		//Click on Go
		driver.findElement(By.xpath(".//*[@id='listSearchText_964746']//following::a[1]")).click();
		Thread.sleep(4000);
					
		//select first one : Submission Number
		WebElement element3 = driver.findElement(By.xpath(".//*[@title='Submission Number']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element3);
		
		//Email Selection
		WebElement dropdown5 = driver.findElement(By.xpath(".//select[contains(@title,'Please select the Agency Email Address where the bond forms should be sent')]"));
		Select select6 =new Select(dropdown5);
		select6.selectByValue("999");	//Other
		Thread.sleep(2000);		
		driver.findElement(By.xpath(".//input[contains(@title,'Please enter the Other Agency Email Address where the bond forms should be sent')]")).sendKeys("nisha.balodi@tmnas.com");
		
		//Execute Bond and fetch Bond Number
		driver.findElement(By.xpath(".//div[@id='ext-gen1030']//child::a[1]")).click();
		Thread.sleep(6000);
		String BondNumber= driver.findElement(By.xpath(".//div[text()[contains(.,'Bond Number')]]//following::div[1]//child::div[1]")).getText();
		System.out.println("Bond Number is "+BondNumber);

	    //String BondNumber="26512938038";
	    
		//Login into IW
		ob1.LoginIW(driver);
		 	       
		//Search for Bond Number		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'listSearchText')]")).sendKeys(BondNumber);
		
		//Click on Go
		//driver.findElement(By.xpath(".//*[@id='ext-gen1036']")).click();
		driver.findElement(By.partialLinkText("Go")).click();
		Thread.sleep(3000);
					
		//select first one : Bond Number
		WebElement element4 = driver.findElement(By.xpath(".//*[@id='gridview-1031']/table/tbody/tr[2]/td[1]/div//child::a[1]"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", element4);

		// Verify New Bond Transaction
		driver.findElement(By.xpath(".//*[@title='Transaction Type']")).click();
		
		//Verify forms (add code)
		driver.findElement(By.xpath(".//*[@id='ext-gen1027']/span")).click();
		
		if(driver.findElement(By.xpath(".//*[@id='contentColumnData']")) != null)
		{
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		// click on Advanced Search
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Label_26422514038_15003746"))).click();
				// wait.until(ExpectedConditions.visibilityOf(By.xpath(".//*[@id='Label_26436925538_15003746']")).click();
				TakesScreenshot ts101 = (TakesScreenshot) driver;
				File source101 = ts101.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source101, new File("C:/Headless/name1.png"));
				
				
				//Fetch Account ID
		String AccountID= driver.findElement(By.xpath(".//div[text()[contains(.,'PATH Account ID')]]//following::div[1]//child::div[1]")).getText();
		System.out.println("PATH Account ID is "+AccountID);
				
				
		*/
		
		/*
		//Email Selection
		WebElement dropdown5 = driver.findElement(By.xpath(".//select[contains(@title,'Please select the user from whom the email should be sent')]"));
		Select select6 =new Select(dropdown5);
		select6.selectByValue("1");		//Existing User
		
		WebElement dropdown6 = driver.findElement(By.xpath("Please select the Agency Email Address where the bond forms should be sent"));
		Select select7 =new Select(dropdown6);
		select7.selectByValue("999");	//Other
		Thread.sleep(2000);		
		driver.findElement(By.xpath(".//input[contains(@title,'Please enter the Other Agency Email Address')]")).sendKeys("nisha.balodi@tmnas.com");
		*/
		
		
		// driver.manage().deleteAllCookies();
		// driver.close();
		// driver.quit(); */
		
		} //try block
		
			finally{}	
		
		/*finally{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String date = sdf.format(new Date());
//			TakesScreenshot ts101 = (TakesScreenshot) driver;
//			File source101 = ts101.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(source101, new File("C:/Headless/name1.png"));
//			
//			   driver.manage().deleteAllCookies();
//			   driver.close();
//			   driver.quit();
		}*/

	}


}
