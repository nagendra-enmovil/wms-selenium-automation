package com.wms.services;

import static org.assertj.core.api.Assertions.in;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.pageobjects.InboundObjects;

public class InboundServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static InboundObjects inboundobjects;
	private static Logger log = Logger.getLogger(InboundServices.class);
	
	public static void init() {
		inboundobjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), InboundObjects.class);
	}
	
	public InboundServices inboundActivities() {
		inboundobjects.getInboundButton().click();
		inboundobjects.getBulkUploadButton().click();
		File asndata = new File("src/main/resources/Excel-Data/Inbound-asn-data2.xlsx");
		BrowserDriver.waitForPageToLoad();
		inboundobjects.getBuInputFiled().sendKeys(asndata.getAbsolutePath());
		BrowserDriver.wait(1);
		inboundobjects.getSubmitBUtton().click();
		WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
		try {
			popup = wait.until(ExpectedConditions.visibilityOf(
		            inboundobjects.getSweetAlertMsg()
		        ));
		        popupMessage = popup.getText().trim();
		        log.info("Popup message received: " + popupMessage);
		} catch (TimeoutException e) {
			 log.error("❌ No popup message found within timeout!", e);
		        Assert.fail("Bulk upload popup did not appear.");
		} finally {
			try {
				BrowserDriver.wait(1);
				inboundobjects.getPopupOkButton().click();
			} catch (Exception e) {
				log.warn("⚠️ Failed to click OK button on popup", e);
			}
		}
		if("Data Uploaded Successfully".equalsIgnoreCase(popupMessage)) {
			log.info("✅ Bulk upload success: " + popupMessage);
		} else {
			log.info("❌ Bulk upload failed with message: " + popupMessage);
	        Assert.fail("Bulk upload failed with message: " + popupMessage);
		}
		return this;
	}
	
	public InboundServices inboundAsnProcess() throws InterruptedException {
		inboundobjects.getInboundButton().click();
		BrowserDriver.wait(1);
		inboundobjects.getPendingBayTab().click();
		inboundobjects.getAssignBayButton().click();
		BrowserDriver.wait(1);
		inboundobjects.getSelectBayDropdown().click();

		WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(inboundobjects.getDropdownOptions()));

		List<WebElement> options = inboundobjects.getDropdownOptions();
		for (WebElement option : options) {
		    log.info(option.getText());
		}
		
		Random rnd = new Random();
		int randomindex = rnd.nextInt(options.size());
		WebElement selectedBay = options.get(randomindex);
		
		System.out.println("Selected Bay: " + selectedBay.getText());
		selectedBay.click();
		
		inboundobjects.getSelectExecutiveDropdown().click();
		WebDriverWait wait1 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfAllElements(inboundobjects.getDropdownOptions()));

		List<WebElement> options1 = inboundobjects.getDropdownOptions();
		for (WebElement option : options1) {
		    log.info(option.getText());
		}
		
		Random rnd1 = new Random();
		int randomindex1 = rnd1.nextInt(options1.size());
		WebElement selectedBay1 = options1.get(randomindex1);
		
		System.out.println("Selected Bay: " + selectedBay1.getText());
		selectedBay1.click();
		
		inboundobjects.getSubmitAssignBayButton().click();
		
		WebDriverWait wait2 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));

	    try {
	        popup = wait2.until(ExpectedConditions.visibilityOf(
	            inboundobjects.getPopupMessage()
	        ));
	        popupMessage = popup.getText().trim();
	        log.info("Popup message received: " + popupMessage);
	    } catch (TimeoutException e) {
	        log.error("❌ No popup message found within timeout!", e);
	        Assert.fail("Success popup message did not appear.");
	    } finally {
	        try {
	            BrowserDriver.wait(1);
	            inboundobjects.getSuccessPopupOkButton().click();
	        } catch (Exception e) {
	            log.warn("⚠️ Failed to click OK button on popup", e);
	        }
	    }
	    if ("Bay Assigned to Executive Successfully".equalsIgnoreCase(popupMessage)) {
	        log.info("✅ Bay Assigned to Executive Successfully: " + popupMessage);
	    } else {
	        log.info("❌ Bay Assign failed with message: " + popupMessage);
	        Assert.fail("Bay Assign failed with message: " + popupMessage);
	    }
	    
	    inboundobjects.getPendingUnloadsTab().click();
	    BrowserDriver.wait(1);
	    inboundobjects.getStartUnloadButton().click();
	    BrowserDriver.wait(1);
	    inboundobjects.getReceivedQuantityfield().click();
	    inboundobjects.getEnterDataInReceivedQuan().sendKeys("100");
	    inboundobjects.getReceivedQuantityfield2().click();
	    inboundobjects.getEnterDataInReceivedQuan2().sendKeys("300");
	    inboundobjects.getReceivedQuantityfield3().click();
	    inboundobjects.getEnterDataInReceivedQuan3().sendKeys("200");
	    inboundobjects.getEnterDataInReceivedQuan3().sendKeys(Keys.ENTER);
	    List<WebElement> editIcons = BrowserDriver.getCurrentDriver().findElements(By.xpath("//span[@title='Editable']"));

	    for (int i = 0; i < editIcons.size(); i++) {
	        WebElement icon = editIcons.get(i);
	        new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(icon))
	            .click();
	        
	        Thread.sleep(1000);
	    }
	    
	    inboundobjects.getReceivedQuantityfield().click();
	    inboundobjects.getEnterDataInReceivedQuan().sendKeys("100");
	    
	    for (int i = 1; i <= 3; i++) {
	    	String cellXpath = "(//div[@col-id='received_quantity'])[" + i + "]";
	    	WebDriverWait wait3 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
	        WebElement cell = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cellXpath)));

	        // Step 2: Click the editable icon inside the cell
	        WebElement editIcon = cell.findElement(By.xpath(".//span[@title='Editable']"));
	        wait3.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
	        
	        WebElement inputField = wait3.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath(cellXpath + "//input")
	            ));

	            // Step 4: Clear and enter value
	            inputField.clear();
	            inputField.sendKeys("100");
	    }
	    
	    List<WebElement> editIcons1 = BrowserDriver.getCurrentDriver().findElements(By.xpath("//span[@title='Editable']"));

	    System.out.println("Total Editable Fields Found: " + editIcons1.size());

	    WebDriverWait wait4 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));

	    for (int i = 0; i < editIcons1.size(); i++) {
	        WebElement icon = editIcons1.get(i);
	        
	        // Scroll into view just in case
//	        ((JavascriptExecutor) BrowserDriver.getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", icon);
	        
	        // Click the editable icon
	        wait4.until(ExpectedConditions.elementToBeClickable(icon)).click();

	        // Wait for input or textarea to appear after click
	        try {
	            WebElement inputField = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' or @type='number']")));
	            inputField.clear();
	            inputField.sendKeys("100");
	        } catch (TimeoutException e) {
	            WebElement textarea = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea")));
	            textarea.clear();
	            textarea.sendKeys("100");
	        }

	        Thread.sleep(500);  // Slight pause for stability
	    }
	    
	    
	    WebDriverWait wait5 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
	    
	    for (int row = 1; row <= 3; row++) {
	     // Step 1: Click the edit icon inside Received Quantity cell
	     String editIconXpath = "(//span[@title='Editable'])[" + row + "]";
	     WebElement editIcon = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(editIconXpath)));
	     editIcon.click();

	     // Step 2: Wait for the input field to appear inside the editable cell
	     String inputXpath = "(//div[@col-id='received_quantity' and contains(@class, 'ag-cell-inline-editing')])[" + row + "]//input";
	     WebElement inputField = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXpath)));

	     // Step 3: Clear and send different value (for example row index)
	     inputField.clear();
	     inputField.sendKeys(String.valueOf(row * 100));  // e.g., 100, 200, 300
	     
	     inputField.sendKeys(Keys.TAB);
	     BrowserDriver.wait(1);
	 }


		return this;
	}
	
