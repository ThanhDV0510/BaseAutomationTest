package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UserDetailCreate extends WebActions{

	public Form_UserDetailCreate(WebDriver driver) {
		super(driver);
	}

	By titleUserDetail = By.xpath("//div[@id='user-detail-box']//h4[@id='label-edit-user']");
	public boolean isTitleUserDetailDisplayed(){
		boolean flag = isWebElementDisplayed(titleUserDetail);
		return flag;
	}
	
	By iconCloseDetail = By.xpath("//div[@id='user-detail-box']//button[@id='btn-close-edit-form']");
	public void clickIconCloseDetail(){
		waitFluentWait(iconCloseDetail);
		click(iconCloseDetail);
	}
	
	public String selectEmpCode(){
		By drpEmpCode = By.xpath("//span[@aria-owns='employee-code-dropdown_listbox']");
		By firstEmpCode = By.xpath("(//ul[@id='employee-code-dropdown_listbox']/li)[1]");
		waitFluentWait(drpEmpCode);
		click(drpEmpCode);
		sleep(1);
		String code = getText(firstEmpCode);
		waitFluentWait(firstEmpCode);
		click(firstEmpCode);
		return code;
	}
	
	By drplistDefault = By.xpath("(//form[@id='frmCreateUser']//div[4]//span)[1]");
	By txtSearchDefault = By.xpath("//div[@id='securityProfile-list']//input");
	By btnSave = By.xpath("//button[@id='btnAddUser']");
	By btnCancel = By.xpath("//button[@id='btnAddCancel']");
	By itemFirstDefault = By.xpath("//ul[@id='securityProfile_listbox']//li[1]");	
		
	public void fillSearchDefault(String searchdefault)
	{
		waitFluentWait(txtSearchDefault);
		ClickElementAndType(txtSearchDefault, searchdefault);
	}
	
	public void clickDrplistDefault()
	{
		waitFluentWait(drplistDefault);
		click(drplistDefault);
	}	
	
	public void clickItemFirstDefault()
	{
		waitFluentWait(itemFirstDefault);
		click(itemFirstDefault);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void selectFunctionSet(String searchdefault)
	{
		clickDrplistDefault();
		sleep(1);
		fillSearchDefault(searchdefault);
		sleep(1);
		clickItemFirstDefault();
		sleep(1);
		clickBtnSave();
	}
}
