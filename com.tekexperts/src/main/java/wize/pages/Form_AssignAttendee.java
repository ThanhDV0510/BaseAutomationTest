package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AssignAttendee extends WebActions {

	public Form_AssignAttendee(WebDriver driver) {
		super(driver);
     }

	By lblAssignAttendee = By.xpath("(//div[@id='assignment-user']//h5)[1]");
			
	public boolean isLblAssignAttendeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssignAttendee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtSearch = By.xpath("(//div[@id='assignment-user']//th//input)[4]");
	
	public void fillSearch(String searchname)
	{
		waitFluentWait(txtSearch);
		goTextOn(txtSearch, searchname);
	}
	
	By cboxAllLeft = By.xpath("(//div[@id='assignment-user']//th//label)[1]");
	By cboxAllRight = By.xpath("(//div[@id='assignment-user']//th//label)[2]");
				
	public void clickCboxAllLeft()
	{
		waitFluentWait(cboxAllLeft);
		click(cboxAllLeft);
	}
		
	public void clickCboxAllRight()
	{
		waitFluentWait(cboxAllRight);
		click(cboxAllRight);
	}
		
	By btnMove = By.xpath("(//div[@id='assignment-user']//div[2]//button//i)[1]");
	By btnBack = By.xpath("(//div[@id='assignment-user']//div[2]//button//i)[2]");
	
	public void clickBtnMove()
	{
		waitFluentWait(btnMove);
		click(btnMove);
		sleep(3);
	}
	
	public void clickBtnBack()
	{
		waitFluentWait(btnBack);
		click(btnBack);
	}
	
	By btnAssign = By.xpath("(//div[@id='assignment-user']//div[3]/button)[2]");
	By btnCancel = By.xpath("(//div[@id='assignment-user']//div[3]/button)[1]");
	
	public void clickBtnAssign()
	{
		waitFluentWait(btnAssign);
		click(btnAssign);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By btnNo = By.xpath("//button[contains(.,'No')]");
	
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
