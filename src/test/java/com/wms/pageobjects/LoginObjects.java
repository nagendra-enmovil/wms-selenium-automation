package com.wms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects {
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h3[text()='Warehouse Management']")
	private WebElement wareHouseManag;
	

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public void setPassWord(WebElement passWord) {
		this.passWord = passWord;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getWareHouseManag() {
		return wareHouseManag;
	}

	public void setWareHouseManag(WebElement wareHouseManag) {
		this.wareHouseManag = wareHouseManag;
	}
	
}
