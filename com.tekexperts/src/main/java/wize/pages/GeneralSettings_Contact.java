package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings_Contact extends WebActions {

	public GeneralSettings_Contact(WebDriver driver) {
		super(driver);
     }
	
	By lblContact = By.xpath("//section[@id='contact-partial-view']//h3");
		
	public boolean isLblContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
