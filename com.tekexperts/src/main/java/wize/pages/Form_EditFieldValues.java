package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditFieldValues extends WebActions {

	public Form_EditFieldValues(WebDriver driver) {
		super(driver);
     }
	
	By lblEditFieldValues = By.xpath("//div[@id='edit-field-values-box']//h4");
			
	public boolean isLblEditFieldValuesDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditFieldValues).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By linkClickHere = By.xpath("//div[@id='no-values']//a");
	By iconRemove1 = By.xpath("(//div[@id='lst-values']//div[@title='Remove value'])[1]");
	By iconAdd1 = By.xpath("(//div[@id='lst-values']//div[@title='Add a new value'])[1]");
	By txtValues1 = By.xpath("(//div[@id='lst-values']//div//input[2])[1]");
	By txtValues2 = By.xpath("(//div[@id='lst-values']//div//input[2])[2]");
	By msgDuplicate = By.xpath("(//div[@id='lst-values']//div[2]//span)[1]");
	
	public void clickLinkClickHere()
	{
		waitFluentWait(linkClickHere);
		click(linkClickHere);
	}
	
	public boolean isLinkClickHereDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkClickHere).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgDuplicateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgDuplicate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickIconRemove1()
	{
		waitFluentWait(iconRemove1);
		click(iconRemove1);
	}
	
	public void clickIconAdd1()
	{
		waitFluentWait(iconAdd1);
		click(iconAdd1);
	}
	
	public void fillTxtValues1(String value)
	{
		waitFluentWait(txtValues1);
		goTextOn(txtValues1, value);
	}
	
	public void fillTxtValues2(String value)
	{
		waitFluentWait(txtValues2);
		goTextOn(txtValues2, value);
	}
	
	By btnSwitch1 = By.xpath("(//div[@id='lst-values']//label)[1]");
	By statusON = By.xpath("(//label[@title='Click to switch to inactive state'])[1]");
	By statusOFF = By.xpath("//label[@title='Click to switch to active state'][1]");
	
	public boolean isStatusONDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(statusON).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isStatusOFFisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(statusOFF).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOFF()
	{
		String result = driver.findElement(btnSwitch1).getAttribute("title");
		 if (result.equals("Click to switch to inactive state"))
		 {
			 click(btnSwitch1);
		 }
	}
	
	public void clickON()
	{
		String result = driver.findElement(btnSwitch1).getAttribute("title");
		 if (result.equals("Click to switch to active state"))
		 {
			 click(btnSwitch1);
		 }
	}
	
	By btnClose = By.xpath("(//div[@id='edit-field-values-box']//button)[2]");
	By btnCancel = By.xpath("(//div[@id='edit-field-values-box']//button)[3]");
	By btnSave = By.xpath("(//div[@id='edit-field-values-box']//button)[4]");
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
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
