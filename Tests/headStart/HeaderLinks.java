package headStart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderLinks extends FooterLinks{

	public static final String img_HeaderLogo = "Header JAB Logo#xpath=//*[contains(@id,'contentRecommendationWidget_HeaderStoreLogo_Content')]//img";
	public static final String txt_searchbox="search textbox#xpath=//input[contains(@name,'searchTerm')]";
	public static final String btn_go=" Go button#xpath=//span[contains(text(),'Go')]/parent::a";
	public static final String lnk_my_account="My Account header link#xpath=//div[@id='header']//a[contains(text(),'My Account')]";
	public static final String lnk_my_cart="My cart link#xpath=//span[contains(text(),'My Cart:') or contains(text(),'CHECKOUT')]";
	public static final String lnk_signOut="sign out link#xpath=//a[contains(@id,'signOutQuickLink') or contains(text(),'Sign Out')]";
	public static final String lnk_siginIn="sign in link#xpath=//a[@id='signInQuickLink']";

	public static final String lnk_Header_StoreLocator = "Header Link - Store Locator#xpath=//a[contains(@id,'storeLocatorQuickLink')]"; 
	public static final String lnk_Header_OrderStatus = "Header Link - OrderStatus#xpath=//*[@id='quickLinksBar']//a[contains(text(),'Order Status')]";
	//public static final String lnk_Header_MyAccount = "Header Link - My Account#xpath=//a[@id='myAccountQuickLink']";
	public static final String lnk_Header_MyAccount = "Header Link - My Account#xpath=//*[@id='quickLinksBar']//*[contains(text(),'My Account')]";
	public static final String popup_JoinEmailList = "Join Email List Pop-up#xpath=//div[@id='modalJoinEmail']/div[contains(@class,'modal-wrapper modal-join-email')]";
	public static final String popup_JoinEmailList_Close ="Join Email List Pop-up - Close Button #xpath=//a[contains(text(),'Join email list dialog close')]";
	public static final String lnk_Header_JoinEmailList = "Header Link - Join Email List#xpath=//*[@id='joinEmailQuickLink']";
	public static final String lnk_Header_ChangeRegion = "Header Link - Change Region#xpath=//img[@id='header-international-img']";
	public static final String popup_ChangeRegion = "Join Email List Pop-up#xpath=//div[@id='modalLanguageCurrency']/div[contains(@class,'modal-wrapper modal-language-currency')]";
	public static final String popup_ChangeRegion_Close ="Join Email List Pop-up - Close Button#xpath=//div[@id='modalLanguageCurrency']//button[contains(text(),'International shipping dialog close')]";
	public static final String btn_SignIn="Sign in button#xpath=//span[contains(text(),'Sign In')]/parent::button";
	public static final String img_Header_CountryFlag = "Header Link - Country Flag#xpath=//*[@id='header-international-label']";
	public static final String lnk_Header_MyCart = "Header Link - My Cart#xpath=//*[@id='MiniShoppingCart']//span[contains(text(),'My Cart')]";
	public static final String ele_MyCartWindow = "Shopping Cart Page Window#xpath=//div[@id='ShopCartDisplay']";	
	
	
	
	public void searchProduct(String productName){
		typeIn(txt_searchbox, productName);
		clickOn(btn_go);
	}
	
	
	public void clickOnMyAccountHeaderLink(){
		clickOn(lnk_my_account);
		//waitForText("My Account Information");
	}
	
	public void clickOnMycart(){
		clickOn(lnk_my_cart);
		//waitForText("Cart Details:");
	}
	
	public void clickOnSignOutLink(){
		clickOn(lnk_signOut);
		waitTime(5);
		//waitForText("Sign in to your Account");
	}

	public void clickOnSignInLink(){
		clickOn(lnk_siginIn);
		waitForText("Sign in to your Account");
	}
	
	public void verifyNavigatedPage(String pageName){
		try{
			waitForElement("#xpath=//div[@id='content']//div[contains(@class,'breadcrumb')]/a[contains(text(),'Home')]");
			List<String> breadCrumbText=new ArrayList<String>();

			List<WebElement> sublink=driver.findElements(By.xpath("//div[@id='content']//div[contains(@class,'breadcrumb')]/span"));

			for(WebElement ele:sublink){
				breadCrumbText.add(ele.getText().trim());
			}

			if(pageName=="My Account"){
				String myAccountPage= "My Account Information";
				if(myAccountPage.equalsIgnoreCase(breadCrumbText.get(breadCrumbText.size()-1))){
					testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
				}else{
					testStepFailed(pageName+" Link Successfully is not Navigated to its corresponding page");
				}
			}
			else{
				if(pageName.equalsIgnoreCase(breadCrumbText.get(breadCrumbText.size()-1))){
					testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
				}else{
					testStepFailed(pageName+" Link Successfully is not Navigated to its corresponding page");
				}	
			}
		}catch(Exception e){
			testStepFailed(e.toString());
		}
	}


	public void clickOnJoinEmailListLink(){
		clickOn(lnk_Header_JoinEmailList);
	}
	public void verifyJoinEmailListLink(){
		try{
			WebDriverWait wait=new WebDriverWait(driver,implicitlyWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalJoinEmail']/div[contains(@class,'modal-wrapper modal-join-email')]")));
			}catch(Exception e){
				
			}
		if(isElementDisplayed(popup_JoinEmailList)){
			testStepPassed("Join Email List Pop-up is Displayed");
			clickOn(popup_JoinEmailList_Close);
		}else{
			testStepFailed("Join Email List Pop-up is not Displayed");
		}
	}

	public void verifySearchResult(String productName){
		try{
			waitForElement("#xpath=//div[contains(@id,'searchBasedNavigation_widget')]//div[contains(@class,'product_info')]//div[contains(@id,'product_name')]//a[contains(text(),'')]");
			String searchResultProductName = driver.findElement(By.xpath("//div[contains(@id,'searchBasedNavigation_widget')]//li[1]//div[contains(@class,'product_info')]//div[contains(@id,'product_name')]//a[contains(text(),'')]")).getText();
			if (searchResultProductName.toLowerCase().contains(productName.toLowerCase())){
				testStepPassed("Searched Results are displayed");			
			}else{
				testStepFailed("Searched Results are not displayed");
			}
		}catch(Exception e){
			testStepFailed("verifysearchResult() fails: "+e.toString());
		}
	}

	public void clickOnChangeRegionLink(){
		clickOn(lnk_Header_ChangeRegion);
	}
	public void clickOnFlag(){
		clickOn(img_Header_CountryFlag);
	}

	public void verifyChangeRegionPopup(){
		if(isElementDisplayed(popup_ChangeRegion)){
			testStepPassed("Change Region Pop-up is Displayed");	
			clickOn(popup_ChangeRegion_Close);
		}else{
			testStepFailed("Change Region Pop-up is Not Displayed");	
		}
	}


	/** Click And Verify My Cart Link */ 
	public void clickOnMyCartLink(){
		clickOn(lnk_Header_MyCart);
	}

	public void verifyMyCartLink(){
		if(isElementDisplayed(ele_MyCartWindow)){
			testStepPassed("Shopping Cart Page is Displayed");
		}else{
			testStepFailed("Shopping Cart Page is not Displayed");	
		}
	}
	
	public void clickJabLogo(){
		if(isElementDisplayed(img_HeaderLogo)){
			clickOn(img_HeaderLogo);
		}
		else{
			testStepFailed("Header Logo not displayed");
		}
	}
	
	public void clickHeaderLink(String pageName){

		if(pageName.equalsIgnoreCase("Store Locator")){
			clickOn(lnk_Header_StoreLocator);
		}
		else if(pageName.equalsIgnoreCase("Order Status")){
			clickOn(lnk_Header_OrderStatus);
		}
		else if(pageName.equalsIgnoreCase("My Account")){
			clickOn(lnk_Header_MyAccount);
		}

	}
	
	public void verifySignInPage(){
		//if(isElementDisplayed(btn_SignIn)){
		if(driver.getTitle().equalsIgnoreCase("Sign In")){
			testStepPassed("SignIn Page is Displayed");
		}else{
			testStepFailed("SignIn Page is not Displayed");	
		}
		
		
		
	}
}
