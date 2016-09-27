package jabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import headStart.HeaderLinks;

/**
 * @author Indium
 *
 */
public class BillingAndShippingInformationPage extends HeaderLinks{

	public static final String drp_countrySelect="Country select drop down#xpath=//select[contains(@name,'country')]";
	public static final String txt_firstName="First Name textbox#xpath=//input[contains(@name,'firstName')]";
	public static final String txt_lastName="Last name textbox#xpath=//input[contains(@name,'lastName')]";
	public static final String txt_companyName="company name textbox#xpath=//input[contains(@name,'organizationName')]";
	public static final String txt_addressOne="address one textbox#xpath=//input[contains(@name,'address1')]";
	public static final String txt_addressTwo="address two textbox#xpath=//input[contains(@name,'address2')]";
	public static final String txt_addressThree="address three textbox#xpath=//input[contains(@name,'address3')]";
	public static final String txt_city="city textbox#xpath=//input[contains(@name,'city')]";
	public static final String txt_state="state textbox#xpath=//input[contains(@name,'state')]";
	public static final String txt_zipcode="zipcode textbox#xpath=//input[contains(@name,'zipCode')]";
	public static final String txt_phoneOne="phone textbox#xpath=//input[contains(@name,'phone1')]";
	public static final String txt_email="email textbox#xpath=//input[contains(@name,'email1')]";
	public static final String txt_confirmEmail="phone textbox#xpath=//input[contains(@name,'email2')]";
	public static final String chk_discountAndNews="Receive discount and news check box#xpath=//input[contains(@name,'billingEnrol')]";
	public static final String btn_continue_payment="continue payment button#xpath=//span[contains(text(),'Continue to Payment')]/parent::button";

	public static final String rd_btn_sameAsBilling=" Same as billing address radio button#xpath=//input[@id='shipAsBil' and @name='shippingRadio']";
	public static final String rd_btn_shipToStore=" ship to store radio button#xpath=//input[@id='shipToStore' and @name='shippingRadio']";
	public static final String rd_btn_shipToOther=" ship to Other radio button#xpath=//input[@id='shipToOther' and @name='shippingRadio']";

	public static final String txt_shipping_firstname="Shipping address first name textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'firstName')]";
	public static final String txt_shipping_lastname="shipping address last name textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'lastName')]";
	public static final String txt_shipping_company="shipping address company textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'organizationName')]";
	public static final String txt_shipping_addressOne="shipping address first textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'address1')]";
	public static final String txt_shipping_addresstwo="shipping address second textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'address2')]";
	public static final String txt_shipping_addressthree="shipping address third textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'address3')]";
	public static final String txt_shipping_city="shipping address city textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'city')]";
	public static final String txt_shipping_state="shipping address state textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'state')]";
	public static final String txt_shipping_zipcode="shipping address zipcode textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'zipCode')]";
	public static final String txt_shipping_phone="shipping address phone textbox#xpath=//div[@id='shippingCreateEditArea1']//input[contains(@name,'phone1')]";

	public static final String drp_shipping_method="shipping mode drop down selection#xpath=//select[contains(@name,'singleShipmentShippingMode')]";

	public static final String drp_billing_address_select="select billing address drop down#xpath=//select[contains(@name,'billing_address_id')]";

	public void clickOnContinueToPayment(){
		clickOn(btn_continue_payment);
	}

	/** Fill billing address details
	 * @param country
	 * @param firstName
	 * @param lastName
	 * @param company [ optional data ]
	 * @param streetAdd
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param phone
	 * @param email
	 * @param confirmEmail
	 */
	public void fillBillingAddressDetails(String country, String firstName, String lastName, String company, String  streetAdd, String city, String state, String zipCode, String phone, String email, String confirmEmail){
		selectFromDropdown(drp_countrySelect, country);
		typeIn(txt_firstName, firstName);
		typeIn(txt_lastName, lastName);
		typeIn(txt_companyName, company);
		typeIn(txt_addressOne, streetAdd);
		typeIn(txt_city, city);
		typeIn(txt_state, state);
		typeIn(txt_zipcode, zipCode);
		typeIn(txt_phoneOne, phone);
		typeIn(txt_email, email);
		typeIn(txt_confirmEmail, confirmEmail);
	}


	/**choose Billing Address Options
	 * @param option [same as billing,ship to store,ship to other]
	 *//*
	public void chooseBillingAddressOptions(String option){
		switch (option.toLowerCase()) {
		case "same as billing":
			clickOn(rd_btn_sameAsBilling);
			break;
		case "ship to store":
			clickOn(rd_btn_sameAsBilling);
			break;
		case "ship to other":
			clickOn(rd_btn_sameAsBilling);
			break;

		default:
			clickOn(rd_btn_sameAsBilling);
			break;
		}
		clickOn(rd_btn_sameAsBilling);
	}*/

	public void fillShippingAddressDetails(String firstName, String lastName, String company, String  streetAdd, String city, String state, String zipCode, String phone){
		typeIn(txt_shipping_firstname, firstName);
		typeIn(txt_shipping_lastname, lastName);
		typeIn(txt_shipping_company, company);
		typeIn(txt_shipping_addressOne, streetAdd);
		typeIn(txt_shipping_city, city);
		typeIn(txt_shipping_state, state);
		typeIn(txt_shipping_zipcode, zipCode);
		typeIn(txt_shipping_phone, phone);
	}

	public void selectShippingMode(String shippingMode){
		selectFromDropdown(drp_shipping_method, shippingMode);
	}

	/**choose Shipping Address Options
	 * @param option [same as billing,ship to store,ship to other]
	 */
	public void chooseShippingAddressOptions(String option){
		switch (option.toLowerCase()) {
		case "same as billing":
			clickOn(rd_btn_sameAsBilling);
			break;
		case "ship to store":
			clickOn(rd_btn_sameAsBilling);
			break;
		case "ship to other":
			clickOn(rd_btn_sameAsBilling);
			break;

		default:
			clickOn(rd_btn_sameAsBilling);
			break;
		}
		clickOn(rd_btn_sameAsBilling);
	}

	public void selectBillingAddressDropdown(String option){
		selectFromDropdown(drp_billing_address_select, option);
	}

	public void selectBillingAddressDropdown(int index){
		selectFromDropdown(drp_billing_address_select, index);
	}
	public void selectNewaddressOptionFromBillingAddressDropDown(){
		try{
			new Select(driver.findElement(By.xpath("//select[contains(@name,'billing_address_id')]"))).selectByVisibleText("New Address");
			testStepPassed("select 'New Address' from billing address drop down");
		}catch(Exception e){
			testStepFailed("Exception occured while trying to select dropdown : "+e);
		}
	}
}

