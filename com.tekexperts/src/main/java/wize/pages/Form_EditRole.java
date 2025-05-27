package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditRole extends WebActions {

	public Form_EditRole(WebDriver driver) {
		super(driver);
     }

	By lblEditRole = By.id("label-edit-role");
	
	public boolean isLblEditRolelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditRole).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtRoleName = By.id("role-name");
	By btnRadio = By.xpath("(//div[@id='function-set-pane-viewEdit']//label)[1]");

	public void fillRoleName(String rolename)
	{
		waitFluentWait(txtRoleName);
		ClickElementAndType(txtRoleName, rolename);
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
	
	By btnCancel = By.id("btn-cancel-edit");
	By btnSave = By.id("btn-save");
			
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
				
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}

}
