package com.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;


public class LoginTest {
	
	@Test
	public void testInValidLogin() throws Exception{
		
		HomePage hp=new HomePage();
		hp.doLogin("dunelmtesting@gmail.com", "Dunelm2017");
		boolean locator=hp.validateInvalidLogin();
		Assert.assertEquals(locator, true);
		
	}
	
	
	@Test
	public void testFooterLinks(){
		
		HomePage hp=new HomePage();
		hp.navigateHomePage();
		int a=hp.verifyFooterLinks();
		
		Assert.assertEquals(a, 28);	
		
	}
	
	
	@Test
	public void testMainText(){
		System.out.println("###########Line1");
		HomePage hp=new HomePage();
		System.out.println("###########Line2");
		hp.navigateHomePage();
		System.out.println("###########Line3");
		String str=hp.getMainText();
		System.out.println("###########Line4");
		Assert.assertEquals("Facebook helps you connect and share with the people in your life.", str);
		
		
	}
	
	@Test
	public void testGlobalImage(){
		
		HomePage hp=new HomePage();	
		hp.navigateHomePage();	
		boolean str=hp.verifyGlobalImage();	
        Assert.assertEquals(str, true);		
		
	}
	
	@Test(enabled=true)
	public void testValidLogin(){
		
		HomePage hp=new HomePage();
		hp.navigateHomePage();
		hp.doLogin("dunelmtesting@gmail.com", "Dunelm2016");	
		
	}
	

}
