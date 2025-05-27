package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddSkillToBaseline_Position extends WebActions {

	public Form_AddSkillToBaseline_Position(WebDriver driver) {
		super(driver);
     }

	By lblAddSkillToBaseLine = By.id("add-skill-title");
	
	By txtCategory = By.id("divSkillCategoryMultiSelect");
	By firstItem = By.xpath("(//ul[@id='category_listbox']//li)[1]");
	By msgError = By.id("Category_validationMessage");
	
	By txtSkill = By.id("divSkill");
	By firstItemSkill = By.xpath("(//ul[@id='skill_listbox']//li)[1]");

	By lblSkillLevel = By.xpath("//div[@id='addSkill-form']//div[2]//p");
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
	By btnAdd = By.id("addSkill");
		
	public boolean isLblAddSkillToBaseLineDisplayed()
	{
		boolean flag = false;
		try {
			waitForElementPresent(5, lblAddSkillToBaseLine);
			if (driver.findElements(lblAddSkillToBaseLine).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgErrorDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgError).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblSkillLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkillLevel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblAddSkillToBaseLine()
	{
		waitFluentWait(lblAddSkillToBaseLine);
		click(lblAddSkillToBaseLine);
	}
	
	public void selectCategory(String category)

	{
		waitFluentWait(txtCategory);
		ClickElementAndType(txtCategory, category);
		waitFluentWait(firstItem);
		click(firstItem);
	}
	
	public void selectSkill(String skill)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skill);
		waitFluentWait(firstItemSkill);
		click(firstItemSkill);
		sleep(0.25);
	}
		
	public void clickTxtCategory() 
	{ 
		waitFluentWait(txtCategory); 
		driver.findElement(By.id("divSkillCategoryMultiSelect")).click(); 
	}
	
	public void clickTxtSkill() 
	{ 
		waitFluentWait(txtSkill); 
		clickOnElement(driver.findElement(txtSkill)); 
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickDoubleBtnCancel()
	{
		waitFluentWait(btnCancel);
		doubleClick(driver.findElement(btnCancel), 0);
	}
		
	public void clickBtnAdd()
	{
		waitFluentWait(btnAdd);
		click(btnAdd);
	}
	
	public void clickDoubleBtnAdd()
	{
		waitFluentWait(btnAdd);
		doubleClick(driver.findElement(btnAdd), 0);
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
			
	public void inputData(String category,String skill)
	{
		selectCategory(category);
		selectSkill(skill);
		sleep(1.5);
	}
}
