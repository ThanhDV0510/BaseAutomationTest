package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData_Contact extends WebActions {

	public MyData_Contact(WebDriver driver) {
		super(driver);
     }
	
	By lblUnit = By.xpath("//div[@id='Employee-Data-tabstrip-2']//li[11]//span");
	By lblPosition = By.xpath("//div[@id='Employee-Data-tabstrip-2']//li[16]//span");
	By lblContractInfo = By.xpath("(//div[@id='Employee-Data-tabstrip-2']//h5)[1]");
	
	public boolean isLblContractInfoDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContractInfo).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}

