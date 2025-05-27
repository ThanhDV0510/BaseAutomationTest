package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_EmployeeCode extends WebActions {

	public GeneralSettings_EmployeeCode(WebDriver driver) {
		super(driver);
     }
	
	By lblEmployeeCode = By.xpath("//section[@id='employeecode-partial-view']//h3");
	
	public boolean isLblEmployeeCodeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployeeCode).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
