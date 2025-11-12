package com.wms.pageobjects;

import org.junit.jupiter.params.provider.FieldSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExecutivePageObjects {
	
	@FindBy(xpath = "//button[text()='Executives']")
	private WebElement executiveButton;
	
	@FindBy(xpath = "//button[text()='Create Executive']")
	private WebElement createExecutivebutton;
	
	@FindBy(xpath = "//input[@name='new_firstname']")
	private WebElement firstname;
	
	@FindBy(xpath = "//input[@name='new_lastname']")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@name='new_username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='new_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='new_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement successOkButton;
	
	@FindBy(xpath = "//button[text()='Executive Roles']")
	private WebElement executiveRolesButton;
	
	@FindBy(xpath = "//button[text()='Add Executive Role']")
	private WebElement createExecutiveRoleButton;
	
	@FindBy(xpath = "(//label[contains(text(), 'Select Executive')]/following::div[contains(@class,'css-13cymwt-control')])[1]")
	private WebElement selectExecutiveDropdown;
	
	@FindBy(xpath = "(//label[contains(text(), 'Executive Department')]/following::div[contains(@class,'css-13cymwt-control')])[1]")
//	@FindBy(xpath = "(//label[contains(text(), 'Executive Department')]/following::div[text()='Select...'])[1]")
	private WebElement departmentDropdown;
	
	@FindBy(xpath = "//div[@aria-label='Remove Admin Access']")
	private WebElement clearAdminOptionInDepartmentDropdown;
	
	@FindBy(xpath = "(//label[contains(text(), 'Executive Role')]/following::div[contains(@class,'css-13cymwt-control')])[1]")
	private WebElement roleDropdown;
	
	@FindBy(xpath = "//label[text() = 'Executive Name']")
	private WebElement executiveNameClick;
	
	@FindBy(xpath = "//button[text() = 'Finish']")
	private WebElement fineshButton;
	
	@FindBy(xpath = "//h2")
	private WebElement popupText;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement okButton;

	public WebElement getExecutiveButton() {
		return executiveButton;
	}

	public void setExecutiveButton(WebElement executiveButton) {
		this.executiveButton = executiveButton;
	}

	public WebElement getCreateExecutivebutton() {
		return createExecutivebutton;
	}

	public void setCreateExecutivebutton(WebElement createExecutivebutton) {
		this.createExecutivebutton = createExecutivebutton;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public void setFirstname(WebElement firstname) {
		this.firstname = firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public void setLastname(WebElement lastname) {
		this.lastname = lastname;
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public WebElement getSuccessOkButton() {
		return successOkButton;
	}

	public void setSuccessOkButton(WebElement successOkButton) {
		this.successOkButton = successOkButton;
	}

	public WebElement getExecutiveRolesButton() {
		return executiveRolesButton;
	}

	public void setExecutiveRolesButton(WebElement executiveRolesButton) {
		this.executiveRolesButton = executiveRolesButton;
	}

	public WebElement getCreateExecutiveRoleButton() {
		return createExecutiveRoleButton;
	}

	public void setCreateExecutiveRoleButton(WebElement createExecutiveRoleButton) {
		this.createExecutiveRoleButton = createExecutiveRoleButton;
	}

	public WebElement getSelectExecutiveDropdown() {
		return selectExecutiveDropdown;
	}

	public void setSelectExecutiveDropdown(WebElement selectExecutiveDropdown) {
		this.selectExecutiveDropdown = selectExecutiveDropdown;
	}

	public WebElement getDepartmentDropdown() {
		return departmentDropdown;
	}

	public void setDepartmentDropdown(WebElement departmentDropdown) {
		this.departmentDropdown = departmentDropdown;
	}

	public WebElement getClearAdminOptionInDepartmentDropdown() {
		return clearAdminOptionInDepartmentDropdown;
	}

	public void setClearAdminOptionInDepartmentDropdown(WebElement clearAdminOptionInDepartmentDropdown) {
		this.clearAdminOptionInDepartmentDropdown = clearAdminOptionInDepartmentDropdown;
	}

	public WebElement getRoleDropdown() {
		return roleDropdown;
	}

	public void setRoleDropdown(WebElement roleDropdown) {
		this.roleDropdown = roleDropdown;
	}

	public WebElement getExecutiveNameClick() {
		return executiveNameClick;
	}

	public void setExecutiveNameClick(WebElement executiveNameClick) {
		this.executiveNameClick = executiveNameClick;
	}

	public WebElement getFineshButton() {
		return fineshButton;
	}

	public void setFineshButton(WebElement fineshButton) {
		this.fineshButton = fineshButton;
	}

	public WebElement getPopupText() {
		return popupText;
	}

	public void setPopupText(WebElement popupText) {
		this.popupText = popupText;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public void setOkButton(WebElement okButton) {
		this.okButton = okButton;
	}
	
}
