package jabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentInformationPage extends OrderConfirmationPage{

	public static final String rdo_btn_creditcard="Credeit radio button#xpath=//input[contains(@name,'paymentMethodRadio') and @value='creditCard']";
	public static final String rdo_btn_paypal="paypal radio button#xpath=//input[contains(@name,'paymentMethodRadio') and @value='payPal']";
	public static final String drp_creditType="credit card type#xpath=//select[contains(@id,'payMethodId')]";
	public static final String txt_card_number="card number textbox#xpath=//input[contains(@name,'account')]";
	public static final String txt_expiry_month="expiry month textbox#xpath=//input[contains(@name,'expire_month')]";
	public static final String txt_expiry_year="expiry year textbox#xpath=//input[contains(@name,'expire_year')]";
	public static final String txt_cvv="cvv textbox#xpath=//input[contains(@name,'cc_cvc')]";
	public static final String btn_placeOrder="Place order button#xpath=//span[contains(text(),'Apply Payment / Place Order')]/parent::a";
	public static final String lnk_back_to_cart="back to cart link#xpath=//div[contains(@class,'back-cart')]/a";
	
	public static final String txt_gift_card_number="Gift card number textbox#xpath=//input[contains(@name,'giftCardNumber')]";
	public static final String txt_PIN="PIN number textbox#xpath=//input[contains(@name,'giftCardPin')]";
	public static final String btn_applyGiftCard="Apply Gift Card button#xpath=//span[contains(text(),'Apply Gift Card')]";

	private String strCardNumber;
	private String strCardExpiryMonth;
	private String strCardExpiryYear;
	private String strCardCvv;
	private String strCardType;
	private int cardIndex;

	private String strGiftCardNumber;
	private String strPIN;


	public void chooseCreditCardOption(){
		clickOn(rdo_btn_creditcard);
	}

	public void fillCreditCardDetails(String cardType, String cardNumber,String expireMonth,String expireyear,String cvv){
		setCardTypeSelectionValue(cardType);
		if(cardNumber.isEmpty()||expireMonth.isEmpty()||expireyear.isEmpty()||cvv.isEmpty()){
			setPaymentData(cardType);
		}else{
			strCardNumber=cardNumber;
			strCardExpiryMonth=expireMonth;
			strCardExpiryYear=expireyear;
			strCardCvv=cvv;
		}

		//selectFromDropdown(drp_creditType, strCardType);
		try{
			WebElement element1  =driver.findElement(By.xpath("//select[@id='payMethodId_1']"));
			Select Value=new Select(element1 );
			Value.selectByIndex(cardIndex);
			testStepPassed("Select '"+strCardType+"' from : credit card type selection drop down");
		}catch(Exception e){
			testStepFailed("Unable to select "+strCardType+" value from credit card type drop down");
		}
		typeIn(txt_card_number, strCardNumber);
		typeIn(txt_expiry_month, strCardExpiryMonth);
		typeIn(txt_expiry_year, strCardExpiryYear);
		typeIn(txt_cvv, strCardCvv);
	}

	public boolean clickOnPlaceOrder(){
		if(orderPlacementFlag==true){
			clickOn(btn_placeOrder);
			return true;
		}else{
			testStepPassed("Order is not placed due to execution is happening in production or test environment");
			return false;
		}

	}

	public void setCardTypeSelectionValue(String cardType){
		switch (cardType.toLowerCase()) {
		case "Master Card Credit Card":
			strCardType="Master Card Credit Card";
			cardIndex=3;
			break;

		case "Discover":
			strCardType="Discover ";
			cardIndex=5;
			break;

		case "Diners Club":
			strCardType="Diners Club ";
			cardIndex=2;
			break;

		case "American Express Credit Card One":
			strCardType="American Express Credit Card ";
			cardIndex=4;
			break;

		case "American Express Credit Card Two":
			strCardType="American Express Credit Card ";
			cardIndex=4;
			break;

		case "VISA Credit Card":
			strCardType="VISA Credit Card ";
			cardIndex=1;
			break;

		default:
			strCardType="Master Card Credit Card ";
			cardIndex=3;
			break;
		}
	}

	public void setPaymentData(String cardType){
		setCardTypeSelectionValue(cardType);
		switch (cardType.toLowerCase().trim()) {
		case "master card credit card":
			strCardNumber=getConfigProperty("Master Card Credit Card");
			cardType="Master Card Credit Card ";
			break;

		case "discover":
			strCardNumber=getConfigProperty("Discover");
			break;

		case "diners club":
			strCardNumber=getConfigProperty("Diners Club");
			break;

		case "american express credit card one":
			strCardNumber=getConfigProperty("American Express Credit Card One");
			break;

		case "american express credit card two":
			strCardNumber=getConfigProperty("American Express Credit Card Two");
			break;

		case "visa credit card":
			strCardNumber=getConfigProperty("VISA Credit Card");
			break;

		default:
			strCardNumber=getConfigProperty("Master Card Credit Card");
			break;
		}
		strCardExpiryMonth=getConfigProperty("CardExpiryMonth");
		strCardExpiryYear=getConfigProperty("CardExpiryYear");
		strCardCvv=getConfigProperty("CardCVV");

	}

	public void setGiftCardDetails(){
		strGiftCardNumber=getConfigProperty("Gift Card Number");
		strPIN=getConfigProperty("Gift Card PIN");
	}

	public void fillGiftCardDetails(String giftCardNumber, String PIN){

		if(giftCardNumber.isEmpty()||PIN.isEmpty()){
			setGiftCardDetails();
		}else{
			strGiftCardNumber=giftCardNumber;
			strPIN=PIN;
		}
		typeIn(txt_gift_card_number, strGiftCardNumber);
		typeIn(txt_PIN, strPIN);
	}

	public void clickOnApplyGiftCard(){
		clickOn(btn_applyGiftCard);
	}
	
	public void clickOnBackTocartFromPaymentInfoPage(){
		clickOn(lnk_back_to_cart);
	}
}
