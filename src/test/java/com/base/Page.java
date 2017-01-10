package com.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Page {
	
	
	public static WebDriver driver;
	
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("devpinoyLogger");

	
	public Page() {
		
		if(driver==null){
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/properties/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			System.out.println("CONFIG FILE LOADED");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logs.debug("Loaded the Config property file");
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/properties/OR.properties");
			System.out.println("OR FILE LOADED");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			System.out.println("OR FILE LOADED");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logs.debug("loaded the OR property file");
		
		if(Config.getProperty("browser").equals("firefox")){
			System.out.println("LOADING ff BROWSER");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\newDR\\geckodriver-v0.11.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			logs.debug("Loaded Firefox");
			System.out.println("LOADED BROWSER");
			
		}else if(Config.getProperty("browser").equals("ie")){
			
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else if(Config.getProperty("browser").equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		//DbManager.setMysqlDbConnection();

		}
			
	}
	
	
	public static void click(String key){
		
		
		driver.findElement(By.xpath(OR.getProperty(key))).click();
		System.out.println(key);
		
	}
	
	
	public static void input(String key,String value){
		
		
		driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		
	}
	
	
}
