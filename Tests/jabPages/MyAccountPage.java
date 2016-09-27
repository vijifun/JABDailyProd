package jabPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends MyAccountOrderHistoryPage{

	public static final String[] navigationLinks={"Order History","My Account Information","Bank Account™ Rewards","Address Book","Billing Information","Wish List","Size Selector"};

	public void verifyMyAccountLeftNavigationLinks(){
		try{
			List<WebElement> naviLinks=driver.findElements(By.xpath("//div[@class='account-navigation']//li/a"));
			if(naviLinks.size()>0){
				for(int i=0;i<naviLinks.size();i++){
					if(naviLinks.get(i).getText().trim().equalsIgnoreCase(navigationLinks[i])){
						testStepPassed("Verified '"+navigationLinks[i]+"' link available in My account left navigation menu");
					}else{
						testStepFailed("'"+navigationLinks[i]+"' link is NOT available in My account left navigation menu");
					}
				}

			}
		}catch(Exception e){
			testStepFailed("Exception occured: "+e);
		}
	}
	
	/**click On Left Navigation from MyAccountPage
	 * @param navLink [Order History,My Account Information,Bank Account™ Rewards,Address Book,Billing Information,Wish List,Size Selector]
	 */
	public void clickOnLeftNavigationMyAccountPage(String navLink){
		clickOn("'"+navLink+"' left navigation link#xpath=//div[@class='account-navigation']//li//*[contains(text(),'"+navLink+"')]");
		//waitForText("My Order History");
	}
}
