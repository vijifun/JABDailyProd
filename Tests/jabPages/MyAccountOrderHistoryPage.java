package jabPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountOrderHistoryPage extends MyAccountOrderDetailPage{

	
	public void clickOnViewOrderInOrderHistoryPage(String orderNumber){
		clickOn("view order link of order number '"+orderNumber+"'#xpath=//p[contains(text(),'"+orderNumber+"')]/parent::div/preceding-sibling::div[@class='order-item-head']//a[contains(text(),'View Order')]");
		waitForText("Order Details");
	}
	
	public void verifyOrderNumberDispayedOnOrderHistory(String orderNumber){
		List<WebElement> orderlist=driver.findElements(By.xpath("//div[contains(@class,'order-item-entry')]/p"));
		if(orderlist.size()>0){
			for(int i=0;i<orderlist.size();i++){
				if(orderlist.get(i).getText().trim().split(":")[1].trim().equalsIgnoreCase(orderNumber)){
					testStepPassed("Verified order number "+orderNumber+" is listed in order History page");
					break;
				}
				if(i==orderlist.size()-1){
					testStepFailed("'"+orderNumber+" order number is NOT listed in order History page");
				}
			}
		}
	}
}
