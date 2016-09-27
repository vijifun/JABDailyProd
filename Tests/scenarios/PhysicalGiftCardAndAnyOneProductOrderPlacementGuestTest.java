package scenarios;

public class PhysicalGiftCardAndAnyOneProductOrderPlacementGuestTest extends KeywordSearchTest{

	public void physicalGiftCardAndAnyOneProductOrderPlacementGuestTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Launch JAB application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			clickOnMycart();
			removeAllItemInMyCartPage();
			//2.search and select any regular product and added to cart
			searchProduct(retrieve("ProductOneSearch"));
			waitTime(5);
			selectProduct(retrieve("ProductOneSearch"));
			selectSizeProductDiscriptionPage(retrieve("ProductOneSize"));
			selectColorProductDiscriptionPage(retrieve("ProductOneColor"));
			clickOnAddToCartProductDiscriptionPage();
			waitForMiniCartToAppearAndDissapear();
			//3.Search and select Physical gift card and added to cart
			searchProduct(retrieve("ProductTwoSearch"));
			waitTime(5);
			selectProduct(retrieve("ProductTwoSearch"));
			//selectSizeProductDiscriptionPage(retrieve("ProductTwoSize"));
			//selectColorProductDiscriptionPage(retrieve("ProductTwoColor"));
			//clickOnAddToCartProductDiscriptionPage();
			waitForText("Type of Gift Card:");
			waitTime(5);
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			fillPhysicalGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"));
			clickOnAddToCartForPhysicalGiftCardPage();
			waitTime(5);
			clickOnMycart();
			//4.Click on "Proceed To Checkout"
			clickOnProceedToCheckOut();
			//5.Click on "Checkout As Guest"
			clickOnGuestCheckout();
			//6.On Billing and Shipping Information page entered all field for Billing address and select any shipping address like "Same as Billing, Ship To Store, Ship To other" and click on "Continue To Payment".
			fillBillingAddressDetails(retrieve("Country"), retrieve("FirstName"), retrieve("LastName"), retrieve("Company"), retrieve("StreetAddress"),
					retrieve("City"), retrieve("State"), retrieve("ZipCode"), retrieve("Phone"), retrieve("eMail"), retrieve("ConfirmEmail"));
			//7.On Billing information page select any payment method : "Credit/ Debit Card, Bill Me Later , Paypal" and click on "Apply Payment/ Place Order"
			chooseShippingAddressOptions("");
			clickOnContinueToPayment();
			chooseCreditCardOption();
			fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("cvv"));
			if(clickOnPlaceOrder()){
				clickOnSignOutLink();
				getOrderNumber();
			}else{
				clickOnBackTocartFromPaymentInfoPage();
				removeAllItemInMyCartPage();
			}
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}
	}

}
