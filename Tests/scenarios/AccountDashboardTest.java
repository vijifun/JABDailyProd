package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import headStart.HeaderLinks;
import jabPages.SignInPage;

public class AccountDashboardTest extends SignInPage{
	private String productName,orderNumber,productSize,productColor;

	public void accountDashboardTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Launch JAB web application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			clickOnSignInLink();
			//2.Login and place a order
			signIn(retrieve("Username"), retrieve("Password"));
			waitTime(6);
			if(orderPlacementFlag==true){
				verifyAndMakeShoppingCartEmpty();
				waitTime(2);
				selectCategoryFromDepartmentMenu(retrieve("ProductDepartment"), retrieve("ProductSubCategory"));
				productName=clickOnQuickView(retrieve("ProductName"));
				clickOnMoreDetailBtnQuickViewPopup();
				productSize=selectSizeProductDiscriptionPage(retrieve("ProductSize"));
				productColor=selectColorProductDiscriptionPage(retrieve("ProductColor"));
				clickOnAddToCartProductDiscriptionPage();
				waitTime(5);
				clickOnMycart();
				clickOnProceedToCheckOut();
				chooseShippingAddressOptions("");
				clickOnContinueToPayment();
				chooseCreditCardOption();
				waitTime(3);
				fillCreditCardDetails(retrieve("CardType"), retrieve("CardNumber"), retrieve("ExpireMonth"), retrieve("ExpireYear"), retrieve("CVV"));
				waitTime(3);
				clickOnPlaceOrder();
				waitForText("Your Order is Complete");
				waitTime(3);
				orderNumber=getOrderNumber();
				navigateToHomePage();
				//3.Click on My Account from home page header
				clickOnMyAccountHeaderLink();
				//4.Verify correct left navigation menu is displayed on My Account page
				verifyMyAccountLeftNavigationLinks();
				//5.Navigate to My Account->Order History
				clickOnLeftNavigationMyAccountPage("Order History");
				//6.Verify that the order details are displayed
				verifyOrderNumberDispayedOnOrderHistory(orderNumber);
				clickOnViewOrderInOrderHistoryPage(orderNumber);
				//7.Click on order number -- order details should be displayed
				verifySizeAndColorInOrderDetailPage(productSize, productColor);
				//8.Click on the product image -- PDP for the product should be displayed
				clickOnProductImageInOrderDetailPage();
				verifyUserInProductDescriptionPage();
			}
			clickOnMyAccountHeaderLink();
			//9.Click on My Account->My Account Information
			clickOnLeftNavigationMyAccountPage("My Account Information");
			waitForText("My Account Information");
			//10.Click on Edit Email button, change email and verify the changes
			clickOnEditEmailLinkInAccountInformationPage();
			//String newEmailId=retrieve("newEmailId");
			String username=retrieve("newEmailId");
			String newEmailId=username.split("@")[0]+"_"+getCurrentDateAndTimeStamp()+"@"+username.split("@")[1];
			fillEditEmailAddressDetails(newEmailId, newEmailId);
			clickOnEditEmailSaveButton();
			waitForLoadingAndDissappearJABLoadingImg();
			if(newEmailId.equalsIgnoreCase(getEmailIdDisplayedOnMyAccountInformationPage())){
				testStepPassed("Verified email id has been changed to new id :"+getEmailIdDisplayedOnMyAccountInformationPage());

			}else{
				testStepFailed("Modified Email id is not matching with new id or unable to change the username");
			}
			// reverting back to old username
			if(!retrieve("Username").equalsIgnoreCase(getEmailIdDisplayedOnMyAccountInformationPage())){
				newEmailId=retrieve("Username");
				clickOnEditEmailLinkInAccountInformationPage();
				fillEditEmailAddressDetails(newEmailId, newEmailId);
				clickOnEditEmailSaveButton();
				waitForLoadingAndDissappearJABLoadingImg();
				if(newEmailId.equalsIgnoreCase(getEmailIdDisplayedOnMyAccountInformationPage())){
					testStepPassed("Username reverted back to old id :"+getEmailIdDisplayedOnMyAccountInformationPage());
				}else{
					testStepFailed("unable to revert back old username");
				}
			}


			///////////////New password change//////////////
			//11.Click on Edit Password button, change password and verify the changes
			/*clickOnEditPasswordLinkInAccountInformationPage();
			String newpassword=retrieve("newPassword");
			fillEditPasswordDetails(newpassword, newpassword);
			clickOnEditPasswordSaveButton();
			waitForLoadingAndDissappearJABLoadingImg();*/

