package iSAFE;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.GenericKeywords;






public class ApplicationKeywords extends GenericKeywords{
	public boolean proceed=false;


	public void swtichWindow(String windowName){
		Set<String> windows=driver.getWindowHandles();
		if(windows.size()>0){
			for(String loop: windows){
				driver.switchTo().window(loop);
				if(driver.getTitle().equalsIgnoreCase(windowName)){
					testStepPassed("Switched to '"+windowName+"' window");
					break;
				}
			}
			
		}else{
			testStepFailed("There is no window available to switch");
		}
	}
	
	public  void clickOnWebElement(String description, WebElement element){
		//waitForElementToDisplay(objLocator, elementLoadWaitTime);
		element=webElement;
		for(int i=1;i<=elementLoadWaitTime;i++)
		{
			try
			{
				webElement.click();
				//writeToLogFile("INFO","Successfuly clicked on "+locatorDescription);
				//testReporter("Green", "Click on :"+locatorDescription);
				testStepPassed("Click on :"+description);
				break;
			}
			catch(InvalidSelectorException e)
			{

				waitTime(1);
			}
			catch(StaleElementReferenceException e)
			{

				waitTime(1);
			}
			catch(ElementNotVisibleException e){

				waitTime(1);
			}
			catch(UnreachableBrowserException e)
			{

				testStepFailed(e.toString());
			}
			catch(UnhandledAlertException e){

				waitTime(1);
			}
			catch(WebDriverException e){

				waitTime(1);
			}
			catch(Exception e)
			{
				testStepFailed("Exception Error '"+e.toString()+"'");
			}

			if(i==elementLoadWaitTime)
			{
				testStepFailed(description+" element found but its not in editable/clickable state within "+elementLoadWaitTime+" timeouts");
			}
		}


	}
}