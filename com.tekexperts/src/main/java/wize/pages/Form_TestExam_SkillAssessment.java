package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_TestExam_SkillAssessment extends WebActions {

	public Form_TestExam_SkillAssessment(WebDriver driver) {
		super(driver);
     }
	
	By lblSkillAssessment = By.xpath("//div[@id='skill-test']//strong//span");
	
	By lblAreYouReady = By.xpath("(//div[@id='skill-test']//h2)[1]");
	
	By btnLetBegin = By.xpath("(//div[@id='skill-test']//div[3]//button)[1]");
	By btnCancel = By.xpath("(//div[@id='skill-test']//div[3]//button)[2]");
	By btnBack = By.xpath("(//div[@id='skill-test']//div[3]//button)[3]");
	By btnSavenNext = By.xpath("(//div[@id='skill-test']//div[3]//button)[4]");
	
	By btnBackToAssessmentLibrary = By.xpath("//div[@id='skill-test']//section/div[1]//div[4]//a[1]");
	By btnSeeTheResults = By.xpath("//div[@id='skill-test']//section/div[1]//div[4]//a[2]");
		
	public boolean isBtnSeeTheResultsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnSeeTheResults).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblAreYouReadyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAreYouReady).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public boolean isBtnLetBeginDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnLetBegin).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCancelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCancel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
		
	public void clickBtnLetBegin()
	{
		waitFluentWait(btnLetBegin);
		click(btnLetBegin);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnSubmit()
	{
		waitFluentWait(btnSavenNext);
		click(btnSavenNext);
	}
	
	public boolean isBtnBackToAssessmentLibrarylDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnBackToAssessmentLibrary).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnBackToAssessmentLibrary()
	{
		waitFluentWait(btnBackToAssessmentLibrary);
		click(btnBackToAssessmentLibrary);
	}
	
	public void clickBtnSeeTheResults()
	{
		waitFluentWait(btnSeeTheResults);
		click(btnSeeTheResults);
	}
	
	public void clickBtnSavenNext()
	{
		waitFluentWait(btnSavenNext);
		click(btnSavenNext);
	}
	
	public void clickBtnBack()
	{
		waitFluentWait(btnBack);
		click(btnBack);
	}

	By lblQuestion = By.xpath("//div[@id='right-panel-skill-question']//h6//strong");
	
	public boolean isLblQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnNumber1 = By.xpath("(//div[@id='skill-test']//div[3]/div//li)[1]");
	By btnNumber2 = By.xpath("(//div[@id='skill-test']//div[3]/div//li)[2]");
	
	public void clickBtnNumber1()
	{
		waitFluentWait(btnNumber1);
		click(btnNumber1);
	}
	
	public void clickBtnNumber2()
	{
		waitFluentWait(btnNumber2);
		click(btnNumber2);
	}
	
	By btnRadioNoConfidence = By.xpath("(//div[@id='contentConfident']//label)[1]");
	By btnRadioDoubt = By.xpath("(//div[@id='contentConfident']//label)[2]");
	By btnRadioConfidence = By.xpath("(//div[@id='contentConfident']//label)[3]");
	By btnRadioCompleteConfidence = By.xpath("(//div[@id='contentConfident']//label)[4]");
	
	public void clickBtnRadioNoConfidence()
	{
		waitFluentWait(btnRadioNoConfidence);
		click(btnRadioNoConfidence);
	}
	
	public void clickBtnRadioDoubt()
	{
		waitFluentWait(btnRadioDoubt);
		click(btnRadioDoubt);
	}
	
	public void clickBtnRadioConfidence()
	{
		waitFluentWait(btnRadioConfidence);
		click(btnRadioConfidence);
	}
	
	public void clickBtnRadioCompleteConfidence()
	{
		waitFluentWait(btnRadioCompleteConfidence);
		click(btnRadioCompleteConfidence);
	}
	
	By subTab1st = By.xpath("(//button[@data-bind='click:skillTestResultVM.currentTestHistorysClick'])[3]");
	By subTab2nd = By.xpath("(//button[@data-bind='click:skillTestResultVM.currentTestHistorysClick'])[2]");
	By subTab3rd = By.xpath("(//button[@data-bind='click:skillTestResultVM.currentTestHistorysClick'])[1]");
	
	public void clickSubTab1st()
	{
		waitFluentWait(subTab1st);
		click(subTab1st);
	}
	
	public void clickSubTab2nd()
	{
		waitFluentWait(subTab2nd);
		click(subTab2nd);
	}
	
	public void clickSubTab3rd()
	{
		waitFluentWait(subTab3rd);
		click(subTab3rd);
	}
	
	By btnAnwser1 = By.xpath("(//div[@id='right-panel-skill-question']//input)[1]");
	By btnAnwser2 = By.xpath("(//div[@id='right-panel-skill-question']//input)[2]");
	By btnAnwser3 = By.xpath("(//div[@id='right-panel-skill-question']//input)[3]");
	By btnAnwser4 = By.xpath("(//div[@id='right-panel-skill-question']//input)[4]");
	
	public void clickBtnAnwser1()
	{
		waitFluentWait(btnAnwser1);
		click(btnAnwser1);
	}
	
	public void clickBtnAnwser2()
	{
		waitFluentWait(btnAnwser2);
		click(btnAnwser2);
	}
	
	public void clickBtnAnwser3()
	{
		waitFluentWait(btnAnwser3);
		click(btnAnwser3);
	}
	
	public void clickBtnAnwser4()
	{
		waitFluentWait(btnAnwser4);
		click(btnAnwser4);
	}
	
	//Popup Confirm Delete
		By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
		By btnYes = By.xpath("//button[contains(.,'YES')]");
		By btnNo = By.xpath("//button[contains(.,'NO')]");
		
		public boolean isLblConfirmationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(lblConfirmation).size() > 0) {
					flag = true;
						}
				} catch (Exception e) {
					return flag;
				}	
			return flag;
		}
			
		public void clickBtnYes()
		{
			waitFluentWait(btnYes);
			click(btnYes);
		}

		public void clickBtnNo()
		{
			waitFluentWait(btnNo);
			click(btnNo);
		}
}
