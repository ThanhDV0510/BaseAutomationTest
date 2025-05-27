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
import wize.pages.MyData;
import wize.pages.MyData_Contract;
import wize.pages.MySpace;
import wize.pages.UserManagement;

public class Test_FunctionSet_MyData_Contract extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
		
	MySpace mySpace;
	MyData myData;
	MyData_Contract contract;
		
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
		myData = new MyData(driver);
		contract = new MyData_Contract(driver);
				
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25508() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| Contract | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabMySpace();
		editFunctionSet.clickSubTabMyData();
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
				
		TestLogger.info("6. Access My Data sub-tab");
		
		mySpace.clickTabMyData();
		
		if (myData.isSubTabContactDisplayed() == true) {
			setStatusTest("pass", "Access My Data sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Data sub-tab");
		}

		TestLogger.info("7. Access to Contract");
			
		myData.clickSubTabContact();
		
		if (contract.isLblContractInfoDisplayed() == true) {
			setStatusTest("pass", "Access Contract");
		} else {
			setStatusTest("fail", "Not Access Contract");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Contract  block\r\n" 
				+ "2. Work Permit block");
		
		if (contract.isLblContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Contract  block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Contract  block");
		}
		
		if (contract.isLblWorkPermitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Work Permit block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Work Permit block");
		}
}
	
	@Test(priority = 2)
		
			public void TT_25509() throws InterruptedException {
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
						
			TestLogger.info("3. Update Function Set| Contract | View Contract +  Manage Personal Career Path");
				
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
				
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
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
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabContactDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}

			TestLogger.info("7. Access to Contract");
				
			myData.clickSubTabContact();
			
			if (contract.isLblContractInfoDisplayed() == true) {
				setStatusTest("pass", "Access Contract");
			} else {
				setStatusTest("fail", "Not Access Contract");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Contract  block\r\n" 
					+ "2. Work Permit block");
			
			if (contract.isLblContractDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Contract  block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Contract  block");
			}
			
			if (contract.isLblWorkPermitDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Work Permit block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Work Permit block");
			}
	}

	@Test(priority = 3)
	
	public void TT_25510() throws InterruptedException {
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
					
	TestLogger.info("3. Update Function Set| Contract | No Permission");	
			
	functionSet.fillSearchName(DataManager.FunctionSet);
	functionSet.clickIconEdit();
	
	if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
		setStatusTest("pass", "Open Edit Function Set popup");
	} else {
		setStatusTest("fail", "NOT Open Edit Function Set popup");
	}
	
	editFunctionSet.clickTabMySpace();
	editFunctionSet.clickSubTabMyData();
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
	
	TestLogger.info("Expect : User CANNOT see/do: " + "Contract");
	
	if (myData.isSubTabContactDisplayed() == false) {
		setStatusTest("pass", "User CANNOT see/do: " + "Contract");
	} else {
		setStatusTest("fail", "User CAN see/do: " + "Contract");
	}
}

	@Test(priority = 4)
	
		public void TT_25511() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| Contract | View Contract");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyContact();
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
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabContactDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}

			TestLogger.info("7. Access to Contract");
				
			myData.clickSubTabContact();
			
			if (contract.isLblContractDisplayed() == true) {
				setStatusTest("pass", "Access Contract");
			} else {
				setStatusTest("fail", "Not Access Contract");
			}
			
			TestLogger.info("Expect : User CAN see/do: " + "Contract  block");
			
			if (contract.isLblContractDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Contract  block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Contract  block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: " + "Work Permit block");
			
			if (contract.isLblWorkPermitDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Work Permit block");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Work Permit block");
			}
}

	@Test(priority = 5)
	
		public void TT_25512() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| Contract | View Work Permit");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnMyViewWorkPermit();
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
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabContactDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}

			TestLogger.info("7. Access to Contract");
				
			myData.clickSubTabContact();
			
			if (contract.isLblWorkPermitDisplayed() == true) {
				setStatusTest("pass", "Access Contract");
			} else {
				setStatusTest("fail", "Not Access Contract");
			}
			
			TestLogger.info("Expect : User CAN see/do: " + "Work Permit block");
					
			if (contract.isLblWorkPermitDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Work Permit block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Work Permit block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: " + "Contract  block");
			
			if (contract.isLblContractDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Contract  block");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Contract  block");
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
