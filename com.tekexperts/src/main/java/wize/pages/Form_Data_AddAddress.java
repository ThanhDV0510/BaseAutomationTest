package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddAddress extends WebActions {

	public Form_Data_AddAddress(WebDriver driver) {
		super(driver);
     }

	By lblAddAddress = By.xpath("//div[@id='add-address-info']//h4");
				
	public boolean isLblAddAddressDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddAddress).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By drplistType = By.xpath("(//form[@id='address-form-create']//span[2])[1]");
	By itemHome = By.xpath("(//ul[@id='typeCreate_listbox']//li)[1]");
	By itemMailing = By.xpath("(//ul[@id='typeCreate_listbox']//li)[1]");
	By itemWork = By.xpath("(//ul[@id='typeCreate_listbox']//li)[1]");
	
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
	
	By txtZipCode = By.id("postalCodeCreate");
	By txtStreet = By.id("streetCreate");
	By txtCity = By.id("cityCreate");
	By txtState = By.id("stateCreate");
	
	public void fillTxtZipCode(String zipcode)
	{
		waitFluentWait(txtZipCode);
		ClickElementAndType(txtZipCode, zipcode);
	}
	
	public void fillTxtStreet(String street)
	{
		waitFluentWait(txtStreet);
		ClickElementAndType(txtStreet, street);
	}
	
	public void fillTxtCity(String city)
	{
		waitFluentWait(txtCity);
		ClickElementAndType(txtCity, city);
	}
	
	public void fillTxtState(String state)
	{
		waitFluentWait(txtState);
		ClickElementAndType(txtState, state);
	}
	
	By drplistCountry = By.xpath("(//form[@id='address-form-create']//span[2])[2]");
	By itemCountry = By.xpath("(//ul[@id='countryCodeCreate_listbox']//li)[1]");	
		
	public void selectDrplistCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		waitFluentWait(itemCountry);
		click(itemCountry);
	}
		
	By btnCancel = By.id("cancelAddress");
	By btnSavenCreateNew = By.id("saveAndCreateNewAddress");
	By btnSaveEmployee = By.id("saveAddressTTM");
	By btnSaveMy = By.id("saveAddress");
	
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
	
	public void clickBtnSaveEmployee()
	{
		waitFluentWait(btnSaveEmployee);
		click(btnSaveEmployee);
	}
	
	public void clickBtnSaveMy()
	{
		waitFluentWait(btnSaveMy);
		click(btnSaveMy);
	}
}
