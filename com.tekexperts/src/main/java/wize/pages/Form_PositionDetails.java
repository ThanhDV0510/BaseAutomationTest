package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_PositionDetails extends WebActions {

	public Form_PositionDetails(WebDriver driver) {
		super(driver);
     }
	
	By lblPositionDetails = By.id("label-position-detail");
	
	By iconEdit = By.id("btn-edit-position");
	By iconDelete = By.id("btn-delete-position");
	By iconX = By.id("btn-close-detail");
	
	public boolean isLblPositionDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPositionDetails).size() > 0) {
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
		click(iconEdit);
		sleep(3);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
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
