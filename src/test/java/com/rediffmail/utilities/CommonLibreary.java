package com.rediffmail.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CommonLibreary extends BaseClass{
		
public void enterText(WebElement element , String value , String desc) {
	try {
	//WebDriverWait wait = new WebDriverWait(driver, 20);//
	WebElement ele=new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
	  ele.sendKeys(value);
	  System.out.println("Entered text: "+value +" in field: "+desc);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
	
}

public String getEleText(WebElement element) {
	String actValue =null;
	try {
	//WebDriverWait wait = new WebDriverWait(driver, 20);//
	WebElement ele=new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
	actValue = ele.getText();
	  System.out.println("Fetched value is: "+actValue);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
	return actValue;
	
}

public void clickEle(WebElement element, String desc) {
	try {
	WebElement ele=new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
	  ele.click();
	  System.out.println("Clicked on element: "+desc);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
}

public boolean verifyIfElementFound(WebElement ele, String desc){
	boolean value = false;
	try{
		WebElement element=new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ele));
		boolean val1 = element.isDisplayed();
		boolean val2 = element.isEnabled();
		if(val1 == true && val2 == true){
			value = true;
			System.out.println(desc+" is present");
		}
		else
		{
			System.out.println(desc+" is not present");
			Assert.fail();
		}
			
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
	return value;		
}

	public void verifyContainsText(WebElement element, String expectedVal, String desc)
	{
		try{
			String actVal = getEleText(element).trim().toLowerCase();
			String expVal = expectedVal.trim().toLowerCase();
			if(actVal.contains(expVal))
			{
				System.out.println("Verified that "+desc+" contains text: "+expectedVal);
			}
			else
				System.out.println("Failed to verify that "+desc+" contains text: "+expectedVal+" istead actual value is: "+actVal);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	public void shiftFocusToElement(WebElement element)
	{
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	
}
