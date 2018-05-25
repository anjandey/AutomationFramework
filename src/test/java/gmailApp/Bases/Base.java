/**
 * 
 */
package gmailApp.Bases;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import gmailApp.Utilities.GenerateScreenshot;

import gmailApp.Pages.*;
import gmailApp.PageModelLib.*;

/**
 * @author anjan.k.dey
 *
 */
public abstract class Base {

	/**
	 * 
	 */

	public ExtentReports extent;
	public ExtentTest test;
	
	protected PageModel pageModel;

	public Base() {
		// TODO Auto-generated constructor stub
	}

	public String baseURL = "http://newtours.demoaut.com/";
	//public String baseURL = "https://imp.healthcare.gov/";
	public static WebDriver driver;
	
	protected HomePage_pg HomePage_pg;

	// public void Initialized(String BASE_URL)
	public void Initialized() {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Thread.sleep(5000);
		pageModel = new PageModel(driver);

	}

	@BeforeTest
	public void setUpTest() {
		Initialized();
		HomePage_pg = (HomePage_pg)pageModel.getPage(PageName.HOME_PAGE, false);
		startTestReport();

	}

	@AfterMethod
	public void getTestResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// String screenshotPath = GenerateScreenshot.CaptureScreenshot(driver,
			// test.getTest().getName());
			String screenshotPath = CaptureScreenshot(driver, test.getTest().getName());
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "ScreenshotBelow: " + test.addScreenCapture(screenshotPath));

		}
		extent.endTest(test);
	}

	@AfterTest
	public void GetResult() {
		endTest();
		endTestReport();
	}

	public By WaitForelementLoad(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Here we will wait until element is not visible, if element is visible then it
		// will return web element
		// or else it will throw exception
		WebElement element = wait
				// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
				.until(ExpectedConditions.visibilityOfElementLocated(ele));

		// if element found then we will use- In this example I just called isDisplayed
		// method
		boolean status = element.isDisplayed();

		// if else condition
		if (status) {
			System.out.println("===== WebDriver is visible======");
		} else {
			System.out.println("===== WebDriver is not visible======");
		}
		return ele;
	}

	public void WaitForElement(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Here we will wait until element is not visible, if element is visible then it
		// will return web element
		// or else it will throw exception

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void WaitForElementLoadAndGone(String by)
	// {
	// //Base.driver.ExecuteScript();
	// //Console.WriteLine("Waiting Started ");
	// WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS());
	// try
	// {
	// wait.Until(ExpectedConditions.ElementIsVisible(By.XPath(by)));
	// wait.Until(ExpectedConditions.InvisibilityOfElementLocated(By.XPath(by)));
	// }
	// catch (WebDriverTimeoutException te)
	// {
	// Console.WriteLine("Manually web timeout Caught: " + te.Message);
	// }
	// catch (TimeoutException te)
	// {
	// Console.WriteLine("Manually timeout Caught: " + te.Message);
	// }
	// finally
	// {
	// //Console.WriteLine();
	// }
	// }

	public void startTestReport() {

		// String currDate = DateTime.Now.ToString("MMddyyyy_HHmm");// C# code
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		// LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd_HHmm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		// extent = new ExtentReports (System.getProperty("user.dir")+"\\Reports\\"
		// +dtf.format(now) +".html");
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + getClass().getName() + dtf.format(now) + ".html");
		// extent = new ExtentReports (System.getProperty("user.dir")+"\\Reports\\" +
		// name + "_" + dtf.format(now) +"\\ExtentReport.html");
		// extent.addSystemInfo("Environment","Environment Name")
		extent.addSystemInfo("Host Name", "Anjan Dey").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Anjan Dey");
		// loading the external xml file (i.e., extent-config.xml) which was placed
		// under the base directory
		// You could find the xml file below. Create xml file in your project and copy
		// past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	// public void getResult(ITestResult result){
	// if(result.getStatus() == ITestResult.FAILURE){
	// test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	// test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	// }else if(result.getStatus() == ITestResult.SKIP){
	// test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	// }
	// // ending test
	// //endTest(test) : It ends the current test and prepares to create HTML report
	// extent.endTest(test);
	// }

	// public void getResult(ITestResult result){
	// if(result.getStatus() == ITestResult.FAILURE){
	// test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	// test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	// }else if(result.getStatus() == ITestResult.SKIP){
	// test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	// }
	// // ending test
	// //endTest(test) : It ends the current test and prepares to create HTML report
	// extent.endTest(test);
	// }

	public void endTest() {

		driver.quit();

	}

	public void endTestReport() {
		extent.flush();
		extent.close();
	}

	public static String CaptureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/ErrorScreenshots/" + screenshotName + ".png";
		File destination = new File(dest);
		// FileUtils.copyFile(source, destination);
		FileUtils.copyFile(source, destination);
		return dest;

	}

}
