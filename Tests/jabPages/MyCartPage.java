package jabPages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyCartPage extends MyAccountWishListPage{

	public static final String btn_proceedToCheckOut="Proceed to check out button#xpath=//span[contains(text(),'Proceed to Checkout')]/parent::span/parent::a";
	public static final String ele_cart_empty_msg="Shopping cart empty message#xpath=//div[@class='empty_cart_message']";
	public static final String myCart_errorMesage="My cart error message#xpath=//section[@id='order_details']//div[contains(@class,'international-error-msg')]/div";
	public static final String btn_CheckOut="Check out button#xpath=//div[contains(@id,'cartDropdown')]//span[contains(text(),'Checkout')]";

	public int getNumberOfItemListedInMyCartPage(){
		int num=0;
		List<WebElement> itemCount=driver.findElements(By.xpath("//section[@id='order_details']//div[@class='itemDetailsRow']"));
		num=itemCount.size();
		return num;
	}

	public void selectProductQuantityMyCartPage(String productName, String quantity){
		selectFromDropdown("'"+productName+"' quantity dropdown#xpath=//a[contains(@id,'catalogEntry_name') and contains(text(),'"+productName+"')]/parent::h2/parent::div/following-sibling::div/div[2]/select", quantity);
	}

	public void removeAllItemInMyCartPage(){
		List<WebElement> removeLink=driver.findElements(By.xpath("//div[@id='ShopCartPagingDisplay']//a[contains(text(),'Remove')]"));
		if(removeLink.size()>0){
			for(int i=removeLink.size();i>0;i--){
				clickOn("Remove link#xpath=//div[@id='ShopCartPagingDisplay']//a[contains(text(),'Remove')]");
				waitForLoadingAndDissappearJABLoadingImg();
			}
		}
	}

	public void clickOnProceedToCheckOut(){
		clickOn(btn_proceedToCheckOut);
	}

	public void verifyShoppingCartIsEmpty(){
		try{
			verifyElement(ele_cart_empty_msg);
			testStepPassed("verified shopping cart is empty");
		}catch(Exception e){
			testStepFailed("Shopping cart is not empty after removing all items");
		}
	}

	public boolean verifyQuantityNotInStockErrorMessage(){
		boolean flag=false;
		try{
			if(driver.findElement(By.xpath("//div[contains(@class,'page-level-error')]")).getText().contains("products you wish to purchase are not available in the quantity you requested")){
				flag= true;
			}
		}catch(Exception e){

		}
		return flag;

	}

	public void verifyErrorMessageInMyCartPage(String strErrorMessage){
		try{
			String errorMessage;
			if(driver.findElement(By.xpath("//div[contains(@class,'international-error-msg')]/div")).isDisplayed()){
				if(!strErrorMessage.isEmpty()){

				}else{
					errorMessage=getText(myCart_errorMesage);
					testStepPassed("Verified error message displayed as : '"+errorMessage+"'");
				}
			}
		}catch(Exception e){
			testStepFailed("There is no error message displayed");
		}
	}

	public void verifyAndMakeShoppingCartEmpty(){
		try{
			clickOnMycart();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			removeAllItemInMyCartPage();
		}catch(Exception e){

		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}


	}

	public void clickOnCheckOut(){
		if(isElementDisplayed(btn_CheckOut)){
			clickOn(btn_CheckOut);
		}else{
			testStepFailed("checkout popup is not displayed");
		}
	}

	public List<String> getProductNameListedInMyCartPage(){
		List<WebElement> productNameElement=driver.findElements(By.xpath("//a[contains(@id,'catalogEntry_name')]"));
		List<String> productNameListedInMyCartPage = new ArrayList<String>();

		for(WebElement ele:productNameElement){
			productNameListedInMyCartPage.add(ele.getText().trim());
		}
		return productNameListedInMyCartPage;
	}

	public void verifyAddedProductOnMyCartPage(String selectedProductName,List<String> productNameListedOnMyCartPage){
		for(int i=0;i<productNameListedOnMyCartPage.size();i++){
			if(selectedProductName.toLowerCase().contains(productNameListedOnMyCartPage.get(i).toLowerCase())){
				testStepPassed("The '"+selectedProductName+"' product is listed on MyCart Page");
				break;
			}
			if(i==productNameListedOnMyCartPage.size()-1){
				testStepFailed("The selected product is not listed on MyCart Page");
			}
		}
	}
}
