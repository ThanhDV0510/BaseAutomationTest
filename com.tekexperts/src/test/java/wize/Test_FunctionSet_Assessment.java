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
import wize.pages.AssessmentSchedule;
import wize.pages.AttendeeList;
import wize.pages.AttendeeList_TestSchedule;
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
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
import wize.pages.Form_TestScheduleDetail;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_Assessment extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	
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
	Clone_Form_EditFunctionSet cloneForm;
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
		assessment = new Assessment(driver);
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
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		imageCotainer = new ImageCotainer();
		screen = new Screen();
		s = new ScreenController(screen);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = false)

	public void TT_16433() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxFullPermission();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("5. Access to Assessment >> Create New Caterogy");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
				
		assessment.fillSearchCategory(DataManager.Functional);
		
		if(assessment.isFirstCategoryDisplayed() == true)
		{
			assessment.clickIconDeleteCategory();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
			}
			
			assessment.clickBtnCreateCategory();
			
			if (assessment. isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
			
			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}
			
		}
		else
		{
			assessment.clickBtnCreateCategory();
			
			if (assessment. isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
			
			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}
		}
		
		assessment.hoverCategory();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
						
		TestLogger.info("6. Update Category");
	
		assessment.clickIconEditCategory();
		
		if (assessment.isLblEditCategoryDisplayed() == true) {
			setStatusTest("pass", "Open Eit Category popup");
		} else {
		setStatusTest("fail", "NOT Open Eit Category popup");
		}
				
		assessment.fillUpdateCategoryName("1");
		assessment.clickBtnSaveUpdateCategory();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Test category updated success");
		} else {
			setStatusTest("fail","Test category updated NOT success");
		}
		
		TestLogger.info("7. Delete Category");
		
		assessment.clickIconDeleteCategory();
				
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
		}
				
		TestLogger.info("8. Create New Caterogy or Access to a Category");
		
		assessment.fillSearchCategory(DataManager.FunctionSet);
		if(assessment.isFirstCategoryDisplayed() == true) 
		{
			assessment.clickFirstCategory();
			
			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass","Open Test screen");
			} else {
				setStatusTest("fail","NOT Open Test screen");
			}
		}
		else
		{
			assessment.clickBtnCreateCategory();
				
			if (assessment. isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
				
			assessment.fillCategoryName(DataManager.FunctionSet);
			assessment.clickBtnSaveCreate();
				
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}	
			
			assessment.fillSearchCategory(DataManager.FunctionSet);
			assessment.clickFirstCategory();
			
			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass","Open Test screen");
			} else {
				setStatusTest("fail","NOT Open Test screen");
			}
		}
	
		TestLogger.info("9. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
	
		createSkillTest.fillTitle(DataManager.Assessment_TT_16433);
		createSkillTest.fillDescription(DataManager.Assessment_TT_16433);
		createSkillTest.fillCategory("t");
		
		createSkillTest.clickBtnThumbnail();
		
		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("10. Next to Testing settings tab >> Next to Question tab");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment settings tab");
		} else {
			setStatusTest("fail", "Not Access to Assessment settings tab");
		}	

		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		TestLogger.info("11.  Input data on Question tab >> Click on button Save");
						
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
		
		assessment.searchName(DataManager.Assessment_TT_16433);
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Assessment\r\n" 
				+ "2. Button Create\r\n"
				+ "3. Icon Delete\r\n"
				+ "4. Icon Edit\r\n"
				+ "5. Icon Schedule");
		
		if (assessment.isLblAssessmentDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Assessment");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Assessment");
		}
		
		if (assessment.isBtnCreateAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		if (assessment.isIconDeleteFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (assessment.isIconEditFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		if (assessment.isIconScheduleFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Schedule");
		}
		
		TestLogger.info("12. Open Edit Skill Test");
	
		assessment.clickIconEditFirstItem();
				
		if (editSkillTest.isLblEditSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Adaptive Test");
		} else {
			setStatusTest("fail", "Not Access to Edit Adaptive Test");
		}		
				
		TestLogger.info("13. Next to Testing settings tab >> Update data on Testing settings tab");
		Thread.sleep(3000);
		editSkillTest.clickBtnNext();
		
		if (editSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		editSkillTest.clickCboxCompetency();
				
		TestLogger.info("14. Next to Question tab >> Click on button Save");
		
		editSkillTest.clickBtnNext();;
		
		if (editSkillTest.isLblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		editSkillTest.clickBtnSave();
		
		if (editSkillTest.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass","Open Confirmation popup");
		} else {
			setStatusTest("fail","NOT Open Confirmation popup");
		}
		
		editSkillTest.clickBtnYes();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Adaptive Test updated successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Adaptive Test updated successfully");
		}
		
		TestLogger.info("15. Delete Skill Test");
		
		assessment.clickIconDeleteFirstItem();
		assessment.clickBtnYes();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test deleted successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test deleted successfully");
		}
	}
	
	@Test(priority = 2,enabled = false)

	public void TT_16428() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | NO View");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFbtnRadioAssessment();
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("5. Access to Assessment");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Assessment in Control Board");
		
		if (controlBoard.isLblAssessmentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Assessment in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Assessment in Control Board");
		}
	}
	
	@Test(priority = 3,enabled = false)

	public void TT_16435() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | Manage Assessment Category");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewAssessmentList();
		cloneForm.clickONbtnManageAssessmentCategory();
		cloneForm.clickOFFbtnCreateAssessment();
		cloneForm.clickOFFBtnEditAssessmentSettings();
		cloneForm.clickOFFBbtnDeleteAssessment();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("5. Access to Assessment >> Create New Caterogy");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
				
		assessment.fillSearchCategory(DataManager.Functional);
		
		if(assessment.isFirstCategoryDisplayed() == true)
		{
			assessment.clickIconDeleteCategory();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
			}
			
			assessment.clickBtnCreateCategory();
			
			if (assessment. isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
			
			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}
			
		}
		else
		{
			assessment.clickBtnCreateCategory();
			
			if (assessment. isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
			
			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
						
		TestLogger.info("6. Update Category");
	
		assessment.clickIconEditCategory();
		
		if (assessment.isLblEditCategoryDisplayed() == true) {
			setStatusTest("pass", "Open Eit Category popup");
		} else {
		setStatusTest("fail", "NOT Open Eit Category popup");
		}
				
		assessment.fillUpdateCategoryName("1");
		assessment.clickBtnSaveUpdateCategory();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Test category updated success");
		} else {
			setStatusTest("fail","Test category updated NOT success");
		}
		
		TestLogger.info("7. Delete Category");
		
		assessment.clickIconDeleteCategory();
				
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
		}
	}
	
	@Test(priority = 4,enabled = false)

	public void TT_16436() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | Create Assessment");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewAssessmentList();
		cloneForm.clickONbtnManageAssessmentCategory();
		cloneForm.clickONbtnCreateAssessment();
		cloneForm.clickOFFBtnEditAssessmentSettings();
		cloneForm.clickOFFBbtnDeleteAssessment();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
				
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
		
		assessment.hoverCategory();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
			
		TestLogger.info("6. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
				
		createSkillTest.fillTitle(DataManager.Assessment_TT_16436);
		createSkillTest.fillDescription(DataManager.Assessment_TT_16436);
		createSkillTest.fillCategory("t");
		
		createSkillTest.clickBtnThumbnail();
		
		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("7. Next to Testing settings tab >> Next to Question tab");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	

		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		TestLogger.info("8. Input data on Question tab >> Click on button Save");
						
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
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Assessment\r\n" 
				+ "2. Button Create");
		
		if (assessment.isLblAssessmentDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Assessment");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Assessment");
		}
		
		if (assessment.isBtnCreateAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Icon Edit\r\n"
				+ "3. Icon Schedule");
			
		if (assessment.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (assessment.isIconEditFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessment.isIconScheduleFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Schedule");
		}
	}
	
	@Test(priority = 5,enabled = false)

	public void TT_16430() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | View Only");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxViewOnly();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
				
		TestLogger.info("5. Access to Assessment >> Open a Category");
		
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
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n"
				+ "CAN NOT see/do: \r\n"
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}

		if(!assessment.isIconDotDisplayed()){
			setStatusTest("pass", "User CAN NOT see/do: " + "icon dot");
		}else{
			setStatusTest("fail", "User CAN see/do: " + "icon dot");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Assessment");
		
		if (assessment.isLblAssessmentDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Assessment");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Assessment");
		}
	
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Icon Edit\r\n"
				+ "3. Icon Schedule\r\n"
				+ "4. Button Create");
			
		assessment.hoverOnFirstAssessment();
		
		if (assessment.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (assessment.isIconEditFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessment.isIconScheduleFirstItemDisplayed() == true || assessment.isIconAttendeeFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Icon Schedule");
		}
		
		if (assessment.isBtnCreateAssessmentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
	}
	
	@Test(priority = 6,enabled = false)

	public void TT_16437() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | Edit Assessment");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewAssessmentList();
		cloneForm.clickONbtnManageAssessmentCategory();
		cloneForm.clickOFFbtnCreateAssessment();
		cloneForm.clickONBtnEditAssessmentSettings();
		cloneForm.clickOFFBbtnDeleteAssessment();
		cloneForm.clickOFFbtnRadioAttendeelist();
		cloneForm.clickOFFbtnRadioAssessmentSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >> Open a Category");
		
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
		
		assessment.hoverCategory();
	
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Assessment\r\n" 
				+ "2. Icon Edit");
		
		if (assessment.isLblAssessmentDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Assessment");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Assessment");
		}
		
		if (assessment.isIconEditFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Schedule");
			
		if (assessment.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (assessment.isBtnCreateAssessmentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessment.isIconScheduleFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Schedule");
		}
						
		TestLogger.info("6. Open Edit Skill Test");
//		assessment.searchName("Assessment3604");
		assessment.searchName(DataManager.Assessment_TT_16436);
		assessment.clickIconEditFirstItem();
				
		if (editSkillTest.isLblEditSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Edit Skill Test");
		}		
		TestLogger.info("7. Next to Testing settings tab >> Update data on Testing settings tab");
		
		editSkillTest.clickBtnNext();
		
		if (editSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		editSkillTest.clickCboxCompetency();
				
		TestLogger.info("8. Next to Question tab >> Click on button Save");
		
		editSkillTest.clickBtnNext();;
		
		if (editSkillTest.isLblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		editSkillTest.clickBtnSave();
		
		if (editSkillTest.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass","Open Confirmation popup");
		} else {
			setStatusTest("fail","NOT Open Confirmation popup");
		}
		
		editSkillTest.clickBtnYes();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Assessment updated successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Assessment updated successfully");
		}
}
	
	@Test(priority =7,enabled = false)

	public void TT_16438() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
		
		TestLogger.info("3. Update Function Set| Assessment | Delete Assessment");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewAssessmentList();
		cloneForm.clickONbtnManageAssessmentCategory();
		cloneForm.clickOFFbtnCreateAssessment();
		cloneForm.clickOFFBtnEditAssessmentSettings();
		cloneForm.clickONbtnDeleteAssessment();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioAssessmentSchedule();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioAttendeelist();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Assessment >> Open a Category");
		
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
		
		assessment.hoverCategory();
	
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (assessment. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (assessment.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (assessment.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (assessment.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Assessment\r\n" 
				+ "2. Icon Delete");
		
		if (assessment.isLblAssessmentDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Assessment");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Assessment");
		}
		
		if (assessment.isIconDeleteFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Schedule");
			
		if (assessment.isIconEditFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessment.isBtnCreateAssessmentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessment.isIconScheduleFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Schedule");
		}
						
		TestLogger.info("6. Delete Skill Test");
//		assessment.searchName("Assessment3644");
		assessment.searchName(DataManager.Assessment_TT_16436);
		assessment.clickIconDeleteFirstItem();
		assessment.clickBtnYes();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test deleted successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test deleted successfully");
		}
}
	
	@Test(priority = 8,enabled = true)
		
		public void TT_16450() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Schedule | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxFullPermission();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Assign function set for Account User");
		
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblUser();
		
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "Access to USER MANAGEMENT");
		} else {
			setStatusTest("fail", "NOT Access to USER MANAGEMENT");
		}
		
		userManagement.openEditPopup(PropertyManager.EmailUser);
		editUser.updateFunctionSet(DataManager.FunctionSet);
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User updated sucessfully");
		}
		
		TestLogger.info("5. Logout >> Login with account User");
	
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
	
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("6. Access to Assessment >>  Open a Category");
		
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
	
		TestLogger.info("7. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
				
		createSkillTest.fillTitle(DataManager.Assessment_TT_16450);
		createSkillTest.fillDescription(DataManager.Assessment_TT_16450);
		createSkillTest.fillCategory("t");
		
		createSkillTest.clickBtnThumbnail();
		
		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);
	
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("8. Next to Testing settings tab >> Next to Question tab");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
	
		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		TestLogger.info("9.  Input data on Question tab >> Click on button Save");
						
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
			
		TestLogger.info("10.  Access to Schedule");
