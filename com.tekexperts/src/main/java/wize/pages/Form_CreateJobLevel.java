package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateJobLevel extends WebActions {

	public Form_CreateJobLevel(WebDriver driver) {
		super(driver);
     }

	By lblCreateJobLevel = By.id("label-create-job-level");
	
	By txtJobLevel = By.id("txtJobLevelName");
	
	By txtDescription = By.id("txtJobLevelDescription");
	
	By drplistLinkToJob = By.id("ddlJob");
	By firstLinkToJob = By.xpath("(//ul[@id='ddlJob_listbox']/li)[1]");
	
	
	By btnCancel = By.id("btnCancel");
	By btnSavenCreateNew = By.id("btn-save-new");
	By btnSave = By.id("btn-save-create");
		
	public boolean isLblCreateJobLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateJobLevel).size() > 0) {
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
	
	/*public void fillLinkToJob(String linktojob)
	{
		waitFluentWait(drplistLinkToJob);
		driver.findElement(By.id("ddlJob")).click();
		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Link To Job'])[2]/following::div[3]")).click();
		driver.findElement(By.xpath("//*[@id='jobLevelForm']/div[3]/div/div/div")).sendKeys(linktojob);
		waitFluentWait(firstLinkToJob);
		driver.findElement(By.xpath("(//ul[@id='ddlJob_listbox']/li)[1]")).click();
		//driver.findElement(By.xpath("(//li[contains(.,'Test Automation')])[2]")).click();
		
	}*/
	
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
		
	public void inputData(String joblevel,String description)
	{
		fillJobLevel(joblevel);
		fillDescription(description);
	}
}
