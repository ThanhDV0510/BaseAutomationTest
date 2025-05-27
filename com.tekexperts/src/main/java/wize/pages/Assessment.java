package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Assessment extends WebActions {

	public Assessment(WebDriver driver) {
		super(driver);
     }
	
	By lblAssessment = By.xpath("(//div[@id='main']//li)[2]"); 
	
	public boolean isLblAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By lblCategory = By.xpath("//div[@id='categoryPage']//h6");
	By lblAssessmentDetail = By.xpath("//div[@id='testSetting-viewmodel']//h3");
	
	public boolean isLblCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblAssessmentDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssessmentDetail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCreateCategory = By.id("createCategory");
	By txtSearchCategory = By.id("searchText");
	By firstCategory = By.xpath("(//section[@id='testCategory-screen']//td)[1]");
	By iconEditCategory = By.id("action-edit");
	By iconDeleteCategory = By.id("action-delete");
	By iconDots = By.xpath("(//div[@id='testCategory-list-grid']/div[2]//i)[1]");
	By iconRemoveCategory = By.xpath("(//section[@id='testCategory-screen']/div[2]//span[1]/span)[1]");
	By iconSearch = By.xpath("(//section[@id='testCategory-screen']/div[2]//i)[1]");
		
	public boolean isIconEditCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconDeleteCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconRemoveCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		waitFluentWait(iconRemoveCategory);
		click(iconRemoveCategory);
	}
		
	public void clickBtnCreateCategory()
	{
		waitFluentWait(btnCreateCategory);
		click(btnCreateCategory);
		sleep(2);
	}
	
	public boolean isIconDotDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(iconDots).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickIconEditCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconEditCategory);
		click(iconEditCategory);
	}
	
	public void clickIconDeleteCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconDeleteCategory);
		click(iconDeleteCategory);
	}
	

	public void hoverCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
	}
	
	public void fillSearchCategory(String searchcategory)
	{
		waitFluentWait(txtSearchCategory);
		goTextOn(txtSearchCategory, searchcategory);
		click(iconSearch);
	}
	
	public void clickFirstCategory()
	{
		waitFluentWait(firstCategory);
		click(firstCategory);
	}
	
	public void selectCategory(String searchcategory)
	{
		fillSearchCategory(searchcategory);
		clickFirstCategory();
	}
	
	public boolean isFirstCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Create Category popup
	
	By lblCreateCategory = By.xpath("//div[@id='testCategory-create-box']//h4");
	By txtCategoryName = By.id("CreateName");
	By btnSaveCreate = By.id("saveTestCategory");
	
	public boolean isLblCreateCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblCreateCategory()
	{
		waitFluentWait(lblCreateCategory);
		click(lblCreateCategory);
	}
	
	
	public void clickBtnSaveCreate()
	{
		waitFluentWait(btnSaveCreate);
		click(btnSaveCreate);
	}
	
	public void fillCategoryName(String categoryname)
	{
		waitFluentWait(txtCategoryName);
		ClickElementAndType(txtCategoryName, categoryname);
	}
	
	//Edit Category Popup
	By lblEditCategory = By.xpath("//div[@id='testCategoryEditModal']//h4");
	By txtUpdateCategoryName = By.id("EditName");
	By btnSaveUpdateCategory = By.xpath("//div[@id='testCategoryEditModal']//button[@id='saveTestCategory']");
	By btnCancelUpdateCategory = By.xpath("//div[@id='testCategoryEditModal']//button[@id='cancelTestCategory']");		
			
	public void fillUpdateCategoryName(String Updatecategoryname)
	{
		waitFluentWait(txtUpdateCategoryName);
		ClickElementAndType(txtUpdateCategoryName, Updatecategoryname);
	}
		
	public boolean isLblEditCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditCategory).size() > 0) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
				return flag;
	}
		
	public void clickBtnSaveUpdateCategory()
	{
		sleep(1);
		waitFluentWait(btnSaveUpdateCategory);
		click(btnSaveUpdateCategory);
	}
	
	public void clickBtnCancelUpdateCategory()
	{
		sleep(1);
		waitFluentWait(btnCancelUpdateCategory);
		click(btnCancelUpdateCategory);
	}
	
	//Button Create Assessment
	
	By btnCreateAssessment = By.xpath("(//div[@id='testSetting-viewmodel']//a/i[@class='icon icon-plus3'])[2]");
	By itemAdaptiveTest = By.xpath("(//div[@id='testSetting-viewmodel']//div/a)[5]");
	By itemComplianceTest = By.xpath("(//div[@id='testSetting-viewmodel']//div/a)[6]");
	By itemSkillTest = By.xpath("(//div[@id='testSetting-viewmodel']//div/a)[7]");

	public boolean isBtnCreateAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateAssessmentEnabled()
	{
		boolean flag = true;
		try {
			if (driver.findElement(btnCreateAssessment).isEnabled()) {
				flag = false;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnCreateAssessment()
	{
		waitFluentWait(btnCreateAssessment);
		click(btnCreateAssessment);
	}
	
	public void clickItemAdaptiveTest()
	{
		waitFluentWait(itemAdaptiveTest);
		click(itemAdaptiveTest);
	}
		
	public void clickItemComplianceTest()
	{
		waitFluentWait(itemComplianceTest);
		click(itemComplianceTest);
	}

	public void clickItemSkillTest()
	{
		waitFluentWait(itemSkillTest);
		click(itemSkillTest);
	}
	
	By btnDeletaAll = By.xpath("//button[@title='Delete all selected assessments']");

	public boolean isBtnDeletaAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeletaAll).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
	
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeletaAll);
		click(btnDeletaAll);
	}
	
	By cboxAll = By.xpath("//div[@id='testSetting-viewmodel']//th/label");
	By cboxSingle = By.xpath("(//div[@id='testSetting-viewmodel']//td/label)[1]");
	
	public boolean isCboxSingleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(cboxSingle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isCboxSingleClickable(){
		boolean flag = isWebElementClickable(cboxSingle);
		return flag;
	}
	
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public void clickCboxSingle()
	{
		waitFluentWait(cboxSingle);
		click(cboxSingle);
	}
	
	By iconDeleteFirstItem = By.xpath("(//div[@id='test-setting-grid']//a[@title='Delete'])[1]");
	By iconEditFirstItem = By.xpath("(//div[@id='test-setting-grid']//a[@title='Edit'])[1]");
	By iconScheduleFirstItem = By.xpath("(//div[@id='test-setting-grid']//a[@title='Schedule'])[1]");
	By iconAttendeeFirstItem = By.xpath("(//div[@id='test-setting-grid']//a[@title='Attendee list'])[1]");
	By iconDotsFirst = By.xpath("//div[@id='testSetting-viewmodel']//td[11]");
	By searchName = By.xpath("(//div[@id='testSetting-viewmodel']//tr[2]//input)[1]");
	
	public void searchName(String name)
	{
		waitFluentWait(searchName);
		goTextOn(searchName, name);
		sleep(2);
	}
	
	public boolean isIconAttendeeFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconAttendeeFirstItem).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
	
	public void clickIconAttendeeFirstItem()
	{
		moveHoverElement(driver.findElement(iconDotsFirst));
		waitFluentWait(iconAttendeeFirstItem);
		click(iconAttendeeFirstItem);
	}
	
	public void hoverOnFirstAssessment(){
		moveHoverElement(driver.findElement(iconDotsFirst));
	}
	
	public boolean isIconDeleteFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteFirstItem).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
	
	public boolean isIconEditFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditFirstItem).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
	
	public boolean isIconScheduleFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconScheduleFirstItem).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
	
	public void clickIconDeleteFirstItem()
	{
		moveHoverElement(driver.findElement(iconDotsFirst));
		waitFluentWait(iconDeleteFirstItem);
		click(iconDeleteFirstItem);
	}
	
	public void clickIconEditFirstItem()
	{
		moveHoverElement(driver.findElement(iconDotsFirst));
		waitFluentWait(iconEditFirstItem);
		click(iconEditFirstItem);
	}
	
	public void clickIconScheduleFirstItem()
	{
		moveHoverElement(driver.findElement(iconDotsFirst));
		waitFluentWait(iconScheduleFirstItem);
		click(iconScheduleFirstItem);
	}
	
	//Popup Confirm Delete
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
	By btnYes2nd = By.xpath("(//button[contains(.,'YES')])[2]");
	By btnNo = By.xpath("//button[contains(.,'NO')]");
	
	public boolean isLblConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblConfirmation).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
		
	public void clickBtnYes()
	{
		waitFluentWait(btnYes);
		click(btnYes);
	}
	
	public void clickBtnYes2nd()
	{
		waitFluentWait(btnYes2nd);
		click(btnYes2nd);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}

	public void deleteAll()
	{
		clickBtnDeleteAll();
		clickBtnYes();
	}
		
	public void deleteSignle()
	{
		clickIconDeleteFirstItem();
		sleep(3);
		clickBtnYes();
	}
	
	public void deleteSingle2nd()
	{
		clickIconDeleteFirstItem();
		sleep(3);
		clickBtnYes2nd();
	}
	
	public boolean isContentPopupConfirmCorrect(){
		boolean flag = false;
		try {
			if(driver.findElement(By.id("dialogDeleteTest")).getText().equals("Are you sure you want to delete the selected assessment? Please be informed that your action is irreversible.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By firstLinkAssessment = By.xpath("(//div[@id='test-setting-grid']//a[@class='text open-slide link-test-name'])[1]");
	By btnClearFilterAssessmentName = By.xpath("//span[@data-field='title']//button[@title='Clear']");
	By btnClearFilterStatus = By.xpath("//span[@data-field='testSettingStatusCode']//span[@title='Clear']");
	By searchStatus = By.xpath("//div[@role='listbox']//input");
	public boolean isFirstLinkAssessmentDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkAssessment);
		return flag;
	}
	
	public void clickFirstLinkAssessment(){
		waitFluentWait(firstLinkAssessment);
		click(firstLinkAssessment);
	}
	
	public String getTextFirstAssessment(){
		String assessName = getTextWebElement(firstLinkAssessment);
		return assessName;
	}
	
	public void clickClearFilterAssessmentName(){
		waitFluentWait(btnClearFilterAssessmentName);
		click(btnClearFilterAssessmentName);
		sleep(1);
	}
	
	public void clickClearFilterStatus(){
		waitFluentWait(btnClearFilterStatus);
		click(btnClearFilterStatus);
		sleep(1);
	}
	
	public void filterStatus(String stt){
		waitFluentWait(searchStatus);
		goTextOn(searchStatus, stt);
		sleep(1);
	}
	
	By titleAssessmentDetail = By.xpath("//div[@id='skillTestDetail']//h4");
	By iconCloseAssessmentDetail = By.xpath("//div[@id='skillTestDetail']//button[@title='Close']");
	public boolean isTitleDetailDisplayed(){
		boolean flag = isWebElementDisplayed(titleAssessmentDetail);
		return flag;
	}
	
	public void clickCloseDetailForm(){
		waitFluentWait(iconCloseAssessmentDetail);
		click(iconCloseAssessmentDetail);
	}
	
	public String getTooltipBtnDeleteAll(){
		String tooltip = "";
		try {
			tooltip = driver.findElement(btnDeletaAll).getAttribute("title");
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
	
	public boolean isBtnDeleteAllEnable(){
		boolean flag = isWebElementClickable(btnDeletaAll);
		return flag;
	}
	
	By drpAssessmentType = By.xpath("//span[@data-field='testTypeCode']//span[@class='k-input']");
	By optionAdaptive = By.xpath("(//li[contains(.,'Adaptive')])[4]");
	By optionCompliance = By.xpath("(//li[contains(.,'Compliance')])[1]");
	By optionSkill = By.xpath("(//li[contains(.,'Skill')])[12]");
	
	public void selectTypeAdaptive(){
		waitFluentWait(drpAssessmentType);
		click(drpAssessmentType);
		waitFluentWait(optionAdaptive);
		click(optionAdaptive);
		sleep(2);
	}
	public void selectTypeCompliance(){
		waitFluentWait(drpAssessmentType);
		click(drpAssessmentType);
		waitFluentWait(optionCompliance);
		click(optionCompliance);
		sleep(2);
	}
	public void selectTypeSkill(){
		waitFluentWait(drpAssessmentType);
		click(drpAssessmentType);
		waitFluentWait(optionSkill);
		click(optionSkill);
		sleep(2);
	}
	
	public boolean isFilterAdaptiveCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[4]"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Adaptive")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isFilterComplianceCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[4]"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Compliance")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isFilterSkillCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[4]"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Skill")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnClearFilterAssessmentType = By.xpath("//span[@data-field='testTypeCode']//button[@title='Clear']");
	By btnClearFilterRestriction = By.xpath("//span[@data-field='restrictionCode']//button[@title='Clear']");
	public void clickClearFilterAssessmentType(){
		waitFluentWait(btnClearFilterAssessmentType);
		click(btnClearFilterAssessmentType);
	}
	public void clickClearFilterRestriction(){
		waitFluentWait(btnClearFilterRestriction);
		click(btnClearFilterRestriction);
	}
	
	By drpRestrictionType = By.xpath("//span[@data-field='restrictionCode']//span[@class='k-input']");
	By optionAppRequest = By.xpath("//li[contains(.,'Approval Requested')]");
	By optionManAssign = By.xpath("//li[contains(.,'Manually Assigned')]");
	By optionPublic = By.xpath("//li[contains(.,'Public')]");
	
	public void selectRestrictionAppReq(){
		waitFluentWait(drpRestrictionType);
		click(drpRestrictionType);
		waitFluentWait(optionAppRequest);
		click(optionAppRequest);
		sleep(2);
	}
	public void selectRestrictionManAssign(){
		waitFluentWait(drpRestrictionType);
		click(drpRestrictionType);
		waitFluentWait(optionManAssign);
		click(optionManAssign);
		sleep(2);
	}
	public void selectRestrictionPublic(){
		waitFluentWait(drpRestrictionType);
		click(drpRestrictionType);
		waitFluentWait(optionPublic);
		click(optionPublic);
		sleep(2);
	}
	public boolean isFilterAppRequestCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[5]/span"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Approval Requested")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isFilterManAssignCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[5]/span"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Manually Assigned")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isFilterPublicCorrect(){
		boolean flag = false;
		try {
			List<WebElement> list = driver.findElements(By.xpath("//td[5]/span"));
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getText().equals("Public")){
					break;
				}else{
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By versionFilter = By.xpath("(//span[@data-field='isLatest']//span[1])[5]");
	By optionAllVersion = By.xpath("//span[contains(.,'All Version')]");
	By optionCurrentVersion = By.xpath("//li[contains(.,'Current Version')]");
	public void selectOptionAllVersion(){
		waitFluentWait(versionFilter);
		click(versionFilter);
		waitFluentWait(optionAllVersion);
		click(optionAllVersion);
		sleep(2);
	}
	
	public void selectOptionCurrentVersion(){
		waitFluentWait(versionFilter);
		click(versionFilter);
		waitFluentWait(optionCurrentVersion);
		click(optionCurrentVersion);
		sleep(2);
	}
	public String getTooltipVersionFilter(){
		String tooltip = "";
		try {
			tooltip = driver.findElement(versionFilter).getAttribute("title");
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
}
