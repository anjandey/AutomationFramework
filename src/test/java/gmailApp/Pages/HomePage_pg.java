/**
 * 
 */
package gmailApp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import gmailApp.PageModelLib.Page;

/**
 * @author anjan.k.dey
 *
 */
public class HomePage_pg implements Page {

	/**
	 * 
	 */
	public static WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using = ".//*[@id='account']/a")
 
	public WebElement lnk_MyAccount;
 
	 @FindBy(how = How.ID, using = "log")
 
	 public static WebElement txtbx_UserName;
 
	 @FindBy(how = How.ID, using = "pwd")
 
	 static WebElement txtbx_Password;
 
	 @FindBy(how = How.NAME, using = "submit")
 
	 static WebElement btn_Login ;
 
	 @FindBy(how = How.XPATH, using = ".//*[@id='account_logout']/a")
 
	 static WebElement lnk_LogOut;

}
