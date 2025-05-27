package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Ulties.DataManager;
import Ulties.TienIch;
import controller.WebActions;

public class Form_Create_DimensionGoalLine extends WebActions{
	public Form_Create_DimensionGoalLine(WebDriver driver) {
		super(driver);
	}

	By titleCreate = By.xpath("//div[@id='create-goal']//h4[@class='section-title']");
	By btnCancelCreate = By.xpath("//div[@id='create-goal']//button[@title='Cancel all unsaved changes']");
	By btnCloseCreate = By.xpath("//div[@class='section-header']//button[@data-bind='click: addGoalLineVM.closeForm']");
	By btnSave = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By btnSaveAndCreateNew = By.xpath("(//button[@class='btn btn-light'])[4]");
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
	By btnNextMonth = By.xpath("(//a[@role='button'][@aria-label='Next'])[1]");
	By endDate = By.xpath("//a[@data-value='2020/11/16']");
	By txtChecklist = By.xpath("//input[@placeholder='Enter task description here']");
	By radioAfter = By.xpath("//input[@name='endType'][@value='2']");
	By radioNever = By.xpath("//input[@name='endType'][@value='1']");
	By radioON = By.xpath("//input[@name='endType'][@value='3']");
	By calOnDate = By.xpath("//span[@aria-controls='txtRepeatEndDate_dateview']/span");
	By btnNextMonthON = By.xpath("(//a[@role='button'][@aria-label='Next'])[2]");
	By drlRepeatEvery = By.xpath("//span[@aria-owns='ddlRepeatType_listbox']");
	By yearRepeat = By.xpath("//ul[@id='ddlRepeatType_listbox']/li[3]");
	By endDateON = By.xpath("(//a[@data-value='2020/11/16'])[2]");
	
	public boolean isTitleCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleCreate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCancelCreate(){
		waitFluentWait(btnCancelCreate);
		click(btnCancelCreate);
	}
	
	public void clickBtnCloseCreate(){
		waitFluentWait(btnCloseCreate);
		click(btnCloseCreate);
	}
	
	public void clickBtnSaveCreate(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnSaveAndCreate(){
		waitFluentWait(btnSaveAndCreateNew);
		click(btnSaveAndCreateNew);
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
	
	public void selectRepeatEveryYear(){
		waitFluentWait(drlRepeatEvery);
		click(drlRepeatEvery);
		waitFluentWait(yearRepeat);
		click(yearRepeat);
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
	
	public void createFinancialType(String goalName){
		fillGoalName(goalName);
		switchToFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveCreate();
	}
	
	public void createNonFinancialType(){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4));
		switchToNonFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveCreate();
	}
	
	public void createFinancialTypeAndCreateNew(){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4));
		switchToFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveAndCreate();
	}
	
	public void createNonFinancialTypeAndCreateNew(){
		fillGoalName(DataManager.Test + TienIch.taoRandomSo(4));
		switchToNonFinancialType();
		fillDuration();
		fillTarget();
		selectFormat();
		selectMetrics();
		clickBtnSaveAndCreate();
	}
	
	public void sendKeysINTByJS(WebDriver driver, int attributeValue){
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].setAttribute('value','"+attributeValue+"');", driver.findElement(txtDuration));
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
	
	public void clickRadioNever(){
		waitFluentWait(radioNever);
		click(radioNever);
	}
	
	public void clickRadioAfter(){
		waitFluentWait(radioAfter);
		click(radioAfter);
	}
	
	public void clickRadioON(){
		waitFluentWait(radioON);
		click(radioON);
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
	
	public boolean isEndDateONDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(endDateON).size() > 0) {
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
	
	public void setCalendarONDate(){
		sleep(1.5);
		waitFluentWait(calOnDate);
		click(calOnDate);
		while(!isEndDateONDisplayed()){
			waitFluentWait(btnNextMonthON);
			click(btnNextMonthON);
		}
		waitFluentWait(endDateON);
		click(endDateON);
	}
	
	public void fillChecklist(String desc){
		waitFluentWait(txtChecklist);
		goTextOnNoEnter(txtChecklist, desc);
	}
	
	By msgGoalName = By.xpath("//span[@id='txtGoalName_validationMessage']");
	By msgDuration = By.xpath("//span[@id='txtDuration_validationMessage']");
	By msgTarget = By.xpath("//span[@id='txtTarget_validationMessage']");
	By msgFormat = By.xpath("//span[@id='ddlFormat_validationMessage']");
	By msgMetrics = By.xpath("//span[@id='ddlMetric_validationMessage']");
	By msgStartDate = By.xpath("//span[@id='txtGoalStartDate_validationMessage']");
	By msgEndDate = By.xpath("//span[@id='txtGoalEndDate_validationMessage']");
	By msgChecklist = By.xpath("//span[contains(@id,'checkList')]");
	By msgWeightPoint = By.xpath("//span[contains(@id,'weigPoint')]");
	
	public boolean validateGoalName(){
		boolean flag = false;
		try {
			if(driver.findElements(msgGoalName).size() > 0 && driver.findElement(msgGoalName).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateDuration(){
		boolean flag = false;
		try {
			if(driver.findElements(msgDuration).size() > 0 && driver.findElement(msgDuration).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateTarget(){
		boolean flag = false;
		try {
			if(driver.findElements(msgTarget).size() > 0 && driver.findElement(msgTarget).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateFormat(){
		boolean flag = false;
		try {
			if(driver.findElements(msgFormat).size() > 0 && driver.findElement(msgFormat).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateMetrics(){
		boolean flag = false;
		try {
			if(driver.findElements(msgMetrics).size() > 0 && driver.findElement(msgMetrics).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateStartDate(){
		boolean flag = false;
		try {
			if(driver.findElements(msgStartDate).size() > 0 && driver.findElement(msgStartDate).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateEndDate(){
		boolean flag = false;
		try {
			if(driver.findElements(msgEndDate).size() > 0 && driver.findElement(msgEndDate).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateChecklist(){
		boolean flag = false;
		try {
			if(driver.findElements(msgChecklist).size() > 0 && driver.findElement(msgChecklist).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean validateWeightPoint(){
		boolean flag = false;
		try {
			if(driver.findElements(msgWeightPoint).size() > 0 && driver.findElement(msgWeightPoint).getText().equals("Mandatory field.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
