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

public class Test_DashBoard_FrontLineManager extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	DashBoard db;
	FrontLineManager frontLine;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {
		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
		db = new DashBoard(driver);
		frontLine = new FrontLineManager(driver);
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 0)
	public void TT_17979() throws InterruptedException{
		
		TestLogger.info("1. Login with account Admin");
		
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Go to Dashboard >> FrontLine Manager");
		
		controlBoard.clickTabDashBoard();
		db.clickTabFrontLineManager();
		
		if(db.isTabFrontLineManagerDisplayed() == true){
			setStatusTest("Pass", "Display tab Front line Manager successfully");
		}else{
			setStatusTest("Pass", "Can not display tab Front line Manager");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. MY TEAM - POSITION FIT\r\n" 
				+ "2. TOP PERCENTAGE FIT\r\n"
				+ "3. BOTTOM PERCENTAGE FIT\r\n"
				+ "4. TOP SKILL AVERAGE VALUE\r\n"
				+ "5. BOTTOM SKILL AVERAGE VALUE");
		
		if (frontLine.isLblMyTeamPositionFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "MY TEAM - POSITION FI");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "MY TEAM - POSITION FI");
		}
		
		if (frontLine.isLblTopPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP PERCENTAGE FIT");
		}
		
		if (frontLine.isLblBottomPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM PERCENTAGE FIT");
		}
		
		if (frontLine.isLblTopSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP SKILL AVERAGE VALUE");
		}
		
		if (frontLine.isLblBottomSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.quit();
	}
}
