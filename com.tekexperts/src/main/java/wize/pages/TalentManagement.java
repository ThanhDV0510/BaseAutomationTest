package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TalentManagement extends WebActions {

	public TalentManagement(WebDriver driver) {
		super(driver);
     }
	
	By tabEmployee = By.xpath("//div[@id='talent-management-tabstrip']//li[@data-pagecode='EMPLOYEE_MANAGEMENT']");
	
	public boolean isTabEmployeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabEmployee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabEmployee()
	{
		waitFluentWait(tabEmployee);
		click(tabEmployee);
	}
	
	By tabTalent = By.xpath("//div[@id='talent-management-tabstrip']//li[@data-pagecode='TalentData']");
	
	public boolean isTabTalentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabTalent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabTalent()
	{
		waitFluentWait(tabTalent);
		click(tabTalent);
	}
	
	By tabPerformanceGrowth = By.xpath("//div[@id='talent-management-tabstrip']//li[@data-pagecode='GrowthAndOptimization']");
	public boolean isTabPerformanceGrowthDisplayed(){
		boolean flag = isWebElementDisplayed(tabPerformanceGrowth);
		return flag;
	}
	public void clickTabPerformanceGrowth()
	{
		waitFluentWait(tabPerformanceGrowth);
		click(tabPerformanceGrowth);
	}
}
