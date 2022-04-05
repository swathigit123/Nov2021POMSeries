package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.Accountpage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	Accountpage AccPage;

	@BeforeTest()
	public 	void setUp() {
	df = new DriverFactory();
	prop = df.init_prop();
	driver = df.init_driver(prop);
	loginPage =  new LoginPage(driver);
	}
	
	@AfterTest()
	public void tearDown() {
		//driver.quit();
	}
	
}
