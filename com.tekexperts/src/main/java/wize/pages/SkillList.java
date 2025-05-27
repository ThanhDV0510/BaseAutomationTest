package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class SkillList extends WebActions {

	public SkillList(WebDriver driver) {
		super(driver);
     }
	
	By lblSkill = By.id("label-skill-category");
	By linkClickHere = By.xpath("(//div[@id='skillScreen']//p/a)[2]");
	By linkClickHereCategory = By.xpath("(//a[@class='btn-link text-primary'][contains(.,'Click here')])[1]");
	
	public boolean isLblSkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkClickHereDisplayed() {
		try {
			waitFluentWait(linkClickHere);
			if (driver.findElement(linkClickHere).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isLinkClickHereCategoryDisplayed() {
		try {
			waitFluentWait(linkClickHereCategory);
			if (driver.findElement(linkClickHereCategory).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	By btnAddCategory = By.id("showAddCategory");
	By txtSearchCategory = By.id("txtSearchCategory");
	By firtItemCategory = By.xpath("(//ul[@id='categoryView']//div)[1]");
	By iconMenu = By.xpath("(//ul[@id='categoryView']//div[2]/i)[1]");	
	By iconSearch = By.id("searchCategory");
	By txtCategoryName = By.xpath("//form[@id='frmEditSkillCategory']/input");
	By iconDeleteCategory = By.xpath("(//ul[@id='categoryView']//button[@title='Delete'])[1]");
	By iconEditCategory = By.xpath("(//ul[@id='categoryView']//button[@title='Edit'])[1]");
	By iconSaveCategory = By.xpath("//ul[@id='categoryView']//button[@title='Save']");
	By iconCancelCategory = By.xpath("//ul[@id='categoryView']//button[@title='Cancel']");
	By iconRemoveCategory = By.xpath("//div[@id='divListView']//span[@title='clear']");

	public boolean isFirtItemCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firtItemCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void searchCategory1(String category)
	{
		waitFluentWait(txtSearchCategory);
		ClickElementAndType(txtSearchCategory, category);
		click(iconSearch);
	}
	
	public void searchCategory(String category)
	{
		waitFluentWait(txtSearchCategory);
		ClickElementAndType(txtSearchCategory, category);
		clickFirtItemCategory();
	}
	
	public void clickFirtItemCategory()
	{
		waitFluentWait(firtItemCategory);
		click(firtItemCategory);
	}
	
	public void clickBtnAddCategory()
	{
		waitFluentWait(btnAddCategory);
		click(btnAddCategory);
	}
	
	public void clickIconRemoveCategory()
	{
		moveHoverElement(driver.findElement(txtSearchCategory));
		waitFluentWait(iconRemoveCategory);
		click(iconRemoveCategory);
	}
	
	public boolean isTxtCategoryNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtCategoryName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconDeleteCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEditCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillCategoryName(String categoryname)
	{
		waitFluentWait(txtCategoryName);
		goTextOn(txtCategoryName, categoryname);
	}
	
	public void clickIconDeleteCategory()
	{
		moveHoverElement(driver.findElement(firtItemCategory));
		waitFluentWait(iconMenu);
		moveHoverElement(driver.findElement(iconMenu));
		waitFluentWait(iconDeleteCategory);
		click(iconDeleteCategory);
	}
	
	public void clickIconEditCategory()
	{
		moveHoverElement(driver.findElement(firtItemCategory));
		waitFluentWait(iconMenu);
		moveHoverElement(driver.findElement(iconMenu));
		waitFluentWait(iconEditCategory);
		click(iconEditCategory);
	}
	
	public void clickIconSaveCategory()
	{
		waitFluentWait(iconSaveCategory);
		click(iconSaveCategory);
	}
	
	public void clickIconCancelCategory()
	{
		waitFluentWait(iconCancelCategory);
		click(iconCancelCategory);
	}
	
	public boolean isIconSaveCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconSaveCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By lblSkillList = By.id("label-skill-list");
	By txtSearchSkill = By.id("txtSearchSkill");
	By itemFirstSkill = By.xpath("(//ul[@id='skillView']//div)[1]");
	By btnAddSkill = By.id("btn-create-skill");
	
	public boolean isLblSkillListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkillList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddSkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void searchSkill(String skill)
	{
		waitFluentWait(txtSearchSkill);
		ClickElementAndType(txtSearchSkill, skill);
	}
	
	public void clickItemFirstSkill()
	{
		waitFluentWait(itemFirstSkill);
		click(itemFirstSkill);
	}
	
	public void clickBtnAddSkill()
	{
		waitFluentWait(btnAddSkill);
		click(btnAddSkill);
	}
	
	By lblSkillDetails = By.xpath("//section[@id='detailSkill']/div[1]//h3");
	By btnEdit = By.xpath("//section[@id='detailSkill']//button[@title='Edit']");
	
	public boolean isLblSkillDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkillDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnEdit()
	{
		waitFluentWait(btnEdit);
		click(btnEdit);
	}
}
