package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.BayData;
import com.wms.data.LoginData;
import com.wms.data.WarehouseData;
import com.wms.data.WmsDataConfig;
import com.wms.services.BaysServices;
import com.wms.services.LoginService;

import util.BaseListener;

public class BaysTestScripts extends BaseListener{
	LoginData logindata = null;
	LoginService loginservice = null;
    BayData baydata = null;
	BaysServices baysservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		baydata = new WmsDataConfig().getBayData();
		baysservice = new BaysServices(); 
		InitializeViews.init();
		Logger = extent.createTest("WMS Bays Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Bays screen Test")
	public void BaysScreenTest() {
		baysservice.addingSingleBay(baydata.getBayname(), baydata.getBaynumber());
//		baysservice.clickChooseFile();
	}
}
