package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTalent_MyCareerPath extends WebActions {

	public MyTalent_MyCareerPath(WebDriver driver) {
		super(driver);
     }
	
	By lblMyCareerPath = By.xpath("(//div[@id='Talent-tabstrip-03']//h3)[1]");
		
	public boolean isLblMyCareerPathDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMyCareerPath).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCreate = By.xpath("(//div[@id='Talent-tabstrip-03']//button)[1]");
	By btnDelete = By.xpath("(//div[@id='career-path-schedule']//div[3]//i)[2]");
	By btnEdit = By.xpath("(//div[@id='career-path-schedule']//div[3]//i)[3]");
	By avatarPosition = By.xpath("(//div[@id='career-path-schedule']//a)[2]");
	
	public void clickBtnCreate()
	{
		waitFluentWait(btnCreate);
		click(btnCreate);
	}
	
	public boolean isBtnCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDelete()
	{
		moveHoverElement(driver.findElement(avatarPosition));
		waitFluentWait(btnDelete);
		click(btnDelete);
	}
	
	public boolean isBtnDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnEdit()
	{
		moveHoverElement(driver.findElement(avatarPosition));
		waitFluentWait(btnEdit);
		click(btnEdit);
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnKeepLearning = By.xpath("(//div[@id='accordion-careerpath-competency']//a)[1]");
	
	public boolean isBtnKeepLearningDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnKeepLearning).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnKeepLearning()
	{
		waitFluentWait(btnKeepLearning);
		click(btnKeepLearning);
	}
	
	//Popup Confirm
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

