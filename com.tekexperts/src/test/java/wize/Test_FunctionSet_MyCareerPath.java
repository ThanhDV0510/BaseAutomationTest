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
import wize.pages.Form_AddMoreCreatePath;
import wize.pages.Form_EditMoreCreatePath;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.GeneralSettings;
import wize.pages.GeneralSettings_LearningURL;
import wize.pages.LoginScreen;
import wize.pages.MySpace;
import wize.pages.MyTalent;
import wize.pages.MyTalent_MyCareerPath;
import wize.pages.UserManagement;

public class Test_FunctionSet_MyCareerPath extends TestManager {
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
	MyTalent_MyCareerPath myCareerPath;
	Form_AddMoreCreatePath addMoreCreatePath;
	Form_EditMoreCreatePath editMoreCreatePath;
	
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
		myCareerPath = new MyTalent_MyCareerPath(driver);
		addMoreCreatePath = new Form_AddMoreCreatePath(driver);
		editMoreCreatePath = new Form_EditMoreCreatePath(driver);
		
		learningURL = new GeneralSettings_LearningURL(driver);
		generalSettings = new GeneralSettings(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25483() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Career Path | Full Permission");
		
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
		
		if (myTalent.isTabMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}

		TestLogger.info("7. Access to My Career Path");
			
		myTalent.clickTabMyCareerPath();
		
		if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "Access My Career Path");
		} else {
			setStatusTest("fail", "Not Access My Career Path");
		}
		
		TestLogger.info("8. Create new Carreer Path success");
		
		myCareerPath.clickBtnCreate();
		
		if (addMoreCreatePath.isLblAddMoreCreatePathDisplayed() == true) {
			setStatusTest("pass", "Access Add More areer Path");
		} else {
			setStatusTest("fail", "Not Access Add More areer Path");
		}
		
		addMoreCreatePath.clickDrplistNextPosition();
		addMoreCreatePath.clickItemFirstNext();
		addMoreCreatePath.clickDrplstAfterPosition();
		addMoreCreatePath.clickItemFirstAfter();
		addMoreCreatePath.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add More areer Path Success");
		} else {
			setStatusTest("fail", "Add More areer Path Fail");
		}
		
		driver.navigate().refresh();
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Create button\r\n"
				+ "3. Edit button\r\n"
				+ "4. Delete button\r\n"
				+ "5. Keep Learning button");
		
		if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		if (myCareerPath.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create button");
		}
		
		if (myCareerPath.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
		}
		
		if (myCareerPath.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete button");
		}
						
		if (myCareerPath.isBtnKeepLearningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Keep Learning button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Keep Learning button");
		}
		
		TestLogger.info("9. Update Carreer Path success");
		
		myCareerPath.clickBtnEdit();
		
		if (editMoreCreatePath.isLblEditMoreCreatePathDisplayed() == true) {
			setStatusTest("pass", "Access Edit More career Path");
		} else {
			setStatusTest("fail", "Not Access Edit More career Path");
		}
		
		editMoreCreatePath.clickDrplistNextPosition();
		editMoreCreatePath.clickItemSecondNext();
		editMoreCreatePath.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Edit More areer Path Success");
		} else {
			setStatusTest("fail", "Edit More areer Path Fail");
		}
		
		TestLogger.info("10. Delete Carreer Path success");
		
		myCareerPath.clickBtnDelete();
		
		if(myCareerPath.isLblConfirmationDisplayed() == true)
		{
			myCareerPath.clickBtnYes();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete career Path Success");
			} else {
				setStatusTest("fail", "Delete career Path Fail");
			}
		}
}
	
	@Test(priority = 2)
	
	public void TT_25485() throws InterruptedException {
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
					
	TestLogger.info("3. Update Function Set| My Career Path | No Permission");	
			
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
	
	TestLogger.info("Expect : User CANNOT see/do: " + "My Career Path");
	
	if (myTalent.isTabMyCareerPathDisplayed() == false) {
		setStatusTest("pass", "User CANNOT see/do: " + "My Career Path");
	} else {
		setStatusTest("fail", "User CAN see/do: " + "My Career Path");
	}
}

	@Test(priority = 3)
	
		public void TT_25488() throws InterruptedException {
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
					
		TestLogger.info("3. Update Function Set| My Career Path | View My Career Path +  Manage Personal Career Path");
			
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
		editFunctionSet.clickONbtnViewMyCareerPath();
		editFunctionSet.clickONbtnManagePersonalCareerPath();
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
		
		if (myTalent.isTabMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "Access My Talent sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Talent sub-tab");
		}
		
		TestLogger.info("7. Access to My Career Path");
		
		myTalent.clickTabMyCareerPath();
		
		if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "Access My Career Path");
		} else {
			setStatusTest("fail", "Not Access My Career Path");
		}
			
		TestLogger.info("8. Create new Carreer Path success");
			
		myCareerPath.clickBtnCreate();
		
		if (addMoreCreatePath.isLblAddMoreCreatePathDisplayed() == true) {
			setStatusTest("pass", "Access Add More areer Path");
		} else {
			setStatusTest("fail", "Not Access Add More areer Path");
		}
			
		addMoreCreatePath.clickDrplistNextPosition();
		addMoreCreatePath.clickItemFirstNext();
		addMoreCreatePath.clickDrplstAfterPosition();
		addMoreCreatePath.clickItemFirstAfter();
		addMoreCreatePath.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add More areer Path Success");
		} else {
			setStatusTest("fail", "Add More areer Path Fail");
		}
		
		driver.navigate().refresh();
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Create button\r\n"
				+ "3. Edit button\r\n"
				+ "4. Delete button");
		
		if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
			
		if (myCareerPath.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create button");
		}
		
		if (myCareerPath.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
		}
			
		if (myCareerPath.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete button");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: "	+ "Keep Learning button");
		
		if (myCareerPath.isBtnKeepLearningDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Keep Learning button");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Keep Learning button");
		}
		
		TestLogger.info("9. Update Carreer Path success");
			
		myCareerPath.clickBtnEdit();
		
		if (editMoreCreatePath.isLblEditMoreCreatePathDisplayed() == true) {
			setStatusTest("pass", "Access Edit More career Path");
		} else {
			setStatusTest("fail", "Not Access Edit More career Path");
		}
		
		editMoreCreatePath.clickDrplistNextPosition();
		editMoreCreatePath.clickItemSecondNext();
		editMoreCreatePath.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Edit More areer Path Success");
			} else {
				setStatusTest("fail", "Edit More areer Path Fail");
		}
		
		TestLogger.info("10. Delete Carreer Path success");
		
		myCareerPath.clickBtnDelete();
		
		if(myCareerPath.isLblConfirmationDisplayed() == true)
		{
			myCareerPath.clickBtnYes();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete career Path Success");
			} else {
				setStatusTest("fail", "Delete career Path Fail");
			}
		}
		
		TestLogger.info("11. Create new Carreer Path success");
		
		myCareerPath.clickBtnCreate();
		
		if (addMoreCreatePath.isLblAddMoreCreatePathDisplayed() == true) {
			setStatusTest("pass", "Access Add More areer Path");
		} else {
			setStatusTest("fail", "Not Access Add More areer Path");
		}
			
		addMoreCreatePath.clickDrplistNextPosition();
		addMoreCreatePath.clickItemFirstNext();
		addMoreCreatePath.clickDrplstAfterPosition();
		addMoreCreatePath.clickItemFirstAfter();
		addMoreCreatePath.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add More areer Path Success");
		} else {
			setStatusTest("fail", "Add More areer Path Fail");
		}
}

	@Test(priority = 4)
	
		public void TT_25487() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Career Path | View My Career Path +  Keep Learning");
			
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
			editFunctionSet.clickONbtnViewMyCareerPath();
			editFunctionSet.clickONbtnCareerKeepLearning();
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
			
			if (myTalent.isTabMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "Access My Talent sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Talent sub-tab");
			}
	
			TestLogger.info("7. Access to My Career Path");
				
			myTalent.clickTabMyCareerPath();
			
			if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "Access My Career Path");
			} else {
				setStatusTest("fail", "Not Access My Career Path");
			}
			
			TestLogger.info("Expect : User CAN see/do: " + "Keep Learning");
			
			if (myCareerPath.isBtnKeepLearningDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Keep Learning");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Keep Learning");
			}
						
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Data table\r\n" 
					+ "2. Create button\r\n"
					+ "3. Edit button\r\n"
					+ "4. Delete button");
			
			if (myCareerPath.isLblMyCareerPathDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Data table");
			}
			
			if (myCareerPath.isBtnCreateDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create button");
			}
			
			if (myCareerPath.isBtnEditDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit button");
			}
			
			if (myCareerPath.isBtnDeleteDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete button");
			}
}

	@Test(priority = 5)
	
		public void TT_25484() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Career Path | View Only");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxSubViewOnly();
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
			
			if (myTalent.isTabMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "Access My Talent sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Talent sub-tab");
			}
	
			TestLogger.info("7. Access to My Career Path");
				
			myTalent.clickTabMyCareerPath();
			
			if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "Access My Career Path");
			} else {
				setStatusTest("fail", "Not Access My Career Path");
			}
			
										
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Data table\r\n" 
					+ "2. Create button\r\n"
					+ "3. Edit button\r\n"
					+ "4. Delete button");
			
			if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Data table");
			}
			
			if (myCareerPath.isBtnCreateDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create button");
			}
			
			if (myCareerPath.isBtnEditDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
			}
			
			if (myCareerPath.isBtnDeleteDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete button");
			}
									
			TestLogger.info("Expect : User CANNOT see/do: " + "Keep Learning button");
			
			if (myCareerPath.isBtnKeepLearningDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Keep Learning button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Keep Learning button");
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
