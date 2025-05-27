package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.DashBoard;
import wize.pages.LoginScreen;
import wize.pages.MyData;
import wize.pages.MyData_Contact;
import wize.pages.MySkillGap;
import wize.pages.MySpace;

public class Test_Functional_Dashboard extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	MySpace mySpace;
	MyData myData;
	MyData_Contact myDataContract;
	
	DashBoard dashBoard;
	MySkillGap mySkillGap;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		mySpace = new MySpace(driver);
		myDataContract = new MyData_Contact(driver);
		myData = new MyData(driver);
		dashBoard = new DashBoard(driver);
		mySkillGap = new MySkillGap(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_16554() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> Personal Data >> Contract");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isTabMyTalentDisplayed() == true) {
			setStatusTest("pass", "Access to My Space");
		} else {
			setStatusTest("fail", "NOT Access to My Space");
		}
		
		mySpace.clickTabMyData();
		
		if (myData.isSubTabPersonalDataDisplayed() == true) {
			setStatusTest("pass", "Access to Personal Data");
		} else {
			setStatusTest("fail", "NOT Access to Personal Data");
		}
		
		myData.clickSubTabContact();
		
		if (myDataContract.isLblContractInfoDisplayed() == true) {
			setStatusTest("pass", "Access to Contract");
		} else {
			setStatusTest("fail", "NOT Access to Contract");
		}
		
		TestLogger.info("3. Look at Unit/Department");
		
		if (myDataContract.isLblUnitDisplayed() == true) {
			setStatusTest("pass", "Must have a value ");
		} else {
			setStatusTest("fail", "NOT Must have a value ");
		}
		
		TestLogger.info("4. Access to Dashboard");
		
		controlBoard.clickTabDashBoard();
		
		if (dashBoard.isTabMySkillDisplayed() == true) {
			setStatusTest("pass", "Access to Dashboard");
		} else {
			setStatusTest("fail", "NOT Access to Dashboard ");
		}
		
		TestLogger.info("5. Look at Dimension Widget");
		
		if (mySkillGap.isLblUnitDisplayed() == true) {
			setStatusTest("pass", "Value must be the same at step 3");
		} else {
			setStatusTest("fail", "NOT Value must be the same at step 3");
		}
		
	}
		
	@Test(priority = 2)

	public void TT_16555() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to My Space >> Personal Data >> Contract");

		controlBoard.clickTabMySpace();
		
		if (mySpace.isTabMyTalentDisplayed() == true) {
			setStatusTest("pass", "Access to My Space");
		} else {
			setStatusTest("fail", "NOT Access to My Space");
		}
		
		mySpace.clickTabMyData();
		
		if (myData.isSubTabPersonalDataDisplayed() == true) {
			setStatusTest("pass", "Access to Personal Data");
		} else {
			setStatusTest("fail", "NOT Access to Personal Data");
		}
		
		myData.clickSubTabContact();
		
		if (myDataContract.isLblContractInfoDisplayed() == true) {
			setStatusTest("pass", "Access to Contract");
		} else {
			setStatusTest("fail", "NOT Access to Contract");
		}
		
		TestLogger.info("3. Look at Primary Position");
		
		if (myDataContract.isLblPositionDisplayed() == true) {
			setStatusTest("pass", "Must have a value ");
		} else {
			setStatusTest("fail", "NOT Must have a value ");
		}
		
		TestLogger.info("4. Access to Dashboard");
		
		controlBoard.clickTabDashBoard();
		
		if (dashBoard.isTabMySkillDisplayed() == true) {
			setStatusTest("pass", "Access to Dashboard");
		} else {
			setStatusTest("fail", "NOT Access to Dashboard ");
		}
		
		TestLogger.info("5. Look at Position Widget");
		
		if (mySkillGap.isLblPositionDisplayed() == true) {
			setStatusTest("pass", "Value must be the same at step 3");
		} else {
			setStatusTest("fail", "NOT Value must be the same at step 3");
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
