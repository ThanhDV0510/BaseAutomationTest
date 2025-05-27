package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MySkillGap extends WebActions {

	public MySkillGap(WebDriver driver) {
		super(driver);
     }

	By lblUnit = By.xpath("//div[@id='dashboard-container']//tr[9]");
	By lblPoistion = By.xpath("//div[@id='dashboard-container']//strong");
	
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
			if (driver.findElements(lblPoistion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
