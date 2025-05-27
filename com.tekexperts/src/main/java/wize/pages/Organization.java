package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Organization extends WebActions {

	public Organization(WebDriver driver) {
		super(driver);
     }
	
	By lblDIMENSIONLIST = By.id("label-dimension");
		
	public boolean isLblDIMENSIONLISTDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblDIMENSIONLIST).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By menuBusinessUnit = By.id("dimension-Business Unit");
	By menuCountry = By.id("dimension-Country");
	By menuProduct = By.id("dimension-Product");
	By menuProject = By.id("dimension-Project");
	By menuRegion = By.id("dimension-Region");
	By menuSite = By.id("dimension-Site");
	By menuTeam = By.id("dimension-Team");
	By menuUnitDepartment = By.id("dimension-Unit/Department");
	
	public void clickMenuBusinessUnit()
	{
		waitFluentWait(menuBusinessUnit);
		click(menuBusinessUnit);
	}
	
	public void clickMenuCountry()
	{
		waitFluentWait(menuCountry);
		click(menuCountry);
	}
	
	public void clickMenuProduct()
	{
		waitFluentWait(menuProduct);
		click(menuProduct);
	}

	public void clickMenuProject()
	{
		waitFluentWait(menuProject);
		click(menuProject);
	}
	
	public void clickMenuRegion()
	{
		waitFluentWait(menuRegion);
		click(menuRegion);
	}
	
	public void clickMenuSite()
	{
		waitFluentWait(menuSite);
		click(menuSite);
	}
	
	public void clickMenuTeam()
	{
		waitFluentWait(menuTeam);
		click(menuTeam);
	}
	
	public void clickMenuUnitDepartment()
	{
		waitFluentWait(menuUnitDepartment);
		click(menuUnitDepartment);
	}
}

