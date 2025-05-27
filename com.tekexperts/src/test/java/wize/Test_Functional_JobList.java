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
import wize.pages.Form_CreateJob;
import wize.pages.Form_CreateJobLevel;
import wize.pages.Form_EditJob;
import wize.pages.Form_JobDetails;
import wize.pages.JobLevelList;
import wize.pages.JobList;
import wize.pages.LoginScreen;

public class Test_Functional_JobList extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	JobList jobList;
	Form_JobDetails formJobDetails;
	Form_CreateJob formCreateJob;
	Form_EditJob formEditJob;
	JobLevelList jobLevelList;
	Form_CreateJobLevel formCreateJobLevel;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		jobList = new JobList(driver);
		formJobDetails = new Form_JobDetails(driver);
		formCreateJob = new Form_CreateJob(driver);
		formEditJob = new Form_EditJob(driver);
		jobLevelList = new JobLevelList(driver);
		formCreateJobLevel = new Form_CreateJobLevel(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_12015() throws InterruptedException {

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

		TestLogger.info("3. Click on Add button >> Input all required field >> Click on button Save");

		jobList.fillSearchJob(DataManager.FunctionSet);
		if (jobList.isLinkFirstJobDisplayed() == true) {
			jobList.deleteJob();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
			}

			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
		} else {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
		}

		TestLogger.info("4. Delete Job");

		jobList.fillSearchJob(DataManager.FunctionSet);
		jobList.deleteJob();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
		}
	}

	@Test(priority = 2)

	public void TT_12009() throws InterruptedException {
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

		TestLogger.info(
				"3. Click on icon Add in the top >> Input all required field >> Click on button Save & Create New");

		jobList.clickBtnCreate();

		if (formCreateJob.isLblCreateJobDisplayed() == true) {
			setStatusTest("pass", "Open Create Job popup");
		} else {
			setStatusTest("fail", "Not Open Create Job popup");
		}

		formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
		formCreateJob.clickBtnSavenCreateNew();
		formCreateJob.clickBtnCancel();

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
				+ "2. Entire forms display as default, no data is inputted");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
		}

		if (formCreateJob.isLblCreateJobDisplayed() == true) {
			setStatusTest("pass", "Entire forms display as default, no data is inputted");
		} else {
			setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
		}
	}

	@Test(priority = 3)

	public void TT_12459() throws InterruptedException {
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

		TestLogger.info("3. Click on Edit button >> Click button Save");

		jobList.fillSearchJob(DataManager.FunctionSet);
		if (jobList.isLinkFirstJobDisplayed() == true) {
			jobList.deleteJob();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
			}

			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
			jobList.fillSearchJob(DataManager.FunctionSet);
		} else {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
			jobList.fillSearchJob(DataManager.FunctionSet);
		}
		jobList.clickIconEdit();

		if (formEditJob.isLblEditJobDisplayed() == true) {
			setStatusTest("pass", "Open Edit Job popup");
		} else {
			setStatusTest("fail", "Not Open Create Job popup");
		}
		formEditJob.fillDescription("change description");
		formEditJob.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job updated successfully\r\n"
				+ "2. Saves updated Job to Job list\r\n" + "3. Redirects to Job List");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job updated successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job updated successfully");
		}

		if (jobList.isLinkFirstJobDisplayed() == true) {
			setStatusTest("pass", "Saves updated Job to Job list");
		} else {
			setStatusTest("fail", "Not Saves updated Job to Job list");
		}

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Redirects to Job List");
		} else {
			setStatusTest("fail", "Not Redirects to Job List");
		}
	}

	@Test(priority = 4)

	public void TT_14545() throws InterruptedException {
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

		TestLogger.info("3. Click on a Job to open detail >> Click on icon Edit in the top right >> Click button Save");

		jobList.fillSearchJob(DataManager.FunctionSet);
		if (jobList.isLinkFirstJobDisplayed() == true) {
			jobList.deleteJob();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
			}

			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
			jobList.fillSearchJob(DataManager.FunctionSet);
		} else {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job created successfully\r\n"
					+ "2. Saves created Job to Job list\r\n" + "3. Redirects to Job List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			if (jobList.isLinkFirstJobDisplayed() == true) {
				setStatusTest("pass", "Saves created Job to Job list");
			} else {
				setStatusTest("fail", "Not Saves created Job to Job list");
			}

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Job List");
			} else {
				setStatusTest("fail", "Not Redirects to Job List");
			}
			jobList.fillSearchJob(DataManager.FunctionSet);
		}
		jobList.clickLinkFirstJob();
		formJobDetails.clickIconEdit();

		if (formEditJob.isLblEditJobDisplayed() == true) {
			setStatusTest("pass", "Open Edit Job popup");
		} else {
			setStatusTest("fail", "Not Open Create Job popup");
		}
		formEditJob.fillDescription("change description");
		formEditJob.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Job updated successfully\r\n"
				+ "2. Saves updated Job to Job list\r\n" + "3. Redirects to Job List");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job updated successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job updated successfully");
		}

		if (jobList.isLinkFirstJobDisplayed() == true) {
			setStatusTest("pass", "Saves updated Job to Job list");
		} else {
			setStatusTest("fail", "Not Saves updated Job to Job list");
		}

		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Redirects to Job List");
		} else {
			setStatusTest("fail", "Not Redirects to Job List");
		}

	}

	@Test(priority = 5)

	public void TT_12286() throws InterruptedException {
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

		TestLogger.info("3. Click on any Job >> Click on Delete button >> Click on NO button");

		jobList.fillSearchJob(DataManager.FunctionSet);
		jobList.clickLinkFirstJob();
		formJobDetails.clickIconDelete();

		if (formJobDetails.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Comfirm popup");
			formJobDetails.clickBtnNo();
		} else {
			setStatusTest("fail", "Not Open Comfirm popup");
		}

		TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");

		if (formJobDetails.isLblJobDetailsDisplayed() == true) {
			setStatusTest("pass", "System closes dialogue message. Nothing changes");
		} else {
			setStatusTest("fail", "System NOT closes dialogue message");
		}

		TestLogger.info("4. Click Yes");

		formJobDetails.clickIconDelete();

		if (formJobDetails.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Comfirm popup");
			formJobDetails.clickBtnYes();
		} else {
			setStatusTest("fail", "Not Open Comfirm popup");
		}

		TestLogger.info("Expect : User CAN see/do: " + "Job deleted successfully.");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
		}
	}

	@Test(priority = 6)

	public void TT_12294() throws InterruptedException {
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

		TestLogger.info("3. Click on icon Delete in Job B's row >> Click on NO button");

		jobList.fillSearchJob(DataManager.FunctionSet);

		if (jobList.isLinkFirstJobDisplayed() == true) {
			jobList.clickIconDelete();

			if (jobList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				formJobDetails.clickBtnNo();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "System closes dialogue message. Nothing changes");
			} else {
				setStatusTest("fail", "System NOT closes dialogue message");
			}
		} else {
			jobList.clickBtnCreate();

			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
			} else {
				setStatusTest("fail", "Not Open Create Job popup");
			}

			formCreateJob.inputData(DataManager.FunctionSet, DataManager.Test, DataManager.Test);
			formCreateJob.clickBtnSave();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}

			jobList.clickIconDelete();

			if (jobList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				formJobDetails.clickBtnNo();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");

			if (jobList.isLblJobListDisplayed() == true) {
				setStatusTest("pass", "System closes dialogue message. Nothing changes");
			} else {
				setStatusTest("fail", "System NOT closes dialogue message");
			}
		}

		TestLogger.info("4. Click Yes");

		jobList.clickIconDelete();

		if (jobList.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Comfirm popup");
			formJobDetails.clickBtnYes();
		} else {
			setStatusTest("fail", "Not Open Comfirm popup");
		}

		TestLogger.info("Expect : User CAN see/do: " + "Job deleted successfully.");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job deleted successfully.");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job deleted successfully.");
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
