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
import wize.pages.Form_Duplicate_JobGoalLine;
import wize.pages.GoalLine;
import wize.pages.LoginScreen;

public class Test_Functional_GoalLineJob extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	GoalLine goalLineList;
	Form_Duplicate_JobGoalLine duplicateJobGoalLine;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		goalLineList = new GoalLine(driver);
		duplicateJobGoalLine = new Form_Duplicate_JobGoalLine(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = false)
	public void TT_22619_TT_22620(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Job");
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
		TestLogger.info("4. Click icon Duplicate");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed properly \n TT_22619 is PASSED");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed properly \n TT_22619 is FAILED");
		}
		
		duplicateJobGoalLine.clickBtnCloseDuplicate();
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "Form Duplicate is closed properly \n TT_22620 is PASSED");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT closed properly \n TT_22620 is FAILED");
		}
	}
	
	@Test(priority = 2, enabled = false)
	public void TT_22696_TT_22722(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Job");
		goalLineList.clickTabJob();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		TestLogger.info("4. Click icon Duplicate");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed");
		}
		TestLogger.info("5. Select Goal End Date = 16/12/2020");
		duplicateJobGoalLine.switchToFinancialType();
		duplicateJobGoalLine.clickRadioRepeat();
		duplicateJobGoalLine.setCalendarEndDate();
		TestLogger.info("Expected: display error message M216");
		duplicateJobGoalLine.clickBtnSaveDuplicate();
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("The duration of the goal must be shorter than how frequently it occurs. Please shorten the duration, or change the repeat pattern of the goal.")){
			setStatusTest("pass", "Message M216 is displayed \n TT_22696 is PASSED");
		}else{
			setStatusTest("fail", "Message M216 is NOT displayed \n TT_22696 is FAILED");
		}
		duplicateJobGoalLine.clickBtnCancelDuplicate();
		TestLogger.info("6. Click icon Duplicate again");
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed");
		}
		TestLogger.info("7. Select Goal End Date = 16/12/2020");
		duplicateJobGoalLine.switchToNonFinancialType();
		duplicateJobGoalLine.switchToFinancialType();
		duplicateJobGoalLine.switchToNonFinancialType();
		duplicateJobGoalLine.clickRadioRepeat();
		duplicateJobGoalLine.setCalendarEndDate();
		duplicateJobGoalLine.fillChecklist("desc");
		TestLogger.info("Expected: display error message M216");
		duplicateJobGoalLine.clickBtnSaveDuplicate();
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("The duration of the goal must be shorter than how frequently it occurs. Please shorten the duration, or change the repeat pattern of the goal.")){
			setStatusTest("pass", "Message M216 is displayed \n TT_22722 is PASSED");
		}else{
			setStatusTest("fail", "Message M216 is NOT displayed \n TT_22722 is FAILED");
		}
	}
	
	@Test(priority = 3, enabled = false)
	public void TT_22826(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Job");
		goalLineList.clickTabJob();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		TestLogger.info("4. Click icon Duplicate");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed");
		}
		TestLogger.info("5. Click btn Save");
		duplicateJobGoalLine.fillGoalName(DataManager.Test + 1);
		duplicateJobGoalLine.switchToNonFinancialType();
		duplicateJobGoalLine.fillChecklist("desc");
		duplicateJobGoalLine.clickBtnSaveDuplicate();
		TestLogger.info("Expected: 1. msg successful is displayed \n2. close form duplicate \n3. new goal is displayed in the goal list");
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("Job Goal created successfully.")){
			setStatusTest("pass", "Goal is created successfully");
		}else{
			setStatusTest("fail", "Goal is NOT created successfully");
		}
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "Duplicate form is closed");
		}else{
			setStatusTest("fail", "Duplicate form is NOT closed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test+1);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Newly created goal is displayed in the goal list");
		}else{
			setStatusTest("fail", "Newly created goal is NOT displayed in the goal list");
		}
	}
	
	@Test(priority = 4, enabled = true)
	public void TT_22828_TT_22832(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Job");
		goalLineList.clickTabJob();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		TestLogger.info("4. Click icon Duplicate");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed");
		}
		TestLogger.info("5. Click btn Save And Duplicate");
		duplicateJobGoalLine.fillGoalName(DataManager.Test + 2);
		duplicateJobGoalLine.switchToNonFinancialType();
		duplicateJobGoalLine.fillChecklist("desc");
		duplicateJobGoalLine.clickBtnSaveAndDuplicate();
		TestLogger.info("Expected: 1. msg successful is displayed \n2. form duplicate still opens \n3. all values are back to default");
		if(goalLineList.isMsgSuccessDisplayed() && goalLineList.getMsgSuccess().equals("Job Goal created successfully.")){
			setStatusTest("pass", "Goal is created successfully");
		}else{
			setStatusTest("fail", "Goal is NOT created successfully");
		}
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Duplicate form is still opened");
		}else{
			setStatusTest("fail", "Duplicate form is NOT opened");
		}
		if(duplicateJobGoalLine.isFinancialChecked()){
			setStatusTest("pass", "all values are back to default");
		}else{
			setStatusTest("fail", "all values are not back to default");
		}
		duplicateJobGoalLine.clickBtnCancelDuplicate();
		goalLineList.fillSearchGoalName(DataManager.Test+2);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Newly created goal is displayed in the goal list");
		}else{
			setStatusTest("fail", "Newly created goal is NOT displayed in the goal list");
		}
	}
	
	@Test(priority = 5, enabled = false)
	public void TT_22830(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Job");
		goalLineList.clickTabJob();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkFirstJob();
		TestLogger.info("4. Click icon Duplicate");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.clickIconDuplicate();
		if(duplicateJobGoalLine.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form Duplicate is displayed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT displayed");
		}
		TestLogger.info("5. Edit goal name");
		duplicateJobGoalLine.fillGoalName("New goal name");
		duplicateJobGoalLine.clickBtnCancelDuplicate();
		TestLogger.info("Expected: duplicate form is closed");
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "Form Duplicate is closed");
		}else{
			setStatusTest("fail", "Form Duplicate is NOT closed");
		}
		TestLogger.info("Expected: new goal is not displayed in goal list");
		goalLineList.fillSearchGoalName("New goal name");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("fail", "New goal is displayed");
		}else{
			setStatusTest("pass", "New goal is NOT displayed");
		}
		// clear test data
		goalLineList.fillSearchGoalName(DataManager.Test);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			goalLineList.deleteAllGoal();
			if(goalLineList.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Goal is deleted successfully");
			}else{
				setStatusTest("fail", "Goal is NOT deleted successfully");
			}
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


