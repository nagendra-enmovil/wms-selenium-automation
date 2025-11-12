package com.wms.services;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.wms.config.BrowserDriver;
import com.wms.pageobjects.ExecutivePageObjects;


public class ExecutiveServices {
	
	public static ExecutivePageObjects ExecutiveObjects;
	private static Logger log = Logger.getLogger(ExecutiveServices.class);
	
	public static void init() {
		ExecutiveObjects = PageFactory.initElements(BrowserDriver.getCurrentDriver(), ExecutivePageObjects.class);
	}
	
	public ExecutiveServices toAddSingleExecutive() {
		ExecutiveObjects.getExecutiveButton().click();
		ExecutiveObjects.getCreateExecutivebutton().click();
		ExecutiveObjects.getFirstname().sendKeys("Kiran");
		ExecutiveObjects.getLastname().sendKeys("Enmovil");
		ExecutiveObjects.getUsername().sendKeys("Kiran");
		ExecutiveObjects.getEmail().sendKeys("kiran@gmail.com");
		ExecutiveObjects.getPassword().sendKeys("Kiran@123");
		ExecutiveObjects.getSubmitButton().click();
		WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ExecutiveObjects.getSuccessOkButton()));
        ExecutiveObjects.getSuccessOkButton().click();
        BrowserDriver.wait(1);
		return this;
	}

	public ExecutiveServices toAddExecutiveRoles() throws InterruptedException {
		ExecutiveObjects.getExecutiveButton().click();
		ExecutiveObjects.getExecutiveRolesButton().click();
		ExecutiveObjects.getCreateExecutiveRoleButton().click();
		BrowserDriver.wait(2);
		ExecutiveObjects.getSelectExecutiveDropdown().click();
		
		WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(5));
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
			    By.xpath("//div[contains(@class,'css-1nmdiq5-menu')]//div[contains(@class,'css-d7l1ni-option')]")
			));           

			String desiredValue1 = "Kiran - (kiran@gmail.com)";

			for (WebElement option : options) {
			    String text = option.getAttribute("innerText").trim();
			    if (text.equals(desiredValue1)) {
			        option.click();
			        break;
			    }
			}
			
			BrowserDriver.wait(1);
			ExecutiveObjects.getClearAdminOptionInDepartmentDropdown().click();
			ExecutiveObjects.getExecutiveNameClick().click();
			ExecutiveObjects.getDepartmentDropdown().click();
			BrowserDriver.wait(1);
			
			WebDriverWait wait1 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
			List<WebElement> options1 = wait1.until(ExpectedConditions
			        .visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='react-select-5-listbox']//div[@role='option']")));

			String department = "Inbound";
			for (WebElement option : options1) {
			    String text = option.getText().trim();
			    if (text.equalsIgnoreCase(department)) {
			        option.click();
			        break;
			    }
			}
			
			BrowserDriver.wait(1);
			ExecutiveObjects.getRoleDropdown().click();
			
			WebDriverWait wait2 = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(5));
			List<WebElement> options2 = wait2.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'react-select-6-listbox']//div[@role = 'option']")));
			
			String role = "ALL";
			for(WebElement option : options2) {
				String text = option.getText().trim();
				if(text.equalsIgnoreCase(role)) {
					option.click();
					break;
				}
			}
			
			ExecutiveObjects.getFineshButton().click();
			String popupmessage = ExecutiveObjects.getPopupText().getText();
			log.info("Successfully " + popupmessage);
			ExecutiveObjects.getOkButton().click();
			
		
		return this;
	}
	
	public ExecutiveServices creatingExecutivesWithExcel() throws FileNotFoundException, IOException {
		ExecutiveObjects.getExecutiveButton().click();
		ExecutiveObjects.getCreateExecutivebutton().click();
		String Filepath = "src/main/resources/Excel-Data/ExecutivesList.xlsx";
		try(FileInputStream fis = new FileInputStream(Filepath);
				Workbook workbook = new XSSFWorkbook(fis)){
			    Sheet sheet = workbook.getSheetAt(0);
			
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				
				String firstname = row.getCell(0).getStringCellValue();
				String lastname = row.getCell(1).getStringCellValue();
				String username = row.getCell(2).getStringCellValue();
				String email = row.getCell(3).getStringCellValue();
				String password = row.getCell(4).getStringCellValue();
				
				ExecutiveObjects.getFirstname().clear();
				ExecutiveObjects.getFirstname().sendKeys(firstname);
				BrowserDriver.wait(1);
				
				ExecutiveObjects.getLastname().clear();
				ExecutiveObjects.getLastname().sendKeys(lastname);
				BrowserDriver.wait(1);
				
				ExecutiveObjects.getUsername().clear();
				ExecutiveObjects.getUsername().sendKeys(username);
				BrowserDriver.wait(1);
				
				ExecutiveObjects.getEmail().clear();
				ExecutiveObjects.getEmail().sendKeys(email);
				BrowserDriver.wait(1);
				
				ExecutiveObjects.getPassword().clear();
				ExecutiveObjects.getPassword().sendKeys(password);
				BrowserDriver.wait(1);
				
				ExecutiveObjects.getSubmitButton().click();
				
				WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(ExecutiveObjects.getSuccessOkButton()));
	            ExecutiveObjects.getSuccessOkButton().click();
	            BrowserDriver.wait(1);
	            
	            ExecutiveObjects.getCreateExecutivebutton().click();
	            BrowserDriver.wait(1);
			} 
			}catch(Exception e) {
				log.error("Error reading Excel file:", e);
			
		}		
		return this;
	}
	
