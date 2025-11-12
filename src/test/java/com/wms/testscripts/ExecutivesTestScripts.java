package com.wms.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.ExecutivesData;
import com.wms.data.LoginData;
import com.wms.data.WmsDataConfig;
import com.wms.services.ExecutiveServices;
import com.wms.services.LoginService;

import util.BaseListener;

public class ExecutivesTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
//	ExecutivesData executivesdata = null;
	ExecutiveServices executiveservices = null;
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
//		executivesdata = new WmsDataConfig().getExecutivesData();
		executiveservices = new ExecutiveServices();
		InitializeViews.init();
		Logger = extent.createTest("WMS Executive Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Executive screen Test")
	public void ProductsScreenTest() throws FileNotFoundException, IOException, InterruptedException {
		executiveservices.toAddSingleExecutive();
		executiveservices.toAddExecutiveRoles();
		executiveservices.creatingExecutivesWithExcel();
		
	}
}
