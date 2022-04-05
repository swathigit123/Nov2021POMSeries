package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;



public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
		public void AccsetUp() {
			AccPage = loginPage.doLogin(prop.getProperty("userName"),prop.getProperty("password"));		
		}
	
	@Test
	public void AccPageTitleTest() {
		String actualTitle = AccPage.getAccountsPageTitle();
		System.out.println("Account PAge Title is" +actualTitle);
		Assert.assertEquals(actualTitle,Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void AccountsPageUrlTest() {
		String AccUrl = AccPage.getAccountsPageUrl();
		Assert.assertTrue(AccUrl.contains(Constants.ACCOUNT_PAGE_URLFRACTION));
	}
	
	@Test
	public void AccPageHeader() {
		String AccHeader = AccPage.getAccPageHeader();
		Assert.assertEquals(AccHeader, Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@Test
	public void AccLogOutPageExist() {
		Assert.assertTrue(AccPage.isLogoutLinkExist());
	}
	
	@Test
	public void AccPageSectionsTest() {
	List<String> AccPageSections = AccPage.getAccPageSections();
	System.out.println("Accpunt page sections" +AccPageSections);
	Assert.assertEquals(AccPageSections, Constants.ACCOUNT_PAGE_SECTIONSLIST);
	}
}
