package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	public Properties prop; //Properties is a class in java.
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		
		System.out.println("Browser name is" +browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			//bDriverManager.firefoxdriver().setup();
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please pass the correct browser" + browserName);
		}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url").trim());
			return driver;
	}
	
	/**
	 * this method is used to  intialize the properties
	 * @return
	 */
	public Properties init_prop() {
		 prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
		
	}
	
	
	
}
