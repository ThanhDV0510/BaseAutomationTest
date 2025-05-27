package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTalent_MySkill360 extends WebActions {

	public MyTalent_MySkill360(WebDriver driver) {
		super(driver);
     }
	
	By lblMyCompetency = By.xpath("(//div[@id='Talent-tabstrip-02']//h3)[1]");
	
	public boolean isLblMyCompetencyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMyCompetency).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By lblBaseline = By.xpath("(//div[@id='accordion-azure-competency']//h3)[1]");
	By btnKeepLearing = By.id("keepLearningUrlSkill360");
	
	public boolean isLblBaselineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnKeepLearingDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnKeepLearing).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnKeepLearing()
	{
		waitFluentWait(btnKeepLearing);
		click(btnKeepLearing);
	}
}

