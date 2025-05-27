package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GeneralSettings extends WebActions {

	public GeneralSettings(WebDriver driver) {
		super(driver);
     }
	
	By lblGeneralSettings = By.id("label-general-setting");
	By subMenuSkill = By.xpath("//ul[@id='organizationScreenView']/li[1]");
	By subMenuOrganization = By.xpath("//ul[@id='organizationScreenView']/li[2]");
	By subMenuLearningURL = By.xpath("//ul[@id='organizationScreenView']/li[3]");
	By subMenuUserDefinedValues = By.xpath("//ul[@id='organizationScreenView']/li[4]");
	By subMenuEmployeeCode = By.xpath("//ul[@id='organizationScreenView']/li[5]");
	By subMenuContact = By.xpath("//ul[@id='organizationScreenView']/li[6]");
	
	public boolean isSubMenuLearningURLDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuLearningURL).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuLearningURL()
	{
		waitFluentWait(subMenuLearningURL);
		click(subMenuLearningURL);
	}
	
	public boolean isSubMenuEmployeeCodeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuEmployeeCode).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuEmployeeCode()
	{
		waitFluentWait(subMenuEmployeeCode);
		click(subMenuEmployeeCode);
	}
	
	public boolean isSubMenuContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuContact()
	{
		waitFluentWait(subMenuContact);
		click(subMenuContact);
	}
	
	public boolean isLblGeneralSettingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblGeneralSettings).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuUserDefinedValuesDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuUserDefinedValues).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuUserDefinedValues()
	{
		waitFluentWait(subMenuUserDefinedValues);
		click(subMenuUserDefinedValues);
	}
	
	public boolean isSubMenuSkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuOrganizationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subMenuOrganization).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuSkill()
	{
		waitFluentWait(subMenuSkill);
		click(subMenuSkill);
	}
	
	public void clickSubMenuOrganization()
	{
		waitFluentWait(subMenuOrganization);
		click(subMenuOrganization);
	}
}
