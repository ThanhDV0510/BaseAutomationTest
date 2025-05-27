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
import wize.pages.Baseline_Job;
import wize.pages.ControlBoard;
import wize.pages.Form_Add_Update_GoalLine_Job;
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
import wize.pages.PositionList;

public class Test_Functional_Goalline_Job extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails positionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	Form_Add_Update_SkillToBaseline_Job formAddUpdateSkillToBaseline;
	Form_Add_Update_GoalLine_Job formAddUpdateGoalLineJob;
	Goalline_Left_Panel goalline;
	Goalline_Job goallineJob;
	Baseline_Job baselineJob;
	Form_CloneBaseline cloneBaseline;
	Form_BaselineUpdateConfirmation formBaselineUpdateConfirmation;

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
		formAddUpdateGoalLineJob = new Form_Add_Update_GoalLine_Job(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = false)

	public void TT_19764() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Create Goal line");
		formAddUpdateGoalLineJob.createGoalLine("automation goalline");

		if (formAddUpdateGoalLineJob.isMsgCreateGoalDisplayed()) {
			setStatusTest("pass", "Create Goal Line is successfully");
		} else {
			setStatusTest("fail", "Create Goal Line is NOT successfully");
		}
	}
	@Test(priority = 2, enabled = true)

	public void TT_19768() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Cancel Goal line");
		formAddUpdateGoalLineJob.cancelGoalLine("cancel this goal line");
		// ==========================
		if (goallineJob.isBtnAddIconDisplayed()) {
			setStatusTest("pass", "Not Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Open Create Goal Line popup");
		}
	}
	@Test(priority = 3, enabled = true)

	public void TT_19683() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Click close button");
		formAddUpdateGoalLineJob.clickBtnClose();

		// ==========================
		if (goallineJob.isBtnAddIconDisplayed()) {
			setStatusTest("pass", "Not Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Open Create Goal Line popup");
		}
	}
	
	@Test(priority = 4, enabled = true)

	public void TT_25029() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Create Non-Financial Goal line");
		formAddUpdateGoalLineJob.createFinancialGoalLine("automation non-financial goal", "automation checklist");

		if (formAddUpdateGoalLineJob.isMsgCreateGoalDisplayed()) {
			setStatusTest("pass", "Create Goal Line is successfully");
		} else {
			setStatusTest("fail", "Create Goal Line is NOT successfully");
		}
	}
	@Test(priority = 5, enabled = true)

	public void TT_19607() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}
		TestLogger.info("7. Click on financial button");
		formAddUpdateGoalLineJob.clickFinancialType();
		
		TestLogger.info("8. Click on close button");
		formAddUpdateGoalLineJob.clickBtnClose();

		// ==========================
		if (goallineJob.isBtnAddIconDisplayed()) {
			setStatusTest("pass", "Not Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Open Create Goal Line popup");
		}
	}
	
	@Test(priority = 6, enabled = true)

	public void TT_19766() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Create Non-Financial Goal line");
		formAddUpdateGoalLineJob.createFinancialGoalLine_SaveCreateNew("automation non-financial goal 2 ", "automation checklist");

		if (formAddUpdateGoalLineJob.isMsgCreateGoalDisplayed()) {
			setStatusTest("pass", "Create Goal Line is successfully");
		} else {
			setStatusTest("fail", "Create Goal Line is NOT successfully");
		}
		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}
	}
		
	@Test(priority = 7, enabled = true)

	public void TT_25034() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job");

		controlBoard.clickLblJob();

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job");
		} else {
			setStatusTest("fail", "Not Access to Job");
		}

		TestLogger.info("3. Create Job List");

		jobList.fillSearchJob(DataManager.GoallineJob);
		if (jobList.isLinkFirstJobDisplayed() == false) {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.GoallineJob, DataManager.GoallineJob, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

		}

		TestLogger.info("4 . Access to Talent >> GoalLine >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		goalline.clickTabJob();

		if (goallineJob.isLblGoalLineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> GoalLine >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> GoalLine >> Job tab");
		}

		goallineJob.fillTxtSearchJob(DataManager.GoallineJob);

		TestLogger.info("5. Click on 'Add Icon' button");
		goallineJob.clickBtnAddIcon();

		TestLogger.info("6. Click on 'Create Goal' button");
		goallineJob.clickBtnCreateGoal();

		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
		}

		TestLogger.info("7. Create Goal line");
		formAddUpdateGoalLineJob.createGoalLine_SaveCreateNew("automation goalline 2");

		if (formAddUpdateGoalLineJob.isMsgCreateGoalDisplayed()) {
			setStatusTest("pass", "Create Goal Line is successfully");
		} else {
			setStatusTest("fail", "Create Goal Line is NOT successfully");
		}
		
		// ==========================
		if (formAddUpdateGoalLineJob.isLblCreateGoalLineDisplayed()) {
			setStatusTest("pass", "Open Create Goal Line popup");
		} else {
			setStatusTest("fail", "Not Open Create Goal Line popup");
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
