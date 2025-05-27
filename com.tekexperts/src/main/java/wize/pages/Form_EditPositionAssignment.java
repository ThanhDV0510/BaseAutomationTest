package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditPositionAssignment extends WebActions {

	public Form_EditPositionAssignment(WebDriver driver) {
		super(driver);
     }

	By lblEditPositionAssignment = By.xpath("(//h4[contains(.,'Edit Position Assignment')])[1]");
	
	By txtPositionName = By.id("ddlPosition_taglist");
	
	By txtDescription = By.id("txtDescription");
	By btnSwitch = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Primary'])[6]/following::span[1]");

	By btnCancel = By.xpath("(//button[contains(.,'Cancel')])[2]");
	By btnSave = By.xpath("(//button[contains(.,'Save')])[2]");
		
	public boolean isLblEditPositionAssignmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditPositionAssignment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillPositionName(String positionname)
	{
		waitFluentWait(txtPositionName);
		goTextOn(txtPositionName, positionname);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		goTextOn(txtDescription, description);
	}
	
	public void clickBtnSwitch()
	{
		waitFluentWait(btnSwitch);
		clickByJavaScript(btnSwitch);
	}
	
/*	public void selectJobLevel(String joblevel)
	{
		waitFluentWait(drplistJobLevel);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Job Level'])[2]/following::div[3]")).click();
		driver.findElement(By.xpath("//form[@id='frmCreateJob']/div[4]/div/div/div/input")).sendKeys(joblevel);
		sleep(3);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Unit/Department'])[2]/following::span[1]")).click();
	}
		*/	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		clickByJavaScript(btnCancel);
	}
		
}
