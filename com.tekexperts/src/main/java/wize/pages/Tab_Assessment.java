package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Tab_Assessment extends WebActions {

	public Tab_Assessment(WebDriver driver) {
		super(driver);
     }
		
	By tabAssessmentLibrary = By.id("tab-library");
	By tabMyAssessment = By.id("tab-my-test");
	
	public boolean isTabAssessmentLibraryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAssessmentLibrary).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabAssessmentLibrary()
	{
		waitFluentWait(tabAssessmentLibrary);
		click(tabAssessmentLibrary);		
	}
	
	public boolean isTabMyAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMyAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabMyAssessment()
	{
		waitFluentWait(tabMyAssessment);
		click(tabMyAssessment);		
	}
}
