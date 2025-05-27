package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_UpdatePosition extends WebActions {

	public Baseline_UpdatePosition(WebDriver driver) {
		super(driver);
     }

	By btnEdit = By.id("btn-position-base-line-edit");
	By btnExpandCollapse = By.xpath("(//div[@id='htmlTabCode']//section[1]//h3)[2]");
	By iconDelete = By.xpath("(//div[@id='accordion-azure-baseline-2']//button[@title='Remove all skills'])[1]");
	By iconX1 = By.xpath("(//div[@id='accordion-azure-baseline-2']//button[@title='Remove skill'])[1]");
	By iconX3 = By.xpath("(//div[@id='accordion-azure-baseline-2']//i)[5]");
	By linkSkillL1 = By.xpath("//div[@id='htmlTabCode']//div[@selectedlevel='1']");
	
	By btnAddSkill = By.xpath("(//div[@id='htmlTabCode']//section[1]//a)[1]");
	By itemSkill = By.xpath("//div[@id='htmlTabCode']//section[1]//a[@title='Add skill to baseline']");
	By itemInherit = By.xpath("//div[@id='htmlTabCode']//section[1]//a[@title='Inherit skill from another baseline']");	
	By itemClone = By.xpath("//div[@id='htmlTabCode']//section[1]//a[@title='Clone baseline from another position']");
	
	By lblTotalEdit = By.xpath("(//div[@id='htmlTabCode']//section[1]/div[2]//span[1])[1]");
	
	By btnSave = By.id("btn-save-position-base-line-2");
	By btnCancel = By.id("btn-cancel-edit-position-base-line");
		
	public boolean isBtnCreateBaselineClickable(){
		boolean flag = isWebElementClickable(btnAddSkill);
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
	
	public boolean isIconRemoveSkillDisplayed(){
		boolean flag = isWebElementDisplayed(iconX1);
		return flag;
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEdit).size() > 0) {
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
	
	public void clickBtnEdit()
	{
		waitFluentWait(btnEdit);
		click(btnEdit);
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
	
	public void clickItemInherit()
	{
		waitFluentWait(itemInherit);
		click(itemInherit);
	}
		
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public boolean isBtnDeleteAllBaselineClickable(){
		boolean flag = isWebElementClickable(iconDelete);
		return flag;
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
		waitFluentWait(btnSave);
		ClickElement(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public boolean isItemAddSkillDisplayed(){
		boolean flag = isWebElementDisplayed(itemSkill);
		return flag;
	}
	public boolean isItemCloneDisplayed(){
		boolean flag = isWebElementDisplayed(itemClone);
		return flag;
	}
	public boolean isItemInheritDisplayed(){
		boolean flag = isWebElementDisplayed(itemInherit);
		return flag;
	}
	
	By btnFirstCollapse = By.xpath("(//div[@id='accordion-azure-baseline-2']//button[@class='btn btn-md'])[1]");
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
		boolean flag = isWebElementDisplayed(btnExpandCollapse);
		return flag;
	}
}
