package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_Add_Update_Growth_Optimization_GoalLine extends WebActions {

	public Form_Add_Update_Growth_Optimization_GoalLine(WebDriver driver) {
		super(driver);
     }

	By lblCreateGoalLine = By.xpath("//h4[contains(.,'Create Goal')]");
	By lblGoalName = By.xpath("//label[contains(.,'Goal Name *')]");
	By txtGoalName= By.id("txtGoalName");
	By txtDuration=By.xpath("(//span[contains(@unselectable,'on')])[41]");
	By txtTarget=By.xpath("(//span[@unselectable='on'])[43]");
	By cboFormat=By.xpath("(//span[contains(@class,'k-input')])[9]");
	By cboMetrics=By.xpath("(//span[@unselectable='on'])[52]");
	By msgCreateGoal=By.xpath("//div[@class='alert-text']");
	By firstItemFormat=By.xpath("(//li[contains(.,'Number')])[1]");
	By firstItemMetrics=By.xpath("(//span[@class='overflow-text'])[1]");
	By btnSave=By.xpath("//button[@title='Save as Draft']");
	By btnCancel=By.xpath("(//button[contains(.,'Cancel')])[3]");
	By btnSaveCreateNew=By.xpath("//button[contains(.,'Save & Create New')]");
	By btnClose=By.xpath("(//i[@class='icon icon-cross2'])[4]");
	By FinancialType=By.xpath("(//span[contains(@class,'custom-control-label')])[1]");
	By checkList=By.xpath("//input[@placeholder='Enter task description here']");
	By cldGoalEndDate=By.xpath("(//span[contains(@class,'k-icon k-i-calendar')])[5]");
	By Today=By.xpath("(//a[@tabindex='-1'][contains(.,'6')])[1]");
	By txtGoalName_Mandatory=By.xpath("//span[@id='txtGoalName_validationMessage']");
	By txtDuration_Mandatory=By.xpath("//span[@id='txtGoalName_validationMessage']");
	By GoalEndDate_Mandatory=By.xpath("//span[@id='txtGoalEndDate_validationMessage']");
	By CheckList_Mandatory=By.xpath("//input[@placeholder='Enter task description here']");
	By WeightPoint=By.xpath("//input[@name='weigPointf96c4a49-31f1-45c3-9b7a-ece83fc08ccf']");
	
	public boolean isGoalNameMandatoryDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, txtGoalName_Mandatory);
			if ( driver.findElement(txtGoalName_Mandatory).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isDurationMandatoryDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, txtDuration_Mandatory);
			if ( driver.findElement(txtDuration_Mandatory).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isGoalEndDateMandatoryDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, GoalEndDate_Mandatory);
			if ( driver.findElement(GoalEndDate_Mandatory).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isCheckListMandatoryDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, CheckList_Mandatory);
			if ( driver.findElement(CheckList_Mandatory).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLblCreateGoalLineDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblCreateGoalLine);
			if ( driver.findElement(lblCreateGoalLine).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isLblGoalNameDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblGoalName);
			if ( driver.findElement(lblGoalName).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void fillGoalName(String description)
	{
		waitFluentWait(txtGoalName);
		ClickElementAndType(txtGoalName, description + TienIch.taoRandomSo(5));
		sleep(3);
	}
	public void fillCheckList(String txtcheckList)
	{
		waitFluentWait(checkList);
		ClickElementAndType(checkList, txtcheckList + TienIch.taoRandomSo(5));
		sleep(3);
	}
	public void fillDuration()
	{
		waitFluentWait(txtDuration);
		click(txtDuration);
		sleep(3);
	}
	public void fillTarget()
	{
		waitFluentWait(txtTarget);
		click(txtTarget);
		sleep(3);
	}
	public void fillCldGoalEndDate()
	{
		waitFluentWait(cldGoalEndDate);
		click(cldGoalEndDate);
		sleep(3);
		waitFluentWait(Today);
		click(Today);
		sleep(3);
	}
	public boolean isMsgCreateGoalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgCreateGoal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectCboFormat()
	{
		waitFluentWait(cboFormat);
		clickByJavaScript(cboFormat);
		waitFluentWait(firstItemFormat);
		click(firstItemFormat);
		sleep(0.25);
	}
	
	public void selectCboMetrics()

	{
		waitFluentWait(cboMetrics);
		clickByJavaScript(cboMetrics);
		waitFluentWait(firstItemMetrics);
		click(firstItemMetrics);
		sleep(0.25);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	public void clickBtnSaveCreateNew()
	{
		waitFluentWait(btnSaveCreateNew);
		click(btnSaveCreateNew);
	}
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	public void clickFinancialType()
	{
		waitFluentWait(FinancialType);
		clickByJavaScript(FinancialType);
	}
	public void createGoalLine(String description)
	{
		fillGoalName(description);
		fillDuration();
		fillTarget();
		selectCboFormat();
		selectCboMetrics();
		clickBtnSave();
	}
	public void cancelGoalLine(String description)
	{
		fillGoalName(description);
		fillDuration();
		fillTarget();
		selectCboFormat();
		selectCboMetrics();
		clickBtnCancel();
	}
	
	public void createNonFinancialGoalLine(String description, String txtcheckList)
	{
		fillGoalName(description);
		fillDuration();
		fillCldGoalEndDate();
		fillCheckList(txtcheckList);
		clickBtnSave();
	}
	public void createNonFinancialGoalLine_SaveCreateNew(String description, String txtcheckList)
	{
		fillGoalName(description);
		clickFinancialType();
		fillDuration();
		fillTarget();
		fillCheckList(txtcheckList);
		clickBtnSaveCreateNew();
	}
	public void createGoalLine_SaveCreateNew(String description)
	{
		fillGoalName(description);
		fillDuration();
		fillTarget();
		selectCboFormat();
		selectCboMetrics();
		clickBtnSaveCreateNew();
	}
}
