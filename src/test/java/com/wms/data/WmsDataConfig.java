package com.wms.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;


public class WmsDataConfig {
	JSONParser parser = null;
	JSONObject json = null;
	ObjectMapper objectMapper = null;
	
	public LoginData getLoginData() {
		LoginData loginData = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/WMSLogin.json"));
			objectMapper = new ObjectMapper();
//			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			loginData = objectMapper.readValue(json.toString(), LoginData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginData;
	}
	
	public WarehouseData getWarehouseData() {
		WarehouseData warehousedata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/WarehouseData.json"));
			objectMapper = new ObjectMapper();
			warehousedata = objectMapper.readValue(json.toString(), WarehouseData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return warehousedata;
	}
	
//	public BinRackData getZoneData() {
//		BinRackData binrackdata = null;
//		try {
//			parser = new JSONParser();
//			json = (JSONObject) parser.parse(new FileReader("\"src/main/resources/WMS-Data/WarehouseData.json\""));
//			objectMapper = new ObjectMapper();
//			binrackdata = objectMapper.readValue(json.toString(), BinRackData.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return binrackdata;
//	}
	
	public BinRackData getBinRackData() {
		BinRackData binrackdata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/BinRackData.json"));
			objectMapper = new ObjectMapper();
			binrackdata = objectMapper.readValue(json.toString(), BinRackData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return binrackdata;
	}
	
	public BayData getBayData() {
		BayData baydata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/BayData.json"));
			objectMapper = new ObjectMapper();
			baydata = objectMapper.readValue(json.toString(), BayData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baydata;
	}
	
	public TrolleysData getTrolleyData() {
		TrolleysData trolleydata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/TrolleysData.json"));
			objectMapper = new ObjectMapper();
			trolleydata = objectMapper.readValue(json.toString(), TrolleysData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trolleydata;
	}
	
	public KitsData getKitsData() {
		KitsData kitsdata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/KitsData.json"));
			objectMapper = new ObjectMapper();
			kitsdata = objectMapper.readValue(json.toString(), KitsData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kitsdata;
	}
	
	public ProductData getProductData() {
		ProductData productdata = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/ProductsData.json"));
			objectMapper = new ObjectMapper();
			productdata = objectMapper.readValue(json.toString(), ProductData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productdata;
	}
	
	public ExecutivesData getExecutivesData() {
		ExecutivesData executivesdata = null;
		try {
//			parser = new JSONParser();
//			json = (JSONObject) parser.parse(new FileReader("src/main/resources/WMS-Data/ExecutivesData.json"));
			objectMapper = new ObjectMapper();
			executivesdata = objectMapper.readValue(new File("src/main/resources/WMS-Data/ExecutivesData.json"), ExecutivesData.class);
			System.out.println("First Name from JSON: " + executivesdata.getFirstname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executivesdata;
	}
	
	
	public static List<String> readZonesFromFile(String fileName) {
        List<String> zones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(WmsDataConfig.class.getClassLoader().getResourceAsStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                zones.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zones;
    }
}
