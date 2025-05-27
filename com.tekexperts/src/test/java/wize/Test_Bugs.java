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
import wize.pages.FrontLineManager;
import wize.pages.LoginScreen;
import wize.pages.MySpace;

public class Test_Bugs extends TestManager{
	
	WebDriver driver;
	PropertyManager propertyManager;
	LoginScreen loginScreen;
	ControlBoard controlBoard;
	MySpace mySpace;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {
		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		mySpace = new MySpace(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 0)
	
	//Bug WP-3220
	public void TT_18963_TT_18964() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		
		loginScreen.SignInWith(PropertyManager.EmailTuan, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to My Space >> My Profile");
		
		mySpace.clickMySpace();
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		mySpace.clickTabMyData();
		
		
		if (mySpace.isTabMyDataDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		
		
			
	}
	
/*	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.quit();
	}*/
}
