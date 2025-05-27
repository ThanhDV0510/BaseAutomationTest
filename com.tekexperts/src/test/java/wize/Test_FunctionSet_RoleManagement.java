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
import wize.pages.Form_CreateRole;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditRole;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.RoleManagement;
import wize.pages.UserManagement;

public class Test_FunctionSet_RoleManagement extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	RoleManagement roleManagement;
	Form_EditUser editUser;
	Form_CreateRole createRole;
	Form_EditRole editRole;
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
		editUser = new Form_EditUser(driver);
		roleManagement = new RoleManagement(driver);
		createRole = new Form_CreateRole(driver);
		editRole = new Form_EditRole(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)

	public void TT25577() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | Full Permission ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
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
		
		TestLogger.info("5. Access to Role Management ");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Role Management \r\n" 
				+ "2. Button Create\r\n"
				+ "3. Button Delete");
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
		
		if (roleManagement.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		if (roleManagement.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
		
		TestLogger.info("6. Create New Role");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		if(roleManagement.isLinkFirstRoleDisplayed() == true)
		{
			roleManagement.clickCboxAll();
			roleManagement.clickBtnDeleteAll();
			
			if(roleManagement.checkBtnYesAvailble()== true)
			{
				roleManagement.clickBtnYes();
			}
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Role Management deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Role Management deleted successfully");
			}
			
			roleManagement.clickBtnAdd();
			
			if (createRole.isLblCreateRolelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			createRole.inputData(DataManager.Functional);
			createRole.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Role Management created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Icon Delete \r\n" 
					+ "2. Icon Edit\r\n"
					+ "3. Icon Clone");
			
			if (roleManagement.isIconDeleteDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
			}
			
			if (roleManagement.isIconEditDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
			}
			
			if (roleManagement.isIconCloneDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
			}
		}
		else
		{
			roleManagement.clickBtnAdd();
			
			if (createRole.isLblCreateRolelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			createRole.inputData(DataManager.Functional);
			createRole.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Role Management created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Icon Delete \r\n" 
					+ "2. Icon Edit\r\n"
					+ "3. Icon Clone");
			
			if (roleManagement.isIconDeleteDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
			}
			
			if (roleManagement.isIconEditDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
			}
			
			if (roleManagement.isIconCloneDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
			}
		}
	
		TestLogger.info("7. Update Role Management");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		roleManagement.clickIconEdit();
		
		if (editRole.isLblEditRolelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		editRole.fillRoleName("Name 1");
		editRole.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Role Management updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management updated successfully");
		}
		
		TestLogger.info("8. Click on icon Clone when hover on any item in list to create new ");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		roleManagement.clickIconClone();
				
		if (createRole.isLblCreateRolelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		createRole.fillRoleName(DataManager.Functional + "Name 2");
		createRole.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Role Management created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
		}
		
		TestLogger.info("9. Delete Role Management");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		if(roleManagement.isCboxAllSelected()){
			roleManagement.clickCboxAll();
			System.out.println("Is being selected");
		}
		Thread.sleep(1500);
		roleManagement.clickCboxAll();
		roleManagement.clickBtnDeleteAll();
	
		TestLogger.info("Expect : User CAN see/do: " + "Role Management deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management deleted successfully");
		}
	}
		
	@Test(priority = 2, enabled = true)

	public void TT25579() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | NO VIEW Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONbtnViewUser();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewRole();
		cloneForm.clickOFFbtnViewRoleDetail();
		cloneForm.clickOFFbtnCreateRole();
		cloneForm.clickOFFbtnEditRole();
		cloneForm.clickOFFbtnDeleteRole();
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
		
		TestLogger.info("5. Access to Role Management ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Role Management in Control Board");
		
		if (controlBoard.isLblRoleDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Role Management in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Role Management in Control Board");
		}
}
	
	@Test(priority = 3, enabled = true)

	public void TT25581() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Role Management ");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management ");
		}
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		if(roleManagement.isLinkFirstRoleDisplayed() == true)
		{
			roleManagement.clickCboxAll();
			roleManagement.clickBtnDeleteAll();

			if(roleManagement.checkBtnYesAvailble()== true)
			{
				roleManagement.clickBtnYes();
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
		
		TestLogger.info("4. Update Function Set|Role Management | View & Create Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewRole();
		cloneForm.clickOFFbtnViewRoleDetail();
		cloneForm.clickONbtnCreateRole();
		cloneForm.clickOFFbtnEditRole();
		cloneForm.clickOFFbtnDeleteRole();
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
		
		TestLogger.info("6. Access to Role Management ");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Role Management \r\n" 
				+ "2. Button Create");
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
		
		if (roleManagement.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Delete");
		
		if (roleManagement.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("7. Create New Role");
				
		roleManagement.clickBtnAdd();
		
		if (createRole.isLblCreateRolelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createRole.inputData(DataManager.Functional);
		createRole.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Role Management created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
		}
				
		TestLogger.info("8. Hover on every Role Management in list");
			
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Clone");
		
		if (roleManagement.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (roleManagement.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (roleManagement.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		TestLogger.info("9. Click on icon Clone when hover on any item in list to create new ");
		
		roleManagement.clickIconClone();
		
		if (createRole.isLblCreateRolelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		createRole.fillRoleName(DataManager.Functional + "name 1");
		createRole.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Role Management created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
		}
}
	
	@Test(priority = 4, enabled = true)

	public void TT25578() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | View Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
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
		
		TestLogger.info("5. Access to Role Management ");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Role Management ");
				
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
		TestLogger.info("Expect : User CAN see/do: " + "Role detail ");
		roleManagement.clickLinkFirstRole();
		if(roleManagement.isTitleRoleDetailDisplayed()){
			setStatusTest("pass", "User CAN view Role detail");
		}else{
			setStatusTest("pass", "User CANNOT view Role detail");
		}
		roleManagement.clickIconCloseRoleDetailDisplayed();
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n" 
				+ "2. Button Create");
			
		if (roleManagement.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
				
		if (roleManagement.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
			
		TestLogger.info("6. Hover on every Role Management in list");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (roleManagement.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (roleManagement.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (roleManagement.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
}
	
	@Test(priority = 5, enabled = true)

	public void TT25582() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | View & Edit Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewRole();
		cloneForm.clickOFFbtnViewRoleDetail();
		cloneForm.clickOFFbtnCreateRole();
		cloneForm.clickONbtnEditRole();
		cloneForm.clickOFFbtnDeleteRole();
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
		
		TestLogger.info("5. Access to Role Management");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Role Management ");
				
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n" 
				+ "2. Button Create");
			
		if (roleManagement.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
				
		if (roleManagement.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		TestLogger.info("6. Hover on every Role Management in list");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Edit");
		
		if (roleManagement.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Clone");
		
		if (roleManagement.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (roleManagement.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		TestLogger.info("7. Update Role Management");
		
		roleManagement.clickIconEdit();
		
		if (editRole.isLblEditRolelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		editRole.fillRoleName(DataManager.Functional + "name 2");
		editRole.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Role Management updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management updated successfully");
		}
}
	
	@Test(priority = 6, enabled = true)

	public void TT25583() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | View & Delete Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewRole();
		cloneForm.clickOFFbtnViewRoleDetail();
		cloneForm.clickOFFbtnCreateRole();
		cloneForm.clickOFFbtnEditRole();
		cloneForm.clickONbtnDeleteRole();
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
		
		TestLogger.info("5. Access to Role Management");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management");
		} else {
			setStatusTest("fail", "Not Access to Role Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Role Management \r\n" 
				+ "2. Button Delete");
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
				
		if (roleManagement.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Clone");
		
		if (roleManagement.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Clone");
		}
		
		TestLogger.info("6. Hover on every Role Management in list");
		
		roleManagement.fillFilterRoleName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		
		if (roleManagement.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit \r\n" 
				+ "2. Icon Clone");
		
		if (roleManagement.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (roleManagement.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		
		TestLogger.info("7. Delete Role Management");
		
		roleManagement.clickCboxAll();
		roleManagement.clickBtnDeleteAll();
		
		TestLogger.info("Expect : User CAN see/do: " + "Role Management deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management deleted successfully");
		}
}

	@Test(priority = 7, enabled = true)

	public void TT25580() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Role Management | View Role only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewRole();
		cloneForm.clickOFFbtnViewRoleDetail();
		cloneForm.clickOFFbtnCreateRole();
		cloneForm.clickOFFbtnEditRole();
		cloneForm.clickOFFbtnDeleteRole();
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
		
		TestLogger.info("5. Access to Role Management ");

		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Role Management ");
				
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Role Management ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Role Management ");
		}
		TestLogger.info("Expect : User CANNOT see/do: " + "Role detail ");
		if(!roleManagement.isLinkFirstRoleClickable()){
			setStatusTest("pass", "User CANNOT view Role detail");
		}else{
			setStatusTest("pass", "User CAN view Role detail");
		}
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n" 
				+ "2. Button Create");
			
		if (roleManagement.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
				
		if (roleManagement.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
			
		TestLogger.info("6. Hover on every Role Management in list");
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Clone");
		
		if (roleManagement.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (roleManagement.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (roleManagement.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
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
