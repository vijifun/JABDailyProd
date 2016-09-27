package scenarios;

public class ShoppingCartTest extends SavedCardOrderPlacementTest{
	private String productName;
	private int itemCountOne;
	private int itemCountTwo;
	public void shoppingCartTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			//1.Launch JAB web application, login and navigate to PGP (any item)
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			navigateToHomePage();
			clickOnSignInLink();
			signIn(retrieve("Username"), retrieve("Password"));
			waitTime(2);
			clickOnMycart();
			waitTime(2);
			removeAllItemInMyCartPage();
			selectCategoryFromDepartmentMenu(retrieve("ProductOneDepartment"), retrieve("ProductOneSubCategory"));
			//2.Open QV
			productName=clickOnQuickView(retrieve("ProductOneName"));
			//3.Verify details seen on QV are as per requirement
			//4.Click on More details button to go to PDP
			clickOnMoreDetailBtnQuickViewPopup();
			//5.Select Size and Color and Click on Add to cart
			selectSizeProductDiscriptionPage(retrieve("ProductOneSize"));
			selectColorProductDiscriptionPage(retrieve("ProductOneColor"));
			clickOnAddToCartProductDiscriptionPage();
			waitForMiniCartToAppearAndDissapear();
			waitTime(2);
			//6.Go to PGP of any category
			selectCategoryFromDepartmentMenu(retrieve("ProductTwoDepartment"), retrieve("ProductTwoSubCategory"));
			clickOnQuickView(retrieve("ProductTwoName"));
			//7.Go to PDP of any product
			clickOnMoreDetailBtnQuickViewPopup();
			//8.Select Size and Color and Click on Add to cart
			selectSizeProductDiscriptionPage(retrieve("ProductTwoSize"));
			selectColorProductDiscriptionPage(retrieve("ProductTwoColor"));
			clickOnAddToCartProductDiscriptionPage();
			waitForMiniCartToAppearAndDissapear();
			waitTime(2);
			//9.Go to shopping cart and verify 2 items are added to cart 
			clickOnMycart();
			waitForText("Cart Details:");
			//10.Verify product details are as per requirement on shopping cart page
			//11.Select Quantity as 2 and verify that 3 items are added to cart
			itemCountOne=getNumberOfItemListedInMyCartPage();
			selectProductQuantityMyCartPage(productName, "2");
			waitForLoadingAndDissappearJABLoadingImg();
			itemCountTwo=getNumberOfItemListedInMyCartPage();
			if(itemCountTwo==itemCountOne+1){
				testStepPassed("Verified that 3 items are added to cart after adding the quantity for product "+productName);
			}else{
				testStepFailed("After adding the quantity the product item is not increased in My cart page");
			}
			//12.Verify the functionality of Edit Product Options on shopping cart page
			//14.Remove all the items, verify details on empty shopping cart page and logout.
			removeAllItemInMyCartPage();
			clickOnSignOutLink();
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}
	}

}
