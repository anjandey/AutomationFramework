package gmailApp.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveAppID {
	 @Test
	 public void HomePage() {
//		  System.out.println("Hello TestNG");
	//   //throw new RuntimeException("Test not implemented");
	 }
		
		//public String baseURL = "http://newtours.demoaut.com/";
		public String baseURL = "https://imp.healthcare.gov/";
		public WebDriver driver;
		
		  //public void Initialized(String BASE_URL)
		  public void Initialized()
	     {
	     
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();
	 		//Thread.sleep(5000);
	 		
	     }

		@BeforeTest
		public void setBaseURL() throws Exception {
			//driver = new FirefoxDriver();
			Initialized();
			driver.get(baseURL);
			Thread.sleep(3000);	
			//HomePage_pg.lnk_Login.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@class='header-link' and @href='/login']")).click();
			//HomePage_pg.lnk_Login.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='username']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name='username']")).sendKeys("adey@yopmail.com");
			//HomePage_pg.txtbx_UserName.sendKeys("adey@yopmail.com");
			driver.findElement(By.xpath("//*[@name='password']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Poonam9228");
			//HomePage_pg.txtbx_Password.sendKeys("Poonam9228");
			Thread.sleep(1000);
			//
			driver.findElement(By.xpath(".//*[@id='main-body-content']/div/div/div/form/div[5]/div")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='headerUserName']/strong")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='landingPageMenuLink']")).click();
			//*[@id='landingPage_ActiveApplicationsList']/li/div[2]/div/button
			
			WebElement btnRemove = driver.findElement(By.xpath("//*[@id='landingPage_ActiveApplicationsList']/li/div[2]/div/button"));
			if (btnRemove.isDisplayed())
			{
				btnRemove.click();	
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='mainLanguage']/body/div[6]/div[2]/div/div[2]/div/button[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='mainLanguage']/body/div[6]/div[2]/div/div[2]/div/button[3]")).click();
			}
			else
			{
			
			Thread.sleep(2000);
			WebElement yearSelect=driver.findElement(By.xpath("//*[@id='yearDropdownview38']"));
			
			//WebElement wannabeSelect = sDriver.findElement(By.id("foo"));
			 Select selectEle = new Select(yearSelect);
			 selectEle.selectByValue("2018");
			 
				WebElement stateSelect=driver.findElement(By.xpath("//*[@id='stateDropdownview37']"));
				
				//WebElement wannabeSelect = sDriver.findElement(By.id("foo"));
				 Select selectStateEle = new Select(stateSelect);
				 selectStateEle.selectByValue("DE");
			//*[@id='yearDropdownview38']
			//startTestReport();
			}
			
		}

}
