package com.class02;

//TC 1: OrangeHRM Title Validation
//
//TC 2: OrangeHRM Successful Login 
//https://opensource-demo.orangehrmlive.com/
//Please make sure to use the following:
//annotations:
//	@BeforeMethod
//	@AfterMethod
//	@Test

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;



public class OrangeTask extends CommonMethods{

	
	@BeforeMethod
	public static void navig() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority =0)
	public static void valid() {
		String title=driver.getTitle();
		String exp ="OrangeHRM";
		System.out.println(title);
		if(exp.equalsIgnoreCase(title) ){
			System.out.println("correct");
		}
		else {
			System.out.println("NOT correct");
		}
	}
	
	@Test(priority=1)
	public static void loginWeb(){
		sendText(driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")), "Admin");
		sendText(driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")), "admin123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}
	@AfterMethod
	public static void logout(){
		driver.close();
	}
}