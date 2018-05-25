package gmailApp.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class GenerateExtentReport
{
    ExtentReports extent;
    ExtentTest test;
    public static WebDriver driver;
         
    @BeforeTest
    public void startReport()
    {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd_HHmm");  
		   LocalDateTime now = LocalDateTime.now(); 
		   System.out.println(dtf.format(now));  
		   String name = new Object(){}.getClass().getEnclosingMethod().getName();
		   System.out.println(name);

		//extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		   extent = new ExtentReports (System.getProperty("user.dir")+"/Reports/" + getClass().getName()+ dtf.format(now) +".html");
		//extent.addSystemInfo("Environment","Environment Name")
    	//
        //extent = new ExtentReports(System.getProperty("user.dir") +"/Reports/MyOwnReport.html", false);
        extent
        .addSystemInfo("Host Name", "Anjan")
        .addSystemInfo("Environment", "QA")
        .addSystemInfo("User Name", "Anjan Dey");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }
     
    @Test
    public void MydemoReportPass()
    {
        test=extent.startTest("MydemoReportPass");
        Assert.assertTrue(true);
        test.log(LogStatus.PASS, "Assert Pass as condition is True");
    }
   
    @Test
    public void MydemoReportFail()
    {
        test=extent.startTest("MydemoReportFail");
        Assert.assertTrue(false);
        test.log(LogStatus.FAIL, "Assert Fail as condition is False");
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
        	String screenshotPath = CaptureScreenshot(driver, test.getTest().getName());
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL,  "ScreenshotBelow: "+ test.addScreenCapture(screenshotPath));
            
             
        }
        extent.endTest(test);
    }
    
    public static String CaptureScreenshot(WebDriver driver, String screenshotName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	String dest = System.getProperty("user.dir")+"/ErrorScreenshots/"+screenshotName+".png";
    	File destination = new File(dest);
    	//FileUtils.copyFile(source, destination);
    	FileUtils.copyFile(source, destination);
    	return dest;
    	
    }
     
    @AfterTest
    public void endreport()
    {
        extent.flush();
        extent.close();
    }
}