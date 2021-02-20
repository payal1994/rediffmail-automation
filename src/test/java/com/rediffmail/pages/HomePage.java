package com.rediffmail.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rediffmail.pages.ComposePage;
import com.rediffmail.utilities.CommonLibreary;

public class HomePage {
	WebDriver driver;
	CommonLibreary lib= new CommonLibreary();
    public HomePage(WebDriver driver){
    		this.driver=driver;
	        PageFactory.initElements(driver, this);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
    
//    @FindBy(xpath = "//li[@title=\"Compose a new mail\"]")
//    public WebElement lnkWriteMail;
    
    @FindBy(xpath = " //cite[@class=\"rd_logo\"]")
    public WebElement txtTitle;
 
 
    public WebElement tabLinkEle(String tabName)
    {
    	WebElement ele = driver.findElement(By.xpath("//b[text()='"+tabName+"']"));
    	return ele;
    }
    
    public ComposePage clickWriteMail(String tabName) {
    	
    	 lib.clickEle(tabLinkEle(tabName),tabName +" tab");
    	return new ComposePage(driver);
    				
    }
    public boolean verifyHomePage() {
    	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    	String sTitle=txtTitle.getText();
       	boolean result=false;
    	if(sTitle.contains("rediff.com")) {
    		result=true;
    	
    	}
    	else
    		result=false;
    		return result;
    }
    
    
    
}
