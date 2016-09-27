package scenarios;

public class GiftCardRedemptionTest extends FooterLinksOnHomePageTest{
	public void giftCardRedemptionTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1. Launch JAB web application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			//2. Login to JAB app by member Login
			signIn(retrieve("Username"), retrieve("Password"));
			//3. Add the regular product to shopping cart.	
			selectCategoryFromDepartmentMenu(retrieve("ProductDepartment"), retrieve("ProductSubCategory"));
			selectProduct("ProductName");
			selectSizeProductDiscriptionPage(retrieve("ProductSize"));
			selectColorProductDiscriptionPage(retrieve("ProductColor"));
			clickOnAddToCartProductDiscriptionPage();
			//4. Proceed to checkout page.
			clickOnCheckOut();
			clickOnProceedToCheckOut();
			//5. Enter billing address.
			selectBillingAddressDropdown(1);
			fillBillingAddressDetails(retrieve("Country"), retrieve("FirstName"), retrieve("LastName"), retrieve("Company"), retrieve("StreetAddress"), retrieve("City"), retrieve("State"), retrieve("ZipCode"), retrieve("Phone"), retrieve("Email"), retrieve("ConfirmEmail"));
			//6. Enter the payment method as gift card.
			clickOnContinueToPayment();

			//7. Enter Gift card no and pin no and apply it.
			fillGiftCardDetails(retrieve("GiftCardNo"), retrieve("PIN"));
			clickOnApplyGiftCard();

			//If remaining balance > 0, select credit card and enter payment details

			chooseCreditCardOption();
			fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("CVV"));

			//8. Place order
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

