package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LandingPage;

public class LandingPageTest extends LandingPage {
	
  @Test
  public void testActivityLog() throws Exception {
	  
	  
	  navigateToActivityLog();
  }
  
  @Test
  public void verifyActivityLogText() throws Exception {
	  
	  validateActivityLog();
	  Assert.assertEquals(validateActivityLog(), "sample");
  }
  
}
