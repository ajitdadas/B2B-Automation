package com.cisco.b2b.auotomation.common.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.common.constants.E2EVTPageConstants;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

public class E2EVTConnectivity {

	Logger logger = LogManager.getLogger(E2EVTConnectivity.class);

	public Map<String, ReportDetail> e2evtLogin(final Map<String, ReportDetail> reportDetailsMap)
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		final UtilityFunctions ufObj = new UtilityFunctions();
		Map<String, ReportDetail> e2evtmap = new HashMap<>();
		System.setProperty(E2EVTPageConstants.GECKO_DRIVER, E2EVTPageConstants.GECKO_DRIVERPATH);
		// WebDriver driver;

		final String downloadFilepath = (NGCConstants.NGCRESPONSE_BASEFOLDERPATH)
				.concat(NGCConstants.E2EVTRESPONSE_DOWNLOADPATH);

		// Setting Firefox Profile
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", downloadFilepath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		FirefoxOptions firefoxOpt = new FirefoxOptions();
		firefoxOpt.setProfile(profile);
		WebDriver driver = new FirefoxDriver(firefoxOpt);

		// System.setProperty(E2EVTPageConstants.CHROME_DRIVER,
		// E2EVTPageConstants.CHROME_DRIVERPATH);

		/*
		 * final Map<String, Object> chromePrefs = new HashMap<>();
		 * 
		 * chromePrefs.put(E2EVTPageConstants.SAFEBROWSING_ENABLED, true);
		 * chromePrefs.put(E2EVTPageConstants.DOWNLOAD_DEFAULT_DIRECTORY,
		 * downloadFilepath);
		 * chromePrefs.put(E2EVTPageConstants.BROWSER_SETTINGS_AUTOMATICDOWNLOADS,
		 * E2EVTPageConstants.ONE); chromePrefs.put(E2EVTPageConstants.DOWNLOAD_PROMPT,
		 * false);
		 */
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
		// true);

		// final ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption(E2EVTPageConstants.PREFS, chromePrefs);
		// capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		// @SuppressWarnings("deprecation")
		// final WebDriver driver = new FirefoxDriver();
		// final WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Open E2EVT URL
		final String E2EVT_LoginURL = E2EVTPageConstants.E2EVT_URL;
		driver.get(E2EVT_LoginURL);
		Thread.sleep(E2EVTPageConstants.LONGWAIT);

		// Enter Login Credentials
		final WebElement userName = driver.findElement(By.xpath(E2EVTPageConstants.USERNAME_XPATH));
		userName.sendKeys(CommonConstants.USERNAME);
		final WebElement next = driver.findElement(By.xpath(E2EVTPageConstants.NEXT_XPATH));
		next.click();
		Thread.sleep(E2EVTPageConstants.LONGWAIT);

		final WebElement password = driver.findElement(By.xpath(E2EVTPageConstants.PASSWORD_XPATH));
		password.sendKeys(CommonConstants.PASSWORD);
		final WebElement loginBtn = driver.findElement(By.xpath(E2EVTPageConstants.LOGINBTN_XPATH));
		loginBtn.click();
		Thread.sleep(E2EVTPageConstants.LONGWAIT);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("duo_iframe");

		Thread.sleep(3000);
		// WebElement body = driver.findElement(By.xpath("//body"));

		driver.findElement(By.xpath("//button[contains(.,'Call Me')]")).click();

		driver.switchTo().defaultContent();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(30000);

		logger.debug("E2EVT login successful.");

		// Clear downloads folder
		this.clearDownloadFolder();
		// Execute positive test cases
		for (final Map.Entry<String, ReportDetail> entry : reportDetailsMap.entrySet()) {
			ReportDetail reportDetail = entry.getValue();

			// Enter UPID once page is loaded
			Thread.sleep(E2EVTPageConstants.LONGWAIT);
			final WebElement upid = driver.findElement(By.xpath(E2EVTPageConstants.UPID_XPATH));
			upid.clear();
			upid.sendKeys(reportDetail.getBodId());

			// Click on search button
			final WebElement searchBtn = driver.findElement(By.xpath(E2EVTPageConstants.SEARCHBTN_XPATH));
			searchBtn.click();
			Thread.sleep(E2EVTPageConstants.LONGWAIT);

			// Click on expand button
			final WebElement expandUPID = driver.findElement(By.xpath(E2EVTPageConstants.EXPANDUPID_XPATH));
			expandUPID.click();
			// Wait for transaction id details to get loaded
			Thread.sleep(E2EVTPageConstants.LONGWAIT);

			// Scroll downwards
			final JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript(E2EVTPageConstants.WINDOW_SCROLLBY);

			// Download B2B response
			final WebElement b2bResponseBtn = driver.findElement(By.xpath(E2EVTPageConstants.B2B_RESPONSEBTN));
			b2bResponseBtn.click();
			// Wait for B2B response file to get downloaded
			Thread.sleep(E2EVTPageConstants.LONGWAIT);

			// Download Crossflow response
			final WebElement crossflowResponseBtn = driver
					.findElement(By.xpath(E2EVTPageConstants.CROSSFLOW_RESPONSEBTN));
			crossflowResponseBtn.click();
			// Wait for crossflow response file to get downloaded
			Thread.sleep(E2EVTPageConstants.LONGWAIT);
			reportDetail = ufObj.renameResponseFiles(reportDetail);
			if (null != reportDetail)
				e2evtmap.put(entry.getKey(), reportDetail);
		}
		driver.close();
		return e2evtmap;
	}

	public void clearDownloadFolder() {
		final File downloadResponseFolder = new File(
				NGCConstants.NGCRESPONSE_BASEFOLDERPATH.concat(NGCConstants.E2EVTRESPONSE_DOWNLOADPATH));
		/*
		 * try { FileUtils.cleanDirectory(downloadResponseFolder); } catch (IOException
		 * e) { logger.error("Unable to clean directory :: {} ", e.getMessage()); }
		 */
		for (final File file : downloadResponseFolder.listFiles()) {
			if (!file.isDirectory()) {
				file.delete();
			}
		}
	}
}