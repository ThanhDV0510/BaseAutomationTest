package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_QuestionDetails extends WebActions {

	public Form_QuestionDetails(WebDriver driver) {
		super(driver);
     }
	
	By lblQuestionDetails = By.xpath("//div[@id='detail-question']//h4");
	By tabQuestionContent = By.xpath("(//div[@id='detail-question']//li//span)[2]");
		
	public boolean isLblQuestionDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestionDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabQuestionContent()
	{
		waitFluentWait(tabQuestionContent);
		clickByJavaScript(tabQuestionContent);
	}
		
	By iconReject = By.xpath("//div[@id='detail-question']//i[@class='icon icon-blocked']");
	By iconEdit = By.xpath("//div[@id='detail-question']//i[@class='icon icon-pencil7']");
	By iconDelete = By.xpath("//div[@id='detail-question']//i[@class='icon icon-bin']");
	By iconMove = By.xpath("//div[@id='detail-question']//i[@class='icon icon-toggle open-other-slidingbox']");
	By iconX = By.xpath("//div[@id='detail-question']//i[@class='icon icon-cross2']");
	
	public boolean isIconRejectsDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconReject).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEditDetailDisplayed()
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

	public boolean isIconDeleteDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconMoveDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconMove).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickIconReject()
	{
		waitFluentWait(iconReject);
		click(iconReject);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public void clickIconMove()
	{
		waitFluentWait(iconMove);
		click(iconMove);
	}
	
	
	//Popup Confirm Delete
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
			clickByJavaScript(btnYes);
		}

		public void clickBtnNo()
		{
			waitFluentWait(btnNo);
			clickByJavaScript(btnNo);
		}
}
