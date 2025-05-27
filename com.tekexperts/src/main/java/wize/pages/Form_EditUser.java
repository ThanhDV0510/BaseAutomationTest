package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditUser extends WebActions {

	public Form_EditUser(WebDriver driver) {
		super(driver);
     }

	By lblEditUser = By.id("label-edit-user");
	
	public boolean isLblEditUserDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By drplistDefault = By.xpath("(//form[@id='frmEditUser']//div[4]//span)[1]");
	By txtSearchDefault = By.xpath("//div[@id='securityProfileViewEdit-list']//input");
	By btnSave = By.id("btnUpdateUser");
	By btnCancel = By.xpath("//div[@id='user-detail-box']//button[@id='btnCancelUpdate']");
	By itemFirstDefault = By.xpath("//ul[@id='securityProfileViewEdit_listbox']//li[1]");	
	By defaultSecurityProfile = By.xpath("(//span[@class='k-widget k-dropdown form-control']/span/span[@class='k-input'])[5]");
		
	public void fillSearchDefault(String searchdefault)
	{
		waitFluentWait(txtSearchDefault);
		ClickElementAndType(txtSearchDefault, searchdefault);
	}
	
	public void clickDrplistDefault()
	{
		waitFluentWait(drplistDefault);
		click(drplistDefault);
	}	
	
	public void clickItemFirstDefault()
	{
		waitFluentWait(itemFirstDefault);
		click(itemFirstDefault);
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
	
	public void updateFunctionSet(String searchdefault)
	{
		clickDrplistDefault();
		sleep(1);
		fillSearchDefault("binh full permission");
		sleep(1);
		clickItemFirstDefault();
		clickDrplistDefault();
		fillSearchDefault(searchdefault);
		sleep(1);
		clickItemFirstDefault();
		sleep(1);
		clickBtnSave();
	}
}
	
	