//		assessment.searchName("Assessment6404");
//		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
		
		TestLogger.info("11. Create Schedule");
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Schedule popup");
		}	
			
		createTestSchedule.fillScheduleName(DataManager.Schedule_TT_16450);
		createTestSchedule.clickIconStartDate();
		createTestSchedule.clickItemTodayStartDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Schedule created successfully");
		}	
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Button Create\r\n"
				+ "3. Icon Cancel\r\n"
				+ "4. Icon Edit\r\n"
				+ "5. Icon Assign\r\n"
				+ "6. Link Attende List");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		if (assessmentSchedule.isIconCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Cancel");
		}
		
		if (assessmentSchedule.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		if (assessmentSchedule.isIconAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Assign");
		}
		
		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
		}
		
		TestLogger.info("12. Update schedule");
//		assessmentSchedule.searchName("Schedule5917");
		assessmentSchedule.searchName(DataManager.Schedule_TT_16450);
		assessmentSchedule.clickIconEdit();
		
		if (editTestSchedule.isLblEditScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Edit Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Edit Schedule popup");
		}	
		
		editTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Schedule updated successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Schedule updated successfully");
		}	
		
		TestLogger.info("13. Open Assgin Attendee popup >> Assgin Employee");
		
		assessmentSchedule.clickIconAssign();
		
		if (assignAttendee.isLblAssignAttendeeDisplayed() == true) {
			setStatusTest("pass", "Access to Assgin Attendee popup");
		} else {
			setStatusTest("fail", "Not Access to Assgin Attendee popup");
		}

		assignAttendee.clickCboxAllLeft();
		assignAttendee.clickBtnMove();
		assignAttendee.clickBtnAssign();
				
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User added to schedule successfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User added to schedule successfully");
		}
			
		TestLogger.info("14. Cancel Schedule");
		
		assessmentSchedule.clickIconCancel();
		assessmentSchedule.clickBtnYes();
		
		if (assessmentSchedule.isLblCancelledDisplayed() == true) {
			setStatusTest("pass", "Cancel Schedule Success");
		} else {
			setStatusTest("fail", "Cancel Schedule NOT Success");
		}	
		
		TestLogger.info("15. Create 2nd Schedule");
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Schedule popup");
		}	
			
		createTestSchedule.fillScheduleName(DataManager.Schedule_TT_16450 + "1");
		createTestSchedule.clickIconStartDate();
		createTestSchedule.clickItemTodayStartDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Schedule created successfully");
		}	
	}

	@Test(priority = 9,enabled = true)
	
		public void TT_16444() throws InterruptedException {
		TestLogger.info("1. Login with account.");
	
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		
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
	
		TestLogger.info("3. Update Function Set| Assessment - Schedule | No View");
	
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
	
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
	
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONbtnRadioAssessmentGeneralSettings();
		cloneForm.clickOFFbtnRadioAssessmentSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
	
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
	
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("5. Access to Assessment >>  Open a Category");
	
		controlBoard.clickLblAssessment();
	
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
	
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Assessment screen");
		} else {
			setStatusTest("fail","NOT Open Assessment screen");
		}

		TestLogger.info("6. Access to Schedule");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Schedule");
		
		if (assessment.isIconScheduleFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Schedule");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Schedule");
		}
		
}
	
	@Test(priority = 10,enabled = true)
		
		public void TT_16452() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Schedule | View & Create Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnRadioAssessmentSchedule();
		cloneForm.clickONbtnViewSchedulelist();
		cloneForm.clickONbtnCreateTestSchedule();
		cloneForm.clickOFFbtnEditTestSchedule();
		cloneForm.clickOFFbtnCancelTestSchedule();
		cloneForm.clickOFFbtnAssignAttendee();
		cloneForm.clickOFFbtnRemoveAttendee();
		cloneForm.clickOFFbtnViewTestReportTestSchedule();
		cloneForm.clickOFFBtnViewAttendeeListTestSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6.  Access to Schedule");
