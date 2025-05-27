package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Inherit_PositionGoalLine extends WebActions{

	public Form_Inherit_PositionGoalLine(WebDriver driver) {
		super(driver);
	}

	By titleInherit = By.xpath("//div[@class='modal-header']/h5[@class='modal-title heading']");
	By btnX = By.xpath("(//button[@data-bind='click: inheritGoalLineVM.closeForm'])[1]");
	By btnCancel = By.xpath("(//button[@data-bind='click: inheritGoalLineVM.closeForm'])[2]");
	By btnInherit = By.id("btnInherit");
	By tabJob = By.id("job-tab");
	By tabDimension = By.id("dimension-tab");
	By ddlJobGoalLine = By.id("divSelectJobGoal");
	By firstItemJob = By.xpath("//ul[@id='ddlJobGoalLine_listbox']/li[1]");
	By firstItemJob2ndTime = By.xpath("(//ul[@id='ddlJobGoalLine_listbox']/li)[2]");
	By ddlDimensionGoalLine = By.id("ddlDimensionGoalLineInherit");
	By firstItemDimension = By.xpath("(//ul[@id='ddlDimensionGoalLineInherit_listbox']/li)[2]");
	By ckbAllFormInherit = By.xpath("//label[@title='Select current page'][@for='header-chb-inherit-job']");
	By ckbFirstItemInherit = By.xpath("(//div[@data-bind='visible: inheritGoalLineVM.inheritJobGoalLineVM.isShowGrid']//label[@title='Select this goal'])[1]");
	public boolean isTitleInheritDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleInherit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCancelInherit(){
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnCloseInherit(){
		waitFluentWait(btnX);
		click(btnX);
	}
	
	public void clickBtnInherit(){
		waitFluentWait(btnInherit);
		click(btnInherit);
	}
	
	public void clickTabJob(){
		waitFluentWait(tabJob);
		click(tabJob);
	}
	
	public void clickTabDimension(){
		waitFluentWait(tabDimension);
		click(tabDimension);
	}
	
	public void selectFirstItemJob(){
		waitFluentWait(ddlJobGoalLine);
		click(ddlJobGoalLine);
		waitFluentWait(firstItemJob);
		click(firstItemJob);
	}
	
	public void selectFirstItemJob2ndTime(){
		waitFluentWait(ddlJobGoalLine);
		click(ddlJobGoalLine);
		waitFluentWait(firstItemJob2ndTime);
		click(firstItemJob2ndTime);
	}
	
	public void selectFirstItemDimension(){
		waitFluentWait(ddlDimensionGoalLine);
		click(ddlDimensionGoalLine);
		waitFluentWait(firstItemDimension);
		click(firstItemDimension);
	}
	
	public void clickCkbAllInheritForm(){
		waitFluentWait(ckbAllFormInherit);
		click(ckbAllFormInherit);
	}
	
	public void clickCkbFirstItemInheritForm(){
		waitFluentWait(ckbFirstItemInherit);
		click(ckbFirstItemInherit);
	}
}
