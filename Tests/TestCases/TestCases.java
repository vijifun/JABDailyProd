package TestCases;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import scenarios.UserRegistrationTest;
import AutomationFramework.GenericKeywords;




@Listeners({ Utilities.TestListener.class })
public class TestCases extends GenericKeywords {
	String machineName = "";
	UserRegistrationTest modulefunctionalities = new UserRegistrationTest();

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	public void TestStart(String testCaseDescription,String hostName,String testCaseName){ 

		modulefunctionalities.currentTestCaseName=testCaseName;
		modulefunctionalities.setEnvironmentTimeouts();
		reportStart(testCaseDescription,hostName);
		modulefunctionalities.iterationCount.clear();
		modulefunctionalities.iterationCountInTextData();
	}

	@BeforeClass
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" ,"TestData.SheetNumber"})
	public void precondition(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,String sheetNo) {

		modulefunctionalities.setup(machineName, host, port, browser, os,browserVersion, osVersion, sheetNo);
		//modulefunctionalities.openBrowser(machineName,host,port,browser,os,browserVersion,osVersion);
		modulefunctionalities.setEnvironmentFlag();

	}

	@AfterClass
	public void closeSessions() {
		modulefunctionalities.closeAllSessions();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void AddToWishListGuestTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Add To Wish List Guest Test Scenario",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.addToWishListGuestTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void ShoppingCartTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Shopping Cart Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.shoppingCartTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void EGiftCardOrderMemberTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("EGift Card Order Member Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.eGiftCardOrderMemberTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void PhysicalGiftCardAndAnyOneProductOrderPlacementGuestTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Physical Gift Card And AnyOne Product Order Placement Guest Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.physicalGiftCardAndAnyOneProductOrderPlacementGuestTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}



	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void PhysicalGiftCardOrderGuestTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Physical Gift Card Order Guest Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.physicalGiftCardOrderGuestTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void UserRegistrationTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("User Registration Test",machineName,method.getName());
		if(browser.equalsIgnoreCase("chrome")){
			for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
				//if(i==1) modulefunctionalities.NavigateToHomePage();
				modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
				if(!(modulefunctionalities.iterationCount.size()<=1)){
					Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
				}
				modulefunctionalities.userRegistrationTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
			}
		}else{
			throw new SkipException("Skipping this exception");
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void CategoryShoppingCartTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Category Shopping Cart Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.categoryShoppingCartTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void AccountDashboardTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Account Dashboard Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.accountDashboardTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void EGiftCardWithRegularProductTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("EGiftCard With Regular Product Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.eGiftCardWithRegularProductTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void EGiftCardMergeWithRegularProductTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("EGiftCard Merge With Regular Product Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.eGiftCardMergeWithRegularProductTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void EGiftCardOrderGuestTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("EGiftCard Order Guest Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.eGiftCardOrderGuestTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void EGiftCardOrderSecureLoginTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("EGiftCard Order Secure login Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.eGiftCardOrderSecureLoginTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void SavedCardOrderPlacementTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Saved Card Order Placement Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.savedCardOrderPlacementTestScenario(machineName,host, port, browser, os, browserVersion,osVersion,method.getName());
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void AddToCartDifferentCategoryProductsTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Add To Cart Different Category Products Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.addToCartDifferentCategoryProductsTestScenario(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
		}
		TestEnd();
	}
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void FooterLinksOnHomePageTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Footer Links On Home Page Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.footerLinksOnHomePageTestScenarioPartOne(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
			modulefunctionalities.footerLinksOnHomePageTestScenarioPartTwo(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
		}
		TestEnd();
	}
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void HeaderLinksOnHomePageTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Header Links On Home Page Test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.headerLinksOnHomePageTestScenario(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
		}
		TestEnd();
	}
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void SubcategoriesLinksNavigationOnHomePageTestPartOne(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Subcategories Links Navigation On Home Page Test",machineName,method.getName());
		if(browser.equalsIgnoreCase("Chrome")){
			for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
				//if(i==1) modulefunctionalities.NavigateToHomePage();
				modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
				if(!(modulefunctionalities.iterationCount.size()<=1)){
					Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
				}
				modulefunctionalities.subCategoriesLinksNavigationOnHomePageTestScenarioPartOne(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
			}
		}else{
			throw new SkipException("Skipping this exception");
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void SubcategoriesLinksNavigationOnHomePageTestPartTwo(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Subcategories Links Navigation On Home Page Test",machineName,method.getName());
		if(browser.equalsIgnoreCase("Chrome")){
			for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
				//if(i==1) modulefunctionalities.NavigateToHomePage();
				modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
				if(!(modulefunctionalities.iterationCount.size()<=1)){
					Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
				}
				modulefunctionalities.subCategoriesLinksNavigationOnHomePageTestScenarioPartTwo(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
			}
		}else{
			throw new SkipException("Skipping this exception");
		}
		TestEnd();
	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void SubcategoriesLinksNavigationOnHomePageTestPartThree(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Subcategories Links Navigation On Home Page Test",machineName,method.getName());
		if(browser.equalsIgnoreCase("chrome")){
			for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
				//if(i==1) modulefunctionalities.NavigateToHomePage();
				modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
				if(!(modulefunctionalities.iterationCount.size()<=1)){
					Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
				}
				modulefunctionalities.subCategoriesLinksNavigationOnHomePageTestScenarioPartThree(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
			}
		}else{
			throw new SkipException("Skipping this exception");
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void SubcategoriesLinksNavigationOnHomePageTestPartFour(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Subcategories Links Navigation On Home Page Test",machineName,method.getName());
		if(browser.equalsIgnoreCase("chrome")){
			for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
				//if(i==1) modulefunctionalities.NavigateToHomePage();
				modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
				if(!(modulefunctionalities.iterationCount.size()<=1)){
					Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
				}
				modulefunctionalities.subCategoriesLinksNavigationOnHomePageTestScenarioPartFour(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
			}
		}else{
			throw new SkipException("Skipping this exception");
		}
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port","selenium.browser", "selenium.os", "selenium.browserVersion","selenium.osVersion" })
	public void KeywordSearchTest(String machineName, String host, String port,String browser, String os, String browserVersion, String osVersion,Method method) {
		TestStart("Keyword search test",machineName,method.getName());
		for(int i=0;i<modulefunctionalities.iterationCount.size();i++){
			//if(i==1) modulefunctionalities.NavigateToHomePage();
			modulefunctionalities.dataRowNo=Integer.parseInt(modulefunctionalities.iterationCount.get(i).toString());
			if(!(modulefunctionalities.iterationCount.size()<=1)){
				Reporter.log(machineName+"<font size=4 color=blue>DataSet:"+(i+1)+"</font><br/>");
			}
			modulefunctionalities.keywordSearchTestScenario(machineName, host, port, browser, os, browserVersion, osVersion, method.getName());
		}
		TestEnd();
	}

	public void TestEnd() {
		if (modulefunctionalities.testCaseExecutionStatus) {
			GenericKeywords.testFailed();
		}
		waitTime(1);
		try {
			if (isAlertWindowPresent()) {
				driver.switchTo().alert().accept();
			}
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}	

}
