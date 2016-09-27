package jabPages;

public class SignInPage extends QuickViewPopUp{

	//public static final String txt_loginID="Login ID text box#xpath=//input[contains(@name,'logonId')]";
	public static final String txt_loginID="Login ID text box#xpath=//input[contains(@name,'logonId') and (contains(@id,'WC_AccountDisplay_FormInput_logonId') or contains(@id,'WC_CheckoutLogon_FormInput_logonId'))]";
	public static final String txt_loginPassword="Login password text box#xpath=//input[contains(@name,'logonPassword')]";

	public static final String lnk_forgotpassword="Forgot password link text#xpath=//a[contains(text(),'Forgot your password?')]";
	public static final String btn_signIn="Sign in button#xpath=//span[contains(text(),'Sign In') or contains(text(),'Sign in')]/parent::button";
	public static final String txt_Email="E-mail (Username) text box#xpath=//input[contains(@id,'bmemail')]";
	public static final String txt_verifyEmail="Verify E-mail text box#xpath=//input[contains(@id,'bmverifyEmail')]";
	public static final String txt_password="account creation password text box#xpath=//input[contains(@id,'bmlogonPassword')]";

	
	public static final String btn_guest_checkout="guest checkout button#xpath=//a[span[contains(text(),'Guest Checkout')]/parent::a and @id='checkout']";

	public static final String txt_createAccount_username="create account username textbox#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@name,'email1')]";
	public static final String txt_createAccount_verifyeMail="create account verify email textbox#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'bmverifyEmail')]";
	public static final String txt_createAccount_password="create account password textbox#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'bmlogonPassword')]";
	public static final String txt_createAccount_verifyPassword="create account verify password textbox#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'bmlogonPasswordVerify')]";
	public static final String txt_createAccount_receiveOffers="create account receive discount email chechbox#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@name,'receiveEmail')]";
	public static final String rdo_createAccount_bankAccount_yes="'Yes, sign me up for Bank Account™ Rewards' radio button#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'signupbar') and @type='radio']";
	public static final String rdo_createAccount_bankAccount_already="' I'm already a Bank Account™ Rewards Member - Link My Account' radio button#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'alreadybarmember') and @type='radio']";
	public static final String rdo_createAccount_bankAccount_no="'I don't want to sign up for Bank Account™ Rewards' radio button#xpath=//div[contains(@class,'sign-in-block')]//input[contains(@id,'dontsignupbar') and @type='radio']";

	public static final String btn_signup="signup button#xpath=//span[contains(text(),'Sign Up')]/parent::button";


	public void signIn(String emailId, String password){
	
		typeIn(txt_loginID, emailId);
		typeIn(txt_loginPassword, password);
		clickOn(btn_signIn);
	}

	public void verifyLoginPage(){
		if(driver.getTitle().trim().equalsIgnoreCase("sign in")){
			testStepPassed("Verified user is in Sign In page");
		}else{
			testStepFailed("User is not in Sigin In page");
		}
	}

	

	public void clickOnGuestCheckout(){
		clickOn(btn_guest_checkout);
	}

	public void fillCreateAccountDetails(String email, String verifyEmail, String password, String verifyPassword){
		typeIn(txt_createAccount_username, email);
		typeIn(txt_createAccount_verifyeMail, verifyEmail);
		typeIn(txt_createAccount_password, password);
		typeIn(txt_createAccount_verifyPassword, verifyPassword);
	}

	public void chooseBankRewardOption(String option){
		switch (option.toLowerCase()) {
		case "yes":
			clickOn(rdo_createAccount_bankAccount_yes);
			break;
		case "already":
			clickOn(rdo_createAccount_bankAccount_already);
			break;
		case "no":
			clickOn(rdo_createAccount_bankAccount_no);
			break;
		default:
			clickOn(rdo_createAccount_bankAccount_no);
			break;
		}
	}
	
	public void clickOnSignUpButton(){
		clickOn(btn_signup);
	}
}
