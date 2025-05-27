package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Goalline_Job extends WebActions {

	public Goalline_Job(WebDriver driver) {
		super(driver);
     }
		
	By txtSearchJob = By.id("search");
	By itemFirstJob = By.xpath("(//div[@class='item category-info'])[1]");
	By itemFirtSearchJob = By.xpath("//div[contains(@class,'item category-info')]");
	
	public boolean isItemFirstJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirstJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickItemFirtJob()
	{
		waitFluentWait(itemFirstJob);
		clickByJavaScript(itemFirstJob);
	}
	
	public void fillTxtSearchJob(String searchjob)
	{
		waitFluentWait(txtSearchJob);
		ClickElementAndType(txtSearchJob, searchjob);
		sleep(2);
		waitFluentWait(itemFirtSearchJob);
		click(itemFirtSearchJob);
		clickItemFirtJob();
		sleep(2);
	}
	
	By lblGoalLineName=By.xpath("//h3[@class='section-title text-uppercase']");
	
	public boolean isLblGoalLineNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblGoalLineName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnAddIcon=By.xpath("//i[@class='icon icon-plus3']");
	public boolean isBtnAddIconDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddIcon).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAddIcon()
	{
		waitFluentWait(btnAddIcon);
		clickByJavaScript(btnAddIcon);
	}
	
	By btnCreateGoal=By.xpath("(//a[@role='button'])[3]");
	public boolean isBtnCreateGoalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateGoal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateGoal()
	{
		waitFluentWait(btnCreateGoal);
		click(btnCreateGoal);
	}
	
}
