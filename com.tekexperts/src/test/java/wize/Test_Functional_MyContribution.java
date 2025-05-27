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
import wize.pages.Form_EditQuestion;
import wize.pages.Form_QuestionDetails;
import wize.pages.LoginScreen;
import wize.pages.MyContribution_Question;
import wize.pages.MySpace;
import wize.pages.PendingForApproval_Assessment;
import wize.pages.QuestionPool;

public class Test_Functional_MyContribution extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	QuestionPool questionPool;
	MySpace mySpace;
	MyContribution_Question myQuestion;
	PendingForApproval_Assessment pfaAssessment;
	Form_CreateQuestion formCreateQuestion;
	Form_EditQuestion formEditQuestion;
	Form_QuestionDetails formQuestionDetails;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
	
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		questionPool = new QuestionPool(driver);
		pfaAssessment = new PendingForApproval_Assessment(driver);
		formCreateQuestion = new Form_CreateQuestion(driver);
		formEditQuestion = new Form_EditQuestion(driver);
		formQuestionDetails = new Form_QuestionDetails(driver);
		myQuestion = new MyContribution_Question(driver);
		mySpace = new MySpace(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_14240_TT_14298() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		if(questionPool.isIconEditCategoryDisplayed() == true)
		{
			TestLogger.info("3. Access to My Space >> My Contribution");

			controlBoard.clickTabMySpace();
			mySpace.clickTabMyContribution();
			
			if (myQuestion.isLblMyQuestionDisplayed() == true) {
				setStatusTest("pass", "Access to My Contribution");
			} else {
				setStatusTest("fail", "Not Access to My Contribution");
			}
		}
		else
		{
			questionPool.createCategory(DataManager.FunctionSet, PropertyManager.EmailAdmin);
			
			TestLogger.info("3. Access to My Space >> My Contribution");

			controlBoard.clickTabMySpace();
			mySpace.clickTabMyContribution();
			
			if (myQuestion.isLblMyQuestionDisplayed() == true) {
				setStatusTest("pass", "Access to My Contribution");
			} else {
				setStatusTest("fail", "Not Access to My Contribution");
			}
		}

		
				
		TestLogger.info("4. Click  on Create Question icon >> select Single choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("5. Create Question");
			
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave1();
		formCreateQuestion.clickBtnRadio1();
	
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
			
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
		
		myQuestion.clickIconSubmitFirstItem();
		
		TestLogger.info("7. Access to Pending for Approval >> sub tab Question >> Reject question");
		
		mySpace.clickTabPendingforApproval();
		
		if(pfaAssessment.isLblPendingForApprovalDisplayed() == true)
		{
			setStatusTest("pass", "Access to Pending for Approval");
		}
		else
		{
			setStatusTest("fail", "NOT Access to Pending for Approval");
		}
		
		pfaAssessment.clickIconFirstReject();
		pfaAssessment.rejectQuestion(DataManager.FunctionSet);
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question(s) have been rejected successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question(s) have been rejected successfully");
		}
			
		TestLogger.info("8. Access to My Contribution -> Question >> Click on Edit icon of question has status Rejected >> Update data >> Click on Save button");
		
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		myQuestion.clickIconEditFirstItem();
		formEditQuestion.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question has been updated successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question has been updated successfully");
		}		
}
		
	@Test(priority = 2)

	public void TT_15136_TT_14899() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
			
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
						
		TestLogger.info("5. Select one  < skill # competency > without linked  behaviors >> Click on Save button");
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > without linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
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
		
		myQuestion.clickIconSubmitFirstItem();
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "Change status to Pending");
		}
		else
		{
			setStatusTest("fail", "NOT Change status to Pending");
		}
		
		TestLogger.info("6. Access to Pending for Approval >> sub tab Question >> Aprrove question");
		
		mySpace.clickTabPendingforApproval();
		
		if(pfaAssessment.isLblPendingForApprovalDisplayed() == true)
		{
			setStatusTest("pass", "Access to Pending for Approval");
		}
		else
		{
			setStatusTest("fail", "NOT Access to Pending for Approval");
		}
		
		pfaAssessment.clickIconFirstApprove();
		pfaAssessment.aprroveQuestion(DataManager.Skill1);
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question(s) have been approved successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question(s) have been approved successfully");
		}
}
	
	@Test(priority = 3)

	public void TT_14243_TT_14289() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
			
		TestLogger.info("5. Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
			
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
		
		TestLogger.info("7. Click on Edit icon of question has status Draft ");
		
		myQuestion.clickIconEditFirstItem();
		
		if(formEditQuestion.isLblEditQuestionDisplayed() == true)
		{
			setStatusTest("pass", "Access to Edit Question popup");
		}
		else
		{
			setStatusTest("fail", "NOT Access to Edit Question popup");
		}
		
		TestLogger.info("8. Update data >> Click on Save button ");
		
		formEditQuestion.clickIconRemoveMySkill();
		formEditQuestion.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question updated successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question updated successfully.");
		}
}
	
	@Test(priority = 4)

	public void TT_15138() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Single choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
						
		TestLogger.info("5. Select one < skill # competency > >> Click on X icon of the skill");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
				
	}
	
	@Test(priority = 5)

	public void TT_14246() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
}
	
	@Test(priority = 6)

	public void TT_14248() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
				
		TestLogger.info("5. Select one  < skill # competency > without linked  behaviors >> Click on Save button");

		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill2);
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > without linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}	
	}
	
	@Test(priority = 7)

	public void TT_15206() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
						
		TestLogger.info("5. Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
}
	
	@Test(priority = 8)

	public void TT_15207() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Multipe choice option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemMultipleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
				
		TestLogger.info("5. Select one < skill # competency > >> Click on X icon of the skill");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
				
	}
	
	@Test(priority = 9)

	public void TT_14249() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		formCreateQuestion.clickBtnQuestionInformation();
		formCreateQuestion.clickBtnRadio2();
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}			
	}
	
	@Test(priority = 10)

	public void TT_14250() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
					
		TestLogger.info("5. Select one  < skill # competency > NOT has linked  behaviors >> Click on Save button");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == false)
		{
			setStatusTest("pass", "Displays < skill name + level > NOT has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > has linked behaviors");
		}
		
		formCreateQuestion.clickBtnQuestionInformation();
		formCreateQuestion.clickBtnRadio2();
							
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
	}
	
	@Test(priority = 11)

	public void TT_15220() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
						
		TestLogger.info("5. Select one  < skill # competency > has linked  behaviors >> Click on Save button");
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.clickBtnQuestionInformation();
		formCreateQuestion.clickBtnRadio2();
			
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
		
		TestLogger.info("6. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
}
	
	@Test(priority = 12)

	public void TT_15221() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select True/False option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemTrueFalse();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Question text, Answer.");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		TestLogger.info("5. Select one < skill # competency > >> Click on X icon of the skill");
		
		formCreateQuestion.selectSkillMyContribution(DataManager.Skill1);
		formCreateQuestion.clickIconRemoveSkill();
		
		if(formCreateQuestion.isTagTestAutomationDisplayed() == true)
		{
			setStatusTest("pass", "The skill is removed");
		}
		else
		{
			setStatusTest("fail", "The skill is NOT removed");
		}
				
	}
	
	@Test(priority = 13)

	public void TT_14251() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Not selected skill for the stage)");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();

		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage("Test 1");
		formCreateQuestion.clickIconSave1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickBtnRadio4();
		formCreateQuestion.clickIconSave2();
				
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
	}
	
	@Test(priority = 14)

	public void TT_14253() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Select one skill for the stage without linked behaviors)");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();

		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage("Test 1");
		formCreateQuestion.clickIconSave1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave2();
		formCreateQuestion.clickBtnRadio4();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillMy2(DataManager.Skill2);
		
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
	}
	
	@Test(priority = 14)

	public void TT_15234() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Select one skill for the stage has linked behaviors)");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage("Test 1");
		formCreateQuestion.clickIconSave1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave2();
		formCreateQuestion.clickBtnRadio4();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillMyStage1(DataManager.Skill1);
		
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
	}
	
	@Test(priority = 15)

	public void TT_15240() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Input many stages)");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
				
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage("Test 1");
		formCreateQuestion.clickIconSave1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name 1 success");
		} else {
			setStatusTest("fail", "Add Stage Name 1 NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave2();
		formCreateQuestion.clickBtnRadio4();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add Anwser 1 success");
		} else {
			setStatusTest("fail", "Add Anwser 1 NOT success");
		}
		
		formCreateQuestion.selectSkillMyStage1(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Add Stage 1 success");
		}
		else
		{
			setStatusTest("fail", "Add Stage 1 NOT success");
		}
		
		formCreateQuestion.clickBtnAddStage();
		
		formCreateQuestion.fillStage2("Test 2");
		formCreateQuestion.clickIconSave3();
		
		if (formCreateQuestion.isIconEdit3Displayed() == true) {
			setStatusTest("pass", "Add Stage Name 2 success");
		} else {
			setStatusTest("fail", "Add Stage Name 2 NOT success");
		}
		
		formCreateQuestion.fillInputAnswer2(DataManager.Skill2);
		formCreateQuestion.clickIconSave4();
		formCreateQuestion.clickBtnRadio8();
		
		if (formCreateQuestion.isIconEdit4Displayed() == true) {
			setStatusTest("pass", "Add Anwser 2 success");
		} else {
			setStatusTest("fail", "Add Anwser 2 NOT success");
		}
		
		formCreateQuestion.selectSkillMyStage2(DataManager.Skill2);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Add Stage 1 success");
		}
		else
		{
			setStatusTest("fail", "Add Stage 1 NOT success");
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
		
		TestLogger.info("5. Check the < question > in My Space - My Contribution - Question page");
		
		if(myQuestion.isLblStatusDisplayed() == true)
		{
			setStatusTest("pass", "The question is displayed in the table with Status = Draft");
		}
		else
		{
			setStatusTest("fail", "The question is NOT displayed in the table with Status = Draft");
		}
	}
	
	@Test(priority = 16)

	public void TT_15241() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemScenario();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question(Remove Function)");
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
			
		formCreateQuestion.clickDrplistProduct();
		formCreateQuestion.clickItemProduct1();
		
		formCreateQuestion.fillCase(TienIch.taoRandomSo(1));
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		formCreateQuestion.clickBtnQuestionInformation();
		
		formCreateQuestion.fillStage("Test 1");
		formCreateQuestion.clickIconSave1();
		
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add Stage Name success");
		} else {
			setStatusTest("fail", "Add Stage Name NOT success");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave2();
		formCreateQuestion.clickBtnRadio4();
		
		if (formCreateQuestion.isIconEdit2Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.selectSkillMyStage1(DataManager.Skill1);	
		
		formCreateQuestion.clickIconRemoveSkillMyStage();
		
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
	
	@Test(priority = 17)

	public void TT_14901() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> My Contribution");

		controlBoard.clickTabMySpace();
		mySpace.clickTabMyContribution();
		
		if (myQuestion.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to My Contribution");
		} else {
			setStatusTest("fail", "Not Access to My Contribution");
		}
		
		TestLogger.info("3. Click  on Create Question icon >> select Scenario  option ");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		TestLogger.info("4. Create Question");
			
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
		
		String QuestionText = "Test Automation" + TienIch.taoRandomSo(3);
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave1();
		formCreateQuestion.clickBtnRadio1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("5. Click on Delete icon of question has status Draft ");
		
		myQuestion.deleteFirstItem();
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Question deleted successfully");
		}
		else
		{
			setStatusTest("fail", "Question NOT deleted successfully");
		}	
		
		TestLogger.info("6. Create Question");
		
		myQuestion.clickBtnCreateQuestion();
		myQuestion.clickItemSingleChoice();
		
		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		formCreateQuestion.clickDrplistCategory();
		formCreateQuestion.clickItemTestingAutomation();
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItemMyContribution();
		
		formCreateQuestion.clickBtnAssignToMe2();
				
		formCreateQuestion.fillQuestionText(QuestionText);
		
		formCreateQuestion.fillInputAnswer(DataManager.FunctionSet);
		formCreateQuestion.clickIconSave1();
		formCreateQuestion.clickBtnRadio1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("7. Click on Delete icon of question has status Draft ");
		
		myQuestion.deleteAll();
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Question deleted successfully");
		}
		else
		{
			setStatusTest("fail", "Question NOT deleted successfully");
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
		driver.close();
	}
}
