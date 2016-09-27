package scenarios;


import java.util.List;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubcategoriesLinksNavigationOnHomePageTest extends ShoppingCartTest{

	public void subCategoriesLinksNavigationOnHomePageTestScenarioPartOne(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			List<String> departmentMenuList = getListOfDepartmentMenuName();
			List<String> categoryAndSubcategoryList;
			WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(getConfigProperty("ElementLoadWaitTime")));

			//for(int i=0; i<departmentMenuList.size();i++){
			for(int i=0; i<3;i++){
				String deptName = WordUtils.capitalize(departmentMenuList.get(i).toLowerCase());

				if(!deptName.equals("Shoes And Accessories")){
					clickOnDepartmentMenu(deptName);			
				}else{
					deptName="Shoes and Accessories";
					clickOnDepartmentMenu(deptName);
				}
				verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(deptName);			
				waitTime(10);
				//if(!deptName.equals("Shoes And Accessories")){
				categoryAndSubcategoryList = getListOfCategoryAndSubcategorylink(deptName);
				/*}else{
					categoryAndSubcategoryList = getListOfCategoryAndSubcategorylink("Shoes and Accessories");
				}*/
				for(int j=12; j<categoryAndSubcategoryList.size(); j++){

					String categoryOrSubcategoryName = categoryAndSubcategoryList.get(j);
					if(categoryOrSubcategoryName.equalsIgnoreCase("Tuxedo Rentals at JOSBANKFORMAL.COM")){
						testStepPassed("<<---------Skipping Tuxedo Rentals at JOSBANKFORMAL.COM link verification--------->>");
					}else{
						try{
							selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);
							/*if(categoryOrSubcategoryName.equalsIgnoreCase("Slim Fit Sportcoats")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//")));
						}else{*/
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
							//}
							verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
							verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
						}catch(Exception e){
							try{
								testStepPassed("<<-----------------------Trying again for '"+categoryOrSubcategoryName+"' page------------------------------------------>>");
								driver.get(getConfigProperty("AppURL"));
								waitTime(2);
								selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);	
								/*if(categoryOrSubcategoryName.equalsIgnoreCase("Slim Fit Sportcoats")){
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='widget_breadcrumb']//li/h1[text()='Sportcoats']")));
							}else{*/
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
								//}
								verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
								verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
							}catch(Exception f){
								testStepFailed("Exception occured: "+f);
							}
						}
					}
				}
			}
		}catch(Exception e){
			testStepFailed("Exception "+e.toString());
		}finally{
			driver.close();
		}
	}

	public void subCategoriesLinksNavigationOnHomePageTestScenarioPartTwo(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			List<String> departmentMenuList = getListOfDepartmentMenuName();
			List<String> categoryAndSubcategoryList;
			WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(getConfigProperty("ElementLoadWaitTime")));

			for(int i=3; i<6;i++){

				String deptName = WordUtils.capitalize(departmentMenuList.get(i).toLowerCase());

				if(!deptName.equals("Shoes And Accessories")){
					clickOnDepartmentMenu(deptName);			
				}else{
					deptName="Shoes and Accessories";
					clickOnDepartmentMenu(deptName);
				}
				verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(deptName);			

				categoryAndSubcategoryList = getListOfCategoryAndSubcategorylink(deptName);
				for(int j=0; j<categoryAndSubcategoryList.size(); j++){

					String categoryOrSubcategoryName = categoryAndSubcategoryList.get(j);
					if(categoryOrSubcategoryName.equalsIgnoreCase("Tuxedo Rentals at JOSBANKFORMAL.COM")){
						testStepPassed("<<---------Skipping Tuxedo Rentals at JOSBANKFORMAL.COM link verification--------->>");
					}else{
						try{
							selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
							verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
							verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
						}catch(Exception e){
							try{
								testStepPassed("<<-----------------------Trying again for '"+categoryOrSubcategoryName+"' page------------------------------------------>>");
								driver.get(getConfigProperty("AppURL"));
								waitTime(2);
								selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);	
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
								verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
								verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
							}catch(Exception f){
								testStepFailed("Exception occured: "+f);
							}
						}
					}
				}
			}
		}catch(Exception e){
			testStepFailed("Exception "+e.toString());
		}finally{
			driver.close();
		}
	}

	public void subCategoriesLinksNavigationOnHomePageTestScenarioPartThree(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			List<String> departmentMenuList = getListOfDepartmentMenuName();
			List<String> categoryAndSubcategoryList;
			WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(getConfigProperty("ElementLoadWaitTime")));

			for(int i=6; i<departmentMenuList.size()-1;i++){


				String deptName = WordUtils.capitalize(departmentMenuList.get(i).toLowerCase());
				if(!deptName.equalsIgnoreCase("tuxedos")){
				if(!deptName.equals("Shoes And Accessories")){
					clickOnDepartmentMenu(deptName);			
				}else{
					deptName="Shoes and Accessories";
					clickOnDepartmentMenu(deptName);
				}
				verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(deptName);			

				categoryAndSubcategoryList = getListOfCategoryAndSubcategorylink(deptName);
				for(int j=0; j<categoryAndSubcategoryList.size(); j++){

					String categoryOrSubcategoryName = categoryAndSubcategoryList.get(j);
					if(categoryOrSubcategoryName.equalsIgnoreCase("Tuxedo Rentals at JOSBANKFORMAL.COM")){
						testStepPassed("<<---------Skipping Tuxedo Rentals at JOSBANKFORMAL.COM link verification--------->>");
					}else{
						try{
							selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
							verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
							verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
						}catch(Exception e){
							try{
								testStepPassed("<<-----------------------Trying again for '"+categoryOrSubcategoryName+"' page------------------------------------------>>");
								driver.get(getConfigProperty("AppURL"));
								waitTime(2);
								selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);	
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
								verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
								verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
							}catch(Exception f){
								testStepFailed("Exception occured: "+f);
							}
						}
					}
				}
			}
			}
		}catch(Exception e){
			testStepFailed("Exception "+e.toString());
		}finally{
			driver.close();
		}
	}

	public void subCategoriesLinksNavigationOnHomePageTestScenarioPartFour(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion, String tcId){
		try{
			openBrowser(machineName, host, port, browser, os, browserVersion, osVersion);
			verifyUSFlagSelected();
			List<String> departmentMenuList = getListOfDepartmentMenuName();
			List<String> categoryAndSubcategoryList;
			WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(getConfigProperty("ElementLoadWaitTime")));

			for(int i=(departmentMenuList.size()-1); i<departmentMenuList.size();i++){

				String deptName = WordUtils.capitalize(departmentMenuList.get(i).toLowerCase());
				if(!deptName.equalsIgnoreCase("tuxedos")){
					if(!deptName.equals("Shoes And Accessories")){
						clickOnDepartmentMenu(deptName);			
					}else{
						deptName="Shoes and Accessories";
						clickOnDepartmentMenu(deptName);
					}
					verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(deptName);			

					categoryAndSubcategoryList = getListOfCategoryAndSubcategorylink(deptName);
					for(int j=0; j<categoryAndSubcategoryList.size(); j++){

						String categoryOrSubcategoryName = categoryAndSubcategoryList.get(j);
						if(categoryOrSubcategoryName.equalsIgnoreCase("Tuxedo Rentals at JOSBANKFORMAL.COM")){
							testStepPassed("<<---------Skipping Tuxedo Rentals at JOSBANKFORMAL.COM link verification--------->>");
						}else{
							try{
								selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
								verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
								verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
							}catch(Exception e){
								try{
									testStepPassed("<<-----------------------Trying again for '"+categoryOrSubcategoryName+"' page------------------------------------------>>");
									driver.get(getConfigProperty("AppURL"));
									waitTime(2);
									selectCategoryFromDepartmentMenu(deptName, categoryOrSubcategoryName);	
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[nav[@id='widget_breadcrumb']//li/h1[contains(text(),'"+categoryOrSubcategoryName+"')] or span[contains(@class,'tuxedo-rental-content')] or nav[@id='widget_breadcrumb']//li/h1[text()='Sportcoats'] or nav[@id='widget_breadcrumb']//li/h1[text()='Knit Shirts']]")));
									verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(categoryOrSubcategoryName);
									verifyProductDisplayInProductGridPage(categoryOrSubcategoryName);
								}catch(Exception f){
									testStepFailed("Exception occured: "+f);
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			testStepFailed("Exception "+e.toString());
		}finally{
			driver.close();
		}
	}

	public boolean verifyProductDisplayInProductGridPage(String categoryName){
		boolean flag=false;
		try{
			if(driver.findElement(By.xpath("//div[contains(@class,'product_listing_container') or contains(@id,'categoryRecommendationWidget')]")).isDisplayed()){
				flag=true;
				testStepPassed("Verified product displayed in '"+categoryName+"' page------>>");
			}
		}
		catch(Exception e){
			testStepFailed("Products are not displayed in '"+categoryName+"' page------>>");
		}
		return flag;
	}
}
