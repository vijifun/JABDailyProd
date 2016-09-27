package jabPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescriptionPage extends PaymentInformationPage{

	public static final String drp_sizeSelection="size selection drop down#xpath=//select[@name='sizeAttrValueSelect']";
	public static final String drp_colorSelection="size selection drop down#xpath=//select[@name='colorAttrValueSelect']";
	public static final String drp_quantitySelection="quantity selection drop down#xpath=//select[@name='quantity']";
	public static final String btn_addToCart=" Add to cart button#xpath=//span[contains(text(),'Add To Cart')]/parent::button";
	public static final String btn_addToWishList=" Add to Wish List button#xpath=//span[contains(text(),'Added to Wish List')]/preceding-sibling::button";
	public static final String drp_tailoring="tailoring dropdown#xpath=//select[contains(@name,'tailoring')]";
	public static final String drp_finish="finish dropdown#xpath=//select[contains(@name,'finish')]";
	public static final String drp_outseam="outseam dropdown#xpath=//select[contains(@name,'outseam')]";

	public static final String pdp_errorMesage="Error message#xpath=//div[contains(@id,'page-level-error-content')]";

	public String selectSizeProductDiscriptionPage(String size){
		String selectedValue=null;
		if(!size.isEmpty()){
			selectFromDropdown(drp_sizeSelection, size);
			selectedValue=size;
		}else{
			List<WebElement> options=driver.findElements(By.xpath("//select[@name='sizeAttrValueSelect']/option"));
			selectedValue=options.get(1).getAttribute("value");
			selectFromDropdown(drp_sizeSelection, selectedValue);
		}
		return selectedValue;
	}

	public String selectColorProductDiscriptionPage(String color){
		String selectedValue=null;
		if(!color.isEmpty()){
			selectFromDropdown(drp_colorSelection, color);
			selectedValue=color;
		}else{
			List<WebElement> options=driver.findElements(By.xpath("//select[@name='colorAttrValueSelect']/option"));
			selectedValue=options.get(1).getAttribute("value");
			selectFromDropdown(drp_colorSelection, selectedValue);
		}
		return selectedValue;
	}

	public void clickOnAddToCartProductDiscriptionPage(){
		if(currentBrowser.equalsIgnoreCase("InternetExplorer")){
			clickOnSpecialElement(btn_addToCart);
		}else{
			clickOn(btn_addToCart);
		}
	}
	public void clickOnAddToWishListProductDiscriptionPage(){
		clickOn(btn_addToWishList);
	}

	public String selectTailoringOptionIfAvailable(String tailoringOption){
		try{

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//select[contains(@name,'tailoring')]")).isDisplayed()){
				driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
				try{
					if(!tailoringOption.isEmpty()){
						selectFromDropdown(drp_tailoring, tailoringOption);
					}
					else {
						List<WebElement> options=driver.findElements(By.xpath("//select[contains(@name,'tailoring')]/option"));
						for(int i=0; i<options.size();i++){
							if(!options.get(i).getText().trim().equalsIgnoreCase("none")){
								tailoringOption=options.get(i).getText().trim();
								break;
							}
						}
						selectFromDropdown(drp_tailoring, tailoringOption);
					}
				}catch(Exception f){
					testStepFailed("Unable to select '"+tailoringOption+"' from tailoring option drop down");
				}
			}
		}catch(Exception e){
			testStepPassed("Skipping tailoring option selection since the option was not available");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
		return tailoringOption;

	}

	public String selectCreaseOptionIfAvailable(String creaseOption){
		try{

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//select[contains(@name,'crease')]")).isDisplayed()){
				driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
				creaseOption=selectCreaseOption(creaseOption);
			}
		}catch(Exception e){
			testStepPassed("Skipping crease option selection since the option was not available");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
		return creaseOption;

	}

	public String selectCreaseOption(String creaseOption){
		try{
			if(!creaseOption.isEmpty()){
				selectFromDropdown(drp_tailoring, creaseOption);
			}
			else {
				List<WebElement> options=driver.findElements(By.xpath("//select[contains(@name,'crease')]/option"));
				for(int i=0; i<options.size();i++){
					if(!options.get(i).getText().trim().equalsIgnoreCase("none")){
						creaseOption=options.get(i).getText().trim();
						break;
					}
				}
				selectFromDropdown(drp_tailoring, creaseOption);
			}
		}catch(Exception f){
			testStepFailed("Unable to select '"+creaseOption+"' from crease option drop down");
		}
		return creaseOption;
	}

	public String selectFinishOptionIfAvailable(String finishOption){
		String selectedValue=null;
		try{
			waitTime(3);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//select[contains(@name,'finish')]")).isDisplayed()){
				if(!finishOption.isEmpty()){
					selectFromDropdown(drp_finish, finishOption);
					selectedValue=finishOption;
				}
				else {
					List<WebElement> options=driver.findElements(By.xpath("//select[contains(@name,'finish')]/option"));
					selectedValue=options.get(1).getText();
					selectFromDropdown(drp_finish, selectedValue);
				}
			}
		}catch(Exception e){
			System.out.println("Exception");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
		return selectedValue;

	}
	public String selectOutseamOptionIfAvailable(String outseamOption){
		String selectedValue=null;
		try{

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//select[contains(@name,'outseam')]")).isDisplayed()){
				if(!outseamOption.isEmpty()){
					selectFromDropdown(drp_outseam, outseamOption);
					selectedValue=outseamOption;
				}
				else {
					List<WebElement> options=driver.findElements(By.xpath("//select[contains(@name,'outseam')]/option"));
					selectedValue=options.get(1).getText();
					selectFromDropdown(drp_outseam, selectedValue);
				}
			}
		}catch(Exception e){
			System.out.println("Exception");
		}finally{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
		return selectedValue;

	}

	public void verifyErrorMessageInPDP(String strErrorMessage){
		try{
			String errorMessage;
			if(driver.findElement(By.xpath("//div[contains(@id,'page-level-error-content')]")).isDisplayed()){
				if(!strErrorMessage.isEmpty()){

				}else{
					errorMessage=getText(pdp_errorMesage);
					testStepPassed("Verified error message displayed as : '"+errorMessage+"'");
				}
			}
		}catch(Exception e){
			testStepFailed("There is no error message displayed");
		}
	}

	public boolean verifyUserInProductDescriptionPage(){
		boolean flag=false;
		try{
			if(driver.findElement(By.xpath("//div[contains(@class,'product-details')]")).isDisplayed()){
				testStepPassed("Verified user is in product description page");
				flag= true;
			}
		}catch(Exception e){
			testStepFailed("User is not in product description page");
		}
		return flag;
	}

	public void waitForMiniCartToAppearAndDissapear(){
		try{
			WebDriverWait wait=new WebDriverWait(driver,implicitlyWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartDropdown')]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'cartDropdown')]")));
		}catch(Exception e){

		}
	}
}
