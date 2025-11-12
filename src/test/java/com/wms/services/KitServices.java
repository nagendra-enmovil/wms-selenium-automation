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
import com.wms.pageobjects.KitPageObjects;

public class KitServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static KitPageObjects KitObjects;
	private static Logger log = Logger.getLogger(KitServices.class);
	
	// Initialize ProductsObjects
		public static void init() {
			KitObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), KitPageObjects.class);
		}
		
		public KitServices toAddSingleKit(String kitid, String kitname, String kitdescription) {
			KitObjects.getKitButton().click();
			KitObjects.getAddKitButton().click();
			KitObjects.getKitId().sendKeys(kitid);
			KitObjects.getKitName().sendKeys(kitname);
			KitObjects.getKitDescription().sendKeys(kitdescription);
			KitObjects.getSubmitButton().click();
			log.info("Kit details added successfully.");
	    	BrowserDriver.wait(1);
	    	KitObjects.getPopupOkButton().click();
			return this;
		}
		
		public KitServices clickChooseFile() {
			KitObjects.getKitButton().click();
			KitObjects.getBulkUploadButton().click();
		    File consignmentFile = new File("src/main/resources/Excel-Data/Kit sample data.xlsx");
		    BrowserDriver.waitForPageToLoad();
		    KitObjects.getBuInputFiled().sendKeys(consignmentFile.getAbsolutePath());
		    BrowserDriver.wait(1);
		    KitObjects.getSubmitBUtton().click();
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
		            BrowserDriver.wait(1); // wait a bit before clicking
		            KitObjects.getPopupOkButton().click();
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
