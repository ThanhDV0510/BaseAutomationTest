package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData extends WebActions {

	public MyData(WebDriver driver) {
		super(driver);
     }
	
	By subTabPersonalData = By.id("mydata-tabstrip-personal");
	By subTabContact = By.id("mydata-tabstrip-contract");
	By subTabPositionData = By.id("mydata-tabstrip-position");
	By subTabOrganizationChart = By.id("mydata-tabstrip-organizationChart");

	public boolean isSubTabPersonalDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabPersonalData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabPersonalData()
	{
		waitFluentWait(subTabPersonalData);
		click(subTabPersonalData);
	}
	
	
	public boolean isSubTabContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabContact()
	{
		waitFluentWait(subTabContact);
		click(subTabContact);
	}
	
	public boolean isSubTabPositionDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabPositionData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubTabPositionData()
	{
		waitFluentWait(subTabPositionData);
		click(subTabPositionData);
		sleep(5);
	}
	
	public void clickSubTabOrganizationChart()
	{
		waitFluentWait(subTabOrganizationChart);
		click(subTabOrganizationChart);
	}
	
	
	public boolean isSubTabOrganizationChartDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabOrganizationChart).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
}

