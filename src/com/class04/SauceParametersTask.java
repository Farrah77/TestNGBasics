package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class SauceParametersTask extends CommonMethods {
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void setUp(String browser, String url) {
		setUpDriver(browser, url);
	    
	    }
	
	@Parameters({"user1", "pass1"})
	@Test
	public void UserName1(String user1, String pass1) {
	    
	  sendText(driver.findElement(By.id("user-name")), user1 );
	  sendText(driver.findElement(By.id("password")), pass1);
	  driver.findElement(By.className("btn_action")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	//Assert.assertEquals(findElement(By.cssSelector("div[class='product_label']").getText(), "Products"); second option of hard Assert
	}
	
	@Parameters({"user2", "pass2"})
	@Test
	public void UserName2(String user2, String pass2) {
	    
	       sendText(driver.findElement(By.id("user-name")), user2);
	       sendText(driver.findElement(By.id("password")), pass2);
	       driver.findElement(By.className("btn_action")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	       //Assert.assertEquals(findElement(By.cssSelector("div[class='product_label']").getText(), "Products"); second option of hard Assert
	    }
	@AfterMethod
	public void tearDown() {
	    driver.close();
	}
	}


