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
import wize.pages.Form_CreateJobLevel;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditJobLevel;
import wize.pages.Form_EditUser;
import wize.pages.Form_JobLevelDetails;
import wize.pages.FunctionSet;
import wize.pages.JobLevelList;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_JobLevel extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	JobLevelList jobLevelList;
	Form_JobLevelDetails formJobLevelDetails;
	Form_CreateJobLevel formCreateJobLevel;
	Form_EditJobLevel formEditJobLevel;
	Form_EditUser editUser;
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
		jobLevelList = new JobLevelList(driver);
		formJobLevelDetails = new Form_JobLevelDetails(driver);
		formCreateJobLevel = new Form_CreateJobLevel(driver);
		formEditJobLevel = new Form_EditJobLevel(driver);
		editUser = new Form_EditUser(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)

	public void TT25115_TT25116_TT25126() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
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
		TestLogger.info("5. Access to Job Level ");
		
		TestLogger.info("Expect : User CAN see/do: " + "hyperlink Job Level in Control Board");
		
		if (controlBoard.isLblJobLevelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CAN see/do Job Level subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Access to Job Level ");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level ");
		} else {
			setStatusTest("fail", "Not Access to Job Level ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n" 
				+ "2. Button Create");
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		
		if (jobLevelList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("8. Create New Job Level");
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
		
		if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
		{
			jobLevelList.deleteJobLevel();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Job Level deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Job Level deleted successfully");
			}
			
			jobLevelList.clickBtnCreate();;
			
			if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreateJobLevel.inputData(DataManager.Functional,DataManager.Test);
			formCreateJobLevel.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Job Level created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
			}			
		}
		else
		{
			jobLevelList.clickBtnCreate();;
			
			if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreateJobLevel.inputData(DataManager.Functional,DataManager.Test);
			formCreateJobLevel.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Job Level created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
			}
		}
		
		TestLogger.info("9. Hover on every Job Level in list");
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (jobLevelList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (jobLevelList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("10. Update Job Level");
		
		jobLevelList.clickIconEdit();
		
		if (formEditJobLevel.isLblEditJobLevelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		
		formEditJobLevel.fillDescription(DataManager.Test);
		formEditJobLevel.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job Level updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job Level updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job Level updated successfully");
		}
		
		TestLogger.info("11. Delete Job Level");
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
		jobLevelList.deleteJobLevel();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job Level deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job Level deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job Level deleted successfully");
		}
		TestLogger.info("12. Click icon Control Board >> Access Job via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "JobLevel/Index");
		if(!controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User can access normally");
		}else{
			setStatusTest("fail", "User CANNOT access normally");
		}
	}

	@Test(priority = 2, enabled = true)

	public void TT25113_TT25114() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job Level | NO VIEW Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONbtnViewDimensionList();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewJobLevelList();
		cloneForm.clickOFFbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickOFFbtnEditJobLevel();
		cloneForm.clickOFFbtnDeleteJobLevel();
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
		TestLogger.info("5. Access to Job Level ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		
		if (controlBoard.isLblJobLevelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Job Level subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Job Level via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "JobLevel/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Job list");
		}else{
			setStatusTest("fail", "User CAN access normally");
		}
}
		
	@Test(priority = 3, enabled = true)

	public void TT25121() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Job Level >> Delete old data");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level ");
		} else {
			setStatusTest("fail", "Not Access to Job Level ");
		}
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
		
		if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
		{
			jobLevelList.deleteJobLevel();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Job Level deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Job Level deleted successfully");
			}
		}

		TestLogger.info("3. Access to Function Set");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("4. Update Function Set|Job Level | View & Create Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickONbtnCreateJobLevel();
		cloneForm.clickOFFbtnEditJobLevel();
		cloneForm.clickOFFbtnDeleteJobLevel();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
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
		
		TestLogger.info("6. Access to Job Level ");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level ");
		} else {
			setStatusTest("fail", "Not Access to Job Level ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n" 
				+ "2. Button Create");
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		
		if (jobLevelList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
						
		TestLogger.info("7. Create New Job Level");
		
		jobLevelList.clickBtnCreate();
		
		if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		formCreateJobLevel.inputData(DataManager.Functional,DataManager.Test);
		formCreateJobLevel.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job Level created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
		}
			
		TestLogger.info("8. Hover on every Job Level in list");
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
					
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (jobLevelList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (jobLevelList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
}
	
	@Test(priority = 4, enabled = true)

	public void TT25122() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job Level | View & Edit Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickONbtnEditJobLevel();
		cloneForm.clickOFFbtnDeleteJobLevel();
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
		
		TestLogger.info("5. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level ");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Job Level ");
				
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
			
		if (jobLevelList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
						
		TestLogger.info("6. Hover on every Job Level in list");
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Edit");
		
		if (jobLevelList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Delete");
		
		if (jobLevelList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
			
		TestLogger.info("7. Update Job Level List");
		
		jobLevelList.clickIconEdit();
		
		if (formEditJobLevel.isLblEditJobLevelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		
		formEditJobLevel.fillDescription(DataManager.Test);
		formEditJobLevel.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job Level updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job Level updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job Level updated successfully");
		}
}
	
	@Test(priority = 5, enabled = true)

	public void TT22123() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickOFFbtnEditJobLevel();
		cloneForm.clickONbtnDeleteJobLevel();
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
		
		TestLogger.info("5. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n" 
				+ "2. Button Delete");
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
				
		if (jobLevelList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
			
		TestLogger.info("6. Hover on every Job in list");
		
		jobLevelList.fillSearchJobLevel(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		
		if (jobLevelList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (jobLevelList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("7. Delete Job Level");
		
		jobLevelList.deleteJobLevel();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job Level deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job Level deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job Level deleted successfully");
		}
	}

	@Test(priority = 6, enabled = true)
	public void TT25117_TT25118_TT_25120(){
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
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxViewOnly();
		cloneForm.clickCboxSubViewOnly();
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
		TestLogger.info("5. Access to Job Level ");
		TestLogger.info("Expect : User CAN see/do: " + "hyperlink Job Level in Control Board");
		if (controlBoard.isLblJobLevelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CAN see/do Job Level subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n" );
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		TestLogger.info("8. Hover on every Job in list");
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		if (!jobLevelList.isIconDeleteDisplayed()) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (jobLevelList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("9. User can view Job level detail");
		
		if(jobLevelList.isLinkFirstJobLevelClickable()){
			setStatusTest("pass", "User CAN click on Job level link");
		}else{
			setStatusTest("fail", "user CANNOT see Job level detail");
		}
		if(formJobLevelDetails.isLblJobLevelDetailssDisplayed()){
			setStatusTest("pass", "User CAN see Job level detail");
		}else{
			setStatusTest("fail", "user CANNOT see Job level detail");
		}
	}
	
	@Test(priority = 7, enabled = true)
	public void TT25119(){
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
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickOFFbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickOFFbtnEditJobLevel();
		cloneForm.clickOFFbtnDeleteJobLevel();
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
		TestLogger.info("5. Access to Job Level ");
		TestLogger.info("Expect : User CAN see/do: " + "hyperlink Job Level in Control Board");
		if (controlBoard.isLblJobLevelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CAN see/do Job Level subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n" );
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		TestLogger.info("8. Hover on every Job in list");
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Icon Delete");
		if (!jobLevelList.isIconDeleteDisplayed()) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (jobLevelList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("9. User CANNOT view Job level detail");
		
		if(!jobLevelList.isLinkFirstJobLevelClickable()){
			setStatusTest("pass", "User CANNOT click on Job level link");
		}else{
			setStatusTest("fail", "user CAN see Job level detail");
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void TT25124(){
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
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickONbtnEditJobLevel();
		cloneForm.clickOFFbtnDeleteJobLevel();
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
		TestLogger.info("5. Access to Job Level ");
		TestLogger.info("Expect : User CAN see/do: " + "hyperlink Job Level in Control Board");
		if (controlBoard.isLblJobLevelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CAN see/do Job Level subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n"
				+ "2. Button Edit" );
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		TestLogger.info("8. Hover on every Job in list");
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Delete");
		if (!jobLevelList.isIconDeleteDisplayed()) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Delete");
		}
				
		TestLogger.info("Expect : User CAN see/do: " + "Icon Edit");
		
		if (jobLevelList.isIconEditDisplayed()) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
			
		TestLogger.info("9. User CAN view Job level detail");
		
		if(jobLevelList.isLinkFirstJobLevelClickable()){
			setStatusTest("pass", "User CANNOT click on Job level link");
		}else{
			setStatusTest("fail", "user CAN see Job level detail");
		}
		if(formJobLevelDetails.isLblJobLevelDetailssDisplayed()){
			setStatusTest("pass", "User CAN view Job level detail");
		}else{
			setStatusTest("fail", "User CANNOT view Job level detail");
		}
	}
	
	@Test(priority = 9, enabled = true)
	public void TT25125(){
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
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickOFFbtnCreateJobLevel();
		cloneForm.clickOFFbtnEditJobLevel();
		cloneForm.clickONbtnDeleteJobLevel();
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
		TestLogger.info("5. Access to Job Level ");
		TestLogger.info("Expect : User CAN see/do: " + "hyperlink Job Level in Control Board");
		if (controlBoard.isLblJobLevelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CAN see/do Job Level subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job Level \r\n"
				+ "2. Button Edit" );
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job Level ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job Level ");
		}
		TestLogger.info("8. Hover on every Job in list");
		TestLogger.info("Expect : User CAN see/do: " + "Icon Delete");
		if (jobLevelList.isIconDeleteDisplayed()) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (!jobLevelList.isIconEditDisplayed()) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("9. User CAN view Job level detail");
		
		if(jobLevelList.isLinkFirstJobLevelClickable()){
			setStatusTest("pass", "User CANNOT click on Job level link");
		}else{
			setStatusTest("fail", "user CAN see Job level detail");
		}
		if(formJobLevelDetails.isLblJobLevelDetailssDisplayed()){
			setStatusTest("pass", "User CAN view Job level detail");
		}else{
			setStatusTest("fail", "User CANNOT view Job level detail");
		}
	}
	
	@Test(priority = 10, enabled = true)
	public void TT25127(){
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
		TestLogger.info("3. Update Function Set|Job Level | View & Delete Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONbtnViewDimensionList();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewJobLevelList();
		cloneForm.clickONbtnViewJobLevelDetails();
		cloneForm.clickONbtnCreateJobLevel();
		cloneForm.clickONbtnEditJobLevel();
		cloneForm.clickONbtnDeleteJobLevel();
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
		TestLogger.info("5. Access to Job Level ");
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		if (!controlBoard.isLblJobLevelDisplayed()) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Job Level in Control Board");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "hyperlink Job Level in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Job Level subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkJobLevelOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Job Level sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Job Level on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Job Level via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "JobLevel/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Job list");
		}else{
			setStatusTest("fail", "User CAN access normally");
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
