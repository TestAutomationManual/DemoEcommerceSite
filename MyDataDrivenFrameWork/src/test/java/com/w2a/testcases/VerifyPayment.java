package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class VerifyPayment extends TestBase {
	
	@Test(priority=5)
	public void verifyPaymentHistory() throws InterruptedException {
		
//		LoginNewUser l= new LoginNewUser();
//		l.login();
		
		System.out.println("Click on my Profile");
		driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
		
		System.out.println("Click on the orders");
		driver.findElement(By.xpath("//a[@title='Orders']")).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		String amount=driver.findElement(By.xpath("//tr[@class='first_item ']//td[@class='history_price']")).getText();
		
		System.out.println("The amount paid for the order "+amount);
		Thread.sleep(1000);
		
	}

}
