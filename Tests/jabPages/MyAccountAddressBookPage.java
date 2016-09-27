package jabPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountAddressBookPage extends HomePage{

	public static final String lnk_newCard="new address link#xpath=//div[@class='address-book-info']//a[contains(text(),'New Address')]";
	
	public static final String txt_newAddress_shipping_firstName="first name textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'firstName')]";
	public static final String txt_newAddress_shipping_lastName="last name textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'lastName')]";
	public static final String txt_newAddress_shipping_addressOne="address one textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address1')]";
	public static final String txt_newAddress_shipping_addressTwo="address two textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address2')]";
	public static final String txt_newAddress_shipping_addressThree="address three textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'address3')]";
	public static final String txt_newAddress_shipping_city="city textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'city')]";
	public static final String txt_newAddress_shipping_state="state textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'state')]";
	public static final String txt_newAddress_shipping_zipcode="zipcode textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'zipCode')]";
	public static final String txt_newAddress_shipping_phone1="day phone textbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'phone1')]";
	
	public static final String chk_default_shipping="default shipping checkbox#xpath=//form[@id='addAddressForm']//input[contains(@name,'primary')]";
	public static final String btn_newcard_shipping_save="new billing popup save button#xpath=//form[@id='addAddressForm']//span[contains(text(),'Save')]/parent::button";
	
	//public static final String lnk_defaultPayment_edit="default payment edit button#xpath=//div[@class='address-book-default']//a[contains(text(),'Edit')]";
	//public static final String lnk_defaultPayment_remove="default payment remove button#xpath=//div[@class='address-book-default']//a[contains(text(),'Remove')]";
	
	public static final String txt_edit_shipping_firstName="first name textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'firstName')]";
	public static final String txt_edit_shipping_lastName="last name textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'lastName')]";
	public static final String txt_edit_shipping_addressOne="address one textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address1')]";
	public static final String txt_edit_shipping_addressTwo="address two textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address2')]";
	public static final String txt_edit_shipping_addressThree="address three textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'address3')]";
	public static final String txt_edit_shipping_city="city textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'city')]";
	public static final String txt_edit_shipping_state="state textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'state')]";
	public static final String txt_edit_shipping_zipcode="zipcode textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'zipCode')]";
	public static final String txt_edit_shipping_phone1="day phone textbox#xpath=//form[@id='EditAddressForm']//input[contains(@name,'phone1')]";
	
	public static final String btn_edit_shipping_savebutton="edit shipping save buton#xpath=//form[@id='EditAddressForm']//span[contains(text(),'Save')]/parent::button";
	public static final String btn_edit_shipping_cancelbutton="edit shipping cancel button#xpath=//form[@id='EditAddressForm']//span[contains(text(),'Cancel')]/parent::button";
	
	public void clickOnNewAddressLinkInAddressBookPage(){
		clickOn(lnk_newCard);
	}
	
	public void fillNewShippingAddressOptionPopUpInAddressBookPage(String firstName, String lastName, String addressOne, String  addressTwo, 
			String addressThree, String city,String state,String zipcode, String dayPhone,boolean defaultpayementFlag){
		typeIn(txt_newAddress_shipping_firstName, firstName);
		typeIn(txt_newAddress_shipping_lastName, lastName);
		typeIn(txt_newAddress_shipping_addressOne, addressOne);
		typeIn(txt_newAddress_shipping_addressTwo, addressTwo);
		typeIn(txt_newAddress_shipping_addressThree, addressThree);
		typeIn(txt_newAddress_shipping_city, city);
		typeIn(txt_newAddress_shipping_state, state);
		typeIn(txt_newAddress_shipping_zipcode, zipcode);
		typeIn(txt_newAddress_shipping_phone1, dayPhone);
		if(defaultpayementFlag==true){
			clickOn(chk_default_shipping);
		}
	}
	
	public void clickOnSaveBtnInNewShippingAddressPopup(){
		clickOn(btn_newcard_shipping_save);
	}
	
	public void clickOnEditBtnInAdditionalShippingAddress(String firstNameLastName){
		clickOn("'"+firstNameLastName+"' Edit link#xpath=//div[@class='address-book-additional']//p[contains(text(),'"+firstNameLastName+"')]/parent::div//a[contains(text(),'Edit')]");
	}
	
	public void clickOnRemoveBtnInAdditionalShippingAddress(String firstNameLastName){
		clickOn("'"+firstNameLastName+"' Remove link#xpath=//div[@class='address-book-additional']//p[contains(text(),'"+firstNameLastName+"')]/parent::div//a[contains(text(),'Remove')]");
	}
	public void removeAllAddressInAdditionalShippingAddress(String firstNameLastName){
		  List<WebElement> addressList=driver.findElements(By.xpath("//div[@class='address-book-additional']//p[contains(text(),'"+firstNameLastName+"')]/parent::div//a[contains(text(),'Remove')]"));
		  if(addressList.size()>0){
		   for(WebElement ele:addressList){
			   clickOn("'"+firstNameLastName+"' Remove link#xpath=//div[@class='address-book-additional']//p[contains(text(),'"+firstNameLastName+"')]/parent::div//a[contains(text(),'Remove')]");
			waitForLoadingAndDissappearJABLoadingImg();
		    waitTime(2);
		   }
		  }
		 }
	
	public void editAdditionalShippingAddressPopUpInAddressBookPage(String firstName, String lastName, String addressOne, String  addressTwo,
			String addressThree, String city,String state,String zipcode, String dayPhone,boolean defaultpayementFlag){
		if(!firstName.isEmpty()) typeIn(txt_edit_shipping_firstName, firstName);
		if(!lastName.isEmpty()) typeIn(txt_edit_shipping_lastName, lastName);
		if(!addressOne.isEmpty()) typeIn(txt_edit_shipping_addressOne, addressOne);
		if(!addressTwo.isEmpty()) typeIn(txt_edit_shipping_addressTwo, addressTwo);
		if(!addressThree.isEmpty()) typeIn(txt_edit_shipping_addressThree, addressThree);
		if(!city.isEmpty()) typeIn(txt_edit_shipping_city, city);
		if(!state.isEmpty()) typeIn(txt_edit_shipping_state, state);
		if(!zipcode.isEmpty()) typeIn(txt_edit_shipping_zipcode, zipcode);
		if(!dayPhone.isEmpty()) typeIn(txt_edit_shipping_phone1, dayPhone);
		if(defaultpayementFlag==true){
			clickOn(chk_default_shipping);
		}
	}
	
	public void clickOnSaveBtnEditShippingAddressPopup(){
		clickOn(btn_edit_shipping_savebutton);
	}
	public void clickOnCancelBtnEditShippingAddressPopup(){
		clickOn(btn_edit_shipping_cancelbutton);
	}
	
	
	public String getValueFromEditShippingAddressPopUp(String labelName){
		String returnValue="";
		switch (labelName) {
		case "first name":
			returnValue= getAttributeValue(txt_edit_shipping_firstName, "value");
			break;

		case "last name":
			returnValue= getAttributeValue(txt_edit_shipping_lastName, "value");
			break;

		case "address one":
			returnValue= getAttributeValue(txt_edit_shipping_addressOne, "value");
			break;

		case "address two":
			returnValue= getAttributeValue(txt_edit_shipping_addressTwo, "value");
			break;

		case "address three":
			returnValue= getAttributeValue(txt_edit_shipping_addressThree, "value");
			break;

		case "city":
			returnValue= getAttributeValue(txt_edit_shipping_city, "value");
			break;

		case "state":
			returnValue= getAttributeValue(txt_edit_shipping_state, "value");
			break;

		case "zipcode":
			returnValue= getAttributeValue(txt_edit_shipping_zipcode, "value");
			break;

		case "phone1":
			returnValue= getAttributeValue(txt_edit_shipping_phone1, "value");
			break;

		}
		return returnValue;
		
	}
}
