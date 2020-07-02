package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginNewUser extends TestBase {
	
	@Test(priority=3)
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='login']")).click();		
		System.out.println("Click on sign in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//form[@id='login_form']/div/div/input")).sendKeys("validTest.validTest@gmail.com");
		driver.findElement(By.xpath("//form[@id='login_form']/div/div[2]/span/input")).sendKeys("Testing@123");
		
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(2000);
		
		
		
	}

}
