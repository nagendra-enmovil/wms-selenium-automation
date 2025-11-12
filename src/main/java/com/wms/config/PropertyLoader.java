package com.wms.config;

import java.util.ResourceBundle;

public class PropertyLoader {
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("Config");
	
	public static String getBrowser() {
		return RESOURCE_BUNDLE.getString("browserType");
	}
	
	public static String getChromePath() {
		return RESOURCE_BUNDLE.getString("browserChromePath");
	}
	
	public static String getEdgePath() {
		return RESOURCE_BUNDLE.getString("browserEdgePath");
	}
	
	public static String getFirefoxPath() {
		return RESOURCE_BUNDLE.getString("browserFirefoxPath");
	}
	
	public static String getWMSURL() {
		return RESOURCE_BUNDLE.getString("WMSDevURL");
	}
	
	public static String getLoginData() {
		return RESOURCE_BUNDLE.getString("loginDataPath");
	}

	public static String getDEVUrl() {
		return RESOURCE_BUNDLE.getString("pocDevUrl");
	}
}
