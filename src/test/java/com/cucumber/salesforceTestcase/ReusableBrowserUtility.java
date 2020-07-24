package com.cucumber.salesforceTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableBrowserUtility {
	
	public static WebDriver driver;
	
    	static void LaunchBrowser(String str) throws InterruptedException
	{
		try {
		if(str.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("http://google.com");
				
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
				
		}
		else if(str.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
			
			driver.get("http://google.com");
			
			driver.manage().deleteAllCookies();
			
			driver.manage().window().maximize();

					}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
    	static void URL()
    	{
    		 driver.get("https://login.salesforce.com/");
    	}
	
	static void login(String sUsername, String sPassword)
	{
		 		
		WebElement username = driver.findElement(By.id("username"));
		
		username.sendKeys(sUsername);

		WebElement password=driver.findElement(By.id("password"));

		password.sendKeys(sPassword);

		driver.findElement(By.id("Login")).click();

	}
	
	static void userMenu(String uStr) throws InterruptedException
    {
		Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@id='userNav-arrow']")));

    	WebElement UsernameArrow=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
						
		UsernameArrow.click();
		
		System.out.println("Clicked on user menu drop down.");
				
    	if(uStr.equalsIgnoreCase("My Profile"))
    	{
    		WebElement open_myProfile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
    		
    		waitForPageElementToVisible(open_myProfile);
    		if(open_myProfile.isDisplayed())
    		{			
    		open_myProfile.click();
    		System.out.println("CLicked on my profile link.");
    		}
    	}
    	
    	else if(uStr.equalsIgnoreCase("My Settings"))
    	{
    		Thread.sleep(1000);
    		WebElement open_mySettings=driver.findElement(By.linkText("My Settings"));
			
			waitForPageElementToVisible(open_mySettings);
						
			if(open_mySettings.isDisplayed())
			{
			open_mySettings.click();	
			System.out.println("CLicked on My Settings.");
			}
    	}
    		else if(uStr.equalsIgnoreCase("Logout"))
    	{
    		WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    		
    		waitForPageElementToVisible(logOut);
    		if(logOut.isDisplayed()) {
    		
    		logOut.click();
    		}
    	}
		
    }
	
	static void homepage()
	{
		waitForPageElementToVisible(driver.findElement(By.xpath("//span[contains(text(),'Mitali Kapuria')]")));
		
		WebElement userName=driver.findElement(By.xpath("//span[contains(text(),'Mitali Kapuria')]"));
			
		String user=userName.getText();
		
		System.out.println("It validates that the user logged in and is on salesforce homepage."+user);
	}
	
    /*static void LogOut()
    {
		waitForPageElementToVisible(driver.findElement(By.xpath("//span[@id='userNavLabel']")));

    	WebElement UsernameArrow=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		
					
		UsernameArrow.click();
				
    	WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		
		waitForPageElementToVisible(logOut);
		if(logOut.isDisplayed()) {
		
		logOut.click();
		}
		
    }*/
    
    static void waitForPageElementToVisible(WebElement eleToWait) 
    {
		WebDriverWait wait = new WebDriverWait(ReusableBrowserUtility.driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
		
	}	
	static void quitBrowser()
	{
		driver.quit();
	}



}
