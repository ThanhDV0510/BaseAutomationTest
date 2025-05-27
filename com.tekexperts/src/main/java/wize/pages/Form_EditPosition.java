package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditPosition extends WebActions {

	public Form_EditPosition(WebDriver driver) {
		super(driver);
     }

	By lblEditPosition = By.id("label-create-position");
	
	By drplistDimension = By.id("(//div[@id='add-position']/section/div[2]/form/div/div/div/div)[1]");
	By itemBusinessUnit = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Business Unit')]");
	By itemCountry = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Country')]");
	By itemProduct = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Product')]");
	By itemProject = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Project')]");
	By itemRegion = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Region')]");
	By itemSite = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Site')]");
	By itemTeam = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Team')]");
	By itemUnitDepartment = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Unit/Department')]");

	By drplistBusinessUnit = By.xpath("//div[@id='divBusinessUnit']/div/span");
	By txtSearchBusinessUnit = By.xpath("//div[@id='ddlBusinessUnit-list']/span/input");
	By firstItemBusinessUnit = By.xpath("(//ul[@id='ddlBusinessUnit_listbox']/li)[1]");
			
	By drplistJob = By.id("ddlJob");
	By firstItemJob = By.xpath("(//ul[@id='ddlJob_listbox']/li)[1]");
	
	By drplistLevel = By.id("ddlJobLevel");
	By firstItemLevel = By.xpath("//ul[@id='ddlJobLevel_listbox']/li[1]");
		
	By txtPositionName = By.id("txtPositionName");
	
	By btnCancel = By.id("btn-cancel");
	By btnSave = By.id("btn-save");
	
	public boolean isLblEditPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void fillPositionName(String positionname){
		waitFluentWait(txtPositionName);
		driver.findElement(txtPositionName).clear();
		goTextOnNoEnter(txtPositionName, positionname);
	}
		
}
