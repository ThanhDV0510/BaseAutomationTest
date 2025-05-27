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
import wize.pages.Baseline_Left_Panel;
import wize.pages.Baseline_Job;
import wize.pages.ControlBoard;
import wize.pages.Form_Add_Update_SkillToBaseline_Job;
import wize.pages.Form_BaselineUpdateConfirmation;
import wize.pages.Form_CloneBaseline;
import wize.pages.Form_CreateJob;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditJob;
import wize.pages.Form_EditPosition;
import wize.pages.Form_JobDetails;
import wize.pages.Form_PositionDetails;
import wize.pages.JobList;
import wize.pages.LoginScreen;
import wize.pages.PositionList;

public class Test_Functional_Baseline_Job extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails positionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	Form_Add_Update_SkillToBaseline_Job formAddUpdateSkillToBaseline;
	Baseline_Left_Panel baseline;
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
		baseline = new Baseline_Left_Panel(driver);
		baselineJob = new Baseline_Job(driver);
		cloneBaseline = new Form_CloneBaseline(driver);
		formBaselineUpdateConfirmation = new Form_BaselineUpdateConfirmation(driver);
		
		jobList = new JobList(driver);
		formJobDetails = new Form_JobDetails(driver);
		formCreateJob = new Form_CreateJob(driver);
		formEditJob = new Form_EditJob(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = true)

	public void TT_17641_TT_17647() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

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
		
		jobList.fillSearchJob(DataManager.BalinseJob);
		if(jobList.isLinkFirstJobDisplayed() == false)
		{			
			jobList.clickBtnCreate();
			
			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
					} else {
				setStatusTest("fail", "Not Open Create Job popup");
					}
				
			formCreateJob.inputData(DataManager.BalinseJob,DataManager.BalinseJob,DataManager.Test);
			formCreateJob.clickBtnSave();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}
	
		}
		
		TestLogger.info("4 . Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("5. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("6. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("7. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("8. Click on icon key of a behavior");
	
		formAddUpdateSkillToBaseline.clickBtnSetKey();
		
		TestLogger.info("Expect : User CAN see/do:\r\n "
				+ "1. System marks selected behavior as important\r\n"
				+ "2. Check & key icon change to green");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == true) {
			setStatusTest("pass", "System marks selected behavior as important");
		} else {
			setStatusTest("fail", "NOT System marks selected behavior as important");
		}
		
		if (formAddUpdateSkillToBaseline.isCheckBehaviorDisplayed() == true) {
			setStatusTest("pass", "Check & key icon change to green");
		} else {
			setStatusTest("fail", "NOT Check & key NOT icon change to green");
		}
		
		TestLogger.info("9. Click on Cancel button");
		
		formAddUpdateSkillToBaseline.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to No Baseline screen");
		
		if (baselineJob.isLblTotalEditDisplayed() == false) {
			setStatusTest("pass", "System discards all selection/changes and redirects to No Baseline screen");
		} else {
			setStatusTest("fail", "NOT System discards all selection/changes and redirects to No Baseline screen");
		}
	}
	
	@Test(priority = 2, enabled = true)

	public void TT_17645() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("6. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
	}
	
	@Test(priority = 3, enabled = true)

	public void TT_17668() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 2");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
				
		TestLogger.info("6. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
					
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("7. Click on link Update baseline");
		
		baselineJob.clickLinkSkillL1();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("8. Update Skill from Level 2 to Level 3"); 
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		
		TestLogger.info("9. Click on Cancel button"); 
				
		formAddUpdateSkillToBaseline.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to Preview Baseline screen");
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == false) {
			setStatusTest("pass", "System discards all selection/changes and redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System discards all selection/changes and redirects to Preview Baseline screen");
		}
	}
	
	@Test(priority = 4, enabled = true)

	public void TT_17663_TT_17667_TT_17668() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 2");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
		
		TestLogger.info("6. Click on icon key of a behavior");
		
		formAddUpdateSkillToBaseline.clickBtnSetKey();
				
		TestLogger.info("7. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
	
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("8. Click on link Update baseline");
		
		baselineJob.clickLinkSkillL1();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("9. Update Skill from Level 2 to Level 3"); 
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		
		TestLogger.info("Expect : User CAN see/do: " + "Update Skill Success");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == false) {
			setStatusTest("pass", "Update Skill Success");
		} else {
			setStatusTest("fail", "Update Skill NOT Success");
		}
		
		TestLogger.info("10. Click on icon key of a behavior"); 
				
		formAddUpdateSkillToBaseline.clickBtnSetKey();
		
		TestLogger.info("Expect : User CAN see/do:\r\n"
				+ "1. System marks selected behavior as important\r\n"
				+ "2. Check & key icon change to green");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == true) {
			setStatusTest("pass", "System marks selected behavior as important");
		} else {
			setStatusTest("fail", "NOT System marks selected behavior as important");
		}
		
		if (formAddUpdateSkillToBaseline.isCheckBehaviorDisplayed() == true) {
			setStatusTest("pass", "Check & key icon change to green");
		} else {
			setStatusTest("fail", "NOT Check & key NOT icon change to green");
		}
		
		TestLogger.info("11. Click on Update button"); 
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System changes level to level 3 and redirects to Preview Baseline screen");
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == false) {
			setStatusTest("pass", "System changes level to level 3 and redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System changes level to level 3 and redirects to Preview Baseline screen");
		}	
	}
	
	@Test(priority = 5, enabled = true)

	public void TT_17672_TT_17674_TT_17675() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Create Skill 1"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
				
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
			
		formAddUpdateSkillToBaseline.clickBtnAdd();
					
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
						
		TestLogger.info("4. Click on Remove icon of a skill");
		
		baselineJob.clickIconX1();
		
		TestLogger.info("Expect : User CAN see/do: " + "Remove that skill ");
		
		if (baselineJob.isStatusLinkSkillDisplayed() == false) {
			setStatusTest("pass", "Remove that skill ");
		} else {
			setStatusTest("fail", "NOT Remove that skill ");
		}
		
		TestLogger.info("5. Create Skill 1"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
				
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
			
		formAddUpdateSkillToBaseline.clickBtnAdd();
					
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("6. Click on Delete icon of a skill category"); 
		
		baselineJob.clickIconDelete();
		
		TestLogger.info("Expect : User CAN see/do: " + "Remove that skill category and its skills");
		
		if (baselineJob.isStatusLinkSkillDisplayed() == false) {
			setStatusTest("pass", "Remove that skill category and its skills");
		} else {
			setStatusTest("fail", "NOT Remove that skill category and its skills");
		}
		
		TestLogger.info("7. Click on Cancel button"); 
				
		baselineJob.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to No Baseline screen");
		
		if (baselineJob.isBtnSaveDisplayed() == false) {
			setStatusTest("pass", "System discards all selection/changes and redirects to No Baseline screen");
		} else {
			setStatusTest("fail", "NOT System discards all selection/changes and redirects to No Baseline screen");
		}
}
	
	@Test(priority = 6, enabled = true)

	public void TT_17658_TT_17676() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 2");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
		
		TestLogger.info("6. Click on icon key of a behavior");
		
		formAddUpdateSkillToBaseline.clickBtnSetKey();
				
		TestLogger.info("7. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
			
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("8. Click on link Update baseline");
	
		baselineJob.clickLinkSkillL1();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("9. Update Skill from Level 2 to Level 3"); 
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("10. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System redirect to Select Skill Level screen");
		
		if (baselineJob.isStatusLinkSkillDisplayed() == true) {
			setStatusTest("pass", "System redirect to Select Skill Level screen");
		} else {
			setStatusTest("fail", "NOT System redirect to Select Skill Level screen");
		}
		
		TestLogger.info("11. Click on Save button");
		
		baselineJob.clickBtnSave();
		/*formBaselineUpdateConfirmation.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}*/
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
	}
	
	@Test(priority = 7, enabled = true)

	public void TT_18220_TT_18223() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

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
		
		jobList.fillSearchJob(DataManager.BalinseJob);
		if(jobList.isLinkFirstJobDisplayed() == false)
		{			
			jobList.clickBtnCreate();
			
			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
					} else {
				setStatusTest("fail", "Not Open Create Job popup");
					}
				
			formCreateJob.inputData(DataManager.BalinseJob,DataManager.BalinseJob,DataManager.Test);
			formCreateJob.clickBtnSave();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}
	
		}
		
		TestLogger.info("4 . Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("5. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("6. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("7. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		
		TestLogger.info("8. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
				
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("9. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
			
		TestLogger.info("10. Click on Edit button >> Click on 'Add Skill' hyperlink");
		
		baselineJob.clickBtnEdit();
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("11. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("12. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		
		TestLogger.info("13. Click on icon key of a behavior");
	
		formAddUpdateSkillToBaseline.clickBtnSetKey();
		
		TestLogger.info("Expect : User CAN see/do:\r\n "
				+ "1. System marks selected behavior as important\r\n"
				+ "2. Check & key icon change to green");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == true) {
			setStatusTest("pass", "System marks selected behavior as important");
		} else {
			setStatusTest("fail", "NOT System marks selected behavior as important");
		}
		
		if (formAddUpdateSkillToBaseline.isCheckBehaviorDisplayed() == true) {
			setStatusTest("pass", "Check & key icon change to green");
		} else {
			setStatusTest("fail", "NOT Check & key NOT icon change to green");
		}
		
		TestLogger.info("14. Click on Cancel button");
		
		formAddUpdateSkillToBaseline.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to No Baseline screen");
		
		if (baselineJob.isLblViewBaselineDisplayed() == true) {
			setStatusTest("pass", "System discards all selection/changes and redirects to No Baseline screen");
		} else {
			setStatusTest("fail", "NOT System discards all selection/changes and redirects to No Baseline screen");
		}
	}
	
	@Test(priority = 8, enabled = true)

	public void TT_18225() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("6. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("7. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
			
		TestLogger.info("8. Click on Edit button >> Click on 'Add Skill' hyperlink");
		
		baselineJob.clickBtnEdit();
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("9. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill2);
			
		TestLogger.info("10. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("11. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
	}
	
	@Test(priority = 9, enabled = true)

	public void TT_18132_TT_18131() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

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
		
		jobList.fillSearchJob(DataManager.BalinseJob);
		if(jobList.isLinkFirstJobDisplayed() == false)
		{			
			jobList.clickBtnCreate();
			
			if (formCreateJob.isLblCreateJobDisplayed() == true) {
				setStatusTest("pass", "Open Create Job popup");
					} else {
				setStatusTest("fail", "Not Open Create Job popup");
					}
				
			formCreateJob.inputData(DataManager.BalinseJob,DataManager.BalinseJob,DataManager.Test);
			formCreateJob.clickBtnSave();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Job created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
			}
	
		}
		
		TestLogger.info("4 . Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("5. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("6. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("7. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		
		TestLogger.info("8. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
				
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("9. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
			
		TestLogger.info("10. Click on Edit button >> Click on link skill");
		
		baselineJob.clickBtnEdit();
		baselineJob.clickLinkSkillL1();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("11. Click on icon key of a behavior");
	
		formAddUpdateSkillToBaseline.clickBtnSetKey();
		
		TestLogger.info("Expect : User CAN see/do:\r\n"
				+ "1. System marks selected behavior as important\r\n"
				+ "2. Check & key icon change to green");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == true) {
			setStatusTest("pass", "System marks selected behavior as important");
		} else {
			setStatusTest("fail", "NOT System marks selected behavior as important");
		}
		
		if (formAddUpdateSkillToBaseline.isCheckBehaviorDisplayed() == true) {
			setStatusTest("pass", "Check & key icon change to green");
		} else {
			setStatusTest("fail", "NOT Check & key NOT icon change to green");
		}
		
		TestLogger.info("12. Click on Cancel button");
		
		formAddUpdateSkillToBaseline.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to No Baseline screen");
		
		if (baselineJob.isLblTotalEditDisplayed() == true) {
			setStatusTest("pass", "System discards all selection/changes and redirects to No Baseline screen");
		} else {
			setStatusTest("fail", "NOT System discards all selection/changes and redirects to No Baseline screen");
		}
	}
	
	@Test(priority = 10, enabled = true)

	public void TT_18220() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent >> Baseline >> Job tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
		}
		
		baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
		
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
		
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
				
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("4. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("5. Select Skill Level 3");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
				
		TestLogger.info("6. Click on Add button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("7. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
			
		TestLogger.info("8. Click on Edit button >> Click on link skill");
		
		baselineJob.clickBtnEdit();
		baselineJob.clickLinkSkillL1();
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("9. Update Skill Level 3 to Level 2");
		
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
				
		TestLogger.info("10. Click on Update button");
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System changes to level 3 and redirects to Preview Baseline screen");
		
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System changes to level 3 and redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System changes to level 3 and redirects to Preview Baseline screen");
		}
		
	}
	
		@Test(priority = 11, enabled = true)
	
		public void TT_18135_TT_18138_TT_18137() throws InterruptedException {
			TestLogger.info("1. Login with account.");
	
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
	
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
	
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
	
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Create Skill 1"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddUpdateSkillToBaseline.clickRadiobtnL2();
				
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			baselineJob.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
							
			TestLogger.info("4. Click on 'Edit' icon >> Click on Remove icon of a skill");
			
			baselineJob.clickBtnEdit();
			baselineJob.clickIconX1();
			
			TestLogger.info("Expect : User CAN see/do: " + "Remove that skill ");
			
			if (baselineJob.isStatusLinkSkillDisplayed() == false) {
				setStatusTest("pass", "Remove that skill ");
			} else {
				setStatusTest("fail", "NOT Remove that skill ");
			}
			
			TestLogger.info("5. Create Skill 1"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddUpdateSkillToBaseline.clickRadiobtnL2();
				
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			baselineJob.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
			
			TestLogger.info("6. Click on 'Edit' icon >> Click on Delete icon of a skill category"); 
			
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			
			TestLogger.info("Expect : User CAN see/do: " + "Remove that skill category and its skills");
			
			if (baselineJob.isStatusLinkSkillDisplayed() == false) {
				setStatusTest("pass", "Remove that skill category and its skills");
			} else {
				setStatusTest("fail", "NOT Remove that skill category and its skills");
			}
			
			TestLogger.info("7. Click on Cancel button"); 
					
			baselineJob.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to No Baseline screen");
			
			if (baselineJob.isBtnSaveDisplayed() == false) {
				setStatusTest("pass", "System discards all selection/changes and redirects to No Baseline screen");
			} else {
				setStatusTest("fail", "NOT System discards all selection/changes and redirects to No Baseline screen");
			}
	}

		@Test(priority = 12, enabled = true)
		
		public void TT_18139() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
			
			TestLogger.info("4. Select Caterogy Technical & Skill Reading");
			
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				
			TestLogger.info("5. Select Skill Level 3");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL3();
					
			TestLogger.info("6. Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("7. Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
				
			TestLogger.info("8. Click on Edit button");
			
			baselineJob.clickBtnEdit();
						
			TestLogger.info("9. Click on Save button");
						
			TestLogger.info("Expect : Button Save is disable");
			
			if (baselineJob.isBtnSaveEnable() == false) {
				setStatusTest("pass", "Button Save is already disable");
			} else {
				setStatusTest("fail", "Button Save is not disable");
			}
			
			if (baselineJob.isLblViewBaselineDisplayed() == true) {
				setStatusTest("pass", "System redirects to Job Baseline View screen");
			} else {
				setStatusTest("fail", "NOT System redirects to Job Baseline View screen");
			}
			
			TestLogger.info("10. Click on Edit button >> Click on link skill");
			
//			baselineJob.clickBtnEdit();
			
			baselineJob.clickLinkSkillL1();
			
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Access to Update Skill to Baseline popup");
			} else {
				setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
			}
			
			TestLogger.info("11. Update Skill Level 3 to Skill Level 2");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL2();
			
			TestLogger.info("12. Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves all changes and redirects to Baseline Update Confirmation screen");
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "System saves all changes and redirects to Baseline Update Confirmation screen");
			} else {
				setStatusTest("fail", "NOT System saves all changes and redirects to Baseline Update Confirmation screen");
			}
			
			TestLogger.info("13. Click on Save button");
			
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg Success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg Success");
			} else {
				setStatusTest("fail", "NOT Displays msg Success");
			}
		}

		@Test(priority = 13, enabled = true)
		
		public void TT_18241_TT_18243() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
			
			TestLogger.info("4. Select Caterogy Technical & Skill Reading");
			
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				
			TestLogger.info("5. Select Skill Level 3");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL3();
					
			TestLogger.info("6. Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("7. Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
				
			TestLogger.info("8. Click on Edit button");
			
			baselineJob.clickBtnEdit();
			
			TestLogger.info("9. Update Skill");
			
			baselineJob.clickLinkSkillL1();
			
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Access to Update Skill to Baseline popup");
			} else {
				setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
			}
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("10. Click on 'Add' icon >> Clone Baseline");
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemClone();
			
			if (cloneBaseline.isLbClonelBaselineDisplayed() == true) {
				setStatusTest("pass", "Access to Clone Baseline popup");
			} else {
				setStatusTest("fail", "NOT Access to Clone Baseline popup");
			}
			
			TestLogger.info("11. Select any job");
			
			cloneBaseline.selectClone(DataManager.BalinseJob);
			
			if (cloneBaseline.isLblBaselineDisplayed() == true) {
				setStatusTest("pass", "Select Job Success");
			} else {
				setStatusTest("fail", "NOT Select Job Success");
			}
			
			TestLogger.info("12. Click on Clone button");
			
			cloneBaseline.clickBtnClone();
			
			TestLogger.info("Expect : User CAN see/do: " + "System redirects to Preview Baseline screen");
			
			if (baselineJob.isLblWarningDisplayed() == true) {
				setStatusTest("pass", "System redirects to Preview Baseline screen");
			} else {
				setStatusTest("fail", "NOT System redirects to Preview Baseline screen");
			}	
			
			TestLogger.info("13. Click on 'Add' icon >> Clone Baseline");
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemClone();
			
			if (cloneBaseline.isLbClonelBaselineDisplayed() == true) {
				setStatusTest("pass", "Access to Clone Baseline popup");
			} else {
				setStatusTest("fail", "NOT Access to Clone Baseline popup");
			}
			
//			TestLogger.info("14. Select any job");
//			
//			cloneBaseline.selectClone(DataManager.BalinseJob);
//			
//			if (cloneBaseline.isLblBaselineDisplayed() == true) {
//				setStatusTest("pass", "Select Job Success");
//			} else {
//				setStatusTest("fail", "NOT Select Job Success");
//			}
			
			TestLogger.info("15. Click on Cancel button");
			
			cloneBaseline.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes and redirects to Preview Baseline screen");
			
			if (cloneBaseline.isLbClonelBaselineDisplayed() == false) {
				setStatusTest("pass", "System discards all selection/changes and redirects to Preview Baseline screen");
			} else {
				setStatusTest("fail", "NOT System discards all selection/changes and redirects to Preview Baseline screen");
			}
}
		
		@Test(priority = 14, enabled = true)
		
		public void TT_18148() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Create Skill 3 : Level 2"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill3);
			formAddUpdateSkillToBaseline.clickRadiobtnL2();
							
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			baselineJob.clickBtnSave();
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Access to Baseline Updapte Comfirmation popup");
			} else {
				setStatusTest("fail", "NOT Access to Baseline Updapte Comfirmation popup");
			}
			
			TestLogger.info("4. Create Skill 1 : Level 2 : Set Key"); 
			
			baselineJob.clickBtnEdit();
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddUpdateSkillToBaseline.clickRadiobtnL2();
			formAddUpdateSkillToBaseline.clickBtnSetKey();
				
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
						
			TestLogger.info("5. Create Skill 2 : Level 5: Not Set Key");
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill2);
			formAddUpdateSkillToBaseline.clickRadiobtnL5();
							
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
								
			TestLogger.info("6. Click on Save button");
			
			baselineJob.clickBtnSave();
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Access to Baseline Updapte Comfirmation popup");
			} else {
				setStatusTest("fail", "NOT Access to Baseline Updapte Comfirmation popup");
			}
						
			TestLogger.info("Expect : User CAN see/do:\r\n"
					+ "1. Current value = N/A\r\n"
					+ "2. New value = Skill B - Level 2 (New)r\n"
					+ "3. New value = Skill C - Level 5 (New)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = N/A");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = N/A");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill B - Level 2 (New)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill B - Level 2 (New)");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill C - Level 5 (New)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill C - Level 5 (New)");
			}
			
			formBaselineUpdateConfirmation.clickIconX();
		}

		@Test(priority = 15, enabled = true)
		
		public void TT_18244() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
			
			TestLogger.info("4. Select Caterogy Technical & Skill Reading");
			
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				
			TestLogger.info("5. Select Skill Level 1");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL1();
					
			TestLogger.info("6. Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("7. Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
				
			TestLogger.info("8. Click on Edit button");
			
			baselineJob.clickBtnEdit();
			
			TestLogger.info("9. Click on X icon");
			
			baselineJob.clickIconX1();
			
			if (baselineJob.isIconX1Displayed() == false) {
				setStatusTest("pass", "Remove Success");
			} else {
				setStatusTest("fail", "NOT Remove Success");
			}
								
			TestLogger.info("10. Click on Save button");
			
			baselineJob.clickBtnSave();
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Access to Baseline Updapte Comfirmation popup");
			} else {
				setStatusTest("fail", "NOT Access to Baseline Updapte Comfirmation popup");
			}
						
			TestLogger.info("Expect : User CAN see/do:\r\n"
					+ "1. Current value = Skill F - Level 1\r\n"
					+ "2. New value = Skill F - Level 1 (Deleted)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = Skill F - Level 1");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = Skill F - Level 1");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill F - Level 1 (Deleted)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill F - Level 1 (Deleted)");
			}
	
			formBaselineUpdateConfirmation.clickIconX();
		}

		@Test(priority = 16, enabled = true)
		
		public void TT_18245() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
						
			TestLogger.info("3. Create Skill X : Level 1"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddUpdateSkillToBaseline.clickRadiobtnL1();
							
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
						
			TestLogger.info("4. Create Skill Y : Level 1");
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill2);
			formAddUpdateSkillToBaseline.clickRadiobtnL1();
							
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("5. Create Skill Z : Level 1"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
					
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill3);
			formAddUpdateSkillToBaseline.clickRadiobtnL1();
							
			formAddUpdateSkillToBaseline.clickBtnAdd();
						
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("6. Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
				
			TestLogger.info("7. Click on Edit button >> Delete Skill Category");
			
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
					
			if (baselineJob.isIconX1Displayed() == false) {
				setStatusTest("pass", "Remove Success");
			} else {
				setStatusTest("fail", "NOT Remove success");
			}
								
			TestLogger.info("8. Click on Save button");
			
			baselineJob.clickBtnSave();
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Access to Baseline Updapte Comfirmation popup");
			} else {
				setStatusTest("fail", "NOT Access to Baseline Updapte Comfirmation popup");
			}
						
			TestLogger.info("Expect : User CAN see/do:\r\n"
					+ "1. Current value = Skill X - Level 1\r\n"
					+ "2. New value = Skill X - Level 1 (Deleted)r\n"
					+ "3. Current value = Skill Y - Level 1\r\n"
					+ "4. New value = Skill Y - Level 1 (Deleted)\r\n"
					+ "5. Current value = Skill Z - Level 1\r\n"
					+ "6. New value = Skill Z - Level 1 (Deleted)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = Skill X - Level 1");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = Skill X - Level 1");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill X - Level 1 (Deleted)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill X - Level 1 (Deleted)");
			}
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue2Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = Skill Y - Level 1");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = Skill Y - Level 1");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill Y - Level 1 (Deleted)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill Y - Level 1 (Deleted)");
			}
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue3Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = Skill Z - Level 1");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = Skill Z - Level 1");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill Z - Level 1 (Deleted)");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill Z - Level 1 (Deleted)");
			}
			
			formBaselineUpdateConfirmation.clickIconX();
		}

		@Test(priority = 17, enabled = true)
		
		public void TT_18246() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Access to Talent >> Baseline >> Job tab");
		
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblBaseLine();
			baseline.clickTabJob();
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline >> Job tab");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline >> Job tab");
			}
			
			baselineJob.fillTxtSearchJob(DataManager.BalinseJob);
			
			if(baselineJob.isLblViewBaselineDisplayed() == true)
			{
				baselineJob.clickBtnEdit();
				baselineJob.clickIconDelete();
				baselineJob.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Click on 'Add Skill' hyperlink"); 
			
			baselineJob.clickBtnAddSkill();
			baselineJob.clickItemSkill();
					
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
			
			TestLogger.info("4. Select Caterogy Technical & Skill Reading");
			
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				
			TestLogger.info("5. Select Skill Level 1");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL1();
					
			TestLogger.info("6. Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("7. Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
				
			TestLogger.info("8. Click on Edit button");
			
			baselineJob.clickBtnEdit();
			
			TestLogger.info("9. Open Update Skill To Baseline popup");
			
			baselineJob.clickLinkSkillL1();
			
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true ) {
				setStatusTest("pass", "Open Update Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Update Skill To Baseline popup");
			}
			
			TestLogger.info("10. Change to another key behavior");
			
			formAddUpdateSkillToBaseline.clickBtnSetKey();
			
			if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == true) {
				setStatusTest("pass", "Change to another key behavior success");
			} else {
				setStatusTest("fail", "Change to another key behavior NOT success");
			}
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
								
			TestLogger.info("11. Click on Save button");
			
			baselineJob.clickBtnSave();
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Access to Baseline Updapte Comfirmation popup");
			} else {
				setStatusTest("fail", "NOT Access to Baseline Updapte Comfirmation popup");
			}
						
			TestLogger.info("Expect : User CAN see/do:\r\n"
					+ "1. Current value = Skill B - Level 2\r\n"
					+ "2. New value = Skill B - Level 2 (Domain knowledge/ Key behavior has been");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Displays : Current value = Skill B - Level 2");
			} else {
				setStatusTest("fail", "NOT Displays : Current value = Skill B - Level 2");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "Displays : New value = Skill B - Level 2 (Domain knowledge/ Key behavior has been ");
			} else {
				setStatusTest("fail", "NOT Displays : New value = Skill B - Level 2 (Domain knowledge/ Key behavior has been ");
			}
		
			formBaselineUpdateConfirmation.clickIconX();
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
