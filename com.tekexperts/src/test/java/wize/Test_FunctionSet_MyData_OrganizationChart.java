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
import wize.pages.MyData_OrganizationChart;
import wize.pages.MySpace;
import wize.pages.UserManagement;

public class Test_FunctionSet_MyData_OrganizationChart extends TestManager {
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
	MyData_OrganizationChart organizationChart;
	
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
		organizationChart = new MyData_OrganizationChart(driver);
	
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25516() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| Organization Chart | Full Permission");
		
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

		TestLogger.info("7. Access to Organization Chart");
			
		myData.clickSubTabContact();
			
		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (organizationChart.isLblOrganizationChartDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
}
	
	@Test(priority = 2)
		
			public void TT_25517() throws InterruptedException {
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
						
			TestLogger.info("3. Update Function Set| Organization Chart | View Only");
				
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
				
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
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
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabContactDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}

			TestLogger.info("7. Access to Organization Chart");
			
			myData.clickSubTabContact();
				
			TestLogger.info("Expect : User CAN see/do: " + "Data table");
			
			if (organizationChart.isLblOrganizationChartDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Data table");
			}
	}

	@Test(priority = 3)
	
	public void TT_25518() throws InterruptedException {
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
					
	TestLogger.info("3. Update Function Set| Organization Chart | No Permission");	
			
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
	
	TestLogger.info("Expect : User CANNOT see/do: " + "Organization Chart");
	
	if (myData.isSubTabPositionDataDisplayed() == false) {
		setStatusTest("pass", "User CANNOT see/do: " + "Organization Chart");
	} else {
		setStatusTest("fail", "User CAN see/do: " + "Organization Chart");
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
