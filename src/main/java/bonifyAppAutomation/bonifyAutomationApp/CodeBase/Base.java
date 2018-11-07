package bonifyAppAutomation.bonifyAutomationApp.CodeBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log= LogManager.getLogger(Base.class);
	
	
	//Constructor using for reading the config.properties file
	public Base(){
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		try {
			prop =new Properties();
			String dir_path =System.getProperty("user.dir");
			FileInputStream ip= new FileInputStream(dir_path+"/src/main/java/bonifyAppAutomation/bonifyAutomationApp/Configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method used to initialise the Browser and launching the URL 
	public static void initialisation() throws Exception {
		
		
		String browserName=  prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions coptions = new ChromeOptions();
			coptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(coptions);
		}else if(browserName.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		log.info("Class Base > initialisation method has been invoked ");
		driver.get(prop.getProperty("url"));

		

		
	}
	
	//This method will handle any new open tab in a same window where automation script is running
	public String newwindowhandlemethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("Size of the tab is:"+tabs2.size());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		String title= driver.getTitle();
		System.out.println("New Open Page Title:"+" "+title);
		String url= driver.getCurrentUrl();
		System.out.println("New Open Page URL:"+" "+url);
		driver.close();
	    driver.switchTo().window(tabs2.get(0));
	
		return title;
	}
	
	
	
	

	
	
    
}
