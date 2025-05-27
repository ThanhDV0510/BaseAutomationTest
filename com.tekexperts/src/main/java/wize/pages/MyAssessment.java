package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyAssessment extends WebActions {

	public MyAssessment(WebDriver driver) {
		super(driver);
     }
		
	By lblApproval = By.xpath("(//div[@id='my-space-tabstrip-2']//h6)[1]");
	By lblStatusPublic = By.xpath("(//div[@id='myPublicTestListView']//span)[1]");
	By lblStatusManual = By.xpath("(//div[@id='listViewManually']//span)[1]");
	By btnViewResult = By.xpath("(//a[contains(.,'View result')])[1]");
	By btnTryAgainEnable = By.xpath("(//a[contains(.,'Try again')])[1]");
	By btnTryAgainDisable = By.xpath("(//a[@class='btn btn-primary disabled'])[1]");
	By lblPaused = By.xpath("(//span[contains(.,'Paused')])[1]");
	By btnResume = By.xpath("(//a[contains(.,'Resume')])[1]");
	By lblToolTip=By.xpath("(//div[@class='test-request-footer']/span)[2]");
	
	public boolean isLblApprovalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblApproval).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblStatusPublicDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblStatusPublic).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnTryAgainEnableDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnTryAgainEnable).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnTryAgainDisableDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnTryAgainDisable).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnViewResultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnViewResult).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblStatusManualDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblStatusManual).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void hoverOnLblStatusManual()
	{
		waitFluentWait(lblStatusManual);
		moveHoverElement(driver.findElement(lblStatusManual));
	}
	
	
	public void hoverOnLblStatusPublic()
	{
		waitFluentWait(lblStatusPublic);
		moveHoverElement(driver.findElement(lblStatusPublic));
	}
	
	public boolean isLblPausedDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPaused).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnResumeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnResume).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnResume()
	{
		waitFluentWait(btnResume);
		click(btnResume);		
	}
	
	public void hoverOnLblPaused()
	{
		waitFluentWait(lblPaused);
		moveHoverElement(driver.findElement(lblPaused));
	}
	
	By statusApprovalRequested =By.xpath("(//div[@id='listViewMyTestApproval']//span)[1]");
	By firstAssessment=By.xpath("(//div[@id='listViewMyTestApproval']//img)[1]");
			
	public void hoverOnAssessment()
	{
		waitFluentWait(firstAssessment);
		moveHoverElement(driver.findElement(firstAssessment));
	}
		
	public boolean isStatusApprovalRequestedDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(statusApprovalRequested).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	By btnLetBegin=By.xpath("//a[contains(@class,'btn btn-primary')]");
	
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
		
	By lblCompleteStatus=By.xpath("(//div[@class='sub-tag'][contains(.,'Completed')])[1]");
	
	public boolean isLblCompleteStatusDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCompleteStatus).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblToolTipDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblToolTip).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnTryAgain=By.xpath("//span[contains(.,'Try again')]");
	
	public void hoverOnBtnTryAgain()
	{
		waitFluentWait(btnTryAgain);
		moveHoverElement(driver.findElement(btnTryAgain));
	}
}
