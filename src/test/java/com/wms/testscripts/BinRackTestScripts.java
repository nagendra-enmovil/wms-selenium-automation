package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.WmsDataConfig;
import com.wms.services.BinRackServices;
import com.wms.services.LoginService;

import util.BaseListener;

public class BinRackTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	BinRackServices binrackservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		binrackservice = new BinRackServices(); 
		InitializeViews.init();
		Logger = extent.createTest("WMS Zone-Bin-Rack Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description = "WMS Zone-Bin-Rack Screen")
	public void BinRackScreenTest() {
		BrowserDriver.wait(5);
//		binrackservice.creatingZonesWithExcel().clickChooseFile();
		binrackservice.clickChooseFile();
	}
}