//		assessment.searchName("Assessment7384");
		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
						
		TestLogger.info("7. Create Schedule");
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Schedule popup");
		}	
					
		createTestSchedule.fillScheduleName(DataManager.Schedule_TT_16452);
		createTestSchedule.clickIconStartDate();
		createTestSchedule.clickItemTodayStartDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Schedule created successfully");
		}	
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Button Create");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Cancel\r\n"
				+ "2. Icon Edit\r\n"
				+ "3. Icon Assign\r\n"
				+ "4. Link Attende List");
				
		if (assessmentSchedule.isIconCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Cancel");
		}
		
		if (assessmentSchedule.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessmentSchedule.isIconAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Assign");
		}
		
		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Link Attende List");
		}
		
		assessmentSchedule.clickIconX();
}	
	
	@Test(priority = 11,enabled = true)
	
		public void TT_16461() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Schedule | View & Edit Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnRadioAssessmentSchedule();
		cloneForm.clickONbtnViewSchedulelist();
		cloneForm.clickOFFbtnCreateTestSchedule();
		cloneForm.clickONbtnEditTestSchedule();
		cloneForm.clickOFFbtnCancelTestSchedule();
		cloneForm.clickOFFbtnAssignAttendee();
		cloneForm.clickOFFbtnRemoveAttendee();
		cloneForm.clickOFFbtnViewTestReportTestSchedule();
		cloneForm.clickOFFBtnViewAttendeeListTestSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6.  Access to Schedule");
