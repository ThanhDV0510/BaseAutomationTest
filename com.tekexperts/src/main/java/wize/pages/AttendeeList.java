package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AttendeeList extends WebActions {

	public AttendeeList(WebDriver driver) {
		super(driver);
     }

	By lblAttendeeList = By.xpath("(//div[@id='assessement-trainee-schedule']//h4)[1]");
	
	public boolean isLblAttendeeListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAttendeeList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconX = By.xpath("(//div[@id='assessement-trainee-schedule']//button)[1]");
	By iconViewResult = By.xpath("(//div[@id='trainee-attendee-grid']//td//a)[1]");
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public boolean isIconViewResultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconViewResult).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickIconViewResult()
	{
		waitFluentWait(iconViewResult);
		click(iconViewResult);
	}
}
