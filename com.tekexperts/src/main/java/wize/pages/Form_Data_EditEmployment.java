package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditEmployment extends WebActions {

	public Form_Data_EditEmployment(WebDriver driver) {
		super(driver);
     }

	By lblEditEmployment = By.xpath("//div[@id='edit-employment-info']//h4");
				
	public boolean isLblEditEmploymentDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditEmployment).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By txtPayrollCode = By.id("employeePayrollCodeEdit");
	
	public void fillTxtPayrollCode(String payrollcode)
	{
		waitFluentWait(txtPayrollCode);
		ClickElementAndType(txtPayrollCode, payrollcode);
	}
	
	By drplistPayCurrency= By.xpath("(//form[@id='employment-form-edit']//span[2])[1]");
	By itemPayCurrency = By.xpath("(//ul[@id='payCurrencyEdit_listbox']//li)[1]");
	
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
		
	By iconStartDate = By.xpath("//form[@id='employment-form-edit']//div[3]/span/span/span");
	By itemToday = By.xpath("//div[@id='startDateEdit_dateview']//div[3]//a");
	
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

	By drplistContractType = By.xpath("(//form[@id='employment-form-edit']//span[2])[3]");
	By itemContractType = By.xpath("(//ul[@id='contractTypeEdit_listbox']//li)[1]");	
		
	public void selectDrplistContractType()
	{
		waitFluentWait(drplistContractType);
		click(drplistContractType);
		click(itemContractType);
	}
		
	By btnCancel = By.id("cancelEmployment");
	By btnSave = By.id("saveEmployment");
	
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
