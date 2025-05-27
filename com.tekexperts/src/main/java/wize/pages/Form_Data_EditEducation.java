package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Data_EditEducation extends WebActions {

	public Form_Data_EditEducation(WebDriver driver) {
		super(driver);
     }

	By lblEditEducation = By.xpath("//div[@id='edit-education-info']//h4");
				
	public boolean isLblEditEducationDisplayed()
	{
		boolean flag= false;
		try {
			if ( driver.findElement(lblEditEducation).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	By drplistLevel = By.xpath("(//form[@id='education-form-edit']//span[2])[1]");
	By itemLevel  = By.xpath("(//ul[@id='levelUpdate_listbox']//li)[1]");
	
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
		
	By txtInstitute = By.xpath("(//form[@id='education-form-edit']//input)[3]");
	By txtMajor = By.xpath("(//form[@id='education-form-edit']//input)[4]");
		
	public void fillTxtInstitute(String Institute)
	{
		waitFluentWait(txtInstitute);
		goTextOn(txtInstitute, Institute);
	}
	
	public void fillTxtMajor(String major)
	{
		waitFluentWait(txtMajor);
		goTextOn(txtMajor, major);
	}
		
	By drplistGraduationYear = By.xpath("(//form[@id='education-form-edit']//span[2])[3]");
	By itemGraduationYear = By.xpath("(//ul[@id='graduationYearUpdate-list']//li)[1]");	
		
	public void selectDrplistGraduationYear()
	{
		waitFluentWait(drplistGraduationYear);
		click(drplistGraduationYear);
		click(itemGraduationYear);
	}
		
	By btnCancel = By.xpath("(//div[@id='edit-education-info']//div[3]//button)[1]");
	By btnSave = By.xpath("(//div[@id='edit-education-info']//div[3]//button)[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
}
