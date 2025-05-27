package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class UserManagement extends WebActions {

	public UserManagement(WebDriver driver) {
		super(driver);
     }
	
	By lblUserManagement = By.id("label-manage-user");
	
	public boolean isLblUserManagementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblUserManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblUserManagement()
	{
		waitFluentWait(lblUserManagement);
		click(lblUserManagement);
	}
	
	By btnCreateUser = By.xpath("//i[@class='icon icon-plus3']");
	By linkCreateSingleUser = By.xpath("//a[@id='btn-create-user']");
	By btnImportUser = By.id("btn-import-user");
	By btnUnlock = By.id("btn-lock-user");
	By btnActivate = By.id("btn-active-user");
	By btnDeactivate = By.id("btn-inactive-user");
	By btnChangeStatusFirstUser = By.xpath("(//input[@type='checkbox'])[3]");
	By changeStatusFirstUser = By.xpath("(//span[@class='custom-control-label'])[1]");
	public boolean isBtnCreateUserDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateUser()
	{
		waitFluentWait(btnCreateUser);
		click(btnCreateUser);
		waitFluentWait(linkCreateSingleUser);
		click(linkCreateSingleUser);
	}	
	
	public boolean isBtnImportUserDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnImportUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnImportUser()
	{
		waitFluentWait(btnImportUser);
		click(btnImportUser);
	}
	
	public boolean isBtnUnlockDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnUnlock).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnUnlock()
	{
		waitFluentWait(btnUnlock);
		click(btnUnlock);
	}
	
	public boolean isBtnActivateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnActivate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnActivate()
	{
		waitFluentWait(btnActivate);
		click(btnActivate);
	}
	
	public boolean isBtnDeactivateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeactivate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDeactivate()
	{
		waitFluentWait(btnDeactivate);
		click(btnDeactivate);
	}
		
	By txtFilterEmail = By.xpath("(//div[@id='user-grid']//span/input)[4]");
	By linkFirstUser = By.xpath("(//div[@id='user-grid']//td)[3]");
	By iconEdit = By.xpath("(//div[@id='user-grid']//td[11]/a)[1]");
	By txtFilterEmpCode = By.xpath("//div[@id='user-grid']//input[@aria-label='Employee Code']");
	
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
	
	public void fillFilterEmail(String filteremail)
	{
		waitFluentWait(txtFilterEmail);
		goTextOn(txtFilterEmail, filteremail);
		sleep(2);
		clickLblUserManagement();
	}
	public void fillFilterEmpCode(String code)
	{
		waitFluentWait(txtFilterEmpCode);
		goTextOn(txtFilterEmpCode, code);
		sleep(2);
		clickLblUserManagement();
	}
	
	public void clickIconEdit()
	{
		moveHoverElement(driver.findElement(linkFirstUser));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}	
	
	public void clickLinkFirstUser()
	{
		waitFluentWait(linkFirstUser);
		click(linkFirstUser);
	}	
	
	public boolean isLinkFirstUserDisplayed(){
		boolean flag = isWebElementDisplayed(linkFirstUser);
		return flag;
	}
	
	public boolean isLinkFirstUserClickable(){
		By linkUser = By.xpath("(//div[@id='user-grid']//td/a)[1]");
		boolean flag = isWebElementClickable(linkUser);
		return flag;
	}
	
	public void openEditPopup(String filteremail)
	{
		fillFilterEmail(filteremail);
		clickIconEdit();
	}
	
	public boolean isBtnChangeStatusFirstUserDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnChangeStatusFirstUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean getStatusBtnChangeFirstUser(){
		boolean flag = false;
		String stt = driver.findElement(btnChangeStatusFirstUser).getAttribute("checked");
		try {
			if(stt!= null){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void deactivateFirstUser(){
		waitFluentWait(changeStatusFirstUser);
		if(getStatusBtnChangeFirstUser()){
			clickByJavaScript(changeStatusFirstUser);
		}
	}
	
	public void activateFirstUser(){
		waitFluentWait(changeStatusFirstUser);
		if(!getStatusBtnChangeFirstUser()){
			clickByJavaScript(changeStatusFirstUser);
		}
	}
	
	By iconControlBoard = By.id("link-control-board");
	public void clickIconControlBoard(){
		waitFluentWait(iconControlBoard);
		click(iconControlBoard);
	}
	
	By firstCheckboxSelect = By.xpath("(//div[@id='user-grid']//td[@title='Select']/label)[1]");
	public void clickFirstCheckboxSelect(){
		waitFluentWait(firstCheckboxSelect);
		click(firstCheckboxSelect);
	}
	By btnYesConfirmUnlock = By.xpath("//button[contains(.,'YES')]");
	public void clickBtnYesConfirmUnlock(){
		waitFluentWait(btnYesConfirmUnlock);
		click(btnYesConfirmUnlock);
	}
	By btnYesConfirmActivate = By.xpath("(//button[contains(.,'YES')])[2]");
	public void clickBtnYesConfirmActivate(){
		waitFluentWait(btnYesConfirmActivate);
		click(btnYesConfirmActivate);
	}
}
