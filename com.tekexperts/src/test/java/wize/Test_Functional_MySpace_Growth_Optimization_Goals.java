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
import wize.pages.Baseline_Job;
import wize.pages.ControlBoard;
import wize.pages.Form_Add_Update_Growth_Optimization_GoalLine;
import wize.pages.Form_Add_Update_SkillToBaseline_Job;
import wize.pages.Form_BaselineUpdateConfirmation;
import wize.pages.Form_CloneBaseline;
import wize.pages.Form_CreateJob;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditJob;
import wize.pages.Form_EditPosition;
import wize.pages.Form_JobDetails;
import wize.pages.Form_PositionDetails;
import wize.pages.Goalline_Job;
import wize.pages.Goalline_Left_Panel;
import wize.pages.JobList;
import wize.pages.LoginScreen;
import wize.pages.MySpace_GrowthandOptimization;
import wize.pages.PositionList;

public class Test_Functional_MySpace_Growth_Optimization_Goals extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails positionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	Form_Add_Update_SkillToBaseline_Job formAddUpdateSkillToBaseline;
	Form_Add_Update_Growth_Optimization_GoalLine formAddUpdateMyGoal;
	Goalline_Left_Panel goalline;
	Goalline_Job goallineJob;
	Baseline_Job baselineJob;
	Form_CloneBaseline cloneBaseline;
	Form_BaselineUpdateConfirmation formBaselineUpdateConfirmation;
	MySpace_GrowthandOptimization myGoal;

	JobList jobList;
	Form_JobDetails formJobDetails;
	Form_CreateJob formCreateJob;
	Form_EditJob formEditJob;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		positionList = new PositionList(driver);
		positionDetails = new Form_PositionDetails(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		formEditPosition = new Form_EditPosition(driver);
		formAddUpdateSkillToBaseline = new Form_Add_Update_SkillToBaseline_Job(driver);
		goalline = new Goalline_Left_Panel(driver);
		goallineJob = new Goalline_Job(driver);
		cloneBaseline = new Form_CloneBaseline(driver);
		formBaselineUpdateConfirmation = new Form_BaselineUpdateConfirmation(driver);

		jobList = new JobList(driver);
		formJobDetails = new Form_JobDetails(driver);
		formCreateJob = new Form_CreateJob(driver);
		formEditJob = new Form_EditJob(driver);
		formAddUpdateMyGoal = new Form_Add_Update_Growth_Optimization_GoalLine(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
		myGoal=new MySpace_GrowthandOptimization(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_26358() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailLan, PropertyManager.PASSWORD);
		
		myGoal.clickTabGrowthOptimization();
		// ==========================
		if (myGoal.isLblMyGoalsDisplayed()) {
			setStatusTest("pass", "Open My Goals List");
		} else {
			setStatusTest("fail", "Not Open My Goals List");
		}
		TestLogger.info("6. Create Goal line");
		myGoal.clickBtnAddNewGoals();
		
		if (formAddUpdateMyGoal.isLblGoalNameDisplayed()) {
			setStatusTest("pass", "Open Create My Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create My Goal Line popup");
		}
		//=========check Mandatory=============
		formAddUpdateMyGoal.clickBtnSave();
		//========Goal Name====================
		if (formAddUpdateMyGoal.isGoalNameMandatoryDisplayed()) {
			setStatusTest("pass", "Goal Name mandatory");
		}
		else 
		{
			setStatusTest("fail", "Goal Name does NOT mandatory");
		}
		//========Duration====================
		if (formAddUpdateMyGoal.isDurationMandatoryDisplayed()) {
			setStatusTest("pass", "Duration mandatory");
		}
		else 
		{
			setStatusTest("fail", "Duration does NOT mandatory");
		}
		//========Goal End Date====================
		if (formAddUpdateMyGoal.isGoalEndDateMandatoryDisplayed()) {
			setStatusTest("pass", "Goal End Date mandatory");
		}
		else 
		{
			setStatusTest("fail", "Goal End Date does NOT mandatory");
		}
		//========CheckList====================
		if (formAddUpdateMyGoal.isCheckListMandatoryDisplayed()) {
			setStatusTest("pass", "CheckList mandatory");
		}
		else 
		{
			setStatusTest("fail", "CheckList does NOT mandatory");
		}
		
		
		TestLogger.info("7. Create Goal line");
		formAddUpdateMyGoal.createNonFinancialGoalLine("automation goalline","automation goalline");

		if (formAddUpdateMyGoal.isMsgCreateGoalDisplayed()) {
			setStatusTest("pass", "Create Goal Line is successfully");
		} else {
			setStatusTest("fail", "Create Goal Line is NOT successfully");
		}
		if (myGoal.isLblStatusDraftDisplayed()) {
			setStatusTest("pass", "Status is Draft");
		}
		else 
		{
			setStatusTest("fail", "Status does NOT Draft");
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
