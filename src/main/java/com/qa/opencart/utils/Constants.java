package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	public static final int DEFAULT_TIME_OUT = 30;
	public static final String LOGIN_SUCCESS_MSG = "Your Account Has Been Created!";
			
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	
	public static final String ACCOUNT_PAGE_URLFRACTION = "account/account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	public static final List<String> ACCOUNT_PAGE_SECTIONSLIST = 
														Arrays.asList("My Account",
																	   "My Orders",
																	   "My Affiliate Account",
																	   "Newsletter");		
			
}
