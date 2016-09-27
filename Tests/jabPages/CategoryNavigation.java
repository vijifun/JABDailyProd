package jabPages;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryNavigation extends BillingAndShippingInformationPage{

	public static final String grd_TuxedosGrid = "Tuxedos #xpath=//div[contains(@id,'contentWrapper')]//div[contains(@id,'main')]//div[contains(@class,'tuxedo-rental-content')]";

	
	public void selectCategoryFromDepartmentMenu(String departmentMenu, String subCategory){
		mouseOver(" '"+departmentMenu+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentMenu+"')]");
		clickOnSpecialElement(" '"+subCategory+"' subcategory link#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentMenu+"')]/../following-sibling::div//a[contains(text(),'"+subCategory+"')]");
	}

	


	public List<String> getListOfDepartmentMenuName(){
		List<WebElement> departmentMenuElement=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span"));
		List<String> departmentMenu=new ArrayList<String>();
		for(int i=0;i<departmentMenuElement.size();i++){
			departmentMenu.add(departmentMenuElement.get(i).getText().trim());
		}
		return departmentMenu;
	}

	/**Click on any sub category link of a department
	 * @param departmentName
	 * @return
	 */
	public String clickOnAnySubCategoryLink(String departmentName){
		String subCategoryLink = null;
		try{
			mouseOver(" '"+departmentName+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentName+"')]");
			waitTime(5);
			List<WebElement> subcategoryLink=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span[contains(text(),'"+departmentName+"')]/parent::a/parent::li//div//a[contains(@id,'subcategoryLink')]"));// or contains(@id,'categoryLink')]
			if(subcategoryLink.size()>0){
				Random ran= new Random();
				int ranNumber=ran.nextInt(subcategoryLink.size());
				webElement=subcategoryLink.get(ranNumber);
				subCategoryLink=webElement.getText().trim();
				locatorDescription="Click on :"+subCategoryLink;
				webElement.click();
				testStepPassed(locatorDescription);
			}else{
				testStepFailed("There is no subcategory link to click");
			}
		}catch(Exception e){
			testStepFailed("Unable to click on webelement :");
		}
		return subCategoryLink;
	}
	
	public List<String> getListOfCategoryAndSubcategorylink(String departmentLink){
		String locator=" '"+departmentLink+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentLink+"')]";
		mouseOver(locator);
		//waitTime(2);
		try{
		WebDriverWait wait=new WebDriverWait(driver,implicitlyWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'departmentMenu') and contains(@aria-label,'"+departmentLink+"')]")));
		}catch(Exception e){
			testStepFailed("Department menu is not displayed on mouse hover "+departmentLink);
		}
		List<String> subLinkList=new ArrayList<String>();
		List<WebElement> sublink=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span[contains(text(),'"+departmentLink+"')]/parent::a/parent::li//a[contains(@id,'subcategoryLink') or contains(@id,'categoryLink')]"));
		for(WebElement ele:sublink){
			subLinkList.add(ele.getText().trim());
		}
		return subLinkList;
	}
	
	/**Click on any category of a department
	 * @param departmentName
	 * @return
	 */
	public String clickOnAnyCategoryLink(String departmentName){
		String categoryLink = null;
		try{
			mouseOver(" '"+departmentName+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentName+"')]");
			List<WebElement> subcategoryLink=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span[contains(text(),'"+departmentName+"')]/parent::a/parent::li//div//a[contains(@id,'categoryLink')"));// or contains(@id,'categoryLink')]
			if(subcategoryLink.size()>0){
				Random ran= new Random();
				int ranNumber=ran.nextInt(subcategoryLink.size());
				webElement=subcategoryLink.get(ranNumber);
				categoryLink=webElement.getText().trim();
				locatorDescription="Click on :"+categoryLink;
				webElement.click();
				testStepPassed(locatorDescription);
			}else{
				testStepFailed("There is no subcategory link to click");
			}
		}catch(Exception e){
			testStepFailed("Unable to click on webelement :");
		}
		return categoryLink;
	}
	
	/**Click on any category or sub category link of a department
	 * @param departmentName
	 * @return
	 */
	public String clickOnAnyCategoryOrSubCategoryLink(String departmentName){
		String subCategoryLink = null;
		try{
			mouseOver(" '"+departmentName+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentName+"')]");
			waitTime(5);
			List<WebElement> subcategoryLink=driver.findElements(By.xpath("//ul[contains(@id,'departmentsMenu')]/li/a/span[contains(text(),'"+departmentName+"')]/parent::a/parent::li//div//a[contains(@id,'subcategoryLink') or contains(@id,'categoryLink')]")); 
			if(subcategoryLink.size()>0){
				Random ran= new Random();
				int ranNumber=ran.nextInt(subcategoryLink.size());
				webElement=subcategoryLink.get(ranNumber);
				subCategoryLink=webElement.getText().trim();
				locatorDescription="Click on :"+subCategoryLink;
				webElement.click();
				testStepPassed(locatorDescription);
			}else{
				testStepFailed("There is no subcategory link to click");
			}
		}catch(Exception e){
			testStepFailed("Unable to click on webelement :");
		}
		return subCategoryLink;
	}
	
	public void clickOnDepartmentMenu(String departmentName){
		clickOn(" '"+departmentName+"' category#xpath=//nav[contains(@id,'headerRow2')]//a[@role='menuitem']//span[contains(text(),'"+departmentName+"')]");
		
	}
	
	public void verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage(String pageName){
		//try{
		/*	if(!pageName.equals("Tuxedos")){
				if(driver.findElement(By.xpath("//nav[@id='widget_breadcrumb']//a[contains(text(),'Home')]")).isDisplayed()){
					if(pageName.equalsIgnoreCase(driver.findElement(By.xpath("//nav[@id='widget_breadcrumb']//li/h1")).getText())){
						testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
					}else{
						testStepFailed(pageName+" Link is not Navigated to its corresponding page");
					}
				}

			}
			else{*/
				try{
					if(driver.findElement(By.xpath("//nav[@id='widget_breadcrumb']//a[contains(text(),'Home')]")).isDisplayed()){
						if(pageName.equalsIgnoreCase("Tailored Fit Knit Shirts")){
							pageName="Knit Shirts";
						}
						if(pageName.equalsIgnoreCase("Tailored Fit")){
							pageName="Tailored Fit Dress Pants || Tailored Fit Sportshirts";
						}
						if(pageName.equalsIgnoreCase("Joseph ")){
							pageName=" NEW! Joseph Abboud Sportshirts ";
						}
						
						if(pageName.trim().equalsIgnoreCase(driver.findElement(By.xpath("//nav[@id='widget_breadcrumb']//li/h1")).getText().trim())){
							testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
						}
						else if(pageName.trim().contains(driver.findElement(By.xpath("//nav[@id='widget_breadcrumb']//li/h1")).getText().trim())){
							testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
						}else{
						
							testStepFailed(pageName+" Link is not Navigated to its corresponding page");
						}
					}
				}catch(Exception e){
					if(isElementDisplayed(grd_TuxedosGrid)){
						testStepPassed(pageName+" Link Successfully Navigated to its corresponding page");
					}else{
						testStepFailed(pageName+" Link is not Navigated to its corresponding page");
					}
				}
				
			//}
		//}catch(Exception e){
			//testStepFailed("Exception occured in 'verifyDepartmentOrCategoryOrSubCategoryLinkNavigatedPage Fails as: '"+ e.toString());
		//}


	}
}
