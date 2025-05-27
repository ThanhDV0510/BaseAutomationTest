package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditQuestion extends WebActions {

	public Form_EditQuestion(WebDriver driver) {
		super(driver);
     }

	By lblEditQuestion = By.xpath("//div[@id='update-question']//h4");
	By tabQuestionContent = By.xpath("(//div[@id='update-question-tabstrip']//span)[2]");
		
	public boolean isLblEditQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabQuestionContent()
	{
		waitFluentWait(tabQuestionContent);
		clickByJavaScript(tabQuestionContent);
	}
	
	//Question Content
	By btnQuestionInformation = By.xpath("(//div[@id='update-question-tabstrip-1']//button)[1]");
	
	public void clickBtnQuestionInformation()
	{
		waitFluentWait(btnQuestionInformation);
		clickByJavaScript(btnQuestionInformation);
	}
	
	By drplistType = By.xpath("(//span[@unselectable='on'])[47]");
	By itemSingleChoice = By.xpath("(//li[contains(.,'Single choice')])[2]");
	By itemMultipleChoice = By.xpath("(//li[contains(.,'Multiple choice')])[2]");
	By itemTrueFalse = By.xpath("(//li[contains(.,'True/False')])[2]");
	By itemScenario = By.xpath("(//li[contains(.,'Scenario')])[2]");
	
	public void clickDrplistType()
	{
		waitFluentWait(drplistType);
		clickByJavaScript(drplistType);
	}
	
	public void clickItemSingleChoice()
	{
		waitFluentWait(itemSingleChoice);
		clickByJavaScript(itemSingleChoice);
	}
	
	public void clickItemMultipleChoice()
	{
		waitFluentWait(itemMultipleChoice);
		clickByJavaScript(itemMultipleChoice);
	}
	
	public void clickItemTrueFalse()
	{
		waitFluentWait(itemTrueFalse);
		clickByJavaScript(itemTrueFalse);
	}
	
	public void clickItemScenario()
	{
		waitFluentWait(itemScenario);
		clickByJavaScript(itemScenario);
	}
	
	By drplistCategory = By.xpath("//span[@aria-owns='ddlCreateCategory_listbox']");
	By itemTestAutomation = By.xpath("(//li[contains(.,'Test Automation')])[2]");
	
	public void clickDrplistCategory()
	{
		waitFluentWait(drplistCategory);
		clickByJavaScript(drplistCategory);
	}
	
	public void clickItemTestAutomation()
	{
		waitFluentWait(itemTestAutomation);
		clickByJavaScript(itemTestAutomation);
	}
	
	//By drplistCompletionTime = By.xpath("(//span[@unselectable='on'])[55]");
	By drplistCompletionTime = By.xpath("//span[@aria-owns='ddlCreateCompletionTime_listbox']");
	By item1 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[15]/following::li[1]");
	By itemMyContribution = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[38]/following::li[1]");
			
	public void clickDrplistCompletionTime()
	{
		waitFluentWait(drplistCompletionTime);
		clickByJavaScript(drplistCompletionTime);
	}
	
	public void clickItem1()
	{
		waitFluentWait(item1);
		click(item1);
	}
	
	public void clickItemMyContribution()
	{
		waitFluentWait(itemMyContribution);
		clickByJavaScript(itemMyContribution);
	}
		
	By txtAuthor = By.xpath("//input[@name='author']");
	By btnAssignToMe= By.xpath("//i[@class='icon icon-user-check']");
	By btnAssignToMe2= By.xpath("(//i[@class='icon icon-user-check'])[2]");
	
	public void clickBtnAssignToMe()
	{
		waitFluentWait(btnAssignToMe);
		clickByJavaScript(btnAssignToMe);
	}
	
	public void clickBtnAssignToMe2()
	{
		waitFluentWait(btnAssignToMe2);
		clickByJavaScript(btnAssignToMe2);
	}
	
	
	By drplistPool = By.xpath("(//div[@role='listbox'])[2]");
	By itemTraining = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[16]/following::li[1]");
	By itemKnowledgeCheck = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[16]/following::li[2]");
	By itemCompetency = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[16]/following::li[3]");
	By itemCompliance = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No data found.'])[16]/following::li[4]");
	By iconRemovePool = By.xpath("//span[@aria-label='delete']");
	
	public boolean isIconRemovePoolDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconRemovePool).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickDrplistPool()
	{
		waitFluentWait(drplistPool);
		clickByJavaScript(drplistPool);
	}
	
	public void clickItemTraining()
	{
		waitFluentWait(itemTraining);
		clickByJavaScript(itemTraining);
	}
	
	public void clickItemKnowledgeCheck()
	{
		waitFluentWait(itemKnowledgeCheck);
		clickByJavaScript(itemKnowledgeCheck);
	}
	
	public void clickItemCompetency()
	{
		waitFluentWait(itemCompetency);
		clickByJavaScript(itemCompetency);
	}
	
	public void clickItemCompliance()
	{
		waitFluentWait(itemCompliance);
		clickByJavaScript(itemCompliance);
	}
	
	By drplistProduct = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product'])[1]/following::span[3]");
	By itemShoes = By.xpath("//*[@id='ddlCreateQuestionProduct_listbox']/li[1]");
	By itemPerfurme = By.xpath("//*[@id='ddlCreateQuestionProduct_listbox']/li[2]");
	By itemProduct11 = By.xpath("//*[@id='ddlCreateQuestionProduct_listbox']/li[3]");
	By itemProduct21 = By.xpath("//*[@id='ddlCreateQuestionProduct_listbox']/li[4]");
	
	public void clickDrplistProduct()
	{
		waitFluentWait(drplistProduct);
		clickByJavaScript(drplistProduct);
	}
	
	public void clickItemShoes()
	{
		waitFluentWait(itemShoes);
		clickByJavaScript(itemShoes);
	}
	
	public void clickItemPerfurme()
	{
		waitFluentWait(itemPerfurme);
		clickByJavaScript(itemPerfurme);
	}
	
	public void clickItemProduct11()
	{
		waitFluentWait(itemProduct11);
		clickByJavaScript(itemProduct11);
	}
	
	public void clickItemProduct21()
	{
		waitFluentWait(itemProduct21);
		clickByJavaScript(itemProduct21);
	}	
	
	By txtCase = By.xpath("//input[@id='txtCreateQuestionCase']");
	
	public void fillCase(String txtcase)
	{
		waitFluentWait(txtCase);
		ClickElementAndType(txtCase, txtcase);
	}
	
	By txtQuestionText = By.xpath("//*[@id=\"collapseCreateQuestionBody\"]/div//iframe");
	
	By txtQ = By.id("txtCreateQuestionText");
	
	public void fillQuestionText(String questiontext)
	{
		waitFluentWait(txtQuestionText);
		ClickElementAndType(txtQuestionText, questiontext);
		sleep(3);
	}
			
	By btnAnswerInformation = By.xpath("//button[@id='btnCollapseCreateAnswerInfo']");
	By btnAddAnswer = By.xpath("//button[contains(.,'Add answer')]");
	By iconSave1 = By.xpath("(//i[@class='icon icon-floppy-disk'])[1]");
	By iconSave2 = By.xpath("(//i[@class='icon icon-floppy-disk'])[2]");
	By iconSave3 = By.xpath("(//i[@class='icon icon-floppy-disk'])[3]");
	By iconSave4 = By.xpath("(//i[@class='icon icon-floppy-disk'])[4]");
	By iconX = By.xpath("(//ul[@id='listQuestion']/li/div[2]/div[2]/button/i)[2]");
	By iconEdit1 = By.xpath("(//button[@title='Edit'])[1]");
	By iconDelete1 = By.xpath("(//button[@title='Delete'])[2]");
	By iconEdit2 = By.xpath("(//button[@title='Edit'])[2]");
	By iconDelete2 = By.xpath("(//button[@title='Delete'])[3]");
	By iconEdit3 = By.xpath("(//button[@title='Edit'])[3]");
	By iconDelete3 = By.xpath("(//button[@title='Delete'])[4]");
	By iconEdit4 = By.xpath("(//button[@title='Edit'])[4]");
	By iconDelete4 = By.xpath("(//button[@title='Delete'])[5]");
	By btnRadio1 = By.xpath("(//input[@type='radio'])[1]");
	By btnRadio2 = By.xpath("(//input[@type='radio'])[2]");
	By btnRadio3 = By.xpath("(//input[@type='radio'])[3]");
	By btnRadio4 = By.xpath("(//input[@type='radio'])[4]");
	By btnRadio5 = By.xpath("(//input[@type='radio'])[5]");
	By btnRadio6 = By.xpath("(//input[@type='radio'])[6]");
	By btnRadio7 = By.xpath("(//input[@type='radio'])[7]");
	By btnRadio8 = By.xpath("(//input[@type='radio'])[8]");
	By cboxAnswer1 = By.xpath("(//input[@title='Mark as correct answer'])[1]");
	By txtInputAnswer = By.xpath("//input[@placeholder='Input Answer...']");
	By txtInputAnswer2 = By.xpath("(//input[@placeholder='Input Answer...'])[2]");
	By txtStage = By.xpath("//input[@placeholder='Stage']");
	By txtStage2 = By.xpath("(//input[@placeholder='Stage'])[2]");
	By btnAddStage = By.xpath("//button[@data-bind='events:{click: addNewStage}']");
	
	public boolean isIconEdit1Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit1).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEdit2Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit2).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEdit3Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit3).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEdit4Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit4).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAnswerInformation()
	{
		waitFluentWait(btnAnswerInformation);
		clickByJavaScript(btnAnswerInformation);
	}
	
	public void clickBtnAddAnswer()
	{
		waitFluentWait(btnAddAnswer);
		clickByJavaScript(btnAddAnswer);
	}
	
	public void clickIconSave1()
	{
		waitFluentWait(iconSave1);
		click(iconSave1);
	}
	
	public void clickIconSave2()
	{
		waitFluentWait(iconSave2);
		click(iconSave2);
	}
	
	public void clickIconSave3()
	{
		waitFluentWait(iconSave3);
		click(iconSave3);
	}
	
	public void clickIconSave4()
	{
		waitFluentWait(iconSave4);
		click(iconSave4);
	}
	
	public void clickIconX()
	{
		waitFluentWait(iconX);
		clickByJavaScript(iconX);
	}
	
	public void clickIconEdit1()
	{
		waitFluentWait(iconEdit1);
		clickByJavaScript(iconEdit1);
	}
	
	public void clickIconDelete1()
	{
		waitFluentWait(iconDelete1);
		clickByJavaScript(iconDelete1);
	}
	
	public void clickIconEdit2()
	{
		waitFluentWait(iconEdit2);
		clickByJavaScript(iconEdit2);
	}
	
	public void clickIconDelete2()
	{
		waitFluentWait(iconDelete2);
		clickByJavaScript(iconDelete2);
	}
	
	public void clickIconEdit3()
	{
		waitFluentWait(iconEdit3);
		clickByJavaScript(iconEdit3);
	}
	
	public void clickIconDelete3()
	{
		waitFluentWait(iconDelete3);
		clickByJavaScript(iconDelete3);
	}
	
	public void clickIconEdit4()
	{
		waitFluentWait(iconEdit4);
		clickByJavaScript(iconEdit4);
	}
	
	public void clickIconDelete4()
	{
		waitFluentWait(iconDelete4);
		clickByJavaScript(iconDelete4);
	}
	
	public void clickBtnRadio1()
	{
		waitFluentWait(btnRadio1);
		clickByJavaScript(btnRadio1);
	}
	
	public void clickBtnRadio2()
	{
		waitFluentWait(btnRadio2);
		clickByJavaScript(btnRadio2);
	}
	
	public void clickBtnRadio3()
	{
		waitFluentWait(btnRadio3);
		clickByJavaScript(btnRadio3);
	}
	
	public void clickBtnRadio4()
	{
		waitFluentWait(btnRadio4);
		clickByJavaScript(btnRadio4);
	}
	
	public void clickBtnRadio5()
	{
		waitFluentWait(btnRadio5);
		clickByJavaScript(btnRadio5);
	}
	
	public void clickBtnRadio6()
	{
		waitFluentWait(btnRadio6);
		clickByJavaScript(btnRadio6);
	}
	
	public void clickBtnRadio7()
	{
		waitFluentWait(btnRadio7);
		clickByJavaScript(btnRadio7);
	}
	
	public void clickBtnRadio8()
	{
		waitFluentWait(btnRadio8);
		clickByJavaScript(btnRadio8);
	}
	
	public void clickCboxAnswer1()
	{
		waitFluentWait(cboxAnswer1);
		clickByJavaScript(cboxAnswer1);
	}
	
	public void fillInputAnswer(String inputanswer)
	{
		waitFluentWait(txtInputAnswer);
		ClickElementAndType(txtInputAnswer, inputanswer);
	}
	
	public void fillInputAnswer2(String inputanswer)
	{
		waitFluentWait(txtInputAnswer2);
		ClickElementAndType(txtInputAnswer2, inputanswer);
	}
	
	public void fillStage(String stage)
	{
		waitFluentWait(txtStage);
		goTextOnNoEnter(txtStage, stage);
	}
	
	public void fillStage2(String stage2)
	{
		waitFluentWait(txtStage2);
		goTextOnNoEnter(txtStage2, stage2);
	}
	
	public void clickBtnAddStage()
	{
		waitFluentWait(btnAddStage);
		clickByJavaScript(btnAddStage);
	}
	
	By btnCancel = By.id("btnCancelCreateQuestion");
	By btnPreview = By.id("btnPreviewCreateQuestion");
	By btnSave = By.id("btnSaveCreateQuestion");
	
	By buttonSave = By.xpath("//button[@id='btnSaveCreateQuestion']");
		
	public void clickButtonSave()
	{
		waitFluentWait(buttonSave);
		clickByJavaScript(buttonSave);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnPreview()
	{
		waitFluentWait(btnPreview);
		clickByJavaScript(btnPreview);
	}
		
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	
	//Question Pool
	By txtSkillMyContribution = By.xpath("(//input[@role='listbox'])[2]");
	By txtSkill = By.xpath("(//input[@role='listbox'])[3]");
	By txtSkillStage1 = By.xpath("(//div[contains(@role,'listbox')])[4]");
	By txtSkillStage2 = By.xpath("(//div[contains(@role,'listbox')])[5]");
	By btnRadioSkillL1 = By.xpath("//input[@value='1']");
	By btnRadioSkillL2 = By.xpath("(//input[@value='1'])[2]");
	By btnRadioSkillL3 = By.xpath("(//input[@value='1'])[4]");
	By lblTestAutomation1 = By.xpath("(//span[contains(@class,'list-content')])[1]");
	By lblTestAutomation2 = By.xpath("(//span[contains(@class,'list-content')])[2]");
	By lblDomainKnowleadge = By.xpath("(//button[@class='btn btn-md collapsed'])");
	By iconRemoveSkill = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[1]/following::span[5]");
	By iconRemoveMySkill = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[1]/following::span[4]");
	By iconRemoveSkillStage = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Test Automation 1#1'])[6]/following::span[2]");
	By iconRemoveSkillMyStage = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Test Automation 1#1'])[1]/following::span[2]");
	By tagTestAutomation = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[1]/following::span[1]");
	By lblTrue = By.xpath("//span[@class='custom-control-label'][contains(.,'True')]");
	
	public void clickIconRemoveSkill()
	{
		waitFluentWait(iconRemoveSkill);
		ClickElement(iconRemoveSkill);
	}
	
	public void clickIconRemoveMySkill()
	{
		waitFluentWait(iconRemoveMySkill);
		ClickElement(iconRemoveMySkill);
	}
	
	public void clickIconRemoveSkillStage()
	{
		waitFluentWait(iconRemoveSkillStage);
		ClickElement(iconRemoveSkillStage);
	}
	
	public void clickIconRemoveSkillMyStage()
	{
		waitFluentWait(iconRemoveSkillMyStage);
		ClickElement(iconRemoveSkillMyStage);
	}
	
	public boolean isLblTrueDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTrue).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
		
	}
	
	public boolean isLblDomainKnowleadgeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblDomainKnowleadge).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTagTestAutomationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tagTestAutomation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectSkillMyContribution(String skillcompetency)
	{
		waitFluentWait(txtSkillMyContribution);
		ClickElementAndType(txtSkillMyContribution, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation1));
		sleep(3);
		ClickElement(btnRadioSkillL1);
	}
	
	public void selectSkill(String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation1));
		sleep(3);
		ClickElement(btnRadioSkillL1);
	}
	
	public void selectSkillStage1(String skillcompetency)
	{
		waitFluentWait(txtSkillStage1);
		ClickElementAndType(txtSkillStage1, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation1));
		sleep(3);
		ClickElement(btnRadioSkillL2);
	}
	
	public void selectSkillStage2(String skillcompetency)
	{
		waitFluentWait(txtSkillStage2);
		ClickElementAndType(txtSkillStage2, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation2));
		sleep(3);
		ClickElement(btnRadioSkillL3);
	}
	
	
	//My Contribution
	By lblTestAuto1 = By.xpath("(//span[@class='list-content'])[24]");
	By lblTestAuto2 = By.xpath("(//span[@class='list-content'])[25]");
	By btnRadioSkillMy = By.xpath("(//input[@name='radio13'])[7]");
	By btnRadioSkillMyStage1 = By.xpath("(//input[@name='radio12'])[7]");
	By btnRadioSkillMyStage2 = By.xpath("(//input[@name='radio12'])[13]");
	
	public void selectSkillMy (String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto1));
		sleep(3);
		ClickElement(btnRadioSkillMy);
	}
	
	public void selectSkillMyStage1 (String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto1));
		sleep(3);
		ClickElement(btnRadioSkillMyStage1);
	}
	
	public void selectSkillMyStage2 (String skillcompetency)
	{
		scrollToBottomPage();
		waitFluentWait(txtSkillStage1);
		ClickElementAndType(txtSkillStage1, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto2));
		sleep(3);
		ClickElement(btnRadioSkillMyStage2);
	}
}
