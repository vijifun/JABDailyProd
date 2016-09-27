package scenarios;

public class EGiftCardOrderGuestTest extends EGiftCardMergeWithRegularProductTest{


	public void eGiftCardOrderGuestTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Launch JAB application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			verifyAndMakeShoppingCartEmpty();
			//2.Add the E-gift card to shopping cart.
			clickOnFooterLink(retrieve("FooterLink"));
			waitForText("Gift Cards");
			selectProduct(retrieve("ProductName"));
			waitForText("Type of Gift Card:");
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftCardVerifyEmail"));
			clickOnAddToCartForEGiftCardPage();
			//clickOnMycart();
			//3.Proceed to checkout page.
			clickOnProceedToCheckOut();
			//4.Click on "Continue as Guest User" button on Secured Login page.
			clickOnGuestCheckout();
			//5.Enter billing address.
			fillBillingAddressDetails(retrieve("Country"), retrieve("FirstName"), retrieve("LastName"), retrieve("Company"), retrieve("StreetAddress"),
					retrieve("City"), retrieve("State"), retrieve("ZipCode"), retrieve("Phone"), retrieve("eMail"), retrieve("ConfirmEmail"));
			//chooseShippingAddressOptions("");
			clickOnContinueToPayment();
			//6.Enter the payment method details.
			chooseCreditCardOption();
			fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("cvv"));
			//7.Place the Order.
			if(clickOnPlaceOrder()){
				waitForText("Your Order is Complete");
				getOrderNumber();
				clickOnHeaderLogo();
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
