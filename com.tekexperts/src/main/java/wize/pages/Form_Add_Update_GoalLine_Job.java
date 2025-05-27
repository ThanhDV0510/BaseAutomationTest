package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_Add_Update_GoalLine_Job extends WebActions {

	public Form_Add_Update_GoalLine_Job(WebDriver driver) {
		super(driver);
     }

	By lblCreateGoalLine = By.xpath("//h4[contains(.,'Create Goal')]");
	By lblGoalName = By.xpath("//label[contains(.,'Goal Name *')]");
	By txtGoalName= By.id("txtGoalName");
	By txtDuration=By.xpath("(//span[@unselectable='on'])[24]");
	By txtTarget=By.xpath("(//span[@unselectable='on'])[43]");
	By cboFormat=By.xpath("(//span[contains(@class,'k-input')])[9]");
	By cboMetrics=By.xpath("(//span[@unselectable='on'])[52]");
	By msgCreateGoal=By.xpath("//div[@class='alert-text']");
	By firstItemFormat=By.xpath("(//li[contains(.,'Number')])[1]");
	By firstItemMetrics=By.xpath("(//span[@class='overflow-text'])[1]");
	By btnSave=By.xpath("(//button[@title='Add new Goal'])[3]");
	By btnCancel=By.xpath("(//button[contains(.,'Cancel')])[3]");
	By btnSaveCreateNew=By.xpath("//button[contains(.,'Save & Create New')]");
	By btnClose=By.xpath("(//i[@class='icon icon-cross2'])[4]");
	By FinancialType=By.xpath("(//span[contains(@class,'custom-control-label')])[1]");
	By checkList=By.xpath("//input[@placeholder='Enter task description here']");
			
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
	
	public void createFinancialGoalLine(String description, String txtcheckList)
	{
		fillGoalName(description);
		clickFinancialType();
		fillDuration();
		fillTarget();
		fillCheckList(txtcheckList);
		clickBtnSave();
	}
	public void createFinancialGoalLine_SaveCreateNew(String description, String txtcheckList)
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
