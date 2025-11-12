package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.TrolleysData;
import com.wms.data.WmsDataConfig;
import com.wms.services.LoginService;
import com.wms.services.TrolleysServices;

import util.BaseListener;

public class TrolleysTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	TrolleysData trolleydata = null;
	TrolleysServices trolleysservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		trolleydata = new WmsDataConfig().getTrolleyData();
		trolleysservice = new TrolleysServices(); 
		InitializeViews.init();
		Logger = extent.createTest("WMS Trollys Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Trolleys screen Test")
	public void BaysScreenTest() {
		trolleysservice.toAddSingleTrolley(trolleydata.getTrolleyname(), trolleydata.getTrolleynumber());
		trolleysservice.clickChooseFile();
	}
}
