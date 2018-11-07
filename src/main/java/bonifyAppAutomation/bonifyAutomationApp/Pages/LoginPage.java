package bonifyAppAutomation.bonifyAutomationApp.Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import bonifyAppAutomation.bonifyAutomationApp.CodeBase.Base;

public class LoginPage extends Base {
	
	static String title=" ";
	
	//Used Page Factory for identifying the element for better maintainability of the code.
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement registrationbtn;
	
	@FindBy(xpath = "//a[contains(@href,'/register/email')]")
	WebElement registerbtn;
	
	@FindBy(className ="general-error")
	WebElement errorMessage;
	
	@FindBy(className ="error")
	WebElement errorMessageRegisterPage;
	
	@FindBy(xpath = "//div[contains(@class,'dropdown-label')]")
	WebElement nameconfirmation;
	
	@FindBy(xpath = "//a[contains(@href,'/recover')]")
	WebElement forgetpassbtn;

	@FindBy(xpath = "//a[contains(@href,'http://bonify.de/impressum')]")
	WebElement imprintbtn;
	
	@FindBy(xpath = "//a[contains(@href,'http://bonify.de/agb')]")
	WebElement conditionbtn;
	
	@FindBy(xpath = "//a[contains(@href,'http://bonify.de/datenschutz')]")
	WebElement dataprotectionbtn;
	
	@FindBy(className = "l-titlebar-content")
	WebElement imprintpageclick;
	
	@FindBy(xpath="//img[contains(@src,'/dist/a0a1881e5f582f55db453aea5316c00e.png')]")
	WebElement logoofSecurityPartners;
	
	@FindBy(xpath="//a[contains(@href,'/my-products/financial-products/debit-cards')]")
	WebElement financelinkbtn;
	

	public LoginPage() {
		
		PageFactory.initElements(driver, this);//this is pointing to current class object
	}


	
	//login page method , Where user will login and method will check if username/password is correct or not.
	public boolean loginpageErrormethod(String userid, String pwd) throws Exception {
		boolean flag = true;
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		username.sendKeys(userid);
		password.sendKeys(pwd);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		registrationbtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		try {
		if(errorMessage.isEnabled()) {
		flag=true;
		}}
		catch(Exception e) {
			System.out.println("Values are getting changed in try-catch");
			flag = false;
			System.out.println("Final Value of Flag is :"+" "+flag);
			
		}
		return flag;
	}
	
	
	//This is a method for filling out the registration form for new user along with checking the password Strength like min. 8 character length, a number & a special character by regex expression
	public boolean registerationmethod(String userid,String pwd) throws InterruptedException {
		boolean flag = false;
		registerbtn.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		username.sendKeys(userid);
		if(!pwd.matches("^[A-Za-z0-9@$!%*#?&]{8,}$")) {
			password.sendKeys(pwd);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(errorMessageRegisterPage.isEnabled())
		{
			System.out.println("Passing new password with Correct character strength");
			password.clear();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(prop.getProperty("correct_user_password").matches("^[A-Za-z0-9@$!%*#?&]{8,}$")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				password.sendKeys(prop.getProperty("correct_user_password"));
			registrationbtn.click();
			flag=true;
			System.out.println("Changing the value of flag from false to:"+" "+flag);
			}
			else {
				System.out.println("Password doesnt follow the rules, so again check & re-enter the password");
			}
		}
		}
		return flag;
	}
	
	//This method will return the user-id from the home page of existing user confirming whether the user has logged in correctly or not 
	public String homepagemethod() {
		String name=nameconfirmation.getText();
		return name;
	}
	
	//This method will click and get the newly open tab URL of the forget password link 
	public String forgetpassmethod() throws InterruptedException {
		forgetpassbtn.click();

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	}

	//This method will click and get the newly open tab's page title from page source of the Imprint link 
	public String imprintmethod() throws InterruptedException {
		
		imprintbtn.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 title = newwindowhandlemethod();
		return title;
	}

	//This method will click and get the newly open tab's page title from page source of the Condition link
	public String conditionmethod() throws InterruptedException {
		conditionbtn.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 title = newwindowhandlemethod();
		return title;
	}
	
	//This method will click and get the newly open tab's page title from page source of the Data Protection link
	public String dataprotectionmethod() throws InterruptedException {
		dataprotectionbtn.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		 title = newwindowhandlemethod();
		return title;
		
	}
	
	//This method will check whether the logo at the bottom of the login page is displayed or not.
	public boolean logosecuritypartnermethod() {
		return logoofSecurityPartners.isDisplayed();
	}
	
	//This method will check the element in Finance-To Offer link(Credit Comparison)
	public FinancePage financelinkmethod() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//span[contains(text(),'Zum Angebot')]")).click();
	
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);


		return new FinancePage();
	}
}
