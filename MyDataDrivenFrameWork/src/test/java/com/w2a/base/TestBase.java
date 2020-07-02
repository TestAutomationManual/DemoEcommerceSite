package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.w2a.utilities.ExcelReader;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log =Logger.getLogger("devpinoyLogger");
	
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");

	@BeforeSuite
	public void setUp() throws IOException {
		
		if (driver==null) {

			System.out.println(System.getProperty("user.dir"));
			System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			
			config= new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			
			config.load(fis);
			log.debug("Config file loaded");
			
			OR= new Properties();
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			
			OR.load(fis);
			log.debug("OR file loaded");
		
		
		if(config.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome launched");
		
		}
		else if(config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
			
		}

	}

	public boolean isElementPresent(By by) {
		
		try {
			
			driver.findElement(by);
			return true;
			
		}catch (ElementNotFoundException e) {
			
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown() {
		
		if(driver != null) {
			
			driver.quit();
		}
		log.debug("Execution completed");

	}
}
