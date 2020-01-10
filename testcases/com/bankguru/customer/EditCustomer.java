package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.AbstractTest;

public class EditCustomer extends AbstractTest {
	WebDriver driver;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		
	}
}
