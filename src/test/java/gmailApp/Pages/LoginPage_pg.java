package gmailApp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_pg {
 static WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using = ".//*[@id='account']/a")
 
	public static WebElement lnk_MyAccount;

}
