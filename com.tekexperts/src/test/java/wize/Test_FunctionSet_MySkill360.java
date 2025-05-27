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
import wize.pages.FunctionSet;
import wize.pages.GeneralSettings;
import wize.pages.GeneralSettings_LearningURL;
import wize.pages.LoginScreen;
import wize.pages.MySpace;
import wize.pages.MyTalent;
import wize.pages.MyTalent_MySkill360;
import wize.pages.UserManagement;

public class Test_FunctionSet_MySkill360 extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
		
	MySpace mySpace;
	MyTalent myTalent;
	MyTalent_MySkill360 mySkill360;
	
	GeneralSettings generalSettings;
	GeneralSettings_LearningURL learningURL;
	
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
		
		mySpace = new MySpace(driver);
		myTalent = new MyTalent(driver);
		mySkill360 = new MyTalent_MySkill360(driver);
		
		learningURL = new GeneralSettings_LearningURL(driver);
		generalSettings = new GeneralSettings(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25476() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Skill 360 | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabMySpace();
		editFunctionSet.clickSubTabMyTalent();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
		editFunctionSet.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Update Learning URL");
		
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGeneralSettings();
		
		if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
			setStatusTest("pass", "Access to General Settings");
		} else {
			setStatusTest("fail", "Not Access to General Settings");
		}
		
		generalSettings.clickSubMenuLearningURL();
		
		if (learningURL.isLblLearingURLDisplayed() == true) {
			setStatusTest("pass", "Access to Learning URL screen");
		} else {
			setStatusTest("fail", "Not Access to Learning URL screen");
		}
		
		if(learningURL.isTxtURLDisplayed() == true)
		{
			controlBoard.logout();
		}
		else
		{
			learningURL.clickBtnON();
			learningURL.fillTxtURL(DataManager.LearningURL);
			learningURL.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Learning URL success");
			} else {
				setStatusTest("fail", "Update Learning URL fail");
			}
			
			if (controlBoard.isAvatarDisplayed() == true) {
				controlBoard.logout();
			}
		}
		
		TestLogger.info("5. Logout >> Login with account User");
		
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
		
		TestLogger.info("6. Access to My Space tab");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("7. Access My Talent sub-tab");
		
		mySpace.clickTabMyTalent();
		
		if (myTalent.isTabMySkill360Displayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}

		TestLogger.info("8. Access to My Skill 360");
			
		myTalent.clickTabMySkill360();
		
		if (mySkill360.isLblMyCompetencyDisplayed() == true) {
			setStatusTest("pass", "Access My Skill 360");
		} else {
			setStatusTest("fail", "Not Access My Skill 360");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Keep Learning button");
		
		if (mySkill360.isLblBaselineDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		if (mySkill360.isBtnKeepLearingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Keep Learning button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Keep Learning button");
		}
}
	
	@Test(priority = 2)

	public void TT_25477() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Skill 360 | View Only");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabMySpace();
		editFunctionSet.clickSubTabMyTalent();
		editFunctionSet.clickCboxViewOnly();
		editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
		editFunctionSet.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Update Learning URL");
		
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGeneralSettings();
		
		if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
			setStatusTest("pass", "Access to General Settings");
		} else {
			setStatusTest("fail", "Not Access to General Settings");
		}
		
		generalSettings.clickSubMenuLearningURL();
		
		if (learningURL.isLblLearingURLDisplayed() == true) {
			setStatusTest("pass", "Access to Learning URL screen");
		} else {
			setStatusTest("fail", "Not Access to Learning URL screen");
		}
		
		if(learningURL.isTxtURLDisplayed() == true)
		{
			controlBoard.logout();
		}
		else
		{
			learningURL.clickBtnON();
			learningURL.fillTxtURL(DataManager.LearningURL);
			learningURL.clickBtnYes();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Learning URL success");
			} else {
				setStatusTest("fail", "Update Learning URL fail");
			}
			
			if (controlBoard.isAvatarDisplayed() == true) {
				controlBoard.logout();
			}
		}
		
		TestLogger.info("5. Logout >> Login with account User");
		
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
		
		TestLogger.info("6. Access to My Space tab");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("7. Access My Talent sub-tab");
		
		mySpace.clickTabMyTalent();
		
		if (myTalent.isTabMySkill360Displayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}

		TestLogger.info("8. Access to My Skill 360");
			
		myTalent.clickTabMySkill360();
		
		if (mySkill360.isLblMyCompetencyDisplayed() == true) {
			setStatusTest("pass", "Access My Skill 360");
		} else {
			setStatusTest("fail", "Not Access My Skill 360");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (mySkill360.isLblBaselineDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + " Keep Learning button");
		
		if (mySkill360.isBtnKeepLearingDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Keep Learning button");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Keep Learning button");
		}
}

	@Test(priority = 3)
	
		public void TT_25478() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Skill 360 | No Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
			editFunctionSet.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
			}
			
			TestLogger.info("4. Update Learning URL");
			
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblGeneralSettings();
			
			if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
				setStatusTest("pass", "Access to General Settings");
			} else {
				setStatusTest("fail", "Not Access to General Settings");
			}
			
			generalSettings.clickSubMenuLearningURL();
			
			if (learningURL.isLblLearingURLDisplayed() == true) {
				setStatusTest("pass", "Access to Learning URL screen");
			} else {
				setStatusTest("fail", "Not Access to Learning URL screen");
			}
			
			if(learningURL.isTxtURLDisplayed() == true)
			{
				controlBoard.logout();
			}
			else
			{
				learningURL.clickBtnON();
				learningURL.fillTxtURL(DataManager.LearningURL);
				learningURL.clickBtnYes();
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Update Learning URL success");
				} else {
					setStatusTest("fail", "Update Learning URL fail");
				}
				
				if (controlBoard.isAvatarDisplayed() == true) {
					controlBoard.logout();
				}
			}
			
			TestLogger.info("5. Logout >> Login with account User");
			
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
			
			TestLogger.info("6. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: " + "My Skill 360");
			
			if (myTalent.isTabMySkill360Displayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "My Skill 360");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "My Skill 360");
			}
}

	@Test(priority = 4)
	
		public void TT_25479() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Skill 360 | View  + Keep Learning Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnRadioMySkill360();
			editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
			editFunctionSet.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
			}
			
			TestLogger.info("4. Update Learning URL");
			
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblGeneralSettings();
			
			if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
				setStatusTest("pass", "Access to General Settings");
			} else {
				setStatusTest("fail", "Not Access to General Settings");
			}
			
			generalSettings.clickSubMenuLearningURL();
			
			if (learningURL.isLblLearingURLDisplayed() == true) {
				setStatusTest("pass", "Access to Learning URL screen");
			} else {
				setStatusTest("fail", "Not Access to Learning URL screen");
			}
			
			if(learningURL.isTxtURLDisplayed() == true)
			{
				controlBoard.logout();
			}
			else
			{
				learningURL.clickBtnON();
				learningURL.fillTxtURL(DataManager.LearningURL);
				learningURL.clickBtnYes();
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Update Learning URL success");
				} else {
					setStatusTest("fail", "Update Learning URL fail");
				}
				
				if (controlBoard.isAvatarDisplayed() == true) {
					controlBoard.logout();
				}
			}
			
			TestLogger.info("5. Logout >> Login with account User");
			
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
			
			TestLogger.info("6. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("7. Access My Talent sub-tab");
			
			mySpace.clickTabMyTalent();
			
			if (myTalent.isTabMySkill360Displayed() == true) {
				setStatusTest("pass", "Access My Talent sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Talent sub-tab");
			}
	
			TestLogger.info("8. Access to My Skill 360");
				
			myTalent.clickTabMySkill360();
			
			if (mySkill360.isLblMyCompetencyDisplayed() == true) {
				setStatusTest("pass", "Access My Skill 360");
			} else {
				setStatusTest("fail", "Not Access My Skill 360");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Data table\r\n" 
					+ "2. Keep Learning button");
			
			if (mySkill360.isLblBaselineDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Data table");
			}
			
			if (mySkill360.isBtnKeepLearingDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Keep Learning button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Keep Learning button");
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
