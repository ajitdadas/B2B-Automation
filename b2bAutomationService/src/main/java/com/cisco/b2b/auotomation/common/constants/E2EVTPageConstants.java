package com.cisco.b2b.auotomation.common.constants;

public class E2EVTPageConstants {

	public static final String CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String CHROME_DRIVERPATH = "C:\\Users\\avratnaw\\Documents\\API Automation\\chromedriver.exe";
	public static final String GECKO_DRIVER = "webdriver.gecko.driver";
	public static final String GECKO_DRIVERPATH = "C:\\Users\\avratnaw\\Documents\\API Automation\\geckodriver-v0.26.0-win64\\geckodriver.exe";
	public static final String SAFEBROWSING_ENABLED = "safebrowsing.enabled";
	public static final String DOWNLOAD_DEFAULT_DIRECTORY = "download.default_directory";
	public static final String BROWSER_SETTINGS_AUTOMATICDOWNLOADS = "profile.content_settings.exceptions.automatic_downloads.*.setting";
	public static final String DOWNLOAD_PROMPT = "download.prompt_for_download";
	public static final String PREFS = "prefs";
	public static final String E2EVT_URL = "https://ys1e2e-stage.cloudapps.cisco.com/b2b/e2e/#/e2ehome/monitor";
	public static final String USERNAME_XPATH = ".//*[@id='userInput']";
	public static final String NEXT_XPATH = ".//*[@value='Next']";
	public static final String PASSWORD_XPATH = ".//*[@id='passwordInput']";
	public static final String LOGINBTN_XPATH = ".//*[@id='login-button']";
	public static final String UPID_XPATH = "//*[@id='txtpono']";
	public static final String SEARCHBTN_XPATH = ".//button[@label='Search']";
	public static final String EXPANDUPID_XPATH = ".//*[@id='tabularData']/div[2]/p-datatable/div/div[2]/table/tbody/tr/td[2]/span/p/a";
	public static final String WINDOW_SCROLLBY = "window.scrollBy(0,1000)";
	public static final String B2B_RESPONSEBTN = ".//td[text()='Response delivered to the partner']/following::td[1]/span[1]/a/img[@id='download_image']";
	public static final String CROSSFLOW_RESPONSEBTN = ".//td[text()='Response delivered by config service']/following::td[1]/span[1]/a/img[@id='download_image']";
	public static final int LONGWAIT = 5000;
	public static final int SHORTWAIT = 3000;
	public static final int EXTRALONGWAIT = 30000;
	public static final int ONE = 1;
}
