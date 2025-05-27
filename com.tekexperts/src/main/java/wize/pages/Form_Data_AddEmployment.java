package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddEmployment extends WebActions {

	public Form_Data_AddEmployment(WebDriver driver) {
		super(driver);
     }

	By lblAddEmployment = By.xpath("//div[@id='add-employment-info']//h4");
				
	public boolean isLblAddEmploymentDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddEmployment).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtPayrollCode = By.id("employeePayrollCodeCreate");
	
	public void fillTxtPayrollCode(String payrollcode)
	{
		waitFluentWait(txtPayrollCode);
		ClickElementAndType(txtPayrollCode, payrollcode);
	}
	
	By drplistPayCurrency= By.xpath("(//form[@id='employment-form-create']//span[2])[1]");
	By itemPayCurrency = By.xpath("(//ul[@id='payCurrencyCreate-list']//li)[1]");
	
	public void clickDrplistPayCurrency()
	{
		waitFluentWait(drplistPayCurrency);
		click(drplistPayCurrency);
	}
	
	public void clickItemPayCurrency()
	{
		waitFluentWait(itemPayCurrency);
		click(itemPayCurrency);
	}
		
	By iconStartDate = By.xpath("//form[@id='employment-form-create']//div[3]//span[2]");
	By itemToday = By.xpath("//div[@id='startDateCreate_dateview']//div[3]//a");
	
	public void clickIconStartDate()
	{
		waitFluentWait(iconStartDate);
		click(iconStartDate);
	}
	
	public void clickItemToday()
	{
		waitFluentWait(itemToday);
		click(itemToday);
	}

	By drplistContractType = By.xpath("(//form[@id='employment-form-create']//span[2])[4]");
	By itemContractType = By.xpath("(//ul[@id='contractTypeCreate_listbox']//li)[1]");	
		
	public void selectDrplistContractType()
	{
		waitFluentWait(drplistContractType);
		click(drplistContractType);
		click(itemContractType);
	}
		
	By btnCancel = By.id("cancelEmployment");
	By btnSavenCreateNew = By.id("saveAndCreateNewEmployment");
	By btnSave = By.id("saveEmploymentTTM");
	
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
