package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddMoreCreatePath extends WebActions {

	public Form_AddMoreCreatePath(WebDriver driver) {
		super(driver);
     }
	
	By lblAddMoreCreatePath = By.xpath("//div[@id='add-career-path']//h4");
		
	public boolean isLblAddMoreCreatePathDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAddMoreCreatePath).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By drplistNextPosition = By.xpath("(//form[@id='add-career-path-position-form']//span[2]/span)[1]");
	By txtSearchNextPosition = By.xpath("//div[@id='ddlToPosition-list']//input");
	By itemFirstNext = By.xpath("(//ul[@id='ddlToPosition_listbox']//li)[1]");
	
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
	
	public void searchNextPosition(String nextposition)
	{
		waitFluentWait(txtSearchNextPosition);
		ClickElementAndType(txtSearchNextPosition, nextposition);
	}
	
	By drplstAfterPosition = By.xpath("(//form[@id='add-career-path-position-form']//span[2]/span)[2]");
	By txtSearchAfterPosition = By.xpath("//div[@id='ddlFromPosition-list']//input");
	By itemFirstAfter = By.xpath("(//ul[@id='ddlFromPosition_listbox']//li)[1]");
	
	public void clickDrplstAfterPosition()
	{
		waitFluentWait(drplstAfterPosition);
		click(drplstAfterPosition);
	}
	
	public void searchtfterPosition(String afterposition)
	{
		waitFluentWait(txtSearchAfterPosition);
		ClickElementAndType(txtSearchAfterPosition, afterposition);
	}
	
	public void clickItemFirstAfter()
	{
		waitFluentWait(itemFirstAfter);
		click(itemFirstAfter);
	}	
		
	By btnClose = By.xpath("(//div[@id='add-career-path']//button)[1]");
	By btnCancel = By.xpath("(//div[@id='add-career-path']//button)[2]");
	By btnSave = By.xpath("(//div[@id='add-career-path']//button)[3]");
	
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
	
	//String urlWize = "https://wize5ypmt3tnj4iw4.azurewebsites.net/MyTalent/MySkill360";
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}

