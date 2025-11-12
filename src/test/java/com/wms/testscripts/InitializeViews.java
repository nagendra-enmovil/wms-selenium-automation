package com.wms.testscripts;

import org.openqa.selenium.WebDriver;

import com.wms.config.BrowserDriver;
import com.wms.services.BaysServices;
import com.wms.services.BinRackServices;
import com.wms.services.ExecutiveServices;
import com.wms.services.InboundServices;
import com.wms.services.KitServices;
import com.wms.services.LoginService;
import com.wms.services.ProductsScreenServices;
import com.wms.services.TrolleysServices;
import com.wms.services.WarehouseServices;

public class InitializeViews {
	
	protected static WebDriver uiDriver = null;
	public static void init() {
		if(uiDriver == null) {
			uiDriver = BrowserDriver.getCurrentDriver();
		}
		LoginService.init();
		ProductsScreenServices.init();
		ExecutiveServices.init();
		BaysServices.init();
		KitServices.init();
		TrolleysServices.init();
		BinRackServices.init();
		WarehouseServices.init();
		InboundServices.init();
	 }
}
