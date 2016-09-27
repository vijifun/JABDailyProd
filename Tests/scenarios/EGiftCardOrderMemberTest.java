package scenarios;

public class EGiftCardOrderMemberTest extends EGiftCardOrderGuestTest{

	public void eGiftCardOrderMemberTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			clickOnSignInLink();
			signIn(retrieve("Username"), retrieve("Password"));
			clickOnMycart();
			removeAllItemInMyCartPage();
			waitTime(2);
			clickOnFooterLink(retrieve("FooterLink"));
			waitForText("Gift Cards");
			selectProduct(retrieve("ProductName"));
			waitForText("Type of Gift Card:");
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftCardVerifyEmail"));
			clickOnAddToCartForEGiftCardPage();
			clickOnProceedToCheckOut();
			clickOnContinueToPayment();
			waitForText("How would you like to pay");
			chooseCreditCardOption();
			fillCreditCardDetails(retrieve("CreditCardType"), retrieve("CreditCardNumber"), retrieve("CreditCardExpiryMonth"), retrieve("CreditCardExpiryYear"), retrieve("SecurityId"));
			if(clickOnPlaceOrder()){
			getOrderNumber();
			clickOnHeaderLogo();
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
