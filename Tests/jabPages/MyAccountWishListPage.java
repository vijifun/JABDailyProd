package jabPages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class MyAccountWishListPage extends MyAccountPage {

	@SuppressWarnings("unused")
	public HashMap<String, String> getProductDetails(String productIDAttribute){
		String prodTitle;
		String prodItemNumber;
		String prodColor;
		String prodSize;
		String prodPrize;
		String prodPromo;
		HashMap<String, String> productDetails = new HashMap<String, String>();
		
		prodTitle=driver.findElement(By.xpath("//div[@id='"+productIDAttribute+"']//div[@class='wish-list-entry']//div[@class='wish-list-title']")).getText().trim();
		prodItemNumber=driver.findElement(By.xpath("//div[@id='"+productIDAttribute+"']//div[@class='wish-list-entry']//div[@class='wish-list-attr wish-list-sku']")).getText().trim();
		prodColor=driver.findElement(By.xpath("//div[@id='"+productIDAttribute+"']//div[@class='wish-list-entry']//span[contains(text(),'Color:')]/parent::div")).getText().split(":")[1].trim();
		prodSize=driver.findElement(By.xpath("//div[@id='"+productIDAttribute+"']//div[@class='wish-list-entry']//span[contains(text(),'Size:')]/parent::div")).getText().split(":")[1].trim();
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		prodPromo=driver.findElement(By.xpath("//div[@id='"+productIDAttribute+"']//div[@class='wish-list-entry']//div[contains(@class,'wish-list-promo')]")).getText().trim();
		productDetails.put("prodPromo", prodPromo);
		}catch(Exception e){
			
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
		productDetails.put("prodTitle", prodTitle);
		productDetails.put("prodItemNumber", prodItemNumber);
		productDetails.put("prodColor", prodColor);
		productDetails.put("prodSize", prodSize);
		
		return productDetails;
	}
	public String getProductIdAttributeValue(String productName){
		return driver.findElement(By.xpath("//div[@class='wishlist']//div[contains(text(),'"+productName+"')]/ancestor::div[@class='wish-list-item']")).getAttribute("id");
	}
	
	public void removeProduct(String productName){
		String id=getProductIdAttributeValue(productName);
		String locator="'"+productName+"' remove link#xpath=//div[@id='"+id+"']//div[@class='wish-list-entry']//div[contains(@class,'link-list')]/a[contains(text(),'Remove')]";
		clickOn(locator);
	}
	
	public void verifyProductNotListedInWishList(String productName){
		try{
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class='wishlist']//div[contains(text(),'"+productName+"')]"));
			testStepFailed("'"+productName+"' product name is listed in wish list");
		}catch(Exception e){
			testStepPassed("Verified '"+productName+"' product name is NOT listed in wish list");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime,TimeUnit.SECONDS);
		}
	}
}
