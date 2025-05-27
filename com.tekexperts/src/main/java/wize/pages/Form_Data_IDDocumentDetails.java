package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_IDDocumentDetails extends WebActions {

	public Form_Data_IDDocumentDetails(WebDriver driver) {
		super(driver);
     }

	By lblIDDocumentDetails = By.xpath("//div[@id='detail-identification-doc-info']//h4");
				
	public boolean islblIDDocumentDetailsDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblIDDocumentDetails).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By btnEdit = By.xpath("(//div[@id='detail-identification-doc-info']//button)[1]");
	By btnClose = By.xpath("(//div[@id='detail-identification-doc-info']//button)[2]");
	
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
