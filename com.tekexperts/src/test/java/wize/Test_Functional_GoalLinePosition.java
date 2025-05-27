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
import wize.pages.ControlBoard;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_Create_DimensionGoalLine;
import wize.pages.Form_Duplicate_JobGoalLine;
import wize.pages.Form_Inherit_PositionGoalLine;
import wize.pages.GoalLine;
import wize.pages.LoginScreen;
import wize.pages.PositionList;

public class Test_Functional_GoalLinePosition extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	GoalLine goalLineList;
	Form_Create_DimensionGoalLine createDimensionGoalLine;
	PositionList positionList;
	Form_CreatePosition formCreatePosition;
	Form_Duplicate_JobGoalLine duplicateJobGoalLine;
	Form_Inherit_PositionGoalLine inheritPosition;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		goalLineList = new GoalLine(driver);
		createDimensionGoalLine = new Form_Create_DimensionGoalLine(driver);
		positionList = new PositionList(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		duplicateJobGoalLine = new Form_Duplicate_JobGoalLine(driver);
		inheritPosition = new Form_Inherit_PositionGoalLine(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 1, enabled = true)
	public void TT_22938(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Prepare data >> Access to Position list screen >> Create new Position");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblPosition();
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}
		positionList.fillSearchPosition(DataManager.Test);
		if(!positionList.isLinkFirstPostionDisplayed()){
			positionList.clickBtnCreate();
			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}
			
			formCreatePosition.inputData(DataManager.Test,DataManager.Test,DataManager.Test);
			formCreatePosition.clickBtnSave();
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}
		}
		
		TestLogger.info("3. Access to Goal Line screen >> tab Job");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		goalLineList.clickTabJob();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		TestLogger.info("Create data job goal line");
		goalLineList.fillSearchGoalName(DataManager.Test);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			goalLineList.deleteAllGoal();
			if(goalLineList.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Goal is deleted successfully");
			}else{
				setStatusTest("fail", "Goal is NOT deleted successfully");
			}
		}
		goalLineList.clickLinkCreateGoal();
		duplicateJobGoalLine.createFinancialType();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Goal is created successfully");
		}else{
			setStatusTest("fail", "Goal is NOT created successfully");
		}
		goalLineList.clickLinkCreateGoal();
		duplicateJobGoalLine.createFinancialTypeWithParam("abc");
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Goal is created successfully");
		}else{
			setStatusTest("fail", "Goal is NOT created successfully");
		}
		TestLogger.info("4. Back to tab Position >> Open form Inherit Goal Line");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goalLineList.clickTabPosition();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		goalLineList.clickLinkinheritGoal();
		if(inheritPosition.isTitleInheritDisplayed()){
			setStatusTest("pass", "Form inherit is displayed successfully");
		}else{
			setStatusTest("fail", "Form inherit is NOT displayed successfully");
		}
		TestLogger.info("5. Select a job and close form");
		inheritPosition.selectFirstItemJob();
		inheritPosition.clickCkbAllInheritForm();
		inheritPosition.clickBtnCloseInherit();
		try {
			goalLineList.clickLinkCreateGoal();
			setStatusTest("pass", "Form inherit is closed successfully!");
		} catch (Exception e) {
			setStatusTest("fail", "Form inherit is NOT closed successfully");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT_22942(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access Goal Line >> Position tab");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		TestLogger.info("3. Open form inherit from job");
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		goalLineList.clickLinkinheritGoal();
		if(inheritPosition.isTitleInheritDisplayed()){
			setStatusTest("pass", "Form inherit is displayed successfully");
		}else{
			setStatusTest("fail", "Form inherit is NOT displayed successfully");
		}
		TestLogger.info("4. Select a job and save");
		inheritPosition.selectFirstItemJob();
		inheritPosition.clickCkbFirstItemInheritForm();
		inheritPosition.clickBtnInherit();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("Position Goal created successfully.")){
			setStatusTest("pass", "Message M028 is displayed");
		}else{
			setStatusTest("fail", "Message M028 is NOT displayed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Inherit SUCCESSFULLY  \n TT_22942 is PASSED");
		}else{
			setStatusTest("pass", "Inherit UNSUCCESSFULLY  \n TT_22942 is PASSED");
		}
		goalLineList.deleteAllGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Goal is deleted successfully");
		}else{
			setStatusTest("fail", "Goal is NOT deleted successfully");
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void TT_22944(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access Goal Line >> Position tab");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		TestLogger.info("3. Open form inherit from job");
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		goalLineList.clickLinkinheritGoal();
		if(inheritPosition.isTitleInheritDisplayed()){
			setStatusTest("pass", "Form inherit is displayed successfully");
		}else{
			setStatusTest("fail", "Form inherit is NOT displayed successfully");
		}
		TestLogger.info("4. Select a job and save");
		inheritPosition.selectFirstItemJob();
		inheritPosition.clickCkbAllInheritForm();
		inheritPosition.clickBtnInherit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("Position Goal created successfully.")){
			setStatusTest("pass", "Message M028 is displayed");
		}else{
			setStatusTest("fail", "Message M028 is NOT displayed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test);
		if(goalLineList.getTotalGoalInTable() > 1){
			setStatusTest("pass", "Inherit SUCCESSFULLY  \n TT_22944 is PASSED");
		}else{
			setStatusTest("pass", "Inherit UNSUCCESSFULLY  \n TT_22944 is PASSED");
		}
		goalLineList.deleteAllGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Goal is deleted successfully");
		}else{
			setStatusTest("fail", "Goal is NOT deleted successfully");
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
