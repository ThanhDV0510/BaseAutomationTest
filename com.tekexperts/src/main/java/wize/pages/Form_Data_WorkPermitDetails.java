package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_WorkPermitDetails extends WebActions {

	public Form_Data_WorkPermitDetails(WebDriver driver) {
		super(driver);
     }

	By lblWorkPermitDetails = By.xpath("//div[@id='edit-workPermits-info']//h4");
				
	public boolean isLblWorkPermitDetailsDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblWorkPermitDetails).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By btnEdit= By.xpath("(//div[@id='edit-workPermits-info']//section[2]//i)[1]");
	By btnClose = By.xpath("(//div[@id='edit-workPermits-info']//section[2]//i)[2]");
	
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
