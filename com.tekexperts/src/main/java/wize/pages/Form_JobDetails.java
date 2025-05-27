package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_JobDetails extends WebActions {

	public Form_JobDetails(WebDriver driver) {
		super(driver);
     }
	
	By lblJobDetails = By.id("label-job-detail");
	By iconEdit = By.id("btn-edit-job");
	By iconDelete = By.id("btn-delete-job");
	By iconX = By.id("btn-close-detail");
	
	public boolean isLblJobDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJobDetails).size() > 0) {
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
		clickByJavaScript(iconEdit);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		clickByJavaScript(iconX);
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		clickByJavaScript(iconDelete);
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
