package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditProfile extends WebActions {

	public Form_Data_EditProfile(WebDriver driver) {
		super(driver);
     }

	By lblEditProfile = By.xpath("//div[@id='edit-profile']//h4");
				
	public boolean isLblEditProfileDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditProfile).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtFirstName = By.id("firstName");
	By txtMiddleName = By.id("middleName");
	By txtLastName = By.id("lastName");	
	
	public void fillTxtFirstName(String firstName)
	{
		waitFluentWait(txtFirstName);
		ClickElementAndType(txtFirstName, firstName);
	}
	
	public void fillTxtMiddleName(String middleName)
	{
		waitFluentWait(txtMiddleName);
		ClickElementAndType(txtMiddleName, middleName);
	}
	
	public void fillTxtLastName(String lastName)
	{
		waitFluentWait(txtLastName);
		ClickElementAndType(txtLastName, lastName);
	}
	
	By txtMobilePhone = By.id("mobilePhone");
	By txtHomePhone = By.id("homePhone");
	
	public void fillTxtMobilePhone(String mobilePhone)
	{
		waitFluentWait(txtMobilePhone);
		goTextOn(txtMobilePhone, mobilePhone);
	}
	
	public void fillTxtHomePhone(String homePhone)
	{
		waitFluentWait(txtHomePhone);
		ClickElementAndType(txtHomePhone, homePhone);
	}
	
	By btnCancel = By.id("cancelProfile");
	By btnSave = By.id("saveProfile");
	By btnClose = By.xpath("(//div[@id='edit-profile']//button)[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}
