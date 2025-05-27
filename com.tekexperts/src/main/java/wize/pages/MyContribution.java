package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyContribution extends WebActions {

	public MyContribution(WebDriver driver) {
		super(driver);
     }
	
	By tabQuestion = By.id("contribution-tabstrip-question");

	public boolean isTabQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabQuestion()
	{
		waitFluentWait(tabQuestion);
		click(tabQuestion);
		sleep(2);
	}
}

