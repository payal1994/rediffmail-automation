package com.rediffmail.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;



/**
 * 
 * @author Naveen
 * @see in this class the path for screenshot is hard coded, please refer to others.properties file 
 *   the entry is kept, and this path shall be able to change from properties file 
 */
public class ScreenShot {

	private WebDriver driver; 
	
	// the driver information will be given by selenium test case 
	public ScreenShot(WebDriver driver){
		this.driver = driver; 
	}
	public String captureScreen() throws IOException {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String userDir = System.getProperty("user.dir");
			//String path= userDir+"\\screenshots\\";
			String dest =userDir+"\\screenshots\\"+getcurrentdateandtime()+".png";
			//System.out.println(dest);
			File target = new File(dest);
			FileUtils.copyFile(src, target);
			return dest;
//		
		
	}
	
	public String getcurrentdateandtime(){
	String str = null;
	try{
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
	Date date = new Date();
	str= dateFormat.format(date);
	str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
	}
	catch(Exception e){

	}
	return str;
	}
	

	public void captureScreenShot(String fileName){
		
		String userDir = System.getProperty("user.dir");
		String path=userDir+"\\Screenshots\\";
	
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	
}
