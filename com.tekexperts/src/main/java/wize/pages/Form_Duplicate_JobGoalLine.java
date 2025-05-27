package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.DataManager;
import Ulties.TienIch;
import controller.WebActions;

public class Form_Duplicate_JobGoalLine extends WebActions{

	public Form_Duplicate_JobGoalLine(WebDriver driver) {
		super(driver);
	}

	By titleDuplicate = By.xpath("//div[@id='create-goal']//h4[@class='section-title']");
	By btnCancelDuplicate = By.xpath("//div[@id='create-goal']//button[@title='Cancel all unsaved changes']");
	By btnCloseDuplicate = By.xpath("//div[@class='section-header']//button[@data-bind='click: addGoalLineVM.closeForm']");
	By btnSave = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By btnSaveAndDuplicate = By.xpath("(//button[@class='btn btn-light'])[5]");
	By txtGoalName = By.id("txtGoalName");
	By upDuration = By.xpath("//div[@data-bind='visible: addGoalLineVM.goalLineModel.isDuration']//span[@class='k-icon k-i-arrow-60-up']");
	By txtDuration = By.xpath("(//input[@aria-valuemax='999'])[1]");
	By upTarget = By.xpath("//div[@data-bind='visible: addGoalLineVM.goalLineModel.isFinancial']//span[@class='k-icon k-i-arrow-60-up']");
	By txtTarget = By.xpath("(//input[@aria-valuemax='999999999999'])[1]");
	By drlFormat = By.xpath("//span[@aria-owns='ddlFormat_listbox']");
	By formatNumber = By.xpath("(//ul[@id='ddlFormat_listbox']/li)[1]");
	By formatPercentage = By.xpath("(//ul[@id='ddlFormat_listbox']/li)[2]");
	By drlMetrics = By.xpath("//span[@aria-owns='ddlMetric_listbox']");
	By firstMetrics = By.xpath("(//ul[@id='ddlMetric_listbox']/li)[1]/span");
	By iconFinancialType = By.xpath("//div[@class='form-options']//label[@data-bind='attr: {title: addGoalLineVM.titleFinancial, data-title: addGoalLineVM.titleFinancial}']");
	By radioDuration = By.xpath("//input[@name='timeLimit'][@value='1']");
	By radioSpecificDates = By.xpath("//input[@name='timeLimit'][@value='2']");
	By radioRepeat = By.xpath("//input[@name='timeLimit'][@value='3']");
	By calStartDate = By.xpath("//span[@aria-controls='txtGoalStartDate_dateview']/span");
	By startDate = By.xpath("//a[@data-value='2020/5/24']");
	By calEndDate = By.xpath("//span[@aria-controls='txtGoalEndDate_dateview']/span");
	By btnNextMonth = By.xpath("(//a[@role='button'][@aria-label='Next'])");
	By endDate = By.xpath("//a[@data-value='2020/11/16']");
	By txtChecklist = By.xpath("//input[@placeholder='Enter task description here']");
	
	public boolean isTitleDuplicateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleDuplicate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCancelDuplicate(){
		waitFluentWait(btnCancelDuplicate);
		click(btnCancelDuplicate);
	}
	
	public void clickBtnCloseDuplicate(){
		waitFluentWait(btnCloseDuplicate);
		click(btnCloseDuplicate);
	}
	
	public void clickBtnSaveDuplicate(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnSaveAndDuplicate(){
		waitFluentWait(btnSaveAndDuplicate);
		click(btnSaveAndDuplicate);
	}
	
	public void fillGoalName(String name){
		waitFluentWait(txtGoalName);
		goTextOnNoEnter(txtGoalName, name);
	}
	
	public void fillDuration(){
		waitFluentWait(upDuration);
		click(upDuration);
		click(upDuration);
	}
	
	public void fillTarget(){
		waitFluentWait(txtTarget);
		click(upTarget);
		click(upTarget);
	}
	
	public void selectFormat(){
		waitFluentWait(drlFormat);
		click(drlFormat);
		waitFluentWait(formatNumber);
		click(formatNumber);
	}
	
	public void selectMetrics(){
		waitFluentWait(drlMetrics);
		click(drlMetrics);
		waitFluentWait(firstMetrics);
		click(firstMetrics);
	}
	
	public boolean isFinancialChecked(){
		boolean flag = false;
		try {
			if(driver.findElement(iconFinancialType).getAttribute("data-title").equals("Click to switch to Non-financial type")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void switchToFinancialType(){
		if(!isFinancialChecked()){
			waitFluentWait(iconFinancialType);
			click(iconFinancialType);
		}
	}
	
	public void switchToNonFinancialType(){
		if(isFinancialChecked()){
			waitFluentWait(iconFinancialType);
			click(iconFinancialType);
		}
	}
	
	public void createFinancialType(){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4));
		switchToFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveDuplicate();
	}
	
	public void createFinancialTypeWithParam(String param){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4) + param);
		switchToFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveDuplicate();
	}
	
	public void createNonFinancialType(){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4));
		switchToNonFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveDuplicate();
	}
	
	public void clickRadioDuration(){
		waitFluentWait(radioDuration);
		click(radioDuration);
	}
	
	public void clickRadioSpecificDates(){
		waitFluentWait(radioSpecificDates);
		click(radioSpecificDates);
	}
	
	public void clickRadioRepeat(){
		waitFluentWait(radioRepeat);
		click(radioRepeat);
	}
	
	public boolean isEndDateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(endDate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void setCalendarEndDate(){
		waitFluentWait(calEndDate);
		click(calEndDate);
		while(!isEndDateDisplayed()){
			waitFluentWait(btnNextMonth);
			click(btnNextMonth);
		}
		waitFluentWait(endDate);
		click(endDate);
	}
	
	public void fillChecklist(String desc){
		waitFluentWait(txtChecklist);
		goTextOnNoEnter(txtChecklist, desc);
	}
}
