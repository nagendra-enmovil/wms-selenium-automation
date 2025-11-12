package com.wms.services;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.pageobjects.WarehousePageObjects;


public class WarehouseServices {
	
	public static WarehousePageObjects warehouseobjects;
	private static Logger log = Logger.getLogger(WarehouseServices.class);
	
	public static void init() {
		warehouseobjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), WarehousePageObjects.class);
	}
	
//	public WarehouseServices warehouseOperations(String warehouse_id, String warehouse_name, String adress, String geo_codes, String pincode, String total_area, String storage_area) {
//		warehouseobjects.getAddWarehouseButton().click();
//		BrowserDriver.wait(2);
//		warehouseobjects.getWarehouse_id().sendKeys(warehouse_id);
//		warehouseobjects.getWarehouse_name().sendKeys(warehouse_name);
//		warehouseobjects.getAdress().sendKeys(adress);
//		warehouseobjects.getGeo_codes().sendKeys(geo_codes);
//		warehouseobjects.getStateClick().click();
//		warehouseobjects.selectStateByVisibleText("Telangana");
//		warehouseobjects.getCityClick().click();
//		warehouseobjects.selectCityByVisibleText("Hyderabad");
//		warehouseobjects.getPincode().sendKeys(pincode);
//		warehouseobjects.getWarehouseTypeClick().click();
//		warehouseobjects.selectWarehouseTypeByVisibleText("Cold Storage");
//		warehouseobjects.getOwnershipClick().click();
//		warehouseobjects.selectOwnershipByVisibleText("Leased");
//		warehouseobjects.getOperationalStatusClick().click();
//		warehouseobjects.selectOperationalStatusByVisibleText("Operational");
//		warehouseobjects.getAutomationLevelClick().click();
//		warehouseobjects.selectAutomationLevelByVisibleText("Manual");
//		warehouseobjects.getContinueButton().click();
//		BrowserDriver.wait(2);
//		warehouseobjects.getTotal_area().sendKeys(total_area);
//		warehouseobjects.getStorage_area().sendKeys(storage_area);
//		warehouseobjects.getDateClick().click();
//		warehouseobjects.getDate().click();
//		warehouseobjects.getShiftClick().click();
//		warehouseobjects.selectShiftByVisibleText("Day");
//		warehouseobjects.getShiftTimingsClick().click();
//		warehouseobjects.selectShiftTimingsByVisibleText("Weekend Only");
//		warehouseobjects.getDockCapacityClick().click();
//		warehouseobjects.selectDockCapacityByVisibleText("Multipurpose");
//		warehouseobjects.getSecurityGatesClick().click();
//		warehouseobjects.selectSecurityGatesByVisibleText("In/Out");
//		warehouseobjects.getStaffClick().click();
//		warehouseobjects.selectStaffByVisibleText("Full Time");
//		warehouseobjects.getCCClick().click();
//		warehouseobjects.selectComplianceCertificationsByVisibleText("Green");
//		warehouseobjects.getFineshButton().click();
//		log.info("Warehouse details added successfully.");
//		BrowserDriver.wait(2);
//		Alert alert = BrowserDriver.getCurrentDriver().switchTo().alert();
//		log.info(alert.getText());
//		alert.accept();
//		log.info("Alert accepted successfully!");
//		return this;
//	}
	
	public void selectDropdown(WebElement element, String visibleText) {
		element.click();
		BrowserDriver.wait(2);
	    Select dropdown = new Select(element);
	    dropdown.selectByVisibleText(visibleText);
	}
	
	public String getCellValueAsString(Cell cell) {
	    if (cell == null) return "";

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString(); // or format with SimpleDateFormat
	            } else {
	                return String.valueOf((long) cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}

	
	public WarehouseServices warehouseGeneralInfoData() {
		
		String Filepath = "src/main/resources/Excel-Data/warehousegeneralinfodata.xlsx";
		try(FileInputStream fis = new FileInputStream(Filepath);
				Workbook workbook = new XSSFWorkbook(fis)){
			    Sheet sheet = workbook.getSheetAt(0);
			    
			    for(int i=1; i<=sheet.getLastRowNum(); i++) {
			    	Row row = sheet.getRow(i);
			    	
			    	warehouseobjects.getAddWarehouseButton().click();
			    	BrowserDriver.wait(1);
			    	
			    	String warehouseid = getCellValueAsString(row.getCell(0));
			    	String warehousename = getCellValueAsString(row.getCell(1));
			    	String address = getCellValueAsString(row.getCell(2));
			    	String geocodes = getCellValueAsString(row.getCell(3));
			    	String state = getCellValueAsString(row.getCell(4));
			    	String city = getCellValueAsString(row.getCell(5));
			    	String pincode = getCellValueAsString(row.getCell(6));
			    	String warehousetype = getCellValueAsString(row.getCell(7));
			    	String ownership = getCellValueAsString(row.getCell(8));
			    	String operationalstatus = getCellValueAsString(row.getCell(9));
			    	String automtionlevel = getCellValueAsString(row.getCell(10));
			    	String totalarea = getCellValueAsString(row.getCell(11));
			    	String stotagearea = getCellValueAsString(row.getCell(12));
			    	String shift = getCellValueAsString(row.getCell(13));
			    	String shifttiming = getCellValueAsString(row.getCell(14));
			    	String dockcapacity = getCellValueAsString(row.getCell(15));
			    	String securitygates = getCellValueAsString(row.getCell(16));
			    	String staff = getCellValueAsString(row.getCell(17));
			    	String cc = getCellValueAsString(row.getCell(18));

			    	
			    	warehouseobjects.getWarehouse_id().clear();
			    	warehouseobjects.getWarehouse_id().sendKeys(warehouseid);
			    	
			    	warehouseobjects.getWarehouse_name().clear(); 
			    	warehouseobjects.getWarehouse_name().sendKeys(warehousename);
			    	
			    	warehouseobjects.getAdress().clear();
			    	warehouseobjects.getAdress().sendKeys(address);
			    	
			    	warehouseobjects.getGeo_codes().clear();
			    	warehouseobjects.getGeo_codes().sendKeys(geocodes);
			    	
			    	warehouseobjects.getPincode().clear();
			    	warehouseobjects.getPincode().sendKeys(pincode);
			    	
			    	
			    	selectDropdown(warehouseobjects.getStateClick(), state);
			    	selectDropdown(warehouseobjects.getCityClick(), city);
			    	selectDropdown(warehouseobjects.getWarehouseTypeClick(), warehousetype);
			    	selectDropdown(warehouseobjects.getOwnershipClick(), ownership);
			    	selectDropdown(warehouseobjects.getOperationalStatusClick(), operationalstatus);
			    	selectDropdown(warehouseobjects.getAutomationLevelClick(), automtionlevel);
			    	
			    	warehouseobjects.getContinueButton().click();
			    	BrowserDriver.wait(2);
			    	
			    	warehouseobjects.getTotal_area().clear();
			    	warehouseobjects.getTotal_area().sendKeys(totalarea);
			    	
			    	warehouseobjects.getStorage_area().clear();
			    	warehouseobjects.getStorage_area().sendKeys(stotagearea);
			    	
			    	selectDropdown(warehouseobjects.getShiftClick(), shift);
			    	selectDropdown(warehouseobjects.getShiftTimingsClick(), shifttiming);
			    	selectDropdown(warehouseobjects.getDockCapacityClick(), dockcapacity);
			    	selectDropdown(warehouseobjects.getSecurityGatesClick(), securitygates);
			    	selectDropdown(warehouseobjects.getStaffClick(), staff);
			    	selectDropdown(warehouseobjects.getCCClick(), cc);
			    	
			    	BrowserDriver.wait(5);
			    	warehouseobjects.getFineshButton().click();
			    	
			    	log.info("Warehouse details added successfully.");
			    	BrowserDriver.wait(2);
					Alert alert = BrowserDriver.getCurrentDriver().switchTo().alert();
					log.info(alert.getText());
					alert.accept();
					log.info("Alert accepted successfully!");
			    	
			    }
		} catch (Exception e) {
			log.error("Error reading Excel file:", e);
		}
		return this;
	}
}
