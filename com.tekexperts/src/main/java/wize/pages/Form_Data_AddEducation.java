package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_AddEducation extends WebActions {

	public Form_Data_AddEducation(WebDriver driver) {
		super(driver);
     }

	By lblAddEducation = By.xpath("//div[@id='add-education-info']//h4");
				
	public boolean isLblAddEducationDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblAddEducation).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By drplistLevel = By.xpath("(//form[@id='education-form-create']//span[2])[1]");
	By itemLevel  = By.xpath("(//ul[@id='levelCreate_listbox']//li)[1]");
	
	public void clickDrplistLevel()
	{
		waitFluentWait(drplistLevel);
		click(drplistLevel);
	}
	
	public void clickItemLevel()
	{
		waitFluentWait(itemLevel);
		click(itemLevel);
	}
	
	public void selectLevel()
	{
		clickDrplistLevel();
		clickItemLevel();
	}
		
	By txtInstitute = By.id("instituteCreate");
	By txtMajor = By.id("majorCreate");
		
	public void fillTxtInstitute(String Institute)
	{
		waitFluentWait(txtInstitute);
		ClickElementAndType(txtInstitute, Institute);
	}
	
	public void fillTxtMajor(String major)
	{
		waitFluentWait(txtMajor);
		ClickElementAndType(txtMajor, major);
	}
		
	By drplistGraduationYear = By.xpath("(//form[@id='education-form-create']//span[2])[3]");
	By itemGraduationYear = By.xpath("(//ul[@id='graduationYearCreate_listbox']//li)[1]");	
		
	public void selectDrplistGraduationYear()
	{
		waitFluentWait(drplistGraduationYear);
		click(drplistGraduationYear);
		click(itemGraduationYear);
	}
		
	By btnCancel = By.id("cancelEducation");
	By btnSavenCreateNew = By.id("saveAndCreateNewEducation");
	By btnSave = By.id("saveEducation");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}

	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}
