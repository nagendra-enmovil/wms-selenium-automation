package com.wms.services;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.pageobjects.BaysPageObjects;

public class BaysServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static BaysPageObjects BaysObjects;
	private static Logger log = Logger.getLogger(BaysServices.class);
	
	// Initialize ProductsObjects
		public static void init() {
			BaysObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), BaysPageObjects.class);
		}
		
		public BaysServices addingSingleBay(String bayname, String baynumber) {
			BaysObjects.getBaysButton().click();
			BaysObjects.getAddBayButton().click();
			BaysObjects.getBayName().sendKeys(bayname);
			BaysObjects.getBayNumber().sendKeys(baynumber);
			BaysObjects.getFinishButton().click();
			log.info("Bay details added successfully.");
	    	BrowserDriver.wait(2);
			Alert alert = BrowserDriver.getCurrentDriver().switchTo().alert();
			log.info(alert.getText());
			alert.accept();
			log.info("Alert accepted successfully!");
			return this;
		}
		
		public BaysServices clickChooseFile() {
			BaysObjects.getBaysButton().click();
			BaysObjects.getBulkUploadButton().click();
		    File consignmentFile = new File("src/main/resources/Excel-Data/Bay smaple data.xlsx");
		    BrowserDriver.waitForPageToLoad();
		    BaysObjects.getBuInputFiled().sendKeys(consignmentFile.getAbsolutePath());
		    BrowserDriver.wait(1);
		    BaysObjects.getSubmitBUtton().click();
		    WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));

		    try {
		        popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//div[@class='sweet-alert ']//h2")
		        ));
		        popupMessage = popup.getText().trim();
		        log.info("Popup message received: " + popupMessage);
		    } catch (TimeoutException e) {
		        log.error("❌ No popup message found within timeout!", e);
		        Assert.fail("Bulk upload popup did not appear.");
		    } finally {
		        try {
		            BrowserDriver.wait(1);
		            BaysObjects.getPopupOkButton().click();
		        } catch (Exception e) {
		            log.warn("⚠️ Failed to click OK button on popup", e);
		        }
		    }
		    if ("Data Uploaded Successfully".equalsIgnoreCase(popupMessage)) {
		        log.info("✅ Bulk upload success: " + popupMessage);
		    } else {
		        log.info("❌ Bulk upload failed with message: " + popupMessage);
		        Assert.fail("Bulk upload failed with message: " + popupMessage);
		    }

		    return this;
		}
}
