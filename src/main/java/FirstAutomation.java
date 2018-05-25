import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 */

/**
 * @author anjan.k.dey
 *
 */
public class FirstAutomation {
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\\\Selenium\\\\Drivers\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		//String actualTitle = driver.getTitle();
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("mercury");
		
		driver.findElement(By.name("password")).sendKeys("mercury");
		Thread.sleep(5000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

}
