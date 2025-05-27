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
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditSkillTest;
import wize.pages.Form_EditTestSchedule;
import wize.pages.Form_EditUser;
import wize.pages.Form_TestExam_ComplianceAssessment;
import wize.pages.Form_TestExam_SkillAssessment;
import wize.pages.Form_TestScheduleDetail;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.MyAssessment;
import wize.pages.MyData;
import wize.pages.MyData_Contact;
import wize.pages.MySpace;
import wize.pages.PendingForApproval;
import wize.pages.PendingForApproval_Assessment;
import wize.pages.Tab_Assessment;
import wize.pages.UserManagement;

public class Test_Assessment_ApproveRequestedTest extends TestManager {
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
	Form_TestExam_SkillAssessment testExamSkill;;
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
	UserManagement userManagement;
	Form_EditUser editUser;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;

	ImageCotainer imageCotainer;
	Screen screen;
	ScreenController s;
	PendingForApproval_Assessment pfaAssessment;
	PendingForApproval pendingForApproval;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		editUser = new Form_EditUser(driver);
		mySpace = new MySpace(driver);
		myDataContract = new MyData_Contact(driver);
		myData = new MyData(driver);
		dashBoard = new DashBoard(driver);
		assessmentLibrary = new AssessmentLibrary(driver);
		tabAssessment = new Tab_Assessment(driver);
		userManagement = new UserManagement(driver);
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
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		imageCotainer = new ImageCotainer();
		screen = new Screen();
		s = new ScreenController(screen);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
		pfaAssessment = new PendingForApproval_Assessment(driver);
		pendingForApproval = new PendingForApproval(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
		
	}

	@Test(priority = 1, enabled = true)

	public void Check_Rejected_status() throws InterruptedException {
		
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set| Assessment | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabAssessment();
		editFunctionSet.clickSubTabAssessmentSettings();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
		editFunctionSet.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");

		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("5. Access to Assessment");

		controlBoard.clickLblAssessment();

		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}

		TestLogger.info("6. Create New Caterogy or Access to a Category");

