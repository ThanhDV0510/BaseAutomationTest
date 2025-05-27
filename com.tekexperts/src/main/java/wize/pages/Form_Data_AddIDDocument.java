package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddIDDocument extends WebActions {

	public Form_Data_AddIDDocument(WebDriver driver) {
		super(driver);
     }

	By lblAddIDDocument = By.xpath("//div[@id='create-identification-doc-info']//h4");
				
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
	
	By btnImg = By.xpath("//form[@id='create-identification-doc-form']//a");
	
	public void clickBtnImg()
	{
		waitFluentWait(btnImg);
		click(btnImg);
	}
	
	By drplistType = By.xpath("(//form[@id='create-identification-doc-form']//span[2]//span)[1]");
	By itemType = By.xpath("(//ul[@id='idDocCreateType_listbox']//li)[1]");
	
	public void selectType()
	{
		waitFluentWait(drplistType);
		click(drplistType);
		waitFluentWait(itemType);
		click(itemType);
	}
		
	By txtNumber = By.id("idDocCreateNumber");
	
	public void fillTxtNumber(String number)
	{
		waitFluentWait(txtNumber);
		ClickElementAndType(txtNumber, number);
	}
	
	By drplistCountry = By.xpath("(//form[@id='create-identification-doc-form']//span[2]//span)[2]");
	By itemCountry = By.xpath("(//ul[@id='idDocCreateCountry_listbox']//li)[1]");	
		
	public void selectCountry()
	{
		waitFluentWait(drplistCountry);
		click(drplistCountry);
		waitFluentWait(itemCountry);
		click(itemCountry);
	}
	
	By iconIssueDate = By.xpath("(//form[@id='create-identification-doc-form']//div[5]//span)[5]");
	By itemToDayIssue = By.xpath("//div[@id='idDocCreateIssueDate_dateview']//div[3]//a");
	By iconExpiryDate = By.xpath("(//form[@id='create-identification-doc-form']//div[5]//span)[10]");
	By itemTodayExpiry = By.xpath("//div[@id='idDocCreateExpiryDate_dateview']//div[3]//a");
	
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
	
	By btnCancel = By.id("cancelIdentificationDocCreate");
	By btnSavenCreateNew = By.id("saveAndCreateNewIdentificationDocCreate");
	By btnSave = By.id("saveIdentificationDocCreate");
	By btnClose = By.xpath("//div[@id='create-identification-doc-info']//i");
	
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
