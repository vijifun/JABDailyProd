package jabPages;

public class QuickViewPopUp extends ProductGridPage{
	public static final String btn_more_detail="More detail button#xpath=//button[@class='qv-more-details-btn']";
	
	public void clickOnMoreDetailBtnQuickViewPopup(){
		clickOn(btn_more_detail);
	}

}
