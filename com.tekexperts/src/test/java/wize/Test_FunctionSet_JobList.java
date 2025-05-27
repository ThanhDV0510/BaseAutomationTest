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
import wize.pages.Form_CreateJob;
import wize.pages.Form_CreateJobLevel;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditJob;
import wize.pages.Form_EditUser;
import wize.pages.Form_JobDetails;
import wize.pages.FunctionSet;
import wize.pages.JobLevelList;
import wize.pages.JobList;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_JobList extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	JobList jobList;
	Form_JobDetails formJobDetails;
	Form_CreateJob formCreateJob;
	Form_EditJob formEditJob;
	JobLevelList jobLevelList;
	Form_CreateJobLevel formCreateJobLevel;
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
		jobList = new JobList(driver);
		formJobDetails = new Form_JobDetails(driver);
		formCreateJob = new Form_CreateJob(driver);
		formEditJob = new Form_EditJob(driver);
		jobLevelList = new JobLevelList(driver);
		formCreateJobLevel = new Form_CreateJobLevel(driver);
		editUser = new Form_EditUser(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)

	public void TT25100_TT25101_TT25111() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Job | Full Permission ");
		
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
		TestLogger.info("5. User CAN see/do Job subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Job link on Control board");
		if(controlBoard.isLblJobDisplayed()){
			setStatusTest("pass", "User CAN see/do Job link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job link on Control Board");
		}
		TestLogger.info("7. Access to Job ");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job ");
		} else {
			setStatusTest("fail", "Not Access to Job ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job \r\n" 
				+ "2. Button Create");
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job ");
		}
		
		if (jobList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("8. Create New Job");
		
		jobList.fillSearchJob(DataManager.Functional);
		
		if(jobList.isLinkFirstJobDisplayed() == true)
		{
			jobList.clickIconDelete();
			jobList.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Job List deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Job List deleted successfully");
			}
			
			jobList.clickBtnCreate();
			
			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreateJob.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
			formCreateJob.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Job created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}		
		}
		else
		{
			jobList.clickBtnCreate();
			
			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreateJob.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
			formCreateJob.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Job created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}
		}
		
		
		TestLogger.info("9. Hover on every Job in list");
	
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (jobList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (jobList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("10. Update Job");
		
		jobList.clickIconEdit();
		jobList.fillDescription(DataManager.FunctionSet);
		
		if (formEditJob.isLblEditJobDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		formEditJob.fillDescription("new des");
		formEditJob.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job updated successfully");
		}
		
		TestLogger.info("11. Delete Job");
		
		jobList.clickIconDelete();
		jobList.clickBtnYes();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job deleted successfully");
		}
		TestLogger.info("13. Click icon Control Board >> Access Job via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Job/Index");
		if(!controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User can access normally");
		}else{
			setStatusTest("fail", "User CANNOT access normally");
		}
	}
		
	@Test(priority = 2, enabled = true)

	public void TT25098_TT25099() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job | NO VIEW Permission");
		
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
		cloneForm.clickOFFbtnViewJobList();
		cloneForm.clickOFFbtnViewJobdetail();
		cloneForm.clickOFFbtnCreateJob();
		cloneForm.clickOFFbtnEditJob();
		cloneForm.clickOFFbtnDeleteJob();
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
		
		TestLogger.info("5. Access to Job ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Job in Control Board");
		
		if (controlBoard.isLblJobDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Job in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Job in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Job subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkJobOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Job sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Job on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Job via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Job/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Job list");
		}else{
			setStatusTest("fail", "User CAN access normally");
		}
		
}
	
	@Test(priority = 3, enabled = true)

	public void TT25092() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Job List >> Delete old data");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job List ");
		} else {
			setStatusTest("fail", "Not Access to Job List ");
		}
		
		jobList.fillSearchJob(DataManager.Functional);
		
		if(jobList.isLinkFirstJobDisplayed() == true)
		{
			jobList.clickIconDelete();
			jobList.clickBtnYes();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Job List deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Job List deleted successfully");
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
		
		TestLogger.info("4. Update Function Set|Job | View & Create Permission");
		
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
		
		cloneForm.clickONbtnViewJobList();
		cloneForm.clickONbtnViewJobdetail();
		cloneForm.clickONbtnCreateJob();
		cloneForm.clickOFFbtnEditJob();
		cloneForm.clickOFFbtnDeleteJob();
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
		
		TestLogger.info("6. Access to Job ");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job ");
		} else {
			setStatusTest("fail", "Not Access to Job ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job \r\n" 
				+ "2. Button Create");
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job ");
		}
		
		if (jobList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
						
		TestLogger.info("7. Create New Job");
		
		jobList.clickBtnCreate();
		
		if (formCreateJob.isLblCreateJobDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		formCreateJob.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
		formCreateJob.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
		}
			
		TestLogger.info("8. Hover on every Job in list");
		
		jobList.fillSearchJob(DataManager.Functional);
					
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (jobList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (jobList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
}
	
	@Test(priority = 4, enabled = true)

	public void TT25104_TT25102_TT25103_TT25105() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job | View Only Permission");
		
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
		TestLogger.info("5. User CAN see/do Job subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkJobOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Job sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Job link on Control board");
		if(controlBoard.isLblJobDisplayed()){
			setStatusTest("pass", "User CAN see/do Job link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Job link on Control Board");
		}
		TestLogger.info("7. Access to Job ");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job ");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Job ");
				
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
			
		if (jobList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
			
		TestLogger.info("8. Hover on every Job in list");
		
		jobList.fillSearchJob(DataManager.Functional);
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (jobList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (jobList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		TestLogger.info("Expected: User can view job detail");
		if(jobList.isLinkFirstJobClickable()){
			setStatusTest("pass", "User CAN click on job detail link");
		}else{
			setStatusTest("fail", "User CANNOT view job detail successfully");
		}
		if(formJobDetails.isLblJobDetailsDisplayed()){
			setStatusTest("pass", "User CAN view job detail successfully");
		}else{
			setStatusTest("fail", "User CANNOT view job detail successfully");
		}
}
	
	@Test(priority = 5, enabled = true)

	public void TT25107_TT25109() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job | View & Edit Permission");
		
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
		
		cloneForm.clickONbtnViewJobList();
		cloneForm.clickONbtnViewJobdetail();
		cloneForm.clickOFFbtnCreateJob();
		cloneForm.clickONbtnEditJob();
		cloneForm.clickOFFbtnDeleteJob();
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
		
		TestLogger.info("5. Access to Job");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job ");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Job ");
				
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
			
		if (jobList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
						
		TestLogger.info("6. Hover on every Job in list");
		
		jobList.fillSearchJob(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Edit");
		
		if (jobList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Delete");
		
		if (jobList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
			
		TestLogger.info("7. Update jobList");
		
		jobList.clickIconEdit();
		jobList.fillDescription(DataManager.FunctionSet);
		
		if (formEditJob.isLblEditJobDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		formEditJob.fillDescription("new des");
		formEditJob.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job updated successfully");
		}
}
	
	@Test(priority = 6, enabled = true)

	public void TT25108_TT25110() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Job | View & Delete Permission");
		
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
		
		cloneForm.clickONbtnViewJobList();
		cloneForm.clickONbtnViewJobdetail();
		cloneForm.clickOFFbtnCreateJob();
		cloneForm.clickOFFbtnEditJob();
		cloneForm.clickONbtnDeleteJob();
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
		
		TestLogger.info("5. Access to Job");

		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Job \r\n" 
				+ "2. Button Delete");
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Job ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Job ");
		}
				
		if (jobList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
			
		TestLogger.info("6. Hover on every Job in list");
		
		jobList.fillSearchJob(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		
		if (jobList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (jobList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("7. Delete Job");
		
		jobList.fillSearchJob(DataManager.Functional);
		jobList.clickIconDelete();
		jobList.clickBtnYes();
		
		TestLogger.info("Expect : User CAN see/do: " + "Job deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Job deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Job deleted successfully");
		}
	}
	
	@Test(priority = 7, enabled = true)
	public void TT25112(){
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
		TestLogger.info("3. Update Function Set|Job | View Job list & View job detail & Edit Permission");
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
		
		cloneForm.clickOFFbtnViewJobList();
		cloneForm.clickONbtnViewJobdetail();
		cloneForm.clickONbtnCreateJob();
		cloneForm.clickONbtnEditJob();
		cloneForm.clickONbtnDeleteJob();
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
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Job in Control Board");
		
		if (controlBoard.isLblJobDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Job in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Job in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Job subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkJobOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Job sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Job on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Job via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Job/Index");
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
