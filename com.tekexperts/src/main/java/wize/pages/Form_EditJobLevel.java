package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditJobLevel extends WebActions {

	public Form_EditJobLevel(WebDriver driver) {
		super(driver);
     }

	By lblEditJobLevel = By.id("label-create-job-level");
	
	By txtJobLevel = By.id("txtJobLevelName");
	
	By txtDescription = By.id("txtJobLevelDescription");
	
	By drplistLinkToJob = By.id("ddlJob");
	
	By btnCancel = By.id("btnCancel");
	By btnSave = By.id("btn-save-create");
		
	public boolean isLblEditJobLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditJobLevel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillJobLevel(String joblevel)
	{
		waitFluentWait(txtJobLevel);
		goTextOn(txtJobLevel, joblevel);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		goTextOn(txtDescription, description);
	}
	
	public void fillLinkToJob(String linktojob)
	{
		waitFluentWait(drplistLinkToJob);
		goTextOn(drplistLinkToJob, linktojob);
	}
	
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
		
	public void inputData(String joblevel,String description,String linktojob)
	{
		fillJobLevel(joblevel);
		fillDescription(description);
		fillLinkToJob(linktojob);
	}
}
