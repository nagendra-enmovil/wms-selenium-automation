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
import com.wms.pageobjects.TrolleysPageObjects;

public class TrolleysServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static TrolleysPageObjects TrolleysObjects;
	private static Logger log = Logger.getLogger(TrolleysServices.class);
	
	// Initialize ProductsObjects
		public static void init() {
			TrolleysObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), TrolleysPageObjects.class);
		}
		
		public TrolleysServices toAddSingleTrolley(String trolleyname, String trolleynumber) {
			TrolleysObjects.getTrolleysButton().click();
			TrolleysObjects.getAddTrolleyButton().click();
			TrolleysObjects.getTrolleyName().sendKeys(trolleyname);
			TrolleysObjects.getTrolleyNumber().sendKeys(trolleynumber);
			TrolleysObjects.getFinishButton().click();
			log.info("Trolley details added successfully.");
	    	BrowserDriver.wait(2);
			Alert alert = BrowserDriver.getCurrentDriver().switchTo().alert();
			log.info(alert.getText());
			alert.accept();
			log.info("Alert accepted successfully!");
			return this;
		}
		
		public TrolleysServices clickChooseFile() {
			TrolleysObjects.getTrolleysButton().click();
			TrolleysObjects.getBulkUploadButton().click();
		    File consignmentFile = new File("src/main/resources/Excel-Data/Trolly sample data.xlsx");
		    BrowserDriver.waitForPageToLoad();
		    TrolleysObjects.getBuInputFiled().sendKeys(consignmentFile.getAbsolutePath());
		    BrowserDriver.wait(1);
		    TrolleysObjects.getSubmitBUtton().click();
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
		            TrolleysObjects.getPopupOkButton().click();
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
