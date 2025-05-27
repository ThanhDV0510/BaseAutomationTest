package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_Organization extends WebActions {

	public GeneralSettings_Organization(WebDriver driver) {
		super(driver);
     }

	By btnActive = By.xpath("(//section[@id='organization-partial-view']//span[@title='Activate'])[1]");
	By btnDeactive = By.xpath("(//section[@id='organization-partial-view']//span[@title='Deactive'])[1]");
	By btnRadio = By.id("IsActive-Client");
	By lblOrganization = By.id("label-tab-organization");
	
	public boolean isLblOrganizationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblOrganization).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnActiveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnActive).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnDeactiveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeactive).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnRadio()
	{
		waitFluentWait(btnRadio);
		ClickElement(btnRadio);
	}
	
	By btnSave = By.xpath("//section[@id='organization-partial-view']//div[3]/button[2]");
	By btnCancel = By.xpath("//section[@id='organization-partial-view']//div[3]/button[1]");
	
	public boolean isBtnSaveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSave).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
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
