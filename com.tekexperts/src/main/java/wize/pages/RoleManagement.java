package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class RoleManagement extends WebActions {

	public RoleManagement(WebDriver driver) {
		super(driver);
     }
	
	By lblRoleManagement = By.id("label-manage-role");
	
	public boolean isLblRoleManagementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblRoleManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtFilterRoleName = By.xpath("(//div[@id='role-grid']//span/input)[3]");
	By linkFirstRole = By.xpath("(//div[@id='role-grid']//td)[3]");
	By iconEdit = By.xpath("(//div[@id='role-grid']//a[@title='Edit'])[1]");
	By iconDelete = By.xpath("(//div[@id='role-grid']//a[@title='Delete'])[1]");
	By iconClone = By.xpath("(//div[@id='role-grid']//a[@title='Clone'])[1]");
	By iconDots = By.xpath("(//div[@id='role-grid']//td)[6]");
	By cboxAll = By.xpath("//div[@id='role-grid']//th/label");
	By cboxFirst = By.xpath("(//div[@id='role-grid']//td/label)[1]");
	By btnAdd = By.id("btn-create-role");
	By btnDeleteAll = By.id("btn-delete-role");
	
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
	
	public boolean isLinkFirstRoleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstRole).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkFirstRoleClickable(){
		By firstRole = By.xpath("(//div[@id='role-grid']//td/a)[1]");
		boolean flag = isWebElementClickable(firstRole);
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitFluentWait(btnAdd);
		click(btnAdd);
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
	
	public void clickIconDelete()
	{
		waitFluentWait(iconDelete);
		click(iconDelete);
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
	
	public void clickIconClone()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconClone);
		click(iconClone);
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
		sleep(1);
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
	
	public boolean isCboxAllSelected(){
		boolean flag = false;
		try {
			if(driver.findElement(cboxAll).isSelected()){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickCboxFirst()
	{
		waitFluentWait(cboxFirst);
		click(cboxFirst);
	}
			
	public void fillFilterRoleName(String filterrolename)
	{
		waitFluentWait(txtFilterRoleName);
		goTextOn(txtFilterRoleName, filterrolename);
		sleep(5);
	}
			
	public void clickLinkFirstRole()
	{
		waitFluentWait(linkFirstRole);
		click(linkFirstRole);
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
	
	public boolean checkBtnYesAvailble()
	{
		try {
			if (isElementVisible(btnYes)==true)
			{
				return true;
			}	
	            else
	        {
	          	return false;
	        }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	            return false;
	        }
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
	
	By titleRoleDetail = By.xpath("//div[@id='role-slide-viewEdit']//h4");
	public boolean isTitleRoleDetailDisplayed(){
		boolean flag = isWebElementDisplayed(titleRoleDetail);
		return flag;
	}
	By iconCloseRoleDetail = By.xpath("//div[@id='role-slide-viewEdit']//button[@id='btn-close-edit-form']");
	public void clickIconCloseRoleDetailDisplayed(){
		waitFluentWait(iconCloseRoleDetail);
		click(iconCloseRoleDetail);
	}
}
