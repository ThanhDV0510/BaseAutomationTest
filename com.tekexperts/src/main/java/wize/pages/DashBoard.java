package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class DashBoard extends WebActions {

	public DashBoard(WebDriver driver) {
		super(driver);
     }
	
	By tabMySkillTap = By.xpath("(//div[@id='dashboard-container']//a)[1]");
	By tabFrontLineManager = By.xpath("(//div[@id='dashboard-container']//a)[2]");
	By tabSkillAssessment = By.xpath("(//div[@id='dashboard-container']//a)[3]");
		
	public void clickTabMySkillTap()
	{
		waitFluentWait(tabMySkillTap);
		click(tabMySkillTap);
	}
		
	public boolean isTabMySkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMySkillTap).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	
	public void clickTabSkillAssessment()
	{
		waitFluentWait(tabSkillAssessment);
		click(tabSkillAssessment);
	}
	
	public boolean isTabSkillAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabSkillAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
		
	public void clickTabFrontLineManager()
	{
		waitFluentWait(tabFrontLineManager);
		click(tabFrontLineManager);
	}
		
	public boolean isTabFrontLineManagerDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabFrontLineManager).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