			///////////////////////////////////////////
			//12.Go to My account >Billing Information
			clickOnLeftNavigationMyAccountPage("Billing Information");
			waitForText("Billing Information");
			//13.Click on New card.
			clickOnNewCardLinkInBillingInformationPage();
			//14.Select different credit card type
			//15.Enter all mandatory details.
			fillNewPaymentOptionPopUpInBillingInformationPage(retrieve("NewCardType"), retrieve("NewCardNumber"), retrieve("NewExpireMonth"), retrieve("NewExpireYear"), retrieve("NewFirstName"), retrieve("NewLastName"), 
					retrieve("NewStreetAddressOne"), "", retrieve("NewStreetAddressThree"), retrieve("NewCity"), retrieve("NewState"), retrieve("NewZipCode"), retrieve("NewPhone"), "", retrieve("NeweMail"), retrieve("NewConfirmEmail"), true);
			//16.Save the details.
			clickOnSaveBtnInNewPaymentOption();
			waitForLoadingAndDissappearJABLoadingImg();
			//clickOnEditBtnInDefaultPaymentOption();
			waitTime(10);
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath("//div[@class='address-book-default']//a[contains(text(),'Edit')]")).isDisplayed()){
					clickOnEditBtnInDefaultPaymentOption();
				}
			}catch(Exception e){
				clickOnMakeThisMyDefaultInMyAccountBillingInfoPage(retrieve("NewFirstName")+" "+retrieve("NewLastName"));
				waitForLoadingAndDissappearJABLoadingImg();
				clickOnEditBtnInDefaultPaymentOption();
			}
			editDefaultPaymentOptionPopUpInBillingInformationPage("", "", "", retrieve("NewStreetAddressTwo"), "", "", "", "", "", "", "", "", true);
			clickOnSaveBtnEditDefaultPaymentOptionPopup();waitForLoadingAndDissappearJABLoadingImg();
			//17.Verify editing billing information
			clickOnEditBtnInDefaultPaymentOption();
			if(getValueFromEditBillinginformationPopUp("address two").contains(retrieve("NewStreetAddressTwo"))){
				testStepPassed("Verified the edit billing information");
			}else{
				testStepFailed("Edit billing information is not matching with edited value");
			}
			clickOnCancelBtnEditDefaultPaymentOptionPopup();
			waitForText("Billing Information");

			clickOnRemoveBtnInDefaultPaymentOption();
			waitForLoadingAndDissappearJABLoadingImg();waitTime(3);
			//18.Verify deleting billing information
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath("//div[@class='address-book-default']//a[contains(text(),'Edit')]")).isDisplayed())
					testStepFailed("Billing information is not deleted");
			}catch(Exception e){
				testStepPassed("Verified billing information is deleted");
			}finally{
				driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
			}
			//19.Go to My account >Address Book
			clickOnLeftNavigationMyAccountPage("Address Book");
			waitForText("My Address Book");
			//20.Add address and verify
			clickOnNewAddressLinkInAddressBookPage();
			waitTime(3);
			fillNewShippingAddressOptionPopUpInAddressBookPage(retrieve("NewShippingFirstName"), retrieve("NewShippingLastName"), retrieve("NewShippingStreetAddressOne"), "", retrieve("NewShippingStreetAddressThree"), retrieve("NewShippingCity"), retrieve("NewShippingState"), retrieve("NewShippingZipCode"), retrieve("NewShippingPhone"), false);
			waitTime(3);
			clickOnSaveBtnInNewShippingAddressPopup();
			waitForLoadingAndDissappearJABLoadingImg();
			waitTime(3);
			//21.Edit address and verify
			clickOnEditBtnInAdditionalShippingAddress(retrieve("NewShippingFirstName")+" "+ retrieve("NewShippingLastName"));
			waitTime(2);
			editAdditionalShippingAddressPopUpInAddressBookPage("", "", "", retrieve("NewShippingStreetAddressTwo"), "", "", "", "", "", false);
			clickOnSaveBtnEditShippingAddressPopup();
			waitForLoadingAndDissappearJABLoadingImg();
			waitTime(3);
			clickOnEditBtnInAdditionalShippingAddress(retrieve("NewShippingFirstName")+" "+ retrieve("NewShippingLastName"));
			if(getValueFromEditShippingAddressPopUp("address two").contains(retrieve("NewShippingStreetAddressTwo"))){
				testStepPassed("Verified the edit shipping information");
			}else{
				testStepFailed("Edit shipping information is not matching with edited value");
			}
			clickOnCancelBtnEditShippingAddressPopup();
			waitForText("My Address Book");
			//22.Remove address and verify
			waitTime(5);
			//clickOnRemoveBtnInAdditionalShippingAddress(retrieve("NewShippingFirstName")+" "+ retrieve("NewShippingLastName"));
			removeAllAddressInAdditionalShippingAddress(retrieve("NewShippingFirstName")+" "+ retrieve("NewShippingLastName"));
			waitForLoadingAndDissappearJABLoadingImg();
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath("//div[@class='address-book-additional']//p[contains(text(),'"+retrieve("NewShippingFirstName")+" "+ retrieve("NewShippingLastName")+"')]/parent::div//a[contains(text(),'Edit')]")).isDisplayed()){
					testStepFailed("Shipping address is not deleted");
				}
			}catch(Exception e){
				testStepPassed("Verified shipping address is deleted");
			}finally{
				driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
			}
			//23.Logout
			clickOnSignOutLink();
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}
	}
}
