package com.wms.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wms.config.BrowserDriver;
import com.wms.config.PropertyLoader;
import com.wms.data.LoginData;
import com.wms.data.WarehouseData;
import com.wms.data.WmsDataConfig;
import com.wms.services.BaysServices;
import com.wms.services.LoginService;
import com.wms.services.WarehouseServices;

import util.BaseListener;

public class WarehouseTestScripts extends BaseListener{
	
	LoginData logindata = null;
	LoginService loginservice = null;
	WarehouseData warehousedata = null;
	WarehouseServices warehouseservice = null;
	
	@BeforeClass
	public void init() {
		logindata = new WmsDataConfig().getLoginData();
		loginservice = new LoginService();
		warehousedata = new WmsDataConfig().getWarehouseData();
		warehouseservice = new WarehouseServices(); 
		InitializeViews.init();
		Logger = extent.createTest("WMS Add Warehouse Screen");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getWMSURL());
		loginservice.loginToWms(logindata.getUsername(), logindata.getPassword());
	}
	
	@Test(description="WMS Warehouse screen Test")
	public void WarehouseScreenTest() {
//		warehouseservice.warehouseOperations(warehousedata.getWarehouse_id(), warehousedata.getWarehouse_name(), warehousedata.getAdress(), warehousedata.getGeo_codes(), warehousedata.getPincode(), warehousedata.getTotal_area(), warehousedata.getStorage_area());
		warehouseservice.warehouseGeneralInfoData();
	}
}