//		assessment.searchName("Assessment7384");
		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Icon Edit");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
						
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Cancel\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Assign\r\n"
				+ "4. Link Attende List");
				
		if (assessmentSchedule.isIconCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Cancel");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessmentSchedule.isIconAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Assign");
		}	
		
		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
		}
		
		TestLogger.info("7. Update schedule");
//		assessmentSchedule.searchName("Schedule8025");
		assessmentSchedule.searchName(DataManager.Schedule_TT_16452);
		assessmentSchedule.clickIconEdit();
		
		if (editTestSchedule.isLblEditScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Edit Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Edit Schedule popup");
		}	
		
		editTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Schedule updated successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Schedule updated successfully");
		}	
		
		assessmentSchedule.clickIconX();
	}
	
	@Test(priority = 12,enabled = true)
	
		public void TT_16502() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Schedule | View List Attendee Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnRadioAssessmentSchedule();
		cloneForm.clickONbtnViewSchedulelist();
		cloneForm.clickOFFbtnCreateTestSchedule();
		cloneForm.clickOFFbtnEditTestSchedule();
		cloneForm.clickOFFbtnCancelTestSchedule();
		cloneForm.clickOFFbtnAssignAttendee();
		cloneForm.clickOFFbtnRemoveAttendee();
		cloneForm.clickOFFbtnViewTestReportTestSchedule();
		cloneForm.clickONBtnViewAttendeeListTestSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6. Access to Schedule");
