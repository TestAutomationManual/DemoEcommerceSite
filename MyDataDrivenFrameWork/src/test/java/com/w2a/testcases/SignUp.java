package com.w2a.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.w2a.base.TestBase;

public class SignUp extends TestBase {
	
	
	@Test(priority=1)
	public void clickSignUp() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='login']")).click();		
		System.out.println("Click on sign in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//div[@class='form-group']//input[@id='email_create']")).sendKeys("validTest9.validTest9@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		Thread.sleep(2000);
	
	}
	
	@Test(priority=2,dataProvider="getData")
	
	public void registration(String FirstName, String LastName, String Password, String FN, String LN, String Address,String City,String State,String ZipCode,String Mobile,String Alias) throws InterruptedException
	{
		//FN	LN	Address	City	State	ZipCode	Mobile	Alias

		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		log.info("Entering the First Name");
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(LastName);
		driver.findElement(By.cssSelector("#passwd")).sendKeys(Password);
		
		Select day= new Select(driver.findElement(By.xpath("//Select[@id='days']")));
		day.selectByValue("2");
		
		Select month = new Select(driver.findElement(By.cssSelector("#months")));
		month.selectByValue("2");
		
		Select year = new Select(driver.findElement(By.cssSelector("#years")));
		year.selectByValue("1975");
		
		driver.findElement(By.xpath("//div[@class='account_creation']/p[1]/input")).sendKeys(FN);
		driver.findElement(By.xpath("//div[@class='account_creation']/p[2]/input")).sendKeys(LN);
		
		driver.findElement(By.xpath("//div[@class='account_creation']/p[4]/input")).sendKeys(Address);
		driver.findElement(By.xpath("//div[@class='account_creation']/p[6]/input")).sendKeys(City);
				
		Select state= new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue("53");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//div[@class='account_creation']/p[8]/input")).sendKeys("00000");
		
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("dasdnadnb");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9860963321");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Alias);

		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=']")).click();
		System.out.println("System is logout now");
		Thread.sleep(1000);
	}
	
	
	@DataProvider
	public Object[][] getData() {

		//int row = excel.getRowCount("SignUpData");
		int row=2;
		int col = excel.getColumnCount("SignUpData");

		Object[][] data = new Object[row - 1][col];

		for (int rowNum = 2; rowNum <= row; rowNum++) {

			for (int colNum = 0; colNum < col; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData("SignUpData", colNum, rowNum);

				System.out.println(data[rowNum - 2][colNum]);

			}

		}

		return data;

	}

}
