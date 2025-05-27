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
import wize.pages.Baseline_Dimension;
import wize.pages.ControlBoard;
import wize.pages.Form_Add_Update_SkillToBaseline_Dimension;
import wize.pages.Form_BaselineUpdateConfirmation_Dimension;
import wize.pages.Form_CloneBaseline;
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditBusinessUnit;
import wize.pages.Form_EditPosition;
import wize.pages.Form_PositionDetails;
import wize.pages.LoginScreen;
import wize.pages.Organization;
import wize.pages.Organization_BusinessUnit;
import wize.pages.PositionList;

public class Test_Functional_Baseline_Dimension extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails positionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	Form_Add_Update_SkillToBaseline_Dimension formAddUpdateSkillToBaseline;
	Baseline_Left_Panel baseline;
	Baseline_Dimension baselineDimension;
	Form_CloneBaseline cloneBaseline;
	Form_BaselineUpdateConfirmation_Dimension formBaselineUpdateConfirmation;
	
	Organization organization;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_EditBusinessUnit editBusinessUnit;
	
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
		formAddUpdateSkillToBaseline = new Form_Add_Update_SkillToBaseline_Dimension(driver);
		baseline = new Baseline_Left_Panel(driver);
		baselineDimension = new Baseline_Dimension(driver);
		cloneBaseline = new Form_CloneBaseline(driver);
		formBaselineUpdateConfirmation = new Form_BaselineUpdateConfirmation_Dimension(driver);
		
		organization = new Organization(driver);
		businessUnit = new Organization_BusinessUnit(driver);
		createBusinessUnit = new Form_CreateBusinessUnit(driver);
		editBusinessUnit = new Form_EditBusinessUnit(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_17282() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Organization");

		controlBoard.clickLblOrganization();
		
		if (organization.isLblDIMENSIONLISTDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "Not Access to Organization");
		}
		
		TestLogger.info("3. Create New BusinessUnit");
		
		businessUnit.fillSearchName(DataManager.BalinseDimension);
		
		if(businessUnit.isItemFirstDisplayed() == false)
		{			
			businessUnit.clickBtnAdd();
			
			if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
				} else {
			setStatusTest("fail", "Not Open Create popup");
			}
				
			createBusinessUnit.fillData(DataManager.BalinseDimension,DataManager.BalinseDimension);
			createBusinessUnit.clickBtnSave();
		
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Business Unit created successfully");
			}	
		}
		
		TestLogger.info("4 . Access to Talent >> Baseline >> Dimension tab");

		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabDimension();
		
		if (baselineDimension.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent >> Baseline >> Dimension tab");
		} else {
			setStatusTest("fail", "Not Access to Talent >> Baseline >> Dimension tab");
		}
		
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		
		if(baselineDimension.isLblViewBaselineDisplayed() == true)
		{
			baselineDimension.clickBtnEdit();
			baselineDimension.clickIconDelete();
			baselineDimension.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("5. Click on 'Add Skill' hyperlink"); 
		
		baselineDimension.clickBtnAddSkill();
		baselineDimension.clickItemSkill();
				
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
		
		if (baselineDimension.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
				
		TestLogger.info("9. Double click on Save button");
		
		baselineDimension.clickDoubleBtnSave();
			
		TestLogger.info("Expect : User CAN see/do: " + "Create successfully: M028 and create only a record");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Create successfully: M028 and create only a record");
		} else {
			setStatusTest("fail", "NOT Create successfully: M028 and create only a record");
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
