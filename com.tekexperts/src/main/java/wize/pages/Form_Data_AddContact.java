package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddContact extends WebActions {

	public Form_Data_AddContact(WebDriver driver) {
		super(driver);
     }

	By lblAddContact = By.xpath("//div[@id='add-contact-info']//h4");
				
	public boolean isLblAddContactDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddContact).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtName = By.id("contactPersonNameCreate");
	By drplistRelationship = By.xpath("//div[@id='add-contact-info']//div[2]/span");
	By itemRelationship = By.xpath("(//ul[@id='contactRelationship_listbox']//li)[1]");
	By txtPhone = By.id("contactMobilePhone");
	By txtEmail = By.id("contactEmail");
	
	public void fillTxtName(String name)
	{
		waitFluentWait(txtName);
		ClickElementAndType(txtName, name);
	}
	
	public void selectRelationship()
	{
		waitFluentWait(drplistRelationship);
		click(drplistRelationship);
		sleep(3);
		click(itemRelationship);
	}
	
	public void fillTxtPhone(String phone)
	{
		waitFluentWait(txtPhone);
		ClickElementAndType(txtPhone, phone);
	}
	
	public void fillTxtEmail(String email)
	{
		waitFluentWait(txtEmail);
		ClickElementAndType(txtEmail, email);
	}
	
	By btnCancel = By.id("cancelOtherContact");
	By btnSavenCreateNew = By.id("saveAndCreateNewOtherContact");
	By btnSave = By.id("saveOtherContact");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}

	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}
