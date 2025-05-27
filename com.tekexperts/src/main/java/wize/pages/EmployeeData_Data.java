package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeData_Data extends WebActions {

	public EmployeeData_Data(WebDriver driver) {
		super(driver);
     }
	
	By tabPersonal = By.xpath("(//div[@id='emp-data-tabstrip']//li)[1]");
	By tabContract = By.xpath("(//div[@id='emp-data-tabstrip']//li)[2]");
	By tabPosition = By.xpath("(//div[@id='emp-data-tabstrip']//li)[3]");
	By tabOrganizationChart = By.xpath("(//div[@id='emp-data-tabstrip']//li)[4]");
	
	public boolean isTabPersonalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabPersonal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabPersonal()
	{
		waitFluentWait(tabPersonal);
		click(tabPersonal);
	}
	
	public boolean isTabContractDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabContract).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabContract()
	{
		waitFluentWait(tabContract);
		click(tabContract);
	}
	
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
	
	public boolean isTabOrganizationChartDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabOrganizationChart).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabOrganizationChart()
	{
		waitFluentWait(tabOrganizationChart);
		click(tabOrganizationChart);
	}

}
