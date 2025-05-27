package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_TestScheduleDetail extends WebActions {

	public Form_TestScheduleDetail(WebDriver driver) {
		super(driver);
     }

	By lblTestScheduleDetails = By.xpath("//div[@id='view-test-schedule']//h4");
	
	public boolean isLblTestScheduleDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTestScheduleDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconCancel = By.xpath("(//div[@id='view-test-schedule']//button)[1]");
	By iconEdit = By.xpath("(//div[@id='view-test-schedule']//button)[2]");
	By iconAssign = By.xpath("(//div[@id='view-test-schedule']//button)[3]");
	By iconX = By.xpath("(//div[@id='view-test-schedule']//button)[4]");
	
	public boolean isIconXDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconX).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public boolean isIconCancelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconCancel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconCancel()
	{
		waitFluentWait(iconCancel);
		click(iconCancel);
	}
	
	public boolean isIconEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public boolean isIconAssignDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconAssign).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconAssign()
	{
		waitFluentWait(iconAssign);
		click(iconAssign);
	}
}
