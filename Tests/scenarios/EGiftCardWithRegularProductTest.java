package scenarios;

public class EGiftCardWithRegularProductTest extends EGiftCardOrderSecureLoginTest{
private String productName,productSize,productColor;
	public void eGiftCardWithRegularProductTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Open JAB App for Guest User
			openBrowser(machineName,host,port,browser,os,browserVersion,osVersion);
			verifyUSFlagSelected();
			verifyAndMakeShoppingCartEmpty();
			//2.Click on Gift card in Footer section
			clickOnFooterLink(retrieve("FooterLink"));
			waitForText("Gift Cards");
			//3.Click on "JoS. A. Bank e-Gift Card " or E-Gift card Image.It Should be redirected on E-Gift card PDP.
			selectProduct(retrieve("ProductOneName"));
			waitForText("Type of Gift Card:");
			//4.Fill all fields on PDP and Click on Add To Cart.It should be redirected on Shopping cart.
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftCardVerifyEmail"));
			clickOnAddToCartForEGiftCardPage();
			waitForLoadingAndDissappearJABLoadingImg();
			waitForText("Cart Details");
			//5.Add any regular product into cart.
			selectCategoryFromDepartmentMenu(retrieve("ProductTwoDepartment"), retrieve("ProductTwoSubCategory"));
			this.productName=clickOnQuickView(retrieve("ProductTwoName"));
			clickOnMoreDetailBtnQuickViewPopup();
			this.productSize=selectSizeProductDiscriptionPage(retrieve("ProductTwoSize"));
			this.productColor=selectColorProductDiscriptionPage(retrieve("ProductTwoColor"));
			clickOnAddToCartProductDiscriptionPage();
			//6.User should not be able to add regular product into cart.Error message should be seen after adding any product into cart
			verifyErrorMessageInPDP("");
			
		}catch(Exception e){
			
		}finally{
			driver.close();
		}
	}
}
