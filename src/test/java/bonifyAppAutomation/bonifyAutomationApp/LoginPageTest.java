package bonifyAppAutomation.bonifyAutomationApp;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bonifyAppAutomation.bonifyAutomationApp.CodeBase.Base;
import bonifyAppAutomation.bonifyAutomationApp.Pages.LoginPage;

@Listeners(bonifyAppAutomation.bonifyAutomationApp.ExtentReportListener.ExtentReportNG.class)
public class LoginPageTest extends Base 
{
	LoginPage loginpage;
	
	boolean flag;
	
	static String title=" ";
	
	public LoginPageTest()
    {
        super();
    }
	
	 @BeforeMethod
		public void setUp() throws Exception {
			initialisation();
			log.info("Class LoginPageTest > Before method has been invoked ");
			loginpage = new LoginPage(); 
	
		}
//This is a Test Case for User if user is new or an existing one
	 @Test(priority=1)
	    public void loginPageTestCase() throws Exception
	    {
		 flag=loginpage.loginpageErrormethod(prop.getProperty("email_id"), prop.getProperty("user_password_correct"));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		if(flag=true) {
			System.out.println("New User");
			Assert.assertEquals(flag, true);
		}
	 else {
		 System.out.println("User already exist");
		  title=loginpage.homepagemethod();
		 Assert.assertEquals(title,prop.getProperty("email_id"));
		 System.exit(0);
	 }
	    }

//This is a Test Case for filling out the registration form for new user along with checking the password Strength like min. 8 character length, a number & a special character by regex expression
	 @Test(priority=2)
	    public void loginPageRegistrationPageTitleTestCase() throws Exception
	    {
		
	   flag=loginpage.loginpageErrormethod(prop.getProperty("email_id"), prop.getProperty("user_password_negative_value"));

	   if(flag==true) {
			 boolean newflag=loginpage.registerationmethod(prop.getProperty("email_id"), prop.getProperty("user_password_negative_value"));
			Assert.assertEquals(newflag, true);
		 }
	   
	    }
		
//Whether with correct credentials user has logged into the application correctly by validating from the email id shown in the home page	 
	 @Test(priority=3)
	    public void loginPageRegistrationTestCase() throws Exception
	    {
		
	   flag=loginpage.loginpageErrormethod(prop.getProperty("email_id"), prop.getProperty("correct_user_password"));
		 if(flag==false) {
			  title=loginpage.homepagemethod();
			Assert.assertEquals(title, prop.getProperty("email_id"));
		 }
		
		 }
//Test Case of forget button link	    
	 @Test(priority=4)
	    public void forgetpassbtnMethod() throws Exception
	    {
		   String urlname=loginpage.forgetpassmethod();
		   System.out.println("value of returned URL is:"+" "+urlname);
		
		   Assert.assertEquals(urlname,prop.getProperty("forget_password_URL"));
		 }

//Test Case of Imprint button link
	 @Test(priority=5)
	    public void imprintbtnMethod() throws Exception
	    {
		    title=loginpage.imprintmethod();
		   System.out.println("value of returned Imprint URL is:"+" "+title);
		   Assert.assertEquals(title,prop.getProperty("page_title_Imprint"));
		 }
	 
//Test Case of Condition button link	 
	 @Test(priority=6)
	    public void conditionsbtnMethod() throws Exception
	    {
		    title=loginpage.conditionmethod();
		   System.out.println("value of returned Conditions URL is:"+" "+title);
		   
		   Assert.assertEquals(title,prop.getProperty("page_title_Conditions"));
		 }
	 
//Test Case for Data Protection link	 
	 @Test(priority=7)
	    public void dataprotectionbtnMethod() throws Exception
	    {
		    title=loginpage.dataprotectionmethod();
		   System.out.println("value of returned Data Protection URL is:"+" "+title);
		   Assert.assertEquals(title,prop.getProperty("page_title_Data_Protection"));
		 }
//Test Case for Image shown at the bottom of the login page.
	 @Test(priority=8)
	    public void logosecuritypartnerMethodTest() throws Exception
	    {
		   boolean flag=loginpage.logosecuritypartnermethod();
		   Assert.assertEquals(flag,true);
		 }
	 
	  @AfterMethod
	    public void tearDown(ITestResult result) {
	    	driver.quit();
	    }
   
}
