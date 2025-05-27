package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditJob extends WebActions {

	public Form_EditJob(WebDriver driver) {
		super(driver);
     }

	By lblEditJob = By.id("label-create-job");
	
	By btnCancel = By.id("btnCancelCreate");
	By btnSave = By.id("btnCreateJob");
		
	By txtJobName = By.id("jobName");
	By txtDescription = By.id("description");
	
	By drplistJobLevel = By.xpath("(//div[@id='lst-job-level']//span/span[2])[1]");
	By txtSearchJobLevel = By.xpath("//input[@role='listbox']");
	
	By btnAddJobLevel = By.id("btn-plus");
	By btnRemoveJobLevel = By.id("btn-minus-1");
			
	public boolean isLblEditJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillJobName(String jobname)
	{
		waitFluentWait(txtJobName);
		goTextOn(txtJobName, jobname);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		goTextOn(txtDescription, description);
	}
	
	public void clickBtnAddJobLevel()
	{
		waitFluentWait(btnAddJobLevel);
		click(btnAddJobLevel);
	}
	
	public void clickBtnRemoveJobLevel()
	{
		waitFluentWait(btnRemoveJobLevel);
		click(btnRemoveJobLevel);
	}	
			
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void selectJobLevel(String joblevel)
	{
		waitFluentWait(drplistJobLevel);
		click(drplistJobLevel);
		waitFluentWait(txtSearchJobLevel);
		goTextOn(txtSearchJobLevel, joblevel);
	}
}
