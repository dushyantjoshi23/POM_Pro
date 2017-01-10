package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Page;

public class HomePage extends Page{

	
	public void doLogin(String username,String password){
		
		input("username", username);
		input("password", password);
		click("login");
	}
	
	public boolean validateInvalidLogin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 40L);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Recover Your Account")));
	boolean checkButton=driver.findElement(By.linkText("Recover Your Account")).isDisplayed();
		if(checkButton)
	{return true;}
		else
		return false;
		
	}
	
	public void navigateHomePage(){
		
		driver.get("https://www.facebook.com");
	}
	
public int verifyFooterLinks(){
		
	WebElement linkCount= driver.findElement(By.xpath("//*[@id='pageFooter']/div[2]/table/tbody"));
	List<WebElement> newLi= linkCount.findElements(By.tagName("a"));
	int siz=newLi.size();
	for (WebElement e  : newLi)
    {
		if(e.isDisplayed()){
     String fs=   e.getText();
     System.out.println("###########"+fs);
		}
    }
	return siz;
}


public String getMainText(){
	System.out.println("Inside getMainFunction");
String str=driver.findElement(By.className("_5iyx")).getText();
System.out.println("After getMainFunctionLine");
	return str;
}

public boolean verifyGlobalImage(){
boolean b=driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/div/img")).isDisplayed();
	return b;
}



}