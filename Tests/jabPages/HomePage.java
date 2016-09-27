package jabPages;


public class HomePage extends GiftCardPage{
	public static final String img_logo="App logo img#xpath=//*[@src='//content.josbank.com/Global/logo-center.jpg'or @id='logo']";
	public static final String grd_HomePageGrid = "Home Page #xpath=//div[@id='contentWrapper']//div[@class='row row-margin row-promotion-grid']";

	
	public void navigateToHomePage(){
		clickOn(img_logo);
	}
	public void verifyHomePage(){
		waitTime(5);
		if(isElementDisplayed(grd_HomePageGrid)){
			testStepPassed("JAB Home page is Displayed");
		}else{
			testStepFailed("JAB Home Page is not displayed");
		}
	}
	
}
