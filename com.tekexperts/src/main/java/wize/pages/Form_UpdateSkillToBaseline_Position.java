package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UpdateSkillToBaseline_Position extends WebActions {

	public Form_UpdateSkillToBaseline_Position(WebDriver driver) {
		super(driver);
     }

	By lblUpdateSkillToBaseLine = By.id("add-skill-title");
	
	By radiobtnL1 = By.id("1");
	By radiobtnL2 = By.id("2");
	By radiobtnL3 = By.id("3");
	By radiobtnL4 = By.id("4");
	By radiobtnL5 = By.id("5");
	By radiobtnL6 = By.id("6");
	By radiobtnL7 = By.id("7");
	By radiobtnL8 = By.id("8");
	By radiobtnL9 = By.id("9");
	By radiobtnL10 = By.id("10");
		
	By btnCancel = By.id("btn-cancel-add-skill");
	By btnUpdate = By.id("addSkill");
		
	public boolean isLblUpdateSkillToBaseLineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblUpdateSkillToBaseLine).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnUpdate()
	{
		waitFluentWait(btnUpdate);
		click(btnUpdate);
	}
	
	public void clickRadiobtnL1()
	{
		waitFluentWait(radiobtnL1);
		click(radiobtnL1);
	}
	
	public void clickRadiobtnL2()
	{
		waitFluentWait(radiobtnL2);
		click(radiobtnL2);
	}
	
	public void clickRadiobtnL3()
	{
		waitFluentWait(radiobtnL3);
		click(radiobtnL3);
	}
	
	public void clickRadiobtnL4()
	{
		waitFluentWait(radiobtnL4);
		click(radiobtnL4);
	}
	
	public void clickRadiobtnL5()
	{
		waitFluentWait(radiobtnL5);
		click(radiobtnL5);
	}
	
	public void clickRadiobtnL6()
	{
		waitFluentWait(radiobtnL6);
		click(radiobtnL6);
	}
	
	public void clickRadiobtnL7()
	{
		waitFluentWait(radiobtnL7);
		click(radiobtnL7);
	}
	
	public void clickRadiobtnL10()
	{
		waitFluentWait(radiobtnL10);
		click(radiobtnL10);
	}
	
	public void clickRadiobtnL8()
	{
		waitFluentWait(radiobtnL8);
		click(radiobtnL8);
	}
	
	public void clickRadiobtnL9()
	{
		waitFluentWait(radiobtnL9);
		click(radiobtnL9);
	}
}
