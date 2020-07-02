package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddToCart extends TestBase{
	
	@Test(priority=4)
	public void SelectWomenSection() throws InterruptedException {
		
//		LoginNewUser l= new LoginNewUser();
//		l.login();
		
		log.info("Select the Women Section");
		driver.findElement(By.xpath("//a[@title='Women']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		//WebElement item = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		
		System.out.println("Move to webElement");
		actions.moveToElement(driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")));
		
		driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div[2]/div[2]/a[@data-id-product='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
		
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();

		driver.findElement(By.xpath("//div[@id='uniform-cgv']")).click();
		driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
		
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		System.out.println("Payment made suuccessfully");
		
		
		
	}

}
