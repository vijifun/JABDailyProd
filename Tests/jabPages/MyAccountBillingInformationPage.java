package jabPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountBillingInformationPage extends MyAccountAddressBookPage{

	public static final String lnk_newCard="new card link#xpath=//div[@class='address-book-info']//a[contains(text(),'New Card')]";
	public static final String drp_newCard_billing_card_type="cart type dropdown#xpath=//form[@id='addAddressForm']//select[contains(@name,'cc_brand')]";
	public static final String txt_newCard_billing_card_number="cart number textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'cardNumber')]";
	public static final String txt_newCard_billing_expiry_month="expiry month textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'cc_exp_month')]";
	public static final String txt_newCard_billing_expiry_year="expiry year textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'cc_exp_year')]";
	public static final String txt_newCard_billing_firstName="first name textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'firstName')]";
	public static final String txt_newCard_billing_lastName="last name textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'lastName')]";
	public static final String txt_newCard_billing_addressOne="address one textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address1')]";
	public static final String txt_newCard_billing_addressTwo="address two textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address2')]";
	public static final String txt_newCard_billing_addressThree="address three textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address3')]";
	public static final String txt_newCard_billing_city="city textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'city')]";
	public static final String txt_newCard_billing_state="state textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'state')]";
	public static final String txt_newCard_billing_zipcode="zipcode textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'zipCode')]";
	public static final String txt_newCard_billing_phone1="day phone textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'phone1')]";
	public static final String txt_newCard_billing_phone2="evening phone textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'phone2')]";
	public static final String txt_newCard_billing_email1="email textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'email1')]";
	public static final String txt_newCard_billing_email2="confirm email textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'confirmemail1')]";

	public static final String chk_default_payment="default payment checkbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'defaultPayment')]";
	public static final String btn_newcard_billing_save="new billing popup save button#xpath=//form[@id='addAddressForm']//span[contains(text(),'Save')]/parent::button";

	public static final String lnk_defaultPayment_edit="default payment edit button#xpath=//div[@class='address-book-default']//a[contains(text(),'Edit')]";
	public static final String lnk_defaultPayment_remove="default payment remove button#xpath=//div[@class='address-book-default']//a[contains(text(),'Remove')]";

	public static final String txt_edit_billing_firstName="first name textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'firstName')]";
	public static final String txt_edit_billing_lastName="last name textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'lastName')]";
	public static final String txt_edit_billing_addressOne="address one textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address1')]";
	public static final String txt_edit_billing_addressTwo="address two textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address2')]";
	public static final String txt_edit_billing_addressThree="address three textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address3')]";
	public static final String txt_edit_billing_city="city textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'city')]";
	public static final String txt_edit_billing_state="state textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'state')]";
	public static final String txt_edit_billing_zipcode="zipcode textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'zipCode')]";
	public static final String txt_edit_billing_phone1="day phone textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'phone1')]";
	public static final String txt_edit_billing_phone2="evening phone textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'phone2')]";
	public static final String txt_edit_billing_email1="email textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'email1')]";
	public static final String txt_edit_billing_email2="confirm email textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'confirmemail1')]";

	public static final String btn_edit_billing_savebutton="edit billing save buton#xpath=//form[@id='EditAddressForm']//span[contains(text(),'Save')]/parent::button";
	public static final String btn_edit_billing_cancelbutton="edit billing cancel button#xpath=//form[@id='EditAddressForm']//span[contains(text(),'Cancel')]/parent::button";

	public void clickOnNewCardLinkInBillingInformationPage(){
		clickOn(lnk_newCard);
	}

	public void fillNewPaymentOptionPopUpInBillingInformationPage(String cardType,String cardNumber, String cardExpMonth,String cardExpYear, String firstName,
			String lastName, String addressOne, String  addressTwo, String addressThree, String city,String state,String zipcode, String dayPhone,String eveningPhone, String email, String confirmEmail,boolean defaultpayementFlag){
		selectFromDropdown(drp_newCard_billing_card_type, cardType);
		typeIn(txt_newCard_billing_card_number, cardNumber);
		typeIn(txt_newCard_billing_expiry_month, cardExpMonth);
		typeIn(txt_newCard_billing_expiry_year, cardExpYear);
		typeIn(txt_newCard_billing_firstName, firstName);
		typeIn(txt_newCard_billing_lastName, lastName);
		typeIn(txt_newCard_billing_addressOne, addressOne);
		typeIn(txt_newCard_billing_addressTwo, addressTwo);
		typeIn(txt_newCard_billing_addressThree, addressThree);
		typeIn(txt_newCard_billing_city, city);
		typeIn(txt_newCard_billing_state, state);
		typeIn(txt_newCard_billing_zipcode, zipcode);
		typeIn(txt_newCard_billing_phone1, dayPhone);
		typeIn(txt_newCard_billing_phone2, eveningPhone);
		typeIn(txt_newCard_billing_email1, email);
		typeIn(txt_newCard_billing_email2, confirmEmail);
		//if(!currentBrowser.toLowerCase().contains("firefox")){
			if(defaultpayementFlag==true){
				clickOn(chk_default_payment);
			//}
		}
	}

	public void clickOnSaveBtnInNewPaymentOption(){
		clickOn(btn_newcard_billing_save);
	}

	public void clickOnEditBtnInDefaultPaymentOption(){
		clickOn(lnk_defaultPayment_edit);
	}

	public void clickOnRemoveBtnInDefaultPaymentOption(){
		clickOn(lnk_defaultPayment_remove);
	}

	public void editDefaultPaymentOptionPopUpInBillingInformationPage(String firstName, String lastName, String addressOne, String  addressTwo,
			String addressThree, String city,String state,String zipcode, String dayPhone,String eveningPhone, String email, String confirmEmail,boolean defaultpayementFlag){
		if(!firstName.isEmpty()) typeIn(txt_edit_billing_firstName, firstName);
		if(!lastName.isEmpty()) typeIn(txt_edit_billing_lastName, lastName);
		if(!addressOne.isEmpty()) typeIn(txt_edit_billing_addressOne, addressOne);
		if(!addressTwo.isEmpty()) typeIn(txt_edit_billing_addressTwo, addressTwo);
		if(!addressThree.isEmpty()) typeIn(txt_edit_billing_addressThree, addressThree);
		if(!city.isEmpty()) typeIn(txt_edit_billing_city, city);
		if(!state.isEmpty()) typeIn(txt_edit_billing_state, state);
		if(!zipcode.isEmpty()) typeIn(txt_edit_billing_zipcode, zipcode);
		if(!dayPhone.isEmpty()) typeIn(txt_edit_billing_phone1, dayPhone);
		if(!eveningPhone.isEmpty()) typeIn(txt_edit_billing_phone2, eveningPhone);
		if(!email.isEmpty()) typeIn(txt_edit_billing_email1, email);
		if(!confirmEmail.isEmpty()) typeIn(txt_edit_billing_email2, confirmEmail);
		if(defaultpayementFlag==true){
			//clickOn(chk_default_payment);
		}
	}
	public void clickOnMakeThisMyDefaultInMyAccountBillingInfoPage(String firstAndLastName){
		  clickOn("Make this my default link#xpath=//div[contains(@class,'address-book-additional')]//p[contains(text(),'"+firstAndLastName+"')]/parent::div//a[contains(@class,'makeDefaultAction') or contains(text(),'Make this my Default')]");
		 }
	

	public void clickOnSaveBtnEditDefaultPaymentOptionPopup(){
		clickOn(btn_edit_billing_savebutton);
	}

	public void clickOnCancelBtnEditDefaultPaymentOptionPopup(){
		clickOn(btn_edit_billing_cancelbutton);
	}


	public String getValueFromEditBillinginformationPopUp(String labelName){
		String returnValue="";
		switch (labelName) {
		case "first name":
			returnValue= getAttributeValue(txt_edit_billing_firstName, "value");
			break;

		case "last name":
			returnValue= getAttributeValue(txt_edit_billing_lastName, "value");
			break;

		case "address one":
			returnValue= getAttributeValue(txt_edit_billing_addressOne, "value");
			break;

		case "address two":
			returnValue= getAttributeValue(txt_edit_billing_addressTwo, "value");
			break;

		case "address three":
			returnValue= getAttributeValue(txt_edit_billing_addressThree, "value");
			break;

		case "city":
			returnValue= getAttributeValue(txt_edit_billing_city, "value");
			break;

		case "state":
			returnValue= getAttributeValue(txt_edit_billing_state, "value");
			break;

		case "zipcode":
			returnValue= getAttributeValue(txt_edit_billing_zipcode, "value");
			break;

		case "phone1":
			returnValue= getAttributeValue(txt_edit_billing_phone1, "value");
			break;

		case "phone2":
			returnValue= getAttributeValue(txt_edit_billing_phone2, "value");
			break;

		case "email1":
			returnValue= getAttributeValue(txt_edit_billing_email1, "value");
			break;

		case "email2":
			returnValue= getAttributeValue(txt_edit_billing_email2, "value");
			break;


		}
		return returnValue;

	}
}
