package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task1 extends CommonMethods {
	

	@BeforeGroups({"Smoke", "Regression1", "Regression2"})
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}
	
	@Test (groups ="Smoke")
	public void userOne() {
		
		sendText(driver.findElement(By.xpath("\"input#user-name\"")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input.form-input")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		//driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	}
	
	@Test(groups = "Regression1")
	public void userTwo() {
		
		sendText(driver.findElement(By.xpath("\"input#user-name\"")), "problem_user");
		sendText(driver.findElement(By.cssSelector("input.form-input")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
	@Test(groups = "Regression2")
	public void userThree() {
		
		sendText(driver.findElement(By.xpath("\"input#user-name\"")), "performance_glitch_user");
		sendText(driver.findElement(By.cssSelector("input.form-input")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
