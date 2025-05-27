package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_BaselineUpdateConfirmation extends WebActions {

	public Form_BaselineUpdateConfirmation(WebDriver driver) {
		super(driver);
     }
	
	By lblBaselineUpdateConfirmation = By.xpath("//div[@id='baseline-update-confirmation']//h5");
	
	By iconX = By.xpath("//div[@id='baseline-update-confirmation']//div[1]/button");
	By btnSave = By.xpath("//div[@id='baseline-update-confirmation']//div[3]/button[2]");
	By btnCancel = By.xpath("//div[@id='baseline-update-confirmation']//div[3]/button[1]");
	
	By valueCurrentValue1 = By.xpath("(//div[@id='baseline-changes-grid']//span)[1]");
	By valueCurrentValue2 = By.xpath("(//div[@id='baseline-changes-grid']//span)[2]");
	By valueCurrentValue3 = By.xpath("(//div[@id='baseline-changes-grid']//span)[3]");
	
	By valueNewValue = By.xpath("(//div[@id='baseline-changes-grid']//td[3]//span)[1]");
	By valueNewValueStatus = By.xpath("(//div[@id='baseline-changes-grid']//td[3]//span[2])[1]");
		
	public boolean isLblBaselineUpdateConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaselineUpdateConfirmation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueNewValueDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueNewValue).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueCurrentValue3Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueCurrentValue3).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueCurrentValue2Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueCurrentValue2).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueCurrentValue1Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueCurrentValue1).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueNewValueStatusDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueNewValueStatus).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
}
