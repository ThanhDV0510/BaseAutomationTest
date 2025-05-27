package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class PendingForApproval extends WebActions {

	public PendingForApproval(WebDriver _driver) {
		super(_driver);
	}
	
	By subTabQuestion = By.id("TabQuestion");
	By subTabAssessment = By.id("TabTest");
	By subTabAssessmentResult = By.id("TabTestResult");
	
	public boolean isSubTabQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabQuestion()
	{
		waitFluentWait(subTabQuestion);
		click(subTabQuestion);
	}
	
	
	public boolean isSubTabAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabAssessment()
	{
		waitFluentWait(subTabAssessment);
		click(subTabAssessment);
	}
	
	public boolean isSubTabAssessmentResultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabAssessmentResult).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabAssessmentResult()
	{
		waitFluentWait(subTabAssessmentResult);
		click(subTabAssessmentResult);
	}
}

