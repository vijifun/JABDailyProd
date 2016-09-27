package jabPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class ProductGridPage extends ProductDescriptionPage{

	public String selectFirstProductListed(){
		String productName;
		String locator="first product listed#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//div[contains(@class,'product_name')]//a";
		productName=getText(locator);
		clickOn(productName+" product name#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//a[contains(text(),'"+productName+"')]");
		return productName;
	}

	public String getPromoForFirstProductListed(){
		return getText("Promo of first product listed#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//div[contains(@class,'product_description')]/p");

	}

	public String selectProduct(String productName){
		//String prodName;
		if(!productName.isEmpty()){
			clickOn(productName+" product name#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//a[contains(text(),'"+productName+"')]");
			return productName;
		}else{
			String locator="first product listed#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//div[contains(@class,'product_name')]//a";
			productName=getText(locator);
			clickOn(productName+" product name#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//a[contains(text(),'"+productName+"')]");
			return productName;
		}
	}

	public String clickOnQuickView(String productName){
		//String prodName;
		if(!productName.isEmpty()){
			clickOn(productName+" product name Quick view button#xpath=//div[contains(@class,'product_listing_container')]//a[contains(text(),'"+productName+"')]/parent::h2/parent::div/parent::div//button[contains(@class,'quick-view-btn')]");
			return productName;
		}else{
			String locator="first product listed#xpath=//div[contains(@class,'product_listing_container')]/ul/li/div//div[contains(@class,'product_name')]//a";
			productName=getText(locator);
			clickOn(productName+" product name Quick view button#xpath=//div[contains(@class,'product_listing_container')]//a[contains(text(),'"+productName+"')]/parent::h2/parent::div/parent::div//button[contains(@class,'quick-view-btn')]");
			return productName;
		}
	}

	public String clickOnProductGroupInPGP(String productGroupName){
		if(!productGroupName.isEmpty()){
			clickOn("'"+productGroupName+"' product group link#xpath=//a[contains(@class,'product_group_name product') and contains(text(),'"+productGroupName+"')]");
			return productGroupName;
		}else{
			String locator="first product group listed#xpath=//a[contains(@class,'product_group_name product')]";
			productGroupName=getText(locator);
			clickOn("'"+productGroupName+"' product group link#xpath=//a[contains(@class,'product_group_name product') and contains(text(),'"+productGroupName+"')]");
			return productGroupName;
		}
	}

	public void clickonProductGroupInPGPIfAvailable(String productGroupName){
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//a[contains(@class,'product_group_name product')]")).isDisplayed()){
				clickOnProductGroupInPGP(productGroupName);
			}
		}catch(Exception e){
			System.out.println("Exception");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
	}
	
	public void verifyUserInProductGridPageWithProductListing(){
		try{
			if(driver.findElement(By.xpath("//div[@class='product_listing_container']")).isDisplayed()){
				testStepPassed("Verified user is navigated to product grid page with product listing");
			}
		}catch(Exception e){
			testStepFailed("User is not navigated to ptroduct grid page");
		}
	}
}
