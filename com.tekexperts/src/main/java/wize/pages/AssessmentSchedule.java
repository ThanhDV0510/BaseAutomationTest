package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AssessmentSchedule extends WebActions {

	public AssessmentSchedule(WebDriver driver) {
		super(driver);
     }

	By lblAssessment = By.xpath("(//div[@id='assessement-schedule']//h4)[1]");
	
	public boolean isLblAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconX = By.xpath("(//div[@id='assessement-schedule']//i)[1]");
	By btnAdd = By.xpath("(//div[@id='assessement-schedule']//button[@title='Add Schedule'])");
	By searchName = By.xpath("(//div[@id='assessement-schedule']//div[2]//input)[1]");
	
	public void searchName(String name)
	{
		waitFluentWait(searchName);
		goTextOn(searchName, name);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public boolean isBtnAddDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAdd).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitFluentWait(btnAdd);
		click(btnAdd);
	}
	
	By iconCancel = By.xpath("(//div[@id='assessement-schedule']//a[@title='Cancel'])[1]");
	By iconEdit = By.xpath("(//div[@id='assessement-schedule']//a[@title='Edit Schedule'])[1]");
	By iconAssign = By.xpath("(//div[@id='assessement-schedule']//a[@title='Assign Attendee'])[1]");
	By iconLinkAttendee = By.xpath("(//a[@id='link-attendee'])[1]");
	By linkAttendee = By.xpath("(//div[@id='assessement-schedule']//td[4]//a)[1]");
	By linkAttendee2 = By.xpath("(//div[@id='assessement-schedule']//td[4]//a)[2]");
	By iconDots = By.xpath("//div[@id='assessment-schedule-grid']//td[6]");
	By iconDots1 = By.xpath("//div[@id='assessment-schedule-grid']//td[6]");
	
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
	
	public boolean isIconLinkAttendeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconLinkAttendee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkAttendeeClickable(){
		boolean flag = false;
		try {
			if (isWebElementClickable(linkAttendee)) {
				
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkAttendee()
	{
		waitFluentWait(linkAttendee);
		click(linkAttendee);
	}
	
	public void clickLinkAttendee2()
	{
		waitFluentWait(linkAttendee2);
		click(linkAttendee2);
	}
	
	public void clickIconCancel()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconCancel);
		click(iconCancel);
	}
	
	public void clickIconCancel1()
	{
		moveHoverElement(driver.findElement(iconDots1));
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
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public void clickIconEdit1()
	{
		moveHoverElement(driver.findElement(iconDots1));
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
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconAssign);
		click(iconAssign);
		sleep(2);
	}
	
	public void clickIconLinkAttendee()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconLinkAttendee);
		click(iconLinkAttendee);
		sleep(2);
	}
	
	By lblCancelled = By.xpath("//div[@id='assessment-schedule-grid']//td[5]//span");
	
	public boolean isLblCancelledDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCancelled).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
	By btnNo = By.xpath("//button[contains(.,'NO')]");
	
	public boolean isLblConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblConfirmation).size() > 0) {
				flag = true;
					}
			} catch (Exception e) {
				return flag;
			}	
		return flag;
	}
		
	public void clickBtnYes()
	{
		waitFluentWait(btnYes);
		click(btnYes);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}
}
