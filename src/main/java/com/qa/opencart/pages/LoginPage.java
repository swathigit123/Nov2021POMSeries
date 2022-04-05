package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1.Private by locator
	private By emailId = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPassword = By.linkText("Forgotten Password");
	private By RegisterLink = By.linkText("Register");
	
	//2.Constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3.public page actions/methods:
	public String getLoginPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	
	}
	
	public String getPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}

	public boolean isForgotPasswordLinkExist() {
	//	return driver.findElement(forgotPassword).isDisplayed();
		return eleUtil.doIsDisplayed(forgotPassword);			
	}
	
	public Accountpage doLogin(String userName,String password) {
		
		eleUtil.dosendKeys(emailId, userName);
		eleUtil.dosendKeys(pwd, password);
		eleUtil.doClick(loginBtn);
		return new Accountpage(driver);
			
	}
	
	public boolean IsRegisterLinkExist() {
		return eleUtil.doIsDisplayed(RegisterLink);
	}
	
	public RegistrationPage doClickRegisterLink() {
		//if(IsRegisterLinkExist()) {
			eleUtil.doClick(RegisterLink);
			return new RegistrationPage(driver);	
	
	}
}

