package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData_OrganizationChart extends WebActions {

	public MyData_OrganizationChart(WebDriver driver) {
		super(driver);
     }
	
	By lblOrganizationChart = By.xpath("(//div[@id='Employee-Data-tabstrip-4']//h5)[1]");
	
	public boolean isLblOrganizationChartDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblOrganizationChart).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}

