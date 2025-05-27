package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditWorkPermit extends WebActions {

	public Form_Data_EditWorkPermit(WebDriver driver) {
		super(driver);
     }

	By lblEditWorkPermit = By.xpath("//div[@id='edit-workPermits-info']//h4");
				
	public boolean isLblEditWorkPermitDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditWorkPermit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	By txtPermitNumber = By.id("permitNumberEdit");
	
	public void fillTxtPermitNumber(String permitnumber)
	{
		waitFluentWait(txtPermitNumber);
		ClickElementAndType(txtPermitNumber, permitnumber);
	}
		
	By drplistCountry = By.xpath("(//form[@id='workPermits-form-edit']//span[2])[1]");
	By itemCountry = By.xpath("(//ul[@id='issuingCountryEdit_listbox']//li)[1]");	
		
	public void selectDrplistCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		click(itemCountry);
	}
		
	By btnCancel = By.id("cancelWorkPermits");
	By btnSave = By.id("saveWorkPermits");
	
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
