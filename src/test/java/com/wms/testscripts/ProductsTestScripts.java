package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.ProductData;
import com.wms.data.WmsDataConfig;
import com.wms.services.LoginService;
import com.wms.services.ProductsScreenServices;

import util.BaseListener;

public class ProductsTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	ProductData productdata = null;
	ProductsScreenServices productservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		productdata = new WmsDataConfig().getProductData();
		productservice = new ProductsScreenServices(); 
		InitializeViews.init();
		Logger = extent.createTest("WMS Products screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Products screen Test")
	public void ProductsScreenTest() {
		productservice.toAddSingleProduct();
//		productservice.clickChooseFile();
	}
}
