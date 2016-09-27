package scenarios;

import java.util.ArrayList;
import java.util.List;

public class AddToCartDifferentCategoryProductsTest extends AccountDashboardTest {

	/*public void addToCartDifferentCategoryProductsTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		List<String> productNameListedOnMyCartPage= new ArrayList<String>();
		String selectedProductName; 
		//		Verify add to cart of Each product ( suits,ties,accessory,pant,shoes,physical gift card and egift card) works correctly


		try{	
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			selectCategoryFromDepartmentMenu("Suits","All Suits");
			selectedProductName = selectProduct("");
			waitTime(3);
			selectSizeProductDiscriptionPage("");
			selectColorProductDiscriptionPage("");
			clickOnAddToCartProductDiscriptionPage();
			waitTime(3);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify ties			
			selectCategoryFromDepartmentMenu("Ties","Executive Ties");
			selectedProductName = selectProduct("");
			waitTime(5);
			selectSizeProductDiscriptionPage("");
			selectColorProductDiscriptionPage("");
			clickOnAddToCartProductDiscriptionPage();
			waitTime(10);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify accessory
			selectCategoryFromDepartmentMenu("Shoes and Accessories","Casual Belts");
			selectedProductName = selectProduct("");
			waitTime(3);
			selectSizeProductDiscriptionPage("");
			selectColorProductDiscriptionPage("");
			clickOnAddToCartProductDiscriptionPage();
			waitTime(10);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify pant
			selectCategoryFromDepartmentMenu("Pants","Traveler Dress Pants");
			selectedProductName = selectProduct("");
			waitTime(3);
			selectSizeProductDiscriptionPage("");
			selectColorProductDiscriptionPage("");
			clickOnAddToCartProductDiscriptionPage();
			waitTime(10);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify shoes
			selectCategoryFromDepartmentMenu("Shoes and Accessories","Cole Haan");
			selectedProductName = selectProduct("");
			waitTime(3);
			selectSizeProductDiscriptionPage("");
			selectColorProductDiscriptionPage("");
			clickOnAddToCartProductDiscriptionPage();
			waitTime(10);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify physical card			
			clickOnFooterLink(retrieve("FooterLink"));
			selectedProductName = selectProduct(retrieve("ProductOne"));
			waitForText("Type of Gift Card:");
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			fillPhysicalGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"));
			clickOnAddToCartForPhysicalGiftCardPage();
			waitTime(3);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();
			waitTime(2);
			
			//Add to cart and verify egift card
			clickOnFooterLink(retrieve("FooterLink"));
			selectedProductName = selectProduct(retrieve("ProductTwo"));
			waitForText("Type of Gift Card:");
			selectGiftCardPrice(retrieve("GiftCardPrice"));
			filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftcardToEmail"));
			clickOnAddToCartForEGiftCardPage();
			waitTime(3);
			clickOnMycart();
			productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
			verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
			removeAllItemInMyCartPage();
			verifyShoppingCartIsEmpty();

		}catch(Exception e){
			testStepFailed(e.toString());
		}finally{
			driver.close();
		}
	}*/
	
	
	public void addToCartDifferentCategoryProductsTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		List<String> productNameListedOnMyCartPage= new ArrayList<String>();
		String selectedProductName; 
		//		Verify add to cart of Each product ( suits,ties,accessory,pant,shoes,physical gift card and egift card) works correctly


		try{	
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			if(!retrieve("DepartmentName").isEmpty()){

				selectCategoryFromDepartmentMenu(retrieve("DepartmentName"),retrieve("CategoryName"));
				selectedProductName = selectProduct(retrieve("ProductName"));
				waitTime(10);
				selectSizeProductDiscriptionPage(retrieve("ProductSize"));
				selectColorProductDiscriptionPage(retrieve("ProductColor"));
				clickOnAddToCartProductDiscriptionPage();
				waitTime(5);
				clickOnMycart();
				productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
				verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
				removeAllItemInMyCartPage();
				verifyShoppingCartIsEmpty();
				waitTime(2);
			}else if(retrieve("DepartmentName").isEmpty() && !retrieve("FooterLink").isEmpty()){


				//Add to cart and verify physical card			
				clickOnFooterLink(retrieve("FooterLink"));

				selectedProductName = selectProduct(retrieve("ProductName"));
				waitForText("Type of Gift Card:");
				selectGiftCardPrice(retrieve("GiftCardPrice"));
				if(retrieve("ProductName").equalsIgnoreCase("JoS. A. Bank Gift Card")){
					fillPhysicalGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"));
					clickOnAddToCartForPhysicalGiftCardPage();
				}else if(retrieve("ProductName").equalsIgnoreCase("JoS. A. Bank eGift Card")){
					filleGiftCardDetails(retrieve("GiftCardTo"), retrieve("GiftCardFrom"), retrieve("GiftCardMessage"), retrieve("GiftcardToEmail"), retrieve("GiftcardToEmail"));
					clickOnAddToCartForEGiftCardPage();
				}
				waitTime(3);
				clickOnMycart();
				waitTime(3);
				productNameListedOnMyCartPage = getProductNameListedInMyCartPage();
				verifyAddedProductOnMyCartPage(selectedProductName,productNameListedOnMyCartPage);
				removeAllItemInMyCartPage();
				verifyShoppingCartIsEmpty();
				waitTime(2);
			}


		}catch(Exception e){
			testStepFailed("Exception occured : "+e.toString());
		}finally{
			driver.close();
		}
	}
}