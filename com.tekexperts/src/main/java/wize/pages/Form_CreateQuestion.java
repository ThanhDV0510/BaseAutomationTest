package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateQuestion extends WebActions {

	public Form_CreateQuestion(WebDriver driver) {
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
	
	By drplistType = By.xpath("(//form[@id='frmCreateQuestionPool']//div[2]//span[1])[2]");
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
	
	By drplistCategory = By.xpath("(//form[@id='frmCreateQuestionPool']//div[2]//span[1])[3]");
	By itemTestingAutomation = By.xpath("//div[@id='ddlCreateCategory-list']//li[contains(.,'Testing Automation')]");
	
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
	
	public void selectCategory(String category){
		try {
			clickDrplistCategory();
			By selectedCategory = By.xpath("//div[@id='ddlCreateCategory-list']//li[contains(.,'" + category +  "')]");
			waitFluentWait(selectedCategory);
			click(selectedCategory);
		} catch (Exception e) {
			System.out.println("Please input correct category name");
		}
	}
	
	By drplistCompletionTime = By.xpath("(//form[@id='frmCreateQuestionPool']//div[3]//span[1])[3]");
	By item1 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[1]");
	By item2 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[2]");
	By item3 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[3]");
	By item4 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[4]");
	By item5 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[5]");
	By item6 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[6]");
	By item7 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[7]");
	By item8 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[8]");
	By item9 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[9]");
	By item10 = By.xpath("(//ul[@id='ddlCreateCompletionTime_listbox']//li)[10]");
	
	By itemMyContribution = By.xpath("(//*[@id='ddlCreateCompletionTime_listbox'])/li[1]");
			
	public void clickDrplistCompletionTime()
	{
		sleep(3);
		waitFluentWait(drplistCompletionTime);
		click(drplistCompletionTime);
	}
	
	public void clickItem1()
	{
		waitFluentWait(item1);
		click(item1);
	}
	
	public void selectCompletionTime(int time){
		sleep(1.5);
		switch (time) {
		case 1:
			click(item1);
			break;
		case 2:
			click(item2);
			break;
		case 3:
			click(item3);
			break;
		case 5:
			click(item4);
			break;
		case 8:
			click(item5);
			break;
		case 13:
			click(item6);
			break;
		case 17:
			click(item7);
			break;
		case 21:
			click(item8);
			break;
		case 25:
			click(item9);
			break;
		case 30:
			click(item10);
			break;
		default:
			System.out.println("You need to input the correct number of completion time");
			break;
		}
	}
	
	public void clickItemMyContribution()
	{
		waitFluentWait(itemMyContribution);
		click(itemMyContribution);
	}
		
	By txtAuthor = By.id("txtCreateQuestionAuthor");
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
	
	public void fillAuthor(String author){
		waitFluentWait(txtAuthor);
		ClickElementAndType(txtAuthor, author);
	}
	//By drplistPool = By.xpath("(//div[@role='listbox'])[2]");
	By drplistPool = By.xpath("//form[@id='frmCreateQuestionPool']//div[5]/div/div/div");
	By itemTraining = By.xpath("//*[@id='ddlCreatePools_listbox']/li[1]");
	By itemKnowledgeCheck = By.xpath("//*[@id='ddlCreatePools_listbox']//li[2]");
	By itemCompetency = By.xpath("//*[@id='ddlCreatePools_listbox']/li[3]");
	By itemCompliance = By.xpath("//*[@id='ddlCreatePools_listbox']/li[4]");
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
		click(drplistPool);
	}
	
	public void clickItemTraining()
	{
		waitFluentWait(itemTraining);
		click(itemTraining);
	}
	
	public void clickItemKnowledgeCheck()
	{
		waitFluentWait(itemKnowledgeCheck);
		click(itemKnowledgeCheck);
	}
	
	public void clickItemCompetency()
	{
		waitFluentWait(itemCompetency);
		click(itemCompetency);
	}
	
	public void clickItemCompliance()
	{
		waitFluentWait(itemCompliance);
		click(itemCompliance);
	}
	
	public void selectPool(String pool){
		if(pool.equals("Training")){
			clickItemTraining();
		}else if(pool.equals("Competency")){
			clickItemCompetency();
		}else if(pool.equals("Knowledge check")){
			clickItemKnowledgeCheck();
		}else if(pool.equals("Compliance")){
			clickItemCompliance();
		}
	}
	By txtInstruction = By.xpath("//textarea[@id='txtCreateQuestionInstruction']");
	
	public void fillInstruction(String instruction){
		waitFluentWait(txtInstruction);
		ClickElementAndType(txtInstruction, instruction);
	}
	
	By drplistProduct = By.xpath("//form[@id='frmCreateQuestionPool']//div[6]//span[2]");
	By itemProduct1 = By.xpath("//*[@id='ddlCreateQuestionProduct-list']/li[1]");
	By itemProduct2 = By.xpath("//*[@id='ddlCreateQuestionProduct-list']/li[2]");
	By itemProduct3 = By.xpath("//*[@id='ddlCreateQuestionProduct-list']/li[3]");
	By itemProduct4 = By.xpath("//*[@id='ddlCreateQuestionProduct_listbox']/li[4]");
	
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
	
	public void selectProduct(String product){
		clickDrplistProduct();
		By selectedProduct = By.xpath("//div[@id='ddlCreateQuestionProduct-list']//li[contains(.,'" + product +  "')]");
		waitFluentWait(selectedProduct);
		click(selectedProduct);
	}
	
	By txtCase = By.id("txtCreateQuestionCase");
	
	public void fillCase(String txtcase)
	{
		waitFluentWait(txtCase);
		ClickElementAndType(txtCase, txtcase);
	}
	
	By txtQuestionText = By.xpath("//*[@id='frmCreateQuestionPool']//table/tbody/tr[2]/td/iframe");
	
	
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
    By iconSave5 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[5]//button)[3]");
    By iconSave6 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[6]//button)[3]");
    By iconSave7 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[7]//button)[3]");
    By iconSave8 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[8]//button)[3]");
    By iconSave9 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[9]//button)[3]");
    By iconSave10 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[10]//button)[3]");
    By iconSave11 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[11]//button)[3]");
    By iconSave12 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[12]//button)[3]");
    By iconSave13 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[13]//button)[3]");
    By iconSave14 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[14]//button)[3]");
    By iconSave15 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[15]//button)[3]");
   
    By iconCancel1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[1]//button)[4]");
    By iconCancel2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[2]//button)[4]");
    By iconCancel3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[3]//button)[4]");
    By iconCancel4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//li[4]//button)[4]");
   
    By iconEdit1 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[1]");
    By iconEdit2 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[2]");
    By iconEdit3 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[3]");
    By iconEdit4 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[4]");
    By iconEdit5 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[5]");
    By iconEdit6 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[6]");
    By iconEdit7 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[7]");
    By iconEdit8 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[8]");
    By iconEdit9 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[9]");
    By iconEdit10 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[10]");
    By iconEdit11 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[11]");
    By iconEdit12 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[12]");
    By iconEdit13 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[13]");
    By iconEdit14 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[14]");
    By iconEdit15 = By.xpath("(//div[@id='collapseCreateAnswerInfo']//button[@title='Edit'])[15]");
    
   
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
    By btnRadio9 = By.xpath("(//ul[@id='listQuestion']//input)[17]");
    By btnRadio10 = By.xpath("(//ul[@id='listQuestion']//input)[19]");
    By btnRadio11 = By.xpath("(//ul[@id='listQuestion']//input)[21]");
    By btnRadio12 = By.xpath("(//ul[@id='listQuestion']//input)[23]");
    By btnRadio13 = By.xpath("(//ul[@id='listQuestion']//input)[25]");
    By btnRadio14 = By.xpath("(//ul[@id='listQuestion']//input)[27]");
    By btnRadio15 = By.xpath("(//ul[@id='listQuestion']//input)[29]");
    
    
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
    By txtInputAnswerSingleChoice2 = By.xpath("(//ul[@data-template='question-template']//input)[4]");
    By txtInputAnswerSingleChoice3 = By.xpath("(//ul[@data-template='question-template']//input)[6]");
    By txtInputAnswerSingleChoice4 = By.xpath("(//ul[@data-template='question-template']//input)[8]");
    By txtInputAnswerSingleChoice5 = By.xpath("(//ul[@data-template='question-template']//input)[10]");
    By txtInputAnswerSingleChoice6 = By.xpath("(//ul[@data-template='question-template']//input)[12]");
    By txtInputAnswerSingleChoice7 = By.xpath("(//ul[@data-template='question-template']//input)[14]");
    By txtInputAnswerSingleChoice8 = By.xpath("(//ul[@data-template='question-template']//input)[16]");
    By txtInputAnswerSingleChoice9 = By.xpath("(//ul[@data-template='question-template']//input)[18]");
    By txtInputAnswerSingleChoice10 = By.xpath("(//ul[@data-template='question-template']//input)[20]");
    By txtInputAnswerSingleChoice11 = By.xpath("(//ul[@data-template='question-template']//input)[22]");
    By txtInputAnswerSingleChoice12 = By.xpath("(//ul[@data-template='question-template']//input)[24]");
    By txtInputAnswerSingleChoice13 = By.xpath("(//ul[@data-template='question-template']//input)[26]");
    By txtInputAnswerSingleChoice14 = By.xpath("(//ul[@data-template='question-template']//input)[28]");
    By txtInputAnswerSingleChoice15 = By.xpath("(//ul[@data-template='question-template']//input)[30]");
    By txtInputAnswer = By.xpath("(//ul[@data-template='question-template-scenario']//input)[2]");
    By txtInputAnswer2 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[4]");
    By txtInputAnswer3 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[6]");
    By txtInputAnswer4 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[8]");
    By txtInputAnswer5 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[10]");
    By txtInputAnswer6 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[12]");
    By txtInputAnswer7 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[14]");
    By txtInputAnswer8 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[16]");
    By txtInputAnswer9 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[18]");
    By txtInputAnswer10 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[20]");
    By txtInputAnswer11 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[22]");
    By txtInputAnswer12 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[24]");
    By txtInputAnswer13 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[26]");
    By txtInputAnswer14 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[28]");
    By txtInputAnswer15 = By.xpath("(//ul[@data-template='question-template-scenario']//input)[30]");
   
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
	
	public boolean isIconEdit5Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEdit5).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEdit6Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit6);
		return flag;
	}
	public boolean isIconEdit7Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit7);
		return flag;
	}
	public boolean isIconEdit8Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit8);
		return flag;
	}
	public boolean isIconEdit9Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit9);
		return flag;
	}
	public boolean isIconEdit10Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit10);
		return flag;
	}
	public boolean isIconEdit11Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit11);
		return flag;
	}
	public boolean isIconEdit12Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit12);
		return flag;
	}
	public boolean isIconEdit13Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit13);
		return flag;
	}
	public boolean isIconEdit14Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit14);
		return flag;
	}
	public boolean isIconEdit15Displayed(){
		boolean flag = isWebElementDisplayed(iconEdit15);
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
	
	public void clickIconSave5()
	{
		waitFluentWait(iconSave5);
		click(iconSave5);
	}
	public void clickIconSave6()
	{
		waitFluentWait(iconSave6);
		click(iconSave6);
	}
	public void clickIconSave7()
	{
		waitFluentWait(iconSave7);
		click(iconSave7);
	}
	public void clickIconSave8()
	{
		waitFluentWait(iconSave8);
		click(iconSave8);
	}
	public void clickIconSave9()
	{
		waitFluentWait(iconSave9);
		click(iconSave9);
	}
	public void clickIconSave10()
	{
		waitFluentWait(iconSave10);
		click(iconSave10);
	}
	public void clickIconSave11()
	{
		waitFluentWait(iconSave11);
		click(iconSave11);
	}
	public void clickIconSave12()
	{
		waitFluentWait(iconSave12);
		click(iconSave12);
	}
	public void clickIconSave13()
	{
		waitFluentWait(iconSave13);
		click(iconSave13);
	}
	public void clickIconSave14()
	{
		waitFluentWait(iconSave14);
		click(iconSave14);
	}
	public void clickIconSave15()
	{
		waitFluentWait(iconSave15);
		click(iconSave15);
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
	public void clickBtnRadio9()
	{
		waitFluentWait(btnRadio9);
		click(btnRadio9);
	}
	public void clickBtnRadio10()
	{
		waitFluentWait(btnRadio10);
		click(btnRadio10);
	}
	public void clickBtnRadio11()
	{
		waitFluentWait(btnRadio11);
		click(btnRadio11);
	}
	public void clickBtnRadio12()
	{
		waitFluentWait(btnRadio12);
		click(btnRadio12);
	}
	public void clickBtnRadio13()
	{
		waitFluentWait(btnRadio13);
		click(btnRadio13);
	}
	public void clickBtnRadio14()
	{
		waitFluentWait(btnRadio14);
		click(btnRadio14);
	}
	public void clickBtnRadio15()
	{
		waitFluentWait(btnRadio15);
		click(btnRadio15);
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
	public void fillInputAnswer3(String inputanswer)
	{
		waitFluentWait(txtInputAnswer3);
		ClickElementAndType(txtInputAnswer3, inputanswer);
	}
	public void fillInputAnswer4(String inputanswer)
	{
		waitFluentWait(txtInputAnswer4);
		ClickElementAndType(txtInputAnswer4, inputanswer);
	}
	public void fillInputAnswer5(String inputanswer)
	{
		waitFluentWait(txtInputAnswer5);
		ClickElementAndType(txtInputAnswer5, inputanswer);
	}
	public void fillInputAnswer6(String inputanswer)
	{
		waitFluentWait(txtInputAnswer6);
		ClickElementAndType(txtInputAnswer6, inputanswer);
	}
	public void fillInputAnswer7(String inputanswer)
	{
		waitFluentWait(txtInputAnswer7);
		ClickElementAndType(txtInputAnswer7, inputanswer);
	}
	public void fillInputAnswer8(String inputanswer)
	{
		waitFluentWait(txtInputAnswer8);
		ClickElementAndType(txtInputAnswer8, inputanswer);
	}
	public void fillInputAnswer9(String inputanswer)
	{
		waitFluentWait(txtInputAnswer9);
		ClickElementAndType(txtInputAnswer9, inputanswer);
	}
	public void fillInputAnswer10(String inputanswer)
	{
		waitFluentWait(txtInputAnswer10);
		ClickElementAndType(txtInputAnswer10, inputanswer);
	}
	public void fillInputAnswer11(String inputanswer)
	{
		waitFluentWait(txtInputAnswer11);
		ClickElementAndType(txtInputAnswer11, inputanswer);
	}
	public void fillInputAnswer12(String inputanswer)
	{
		waitFluentWait(txtInputAnswer12);
		ClickElementAndType(txtInputAnswer12, inputanswer);
	}
	public void fillInputAnswer13(String inputanswer)
	{
		waitFluentWait(txtInputAnswer13);
		ClickElementAndType(txtInputAnswer13, inputanswer);
	}
	public void fillInputAnswer14(String inputanswer)
	{
		waitFluentWait(txtInputAnswer14);
		ClickElementAndType(txtInputAnswer14, inputanswer);
	}
	public void fillInputAnswer15(String inputanswer)
	{
		waitFluentWait(txtInputAnswer15);
		ClickElementAndType(txtInputAnswer15, inputanswer);
	}
	
	public void fillInputAnswerSingleChoice(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice);
		ClickElementAndType(txtInputAnswerSingleChoice, inputanswer);
	}
	
	public void fillInputAnswerSingleChoice1(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice);
		ClickElementAndType(txtInputAnswerSingleChoice, inputanswer);
	}
	public void fillInputAnswerSingleChoice2(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice2);
		ClickElementAndType(txtInputAnswerSingleChoice2, inputanswer);
	}
	public void fillInputAnswerSingleChoice3(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice3);
		ClickElementAndType(txtInputAnswerSingleChoice3, inputanswer);
	}
	public void fillInputAnswerSingleChoice4(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice4);
		ClickElementAndType(txtInputAnswerSingleChoice4, inputanswer);
	}
	
	public void fillInputAnswerSingleChoice5(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice5);
		ClickElementAndType(txtInputAnswerSingleChoice5, inputanswer);
	}
	public void fillInputAnswerSingleChoice6(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice6);
		ClickElementAndType(txtInputAnswerSingleChoice6, inputanswer);
	}
	public void fillInputAnswerSingleChoice7(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice7);
		ClickElementAndType(txtInputAnswerSingleChoice7, inputanswer);
	}
	public void fillInputAnswerSingleChoice8(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice8);
		ClickElementAndType(txtInputAnswerSingleChoice8, inputanswer);
	}
	public void fillInputAnswerSingleChoice9(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice9);
		ClickElementAndType(txtInputAnswerSingleChoice9, inputanswer);
	}
	public void fillInputAnswerSingleChoice10(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice10);
		ClickElementAndType(txtInputAnswerSingleChoice10, inputanswer);
	}
	public void fillInputAnswerSingleChoice11(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice11);
		ClickElementAndType(txtInputAnswerSingleChoice11, inputanswer);
	}
	public void fillInputAnswerSingleChoice12(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice12);
		ClickElementAndType(txtInputAnswerSingleChoice12, inputanswer);
	}
	public void fillInputAnswerSingleChoice13(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice13);
		ClickElementAndType(txtInputAnswerSingleChoice13, inputanswer);
	}
	public void fillInputAnswerSingleChoice14(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice14);
		ClickElementAndType(txtInputAnswerSingleChoice14, inputanswer);
	}
	public void fillInputAnswerSingleChoice15(String inputanswer)
	{
		waitFluentWait(txtInputAnswerSingleChoice15);
		ClickElementAndType(txtInputAnswerSingleChoice15, inputanswer);
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
	By btnRadioSkillL1 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='1']");
	By btnRadioSkillL2 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='2']");
	By btnRadioSkillL3 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='3']");
	By btnRadioSkillL4 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='4']");
	By btnRadioSkillL5 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='5']");
	By btnRadioSkillL6 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='6']");
	By btnRadioSkillL7 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='7']");
	By btnRadioSkillL8 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='8']");
	By btnRadioSkillL9 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='9']");
	By btnRadioSkillL10 = By.xpath("//ul[@id='dllCreateSkillCompetency_listbox']//input[@value='10']");
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
	
	By btnExpandBehavior = By.xpath("//div[@id='accordion-behavior-level-1']//h3/button");
	By ckBehavior1 = By.xpath("(//ul[@class='list-group check-list']//input)[1]");
	By ckBehavior2 = By.xpath("(//ul[@class='list-group check-list']//input)[2]");
	By ckBehavior3 = By.xpath("(//ul[@class='list-group check-list']//input)[3]");
	public void selectSkillAndLevelSingleChoice(String skillName, int level, String behavior)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillName);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomationSingleChoice));
		sleep(3);
		switch (level) {
		case 1:
			ClickElement(btnRadioSkillL1);
			break;
		case 2:
			ClickElement(btnRadioSkillL2);
			break;
		case 3:
			ClickElement(btnRadioSkillL3);
			break;
		case 4:
			ClickElement(btnRadioSkillL4);
			break;
		case 5:
			ClickElement(btnRadioSkillL5);
			break;
		case 6:
			ClickElement(btnRadioSkillL6);
			break;
		case 7:
			ClickElement(btnRadioSkillL7);
			break;
		case 8:
			ClickElement(btnRadioSkillL8);
			break;
		case 9:
			ClickElement(btnRadioSkillL9);
			break;
		case 10:
			ClickElement(btnRadioSkillL10);
			break;
		default:
			System.out.println("INPUT WRONG LEVEL NUMBER");
			break;
		}
		String[] behavGroup = behavior.split(",");
		for (String _behav : behavGroup){
			if(!_behav.equals("")){
				scrollToElement(driver.findElement(btnExpandBehavior));
				waitFluentWait(btnExpandBehavior);
				click(btnExpandBehavior);
				if(_behav.equals("Behavior 1")){
					waitFluentWait(ckBehavior1);
					click(ckBehavior1);
				}else if(_behav.equals("Behavior 2")){
					waitFluentWait(ckBehavior2);
					click(ckBehavior2);
				}else if(_behav.equals("Behavior 3")){
					waitFluentWait(ckBehavior3);
					click(ckBehavior3);
				}
			}
		}
		/*if(!behavior.equals("")){
			scrollToElement(driver.findElement(btnExpandBehavior));
			waitFluentWait(btnExpandBehavior);
			click(btnExpandBehavior);
			switch (behavior) {
			case "Behavior 1":
				waitFluentWait(ckBehavior1);
				click(ckBehavior1);
				break;
			case "Behavior 2":
				waitFluentWait(ckBehavior2);
				click(ckBehavior2);
				break;
			case "Behavior 3":
				waitFluentWait(ckBehavior3);
				click(ckBehavior3);
				break;
			default:
				break;
			}
		}*/
	}
	
	By radioTrue = By.xpath("(//input[@name='radioTrueFalse'])[1]");
	By radioFalse = By.xpath("(//input[@name='radioTrueFalse'])[2]");
	
	public void clickRadioTrue(){
		waitFluentWait(radioTrue);
		click(radioTrue);
	}
	public void clickRadioFalse(){
		waitFluentWait(radioFalse);
		click(radioFalse);
	}
	public void selectAnswerTrueFalse(String answer){
		switch (answer) {
		case "true":
			clickRadioTrue();
			break;
		case "false":
			clickRadioFalse();
			break;
		case "":
			break;
		default:
			System.out.println("Please correct the input answer");
			break;
		}
	}
	
	By radioSingleChoiceStage1 = By.xpath("(//div[@id='listStageScenario']//input[contains(@name,'radioStage')])[1]");
	By radioMultiChoiceStage1 = By.xpath("(//div[@id='listStageScenario']//input[contains(@name,'radioStage')])[2]");
	By radioTrueFalseStage1 = By.xpath("(//div[@id='listStageScenario']//input[contains(@name,'radioStage')])[3]");
	
	public void selectTypeStage1(String choice){
		if(choice.equals("Single choice")){
			waitFluentWait(radioSingleChoiceStage1);
			click(radioSingleChoiceStage1);
		}else if(choice.equals("Multiple choice")){
			waitFluentWait(radioMultiChoiceStage1);
			click(radioMultiChoiceStage1);
		}else if(choice.equals("True/False")){
			waitFluentWait(radioTrueFalseStage1);
			click(radioTrueFalseStage1);
		}
	}
	
	By btnAddAnswerStage1 = By.xpath("//div[@id='listStageScenario']//button[@type='button']");
	public void clickBtnAddAnswerStage1(){
		waitFluentWait(btnAddAnswerStage1);
		click(btnAddAnswerStage1);
	}
	
	By msgCompTime = By.xpath("//span[@id='CreateCompletionTime_validationMessage']");
	By msgCreator = By.xpath("//span[@id='author_validationMessage']");
	By msgAssessmentGroup = By.xpath("//span[@id='CreatePools_validationMessage']");
	By msgQuesText = By.xpath("//span[@id='CreateQuestionText_validationMessage']");
	By msgSkillLevel = By.xpath("//span[@id='_validationMessage']");
	By msgAnswer = By.xpath("(//div[@id='frmQuestionAnswer']//span[contains(@id,'validationMessage')])[1]");
	public String getMsgCompTime(){
		String msg = driver.findElement(msgCompTime).getText();
		return msg;
	}
	public String getMsgCreator(){
		String msg = driver.findElement(msgCreator).getText();
		return msg;
	}
	public String getMsgAssessmentGroup(){
		String msg = driver.findElement(msgAssessmentGroup).getText();
		return msg;
	}
	public String getMsgQuesText(){
		String msg = driver.findElement(msgQuesText).getText();
		return msg;
	}
	public String getMsgSkillLevel(){
		String msg = driver.findElement(msgSkillLevel).getText();
		return msg;
	}
	public String getMsgAnswer(){
		String msg = driver.findElement(msgAnswer).getText();
		return msg;
	}
	public boolean isMsgCompTimeDisplayed(){
		boolean flag = isWebElementDisplayed(msgCompTime);
		return flag;
	}
	public boolean isMsgCreatorDisplayed(){
		boolean flag = isWebElementDisplayed(msgCreator);
		return flag;
	}
	public boolean isMsgAssessmentGroupDisplayed(){
		boolean flag = isWebElementDisplayed(msgAssessmentGroup);
		return flag;
	}
	public boolean isMsgQuestionTextDisplayed(){
		boolean flag = isWebElementDisplayed(msgQuesText);
		return flag;
	}
	public boolean isMsgSkillLevelDisplayed(){
		boolean flag = isWebElementDisplayed(msgSkillLevel);
		return flag;
	}
	public boolean isMsgAnswerDisplayed(){
		boolean flag = isWebElementDisplayed(msgAnswer);
		return flag;
	}
}
