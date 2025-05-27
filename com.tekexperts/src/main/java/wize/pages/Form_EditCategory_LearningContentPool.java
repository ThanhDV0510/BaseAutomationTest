package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Form_EditCategory_LearningContentPool extends WebActions{

	public Form_EditCategory_LearningContentPool(WebDriver driver) {
		super(driver);
	}
	
	By lblEditCategory = By.xpath("//h4[@title='Edit Category']");
	By iconX = By.xpath("//div[@id='edit-category-box']//button[@title='Close']");
	By btnCancel = By.xpath("//div[@id='edit-category-box']//button[@id='cancelCategory']");
	By btnSave = By.xpath("//div[@id='edit-category-box']//button[@id='saveCategory']");
	By drplistParentCategory = By.xpath("(//form[@id='edit-category-form']//span)[1]");
	By txtSearchParentCategory = By.xpath("//input[@aria-owns='EditParentId_listbox']");
	
	public boolean isLblEditCategoryDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(lblEditCategory).size() > 0) {
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
	
	public boolean isIconXDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(iconX).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconX(){
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public boolean isBtnCancelDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnCancel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCancel(){
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public boolean isBtnSaveDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnSave).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnSave(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public boolean isBtnSaveEnable()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSave).isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCancelEnable()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCancel).isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public int countTotalParentCategory(){
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='EditParentId_listbox']/li"));
		int size = list.size();
		return size;
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
	
	By lblNoDataSearchParent = By.xpath("//div[@id='EditParentId-list']//div[@class='k-nodata']/div");
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
	
	public void fillParentCategoryNameValid(String categoryname)
	{
		waitFluentWait(txtSearchParentCategory);
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(txtSearchParentCategory).sendKeys(Keys.BACK_SPACE);
		ClickElementAndType(txtSearchParentCategory, categoryname);
	}
	
	By firstParentCategory = By.xpath("//ul[@id='EditParentId_listbox']/li[1]");
	By secondParentCategory = By.xpath("//ul[@id='EditParentId_listbox']/li[2]");
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
	
	public void clickSecondParentCategory(){
		waitFluentWait(secondParentCategory);
		click(secondParentCategory);
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
	
	By txtCategoryName = By.id("EditName");
	public void fillCategoryName(String categoryname)
	{
		waitFluentWait(txtCategoryName);
		ClickElementAndType(txtCategoryName, categoryname);
	}
	
	public void clearInputCategoryName(){
		driver.findElement(txtCategoryName).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(txtCategoryName).sendKeys(Keys.BACK_SPACE);
	}
	
	By drplistUser = By.xpath("//form[@id='edit-category-form']/div[4]//div[1]");
	By itemUser = By.xpath("//*[@id='EditApproversUsers-list']//li[1]");
	public void selectUser(String user)
	{
		waitFluentWait(drplistUser);
		ClickElementAndType(drplistUser, user);
		sleep(5);
		click(itemUser);
		sleep(1);
	}
	
	By emailUser = By.xpath("(//ul[@id='EditApproversUsers_taglist']//span)[3]");
	By avatarUser = By.xpath("//ul[@id='EditApproversUsers_taglist']//span[@class='avatar avatar-sm mr-2']");
	
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
	
	public String getEmail(){
		String email = "";
		try {
			email = driver.findElement(emailUser).getText();
		} catch (Exception e) {
			return "No data";
		}
		return email;
	}
	
	By iconDeleteUser = By.xpath("//span[@aria-label='delete']");
	public void clickIconDeleteUser(){
		waitFluentWait(iconDeleteUser);
		click(iconDeleteUser);
	}
	
	public void deleteAllAssignedUser(){
		while (isAvatarUserDisplayed()){
			clickIconDeleteUser();
		}
	}
	
	By itemBlank = By.xpath("//div[@id='EditParentId-list']/div[@class='k-list-optionlabel']");
	public void selectItemBlank(){
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		waitFluentWait(itemBlank);
		clickByJavaScript(itemBlank);
	}
	
	public void selectSecondParentCategory()
	{
		waitFluentWait(avatarUser);
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		clickSecondParentCategory();
	}
	
	public void selectParentCategoryAll()
	{
		waitFluentWait(avatarUser);
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		clickFirstParentCategory();
	}
	
	public void selectParentCategory(String parent)
	{
		waitFluentWait(avatarUser);
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		sleep(5);
		goTextOn(txtSearchParentCategory, parent);
	}
}
