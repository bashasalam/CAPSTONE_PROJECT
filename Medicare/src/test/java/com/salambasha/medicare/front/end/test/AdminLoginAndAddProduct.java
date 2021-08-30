package com.salambasha.medicare.front.end.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLoginAndAddProduct {

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
		
		driver.findElement(By.id("addProductId")).click();

		Thread.sleep(1000);
		
		
		WebElement productName = driver.findElement(By.xpath("//input[@name='productName']"));
		WebElement brandName = driver.findElement(By.xpath("//input[@name='brandName']"));
		WebElement description = driver.findElement(By.xpath("//textarea[@name='description']"));
		WebElement price = driver.findElement(By.xpath("//input[@name='price']"));
		WebElement offer = driver.findElement(By.xpath("//input[@name='offer']"));
		WebElement theCategory = driver.findElement(By.xpath("//select[@name='theCategory']"));
		WebElement quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
		WebElement fileToUpload = driver.findElement(By.xpath("//input[@name='fileToUpload']"));
		WebElement extraImage1 = driver.findElement(By.xpath("//input[@name='extraImage1']"));
		WebElement extraImage2 = driver.findElement(By.xpath("//input[@name='extraImage2']"));
		WebElement extraImage3 = driver.findElement(By.xpath("//input[@name='extraImage3']"));
		WebElement saveBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		productName.sendKeys("Volini Pain Relief Gel");
		brandName.sendKeys("Visit Volini Store");
		description.sendKeys("Tube Of 75 G");
		price.sendKeys("245");
		offer.sendKeys("10");
		theCategory.sendKeys("5");
		quantity.sendKeys("15");
	
	
		Thread.sleep(1000);
		fileToUpload.sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-1-1626360920.webp");
		Thread.sleep(100);
		extraImage1.sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-2-1614077121.webp");
		Thread.sleep(100);
		extraImage2.sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-6.3-1614077100.webp");
		Thread.sleep(100);
		extraImage3.sendKeys("C:/Users/Allaahuakbar/Desktop/Madicines and its images/HealthCare Products/Volini/volini-pain-relief-gel-tube-of-75-g-6.5-1614077336.webp");
		Thread.sleep(100);
		System.out.println("Product is Uploaded Successfully");
		
		Thread.sleep(1000);
		//Remember.click();
		saveBtn.click();
			
		
			driver.quit();
		
		
		
		
		

	}

}
