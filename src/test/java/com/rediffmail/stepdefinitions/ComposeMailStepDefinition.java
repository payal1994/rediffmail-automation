package com.rediffmail.stepdefinitions;

import com.rediffmail.pages.ComposePage;
import com.rediffmail.pages.HomePage;
import com.rediffmail.pages.LoginPage;
import com.rediffmail.utilities.BaseClass;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposeMailStepDefinition extends BaseClass{
	LoginPage login= new LoginPage(driver);  
	HomePage homePage;//= new HomePage(driver); 
	ComposePage composePage;
	@Given("^User login to the application with valid credentials$")
	public void user_login_to_the_application_with_valid_credentials() throws Throwable {
		homePage=login.login(readProperties("UserName"),readProperties("Password"));
	}

//	@When("^User navigate to write mail$")
//	public void user_navigate_to_write_mail() throws Throwable {
//		if(homePage.verifyHomePage()) {
//		composePage=homePage.clickWriteMail();
//		}
//		else {
//	    throw new PendingException();
//		}
//	}
	@When("^User navigate to \"([^\"]*)\"$")
	public void user_navigate_to_diffirent_tab(String tabName) throws Throwable {
		if(homePage.verifyHomePage()) {
			composePage=homePage.clickWriteMail(tabName);
			}
			else {
		    throw new PendingException();
			}
	}


	@Then("^Verify New Mail tab is open$")
	public void verify_New_Mail_tab_is_open() throws Throwable {
		composePage.verifyNewMailTab();
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Verify all links and icon on that tab$")
	public void verify_all_links_and_icon_on_that_tab() throws Throwable {
		composePage.verifyAllButtonAvailablity();
		composePage.verifyAllFieldAvailablity();
		composePage.verifyFontFormattingIcons();
	}

	@When("^User composes the mail \"([^\"]*)\" and \"([^\"]*)\" recipient$")
	public void user_composes_the_mail_and_send_it(String arg1,String arg2) throws Throwable {
		if(arg1.equalsIgnoreCase("with subject"))
		{
			composePage.enterSubject("Dummy subject");
		}
		if(arg2.equalsIgnoreCase("valid"))
		{
			composePage.enterRecipient("payal.kataruka2018@gmail.com");
		}
		else
		{
			composePage.enterRecipient("abc");
		}
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}
	
	@And("^click on \"([^\"]*)\" button$")
	public void click_on_button(String btnName)
	{
		composePage.clickButton(btnName);
	}

	@Then("^User verify \"([^\"]*)\" message$")
	public void user_verify_the_sent_mail_message(String msg) throws Throwable {
		composePage.verifySuccessMsg(msg);
	}
	
	@Then("^User verify \"([^\"]*)\" pop up message$")
	public void verify_popUp_messages(String arg)
	{
		composePage.verifyPopUpMessage(arg);
	}

}
