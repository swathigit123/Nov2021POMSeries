package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class Accountpage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By header = By.cssSelector("div#logo a");
	private By Sections = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By Search = By.name("search");
	private By SearchIcon = By.cssSelector("div#search button");
	
	public Accountpage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Actions/Methods
	public String getAccountsPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountsPageUrl() {
		return eleUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URLFRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccPageHeader() {
		return eleUtil.dogetText(header);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
			return true;
		}
		return false;
	}
	
	public List<String> getAccPageSections() {
		List<WebElement> Sectionslist = eleUtil.waitforElementsVisible(Sections,Constants.DEFAULT_TIME_OUT);
		List<String> secValList = new ArrayList<String>();
		for(WebElement e : Sectionslist) {
		String text =e.getText();
		secValList.add(text);
		}
		return secValList;
	}
	
	public boolean IsSearchExist() {
		return eleUtil.doIsDisplayed(Search);
	}
	
	public void doSearch(String ProductName) {
		if(IsSearchExist()) {
			eleUtil.dosendKeys(Search, ProductName);
			eleUtil.doClick(SearchIcon);
		}
	
	}
	
	


}
