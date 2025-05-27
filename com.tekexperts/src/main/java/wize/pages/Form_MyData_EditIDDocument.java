package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_MyData_EditIDDocument extends WebActions {

	public Form_MyData_EditIDDocument(WebDriver driver) {
		super(driver);
     }

	By lblEditIDDocument = By.xpath("//div[@id='edit-identificationDocuments-info']//h4");
				
	public boolean isLblEditIDDocumentDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditIDDocument).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By btnImg = By.xpath("//form[@id='identificationDocuments-form-edit']//a");
	
	public void clickBtnImg()
	{
		waitFluentWait(btnImg);
		click(btnImg);
	}
	
	By drplistType = By.xpath("(//form[@id='identificationDocuments-form-edit']//span[2]//span)[1]");
	By itemType = By.xpath("(//ul[@id='typeIDEdit_listbox']//li)[1]");
	
	public void selectDrplistType()
	{
		waitFluentWait(drplistType);
		click(drplistType);
		waitFluentWait(itemType);
		click(itemType);
	}
		
	
	By txtNumber = By.id("numberEdit");
	
	public void fillTxtNumber(String number)
	{
		waitFluentWait(txtNumber);
		goTextOn(txtNumber, number);
	}
	
	By drplistCountry = By.xpath("//form[@id='identificationDocuments-form-edit']//div[4]//span[2]");
	By itemCountry = By.xpath("(//ul[@id='countryIDEdit_listbox']//li)[1]");	
		
	public void selectDrplistCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		waitFluentWait(itemCountry);
		click(itemCountry);
	}
	
	By btnCancel = By.xpath("(//div[@id='edit-identificationDocuments-info']//div[3]//button)[1]");
	By btnSave = By.xpath("(//div[@id='edit-identificationDocuments-info']//div[3]//button)[1]");
	By btnClose = By.xpath("(//div[@id='update-identification-doc-info']//i");
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
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
