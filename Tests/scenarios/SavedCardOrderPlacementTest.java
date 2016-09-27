package scenarios;

public class SavedCardOrderPlacementTest extends PhysicalGiftCardOrderGuestTest{

	public void savedCardOrderPlacementTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//Open Site
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			//1. Sign In using a existing user
			signIn(retrieve("Username"), retrieve("Password"));
			// Save card details
			clickOnMyAccountHeaderLink();
			clickOnLeftNavigationMyAccountPage("Billing Information");
			clickOnNewCardLinkInBillingInformationPage();
			fillNewPaymentOptionPopUpInBillingInformationPage(retrieve("CardType"),retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("FirstName"),
					retrieve("LastName"), retrieve("StreetAddressOne"), retrieve("StreetAddressTwo"), retrieve("StreetAddressThree"), retrieve("City"), retrieve("State"), retrieve("ZipCode"), retrieve("DaytimePhone"), retrieve("EveningPhone"), retrieve("Email"), retrieve("ConfirmEmail"), true);
			clickOnSaveBtnInNewPaymentOption();	
			//2. Search for a Product
			searchProduct(retrieve("ProductSearch"));
			waitTime(5);
			selectProduct("ProductName");
			//3. Add product to cart
			selectSizeProductDiscriptionPage(retrieve("ProductSize"));
			selectColorProductDiscriptionPage(retrieve("ProductColor"));
			clickOnAddToCartProductDiscriptionPage();
			//4. Checkout to Shopping Cart
			clickOnCheckOut();
			//5. Checkout from Shopping Cart
			clickOnProceedToCheckOut();
			//6. Select the details of a card that has been saved by the logged in user 
			clickOnContinueToPayment();
			chooseCreditCardOption();
			//Option to select details of a card that has been saved by the logged in user is not available in the application. Needs development.



			//fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("CVV"));
			//7. Place order
			if(clickOnPlaceOrder()){
				waitForText("Your Order is Complete");
				getOrderNumber();
			}else{
				clickOnBackTocartFromPaymentInfoPage();
				removeAllItemInMyCartPage();
			}
			clickOnSignOutLink();

		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}
	}
}
