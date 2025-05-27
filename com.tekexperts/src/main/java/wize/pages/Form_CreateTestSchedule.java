package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateTestSchedule extends WebActions {

	public Form_CreateTestSchedule(WebDriver driver) {
		super(driver);
     }

	By lblCreateSchedule = By.xpath("//div[@id='create-test-schedule']//h4");
			
	public boolean isLblCreateScheduleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtScheduleName = By.xpath("(//form[@id='create-schedule-form']//input)[1]");
	By iconStartDate = By.xpath("(//form[@id='create-schedule-form']//span[@class='k-icon k-i-calendar'])[1]");
	By iconEndDate = By.xpath("(//form[@id='create-schedule-form']//span[@class='k-icon k-i-calendar'])[2]");
	By itemTodayStartDate = By.xpath("//div[@id='startDateCreate_dateview']//div[3]//a");
	By itemTodayEndDate = By.xpath("//div[@id='endDateCreate_dateview']//div[3]//a");
	By iconNextStartDate= By.xpath("//div[@id='startDateCreate_dateview']//div[1]//a[3]");
	By itemFuture = By.xpath("//div[@id='startDateCreate_dateview']//tr[6]//td[7]");
	
	public void fillScheduleName(String schedulename)
	{
		waitFluentWait(txtScheduleName);
		ClickElementAndType(txtScheduleName, schedulename);
	}
	
	public void clickIconStartDate()
	{
		waitFluentWait(iconStartDate);
		click(iconStartDate);
	}
	
	public void clickIconEndDate()
	{
		waitFluentWait(iconEndDate);
		click(iconEndDate);
	}
	
	public void clickIconNextStartDatee()
	{
		waitFluentWait(iconNextStartDate);
		click(iconNextStartDate);
	}
	
	public void clickItemFuture()
	{
		waitFluentWait(itemFuture);
		click(itemFuture);
	}
	
	public void clickItemTodayStartDate()
	{
		waitFluentWait(itemTodayStartDate);
		click(itemTodayStartDate);
	}
	
	public void setScheduleEndDate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#endDateCreate').data('kendoDatePicker'); datepicker.value(new Date(2020, 12, 31)); datepicker.trigger('change');");
//		js.executeScript("var attendee = $('#schedule-tab-grid tr.k-filter-row input[data-role='numerictextbox']').data('kendoNumericTextBox'); attendee.value(5); attendee.trigger('change');");
	}
	
	public void setScheduleStartDate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#startDateCreate').data('kendoDatePicker'); datepicker.value(new Date(2020, 12, 31)); datepicker.trigger('change');");
	}
	
	By btnSave = By.id("saveSchedule");
	By btnSavenAssign = By.id("saveAndAssignSchedule");
	By btnCancel = By.id("cancelSchedule");
	By btnCloseSlideSchedule = By.xpath("//div[@id='assessement-schedule']//button[@class='btn btn-icon close-slide']");
	
	public void clickBtnCloseSlideSchedule()
	{
		waitFluentWait(btnCloseSlideSchedule);
		click(btnCloseSlideSchedule);
		sleep(3);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnSavenAssign()
	{
		waitFluentWait(btnSavenAssign);
		click(btnSavenAssign);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}	
	
	By lblCancelled = By.xpath("//div[@id='assessment-schedule-grid']//td[5]//span");
	
	public boolean isLblCancelledDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCancelled).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
}