//		assessment.searchName("Assessment7384");
		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Link Attende List");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
		}
						
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Cancel\r\n"
				+ "4. Icon Assign");
				
		if (assessmentSchedule.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessmentSchedule.isIconCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Cancel");
		}	
		
		if (assessmentSchedule.isIconAssignDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Assign");
		}
		
		TestLogger.info("7. Access to Attende List");
//		assessmentSchedule.searchName("Schedule8025");
		assessmentSchedule.searchName(DataManager.Schedule_TT_16452);
		assessmentSchedule.clickIconLinkAttendee();
	
		TestLogger.info("Expect : User CAN see/do: " + "List of Attende List");
		
		if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Attende List");
		}
					
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Assign User\r\n"
				+ "2. Button Delete");
				
		if (attendeeListSchedule.isBtnAssignmentUserDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Assign User");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Assign User");
		}
		
		if (attendeeListSchedule.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		attendeeListSchedule.clickIconX();
		assessmentSchedule.clickIconX();
	}
	
	@Test(priority = 13,enabled = true)
	
		public void TT_16465() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Dchedule | View & Assign Attendee Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtn2ndCollapse();
		
		cloneForm.clickONbtnRadioAssessmentSchedule();
		cloneForm.clickONbtnViewSchedulelist();
		cloneForm.clickOFFbtnCreateTestSchedule();
		cloneForm.clickOFFbtnEditTestSchedule();
		cloneForm.clickOFFbtnCancelTestSchedule();
		cloneForm.clickONbtnAssignAttendee();
		cloneForm.clickOFFbtnRemoveAttendee();
		cloneForm.clickOFFbtnViewTestReportTestSchedule();
		cloneForm.clickONBtnViewAttendeeListTestSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6.  Access to Schedule");
