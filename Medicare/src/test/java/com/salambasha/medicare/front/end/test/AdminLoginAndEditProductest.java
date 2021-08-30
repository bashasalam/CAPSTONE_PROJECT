package com.salambasha.medicare.front.end.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLoginAndEditProductest {

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
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);	
		
		 driver.findElement(By.cssSelector("tr:nth-child(12) .btn-info > .fas")).click();
		 driver.findElement(By.id("brandName")).sendKeys("Volini Store");
			//Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@name='fileToUpload']")).click();
			 driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-2-1614077121.webp");
			 driver.findElement(By.xpath("//input[@name='extraImage1']")).click();
			 driver.findElement(By.xpath("//input[@name='extraImage1']")).sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-1-1626360920.webp");
			 driver.findElement(By.xpath("//input[@name='extraImage2']")).click();
			 driver.findElement(By.xpath("//input[@name='extraImage2']")).sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-6.3-1614077100.webp");
			 driver.findElement(By.xpath("//input[@name='extraImage3']")).click();
			 driver.findElement(By.xpath("//input[@name='extraImage3']")).sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-6.5-1614077336.webp");
		    driver.findElement(By.cssSelector(".btn")).click();
		    driver.findElement(By.linkText("Logout")).click();
		
		
		
		
		
		    Thread.sleep(1000);
		    System.out.println("Product Edited successfully");
			Thread.sleep(1000);
			
			driver.quit();
		
		
		
		
		

	}

}
