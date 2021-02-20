package com.rediffmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediffmail.utilities.CommonLibreary;

public class ComposePage {
	CommonLibreary lib= new CommonLibreary();
	WebDriver driver;
    public ComposePage(WebDriver driver){
    		this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }
    @FindBy(xpath = "//a[@title='New Mail']")
    public WebElement newMailTitle;
    
    @FindBy(id = "TO_IDcmp2")
    public WebElement txtEnterEmail;
    
    @FindBy(xpath = "//div[@class='comps_fet']//a[text()='Save']")
    public WebElement btnSave;
    
    @FindBy(xpath = "//div[@class='comps_fet']//a[text()='Send']")
    public WebElement btnSend;
    
    @FindBy(xpath = "//div[@class='comps_fet']//a[text()='Address Book']")
    public WebElement btnAddrBook;
    
    @FindBy(xpath = "//div[@class='comps_fet']//a[text()='Cancel']")
    public WebElement btnCancelMail;
    
    @FindBy(xpath = "//label[@data-fld='to']/parent::li//input[@type='text']")
    public WebElement toField;
    
    @FindBy(xpath = "//a[contains(@class,'cc_bcc')]")
    public WebElement btncc_bcc;
    
    @FindBy(xpath = "//label[@data-fld='cc']/parent::li//input[@type='text']")
    public WebElement ccField;
    
    @FindBy(xpath = "//label[@data-fld='cc']/parent::li//input[@type='text']")
    public WebElement bccField;
    
    @FindBy(xpath = "//li[@class='fld_sub']//input[@type='text']")
    public WebElement subjectField;
    
    
    @FindBy(xpath = "//div[@id=\"rd_compose_cmp2\"]//a[text()=' Attach']")
    public WebElement btnAttachment;
    
    
    @FindBy(xpath = "(//label[text()='Subject:']//parent::li//input)[1]")
    public WebElement inputEnterSubject;
    
    @FindBy(xpath = "//div[@class=\"jqistate\"]")
    public WebElement txtErrorPopUp;
    
    @FindBy(xpath = "//a[@title='Bold']")
    public WebElement boldIcon;
    
    @FindBy(xpath = "//a[@title='Italic']")
    public WebElement italicIcon;
    
    @FindBy(xpath = "//a[@title='Underline']")
    public WebElement underlineIcon;
    
    @FindBy(xpath = "//a[@title='Strikethrough']")
    public WebElement strikeIcon;
    
    @FindBy(xpath = "//a[@title='Remove Format']")
    public WebElement removeFormatIcon;
    
    @FindBy(xpath = "//div[contains(@class,'lead jqititle ')]")
    public WebElement popUpTitle;
    
    @FindBy(xpath = "//button[contains(@class,'jqidefaultbutton')]")
    public WebElement acceptPopUpBtn;
    
    @FindBy(id = "rdNotify")
    public WebElement notification;
    
    
    
  
    public void verifyNewMailTab()
    {
    	lib.verifyIfElementFound(newMailTitle, "New mail tab");
    }
    
    public void verifyAllButtonAvailablity()
    {
    	lib.verifyIfElementFound(btnSend, "mail send button");
    	lib.verifyIfElementFound(btnSave, "save mail button");
    	lib.verifyIfElementFound(btnAttachment, "attachment button");
    	lib.verifyIfElementFound(btnAddrBook, "address book button");
    	lib.verifyIfElementFound(btnCancelMail, "cancel mail button");
    }
    
    public void verifyAllFieldAvailablity()
    {
    	lib.verifyIfElementFound(toField, "to(Recipient field)");
    	lib.clickEle(btncc_bcc, "cc and bcc field expand button");
    	lib.verifyIfElementFound(ccField, "cc field");
    	lib.verifyIfElementFound(bccField, "bcc field");
    	lib.verifyIfElementFound(btnAddrBook, "address book button");
    }
    
    public void verifyFontFormattingIcons()
    {
    	lib.verifyIfElementFound(boldIcon, "bold font formatting icon");
    	lib.verifyIfElementFound(italicIcon, "italic font formatting");
    	lib.verifyIfElementFound(underlineIcon, "underline formatting icon");
    	lib.verifyIfElementFound(strikeIcon, "strike through formatting icon ");
    	lib.verifyIfElementFound(removeFormatIcon, "removed formatting icon to undo all formatting changes");
    }
    
    
    
    public void sendMailWithOutAttachment(String emailId,String Subject) {
    	lib.enterText(txtEnterEmail, emailId, "To(recipient)");
    	lib.enterText(inputEnterSubject, Subject,"Subject");
    	lib.clickEle(btnSend, "Send button");
    	//btnSend.click();
    }
    
    public void clickButton(String btnName)
    {
    	WebElement ele = driver.findElement(By.xpath("//div[@class='comps_fet']//a[text()='"+btnName+"']"));
    	lib.clickEle(ele, btnName);
    }
    
    public void enterSubject(String subject)
    {
    	lib.enterText(subjectField, subject, "subject field");
    }
    
    public void enterRecipient(String recipient)
    {
    	lib.enterText(toField, recipient, "to field");
    }
    
    public void verifyPopUpMessage(String warningTitle)
    {
    	lib.shiftFocusToElement(popUpTitle);
    	lib.verifyContainsText(popUpTitle, warningTitle, warningTitle+" pop up");
    	lib.clickEle(acceptPopUpBtn, warningTitle+" pop up accept button");
    }
    
    public void verifySuccessMsg(String msg)
    {
    	lib.verifyContainsText(notification, msg, "mail sent success message");
    }
    
   /* public void sendMailWithAttachment(String emailId,String Subject) {
    	lib.enterText(txtEnterEmail, emailId);
    	lib.enterText(inputEnterSubject, Subject);
    	lib.clickEle(btnAttachment);
    	lib.clickEle(btnSend);
    	
    	
    }*/
    
    
    
}