//	public void enterRowData(List<Map<String, String>> rowDataList) {
//        WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
//
//        for (Map<String, String> rowData : rowDataList) {
//            String sku = rowData.get("SKU");
//            String receivedQty = rowData.get("ReceivedQuantity");
//            String batchNo = rowData.get("BatchLotNo");
//            String trolleyOption = rowData.get("TrolleyOption");
//
//            try {
//                WebElement row = BrowserDriver.getCurrentDriver().findElement(By.xpath("//div[contains(@class,'ag-row')][div[text()='" + sku + "']]"));
//
//                // ---- Enter Received Quantity ----
//                WebElement receivedCell = row.findElement(By.xpath(".//div[@col-id='received_quantity']"));
//                receivedCell.click();
//                WebElement receivedInput = receivedCell.findElement(By.tagName("input"));
//                receivedInput.clear();
//                receivedInput.sendKeys(receivedQty);
//
//                // ---- Enter Batch / Lot No ----
//                WebElement batchCell = row.findElement(By.xpath(".//div[@col-id='batch_lot_number']"));
//                batchCell.click();
//                WebElement batchInput = batchCell.findElement(By.tagName("input"));
//                batchInput.clear();
//                batchInput.sendKeys(batchNo);
//
//                // ---- Select from Trolley Dropdown ----
//                WebElement trolleyCell = row.findElement(By.xpath(".//div[@col-id='pallet_trolly_number']"));
//                trolleyCell.click();
//
//                // Wait for dropdown option to appear
//                WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//div[contains(@class,'ag-popup')]//span[text()='" + trolleyOption + "']")));
//                dropdownOption.click();
//
//                System.out.println("Data entered successfully for SKU: " + sku);
//
//            } catch (NoSuchElementException | TimeoutException e) {
//                System.out.println("Failed to process SKU: " + sku + " - " + e.getMessage());
//            }
//        }
//    }
//	
//	public void prepareAndSubmitRowData() {
//	    TableRowEntry helper = new TableRowEntry(BrowserDriver.getCurrentDriver());
//
//	    List<Map<String, String>> dataList = new ArrayList<>();
//
//	    // Simulating your Excel/row input
//	    Map<String, String> row1 = new HashMap<>();
//	    row1.put("SKU", "PID2018");
//	    row1.put("ReceivedQuantity", "45");
//	    row1.put("BatchLotNo", "B123");
//	    row1.put("TrolleyOption", "Bay-015");
//	    dataList.add(row1);
//
//	    Map<String, String> row2 = new HashMap<>();
//	    row2.put("SKU", "PID2017");
//	    row2.put("ReceivedQuantity", "60");
//	    row2.put("BatchLotNo", "B124");
//	    row2.put("TrolleyOption", "Bay-011");
//	    dataList.add(row2);
//
//	    // Call the service method
//	    helper.enterRowData(dataList);
//	}
}
