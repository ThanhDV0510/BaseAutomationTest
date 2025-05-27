package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AssignPosition extends WebActions {

	public Form_AssignPosition(WebDriver driver) {
		super(driver);
     }

	By lblAssignPosition = By.xpath("(//h4[contains(.,'Assign Position')])[1]");
	
	By txtPositionName = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::div[3]");
	
	By txtDescription = By.id("txtDescription");
	By btnSwitch = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Primary'])[6]/following::span[1]");

	By btnCancel = By.xpath("(//button[contains(.,'Cancel')])[2]");
	By btnSave = By.xpath("(//button[contains(.,'Save')])[2]");
		
	public boolean isLblAssignPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssignPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillPositionName(String positionname)
	{
		sleep(3);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::div[3]")).click();
		sleep(3);
	    driver.findElement(By.xpath("//div[@id='divPosition']/div/div/input")).clear();
	    sleep(3);
	    driver.findElement(By.xpath("//div[@id='divPosition']/div/div/input")).sendKeys(positionname);
	    sleep(3);
	    driver.findElement(By.xpath("//div[@id='divPosition']/div/div/input")).sendKeys(Keys.ENTER);
	    sleep(3);
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
	
	public void assginPosition(String positionname,String description)
	{
		fillPositionName(positionname);
		fillDescription(description);
		clickBtnSwitch();
		clickBtnSave();
	}
		
}
