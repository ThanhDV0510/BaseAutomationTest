package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyContribution_Question extends WebActions {

	public MyContribution_Question(WebDriver driver) {
		super(driver);
     }
	
	By lblMyQuestion = By.xpath("(//div[@id='contribution-tabstrip-1']//h5)[1]");
	
	public boolean isLblMyQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMyQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCreateQuestion = By.xpath("//div[@id='contribution-tabstrip-1']//a[@title='Create Question']");
	By itemSingleChoice = By.xpath("(//div[@id='contribution-tabstrip-1']//a)[2]");
	By itemMultipleChoice = By.xpath("(//div[@id='contribution-tabstrip-1']//a)[3]");
	By itemScenario = By.xpath("(//div[@id='contribution-tabstrip-1']//a)[4]");
	By itemTrueFalse = By.xpath("(//div[@id='contribution-tabstrip-1']//a)[5]");
		
	public void clickBtnCreateQuestion()
	{
		waitFluentWait(btnCreateQuestion);
		click(btnCreateQuestion);
	}
	
	public void clickItemSingleChoice()
	{
		waitFluentWait(itemSingleChoice);
		click(itemSingleChoice);
	}
	
	public void clickItemMultipleChoice()
	{
		waitFluentWait(itemMultipleChoice);
		click(itemMultipleChoice);
	}
	
	public void clickItemScenario()
	{
		waitFluentWait(itemScenario);
		click(itemScenario);
	}
	
	public void clickItemTrueFalse()
	{
		waitFluentWait(itemTrueFalse);
		click(itemTrueFalse);
	}
	
	public boolean isBtnCreateQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnDeleteAll = By.xpath("(//div[@id='contribution-tabstrip-1']//button)[1]");
	By btnSubmitAll = By.xpath("(//div[@id='contribution-tabstrip-1']//button)[2]");
	
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
	}
	
	public boolean isBtnDeleteAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnDeleteAll).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnSubmitAll()
	{
		waitFluentWait(btnSubmitAll);
		click(btnSubmitAll);
	}
	
	public boolean isBtnSubmitAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSubmitAll).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtSearchQuestion = By.xpath("(//div[@id='contribution-question-grid']//input)[2]");
	By linkQuestion = By.xpath("(//div[@id='contribution-question-grid']//td[2]//a)[1]");
	
	public void searchQuestion(String question)
	{
		waitFluentWait(txtSearchQuestion);
		goTextOn(txtSearchQuestion, question);
	}
	
	public void clickLinkQuestion()
	{
		waitFluentWait(linkQuestion);
		click(linkQuestion);
	}
	
	public boolean isLinkQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconDeleteFirstItem = By.xpath("(//div[@id='contribution-question-grid']//td[11]//a)[1]");
	By iconEditFirstItem = By.xpath("(//div[@id='contribution-question-grid']//td[11]//a)[2]");
	By iconSubmitFirstItem = By.xpath("(//div[@id='contribution-question-grid']//td[11]//a)[3]");
	By iconDots = By.xpath("(//div[@id='contribution-question-grid']//td)[11]");
	
	public void clickIconDeleteFirstItem()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconDeleteFirstItem);
		click(iconDeleteFirstItem);
	}
	
	public boolean isIconDeleteFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconEditFirstItem()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconEditFirstItem);
		click(iconEditFirstItem);
	}
	
	public boolean isIconEditFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconSubmitFirstItem()
	{
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconSubmitFirstItem);
		click(iconSubmitFirstItem);
	}	
	
	public boolean isIconSubmitFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconSubmitFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void deleteFirstItem()
	{
		clickIconDeleteFirstItem();
		
		if(isLblConfirmationDisplayed() == true)
		{
			setStatusTest("pass", "Open Confirmation Popup");
		}
		else
		{
			setStatusTest("fail", "NOT Open Confirmation Popup");
		}	
		
		clickBtnYes();
	}
	
	public void deleteAll()
	{
		clickCboxAll();
		clickBtnDeleteAll();
		clickBtnYes2();
	}
	
	By cboxAll = By.xpath("(//div[@id='contribution-question-grid']//label)[1]");
	By cboxSingle = By.xpath("(//div[@id='contribution-question-grid']//label)[2]");
	
	public boolean isCboxSingleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(cboxSingle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public void clickCboxSingle()
	{
		waitFluentWait(cboxSingle);
		click(cboxSingle);
	}
	
	By lblStatus = By.xpath("(//div[@id='contribution-question-grid']//td[7]//span)[1]");
	
	public boolean isLblStatusDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblStatus).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Popup Confirm Delete
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
	By btnYes2 = By.xpath("(//button[contains(.,'YES')])[2]");
	By btnNo = By.xpath("//button[contains(.,'NO')]");
	By btnCancel = By.xpath("(//button[contains(.,'Cancel')])[5]");
	By btnSubmit = By.xpath("(//button[contains(.,'Submit')])");
	
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
	
	public void clickBtnCancel()
	{
		sleep(3);
		click(btnCancel);
	}
	
	public void clickBtnSubmit()
	{
		sleep(3);
		click(btnSubmit);
	}
	
	public void clickBtnYes()
	{
		sleep(3);
		click(btnYes);
	}

	public void clickBtnYes2()
	{
		sleep(3);
		click(btnYes2);
	}
	
	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}
}

