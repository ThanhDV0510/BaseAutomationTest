package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTalent extends WebActions {

	public MyTalent(WebDriver driver) {
		super(driver);
     }
	
	By tabMySkill360 = By.id("Talent-tabstrip-learner");
	By tabMySkill = By.id("Talent-tabstrip-skill");
	By tabMyCareerPath = By.id("Talent-tabstrip-career-path");
	
	public boolean isTabMySkill360Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMySkill360).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabMySkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMySkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabMyCareerPathDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMyCareerPath).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabMySkill360()
	{
		waitFluentWait(tabMySkill360);
		click(tabMySkill360);
		sleep(2);
	}
	
	public void clickTabMySkill()
	{
		waitFluentWait(tabMySkill);
		click(tabMySkill);
		sleep(2);
	}
	
	public void clickTabMyCareerPath()
	{
		waitFluentWait(tabMyCareerPath);
		click(tabMyCareerPath);
		sleep(2);
	}
}

