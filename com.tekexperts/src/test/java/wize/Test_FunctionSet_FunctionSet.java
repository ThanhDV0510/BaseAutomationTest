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
import wize.pages.Form_EditUser;
import wize.pages.Form_FunctionSetDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_FunctionSet extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	Form_CreateFunctionSet createFunctionSet;
	Form_FunctionSetDetails functionSetDetails;
	Clone_Form_EditFunctionSet cloneform;		
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
		editUser = new Form_EditUser(driver);
		createFunctionSet = new Form_CreateFunctionSet(driver);
		functionSetDetails = new Form_FunctionSetDetails(driver);
		cloneform = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	

	@Test(priority = 1,enabled = true)

	public void TT25584() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickCboxFullPermission();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set edit sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set edit sucessfully");
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
		
		TestLogger.info("6. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Function Set List\r\n" 
				+ "2. Button Create\r\n"
				+ "3. Button Delete");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
		
		if (functionSet.isBtnAddFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		if (functionSet.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
		
		TestLogger.info("7. Create New Function Set");
		
		functionSet.fillSearchName(DataManager.Functional);
		
		if(functionSet.isLinkFirstNameDisplayed() == true)
		{
			functionSet.clickCboxAll();
			functionSet.clickBtnDeleteAll();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Function Set deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Function Set deleted successfully");
			}
			
			functionSet.clickBtnAddFunctionSet();
			
			if (createFunctionSet.isLblCreateFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Create Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Create Function Set popup");
			}
			
			createFunctionSet.fillName(DataManager.Functional);
			createFunctionSet.fillDescription(DataManager.Functional);
			createFunctionSet.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
			}
		}
		else
		{
			functionSet.clickBtnAddFunctionSet();
			
			if (createFunctionSet.isLblCreateFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Create Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Create Function Set popup");
			}
			
			createFunctionSet.fillName(DataManager.Functional);
			createFunctionSet.fillDescription(DataManager.Functional);
			createFunctionSet.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
			}			
		}
		
		functionSet.fillSearchName(DataManager.Functional);
		TestLogger.info("8. Hover on every functionSet in list");
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (functionSet.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (functionSet.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		if (functionSet.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}
		TestLogger.info("9. Edit a function set");
		functionSet.clickIconEdit();
		if(editFunctionSet.isLblEditFunctionSetDisplayed()){
			setStatusTest("pass", "Form edit function set is displayed");
		}else{
			setStatusTest("fail", "Form edit function set is NOT displayed");
		}
		editFunctionSet.clickCboxViewOnly();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set edit sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set edit sucessfully");
		}
		TestLogger.info("10. Click on  every Function Set Name to see detail content");
		
		functionSet.clickLinkFirstName();
		
		if (functionSetDetails.isLblFunctionSetDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Fucntion Set Details popup");
		} else {
			setStatusTest("fail", "NOT Open Fucntion Set Details popup");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (functionSetDetails.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (functionSetDetails.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		if (functionSetDetails.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}
		
		TestLogger.info("11. Clone Function Set");
		
		functionSetDetails.clickIconClone();
		createFunctionSet.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Function Set created sucessfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
		}
				
		TestLogger.info("12. Delete Function Set");
		
		functionSet.clickCboxAll();
		functionSet.clickBtnDeleteAll();
				
		TestLogger.info("Expect : User CAN see/do: " + "Function Set deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set deleted successfully");
		}
	}
	
	@Test(priority = 2, enabled = true)

	public void TT25588() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set >> Delete old data");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		functionSet.fillSearchName(DataManager.Functional);
		
		if(functionSet.isLinkFirstNameDisplayed() == true)
		{
			functionSet.clickCboxAll();
			functionSet.clickBtnDeleteAll();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Function Set deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Function Set deleted successfully");
			}
		}
		
		TestLogger.info("3. Update Function Set|FunctionSet| View & Create Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickCboxCustomization();
		cloneform.clickCboxSubCustomization();
		
		cloneform.clickONbtnViewFunctionSet();
		cloneform.clickONbtnViewFunctionSetDetail();
		cloneform.clickONbtnCreateFunctionSet();
		cloneform.clickOFFbtnEditFunctionSet();
		cloneform.clickOFFbtnDeleteFunctionSet();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
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
		
		TestLogger.info("5. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Function Set List\r\n" 
				+ "2. Button Create");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
		
		if (functionSet.isBtnAddFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Delete");
		
		if (functionSet.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("6. Create New Function Set");
		
		functionSet.clickBtnAddFunctionSet();
		
		if (createFunctionSet.isLblCreateFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Create Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Create Function Set popup");
		}
		
		createFunctionSet.fillName(DataManager.Functional);
		createFunctionSet.fillDescription(DataManager.Functional);
		createFunctionSet.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
		}
			
		TestLogger.info("7. Hover on every functionSet in list");
		
		functionSet.fillSearchName(DataManager.Functional);
		functionSet.hoverOnFirstItem();
		
		TestLogger.info("Expect : User CAN see/do: " + " Icon Clone");
		
		if (functionSet.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (functionSet.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSet.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		TestLogger.info("8. Click on  every Function Set Name to see detail content");
		
		functionSet.clickLinkFirstName();
		
		if (functionSetDetails.isLblFunctionSetDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Fucntion Set Details popup");
		} else {
			setStatusTest("fail", "NOT Open Fucntion Set Details popup");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + " Icon Clone");
		
		if (functionSetDetails.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (functionSetDetails.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSetDetails.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		TestLogger.info("9. Clone Function Set");
		
		functionSetDetails.clickIconClone();
		createFunctionSet.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Function Set created sucessfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
		}
	}
	
	@Test(priority = 3, enabled = true)

	public void TT25585() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| View Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
				
		cloneform.clickTabControlBoard();
		cloneform.clickCboxViewOnly();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
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
		
		TestLogger.info("5. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Function Set List");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create\r\n"
				+ "2. Button Delete");
				
		if (functionSet.isBtnAddFunctionSetDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (functionSet.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
			
		TestLogger.info("7. Hover on every functionSet in list");
		
		functionSet.fillSearchName(DataManager.Functional);
		functionSet.hoverOnFirstItem();
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (functionSet.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSet.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (functionSet.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		TestLogger.info("8. Click on  every Function Set Name to see detail content");
		
		functionSet.clickLinkFirstName();
		
		if (functionSetDetails.isLblFunctionSetDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Fucntion Set Details popup");
		} else {
			setStatusTest("fail", "NOT Open Fucntion Set Details popup");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (functionSetDetails.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
			} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSetDetails.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (functionSetDetails.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		functionSetDetails.clickIconX();
}
	
	@Test(priority = 4, enabled = true)

	public void TT25590() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickCboxCustomization();
		cloneform.clickCboxSubCustomization();
		
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickONbtnViewFunctionSet();
		cloneform.clickONbtnViewFunctionSetDetail();
		cloneform.clickOFFbtnCreateFunctionSet();
		cloneform.clickOFFbtnEditFunctionSet();
		cloneform.clickONbtnDeleteFunctionSet();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
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
		
		TestLogger.info("5. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Function Set List\r\n" 
				+ "2. Button Delete");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
				
		if (functionSet.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "  + "Button Create");
				
		if (functionSet.isBtnAddFunctionSetDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every functionSet in list");
		
		functionSet.fillSearchName(DataManager.Functional);
		functionSet.hoverOnFirstItem();
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Delete");
		
		if (functionSet.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Icon Clone");
				
		if (functionSet.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (functionSet.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
					
		TestLogger.info("7. Click on  every Function Set Name to see detail content");
		
		functionSet.clickLinkFirstName();
		
		if (functionSetDetails.isLblFunctionSetDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Fucntion Set Details popup");
		} else {
			setStatusTest("fail", "NOT Open Fucntion Set Details popup");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Delete");
		
		if (functionSetDetails.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit\r\n"
				+ "2. Icon Clone");
				
		if (functionSetDetails.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (functionSetDetails.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		TestLogger.info("8. Delete Function Set");
		
		functionSetDetails.clickIconX();
		functionSet.clickCboxAll();
		functionSet.clickBtnDeleteAll();
	
		TestLogger.info("Expect : User CAN see/do: " + "Function Set deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set deleted successfully");
		}
	}
	
	@Test(priority = 5, enabled = true)
	public void TT25589() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickCboxCustomization();
		cloneform.clickCboxSubCustomization();
		
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickONbtnViewFunctionSet();
		cloneform.clickONbtnViewFunctionSetDetail();
		cloneform.clickOFFbtnCreateFunctionSet();
		cloneform.clickONbtnEditFunctionSet();
		cloneform.clickOFFbtnDeleteFunctionSet();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		functionSet.fillSearchName(DataManager.Functional);
		if(functionSet.isLinkFirstNameDisplayed() == false)
		{
			functionSet.clickBtnAddFunctionSet();
			if (createFunctionSet.isLblCreateFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Create Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Create Function Set popup");
			}
			
			createFunctionSet.fillName(DataManager.Functional);
			createFunctionSet.fillDescription(DataManager.Functional);
			createFunctionSet.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
			}
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
		
		TestLogger.info("5. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Function Set List" );
		TestLogger.info("2. User CANNOT see Button Delete All");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
				
		if (functionSet.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "  + "Button Create");
				
		if (functionSet.isBtnAddFunctionSetDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every functionSet in list");
		
		functionSet.fillSearchName(DataManager.Functional);
		functionSet.hoverOnFirstItem();
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Edit");
		
		if (functionSet.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Icon Clone");
				
		if (functionSet.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSet.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
					
		TestLogger.info("7. Click on  every Function Set Name to see detail content");
		
		functionSet.clickLinkFirstName();
		
		if (functionSetDetails.isLblFunctionSetDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Fucntion Set Details popup");
		} else {
			setStatusTest("fail", "NOT Open Fucntion Set Details popup");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Edit");
		
		if (functionSetDetails.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Icon Clone");
				
		if (functionSetDetails.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (functionSetDetails.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		TestLogger.info("8. Edit Function Set");
		
		functionSetDetails.clickIconX();
		functionSet.clickIconEdit();
		if(editFunctionSet.isLblEditFunctionSetDisplayed()){
			setStatusTest("pass", "Form edit function set is displayed");
		}else{
			setStatusTest("fail", "Form edit function set is NOT displayed");
		}
		editFunctionSet.clickCboxViewOnly();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set edit sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set edit sucessfully");
		}
	}
	
	@Test(priority = 6, enabled = true)
	public void TT25587() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickCboxCustomization();
		cloneform.clickCboxSubCustomization();
		
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickONbtnViewFunctionSet();
		cloneform.clickOFFbtnViewFunctionSetDetail();
		cloneform.clickOFFbtnCreateFunctionSet();
		cloneform.clickOFFbtnEditFunctionSet();
		cloneform.clickOFFbtnDeleteFunctionSet();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
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
		
		TestLogger.info("5. Access to Function Set");

		controlBoard.clickLblFunctionSet();
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Function Set List" );
		TestLogger.info("2. User CANNOT see Button Delete All");
		
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Function Set List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Function Set List");
		}
				
		if (functionSet.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "  + "Button Create");
				
		if (functionSet.isBtnAddFunctionSetDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every functionSet in list");
		
		functionSet.fillSearchName(DataManager.Functional);
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n"
				+ "2. Icon Clone \r\n"
				+ "3. Icon Edit");
		if (functionSet.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		} 
		if (functionSet.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		if (functionSet.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
					
		TestLogger.info("7. Expected: User can not view detail of a function set");
		
		if(!functionSet.isLinkFirstNameClickable()){
			setStatusTest("pass", "CANNOT open Fucntion Set Details popup");
		}else{
			setStatusTest("fail", "Open Fucntion Set Details popup");
		}
	}
	@Test(priority = 7, enabled = true)
	public void TT25586() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|FunctionSet| View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneform.clickTabControlBoard();
		cloneform.clickCboxCustomization();
		cloneform.clickCboxSubCustomization();
		
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickBtnCollapse();
		cloneform.clickOFFbtnRadioFunctionSet();
		cloneform.clickONbtnRadioSecurityProfile();
		cloneform.fillTxtDescription(DataManager.FunctionSet);
		cloneform.clickBtnSave();
		
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
		
		TestLogger.info("5. Expected: CANNOT see Function Set hyperlink");
		if(!controlBoard.isLblFunctionSetDisplayed()){
			setStatusTest("pass", "CANNOT see Function set hyperlink");
		}else{
			setStatusTest("fail", "CAN see Function set hyperlink");
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
