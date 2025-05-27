package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_GoalLineDimensionDetail extends WebActions{

	public Form_GoalLineDimensionDetail(WebDriver driver) {
		super(driver);
	}

	By titleDetailGoal = By.xpath("//div[@id='detail-goal']//h4[@class='section-title']");
	By iconDelete = By.xpath("//button[@title='Delete']");
	By btnYes = By.xpath("(//button[@class='k-button k-primary'])[2]");
	By btnNo = By.xpath("//button[@class='k-button']");
	By iconClose = By.xpath("//button[@data-bind='click: closeForm']");
	
	
	public boolean isTitleDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleDetailGoal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconDelete(){
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public void clickIconClose(){
		waitFluentWait(iconClose);
		click(iconClose);
	}
	
	public boolean compareTextPopupDeleteFirstGoal(){
		boolean flag = false;
		String contentMsg = driver.findElement(By.xpath("(//div[@id='dialogBoxDeleteGoalLine'])[1]")).getText();
		try {
			if(contentMsg.equals("Are you sure you want to delete selected goal? If you continue, data will be lost permanently and cannot be recovered.")){
				flag = true;
				waitFluentWait(btnNo);
				click(btnNo);
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void cancelDeleteFirstGoal(){
		waitFluentWait(btnNo);
		click(btnNo);
	}
	
	public void deleteFirstGoal(){
		waitFluentWait((btnYes));
		click((btnYes));
	}
}
