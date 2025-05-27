package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EducationDetails extends WebActions {

	public Form_Data_EducationDetails(WebDriver driver) {
		super(driver);
     }

	By lblEducationDetails = By.xpath("//div[@id='edit-education-info']//h4");
				
	public boolean isLblEducationDetailsDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEducationDetails).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	By btnEdit = By.xpath("(//div[@id='edit-education-info']//i)[1]");
	By btnClose = By.xpath("(//div[@id='edit-education-info']//i)[2]");
	
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
