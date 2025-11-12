package com.wms.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboundObjects {
	
	@FindBy(xpath = "//button[text() = 'Inbound']")
	private WebElement inboundButton;
	
	@FindBy(xpath = "//button[text() = 'Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//div[@class='sweet-alert ']//h2")
	private WebElement sweetAlertMsg;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	
	@FindBy(xpath = "//h2[text() = 'Pending Bay Assignments']")
	private WebElement pendingBayTab;
	
	@FindBy(xpath = "(//button[text() = 'Assign Bay / Executive'])[1]")
	private WebElement assignBayButton;
	
	@FindBy(xpath = "//div[contains(@class, 'option') and @role='option']")
	private List<WebElement> dropdownOptions;
	
	@FindBy(xpath = "//label[contains(text(), 'Select BAY')]/following-sibling::div")
	private WebElement selectBayDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Select Executive')]/following-sibling::div")
	private WebElement selectExecutiveDropdown;
	
	@FindBy(xpath = "//div[@id = 'slider']//button")
	private WebElement submitAssignBayButton;
	
	@FindBy(xpath = "//div[@class='sweet-alert ']//h2")
	private WebElement popupMessage;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement successPopupOkButton;
	
	@FindBy(xpath = "//h2[text()='Pending Unloads']")
	private WebElement pendingUnloadsTab;
	
	@FindBy(xpath = "//button[text() = 'Start Unload']")
	private WebElement startUnloadButton;
	
	@FindBy(xpath = "(//span[@title='Editable'])[1]")
	private WebElement receivedQuantityfield;
	
	@FindBy(xpath = "(//div[@col-id = 'received_quantity'])[2]")
	private WebElement enterDataInReceivedQuan;
	
	@FindBy(xpath = "(//span[@title='Editable'])[2]")
	private WebElement receivedQuantityfield2;
	
	@FindBy(xpath = "(//div[@col-id = 'received_quantity'])[3]")
	private WebElement enterDataInReceivedQuan2;
	
	@FindBy(xpath = "(//span[@title='Editable'])[3]")
	private WebElement receivedQuantityfield3;
	
	@FindBy(xpath = "(//div[@col-id = 'received_quantity'])[4]")
	private WebElement enterDataInReceivedQuan3;

	public WebElement getInboundButton() {
		return inboundButton;
	}

	public void setInboundButton(WebElement inboundButton) {
		this.inboundButton = inboundButton;
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

	public WebElement getSweetAlertMsg() {
		return sweetAlertMsg;
	}

	public void setSweetAlertMsg(WebElement sweetAlertMsg) {
		this.sweetAlertMsg = sweetAlertMsg;
	}

	public WebElement getPopupOkButton() {
		return popupOkButton;
	}

	public void setPopupOkButton(WebElement popupOkButton) {
		this.popupOkButton = popupOkButton;
	}

	public WebElement getPendingBayTab() {
		return pendingBayTab;
	}

	public void setPendingBayTab(WebElement pendingBayTab) {
		this.pendingBayTab = pendingBayTab;
	}

	public WebElement getAssignBayButton() {
		return assignBayButton;
	}

	public void setAssignBayButton(WebElement assignBayButton) {
		this.assignBayButton = assignBayButton;
	}

	public List<WebElement> getDropdownOptions() {
		return dropdownOptions;
	}

	public void setDropdownOptions(List<WebElement> dropdownOptions) {
		this.dropdownOptions = dropdownOptions;
	}

	public WebElement getSelectBayDropdown() {
		return selectBayDropdown;
	}

	public void setSelectBayDropdown(WebElement selectBayDropdown) {
		this.selectBayDropdown = selectBayDropdown;
	}

	public WebElement getSelectExecutiveDropdown() {
		return selectExecutiveDropdown;
	}

	public void setSelectExecutiveDropdown(WebElement selectExecutiveDropdown) {
		this.selectExecutiveDropdown = selectExecutiveDropdown;
	}

	public WebElement getSubmitAssignBayButton() {
		return submitAssignBayButton;
	}

	public void setSubmitAssignBayButton(WebElement submitAssignBayButton) {
		this.submitAssignBayButton = submitAssignBayButton;
	}

	public WebElement getPopupMessage() {
		return popupMessage;
	}

	public void setPopupMessage(WebElement popupMessage) {
		this.popupMessage = popupMessage;
	}

	public WebElement getSuccessPopupOkButton() {
		return successPopupOkButton;
	}

	public void setSuccessPopupOkButton(WebElement successPopupOkButton) {
		this.successPopupOkButton = successPopupOkButton;
	}

	public WebElement getPendingUnloadsTab() {
		return pendingUnloadsTab;
	}

	public void setPendingUnloadsTab(WebElement pendingUnloadsTab) {
		this.pendingUnloadsTab = pendingUnloadsTab;
	}

	public WebElement getStartUnloadButton() {
		return startUnloadButton;
	}

	public void setStartUnloadButton(WebElement startUnloadButton) {
		this.startUnloadButton = startUnloadButton;
	}

	public WebElement getReceivedQuantityfield() {
		return receivedQuantityfield;
	}

	public void setReceivedQuantityfield(WebElement receivedQuantityfield) {
		this.receivedQuantityfield = receivedQuantityfield;
	}

	public WebElement getEnterDataInReceivedQuan() {
		return enterDataInReceivedQuan;
	}

	public void setEnterDataInReceivedQuan(WebElement enterDataInReceivedQuan) {
		this.enterDataInReceivedQuan = enterDataInReceivedQuan;
	}

	public WebElement getReceivedQuantityfield2() {
		return receivedQuantityfield2;
	}

	public void setReceivedQuantityfield2(WebElement receivedQuantityfield2) {
		this.receivedQuantityfield2 = receivedQuantityfield2;
	}

	public WebElement getEnterDataInReceivedQuan2() {
		return enterDataInReceivedQuan2;
	}

	public void setEnterDataInReceivedQuan2(WebElement enterDataInReceivedQuan2) {
		this.enterDataInReceivedQuan2 = enterDataInReceivedQuan2;
	}

	public WebElement getReceivedQuantityfield3() {
		return receivedQuantityfield3;
	}

	public void setReceivedQuantityfield3(WebElement receivedQuantityfield3) {
		this.receivedQuantityfield3 = receivedQuantityfield3;
	}

	public WebElement getEnterDataInReceivedQuan3() {
		return enterDataInReceivedQuan3;
	}

	public void setEnterDataInReceivedQuan3(WebElement enterDataInReceivedQuan3) {
		this.enterDataInReceivedQuan3 = enterDataInReceivedQuan3;
	}

	
	
	
}
