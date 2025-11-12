package com.wms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WarehousePageObjects {
	
	@FindBy(xpath = "//button[text()='Add Warehouse']")
	private WebElement addWarehouseButton;
	
	@FindBy(xpath = "//input[@name='warehouse_id']")
	private WebElement warehouse_id;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement warehouse_name;
	
	@FindBy(xpath = "//input[@name='address']")
	private WebElement adress;
	
	@FindBy(xpath = "//input[@name='geo_codes']")
	private WebElement geo_codes;
	
	@FindBy(xpath = "//select[@name='country']")
	private WebElement countryClick;
	
	@FindBy(xpath = "//select[@name='state']")
	private WebElement stateClick;
	 
	@FindBy(xpath = "//select[@name='city']")
	private WebElement cityClick;
	
	@FindBy(xpath = "//input[@name='pin_code']")
	private WebElement pincode;
	
	@FindBy(xpath = "//select[@name='warehouse_type']")
	private WebElement warehouseTypeClick;
	
	@FindBy(xpath = "//select[@name='ownership']")
	private WebElement ownershipClick;
	
	@FindBy(xpath = "//select[@name='operational_status']")
	private WebElement operationalStatusClick;
	
	@FindBy(xpath = "//select[@name='automation_level']")
	private WebElement automationLevelClick;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='total_area']")
	private WebElement total_area;
	
	@FindBy(xpath = "//input[@name='storage_area']")
	private WebElement storage_area;
	
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement dateClick;
	
	@FindBy(xpath = "(//div[@class = 'react-datepicker__month']//div[@class='react-datepicker__week'])[5]//div[5]")
	private WebElement date;
	
	@FindBy(xpath = "//select[@name='shift']")
	private WebElement shiftClick;
	
	@FindBy(xpath = "//select[@name='shift_timings']")
	private WebElement shiftTimingsClick;
	
	@FindBy(xpath = "//select[@name='dock_capacity']")
	private WebElement dockCapacityClick;
	
	@FindBy(xpath = "//select[@name='security_gates']")
	private WebElement securityGatesClick;
	
	@FindBy(xpath = "//select[@name='staff']")
	private WebElement staffClick;
	
	@FindBy(xpath = "//select[@name='compliance_certifications']")
	private WebElement CCClick;
	
	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement fineshButton;

	public WebElement getAddWarehouseButton() {
		return addWarehouseButton;
	}

	public void setAddWarehouseButton(WebElement addWarehouseButton) {
		this.addWarehouseButton = addWarehouseButton;
	}

	public WebElement getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(WebElement warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public WebElement getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(WebElement warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	public WebElement getAdress() {
		return adress;
	}

	public void setAdress(WebElement adress) {
		this.adress = adress;
	}

	public WebElement getGeo_codes() {
		return geo_codes;
	}

	public void setGeo_codes(WebElement geo_codes) {
		this.geo_codes = geo_codes;
	}

	public WebElement getCountryClick() {
		return countryClick;
	}

	public void setCountryClick(WebElement countryClick) {
		this.countryClick = countryClick;
	}

	public WebElement getStateClick() {
		return stateClick;
	}

	public void setStateClick(WebElement stateClick) {
		this.stateClick = stateClick;
	}

	public WebElement getCityClick() {
		return cityClick;
	}

	public void setCityClick(WebElement cityClick) {
		this.cityClick = cityClick;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public void setPincode(WebElement pincode) {
		this.pincode = pincode;
	}

	public WebElement getWarehouseTypeClick() {
		return warehouseTypeClick;
	}

	public void setWarehouseTypeClick(WebElement warehouseTypeClick) {
		this.warehouseTypeClick = warehouseTypeClick;
	}

	public WebElement getOwnershipClick() {
		return ownershipClick;
	}

	public void setOwnershipClick(WebElement ownershipClick) {
		this.ownershipClick = ownershipClick;
	}

	public WebElement getOperationalStatusClick() {
		return operationalStatusClick;
	}

	public void setOperationalStatusClick(WebElement operationalStatusClick) {
		this.operationalStatusClick = operationalStatusClick;
	}

	public WebElement getAutomationLevelClick() {
		return automationLevelClick;
	}

	public void setAutomationLevelClick(WebElement automationLevelClick) {
		this.automationLevelClick = automationLevelClick;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	public WebElement getTotal_area() {
		return total_area;
	}

	public void setTotal_area(WebElement total_area) {
		this.total_area = total_area;
	}

	public WebElement getStorage_area() {
		return storage_area;
	}

	public void setStorage_area(WebElement storage_area) {
		this.storage_area = storage_area;
	}

	public WebElement getDateClick() {
		return dateClick;
	}

	public void setDateClick(WebElement dateClick) {
		this.dateClick = dateClick;
	}

	public WebElement getDate() {
		return date;
	}

	public void setDate(WebElement date) {
		this.date = date;
	}

	public WebElement getShiftClick() {
		return shiftClick;
	}

	public void setShiftClick(WebElement shiftClick) {
		this.shiftClick = shiftClick;
	}

	public WebElement getShiftTimingsClick() {
		return shiftTimingsClick;
	}

	public void setShiftTimingsClick(WebElement shiftTimingsClick) {
		this.shiftTimingsClick = shiftTimingsClick;
	}

	public WebElement getDockCapacityClick() {
		return dockCapacityClick;
	}

	public void setDockCapacityClick(WebElement dockCapacityClick) {
		this.dockCapacityClick = dockCapacityClick;
	}

	public WebElement getSecurityGatesClick() {
		return securityGatesClick;
	}

	public void setSecurityGatesClick(WebElement securityGatesClick) {
		this.securityGatesClick = securityGatesClick;
	}

	public WebElement getStaffClick() {
		return staffClick;
	}

	public void setStaffClick(WebElement staffClick) {
		this.staffClick = staffClick;
	}

	public WebElement getCCClick() {
		return CCClick;
	}

	public void setCCClick(WebElement cCClick) {
		CCClick = cCClick;
	}

	public WebElement getFineshButton() {
		return fineshButton;
	}

	public void setFineshButton(WebElement fineshButton) {
		this.fineshButton = fineshButton;
	}

//	public void selectStateByVisibleText(String stateText) {
//	    Select select = new Select(stateClick);
//	    select.selectByVisibleText(stateText);
//	}
//	
//	public void selectCityByVisibleText(String cityText) {
//	    Select select = new Select(cityClick);
//	    select.selectByVisibleText(cityText);
//	}
//	
//	public void selectWarehouseTypeByVisibleText(String WarehouseTypeText) {
//	    Select select = new Select(warehouseTypeClick);
//	    select.selectByVisibleText(WarehouseTypeText);
//	}
//	
//	public void selectOwnershipByVisibleText(String OwnershipText) {
//	    Select select = new Select(ownershipClick);
//	    select.selectByVisibleText(OwnershipText);
//	}
//	
//	public void selectOperationalStatusByVisibleText(String OperatiponalStatusText) {
//	    Select select = new Select(operationalStatusClick);
//	    select.selectByVisibleText(OperatiponalStatusText);
//	}
//	
//	public void selectAutomationLevelByVisibleText(String AutomationLevelText) {
//	    Select select = new Select(automationLevelClick);
//	    select.selectByVisibleText(AutomationLevelText);
//	}
//	
//	public void selectShiftByVisibleText(String ShiftText) {
//	    Select select = new Select(shiftClick);
//	    select.selectByVisibleText(ShiftText);
//	}
//	
//	public void selectShiftTimingsByVisibleText(String ShiftTimingsText) {
//	    Select select = new Select(shiftTimingsClick);
//	    select.selectByVisibleText(ShiftTimingsText);
//	}
//	
//	public void selectDockCapacityByVisibleText(String DockCapacityText) {
//	    Select select = new Select(dockCapacityClick);
//	    select.selectByVisibleText(DockCapacityText);
//	}
//	
//	public void selectSecurityGatesByVisibleText(String SecurityGatesText) {
//	    Select select = new Select(securityGatesClick);
//	    select.selectByVisibleText(SecurityGatesText);
//	}
//	
//	public void selectStaffByVisibleText(String StaffText) {
//	    Select select = new Select(staffClick);
//	    select.selectByVisibleText(StaffText);
//	}
//	
//	public void selectComplianceCertificationsByVisibleText(String ComplianceCertificationsText) {
//	    Select select = new Select(CCClick);
//	    select.selectByVisibleText(ComplianceCertificationsText);
//	}
}
