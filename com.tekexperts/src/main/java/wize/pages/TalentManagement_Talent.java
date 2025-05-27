package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TalentManagement_Talent extends WebActions {

	public TalentManagement_Talent(WebDriver driver) {
		super(driver);
     }
	
	By subTabCompetency = By.xpath("(//div[@id='talent-data-tabstrip']//a)[1]");
	
	public boolean isSubTabCompetencyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabCompetency).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}	
}