//	public ExecutiveServices assignAllExecutiveRoles() throws InterruptedException {
//	    WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));
//
//	    Map<String, Map<String, List<String>>> executives = new LinkedHashMap<>();
//
//	    executives.put("Kiran - (kiran@gmail.com)", Map.of(
//	        "Inbound", Arrays.asList("ALL")
//	    ));
//
//	    executives.put("Vinay Kumar - (vinay@yahoo.com)", Map.of(
//	    	"Inbound", Arrays.asList("ALL")
//	    ));
//	    
//	    // Step 2: Loop through each executive
//	    for (Map.Entry<String, Map<String, List<String>>> execEntry : executives.entrySet()) {
//	        String executiveName = execEntry.getKey();
//	        Map<String, List<String>> departments = execEntry.getValue();
//
//	        // Navigate to executive role creation
//	        ExecutiveObjects.getExecutiveButton().click();
//	        ExecutiveObjects.getExecutiveRolesButton().click();
//	        ExecutiveObjects.getCreateExecutiveRoleButton().click();
//	        BrowserDriver.wait(2);
//
//	        // Select executive
//	        ExecutiveObjects.getSelectExecutiveDropdown().click();
//	        List<WebElement> execOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	                By.xpath("//div[contains(@class,'css-1nmdiq5-menu')]//div[@role='option']")));
//
//	        for (WebElement option : execOptions) {
//	            if (option.getAttribute("innerText").trim().equals(executiveName)) {
//	                option.click();
//	                break;
//	            }
//	        }
//
//	        BrowserDriver.wait(1);
//
//	        for (Map.Entry<String, List<String>> deptEntry : departments.entrySet()) {
//	            String deptName = deptEntry.getKey();
//	            List<String> roles = deptEntry.getValue();
//
//	            ExecutiveObjects.getClearAdminOptionInDepartmentDropdown().click();
//	            ExecutiveObjects.getExecutiveNameClick().click();
//	            
//	            boolean deptFound = false;
//
//	            for (int i = 0; i < 2; i++) {  
//	                try {
//	                    WebElement deptDropdown = ExecutiveObjects.getDepartmentDropdown();
//	                    ((JavascriptExecutor) BrowserDriver.getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", deptDropdown);
//	                    deptDropdown.click();
//
//	                    BrowserDriver.wait(1);
//
//	                    // Try to locate options
//	                    WebDriverWait waitDept = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(5));
//	                    List<WebElement> departmentOptions = waitDept.until(
//	                        ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	                            By.xpath("//div[@id='react-select-5-listbox']//div[@role='option']")
//	                        )
//	                    );
//
//	                    for (WebElement deptOption : departmentOptions) {
//	                        if (deptOption.getText().trim().equalsIgnoreCase(deptName)) {
//	                            deptOption.click();
//	                            deptFound = true;
//	                            break;
//	                        }
//	                    }
//
//	                    if (deptFound) break;
//
//	                } catch (TimeoutException e) {
//	                    log.warn("Department dropdown failed to load. Retrying attempt " + (i + 1));
//	                    // Click outside to reset React dropdown (important)
//	                    ((JavascriptExecutor) BrowserDriver.getCurrentDriver()).executeScript("document.body.click();");
//	                    BrowserDriver.wait(1);
//	                }
//	            }
//
//	            if (!deptFound) {
//	                throw new RuntimeException("Department '" + deptName + "' not found or selectable!");
//	            }
//
//	            BrowserDriver.wait(1);
//
//	            for (String role : roles) {
//	                // Open the Role dropdown before each selection
//	                ExecutiveObjects.getRoleDropdown().click();
//	                BrowserDriver.wait(1);  // slight wait to allow the list to open
//
//	                List<WebElement> roleOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	                        By.xpath("//div[@id = 'react-select-6-listbox']//div[@role = 'option']")));
//
//	                boolean found = false;
//	                for (WebElement roleOption : roleOptions) {
//	                    if (roleOption.getText().trim().equalsIgnoreCase(role)) {
//	                        roleOption.click();
//	                        found = true;
//	                        break;
//	                    }
//	                }
//
//	                if (!found) {
//	                    log.warn("Role not found: " + role);
//	                }
//
//	                BrowserDriver.wait(1); // optional wait after selection
//	            }
//
//
//	            // Finish button and popup
//	            ExecutiveObjects.getFineshButton().click();
//	            String popupMessage = ExecutiveObjects.getPopupText().getText();
//	            log.info("Assigned roles to " + executiveName + " | Department: " + deptName + " | Roles: " + roles);
//	            ExecutiveObjects.getOkButton().click();
//	            BrowserDriver.wait(1);
//	        }
//	    }
//	    return this;
//	}

}
