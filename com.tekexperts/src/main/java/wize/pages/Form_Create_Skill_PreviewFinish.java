package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Create_Skill_PreviewFinish extends WebActions {

	public Form_Create_Skill_PreviewFinish(WebDriver driver) {
		super(driver);
     }
	
	By tabPreview = By.id("step3");
	
	public boolean isTabPreviewDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabPreview).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By tabLevelView = By.id("level-view-tab");
	By tabDomainView = By.id("domain-view-tab");
	
	public void clickTabLevelView()
	{
		waitFluentWait(tabLevelView);
		click(tabLevelView);
	}
	
	public void clickTabDomainView()
	{
		waitFluentWait(tabDomainView);
		click(tabDomainView);
	}
		
	
//	By lblLevel = By.xpath("//div[@id='level-view-pane']//button/i)[1]");
	By lblLevel = By.xpath("(//span[@data-bind='text:title'])[11]");
	By lblYearMonth = By.xpath("(//div[@id='level-view-pane']//li//div[2])[1]");
	By lblDomainName = By.xpath("(//div[@id='domain-view-pane']//button/i)[1]");
	By lblLevelCover = By.xpath("//div[@id='domain-view-pane']//li//div[2]");
	
	public void clickLblLevel()
	{
		waitFluentWait(lblLevel);
		click(lblLevel);
	}
	
	public void clickLblDomainName()
	{
		waitFluentWait(lblDomainName);
		click(lblDomainName);
	}
	
	public boolean isTabLevelViewDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabLevelView).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public boolean isLblYearMonthDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblYearMonth).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabDomainViewDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabDomainView).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblLevelCoverDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblLevelCover).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	 
	By btnCancel = By.id("btn-step3-cancel");
	By btnBack = By.id("btn-step3-back"); 
	By btnSave = By.id("btn-step3-save");
	By btnSaveNCreate = By.id("btn-step3-save-new");
	
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

	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnSaveNCreate()
	{
		waitFluentWait(btnSaveNCreate);
		click(btnSaveNCreate);
	}
}
