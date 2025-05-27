package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_JobLevelDetails extends WebActions {

	public Form_JobLevelDetails(WebDriver driver) {
		super(driver);
     }
	
	By lblJobLevelDetails = By.id("label-detail-job-level");
	By iconEdit = By.id("btn-edit-job-level");
	By iconDelete = By.id("btn-delete-job-level");
	By iconX = By.id("btn-close-detail");
	
	public boolean isLblJobLevelDetailssDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJobLevelDetails).size() > 0) {
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
