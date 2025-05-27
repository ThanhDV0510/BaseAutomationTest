package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditSecurityProfile extends WebActions {

	public Form_EditSecurityProfile(WebDriver driver) {
		super(driver);
     }

	By lblEditSecurityProfile = By.id("label-edit-security-profile");
	
	public boolean isLblEditSecurityProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditSecurityProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By tabRole = By.xpath("(//div[@id='frmEditSecurityProfile']//a)[1]");
	By tabDataPrivacy = By.xpath("(//div[@id='frmEditSecurityProfile']//a)[2]");
	
	public void clickTabRole()
	{
		waitFluentWait(tabRole);
		click(tabRole);
	}
	
	public void clickTabDataPrivacy()
	{
		waitFluentWait(tabDataPrivacy);
		click(tabDataPrivacy);
		sleep(0.5);
	}
	
	By txtSPName = By.id("update-name");
	By txtDescription = By.id("update-description");
	By btnRadio = By.xpath("(//div[@id='security-profile-edit-role-list-table']//label)[1]");
	
	public void fillSPName(String name)
	{
		waitFluentWait(txtSPName);
		ClickElementAndType(txtSPName, name);
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
	}
	
	public void inputData(String name,String Description)
	{
		fillSPName(name);
		fillDescription(Description);
		clickBtnRadio();
	}
	
	//Data Privacy
	By drplistFilterBy1 = By.xpath("(//div[@id='DataPrivacy-tabstrip-01']//div[1]/div/div)[1]");
	By txtValueDimension = By.xpath("(//div[@id='DataPrivacy-tabstrip-01']//div[2]/div/div)[1]");
	
	By drplistLinkToPosition = By.xpath("(//div[@id='DataPrivacy-tabstrip-01']//div[3]/div/div)[1]");
	By itemLinkToPosition = By.xpath("(//ul[@id='link_to_position_dropdown_edit_listbox']//li)[1]");
	
	public void selectLinkToPosition(String linktoposition)
	{
		waitFluentWait(drplistLinkToPosition);
		ClickElementAndType(drplistLinkToPosition, linktoposition);
		click(itemLinkToPosition);
	}
	
	By drplistAdditonal = By.xpath("(//div[@id='DataPrivacy-tabstrip-01']//div[4]//div/div/div)[1]");
	By txtAdditional = By.xpath("(//div[@id='DataPrivacy-tabstrip-01']//div[4]//input)[1]");
	By itemAdditonal = By.xpath("(//ul[@id='additional_position_dropdown_edit_listbox']//li)[1]");
	By itemAbc = By.id("positionAdditional1405");
	By iconRemove = By.xpath("(//ul[@id='additional_position_dropdown_edit_taglist']//span[2])[1]");
	
	public boolean isItemAbcDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemAbc).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectAdditonal(String Additonal)
	{
		if(isItemAbcDisplayed() == true)
		{
			click(iconRemove);
		}
		waitFluentWait(drplistAdditonal);
		click(drplistAdditonal);
		waitFluentWait(txtAdditional);
		typeText(txtAdditional, Additonal);
		waitFluentWait(itemAdditonal);
		click(itemAdditonal);
	}
	
	By btnCancel = By.id("btn-cancel-edit");
	By btnSave = By.id("btn-update");

	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		clickByJavaScript(btnSave);
	}

}
