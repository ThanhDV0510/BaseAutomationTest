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
import wize.pages.ControlBoard;
import wize.pages.Form_EditFieldValues;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.GeneralSettings;
import wize.pages.GeneralSettings_UserDefinedValues;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_GeneralSettings_ReasonForLeavingTheJob extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	GeneralSettings generalSettings;
	GeneralSettings_UserDefinedValues userDefinedValues;
	Form_EditFieldValues editFieldValues;
			
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
		generalSettings = new GeneralSettings(driver);
		userDefinedValues = new GeneralSettings_UserDefinedValues(driver);
		editFieldValues = new Form_EditFieldValues(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_24108_TT_24113_TT_24118_TT_24125_TT_24126_TT_24127() throws InterruptedException {
	TestLogger.info("1. Login with account Admin");

	loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

	if (controlBoard.isLblControlBoardDisplayed() == true) {
		setStatusTest("pass", "Login Successfully!");
	} else {
		setStatusTest("fail", "Login Fail!");
	}

	TestLogger.info("2. Access to General Settings >> User Defined Values");

	controlBoard.clickLblGeneralSettings();
		
	if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
		setStatusTest("pass", "Access to General Settings");
	} else {
		setStatusTest("fail", "Not Access to General Settings");
	}
		
	generalSettings.clickSubMenuUserDefinedValues();
		
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to User Defined Values");
		} else {
		setStatusTest("fail", "Not Access to User Defined Values");		
	}
				
	TestLogger.info("3. Access to Edit Field Values of Reason For Leaving The Job >> Click click on button 'Cancel'");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	editFieldValues.clickBtnCancel();
	
	TestLogger.info("Expect : User CAN see/do: " + "Redirect to screen 'User Defined Values'");
	
	if(userDefinedValues.isLblUserDefinedValuesDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Redirect to screen 'User Defined Values'");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Redirect to screen 'User Defined Values'");
	}
	
	TestLogger.info("4. Access to Edit Field Values of Reason For Leaving The Job >> Click click on button 'Close'");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	editFieldValues.clickBtnClose();
	
	TestLogger.info("Expect : User CAN see/do: " + "Redirect to screen 'User Defined Values");
	
	if(userDefinedValues.isLblUserDefinedValuesDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Redirect to screen 'User Defined Values");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Redirect to screen 'User Defined Values");
	}
	
	TestLogger.info("5. Access to Edit Field Values of Reason For Leaving The Job >> Switch values ON/OFF");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	Thread.sleep(2000);
	editFieldValues.clickOFF();
	
	TestLogger.info("Expect : User CAN see/do: " + "Update value's status to Inactive");
	
	if(editFieldValues.isStatusOFFisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Update value's status to Inactive");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Update value's status to Inactive");
	}
	
	editFieldValues.clickON();
	
	TestLogger.info("Expect : User CAN see/do: " + "Update value's status to Active");
	
	if(editFieldValues.isStatusONDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Update value's status to Active");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Update value's status to Active");
	}
	
	editFieldValues.clickBtnCancel();
	
	TestLogger.info("6. Access to Edit Field Values of Reason For Leaving The Job >> Add Duplicate");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	editFieldValues.fillTxtValues1(DataManager.FunctionSet);
	editFieldValues.clickIconAdd1();
	editFieldValues.fillTxtValues2(DataManager.FunctionSet);
	editFieldValues.clickBtnSave();
	
	TestLogger.info("Expect : User CAN see/do: " + "Value already exists");
	
	if(editFieldValues.isMsgDuplicateDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Value already exists");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Value already exists");
	}
	
	editFieldValues.clickBtnCancel();
	
	TestLogger.info("7. Access to Edit Field Values of Reason For Leaving The Job >> Remove value");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	editFieldValues.clickIconRemove1();
	
	TestLogger.info("Expect : User CAN see/do: " + "Are you sure you want to remove the selected value?");
	
	if(editFieldValues.isLblConfirmationDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Are you sure you want to remove the selected value?");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Are you sure you want to remove the selected value?");
	}
	
	editFieldValues.clickBtnNo();
	editFieldValues.clickBtnCancel();
	
	TestLogger.info("8. Access to Edit Field Values of Reason For Leaving The Job >> Click on button 'Save'");
	
	userDefinedValues.clickBtnEditReasonForLeavingTheJob();
	
	if (userDefinedValues.isLblUserDefinedValuesDisplayed() == true) {
		setStatusTest("pass", "Access to Edit Field Values popup");
		} else {
		setStatusTest("fail", "Not Access to Edit Field Values popup");		
	}
	
	editFieldValues.clickBtnSave();
	
	TestLogger.info("Expect : User CAN see/do: " + "Reason For Leaving The Job updated successfully");
	
	if(DataManager.isMsgSuccessDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Reason For Leaving The Job updated successfully");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Reason For Leaving The Job updated successfully");
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
