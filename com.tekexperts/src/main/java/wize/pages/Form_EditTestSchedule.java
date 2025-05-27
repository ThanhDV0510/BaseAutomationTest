package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditTestSchedule extends WebActions {

	public Form_EditTestSchedule(WebDriver driver) {
		super(driver);
     }

	By lblEditSchedule = By.xpath("//div[@id='edit-test-schedule']//h4");
			
	public boolean isLblEditScheduleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtScheduleName = By.id("editScheduleName");
	By iconEndDate = By.xpath("(//form[@id='edit-schedule-form']//div[2]//div[2]//span)[3]");
	By itemTodayEndDate = By.xpath("//div[@id='editEndDate_dateview']//div[3]//a");
	
	public void fillScheduleName(String schedulename)
	{
		waitFluentWait(txtScheduleName);
		ClickElementAndType(txtScheduleName, schedulename);
	}
	
	public void clickIconEndDate()
	{
		waitFluentWait(iconEndDate);
		click(iconEndDate);
	}
	
	public void clickItemTodayEndDate()
	{
		waitFluentWait(itemTodayEndDate);
		click(itemTodayEndDate);
	}
	
	By btnSave = By.id("btnScheduleEditSave");
	By btnCancel = By.id("btnScheduleEditCancel");
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}	
}
