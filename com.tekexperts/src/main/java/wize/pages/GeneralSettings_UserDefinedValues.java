package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_UserDefinedValues extends WebActions {

	public GeneralSettings_UserDefinedValues(WebDriver driver) {
		super(driver);
     }
	
	By lblUserDefinedValues = By.xpath("(//section[@id='userdefinedvalue-partial-view']//h3)[1]");
		
	public boolean isLblUserDefinedValuesDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblUserDefinedValues).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By lblPersonal = By.xpath("(//section[@id='userdefinedvalue-partial-view']//h3)[2]");
	By lblContract = By.xpath("(//section[@id='userdefinedvalue-partial-view']//h3)[3]");
	By lblPosition = By.xpath("(//section[@id='userdefinedvalue-partial-view']//h3)[4]");
	By lblGoal = By.xpath("(//section[@id='userdefinedvalue-partial-view']//h3)[5]");
	
	public void clickLblPersonal()
	{
		waitFluentWait(lblPersonal);
		click(lblPersonal);
	}
	
	public void clickLblContract()
	{
		waitFluentWait(lblContract);
		click(lblContract);
	}
	
	public void clickLblPosition()
	{
		waitFluentWait(lblPosition);
		click(lblPosition);
	}
	
	public void clickLblGoal()
	{
		waitFluentWait(lblGoal);
		click(lblGoal);
	}
	
	//Personal
	By btnEditCountryofResidence = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[1]");
	By btnEditCountryofWork = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[2]");
	By btnEditDocumentType = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[3]");
	By btnEditContactRelationship = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[4]");
	By btnEditEducationLevel = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[5]");
	By btnEditEmployeeStatus = By.xpath("(//div[@id='personal-data-grid']//td[3]//span)[6]");
	
	By linkEditCountryofResidence = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[1]");
	By linkEditCountryofWork = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[2]");
	By linkEditDocumentType = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[3]");
	By linkEditContactRelationship = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[4]");
	By linkEditEducationLevel = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[5]");
	By linkEditEmployeeStatus = By.xpath("(//div[@id='personal-data-grid']//td[1]//a)[6]");

	public void clickBtnEditCountryofResidence()
	{
		moveHoverElement(driver.findElement(linkEditCountryofResidence));
		waitFluentWait(btnEditCountryofResidence);
		click(btnEditCountryofResidence);
	}
	
	public void clickBtnEditCountryofWork()
	{
		moveHoverElement(driver.findElement(linkEditCountryofWork));
		waitFluentWait(btnEditCountryofWork);
		click(btnEditCountryofWork);
	}
	
	public void clickBtnEditDocumentType()
	{
		moveHoverElement(driver.findElement(linkEditDocumentType));
		waitFluentWait(btnEditDocumentType);
		click(btnEditDocumentType);
	}
	
	public boolean isBtnEditDocumentTypeClickable(){
		moveHoverElement(driver.findElement(linkEditDocumentType));
		boolean flag = isWebElementClickable(btnEditDocumentType);
		return flag;
	}
	
	public void clickBtnEditContactRelationship()
	{
		moveHoverElement(driver.findElement(linkEditContactRelationship));
		waitFluentWait(btnEditContactRelationship);
		click(btnEditContactRelationship);
	}
	
	public void clickBtnEditEducationLevel()
	{
		moveHoverElement(driver.findElement(linkEditEducationLevel));
		waitFluentWait(btnEditEducationLevel);
		click(btnEditEducationLevel);
	}
	
	public void clickBtnEditEmployeeStatus()
	{
		moveHoverElement(driver.findElement(linkEditEmployeeStatus));
		waitFluentWait(btnEditEmployeeStatus);
		click(btnEditEmployeeStatus);
	}
	
	//Contract
	By btnEditContractType = By.xpath("(//div[@id='contract-data-grid']//td[3]//span)[1]");
	By linkEditContractType = By.xpath("(//div[@id='contract-data-grid']//td[1]//a)[1]");
	
	public void clickBtnEditContractType()
	{
		moveHoverElement(driver.findElement(linkEditContractType));
		waitFluentWait(btnEditContractType);
		click(btnEditContractType);
	}
	
	//Position
	By btnEditPositionStartReason = By.xpath("(//div[@id='position-data-grid']//td[3]//span)[1]");
	By btnEditReasonForLeavingTheJob = By.xpath("(//div[@id='position-data-grid']//td[3]//span)[2]");
	
	By linkEditPositionStartReason = By.xpath("(//div[@id='position-data-grid']//td[1]//a)[1]");
	By linkEditReasonForLeavingTheJob = By.xpath("(//div[@id='position-data-grid']//td[1]//a)[2]");
		
	public void clickBtnEditPositionStartReason()		
	{
		moveHoverElement(driver.findElement(linkEditPositionStartReason));
		waitFluentWait(btnEditPositionStartReason);
		click(btnEditPositionStartReason);
	}
	
	public void clickBtnEditReasonForLeavingTheJob()		
	{
		moveHoverElement(driver.findElement(linkEditReasonForLeavingTheJob));
		waitFluentWait(btnEditReasonForLeavingTheJob);
		click(btnEditReasonForLeavingTheJob);
	}
	
	//Goal
	By btnMetrics = By.xpath("(//div[@id='goal-data-grid']//td[3]//span)[1]");
	By linkMetrics = By.xpath("(//div[@id='goal-data-grid']//td[1]//a)[1]");
		
	public void clickBtnMetrics()
	{
		moveHoverElement(driver.findElement(linkMetrics));
		waitFluentWait(btnMetrics);
		click(btnMetrics);
	}
	
	//Popup Confirm Delete
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
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
		clickByJavaScript(btnYes);
	}
	
	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		clickByJavaScript(btnNo);
	}
}
