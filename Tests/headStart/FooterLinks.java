package headStart;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.WordUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FooterLinks extends CommonUtilities{
	String currentWindow;

	public static final String lnk_Footer_ClearanceCenter = "Footer - Clearance Center Link #xpath=//div[@id='footer']//a[contains(text(),'Clearance Center')]";
	public static final String lnk_Footer_CurrentPromotions = "Footer - Current Promotions Link #xpath=//div[@id='footer']//a[contains(text(),'Current Promotions')]";
	public static final String lnk_Footer_DealsOfTheDay = "Footer - Deals of the Day Link #xpath=//div[@id='footer']//a[contains(text(),'Deals of the Day')]";
	public static final String lnk_Footer_GiftCards = "Footer - Gift Cards Link #xpath=//div[@id='footer']//a[contains(text(),'Gift Cards')]";
	public static final String lnk_Footer_FactoryStore = "Footer - Factory Store Link #xpath=//div[@id='footer']//a[contains(text(),'Factory Store')]";
	public static final String lnk_Footer_CustomerServiceCenter = "Footer - Customer Service Center Link #xpath=//div[@id='footer']//a[contains(text(),'Customer Service Center')]";
	public static final String lnk_Footer_InternationalShipping = "Footer - International Shipping Link #xpath=//div[@id='footer']//a[contains(text(),'International Shipping')]";
	public static final String lnk_Footer_PrivacyPolicy = "Footer - Privacy Policy Link #xpath=//div[@id='footer']//a[contains(text(),'Privacy Policy')]";
	public static final String lnk_Footer_SiteMap = "Footer - Site Map Link #xpath=//div[@id='footer']//a[contains(text(),'Site Map')]";
	public static final String lnk_Footer_ContactUs = "Footer - Contact Us Link #xpath=//div[@id='footer']//a[contains(text(),'Contact Us')]";
	public static final String lnk_Footer_CompanyInformation = "Footer - Company Information Link #xpath=//div[@id='footer']//a[contains(text(),'Company Information')]";
	public static final String lnk_Footer_Jobs = "Footer - Jobs Link #xpath=//div[@id='footer']//a[contains(text(),'Jobs')]";
	public static final String lnk_Footer_StoreLocator = "Footer - Store Locator Link #xpath=//div[@id='footer']//a[contains(text(),'Store Locator')]";
	public static final String lnk_Footer_OrderStatus = "Footer - Order Status Link #xpath=//div[@id='footer']//a[contains(text(),'Order Status')]";
	public static final String lnk_Footer_JoinEmailList = "Footer - Join Email List Link #xpath=//div[@id='footer']//a[contains(text(),'Join Email List')]";	
	public static final String lnk_Footer_JoinUsOnFacebook = "Footer - Join us on Facebook Link #xpath=//a[@id='footerFacebookLink']";
	public static final String lnk_Footer_FollowUsOnTwitter = "Footer - Follow us on Twitter Link #xpath=//a[@id='footerTwitterLink']";
	public static final String lnk_Footer_FollowUsOnInstagram = "Footer - Follow us on Instagram Link #xpath=//a[@id='footerInstagramLink']";
	public static final String lnk_Footer_CircleUsOnGoogle = "Footer - 	Circle us on Google+ Link #xpath=//a[@id='footerGooglePlusLink']";
	public static final String lnk_Footer_WatchUsOnYoutube = "Footer - 	Watch us on Youtube Link #xpath=//a[@id='footerYouTubeLink']";
	public static final String lnk_Footer_FollowUsOnPinterest = "Footer - Follow us on Pinterest Link #xpath=//a[@id='footerPinterestLink']";
	public static final String lnk_Footer_ReadOurExpertAdvice = "Footer - Read Our Expert Advice Link #xpath=//a[@id='footerReadAdviceLink']";


	public void clickOnFooterLink(String linkName){	
		if(linkName.equalsIgnoreCase("Join Email List")||linkName.equalsIgnoreCase("jobs"))
		{
			clickOnSpecialElement(linkName+" footer link#xpath=//div[@id='footer']//a[contains(text(),'"+linkName+"')]");
		}
		else
		{
		clickOn(linkName+" footer link#xpath=//div[@id='footer']//a[contains(text(),'"+linkName+"')]");
		}
	}

	public void clickOnFooterSocialLink(String socialLinkName){
		switch (socialLinkName){
		case "Facebook":
			//clickOn(lnk_Footer_JoinUsOnFacebook);
			driver.findElement(By.xpath("//a[@id='footerFacebookLink']")).click();
			break;
		case "Twitter":
			clickOn(lnk_Footer_FollowUsOnTwitter);
			break;
		case "Instagram":
			clickOn(lnk_Footer_FollowUsOnInstagram);
			break;
		case "Google+":
			clickOn(lnk_Footer_CircleUsOnGoogle);
			break;
		case "Youtube":
			clickOn(lnk_Footer_WatchUsOnYoutube);
			break;
		case "Pinterest":
			clickOn(lnk_Footer_FollowUsOnPinterest);
			break;
		default:

		}

	}

	public List<String> getFooterSocialLinksList(){

		List<WebElement> footerSocialLinksElement=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span"));

		List<String> footerSocialLinksList = new ArrayList<String>();

		for(int i=0;i<footerSocialLinksList.size();i++){
			footerSocialLinksList.add(WordUtils.capitalizeFully(footerSocialLinksElement.get(i).getText().trim()));
		}

		return footerSocialLinksList;
	}		

	public void verifyLinkNavigatedPage(String footerLinkName){
		waitTime(10);
		Boolean Flag=false;


		if((footerLinkName.equalsIgnoreCase("clearance center"))||(footerLinkName.equalsIgnoreCase("deals of the day"))||(footerLinkName.equalsIgnoreCase("factory store"))||(footerLinkName.equalsIgnoreCase("gift cards"))){

			if(driver.findElement(By.xpath("//*[contains(@id,'widget_breadcrumb')]//*[contains(text(),'Home')]")).isDisplayed()){
				String currentBreadCrumb = driver.findElement(By.xpath("//nav[contains(@id,'widget_breadcrumb')]//li//h1")).getText().trim();

				if(footerLinkName.equalsIgnoreCase("deals of the day")||footerLinkName.contains("Deal of the Day")){
					if(currentBreadCrumb.equalsIgnoreCase("deal of the day")||currentBreadCrumb.contains("Deal of the Day"))	
						Flag = true;
				}else if(footerLinkName.equalsIgnoreCase(currentBreadCrumb))
					Flag = true;
			}

		}else if((footerLinkName.equalsIgnoreCase("Current Promotions"))){

			String currentBreadCrumb = driver.findElement(By.xpath("//nav[contains(@id,'widget_breadcrumb')]/following-sibling::*//div[contains(@class,'subCat_heading')]/h1")).getText().trim();
			if(currentBreadCrumb.toLowerCase().contains(footerLinkName.toLowerCase()))
				Flag = true;

		}else if((footerLinkName.equalsIgnoreCase("customer service center"))||(footerLinkName.equalsIgnoreCase("privacy policy"))){

			if(driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'intbreadCrumbs')]//a[contains(text(),'Home')]")).isDisplayed()){
				String currentBreadCrumb = driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'intbreadCrumbs')]//li[2][contains(text(),'')]")).getText().trim();
				if(footerLinkName.equalsIgnoreCase(currentBreadCrumb))
					Flag = true;
			}

		}else if(footerLinkName.equalsIgnoreCase("site map")){

			if(driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'breadcrumb')]//a[contains(text(),'Home')]")).isDisplayed()){
				String currentBreadCrumb = driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'breadcrumb')]//span[contains(@class,'current')]")).getText().trim();
				if(footerLinkName.equalsIgnoreCase(currentBreadCrumb))
					Flag = true;
			}

		}else if(footerLinkName.equalsIgnoreCase("Contact Us")){

			if(driver.findElement(By.xpath("//div[contains(@id,'contentWrapper')]//div[contains(@class,'breadcrumb')]/a[contains(text(),'Home')]")).isDisplayed()){
				String currentBreadCrumb = driver.findElement(By.xpath("//div[contains(@id,'contentWrapper')]//div[contains(@class,'breadcrumb')]/h1")).getText().trim();
				if(footerLinkName.equalsIgnoreCase(currentBreadCrumb))
					Flag = true;
			}

		}else if(footerLinkName.equalsIgnoreCase("company information")){

			if(driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'intbreadCrumbs')]//a[contains(text(),'Home')]")).isDisplayed()){
				String currentBreadCrumb = driver.findElement(By.xpath("//div[contains(@id,'main')]//div[contains(@class,'intbreadCrumbs')]//li[2]")).getText().trim();
				if(footerLinkName.equalsIgnoreCase(currentBreadCrumb))
					Flag = true;
			}

		}else if(footerLinkName.equalsIgnoreCase("International Shipping")){	

			if(driver.getTitle().contains("International Shipping"))
				Flag = true;

		}else if(footerLinkName.equalsIgnoreCase("Read Our Expert Advice")){	

			if(driver.getTitle().contains("Expert Advice"))
				Flag = true;

		}else if(footerLinkName.equalsIgnoreCase("jobs")){
			if(driver.getTitle().contains("Retail Jobs and Corporate Jobs")||switchToSpecificWindow("Careers | JoS. A. Bank")) {  	
				
				
				if(driver.getCurrentUrl().toLowerCase().contains("careers")||driver.getCurrentUrl().toLowerCase().contains("jobs")){
					Flag = true;
					clickOnBackButton();
					getBackToOriginalWindow();
					
				}
		}
		}

		if(Flag)
			testStepPassed(footerLinkName +" navigated to its corresponding page");
		else
			testStepFailed(footerLinkName +" is not navigated to its corresponding page");
	}

	public void verifySocialLinkNavigatedPage(String footerSocialLinkName){
		waitTime(10);
		Boolean Flag=false;

		if(footerSocialLinkName.equalsIgnoreCase("Facebook"))
			switchToWindow("Jos. A. Bank Clothiers, Inc.");	

		else if(footerSocialLinkName.equalsIgnoreCase("Google+"))
			switchToWindow("Jos. A. Bank - Google+");

		else if(footerSocialLinkName.equalsIgnoreCase("Twitter"))
			switchToWindow("Jos A Bank (@JosABank) | Twitter");

		else if(footerSocialLinkName.equalsIgnoreCase("Instagram"))
			switchToWindow("Jos. A. Bank (@josabank) • Instagram photos and videos");

		else if(footerSocialLinkName.equalsIgnoreCase("Pinterest"))	
			switchToWindow("Jos. A. Bank on Pinterest");

		else if(footerSocialLinkName.equalsIgnoreCase("Youtube"))
			switchToWindow("Jos. A. Bank - YouTube");
		
		if(!footerSocialLinkName.equals("Google+")){
		
			String url = driver.getCurrentUrl();
			if( (url.contains("Jos.A.Bank")) || (url.toLowerCase().contains("josabank")) && (url.toLowerCase().contains(footerSocialLinkName.toLowerCase())) )
				Flag = true;

		}else{

			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Jos. A. Bank - Google+"))
				Flag = true;

		}

		if(Flag)
			testStepPassed(footerSocialLinkName +" navigated to its corresponding page");
		else
			testStepFailed(footerSocialLinkName +" is not navigated to its corresponding page");

		switchToWindow("Shop Menswear from the Expert in Men’s Apparel | Jos. A. Bank");

	}
	public void getBackToOriginalWindow(){
		driver.switchTo().window(currentWindow);
	}

}


