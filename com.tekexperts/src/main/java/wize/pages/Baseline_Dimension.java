package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_Dimension extends WebActions {

	public Baseline_Dimension(WebDriver driver) {
		super(driver);
     }
		
	By txtSearchDimension = By.id("searchDimension");
	By itemFirtSearchDimension = By.xpath("//ul[@id='searchDimension_listbox']//li[1]");
	By itemFirstDimension = By.xpath("(//div[@id='treelist-BusinessUnit']//tr[2]/td)[1]");
	
	public boolean isItemFirstDimensionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirstDimension).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickItemFirtDimension()
	{
		waitFluentWait(itemFirstDimension);
		click(itemFirstDimension);
	}
	
	public void fillTxtSearchDimension(String searchDimension)
	{
		waitFluentWait(txtSearchDimension);
		ClickElementAndType(txtSearchDimension, searchDimension);
		sleep(2);
		waitFluentWait(itemFirtSearchDimension);
		click(itemFirtSearchDimension);
		clickItemFirtDimension();
		sleep(2);
	}
	
	By lblBaselineName = By.xpath("//div[@id='dimensionBaseline-screen']//section[2]/div[1]//h3");
	By lblViewBaseline = By.xpath("(//div[@id='dimension-detail-container']//h3)[1]");
	By iconCollaseExpand = By.xpath("(//div[@id='treelist-BusinessUnit']//span)[1]");
	
	By iconDelete = By.xpath("(//div[@id='dimension-preview-container']//div[1]/button)[1]");
	By iconX1 = By.xpath("(//div[@id='dimension-preview-container']//div[2]/button)[1]");
	By iconX3 = By.xpath("(//div[@id='dimension-preview-container']//div[2]/button)[2]");
	By linkSkillL1 = By.xpath("(//div[@id='dimension-preview-container']//div[3]/div/div/div/div/div/div/div)[1]");
	By lblWarning = By.xpath("//div[@id='preview-dimension-baseline']//div[3]/button/i");
	
	By btnAddSkill = By.xpath("(//a[@id='btnAddClone'])[1]");
	By btnAddSkillAfterEdit = By.xpath("(//a[@id='btnAddClone'])[2]");
	By itemSkill = By.xpath("(//a[@id='btnAddSkill'])[1]");
	By itemClone = By.xpath("(//a[@id='btnClone'])[1]");

	By btnEdit = By.xpath("//div[@id='dimensionBaseline-screen']//button[@title='Edit']");
	By statusLinkSkill = By.xpath("//div[@id='dimension-preview-container']//div[@class='range-item range-primary']");
	
	By lblTotalEdit = By.xpath("(//div[@id='preview-dimension-baseline']//span)[1]");
	
	By btnSave = By.xpath("//div[@id='preview-dimension-baseline']//div[3]/button[2]");
	By btnCancel = By.xpath("//div[@id='preview-dimension-baseline']//div[3]/button[1]");
	
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
	
	public boolean isBtnAddClickable(){
		boolean flag = isWebElementClickable(btnAddSkill);
		return flag;
	}
	public boolean isBtnAddAfterEditClickable(){
		boolean flag = isWebElementClickable(btnAddSkillAfterEdit);
		return flag;
	}
	public boolean isItemAddSkillToBaselineDisplayed(){
		boolean flag = isWebElementDisplayed(itemSkill);
		return flag;
	}
	public boolean isItemCloneDisplayed(){
		boolean flag = isWebElementDisplayed(itemClone);
		return flag;
	}
	public boolean isBtnEditClickable(){
		boolean flag = isWebElementClickable(btnEdit);
		return flag;
	}
	
	public void clickBtnAddSkill()
	{
		waitFluentWait(btnAddSkill);
		click(btnAddSkill);
	}
		
	public void clickItemSkill()
	{
		waitFluentWait(itemSkill);
		click(itemSkill);
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
	
	public void clickIconCollaseExpand()
	{
		waitFluentWait(iconCollaseExpand);
		click(iconCollaseExpand);
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
	
	public void clickDoubleBtnSave()
	{
		waitFluentWait(btnSave);
		doubleClick(driver.findElement(btnSave), 1);
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
	By linkAddSkill = By.xpath("//div[@class='announcement-body']//a[@title='Add Skill to baseline']");
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
	By btnFirstCollapse = By.xpath("(//div[@id='accordion-dimension-baseline-1']//button[@class='btn btn-md'])[1]");
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
