package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CloneBaseline extends WebActions {

	public Form_CloneBaseline(WebDriver driver) {
		super(driver);
     }
	
	By lbClonelBaseline = By.xpath("//div[@id='clone-job-baseline']//h5[@class='modal-title']");
	
	By drplistClone = By.xpath("//div[@id='clone-job-baseline']//div[2]/div/div/div/div/div[1]");
	By itemCloneFirst = By.xpath("(//ul[@id='ddlJobBaseLine_listbox']//li[1])[1]");
	
	By lblBaseline = By.xpath("(//div[@id='clone-job-baseline']//h3)[1]");
	
	By iconX = By.xpath("//div[@id='clone-form']/div/div[1]//button");
	By btnClone= By.xpath("(//button[@id='addSkill'])");
	By btnCancel = By.xpath("//div[@id='clone-job-baseline']//div[3]/button[1]");
	By btnSaveInPreview = By.xpath("//button[@id='btnSaveJobBaseLine']");
	
	public boolean isLbClonelBaselineDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lbClonelBaseline);
			if ( driver.findElement(lbClonelBaseline).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnClone()
	{
		waitFluentWait(btnClone);
		click(btnClone);
	}
	
	public void clickBtnSaveInPreview()
	{
		waitFluentWait(btnSaveInPreview);
		click(btnSaveInPreview);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public boolean isLblBaselineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblBaseline()
	{
		waitFluentWait(lblBaseline);
		click(lblBaseline);
	}
	
	public void selectClone(String jobname) throws InterruptedException
	{
		waitFluentWait(drplistClone);
		ClickElementAndType(drplistClone, jobname);
		waitFluentWait(itemCloneFirst);
		Thread.sleep(2000);
		click(itemCloneFirst);
	}
}
