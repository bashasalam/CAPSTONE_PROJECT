package com.salambasha.medicare.front.end.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLoginAndAddCategoryTest {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
	//	WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8080/MEDICARE/admin/");
		//To maximize the windows
		driver.manage().window().maximize();
		//To manage the timeouts ie it will wait if there is any objects else it will proceed.
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='adminName']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//WebElement logInBtn = driver.findElement(By.xpath("//input[@type='submit']"));

		
		userName.sendKeys("admin");
		password.sendKeys("salam");
		driver.findElement(By.id("loginButtonId")).click();
		//Remember.click();
		//logInBtn.click();
		
		//Remember.click();
		//logInBtn.click();
		Thread.sleep(1000);
		
		 driver.findElement(By.cssSelector("h3:nth-child(1) .btn")).click();
		    driver.findElement(By.id("madicineName")).click();
		    driver.findElement(By.id("madicineName")).sendKeys("TestCategory");
		    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		   // driver.close();	
		    
		    System.out.println("Category added successfully");
			Thread.sleep(1000);
			
			driver.quit();
		
		
		
		
		

	}

}
