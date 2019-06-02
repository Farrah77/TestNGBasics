package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TestNGHW extends CommonMethods {
	
	@BeforeMethod
     
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}
	
	@Test 
	public void login() {
		sendText(driver.findElement(By.id("user-name")), "standard_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		
		WebElement text = driver.findElement(By.xpath("//div[text()='Products']"));
		String expectedText = text.getText();
		
		if (expectedText.equals("Products")) {
			System.out.println("Text "+expectedText+ " is visible and verified");
		} else {
			System.out.println("Text "+expectedText+" is not visible and not verified");
		}
		
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
		driver.findElement(By.linkText("Logout")).click();
		driver.close();

}
}
