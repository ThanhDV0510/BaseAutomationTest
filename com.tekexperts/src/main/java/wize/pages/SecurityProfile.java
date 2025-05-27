package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class SecurityProfile extends WebActions {

	public SecurityProfile(WebDriver driver) {
		super(driver);
     }
	
	By lblSecurityProfile = By.id("label-manage-security-profile");
	
	public boolean isLblSecurityProfileDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSecurityProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnAdd = By.id("btnCreateSecurityProfile");
	By btnDeleteAll = By.id("btn-delete-security-profile");
	
	By cboxAll = By.xpath("//div[@id='security-profile-grid']//th/label");
	By cboxFirst = By.xpath("(//div[@id='security-profile-grid']//td/label)[1]");
	By txtSearch = By.xpath("//div[@id='security-profile-grid']//th[3]//span[1]/input");
	
	By iconEdit = By.xpath("(//div[@id='security-profile-grid']//a[@title='Edit'])[1]");
	By iconDelete = By.xpath("(//div[@id='security-profile-grid']//a[@title='Delete'])[1]");
	By iconClone = By.xpath("(//div[@id='security-profile-grid']//a[@title='Clone'])[1]");
	By iconDots = By.xpath("(//div[@id='security-profile-grid']//td)[5]");
	By itemFirst = By.xpath("(//div[@id='security-profile-grid']//td/a)[1]");
	
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
	
	public boolean isItemFirstDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirst).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isItemFirstClickable(){
		boolean flag = isWebElementClickable(itemFirst);
		return flag;
	}
	
	public void clickItemFirst()
	{
		waitFluentWait(itemFirst);
		click(itemFirst);
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
		moveHoverElement(driver.findElement(iconDots));
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
		sleep(3);
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
	
	public void clickIconDots()
	{
		waitFluentWait(iconDots);
		click(iconDots);
	}
		
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
		sleep(3);
	}
	
	public void clickCboxFirst()
	{
		waitFluentWait(cboxFirst);
		click(cboxFirst);
	}
	
	public void fillSearch(String search)
	{
		waitFluentWait(txtSearch);
		goTextOn(txtSearch, search);
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
			if (driver.findElements(lblConfirmation).size() > 0) 
			{
				flag = true;
			}
			} catch (Exception e) 
			{
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
