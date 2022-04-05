package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public By getBy(String locatorType,String locatorValue) {
		
		By locator = null;
		switch(locatorType.toLowerCase()) {
		
		case "id":
			locator= By.id(	locatorValue);
			break;
		case "name":
			locator= By.name(	locatorValue);
			break;
		case "classname":
			locator= By.className(locatorValue);
			break;
		case "css":
			locator= By.cssSelector(locatorValue);
			break;
		case "xpath":
			locator= By.xpath(	locatorValue);
			break;
		case "linkText":
			locator= By.linkText(	locatorValue);
			break;
		case "partialLinkText":
			locator= By.partialLinkText(locatorValue);
			break;
		case "tagName":
			locator= By.tagName(locatorValue);
			break;
			default:
				break;
		}	
			return locator;
		
		}
		
	
	
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	//This method is used to get the list of all the elements with specified locators Ex: tagName("a")- all the links
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public int getElementCount(By locator) {
		return getElements(locator).size();
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
		
	}
	public void doClick(String locatorType,String locatorvalue) {
		getElement(getBy(locatorType,locatorvalue)).click();
		
	}
	
	public void dosendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void dosendKeys(String locatorType, String locatorvalue,String value) {
		getElement(getBy(locatorType,locatorvalue)).sendKeys(value);
	}
	
	public String dogetText(By locator) {
	
		return getElement(locator).getText();
	}
	
	public String dogetAttribute(By locator,String attrName) {
		
		return getElement(locator).getAttribute(attrName);
	}
	
	public boolean doIsDisplayed(By locator) {
		
		return getElement(locator).isDisplayed();
	}
	
	//This method is used to print the text of all the links
	
	public void printElementsText(By locator){
		List<WebElement> ListText = getElements(locator);
		for (WebElement e:ListText ) {
			String text = e.getText();
			System.out.println(text);
		}
		
	}
	//This method will return the list of elements text in string format.
	public List<String> getElementsTextList(By locator){
		List<WebElement> ListText = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e:ListText ) {
			String text = e.getText();
			if(!text.isEmpty()) {
			eleTextList.add(text);
			}
		
				}
	
		return eleTextList;

	}	


	//This method will return the list of elements attribute values.
	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attrName);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}

	public void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for(WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(linkText)) {
				e.click();
				break;
			}
	}
}

//************************************wait*********************************************************
	
	//An expectation for checking an element is visible and enabled such that you can click it
	public void clickWhenReady(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator));		
	}
	
	//An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible
	public WebElement waitforElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	//An expectation for checking that there is at least one element present on a web page.	
	public List<WebElement> waitforElementsPresence(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	
		}

	//An expectation for checking that an element is present on the DOM of a page and visible.
	//Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
	public WebElement waitforElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}
	//An expectation for checking that all elements present on the web page that match the locatorare visible.
	//	Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0
	
	public List<WebElement> waitforElementsVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	}
	
//	************************** wait for non web elements *******************************************
	//Returns boolean by checking page Title contains the specfied text.
	public  boolean waitForPageTitle(String TitleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(TitleVal));
	
	}
	//Checks the exact title of the page.
	public  boolean waitForPageActTitle(String TitleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(TitleVal));
	
	}
	//By checking the page title, it return the title of the page.
	public  String doGetPageTitleContains(String TitleVal, int timeOut) {
		if(waitForPageTitle(TitleVal,timeOut)) {
			return driver.getTitle();
		}
	return null;
	}
	
	//checks the title of the page is exact as specified, the return the title of the page.
	public  String doGetPageTitleIs(String TitleVal, int timeOut) {
		if(waitForPageActTitle(TitleVal,timeOut)) {
			return driver.getTitle();
		}
	return null;
	}
	
	//url contains
	public String waitForUrlContains(String urlFraction,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))){
			return driver.getCurrentUrl();
		}
		 return null;
	}
	
	//url to be
	public String waitForUrlToBe(String url,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(url))){
			return driver.getCurrentUrl();
		}
		 return null;
	}
	//******************************Alert Wait********************************
	
	public Alert waitForAlert(int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return	wait.until(ExpectedConditions.alertIsPresent());		
	}
	
	public String getAlertText(int timeOut) {
		return	waitForAlert(timeOut).getText();		
	}

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();		
	}
	
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();		
	}
//**************************FrameWait*************************************
	
	public WebDriver waitForFrameByIndex(int timeOut,int frameIndex) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));			
	}
	
	public WebDriver waitForFrameByLocator(int timeOut,By frameLocator) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));			
	}
	
	public WebDriver waitForFrameByElement(int timeOut,WebElement frameElement) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));			
	}
	
}
