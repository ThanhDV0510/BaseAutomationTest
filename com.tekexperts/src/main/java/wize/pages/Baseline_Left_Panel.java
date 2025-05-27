package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_Left_Panel extends WebActions {

	public Baseline_Left_Panel(WebDriver driver) {
		super(driver);
     }
	
	By tabPosition = By.id("position-baseline");
	By tabJob = By.id("job-baseline");
	By tabDimension = By.id("dimension-baseline");
	
	public boolean isTabPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabPosition()
	{
		waitFluentWait(tabPosition);
		click(tabPosition);
	}
	
	public boolean isTabJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabJob()
	{
		waitFluentWait(tabJob);
		click(tabJob);
	}
	
	public boolean isTabDimensionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabDimension).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabDimension()
	{
		waitFluentWait(tabDimension);
		click(tabDimension);
	}
}
