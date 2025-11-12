package com.wms.services;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.wms.config.BrowserDriver;
import com.wms.data.WmsDataConfig;
import com.wms.pageobjects.BinRackPageObjects;

public class BinRackServices {
	
	String popupMessage = null;
    WebElement popup = null;
	
	public static BinRackPageObjects BinRackObjects;
	private static Logger log = Logger.getLogger(BinRackServices.class);
	
	// Initialize ProductsObjects
		public static void init() {
			BinRackObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), BinRackPageObjects.class);
		}
		
//		public BinRackServices ToAddSingleZoneBinRackUsingBulkUPload() {
//			
//			BinRackObjects.getZoneBinRackButton().click();
//			BinRackObjects.getAddButtonClick().click();
//			BrowerDriver.wait(3);
//			BinRackObjects.getZoneNameEnter().sendKeys("Zone1");
//			BinRackObjects.getZoneCodeEnter().sendKeys("ABYZ01");
//			BinRackObjects.getZoneDescriptionEnter().sendKeys("First Zone");
//			BinRackObjects.getFineshButton().click();
//			BrowerDriver.wait(5);
//			Alert alert = BrowerDriver.getCurrentDriver().switchTo().alert();
//			log.info(alert.getText());
//			alert.accept();
//			log.info("Alert accepted successfully!");
//			BinRackObjects.getSubZoneBinRackButton().click();
//			BinRackObjects.getBulkUploadButton().click();
//			BinRackObjects.getSelectZoneClick().click();
//			BrowerDriver.wait(2);
//			BinRackObjects.selectOption("Zone1 (ABYZ01)");
////			BrowerDriver.wait(3);
////			BrowerDriver.waitForElementVisible(By.id("react-select-4-listbox"), 5);
////			BinRackObjects.selectOption("Zone1 (ABYZ01)");
////			BrowerDriver.wait(2);
//			return this;
//		}
		
//		public BinRackServices ToAddSingleBinRack(String binnumber, String racknumber, String rackname) {
//		BinRackObjects.getAddBinRackButton().click();
//		BinRackObjects.getSelectZoneClick().click();
//		BrowserDriver.wait(2);
//		BinRackObjects.selectOption("Southwest Zone (ZSW-10)");
////		BrowerDriver.wait(3);
////		BrowerDriver.waitForElementVisible(By.id("react-select-4-listbox"), 5);
////		BinRackObjects.selectOption("Zone1 (ABYZ01)");
////		BrowerDriver.wait(2);
//		BinRackObjects.getBinNumber().sendKeys(binnumber);
//		BinRackObjects.getRackNumber().sendKeys(racknumber);
//		BinRackObjects.getRackName().sendKeys(rackname);
//		return this;
//	}
		
		public BinRackServices creatingZonesWithExcel() {
			
			BinRackObjects.getZoneBinRackButton().click();
			BinRackObjects.getAddButtonClick().click();
			BrowserDriver.wait(2);
			String Filepath = "src/main/resources/Excel-Data/Zoneslist.xlsx";
			try (FileInputStream fis = new FileInputStream(Filepath);
					Workbook workbook = new XSSFWorkbook(fis)){
				    Sheet sheet = workbook.getSheetAt(0);
				    int lastRow = sheet.getLastRowNum();
				    
				 for(int i=1; i <= lastRow; i++) {
					 Row row = sheet.getRow(i);
					 
					 String zonename = row.getCell(0).getStringCellValue();
					 String zonecode = row.getCell(1).getStringCellValue();
					 String zonedescription = row.getCell(2).getStringCellValue();
					 
					 BinRackObjects.getZoneNameEnter().clear();
					 BinRackObjects.getZoneNameEnter().sendKeys(zonename);
					 
					 BinRackObjects.getZoneCodeEnter().clear();
					 BinRackObjects.getZoneCodeEnter().sendKeys(zonecode);
					 
					 BinRackObjects.getZoneDescriptionEnter().clear();
					 BinRackObjects.getZoneDescriptionEnter().sendKeys(zonedescription);
					 
					 BinRackObjects.getFineshButton().click();
					 BrowserDriver.wait(2);
					 
					 Alert alert = BrowserDriver.getCurrentDriver().switchTo().alert();
				     log.info(alert.getText());
					 alert.accept();
					 log.info("Alert accepted successfully!");
					 BrowserDriver.wait(2);
					 
					 if (i < lastRow) {
			                BinRackObjects.getAddButtonClick().click();
			                BrowserDriver.wait(1);
			            }
				 }
				
			} catch (Exception e) {
				log.error("Error reading Excel file:", e);
			}
			return this;
		}
		
		public BinRackServices clickChooseFile() {
			BinRackObjects.getZoneBinRackButton().click();
			BrowserDriver.wait(1);
		    BinRackObjects.getSubZoneBinRackButton().click();
		    BrowserDriver.wait(1);

		    List<String> zoneList = Arrays.asList(
		    		"Southwest Zone (ZSW-10)",
		    		"Northeast Zone (ZNE-09)",
			        "Rural Zone (ZR-R08)",
			        "Metro Zone (ZM-M07)",
			        "Coastal Zone (ZCO-06)",
			        "Central Zone (ZC-C05)",
			        "West Supply Zone (ZW-S04)",
			        "East Trade Zone (ZE-T03)",
			        "South Zone (ZS-S02)",
			        "North Zone (ZN-N01)"
		    );
		    
//		    List<String> zoneList = WmsDataConfig.readZonesFromFile("Excel-Data/zone-list.txt");
		    
		    WebDriver driver = BrowserDriver.getCurrentDriver();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    for (String zone : zoneList) {
		        log.info("Processing zone: " + zone);
		        
		        BinRackObjects.getBulkUploadButton().click();
		        
		        WebDriverWait wait2 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
		        WebElement dropdown = wait2.until(ExpectedConditions.visibilityOfElementLocated(
		        	    By.xpath("//div[@id='react-select-4-placeholder' and text()='Select Zone']")
		        	));

		        	Actions actions = new Actions(BrowserDriver.getCurrentDriver());
		        	actions.moveToElement(dropdown).click().perform();
		        
		        WebDriverWait wait1 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(5));
		        WebElement optionToSelect = wait1.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//div[contains(@class, '-option') and text()='" + zone + "']")
		        ));

		        optionToSelect.click();
		        log.info("✅ Selected Zone: " + zone);

		        File file = new File("src/main/resources/Excel-Data/Bin-Rack-Sample Data.xlsx");
		        BinRackObjects.getBuInputFiled().sendKeys(file.getAbsolutePath());
		        BrowserDriver.wait(1);
		        BinRackObjects.getSubmitBUtton().click();

		        WebElement popup = wait2.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//div[@class='sweet-alert ']//h2")
		        ));
		        String popupMessage = popup.getText().trim();
		        log.info("Popup message received: " + popupMessage);

		        try {
		            BinRackObjects.getPopupOkButton().click();
		        } catch (Exception e) {
		            log.warn("⚠️ Failed to click popup OK", e);
		        }

		        if (!popupMessage.equalsIgnoreCase("Data Uploaded Successfully")) {
		            Assert.fail("❌ Bulk upload failed for zone " + zone + " with message: " + popupMessage);
		        }

		        log.info("✅ Bulk upload success for zone: " + zone);
		        BrowserDriver.wait(1);
		    }

		    return this;
		}
		

}
