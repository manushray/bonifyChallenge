package bonifyAppAutomation.bonifyAutomationApp;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import bonifyAppAutomation.bonifyAutomationApp.CodeBase.Base;
import bonifyAppAutomation.bonifyAutomationApp.Pages.FinancePage;

import bonifyAppAutomation.bonifyAutomationApp.Pages.LoginPage;

@Listeners(bonifyAppAutomation.bonifyAutomationApp.ExtentReportListener.ExtentReportNG.class)
public class FinancePageTest extends Base{
	
LoginPage loginpage;
FinancePage financepage;
	
	boolean flag;
	
	public FinancePageTest()
    {
        super();
    }
	
	 @BeforeMethod
		public void setUp() throws Exception {
			initialisation();
			loginpage = new LoginPage(); 
			financepage= new FinancePage();
			loginpage.loginpageErrormethod(prop.getProperty("email_id"),prop.getProperty("correct_user_password"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			financepage=loginpage.financelinkmethod();
			
			System.out.println("Code is coming in Before method");
		}
	 
/* Test Case for switiching into the multiple iframes and clicking one of the link present inside the iframe.
present inside the Insurance > Liability Insurance and clicking on the getsafe premium link */	 
	 @Test(priority=9)
	    public void loginPageTestCase() throws Exception
	    {
		 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 String title=financepage.creditcardmethod();

		 Assert.assertEquals(title,prop.getProperty("page_title_iframe_another_link")); 
	    }
	 
	 @AfterMethod
	 public void tearDown(ITestResult result) {
		 driver.quit();
	 }
	 
}
