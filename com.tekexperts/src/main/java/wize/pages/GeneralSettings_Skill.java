package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_Skill extends WebActions {

	public GeneralSettings_Skill(WebDriver driver) {
		super(driver);
     }
	
	By lblSkill = By.id("label-skill-tab");
	By btnRadio5 = By.id("btn-check-5");
	By btnRadio6 = By.id("btn-check-6");
	By btnRadio7 = By.id("btn-check-7");
	By btnRadio8 = By.id("btn-check-8");
	By btnRadio9 = By.id("btn-check-9");
	By btnRadio10 = By.id("btn-check-10");
	By lblDisabled = By.xpath("//input[@disabled='disabled']");
	
	public boolean isLblSkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblDisabledDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblDisabled).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnRadio5()
	{
		waitFluentWait(btnRadio5);
		click(btnRadio5);
	}
	
	public void clickBtnRadio6()
	{
		waitFluentWait(btnRadio6);
		click(btnRadio6);
	}
	
	public void clickBtnRadio7()
	{
		waitFluentWait(btnRadio7);
		click(btnRadio7);
	}
	
	public void clickBtnRadio8()
	{
		waitFluentWait(btnRadio8);
		click(btnRadio8);
	}
	
	public void clickBtnRadio9()
	{
		waitFluentWait(btnRadio9);
		click(btnRadio9);
	}
	
	public void clickBtnRadio10()
	{
		waitFluentWait(btnRadio10);
		click(btnRadio10);
	}

	By btnSave = By.xpath("//section[@id='skill-partial-view']//div[3]/button[2]");
	By btnCancel = By.xpath("//section[@id='skill-partial-view']//div[3]/button[1]");

	public boolean isBtnSavelDisplayed()
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
