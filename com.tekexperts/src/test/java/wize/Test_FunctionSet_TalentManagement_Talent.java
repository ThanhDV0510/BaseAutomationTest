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
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EmployeeDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.TalentManagement;
import wize.pages.TalentManagement_Employee;
import wize.pages.TalentManagement_Talent;
import wize.pages.Talent_Competency;
import wize.pages.UserManagement;

public class Test_FunctionSet_TalentManagement_Talent extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	
	Form_EmployeeDetails employeeDetais;
	TalentManagement_Employee talentEmployee;
	TalentManagement_Talent talentTalent;
	TalentManagement talent;
	Talent_Competency talentCompetency;
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
		userManagement = new UserManagement(driver);
		
		employeeDetais = new Form_EmployeeDetails(driver);
		talentEmployee = new TalentManagement_Employee(driver);
		talentTalent = new TalentManagement_Talent(driver);
		talentCompetency = new Talent_Competency(driver);
		talent = new TalentManagement(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 3,enabled = false)

	public void TT25643 () throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Talent Management - Talent | Full Permission ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
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
		
		TestLogger.info("5. Access to Talent Management");

		controlBoard.clickTabTalentManagement();
		TestLogger.info("Expect : User CAN see/do: " + "User CAN See/Do: Data table cards");
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table cards");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table cards");
		}
		
		TestLogger.info("6. Access to Talent Management - Employee");
		
		talent.clickTabTalent();
		
		if (talentTalent.isSubTabCompetencyDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management - Employee");
		} else {
			setStatusTest("fail", "NOT Access to Talent Management - Employee");
		}
	}

	@Test(priority = 2, enabled = false)

	public void TT25644() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Talent Management - Talent | VIEW Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");

		controlBoard.clickTabTalentManagement();
		
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "User CAN See/Do: Data table cards");
		
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table cards");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table cards");
		}
		
		TestLogger.info("6. Access to Talent Management - Employee");
		
		talent.clickTabTalent();
		
		if (talentTalent.isSubTabCompetencyDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management - Employee");
		} else {
			setStatusTest("fail", "NOT Access to Talent Management - Employee");
		}
}
		
	@Test(priority = 1,enabled = false)

	public void TT25645() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Talent Management - Talent | NO view Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		
		cloneForm.clickSubTabTalent();
		cloneForm.clickOFFBtnRadioCompetency();

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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");

		controlBoard.clickTabTalentManagement();
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Sub Tab Talent");
		
		if (talentTalent.isSubTabCompetencyDisplayed() == false) {
			setStatusTest("pass","User CANNOT see/do: " + "Sub Tab Talent");
		} else {
			setStatusTest("fail","User CAN see/do: " + "Sub Tab Talent");
		}
}
	
	@Test (priority = 4, enabled = true)
	public void TT25646_TT25642() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Talent Management - Employee | NO view Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickOFFBtnRadioEmployeeList();
		cloneForm.clickOFFbtnRadioData();
		
		cloneForm.clickSubTabPerformanceGrowth();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnRadioGoalChecking();
		
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnRadioCompetency();

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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");

		if(!controlBoard.isTabTalentManagementDisplayed()){
			setStatusTest("pass","Tab Talent Management is NOT displayed in the menu bar");
		}else{
			setStatusTest("fail","Tab Talent Management is displayed in the menu bar");
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
