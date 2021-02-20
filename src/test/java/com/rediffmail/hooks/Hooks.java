package com.rediffmail.hooks;

import com.rediffmail.utilities.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
@Before
public void preRequisites() {
	BaseClass.openBrowser();
}

@After
public void tearDown(){
	BaseClass.closeBrowser();
}

}
