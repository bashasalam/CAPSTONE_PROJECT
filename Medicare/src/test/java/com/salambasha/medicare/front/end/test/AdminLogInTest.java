package com.salambasha.medicare.front.end.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLogInTest {

	public static void main(String[] args) {
	
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
		
		//Remember.click();
		driver.findElement(By.id("loginButtonId")).click();
			
		
			driver.quit();
		
		
		
		
		

	}

}
