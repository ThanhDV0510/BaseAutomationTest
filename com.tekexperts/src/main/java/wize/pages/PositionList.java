package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class PositionList extends WebActions {

	public PositionList(WebDriver driver) {
		super(driver);
     }
	
	By lblPostionList = By.id("label-position-list");
	By btnCreate = By.id("btn-create-position");
	By iconEdit = By.xpath("(//a[@id='action-edit'])[1]");
	By iconDelete = By.xpath("(//a[@id='action-delete'])[1]");
	By iconClone = By.xpath("(//a[@id='action-clone'])[1]");
	By linkFirstPostion = By.xpath("(//div[@id='position-list-grid']//td/a)[1]");
	By txtSearchPosition = By.xpath("(//div[@id='position-list-grid']//input)[1]");
		
	public void fillSearchPosition(String searchposition)
	{
		waitFluentWait(txtSearchPosition);
		goTextOn(txtSearchPosition, searchposition);
		sleep(5);
		click(lblPostionList);
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
	
	public boolean isIconCloneDisplayed(){
		boolean flag = isWebElementDisplayed(iconClone);
		return flag;
	}
	
	public boolean isLblPostionListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPostionList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstPostionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstPostion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstPostion()
	{
		waitFluentWait(linkFirstPostion);
		click(linkFirstPostion);
		sleep(3);
	}
	
	public boolean isLinkFirstPositionClickable(){
		boolean flag = isWebElementClickable(linkFirstPostion);
		return flag;
	}
	
	public void clickBtnCreate()
	{
		waitFluentWait(btnCreate);
		click(btnCreate);
		sleep(3);
	}
	
	public void clickIconClone()
	{
		moveHoverElement(driver.findElement(linkFirstPostion));
		waitFluentWait(iconClone);
		click(iconClone);
		sleep(3);
	}
	
	public void clickIconEdit()
	{
		moveHoverElement(driver.findElement(linkFirstPostion));
		waitFluentWait(iconEdit);
		click(iconEdit);
		sleep(3);
	}
	
	public void clickIconDelete()
	{
		moveHoverElement(driver.findElement(linkFirstPostion));
		waitFluentWait(iconDelete);
		click(iconDelete);
		sleep(3);
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
		click(btnYes);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}

	public void deletePosition()
	{
		clickIconDelete();
		clickBtnYes();
	}
}
