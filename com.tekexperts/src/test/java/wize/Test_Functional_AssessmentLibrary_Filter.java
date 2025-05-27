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
import controller.WebDriversManager;
import wize.pages.Assessment;
import wize.pages.AssessmentLibrary;
import wize.pages.ControlBoard;
import wize.pages.DashBoard;
import wize.pages.Form_CreateAdaptiveTest;
import wize.pages.Form_CreateComplianceTest;
import wize.pages.Form_CreateSkillTest;
import wize.pages.LoginScreen;
import wize.pages.MyData;
import wize.pages.MyData_Contact;
import wize.pages.MySpace;
import wize.pages.Tab_Assessment;

public class Test_Functional_AssessmentLibrary_Filter extends TestManager {
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
	
	Assessment assessment;
	Form_CreateAdaptiveTest createAdaptiveTest;
	Form_CreateComplianceTest createComplianceTest;
	Form_CreateSkillTest createSkillTest;
	
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
		createAdaptiveTest = new Form_CreateAdaptiveTest(driver);
		createComplianceTest = new Form_CreateComplianceTest(driver);
		createSkillTest = new Form_CreateSkillTest(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_12571_TT_12573_TT_12574() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to tab Assessment >> Test Library");

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
		
		TestLogger.info("3. Open Filter popup >> Close Pop-up");
		
		tabAssessment.clickTabAssessmentLibrary();
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.clickIconX();
		
		TestLogger.info("User CAN see/do: " + "Close Pop-up");
		
		if (assessmentLibrary.isLblFilterDisplayed() == false) {
			setStatusTest("pass", "Close Pop-up");
		} else {
			setStatusTest("fail", "NOT Close Pop-up");
		}
						
		TestLogger.info("4. Open Filter popup >> Check Reset button");
		
		assessmentLibrary.clickBtnFilter();
		
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtCategory(DataManager.FunctionSet);
		
		if (assessmentLibrary. isIconXCategoryDisplayed() == true) {
			setStatusTest("pass", "Select Category success");
		} else {
			setStatusTest("fail", "NOT Select Category success");
		}
	
		assessmentLibrary.clickBtnReset();
		
		TestLogger.info("User CAN see/do: " + "Reset success");
		
		if (assessmentLibrary. isIconXCategoryDisplayed() == false) {
			setStatusTest("pass", "Reset success");
		} else {
			setStatusTest("fail", "NOT Reset success");
		}
		
		TestLogger.info("5. Check Save button");
		
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "Save Success");
		
		if (assessmentLibrary. isLblFilterDisplayed() == false) {
			setStatusTest("pass", "Save Success");
		} else {
			setStatusTest("fail", "NOT Save Success");
		}
	}
	
	@Test(priority = 2)

	public void TT_12577_TT_12597() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to tab Assessment >> Test Library");

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
		
		TestLogger.info("3. Open Filter popup >> Search Test Name valid >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtName("Test");
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "System display value");
		} else {
			setStatusTest("fail", "System NOT display value");
		}
		
		TestLogger.info("4. Open Filter popup >> Search Test Name invalid >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtName("System no display value");
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System no display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == false) {
			setStatusTest("pass", "System NOT display value");
		} else {
			setStatusTest("fail", "System display value");
		}
	}
	
	@Test(priority = 3)

	public void TT_12624_TT_12625() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to tab Assessment >> Test Library");

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
		
		TestLogger.info("3. Open Filter popup >> Search Test Description valid >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtDescription("Test");
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "System display value");
		} else {
			setStatusTest("fail", "System NOT display value");
		}
		
		TestLogger.info("4. Open Filter popup >> Search Test Description invalid >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtDescription("System no display value");
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System no display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == false) {
			setStatusTest("pass", "System NOT display value");
		} else {
			setStatusTest("fail", "System display value");
		}
	}
	
	@Test(priority = 4)

	public void TT_12716_TT_12717() throws InterruptedException 
	{
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

		TestLogger.info("4. Open create Skill Test 1");

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
	
		if (createAdaptiveTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
				} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		createSkillTest.clickBtnNextInfo();

		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}
		
		createSkillTest.clickDrplistRestriction();
		
		createSkillTest.clickItemApprovalRequested();
		
		createSkillTest.clickBtnRadioAssessmentSettings();

		createSkillTest.clickBtnNextTesting();
	
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
			setStatusTest("pass", "Displays msg: " + "Skill Test created successfully");
		} else {
			setStatusTest("fail", "NOT displays msg: " + "Skill Test created successfully");
		}
		
		TestLogger.info("5. Access to tab Assessment >> Test Library");

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
		
		TestLogger.info("6. Open Filter popup >> Search 1 value into Category >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtCategory(DataManager.FunctionSet);
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "System display value");
		} else {
			setStatusTest("fail", "System NOT display value");
		}
		
		TestLogger.info("7. Open Filter popup >> Search multiple value into Category");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtCategory2("a");
		
		TestLogger.info("User CAN see/do: " + "System display items with comma to separate each item");
		
		if (assessmentLibrary. isIconXCategoryDisplayed() == true) {
			setStatusTest("pass", "System display items with comma to separate each item");
		} else {
			setStatusTest("fail", "System NOT display items with comma to separate each item");
		}	
		
		assessmentLibrary.clickIconX();
	}
	
	@Test(priority = 5)

	public void TT_12720() throws InterruptedException 
	{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to tab Assessment >> Test Library");

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
		
		TestLogger.info("3. Open Filter popup >> Search 1 value into Owner >> Check data");
		
		assessmentLibrary.clickBtnFilter();
				
		if (assessmentLibrary. isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Open Filter popup");
		} else {
			setStatusTest("fail", "NOT Open Filter popup");
		}
		
		assessmentLibrary.fillTxtOnwer(PropertyManager.EmailAdmin);
		assessmentLibrary.clickBtnAplly();
		
		TestLogger.info("User CAN see/do: " + "System display value");
		
		if (assessmentLibrary. isItemTestFirstDisplayed() == true) {
			setStatusTest("pass", "System display value");
		} else {
			setStatusTest("fail", "System NOT display value");
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