//		assessment.searchName("Assessment7384");
		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Icon Assign\r\n"
				+ "3. Link Attende List");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isIconAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Assign");
		}

		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
		}
						
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Cancel");
				
		if (assessmentSchedule.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessmentSchedule.isIconCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Cancel");
		}	
		
		TestLogger.info("7.  Access to Attende List");
//		assessmentSchedule.searchName("Schedule8025");
		assessmentSchedule.searchName(DataManager.Schedule_TT_16452);
		assessmentSchedule.clickIconLinkAttendee();
		
		if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
			setStatusTest("pass", "Access to Attende List");
		} else {
			setStatusTest("fail", "Not Access to Attende List");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Attende List\r\n"
				+ "2. Button Assign User");
			
		if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Attende List");
		}
		
		if (attendeeListSchedule.isBtnAssignmentUserDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Assign User");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Assign User");
		}
					
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Delete All");
				
		if (attendeeListSchedule.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("8. Open Assgin Attendee popup >> Assgin Employee");
		
		attendeeListSchedule.clickBtnAssignmentUser();
		
		if (assignAttendee.isLblAssignAttendeeDisplayed() == true) {
			setStatusTest("pass", "Access to Assgin Attendee popup");
		} else {
			setStatusTest("fail", "Not Access to Assgin Attendee popup");
		}

		assignAttendee.clickCboxAllLeft();
		assignAttendee.clickBtnMove();
		assignAttendee.clickBtnAssign();
			
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User added to schedule successfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User added to schedule successfully");
		}	
		
		attendeeListSchedule.clickIconX();
		assessmentSchedule.clickIconX();
}	
	
	@Test(priority = 14,enabled = true)
		
			public void TT_16467() throws InterruptedException {
			TestLogger.info("1. Login with account.");
			
			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		
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
			
			TestLogger.info("3. Update Function Set| Assessment - Schedule | View & Remove attendee Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			cloneForm.clickTabControlBoard();
			cloneForm.clickSubTabLearningDevelopment();
			cloneForm.clickCboxCustomization();
			cloneForm.clickCboxSubCustomization();
			cloneForm.clickBtnCollapse();
			cloneForm.clickBtn2ndCollapse();
			
			cloneForm.clickONbtnRadioAssessmentSchedule();
			cloneForm.clickONbtnViewSchedulelist();
			cloneForm.clickOFFbtnCreateTestSchedule();
			cloneForm.clickOFFbtnEditTestSchedule();
			cloneForm.clickOFFbtnCancelTestSchedule();
			cloneForm.clickOFFbtnAssignAttendee();
			cloneForm.clickONbtnRemoveAttendee();
			cloneForm.clickOFFbtnViewTestReportTestSchedule();
			cloneForm.clickONBtnViewAttendeeListTestSchedule();
			cloneForm.fillTxtDescription(DataManager.FunctionSet);
			cloneForm.clickBtnSave();
			
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
			
			loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("5. Access to Assessment >>  Open a Category");
			
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
					
			TestLogger.info("6.  Access to Schedule");
//			assessment.searchName("Assessment7384");
			assessment.searchName(DataManager.Assessment_TT_16450);
			assessment.clickIconScheduleFirstItem();
			
			if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "Access to Schedule");
			} else {
				setStatusTest("fail", "NOT Access to Schedule");
			}
					
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Schedule\r\n" 
					+ "2. Link Attende List");
			
			if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
			}
			
			if (assessmentSchedule.isIconLinkAttendeeDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
			}
							
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Icon Edit\r\n"
					+ "2. Button Create\r\n"
					+ "3. Icon Cancel\r\n"
					+ "4. Icon Assign");
					
			if (assessmentSchedule.isIconEditDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
			}
			
			if (assessmentSchedule.isIconAssignDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Assign");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Assign");
			}
			
			if (assessmentSchedule.isBtnAddDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
			}
			
			if (assessmentSchedule.isIconCancelDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Cancel");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Cancel");
			}	
			
			TestLogger.info("7.  Access to Attende List");
