package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Edit_Skill_PreviewFinish extends WebActions {

	public Form_Edit_Skill_PreviewFinish(WebDriver driver) {
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
	
	By lblLevel = By.xpath("(//div[@id='level-view-panel']//span)[1]");
	By lblYearMonth = By.xpath("(//div[@id='level-view-panel']//li//div[2])[1]");
	By lblDomainName = By.xpath("(//div[@id='domain-view-panel']//button/i)[1]");
	By lblLevelCover = By.xpath("//div[@id='domain-view-panel']//li//div[2]");
	
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
	 
	By btnCancel = By.xpath("(//div[@id='buttonStep3']/button[2])[2]");
	By btnCancel14755 = By.xpath("(//div[@id='buttonStep3']/button[2])[1]");
	By btnBack = By.xpath("(//div[@id='buttonStep3']/button[2])[2]");
	By btnBack14755 = By.xpath("(//div[@id='buttonStep3']/button[2])[1]");
	By btnSave = By.xpath("(//div[@id='buttonStep3']/button[3])[2]");
	By btnSave14755 = By.xpath("(//div[@id='buttonStep3']/button[3])[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
//		click(btnCancel);
		clickByJavaScript(btnCancel);
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
	
	public void clickBtnSave14755()
	{
		waitFluentWait(btnSave14755);
		click(btnSave14755);
	}
}
