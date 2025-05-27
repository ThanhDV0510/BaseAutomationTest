package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditAddress extends WebActions {

	public Form_Data_EditAddress(WebDriver driver) {
		super(driver);
     }

	By lblEditAddress = By.xpath("//div[@id='edit-address-info']//h4");
				
	public boolean isLblEditAddressDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditAddress).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By drplistType = By.xpath("(//form[@id='address-form-edit']//span[2])[1]");
	By itemHome = By.xpath("(//ul[@id='typeEdit_listbox']//li)[1]");
	By itemMailing = By.xpath("(//ul[@id='typeEdit_listbox']//li)[1]");
	By itemWork = By.xpath("(//ul[@id='typeEdit_listbox']//li)[1]");
	
	public void clickDrplistType()
	{
		waitFluentWait(drplistType);
		click(drplistType);
	}
	
	public void clickItemHome()
	{
		waitFluentWait(itemHome);
		click(itemHome);
	}
	
	public void clickItemMailing()
	{
		waitFluentWait(itemMailing);
		click(itemMailing);
	}
	
	public void clickItemWork()
	{
		waitFluentWait(itemWork);
		click(itemWork);
	}
	
	By txtZipCode = By.id("postalCodeEdit");
	By txtStreet = By.id("streetEdit");
	By txtCity = By.id("cityEdit");
	By txtState = By.id("stateEdit");
	
	public void fillTxtZipCode(String zipcode)
	{
		waitFluentWait(txtZipCode);
		ClickElementAndType(txtZipCode, zipcode);
	}
	
	public void fillTxtStreet(String street)
	{
		waitFluentWait(txtStreet);
		goTextOn(txtStreet, street);
	}
	
	public void fillTxtCityl(String city)
	{
		waitFluentWait(txtCity);
		ClickElementAndType(txtCity, city);
	}
	
	public void fillTxtState(String state)
	{
		waitFluentWait(txtState);
		ClickElementAndType(txtState, state);
	}
	
	By drplistCountry = By.xpath("(//form[@id='address-form-edit']//span[2])[2]");
	By itemCountry = By.xpath("(//ul[@id='countryCodeEdit_listbox']//li)[1]");	
		
	public void selectDrplistCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		click(itemCountry);
	}
		
	By btnCancel = By.xpath("(//div[@id='edit-address-info']//div[3]//button)[1]");
	By btnSave = By.xpath("(//div[@id='edit-address-info']//div[3]//button)[2]");
	
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
