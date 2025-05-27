package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AttendeeList_TestSchedule extends WebActions {

	public AttendeeList_TestSchedule(WebDriver driver) {
		super(driver);
     }

	By lblAttendeeList = By.xpath("(//div[@id='assessement-trainee-schedule']//h4)[2]");
	
	public boolean isLblAttendeeListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAttendeeList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconX = By.xpath("(//div[@id='assessement-trainee-schedule']//i)[1]");
	By btnAssignmentUser = By.xpath("//div[@id='assessement-trainee-schedule']//button[@title='Assignment user']");
	By btnDeleteAll = By.xpath("//div[@id='assessement-trainee-schedule']//button[@title='Delete all selected user']");
	By cboxAll = By.xpath("//div[@id='assessement-trainee-schedule']//th//label");
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}

	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public boolean isBtnAssignmentUserDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAssignmentUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAssignmentUser()
	{
		waitFluentWait(btnAssignmentUser);
		click(btnAssignmentUser);
		sleep(3);
	}
	
	public boolean isBtnDeleteAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
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
		click(btnYes);
	}
		
	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}

}
