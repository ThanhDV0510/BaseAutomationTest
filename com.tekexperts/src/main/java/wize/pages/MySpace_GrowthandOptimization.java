package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MySpace_GrowthandOptimization extends WebActions {

	public MySpace_GrowthandOptimization(WebDriver driver) {
		super(driver);
     }
	
	By lblGoals = By.xpath("//h5[contains(.,'GOALS')]");
	
	public boolean isLblMyGoalsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblGoals).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnAddNewGoals = By.xpath("//i[contains(@class,'icon icon-plus3')]");
		
	public void clickBtnAddNewGoals()
	{
		waitFluentWait(btnAddNewGoals);
		click(btnAddNewGoals);
	}
	
	By tabGrowthOptimization=By.xpath("//a[@class='k-link'][contains(.,'Growth and Optimization')]");
	public void clickTabGrowthOptimization()
	{
		waitFluentWait(tabGrowthOptimization);
		click(tabGrowthOptimization);
	}
	
	By btnDeleteAll = By.xpath("(//i[contains(@class,'icon icon-bin')])[1]");
	By btnCheckAll = By.xpath("//label[contains(@title,'Select current page')]");
	
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
	}
	
	public void clickBtnCheckAll()
	{
		waitFluentWait(btnCheckAll);
		click(btnCheckAll);
	}
	By lblStatus_Draft=By.xpath("//span[contains(.,'Draft')]");
	public boolean isLblStatusDraftDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblStatus_Draft);
			if ( driver.findElement(lblStatus_Draft).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}

