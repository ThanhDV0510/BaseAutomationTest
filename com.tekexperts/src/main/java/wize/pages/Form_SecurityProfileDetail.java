package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_SecurityProfileDetail extends WebActions{

	public Form_SecurityProfileDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By lblSPDetail = By.xpath("//div[@id='detail-security-profile']//h4");
	By tabDataPrivacy = By.xpath("//a[@id='DataPrivacy-detail-tab']");
	By tabRole = By.xpath("//a[@id='Role-tab']");
	By valueFilterByOrganization1 = By.xpath("(//ul[@id='filter-by-dropdown_detail_taglist']/li[1]/span[1])[1]");
	By valueSite = By.xpath("(//div[@role='listbox']/ul/li/span[1])[2]");
	By valueFilterByOrganization2 = By.xpath("(//div[@role='listbox']/ul/li/span[1])[3]");
	By valueStatus = By.xpath("(//div[@role='listbox']/ul/li/span[1])[4]");
	By valueLinkToPosition = By.xpath("(//div[@role='listbox']/ul/li/span[1])[5]");
	By valueAdditionalPosition = By.xpath("(//div[@role='listbox']/ul/li/span[1])[6]");
	By valueExceptionalPosition = By.xpath("(//div[@role='listbox']/ul/li/span[1])[7]"); 
	public boolean isLblSecurityProfilelDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSPDetail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabRole(){
		waitFluentWait(tabRole);
		click(tabRole);
	}
	
	public void clickTabDataPrivacy(){
		sleep(3);
		waitFluentWait(tabDataPrivacy);
		click(tabDataPrivacy);
	}
	
	public boolean isFilterOrganization1Correct(){
		boolean flag = false;
		try {
			waitFluentWait(valueFilterByOrganization1);
			String filterBy = driver.findElement(valueFilterByOrganization1).getText();
			if(filterBy.equals("Site")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSiteCorrect(){
		boolean flag = false;
		try {
			waitFluentWait(valueSite);
			String filterBy = driver.findElement(valueSite).getText();
			if(filterBy.equals("VNM")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isFilterOrganization2Correct(){
		boolean flag = false;
		try {
			waitFluentWait(valueFilterByOrganization2);
			String filterBy = driver.findElement(valueFilterByOrganization2).getText();
			if(filterBy.equals("Status")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isStatusCorrect(){
		boolean flag = false;
		try {
			waitFluentWait(valueStatus);
			String filterBy = driver.findElement(valueStatus).getText();
			if(filterBy.equals("Active-Filled")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkToPositionCorrect(){
		boolean flag = false;
		try {
			waitFluentWait(valueLinkToPosition);
			String filterBy = driver.findElement(valueLinkToPosition).getText();
			if(filterBy.equals("01212 Tech Lead 1")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isAdditionalPositionCorrect(){
		boolean flag = false;
		try {
			waitFluentWait(valueAdditionalPosition);
			String filterBy = driver.findElement(valueAdditionalPosition).getText();
			if(filterBy.equals("A lan-008")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isExceptionalPositionCorrect(){
		boolean flag = false;
		try {
			waitFluentWait(valueExceptionalPosition);
			String filterBy = driver.findElement(valueExceptionalPosition).getText();
			if(filterBy.equals("Lan next position Critsit Manager English")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By annoucement = By.xpath("//div[@class='announcement-body']//h5");
	public boolean isAnnoucementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(annoucement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnClose = By.xpath("(//button[@class='btn btn-icon close-slide'])[1]");
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	By btnPreviewEmpList = By.xpath("(//button[@class='btn btn-light'][1])[3]");
	By itemFullName = By.xpath("//div[@id='Review-Employee-Privacy']//td[2]/span");
	By btnClosePreview = By.xpath("(//button[@class='btn btn-light'][1])[7]");
	public void clickBtnPreviewEmpList(){
		waitFluentWait(btnPreviewEmpList);
		click(btnPreviewEmpList);
		waitFluentWait(itemFullName);
	}
	
	public boolean isItemFullNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFullName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnClosePreview(){
		waitFluentWait(btnClosePreview);
		click(btnClosePreview);
	}
	
	public boolean isValueFilterByOrganization1Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueFilterByOrganization1).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueSiteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueSite).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueFilterByOrganization2Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueFilterByOrganization2).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueStatusDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueStatus).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueLinkToPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueLinkToPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueAdditionalPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueAdditionalPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isValueExpectionalPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(valueExceptionalPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
