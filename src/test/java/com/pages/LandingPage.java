package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Page;

public class LandingPage extends Page {

	public void navigateToActivityLog() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 40L);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='userNavigationLabel']")));
		if(driver.findElement(By.className("_5lxt f_click")).isDisplayed()){
			System.out.println("Inside Class Path......");
	driver.findElement(By.className("_5lxt f_click")).click();
    driver.findElement(By.linkText("Activity Log")).click();
		}
    System.out.println("*****Clicked AL");
	
	  
}

public String validateActivityLog(){
	
	String header=null;
	if(driver.findElement(By.className("uiHeaderTitle")).isDisplayed())
	{	
		System.out.println("@@@@@@ Inside Read heeader");
		 header=driver.findElement(By.className("uiHeaderTitle")).getText();
	}
	System.out.println("@@@@@@ Read heeader"+header);
		return header;
	
	
} 	
	
	
}