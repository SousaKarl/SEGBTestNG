package com.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GlobalNavigation {
	
	@Test
	
	public void globalnavigation() throws IOException
	
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		//Accepting the cookie pop up
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		List<WebElement> global_navigation = driver.findElements(By.xpath("//div[@class='segb-flexinav__navs']//nav[@aria-label='global navigation']//li"));
		
		System.out.println("The total number of item is the global naivgation is: "+global_navigation.size());
		
		for (int i=0; i<global_navigation.size(); i++)
			
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='segb-flexinav__navs']//nav[@aria-label='global navigation']//li")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='segb-flexinav__navs']//nav[@aria-label='global navigation']//li")));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(global_navigation.get(i)));
			
			if(global_navigation.get(i).isDisplayed() && global_navigation.get(i).isEnabled())
			{
				
				System.out.println("The link names are :" +global_navigation.get(i).getText());
				
				
				
			}
			
			WebElement navigation = driver.findElement(By.xpath("//nav[@class='segb-flexinav__global-nav segb-flexinav__global-nav--desktop']"));
			File file =	navigation.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File("Global_Navigation.png"));
			
			
			
			
			
		}
		
		driver.close();
		
	}

}



