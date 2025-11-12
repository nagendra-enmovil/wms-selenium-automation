package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.KitsData;
import com.wms.data.LoginData;
import com.wms.data.WmsDataConfig;
import com.wms.services.BaysServices;
import com.wms.services.KitServices;
import com.wms.services.LoginService;

import util.BaseListener;

public class KitTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	KitsData kitsdata = null;
	KitServices kitservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		kitsdata = new WmsDataConfig().getKitsData();
		kitservice = new KitServices(); 
		InitializeViews.init();
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Kit screen Test")
	public void BaysScreenTest() {
		kitservice.toAddSingleKit(kitsdata.getKitid(), kitsdata.getKitname(), kitsdata.getKitdescription());
//		kitservice.clickChooseFile();
	}
}
