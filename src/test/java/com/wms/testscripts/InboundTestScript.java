package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.WmsDataConfig;
import com.wms.services.InboundServices;
import com.wms.services.LoginService;

import util.BaseListener;

public class InboundTestScript extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	InboundServices inboundservice = null;
	
	@BeforeClass
	public void init() {
		logindata  = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		inboundservice = new InboundServices();
		InitializeViews.init();
		Logger = extent.createTest("WMS Inbound Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description = "WMS Inbound Screen")
	public void inboundScreenTest() throws InterruptedException {
		inboundservice.inboundActivities();
		inboundservice.inboundAsnProcess();
//		inboundservice.enterRowData(null);
	}
}
