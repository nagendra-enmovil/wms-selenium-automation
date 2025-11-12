package com.wms.services;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.pageobjects.ProductsScreenPageObjects;

public class ProductsScreenServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static ProductsScreenPageObjects ProductObjects;
	private static Logger log = Logger.getLogger(ProductsScreenServices.class);
	
	// Initialize ProductsObjects
		public static void init() {
			ProductObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), ProductsScreenPageObjects.class);
		}
		
		public ProductsScreenServices toAddSingleProduct() {
			ProductObjects.getProductsButton().click();
			ProductObjects.getAddProductButton().click();
			ProductObjects.getSku().sendKeys("ENV-001");
			ProductObjects.getProductName().sendKeys("Iron");
			ProductObjects.getProductCategory().click();
			ProductObjects.selectCategoryByVisibleText("Spare Parts");
			ProductObjects.getProductdescription().sendKeys("Iron");
			ProductObjects.getUnitCost().sendKeys("2000");
			ProductObjects.getSubmitProductButton().click();
			BrowserDriver.wait(5);
			ProductObjects.getPopupOkButton().click();
			return this;
		}
		
		public ProductsScreenServices clickChooseFile() {
			ProductObjects.getProductsButton().click();
			ProductObjects.getBulkUploadButton().click();
		    File consignmentFile = new File("src/main/resources/Excel-Data/warehouse_products_sample_data.xlsx");
		    BrowserDriver.waitForPageToLoad();
		    ProductObjects.getBuInputFiled().sendKeys(consignmentFile.getAbsolutePath());
		    BrowserDriver.wait(1);
		    ProductObjects.getSubmitBUtton().click();
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
		            ProductObjects.getPopupOkButton().click();
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






















