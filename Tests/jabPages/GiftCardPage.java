package jabPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GiftCardPage extends CategoryNavigation{

	public static final String drp_giftCardType="Gift card selection dropdown#xpath=//select[contains(@name,'giftCardType')]";
	public static final String txt_gift_To=" To textbox#xpath=//div[contains(@id,'divGiftCard')]//input[contains(@name,'recipientName')]";
	public static final String txt_gift_From=" From textbox#xpath=//div[contains(@id,'divGiftCard')]//input[contains(@name,'senderName')]";
	public static final String txt_gift_message=" message textbox#xpath=//div[contains(@id,'divGiftCard')]//input[contains(@name,'giftMessage')]";
	/*public static final String txt_gift_receiptEmail="Receipt email textbox#xpath=//input[contains(@name,'recipientEmail')]";
	public static final String txt_gift_VerifyEmail=" To textbox#xpath=//input[contains(@name,'verifyrecipientEmail')]";
	 */public static final String btn_gift_addToCart="Add to cart#xpath=//div[contains(@id,'divGiftCard')]//span[contains(text(),'Add to Cart')]/parent::button";
	 public static final String drp_gift_price="price selection dropdown#xpath=//div[contains(@id,'divGiftCard')]//select[contains(@name,'priceAttrValueSelect') or contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect')]";


	 public static final String txt_egift_To=" To textbox#xpath=//div[contains(@id,'divECard')]//input[contains(@name,'recipientName')]";
	 public static final String txt_egift_From=" From textbox#xpath=//div[contains(@id,'divECard')]//input[contains(@name,'senderName')]";
	 public static final String txt_egift_message=" message textbox#xpath=//div[contains(@id,'divECard')]//input[contains(@name,'giftMessage')]";
	 public static final String txt_egift_receiptEmail="Receipt email textbox#xpath=//div[contains(@id,'divECard')]//input[contains(@name,'recipientEmail')]";
	 public static final String txt_egift_VerifyEmail=" To textbox#xpath=//div[contains(@id,'divECard')]//input[contains(@name,'verifyrecipientEmail')]";
	 public static final String btn_egift_addToCart="Add to cart#xpath=//div[contains(@id,'divECard')]//span[contains(text(),'Add to Cart')]/parent::button";
	 public static final String drp_egift_price="price selection dropdown#xpath=//div[contains(@id,'divECard')]//select[contains(@name,'priceAttrValueSelect') or contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect')]";

	 public void selectGiftCardType(String cardType){
		 selectFromDropdown(drp_giftCardType, cardType);
	 }

	 public void selectGiftCardPrice(String price){
		 //selectFromDropdown(drp_price, price);
		 List<WebElement> select=driver.findElements(By.xpath("//select[contains(@name,'priceAttrValueSelect') or contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect')]"));
		 if(select.size()>0){
			 for(int i=0;i<select.size();i++){
				 if(select.get(i).isDisplayed()){
					 new Select(select.get(i)).selectByValue(price);
					 testStepPassed("Select '"+price+"' from proce selection drop down");
					 break;
				 }
			 }
		 }

	 }

	 public void selectPhysicalGiftCardPrice(String price){
		 waitTime(3);
		 if(!price.isEmpty()){
			 selectFromDropdown("physical gift card prce drop down#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divGiftCard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]", price.trim());
		 }else{
			 price=getText("Physical gift card price first option#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divGiftCard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]/option[2]").trim();
			 selectFromDropdown("physical gift card prce drop down#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divGiftCard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]", price);
		 }
	 }

	 public void selectEGiftCardPrice(String price){
		 waitTime(3);
		 if(!price.isEmpty()){
			 selectFromDropdown("physical gift card prce drop down#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divECard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]", price.trim());
		 }else{
			 price=getText("Physical gift card price first option#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divECard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]/option[2]").trim();
			 selectFromDropdown("physical gift card prce drop down#xpath=//form[contains(@id,'giftCardForm')]//div[contains(@id,'divECard')]//select[contains(@id,'priceAttrValueSelect') or contains(@class,'definingAttrSelect') or contains(@name,'priceAttrValueSelect')]", price);
		 }
	 }

	 /*public void fillGiftCardDetails(String strTo, String strFrom, String giftMessage, String receiptEmail, String verifyEmail){
		typeIn(txt_To, strTo);
		typeIn(txt_From, strFrom);
		if(!giftMessage.isEmpty() || giftMessage!=null)	typeIn(txt_message, giftMessage);
		if(!receiptEmail.isEmpty() || receiptEmail!=null) typeIn(txt_receiptEmail, receiptEmail);
		if(!verifyEmail.isEmpty() || verifyEmail!=null)	typeIn(txt_VerifyEmail, verifyEmail);
	}*/


	 public void clickOnAddToCartForPhysicalGiftCardPage(){
		 clickOn(btn_gift_addToCart);
	 }

	 public void clickOnAddToCartForEGiftCardPage(){
		 clickOn(btn_egift_addToCart);
	 }

	 public void fillGiftCardDetailsDisplayed(String strTo, String strFrom, String giftMessage, String receiptEmail, String verifyEmail){
		 //typeIn(txt_To, strTo);
		 List<WebElement>toText=driver.findElements(By.xpath("//input[contains(@name,'recipientName')]"));
		 for(int i=0; i<toText.size();i++){
			 if(toText.get(i).isDisplayed()){
				 toText.get(i).clear();
				 toText.get(i).sendKeys(strTo);
				 testStepPassed("Type '"+strTo+"' in To text box");
				 break;
			 }
		 }
		 //typeIn(txt_From, strFrom);
		 List<WebElement>fromText=driver.findElements(By.xpath("//input[contains(@name,'senderName')]"));
		 for(int i=0; i<fromText.size();i++){
			 if(toText.get(i).isDisplayed()){
				 fromText.get(i).clear();
				 fromText.get(i).sendKeys(strFrom);
				 testStepPassed("Type '"+strFrom+"' in From text box");
				 break;
			 }
		 }
		 if(!giftMessage.isEmpty() || giftMessage!=null){
			 //typeIn(txt_message, giftMessage);
			 List<WebElement>messageText=driver.findElements(By.xpath("//input[contains(@name,'giftMessage')]"));
			 for(int i=0; i<messageText.size();i++){
				 if(toText.get(i).isDisplayed()){
					 messageText.get(i).clear();
					 messageText.get(i).sendKeys(giftMessage);
					 testStepPassed("Type '"+giftMessage+"' in message text box");
					 break;
				 }
			 }
		 }
		 if(!receiptEmail.isEmpty() || receiptEmail!=null){
			 //typeIn(txt_receiptEmail, receiptEmail);
			 List<WebElement>rptEmail=driver.findElements(By.xpath("//input[contains(@name,'recipientEmail')]"));
			 for(int i=0; i<rptEmail.size();i++){
				 if(toText.get(i).isDisplayed()){
					 rptEmail.get(i).clear();
					 rptEmail.get(i).sendKeys(receiptEmail);
					 testStepPassed("Type '"+receiptEmail+"' in email text box");
					 break;
				 }
			 }
		 }
		 if(!verifyEmail.isEmpty() || verifyEmail!=null){
			 //typeIn(txt_VerifyEmail, verifyEmail);
			 List<WebElement>vrptEmail=driver.findElements(By.xpath("//input[contains(@name,'verifyrecipientEmail')]"));
			 for(int i=0; i<vrptEmail.size();i++){
				 if(toText.get(i).isDisplayed()){
					 vrptEmail.get(i).clear();
					 vrptEmail.get(i).sendKeys(verifyEmail);
					 testStepPassed("Type '"+verifyEmail+"' in verify email text box");
					 break;
				 }
			 }
		 }
	 }


	 public void fillPhysicalGiftCardDetails(String strTo, String strFrom, String giftMessage){
		 typeIn(txt_gift_To, strTo);
		 typeIn(txt_gift_From, strFrom);
		 if(!giftMessage.isEmpty() || giftMessage!=null)	typeIn(txt_gift_message, giftMessage);
		 /*if(!receiptEmail.isEmpty() || receiptEmail!=null) typeIn(txt_gift_receiptEmail, receiptEmail);
		if(!verifyEmail.isEmpty() || verifyEmail!=null)	typeIn(txt_gift_VerifyEmail, verifyEmail);*/
	 }

	 public void filleGiftCardDetails(String strTo, String strFrom, String giftMessage, String receiptEmail, String verifyEmail){
		 typeIn(txt_egift_To, strTo);
		 typeIn(txt_egift_From, strFrom);
		 if(!giftMessage.isEmpty() || giftMessage!=null)	typeIn(txt_egift_message, giftMessage);
		 if(!receiptEmail.isEmpty() || receiptEmail!=null) typeIn(txt_egift_receiptEmail, receiptEmail);
		 if(!verifyEmail.isEmpty() || verifyEmail!=null)	typeIn(txt_egift_VerifyEmail, verifyEmail);
	 }
}
