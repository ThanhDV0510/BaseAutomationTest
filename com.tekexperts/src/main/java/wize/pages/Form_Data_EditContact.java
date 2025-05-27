package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditContact extends WebActions {

	public Form_Data_EditContact(WebDriver driver) {
		super(driver);
     }

	By lblEditContact = By.xpath("//div[@id='edit-contact-info']//h4");
				
	public boolean isLblEditContactDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditContact).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtName = By.id("contactPersonName");
	By drplistRelationship = By.xpath("//form[@id='otherContact-form']//div[2]/span");
	By itemRelationship = By.xpath("(//ul[@id='contactRelationshipEdit_listbox']//li)[1]");
	By txtPhone = By.id("contactMobilePhoneEdit");
	By txtEmail = By.id("contactEmailEdit");
	
	public void fillTxtName(String name)
	{
		waitFluentWait(txtName);
		goTextOn(txtName, name);
	}
	
	public void selectDrplistRelationship()
	{
		waitFluentWait(drplistRelationship);
		click(drplistRelationship);
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
	
	By btnCancel = By.xpath("(//div[@id='edit-contact-info']//div[3]//button)[1]");
	By btnSave = By.xpath("(//div[@id='edit-contact-info']//div[3]//button)[2]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}
