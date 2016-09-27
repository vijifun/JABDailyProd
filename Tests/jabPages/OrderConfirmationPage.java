package jabPages;


public class OrderConfirmationPage extends MyCartPage{

	public static final String ele_order_number="Order Number#xpath=//span[contains(text(),'Order Number:')]/following-sibling::span";

	public String getOrderNumber(){
		String orderNumber=""; 

		try{
			orderNumber=getText(ele_order_number);
			//orderNumber=driver.findElement(By.xpath("//span[contains(text(),'Order Number:')]/following-sibling::span")).getText();
			testStepPassed("Order confirmation number :"+orderNumber);
		}catch(Exception e){
			testStepFailed("Order is not placed");
		}
		return orderNumber; 
	}

}
