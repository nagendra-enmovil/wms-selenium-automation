package util;

import java.lang.reflect.Executable;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseListener extends TestListenerAdapter {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter  spark;
	public static ExtentTest Logger;
	
	@BeforeSuite
	public void startReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Reports//WMS.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "Enmovil");
		extent.setSystemInfo("Environment", "Dev");
		extent.setSystemInfo("User Name", "Nagendra");
		spark.config().setDocumentTitle("WMS");
		spark.config().setReportName("Regression Result");
		spark.config().setTheme(Theme.DARK);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Logger.log(Status.FAIL, 
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			Logger.log(Status.FAIL, 
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}else if (result.getStatus() == ITestResult.SKIP) {
			Logger.log(Status.SKIP, 
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}else if (result.getStatus() == ITestResult.SUCCESS) {
			Logger.log(Status.PASS, 
					MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
		}
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
