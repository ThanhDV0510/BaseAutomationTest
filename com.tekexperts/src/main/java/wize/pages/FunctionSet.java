package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class FunctionSet extends WebActions {

	public FunctionSet(WebDriver driver) {
		super(driver);
     }
	
	By lblFunctionSet = By.id("label-function-set");
	By btnAddFunctionSet = By.id("createFunctionSet");
	By btnDeleteAll = By.id("deleteFunctionSet");
	By cboxAll = By.xpath("//label[@for='btn-check-all']");
	By cboxFirst = By.xpath("(//div[@id='functionset-grid']//td/label)[1]");
	
	public boolean isLblFunctionSetDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblFunctionSet).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddFunctionSetDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddFunctionSet).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnDeleteAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnAddFunctionSet()
	{
		waitFluentWait(btnAddFunctionSet);
		click(btnAddFunctionSet);
		sleep(3);
	}
		
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
	}
	
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public void clickCboxFirst()
	{
		waitFluentWait(cboxFirst);
		click(cboxFirst);
	}
	
	By txtSearchName = By.xpath("(//div[@id='functionset-grid']//span/input)[1]");
	By linkFirstName = By.xpath("(//div[@id='functionset-grid']//td/a)[1]");
	By iconEdit = By.xpath("(//div[@id='functionset-grid']//a[@title='Edit'])[1]");
	By iconDelete = By.xpath("(//div[@id='functionset-grid']//a[@title='Delete'])[1]");
	By iconClone = By.xpath("(//div[@id='functionset-grid']//a[@title='Clone'])[1]");
	
	public boolean isLinkFirstNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstNameClickable(){
		boolean flag = isWebElementClickable(linkFirstName);
		return flag;
	}
	
	public void clickLinkFirstName()
	{
		waitFluentWait(linkFirstName);
		click(linkFirstName);
		sleep(3);
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
	
	public boolean isIconDeleteDisplayed()
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
	
	public boolean isIconCloneDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconClone).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillSearchName(String SearchName)
	{
		waitFluentWait(txtSearchName);
		goTextOn(txtSearchName, SearchName);
		sleep(2);
		click(lblFunctionSet);
	}
	
	public void hoverOnFirstItem()
	{
		waitFluentWait(linkFirstName);
		moveHoverElement(driver.findElement(linkFirstName));
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(linkFirstName);
		moveHoverElement(driver.findElement(linkFirstName));
		waitFluentWait(iconEdit);
		click(iconEdit);
		sleep(3);
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(linkFirstName);
		moveHoverElement(driver.findElement(linkFirstName));
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public void clickIconClone()
	{
		waitFluentWait(linkFirstName);
		moveHoverElement(driver.findElement(linkFirstName));
		waitFluentWait(iconClone);
		click(iconClone);
		sleep(3);
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
		clickByJavaScript(btnYes);
	}
	
	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		clickByJavaScript(btnNo);
	}
}
