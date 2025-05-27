package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_ViewContact extends WebActions {

	public Form_Data_ViewContact(WebDriver driver) {
		super(driver);
     }

	By lblViewContact = By.xpath("//div[@id='detail-contact-info']//h4");
				
	public boolean isLblViewContactDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblViewContact).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	By btnEdit = By.xpath("(//div[@id='detail-contact-info']//i)[1]");
	By btnClose= By.xpath("(//div[@id='detail-contact-info']//i)[1]");
	
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
