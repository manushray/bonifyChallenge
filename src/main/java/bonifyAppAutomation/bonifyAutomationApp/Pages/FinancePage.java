package bonifyAppAutomation.bonifyAutomationApp.Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import bonifyAppAutomation.bonifyAutomationApp.CodeBase.Base;

public class FinancePage extends Base {


	@FindBy(xpath="//a[contains(@href,'/my-products/insurance')]")
	WebElement creditcard;
	
	@FindBy(name="person")
	WebElement versichertepersonbtn;
	
	@FindBy(name="alter2")
	WebElement ihralterbtn;
	
	@FindBy(xpath="//div[contains(text(),'ja')]")
	WebElement jabtn;
	
	@FindBy(name="submit")
	WebElement submitbtn;
	
	@FindBy(xpath="//option[contains(text(),'Paar ohne Kind')]")
	WebElement versichertepersonValuebtn;
	
	@FindBy(xpath="//img[contains(@src,'/dist/9782c23964b791afd3e9f01d096c2efa.svg')]")
	WebElement liabilityInsurancebtn;

	@FindBy(xpath="//h3[contains(text(),'Tipp der Redaktion:')]")
	WebElement getsafebtn;
	
	public FinancePage() {
		PageFactory.initElements(driver, this);
		
		
	}

//	Method for navigation from creditcard link till liability insurance & switching into the iframes and calling the method for handle the newly open tab   
	public String creditcardmethod() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		creditcard.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		liabilityInsurancebtn.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);	
		driver.switchTo().frame(driver.findElement(By.id("vxcp_frame")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.className("fa_tipp-head")).click();		
		driver.switchTo().defaultContent();
		String title=newwindowhandlemethod();
		System.out.println("Value got from another tab is:"+" "+title);
		return title;
	}
}
