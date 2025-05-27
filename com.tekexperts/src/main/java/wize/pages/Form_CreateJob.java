package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateJob extends WebActions {

	public Form_CreateJob(WebDriver driver) {
		super(driver);
     }

	By lblCreateJob = By.id("label-create-job");
	
	By txtJobName = By.id("jobName");
	
	By txtDescription = By.id("description");
	
	By lblClickHere = By.id("btn-job-create-level");
	By drplistJobLevel = By.xpath("//div[@id='lst-job-level']//span/span[2]");
	By txtSearchJobLevel = By.xpath("//input[@role='listbox']");
	
	By btnAddJobLevel = By.id("btn-plus");
	By btnRemoveJobLevel = By.id("btn-minus-1");
	
	By cboxBusinessUnit = By.id("check-box-BusinessUnit");
	By cboxCountry = By.id("check-box-Country");
	By cboxProduct = By.id("check-box-Product");
	By cboxProject = By.id("check-box-Project");
	By cboxRegion = By.id("check-box-Region");
	By cboxSite = By.id("check-box-Site");
	By cboxTeam = By.id("check-box-Team");
	By cboxUnitDepartment = By.id("check-box-Unit");
	
	By btnCancel = By.id("btnCancelCreate");
	By btnSavenCreateNew = By.id("btnAddCreateNew");
	By btnSave = By.id("btnCreateJob");
		
	public boolean isLblCreateJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateJob).size() > 0) {
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
		ClickElementAndType(txtJobName, jobname);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, description);
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
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}	
	
	//Selecting Items in a Multiple SELECT elements
	public void selectJobLevel(String joblevel)
	{
		waitFluentWait(lblClickHere);
		click(lblClickHere);
		waitFluentWait(drplistJobLevel);
		click(drplistJobLevel);
		waitFluentWait(txtSearchJobLevel);
		goTextOn(txtSearchJobLevel, joblevel);
	}
	
	public void clickCboxBusinessUnit()
	{
		waitFluentWait(cboxBusinessUnit);
		click(cboxBusinessUnit);
	}
	
	public void clickCboxCountry()
	{
		waitFluentWait(cboxCountry);
		click(cboxCountry);
	}
	
	public void clickCboxProduct()
	{
		waitFluentWait(cboxProduct);
		click(cboxProduct);
	}
	
	public void clickCboxProject()
	{
		waitFluentWait(cboxProject);
		click(cboxProject);
	}
	
	public void clickCboxRegion()
	{
		waitFluentWait(cboxRegion);
		click(cboxRegion);
	}
		
	public void clickCboxSite()
	{
		waitFluentWait(cboxSite);
		click(cboxSite);
	}
	
	public void clickCboxTeam()
	{
		waitFluentWait(cboxTeam);
		click(cboxTeam);
	}
		
	public void clickCboxUnitDepartment()
	{
		waitFluentWait(cboxUnitDepartment);
		click(cboxUnitDepartment);
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
		
	public void inputData(String jobname,String description,String joblevel)
	{
		fillJobName(jobname);
		fillDescription(description);
		clickCboxBusinessUnit();
		selectJobLevel(joblevel);
	}

}
