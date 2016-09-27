package scenarios;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;



public class CategoryShoppingCartTest extends AddToWishListGuestTest{
	private List<String> departmentMenuList= new ArrayList<String>();
	private String productName,categoryLink,departmentMenu;
	private int initialCount=0, finalCount=0;

	public void categoryShoppingCartTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{	
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			clickOnMycart();
			removeAllItemInMyCartPage();
			departmentMenuList=getListOfDepartmentMenuName();
			//8.Repeat the steps 2 to 8 for all main categories. 
			for(int i=0;i<departmentMenuList.size();i++){
				//1.Go to first category from top navigation and click on any sub category to go to its PGP
				departmentMenu=WordUtils.capitalize(departmentMenuList.get(i).toLowerCase());
				if(departmentMenu.contains("Shoes And Accessories")){
					departmentMenu="Shoes and Accessories";
				}
				categoryLink=clickOnAnyCategoryOrSubCategoryLink(departmentMenu);
				clickonProductGroupInPGPIfAvailable("");
				//2	Select a product to view in QV
				productName=clickOnQuickView("");
				//3	Click more details to go PDP
				clickOnMoreDetailBtnQuickViewPopup();
				//4	Select the size and add to cart.
				selectSizeProductDiscriptionPage("");
				selectColorProductDiscriptionPage("");
				//8.Make sure you add tailoring options when pants is selected. THIS IS IMPORTANT STEP.
				selectTailoringOptionIfAvailable(retrieve("TailoringOption"));
				selectFinishOptionIfAvailable(retrieve("FinishOption"));
				selectOutseamOptionIfAvailable(retrieve("OutseamOption"));
				clickOnAddToCartProductDiscriptionPage();
				waitTime(10);
				//5	Go to shopping cart and see the product.
				clickOnMycart();
				waitTime(5);
				initialCount=getNumberOfItemListedInMyCartPage();
				//6	Update the qty to 2
				selectProductQuantityMyCartPage(productName, "2");
				waitTime(10);
				finalCount=getNumberOfItemListedInMyCartPage();
				if(finalCount==initialCount+1){
					testStepPassed("Verified the product quantity has been increased after adding the quantity");
				}else{
					if(verifyQuantityNotInStockErrorMessage()){
						testStepFailed("The quantity for the product '"+productName+"' from department '"+departmentMenuList.get(i)+"' and category '"+categoryLink+"' is NOT in stock");
					}else{
						testStepFailed("The product qualtity is not increased by product quantity selection for the product '"+productName+"' from department '"+departmentMenuList.get(i)+"' and category '"+categoryLink+"'");
					}
				}
				//7	Click on remove to remove the item from cart.
				removeAllItemInMyCartPage();
				waitTime(5);
				verifyShoppingCartIsEmpty();
				initialCount=0;
				finalCount=0;
				productName="";
				categoryLink="";
			}
		}catch(Exception e){
			System.out.println(e);
			testStepFailed("Exception occured : "+e);
		}finally{
			driver.close();
		}
	}
}
