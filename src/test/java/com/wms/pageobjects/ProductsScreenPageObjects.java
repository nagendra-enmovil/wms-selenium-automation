package com.wms.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wms.config.BrowserDriver;

public class ProductsScreenPageObjects {
	
	@FindBy(xpath = "//button[text()='Products']")
	private WebElement productsButton;
	
	@FindBy(xpath = "//button[text()='Bulk Upload']")
	private WebElement bulkUploadButton;
	
	@FindBy(xpath = "//input[@id='bulkUploadFile']")
	private WebElement buInputFiled;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBUtton;
	
	@FindBy(xpath = "//a[text()='OK']")
	private WebElement popupOkButton;
	
	@FindBy(xpath = "//button[text()='Add Product']")
	private WebElement addProductButton;
	
	@FindBy(xpath = "//input[@name='pidSku']")
	private WebElement sku;
	
	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productName;
	
	@FindBy(xpath = "//select[@name='productCategory']")
	private WebElement productCategory;
	
	@FindBy(xpath = "//input[@name='productDescription']")
	private WebElement productdescription;
	
	@FindBy(xpath = "//input[@name='unitCost']")
	private WebElement unitCost;
	
	@FindBy(xpath = "//button[text()='Submit Product']")
	private WebElement submitProductButton;
	
	public WebElement getProductsButton() {
		return productsButton;
	}

	public void setProductsButton(WebElement productsButton) {
		this.productsButton = productsButton;
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

	public WebElement getAddProductButton() {
		return addProductButton;
	}

	public void setAddProductButton(WebElement addProductButton) {
		this.addProductButton = addProductButton;
	}

	public WebElement getSku() {
		return sku;
	}

	public void setSku(WebElement sku) {
		this.sku = sku;
	}

	public WebElement getProductName() {
		return productName;
	}

	public void setProductName(WebElement productName) {
		this.productName = productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(WebElement productCategory) {
		this.productCategory = productCategory;
	}

	public WebElement getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(WebElement productdescription) {
		this.productdescription = productdescription;
	}

	public WebElement getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(WebElement unitCost) {
		this.unitCost = unitCost;
	}

	public WebElement getSubmitProductButton() {
		return submitProductButton;
	}

	public void setSubmitProductButton(WebElement submitProductButton) {
		this.submitProductButton = submitProductButton;
	}
	
	public void selectCategoryByVisibleText(String categoryText) {
	    Select select = new Select(productCategory);
	    select.selectByVisibleText(categoryText);
	}

}
