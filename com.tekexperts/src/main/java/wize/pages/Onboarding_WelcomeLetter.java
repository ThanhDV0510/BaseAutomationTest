package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Onboarding_WelcomeLetter extends WebActions {

	public Onboarding_WelcomeLetter(WebDriver driver) {
		super(driver);
     }

	By lblOnboardingWelcomeLetter = By.id("label-letter-name");
		
	public boolean isLblOnboardingWelcomeLetterDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblOnboardingWelcomeLetter).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnEdit = By.id("btn-edit-letter");
	
	public void clickBtnEdit()
	{
		waitFluentWait(btnEdit);
		click(btnEdit);
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtTitle= By.id("updateLetterTitle");
	By txtContentText = By.xpath("//div[@id='formEditLetter']//iframe");
	By txtAuthor = By.xpath("//div[@id='formEditLetter']//div[3]//div");
	By firstAuthorItem = By.xpath("(//ul[@id='updateLetterAuthor_listbox']//li)[1]");
	By txtAuthorTitle = By.id("updateAuthorTitle");
	
	public void fillTitle(String title)
	{
		waitFluentWait(txtTitle);
		goTextOn(txtTitle, title);
	}
	
	public void fillContentText(String contenttext)
	{
		waitFluentWait(txtContentText);
		ClickElementAndType(txtContentText, contenttext);
	}

	public void selectAuthor()
	{
		waitFluentWait(txtAuthor);
		click(txtAuthor);
		waitFluentWait(firstAuthorItem);
		click(firstAuthorItem);
	}
	
	public void fillAuthorTitle(String AuthorTitle)
	{
		waitFluentWait(txtAuthorTitle);
		goTextOn(txtAuthorTitle, AuthorTitle);
	}
	
	By btnCancel = By.id("btn-cancel");
	By btnSave = By.id("btn-save");	
	
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
