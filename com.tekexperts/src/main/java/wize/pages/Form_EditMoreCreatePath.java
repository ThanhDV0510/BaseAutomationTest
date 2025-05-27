package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditMoreCreatePath extends WebActions {

	public Form_EditMoreCreatePath(WebDriver driver) {
		super(driver);
     }
	
	By lblEditMoreCreatePath = By.xpath("//div[@id='update-career-path']//h4");
		
	public boolean isLblEditMoreCreatePathDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditMoreCreatePath).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By drplistNextPosition = By.xpath("(//form[@id='update-career-path-position-form']//span[2]/span)[1]");
	By txtSearchNextPosition = By.xpath("//div[@id='ddlUpdateToPosition_listbox']//input");
	By itemFirstNext = By.xpath("(//ul[@id='ddlUpdateToPosition_listbox']//li)[1]");
	By itemSecondNext = By.xpath("(//ul[@id='ddlUpdateToPosition_listbox']//li)[2]");
	
	public void clickDrplistNextPosition()
	{
		waitFluentWait(drplistNextPosition);
		click(drplistNextPosition);
	}
	
	public void clickItemFirstNext()
	{
		waitFluentWait(itemFirstNext);
		click(itemFirstNext);
	}
	
	public void clickItemSecondNext()
	{
		waitFluentWait(itemSecondNext);
		click(itemSecondNext);
	}
	
	public void searchNextPosition(String nextposition)
	{
		waitFluentWait(txtSearchNextPosition);
		ClickElementAndType(txtSearchNextPosition, nextposition);
	}
			
	By btnClose = By.xpath("(//div[@id='update-career-path']//button)[1]");
	By btnCancel = By.xpath("(//div[@id='update-career-path']//button)[2]");
	By btnSave = By.xpath("(//div[@id='update-career-path']//button)[3]");
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}

