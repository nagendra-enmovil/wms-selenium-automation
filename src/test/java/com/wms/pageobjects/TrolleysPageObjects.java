package com.wms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrolleysPageObjects {
	
	@FindBy(xpath = "//button[text()='Trolleys']")
	private WebElement TrolleysButton;
	
	@FindBy(xpath = "//button[text() = 'Add Trolley']")
	private WebElement addTrolleyButton;
	
	@FindBy(xpath = "//button[text()='Bulk Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	
	@FindBy(xpath = "//input[@name = 'trolley_name']")
	private WebElement trolleyName;
	
	@FindBy(xpath = "//input[@name = 'trolley_number']")
	private WebElement trolleyNumber;
	
	@FindBy(xpath = "//button[text() = 'Finish']")
	private WebElement finishButton;
	
	public WebElement getTrolleysButton() {
		return TrolleysButton;
	}

	public void setTrolleysButton(WebElement trolleysButton) {
		TrolleysButton = trolleysButton;
	}

	public WebElement getAddTrolleyButton() {
		return addTrolleyButton;
	}

	public void setAddTrolleyButton(WebElement addTrolleyButton) {
		this.addTrolleyButton = addTrolleyButton;
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

	public WebElement getTrolleyName() {
		return trolleyName;
	}

	public void setTrolleyName(WebElement trolleyName) {
		this.trolleyName = trolleyName;
	}

	public WebElement getTrolleyNumber() {
		return trolleyNumber;
	}

	public void setTrolleyNumber(WebElement trolleyNumber) {
		this.trolleyNumber = trolleyNumber;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}

	public void setFinishButton(WebElement finishButton) {
		this.finishButton = finishButton;
	}
	
}
