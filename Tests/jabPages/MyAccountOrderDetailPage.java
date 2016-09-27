package jabPages;

public class MyAccountOrderDetailPage extends MyAccountInformationPage{

	
	public void verifySizeAndColorInOrderDetailPage(String size, String color){
		if(getText("product size#xpath=//span[contains(text(),'Size:')]/parent::div").split(":")[1].trim().contains(size)){
			testStepPassed("Verified the Size of the product in order history product detail page");
		}else{
			testStepFailed("'"+size+"' Size of the product is not matching with the size mentioned in order history product detail page");
		}
		
		if(getText("product size#xpath=//span[contains(text(),'Color:')]/parent::div").split(":")[1].trim().contains(color)){
			testStepPassed("Verified the Color of the product in order history product detail page");
		}else{
			testStepFailed("'"+color+"' color of the product is not matching with the color mentioned in order history product detail page");
		}
	}
	
	public void clickOnProductImageInOrderDetailPage(){
		clickOn("product image#xpath=//div[contains(@class,'order-product-img')]/a/img");
	}
}
