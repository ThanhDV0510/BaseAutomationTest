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
import wize.pages.Form_CreateSecurityProfile;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditSecurityProfile;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.SecurityProfile;
import wize.pages.UserManagement;

public class Test_FunctionSet_SecurityProfile extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	SecurityProfile securityProfile;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	Form_CreateSecurityProfile createSecurityProfile;
	Form_EditSecurityProfile editSecurityProfile;
	Clone_Form_EditFunctionSet cloneForm;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		functionSet = new FunctionSet(driver);
		securityProfile = new SecurityProfile(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		createSecurityProfile = new Form_CreateSecurityProfile(driver);
		editSecurityProfile = new Form_EditSecurityProfile(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT25591() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | Full Permission ");

		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();

		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}

		cloneForm.clickTabControlBoard();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickCboxFullPermission();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile ");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile ");
		}

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. List of Security Profile \r\n" + "2. Button Create\r\n"
				+ "3. Button Delete");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		if (securityProfile.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}

		if (securityProfile.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}

		TestLogger.info("6. Create New Security Profile");

		securityProfile.fillSearch(DataManager.Functional);

		if (securityProfile.isItemFirstDisplayed() == true) {
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}

			securityProfile.clickBtnAdd();

			if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}

			createSecurityProfile.inputData(DataManager.Functional, DataManager.Test, DataManager.FunctionSet);
			createSecurityProfile.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
			}
		} else {
			securityProfile.clickBtnAdd();

			if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}

			createSecurityProfile.inputData(DataManager.Functional, DataManager.Test, DataManager.FunctionSet);
			createSecurityProfile.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
			}
		}

		TestLogger.info("7. Hover on every Security Profile in list");

		TestLogger
				.info("Expect : User CAN see/do: \r\n" + "1. Icon Delete \r\n" + "2. Icon Edit\r\n" + "3. Icon Clone");

		if (securityProfile.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}

		if (securityProfile.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}

		if (securityProfile.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}

		TestLogger.info("8. Update Security Profile");

		securityProfile.clickIconEdit();

		if (editSecurityProfile.isLblEditSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		editSecurityProfile.fillDescription("change des");
		editSecurityProfile.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile updated successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile updated successfully");
		}

		TestLogger.info("9. Click on icon Clone when hover on any item in list to create new ");

		securityProfile.clickIconClone();
		createSecurityProfile.fillDescription(DataManager.Test);

		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}

		createSecurityProfile.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}

		TestLogger.info("10. Delete Security Profile");

		securityProfile.clickCboxAll();
		securityProfile.clickBtnDeleteAll();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile deleted successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
		}
	}

	@Test(priority = 2)

	public void TT25593() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | NO VIEW Permission");

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
		cloneForm.clickONbtnViewUser();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();

		cloneForm.clickOFFbtnViewSecurityProfile();
		cloneForm.clickOFFbtnViewSecurityProfileDetail();
		cloneForm.clickOFFbtnCreateSecurityProfile();
		cloneForm.clickOFFbtnEditSecurityProfile();
		cloneForm.clickOFFbtnDeleteSecurityProfile();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile ");

		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Security Profile in Control Board");

		if (controlBoard.isLblSecurityProfileDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Security Profile in Control Board");
		} else {
			setStatusTest("fail", "User SILL CAN see/do: " + "hyperlink Security Profile in Control Board");
		}
	}

	@Test(priority = 3)

	public void TT25595() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Security Profile ");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile ");
		}

		securityProfile.fillSearch(DataManager.Functional);

		if (securityProfile.isItemFirstDisplayed() == true) {
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();

			TestLogger.info("Expect : User CAN see/do: " + "Security Profile deleted successfully");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
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

		TestLogger.info("4. Update Function Set|Security Profile | View & Create Permission");

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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSecurityProfile();
		cloneForm.clickONbtnViewSecurityProfileDetail();
		cloneForm.clickONbtnCreateSecurityProfile();
		cloneForm.clickOFFbtnEditSecurityProfile();
		cloneForm.clickOFFbtnDeleteSecurityProfile();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("6. Access to Security Profile ");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile ");
		}

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. List of Security Profile \r\n" + "2. Button Create");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		if (securityProfile.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}

		TestLogger.info("Expect : User CANNOT see/do: " + "Button Delete");

		if (securityProfile.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}

		TestLogger.info("7. Create New Security Profile");

		securityProfile.clickBtnAdd();

		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}

		createSecurityProfile.inputData(DataManager.Functional, DataManager.Test, DataManager.FunctionSet);
		createSecurityProfile.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}

		TestLogger.info("8. Hover on every Security Profile in list");

		securityProfile.fillSearch(DataManager.Functional);

		TestLogger.info("Expect : User CAN see/do: " + "Icon Clone");

		if (securityProfile.isIconCloneDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Clone");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Icon Delete \r\n" + "2. Icon Edit");

		if (securityProfile.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}

		if (securityProfile.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}

		TestLogger.info("9. Click on icon Clone when hover on any item in list to create new ");

		securityProfile.clickIconClone();
		createSecurityProfile.fillDescription(DataManager.Test);

		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}

		createSecurityProfile.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
	}

	@Test(priority = 4)

	public void TT25592() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | View Only Permission");

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
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile ");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile");
		}

		TestLogger.info("Expect : User CAN see/do: " + "List of Security Profile ");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Button Delete\r\n" + "2. Button Create");

		if (securityProfile.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}

		if (securityProfile.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}

		TestLogger.info("6. Hover on every Security Profile in list");

		securityProfile.fillSearch(DataManager.Functional);

		TestLogger.info(
				"Expect : User CANNOT see/do: \r\n" + "1. Icon Delete \r\n" + "2. Icon Edit\r\n" + "3. Icon Clone");

		if (securityProfile.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}

		if (securityProfile.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}

		if (securityProfile.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		TestLogger.info("Expected: User can View detail of security profile");
		if(securityProfile.isItemFirstClickable()){
			setStatusTest("pass", "User CAN view user detail");
		}else{
			setStatusTest("pass", "User CANNOT view user detail");
		}
	}

	@Test(priority = 5)

	public void TT25596() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | View & Edit Permission");

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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSecurityProfile();
		cloneForm.clickONbtnViewSecurityProfileDetail();
		cloneForm.clickOFFbtnCreateSecurityProfile();
		cloneForm.clickONbtnEditSecurityProfile();
		cloneForm.clickOFFbtnDeleteSecurityProfile();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile");
		}

		TestLogger.info("Expect : User CAN see/do: " + "List of Security Profile ");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Button Delete\r\n" + "2. Button Create");

		if (securityProfile.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}

		if (securityProfile.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}

		TestLogger.info("6. Hover on every Security Profile in list");

		securityProfile.fillSearch(DataManager.Functional);

		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Edit");

		if (securityProfile.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Icon Delete \r\n" + "2. Icon Clone");

		if (securityProfile.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}

		if (securityProfile.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}

		TestLogger.info("7. Update securityProfile");

		securityProfile.clickIconEdit();

		if (editSecurityProfile.isLblEditSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}

		editSecurityProfile.fillDescription(DataManager.Test);
		editSecurityProfile.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile updated successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile updated successfully");
		}
	}

	@Test(priority = 6)

	public void TT25597() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | View & Delete Permission");

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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSecurityProfile();
		cloneForm.clickONbtnViewSecurityProfileDetail();
		cloneForm.clickOFFbtnCreateSecurityProfile();
		cloneForm.clickOFFbtnEditSecurityProfile();
		cloneForm.clickONbtnDeleteSecurityProfile();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile");
		} else {
			setStatusTest("fail", "Not Access to Security Profile");
		}

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. List of Security Profile \r\n" + "2. Button Delete");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		if (securityProfile.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
		}

		TestLogger.info("Expect : User CAN see/do: " + "Button Clone");

		if (securityProfile.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do: " + "Button Clone");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Clone");
		}

		TestLogger.info("6. Hover on every Security Profile in list");

		securityProfile.fillSearch(DataManager.Functional);

		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");

		if (securityProfile.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Icon Edit \r\n" + "2. Icon Clone");

		if (securityProfile.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}

		if (securityProfile.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}

		TestLogger.info("7. Delete Security Profile");

		securityProfile.clickCboxAll();
		securityProfile.clickBtnDeleteAll();

		TestLogger.info("Expect : User CAN see/do: " + "Security Profile deleted successfully");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
		}
	}

	@Test(priority = 7)

	public void TT25594() throws InterruptedException {
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

		TestLogger.info("3. Update Function Set|Security Profile | View Only Permission");

		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();

		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}

		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONbtnViewSecurityProfile();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Function Set updated sucessfully");
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

		TestLogger.info("5. Access to Security Profile ");

		controlBoard.clickLblSecurityProfile();

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile");
		}

		TestLogger.info("Expect : User CAN see/do: " + "List of Security Profile ");

		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Security Profile ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Security Profile ");
		}

		TestLogger.info("Expect : User CANNOT see/do: \r\n" + "1. Button Delete\r\n" + "2. Button Create");

		if (securityProfile.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}

		if (securityProfile.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}

		TestLogger.info("6. Hover on every Security Profile in list");

		securityProfile.fillSearch(DataManager.Functional);

		TestLogger.info(
				"Expect : User CANNOT see/do: \r\n" + "1. Icon Delete \r\n" + "2. Icon Edit\r\n" + "3. Icon Clone");

		if (securityProfile.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}

		if (securityProfile.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}

		if (securityProfile.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Clone");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Clone");
		}
		if(!securityProfile.isItemFirstClickable()){
			setStatusTest("pass", "User CANNOT view user detail");
		}else{
			setStatusTest("pass", "User CAN view user detail");
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
