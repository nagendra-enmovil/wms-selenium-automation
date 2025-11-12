package com.wms.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BinRackPageObjects {
	
	@FindBy(xpath = "//button[text()='Zone - Bin - Rack']")
	private WebElement zoneBinRackButton;
	
	@FindBy(xpath = "//button[text()='Add Zone']")
	private WebElement addButtonClick;
	
	@FindBy(xpath = "//input[@name='zone_name']")
	private WebElement zoneNameEnter;
	
	@FindBy(xpath = "//input[@name='zone_code']")
	private WebElement zoneCodeEnter;
	
	@FindBy(xpath = "//input[@name='zone_description']")
	private WebElement zoneDescriptionEnter;
	
	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement fineshButton;
	
	@FindBy(xpath = "//button[text()='Zone-Bin-Rack']")
	private WebElement subZoneBinRackButton;
	
	@FindBy(xpath = "//div[@id='react-select-4-placeholder' and text()='Select Zone']")
	private WebElement selectZoneClick;
	
	@FindBy(xpath = "//div[starts-with(@id, 'react-select-4-option')]")
	private List<WebElement> selectZoneDropdown;
	
	@FindBy(xpath = "//button[text()='Bulk Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	
	// To Add Single BinRack
	
	@FindBy(xpath = "//button[text()='Add Bin-Rack']")
	private WebElement addBinRackButton;
	
	@FindBy(xpath = "//input[@name = 'bin_number']")
	private WebElement binNumber;
	
	@FindBy(xpath = "//input[@name = 'rack_number']")
	private WebElement rackNumber;
	
	@FindBy(xpath = "//input[@name = 'rack_name']")
    private WebElement rackName;
	
	public WebElement getZoneBinRackButton() {
		return zoneBinRackButton;
	}

	public void setZoneBinRackButton(WebElement zoneBinRackButton) {
		this.zoneBinRackButton = zoneBinRackButton;
	}

	public WebElement getAddButtonClick() {
		return addButtonClick;
	}

	public void setAddButtonClick(WebElement addButtonClick) {
		this.addButtonClick = addButtonClick;
	}

	public WebElement getZoneNameEnter() {
		return zoneNameEnter;
	}

	public void setZoneNameEnter(WebElement zoneNameEnter) {
		this.zoneNameEnter = zoneNameEnter;
	}

	public WebElement getZoneCodeEnter() {
		return zoneCodeEnter;
	}

	public void setZoneCodeEnter(WebElement zoneCodeEnter) {
		this.zoneCodeEnter = zoneCodeEnter;
	}

	public WebElement getZoneDescriptionEnter() {
		return zoneDescriptionEnter;
	}

	public void setZoneDescriptionEnter(WebElement zoneDescriptionEnter) {
		this.zoneDescriptionEnter = zoneDescriptionEnter;
	}

	public WebElement getFineshButton() {
		return fineshButton;
	}

	public void setFineshButton(WebElement fineshButton) {
		this.fineshButton = fineshButton;
	}

	public WebElement getSubZoneBinRackButton() {
		return subZoneBinRackButton;
	}

	public void setSubZoneBinRackButton(WebElement subZoneBinRackButton) {
		this.subZoneBinRackButton = subZoneBinRackButton;
	}

	public WebElement getSelectZoneClick() {
		return selectZoneClick;
	}

	public void setSelectZoneClick(WebElement selectZoneClick) {
		this.selectZoneClick = selectZoneClick;
	}

	public List<WebElement> getSelectZoneDropdown() {
		return selectZoneDropdown;
	}

	public void setSelectZoneDropdown(List<WebElement> selectZoneDropdown) {
		this.selectZoneDropdown = selectZoneDropdown;
	}

	public WebElement getBulkUploadButton() {
		return bulkUploadButton;
	}

	public void setBulkUploadButton(WebElement bulkUploadButton) {
		this.bulkUploadButton = bulkUploadButton;
	}

	public WebElement getBuInputFiled() {
		return buInputFiled;
	}

	public void setBuInputFiled(WebElement buInputFiled) {
		this.buInputFiled = buInputFiled;
	}

	public WebElement getSubmitBUtton() {
		return submitBUtton;
	}

	public void setSubmitBUtton(WebElement submitBUtton) {
		this.submitBUtton = submitBUtton;
	}

	public WebElement getPopupOkButton() {
		return popupOkButton;
	}

	public void setPopupOkButton(WebElement popupOkButton) {
		this.popupOkButton = popupOkButton;
	}
	
	public WebElement getAddBinRackButton() {
		return addBinRackButton;
	}

	public void setAddBinRackButton(WebElement addBinRackButton) {
		this.addBinRackButton = addBinRackButton;
	}

	public WebElement getBinNumber() {
		return binNumber;
	}

	public void setBinNumber(WebElement binNumber) {
		this.binNumber = binNumber;
	}

	public WebElement getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(WebElement rackNumber) {
		this.rackNumber = rackNumber;
	}

	public WebElement getRackName() {
		return rackName;
	}

	public void setRackName(WebElement rackName) {
		this.rackName = rackName;
	}
	
	

	public void selectOption(String optionText) {
        for (WebElement option : selectZoneDropdown) {
            if (option.getText().equalsIgnoreCase(optionText)) {
//            if (option.getText().trim().equalsIgnoreCase(optionText.trim())) {
                option.click();
                break;
            }
        }
    }
	
}