//			assessmentSchedule.searchName("Schedule8025");
			assessmentSchedule.searchName(DataManager.Schedule_TT_16452);
			assessmentSchedule.clickIconLinkAttendee();
			
			if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
				setStatusTest("pass", "Access to Attende List");
			} else {
				setStatusTest("fail", "Not Access to Attende List");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Attende List\r\n"
					+ "2. Button Delete");
				
			if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Attende List");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Attende List");
			}
			
			if (attendeeListSchedule.isBtnDeleteAllDisplayed() == true) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Delete All");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete All");
			}
						
			TestLogger.info("Expect : User CANNOT see/do: " + "Button Assign User");
					
			if (attendeeListSchedule.isBtnAssignmentUserDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Assign User");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Assign User");
			}
			
			TestLogger.info("8. Remove User");
			
			attendeeListSchedule.clickCboxAll();
			attendeeListSchedule.clickBtnDeleteAll();
			attendeeListSchedule.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Attendee deleted successfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Attendee deleted successfully");
			}	
			
			attendeeListSchedule.clickIconX();
			assessmentSchedule.clickIconX();
	}

	@Test(priority = 15,enabled = true)
	
		public void TT_16462() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Schedule | View & Cancel Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtn2ndCollapse();
		
		cloneForm.clickONbtnRadioAssessmentSchedule();
		cloneForm.clickONbtnViewSchedulelist();
		cloneForm.clickOFFbtnCreateTestSchedule();
		cloneForm.clickOFFbtnEditTestSchedule();
		cloneForm.clickONbtnCancelTestSchedule();
		cloneForm.clickOFFbtnAssignAttendee();
		cloneForm.clickOFFbtnRemoveAttendee();
		cloneForm.clickOFFbtnViewTestReportTestSchedule();
		cloneForm.clickOFFBtnViewAttendeeListTestSchedule();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6.  Access to Schedule");
