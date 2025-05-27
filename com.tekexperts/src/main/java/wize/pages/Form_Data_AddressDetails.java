package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddressDetails extends WebActions {

	public Form_Data_AddressDetails(WebDriver driver) {
		super(driver);
     }

	By lblAddressDetails = By.xpath("//div[@id='edit-address-info']//h4");
				
	public boolean isLblAddressDetailsDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddressDetails).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	By btnEdit = By.xpath("(//div[@id='edit-address-info']//i)[1]");
	By btnClose = By.xpath("(//div[@id='edit-address-info']//i)[2]");
	
	public void clickBtnEdit()
	{
		waitFluentWait(btnEdit);
		click(btnEdit);
	}
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
}
