package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Create_Skill_DefineLevel extends WebActions {

	public Form_Create_Skill_DefineLevel(WebDriver driver) {
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
	
	By lblLevel1 = By.xpath("//div[@id='heading-define-level-1']//button/span");
	By btnRadioL1 = By.xpath("//div[@id='heading-define-level-1']//input");
	By iconEditL1 = By.xpath("//div[@id='heading-define-level-1']//a/i");
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
	By drplistYear = By.xpath("(//div[@id='showDialogCreate']//span[2]/span)[1]");
	By itemYear = By.xpath("(//li[@tabindex='-1'][contains(.,'3')])[2]");
	By drplistMonth = By.xpath("(//div[@id='showDialogCreate']//span[2]/span)[2]");
	By itemMonth = By.xpath("(//li[@tabindex='-1'][contains(.,'3')])[1]");
	By lblDomain = By.xpath("//div[@id='accordion-behavior-level']//i");
	By cboxBehavior = By.xpath("//div[@id='accordion-behavior-level']//input");
	By btnSave = By.id("btn-save-behavior-detail");
	By btnClose = By.id("btn-cancel-behavior-detail");
	
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
		sleep(1.5);
		clickItemMonth();
	}
	
	public void selectYear()
	{
		clickDrplistYear();
		sleep(1.5);
		clickItemYear();
	}
	
	public void tickOnBehavior()
	{
		clickLblDomain();
		clickCboxBehavior();
	}
	
	By lblTotal = By.xpath("//div[@id='accordion-behavior-level']//span[2]");
	
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
	
	By btnCancel = By.id("btn-step2-cancel");
	By btnNext = By.id("btn-step2-next");
	By btnBack = By.id("btn-step2-back");
		
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
	
}
