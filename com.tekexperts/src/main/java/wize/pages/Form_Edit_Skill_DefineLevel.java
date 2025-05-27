package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Edit_Skill_DefineLevel extends WebActions {

	public Form_Edit_Skill_DefineLevel(WebDriver driver) {
		super(driver);
     }
	
	By tabDefineLevel = By.id("step2");
	
	public boolean isTabDefineLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabDefineLevel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By lblLevel1 = By.xpath("//section[@id='updateSkill']//div[@id='heading-define-level-1']//button");
	By btnRadioL1 = By.xpath("//section[@id='updateSkill']//div[@id='heading-define-level-1']//input");
	By iconEditL1 = By.xpath("//section[@id='updateSkill']//div[@id='heading-define-level-1']//a");
	By lblBehavior = By.id("collapse-define-level-1");
	
	public boolean isLblBehaviorDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBehavior).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblLevel1()
	{
		waitFluentWait(lblLevel1);
		click(lblLevel1);
	}
	
	public void clickBtnRadioL1()
	{
		waitFluentWait(btnRadioL1);
		click(btnRadioL1);
	}
	
	public void clickIconEditL1()
	{
		waitFluentWait(iconEditL1);
		click(iconEditL1);
	}
	
	//BehaviorPopup
	By lblBehaviorPopup = By.id("showDialogCreate_wnd_title");
	By drplistYear = By.xpath("(//div[@id='showDialogUpdate']//span[2]/span)[1]");
	By itemYear = By.xpath("(//div[@id='cbxExperienceYear-list'])[2]//li[2]");
	By drplistMonth = By.xpath("(//div[@id='showDialogUpdate']//span[2]/span)[2]");
	By itemMonth = By.xpath("(//div[@id='cbxExperienceMonth-list'])[2]//li[2]");
	By lblDomain = By.xpath("(//div[@id='accordion-behavior-level']/div/div/h3/button/i)[1]");
	By cboxBehavior = By.xpath("(//div[@id='accordion-behavior-level']//input)[1]");
	By btnSave = By.xpath("//div[@id='showDialogUpdate']/div[3]//button[@title='Cancel']");
	By btnClose = By.xpath("//div[@id='showDialogUpdate']/div[3]//button[@title='Save']");
	
	public boolean isLblBehaviorPopupDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBehaviorPopup).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblDomain()
	{
		waitFluentWait(lblDomain);
		click(lblDomain);
	}
	
	public void clickCboxBehavior()
	{
		waitFluentWait(cboxBehavior);
		click(cboxBehavior);
	}
	
	public void clickDrplistMonth()
	{
		waitFluentWait(drplistMonth);
		click(drplistMonth);
	}
	
	public void clickItemMonth()
	{
		waitFluentWait(itemMonth);
		click(itemMonth);
	}
	
	public void clickDrplistYear()
	{
		waitFluentWait(drplistYear);
		click(drplistYear);
	}
	
	public void clickItemYear()
	{
		waitFluentWait(itemYear);
		click(itemYear);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	public void selectMonth()
	{
		clickDrplistMonth();
		clickItemMonth();
	}
	
	public void selectMonthYear()
	{
		clickDrplistYear();
		clickItemYear();
	}
	
	public void tickOnBehavior()
	{
		clickLblDomain();
		clickCboxBehavior();
	}
	
	By lblTotal = By.xpath("//span[contains(.,'1/1')]");
	
	public boolean isLblTotalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTotal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCancel = By.xpath("(//div[@id='buttonStep2']/button[1])[2]");
	By btnCancel14755 = By.xpath("(//div[@id='buttonStep2']/button[1])[1]");
	By btnBack = By.xpath("(//div[@id='buttonStep2']/button[2])[2]"); 
	By btnBack14755 = By.xpath("(//div[@id='buttonStep2']/button[2])[1]"); 
	By btnNext = By.xpath("(//div[@id='buttonStep2']/button[3])[2]");
	By btnNext14755 = By.xpath("(//div[@id='buttonStep2']/button[3])[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnBack()
	{
		waitFluentWait(btnBack);
		click(btnBack);
	}
		
	public void clickBtnNext()
	{
		waitFluentWait(btnNext);
		click(btnNext);
	}
	
	public void clickBtnNext14755()
	{
		waitFluentWait(btnNext14755);
		click(btnNext14755);
	}
}
