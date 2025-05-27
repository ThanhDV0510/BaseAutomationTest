package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddWorkPermit extends WebActions {

	public Form_Data_AddWorkPermit(WebDriver driver) {
		super(driver);
     }

	By lblAddWorkPermit = By.xpath("//div[@id='add-workPermits-info']//h4");
				
	public boolean isLblAddWorkPermitDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddWorkPermit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	By txtPermitNumber = By.id("permitNumberCreate");
	
	public void fillTxtPermitNumber(String permitnumber)
	{
		waitFluentWait(txtPermitNumber);
		ClickElementAndType(txtPermitNumber, permitnumber);
	}
		
	By drplistCountry = By.xpath("(//form[@id='workPermits-form-create']//span[2])[1]");
	By itemCountry = By.xpath("(//ul[@id='issuingCountryCreate_listbox']//li)[1]");	
		
	public void selectDrplistCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		click(itemCountry);
	}
	
	By iconStartDate = By.xpath("(//form[@id='workPermits-form-create']//div[3]//span)[4]");
	By itemToday = By.xpath("//div[@id='issueDateCreate_dateview']//div[3]//a");
	
	public void selectStartDate()
	{
		waitFluentWait(iconStartDate);
		click(iconStartDate);
		click(itemToday);
	}
	
	By btnCancel = By.id("cancelWorkPermits");
	By btnSavenCreateNew = By.id("saveAndCreateNewWorkPermits");
	By btnSave = By.id("saveWorkPermits");
	
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
