package com.wms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KitPageObjects {
	
	@FindBy(xpath = "//button[text()='Kits']")
	private WebElement kitButton;
	
	@FindBy(xpath = "//button[text()='Bulk Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	
	@FindBy(xpath = "//button[text() = 'Add KIT']")
	private WebElement addKitButton;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter KIT ID']")
	private WebElement kitId;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter KIT Name']")
	private WebElement kitName;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter KIT Description']")
	private WebElement kitDescription;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	private WebElement submitButton;

	public WebElement getKitButton() {
		return kitButton;
	}

	public void setKitButton(WebElement kitButton) {
		this.kitButton = kitButton;
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

	public WebElement getAddKitButton() {
		return addKitButton;
	}

	public void setAddKitButton(WebElement addKitButton) {
		this.addKitButton = addKitButton;
	}

	public WebElement getKitId() {
		return kitId;
	}

	public void setKitId(WebElement kitId) {
		this.kitId = kitId;
	}

	public WebElement getKitName() {
		return kitName;
	}

	public void setKitName(WebElement kitName) {
		this.kitName = kitName;
	}

	public WebElement getKitDescription() {
		return kitDescription;
	}

	public void setKitDescription(WebElement kitDescription) {
		this.kitDescription = kitDescription;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}
	
}
