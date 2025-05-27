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
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditPosition;
import wize.pages.Form_EditUser;
import wize.pages.Form_PositionDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.PositionList;
import wize.pages.UserManagement;

public class Test_FunctionSet_Position extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	PositionList positionList;
	Form_PositionDetails formPositionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
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
		editUser = new Form_EditUser(driver);
		positionList = new PositionList(driver);
		formPositionDetails = new Form_PositionDetails(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		formEditPosition = new Form_EditPosition(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = true)

	public void TT25081() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Position | Full Permission ");
		
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
		
		TestLogger.info("5. Access to Position ");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position ");
		} else {
			setStatusTest("fail", "Not Access to Position ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Position \r\n" 
				+ "2. Button Create");
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
		
		if (positionList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Create New Position");
		
		positionList.fillSearchPosition(DataManager.Functional);
		
		if(positionList.isLinkFirstPostionDisplayed() == true)
		{
			positionList.deletePosition();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Position deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Position deleted successfully");
			}
		
			positionList.clickBtnCreate();
			
			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreatePosition.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
			formCreatePosition.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Position created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Position created successfully");
			}
		}
		else
		{
			positionList.clickBtnCreate();
			
			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			formCreatePosition.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
			formCreatePosition.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Position created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Position created successfully");
			}
		}
		
		
		TestLogger.info("7. Hover on every Position in list");
		
		positionList.fillSearchPosition(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (positionList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (positionList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		TestLogger.info("8. Update Position");
		
		positionList.clickIconEdit();
		
		if (formEditPosition.isLblEditPositionDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		formEditPosition.fillPositionName(DataManager.Functional);
		formEditPosition.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position updated successfully");
		}

		TestLogger.info("9. Delete Position");
		
		positionList.fillSearchPosition(DataManager.Functional);
		positionList.deletePosition();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position deleted successfully");
		}
		
		/*TestLogger.info("10. Create data Position");
		positionList.clickBtnCreate();
		
		if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		formCreatePosition.inputDataTurn2(DataManager.Functional,DataManager.Test,DataManager.Test);
		formCreatePosition.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position created successfully");
		}*/
	}
		
	@Test(priority = 2, enabled = true)

	public void TT25080() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Position | NO VIEW Permission");
		
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
		cloneForm.clickOFFbtnViewPositionList();
		cloneForm.clickOFFbtnViewPositionDetails();
		cloneForm.clickOFFbtnCreatePositions();
		cloneForm.clickOFFbtnEditPositions();
		cloneForm.clickOFFbtnDeletePositions();
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
		
		TestLogger.info("5. Access to Position ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Position in Control Board");
		
		if (controlBoard.isLblPositionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Position in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Position in Control Board");
		}
}
	
	@Test(priority = 3, enabled = true)

	public void TT25085() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Position ");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position ");
		} else {
			setStatusTest("fail", "Not Access to Position ");
		}
		
		positionList.fillSearchPosition(DataManager.Functional);
		
		if(positionList.isLinkFirstPostionDisplayed() == true)
		{
			positionList.deletePosition();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Position deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Position deleted successfully");
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
		
		TestLogger.info("4. Update Function Set|Position | View & Create Permission");
		
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
		
		cloneForm.clickONbtnViewPositionList();
		cloneForm.clickONbtnViewPositionDetails();
		cloneForm.clickONbtnCreatePositions();
		cloneForm.clickOFFbtnEditPositions();
		cloneForm.clickOFFbtnDeletePositions();
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
		
		TestLogger.info("6. Access to Position ");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position ");
		} else {
			setStatusTest("fail", "Not Access to Position ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Position \r\n" 
				+ "2. Button Create");
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
		
		if (positionList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
						
		TestLogger.info("7. Create New Position");
		
		positionList.clickBtnCreate();
		
		if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		formCreatePosition.inputData(DataManager.Functional,DataManager.Test,DataManager.Test);
		formCreatePosition.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position created successfully");
		}
			
		TestLogger.info("8. Hover on every Position in list");
		
		positionList.fillSearchPosition(DataManager.Functional);
	
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (positionList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (positionList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
}
	
	@Test(priority = 4, enabled = true)

	public void TT25086() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Position | View & Edit Permission");
		
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
		
		cloneForm.clickONbtnViewPositionList();
		cloneForm.clickONbtnViewPositionDetails();
		cloneForm.clickOFFbtnCreatePositions();
		cloneForm.clickONbtnEditPositions();
		cloneForm.clickOFFbtnDeletePositions();
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
		
		TestLogger.info("5. Access to Position");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position ");
		} else {
			setStatusTest("fail", "Not Access to Position");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Position ");
				
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
			
		if (positionList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
						
		TestLogger.info("6. Hover on every Position in list");
		
		positionList.fillSearchPosition(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Edit");
		
		if (positionList.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Delete");
		
		if (positionList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
				
		TestLogger.info("7. Update Position List");
		
		positionList.clickIconEdit();
		
		if (formEditPosition.isLblEditPositionDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		formEditPosition.fillPositionName(DataManager.Functional);
		formEditPosition.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position updated successfully");
		}
}
	
	@Test(priority = 5, enabled = true)

	public void TT25087() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Position | View & Delete Permission");
		
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
		
		cloneForm.clickONbtnViewPositionList();
		cloneForm.clickONbtnViewPositionDetails();
		cloneForm.clickOFFbtnCreatePositions();
		cloneForm.clickOFFbtnEditPositions();
		cloneForm.clickONbtnDeletePositions();
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
		
		TestLogger.info("5. Access to Position");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position");
		} else {
			setStatusTest("fail", "Not Access to Position");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Position");
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
	
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
		
		if (positionList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every Position in list");
		
		positionList.fillSearchPosition(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		
		if (positionList.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		
		if (positionList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
			
		TestLogger.info("7. Delete Position");
		
		positionList.fillSearchPosition(DataManager.Functional);
		positionList.deletePosition();
		
		TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Position deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Position deleted successfully");
		}
	}
	
	@Test(priority = 6, enabled = true)
	public void TT25082_TT25084(){
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
		TestLogger.info("3. Update Function Set|Position | View Position list & View position detail Permission");
		
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
		for (int i = 0; i < 3; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewPositionList();
		cloneForm.clickONbtnViewPositionDetails();
		cloneForm.clickOFFbtnCreatePositions();
		cloneForm.clickOFFbtnEditPositions();
		cloneForm.clickOFFbtnDeletePositions();
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
		TestLogger.info("5. Access to Position");
		controlBoard.clickLblPosition();
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position");
		} else {
			setStatusTest("fail", "Not Access to Position");
		}
		TestLogger.info("Expect : User CAN see/do: " + "List of Position");
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
	
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
		if (positionList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + " Icon Delete");
		if (positionList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + " Icon Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		if (positionList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Duplicate");
		if (positionList.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Duplicate");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Duplicate");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Detail position");
		if (positionList.isLinkFirstPositionClickable()) {
			setStatusTest("pass", "User CAN see/do: " + "Detail position");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Detail position");
		}
		if(formPositionDetails.isLblPositionDetailsDisplayed()){
			setStatusTest("pass", "Position detail form is displayed");
		}else{
			setStatusTest("fail", "Position detail form is NOT displayed");
		}
	}
	
	@Test(priority = 7, enabled = true)
	public void TT25083(){
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
		TestLogger.info("3. Update Function Set|Position | View Position list & View position detail Permission");
		
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
		for (int i = 0; i < 3; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewPositionList();
		cloneForm.clickOFFbtnViewPositionDetails();
		cloneForm.clickOFFbtnCreatePositions();
		cloneForm.clickOFFbtnEditPositions();
		cloneForm.clickOFFbtnDeletePositions();
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
		TestLogger.info("5. Access to Position");
		controlBoard.clickLblPosition();
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position");
		} else {
			setStatusTest("fail", "Not Access to Position");
		}
		TestLogger.info("Expect : User CAN see/do: " + "List of Position");
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Position ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Position ");
		}
	
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create");
		if (positionList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + " Icon Delete");
		if (positionList.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + " Icon Delete");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit");
		if (positionList.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Duplicate");
		if (positionList.isIconCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Duplicate");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Duplicate");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Detail position");
		if (!positionList.isLinkFirstPositionClickable()) {
			setStatusTest("pass", "User CANNOT see/do: " + "Detail position");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Detail position");
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
