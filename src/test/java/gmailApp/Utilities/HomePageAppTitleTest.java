package gmailApp.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gmailApp.Bases.*;
import gmailApp.Pages.HomePage_pg;

public class HomePageAppTitleTest extends Base{
	private HomePage_pg HomePage_pg;

//  @Test
//  public void HomePage() {
//	  System.out.println("Hello TestNG");
//    //throw new RuntimeException("Test not implemented");
//  }
	
//	public String baseURL = "http://newtours.demoaut.com/";
//	public WebDriver driver;
//	
//	  //public void Initialized(String BASE_URL)
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

	@BeforeTest
	public void setBaseURL() {
		//driver = new FirefoxDriver();
		Initialized();
		//driver.get(baseURL);
	}

	@Test
	public void verifyHomePageTitle() {
		
		try {
			String expectedTitle = "Welcome: Mercury Tours";
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			HomePage_pg.lnk_MyAccount.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}
