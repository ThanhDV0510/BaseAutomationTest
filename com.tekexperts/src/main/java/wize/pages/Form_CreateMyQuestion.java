package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateMyQuestion extends WebActions {

	public Form_CreateMyQuestion(WebDriver driver) {
		super(driver);
     }

	By lblCreateQuestion = By.xpath("//div[@id='create-question']//h4");
	By tabQuestionContent = By.xpath("(//div[@id='create-question']//span)[2]");
		
	public boolean isLblCreateQuestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateQuestion).size() > 0) {
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
		click(tabQuestionContent);
	}
	
	//Question Content
	By btnQuestionInformation = By.id("btnCollapseCreateQuestionInfo");
	
	public void clickBtnQuestionInformation()
	{
		waitFluentWait(btnQuestionInformation);
		click(btnQuestionInformation);
	}
	
	By drplistType = By.xpath("(//form[@id='frmCreateQuestion']//span[2]//span)[1]");
	By itemSingleChoice = By.xpath("(//ul[@id='ddlCreateQuestionType_listbox']//li)[1]");
	By itemMultipleChoice = By.xpath("(//ul[@id='ddlCreateQuestionType_listbox']//li)[2]");
	By itemTrueFalse = By.xpath("(//ul[@id='ddlCreateQuestionType_listbox']//li)[3]");
	By itemScenario = By.xpath("(//ul[@id='ddlCreateQuestionType_listbox']//li)[4]");
	
	public void clickDrplistType()
	{
		waitFluentWait(drplistType);
		click(drplistType);
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
	
	public void clickItemTrueFalse()
	{
		waitFluentWait(itemTrueFalse);
		click(itemTrueFalse);
	}
	
	public void clickItemScenario()
	{
		waitFluentWait(itemScenario);
		click(itemScenario);
	}
	
	By drplistCategory = By.xpath("(//form[@id='frmCreateQuestion']//span[2]//span)[2]");
	By itemTestingAutomation = By.xpath("//li[contains(.,'Testing Automation')]");
	
	public void clickDrplistCategory()
	{
		waitFluentWait(drplistCategory);
		click(drplistCategory);
	}
	
	public void clickItemTestingAutomation()
	{
		waitFluentWait(itemTestingAutomation);
		click(itemTestingAutomation);
	}
	
	By drplistCompletionTime = By.xpath("(//form[@id='frmCreateQuestion']//span[2]//span)[3]");
	By itemMyContribution = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox'])/li[1]");
			
	public void clickDrplistCompletionTime()
	{
		sleep(3);
		waitFluentWait(drplistCompletionTime);
		click(drplistCompletionTime);
	}
		
	public void clickItemMyContribution()
	{
		waitFluentWait(itemMyContribution);
		click(itemMyContribution);
	}
	
	public void selectComletionTime()
	{
		clickDrplistCompletionTime();
		clickItemMyContribution();
	}
		
	By txtCreater = By.id("txtCreateQuestionAuthor");
	By btnAssignToMe= By.id("btnCreateAssignToMe");
	By btnAssignToMe2= By.id("btnCreateAssignToMe");
	
	public void clickBtnAssignToMe()
	{
		waitFluentWait(btnAssignToMe);
		click(btnAssignToMe);
	}
	
	public void clickBtnAssignToMe2()
	{
		waitFluentWait(btnAssignToMe2);
		click(btnAssignToMe2);
	}
		
	By drplistProduct = By.xpath("(//form[@id='frmCreateQuestion']//span[2]//span)[5]");
	By itemProduct1 = By.xpath("//ul[@id='ddlCreateQuestionProduct_listbox']/li[1]");
	By itemProduct2 = By.xpath("//ul[@id='ddlCreateQuestionProduct_listbox']/li[2]");
	By itemProduct3 = By.xpath("//ul[@id='ddlCreateQuestionProduct_listbox']/li[3]");
	By itemProduct4 = By.xpath("//ul[@id='ddlCreateQuestionProduct_listbox']/li[4]");
	
	public void clickDrplistProduct()
	{
		waitFluentWait(drplistProduct);
		click(drplistProduct);
	}
	
	public void clickItemProduct1()
	{
		waitFluentWait(itemProduct1);
		click(itemProduct1);
	}
	
	public void clickItemProduct2()
	{
		waitFluentWait(itemProduct2);
		click(itemProduct2);
	}
	
	public void clickItemProduct3()
	{
		waitFluentWait(itemProduct3);
		click(itemProduct3);
	}
	
	public void clickItemProduc4()
	{
		waitFluentWait(itemProduct4);
		click(itemProduct4);
	}	
	
	By txtCase = By.id("txtCreateQuestionCase");
	
	public void fillCase(String txtcase)
	{
		waitFluentWait(txtCase);
		ClickElementAndType(txtCase, txtcase);
	}
	
	By txtQuestionText = By.xpath("//form[@id='frmCreateQuestion']//iframe");
	
	
	public void fillQuestionText(String questiontext)
	{
		waitFluentWait(txtQuestionText);
		ClickElementAndType(txtQuestionText, questiontext);
		sleep(3);
	}
			
	By btnAnswerInformation = By.id("btnCollapseCreateAnswerInfo");
    By btnAddAnswer = By.xpath("//div[@id='collapseCreateAnswerInfo']/div[1]/div[2]//button");
   
    By iconSave1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[1]//button)[3]");
    By iconSave2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[2]//button)[3]");
    By iconSave3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[3]//button)[3]");
    By iconSave4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[4]//button)[3]");
   
    By iconCancel1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[1]//button)[4]");
    By iconCancel2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[2]//button)[4]");
    By iconCancel3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[3]//button)[4]");
    By iconCancel4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[4]//button)[4]");
   
    By iconEdit1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[1]");
    By iconEdit2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[2]");
    By iconEdit3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[3]");
    By iconEdit4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[4]");
   
    By iconDelete1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[1]//button)[2]");
    By iconDelete2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[2]//button)[2]");
    By iconDelete3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[3]//button)[2]");
    By iconDelete4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[4]//button)[2]");
   
    By btnRadio1 = By.xpath("(//ul[@id='listQuestion']//input)[1]");
    By btnRadio2 = By.xpath("(//ul[@id='listQuestion']//input)[3]");
    By btnRadio3 = By.xpath("(//ul[@id='listQuestion']//input)[5]");
    By btnRadio4 = By.xpath("(//ul[@id='listQuestion']//input)[7]");
    By btnRadio5 = By.xpath("(//ul[@id='listQuestion']//input)[9]");
    By btnRadio6 = By.xpath("(//ul[@id='listQuestion']//input)[11]");
    By btnRadio7 = By.xpath("(//ul[@id='listQuestion']//input)[13]");
    By btnRadio8 = By.xpath("(//ul[@id='listQuestion']//input)[15]");
    
    
    By btnRadioAnswerStage1 = By.xpath("(//ul[@data-template='question-template-scenario']//input[1])[1]");
    By iconSaveStage1 = By.xpath("(//div[@id='listStageScenario']//button[@title='Save'])[1]");
    By iconSaveAnswerStage1 = By.xpath("(//div[@id='listStageScenario']//button[@title='Save'])[2]");
    By btnRadioAnswerStage2 = By.xpath("(//ul[@data-template='question-template-scenario']//input[1])[3]");
    By iconSaveStage2 = By.xpath("(//div[@id='listStageScenario']//button[@title='Save'])[3]");
    By iconSaveAnswerStage2 = By.xpath("(//div[@id='listStageScenario']//button[@title='Save'])[4]");
    
    public void clickBtnRadioAnswerStage1(){
    	waitFluentWait(btnRadioAnswerStage1);
    	click(btnRadioAnswerStage1);
    }
    
    public void clickBtnSaveStage1(){
    	waitFluentWait(iconSaveStage1);
    	click(iconSaveStage1);
    }
    
    public void clickBtnSaveAnswerStage1(){
    	waitFluentWait(iconSaveAnswerStage1);
    	click(iconSaveAnswerStage1);
    }
    
    public void clickBtnRadioAnswerStage2(){
    	waitFluentWait(btnRadioAnswerStage2);
    	click(btnRadioAnswerStage2);
    }
    
    public void clickBtnSaveStage2(){
    	waitFluentWait(iconSaveStage2);
    	click(iconSaveStage2);
    }
    
    public void clickBtnSaveAnswerStage2(){
    	waitFluentWait(iconSaveAnswerStage2);
    	click(iconSaveAnswerStage2);
    }
    
    By txtInputAnswerSingleChoice = By.xpath("(//ul[@data-template='question-template']//input)[2]");
    By txtInputAnswer = By.xpath("(//ul[@data-template='question-template-scenario']//input)[2]");
    By txtInputAnswer2 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[4]");
   
    By txtStage = By.xpath("(//div[@id='listStageScenario']//div[2]//input)[1]");
    By txtStage2 = By.xpath("(//div[@id='listStageScenario']/div[2]/div[2]//input)[1]");
    By iconX = By.xpath("(//div[@id='detail-question']//i)[5]");
    By btnAddStage = By.xpath("//div[@id='collapseCreateAnswerInfo']/div/div[3]//button");
	
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
		click(btnAnswerInformation);
	}
	
	public void clickBtnAddAnswer()
	{
		waitFluentWait(btnAddAnswer);
		click(btnAddAnswer);
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
	
	public void clickIconiconCancel1()
	{
		waitFluentWait(iconCancel1);
		click(iconCancel1);
	}
	
	public void clickIconiconCancel2()
	{
		waitFluentWait(iconCancel2);
		click(iconCancel2);
	}
	
	public void clickIconiconCancel3()
	{
		waitFluentWait(iconCancel3);
		click(iconCancel3);
	}
	
	public void clickIconiconCancel4()
	{
		waitFluentWait(iconCancel4);
		click(iconCancel4);
	}
	
	public void clickIconEdit1()
	{
		waitFluentWait(iconEdit1);
		click(iconEdit1);
	}
	
	public void clickIconDelete1()
	{
		waitFluentWait(iconDelete1);
		click(iconDelete1);
	}
	
	public void clickIconEdit2()
	{
		waitFluentWait(iconEdit2);
		click(iconEdit2);
	}
	
	public void clickIconDelete2()
	{
		waitFluentWait(iconDelete2);
		click(iconDelete2);
	}
	
	public void clickIconEdit3()
	{
		waitFluentWait(iconEdit3);
		click(iconEdit3);
	}
	
	public void clickIconDelete3()
	{
		waitFluentWait(iconDelete3);
		click(iconDelete3);
	}
	
	public void clickIconEdit4()
	{
		waitFluentWait(iconEdit4);
		click(iconEdit4);
	}
	
	public void clickIconDelete4()
	{
		waitFluentWait(iconDelete4);
		click(iconDelete4);
	}
	
	public void clickBtnRadio1()
	{
		waitFluentWait(btnRadio1);
		click(btnRadio1);
	}
	
	public void clickBtnRadio2()
	{
		waitFluentWait(btnRadio2);
		click(btnRadio2);
	}
	
	public void clickBtnRadio3()
	{
		waitFluentWait(btnRadio3);
		click(btnRadio3);
	}
	
	public void clickBtnRadio4()
	{
		waitFluentWait(btnRadio4);
		click(btnRadio4);
	}
	
	public void clickBtnRadio5()
	{
		waitFluentWait(btnRadio5);
		click(btnRadio5);
	}
	
	public void clickBtnRadio6()
	{
		waitFluentWait(btnRadio6);
		click(btnRadio6);
	}
	
	public void clickBtnRadio7()
	{
		waitFluentWait(btnRadio7);
		click(btnRadio7);
	}
	
	public void clickBtnRadio8()
	{
		waitFluentWait(btnRadio8);
		click(btnRadio8);
	}
	

	public void clickCboxAnswer1()
	{
		waitFluentWait(btnRadio1);
		click(btnRadio1);
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
	
	public void fillInputAnswerSingleChoice(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice);
		ClickElementAndType(txtInputAnswerSingleChoice, inputanswer);
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
		click(btnAddStage);
	}
	
	By btnCancel = By.id("btnCancelCreateQuestion");
	By btnPreview = By.id("btnPreviewCreateQuestion");
	By btnSavenCreateNew = By.id("btnSaveAndCreateQuestion");
	By btnSave = By.id("btnSaveCreateQuestion");
	
	By buttonSave = By.xpath("//button[@id='btnSaveCreateQuestion']");
	
	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
	}
	
	public void clickButtonSave()
	{
		waitFluentWait(buttonSave);
		click(buttonSave);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnPreview()
	{
		waitFluentWait(btnPreview);
		click(btnPreview);
	}
		
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	
	//Question Pool
	By txtSkillMyContribution = By.xpath("//div[@role='listbox']");
	By txtSkill = By.xpath("//div[@class='k-widget k-multiselect skill-multiselect form-control dllCreateSkillCompetency k-multiselect-clearable']");
	By txtSkill2 = By.xpath("(//div[@class='k-widget k-multiselect skill-multiselect form-control dllCreateSkillCompetency k-multiselect-clearable'])[2]");
	By txtSkillStage1 = By.xpath("(//div[contains(@role,'listbox')])[4]");
	By txtSkillStage2 = By.xpath("(//div[contains(@role,'listbox')])[5]");
	By btnRadioSkillL1 = By.xpath("(//input[@name='radio96'][@value='1'])");
	
	//By btnRadioSkillL1 = By.xpath("//input[@value='1']");
	By btnRadioSkillL2 = By.xpath("(//input[@name='radio96'][@value='2'])");
	By btnRadioSkillL3 = By.xpath("(//input[@name='radio163'][@value='3'])");
	By lblTestAutomationSingleChoice = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//span[@class='list-content']");
	By lblTestAutomation1 = By.xpath("(//span[contains(@class,'list-content')])[1]");
	By lblTestAutomation2 = By.xpath("(//span[contains(@class,'list-content')])[2]");
	By lblDomainKnowleadge = By.xpath("(//button[@class='btn btn-md collapsed'])");
	By iconRemoveSkill = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[1]/following::span[5]");
	By iconRemoveSkillStage = By.xpath("(//span[@aria-label='delete']/span)[2]");
	By iconRemoveSkillMyStage = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Test Automation 1#1'])[1]/following::span[2]");
	By tagTestAutomation = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[1]/following::span[1]");
	By lblTrue = By.xpath("//span[@class='custom-control-label'][contains(.,'True')]");
	
	public void clickIconRemoveSkill()
	{
		waitFluentWait(iconRemoveSkill);
		ClickElement(iconRemoveSkill);
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
	
	public void selectSkillSingleChoiceWithoutLinkedBehavior(String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomationSingleChoice));
		sleep(3);
		ClickElement(btnRadioSkillL3);
	}
	
	public void selectSkillSingleChoice(String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomationSingleChoice));
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
	
	public void selectSkillStage1WithoutLinkedBehavior(String skillcompetency)
	{
		waitFluentWait(txtSkillStage1);
		ClickElementAndType(txtSkillStage1, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation1));
		sleep(3);
		ClickElement(btnRadioSkillL3);
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
	By lblTestAuto1 = By.xpath("(//span[@class='list-content'][contains(.,'Test Automation 1')])[2]");
	By lblTestAuto2 = By.xpath("(//span[@class='list-content'][contains(.,'Test Automation 2')])[2]");
	By btnRadioSkillMy = By.xpath("/html/body/div[27]/div/div[2]/ul/li/div/div/label[1]/span");
	By btnRadioSkillMyStage1 = By.xpath("(//input[@name='radio12'])[7]");
	By btnRadioSkillMyStage2 = By.xpath("(//input[@name='radio12'])[13]");
	
	public void selectSkillMy1 (String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto1));
		sleep(3);
		ClickElement(btnRadioSkillMy);
	}
	
	public void selectSkillMy2 (String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto2));
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
		ClickElement(btnRadioSkillMy);
	}
	
	public void selectSkillMyStage2 (String skillcompetency)
	{
		scrollToBottomPage();
		waitFluentWait(txtSkill2);
		ClickElementAndType(txtSkill2, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAuto2));
		sleep(3);
		ClickElement(btnRadioSkillMy);
	}
	
	public void scrollDownScreen(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
