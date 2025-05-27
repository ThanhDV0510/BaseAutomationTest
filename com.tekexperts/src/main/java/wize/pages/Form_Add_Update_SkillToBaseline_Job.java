package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Add_Update_SkillToBaseline_Job extends WebActions {

	public Form_Add_Update_SkillToBaseline_Job(WebDriver driver) {
		super(driver);
     }

	By lblAddSkillToBaseLine = By.xpath("//div[@id='add-job-skill-baseline']//h5");
	
	By txtCategory = By.id("divSkillCategorySelect");
	By firstItem = By.xpath("(//ul[@id='ddlSkillCategory_listbox']//li)[1]");
	By msgError = By.id("ddlSkillCategory_validationMessage");
	
	By txtSkill = By.id("divSkillSelect");
	By firstItemSkill = By.xpath("(//ul[@id='ddlSkill_listbox']//li)[1]");

	By lblSkillLevel = By.xpath("//div[@id='add-job-skill-baseline']//p");
	By radiobtnL1 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[1]");
	By radiobtnL2 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[2]");
	By radiobtnL3 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[3]");
	By radiobtnL4 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[4]");;
	By radiobtnL5 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[5]");
	By radiobtnL6 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[6]");
	By radiobtnL7 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[7]");
	By radiobtnL8 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[8]");
	By radiobtnL9 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[9]");
	By radiobtnL10 = By.xpath("(//div[@id='add-job-skill-baseline']//div[3]/div/label)[10]");
	
	By btnSetKey = By.xpath("//div[@id='accordion-add-job-baseline-skill']//div[2]/button");
	By statusSetKey = By.xpath("//button[@class='btn btn-icon set-key btn-active']");
	By checkBehavior = By.xpath("//i[@class='icon icon-checkmark3 text-primary']");
	
	By btnCancel = By.xpath("//div[@id='add-job-skill-baseline']//div[3]/button[1]");
	By btnAdd = By.id("btnAddPreviewJobBaseLine");
			
	public boolean isLblAddSkillToBaseLineDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblAddSkillToBaseLine);
			if ( driver.findElement(lblAddSkillToBaseLine).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
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
		driver.findElement(By.id("divSkillCategorySelect")).click(); 
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
	
	public void clickBtnSetKey()
	{
		waitFluentWait(btnSetKey);
		click(btnSetKey);
	}
		
	public boolean isCheckSetKeyDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(statusSetKey).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isCheckBehaviorDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(checkBehavior).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
			
	public void inputData(String category,String skill)
	{
		selectCategory(category);
		selectSkill(skill);
		sleep(1.5);
	}
}
