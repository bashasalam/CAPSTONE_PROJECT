package com.salambasha.medicare.front.end.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserBuyingSuccessTest {

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
		
		 
		    
			
			
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).sendKeys("fadheela2@gmail.com");
		    driver.findElement(By.name("password")).sendKeys("test1");
		    driver.findElement(By.name("submit")).click();
			Thread.sleep(1000);
			
			 driver.findElement(By.id("imageId")).click();
			    driver.findElement(By.id("quantityId")).click();
			    driver.findElement(By.id("quantityId")).sendKeys("10");
			    driver.findElement(By.id("buttonId")).click();
			    driver.findElement(By.cssSelector(".breadcrumb-item:nth-child(1) .mr-md-3")).click();
			    driver.findElement(By.cssSelector(".col-md-3:nth-child(3) #imageId")).click();
			    driver.findElement(By.id("quantityId")).click();
			    driver.findElement(By.id("quantityId")).sendKeys("15");
			    driver.findElement(By.id("buttonId")).click();
			    
			    Thread.sleep(1000);
			    driver.findElement(By.id("nameOnCard")).click();
			    driver.findElement(By.id("nameOnCard")).sendKeys("testname");
			    driver.findElement(By.id("cardNumber")).sendKeys("7979746463131313");
			    driver.findElement(By.id("NAME")).sendKeys("05/22");
			    driver.findElement(By.name("csvNumber")).sendKeys("123");
			    driver.findElement(By.cssSelector("a > .btn")).click();
			    Thread.sleep(1000);
			    
			    driver.findElement(By.name("doorNo")).click();
			    driver.findElement(By.name("doorNo")).sendKeys("12");
			    driver.findElement(By.name("streetName")).sendKeys("street name");
			    driver.findElement(By.name("city")).sendKeys("city");
			    driver.findElement(By.name("state")).sendKeys("state");
			    driver.findElement(By.name("pincode")).sendKeys("784651");
			    driver.findElement(By.cssSelector(".btn")).click();
			    driver.findElement(By.cssSelector(".navbar-nav > .nav-link")).click();
		
		
		
			    Thread.sleep(1000);

		
		
		
			driver.quit();
		
		
		
		
		

	}

}
