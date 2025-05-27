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
import wize.pages.LoginScreen;
import wize.pages.MySpace;
import wize.pages.MyTalent;
import wize.pages.MyTalent_MySkill;
import wize.pages.UserManagement;

public class Test_FunctionSet_MySkill extends TestManager {
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
	MyTalent_MySkill mySkill;

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
		mySkill = new MyTalent_MySkill(driver);
	
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25480() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Skill | Full Permission");
		
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
		
		TestLogger.info("5. Access to My Space tab");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("6. Access My Talent sub-tab");
		
		mySpace.clickTabMyTalent();
		
		if (myTalent.isTabMySkillDisplayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}

		TestLogger.info("7. Access to My Skill");
			
		myTalent.clickTabMySkill();
		
		if (mySkill.isLblMySkillDisplayed() == true) {
			setStatusTest("pass", "Access My Skill");
		} else {
			setStatusTest("fail", "Not Access My Skill");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (mySkill.isLblMySkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
}
	
	@Test(priority = 2)

	public void TT_25481() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Skill | View Only");
		
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
		
		TestLogger.info("5. Access to My Space tab");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("6. Access My Talent sub-tab");
		
		mySpace.clickTabMyTalent();
		
		if (myTalent.isTabMySkillDisplayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}

		TestLogger.info("7. Access to My Skill");
			
		myTalent.clickTabMySkill();
		
		if (mySkill.isLblMySkillDisplayed() == true) {
			setStatusTest("pass", "Access My Skill");
		} else {
			setStatusTest("fail", "Not Access My Skill");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (mySkill.isLblMySkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
}

	@Test(priority = 3)
	
		public void TT_25482() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Skill | No Permission");
			
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
			
			TestLogger.info("5. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: " + "My Skill");
			
			if (myTalent.isTabMySkillDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "My Skill");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "My Skill");
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
