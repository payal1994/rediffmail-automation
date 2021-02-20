package com.rediffmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rediffmail.utilities.CommonLibreary;

public class LoginPage {
	WebDriver driver;
	CommonLibreary lib= new CommonLibreary();
    public LoginPage(WebDriver driver){
    		this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(id = "login1")
	    public WebElement inputUserName;
	    
	    @FindBy(id = "password")
	    public WebElement inputPassword;
	    
	    @FindBy(xpath = "//input[@title='Sign in']")
	    public WebElement btnSignin;
	    
	    
	    public  HomePage login(String UserName,String Password) throws InterruptedException {
	    	lib.enterText(inputUserName, UserName, "user name");
	    	lib.enterText(inputPassword, Password,"password");
	    	lib.clickEle(btnSignin,"sign in");
	    	
	    	 return new HomePage(driver);
	    }
	    
	 
	    
}
