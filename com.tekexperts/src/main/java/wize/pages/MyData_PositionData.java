package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData_PositionData extends WebActions {

	public MyData_PositionData(WebDriver driver) {
		super(driver);
     }
	
	By lblPosition = By.xpath("//h5[contains(.,'POSITIONS')]");
		
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

