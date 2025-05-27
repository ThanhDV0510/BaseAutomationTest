package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateRole extends WebActions {

	public Form_CreateRole(WebDriver driver) {
		super(driver);
     }

	By lblCreateRole = By.id("label-role-form");
	
	public boolean isLblCreateRolelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateRole).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtRoleName = By.id("input-role-name");
	By txtSearchFSName = By.xpath("(//div[@id='function-set-pane-create']//input)[1]");
	By btnRadio = By.xpath("(//div[@id='function-set-pane-create']//label)[1]");
	
	public void fillRoleName(String rolename)
	{
		waitFluentWait(txtRoleName);
		ClickElementAndType(txtRoleName, rolename);
	}
	
	public void fillSearchFSName(String SearchFSName)
	{
		waitFluentWait(txtSearchFSName);
		goTextOn(txtSearchFSName, SearchFSName);
	}
	
	public void clickBtnRadio()
	{
		waitFluentWait(btnRadio);
		ClickElement(btnRadio);
	}
	
	public void inputData(String rolename)
	{
		fillRoleName(rolename);
		clickBtnRadio();
		sleep(1);
	}
	
	By btnCancel = By.id("btn-role-form-cancel");
	By btnSavenCreateNew = By.id("btn-role-form-save-create-new");
	By btnSave = By.id("btn-role-form-save");

	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}

}
