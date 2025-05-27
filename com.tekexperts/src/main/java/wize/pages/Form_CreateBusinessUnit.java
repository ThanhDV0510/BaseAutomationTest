package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateBusinessUnit extends WebActions {

	public Form_CreateBusinessUnit (WebDriver driver) {
		super(driver);
     }

	By lblCreateBusinessUnit = By.id("label-bussiness-unit-create");
	
	public boolean isLblCreateBusinessUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateBusinessUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtName = By.id("createName");
	By txtDescription = By.id("Description");
	By txtAbbreviation = By.id("businessUnitCode");
	By btnSave = By.xpath("(//button[@id='saveBusinessUnit'])[1]");
	By btnCancel = By.xpath("(//button[@id='cancelBusinessUnit'])[1]");
	
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
	
	public void fillAbbreviation(String abb)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, abb);
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
	
	public void fillData(String name,String description)
	{
		fillName(name);
		fillDescription(description);
	}
}
