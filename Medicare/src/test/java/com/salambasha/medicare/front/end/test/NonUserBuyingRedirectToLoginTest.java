package com.salambasha.medicare.front.end.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonUserBuyingRedirectToLoginTest {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
	//	WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8080/MEDICARE/");
		//To maximize the windows
		driver.manage().window().maximize();
		//To manage the timeouts ie it will wait if there is any objects else it will proceed.
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

			
		driver.findElement(By.id("imageId")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("quantityId")).sendKeys("5");
		driver.findElement(By.id("buttonId")).click();


		Thread.sleep(1000);
		
		
		
			driver.quit();
		
		
		
		
		

	}

}
