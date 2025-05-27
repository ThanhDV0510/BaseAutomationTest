package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.DataManager;
import Ulties.ImageCotainer;
import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import controller.ScreenController;
import controller.WebDriversManager;
import wize.pages.Assessment;
import wize.pages.AssessmentLibrary;
import wize.pages.AssessmentSchedule;
import wize.pages.AttendeeList;
import wize.pages.AttendeeList_TestSchedule;
import wize.pages.ControlBoard;
import wize.pages.DashBoard;
import wize.pages.Form_AssignAttendee;
import wize.pages.Form_CreateAdaptiveTest;
import wize.pages.Form_CreateComplianceTest;
import wize.pages.Form_CreateSkillTest;
import wize.pages.Form_CreateTestSchedule;
import wize.pages.Form_EditAdaptiveTest;
import wize.pages.Form_EditComplianceTest;
import wize.pages.Form_EditSkillTest;
import wize.pages.Form_EditTestSchedule;
import wize.pages.Form_TestExam_ComplianceAssessment;
import wize.pages.Form_TestExam_SkillAssessment;
import wize.pages.Form_TestScheduleDetail;
import wize.pages.LoginScreen;
import wize.pages.MyAssessment;
import wize.pages.MyData;
import wize.pages.MyData_Contact;
import wize.pages.MySpace;
import wize.pages.Tab_Assessment;

