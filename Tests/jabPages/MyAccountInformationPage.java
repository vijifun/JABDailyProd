package jabPages;

public class MyAccountInformationPage extends MyAccountBillingInformationPage{

	public static final String lnk_edit_email="edit email link#xpath=//div[contains(@class,'account-info')]//a[contains(text(),'Edit Email')]";
	public static final String lnk_edit_password="edit password link#xpath=//div[contains(@class,'account-info')]//a[contains(text(),'Edit Password')]";
	public static final String txt_emailId="email id#xpath=//span[contains(text(),'')]/parent::div//span[contains(@class,'value')]";
	
	public static final String txt_neweMail="new email textbox#xpath=//label[contains(text(),'New E-mail:')]/parent::div//input[contains(@id,'logonId')]";
	public static final String txt_verifyEmail="verify email textbox#xpath=//label[contains(text(),'Verify E-mail:')]/parent::div//input[contains(@id,'logonId')]";
	public static final String btn_email_save_button="edit email save button#xpath=//form[contains(@id,'EditEmailForm')]//span[contains(text(),'Save')]/parent::button";
	public static final String txt_newpassword=" new password textbox#xpath=//form[contains(@name,'EditPasswordForm')]//input[@name='logonPassword']";
	public static final String txt_verifyPassword="verify password textbox#xpath=//form[contains(@name,'EditPasswordForm')]//input[@name='logonPasswordVerify']";
	public static final String btn_savePassword="edit password save button#xpath=//form[contains(@name,'EditPasswordForm')]//span[contains(text(),'Save')]/parent::button";
	
	public void clickOnEditEmailLinkInAccountInformationPage(){
		clickOn(lnk_edit_email);
	}
	
	public void clickOnEditPasswordLinkInAccountInformationPage(){
		clickOn(lnk_edit_password);
	}
	
	public String getEmailIdDisplayedOnMyAccountInformationPage(){
		return getText(txt_emailId);
	}
	
	public void fillEditEmailAddressDetails(String newEmail,String verifyEmail){
		typeIn(txt_neweMail, newEmail);
		typeIn(txt_verifyEmail, verifyEmail);
	}
	
	public void clickOnEditEmailSaveButton(){
		clickOn(btn_email_save_button);
	}
	
	public void fillEditPasswordDetails(String newPassword, String verifyPassword){
		typeIn(txt_newpassword, newPassword);
		typeIn(txt_verifyPassword, verifyPassword);
	}
	
	public void clickOnEditPasswordSaveButton(){
		clickOn(btn_savePassword);
	}
}
