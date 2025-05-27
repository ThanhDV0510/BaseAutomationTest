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
import wize.pages.Baseline_AddPosition;
import wize.pages.Baseline_Position;
import wize.pages.Baseline_UpdatePosition;
import wize.pages.ControlBoard;
import wize.pages.Form_AddSkillToBaseline_Position;
import wize.pages.Form_BaselineUpdateConfirmation;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditPosition;
import wize.pages.Form_PositionDetails;
import wize.pages.Form_UpdateSkillToBaseline_Position;
import wize.pages.LoginScreen;
import wize.pages.PositionList;

public class Test_Functional_Baseline_Position extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails positionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	Form_AddSkillToBaseline_Position formAddSkillToBaseline;
	Form_UpdateSkillToBaseline_Position formUpdateSkillToBaseline;
	Baseline_Position baselinePosition;
	Baseline_Left_Panel baseline;
	Baseline_AddPosition baselineAddPosition;
	Baseline_UpdatePosition baselineUpdatePosition;
	Form_BaselineUpdateConfirmation formBaselineUpdateConfirmation;
	
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
		formAddSkillToBaseline = new Form_AddSkillToBaseline_Position(driver);
		formUpdateSkillToBaseline = new Form_UpdateSkillToBaseline_Position(driver);
		baselinePosition = new Baseline_Position(driver);
		baseline = new Baseline_Left_Panel(driver);
		baselineAddPosition = new Baseline_AddPosition(driver);
		baselineUpdatePosition = new Baseline_UpdatePosition(driver);
		formBaselineUpdateConfirmation = new Form_BaselineUpdateConfirmation(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = true)

	public void TT_13495() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}
		
		TestLogger.info("3. Create new position");
		
		positionList.fillSearchPosition(DataManager.FunctionSet);
		
		if(positionList.isLinkFirstPostionDisplayed() == true)
		{
			loginScreen.clickIconControlBoard();
		}
		else
		{
			positionList.clickBtnCreate();
			
			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			
			formCreatePosition.inputData(DataManager.FunctionSet,DataManager.Test,DataManager.Test);
			formCreatePosition.clickBtnSave();
			loginScreen.clickIconControlBoard();
		}
				
		TestLogger.info("4. Access to Talent-Baseline");

		controlBoard.clickLblBaseLine();
		
		if (baselinePosition.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent-Baseline");
		} else {
			setStatusTest("fail", "Not Access to Talent-Baseline");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Existing Positions with in the system in Baseline Management");
		
		if (baselinePosition.isFirtItemPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Existing Positions with in the system in Baseline Management");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Existing Positions with in the system in Baseline Management");
		}
	}
	
		@Test(priority = 2, enabled = true)

		public void TT_13571() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			

			TestLogger.info("3. Click on icon Add ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}			

			TestLogger.info("4. Input all required fields >> Click on button Cancel");
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close pop-up.");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Discard all changes, close pop-up.");
			} else {
				setStatusTest("fail", "Not Discard all changes, close pop-up.");
			}
			
			TestLogger.info("5. Input all required fields >> Double click on button Cancel");
			
			baselineAddPosition.clickBtnAddSkill();
			baselineAddPosition.clickItemSkill();
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickDoubleBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close pop-up.");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Discard all changes, close pop-up.");
			} else {
				setStatusTest("fail", "Not Discard all changes, close pop-up.");
			}
					
	}
		@Test(priority = 3, enabled = true)

		public void TT_13572() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			

			TestLogger.info("3. Click on icon Add ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			
			TestLogger.info("4. Input all required fields >> Click on button Add");
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
			+ "1. Skill added successfully and display in Preview Baseline\r\n"
			+ "2. Pop-up disappeared");
			
			if (baselineAddPosition.isLinkSkillL1Displayed() == true) {
				setStatusTest("pass", "Skill added successfully and display in Preview Baseline");
			} else {
				setStatusTest("fail", "Not Skill added successfully and display in Preview Baseline");
			}
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Pop-up disappeared");
			} else {
				setStatusTest("fail", "Pop-up NOT disappeared");
			}
			
			TestLogger.info("5. Click on icon Add ");
			
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Open Add Skill to Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill to Baseline popup");
			}

			TestLogger.info("6. Input all required fields >> Double click on button Add");
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickDoubleBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
			+ "1. Skill added successfully and display in Preview Baseline\r\n"
			+ "2. Pop-up disappeared");
			
			if (baselineAddPosition.isLinkSkillL1Displayed() == true) {
				setStatusTest("pass", "Skill added successfully and display in Preview Baseline");
			} else {
				setStatusTest("fail", "Not Skill added successfully and display in Preview Baseline");
			}
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Pop-up disappeared");
			} else {
				setStatusTest("fail", "Pop-up NOT disappeared");
			}
					
	}

		@Test(priority = 4, enabled = true)

		public void TT_13916() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			

			TestLogger.info("3. Click on icon Add ");
		
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			
			TestLogger.info("4. Click on Category >> Click on Category agian");
				
			formAddSkillToBaseline.clickTxtCategory();
			formAddSkillToBaseline.clickTxtSkill();
			
			TestLogger.info("Expect : User CAN see/do: " + "[Mandatory field.] under field Category");
			
			if (formAddSkillToBaseline.isMsgErrorDisplayed() == true) {
				setStatusTest("pass", "System displays msg M001: " + "[Mandatory field.] under field Category");
			} else {
				setStatusTest("fail", "System NOT displays msg M001: " + "[Mandatory field.] under field Category");
			}
				
			formAddSkillToBaseline.clickBtnCancel();
	}
		@Test(priority = 5, enabled = true)

		public void TT_13919() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			

			TestLogger.info("3. Click on icon Add ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			TestLogger.info("4. Input all required fields >> Click on button Add");
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickBtnAdd();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Add Skill to Baseline Successful");
			} else {
				setStatusTest("fail", "Add Skill to Baseline NOT Successful");
			}
			
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickBtnAdd();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Add Skill to Baseline Successful");
			} else {
				setStatusTest("fail", "Add Skill to Baseline NOT Successful");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" + "Update skill in Preview successful");
			
			if (baselineAddPosition.isLinkSkillL1Displayed() == true) {
				setStatusTest("pass", "Update skill in Preview successful");
			} else {
				setStatusTest("fail", "Not Update skill in Preview successful");
			}			
	}
	
	@Test(priority = 6, enabled = true)

		public void TT_13761() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}

			TestLogger.info("3. Add skill to baseline ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
			}
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			
			TestLogger.info("4. Click on button 'Cancel'");
			
			formAddSkillToBaseline.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "System discards all selection/changes");
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "System discards all selection/changes");
			} else {
				setStatusTest("fail", "System NOT discards all selection/changes");
			}			
	}
		
		@Test(priority = 7, enabled = true)

		public void TT_13705_TT_13706_TT_13704_TT_13762() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickIconDelete();
				baselineUpdatePosition.clickBtnSave();
				formBaselineUpdateConfirmation.clickBtnSave();
			}
			
			TestLogger.info("3. Add: " + "Skill A: Level 3 + Skill B: Level 2 + Skill C: Level 5");
			
			baselineAddPosition.clickBtnAddSkill();
			baselineAddPosition.clickItemSkill();
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Open Add Skill to Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill to Baseline popup");
			}
			
			//Add "Skill A: Level 3"
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
			formAddSkillToBaseline.clickRadiobtnL3();
			formAddSkillToBaseline.clickBtnAdd();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Add Skill A: Level 3 Successfull");
			} else {
				setStatusTest("fail", "Add Skill A: Level 3 NOT Successfull");
			}
			
			//Add "Skill B: Level 2"
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill2);
			formAddSkillToBaseline.clickRadiobtnL2();
			formAddSkillToBaseline.clickBtnAdd();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Add Skill C: Level 2 Successfull");
			} else {
				setStatusTest("fail", "Add Skill C: Level 2 NOT Successfull");
			}
			
			//Add "Skill C: Level 5".
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill3);
			formAddSkillToBaseline.clickRadiobtnL5();
			formAddSkillToBaseline.clickBtnAdd();
						
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Add Skill D: Level 5 Successfull");
			} else {
				setStatusTest("fail", "Add Skill D: Level 5 NOT Successfull");
			}
			
			TestLogger.info("Expect : User CAN see/do: " + "Label = 3.3");
			
			if (baselineUpdatePosition.isLblTotalEditDisplayed() == true) {
				setStatusTest("pass", "Displays Label = 3.3");
			} else {
				setStatusTest("fail", "Not displays Label = 3.3");
			}	
			
			TestLogger.info("4. Remove Skill 3: Level 5");
			
			baselineUpdatePosition.clickIconX3();
			
			TestLogger.info("Expect : User CAN see/do: " + "Label = 2.5");
			
			if (baselineUpdatePosition.isLblTotalEditDisplayed() == true) {
				setStatusTest("pass", "Displays Label = 2.5");
			} else {
				setStatusTest("fail", "Not Displays Label = 2.5");
			}
			
			TestLogger.info("5. View");
			
			TestLogger.info("Expect : User CAN see/do: " + "Label Baseline");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Displays Label Baseline");
			} else {
				setStatusTest("fail", "Not Displays Label Baseline");
			}
			
			TestLogger.info("6. Click on button 'Save'");
			
			baselineAddPosition.clickBtnSave();
								
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. System saves baseline to corresponding position\r\n" 
					+ "2. Back to screen View Baseline\r\n" 
					+ "3. System display M013: [Baseline updated successfully.]Label Baseline");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System display M013: [Baseline updated successfully.]Label Baseline");
			} else {
				setStatusTest("fail", "System display M013: [Baseline updated successfully.]Label Baseline");
			}
			
			if (baselinePosition.isLblViewBaselineDisplayed() == true) {
				setStatusTest("pass", "System saves baseline to corresponding position");
			} else {
				setStatusTest("fail", "System NOT saves baseline to corresponding position");
			}
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Back to screen View Baseline");
			} else {
				setStatusTest("fail", "NOT Back to screen View Baseline");
			}
				
}
		
		@Test(priority = 8, enabled = true)

		public void TT_13726() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			

			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Click on Cancel button ");
			
			formUpdateSkillToBaseline.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "Update Skill pop up closes");
			
			if (baselinePosition.isLblBaselineNameDisplayed()== true) {
				setStatusTest("pass", "Update Skill pop up closes");
			} else {
				setStatusTest("fail", "Update Skill pop up not closes");
			}			
	}
		
		@Test(priority = 9, enabled = true)

		public void TT_13731() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Update Level & Set Key >> Click on Update button ");
			
			formUpdateSkillToBaseline.clickRadiobtnL2();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("Expect : User CAN see/do: " + "System updates the skills to baseline and redirects to Preview baseline");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System updates the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "System NOT updates the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("5. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Display Baseline Update Confirmation pop up");
			
			if (formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
	}
		
		@Test(priority = 10, enabled = true)

		public void TT_13708_TT_13733() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select a Category >> Select edit icon");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
								
			TestLogger.info("4. Click on the Delete icon ");
			
			baselineUpdatePosition.clickIconDelete();
			
			TestLogger.info("Expect : User CAN see/do: " + "Remove all skills in a category");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Remove all skills in a category");
			} else {
				setStatusTest("fail", "NOT Remove all skills in a category");
			}
	}
		
		@Test(priority = 10, enabled = true)

		public void TT_13732() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Update Level & Set Key >> Click on Update button ");
			
			formUpdateSkillToBaseline.clickRadiobtnL2();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("5. Select Cancel button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "Discard all the changes");
			
			if (baselineUpdatePosition.isIconDeleteDisplayed() == false) {
				setStatusTest("pass", "Discard all the changes");
			} else {
				setStatusTest("fail", "Not Discard all the changes");
			}
	}
		
		@Test(priority = 11, enabled = true)

		public void TT_13734() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Update Level & Set Key >> Click on Update button ");
			
			formUpdateSkillToBaseline.clickRadiobtnL2();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("5. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
			
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
			
			TestLogger.info("6. Select X  button in Confirmation pop up");
			
			formBaselineUpdateConfirmation.clickIconX();
			
			TestLogger.info("Expect : User CAN see/do: " + "Close the pop up");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Close the pop up");
			} else {
				setStatusTest("fail", "Not Close the pop up");
			}
	}
		
		@Test(priority = 12, enabled = true)

		public void TT_13735() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Update Level & Set Key >> Click on Update button ");
			
			formUpdateSkillToBaseline.clickRadiobtnL2();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("5. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
			
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
			
			TestLogger.info("6. Select Cancel button in Confirmation pop up");
			
			formBaselineUpdateConfirmation.clickBtnCancel();
			
			TestLogger.info("Expect : User CAN see/do: " + "Close the pop up");
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Close the pop up");
			} else {
				setStatusTest("fail", "Not Close the pop up");
			}
	}
		
		@Test(priority = 13, enabled = true)

		public void TT_13736() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);

			if(baselinePosition.isLblViewBaselineDisplayed() == true)
			{
				
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickLinkSkillL1();
			
				if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Display Update Skill pop up");
				} else {
					setStatusTest("fail", "Not Display Update Skill pop up");
				}
				
			}
			else
			{
				baselineAddPosition.clickBtnAddSkill();
				baselineAddPosition.clickItemSkill();
				
				if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Open Add Skill to Baseline popup");
				} else {
					setStatusTest("fail", "Not Open Add Skill to Baseline popup");
				}
				
				formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				formAddSkillToBaseline.clickBtnAdd();
				
				if (baselinePosition.isLblBaselineNameDisplayed() == true) {
					setStatusTest("pass", "Add Skill to Baseline Successful");
				} else {
					setStatusTest("fail", "Add Skill to Baseline NOT Successful");
				}
				
				baselineAddPosition.clickBtnSave();
				baselineAddPosition.clickItemSkill();
				formBaselineUpdateConfirmation.clickBtnSave();
				
				if (DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "System display M013: [Baseline updated successfully.]Label Baseline");
				} else {
					setStatusTest("fail", "System display M013: [Baseline updated successfully.]Label Baseline");
				}
				
				baselineUpdatePosition.clickBtnEdit();
				baselineUpdatePosition.clickLinkSkillL1();
			
				if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
					setStatusTest("pass", "Display Update Skill pop up");
				} else {
					setStatusTest("fail", "Not Display Update Skill pop up");
				}
			}
			
			TestLogger.info("4. Update Level & Set Key >> Click on Update button ");
			
			formUpdateSkillToBaseline.clickRadiobtnL2();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("5. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. System updates the skills to baseline\r\n"
					+ "2. Redirects to  View baseline");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System display M013: [Baseline updated successfully.]Label Baseline");
			} else {
				setStatusTest("fail", "System display M013: [Baseline updated successfully.]Label Baseline");
			}

			if (baselineUpdatePosition.isBtnEditDisplayed() == true) {
				setStatusTest("pass", "Redirects to  View baseline");
			} else {
				setStatusTest("fail", "Not redirects to  View baseline");
			}
	}
		
		@Test(priority = 14, enabled = true)

		public void TT_14151_TT_14149_TT_14152_TT_14153_TT14150() throws InterruptedException {
			TestLogger.info("1. Login with account.");

			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent >> Baseline");

			controlBoard.clickLblBaseLine();
			
			if (baselinePosition.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "Access to Talent >> Baseline");
			} else {
				setStatusTest("fail", "Not Access to Talent >> Baseline");
			}
			
			TestLogger.info("3. Select a Position >> Select edit icon >> Click on a bar of a selected skill ");
			
			baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickLinkSkillL1();
			
			if ( formUpdateSkillToBaseline.isLblUpdateSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Display Update Skill pop up");
			} else {
				setStatusTest("fail", "Not Display Update Skill pop up");
			}
			
			TestLogger.info("4. Change skill level");
			
			formUpdateSkillToBaseline.clickRadiobtnL1();
			formUpdateSkillToBaseline.clickBtnUpdate();
			
			TestLogger.info("5. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
			
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
						
			TestLogger.info("Expect : History display: \r\n" 
					+ "1. Current Value: Display old skill level\r\n"
					+ "2. New Value: Display new skill level");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Current Value: Display old skill level");
			} else {
				setStatusTest("fail", "Current Value: NOT Display old skill level");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueDisplayed() == true) {
				setStatusTest("pass", "New Value: Display new skill level");
			} else {
				setStatusTest("fail", "New Value: NOT Display new skill level");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
					
			TestLogger.info("5. Remove a skill in list >> Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickIconX1();
			baselineUpdatePosition.clickBtnSave();
			
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
						
			TestLogger.info("Expect : History display: \r\n" 
					+ "1. Current Value: Display deleted skill\r\n"
					+ "2. New Value: Display deleted skill + label (Deleted)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Current Value: Display deleted skill");
			} else {
				setStatusTest("fail", "Current Value: NOT Display deleted skill");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "New Value: Display deleted skill + label (Deleted)");
			} else {
				setStatusTest("fail", "New Value: NOT Display deleted skill + label (Deleted)");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
			
			TestLogger.info("6. Add skill level >> Input all required fields >> Click on button Add");
			
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Open Add Skill to Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill to Baseline popup");
			}
			
			formAddSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill3);
			formAddSkillToBaseline.clickRadiobtnL5();
			formAddSkillToBaseline.clickBtnAdd();

			TestLogger.info("7. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
	
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
						
			TestLogger.info("Expect : History display: \r\n" 
					+ "1. Current Value: N/A\r\n"
					+ "2. New Value: Display deleted skill + label (Newly added)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Current Value: N/A");
			} else {
				setStatusTest("fail", "Current Value: NOT is N/A");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "New Value: Display skill + label (Newly added) ");
			} else {
				setStatusTest("fail", "New Value: NOT Display skill + label (Newly added) ");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
			
			TestLogger.info("8. Add skill");
			
			baselineUpdatePosition.clickBtnAddSkill();
			baselineUpdatePosition.clickItemSkill();
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Open Add Skill to Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill to Baseline popup");
			}
			
			formAddSkillToBaseline.inputData(DataManager.Baseline2,DataManager.Skill4);
			formAddSkillToBaseline.clickBtnAdd();

			TestLogger.info("9. Select Save button in Preview baseline screen");
			
			baselineUpdatePosition.clickBtnSave();
	
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
						
			TestLogger.info("Expect : History display: \r\n" 
					+ "1. Current Value: N/A\r\n"
					+ "2. New Value: Display deleted skill + label (Newly added)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Current Value: N/A");
			} else {
				setStatusTest("fail", "Current Value: NOT is N/A");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "New Value: Display skill + label (Newly added) ");
			} else {
				setStatusTest("fail", "New Value: NOT Display skill + label (Newly added) ");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
			
			TestLogger.info("10. Delete skill category >> Click on button 'Save' in Preview Baseline");
			
			baselineUpdatePosition.clickIconDelete();
			baselineUpdatePosition.clickBtnSave();
	
			if ( formBaselineUpdateConfirmation.isLblBaselineUpdateConfirmationDisplayed() == true) {
				setStatusTest("pass", "Display Baseline Update Confirmation pop up.");
			} else {
				setStatusTest("fail", "Not Display Baseline Update Confirmation pop up.");
			}
						
			TestLogger.info("Expect : History display: \r\n" 
					+ "1. Current Value: Display the deleted skills inside the category\r\n"
					+ "2. New Value: Display the deleted skills inside the category + label (Deleted)");
			
			if (formBaselineUpdateConfirmation.isValueCurrentValue1Displayed() == true) {
				setStatusTest("pass", "Current Value: Display the deleted skills inside the category");
			} else {
				setStatusTest("fail", "Current Value: NOT Display the deleted skills inside the category");
			}
			
			if (formBaselineUpdateConfirmation.isValueNewValueStatusDisplayed() == true) {
				setStatusTest("pass", "New Value: Display the deleted skills inside the category + label (Deleted)");
			} else {
				setStatusTest("fail", "New Value: NOT Display the deleted skills inside the category + label (Deleted)");
			}
			
			formBaselineUpdateConfirmation.clickBtnCancel();
			baselineUpdatePosition.clickIconDelete();
			baselineUpdatePosition.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System display M013: [Baseline updated successfully.]Label Baseline");
			} else {
				setStatusTest("fail", "System display M013: [Baseline updated successfully.]Label Baseline");
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
