package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class JobList extends WebActions {

	public JobList(WebDriver driver) {
		super(driver);
     }
	
	By lblJobList = By.id("label-job-list");
	By btnCreate = By.id("btn-create-job");
	By iconEdit = By.xpath("(//div[@id='job-grid']//a[@id='action-edit'])[1]");
	By iconDelete = By.xpath("(//div[@id='job-grid']//a[@id='action-delete'])[1]");
	By linkFirstJob = By.xpath("(//div[@id='job-grid']//td/a)[1]");
	By txtSearchJob = By.xpath("(//div[@id='job-grid']//input)[1]");
	By txtDescription = By.id("description");	
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		goTextOn(txtDescription, description);
	}
	
	public boolean isBtnCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isIconEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillSearchJob(String searchjob)
	{
		waitFluentWait(txtSearchJob);
		goTextOn(txtSearchJob, searchjob);
		sleep(3);
	}
	
	public boolean isLblJobListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJobList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstJob()
	{
		waitFluentWait(linkFirstJob);
		clickByJavaScript(linkFirstJob);
	}
	
	public boolean isLinkFirstJobClickable(){
		boolean flag = isWebElementClickable(linkFirstJob);
		return flag;
	}
	
	public void clickBtnCreate()
	{
		waitFluentWait(btnCreate);
		clickByJavaScript(btnCreate);
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(iconEdit);
		clickByJavaScript(iconEdit);
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		clickByJavaScript(iconDelete);
	}
	
	//Popup Confirm Delete
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
	By btnNo = By.xpath("//button[contains(.,'NO')]");
	
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
		clickByJavaScript(btnYes);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		clickByJavaScript(btnNo);
	}

	public void deleteJob()
	{
		clickIconDelete();
		clickBtnYes();
	}
}
