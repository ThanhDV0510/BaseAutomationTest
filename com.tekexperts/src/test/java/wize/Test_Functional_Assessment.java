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
import Ulties.TienIch;
import controller.ScreenController;
import controller.WebDriversManager;
import wize.pages.Assessment;
import wize.pages.AssessmentSchedule;
import wize.pages.ControlBoard;
import wize.pages.Form_AssignAttendee;
import wize.pages.Form_CreateAdaptiveTest;
import wize.pages.Form_CreateComplianceTest;
import wize.pages.Form_CreateSkillTest;
import wize.pages.Form_CreateTestSchedule;
import wize.pages.Form_EditAdaptiveTest;
import wize.pages.Form_EditComplianceTest;
import wize.pages.Form_EditSkillTest;
import wize.pages.Form_EditTestSchedule;
import wize.pages.Form_TestScheduleDetail;
import wize.pages.LoginScreen;

public class Test_Functional_Assessment extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;

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
		imageCotainer = new ImageCotainer();
		screen = new Screen();
		s = new ScreenController(screen);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = false)

	public void Create_Edit_Delete_Category() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("3. Create New Caterogy");

		assessment.fillSearchCategory(DataManager.Functional);

		if (assessment.isFirstCategoryDisplayed() == true) {
			assessment.clickIconDeleteCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
			}

			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}

		} else {
			assessment.clickBtnCreateCategory();

			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}

			assessment.fillCategoryName(DataManager.Functional);
			assessment.clickBtnSaveCreate();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Test category created sucessfully");
			}
		}

		TestLogger.info("4. Update Category");

		assessment.clickIconEditCategory();

		if (assessment.isLblEditCategoryDisplayed() == true) {
			setStatusTest("pass", "Open Eit Category popup");
		} else {
			setStatusTest("fail", "NOT Open Eit Category popup");
		}

		assessment.fillUpdateCategoryName("1");
		assessment.clickBtnSaveUpdateCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Test category updated success");
		} else {
			setStatusTest("fail", "Test category updated NOT success");
		}

		TestLogger.info("5. Delete Category");

		assessment.clickIconDeleteCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Test category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Test category deleted successfully");
		}

	}

	@Test(priority = 2, enabled = false)

	public void Create_AdaptiveTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("4. Open create Adaptive Test >> Input data on Basic Information tab");

		assessment.clickBtnCreateAssessment();
		assessment.clickItemAdaptiveTest();

		if (createAdaptiveTest.isLblCreateAdaptiveTestProfilelDisplayed() == true) {
			setStatusTest("pass", "Access to Create Adaptive Test");
		} else {
			setStatusTest("fail", "Not Access to Create Adaptive Test");
		}

		String name = "Assessment" + TienIch.taoRandomSo(3);

		createAdaptiveTest.fillTitle(name);
		createAdaptiveTest.fillDescription(name);
		createAdaptiveTest.fillCategory("t");

		createAdaptiveTest.clickBtnThumbnail();

		s.clickOn(ImageCotainer.btnDesktop);
		s.clickOn(ImageCotainer.fileTest);
		s.clickOn(ImageCotainer.btnOpen);

		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
		} else {
			setStatusTest("fail", "Import NOT Success");
		}

		TestLogger.info("5. Next to Testing settings tab");

		createAdaptiveTest.clickBtnNextInfo();

		if (createAdaptiveTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}

		TestLogger.info("6. Next to Question tab");

		createAdaptiveTest.clickBtnNextTesting();
		;

		if (createAdaptiveTest.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		TestLogger.info("7. Input data on Question tab");

		createAdaptiveTest.clickDrplistQuestionPool1();
		createAdaptiveTest.clickItemCompetency1();

		createAdaptiveTest.clickDrplistSkill1("Test Automation 1");
		createAdaptiveTest.clickItemSkill1();

		TestLogger.info("8. Click on button Save");

		createAdaptiveTest.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Adaptive Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Adaptive Test created successfully");
		}
	}

	@Test(priority = 3, enabled = false)

	public void Update_AdaptiveTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("4. Open Edit Adaptive Test");

		assessment.clickIconEditFirstItem();

		if (editAdaptiveTest.isLblEditAdaptiveTestProfilelDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Adaptive Test");
		} else {
			setStatusTest("fail", "Not Access to Edit Adaptive Test");
		}

		TestLogger.info("5. Next to Testing settings tab");

		editAdaptiveTest.clickBtnNext();

		if (editAdaptiveTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}

		TestLogger.info("6. Next to Question tab");

		editAdaptiveTest.clickBtnNext();

		if (editAdaptiveTest.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		TestLogger.info("7. Update data on Question tab");

		editAdaptiveTest.clickBtnAddQuestion1();

		if (editAdaptiveTest.isBtnAddQuestion2lDisplayed() == true) {
			setStatusTest("pass", "Add Success Question 1");
		} else {
			setStatusTest("fail", "Not Add Success Question 1");
		}

		editAdaptiveTest.clickDrplistQuestionPool2();
		editAdaptiveTest.clickItemCompetency2();

		editAdaptiveTest.clickDrplistSkill2("Test Automation 2");
		editAdaptiveTest.clickItemSkill2();

		if (editAdaptiveTest.isBtnRemoveQuestion2lDisplayed() == true) {
			setStatusTest("pass", "Add Success Question 2");
		} else {
			setStatusTest("fail", "Not Add Success Question 2");
		}

		TestLogger.info("8. Click on button Save");

		editAdaptiveTest.clickBtnSave();

		if (editAdaptiveTest.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Open Confirmation popup");
		}

		editAdaptiveTest.clickBtnYes();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Adaptive Test updated successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Adaptive Test updated successfully");
		}
	}

	@Test(priority = 4, enabled = false)

	public void Delete_AdaptiveTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("4. Delete Adaptive Test");

		assessment.clickIconDeleteFirstItem();
		assessment.clickBtnYes();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Adaptive Test deleted successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Adaptive Test deleted successfully");
		}
	}

	@Test(priority = 5, enabled = false)

	public void Create_SkillTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}

		String name = "Assessment" + TienIch.taoRandomSo(3);

		createSkillTest.fillTitle(name);
		createSkillTest.fillDescription(name);
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

		TestLogger.info("5. Next to Testing settings tab");

		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}

		TestLogger.info("6. Next to Question tab");

		createSkillTest.clickBtnNextTesting();
		;

		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		TestLogger.info("7. Input data on Question tab");

		createSkillTest.clickDrplistDimensionValue("Assessment Skill Test");
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
	}

	@Test(priority = 6, enabled = false)

	public void Update_SkillTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("4. Open Edit Skill Test");

		assessment.clickIconEditFirstItem();

		if (editSkillTest.isLblEditSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Adaptive Test");
		} else {
			setStatusTest("fail", "Not Access to Edit Adaptive Test");
		}

		TestLogger.info("5. Next to Testing settings tab >> Update data on Testing settings tab");

		editSkillTest.clickBtnNext();

		if (editSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}

		editSkillTest.clickCboxCompetency();

		TestLogger.info("6. Next to Question tab");

		editSkillTest.clickBtnNext();
		;

		if (editSkillTest.isLblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}

		TestLogger.info("7. Click on button Save");

		editSkillTest.clickBtnSave();

		if (editSkillTest.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Open Confirmation popup");
		}

		editSkillTest.clickBtnYes();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Adaptive Test updated successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Adaptive Test updated successfully");
		}
	}

	@Test(priority = 7, enabled = false)

	public void Delete_SkillTest() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

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

		TestLogger.info("4. Delete Skill Test");

		assessment.clickIconDeleteFirstItem();
		assessment.clickBtnYes();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Skill Test deleted successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test deleted successfully");
		}
	}

	@Test (priority = 8, enabled = false)
	public void TT20575_TT20576_TT20577(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Access to a Category");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		TestLogger.info("4. Click on link assessment name");
		if(assessment.isFirstLinkAssessmentDisplayed()){
			assessment.clickFirstLinkAssessment();
			if(assessment.isTitleDetailDisplayed()){
				setStatusTest("pass", "Assessment name is displayed as a hyperlink \n TT20575 + TT20576 are PASSED");
				assessment.clickCloseDetailForm();
			}else{
				setStatusTest("fail", "Assessment name is NOT displayed as a hyperlink \n TT20575 + TT20576 are FAILED");
			}
		}else{
			System.out.println("there is no item in the table");
		}
		TestLogger.info("5. Check tooltip btn Delete All");
		if(assessment.getTooltipBtnDeleteAll().equals("Delete all selected assessments")){
			setStatusTest("pass", "Tooltip is correct");
		}else{
			setStatusTest("fail", "Tooltip is NOT correct");
		}
		TestLogger.info("6. Check status btn Delete All when no assessment is selected");
		if(!assessment.isBtnDeleteAllEnable()){
			setStatusTest("pass", "Btn Delete All is disable");
		}else{
			setStatusTest("fail", "Btn Delete All is enable");
		}
		assessment.clickCboxSingle();
		assessment.clickBtnDeleteAll();
		if(assessment.isLblConfirmationDisplayed()){
			if(assessment.isContentPopupConfirmCorrect()){
				setStatusTest("pass", "Content of confirmation is correct");
			}else{
				setStatusTest("fail", "Content of confirmation is NOT correct");
			}
		}else{
			setStatusTest("fail", "Not display deletion confirmation popup \n TT20577 is FAILED");
		}
		TestLogger.info("7. Click NO in popup >> Close popup");
		assessment.clickBtnNo();
		assessment.clickFirstLinkAssessment();
		if(assessment.isTitleDetailDisplayed()){
			setStatusTest("pass", "Confirmation popup is closed");
			assessment.clickCloseDetailForm();
		}else{
			setStatusTest("fail", "Confirmation popup is NOT closed");
		}
		TestLogger.info("8. Click YES in popup >> Delete successfully");
		String asName1 = assessment.getTextFirstAssessment();
		assessment.deleteAll();
		assessment.searchName(asName1);
		if(assessment.isFirstLinkAssessmentDisplayed()){
			setStatusTest("fail", "Can not delete selected assessment  \n TT20577 is FAILED");
		}else{
			setStatusTest("pass", "Delete selected assessment  \n TT20577 is PASSED");
		}
		TestLogger.info("9. Expected: checkbox is hideen with deleted assessment");
		assessment.clickClearFilterAssessmentName();
		assessment.clickClearFilterStatus();
		assessment.filterStatus("Deleted");
		if(assessment.isCboxSingleClickable()){
			setStatusTest("fail", "Checkbox is still displayed \n TT20578 is FAILED");
		}else{
			setStatusTest("pass", "Checkbox is NOT displayed \n TT20578 is PASSED");
		}
	}
	
	@Test (priority = 9, enabled = true)
	public void TT20579_TT20645_TT21064(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Access to a Category");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		TestLogger.info("4. Filter with Type = Adaptive");
		assessment.selectTypeAdaptive();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterAdaptiveCorrect()){
				setStatusTest("pass", "Filter Adaptive is correct");
			}else{
				setStatusTest("fail", "Filter Adaptive is NOT correct");
			}
		}else{
			System.out.println("No data.");
		}
		TestLogger.info("5. Filter with Type = Compliance");
		assessment.selectTypeCompliance();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterComplianceCorrect()){
				setStatusTest("pass", "Filter Compliance is correct");
			}else{
				setStatusTest("fail", "Filter Compliance is NOT correct");
			}
		}else{
			System.out.println("No data.");
		}
		TestLogger.info("6. Filter with Type = Skill");
		assessment.selectTypeSkill();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterSkillCorrect()){
				setStatusTest("pass", "Filter Skill is correct \n TT20579 is PASSED");
			}else{
				setStatusTest("fail", "Filter Skill is NOT correct \n TT20579 is FAILED");
			}
		}else{
			System.out.println("No data.");
		}
		assessment.clickClearFilterAssessmentType();
		System.out.println("==================");
		TestLogger.info("7. Filter with Restriction = Approval Request");
		assessment.selectRestrictionAppReq();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterAppRequestCorrect()){
				setStatusTest("pass", "Filter Restriction = Approve Request is correct");
			}else{
				setStatusTest("fail", "Filter Restriction = Approve Request is NOT correct");
			}
		}else{
			System.out.println("No data.");
		}
		TestLogger.info("7. Filter with Restriction = Manually Assign");
		assessment.selectRestrictionManAssign();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterManAssignCorrect()){
				setStatusTest("pass", "Filter Restriction = Manually Assign is correct");
			}else{
				setStatusTest("fail", "Filter Restriction = Manually Assign is NOT correct");
			}
		}else{
			System.out.println("No data.");
		}
		TestLogger.info("7. Filter with Restriction = Public");
		assessment.selectRestrictionPublic();
		if(assessment.isFirstLinkAssessmentDisplayed()){
			if(assessment.isFilterPublicCorrect()){
				setStatusTest("pass", "Filter Restriction = Public is correct \n TT20645 is PASSED");
			}else{
				setStatusTest("fail", "Filter Restriction = Public is NOT correct \n TT20645 is FAILED");
			}
		}else{
			System.out.println("No data.");
		}
		assessment.clickClearFilterRestriction();
		TestLogger.info("8. Compare tooltip of current version selection");
		if(assessment.getTooltipVersionFilter().equals("Current Version")){
			setStatusTest("pass", "Tooltip of current version is correct");
		}else{
			setStatusTest("fail", "Tooltip of current version is NOT correct");
		}
		assessment.selectOptionAllVersion();
		if(assessment.getTooltipVersionFilter().equals("All Version")){
			setStatusTest("pass", "Tooltip of All version is correct");
		}else{
			setStatusTest("fail", "Tooltip of All version is NOT correct");
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
