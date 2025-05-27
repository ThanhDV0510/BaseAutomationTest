package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Form_CloneSecurityProfile extends WebActions{

	public Form_CloneSecurityProfile(WebDriver driver) {
		super(driver);
	}
	
	By lblCreateSecurityProfile = By.xpath("//h4[@title='Create function']");
	By tabDataPrivacy = By.xpath("//a[@id='DataPrivacy-tab']");
	By tabRole = By.xpath("//a[@id='Role-tab']");
	By valueFilterByOrganization1 = By.xpath("//ul[@id='filter-by-dropdown_taglist']/li[1]/span[1]");
	By valueSite = By.xpath("//ul[@id='filter_value_dropdown_taglist']/li[1]/span[1]");
	By valueFilterByOrganization2 = By.xpath("(//div[@class='form-options']//li[1]/span[1])[3]");
	By valueStatus = By.xpath("(//div[@class='form-options']//li[1]/span[1])[4]");
	By valueLinkToPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[5]");
	By valueAdditionalPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[6]");
	By valueExceptionalPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[7]");
	By btnRemoveFilter = By.xpath("//div[@class='adaptive-action-control']/button[@class='btn pt-4']");
	public boolean isLblCreateSecurityProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateSecurityProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabDataPrivacy(){
		waitFluentWait(tabDataPrivacy);
		click(tabDataPrivacy);
	}
	
	public void clickTabRole(){
		waitFluentWait(tabRole);
		click(tabRole);
	}
	
	public boolean isFilterOrganization1Correct(){
		boolean flag = false;
		try {
			waitFluentWait(valueFilterByOrganization1);
			String filterBy = driver.findElement(valueFilterByOrganization1).getText();
			System.out.println(filterBy);
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
	
	By btnCancel = By.xpath("//div[@id='create-security-profile']//button[contains(.,'Cancel')]");
	By btnSavenCreateNew = By.xpath("//div[@id='create-security-profile']//button[contains(.,'Save & Create new')]");
	By btnSave = By.xpath("//div[@id='create-security-profile']//button[3]");

	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
		sleep(2);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	By txtSPName = By.id("txtSecurityProfileName");
	By txtDescription = By.id("txtSecurityProfileDesc");
	By txtSearchRolename = By.xpath("(//div[@id='role-list-table']//input)[1]");
	By btnRadio = By.xpath("(//div[@id='role-list-table']//label)[1]");
	
	public void fillSPName(String name)
	{
		waitFluentWait(txtSPName);
		ClickElementAndType(txtSPName, name);
	}
	
	public void fillSearchRolename(String SearchRolename)
	{
		waitFluentWait(txtSearchRolename);
		ClickElementAndType(txtSearchRolename, SearchRolename);
		clickLblCreateSecurityProfile();
	}
	
	public void fillDescription(String Description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, Description);
	}
	
	public void clickBtnRadio()
	{
		waitFluentWait(btnRadio);
		click(btnRadio);
		sleep(1);
	}
	
	public void clickLblCreateSecurityProfile()
	{
		waitFluentWait(lblCreateSecurityProfile);
		click(lblCreateSecurityProfile);
	}
	
	By btnClose = By.xpath("(//button[@class='btn btn-icon close-slide'])[3]");
	public void clickBtnClose()
	{
		waitFluentWait(btnClose);
		click(btnClose);
	}
	
	By drpCloneFrom = By.xpath("//div[@id='clone-dropdown-container']//span[@class='k-input']");
	By blankItemClone = By.xpath("//div[@class='k-list-optionlabel']");
	public By getDataOffSetOfCloneItem(){
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='clone-dropdown_listbox']/li"));
		By itemClone = By.xpath("//ul[@id='clone-dropdown_listbox']/li[@data-offset-index='" + (list.size()-1) + "']");
		return itemClone;
	}
	
	public void selectCloneFrom(){
		waitFluentWait(drpCloneFrom);
		click(drpCloneFrom);
		waitFluentWait(getDataOffSetOfCloneItem());
		click(getDataOffSetOfCloneItem());
		sleep(1);
	}
	
	public void selectBlankClone(){
		waitFluentWait(drpCloneFrom);
		click(drpCloneFrom);
		waitFluentWait(blankItemClone);
		click(blankItemClone);
		sleep(1);
	}
	
	By btnPreviewEmpList = By.xpath("(//button[@class='btn btn-light'][1])[5]");
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
	
	public void clickRemoveFilter(){
		waitFluentWait(btnRemoveFilter);
		click(btnRemoveFilter);
	}
}
