package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AssessmentLibrary extends WebActions {

	public AssessmentLibrary(WebDriver driver) {
		super(driver);
     }
	
	By txtSearch = By.id("testLibrarySearch");
	By itemSearchFirst = By.xpath("//ul[@id='testLibrarySearch_listbox']/li[1]");
	By iconSearch = By.id("btnSearchLibrary");
	By btnFilter = By.id("btn-advance-filter");
	
	public void fillTxtSearchTest(String search)
	{
		waitFluentWait(txtSearch);
		ClickElementAndType(txtSearch, search);
		waitFluentWait(itemSearchFirst);
		click(itemSearchFirst);	
		waitFluentWait(iconSearch);
		click(iconSearch);	
	}
	
	public void clickBtnFilter()
	{
		waitFluentWait(btnFilter);
		click(btnFilter);	
		sleep(3);
	}
	
	By btnLetBegin = By.xpath("//a[@class='btn btn-primary']");
	By itemFirst = By.xpath("(//div[@id='listViewTestLibrary']//div)[1]");
	
	public void hoverOnAssessment()
	{
		waitFluentWait(itemFirst);
		moveHoverElement(driver.findElement(itemFirst));	
	}
	
	public boolean isItemTestFirstDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirst).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnLetBeginDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnLetBegin).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickItemFirst()
	{
		waitFluentWait(itemFirst);
		click(itemFirst);		
	}
	
	public void clickBtnLetBegin()
	{
		waitFluentWait(btnLetBegin);
		click(btnLetBegin);		
	}
	
	// Filterpopup
	
	By lblFilter = By.xpath("//h4[contains(.,'Filter')]");
	
	public boolean isLblFilterDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblFilter).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtName = By.id("txtAdvFilterName");
	
	public void fillTxtName(String name)
	{
		waitFluentWait(txtName);
		ClickElementAndType(txtName, name);
	}
	
	By txtDescription = By.id("txtAdvFilterDes");
	
	public void fillTxtDescription(String description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, description);
	}
	
	By txtCategory = By.id("cmbAdvFilterCategory_taglist");
	By itemCategory1 = By.xpath("//ul[@id='cmbAdvFilterCategory_listbox']/li[1]");
	By itemCategory2 = By.xpath("//ul[@id='cmbAdvFilterCategory_listbox']/li[2]");
	By iconXCategory = By.xpath("//ul[@id='cmbAdvFilterCategory_taglist']//span[2]//span");
	
	public boolean isIconXCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconXCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillTxtCategory(String category)
	{
		waitFluentWait(txtCategory);
		ClickElementAndType(txtCategory, category);
		clickItemCategory1();
		sleep(2);
	}
	
	public void fillTxtCategory2(String category)
	{
		waitFluentWait(txtCategory);
		ClickElementAndType(txtCategory, category);
		clickItemCategory2();
		sleep(2);
	}
	
	public void clickTxtCategory()
	{
		waitFluentWait(txtCategory);
		click(txtCategory);		
	}
	
	public void clickItemCategory1()
	{
		waitFluentWait(itemCategory1);
		click(itemCategory1);		
	}
	
	public void clickItemCategory2()
	{
		waitFluentWait(itemCategory2);
		click(itemCategory2);		
	}
	
	By txtOwner = By.id("txtAdvFilterOwner_taglist");
	By itemOwnerFirst = By.xpath("//ul[@id='txtAdvFilterOwner_listbox']/li[1]");
	
	public void fillTxtOnwer(String owner)
	{
		waitFluentWait(txtOwner);
		ClickElementAndType(txtOwner, owner);
		clickItemOwnerFirst();
	}

	public void clickItemOwnerFirst()
	{
		waitFluentWait(itemOwnerFirst);
		click(itemOwnerFirst);		
	}
	
	By txtSkill = By.id("txtAdvFilterSkillCompetency_taglist");
	By lblSkill = By.xpath("//ul[@id='txtAdvFilterSkillCompetency_listbox']/li[1]");
	By btnRadio1 = By.xpath("(//input[@name='radio47'])[1]");
	By btnRadio2 = By.xpath("(//input[@name='radio47'])[2]");
	By btnRadio3 = By.xpath("(//input[@name='radio47'])[3]");
	By btnRadio4 = By.xpath("(//input[@name='radio47'])[4]");
	By btnRadio5 = By.xpath("(//input[@name='radio47'])[5]");
	
	public void fillTxtSkill(String skill)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skill);
	}
	
	public void clickBtnRadio1()
	{
		moveHoverElement(driver.findElement(lblSkill));
		waitFluentWait(btnRadio1);
		click(btnRadio1);		
	}
	
	public void clickBtnRadio2()
	{
		moveHoverElement(driver.findElement(lblSkill));
		waitFluentWait(btnRadio2);
		click(btnRadio2);		
	}
	
	public void clickBtnRadio3()
	{
		moveHoverElement(driver.findElement(lblSkill));
		waitFluentWait(btnRadio3);
		click(btnRadio3);		
	}
	
	public void clickBtnRadio4()
	{
		moveHoverElement(driver.findElement(lblSkill));
		waitFluentWait(btnRadio4);
		click(btnRadio4);		
	}
	
	public void clickBtnRadio5()
	{
		moveHoverElement(driver.findElement(lblSkill));
		waitFluentWait(btnRadio5);
		click(btnRadio5);		
	}
	
	By cboxAdaptiveTest = By.id("rdoAdvTypeAdaptive");
	By cboxComplianceTest = By.id("rdoAdvTypeCompliance");
	By cboxSkillTest = By.id("rdoAdvTypeSkill");
	
	public void clickCboxAdaptiveTest()
	{
		waitFluentWait(cboxAdaptiveTest);
		click(cboxAdaptiveTest);		
	}
	
	public void clickCboxComplianceTest()
	{
		waitFluentWait(cboxComplianceTest);
		click(cboxComplianceTest);		
	}	
	
	public void clickCboxSkillTest()
	{
		waitFluentWait(cboxSkillTest);
		click(cboxSkillTest);		
	}
	
	By cboxPublic = By.id("rdoAdvStatusPublic");
	By cboxApprovalRequested = By.id("rdoAdvStatusApproval");
	
	public void clickCboxPublic()
	{
		waitFluentWait(cboxPublic);
		click(cboxPublic);		
	}
	
	public void clickCboxApprovalRequested()
	{
		waitFluentWait(cboxApprovalRequested);
		click(cboxApprovalRequested);		
	}	
	
	By btnReset = By.xpath("//div[@id='create-filter']//div[3]/button[1]");
	By btnAplly = By.xpath("//div[@id='create-filter']//div[3]/button[2]");
	By iconX = By.xpath("//div[@id='create-filter']//button[@title='Close']");
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
		sleep(3);
	}
	
	public void clickBtnReset()
	{
		waitFluentWait(btnReset);
		click(btnReset);		
	}
	
	public void clickBtnAplly()
	{
		waitFluentWait(btnAplly);
		click(btnAplly);
		sleep(3);
	}
	
	By lblCompleted = By.xpath("(//span[contains(.,'Completed')])[1]");
	By lblPaused = By.xpath("(//span[contains(.,'Paused')])[1]");
	By btnViewResult = By.xpath("//a[contains(.,'View result')]");
	By btnResume = By.xpath("//a[contains(.,'Resume')]");
	
	public boolean isLblPausedDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPaused).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnResumeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnResume).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnResume()
	{
		waitFluentWait(btnResume);
		click(btnResume);		
	}
	
	public void hoverOnLblPaused()
	{
		waitFluentWait(lblPaused);
		moveHoverElement(driver.findElement(lblPaused));
	}
	
	public boolean isLblCompletedDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCompleted).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnViewResultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnViewResult).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void hoverOnLblCompleted()
	{
		waitFluentWait(lblCompleted);
		moveHoverElement(driver.findElement(lblCompleted));
	}
	
	By btnRequestForApproval=By.xpath("//button[contains(.,'Request for Approval')]");
		
	public boolean isBtnRequestForApprovalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnRequestForApproval).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnRequestForApproval()
	{
		waitFluentWait(btnRequestForApproval);
		click(btnRequestForApproval);		
	}
}
