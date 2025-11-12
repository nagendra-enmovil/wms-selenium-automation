package com.wms.services;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.data.WmsDataConfig;
import com.wms.pageobjects.LoginObjects;

public class LoginService {
	
	public static LoginObjects LoginObjects;
	private static Logger log = Logger.getLogger(LoginService.class);
	
	// Initialize LoginObjects
	public static void init() {
		LoginObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginObjects.class);
	}
	
	public LoginService loginToWms(String username, String password) {
		try {
			BrowserDriver.waitForPageToLoad();
			LoginObjects.getUserName().sendKeys(username);
			LoginObjects.getPassWord().sendKeys(password);
			LoginObjects.getLoginButton().click();
			LoginObjects.getWareHouseManag().click();
			BrowserDriver.wait(1);
			log.info("User logged in successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
