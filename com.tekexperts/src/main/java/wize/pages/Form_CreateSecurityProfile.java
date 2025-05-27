package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Form_CreateSecurityProfile extends WebActions {

	public Form_CreateSecurityProfile(WebDriver driver) {
		super(driver);
     }

	By lblCreateSecurityProfile = By.xpath("//div[@id='create-security-profile']//h4");
	By tabRole = By.xpath("//a[@id='Role-tab']");
	By tabDataPrivacy = By.xpath("//a[@id='DataPrivacy-tab']");
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
	
	public void clickLblCreateSecurityProfile()
	{
		waitFluentWait(lblCreateSecurityProfile);
		click(lblCreateSecurityProfile);
	}
	
	public boolean isTabRoleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabRole).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabRole()
	{
		waitFluentWait(tabRole);
		click(tabRole);
	}
	
	public boolean isTabDataPrivacyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabDataPrivacy).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabDataPrivacy()
	{
		waitFluentWait(tabDataPrivacy);
		click(tabDataPrivacy);
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
	
	public void inputData(String name,String Description,String SearchRolename)
	{
		fillSPName(name);
		fillDescription(Description);
		fillSearchRolename(SearchRolename);
		clickBtnRadio();
		sleep(1);
	}
	
	By txtFilterByOrganization1 = By.xpath("//input[@aria-describedby='filter-by-dropdown_taglist']");
	By txtFilterSite = By.xpath("//input[@aria-describedby='filter_value_dropdown_taglist']");
	By btnAddFilter = By.xpath("(//button[@class='btn text-primary pt-4'])[2]");
	By btnRemoveFilter = By.xpath("//div[@class='adaptive-action-control']/button[@class='btn pt-4']");
	By txtFilterByOrganization2 = By.xpath("(//div[@role='listbox']/input)[3]");
	By txtFilterStatus = By.xpath("(//div[@role='listbox']/input)[4]");

	By txtFilterLinkToPosition = By.xpath("//input[@aria-describedby='link_to_position_dropdown_taglist']");
	By radioAllUnderMe = By.xpath("//input[@id='allUnderMe_create']");
	By radioDirectReport = By.xpath("//input[@id='directReport_create']");
	
	By txtFilterAdditionalPosition = By.xpath("//input[@aria-describedby='additional_position_dropdown_taglist']");
	By txtFilterExceptionPosition = By.xpath("//input[@aria-describedby='exceptional_position_dropdown_taglist']");
	
	public void selectOrganization1(String input){
		waitFluentWait(txtFilterByOrganization1);
		goTextOn(txtFilterByOrganization1, input);
	}
	
	public void selectSite(String input){
		waitFluentWait(txtFilterSite);
		goTextOn(txtFilterSite, input);
	}
	
	public void clickAddFilter(){
		waitFluentWait(btnAddFilter);
		click(btnAddFilter);
	}
	
	public void clickRemoveFilter(){
		waitFluentWait(btnRemoveFilter);
		click(btnRemoveFilter);
	}
	
	public boolean isRemoveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnRemoveFilter).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectOrganization2(String input){
		waitFluentWait(txtFilterByOrganization2);
		goTextOn(txtFilterByOrganization2, input);
	}
	
	public void selectStatus(String input){
		waitFluentWait(txtFilterStatus);
		goTextOn(txtFilterStatus, input);
	}
	
	public void selectLinkToPosition(String input){
		waitFluentWait(txtFilterLinkToPosition);
		goTextOn(txtFilterLinkToPosition, input);
	}
	
	public void selectAdditionalPosition(String input){
		waitFluentWait(txtFilterAdditionalPosition);
		goTextOnNoEnter(txtFilterAdditionalPosition, input);
		waitFluentWait(By.xpath("//ul[@id='additional_position_dropdown_listbox']/li[1]"));
		click(By.xpath("//ul[@id='additional_position_dropdown_listbox']/li[1]"));
		sleep(3);
	}
	
	public void selectExceptionalPosition(String input){
		waitFluentWait(txtFilterExceptionPosition);
		goTextOnNoEnter(txtFilterExceptionPosition, input);
		waitFluentWait(By.xpath("//ul[@id='exceptional_position_dropdown_listbox']/li[1]"));
		click(By.xpath("//ul[@id='exceptional_position_dropdown_listbox']/li[1]"));
		sleep(3);
	}
	
	public void selectRadioAllUnderme(){
		waitFluentWait(radioAllUnderMe);
		click(radioAllUnderMe);
	}
	
	public void selectRadioDirectReport(){
		waitFluentWait(radioDirectReport);
		click(radioDirectReport);
	}
	
	public void inputPrivacy(){
		clickTabDataPrivacy();
		selectOrganization1("Site");
		sleep(2);
		selectSite("VNM");
		clickAddFilter();
		selectOrganization2("Status");
		sleep(2);
		selectStatus("Active-Filled");
		selectLinkToPosition("01212 Tech Lead 1");
		selectRadioDirectReport();
		selectRadioAllUnderme();
		selectAdditionalPosition("A lan-008");
		selectExceptionalPosition("Lan next position Critsit Manager English");
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
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}

	By drpCloneFrom = By.xpath("//div[@id='clone-dropdown-container']//span[@class='k-input']");
	
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
	
	By valueFilterByOrganization1 = By.xpath("//ul[@id='filter-by-dropdown_taglist']/li[1]/span[1]");
	By valueSite = By.xpath("//ul[@id='filter_value_dropdown_taglist']/li[1]/span[1]");
	By valueFilterByOrganization2 = By.xpath("(//div[@class='form-options']//li[1]/span[1])[3]");
	By valueStatus = By.xpath("(//div[@class='form-options']//li[1]/span[1])[4]");
	By valueLinkToPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[5]");
	By valueAdditionalPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[6]");
	By valueExceptionalPosition = By.xpath("(//div[@class='form-options']//li[1]/span[1])[7]");
	
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
}
