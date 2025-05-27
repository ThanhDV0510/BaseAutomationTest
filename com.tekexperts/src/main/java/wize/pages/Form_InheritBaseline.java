package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_InheritBaseline extends WebActions{

	public Form_InheritBaseline(WebDriver driver) {
		super(driver);
	}

	By drplstInherit = By.xpath("(//div[@id='inherit-baseline-tabstrip']//div[@role='listbox'])[1]");
	By itemInheritFirst = By.xpath("//ul[@id='dllJobBaseLine_listbox']/li[1]");
	By titleInherit = By.xpath("//div[@id='inherit-position-baseline']//h5[@class='modal-title']");
	By ckboxAllSkill = By.xpath("//input[@class='custom-control-input job-checkAll-Skill']");
	By btnCancel = By.xpath("//div[@id='inherit-position-baseline']//div[@class='modal-footer']/button[1]");
	By btnInherit = By.xpath("//div[@id='inherit-position-baseline']//div[@class='modal-footer']/button[2]");
	By btnSaveInPreview = By.xpath("//button[@id='btn-save-inherit-position-base-line']");
	
	public void selectInherit(String jobname)
	{
		waitFluentWait(drplstInherit);
		ClickElementAndType(drplstInherit, jobname);
		waitFluentWait(itemInheritFirst);
		sleep(2);
		click(itemInheritFirst);
		sleep(2);
	}
	
	public boolean isTitleInheritDisplayed(){
		boolean flag = isWebElementDisplayed(titleInherit);
		return flag;
	}
	
	public void clickCkboxAllSkill(){
		waitFluentWait(ckboxAllSkill);
		click(ckboxAllSkill);
	}
	
	public void clickBtnCancel(){
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnInherit(){
		waitFluentWait(btnInherit);
		click(btnInherit);
	}
	
	public void clickBtnSaveInPreview(){
		waitFluentWait(btnSaveInPreview);
		click(btnSaveInPreview);
	}
}
