package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_MyData_AddIDDocument extends WebActions {

	public Form_MyData_AddIDDocument(WebDriver driver) {
		super(driver);
     }

	By lblAddIDDocument = By.xpath("//div[@id='add-identificationDocuments-info']//h4");
				
	public boolean isLblAddIDDocumentDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddIDDocument).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By btnImg = By.xpath("//form[@id='identificationDocuments-form-create']//a");
	
	public void clickBtnImg()
	{
		waitFluentWait(btnImg);
		click(btnImg);
	}
	
	By drplistType = By.xpath("(//form[@id='identificationDocuments-form-create']//span[2]//span)[1]");
	By itemType = By.xpath("(//ul[@id='typeIDCreate_listbox']//li)[1]");
	
	public void selectType()
	{
		waitFluentWait(drplistType);
		click(drplistType);
		waitFluentWait(itemType);
		click(itemType);
	}
		
	By txtNumber = By.id("numberCreate");
	
	public void fillTxtNumber(String number)
	{
		waitFluentWait(txtNumber);
		ClickElementAndType(txtNumber, number);
	}
	
	By drplistCountry = By.xpath("(//form[@id='identificationDocuments-form-create']//div[4]//span[2])[1]");
	By itemCountry = By.xpath("(//ul[@id='countryIDCreate_listbox']//li)[1]");	
		
	public void selectCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		waitFluentWait(itemCountry);
		click(itemCountry);
	}
	
	By iconIssueDate = By.xpath("(//form[@id='identificationDocuments-form-create']//div[5]//span)[5]");
	By itemToDayIssue = By.xpath("//div[@id='issueDateIDCreate_dateview']//div[3]//a");
	By iconExpiryDate = By.xpath("(//form[@id='identificationDocuments-form-create']//div[5]//span)[10]");
	By itemTodayExpiry = By.xpath("//div[@id='expiryDateIDCreate_dateview']//div[3]//a");
	
	public void selectIssueDate()
	{
		waitFluentWait(iconIssueDate);
		click(iconIssueDate);
		waitFluentWait(itemToDayIssue);
		click(itemToDayIssue);
	}
	
	public void selectExpiryDate()
	{
		waitFluentWait(iconExpiryDate);
		click(iconExpiryDate);
		waitFluentWait(itemTodayExpiry);
		click(itemTodayExpiry);
	}
	
	By btnCancel = By.id("cancelIdentificationDocuments");
	By btnSavenCreateNew = By.id("saveAndCreateNewIdentificationDocuments");
	By btnSave = By.id("saveIdentificationDocuments");
	By btnClose = By.xpath("//div[@id='add-identificationDocuments-info']//i");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
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
