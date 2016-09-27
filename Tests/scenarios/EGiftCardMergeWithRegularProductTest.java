package scenarios;

public class EGiftCardMergeWithRegularProductTest extends CategoryShoppingCartTest{
	private String productName,productSize,productColor;
	
	public void eGiftCardMergeWithRegularProductTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Open JAB App for Guest User
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			verifyAndMakeShoppingCartEmpty();
			//Login as registered user, Add a regular Item, log out.
			clickOnSignInLink();
			signIn(retrieve("Username"), retrieve("Password"));
			verifyAndMakeShoppingCartEmpty();
			selectCategoryFromDepartmentMenu(retrieve("ProductOneDepartment"), retrieve("ProductOneSubCategory"));
			this.productName=clickOnQuickView(retrieve("ProductOneName"));
			clickOnMoreDetailBtnQuickViewPopup();
			this.productSize=selectSizeProductDiscriptionPage(retrieve("ProductOneSize"));
			this.productColor=selectColorProductDiscriptionPage(retrieve("ProductOneColor"));
			clickOnAddToCartProductDiscriptionPage();
			waitTime(5);
			clickOnSignOutLink();
			//2.Add an e-gift card and go to cart then login.
			clickOnFooterLink(retrieve("FooterLink"));
			waitForText("Gift Cards");
			selectProduct(retrieve("ProductTwoName"));
			waitForText("Type of Gift Card:");
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftCardVerifyEmail"));
			clickOnAddToCartForEGiftCardPage();
			waitForLoadingAndDissappearJABLoadingImg();
			waitForText("Cart Details");
			clickOnSignInLink();
			signIn(retrieve("Username"), retrieve("Password"));
			//3.Expected result: it should give an error.
			verifyErrorMessageInMyCartPage("");
			clickOnMycart();
			removeAllItemInMyCartPage();
			clickOnSignOutLink();
		}catch(Exception e){
			testStepFailed("Exception occured: "+e);
		}finally{
			driver.close();
		}
	}
}
