package org.nottyo.samples.testsuites;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SampleTestNgTest {
	private WebDriver driver;	
	private static DesiredCapabilities capabillities;
	 private static Wait<WebDriver> wait;
	 
	  @Test
	  public void f() {
		  driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();	
		  	System.out.println(title);
			Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
	  }
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  
//		  //driver = new ChromeDriver();  
//		  
		  capabillities = DesiredCapabilities.firefox();
		  
		    /** URL is the selenium hub URL here **/
		    driver = new RemoteWebDriver(new URL("http://35.247.181.253:4444/wd/hub"), capabillities);
		   
		    capabillities.setBrowserName("firefox"); 
		    wait = new WebDriverWait(driver, 6000);
		    
		    if(driver != null)
		    	System.out.println("Obtained the driver");
		  
		  System.out.println("Obtained the driver");
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
