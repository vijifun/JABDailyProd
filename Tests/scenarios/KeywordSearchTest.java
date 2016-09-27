package scenarios;

public class KeywordSearchTest extends HeaderLinksOnHomePageTest{
	public void keywordSearchTestScenario(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){

		try{
			//1.Launch JAB application
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			searchProduct(retrieve("Searchkey"));
			verifyUserInProductGridPageWithProductListing();
		}catch(Exception e){
			testStepFailed("Exception occured :"+e);
		}finally{
			
			driver.close();
		}


	}
}
