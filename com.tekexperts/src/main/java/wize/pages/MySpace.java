package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MySpace extends WebActions {

	public MySpace(WebDriver driver) {
		super(driver);
     }
	
	By lblNameSpace = By.xpath("//div[@id='myspace-header']//h4");
	
	public boolean isLblNameSpaceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblNameSpace).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	By tabMyTalent = By.xpath("//div[@id='my-space-tabstrip']//a[contains(text(),'My Talent')]");
	By tabMyData = By.xpath("//div[@id='my-space-tabstrip']//a[contains(text(),'My Data')]");
	By tabGrowthandOptimization = By.xpath("//div[@id='my-space-tabstrip']//a[contains(text(),'Growth and Optimization')]");
	By tabMyContribution = By.xpath("//div[@id='my-space-tabstrip']//a[contains(text(),'My Contribution')]");
	By tabPendingforApproval = By.xpath("//div[@id='my-space-tabstrip']//a[contains(text(),'Pending for Approval')]");
	By menuMySpace = By.xpath("//li[@id='link-my-space']//a[contains(text(),'MY SPACE')]");
	
	public void clickMySpace()
	{
		waitFluentWait(menuMySpace);
		click(menuMySpace);
	}
	
	public boolean isTabMyTalentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMyTalent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabMyTalent()
	{
		waitFluentWait(tabMyTalent);
		click(tabMyTalent);
	}
	
	public boolean isTabGrowthandOptimizationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabGrowthandOptimization).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabGrowthandOptimization()
	{
		waitFluentWait(tabGrowthandOptimization);
		click(tabMyTalent);
	}
	
	
	public boolean isTabMyDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMyData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabMyData()
	{
		sleep(3);
		click(tabMyData);
	}
		
	public boolean isTabMyContributionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMyContribution).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabMyContribution()
	{
		waitFluentWait(tabMyContribution);
		click(tabMyContribution);
	}
	
	public boolean isTabPendingforApprovalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabPendingforApproval).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabPendingforApproval()
	{
		waitFluentWait(tabPendingforApproval);
		click(tabPendingforApproval);
	}
}