		assessment.fillSearchCategory(DataManager.FunctionSet);
		if (assessment.isFirstCategoryDisplayed() == true) {
			assessment.clickFirstCategory();

			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "Open Test screen");
			} else {
				setStatusTest("fail", "NOT Open Test screen");
			}
		} else {
			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.FunctionSet);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}
		}

		TestLogger.info("7. Open create Skill Test >> Input data on Basic Information tab");

		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();

		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Assessment");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Assessment");
		}

		createSkillTest.fillTitle(DataManager.ApproveTest1);
		createSkillTest.fillDescription(DataManager.ApproveTest1);
		createSkillTest.fillCategory("t");
		
		TestLogger.info("8. Next to Testing settings tab");

		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}
		
		TestLogger.info("8.2 Click on Restriction");
		
		createSkillTest.clickDrplistRestriction();

		Thread.sleep(2000);

		TestLogger.info("8.3 Choose Approval Requested");
		
		createSkillTest.clickItemApprovalRequested();

		TestLogger.info("8.4 Turn off Try again");
		
		createSkillTest.clickBtnRadioAssessmentSettings();

		TestLogger.info("9. Next to Question tab");

		createSkillTest.clickBtnNextTesting();
		

		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		Thread.sleep(3000);
		
		TestLogger.info("10. Input data on Question tab");

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

		TestLogger.info("11. Click on button Save");

		createSkillTest.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Skill Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test created successfully");
		}

		TestLogger.info("12. Access to tab Assessment >> Test Library");

		controlBoard.clickTabAssessment();

		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "Not Access to tab Assessment");
		}

		tabAssessment.clickTabAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "Not Access Test Library");
		}

		TestLogger.info("13. Hover on Assessment");

		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest1);
		assessmentLibrary.hoverOnAssessment();

		if (assessmentLibrary.isBtnRequestForApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays button: " + "Request for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Request for Approval");
		}
		
		TestLogger.info("14. Click on Request for Approval button");

		assessmentLibrary.clickBtnRequestForApproval();

		TestLogger.info("15. Click on My Assessment tab");

		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Peding for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Peding for Approval");
		}
				
		TestLogger.info("16. Logout >> Login with account Manager.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("17. Click on My space");
		
		controlBoard.clickTabMySpace();
		
		if (controlBoard.isTabMySpaceDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "My space");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "My space");
		}
		
		Thread.sleep(3000);
		
		TestLogger.info("18. Click on Pending for approval");
		
		mySpace.clickTabPendingforApproval();
		
		if (mySpace.isTabPendingforApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Pending for Approval");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Pending for Approval");
		}

		TestLogger.info("19. Click on Test");
		
		pendingForApproval.clickSubTabAssessment();
		
		if (pendingForApproval.isSubTabAssessmentDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Assessment");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Assessment");
		}

		TestLogger.info("20. Click on First Reject");
		
		pfaAssessment.clickIconFirstReject();
		pfaAssessment.fillRejectReason(DataManager.Test);
		pfaAssessment.clickBtnSaveReject();
		
		TestLogger.info("21. Logout >> Login with account Employee.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		controlBoard.clickTabAssessment();
		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Rejected");
		} else {
			setStatusTest("fail", "NOT displays status: " + "Rejected");
		}
	}

	@Test(priority = 2, enabled = true)

	public void Check_Approved_status() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assessment");

		controlBoard.clickLblAssessment();

		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}

		TestLogger.info("3. Create New Caterogy or Access to a Category");

		assessment.fillSearchCategory(DataManager.FunctionSet);
		if (assessment.isFirstCategoryDisplayed() == true) {
			assessment.clickFirstCategory();

			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "Open Test screen");
			} else {
				setStatusTest("fail", "NOT Open Test screen");
			}
		} else {
			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.FunctionSet);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}
		}

		TestLogger.info("4. Open create Skill Test >> Input data on Basic Information tab");

		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();

		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Assessment");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Assessment");
		}

		createSkillTest.fillTitle(DataManager.ApproveTest2);
		createSkillTest.fillDescription(DataManager.ApproveTest2);
		createSkillTest.fillCategory("t");
	
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}

		TestLogger.info("5. Next to Testing settings tab");

		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}
		
		TestLogger.info("5.2 Click on Restriction");
		
		createSkillTest.clickDrplistRestriction();

		Thread.sleep(2000);

		TestLogger.info("5.3 Choose Approval Requested");
		
		createSkillTest.clickItemApprovalRequested();
		
		TestLogger.info("5.4 Turn off Try again");
		
		createSkillTest.clickBtnRadioAssessmentSettings();

		TestLogger.info("6. Next to Question tab");

		createSkillTest.clickBtnNextTesting();
		;

		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		Thread.sleep(3000);
		
		TestLogger.info("7. Input data on Question tab");

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

		TestLogger.info("8. Click on button Save");

		createSkillTest.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Skill Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test created successfully");
		}

		TestLogger.info("9. Access to tab Assessment >> Test Library");

		controlBoard.clickTabAssessment();

		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "Not Access to tab Assessment");
		}

		tabAssessment.clickTabAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "Not Access Test Library");
		}

		TestLogger.info("10. Hover on Assessment");

		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest2);
		assessmentLibrary.hoverOnAssessment();

		if (assessmentLibrary.isBtnRequestForApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays button: " + "Request for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Request for Approval");
		}
		
		TestLogger.info("11. Click on Request for Approval button");

		assessmentLibrary.clickBtnRequestForApproval();

		Thread.sleep(5000);
		
		TestLogger.info("12. Click on My Assessment tab");

		tabAssessment.clickTabMyAssessment();
		
		Thread.sleep(5000);
		
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Peding for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Peding for Approval");
		}
		
		
		TestLogger.info("13. Logout >> Login with account Manager.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("14. Click on My space");
		
		controlBoard.clickTabMySpace();
		
		if (controlBoard.isTabMySpaceDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "My space");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "My space");
		}
		
		Thread.sleep(3000);
		
		TestLogger.info("15. Click on Pending for approval");
		
		mySpace.clickTabPendingforApproval();
		
		if (mySpace.isTabPendingforApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Pending for Approval");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Pending for Approval");
		}

		TestLogger.info("16. Click on Assessment");
		
		pendingForApproval.clickSubTabAssessment();
		
		if (pendingForApproval.isSubTabAssessmentDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Assessment");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Assessment");
		}

		TestLogger.info("17. Click on First Approve icon");
		
		pfaAssessment.searchQuestion(DataManager.ApproveTest2);
		pfaAssessment.clickIconFirstApprove();
		pfaAssessment.clickBtnYes();
		
		TestLogger.info("18. Logout >> Login with account Employee.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		controlBoard.clickTabAssessment();
		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Approved");
		} else {
			setStatusTest("fail", "NOT displays status: " + "Approved");
		}
	}

	@Test(priority = 3, enabled = true)

	public void Check_Completed_status_and_View_Result() throws InterruptedException {
		TestLogger.info("1. Login with account Employee.");

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		controlBoard.clickTabAssessment();
		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Approved");
		} else {
			setStatusTest("fail", "NOT displays status: " + "Approved");
		}
		
		TestLogger.info("2. Hover the test exam >> Click on 'Let's begin' button");

		if (myAssessment.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "The test exam is display with Lets begin button");
		} else {
			setStatusTest("fail", "The test exam does NOT display with Lets begin button");
		}
		
		TestLogger.info("3. Click on Lets begin button");
		
		assessmentLibrary.clickBtnLetBegin();

		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
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

		TestLogger.info("4. Take a test exam");

		testExamSkill.clickBtnLetBegin();

		if (testExamSkill.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question 1");
		} else {
			setStatusTest("fail", "NOT Open Question 1");
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

		TestLogger.info("5. Back to Test Library >> Access to My Test");

		testExamSkill.clickBtnBackToAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		
		TestLogger.info("6. Click on My Assesment");
		
		tabAssessment.clickTabMyAssessment();
		Thread.sleep(3000);
		
		driver.get("https://wize5ypmt3tnj4iw4.azurewebsites.net/AssessmentLibrary/Index?tabcode=2");
		
		TestLogger.info("7. Hover on Complete");
		
		myAssessment.hoverOnAssessment();
		if (myAssessment.isBtnViewResultDisplayed() == true) {
			setStatusTest("pass", "Displays : " + "View result");
		} else {
			setStatusTest("fail", "NOT displays : " + "View result");
		}

	}

	@Test(priority = 4, enabled = true)

	public void Check_Try_again_button_enable() throws InterruptedException {

		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assessment");

		controlBoard.clickLblAssessment();

		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}

		TestLogger.info("3. Create New Caterogy or Access to a Category");

		assessment.fillSearchCategory(DataManager.FunctionSet);
		if (assessment.isFirstCategoryDisplayed() == true) {
			assessment.clickFirstCategory();

			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "Open Test screen");
			} else {
				setStatusTest("fail", "NOT Open Test screen");
			}
		} else {
			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.FunctionSet);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}
		}

		TestLogger.info("4. Open create Skill Test >> Input data on Basic Information tab");

		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();

		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Assessment");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Assessment");
		}

		createSkillTest.fillTitle(DataManager.ApproveTest3);
		createSkillTest.fillDescription(DataManager.ApproveTest3);
		createSkillTest.fillCategory("t");
	
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}

		TestLogger.info("5. Next to Testing settings tab");

		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}
		
		TestLogger.info("5.2 Click on Restriction");
		
		createSkillTest.clickDrplistRestriction();

		Thread.sleep(2000);

		TestLogger.info("5.3 Choose Approval Requested");
		
		createSkillTest.clickItemApprovalRequested();

		TestLogger.info("6. Next to Question tab");

		createSkillTest.clickBtnNextTesting();
		;

		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		Thread.sleep(3000);
		
		TestLogger.info("7. Input data on Question tab");

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

		TestLogger.info("8. Click on button Save");

		createSkillTest.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Skill Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test created successfully");
		}

		TestLogger.info("9. Access to tab Assessment >> Test Library");

		controlBoard.clickTabAssessment();

		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "Not Access to tab Assessment");
		}

		tabAssessment.clickTabAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "Not Access Test Library");
		}

		TestLogger.info("10. Hover on Assessment");

		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest3);
		assessmentLibrary.hoverOnAssessment();

		if (assessmentLibrary.isBtnRequestForApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays button: " + "Request for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Request for Approval");
		}
		TestLogger.info("11. Click on Request for Approval button");

		assessmentLibrary.clickBtnRequestForApproval();
		Thread.sleep(5000);
		
		TestLogger.info("12. Click on My Assessment tab");

		tabAssessment.clickTabMyAssessment();
		Thread.sleep(5000);
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Peding for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Peding for Approval");
		}
		
		TestLogger.info("13. Logout >> Login with account Manager.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("14. Click on My space");
		
		controlBoard.clickTabMySpace();
		
		if (controlBoard.isTabMySpaceDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "My space");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "My space");
		}
		Thread.sleep(3000);
		
		TestLogger.info("15. Click on Pending for approval");
		
		mySpace.clickTabPendingforApproval();
		
		if (mySpace.isTabPendingforApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Pending for Approval");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Pending for Approval");
		}

		TestLogger.info("16. Click on Test");
		
		pendingForApproval.clickSubTabAssessment();
		
		if (pendingForApproval.isSubTabAssessmentDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Assessment");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Assessment");
		}

		TestLogger.info("17. Click on First Approve icon");
		
		pfaAssessment.searchQuestion(DataManager.ApproveTest3);
		pfaAssessment.clickIconFirstApprove();
		pfaAssessment.clickBtnYes();
		
		TestLogger.info("18. Logout >> Login with account Employee.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		controlBoard.clickTabAssessment();
		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Approved");
		} else {
			setStatusTest("fail", "NOT displays status: " + "Approved");
		}
		
		TestLogger.info("19. Hover the test exam >> Click on 'Let's begin' button");

		if (myAssessment.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "The test exam is display with \"Let's begin\" button");
		} else {
			setStatusTest("fail", "The test exam does NOT display with \"Let's begin\" button");
		}
		
		TestLogger.info("20. Click on Lets begin button");
		
		assessmentLibrary.clickBtnLetBegin();

		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}

		TestLogger.info("21. Take a test exam");

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

		TestLogger.info("22. Back to Test Library >> Access to My Test");

		testExamSkill.clickBtnBackToAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}

		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest3);

		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Completed status\r\n" + "2. View Result button");

		if (assessmentLibrary.isLblCompletedDisplayed() == true) {
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

		if (myAssessment.isLblCompleteStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}

		myAssessment.hoverOnAssessment();

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

	@Test(priority = 5, enabled = true)

	public void Check_Try_again_button_disable() throws InterruptedException {

		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assessment");

		controlBoard.clickLblAssessment();

		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}

		TestLogger.info("3. Create New Caterogy or Access to a Category");

		assessment.fillSearchCategory(DataManager.FunctionSet);
		if (assessment.isFirstCategoryDisplayed() == true) {
			assessment.clickFirstCategory();

			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "Open Test screen");
			} else {
				setStatusTest("fail", "NOT Open Test screen");
			}
		} else {
			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.FunctionSet);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}
		}

		TestLogger.info("4. Open create Skill Test >> Input data on Basic Information tab");

		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();

		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Assessment");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Assessment");
		}

		createSkillTest.fillTitle(DataManager.ApproveTest4);
		createSkillTest.fillDescription(DataManager.ApproveTest4);
		createSkillTest.fillCategory("t");

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}

		TestLogger.info("5. Next to Testing settings tab");

		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}
		
		TestLogger.info("5.2 Click on Restriction");
		
		createSkillTest.clickDrplistRestriction();
		Thread.sleep(2000);

		TestLogger.info("5.3 Choose Approval Requested");
		
		createSkillTest.clickItemApprovalRequested();
				
		TestLogger.info("5.4 Click on month");
		
		createSkillTest.clickDrplistInterval();
		
		TestLogger.info("5.5 Choose 2 months");
		
		createSkillTest.clickItem2Motnh();
		
		TestLogger.info("6. Next to Question tab");

		createSkillTest.clickBtnNextTesting();
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		Thread.sleep(3000);
		
		TestLogger.info("7. Input data on Question tab");

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

		TestLogger.info("8. Click on button Save");

		createSkillTest.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Skill Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test created successfully");
		}

		TestLogger.info("9. Access to tab Assessment >> Test Library");

		controlBoard.clickTabAssessment();

		if (tabAssessment.isTabMyAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to tab Assessment");
		} else {
			setStatusTest("fail", "Not Access to tab Assessment");
		}

		tabAssessment.clickTabAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Access to Test Library");
		} else {
			setStatusTest("fail", "Not Access Test Library");
		}

		TestLogger.info("10. Hover on Assessment");

		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest4);
		assessmentLibrary.hoverOnAssessment();

		if (assessmentLibrary.isBtnRequestForApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays button: " + "Request for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Request for Approval");
		}
		
		TestLogger.info("11. Click on Request for Approval button");

		assessmentLibrary.clickBtnRequestForApproval();
		Thread.sleep(5000);
		
		TestLogger.info("12. Click on My test tab");

		tabAssessment.clickTabMyAssessment();
		Thread.sleep(5000);
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Peding for Approval");
		} else {
			setStatusTest("fail", "NOT displays button: " + "Peding for Approval");
		}
		
		TestLogger.info("13. Logout >> Login with account Manager.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("14. Click on My space");
		
		controlBoard.clickTabMySpace();
		
		if (controlBoard.isTabMySpaceDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "My space");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "My space");
		}
		Thread.sleep(3000);
		
		TestLogger.info("15. Click on Pending for approval");
		
		mySpace.clickTabPendingforApproval();
		
		if (mySpace.isTabPendingforApprovalDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Pending for Approval");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Pending for Approval");
		}

		TestLogger.info("16. Click on Test");
		
		pendingForApproval.clickSubTabAssessment();
		
		if (pendingForApproval.isSubTabAssessmentDisplayed() == true) {
			setStatusTest("pass", "Displays tab: " + "Assessment");
		} else {
			setStatusTest("fail", "NOT displays tab: " + "Assessment");
		}

		TestLogger.info("17. Click on First Approve icon");
		
		pfaAssessment.searchQuestion(DataManager.ApproveTest4);
		pfaAssessment.clickIconFirstApprove();
		pfaAssessment.clickBtnYes();
		
		TestLogger.info("18. Logout >> Login with account Employee.");
		
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}

		loginScreen.SignInWith(PropertyManager.EmailUser1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		controlBoard.clickTabAssessment();
		tabAssessment.clickTabMyAssessment();
		myAssessment.hoverOnAssessment();
		
		if (myAssessment.isStatusApprovalRequestedDisplayed() == true) {
			setStatusTest("pass", "Displays status: " + "Approved");
		} else {
			setStatusTest("fail", "NOT displays status: " + "Approved");
		}
		
		TestLogger.info("19. Hover the test exam >> Click on 'Let's begin' button");

		if (myAssessment.isBtnLetBeginDisplayed() == true) {
			setStatusTest("pass", "The test exam is display with \"Let's begin\" button");
		} else {
			setStatusTest("fail", "The test exam does NOT display with \"Let's begin\" button");
		}
		
		TestLogger.info("20. Click on Lets begin button");
		
		assessmentLibrary.clickBtnLetBegin();

		if (testExamSkill.isLblAreYouReadyDisplayed() == true) {
			setStatusTest("pass", "Open Test Exam");
		} else {
			setStatusTest("fail", "NOT Open Test Exam");
		}

		TestLogger.info("21. Take a test exam");

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

		TestLogger.info("22. Back to Test Library >> Access to My Test");

		testExamSkill.clickBtnBackToAssessmentLibrary();

		if (tabAssessment.isTabAssessmentLibraryDisplayed() == true) {
			setStatusTest("pass", "Back to Test Library");
		} else {
			setStatusTest("fail", "NOT Back to Test Library");
		}
		assessmentLibrary.fillTxtSearchTest(DataManager.ApproveTest4);

		if (assessmentLibrary.isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "Search success");
		} else {
			setStatusTest("fail", "Search NOT success");
		}

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Completed status\r\n" + "2. View Result button");

		if (assessmentLibrary.isLblCompletedDisplayed() == true) {
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

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Completed status\r\n" + "2. View Result button\r\n"
				+ "3. Try again button is enable");

		if (myAssessment.isLblCompleteStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Completed status");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Completed status");
		}

		myAssessment.hoverOnAssessment();

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
		TestLogger.info("Hover on Try again button");
		myAssessment.hoverOnBtnTryAgain();
		
		if (myAssessment.isLblToolTipDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "You have to wait until DD Mon YYYY to retry the test");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "You have to wait until DD Mon YYYY to retry the test");
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
