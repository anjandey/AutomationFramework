package gmailApp.PageModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import gmailApp.Pages.*;
//import gmailApp.Pages.HomePage_pg;
//import gmailApp.Pages.LoginPage_pg;

public class PageModel 
{
	
	WebDriver driver;
    //Home Page
    private HomePage_pg homePage;
    private LoginPage_pg loginPage;
    
    public PageModel(WebDriver driver)
    {
        this.driver = driver;
        //Home Page
        this.homePage = new HomePage_pg();
       // this.homePage = new HomePage_pg();
        this.loginPage = new LoginPage_pg();

 
        //Reports Page

        initPageElements();
    }

    private void initPageElements()
    {
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);

    }

    public Page getPage(PageName pageName, Boolean initialize)
    {
        switch (pageName)
        {
            case HOME_PAGE:
                if (!initialize)
                {
                    return (Page) homePage;
                }
                else
                {
                    this.homePage = new HomePage_pg();
                    PageFactory.initElements(driver, homePage);
                    return (Page) homePage;
                }
                

            case LOGIN_PAGE:
                if (!initialize)
                {
                    return (Page) loginPage;
                }
                else
                {
                    this.loginPage = new LoginPage_pg();
                    PageFactory.initElements(driver, loginPage);
                    return (Page) loginPage;
                }


            default:
            	return (Page) homePage;
        }
    }
}


