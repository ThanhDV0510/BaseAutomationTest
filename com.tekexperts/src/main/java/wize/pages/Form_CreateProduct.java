package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateProduct extends WebActions {

	public Form_CreateProduct (WebDriver driver) {
		super(driver);
     }

	By lblCreateProduct = By.id("label-product-create");
	
	public boolean isLblCreateProductDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateProduct).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtProductName = By.id("createName");
	By txtDescription = By.id("createDescription");
	By btnSave = By.xpath("(//button[@id='save-button'])[1]");
	By btnCancel = By.xpath("(//button[@id='cancel-button'])[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void fillProductName(String name)
	{
		waitFluentWait(txtProductName);
		ClickElementAndType(txtProductName, name);
	}
	
	public void fillDescription(String Description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, Description);
	}
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void createProduct(String name,String Description)
	{
		fillProductName(name);
		fillDescription(Description);
		clickBtnSave();
	}
	
}
