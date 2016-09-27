package scenarios;

public class PhysicalGiftCardOrderGuestTest extends PhysicalGiftCardAndAnyOneProductOrderPlacementGuestTest{

	public void physicalGiftCardOrderGuestTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			clickOnMycart();
			removeAllItemInMyCartPage();
			//2.Search and select Physical gift card and add to cart

			searchProduct(retrieve("ProductSearch"));
			waitTime(5);
			selectProduct(retrieve("ProductSearch"));


			waitForText("Type of Gift Card:");
			//selectGiftCardPrice(retrieve("GiftCardPrice"));
			selectPhysicalGiftCardPrice(retrieve("GiftCardPrice"));
			fillPhysicalGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"));
			clickOnAddToCartForPhysicalGiftCardPage();
			clickOnMycart();
			//3.Click on "Proceed To Checkout"
			clickOnProceedToCheckOut();
			//4.Click on "Checkout As Guest"
			clickOnGuestCheckout();
			//5.On Billing and Shipping Information page enter all field for Billing address and select any shipping address like "Same as Billing, Ship To Store, Ship To other" and click on "Continue To Payment".
			fillBillingAddressDetails(retrieve("Country"), retrieve("FirstName"), retrieve("LastName"), retrieve("Company"), retrieve("StreetAddress"),
					retrieve("City"), retrieve("State"), retrieve("ZipCode"), retrieve("Phone"), retrieve("eMail"), retrieve("ConfirmEmail"));
			chooseShippingAddressOptions("");
			clickOnContinueToPayment();
			//6.On Billing information page select any payment method : "Credit/ Debit Card, Bill Me Later , Paypal" and click on "Apply Payment/ Place Order"
			chooseCreditCardOption();
			fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("cvv"));
			if(clickOnPlaceOrder()){
			//7.Verify that order has been placed successfully
			waitForText("Your Order is Complete");
			String ordNum=getOrderNumber();
			testStepPassed("Order placed number :"+ordNum);
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
