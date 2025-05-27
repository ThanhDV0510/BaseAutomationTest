package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Organization_BusinessUnit extends WebActions {

	public Organization_BusinessUnit(WebDriver driver) {
		super(driver);
     }
	
	By lblBusinessUnit = By.id("label-business-unit");
		
	public boolean isLblBusinessUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBusinessUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnAdd = By.id("createBusinessUnit");
	By txtSearch = By.xpath("(//div[@id='businessUnit-list-grid']//input)[1]");
	By iconEdit = By.xpath("(//a[@id='action-edit'])[1]");
	By iconDelete = By.xpath("(//a[@id='action-delete'])[1]");
	By iconPlus = By.xpath("(//a[@id='action-create'])[1]");
	By itemFirst = By.xpath("(//div[@id='businessUnit-list-grid']//td/span[2])[1]");
	
	public boolean isItemFirstDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(itemFirst).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAdd).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitFluentWait(btnAdd);
		click(btnAdd);
	}

	public boolean isIconEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconEdit()
	{
		waitFluentWait(itemFirst);
		moveHoverElement(driver.findElement(itemFirst));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconDelete()
	{
		waitFluentWait(itemFirst);
		moveHoverElement(driver.findElement(itemFirst));
		waitFluentWait(iconDelete);
		click(iconDelete);
	}
	
	public boolean isIconPlusDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconPlus).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickIconPlus()
	{
		waitFluentWait(itemFirst);
		moveHoverElement(driver.findElement(itemFirst));
		waitFluentWait(iconPlus);
		click(iconPlus);
	}
		
	public void fillSearchName(String searchname)
	{
		waitFluentWait(txtSearch);
		goTextOn(txtSearch, searchname);
	}
}

