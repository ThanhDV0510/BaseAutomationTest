package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_LearningURL extends WebActions {

	public GeneralSettings_LearningURL(WebDriver driver) {
		super(driver);
     }
	
	By lblLearingURL = By.xpath("//section[@id='learning-partial-view']//h3");
	By btnON = By.xpath("(//form[@id='learningUrl-form']/div//label[1])[2]");
	By btnOFF = By.xpath("//form[@id='learningUrl-form']/div//label[2]");
	By txtURL = By.xpath("//form[@id='learningUrl-form']//div[2]//input");
		
	public boolean isLblLearingURLDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblLearingURL).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnON()
	{
		waitFluentWait(btnON);
		click(btnON);
	}
	
	public void clickBtnOFF()
	{
		waitFluentWait(btnOFF);
		click(btnOFF);
	}
	
	By radioON = By.xpath("(//form[@id='learningUrl-form']/div//label[1]/input)[1]");
	By radioOFF = By.xpath("(//form[@id='learningUrl-form']/div//label[2]/input)[1]");
	public boolean getStatusBtnON(){
		boolean flag = true;
		try {
			if (driver.findElement(radioON).getAttribute("disabled") != null) {
				flag = false;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean getStatusBtnOFF(){
		boolean flag = true;
		try {
			if (driver.findElement(radioOFF).getAttribute("disabled") != null) {
				flag = false;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillTxtURL(String url)
	{
		waitFluentWait(txtURL);
		goTextOn(txtURL, url);
	}
	
	public boolean isTxtURLDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtURL).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnSave = By.xpath("(//section[@id='learning-partial-view']//div[3]//button)[2]");
	By btnCancel = By.xpath("(//section[@id='learning-partial-view']//div[3]//button)[1]");
	
	public boolean isBtnSaveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSave).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
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
