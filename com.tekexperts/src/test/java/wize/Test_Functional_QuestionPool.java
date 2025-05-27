package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.DataManager;
import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.Form_CreateQuestion;
import wize.pages.Form_QuestionDetails;
import wize.pages.LoginScreen;
import wize.pages.MyContribution_Question;
import wize.pages.MySpace;
import wize.pages.QuestionPool;

public class Test_Functional_QuestionPool extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	QuestionPool questionPool;
	MySpace myspace;
	MyContribution_Question myQuestion;
	Form_CreateQuestion formCreateQuestion;
	Form_QuestionDetails formQuestionDetails;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		questionPool = new QuestionPool(driver);
		formCreateQuestion = new Form_CreateQuestion(driver);
		formQuestionDetails = new Form_QuestionDetails(driver);
		myQuestion = new MyContribution_Question(driver);
		myspace = new MySpace(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = true)

	public void TT_14176() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		if(questionPool.isFirstCategoryDisplayed() == true)
		{
			TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
			
			questionPool.clickFirstCategory();
			questionPool.clickBtnCreateQuestion();
			questionPool.clickItemSingleChoice();

			if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "Access to Create Question");
			} else {
				setStatusTest("fail", "Not Access to Create Question");
			}
		}
		else
		{
			questionPool.createCategory(DataManager.FunctionSet, PropertyManager.EmailAdmin1);
			questionPool.fillSearchCategory(DataManager.FunctionSet);
			questionPool.clickFirstCategory();
			
			TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
			
			questionPool.clickBtnCreateQuestion();
			questionPool.clickItemSingleChoice();

			if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "Access to Create Question");
			} else {
				setStatusTest("fail", "Not Access to Create Question");
			}
		}
				
		TestLogger.info("4. Create Question");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
}
	
	@Test(priority = 2, enabled = true)

	public void TT_14177() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
						
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > without linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoiceWithoutLinkedBehavior(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > without linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 3, enabled = true)

	public void TT_14966() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
			
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 4, enabled = true)

	public void TT_14967() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
						
		TestLogger.info("5. Select Pool  is Compliance >> Select one < skill # competency > >> Click on X icon of the skill");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
			
		formCreateQuestion.clickBtnCancel();
	}
	
	@Test(priority = 5, enabled = true)

	public void TT_14180() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 6, enabled = true)

	public void TT_14181() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
				
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > NO linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoiceWithoutLinkedBehavior(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > without linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 7, enabled = true)

	public void TT_14975() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
						
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 8, enabled = true)

	public void TT_14976() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
				
		TestLogger.info("5. Select Pool  is Compliance >> Select one < skill # competency > >> Click on X icon of the skill");

		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
		
		formCreateQuestion.clickBtnCancel();
	}
	
	@Test(priority = 9, enabled = true)

	public void TT_14178() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		
		if (formCreateQuestion.isLblTrueDisplayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickButtonSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 10, enabled = true)

	public void TT_14179() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
					
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > NOT has linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoiceWithoutLinkedBehavior(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > NOT has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		if (formCreateQuestion.isLblTrueDisplayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 11, enabled = true)

	public void TT_14995() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
						
		TestLogger.info("5. Select Pool  is Compliance >> Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		if (formCreateQuestion.isLblTrueDisplayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("7. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 12, enabled = true)

	public void TT_14996() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		TestLogger.info("5. Select Pool  is Compliance >> Select one < skill # competency > >> Click on X icon of the skill");
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillSingleChoice(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
			
		formCreateQuestion.clickBtnCancel();
	}
	
	@Test(priority = 13, enabled = true)

	public void TT_14201() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Not selected skill for the stage)");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage(DataManager.Skill4);
		formCreateQuestion.clickBtnSaveStage1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadioAnswerStage1();
		formCreateQuestion.clickBtnSaveAnswerStage1();
				
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickButtonSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 14, enabled = true)

	public void TT_15002() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Select one skill for the stage without linked behaviors)");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage(DataManager.Skill4);
		formCreateQuestion.clickBtnSaveStage1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadioAnswerStage1();
		formCreateQuestion.clickBtnSaveAnswerStage1();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillStage1WithoutLinkedBehavior(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > without linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
				
		formCreateQuestion.clickButtonSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 15, enabled = true)

	public void TT_15003() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Select one skill for the stage has linked behaviors)");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage(DataManager.Skill4);
		formCreateQuestion.clickBtnSaveStage1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadioAnswerStage1();
		formCreateQuestion.clickBtnSaveAnswerStage1();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillStage1(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
				
		formCreateQuestion.clickButtonSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 16, enabled = true)

	public void TT_15006() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Input many stages)");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage(DataManager.Skill4);
		formCreateQuestion.clickBtnSaveStage1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name 1 success");
		} else {
			setStatusTest("fail", "Add Stage Name 1 NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadioAnswerStage1();
		formCreateQuestion.clickBtnSaveAnswerStage1();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add Anwser 1 success");
		} else {
			setStatusTest("fail", "Add Anwser 1 NOT success");
		}
		
		formCreateQuestion.selectSkillStage1(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Add Stage 1 success");
		}
		else
		{
			setStatusTest("fail", "Add Stage 1 NOT success");
		}
		
		formCreateQuestion.clickBtnAddStage();
		
		formCreateQuestion.fillStage2(DataManager.Skill5);
		formCreateQuestion.clickBtnSaveStage2();
		
		if (formCreateQuestion.isIconEdit3Displayed() == true) {
			setStatusTest("pass", "Add Stage Name 2 success");
		} else {
			setStatusTest("fail", "Add Stage Name 2 NOT success");
		}
		
		formCreateQuestion.fillInputAnswer2(DataManager.Skill2);
		formCreateQuestion.clickBtnRadioAnswerStage2();
		formCreateQuestion.clickBtnSaveAnswerStage2();
		
		if (formCreateQuestion.isIconEdit4Displayed() == true) {
			setStatusTest("pass", "Add Anwser 2 success");
		} else {
			setStatusTest("fail", "Add Anwser 2 NOT success");
		}
		
		formCreateQuestion.selectSkillStage2(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Add Stage 2 success");
		}
		else
		{
			setStatusTest("fail", "Add Stage 2 NOT success");
		}
						
		formCreateQuestion.clickButtonSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("5. Check the < question > in Question list table");
			
		if(questionPool.checkQuestionExistedQuestionPool(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with informations are inputted ");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with informations are inputted ");
		}
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		controlBoard.clickTabMySpace();
		myspace.clickTabMyContribution();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Access to My Question");
		}
		else
		{
			setStatusTest("fail", "NOT Access to My Question");
		}
		
		TestLogger.info("Expected: " + "The question is displayed in the table with Status = Approved");
		
		if(questionPool.checkQuestionExistedContribution(QuestionText) == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Approved");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Approved");
		}
			
	}
	
	@Test(priority = 17, enabled = true)

	public void TT_15007() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Question Pool >> Select any category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		questionPool.clickFirstCategory();
		
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Remove Function)");
			
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = DataManager.FunctionSet + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage(DataManager.Skill4);
		formCreateQuestion.clickBtnSaveStage1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadioAnswerStage1();
		formCreateQuestion.clickBtnSaveAnswerStage1();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillStage1(DataManager.Skill1);	
		
		formCreateQuestion.clickIconRemoveSkillStage();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
		
		formCreateQuestion.clickBtnCancel();
		
		if(questionPool.isLinkFirstQuestionDisplayed() == true)
		{
			questionPool.clickCboxAll();
			questionPool.clickBtnDeleteAll();
			questionPool.clickBtnYesAll();
		}				
	}
	
		@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
					
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
			
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.quit();
	}
}
