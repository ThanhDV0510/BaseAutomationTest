package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EmploymentDetails extends WebActions {

	public Form_Data_EmploymentDetails(WebDriver driver) {
		super(driver);
     }

	By lblEmploymentDetails = By.xpath("//div[@id='edit-employment-info']//h4");
				
	public boolean isLblEmploymentDetailsDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEmploymentDetails).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	By btnEdit = By.xpath("(//div[@id='edit-employment-info']//i)[1]");
	By btnClose = By.xpath("(//div[@id='edit-employment-info']//i)[2]");
	
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
