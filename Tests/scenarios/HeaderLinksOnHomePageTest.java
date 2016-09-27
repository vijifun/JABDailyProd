package scenarios;

public class HeaderLinksOnHomePageTest extends GiftCardRedemptionTest {

	public void headerLinksOnHomePageTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);


			//Click on JAB logo to verify that JAB home page is displayed
			clickJabLogo();
			verifyHomePage();

			//Click on the 'Store Locator' link to verify that store locator page is displayed
			clickHeaderLink("Store Locator");
			verifyNavigatedPage("Store Locator");

			//Click on 'Order Status' link and verify that order status page is displayed.
			clickHeaderLink("Order Status");
			verifyNavigatedPage("Order Status");

			//Click on the 'Join Email List' link to verify that join email list pop-up is displayed
			clickOnJoinEmailListLink();
			verifyJoinEmailListLink();
			
			//Enter value in the search text box and click on 'GO' to verify that search results are displayed
			searchProduct("Traveler Traditional Fit Pinpoint Solid Buttondown Collar Dress Shirt");
			verifySearchResult("Traveler Traditional Fit Pinpoint Solid Buttondown Collar Dress Shirt");
			
			//Click on 'Change Region' link and verify that change region pop-up is displayed
			clickOnChangeRegionLink();
			verifyChangeRegionPopup();
			//Click on 'My Cart' link and verify that shopping cart page is displayed
			clickOnMyCartLink();
			verifyMyCartLink();

			//Click on the flag image and verify that change region pop-up is displayed
			clickOnFlag();
			verifyChangeRegionPopup();
			//Click on 'Sign In/Register' link to verify that sign in page is displayed.
			clickOnSignInLink();
			verifySignInPage();		

			//Sign In with valid user
			signIn(retrieve("Username"),retrieve("Password"));

			//Click on the 'My Account' link and verify that it navigates to My Account Information page
			clickHeaderLink("My Account");
			verifyNavigatedPage("My Account");

			//Click on 'Sign Out' link to verify that Sign In page is displayed
			clickOnSignOutLink();
			waitTime(5);
			verifySignInPage();		


		}catch(Exception e){
			testStepFailed("Exception occured: "+e.toString());
		}finally{
			driver.close();
		}

	}
}
