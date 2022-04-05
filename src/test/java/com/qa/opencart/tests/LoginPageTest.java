package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{

	@Test
	public void getLoginPageTilte() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is" +title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void getLoginPageUrl() {
		String url = loginPage.getPageUrl();
		System.out.println("Login Page Url" + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test
	public void getForwardLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());                                                                             
	}
	
	@Test
	public void loginTest() {
		AccPage = loginPage.doLogin(prop.getProperty("userName"),prop.getProperty("password"));
		Assert.assertTrue(AccPage.isLogoutLinkExist());
	}
}
