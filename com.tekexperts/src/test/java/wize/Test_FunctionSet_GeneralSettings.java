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
import wize.pages.Form_EditFieldValues;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.GeneralSettings;
import wize.pages.GeneralSettings_LearningURL;
import wize.pages.GeneralSettings_Organization;
import wize.pages.GeneralSettings_Skill;
import wize.pages.GeneralSettings_UserDefinedValues;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_FunctionSet_GeneralSettings extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	GeneralSettings generalSettings;
	GeneralSettings_Skill generalSettingsSkill;
	GeneralSettings_Organization generalSettingsOrganization;
	GeneralSettings_LearningURL generalSettingsLearningURL;
	GeneralSettings_UserDefinedValues userDefineValue;
	Form_EditFieldValues form_editfieldValues;
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
		generalSettings = new GeneralSettings(driver);
		generalSettingsSkill = new GeneralSettings_Skill(driver);
		generalSettingsOrganization = new GeneralSettings_Organization(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		generalSettingsLearningURL = new GeneralSettings_LearningURL(driver);
		userDefineValue = new GeneralSettings_UserDefinedValues(driver);
		form_editfieldValues = new Form_EditFieldValues(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)

	public void TT25561() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| Full Permission");
		
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
			setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
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
		Thread.sleep(2000);
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
		
		TestLogger.info("6. Access to General Settings >> Skill");

		controlBoard.clickLblGeneralSettings();
		
		if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
			setStatusTest("pass", "Access to General Settings");
		} else {
			setStatusTest("fail", "Not Access to General Settings");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n" 
				+ "2. Menu Organization\r\n"
				+ "3. Menu Learning URL\r\n"
				+ "4. User defined values");
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		if (generalSettings.isSubMenuLearningURLDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Learning URL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Learning URL");
		}
		
		if (generalSettings.isSubMenuUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu User Defined Values");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu User Defined Values");
		}
				
		TestLogger.info("7. Update General Settings");
		
		generalSettingsSkill.clickBtnRadio9();
		generalSettingsSkill.clickBtnRadio10();
		
		if (generalSettingsSkill.isBtnSavelDisplayed() == true) 
		{
			generalSettingsSkill.clickBtnSave();
			generalSettingsSkill.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill level updated successfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill level updated successfully");
			}
			
			generalSettings.clickSubMenuOrganization();
			
		} 
		else 
		{
			generalSettingsSkill.clickBtnRadio10();
			
			if (generalSettingsSkill.isBtnSavelDisplayed() == true) 
			{
				generalSettingsSkill.clickBtnSave();
				generalSettingsSkill.clickBtnYes();
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass","Displays msg: " + "Skill level updated successfully");
				} else {
					setStatusTest("fail","NOT Displays msg: " + "Skill level updated successfully");
				}
				
				generalSettings.clickSubMenuOrganization();
			} 
		}
			
	TestLogger.info("8. Access to General Settings >> Organization");
	
	generalSettingsOrganization.clickBtnRadio();
	generalSettingsOrganization.clickBtnRadio();
	generalSettingsOrganization.clickBtnSave();
	
	TestLogger.info("Expect : User CAN see/do: " + "Dimension activated successfully");
	
	if(DataManager.isMsgSuccessDisplayed() == true)
	{
		setStatusTest("pass", "User CAN see/do: " + "Dimension activated successfully");
	} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Dimension activated successfully");
	}
	
	TestLogger.info("9. Access to General Settings >> Learning URL");
	generalSettings.clickSubMenuLearningURL();
	if(generalSettingsLearningURL.isTxtURLDisplayed()){
		generalSettingsLearningURL.clickBtnOFF();
	}else{
		generalSettingsLearningURL.clickBtnON();
	}
	generalSettingsLearningURL.clickBtnSave();
	if(DataManager.isMsgSuccessDisplayed()){
		setStatusTest("pass", "Edit learning URL successfully");
	}else{
		setStatusTest("fail", "Edit learning URL NOT successfully");
	}
	
	TestLogger.info("10. Access to General Settings >> User Defined Values");
	generalSettings.clickSubMenuUserDefinedValues();
	userDefineValue.clickBtnEditDocumentType();
	Thread.sleep(3000);
	if(form_editfieldValues.isLblEditFieldValuesDisplayed()){
		setStatusTest("pass", "Open form edit field values");
	}else{
		setStatusTest("fail", "NOT Open form edit field values");
	}
	form_editfieldValues.fillTxtValues1("ab");
	form_editfieldValues.clickBtnSave();
	if(DataManager.isMsgSuccessDisplayed()){
		setStatusTest("pass", "Edit learning URL successfully");
	}else{
		setStatusTest("fail", "Edit learning URL NOT successfully");
	}
}

	
	@Test(priority = 2, enabled = true)

	public void TT25562() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
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
		
		TestLogger.info("5. Access to General Settings >> Skill");

		controlBoard.clickLblGeneralSettings();
		
		if (generalSettingsSkill.isLblSkillDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "Not Access to Skill");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n" 
				+ "2. Menu Organization");
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
		
		TestLogger.info("6. Access to General Settings >> Organization");
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Swicth Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Swicth Button");
		} else {
			setStatusTest("fail", "User CAN click on Swicth Button");
		}
		
		TestLogger.info("7. Access to General Settings >> Learning URL");
		generalSettings.clickSubMenuLearningURL();
		if(generalSettingsLearningURL.isLblLearingURLDisplayed()){
			setStatusTest("pass", "Display learning URL settings");
		}else{
			setStatusTest("fail", "NOT Display learning URL settings");
		}
		if(!generalSettingsLearningURL.getStatusBtnON() && !generalSettingsLearningURL.getStatusBtnOFF()){
			setStatusTest("pass", "CANNOT edit learning URL");
		}else{
			setStatusTest("fail", "CAN edit learning URL");
		}
		
		TestLogger.info("8. Access to General Settings >> User Defined Values");
		generalSettings.clickSubMenuUserDefinedValues();
		if(userDefineValue.isLblUserDefinedValuesDisplayed()){
			setStatusTest("pass", "Display User defined values settings");
		}else{
			setStatusTest("fail", "NOT Display User defined values settings");
		}
		if(!userDefineValue.isBtnEditDocumentTypeClickable()){
			setStatusTest("pass", "CANNOT edit document type");
		}else{
			setStatusTest("fail", "CAN edit document type");
		}
	}

	@Test(priority = 3, enabled = true)

	public void TT25565() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| Update System Skill Level Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
				
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickONbtnUpdateSystemSkillLevel();
		cloneForm.clickOFFbtnUpdateSystemDimensions();
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
		
		TestLogger.info("5. Access to General Settings >>  Skill");

		controlBoard.clickLblGeneralSettings();
		
		if (generalSettingsSkill.isLblSkillDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "NOT Access to Skill");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n" 
				+ "2. Menu Organization");
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
				
		TestLogger.info("6. Update General Settings");
		
		generalSettingsSkill.clickBtnRadio9();
		generalSettingsSkill.clickBtnRadio10();
		
		if (generalSettingsSkill.isBtnSavelDisplayed() == true) 
		{
			generalSettingsSkill.clickBtnSave();
			generalSettingsSkill.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill level updated successfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill level updated successfully");
			}
		} 
		else 
		{
			generalSettingsSkill.clickBtnRadio10();
			
			if (generalSettingsSkill.isBtnSavelDisplayed() == true) 
			{
				generalSettingsSkill.clickBtnSave();
				generalSettingsSkill.clickBtnYes();
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass","Displays msg: " + "Skill level updated successfully");
				} else {
					setStatusTest("fail","NOT Displays msg: " + "Skill level updated successfully");
				}
			} 
		}
			
	TestLogger.info("7. Access to General Settings >> Organization");
	
	generalSettings.clickSubMenuOrganization();
	
	if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
		setStatusTest("pass", "Access to Organization");
	} else {
		setStatusTest("fail", "NOT Access to Organization");
	}

	TestLogger.info("Expect : User CANNOT click on Swicth Button");
	
	if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
		setStatusTest("pass", "User CANNOT click on Swicth Button");
	} else {
		setStatusTest("fail", "User CAN click on Swicth Button");
	}
}
		
	@Test(priority = 4, enabled = true)

	public void TT25564() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| Update System Dimensions Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickONbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
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
		
		TestLogger.info("5. Access to General Settings >> Organization");

		controlBoard.clickLblGeneralSettings();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n" 
				+ "2. Menu Organization");
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
			
		TestLogger.info("6. Update Organization");
		
		generalSettingsOrganization.clickBtnRadio();
		generalSettingsOrganization.clickBtnRadio();
		generalSettingsOrganization.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Dimension activated successfully");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "User CAN see/do: " + "Dimension activated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Dimension activated successfully");
		}
			
		TestLogger.info("7. Access to General Settings >> Skill");

		generalSettings.clickSubMenuSkill();
		
		if (generalSettingsSkill.isLblSkillDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "NOT Access to Skill");
		}
		
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
		setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
	}	

	@Test(priority = 5, enabled = true)

	public void TT25563() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFbtnRadioGeneralSettings();
		cloneForm.clickONbtnRadioUser();
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
		
		TestLogger.info("5. Expect : User CANNOT see/do: " + "hyperlink Job in Control Board");
		if (controlBoard.isLblGeneralSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink General Settings in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink General Settings in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do General Settings subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkGeneralSettingsOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do General Settings sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do General Settings on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access General Settings via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Configuration");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access General Settings");
		}else{
			setStatusTest("fail", "User CAN access normally");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT25566() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View General Settings + View User Defined Values Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickOFFbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
		cloneForm.clickONbtnViewUserDefinedValues();
		cloneForm.clickOFFbtnUpdateUserDefinedValues();
		cloneForm.clickOFFbtnUpdateLearningURL();
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
		
		TestLogger.info("5. Access to General Settings >> User Defined Values");

		controlBoard.clickLblGeneralSettings();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n"
				+ "2. Menu Organization\r\n"
				+ "3. Menu Learning URL\r\n" 
				+ "4. Menu User Defined Values");
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		if (generalSettings.isSubMenuLearningURLDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Learning URL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Learning URL");
		}
		
		if (generalSettings.isSubMenuUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu User Defined Values");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu User Defined Values");
		}
		
		generalSettings.clickSubMenuUserDefinedValues();
		
		if (userDefineValue.isLblUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "Access to User Defined Values");
		} else {
			setStatusTest("fail", "NOT Access to User Defined Values");
		}
			
		TestLogger.info("6. User CANNOT see btn Edit Document Type");
		if(!userDefineValue.isBtnEditDocumentTypeClickable()){
			setStatusTest("pass", "CANNOT edit Document Type");
		}else{
			setStatusTest("pass", "CAN edit Document Type");
		}
		
		TestLogger.info("7. Access Skill section");
		generalSettings.clickSubMenuSkill();
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
		
		TestLogger.info("8. Access to General Settings >> Organization");
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Swicth Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Swicth Button");
		} else {
			setStatusTest("fail", "User CAN click on Swicth Button");
		}
		
		TestLogger.info("9. Access to General Settings >> Learning URL");
		generalSettings.clickSubMenuLearningURL();
		if(generalSettingsLearningURL.isLblLearingURLDisplayed()){
			setStatusTest("pass", "Display learning URL settings");
		}else{
			setStatusTest("fail", "NOT Display learning URL settings");
		}
		if(!generalSettingsLearningURL.getStatusBtnON() && !generalSettingsLearningURL.getStatusBtnOFF()){
			setStatusTest("pass", "CANNOT edit learning URL");
		}else{
			setStatusTest("fail", "CAN edit learning URL");
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void TT25567() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View General Settings + Update User Defined Values Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickOFFbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
		cloneForm.clickOFFbtnViewUserDefinedValues();
		cloneForm.clickONbtnUpdateUserDefinedValues();
		cloneForm.clickOFFbtnUpdateLearningURL();
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
		
		TestLogger.info("5. Access to General Settings");

		controlBoard.clickLblGeneralSettings();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n"
				+ "2. Menu Organization\r\n"
				+ "3. Menu Learning URL"); 
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		if (generalSettings.isSubMenuLearningURLDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Learning URL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Learning URL");
		}
		
		if (generalSettings.isSubMenuUserDefinedValuesDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Menu User Defined Values");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Menu User Defined Values");
		}
		
		TestLogger.info("7. Access Skill section");
		generalSettings.clickSubMenuSkill();
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
		
		TestLogger.info("8. Access to General Settings >> Organization");
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Swicth Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Swicth Button");
		} else {
			setStatusTest("fail", "User CAN click on Swicth Button");
		}
		
		TestLogger.info("9. Access to General Settings >> Learning URL");
		generalSettings.clickSubMenuLearningURL();
		if(generalSettingsLearningURL.isLblLearingURLDisplayed()){
			setStatusTest("pass", "Display learning URL settings");
		}else{
			setStatusTest("fail", "NOT Display learning URL settings");
		}
		if(!generalSettingsLearningURL.getStatusBtnON() && !generalSettingsLearningURL.getStatusBtnOFF()){
			setStatusTest("pass", "CANNOT edit learning URL");
		}else{
			setStatusTest("fail", "CAN edit learning URL");
		}
	}
	
	@Test (priority = 8, enabled = true)
	public void TT25568() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View General Settings + View & Update User Defined Values Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickOFFbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
		cloneForm.clickONbtnViewUserDefinedValues();
		cloneForm.clickONbtnUpdateUserDefinedValues();
		cloneForm.clickOFFbtnUpdateLearningURL();
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
		
		TestLogger.info("5. Access to General Settings >> User Defined Values");

		controlBoard.clickLblGeneralSettings();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n"
				+ "2. Menu Organization\r\n"
				+ "3. Menu Learning URL\r\n"
				+ "4. Menu User Defined Values"); 
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		if (generalSettings.isSubMenuLearningURLDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Learning URL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Learning URL");
		}
		
		if (generalSettings.isSubMenuUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu User Defined Values");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu User Defined Values");
		}
		
		generalSettings.clickSubMenuUserDefinedValues();
		
		if (userDefineValue.isLblUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "Access to User Defined Values");
		} else {
			setStatusTest("fail", "NOT Access to User Defined Values");
		}
			
		TestLogger.info("6. User CAN see btn Edit Document Type");
		if(userDefineValue.isBtnEditDocumentTypeClickable()){
			setStatusTest("pass", "CAN edit Document Type");
		}else{
			setStatusTest("pass", "CANNOT edit Document Type");
		}
		form_editfieldValues.clickBtnCancel();
		
		TestLogger.info("7. Access Skill section");
		generalSettings.clickSubMenuSkill();
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
		
		TestLogger.info("8. Access to General Settings >> Organization");
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Swicth Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Swicth Button");
		} else {
			setStatusTest("fail", "User CAN click on Swicth Button");
		}
		
		TestLogger.info("9. Access to General Settings >> Learning URL");
		generalSettings.clickSubMenuLearningURL();
		if(generalSettingsLearningURL.isLblLearingURLDisplayed()){
			setStatusTest("pass", "Display learning URL settings");
		}else{
			setStatusTest("fail", "NOT Display learning URL settings");
		}
		if(!generalSettingsLearningURL.getStatusBtnON() && !generalSettingsLearningURL.getStatusBtnOFF()){
			setStatusTest("pass", "CANNOT edit learning URL");
		}else{
			setStatusTest("fail", "CAN edit learning URL");
		}
	}
	
	@Test (priority = 9, enabled = true)
	public void TT25569() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|General Settings| View General Settings + View & Update User Defined Values Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit General Settings popup");
		} else {
			setStatusTest("fail", "NOT Open Edit General Settings popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewGeneralSettings();
		cloneForm.clickOFFbtnUpdateSystemDimensions();
		cloneForm.clickOFFbtnUpdateSystemSkillLevel();
		cloneForm.clickOFFbtnViewUserDefinedValues();
		cloneForm.clickOFFbtnUpdateUserDefinedValues();
		cloneForm.clickONbtnUpdateLearningURL();
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
		
		TestLogger.info("5. Access to General Settings >> User Defined Values");

		controlBoard.clickLblGeneralSettings();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Menu Skill\r\n"
				+ "2. Menu Organization\r\n"
				+ "3. Menu Learning URL\r\n"
				+ "4. Menu User Defined Values"); 
		
		if (generalSettings.isSubMenuSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Skill");
		}
		
		if (generalSettings.isSubMenuOrganizationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Organization");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Organization");
		}
		
		if (generalSettings.isSubMenuLearningURLDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Menu Learning URL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Menu Learning URL");
		}
		
		if (!generalSettings.isSubMenuUserDefinedValuesDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do: " + "Menu User Defined Values");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Menu User Defined Values");
		}
		
		TestLogger.info("7. Access Skill section");
		generalSettings.clickSubMenuSkill();
		TestLogger.info("Expect : User CANNOT click on Radio Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Radio Button");
		} else {
			setStatusTest("fail", "User CAN click on Radio Button");
		}
		
		TestLogger.info("8. Access to General Settings >> Organization");
		
		generalSettings.clickSubMenuOrganization();
		
		if (generalSettingsOrganization.isLblOrganizationDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "NOT Access to Organization");
		}
		
		TestLogger.info("Expect : User CANNOT click on Swicth Button");
		
		if (generalSettingsSkill.isLblDisabledDisplayed() == true) {
			setStatusTest("pass", "User CANNOT click on Swicth Button");
		} else {
			setStatusTest("fail", "User CAN click on Swicth Button");
		}
		
		TestLogger.info("9. Access to General Settings >> Learning URL");
		generalSettings.clickSubMenuLearningURL();
		if(generalSettingsLearningURL.isLblLearingURLDisplayed()){
			setStatusTest("pass", "Display learning URL settings");
		}else{
			setStatusTest("fail", "NOT Display learning URL settings");
		}
		if(generalSettingsLearningURL.getStatusBtnON() && generalSettingsLearningURL.getStatusBtnOFF()){
			setStatusTest("pass", "CAN edit learning URL");
		}else{
			setStatusTest("fail", "CANNOT edit learning URL");
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
