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
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_CreateProduct;
import wize.pages.Form_EditBusinessUnit;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditProduct;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.Organization;
import wize.pages.Organization_BusinessUnit;
import wize.pages.Organization_Product;
import wize.pages.UserManagement;

public class Test_FunctionSet_Organization extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	
	Organization organization;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_EditBusinessUnit editBusinessUnit;
	
	Organization_Product product;
	Form_CreateProduct createProduct;
	Form_EditProduct editProduct;
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
		
		organization = new Organization(driver);
		businessUnit = new Organization_BusinessUnit(driver);
		createBusinessUnit = new Form_CreateBusinessUnit(driver);
		editBusinessUnit = new Form_EditBusinessUnit(driver);
		
		product = new Organization_Product(driver);
		createProduct = new Form_CreateProduct(driver);
		editProduct = new Form_EditProduct(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)

	public void TT25089() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Organization| Full Permission");
		
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
		
		TestLogger.info("5. Access to Business Unit");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to Business Unit");
		} else {
			setStatusTest("fail", "Not Access to Business Unit");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Business Unit List\r\n" 
				+ "2. Button Create");
		
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Business Unit List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Business Unit List");
		}
		
		if (businessUnit.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Create New Business Unit");
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		if(businessUnit.isItemFirstDisplayed() == true)
		{
			businessUnit.clickIconDelete();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit deleted successfully");
			}
			
			businessUnit.clickBtnAdd();
			
			if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			createBusinessUnit.fillName(DataManager.Functional);
			createBusinessUnit.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		else
		{
			businessUnit.clickBtnAdd();
			
			if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			createBusinessUnit.fillName(DataManager.Functional);
			createBusinessUnit.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		

		TestLogger.info("7. Hover on every Business Unit in list");
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Create");
		
		if (businessUnit.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (businessUnit.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
		
		if (businessUnit.isIconPlusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Create");
		}
		
		TestLogger.info("8. Update Business Unit");
		
		businessUnit.clickIconEdit();
		
		if (editBusinessUnit.isLblEditBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		
		editBusinessUnit.fillDescription(DataManager.FunctionSet);
		editBusinessUnit.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Business Unit updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Business Unit updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Business Unit updated successfully");
		}
		
		TestLogger.info("9. Delete Business Unit");
		
		businessUnit.clickIconDelete();
		
		TestLogger.info("Expect : User CAN see/do: " + "Business Unit deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Business Unit deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Business Unit deleted successfully");
		}
	}
		
	@Test(priority = 2, enabled = true)

	public void TT25088() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Organization| NO VIEW Permission");
		
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
		
		cloneForm.clickOFFbtnViewDimensionList();
		cloneForm.clickOFFbtnCreateDimension();
		cloneForm.clickOFFbtnEditDimension();
		cloneForm.clickOFFbtnDeleteDimension();
		cloneForm.clickONbtnViewJobList();
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
		
		TestLogger.info("5. Access to ORGANIZATION");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Organizationl in Control Board");
		
		if (controlBoard.isLblOrganizationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Organizationl in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Organizationl in Control Board");
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
		
		TestLogger.info("2. Access to Function Set >> Delete old data");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to Business Unit");
		} else {
			setStatusTest("fail", "Not Access to Business Unit");
		}
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		if(businessUnit.isItemFirstDisplayed() == true)
		{
			businessUnit.clickIconDelete();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit deleted successfully");
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
		
		TestLogger.info("4. Update Function Set|Organization| View & Create Permission");
		
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
		cloneForm.clickONbtnCreateDimension();
		cloneForm.clickOFFbtnEditDimension();
		cloneForm.clickOFFbtnDeleteDimension();
		cloneForm.clickONbtnViewJobList();
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
		
		TestLogger.info("6. Access to ORGANIZATION");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to ORGANIZATION");
		} else {
			setStatusTest("fail", "Not Access to ORGANIZATION");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Business Unit List\r\n" 
				+ "2. Button Create");
		
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Business Unit List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Business Unit List");
		}
		
		if (businessUnit.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
		
		TestLogger.info("7. Create New Business Unit");
		
		businessUnit.clickBtnAdd();
		
		if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createBusinessUnit.fillName(DataManager.Functional);
		createBusinessUnit.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
		}
			
		TestLogger.info("8. Hover on every Business Unit in list");
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Create");
		
		if (businessUnit.isIconPlusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Create");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit");
		
		if (businessUnit.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (businessUnit.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
}
	
	@Test(priority = 4, enabled = true)

	public void TT25090_TT25091() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Organization| View Only Permission");
		
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
		
		TestLogger.info("5. Access to ORGANIZATION");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to ORGANIZATION");
		} else {
			setStatusTest("fail", "Not Access to ORGANIZATION");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Business Unit List");
				
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Business Unit List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Business Unit List");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "	+ "Button Create");
		
		if (businessUnit.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
			
		TestLogger.info("6. Hover on every Business Unit in list");
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Edit\r\n"
				+ "3. Icon Create");
		
		if (businessUnit.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (businessUnit.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (businessUnit.isIconPlusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Create");
		}
}
	
	@Test(priority = 5, enabled = true)

	public void TT25093() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Organization| View & Edit Permission");
		
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
		cloneForm.clickOFFbtnCreateDimension();
		cloneForm.clickONbtnEditDimension();
		cloneForm.clickOFFbtnDeleteDimension();
		cloneForm.clickONbtnViewJobList();
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
		
		TestLogger.info("5. Access to ORGANIZATION");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to ORGANIZATION");
		} else {
			setStatusTest("fail", "Not Access to ORGANIZATION");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Business Unit List");
		
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Business Unit List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Business Unit List");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "	+ "Button Create");
		
		if (businessUnit.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every Business Unit in list");
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Edit");
		
		if (businessUnit.isIconEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete \r\n" 
				+ "2. Icon Create");
		
		if (businessUnit.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (businessUnit.isIconPlusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Create");
		}
		
		TestLogger.info("7. Update Business Unit");
		
		businessUnit.clickIconEdit();
		
		if (editBusinessUnit.isLblEditBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Open Edit Popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Popup");
		}
		
		editBusinessUnit.fillDescription(DataManager.FunctionSet);
		createBusinessUnit.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Business Unit updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Business Unit updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Business Unit updated successfully");
		}
}
	
	@Test(priority = 6, enabled = true)

	public void TT25094() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Organization| View & Delete Permission");
		
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
		cloneForm.clickOFFbtnCreateDimension();
		cloneForm.clickOFFbtnEditDimension();
		cloneForm.clickONbtnDeleteDimension();
		cloneForm.clickONbtnViewJobList();
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
		
		TestLogger.info("5. Access to ORGANIZATION");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to ORGANIZATION");
		} else {
			setStatusTest("fail", "Not Access to ORGANIZATION");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Business Unit List");
		
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Business Unit List");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Dimension List");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "	+ "Button Create");
		
		if (businessUnit.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("6. Hover on every Business Unit in list");
		
		businessUnit.fillSearchName(DataManager.Functional);
		
		TestLogger.info("Expect : User CAN see/do: " + "Icon Icon Delete");
		
		if (businessUnit.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Edit \r\n" 
				+ "2. Icon Create");
		
		if (businessUnit.isIconEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit");
		}
		
		if (businessUnit.isIconPlusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Create");
		}
		
		TestLogger.info("7. Delete Business Unit");
		
		businessUnit.clickIconDelete();
		
		TestLogger.info("Expect : User CAN see/do: " + "Business Unit deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Business Unit deleted successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Business Unit deleted successfully");
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
