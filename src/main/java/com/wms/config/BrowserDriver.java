package com.wms.config;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriver {
	private static WebDriver bDriver;
	private static int defaultimeoutseconds;
	
	public static WebDriver getCurrentDriver(String browser) {
		if (bDriver == null) {
			try {
				bDriver = Browser.getBrowser(browser);
			} catch (UnreachableBrowserException ucb) {
				System.out.println("Check the driver file");
				ucb.printStackTrace();
			}
		}
		return bDriver;
		
	}
	
	public static WebDriver getCurrentDriver() {
		return getCurrentDriver(PropertyLoader.getBrowser());
	}
	
	public static void wait(int time) {
		try {
			for(int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static void waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	@SafeVarargs
	public static Boolean waitForPageToLoad(ExpectedCondition<Boolean>... conditions) {
		Boolean isLoaded = false;
	    Wait<WebDriver> wait = new FluentWait<>(getCurrentDriver())
	            .withTimeout(Duration.ofSeconds(45))
	            .ignoring(StaleElementReferenceException.class)
	            .pollingEvery(Duration.ofSeconds(2));
	    for (ExpectedCondition<Boolean> condition : conditions) {
	        isLoaded = wait.until(condition);
	        if (isLoaded == false) {
	            //Stop checking on first condition returning false.
	            break;
	        }
	    }
	    return isLoaded;
	}
	public static Boolean waitForPageToLoad() {
		return waitForPageToLoad(EXPECT_DOC_READY_STATE);
	}
	
	public static final ExpectedCondition<Boolean> EXPECT_DOC_READY_STATE = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bdriver) {
	        String script = "if (typeof window != 'undefined' && window.document) { return window.document.readyState; } else { return 'notready'; }";
	        Boolean result;
	        try {
	            result = ((JavascriptExecutor) bdriver).executeScript(script).equals("complete");
	        } catch (Exception ex) {
	            result = Boolean.FALSE;
	        }
	        return result;
	    }
	};
	
	public static final ExpectedCondition<Boolean> EXPECT_NOT_WAITING = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bdriver) {
	        Boolean loaded = true;
	        try {
	            WebElement wait = getCurrentDriver().findElement(By.id("F"));
	            if (wait.isDisplayed()) {
	                loaded = false;
	            }
	        } catch (StaleElementReferenceException serex) {
	            loaded = false;
	        } catch (NoSuchElementException nseex) {
	            loaded = true;
	        } catch (Exception ex) {
	            loaded = false;
	            System.out.println("EXPECTED_NOT_WAITING: UNEXPECTED EXCEPTION: " + ex.getMessage());
	        }
	        return loaded;
	    }
	};
	
	public static final ExpectedCondition<Boolean> EXPECT_NO_SPINNERS = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bDriver) {
	        Boolean loaded = true;
	        try {
	        List<WebElement> spinners = bDriver.findElements(By.className("spinner"));
	        for (WebElement spinner : spinners) {
	            if (spinner.isDisplayed()) {
	                loaded = false;
	                break;
	            }
	        }
	        }catch (Exception ex) {
	            loaded = false;
	        }
	        return loaded;
	    } 
	};
}
