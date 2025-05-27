package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class QuestionPool extends WebActions {

	public QuestionPool(WebDriver driver) {
		super(driver);
     }
	
	By lblQuestionPool = By.xpath("(//div[@id='main']//li)[2]");
	
	By lblQuestion = By.xpath("//div[@id='question-pool-main-div']//h3");
	By txtSearchQuestion = By.xpath("//input[@aria-label='Question']");

	By lblCategory = By.xpath("//section[@id='questionCategory-screen']//h6");
	By btnCreateCategory = By.id("createCategory");
	By txtSearchCategory = By.id("searchText");
	By firstCategory = By.xpath("//div[@id='questionCategory-list-grid']//span[4]");
	By lblNoData = By.xpath("//div[@id='questionCategory-list-grid']//span[1]");
	By iconEditCategory = By.id("action-edit");
	By iconDeleteCategory = By.id("action-delete");
	By iconDots = By.xpath("(//div[@id='questionCategory-list-grid']//i)[1]");
	By iconRemoveCategory = By.xpath("(//section[@id='questionCategory-screen']//span)[2]");

	public boolean isLblCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblQuestionPoolDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestionPool).size() > 0) {
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
	
	public boolean isBtnCreateCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblNoDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblNoData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateCategory()
	{
		waitFluentWait(btnCreateCategory);
		click(btnCreateCategory);
		sleep(2);
	}
	
	public void clickIconEditCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconEditCategory);
		click(iconEditCategory);
	}
	
	public void clickIconDeleteCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconDeleteCategory);
		click(iconDeleteCategory);
	}
	
	public void fillSearchCategory(String searchcategory)
	{
		waitFluentWait(txtSearchCategory);
		goTextOn(txtSearchCategory, searchcategory);
	}
	
	public void fillSearchQuestion(String searchQuestion)
	{
		waitFluentWait(txtSearchQuestion);
		goTextOn(txtSearchQuestion, searchQuestion);
	}
	
	public void clickFirstCategory()
	{
		waitFluentWait(firstCategory);
		click(firstCategory);
	}
	
	public void selectCategory(String searchcategory)
	{
		fillSearchCategory(searchcategory);
		clickFirstCategory();
	}
	
	public boolean isFirstCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Create Category Popup
	By lblCreateCategory = By.xpath("//div[@id='questionCategory-create-box']//h4");
	By drplistParentCategory = By.xpath("(//form[@id='create-questionCategory-form']//span)[1]");
	By itemAll = By.xpath("(//ul[@id='CreateParentId_listbox']/li)[1]");
	By txtCategoryName = By.id("createName");
	By drplistUser = By.xpath("//form[@id='create-questionCategory-form']/div[4]//div[1]");
	By itemUser = By.xpath("//*[@id='CreateApproversUsers_listbox']/li");
	By btnSave = By.id("saveQuestionCategory");
	By btnCancel = By.id("cancelQuestionCategory");
	
	
	public boolean isLblCreateCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconRemoveCategory()
	{
		moveHoverElement(driver.findElement(txtSearchCategory));
		waitFluentWait(iconRemoveCategory);
		click(iconRemoveCategory);
	}
	
	public void clickLblCreateCategory()
	{
		waitFluentWait(lblCreateCategory);
		click(lblCreateCategory);
	}
	
	public void selectParentCategory()
	{
		waitFluentWait(drplistParentCategory);
		ClickElement(drplistParentCategory);
		sleep(5);
		click(itemAll);
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
	
	public void fillCategoryName(String categoryname)
	{
		waitFluentWait(txtCategoryName);
		ClickElementAndType(txtCategoryName, categoryname);
	}
	
	public void selectUser(String user)
	{
		waitFluentWait(drplistUser);
		ClickElementAndType(drplistUser, user);
		sleep(5);
		click(itemUser);
		sleep(1);
	}
		
	public void createCategory(String categoryname,String user)
	{
		clickBtnCreateCategory();
		selectParentCategory();
		fillCategoryName(categoryname);
		selectUser(user);
		clickBtnSave();
	}
	
	//Edit Category Popup
	By lblEditCategory = By.xpath("//div[@id='questionCategory-edit-box']//h4");
	By txtUpdateCategoryName = By.id("EditName");
	By iconRemove = By.xpath("(//ul[@id='EditApproversUsers_taglist']//span)[5]");
	By btnSaveUpdateCategory = By.xpath("(//button[@id='saveQuestionCategory'])[2]");
	By btnCancelUpdateCategory = By.xpath("(//button[@id='cancelQuestionCategory'])[2]");
	
	public void fillUpdateCategoryName(String Updatecategoryname)
	{
		waitFluentWait(txtUpdateCategoryName);
		ClickElementAndType(txtUpdateCategoryName, Updatecategoryname);
	}
	
	public boolean isLblEditCategoryDisplayed()
	{
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
	
	public void clickBtnSaveUpdateCategory()
	{
		sleep(1);
		waitFluentWait(btnSaveUpdateCategory);
		click(btnSaveUpdateCategory);
	}
	
	public void clickBtnCancelUpdateCategory()
	{
		sleep(1);
		waitFluentWait(btnCancelUpdateCategory);
		click(btnCancelUpdateCategory);
	}
	
	public void clickIconRemove()
	{
		waitFluentWait(iconRemove);
		click(iconRemove);
	}
	
	//Button Create Question
	By btnCreateQuestion = By.xpath("//div[@id='question-pool-main-div']//button[@title='Create Question']");
	By itemSingleChoice = By.xpath("(//div[@id='question-pool-main-div']//a)[1]");
	By itemMultipleChoice = By.xpath("(//div[@id='question-pool-main-div']//a)[2]");
	By itemScenario = By.xpath("(//div[@id='question-pool-main-div']//a)[3]");
	By itemTrueFalse = By.xpath("(//div[@id='question-pool-main-div']//a)[4]");
	
	public boolean isBtnCreateQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateQuestion()
	{
		waitFluentWait(btnCreateQuestion);
		click(btnCreateQuestion);
	}
	
	public void clickItemSingleChoice()
	{
		waitFluentWait(itemSingleChoice);
		click(itemSingleChoice);
	}
	
	public void clickItemMultipleChoice()
	{
		waitFluentWait(itemMultipleChoice);
		click(itemMultipleChoice);
	}
	
	public void clickItemScenario()
	{
		waitFluentWait(itemScenario);
		click(itemScenario);
	}
	
	public void clickItemTrueFalse()
	{
		waitFluentWait(itemTrueFalse);
		click(itemTrueFalse);
	}
	
	By btnDeleteAll = By.xpath("//div[@id='question-pool-main-div']//button[@title='Delete']");
	By btnRejectAll = By.xpath("//div[@class='section-controls']//button[@title='Reject']");
	By btnMoveQuestionAll = By.xpath("//div[@id='question-pool-main-div']//button[@title='Move Question Pool']");
	
	public boolean isBtnRejectAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnRejectAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnDeleteAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnMoveQuestionAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnMoveQuestionAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDeleteAll()
	{
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
	}
	
	public void clickBtnRejectAll()
	{
		waitFluentWait(btnRejectAll);
		click(btnRejectAll);
	}
	
	public void clickBtnMoveQuestionAll()
	{
		waitFluentWait(btnMoveQuestionAll);
		click(btnMoveQuestionAll);
	}
	
	By linkFirstQuestion = By.xpath("(//div[@id='question-pool-grid']//td//a)[1]");
	By linkFirstQuestionNoClickable = By.xpath("(//div[@id='question-pool-grid']//td//span)[1]");
	
	public boolean isLinkFirstQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstQuestion()
	{
		waitFluentWait(linkFirstQuestion);
		click(linkFirstQuestion);
		sleep(1);
	}
	
	public boolean isLinkFirstQuestionClickable(){
		boolean flag = false;
		try {
			if (isWebElementClickable(linkFirstQuestion)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By iconDeleteFirstItem = By.xpath("(//div[@id='question-pool-grid']//span[@class='icon icon-bin'])[1]");
	By iconRejectFirstItem = By.xpath("(//div[@id='question-pool-grid']//span[@class='icon icon-blocked'])[1]");
	By iconMoveQuestionFirstItem = By.xpath("(//div[@id='question-pool-grid']//span[@class='icon icon-toggle'])[1]");
	By iconEditFirstItem = By.xpath("(//div[@id='question-pool-grid']//span[@class='icon icon-pencil7'])[1]");
	
	public boolean isIconDeleteFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconRejectFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconRejectFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconMoveQuestionFirstItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconMoveQuestionFirstItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconEditFirstItem()
	{
		moveHoverElement(driver.findElement(linkFirstQuestion));
		waitFluentWait(iconEditFirstItem);
		click(iconEditFirstItem);
	}
	
	public void clickIconDeleteFirstItem()
	{
		moveHoverElement(driver.findElement(linkFirstQuestion));
		waitFluentWait(iconDeleteFirstItem);
		click(iconDeleteFirstItem);
	}
	
	public void clickIconDeleteFirstItemNoClickable()
	{
		moveHoverElement(driver.findElement(linkFirstQuestionNoClickable));
		waitFluentWait(iconDeleteFirstItem);
		click(iconDeleteFirstItem);
	}
	
	public void clickIconRejectFirstItem()
	{
		moveHoverElement(driver.findElement(linkFirstQuestion));
		waitFluentWait(iconRejectFirstItem);
		click(iconRejectFirstItem);
	}
	
	public void clickIconRejectFirstItemNoClickable()
	{
		moveHoverElement(driver.findElement(linkFirstQuestionNoClickable));
		waitFluentWait(iconRejectFirstItem);
		click(iconRejectFirstItem);
	}
	
	public void clickIconMoveQuestionFirstItem()
	{
		moveHoverElement(driver.findElement(linkFirstQuestion));
		waitFluentWait(iconMoveQuestionFirstItem);
		click(iconMoveQuestionFirstItem);
	}
	
	public void clickIconMoveQuestionFirstItemNoClickable()
	{
		moveHoverElement(driver.findElement(linkFirstQuestionNoClickable));
		waitFluentWait(iconMoveQuestionFirstItem);
		click(iconMoveQuestionFirstItem);
	}
	
	By cboxAll = By.xpath("//div[@id='question-pool-grid']//th//label");
	By cboxSingle = By.xpath("(//div[@id='question-pool-grid']//td//label)[1]");
	
	public boolean isCboxSingleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(cboxSingle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public void clickCboxSingle()
	{
		waitFluentWait(cboxSingle);
		click(cboxSingle);
	}
	
	//Popup Confirm Delete
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");

	By btnYesAll = By.xpath("(//button[contains(.,'YES')])[1]");
	By btnYesSignle = By.xpath("(//button[contains(.,'YES')])[2]");
	By btnYesCategory = By.xpath("(//button[contains(.,'YES')])[1]");

	By btnNo = By.xpath("//button[contains(.,'NO')]");
	
	public boolean isLblConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblConfirmation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnYesAll()
	{
		waitFluentWait(btnYesAll);
		click(btnYesAll);
	}
	
	public void clickBtnYesSignle()
	{
		waitFluentWait(btnYesSignle);
		click(btnYesSignle);
	}
	
	public void clickBtnYesCategory()
	{
		waitFluentWait(btnYesCategory);
		click(btnYesCategory);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}

	public void deleteAll()
	{
		clickBtnDeleteAll();
		clickBtnYesAll();
	}
	
	public void deleteSignle()
	{
		clickIconDeleteFirstItem();
		clickBtnYesSignle();	}
		
	//Reject confirmation
	By lblRejectConfirmation = By.xpath("//h5[contains(.,'Reject confirmation')]");
	By txtRejectReason = By.id("txtMassRejectReason");
	By btnSaveReason = By.id("btnMassRejectSave");
	
	public boolean isLblRejectConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblRejectConfirmation).size() > 0) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
		return flag;
	}
	
	public void fillRejectReason(String rejectreason)
	{
		waitFluentWait(txtRejectReason);
		ClickElementAndType(txtRejectReason, rejectreason);
	}
	
	public void clickBtnSaveReason()
	{
		waitFluentWait(btnSaveReason);
		click(btnSaveReason);
	}
	
	public void rejectConfirmation(String rejectreason)
	{
		fillRejectReason(rejectreason);
		clickBtnSaveReason();
	}
	
	//Move Question
	By lblMoveQuestion = By.xpath("//h4[contains(.,'Move question')]");
	By drplistNewPool = By.xpath("//*[@id='move-question-slider']/section/div[2]/div[2]/label");
	By itemFirst = By.xpath("//*[@id='move-pool-multiselect_listbox']/li[1]");
	By btnSaveMove = By.xpath("//button[contains(@data-bind,'events: {click: gridVM.moveQuestionPools}, disabled: gridVM.disableSaveButton')]");
	
	public boolean isLblMoveQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMoveQuestion).size() > 0) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
		return flag;
	}
	
	public void clickDrplistNewPool()
	{
		waitFluentWait(drplistNewPool);
		ClickElement(drplistNewPool);
		sleep(1);
	}
	
	public void clickItemFirst()
	{
		waitFluentWait(itemFirst);
		click(itemFirst);
		sleep(1);
	}
	
	public void clickBtnSaveMove()
	{
		waitFluentWait(btnSaveMove);
		click(btnSaveMove);
	}
	
	public void moveQuestion()
	{
		clickDrplistNewPool();
		clickItemFirst();
		clickBtnSaveMove();
	}
	
	By firstQuestionContribution = By.xpath("//div[@id='contribution-question-grid']//td/a[@data-target-box='#question-pool-detail-box']");
	public boolean checkQuestionExistedContribution(String questionText){
		boolean flag = false;
		waitFluentWait(txtSearchQuestion);
		fillSearchQuestion(questionText);
		waitFluentWait(firstQuestionContribution);
		try {
			if (driver.findElement(firstQuestionContribution).getText().equals(questionText)) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
		return flag;
	}
	
	public boolean checkQuestionExistedQuestionPool(String questionText){
		boolean flag = false;
		waitFluentWait(txtSearchQuestion);
		fillSearchQuestion(questionText);
		waitFluentWait(linkFirstQuestion);
		try {
			if (driver.findElement(linkFirstQuestion).getText().equals(questionText)) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
		return flag;
	}
}
