package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_AddPosition extends WebActions {

	public Baseline_AddPosition(WebDriver driver) {
		super(driver);
     }

	By btnExpandCollapse = By.xpath("//div[@id='htmlTabCode']/div[1]/section[2]/div[2]//button");
	By iconDelete = By.xpath("(//div[@id='accordion-azure-baseline-2']//i)[2]");
	By iconX1 = By.xpath("(//div[@id='accordion-azure-baseline-2']//i)[3]");
	By iconX3 = By.xpath("(//div[@id='accordion-azure-baseline-2']//i)[5]");
	By linkSkillL1 = By.xpath("//div[@id='htmlTabCode']//div[@selectedlevel='1']");
	
	By btnAddSkill = By.xpath("(//div[@id='htmlTabCode']//section[2]//div[2]//i)[1]");
	By itemSkill = By.xpath("//div[@class='dropdown show']//a[@title='Add Skill to baseline']");
	By itemInherit = By.xpath("//div[@class='dropdown show']//a[@title='Inherit skill from another baseline']");
	By itemClone = By.xpath("//div[@class='dropdown show']//a[@title='Clone baseline from another position']");

	By lblTotalEdit = By.xpath("(//div[@id='htmlTabCode']//section[1]/div[2]//span[1])[1]");
	
	By btnSave = By.id("btn-save-position-base-line");
	By btnCancel = By.id("btn-cancel-edit-position-base-line");
	
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
	
	public void clickBtnExpandCollapse()
	{
		waitFluentWait(btnExpandCollapse);
		click(btnExpandCollapse);
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
	
	public boolean isItemSkillDisplayed(){
		boolean flag = isWebElementDisplayed(itemSkill);
		return flag;
	}
	public boolean isItemInheritDisplayed(){
		boolean flag = isWebElementDisplayed(itemInherit);
		return flag;
	}
	public boolean isItemCloneDisplayed(){
		boolean flag = isWebElementDisplayed(itemClone);
		return flag;
	}
	
	public void clickItemInherit()
	{
		waitFluentWait(itemInherit);
		click(itemInherit);
	}
	
	public void clickItemClone()
	{
		waitFluentWait(itemClone);
		click(itemClone);
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
		sleep(3);
		waitFluentWait(btnSave);
		click(btnSave);
	}

	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	

}
