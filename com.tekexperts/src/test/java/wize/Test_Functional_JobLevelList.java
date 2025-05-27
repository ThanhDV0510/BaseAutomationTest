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
import wize.pages.Form_CreateJobLevel;
import wize.pages.Form_EditJobLevel;
import wize.pages.Form_JobLevelDetails;
import wize.pages.JobLevelList;
import wize.pages.LoginScreen;

public class Test_Functional_JobLevelList extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	JobLevelList jobLevelList;
	Form_JobLevelDetails formJobLevelDetails;
	Form_CreateJobLevel formCreateJobLevel;
	Form_EditJobLevel formEditJobLevel;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		jobLevelList = new JobLevelList(driver);
		formJobLevelDetails = new Form_JobLevelDetails(driver);
		formCreateJobLevel = new Form_CreateJobLevel(driver);
		formEditJobLevel = new Form_EditJobLevel(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_12358() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job Level");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level");
		} else {
			setStatusTest("fail", "Not Access to Job Level");
		}
		
		TestLogger.info("3. Click on icon Add in the top >> Input all required field >> Click on button Save");
			
		jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
		
		if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
		{
			jobLevelList.deleteJobLevel();
			jobLevelList.clickBtnCreate();
			
			if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Create Job Level popup");
			} else {
				setStatusTest("fail", "Not Open Create Job Level popup");
			}
			
			formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
			formCreateJobLevel.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Job Level created successfully\r\n"
					+ "2. Saves created Job Level to Job Level list\r\n"
					+ "3. Redirects to Job Level List");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
			}
			
			if (jobLevelList.isLinkFirstJobLevelDisplayed() == true) {
				setStatusTest("pass", "Saves created Job Level to Job Level list");
			} else {
				setStatusTest("fail", "Not Saves created Job Level to Job Level list");
			}
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) 
			{
				setStatusTest("pass", "Redirects to Job Level List");
			} else {
				setStatusTest("fail", "Not Redirects to Job Level List");
			}
		}
		else
		{
			jobLevelList.clickBtnCreate();
			
			if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Create Job Level popup");
			} else {
				setStatusTest("fail", "Not Open Create Job Level popup");
			}
			
			formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
			formCreateJobLevel.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Job Level created successfully\r\n"
					+ "2. Saves created Job Level to Job Level list\r\n"
					+ "3. Redirects to Job Level List");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
			}
			
			if (jobLevelList.isLinkFirstJobLevelDisplayed() == true) {
				setStatusTest("pass", "Saves created Job Level to Job Level list");
			} else {
				setStatusTest("fail", "Not Saves created Job Level to Job Level list");
			}
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) 
			{
				setStatusTest("pass", "Redirects to Job Level List");
			} else {
				setStatusTest("fail", "Not Redirects to Job Level List");
			}
		}
	
	}
		@Test(priority = 2)

		public void TT_12361() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Job Level");

			controlBoard.clickLblJobLevel();
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) {
				setStatusTest("pass", "Access to Job Level");
			} else {
				setStatusTest("fail", "Not Access to Job Level");
			}
			

			TestLogger.info("3. Click on icon Add in the top >> Input all required field >> Click on button Save & Create New");
			
			jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
			
			if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
			{
				jobLevelList.deleteJobLevel();
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
				
				
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}
			else
			{
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
								
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}			
					
	}
		
		@Test(priority = 3)

		public void TT_12660() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Job Level");

			controlBoard.clickLblJobLevel();
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) {
				setStatusTest("pass", "Access to Job Level");
			} else {
				setStatusTest("fail", "Not Access to Job Level");
			}
			
			TestLogger.info("3. Click on icon Edit in Job A's row >> Click button Save");
			
			jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
			if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
			{
				jobLevelList.deleteJobLevel();
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
				
				
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}
			else
			{
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
								
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}	
			jobLevelList.clickIconEdit();
			
			if (formEditJobLevel.isLblEditJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Edit Job Level popup");
			} else {
				setStatusTest("fail", "Not Open Create Job Level popup");
			}
			formEditJobLevel.fillDescription("change description");
			formEditJobLevel.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Job Level updated successfully\r\n"
					+ "2. Saves updated Job Level to Job Level list\r\n"
					+ "3. Redirects to Job Level List");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level updated successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level updated successfully");
			}
			
			if (jobLevelList.isLinkFirstJobLevelDisplayed() == true) {
				setStatusTest("pass", "Saves updated Job Level to Job Level list");
			} else {
				setStatusTest("fail", "Not Saves updated Job Level to Job Level list");
			}
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) 
			{
				setStatusTest("pass", "Redirects to Job Level List");
			} else {
				setStatusTest("fail", "Not Redirects to Job Level List");
			}
					
	}

		@Test(priority = 4)

		public void TT_12701() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Job Level");

			controlBoard.clickLblJobLevel();
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) {
				setStatusTest("pass", "Access to Job Level");
			} else {
				setStatusTest("fail", "Not Access to Job Level");
			}
			
			TestLogger.info("3. Click on a Job Level to open detail >> Click on icon Edit in the top right >> Click button Save");
			
			jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
			if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
			{
				jobLevelList.deleteJobLevel();
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
				
				
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}
			else
			{
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSavenCreateNew();
								
				TestLogger.info("Expect : User CAN see/do: \r\n" 
						+ "1. Job Level created successfully\r\n"
						+ "2. Entire forms display as default, no data is inputted");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
				}
				
				formCreateJobLevel.clickBtnCancel();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Entire forms display as default, no data is inputted");
				} else {
					setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
				}
			}
			jobLevelList.clickLinkFirstJobLevel();
			formJobLevelDetails.clickIconEdit();
			
			if (formEditJobLevel.isLblEditJobLevelDisplayed() == true) {
				setStatusTest("pass", "Open Edit Job Level popup");
			} else {
				setStatusTest("fail", "Not Open Create Job Level popup");
			}
			formEditJobLevel.fillDescription("change description");
			formEditJobLevel.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Job Level updated successfully\r\n"
					+ "2. Saves updated Job Level to Job Level list\r\n"
					+ "3. Redirects to Job Level List");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job Level updated successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job Level updated successfully");
			}
			
			if (jobLevelList.isLinkFirstJobLevelDisplayed() == true) {
				setStatusTest("pass", "Saves updated Job Level to Job Level list");
			} else {
				setStatusTest("fail", "Not Saves updated Job Level to Job Level list");
			}
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) 
			{
				setStatusTest("pass", "Redirects to Job Level List");
			} else {
				setStatusTest("fail", "Not Redirects to Job Level List");
			}
					
	}
		@Test(priority = 5)

		public void TT_12780() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Job Level");

			controlBoard.clickLblJobLevel();
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) {
				setStatusTest("pass", "Access to Job Level");
			} else {
				setStatusTest("fail", "Not Access to Job Level");
			}
			
			TestLogger.info("3. Click on any Job Level >> Click on Delete button >> Click on NO button");
			
			jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
						
			if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
			{
				jobLevelList.clickLinkFirstJobLevel();
				formJobLevelDetails.clickIconDelete();
				
				if (formJobLevelDetails.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnNo();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");
				
				if (formJobLevelDetails.isLblJobLevelDetailssDisplayed() == true) {
					setStatusTest("pass", "System closes dialogue message. Nothing changes");
				} else {
					setStatusTest("fail", "System NOT closes dialogue message");
				}
				
			}
			else
			{
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSave();
				
				jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
				jobLevelList.clickLinkFirstJobLevel();
				formJobLevelDetails.clickIconDelete();
				
				if (formJobLevelDetails.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnNo();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");
				
				if (formJobLevelDetails.isLblJobLevelDetailssDisplayed() == true) {
					setStatusTest("pass", "System closes dialogue message. Nothing changes");
				} else {
					setStatusTest("fail", "System NOT closes dialogue message");
				}
			}	
			
			TestLogger.info("4. Click Yes");
									
			formJobLevelDetails.clickIconDelete();
				
				if (formJobLevelDetails.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnYes();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "Job Level deleted successfully.");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level deleted successfully.");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level deleted successfully.");
				}	
}
		
		@Test(priority = 6)

		public void TT_12778() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Job Level");

			controlBoard.clickLblJobLevel();
			
			if (jobLevelList.isLblJobLevelListDisplayed() == true) {
				setStatusTest("pass", "Access to Job Level");
			} else {
				setStatusTest("fail", "Not Access to Job Level");
			}
			
			TestLogger.info("3. Click on icon Delete in Job Level B's row >> Click on NO button");
			
			jobLevelList.fillSearchJobLevel(DataManager.FunctionSet);
						
			if(jobLevelList.isLinkFirstJobLevelDisplayed() == true)
			{
				jobLevelList.clickIconDelete();
				
				if (jobLevelList.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnNo();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");
				
				if (jobLevelList.isLblJobLevelListDisplayed() == true) {
					setStatusTest("pass", "System closes dialogue message. Nothing changes");
				} else {
					setStatusTest("fail", "System NOT closes dialogue message");
				}
				
			}
			else
			{
				jobLevelList.clickBtnCreate();
				
				if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
					setStatusTest("pass", "Open Create Job Level popup");
				} else {
					setStatusTest("fail", "Not Open Create Job Level popup");
				}
				
				formCreateJobLevel.inputData(DataManager.FunctionSet,DataManager.Test);
				formCreateJobLevel.clickBtnSave();
				
				jobLevelList.clickIconDelete();
				
				if (jobLevelList.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnNo();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "System closes dialogue message. Nothing changes");
				
				if (jobLevelList.isLblJobLevelListDisplayed() == true) {
					setStatusTest("pass", "System closes dialogue message. Nothing changes");
				} else {
					setStatusTest("fail", "System NOT closes dialogue message");
				}
			}	
			
			TestLogger.info("4. Click Yes");
									
				jobLevelList.clickIconDelete();
				
				if (jobLevelList.isLblConfirmationDisplayed() == true) {
					setStatusTest("pass", "Open Comfirm popup");
					formJobLevelDetails.clickBtnYes();
				} else {
					setStatusTest("fail", "Not Open Comfirm popup");
				}
				
				TestLogger.info("Expect : User CAN see/do: " + "Job Level deleted successfully.");
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System displays msg: " + "Job Level deleted successfully.");
				} else {
					setStatusTest("fail", "System NOT displays msg: " + "Job Level deleted successfully.");
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
