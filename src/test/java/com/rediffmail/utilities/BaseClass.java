package com.rediffmail.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver  driver;
	public static FileExtentOfReport extentReport;
	public static WebDriver openBrowser() {
	 WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(readProperties("URL"));
	  extentReport= new FileExtentOfReport(driver);
	  return driver;
	}
	
	public static void closeBrowser() {
		//driver.close();
		driver.quit();
		}
		
	public static String readProperties(String key)
    {
        Properties propFile = new Properties();
        try {
        	
            propFile.load(new FileInputStream("properties//config.properties"));
        }catch(IOException e){
             e.printStackTrace();
        }
        return propFile.getProperty(key);
    }
	 
	
}
