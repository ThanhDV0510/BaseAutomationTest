package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_FunctionSetDetails extends WebActions {

	public Form_FunctionSetDetails(WebDriver driver) {
		super(driver);
     }

	By lblFunctionSetDetails = By.id("label-detail-function-set");
		
	public boolean isLblFunctionSetDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblFunctionSetDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Tab
	By tabDashBoard = By.xpath("(//ul[@id='moduleList']/li//a)[1]");
	By tabAssessment = By.xpath("(//ul[@id='moduleList']/li//a)[2]");
	By tabTalentManagement = By.xpath("(//ul[@id='moduleList']/li//a)[3]");
	By tabSystemSettings = By.xpath("(//ul[@id='moduleList']/li//a)[4]");
	By tabMySpace = By.xpath("(//ul[@id='moduleList']/li//a)[5]");
	
	public void clickTabDashBoard()
	{
		waitFluentWait(tabDashBoard);
		click(tabDashBoard);
	}
	
	public void clickTabAssessment()
	{
		waitFluentWait(tabAssessment);
		click(tabAssessment);
	}
	
	public void clickTabTalentManagement()
	{
		waitFluentWait(tabTalentManagement);
		click(tabTalentManagement);
	}
	
	public void clickTabSystemSettings()
	{
		waitFluentWait(tabSystemSettings);
		click(tabSystemSettings);
	}
	
	public void clickTabMySpace()
	{
		waitFluentWait(tabMySpace);
		click(tabMySpace);
	}
	
	//Check Box
	By cboxFullPermission = By.id("fullPermission");
	By cboxViewOnly = By.id("viewOnly");
	By cboxCustomization = By.id("customization");
	
	public void clickCboxFullPermission()
	{
		waitFluentWait(cboxFullPermission);
		click(cboxFullPermission);
	}
	
	public void clickCboxViewOnly()
	{
		waitFluentWait(cboxViewOnly);
		click(cboxViewOnly);
	}
	
	public void clickCboxCustomization()
	{
		waitFluentWait(cboxCustomization);
		click(cboxCustomization);
	}
	
	By cboxSubFullPermission = By.id("subFullPermission");

	public void clickCboxSubFullPermission()
	{
		waitFluentWait(cboxSubFullPermission);
		click(cboxSubFullPermission);
	}
	
	By subTabQuestionPool = By.xpath("(//ul[@id='subModuleList']/li//a)[1]");
		
	public void clickSubTabQuestionPool()
	{
		waitFluentWait(subTabQuestionPool);
		click(subTabQuestionPool);
	}
	
	By subTabAssessmentSettings = By.xpath("(//ul[@id='subModuleList']/li//a)[2]");

	public void clickSubTabAssessmentSettings()
	{
		waitFluentWait(subTabAssessmentSettings);
		click(subTabAssessmentSettings);
	}
	
	By subTabAssessmentLearner = By.xpath("(//ul[@id='subModuleList']/li//a)[3]");
	
	public void clickSubTabAssessmentLearner()
	{
		waitFluentWait(subTabAssessmentLearner);
		click(subTabAssessmentLearner);
	}
	
	By subTabTalentJobLevel = By.xpath("(//ul[@id='subModuleList']/li//a)[2]");
	
	public void clickSubTabTalentJobLevel()
	{
		waitFluentWait(subTabTalentJobLevel);
		click(subTabTalentJobLevel);
	}
	
	By subTabTalentPosition = By.xpath("(//ul[@id='subModuleList']/li//a)[3]");

	public void clickSubTabTalentPosition()
	{
		waitFluentWait(subTabTalentPosition);
		click(subTabTalentPosition);
	}
	
	By subTabTalentBaseline = By.xpath("(//ul[@id='subModuleList']/li//a)[4]");
	
	public void clickSubTabTalentBaseline()
	{
		waitFluentWait(subTabTalentBaseline);
		click(subTabTalentBaseline);
	}
	
	By subTabOrgranization = By.xpath("(//ul[@id='subModuleList']/li//a)[1]");
	
	public void clickSubTabOrgranization()
	{
		waitFluentWait(subTabOrgranization);
		click(subTabOrgranization);
	}
	
	By subTabSkill = By.xpath("(//ul[@id='subModuleList']/li//a)[2]");
		
	public void clickSubTabSkill()
	{
		waitFluentWait(subTabSkill);
		click(subTabSkill);
	}
	
	By subTabGeneralSettings = By.xpath("(//ul[@id='subModuleList']/li//a)[3]");
	
	public void clickSubTabGeneralSettings()
	{
		waitFluentWait(subTabGeneralSettings);
		click(subTabGeneralSettings);
	}
	
	By subTabSecurityProfile = By.xpath("(//ul[@id='subModuleList']/li//a)[4]");
	
	public void clickSubTabSecurityProfile()
	{
		waitFluentWait(subTabSecurityProfile);
		click(subTabSecurityProfile);
	}
	
	By subTabRole = By.xpath("(//ul[@id='subModuleList']/li//a)[5]");
		
	public void clickSubTabRole()
	{
		waitFluentWait(subTabRole);
		click(subTabRole);
	}
	
	By subTabFunctionSet = By.xpath("(//ul[@id='subModuleList']/li//a)[6]");
		
	public void clickSubTabFunctionSet()
	{
		waitFluentWait(subTabFunctionSet);
		click(subTabFunctionSet);
	}
		
	By subTabUser = By.xpath("(//ul[@id='subModuleList']/li//a)[7]");
		
	public void clickSubTabUser()
	{
		waitFluentWait(subTabUser);
		click(subTabUser);
	}
	
	By subTabEmployeeData = By.xpath("(//ul[@id='subModuleList']/li//a)[1]");
	
	public void clickSubTabEmployeeData()
	{
		waitFluentWait(subTabEmployeeData);
		click(subTabEmployeeData);
	}
	
	By subTabTalent = By.xpath("(//ul[@id='subModuleList']/li//a)[2]");
	
	public void clickSubTabTalent()
	{
		waitFluentWait(subTabTalent);
		click(subTabTalent);
	}
	
	By subTabMyContribution = By.xpath("(//ul[@id='subModuleList']/li//a)[3]");
	
	public void clickSubTabMyContribution()
	{
		waitFluentWait(subTabMyContribution);
		click(subTabMyContribution);
	}
	
	By subTabPendingApprovals = By.xpath("(//ul[@id='subModuleList']/li//a)[4]");
	
	public void clickSubTabPendingApprovals()
	{
		waitFluentWait(subTabPendingApprovals);
		click(subTabPendingApprovals);
	}

	By iconDelete = By.id("deleteFunctionSet");
	By iconClone = By.id("detailClone");
	By iconEdit = By.id("editFunctionSet");
	By iconX = By.id("closeDetail");
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconClone()
	{
		waitFluentWait(iconClone);
		click(iconClone);
		sleep(3);
	}
	
	public boolean isIconCloneDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconClone).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(iconEdit);
		click(iconEdit);
		sleep(3);
	}
	
	public boolean isIconEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
}
