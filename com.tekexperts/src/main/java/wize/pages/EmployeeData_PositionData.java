package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeData_PositionData extends WebActions {

	public EmployeeData_PositionData(WebDriver driver) {
		super(driver);
     }
	
	By lblPosition = By.xpath("//h5[contains(.,'POSITIONS')]");
	
	//List View
	By txtSearchPositions = By.xpath("//input[contains(@data-text-field,'position')]");
	By linkFirstPosition = By.xpath("(//a[contains(@data-target-box,'#position-assignment-details')])[1]");
	By iconEidt = By.id("action-edit");
	By iconDelete = By.id("action-delete");
	By btnAssignPosition = By.id("btnAssignPosition");
	By btnGridView = By.xpath("//i[@class='icon icon-grid2']");
	By btnListView = By.xpath("//i[@class='icon icon-grid2']");
	
	By lblTestAutomation = By.xpath("//a[contains(.,'Testing Automation')]");
	
	public boolean isLblTestAutomationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTestAutomation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnGridView()
	{
		waitFluentWait(btnGridView);
		click(btnGridView);
	}
	
	public void clickBtnListView()
	{
		waitFluentWait(btnListView);
		click(btnListView);
	}
	
	public boolean isLblPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstPosition()
	{
		waitFluentWait(linkFirstPosition);
		click(linkFirstPosition);
	}
	
	public void clickBtnAssignPosition()
	{
		waitFluentWait(btnAssignPosition);
		click(btnAssignPosition);
	}
	
	public void clickIconEidt()
	{
		moveHoverElement(driver.findElement(linkFirstPosition));
		waitFluentWait(iconEidt);
		click(iconEidt);
	}
	
	public void clickIconDelete()
	{
		moveHoverElement(driver.findElement(linkFirstPosition));
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public void fillSearchPositions(String searchpoisition)
	{
		waitFluentWait(txtSearchPositions);
		goTextOn(txtSearchPositions, searchpoisition);
		sleep(5);
		click(lblPosition);
	}
	
	//Grid View
	By linkPositionsGrid = By.xpath("//h6[@data-bind='events:{ click: employeePositionVM.viewPositionAssignDetailFromListView}']");
	By iconEditGrid = By.xpath("//button[@data-bind='events: {click: employeePositionVM.editPositionAssignment}']");
	By iconDeleteGrid = By.xpath("//button[@data-bind='events:{click: employeePositionVM.deletePositionAssignmentFromListView}']");
	
	public boolean isIconEidtGridDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditGrid).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkPositionsGrid()
	{
		waitFluentWait(linkPositionsGrid);
		click(linkPositionsGrid);
	}
	
	public void clickIconEditGrid()
	{
		waitFluentWait(iconEditGrid);
		click(iconEditGrid);
	}
	
	public void clickIconDeleteGrid()
	{
		waitFluentWait(iconDeleteGrid);
		click(iconDeleteGrid);
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

	public void deletePositions()
	{
		clickIconDelete();
		clickBtnYes();
	}

}