public class Test_Assessment_PublicTestList extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	
	MySpace mySpace;
	MyData myData;
	MyData_Contact myDataContract;
	DashBoard dashBoard;
	AssessmentLibrary assessmentLibrary;
	Tab_Assessment tabAssessment;
	Form_TestExam_ComplianceAssessment testExamCompliance;
	Form_TestExam_SkillAssessment testExamSkill;
	MyAssessment myAssessment;
	
	Assessment assessment;
	Form_CreateAdaptiveTest createAdaptiveTest;
	Form_CreateComplianceTest createComplianceTest;
	Form_CreateSkillTest createSkillTest;
	Form_EditAdaptiveTest editAdaptiveTest;
	Form_EditComplianceTest editComplianceTest;
	Form_EditSkillTest editSkillTest;
	AssessmentSchedule assessmentSchedule;
	Form_CreateTestSchedule createTestSchedule;
	Form_EditTestSchedule editTestSchedule;
	Form_TestScheduleDetail testScheduleDetail;
	Form_AssignAttendee assignAttendee;
	AttendeeList_TestSchedule attendeeListSchedule;
	AttendeeList attendeeList;
	
	ImageCotainer imageCotainer;
	Screen screen;
	ScreenController s;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		mySpace = new MySpace(driver);
		myDataContract = new MyData_Contact(driver);
		myData = new MyData(driver);
		dashBoard = new DashBoard(driver);
		assessmentLibrary = new AssessmentLibrary(driver);
		tabAssessment = new Tab_Assessment(driver);
		assessment = new Assessment(driver);
		testExamCompliance = new Form_TestExam_ComplianceAssessment(driver);
		testExamSkill = new Form_TestExam_SkillAssessment(driver);
		createAdaptiveTest = new Form_CreateAdaptiveTest(driver);
		createComplianceTest = new Form_CreateComplianceTest(driver);
		createSkillTest = new Form_CreateSkillTest(driver);
		editAdaptiveTest = new Form_EditAdaptiveTest(driver);
		editComplianceTest = new Form_EditComplianceTest(driver);
		editSkillTest = new Form_EditSkillTest(driver);
		assessmentSchedule = new AssessmentSchedule(driver);
		createTestSchedule = new Form_CreateTestSchedule(driver);
		editTestSchedule = new Form_EditTestSchedule(driver);
		editTestSchedule = new Form_EditTestSchedule(driver);
		testScheduleDetail = new Form_TestScheduleDetail(driver);
		assignAttendee = new Form_AssignAttendee(driver);
		attendeeListSchedule = new AttendeeList_TestSchedule(driver);
		attendeeList = new AttendeeList(driver);
		myAssessment = new MyAssessment(driver);
		imageCotainer = new ImageCotainer();
		screen = new Screen();
		s = new ScreenController(screen);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = true)

	public void Check_View_Result_button_and_Completed_status() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assesment >> Select a Category");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}		
		
		assessment.fillSearchCategory(DataManager.FunctionSet);

		assessment.clickFirstCategory();
			
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		TestLogger.info("3. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
		
		createSkillTest.fillTitle(DataManager.PublicTest1);
		createSkillTest.fillDescription(DataManager.PublicTest1);
		createSkillTest.fillCategory("t");
	
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("4. Next to Testing settings tab >> Input data");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		createSkillTest.clickDrplistRestriction();
		createSkillTest.clickItemPublic();
		
		createSkillTest.clickBtnRadioAssessmentSettings();
		
		TestLogger.info("5. Next to Question tab >> Input data on Question tab >> Click on button Save");
		
		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		createSkillTest.clickDrplistDimensionValue(DataManager.Assessment);
		createSkillTest.clickItemDimensionValue();
		
		createSkillTest.clickIconAddQuestion();
		
		if (createSkillTest.isLblImportQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
				
		createSkillTest.clickCboxAll();
		createSkillTest.clickBtnSaveImport();
		
		if (createSkillTest.isIconDelete1Displayed() == true) {
			setStatusTest("pass", "Add Question Success");
		} else {
			setStatusTest("fail", "Add Question Fail");
		}
		
		createSkillTest.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test created successfully");
		}
		
		TestLogger.info("6. Access to tab Assessment >> Test Library >> Search Test exam");

		controlBoard.clickTabAssessment();
		
		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "NOT Access to tab Assessment");
		}
		
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "NOT Access Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest1);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("7. Hover the test exam >> Click on 'Let's begin' button");
		
		assessmentLibrary.hoverOnAssessment();
		
		if (assessmentLibrary.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "Open tooltip");
		} else {
			setStatusTest("fail", "NOT Open tooltip");
		}
		
		assessmentLibrary.clickBtnLetBegin();
		
		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}
		
		TestLogger.info("8. Take a test exam");
		
		testExamSkill.clickBtnLetBegin();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 1");
		} else {
			setStatusTest("fail", "NOT Open Question 1");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. ARE YOU READY? label\r\n" 
				+ "2. Let's begin button\r\n"
				+ "3. Cancel button");
		
		if (testExamSkill. isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ARE YOU READY? label");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ARE YOU READY? label");
		}
		
		if (testExamSkill. isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Let's begin button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Let's begin button");
		}
		
		if (testExamSkill. isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Cancel button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Cancel button");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSavenNext();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 2");
		} else {
			setStatusTest("fail", "NOT Open Question 2");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSubmit();
		
		if (testExamSkill.isLblConfirmationDisplayed() == true) 
		{
			testExamSkill.clickBtnYes();
		}
				
		if (testExamSkill.isBtnSeeTheResultsDisplayed() == true) {
			setStatusTest("pass", "Take a test success");
		} else {
			setStatusTest("fail", "Take a test NOT success");
		}
		
		TestLogger.info("9. Back to Test Library >> Access to My Test");
		
		testExamSkill.clickBtnBackToAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest1);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (assessmentLibrary. isLblCompletedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		assessmentLibrary.hoverOnLblCompleted();
		
		if (assessmentLibrary. isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
		
		tabAssessment.clickTabMyAssessment();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (myAssessment. isLblStatusPublicDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		myAssessment.hoverOnLblStatusPublic();
		
		if (myAssessment. isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
	}
	
	@Test(priority = 2, enabled = true)

	public void Check_Try_again_button_enable() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assesment >> Select a Category");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}		
		
		assessment.fillSearchCategory(DataManager.FunctionSet);

		assessment.clickFirstCategory();
			
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		TestLogger.info("3. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
	
		createSkillTest.fillTitle(DataManager.PublicTest2);
		createSkillTest.fillDescription(DataManager.PublicTest2);
		createSkillTest.fillCategory("t");

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("4. Next to Testing settings tab >> Try again = ON and 1 times and 0 month interval ");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		createSkillTest.clickDrplistRestriction();
		createSkillTest.clickItemPublic();
			
		TestLogger.info("5. Next to Question tab >> Input data on Question tab >> Click on button Save");
		
		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		createSkillTest.clickDrplistDimensionValue(DataManager.Assessment);
		createSkillTest.clickItemDimensionValue();
		
		createSkillTest.clickIconAddQuestion();
		
		if (createSkillTest.isLblImportQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
				
		createSkillTest.clickCboxAll();
		createSkillTest.clickBtnSaveImport();
		
		if (createSkillTest.isIconDelete1Displayed() == true) {
			setStatusTest("pass", "Add Question Success");
		} else {
			setStatusTest("fail", "Add Question Fail");
		}
		
		createSkillTest.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test created successfully");
		}	
		
		TestLogger.info("6. Access to tab Assessment >> Test Library >> Search Test exam");

		controlBoard.clickTabAssessment();
		
		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "NOT Access to tab Assessment");
		}
		
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "NOT Access Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest2);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("7. Hover the test exam >> Click on 'Let's begin' button");
		
		assessmentLibrary.hoverOnAssessment();
		
		if (assessmentLibrary.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "Open tooltip");
		} else {
			setStatusTest("fail", "NOT Open tooltip");
		}
		
		assessmentLibrary.clickBtnLetBegin();
		
		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}
		
		TestLogger.info("8. Take a test exam");
		
		testExamSkill.clickBtnLetBegin();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 1");
		} else {
			setStatusTest("fail", "NOT Open Question 1");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. ARE YOU READY? label\r\n" 
				+ "2. Let's begin button\r\n"
				+ "3. Cancel button");
		
		if (testExamSkill. isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ARE YOU READY? label");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ARE YOU READY? label");
		}
		
		if (testExamSkill. isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Let's begin button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Let's begin button");
		}
		
		if (testExamSkill. isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Cancel button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Cancel button");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSavenNext();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 2");
		} else {
			setStatusTest("fail", "NOT Open Question 2");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSubmit();
		
		if (testExamSkill.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Open Confirmation popup");
		}
		
		testExamSkill.clickBtnYes();
		
		if (testExamSkill.isBtnSeeTheResultsDisplayed() == true) {
			setStatusTest("pass", "Take a test success");
		} else {
			setStatusTest("fail", "Take a test NOT success");
		}
		
		TestLogger.info("9. Back to Test Library >> Access to My Test");
		
		testExamSkill.clickBtnBackToAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest2);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (assessmentLibrary. isLblCompletedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		assessmentLibrary.hoverOnLblCompleted();
		
		if (assessmentLibrary.isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
		
		tabAssessment.clickTabMyAssessment();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button\r\n"
				+ "3. Try again button is enable");
		
		if (myAssessment.isLblStatusPublicDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		myAssessment.hoverOnLblStatusPublic();
		
		if (myAssessment.isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
		
		if (myAssessment.isBtnTryAgainEnableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Try again button is enable");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Try again button is enable");
		}
	}
	
	@Test(priority = 3, enabled = true)

	public void Check_Try_again_button_disable() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assesment >> Select a Category");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}		
		
		assessment.fillSearchCategory(DataManager.FunctionSet);

		assessment.clickFirstCategory();
			
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		TestLogger.info("3. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
		
		createSkillTest.fillTitle(DataManager.PublicTest3);
		createSkillTest.fillDescription(DataManager.PublicTest3);
		createSkillTest.fillCategory("t");
		
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("4. Next to Testing settings tab >> Try again = ON and 1 times and 1 month interval ");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		createSkillTest.clickDrplistRestriction();
		createSkillTest.clickItemPublic();
		
		createSkillTest.clickDrplistInterval();
		createSkillTest.clickItem1Motnh();
			
		TestLogger.info("5. Next to Question tab >> Input data on Question tab >> Click on button Save");
		
		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		createSkillTest.clickDrplistDimensionValue(DataManager.Assessment);
		createSkillTest.clickItemDimensionValue();
		
		createSkillTest.clickIconAddQuestion();
		
		if (createSkillTest.isLblImportQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
				
		createSkillTest.clickCboxAll();
		createSkillTest.clickBtnSaveImport();
		
		if (createSkillTest.isIconDelete1Displayed() == true) {
			setStatusTest("pass", "Add Question Success");
		} else {
			setStatusTest("fail", "Add Question Fail");
		}
		
		createSkillTest.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test created successfully");
		}
		
		TestLogger.info("6. Access to tab Assessment >> Test Library >> Search Test exam");

		controlBoard.clickTabAssessment();
		
		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "NOT Access to tab Assessment");
		}
		
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "NOT Access Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest3);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("7. Hover the test exam >> Click on 'Let's begin' button");
		
		assessmentLibrary.hoverOnAssessment();
		
		if (assessmentLibrary.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "Open tooltip");
		} else {
			setStatusTest("fail", "NOT Open tooltip");
		}
		
		assessmentLibrary.clickBtnLetBegin();
		
		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}
		
		TestLogger.info("8. Take a test exam");
		
		testExamSkill.clickBtnLetBegin();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 1");
		} else {
			setStatusTest("fail", "NOT Open Question 1");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. ARE YOU READY? label\r\n" 
				+ "2. Let's begin button\r\n"
				+ "3. Cancel button");
		
		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ARE YOU READY? label");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ARE YOU READY? label");
		}
		
		if (testExamSkill.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Let's begin button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Let's begin button");
		}
		
		if (testExamSkill.isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Cancel button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Cancel button");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSavenNext();
		
		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 2");
		} else {
			setStatusTest("fail", "NOT Open Question 2");
		}
		
		testExamSkill.clickBtnAnwser1();
		testExamSkill.clickBtnRadioCompleteConfidence();
		testExamSkill.clickBtnSubmit();
		
		if (testExamSkill.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Open Confirmation popup");
		}
		
		testExamSkill.clickBtnYes();
		
		if (testExamSkill.isBtnSeeTheResultsDisplayed() == true) {
			setStatusTest("pass", "Take a test success");
		} else {
			setStatusTest("fail", "Take a test NOT success");
		}
		
		TestLogger.info("9. Back to Test Library >> Access to My Test");
		
		
		testExamSkill.clickBtnBackToAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTest3);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (assessmentLibrary. isLblCompletedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		assessmentLibrary.hoverOnLblCompleted();
		
		if (assessmentLibrary. isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
		
		tabAssessment.clickTabMyAssessment();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button\r\n"
				+ "3. Try again button is enable");
		
		if (myAssessment.isLblStatusPublicDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		myAssessment.hoverOnLblStatusPublic();
		
		if (myAssessment.isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
		
		if (myAssessment.isBtnTryAgainDisableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Try again button is disable");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Try again button is disable");
		}
	}
	
	@Test(priority = 4, enabled = true)

	public void Check_Paused_status_and_Resume_button() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assesment >> Select a Category");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}		
		
		assessment.fillSearchCategory(DataManager.FunctionSet);

		assessment.clickFirstCategory();
			
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		TestLogger.info("3. Open create Compliance Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemComplianceTest();
		
		if (createComplianceTest.isLblCreateComplianceTestlDisplayed() == true) {
			setStatusTest("pass", "Access to Create Compliance Test");
		} else {
			setStatusTest("fail", "Not Access to Create Compliance Test");
		}	
				
		createComplianceTest.fillTitle(DataManager.PublicTestL4);
		createComplianceTest.fillDescription(DataManager.PublicTestL4);
		createComplianceTest.fillCategory("t");
		
		createComplianceTest.clickBtnThumbnail();
		
		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);

		if (createComplianceTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("4. Next to Testing settings tab >> Completion Time(min) = Unlimited & Pause = ON");
		
		createComplianceTest.clickBtnNextInfo();
		
		if (createComplianceTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		createComplianceTest.clickDrplistRestriction();
		createComplianceTest.clickItemPublic();
		
		createComplianceTest.clickDrplistCompletionTime();
		createComplianceTest.clickItemCUnlimited();
		
		createComplianceTest.clickBtnPause();
			
		TestLogger.info("5. Next to Question tab >> Input data on Question tab >> Click on button Save");
		
		createComplianceTest.clickBtnNextTesting();;
		
		if (createComplianceTest.isLinkClickHereDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		createComplianceTest.clickLinkClickHere();
		
		if (createComplianceTest.isLblAddQuestionProfilelDisplayed() == true) {
			setStatusTest("pass", "Access to Add Question popup");
		} else {
			setStatusTest("fail", "Not Access to Add Question popup");
		}
				
		createComplianceTest.searchCategoryImport(DataManager.Assessment);
		createComplianceTest.clickCboxAllImport();
		createComplianceTest.clickBtnSaveImport();
		
		if (createComplianceTest.isLblPreviewlDisplayed() == true) {
			setStatusTest("pass", "Add Question Success");
		} else {
			setStatusTest("fail", "Add Question Fail");
		}
		
 		createComplianceTest.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Compliance Test created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Compliance Test created successfully");
		}
		
		TestLogger.info("6. Access to tab Assessment >> Test Library >> Search Test exam");

		controlBoard.clickTabAssessment();
		
		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "NOT Access to tab Assessment");
		}
		
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "NOT Access Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTestL4);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("7. Hover the test exam >> Click on 'Let's begin' button");
		
		assessmentLibrary.hoverOnAssessment();
		
		if (assessmentLibrary.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "Open tooltip");
		} else {
			setStatusTest("fail", "NOT Open tooltip");
		}
		
		assessmentLibrary.clickBtnLetBegin();
		
		if (testExamCompliance.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}
		
		TestLogger.info("8. Take a test exam >> Click on Pause button");
	
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. ARE YOU READY? label\r\n" 
				+ "2. Let's begin button\r\n"
				+ "3. Cancel button");
		
		if (testExamCompliance.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ARE YOU READY? label");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ARE YOU READY? label");
		}
		
		if (testExamCompliance.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Let's begin button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Let's begin button");
		}
		
		if (testExamCompliance.isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Cancel button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Cancel button");
		}
		
		testExamCompliance.clickBtnLetBegin();
		
		if (testExamCompliance.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 1");
		} else {
			setStatusTest("fail", "NOT Open Question 1");
		}
		
		testExamCompliance.clickBtnAnwser1();
		testExamCompliance.clickBtnSavenNext();
		
		if (testExamCompliance.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 2");
		} else {
			setStatusTest("fail", "NOT Open Question 2");
		}
		
		testExamCompliance.clickBtnAnwser1();
		testExamCompliance.clickBtnPause();
				
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTestL4);
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Pause success");
		} else {
			setStatusTest("fail", "Pause NOT success");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Paused status\r\n" 
				+ "2. Resume is enable");
		
		if (assessmentLibrary. isLblPausedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Paused status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Paused status");
		}
		
		assessmentLibrary.hoverOnLblPaused();
		
		if (assessmentLibrary.isBtnResumeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Resume is enable");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Resume is enable");
		}
		
		TestLogger.info("9. Access to My Test >> Done test exam");
				
		tabAssessment.clickTabMyAssessment();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Paused status\r\n" 
				+ "2. Resume is enable");
		
		if (myAssessment.isLblPausedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Paused status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Paused status");
		}
		
		myAssessment.hoverOnLblPaused();
		
		if (myAssessment.isBtnResumeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Resume is enable");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Resume is enable");
		}
		
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "NOT Access Test Library");
		}
		
		assessmentLibrary.hoverOnLblPaused();
		assessmentLibrary.clickBtnResume();
		testExamCompliance.clickBtnSubmit();
		
		if (testExamCompliance.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Open Confirmation popup");
		}
		
		testExamCompliance.clickBtnYes();
		
		if (testExamCompliance.isBtnBackToAssessmentLibrarylDisplayed() == true) {
			setStatusTest("pass", "Take a test success");
		} else {
			setStatusTest("fail", "Take a test NOT success");
		}
		
		TestLogger.info("10. Back to My Test >> Access to Test Library");
		
		controlBoard.clickTabAssessment();
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (myAssessment.isLblStatusPublicDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		myAssessment.hoverOnLblStatusPublic();
			
		if (myAssessment.isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
		}
	
		tabAssessment.clickTabAssessmentLibrary();
		
		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		
		assessmentLibrary.fillTxtSearchTest(DataManager.PublicTestL4);
		
		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Completed status\r\n" 
				+ "2. View Result button");
		
		if (assessmentLibrary. isLblCompletedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}
		
		if (assessmentLibrary. isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "View Result button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "View Result button");
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
