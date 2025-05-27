package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_Job extends WebActions {

	public Baseline_Job(WebDriver driver) {
		super(driver);
     }
		
	By txtSearchJob = By.id("searchJob");
	By itemFirstJob = By.xpath("//ul[@id='jobListBaselineView']//li[1]");
	By itemFirtSearchJob = By.xpath("//ul[@id='searchJob_listbox']//li[1]");
	
	public boolean isItemFirstJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirstJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickItemFirtJob()
	{
		waitFluentWait(itemFirstJob);
		clickByJavaScript(itemFirstJob);
	}
	
	public void fillTxtSearchJob(String searchjob)
	{
		waitFluentWait(txtSearchJob);
		ClickElementAndType(txtSearchJob, searchjob);
		sleep(2);
		waitFluentWait(itemFirtSearchJob);
		click(itemFirtSearchJob);
		clickItemFirtJob();
		sleep(2);
	}
	
	By lblBaselineName = By.id("skillTitle");
	By lblViewBaseline = By.xpath("(//div[@id='accordion-job-baseline']//h3)[1]");

	By iconDelete = By.xpath("(//div[@id='accordion-job-baseline']//div[1]/button)[1]");
	By iconX1 = By.xpath("(//div[@id='accordion-job-baseline']//div[2]/button)[1]");
	By iconX3 = By.xpath("(//div[@id='accordion-job-baseline']//div[2]/button)[3]");
	By linkSkillL1 = By.xpath("(//div[@id='accordion-job-baseline']//div[3]/div/div/div/div/div/div/div)[1]");
	By lblWarning = By.xpath("//div[@id='accordion-job-baseline']//div[3]//div[3]/button/i");
	
	By btnAddSkill = By.xpath("//a[@id='addJobBaseLineDropdown']");
	By itemSkill = By.xpath("//div[@id='dimensionBaseline-screen']//a[@id='btnAddSkill']");
	By itemClone = By.xpath("//div[@id='dimensionBaseline-screen']//a[@id='btnClone']");	

	By btnEdit = By.xpath("//button[@id='editJobBaseLine']");
	By statusLinkSkill = By.xpath("//div[@class='range-item range-primary']");
	
	By lblTotalEdit = By.xpath("(//div[@id='accordion-job-baseline']//span)[1]");
	
	By btnSave = By.id("btnSaveJobBaseLine");
	By btnCancel = By.id("btnCancelJobBaseLine");
	
	public boolean isBtnEditClickable(){
		boolean flag = isWebElementClickable(btnEdit);
		return flag;
	}
	public boolean isBtnSaveDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, btnSave);
			if ( driver.findElement(btnSave).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnSaveEnable()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, btnSave);
			if ( driver.findElement(btnSave).isEnabled() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLblWarningDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblWarning);
			if ( driver.findElement(lblWarning).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isStatusLinkSkillDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, statusLinkSkill);
			if ( driver.findElement(statusLinkSkill).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
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
					
	public boolean isLblTotalEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTotalEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkSkillL1Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkSkillL1).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnAddSkill()
	{
		sleep(3);
		waitFluentWait(btnAddSkill);
		click(btnAddSkill);
	}
		
	public void clickItemSkill()
	{
		waitFluentWait(itemSkill);
		click(itemSkill);
	}
	
	public boolean isItemAddSkillDisplayed(){
		boolean flag = isWebElementDisplayed(itemSkill);
		return flag;
	}
	public boolean isItemCloneDisplayed(){
		boolean flag = isWebElementDisplayed(itemClone);
		return flag;
	}
	
	public void clickItemClone()
	{
		waitFluentWait(itemClone);
		click(itemClone);
	}
	
	public void clickBtnEdit()
	{
		waitFluentWait(btnEdit);
		click(btnEdit);
	}

	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public void clickIconX1()
	{
		waitFluentWait(iconX1);
		click(iconX1);
	}
	
	public boolean isIconX1Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconX1).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconX3()
	{
		waitFluentWait(iconX3);
		click(iconX3);
	}

	public void clickLinkSkillL1()
	{
		waitFluentWait(linkSkillL1);
		click(linkSkillL1);
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
	
	public boolean isLblBaselineNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaselineName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblViewBaselineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblViewBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCreateNewBaseline = By.xpath("(//div[@id='positionBaseline-screen']//a[@title='Click to add new baseline'])[1]");
	By btnEditBaseline = By.xpath("(//div[@id='positionBaseline-screen']//button[@title='Edit'])");
	By linkAddSkill = By.xpath("//div[@class='announcement-body']//a[@title='Add skill to baseline']");
	By linkCloneBaseline = By.xpath("//div[@class='announcement-body']//a[@title='Clone baseline from another dimension']");
	
	public boolean isBtnCreateBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateNewBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnEditBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnEditBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkAddSkillDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkAddSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkCloneBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkCloneBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateBaseline(){
		waitFluentWait(btnCreateNewBaseline);
		click(btnCreateNewBaseline);
	}
	public void clickBtnEditBaseline(){
		waitFluentWait(btnEditBaseline);
		click(btnEditBaseline);
	}
	public void clickLinkAddSkill(){
		waitFluentWait(linkAddSkill);
		click(linkAddSkill);
	}
	public void clickLinkCloneBaseline(){
		waitFluentWait(linkCloneBaseline);
		click(linkCloneBaseline);
	}
	By btnFirstCollapse = By.xpath("(//div[@id='accordion-job-baseline']//button[@class='btn btn-md '])[1]");
	public String getTextBtnFirstCollapse(){
		String text = "";
		try {
			text = driver.findElement(btnFirstCollapse).getAttribute("title");
		} catch (Exception e) {
			return text;
		}
		return text;
	}
	public boolean isFirstSkillDisplayed(){
		boolean flag = isWebElementDisplayed(btnFirstCollapse);
		return flag;
	}
}
