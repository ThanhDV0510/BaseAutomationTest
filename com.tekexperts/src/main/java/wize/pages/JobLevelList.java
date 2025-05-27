package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class JobLevelList extends WebActions {

	public JobLevelList(WebDriver driver) {
		super(driver);
     }
	
	By lblJobLevelList = By.id("label-job-level-list");
	By btnCreate = By.id("btnCreateJobLevel");
	By iconEdit = By.xpath("(//div[@id='job-level-grid']//button[@title='Edit'])[1]");
	By iconDelete = By.xpath("(//div[@id='job-level-grid']//button[@title='Delete'])[1]");
	By linkFirstJobLevel = By.xpath("(//div[@id='job-level-grid']//td/a)[1]");
	By txtSearchJobLevel = By.xpath("(//div[@id='job-level-grid']//input)[1]");
	
	public void fillSearchJobLevel(String searchjoblevel)
	{
		waitFluentWait(txtSearchJobLevel);
		goTextOn(txtSearchJobLevel, searchjoblevel);
		sleep(2);	
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
	
	public boolean isLblJobLevelListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJobLevelList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstJobLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstJobLevel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstJobLevelClickable(){
		boolean flag = isWebElementClickable(linkFirstJobLevel);
		return flag;
	}
	
	public void clickLinkFirstJobLevel()
	{
		waitFluentWait(linkFirstJobLevel);
		click(linkFirstJobLevel);
	}
	
	public void clickBtnCreate()
	{
		waitFluentWait(btnCreate);
		click(btnCreate);
	}
	
	public void clickIconEdit()
	{
		moveHoverElement(driver.findElement(linkFirstJobLevel));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public void clickIconDelete()
	{
		moveHoverElement(driver.findElement(linkFirstJobLevel));
		waitFluentWait(iconDelete);
		click(iconDelete);
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
		click(btnYes);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}

	public void deleteJobLevel()
	{
		clickIconDelete();
		clickBtnYes();
	}
	
}
