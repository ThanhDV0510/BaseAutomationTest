package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData_Contract extends WebActions {

	public MyData_Contract(WebDriver driver) {
		super(driver);
     }
	
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
	
	By lblContract = By.xpath("(//div[@id='Employee-Data-tabstrip-2']//h3)[1]");
	By lblWorkPermit = By.xpath("(//div[@id='Employee-Data-tabstrip-2']//h3)[2]");
	
	public boolean isLblContractDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContract).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblWorkPermitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblWorkPermit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}

