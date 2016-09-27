 package scenarios;


import java.util.HashMap;

import jabPages.ProductDescriptionPage;
import jabPages.SignInPage;



public class AddToWishListGuestTest extends AddToCartDifferentCategoryProductsTest{
	private String productPromo;
	private String productName;
	private String productSize;
	private String productColor;
	private HashMap<String,String> hm=new HashMap<String,String>();

	public void addToWishListGuestTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			//Step 2: Go to any product category tab i.e. shirts, pants etc
			selectCategoryFromDepartmentMenu(retrieve("Department"), retrieve("SubCategory"));
			productPromo=getPromoForFirstProductListed();
			//3	Select any product.//4	Go to PDP.
			productName=selectProduct(retrieve("ProductName"));
			waitTime(5);
			//5	Select the size and other details and click on "Add to wish list".
			productSize=selectSizeProductDiscriptionPage(retrieve("ProductSize"));
			productColor=selectColorProductDiscriptionPage(retrieve("ProductColor"));
			clickOnAddToWishListProductDiscriptionPage();
			//6	Verify that Sign In page appears
			verifyLoginPage();
			//7	Login with existing user's credentials
			signIn(retrieve("Username"), retrieve("Password"));
			//8	Verify the product is seen in the wish list.
			//9	Verify the product details and promo description. in the wish list.
			hm=getProductDetails(getProductIdAttributeValue(productName));
			if(hm.get("prodTitle").equalsIgnoreCase(productName)){
				testStepPassed("Verified product name in wish list page");
			}else{
				testStepFailed("Product name listed in wish list is not matching with the product name added before sign in");
			}
			if(hm.get("prodColor").equalsIgnoreCase(productColor)){
				testStepPassed("Verified product colore in wish list page");
			}else{
				testStepFailed("Product color listed in wish list is not matching with the product color added before sign in");
			}
			if(hm.get("prodSize").equalsIgnoreCase(productSize)){
				testStepPassed("Verified product size in wish list page");
			}else{
				testStepFailed("Product size listed in wish list is not matching with the product size added before sign in");
			}
			if(!productPromo.isEmpty()){
				if(hm.get("prodPromo").equalsIgnoreCase(productPromo)){
					testStepPassed("Verified product promo in wish list page");
				}else{
					testStepFailed("Product promo listed in wish list is not matching with the product promo added before sign in");
				}
			}
			//10	Remove the product from the wish list and verify that 
			removeProduct(productName);
			waitTime(10);
			verifyProductNotListedInWishList(productName);
			//11	Logout
			clickOnSignOutLink();
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}
	}

}
