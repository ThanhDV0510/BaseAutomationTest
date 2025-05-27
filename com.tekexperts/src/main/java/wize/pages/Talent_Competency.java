package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Talent_Competency extends WebActions {

	public Talent_Competency(WebDriver driver) {
		super(driver);
     }
	
	By lblCompetencyManagement = By.xpath("(//div[@id='talent-data-tabstrip']//h5)[1]");
	
	public boolean isSubTabCompetencyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCompetencyManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	By lblEmployee = By.xpath("(//div[@id='talent-data-tabstrip']//strong)[1]");
	
	public boolean isLblEmployeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
}
