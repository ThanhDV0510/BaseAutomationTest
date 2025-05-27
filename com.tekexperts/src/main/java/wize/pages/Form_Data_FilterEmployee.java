package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_FilterEmployee extends WebActions{

	public Form_Data_FilterEmployee(WebDriver driver) {
		super(driver);
	}
	
	By lblFilter = By.xpath("//div[@id='create-filter']//h4");
	By txtKeyword = By.id("keyword");
	By btnReset = By.xpath("(//div[@id='create-filter']//div[3]//button)[1]");
	By btnApply = By.xpath("(//div[@id='create-filter']//div[3]//button)[2]");
	
	public boolean isLblFilterDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblFilter).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnReset()
	{
		waitFluentWait(btnReset);
		click(btnReset);
	}
	
	public void clickBtnApply()
	{
		waitFluentWait(btnApply);
		click(btnApply);
	}
	
	public void fillTxtKeyword(String keyword)
	{
		waitFluentWait(txtKeyword);
		ClickElementAndType(txtKeyword, keyword);
	}
	
}
