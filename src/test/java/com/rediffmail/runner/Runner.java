package com.rediffmail.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



//	@RunWith(Cucumber.class)
	@CucumberOptions(
	 features = "src\\test\\java\\com\\rediffmail\\features"
	 ,glue={"com.rediffmail.stepdefinitions","com.rediffmail.hooks"},
	 plugin = { "pretty","html:CucumberReport/cucumber.html"} 
	 //tags="@Regression"src/test/resource/features
	 )

	public class Runner extends AbstractTestNGCucumberTests {

		
		
	

}
