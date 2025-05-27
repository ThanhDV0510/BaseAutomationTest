package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Goalline_Left_Panel extends WebActions {

	public Goalline_Left_Panel(WebDriver driver) {
		super(driver);
     }
	
	By tabGoalLinePosition = By.id("position-goal");
	By tabGoalLineJob = By.id("job-goal");
	
	public boolean isTabPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabGoalLinePosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabPosition()
	{
		waitFluentWait(tabGoalLinePosition);
		click(tabGoalLinePosition);
	}
	
	public boolean isTabJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabGoalLineJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabJob()
	{
		waitFluentWait(tabGoalLineJob);
		click(tabGoalLineJob);
	}
	
}
