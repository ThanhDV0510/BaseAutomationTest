package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTalent_MySkill extends WebActions {

	public MyTalent_MySkill(WebDriver driver) {
		super(driver);
     }
	
	By lblMySkill = By.xpath("//div[@id='Talent-tabstrip-01']//h3");
	
	public boolean isLblMySkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMySkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}

