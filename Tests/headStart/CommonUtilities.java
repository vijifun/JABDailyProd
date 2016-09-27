package headStart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import iSAFE.ApplicationKeywords;

public class CommonUtilities extends ApplicationKeywords{

	public static final String img_loadingImg="loading image#xpath=//img[contains(@src,'images/global/JAB-ProcessingImage.gif')]";
	public static final String img_country_flag="country flag#xpath=//img[contains(@class,'header-international-img')]";
	public static final String btn_proceedasUS="Proceed as US customer button#xpath=//span[contains(text(),'Proceed As U.S. Customer')]/parent::button";
	public boolean orderPlacementFlag=false;
	public static final String btn_sweepStakesPanel_close="sweep stakes panel close button3xpath=//a[contains(text(),'Sweepstakes dialog close')]";

	public void setup(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion, String sheetNo) {

		testDataSheetNo=Integer.parseInt(sheetNo);
		testResultsFolder(machineName,host,port,browser,os,browserVersion,osVersion);	
		currentExecutionMachineName(machineName);
		setEnvironmentTimeouts();
	}

	public void setEnvironmentTimeouts()
	{
		setTimeouts();
	}
	public void currentExecutionMachineName(String machineName) {
		currentExecutionMachineName = machineName;
	}

	public void closeAllSessions(){
		try{
			driver.quit();
		}catch(Exception e){

		}
	}

	public void waitForLoadingAndDissappearJABLoadingImg(){
		try{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'images/global/JAB-ProcessingImage.gif')]")));
			WebDriverWait wait2=new WebDriverWait(driver,implicitlyWaitTime);
			wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(@src,'images/global/JAB-ProcessingImage.gif')]")));

			waitTime(5);
		}catch(Exception e){

		}

	}

	/**returns the currentDate and time
	 * @return String Date(ddMMyyyyhhmmss)
	 */
	public String getCurrentDateAndTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
		return dateFormat.format(new Date());
	}

	public void verifyUSFlagSelected(){
		String flg;
		if(!currentBrowser.toLowerCase().contains("internetexplorer")){
			flg=getAttributeValue(img_country_flag, "src");
		}else{
			flg=driver.findElement(By.cssSelector("img[id=header-international-img]")).getAttribute("src");
		}
		//String flg=driver.findElement(By.xpath("//img[contains(@class,'header-international-img')]")).getAttribute("src");
		String[] separate=flg.split("/");
		String country=separate[separate.length-1];
		if(!country.toLowerCase().contains("us")){
			testStepPassed("Proceding as US customer");
			clickOn(img_country_flag);
			clickOn(btn_proceedasUS);
			waitForText("Change Region");
		}
	}

	public void setEnvironmentFlag(){
		switch (getConfigProperty("AppURL")) {
		case "https://www.josbank.com":
			orderPlacementFlag=false;
			break;

		case "https://tst.josbank.com":
			orderPlacementFlag=true;
			break;

		case "http://www.josbank.com":
			orderPlacementFlag=false;
			break;

		case "http://tst.josbank.com":
			orderPlacementFlag=true;
			break;

		default:
			orderPlacementFlag=true;
			break;
		}
	}
	public void closeSweepStakesPanelIfAvailable(){
		try{
			if(isElementDisplayed(btn_sweepStakesPanel_close)){
				clickOn(btn_sweepStakesPanel_close);
			}
		}catch(Exception e){

		}
	}
	
	public void clickOnHeaderLogo(){
		clickOn("Header logo#xpath=//a[contains(@id,'HeaderStoreLogo')]");
	}
	public boolean switchToSpecificWindow(String window){
		boolean flag=false;
		Set<String> windows=driver.getWindowHandles();
		if(windows.size()>1){
			for(String win : windows){
				driver.switchTo().window(win);
				if(driver.getTitle().equalsIgnoreCase(window)){
					testStepPassed("Successfully switched to "+window+" window");
					flag=true;
					break;
				}
			}
			if(flag==false){
				testStepFailed(window+" window is not available to switch");
			}
		}else{
			testStepFailed(window+" window is not available to switch");
		}
		return flag;
	}

}
