package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
  @Test(enabled=false)
  public void fTest() throws Exception {
	   WebDriver driver;
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\newDR\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		 
		driver.navigate().to("https://www.facebook.com");
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("dunelmtesting@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Dunelm2017']");
		driver.findElement(By.xpath("//*[@id='u_0_l']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 40L);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Recover Your Account")));
		System.out.println("Element Located@@@@@@@@@@@@@@@@@@@@@");
	boolean str=	driver.findElement(By.linkText("Recover Your Account")).isDisplayed();
		Assert.assertEquals(str, true);
		
  }
  
  @Test
  public void sTest() throws Exception {
	  WebDriver driver;
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\newDR\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.facebook.com");
		WebElement linkCount= driver.findElement(By.xpath("//*[@id='pageFooter']/div[2]/table/tbody"));
		List<WebElement> newLi= linkCount.findElements(By.tagName("a"));
		for (WebElement e  : newLi)
        {
			if(e.isDisplayed()){
         String fs=   e.getText();
         System.out.println("###########"+fs);
			}
        }
	  
  
  }
}
