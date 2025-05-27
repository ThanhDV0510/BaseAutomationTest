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
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
import wize.pages.Form_CreateFunctionSet;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EmployeeDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.TalentManagement;
import wize.pages.TalentManagement_Employee;
import wize.pages.UserManagement;

public class Test_FunctionSet_ControlBoardOnTopbar extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	Form_CreateFunctionSet createFunctionSet;
	UserManagement userManagement;
	
	Form_EmployeeDetails employeeDetais;
	TalentManagement_Employee talentEmployee;
	TalentManagement talent;
	Clone_Form_EditFunctionSet cloneForm;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
	
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		createFunctionSet = new Form_CreateFunctionSet(driver);
		userManagement = new UserManagement(driver);
		
		employeeDetais = new Form_EmployeeDetails(driver);
		talentEmployee = new TalentManagement_Employee(driver);
		talent = new TalentManagement(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = false)

	public void TT25694() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

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
		
		TestLogger.info("3. Update Function Set| ControlBoard on topbard | A view permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
			
		//Control board >> Question Pool
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxFullPermission();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();		
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
		
		TestLogger.info("5. User CAN See Control Board in the menu bar");
		
		if (controlBoard.isIconControlBoardDisplayed() == true) {
			setStatusTest("pass", "User CAN See Control Board in the menu bar");
		} else {
			setStatusTest("fail", "User CANNOT See Control Board in the menu bar");
		}
}
		
	@Test(priority = 2,enabled = false)

	public void TT25695() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

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
		
		TestLogger.info("3. Update Function Set| ControlBoard on topbard | Full view permissions");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
			
		//Control board >> Question Pool, talent-job, organization
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxFullPermission();
				
		//Talent Management >> Employee
		cloneForm.clickTabTalentManagement();
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
		
		TestLogger.info("5. User CAN See Control Board in the menu bar");
					
		if (controlBoard.isIconControlBoardDisplayed() == true) {
			setStatusTest("pass", "User CAN See Control Board in the menu bar");
		} else {
			setStatusTest("fail", "User CANNOT See Control Board in the menu bar");
		}
}
	
	@Test(priority = 3,enabled = true)
	
	public void TT25693() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");
	
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
		
		TestLogger.info("3. Update Function Set| ControlBoard on topbard | NOT any view permissions ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
			
		
		TestLogger.info("Controlboard >> Question Pool");
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickOFFbtnViewQuestionList();
		
		
		TestLogger.info("Controlboard >> Assessment Settings");
		cloneForm.clickBtnCollapse();
		
		cloneForm.clickOFFbtnRadioAssessmentGeneralSettings();
		cloneForm.clickOFFbtnRadioAssessmentSchedule();
		cloneForm.clickOFFbtnRadioAttendeelist();
		
		TestLogger.info("Control Board - System Settings >> Organization");
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFbtnViewDimensionList();
		
		TestLogger.info("Control Board - Talent >> Talent - Job");
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewJobList();
		
		TestLogger.info("Control Board - Talent >> Talent - Job Level");
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewJobLevelList();		
		
		TestLogger.info("Control Board - Talent >> Talent - Position");
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewPositionList();
		
		TestLogger.info("Control Board - System Settings >> Skill");
		cloneForm.clickBtnCollapse();	
		cloneForm.clickOFFbtnViewSkills();
		
		TestLogger.info("Control Board - Talent >> Talent - Baseline");
		
		cloneForm.clickBtnCollapse();
		
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		
		TestLogger.info("Control Board - Talent >> Talent - Goal Line");
		cloneForm.clickBtnCollapse();
		
		cloneForm.clickOFFbtnRadioPostionGoalLine();
		cloneForm.clickOFFbtnRadioJobGoalLine();
		cloneForm.clickOFFbtnRadioDimensionGoalLine();
		
		
		
		TestLogger.info("Control Board - System Settings >> General Settings");
		cloneForm.clickSubTabSystem();
		
		cloneForm.clickOFFbtnViewGeneralSettings();	
		cloneForm.clickOFFbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
		cloneForm.clickOFFbtnViewUserDefinedValues();
		cloneForm.clickOFFbtnUpdateUserDefinedValues();
		cloneForm.clickOFFbtnUpdateLearningURL();
		cloneForm.clickBtnCollapse();
		
		TestLogger.info("Control Board - System Settings >> User");
						
		cloneForm.clickOFFbtnViewUser();
		cloneForm.clickBtnCollapse();
		
		TestLogger.info("Control Board - System Settings >> Role");
		cloneForm.clickOFFbtnViewRole();
		cloneForm.clickBtnCollapse();
		
		TestLogger.info("Control Board - System Settings >> Function Set");
		cloneForm.clickOFFbtnViewFunctionSet();
		cloneForm.clickBtnCollapse();
		
		TestLogger.info("Control Board - System Settings >> Security Profile");
		cloneForm.clickOFFbtnViewSecurityProfile();
		cloneForm.clickBtnCollapse();
		
		TestLogger.info("Control Board - System Settings >> Content Management");
		cloneForm.clickOFFBtnViewWelcomeLetter();
		
		TestLogger.info("Talent Management >> Employee");
		cloneForm.clickTabTalentManagement();
		cloneForm.clickSubTabEmployee();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
						
		cloneForm.clickOFFBtnRadioEmployeeList();	
		cloneForm.clickOFFBtnRadioPersonal();
		cloneForm.clickOFFBtnRadioContract();	
		cloneForm.clickOFFBtnRadioPosition();
		cloneForm.clickOFFBtnRadioOrganizationChart();	
		
		TestLogger.info("Talent Management >> Talent");
		cloneForm.clickSubTabTalent();
		cloneForm.clickOFFBtnViewTeamCompetency();
		
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		
		TestLogger.info("5. User CANNOT See Control Board in the menu bar");
		
		if (controlBoard.isIconControlBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT See Control Board in the menu bar");
		} else {
			setStatusTest("fail", "User CAN See Control Board in the menu bar");
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