//		assessment.searchName("Assessment7384");
		assessment.searchName(DataManager.Assessment_TT_16450);
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Schedule");
		}
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Schedule\r\n" 
				+ "2. Icon Cancel");
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Schedule");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Schedule");
		}
		
		if (assessmentSchedule.isIconCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Cancel");
		}
						
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Button Create\r\n"
				+ "3. Icon Assign\r\n"
				+ "4. Link Attende List");
				
		if (assessmentSchedule.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (assessmentSchedule.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (assessmentSchedule.isIconAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Assign");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Assign");
		}	
		
		if (assessmentSchedule.isIconLinkAttendeeDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do: " + "Link Attende List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Attende List");
		}
		
		TestLogger.info("7. Cancel Schedule");
//		assessmentSchedule.searchName("Schedule01441");
		assessmentSchedule.searchName(DataManager.Schedule_TT_16452);
		assessmentSchedule.clickIconCancel();
		assessmentSchedule.clickBtnYes();
		
		if (assessmentSchedule.isLblCancelledDisplayed() == true) {
			setStatusTest("pass", "Cancel Schedule Success");
		} else {
			setStatusTest("fail", "Cancel Schedule NOT Success");
		}	
		
		TestLogger.info("8. Delete Test");
		
		assessmentSchedule.clickIconX();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		assessment.deleteSingle2nd();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Test deleted successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Test deleted successfully");
		}
	}
	
	@Test(priority = 16,enabled = true)
	
		public void TT_16504() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Attendee list | No View Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnRadioAssessmentGeneralSettings();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioAttendeelist();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
		
		TestLogger.info("6. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
		
		createSkillTest.fillTitle(DataManager.Assessment_TT_16504);
		createSkillTest.fillDescription(DataManager.Assessment_TT_16504);
		createSkillTest.fillCategory("t");
		
		createSkillTest.clickBtnThumbnail();
		
		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("7. Next to Testing settings tab >> Next to Question tab");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	
		
		createSkillTest.clickDrplistRestriction();
		createSkillTest.clickItemPublic();

		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		TestLogger.info("8. Input data on Question tab >> Click on button Save");
						
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
		
		TestLogger.info("9. Access to Attendee list");
		
		assessment.searchName(DataManager.Assessment_TT_16504);
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Attendee List");
		
		if (assessment.isIconAttendeeFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Attendee List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Attendee List");
		}
	}
	
	@Test(priority = 17,enabled = true)
	
		public void TT_16469() throws InterruptedException {
		TestLogger.info("1. Login with account.");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
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
		
		TestLogger.info("3. Update Function Set| Assessment - Attendee list  | View List Attendee & View List of Attendee Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnRadioAttendeelist();
		cloneForm.clickOFFbtnViewAssessmentReportAttendeeList();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("5. Access to Assessment >>  Open a Category");
		
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
				
		TestLogger.info("6.  Access to Attendee List");
//		assessment.searchName("Assessment9583");
		assessment.searchName(DataManager.Assessment_TT_16504);
		assessment.clickIconAttendeeFirstItem();
		
		TestLogger.info("Expect : User CAN see/do: " + "Access to Attendee List");
		
		if (attendeeList.isLblAttendeeListDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do: " + "Access to Attendee List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Access to Attendee List");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon View Result");
		
		if (attendeeList.isIconViewResultDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon View Result");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon View Result");
		}
		
		TestLogger.info("7. Delete Skill Test");
		
		attendeeList.clickIconX();
		assessment.clickCboxAll();
		assessment.clickBtnDeleteAll();
		assessment.clickBtnYes();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test deleted successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test deleted successfully");
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
