package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeData extends WebActions {

	public EmployeeData(WebDriver driver) {
		super(driver);
     }
	
	By lblEmployeeSpace = By.xpath("//div[@id='emp-space-header']//h4");
	
	public boolean isLblEmployeeSpaceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployeeSpace).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	By tabData = By.xpath("(//div[@id='emp-space-tabstrip']//a)[1]");
	
	public boolean isTabDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabData()
	{
		waitFluentWait(tabData);
		click(tabData);
	}
}
