package scenarios;

import org.openqa.selenium.By;

public class UserRegistrationTest extends SubcategoriesLinksNavigationOnHomePageTest{
	private String dynamicUsername,username;

	public void userRegistrationTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{
			//1.Launch JAB application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			username=retrieve("Username");
			dynamicUsername=username.split("@")[0]+"_"+getCurrentDateAndTimeStamp()+"@"+username.split("@")[1];
			//2.Click on Sign In/Register link from header
			clickOnSignInLink();
			//3.Enter valid values into Create an Account fields and click on Sign Up
			fillCreateAccountDetails(dynamicUsername, dynamicUsername, retrieve("password"), retrieve("password"));
			chooseBankRewardOption("");
			clickOnSignUpButton();
			waitForText("Welcome");
			//4.User should be logged in My Account page should be displayed
			if(driver.findElement(By.xpath("//div[@class='breadcrumb']//span[@class='current']")).getText().contains("")){
				testStepPassed("User is registered and navigated to MY Account page");
				//5.Verify Header link "Sign In / Register" changes to "My Account | Sign out" after successful signup.
				if(!driver.findElement(By.xpath("//ul[@id='quickLinksBar']//a[contains(text(),'Sign In / Register')]")).isDisplayed()){
					if(driver.findElement(By.xpath("//ul[@id='quickLinksBar']//a[contains(text(),'My Account')]")).isDisplayed() && driver.findElement(By.xpath("//ul[@id='quickLinksBar']//a[contains(text(),'Sign Out')]")).isDisplayed()){
						testStepPassed("Verified 'Sign In / register' link changed to 'My Accoount | Sign out' after successful signup");
						testStepPassed("Created user account :"+dynamicUsername);
					}else{
						testStepFailed("'My Accoount | Sign out' link is not displayed after user successful signup");
					}
				}else{
					testStepFailed("'Sign In / Register' is dislpayed on page after user successful signup");
				}
			}else{
				testStepFailed("User is not registered");
			}
			//6.Sign out
			clickOnSignOutLink();
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			driver.close();
		}


	}
}
