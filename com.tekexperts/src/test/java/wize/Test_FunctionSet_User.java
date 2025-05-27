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
import wize.pages.Form_EditUser;
import wize.pages.Form_UserDetailCreate;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_User extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	Form_UserDetailCreate userDetailCreate;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Clone_Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		userDetailCreate = new Form_UserDetailCreate(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 1, enabled = true)
	public void TT25572(){
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
		TestLogger.info("3. Update Function Set| User | NO Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnRadioGeneralSettings();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Expected: CANNOT see User hyperlink");
		if (controlBoard.isLblUserDisplayed() == false) {
			setStatusTest("pass", "CANNOT see User hyperlink");
		} else {
			setStatusTest("fail", "CAN see User hyperlink");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT25570() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | FULL Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnRadioUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, create button, edit button, lock/unlock button, active/deactive button");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CAN see Create button");
		}else{
			setStatusTest("fail", "User CANNOT see Create button");
		}
		if(userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CAN see Edit button");
		}else{
			setStatusTest("fail", "User CANNOT see Edit button");
		}
		if(userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CAN see Unlock button");
		}else{
			setStatusTest("fail", "User CANNOT see Unlock button");
		}
		if(userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CAN see Activate button");
		}else{
			setStatusTest("fail", "User CANNOT see Activate button");
		}
		if(userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CAN see Deactivate button");
		}else{
			setStatusTest("fail", "User CANNOT see Deactivate button");
		}
		TestLogger.info("7. User CAN view user detail");
		userManagement.clickLinkFirstUser();
		if(userDetailCreate.isTitleUserDetailDisplayed()){
			setStatusTest("pass", "User CAN see user detail");
		}else{
			setStatusTest("pass", "User CANNOT see user detail");
		}
		userDetailCreate.clickIconCloseDetail();
		TestLogger.info("8. User CAN active/deactive");
		if(userManagement.getStatusBtnChangeFirstUser()){
			userManagement.deactivateFirstUser();
		}else{
			userManagement.activateFirstUser();
		}
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Activate/ deactivate successfully");
		}else{
			setStatusTest("fail", "Activate/ deactivate NOT successfully");
		}
		if(userManagement.getStatusBtnChangeFirstUser()){
			userManagement.deactivateFirstUser();
		}else{
			userManagement.activateFirstUser();
		}
		TestLogger.info("9. User CAN edit");
		userManagement.openEditPopup(PropertyManager.EmailUser);
		editUser.updateFunctionSet(DataManager.FunctionSet);
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User updated sucessfully");
		}
		TestLogger.info("10. User CAN create");
		userManagement.clickBtnCreateUser();
		String empCode = userDetailCreate.selectEmpCode();
		userDetailCreate.selectFunctionSet(DataManager.FunctionSet);
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display msg success");
		}else{
			setStatusTest("fail", "NOT Display msg success");
		}
		Thread.sleep(1500);
		userManagement.fillFilterEmpCode(empCode);
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "Create successfully");
		}else{
			setStatusTest("fail", "Create NOT successfully");
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void TT25571() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxViewOnly();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, view user detail");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		TestLogger.info("7. User CANNOT see create button, edit button, lock/unlock button, active/deactive button");
		if(!userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CANNOT see Create button");
		}else{
			setStatusTest("fail", "User CAN see Create button");
		}
		if(!userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit button");
		}else{
			setStatusTest("fail", "User CAN see Edit button");
		}
		if(!userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CANNOT see Unlock button");
		}else{
			setStatusTest("fail", "User CAN see Unlock button");
		}
		if(!userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Activate button");
		}else{
			setStatusTest("fail", "User CAN see Activate button");
		}
		if(!userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Deactivate button");
		}else{
			setStatusTest("fail", "User CAN see Deactivate button");
		}
		TestLogger.info("7. User CAN view user detail");
		userManagement.clickLinkFirstUser();
		if(userDetailCreate.isTitleUserDetailDisplayed()){
			setStatusTest("pass", "User CAN see user detail");
		}else{
			setStatusTest("fail", "User CANNOT see user detail");
		}
		userDetailCreate.clickIconCloseDetail();
	}
	
	@Test (priority = 4, enabled = true)
	public void TT25573() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW USER ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnViewUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		TestLogger.info("7. User CANNOT see create button, edit button, lock/unlock button, active/deactive button");
		if(!userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CANNOT see Create button");
		}else{
			setStatusTest("fail", "User CAN see Create button");
		}
		if(!userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit button");
		}else{
			setStatusTest("fail", "User CAN see Edit button");
		}
		if(!userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CANNOT see Unlock button");
		}else{
			setStatusTest("fail", "User CAN see Unlock button");
		}
		if(!userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Activate button");
		}else{
			setStatusTest("fail", "User CAN see Activate button");
		}
		if(!userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Deactivate button");
		}else{
			setStatusTest("fail", "User CAN see Deactivate button");
		}
		TestLogger.info("8. User CANNOT view user detail");
		if(!userManagement.isLinkFirstUserClickable()){
			setStatusTest("pass", "User CANNOT see user detail");
		}else{
			setStatusTest("fail", "User CAN see user detail");
		}
	}
	
	@Test (priority = 5, enabled = true)
	public void TT25574() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW + CREATE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnViewUser();
		editFunctionSet.clickONbtnCreateUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, create button");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CAN see Create button");
		}else{
			setStatusTest("fail", "User CANNOT see Create button");
		}
		TestLogger.info("7. User CANNOT see edit button, lock/unlock button, active/deactive button");
		if(!userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit button");
		}else{
			setStatusTest("fail", "User CAN see Edit button");
		}
		if(!userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CANNOT see Unlock button");
		}else{
			setStatusTest("fail", "User CAN see Unlock button");
		}
		if(!userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Activate button");
		}else{
			setStatusTest("fail", "User CAN see Activate button");
		}
		if(!userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Deactivate button");
		}else{
			setStatusTest("fail", "User CAN see Deactivate button");
		}
		TestLogger.info("8. User CANNOT view user detail");
		if(!userManagement.isLinkFirstUserClickable()){
			setStatusTest("pass", "User CANNOT see user detail");
		}else{
			setStatusTest("pass", "User CAN see user detail");
		}
		TestLogger.info("9. User CAN create");
		userManagement.clickBtnCreateUser();
		String empCode = userDetailCreate.selectEmpCode();
		userDetailCreate.selectFunctionSet(DataManager.FunctionSet);
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display msg success");
		}else{
			setStatusTest("fail", "NOT Display msg success");
		}
		Thread.sleep(1500);
		userManagement.fillFilterEmpCode(empCode);
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "Create successfully");
		}else{
			setStatusTest("fail", "Create NOT successfully");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT25575() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW + EDIT Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnViewUser();
		editFunctionSet.clickONbtnEditUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, edit button, ");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CAN see Edit button");
		}else{
			setStatusTest("fail", "User CANNOT see Edit button");
		}
		TestLogger.info("7. User CANNOT see Create, lock/unlock button, active/deactive button");
		if(!userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CANNOT see Create button");
		}else{
			setStatusTest("fail", "User CAN see Create button");
		}
		if(!userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CANNOT see Unlock button");
		}else{
			setStatusTest("fail", "User CAN see Unlock button");
		}
		if(!userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Activate button");
		}else{
			setStatusTest("fail", "User CAN see Activate button");
		}
		if(!userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Deactivate button");
		}else{
			setStatusTest("fail", "User CAN see Deactivate button");
		}
		TestLogger.info("8. User CANNOT view user detail");
		if(!userManagement.isLinkFirstUserClickable()){
			setStatusTest("pass", "User CANNOT see user detail");
		}else{
			setStatusTest("pass", "User CAN see user detail");
		}
		TestLogger.info("9. User CAN edit");
		userManagement.openEditPopup(PropertyManager.EmailUser);
		editUser.updateFunctionSet(DataManager.FunctionSet);
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User updated sucessfully");
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void TT25576() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW + UNLOCK Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnViewUser();
		editFunctionSet.clickONbtnLockUnlockUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, lock/unlock button");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CAN see Unlock button");
		}else{
			setStatusTest("fail", "User CANNOT see Unlock button");
		}
		TestLogger.info("7. User CANNOT see create button, edit button, active/deactive button");
		if(!userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CANNOT see Create button");
		}else{
			setStatusTest("fail", "User CAN see Create button");
		}
		if(!userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit button");
		}else{
			setStatusTest("fail", "User CAN see Edit button");
		}
		if(!userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Activate button");
		}else{
			setStatusTest("fail", "User CAN see Activate button");
		}
		if(!userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CANNOT see Deactivate button");
		}else{
			setStatusTest("fail", "User CAN see Deactivate button");
		}
		TestLogger.info("8. User CANNOT view user detail");
		if(!userManagement.isLinkFirstUserClickable()){
			setStatusTest("pass", "User CANNOT see user detail");
		}else{
			setStatusTest("pass", "User CAN see user detail");
		}
		TestLogger.info("9. User CAN unlock user");
		userManagement.clickFirstCheckboxSelect();
		userManagement.clickBtnUnlock();
		userManagement.clickBtnYesConfirmUnlock();
		System.out.println(DataManager.getMsgSuccess());
		if(DataManager.getMsgSuccess().equals("User unlocked successfully.")){
			setStatusTest("pass", "Unlock successfully");
		}else{
			setStatusTest("fail", "Unlock NOT successfully");
		}
	}
	
	@Test (priority = 8, enabled = true)
	public void TT26255() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| User | VIEW + ACTIVATE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnViewUser();
		editFunctionSet.clickONbtnActiveInactiveUser();
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
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to User screen");
		controlBoard.clickLblUser();
		if (userManagement.isLblUserManagementDisplayed() == true) {
			setStatusTest("pass", "CAN access User screen");
		} else {
			setStatusTest("fail", "CANNOT access User screen");
		}
		TestLogger.info("6. User CAN see data table, active/deactive button");
		if(userManagement.isLinkFirstUserDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(userManagement.isBtnActivateDisplayed()){
			setStatusTest("pass", "User CAN see Activate button");
		}else{
			setStatusTest("fail", "User CANNOT see Activate button");
		}
		if(userManagement.isBtnDeactivateDisplayed()){
			setStatusTest("pass", "User CAN see Deactivate button");
		}else{
			setStatusTest("fail", "User CANNOT see Deactivate button");
		}
		TestLogger.info("7. User CANNOT see create button, edit button, lock/unlock button");
		if(!userManagement.isBtnCreateUserDisplayed()){
			setStatusTest("pass", "User CANNOT see Create button");
		}else{
			setStatusTest("fail", "User CAN see Create button");
		}
		if(!userManagement.isIconEditDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit button");
		}else{
			setStatusTest("fail", "User CAN see Edit button");
		}
		if(!userManagement.isBtnUnlockDisplayed()){
			setStatusTest("pass", "User CANNOT see Unlock button");
		}else{
			setStatusTest("fail", "User CAN see Unlock button");
		}
		TestLogger.info("8. User CANNOT view user detail");
		if(!userManagement.isLinkFirstUserClickable()){
			setStatusTest("pass", "User CANNOT see user detail");
		}else{
			setStatusTest("pass", "User CAN see user detail");
		}
		TestLogger.info("9. User CAN active/deactive");
		if(userManagement.getStatusBtnChangeFirstUser()){
			userManagement.deactivateFirstUser();
		}else{
			userManagement.activateFirstUser();
		}
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Activate/ deactivate successfully from the table");
		}else{
			setStatusTest("fail", "Activate/ deactivate NOT successfully from the table");
		}
		if(userManagement.getStatusBtnChangeFirstUser()){
			userManagement.deactivateFirstUser();
		}else{
			userManagement.activateFirstUser();
		}
		userManagement.clickFirstCheckboxSelect();
		userManagement.clickBtnActivate();
		userManagement.clickBtnYesConfirmUnlock();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Activate/ deactivate successfully from mass-activate");
		}else{
			setStatusTest("fail", "Activate/ deactivate NOT successfully from mass-activate");
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
