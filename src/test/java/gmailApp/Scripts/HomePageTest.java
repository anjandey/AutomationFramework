package gmailApp.Scripts;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import gmailApp.Bases.Base;
import gmailApp.PageModelLib.PageName;
import gmailApp.Pages.HomePage_pg;
import gmailApp.Pages.*;

public class HomePageTest extends Base {
	
	 private HomePage_pg HomePage_pg;

//  @Test
//  public void HomePage() {
//	  System.out.println("Hello TestNG");
//    //throw new RuntimeException("Test not implemented");
//  }
	
//	public String baseURL = "http://newtours.demoaut.com/";
//	public WebDriver driver;
	
	  //public void Initialized(String BASE_URL)
//	  public void Initialized()
//      {
//      
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.get(baseURL);
//		driver.manage().window().maximize();
//  		//Thread.sleep(5000);
//  		
//      }

//	@BeforeTest
//	public void setBaseURL() {
//		//driver = new FirefoxDriver();
//		Initialized();
//		//driver.get(baseURL);
//		//startTestReport();	
//		
//	}

	@Test
	public void verifyHomePageTitle() {
		HomePage_pg = (HomePage_pg)pageModel.getPage(PageName.HOME_PAGE, false);
		test=extent.startTest("verifyHomePageTitle");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		//WaitForelementLoad(By.id("abc"));		
		HomePage_pg.lnk_MyAccount.click();
		
		//LoginPage_pg.lnk_MyAccount.click();
		Assert.assertEquals(actualTitle, expectedTitle);
		test.log(LogStatus.PASS, "Test Passed", expectedTitle);
		test.log(LogStatus.INFO, "verify Home Page Title and Test Passed");
		
	}

//	private void WaitForelementLoad(By id) {
//		// TODO Auto-generated method stub
//		
//	}

//	@AfterTest
//	public void endTest() {
//		driver.quit();
//	}
}
