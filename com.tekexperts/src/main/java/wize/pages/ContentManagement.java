package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ContentManagement extends WebActions {

	public ContentManagement(WebDriver driver) {
		super(driver);
     }

	By lblContentList = By.id("label-content-list");
		
	public boolean isLblContentListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContentList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By menuOnboardingWelcomeLetter = By.id("systemContentManagement");
	
	public void clickMenuOnboardingWelcomeLetter()
	{
		waitFluentWait(menuOnboardingWelcomeLetter);
		click(menuOnboardingWelcomeLetter);
	}
	
	public boolean isMenuOnboardingWelcomeLetterDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(menuOnboardingWelcomeLetter).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
