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
import wize.pages.ContentManagement;
import wize.pages.ControlBoard;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.Onboarding_WelcomeLetter;
import wize.pages.UserManagement;

public class Test_FunctionSet_Onboarding_WelcomeLetter extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
		
	ContentManagement contentManagement;
	Onboarding_WelcomeLetter welcomeLetter;
		
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
		
		contentManagement = new ContentManagement(driver);
		welcomeLetter = new Onboarding_WelcomeLetter(driver);
				
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = true)

	public void TT_25598() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| Content Management | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickSubTabSystem();
		editFunctionSet.clickCboxFullPermission();
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
		
		TestLogger.info("5. Access to Content Management");

		controlBoard.clickLblContentManagement();
		
		if (contentManagement.isLblContentListDisplayed() == true) {
			setStatusTest("pass", "Access to Content Management");
		} else {
			setStatusTest("fail", "Not Access to Content Management");
		}
				
		TestLogger.info("6. Onboarding - Welcome Letter");
		
		contentManagement.clickMenuOnboardingWelcomeLetter();
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Edit button");
		
		if (welcomeLetter.isLblOnboardingWelcomeLetterDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		if (welcomeLetter.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
		}
		
		TestLogger.info("7. Update Onboarding success");
			
		welcomeLetter.clickBtnEdit();
		welcomeLetter.fillTitle(DataManager.lessThan250);
		welcomeLetter.fillContentText(DataManager.lessThan250);		
		welcomeLetter.selectAuthor();
		welcomeLetter.fillAuthorTitle(DataManager.lessThan250);
		welcomeLetter.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg successfull");
		} else {
			setStatusTest("fail", "Not Displays msg successfull");
		}
}
	
	@Test(priority = 2,enabled = true)

	public void TT_25599() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| Content Management | View Only");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickSubTabSystem();
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
		
		TestLogger.info("5. Access to Content Management");

		controlBoard.clickLblContentManagement();
		
		if (contentManagement.isLblContentListDisplayed() == true) {
			setStatusTest("pass", "Access to Content Management");
		} else {
			setStatusTest("fail", "Not Access to Content Management");
		}
				
		TestLogger.info("6. Onboarding - Welcome Letter");
		
		contentManagement.clickMenuOnboardingWelcomeLetter();
			
		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (welcomeLetter.isLblOnboardingWelcomeLetterDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Edit button");
		
		if (welcomeLetter.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Edit button");
		}
}

	@Test(priority = 3)
	
		public void TT_25600() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| Content Management | No Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabControlBoard();
			editFunctionSet.clickSubTabSystem();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnRadioGeneralSettings();
			editFunctionSet.clickONbtnRadioUser();
			editFunctionSet.clickONbtnRadioRole();
			editFunctionSet.clickONbtnRadioFunctionSet();
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
			
			TestLogger.info("5. Access to Content Management");

			TestLogger.info("Expect : User CANNOT see/do: " + "Content Management hyperlink");
			
			if (welcomeLetter.isLblOnboardingWelcomeLetterDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Content Management hyperlink");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Content Management hyperlink");
			}
			
}

	@Test(priority = 4)
	
		public void TT_25601() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| Content Management | View  + Edit Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabControlBoard();
		editFunctionSet.clickSubTabSystem();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONBtnViewWelcomeLetter();
		editFunctionSet.clickONBtnEditWelcomeLetter();
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
		
		TestLogger.info("5. Access to Content Management");

		controlBoard.clickLblContentManagement();
		
		if (contentManagement.isLblContentListDisplayed() == true) {
			setStatusTest("pass", "Access to Content Management");
		} else {
			setStatusTest("fail", "Not Access to Content Management");
		}
				
		TestLogger.info("6. Onboarding - Welcome Letter");
		
		contentManagement.clickMenuOnboardingWelcomeLetter();
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Edit button");
		
		if (welcomeLetter.isLblOnboardingWelcomeLetterDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		if (welcomeLetter.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
		}
		
		TestLogger.info("7. Update Onboarding success");
			
		welcomeLetter.clickBtnEdit();
		welcomeLetter.fillTitle(DataManager.lessThan250);
		welcomeLetter.fillContentText(DataManager.lessThan250);		
		welcomeLetter.selectAuthor();
		welcomeLetter.fillAuthorTitle(DataManager.lessThan250);
		welcomeLetter.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg successfull");
		} else {
			setStatusTest("fail", "Not Displays msg successfull");
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
