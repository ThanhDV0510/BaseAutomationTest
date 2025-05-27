package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Form_CreateCategory_LearningContentPool extends WebActions{

	public Form_CreateCategory_LearningContentPool(WebDriver driver) {
		super(driver);
	}
	
	By lblNoDataSearchParent = By.xpath("//div[@id='CreateParentId-list']//div[@class='k-nodata']/div");
	By txtSearchParentCategory = By.xpath("//input[@aria-owns='CreateParentId_listbox']");
	By drplistParentCategory = By.xpath("(//form[@id='create-Category-form']//span)[1]");
	
	public int countTotalParentCategory(){
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='CreateParentId_listbox']/li"));
		int size = list.size();
		return size;
	}
	
	public boolean isLblNoDataSearchParentDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(lblNoDataSearchParent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isTxtSearchParentDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(txtSearchParentCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillParentCategoryNameInvalid(String categoryname)
	{
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		waitFluentWait(txtSearchParentCategory);
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.BACK_SPACE);
		ClickElementAndType(txtSearchParentCategory, categoryname);
	}
	
	public void fillParentCategoryNameValid(String categoryname)
	{
		waitFluentWait(txtSearchParentCategory);
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.BACK_SPACE);
		ClickElementAndType(txtSearchParentCategory, categoryname);
	}
	
	By firstParentCategory = By.xpath("//ul[@id='CreateParentId_listbox']/li[1]");
	public boolean isFirstParentCategoryDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(firstParentCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickFirstParentCategory(){
		waitFluentWait(firstParentCategory);
		click(firstParentCategory);
	}
	public String getTextSelectedParentCategory(){
		String catName = "";
		try {
			catName = driver.findElement(drplistParentCategory).getText();
		} catch (Exception e) {
			System.out.println("No data returned");
		}
		return catName;
	}
	
	By errorMsgCategoryName = By.xpath("//span[@id='Name_validationMessage']");
	public boolean isErrMsgCategoryNameDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(errorMsgCategoryName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public String getTextErrorMsgCategoryName(){
		String msg = "";
		try {
			msg = driver.findElement(errorMsgCategoryName).getText();
		} catch (Exception e) {
			System.out.println("No data returned");
		}
		return msg;
	}
	
	By iconDeleteUser = By.xpath("//span[@aria-label='delete']");
	By emailUser = By.xpath("(//ul[@id='CreateApproversUsers_taglist']//span)[3]");
	By avatarUser = By.xpath("//ul[@id='CreateApproversUsers_taglist']//span[@class='avatar avatar-sm mr-2']");
	
	public boolean isAvatarUserDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(avatarUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isEmailUserDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(emailUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconDeleteUser(){
		waitFluentWait(iconDeleteUser);
		click(iconDeleteUser);
	}
	
	public String getEmail(){
		String email = "";
		try {
			email = driver.findElement(emailUser).getText();
		} catch (Exception e) {
			return "No data";
		}
		return email;
	}
}
