package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.WmsDataConfig;
import com.wms.services.LoginService;

import util.BaseListener;

public class LoginTestScript extends BaseListener{
	LoginData logindata = null;
	LoginService loginservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		InitializeViews.init();
		Logger = extent.createTest("WMS Login Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		
	}
	
	@Test(description="WMS Login Test",priority=0)
	public void loginTest() {
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
}
