package com.wms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaysPageObjects {
	
	@FindBy(xpath = "//button[text()='Bays']")
	private WebElement baysButton;
	
	@FindBy(xpath = "//button[text()='Add Bay']")
	private WebElement addBayButton;
	
	@FindBy(xpath = "//input[@name='bay_name']")
	private WebElement bayName;
	
	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement finishButton;
	
	@FindBy(xpath = "//input[@name='bay_number']")
	private WebElement bayNumber;
	
	@FindBy(xpath = "//button[text()='Bulk Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	

	public WebElement getBaysButton() {
		return baysButton;
	}

	public void setBaysButton(WebElement baysButton) {
		this.baysButton = baysButton;
	}

	public WebElement getAddBayButton() {
		return addBayButton;
	}

	public void setAddBayButton(WebElement addBayButton) {
		this.addBayButton = addBayButton;
	}

	public WebElement getBayName() {
		return bayName;
	}

	public void setBayName(WebElement bayName) {
		this.bayName = bayName;
	}

	public WebElement getBayNumber() {
		return bayNumber;
	}

	public void setBayNumber(WebElement bayNumber) {
		this.bayNumber = bayNumber;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}

	public void setFinishButton(WebElement finishButton) {
		this.finishButton = finishButton;
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
	
	
}
