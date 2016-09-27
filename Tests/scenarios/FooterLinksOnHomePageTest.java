package scenarios;

import java.util.Iterator;
import java.util.List;

public class FooterLinksOnHomePageTest extends EGiftCardWithRegularProductTest {
	String currentWindow;

	public void footerLinksOnHomePageTestScenarioPartOne(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{

			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			currentWindow=driver.getWindowHandle();
			waitTime(5);
			closeSweepStakesPanelIfAvailable();
			verifyUSFlagSelected();


			//		2	Click on footer link 'Clearance Center' and verify that user is redirected to respective page
			clickOnFooterLink("Clearance Center");
			verifyLinkNavigatedPage("Clearance Center");

			//		3	Click on footer link 'Current Promotions' and verify that user is redirected to respective page
			clickOnFooterLink("Current Promotions");
			verifyLinkNavigatedPage("Current Promotions");

			//		4	Click on footer link 'Deals of the Day' and verify that user is redirected to respective page
			clickOnFooterLink("Deals of the Day");
			verifyLinkNavigatedPage("Deals of the Day");

			//		5	Click on footer link 'Gift Cards' and verify that user is redirected to respective page
			clickOnFooterLink("Gift Cards");
			verifyLinkNavigatedPage("Gift Cards");

			//		6	Click on footer link 'Customer Service Center' and verify that user is redirected to respective page
			clickOnFooterLink("Customer Service Center");
			verifyLinkNavigatedPage("Customer Service Center");

			//		7	Click on footer link 'International Shipping' and verify that user is redirected to respective page
			clickOnFooterLink("International Shipping");
			verifyLinkNavigatedPage("International Shipping");

			//		8	Click on footer link 'Privacy Policy' and verify that user is redirected to respective page
			clickOnFooterLink("Privacy Policy");
			verifyLinkNavigatedPage("Privacy Policy");

			//		9	Click on footer link 'Site Map' and verify that user is redirected to respectiver page
			clickOnFooterLink("Site Map");
			verifyLinkNavigatedPage("Site Map");

			//		10	Click on footer link 'Contact Us' and verify that user is redirected to respective page
			clickOnFooterLink("Contact Us");
			verifyLinkNavigatedPage("Contact Us");

			/*//		11	Click on footer link 'Company Information' and verify that user is redirected to respective page
			clickOnFooterLink("Company Information");
			verifyLinkNavigatedPage("Company Information");

			//		12	Click on footer link 'Jobs' and verify that user is redirected to respective page
			clickOnFooterLink("Jobs");
			verifyLinkNavigatedPage("Jobs");

			//		13	Click on footer link 'Store Locator' and verify that user is redirected to respective page
			clickOnFooterLink("Store Locator");
			verifyNavigatedPage("Store Locator");

			//		14	Click on footer link 'Order Status' and verify that user is redirected to respective page
			clickOnFooterLink("Order Status");
			verifyNavigatedPage("Order Status");

			//		15	Click on footer link 'Join Email List' and verify that user is redirected to respective page
			clickOnFooterLink("Join Email List");
			verifyJoinEmailListLink();

			//		16	Click on footer link 'Mobile Site' and verify that user is redirected to respective page

			//		17	Click on footer link 'Read Our Expert Advice' and verify that user is redirected to respective page
			clickOnFooterLink("Read Our Expert Advice");
			verifyLinkNavigatedPage("Read Our Expert Advice");
			
			driver.get(getConfigProperty("AppURL"));
			currentWindow=driver.getWindowHandle();
			waitTime(5);
			closeSweepStakesPanelIfAvailable();
			verifyUSFlagSelected();

			//		18	Click on footer link 'Join us on Facebook ' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Facebook");
			verifySocialLinkNavigatedPage("Facebook");
			getBackToOriginalWindow();

			//		19	Click on footer link 'Follow us on Twitter' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Twitter");
			verifySocialLinkNavigatedPage("Twitter");
			getBackToOriginalWindow();

			//		20	Click on footer link 'Follow us on Instagram'  and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Instagram");
			verifySocialLinkNavigatedPage("Instagram");
			getBackToOriginalWindow();

			//		21	Click on footer link 'Circle us on Google+' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Google+");
			verifySocialLinkNavigatedPage("Google+");

			getBackToOriginalWindow();
			//		22	Click on footer link 'Watch us on Youtube' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Youtube");
			verifySocialLinkNavigatedPage("Youtube");
			getBackToOriginalWindow();

			//		23	Click on footer link 'Follow us on Pinterest' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Pinterest");
			verifySocialLinkNavigatedPage("Pinterest");
			getBackToOriginalWindow();*/

		}catch(Exception e){
			testStepFailed(e.toString());
		}finally{
			driver.quit();
		}

	}
	
