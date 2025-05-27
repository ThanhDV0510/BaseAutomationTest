package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditBusinessUnit extends WebActions {

	public Form_EditBusinessUnit (WebDriver driver) {
		super(driver);
     }

	By lblEditBusinessUnit = By.id("label-business-unit-edit");
	
	public boolean isLblEditBusinessUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditBusinessUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtName = By.id("Name");
	By txtDescription = By.id("Description");
	By btnSave = By.xpath("(//button[@id='saveBusinessUnit'])[2]");
	By btnCancel = By.xpath("(//button[@id='cancelBusinessUnit'])[2]");
	
	public void fillName(String name)
	{
		waitFluentWait(txtName);
		ClickElementAndType(txtName, name);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, description);
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
}