	public void footerLinksOnHomePageTestScenarioPartTwo(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{

			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			currentWindow=driver.getWindowHandle();
			waitTime(5);
			closeSweepStakesPanelIfAvailable();
			verifyUSFlagSelected();


		/*	//		2	Click on footer link 'Clearance Center' and verify that user is redirected to respective page
			clickOnFooterLink("Clearance Center");
			verifyLinkNavigatedPage("Clearance Center");

			//		3	Click on footer link 'Current Promotions' and verify that user is redirected to respective page
			clickOnFooterLink("Current Promotions");
			verifyLinkNavigatedPage("Current Promotions");

			//		4	Click on footer link 'Deals of the Day' and verify that user is redirected to respective page
			clickOnFooterLink("Deals of the Day");
			verifyLinkNavigatedPage("Deals of the Day");

			//		5	Click on footer link 'Gift Cards' and verify that user is redirected to respective page
			clickOnFooterLink("Gift Cards");
			verifyLinkNavigatedPage("Gift Cards");

			//		6	Click on footer link 'Customer Service Center' and verify that user is redirected to respective page
			clickOnFooterLink("Customer Service Center");
			verifyLinkNavigatedPage("Customer Service Center");

			//		7	Click on footer link 'International Shipping' and verify that user is redirected to respective page
			clickOnFooterLink("International Shipping");
			verifyLinkNavigatedPage("International Shipping");

			//		8	Click on footer link 'Privacy Policy' and verify that user is redirected to respective page
			clickOnFooterLink("Privacy Policy");
			verifyLinkNavigatedPage("Privacy Policy");

			//		9	Click on footer link 'Site Map' and verify that user is redirected to respectiver page
			clickOnFooterLink("Site Map");
			verifyLinkNavigatedPage("Site Map");

			//		10	Click on footer link 'Contact Us' and verify that user is redirected to respective page
			clickOnFooterLink("Contact Us");
			verifyLinkNavigatedPage("Contact Us");*/

			//		11	Click on footer link 'Company Information' and verify that user is redirected to respective page
			clickOnFooterLink("Company Information");
			verifyLinkNavigatedPage("Company Information");

			//		12	Click on footer link 'Jobs' and verify that user is redirected to respective page
			clickOnFooterLink("Jobs");
			verifyLinkNavigatedPage("Jobs");
			

			//		13	Click on footer link 'Store Locator' and verify that user is redirected to respective page
			clickOnFooterLink("Store Locator");
			verifyNavigatedPage("Store Locator");

			//		14	Click on footer link 'Order Status' and verify that user is redirected to respective page
			clickOnFooterLink("Order Status");
			verifyNavigatedPage("Order Status");

			//		15	Click on footer link 'Join Email List' and verify that user is redirected to respective page
			clickOnFooterLink("Join Email List");
			verifyJoinEmailListLink();

			//		16	Click on footer link 'Mobile Site' and verify that user is redirected to respective page

			//		17	Click on footer link 'Read Our Expert Advice' and verify that user is redirected to respective page
			clickOnFooterLink("Read Our Expert Advice");
			verifyLinkNavigatedPage("Read Our Expert Advice");
			
			driver.get(getConfigProperty("AppURL"));
			currentWindow=driver.getWindowHandle();
			waitTime(5);
			closeSweepStakesPanelIfAvailable();
			verifyUSFlagSelected();

			//		18	Click on footer link 'Join us on Facebook ' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Facebook");
			verifySocialLinkNavigatedPage("Facebook");
			getBackToOriginalWindow();

			//		19	Click on footer link 'Follow us on Twitter' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Twitter");
			verifySocialLinkNavigatedPage("Twitter");
			getBackToOriginalWindow();

			//		20	Click on footer link 'Follow us on Instagram'  and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Instagram");
			verifySocialLinkNavigatedPage("Instagram");
			getBackToOriginalWindow();

			//		21	Click on footer link 'Circle us on Google+' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Google+");
			verifySocialLinkNavigatedPage("Google+");

			getBackToOriginalWindow();
			//		22	Click on footer link 'Watch us on Youtube' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Youtube");
			verifySocialLinkNavigatedPage("Youtube");
			getBackToOriginalWindow();

			//		23	Click on footer link 'Follow us on Pinterest' and verify that user is redirected to respective social site
			clickOnFooterSocialLink("Pinterest");
			verifySocialLinkNavigatedPage("Pinterest");
			//getBackToOriginalWindow();

		}catch(Exception e){
			testStepFailed(e.toString());
		}finally{
			driver.quit();
		}

	}
	
	public void getBackToOriginalWindow(){
		driver.switchTo().window(currentWindow);
	}

}
