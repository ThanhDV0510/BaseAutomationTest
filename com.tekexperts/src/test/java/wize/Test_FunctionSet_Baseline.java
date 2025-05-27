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
import wize.pages.Baseline;
import wize.pages.Baseline_AddPosition;
import wize.pages.Baseline_Dimension;
import wize.pages.Baseline_Job;
import wize.pages.Baseline_Position;
import wize.pages.Baseline_UpdatePosition;
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
import wize.pages.Form_AddSkillToBaseline_Position;
import wize.pages.Form_Add_Update_SkillToBaseline_Dimension;
import wize.pages.Form_Add_Update_SkillToBaseline_Job;
import wize.pages.Form_BaselineUpdateConfirmation;
import wize.pages.Form_BaselineUpdateConfirmation_Dimension;
import wize.pages.Form_CloneBaseline;
import wize.pages.Form_CloneBaseline_Dimension;
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_InheritBaseline;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.Organization;
import wize.pages.Organization_BusinessUnit;

public class Test_FunctionSet_Baseline extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	Clone_Form_EditFunctionSet cloneForm;
	Baseline baseline;
	Baseline_Dimension baselineDimension;
	Baseline_Position baselinePosition;
	Baseline_Job baselineJob;
	Baseline_UpdatePosition baselineUpdatePosition;
	Baseline_AddPosition baselineAddPosition;
	Form_AddSkillToBaseline_Position formAddSkillToBaseline;
	Form_BaselineUpdateConfirmation formBaselineUpdateConfirmation;
	Form_CloneBaseline formCloneBaseline;
	Form_InheritBaseline formInheritBaseline;
	Form_Add_Update_SkillToBaseline_Job formAddUpdateSkillToBaseline;
	Form_CloneBaseline cloneBaseline;
	Organization organization;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_Add_Update_SkillToBaseline_Dimension formAddUpdateSkillToBaselineDimension;
	Form_BaselineUpdateConfirmation_Dimension form_BaselineUpdateConfirmation_Dimension;
	Form_CloneBaseline_Dimension formCloneBaselineDimension;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
	
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		baseline = new Baseline(driver);
		baselineDimension = new Baseline_Dimension(driver);
		baselineJob = new Baseline_Job(driver);
		baselinePosition = new Baseline_Position(driver);
		baselineUpdatePosition = new Baseline_UpdatePosition(driver);
		baselineAddPosition = new Baseline_AddPosition(driver);
		formAddSkillToBaseline = new Form_AddSkillToBaseline_Position(driver);
		formBaselineUpdateConfirmation = new Form_BaselineUpdateConfirmation(driver);
		formCloneBaseline = new Form_CloneBaseline(driver);
		formInheritBaseline = new Form_InheritBaseline(driver);
		formAddUpdateSkillToBaseline = new Form_Add_Update_SkillToBaseline_Job(driver);
		cloneBaseline = new Form_CloneBaseline(driver);
		organization = new Organization(driver);
		businessUnit = new Organization_BusinessUnit(driver);
		createBusinessUnit = new Form_CreateBusinessUnit(driver);
		formAddUpdateSkillToBaselineDimension = new Form_Add_Update_SkillToBaseline_Dimension(driver);
		form_BaselineUpdateConfirmation_Dimension = new Form_BaselineUpdateConfirmation_Dimension(driver);
		formCloneBaselineDimension = new Form_CloneBaseline_Dimension(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 1, enabled = true)
	public void TT19235(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for (int i = 0; i <= 4; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnRadioOrganization();
		cloneForm.clickOFFBtnRadioBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");

		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User cannot see/do Baseline subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User STILL CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User cannot see/do Baseline link on Control board");
		if(!controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User STILL CAN see/do Baseline link on Control Board");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT19238(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for (int i = 0; i <= 4; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnViewBaselineListDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline from link Control Board");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Position and Job");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User STILL CAN view tab Dimension");
		}
		TestLogger.info("8. Access Baseline from icon Control Board >> Talent");
		controlBoard.clickSubLinkBaselineOnIconControlBoard();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Position and Job");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User STILL CAN view tab Dimension");
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void TT19237(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for (int i = 0; i <= 4; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnViewBaselineListJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline from link Control Board");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Position and Dimension");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Access Baseline from icon Control Board >> Talent");
		controlBoard.clickSubLinkBaselineOnIconControlBoard();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Position and Dimension");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
	}
	
	@Test (priority = 4, enabled = true)
	public void TT19236(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for (int i = 0; i <= 4; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFbtnViewBaselineListPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline from link Control Board");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Job and Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Access Baseline from icon Control Board >> Talent");
		controlBoard.clickSubLinkBaselineOnIconControlBoard();
		TestLogger.info("Expected: user can view baseline for 2 tabs: Job and Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
	}
	
	@Test (priority = 5, enabled = true)
	public void TT19240_TT20357(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline from link Control Board");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 3 tabs: Position, Job and Dimension");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		TestLogger.info("9. Can see link Add Skill, Inherit baseline and Clone baseline");
		if(baselinePosition.isLinkAddSkillDisplayed()){
			setStatusTest("pass", "User CAN see link Add skill");
		}else{
			setStatusTest("fail", "User CANNOT see link Add skill");
		}
		if(baselinePosition.isLinkInheritBaselineDisplayed()){
			setStatusTest("pass", "User CAN see link Inherit baseline");
		}else{
			setStatusTest("fail", "User CANNOT see link Inherit baseline");
		}
		if(baselinePosition.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CAN see link Clone baseline");
		}else{
			setStatusTest("fail", "User CANNOT see link Clone baseline");
		}
		
		TestLogger.info("10. Select Tab Job");
		baseline.clickTabJob();
		baselineJob.fillTxtSearchJob(DataManager.Test);
		TestLogger.info("11. Can see link Add Skill and Clone baseline");
		if(baselineJob.isLinkAddSkillDisplayed()){
			setStatusTest("pass", "User CAN see link Add skill");
		}else{
			setStatusTest("fail", "User CANNOT see link Add skill");
		}
		if(baselineJob.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CAN see link Clone baseline");
		}else{
			setStatusTest("fail", "User CANNOT see link Clone baseline");
		}
		TestLogger.info("12. Select Tab Dimension");
		baseline.clickTabDimension();
		baselineDimension.fillTxtSearchDimension(DataManager.Test);
		TestLogger.info("13. Can see link Add Skill and Clone baseline");
		if(baselineDimension.isLinkAddSkillDisplayed()){
			setStatusTest("pass", "User CAN see link Add skill");
		}else{
			setStatusTest("fail", "User CANNOT see link Add skill");
		}
		if(baselineDimension.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CAN see link Clone baseline");
		}else{
			setStatusTest("fail", "User CANNOT see link Clone baseline");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT19312(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for (int i = 0; i <= 4; i++) {
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnRadioOrganization();
		cloneForm.clickOFFBtnRadioBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("Paste URL of baseline >> Expected: 403 page");
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Baseline/Index");
		if(baseline.isPage403Displayed()){
			setStatusTest("pass", "403 page is displayed");
		}else{
			setStatusTest("fail", "403 page is NOT displayed");
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void TT20358(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxViewOnly();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 3 tabs: Position, Job and Dimension");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		TestLogger.info("Expected: User CANNOT see link Create baseline, Edit baseline, Add Skill, Inherit baseline and Clone baseline");
		if(!baselinePosition.isLinkAddSkillDisplayed()){
			setStatusTest("pass", "User CANNOT see link Add skill");
		}else{
			setStatusTest("fail", "User CAN see link Add skill");
		}
		if(!baselinePosition.isLinkInheritBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Inherit baseline");
		}else{
			setStatusTest("fail", "User CAN see link Inherit baseline");
		}
		if(!baselinePosition.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		if(!baselinePosition.isBtnCreateBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Create new baseline");
		}else{
			setStatusTest("fail", "User STILL CAN see btn Create new baseline");
		}
		if(!baselinePosition.isBtnEditBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Edit baseline");
		}else{
			setStatusTest("fail", "User STILL CAN see btn Edit baseline");
		}
		
		TestLogger.info("9. Select Tab Job");
		baseline.clickTabJob();
		baselineJob.fillTxtSearchJob(DataManager.Test);
		TestLogger.info("Expected: User CANNOT see link Create baseline, Edit baseline, Add Skill and Clone baseline");
		if(!baselineJob.isBtnCreateBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Create baseline");
		}else{
			setStatusTest("fail", "User CAN see btn Create baseline");
		}
		if(!baselineJob.isBtnEditBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Edit baseline");
		}else{
			setStatusTest("fail", "User CAN see btn Edit baseline");
		}
		if(!baselineJob.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		if(!baselineJob.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		TestLogger.info("10. Select Tab Dimension");
		baseline.clickTabDimension();
		baselineDimension.fillTxtSearchDimension(DataManager.Test);
		TestLogger.info("Expected: User CANNOT see link Create baseline, Edit baseline, Add Skill and Clone baseline");
		if(!baselineDimension.isBtnCreateBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Create baseline");
		}else{
			setStatusTest("fail", "User CAN see btn Create baseline");
		}
		if(!baselineDimension.isBtnEditBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Edit baseline");
		}else{
			setStatusTest("fail", "User CAN see btn Edit baseline");
		}
		if(!baselineDimension.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		if(!baselineDimension.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		TestLogger.info("11. Click icon Control Board >> Access Baseline via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Baseline/Index");
		if(!baseline.isPage403Displayed()){
			setStatusTest("pass", "User can access normally");
		}else{
			setStatusTest("fail", "User CANNOT access normally");
		}
	}
	
	// case failed
	@Test (priority = 8, enabled = true)
	public void TT19253(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickOFFbtnCreateBaselinesPosition();
		cloneForm.clickOFFbtnEditBaselinesPosition();
		cloneForm.clickOFFbtnDeleteBaselinesPosition();
		cloneForm.clickOFFBtnCloneBaselinesPosition();
		cloneForm.clickOFFBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		TestLogger.info("Expected: User CANNOT see link Create baseline, Edit baseline, Add Skill, Inherit baseline and Clone baseline");
		if(!baselinePosition.isLinkAddSkillDisplayed()){
			setStatusTest("pass", "User CANNOT see link Add skill");
		}else{
			setStatusTest("fail", "User CAN see link Add skill");
		}
		if(!baselinePosition.isLinkInheritBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Inherit baseline");
		}else{
			setStatusTest("fail", "User CAN see link Inherit baseline");
		}
		if(!baselinePosition.isLinkCloneBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see link Clone baseline");
		}else{
			setStatusTest("fail", "User CAN see link Clone baseline");
		}
		if(!baselinePosition.isBtnCreateBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Create new baseline");
		}else{
			setStatusTest("fail", "User STILL CAN see btn Create new baseline");
		}
		if(!baselinePosition.isBtnEditBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Edit baseline");
		}else{
			setStatusTest("fail", "User STILL CAN see btn Edit baseline");
		}
	}
	
	// case failed
	@Test (priority = 9, enabled = true)
	public void TT19255(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickONbtnCreateBaselinesPosition();
		cloneForm.clickOFFbtnEditBaselinesPosition();
		cloneForm.clickOFFbtnDeleteBaselinesPosition();
		cloneForm.clickOFFBtnCloneBaselinesPosition();
		cloneForm.clickOFFBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
//		baselinePosition.fillTxtSearchPostion("00002 OPERATIONS MANAGER");
		if(baselinePosition.isLblViewBaselineDisplayed() == false){
			TestLogger.info("In case: no data");
			TestLogger.info("Expected: User CAN see link Create baseline, Add Skill");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			if(baselinePosition.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CAN see link Add skill");
			}else{
				setStatusTest("fail", "User CANNOT see link Add skill");
			}
			if(baselinePosition.isBtnCreateBaselineClickable()){
				setStatusTest("pass", "User CAN see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create new baseline");
			}
			if(baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CAN see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item Add skill from btn Create baseline");
			}
			TestLogger.info("Expected: User CANNOT see link Edit baseline, Delete baseline, Inherit baseline and Clone baseline");
			if(!baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Edit baseline");
			}
			if(!baselineUpdatePosition.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Inherit skill from btn Create baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Clone skill from btn Create baseline");
			}
		}else{
			TestLogger.info("In case: have data");
			TestLogger.info("Expected: User CAN see list baseline");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			TestLogger.info("Expected: User CANNOT see link Create, Edit baseline, Delete baseline, Inherit baseline, Clone baseline");
			if(!baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Edit baseline");
			}
			if(!baselineUpdatePosition.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselinePosition.isBtnCreateBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create new baseline");
			}
			if(!baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
		}
	}
	
	@Test (priority = 10, enabled = true)
	public void TT19256(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickOFFbtnCreateBaselinesPosition();
		cloneForm.clickONbtnEditBaselinesPosition();
		cloneForm.clickOFFbtnDeleteBaselinesPosition();
		cloneForm.clickOFFBtnCloneBaselinesPosition();
		cloneForm.clickOFFBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
//		baselinePosition.fillTxtSearchPostion("00002 OPERATIONS MANAGER");
		if(baselinePosition.isLblViewBaselineDisplayed() == false){
			TestLogger.info("In case: no data");
			TestLogger.info("Expected: User CAN see list baseline");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			TestLogger.info("Expected: User CANNOT see link Create baseline, Add SkillEdit baseline, Delete baseline, Inherit baseline and Clone baseline");
			if(!baselinePosition.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add skill");
			}else{
				setStatusTest("fail", "User CAN see link Add skill");
			}
			if(!baselinePosition.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create new baseline");
			}
			if(!baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
			if(!baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Edit baseline");
			}
			if(!baselineUpdatePosition.isBtnDeleteAllBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Inherit skill from btn Create baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Clone skill from btn Create baseline");
			}
		}else{
			TestLogger.info("In case: have data");
			TestLogger.info("Expected: User CAN see list baseline, Edit baseline");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			if(baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CAN see btn Edit baseline");
				baselineUpdatePosition.clickBtnCancel();
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit baseline");
			}
			TestLogger.info("Expected: User CANNOT see link Create baseline, Delete baseline, Inherit baseline, Clone baseline");
			if(!baselineUpdatePosition.isBtnDeleteAllBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselinePosition.isBtnCreateBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create new baseline");
			}
			if(!baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
		}
	}
	
	@Test (priority = 11, enabled = true)
	public void TT19257(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickOFFbtnCreateBaselinesPosition();
		cloneForm.clickOFFbtnEditBaselinesPosition();
		cloneForm.clickONbtnDeleteBaselinesPosition();
		cloneForm.clickOFFBtnCloneBaselinesPosition();
		cloneForm.clickOFFBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		if(baselinePosition.isLblViewBaselineDisplayed() == false){
			TestLogger.info("Click on icon Add ");
			
			baselineAddPosition.clickBtnAddSkill();
			baselineAddPosition.clickItemSkill();
			
			if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
				setStatusTest("pass", "Open Add Skill to Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill to Baseline popup");
			}

			TestLogger.info("Input all required fields >> Double click on button Add");
			
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
			baselineAddPosition.clickBtnSave();
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
//		baselinePosition.fillTxtSearchPostion("00002 OPERATIONS MANAGER");
		if(baselinePosition.isLblViewBaselineDisplayed() == false){
			setStatusTest("fail", "There is no data");
		}else{
			TestLogger.info("Expected: User CANNOT see link Create baseline, Inherit baseline, Clone baseline");
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Add skill from btn Create baseline");
			}
			if(!baselinePosition.isBtnCreateBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create new baseline");
			}
			if(!baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
			TestLogger.info("Expected: User CAN see list baseline, Edit baseline, Delete skills");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			if(baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CAN see btn Edit baseline");
//				baselineUpdatePosition.clickBtnCancel();
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit baseline");
			}
			if(baselineUpdatePosition.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CAN see btn Delete baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Delete baseline");
			}
			if(baselineUpdatePosition.isIconRemoveSkillDisplayed()){
				setStatusTest("pass", "User CAN see btn Remove skill");
			}else{
				setStatusTest("fail", "User CANNOT see btn Remove skill");
			}
			String beforeDeleteSkill = baselineUpdatePosition.getTextBtnFirstCollapse();
			baselineUpdatePosition.clickBtnCancel();
			if(baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "Open edit baseline");
			}
			baselineUpdatePosition.clickIconDelete();
			String afterDeleteSkill = baselineUpdatePosition.getTextBtnFirstCollapse();
			if(!beforeDeleteSkill.equals(afterDeleteSkill)){
				setStatusTest("pass", "Delete skill successfully");
			}else{
				setStatusTest("fail", "Can not delete skill");
			}
		}
	}
	
	@Test (priority = 12, enabled = true)
	public void TT19259(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickOFFbtnCreateBaselinesPosition();
		cloneForm.clickOFFbtnEditBaselinesPosition();
		cloneForm.clickOFFbtnDeleteBaselinesPosition();
		cloneForm.clickONBtnCloneBaselinesPosition();
		cloneForm.clickOFFBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
//		baselinePosition.fillTxtSearchPostion("00002 OPERATIONS MANAGER");
		if(baselinePosition.isLblViewBaselineDisplayed() == false){
			TestLogger.info("In case: no data");
			TestLogger.info("Expected: User CAN see list baseline, link Clone baseline, btn Create baseline");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			if(baselinePosition.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CAN see link Clone baseline");
			}else{
				setStatusTest("fail", "User CANNOT see link Clone baseline");
			}
			if(!baselineAddPosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CAN see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item Clone skill from btn Create baseline");
			}
			if(baselinePosition.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CAN see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create new baseline");
			}
			TestLogger.info("Expected: User CANNOT see Edit baseline, Delete baseline, Inherit baseline");
			if(!baselinePosition.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add skill");
			}else{
				setStatusTest("fail", "User CAN see link Add skill");
			}
			if(!baselineAddPosition.isItemSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
			if(!baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Edit baseline");
			}
			if(!baselineUpdatePosition.isBtnDeleteAllBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselineAddPosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Inherit skill from btn Create baseline");
			}
		}else{
			TestLogger.info("In case: have data");
			TestLogger.info("Expected: User CAN see list baseline, Edit baseline, item Clone baseline");
			if(baselinePosition.isLblBaselineNameDisplayed()){
				setStatusTest("pass", "User CAN view baseline list");
			}else{
				setStatusTest("fail", "User CANNOT view baseline list");
			}
			if(baselinePosition.isBtnEditBaselineClickable()){
				setStatusTest("pass", "User CAN see btn Edit baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit baseline");
			}
			if(baselineUpdatePosition.isBtnCreateBaselineClickable()){
				setStatusTest("pass", "User CAN see btn Create new baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create new baseline");
			}
			if(baselineUpdatePosition.isItemCloneDisplayed()){
				setStatusTest("pass", "User CAN see item Clone skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item Clone skill from btn Create baseline");
			}
			TestLogger.info("Expected: User CANNOT see link Delete baseline, Inherit baseline");
			if(!baselineUpdatePosition.isBtnDeleteAllBaselineClickable()){
				setStatusTest("pass", "User CANNOT see btn Delete baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see btn Delete baseline");
			}
			if(!baselinePosition.isLinkInheritBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Inherit baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Inherit baseline");
			}
			if(!baselinePosition.isLinkCloneClickable()){
				setStatusTest("pass", "User CANNOT see link Clone baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see link Clone baseline");
			}
			if(!baselineUpdatePosition.isItemInheritDisplayed()){
				setStatusTest("pass", "User CANNOT see item Inherit skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User STILL CAN see item Inherit skill from btn Create baseline");
			}
			if(!baselineUpdatePosition.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item Add skill from btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see item Add skill from btn Create baseline");
			}
		}
	}
	
	@Test (priority = 13, enabled = true)
	public void TT19264() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickONbtnViewBaselineListPosition();
		cloneForm.clickONbtnCreateBaselinesPosition();
		cloneForm.clickONbtnEditBaselinesPosition();
		cloneForm.clickONbtnDeleteBaselinesPosition();
		cloneForm.clickONBtnCloneBaselinesPosition();
		cloneForm.clickONBtnInheritBaselinesPosition();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Position");
		if(baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CAN view tab Position");
		}else{
			setStatusTest("fail", "User CANNOT view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category | Tab Position");
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		if(baselinePosition.isLblViewBaselineDisplayed() == true)
		{
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickIconDelete();
			baselineUpdatePosition.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("Expected: User can Add skill to baseline normally >> Click on icon Add ");
		baselineAddPosition.clickBtnAddSkill();
		baselineAddPosition.clickItemSkill();
		if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Open Add Skill to Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill to Baseline popup");
		}
		TestLogger.info("Input all required fields >> Double click on button Add");
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
		baselineAddPosition.clickBtnSave();
		Thread.sleep(2000);
		if (DataManager.isMsgSuccessDisplayed()) {
			setStatusTest("pass","Display message create successfully");
		} else {
			setStatusTest("fail","NOT Display message create successfully");
		}
		String baselineBeforeDelete = baselinePosition.getTextBtnFirstCollapse();
		if (!baselineBeforeDelete.equals("")) {
			setStatusTest("pass","Create successfully");
		} else {
			setStatusTest("fail","NOT create successfully");
		}
		TestLogger.info("Expected: User can Delete skill from baseline normally");
		baselineUpdatePosition.clickBtnEdit();
		baselineUpdatePosition.clickIconDelete();
		baselineUpdatePosition.clickBtnSave();
		formBaselineUpdateConfirmation.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed()) {
			setStatusTest("pass","Display message delete successfully");
		} else {
			setStatusTest("fail","NOT Display message delete successfully");
		}
		driver.navigate().refresh();
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		String baselineAfterDelete = baselinePosition.getTextBtnFirstCollapse();
		if (!baselineAfterDelete.equals(baselineBeforeDelete)) {
			setStatusTest("pass","Delete skill from baseline works normally");
		} else {
			setStatusTest("fail","Delete skill from baseline DOES NOT works normally");
		}
		
		TestLogger.info("Expected: User can Clone skill from baseline normally");
		baselinePosition.clickLinkCloneBaseline();
		if(formCloneBaseline.isLbClonelBaselineDisplayed()){
			setStatusTest("pass", "Display form clone baseline successfully");
		}else{
			setStatusTest("pass", "Display form clone baseline NOT successfully");
		}
		formCloneBaseline.selectClone("00002 Operations Manager");
		Thread.sleep(3000);
		formCloneBaseline.clickBtnClone();
		formCloneBaseline.clickBtnSaveInPreview();
		Thread.sleep(2000);
		if (DataManager.isMsgSuccessDisplayed()) {
			setStatusTest("pass","Display message clone successfully");
		} else {
			setStatusTest("fail","NOT Display message clone successfully");
		}
		String baselineClone = baselinePosition.getTextBtnFirstCollapse();
		if (!baselineClone.equals("")) {
			setStatusTest("pass","Clone successfully");
		} else {
			setStatusTest("fail","NOT clone successfully");
		}
		
		TestLogger.info("Expected: User can Inherit skill from baseline normally");
		baselineUpdatePosition.clickBtnEdit();
		while(baselineUpdatePosition.isFirstSkillDisplayed()){
			baselineUpdatePosition.clickIconDelete();
		}
		baselineUpdatePosition.clickBtnSave();
		formBaselineUpdateConfirmation.clickBtnSave();
		baselinePosition.clickLinkInheritBaseline();
		if(formInheritBaseline.isTitleInheritDisplayed()){
			setStatusTest("pass", "Open form inherit successfully");
		}else{
			setStatusTest("fail", "Open form inherit NOT successfully");
		}
		formInheritBaseline.selectInherit("Automation");
		formInheritBaseline.clickCkboxAllSkill();
		formInheritBaseline.clickBtnInherit();
		Thread.sleep(2000);
		formInheritBaseline.clickBtnSaveInPreview();
		Thread.sleep(2000);
		if (DataManager.isMsgSuccessDisplayed()) {
			setStatusTest("pass","Display message inherit successfully");
		} else {
			setStatusTest("fail","NOT Display message inherit successfully");
		}
		driver.navigate().refresh();
		baselinePosition.fillTxtSearchPostion(DataManager.FunctionSet);
		String baselineInherit = baselinePosition.getTextBtnFirstCollapse();
		if (!baselineClone.equals(baselineInherit)) {
			setStatusTest("pass","Inherit successfully");
		} else {
			setStatusTest("fail","NOT inherit successfully");
		}
		if(baselinePosition.isLblViewBaselineDisplayed() == true)
		{
			baselineUpdatePosition.clickBtnEdit();
			baselineUpdatePosition.clickIconDelete();
			baselineUpdatePosition.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		Thread.sleep(3000);
	}
	
	@Test (priority = 14, enabled = true)
	public void TT25060(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Job baseline list only");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickOFFbtnCreateBaselinesJob();
		cloneForm.clickOFFbtnEditBaselinesJob();
		cloneForm.clickOFFbtnDeleteBaselinesJob();
		cloneForm.clickOFFBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("Prepare data");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		baseline.clickTabJob();
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(!baselineJob.isFirstSkillDisplayed()){
			baselineJob.clickLinkAddSkill();
			if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
				setStatusTest("pass", "Open Add Skill To Baseline popup");
			} else {
				setStatusTest("fail", "Not Open Add Skill To Baseline popup");
			}
			
			TestLogger.info("Select Category Technical & Skill Reading");
			
			formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
				
			TestLogger.info("Select Skill Level 3");
			
			formAddUpdateSkillToBaseline.clickRadiobtnL3();
					
			TestLogger.info("Click on Add button");
			
			formAddUpdateSkillToBaseline.clickBtnAdd();
			
			TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
			
			if (baselineJob.isLblBaselineNameDisplayed() == true) {
				setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
			} else {
				setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
			}
			
			TestLogger.info("Click on Save button");
			
			baselineJob.clickBtnSave();
					
			TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg success");
			} else {
				setStatusTest("fail", "NOT Displays msg success");
			}
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Job");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CANNOT see/do Create, Delete, Edit");
		if(!baselineJob.isBtnCreateBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see/do btn Create baseline");
		}else{
			setStatusTest("fail", "User CAN see/do btn Create baseline");
		}
		if(!baselineJob.isBtnEditBaselineDisplayed()){
			setStatusTest("pass", "User CANNOT see/do btn Edit baseline");
		}else{
			setStatusTest("fail", "User CAN see/do btn Edit baseline");
		}
		if(!baselineJob.isIconDeleteDisplayed()){
			setStatusTest("pass", "User CANNOT see/do btn Delete skill");
		}else{
			setStatusTest("fail", "User CAN see/do btn Delete skill");
		}
	}
	
	@Test (priority = 15, enabled = true)
	public void TT25061(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Job baseline list + Create");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickONbtnCreateBaselinesJob();
		cloneForm.clickOFFbtnEditBaselinesJob();
		cloneForm.clickOFFbtnDeleteBaselinesJob();
		cloneForm.clickOFFBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Job");
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Create, link add skill to baseline");
		if(!baselineJob.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			if(baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CAN see btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create baseline");
			}
			if(baselineJob.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CAN see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see link Add Skill to Baseline");
			}
			if(baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CAN see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item add skill to Baseline");
			}
			TestLogger.info("10. User CANNOT see/do btn Edit, Delete, Clone");
			if(!baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineJob.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Clone Baseline");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			if(baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CAN see btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create baseline");
			}
			if(baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CAN see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item add skill to Baseline");
			}
			TestLogger.info("10. User CANNOT see/do btn Clone, Delete");
			if(!baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}
	}
	
	@Test (priority = 16, enabled = true)
	public void TT25062(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Job baseline list + Edit");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickOFFbtnCreateBaselinesJob();
		cloneForm.clickONbtnEditBaselinesJob();
		cloneForm.clickOFFbtnDeleteBaselinesJob();
		cloneForm.clickOFFBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Job");
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Edit");
		if(!baselineJob.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			TestLogger.info("10. User CANNOT see/do btn Edit, Delete, Clone, Create");
			if(!baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineJob.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Add Skill to Baseline");
			}
			if(!baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineJob.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Clone Baseline");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			TestLogger.info("10. User CANNOT see/do btn Clone, Delete");
			if(!baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}
	}
	
	@Test (priority = 17, enabled = true)
	public void TT25063(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Job baseline list + Delete");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickOFFbtnCreateBaselinesJob();
		cloneForm.clickOFFbtnEditBaselinesJob();
		cloneForm.clickONbtnDeleteBaselinesJob();
		cloneForm.clickOFFBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Job");
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Edit, Delete");
		if(!baselineJob.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			TestLogger.info("10. User CANNOT see/do btn Edit, Delete, Clone, Create");
			if(!baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineJob.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Add Skill to Baseline");
			}
			if(!baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineJob.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Clone Baseline");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineJob.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			if(baselineJob.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CAN see icon Delete");
			}else{
				setStatusTest("fail", "User CANNOT see icon Delete");
			}
			TestLogger.info("10. User CANNOT see/do btn Clone, Create");
			if(!baselineJob.isBtnCreateBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineJob.isItemAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineJob.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}
	}
	
	@Test (priority = 18, enabled = true)
	public void TT25066(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Job baseline list + Delete");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnViewBaselineListJob();
		cloneForm.clickONbtnCreateBaselinesJob();
		cloneForm.clickONbtnEditBaselinesJob();
		cloneForm.clickONbtnDeleteBaselinesJob();
		cloneForm.clickONBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CANNOT see/do Baseline subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(!controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CAN see/do Baseline link on Control Board");
		}
		TestLogger.info("Paste URL of baseline >> Expected: 403 page");
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Baseline/Index");
		if(baseline.isPage403Displayed()){
			setStatusTest("pass", "403 page is displayed");
		}else{
			setStatusTest("fail", "403 page is NOT displayed");
		}
	}
	
	@Test (priority = 19, enabled = true)
	public void TT25065() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | Full function");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListJob();
		cloneForm.clickONbtnCreateBaselinesJob();
		cloneForm.clickONbtnEditBaselinesJob();
		cloneForm.clickONbtnDeleteBaselinesJob();
		cloneForm.clickONBtnCloneBaselinesJob();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioDimensionBaseline();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Job");
		if(baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CAN view tab Job");
		}else{
			setStatusTest("fail", "User CANNOT view tab Job");
		}
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Dimension");
		}else{
			setStatusTest("fail", "User CAN view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: Add skill to baseline job successfully");
		if(baselineJob.isLblViewBaselineDisplayed() == true)
		{
			baselineJob.clickBtnEdit();
			baselineJob.clickIconDelete();
			baselineJob.clickBtnSave();
			formBaselineUpdateConfirmation.clickBtnSave();
		}
		
		TestLogger.info("10. Click on 'Add Skill' hyperlink"); 
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemSkill();
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		TestLogger.info("11. Select Caterogy Technical & Skill Reading");
		formAddUpdateSkillToBaseline.inputData(DataManager.Baseline1,DataManager.Skill1);
		TestLogger.info("12. Select Skill Level 3");
		formAddUpdateSkillToBaseline.clickRadiobtnL3();
		TestLogger.info("13. Click on Add button");
		formAddUpdateSkillToBaseline.clickBtnAdd();
		TestLogger.info("Expect : User CAN see/do: " + "System saves the skills to baseline and redirects to Preview baseline");
		if (baselineJob.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		
		TestLogger.info("14. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
		String baselineAfterCreated = baselineJob.getTextBtnFirstCollapse();
		if(!baselineAfterCreated.equals("")){
			setStatusTest("pass", "Function add skill to baseline works normally");
		}else{
			setStatusTest("fail", "Function add skill to baseline NOT work normally");
		}
		
		TestLogger.info("Expect : User CAN delete baseline successfully");
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		baselineJob.clickBtnEdit();
		baselineJob.clickIconDelete();
		baselineJob.clickBtnSave();
		formBaselineUpdateConfirmation.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg delete success");
		} else {
			setStatusTest("fail", "NOT Displays msg delete success");
		}
		driver.navigate().refresh();
		baselineJob.fillTxtSearchJob(DataManager.Test);
		if(baselineJob.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		String baselineAfterDeleted = baselineJob.getTextBtnFirstCollapse();
		if(baselineAfterDeleted.equals("")){
			setStatusTest("pass", "Function delete baseline works normally");
		}else{
			setStatusTest("pass", "Function delete baseline NOT work normally");
		}
		TestLogger.info("Expected: user can clone baseline job");
		baselineJob.clickBtnAddSkill();
		baselineJob.clickItemClone();
		if (cloneBaseline.isLbClonelBaselineDisplayed() == true) {
			setStatusTest("pass", "Access to Clone Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Clone Baseline popup");
		}
		
		TestLogger.info("15. Select any job");
		
		cloneBaseline.selectClone(DataManager.BalinseJob);
		
		if (cloneBaseline.isLblBaselineDisplayed() == true) {
			setStatusTest("pass", "Select Job Success");
		} else {
			setStatusTest("fail", "NOT Select Job Success");
		}
		
		TestLogger.info("16. Click on Clone button");
		
		cloneBaseline.clickBtnClone();
		
		TestLogger.info("Expect : User CAN see/do: " + "System redirects to Preview Baseline screen");
		
		if (baselineJob.isLblWarningDisplayed() == true) {
			setStatusTest("pass", "System redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System redirects to Preview Baseline screen");
		}
		TestLogger.info("17. Click on Save button");
		
		baselineJob.clickBtnSave();
				
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg success");
		} else {
			setStatusTest("fail", "NOT Displays msg success");
		}
		String baselineAfterClone = baselineJob.getTextBtnFirstCollapse();
		System.out.println(baselineAfterClone);
		if(!baselineAfterClone.equals("")){
			setStatusTest("pass", "Function clone baseline works normally");
		}else{
			setStatusTest("fail", "Function clone baseline NOT work normally");
		}
		TestLogger.info("Expected: edit skill level and set key successfully");
		TestLogger.info("18. Click on link Update baseline");
		baselineJob.clickBtnEdit();
		baselineJob.clickLinkSkillL1();
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("19. Update Skill from Level 1 to Level 2"); 
		
		formAddUpdateSkillToBaseline.clickRadiobtnL2();
		
		TestLogger.info("Expect : User CAN see/do: " + "Update Skill Success");
		
		if (formAddUpdateSkillToBaseline.isCheckSetKeyDisplayed() == false) {
			setStatusTest("pass", "Update Skill Success");
		} else {
			setStatusTest("fail", "Update Skill NOT Success");
		}
		
		TestLogger.info("20. Click on icon key of a behavior"); 
				
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
		
		TestLogger.info("21. Click on Update button"); 
		
		formAddUpdateSkillToBaseline.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System changes level to level 3 and redirects to Preview Baseline screen");
		
		if (formAddUpdateSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == false) {
			setStatusTest("pass", "System changes level to level 3 and redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System changes level to level 3 and redirects to Preview Baseline screen");
		}
		baselineJob.clickBtnSave();
		formBaselineUpdateConfirmation.clickBtnSave();
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg update success");
		} else {
			setStatusTest("fail", "NOT Displays msg update success");
		}	
	}
	
	@Test (priority = 20, enabled = true)
	public void TT25067(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list only");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.clickOFFbtnCreateBaselinesDimension();
		cloneForm.clickOFFbtnEditBaselinesDimension();
		cloneForm.clickOFFbtnDeleteBaselinesDimension();
		cloneForm.clickOFFBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		
		TestLogger.info("Prepare data");
		controlBoard.clickIconControlBoard();
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
				
		if (formAddUpdateSkillToBaselineDimension.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		
		TestLogger.info("6. Select Caterogy Technical & Skill Reading");
		
		formAddUpdateSkillToBaselineDimension.inputData(DataManager.Baseline1,DataManager.Skill1);
			
		TestLogger.info("7. Select Skill Level 3");
		
		formAddUpdateSkillToBaselineDimension.clickRadiobtnL3();
		
		TestLogger.info("8. Click on Add button");
		
		formAddUpdateSkillToBaselineDimension.clickBtnAdd();
		
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
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Job list is displayed");
		}else{
			setStatusTest("fail", "Baseline Job list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CANNOT see/do Create, Delete, Edit");
		if(!baselineDimension.isBtnAddClickable()){
			setStatusTest("pass", "User CANNOT see/do btn Create baseline");
		}else{
			setStatusTest("fail", "User CAN see/do btn Create baseline");
		}
		if(!baselineDimension.isBtnEditClickable()){
			setStatusTest("pass", "User CANNOT see/do btn Edit baseline");
		}else{
			setStatusTest("fail", "User CAN see/do btn Edit baseline");
		}
		if(!baselineDimension.isIconDeleteDisplayed()){
			setStatusTest("pass", "User CANNOT see/do btn Delete skill");
		}else{
			setStatusTest("fail", "User CAN see/do btn Delete skill");
		}
	}
	
	@Test (priority = 21, enabled = true)
	public void TT25068(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list + Create + Clone");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.clickONbtnCreateBaselinesDimension();
		cloneForm.clickOFFbtnEditBaselinesDimension();
		cloneForm.clickOFFbtnDeleteBaselinesDimension();
		cloneForm.clickONBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Dimension list is displayed");
		}else{
			setStatusTest("fail", "Baseline Dimension list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Create, link add skill, link Clone");
		if(!baselineDimension.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			if(baselineDimension.isBtnAddClickable()){
				setStatusTest("pass", "User CAN see btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create baseline");
			}
			if(baselineDimension.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CAN see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see link Add Skill to Baseline");
			}
			if(baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CAN see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item add skill to Baseline");
			}
			if(baselineDimension.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CAN see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see link Clone Baseline");
			}
			if(baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CAN see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item Clone Baseline");
			}
			TestLogger.info("10. User CANNOT see/do btn Edit, Delete");
			if(!baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			if(baselineDimension.isBtnAddAfterEditClickable()){
				setStatusTest("pass", "User CAN see btn Create baseline");
			}else{
				setStatusTest("fail", "User CANNOT see btn Create baseline");
			}
			if(baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CAN see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item add skill to Baseline");
			}
			if(baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CAN see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CANNOT see item Clone Baseline");
			}
			TestLogger.info("10. User CANNOT see/do btn Delete");
			if(!baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
		}
	}
	
	@Test (priority = 22, enabled = true)
	public void TT25069(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list + Create + Clone");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.clickOFFbtnCreateBaselinesDimension();
		cloneForm.clickONbtnEditBaselinesDimension();
		cloneForm.clickOFFbtnDeleteBaselinesDimension();
		cloneForm.clickOFFBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Dimension list is displayed");
		}else{
			setStatusTest("fail", "Baseline Dimension list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Edit");
		if(!baselineDimension.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			TestLogger.info("10. User CANNOT see/do btn Edit, Create, Delete, Clone");
			if(!baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineDimension.isBtnAddClickable()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineDimension.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Add Skill to Baseline");
			}
			if(!baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineDimension.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Clone Baseline");
			}
			if(!baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			TestLogger.info("10. User CANNOT see/do btn Create, Delete, Clone");
			if(!baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineDimension.isBtnAddAfterEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}
	}
	
	@Test (priority = 22, enabled = true)
	public void TT25070(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list + Create + Clone");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.clickOFFbtnCreateBaselinesDimension();
		cloneForm.clickOFFbtnEditBaselinesDimension();
		cloneForm.clickONbtnDeleteBaselinesDimension();
		cloneForm.clickOFFBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Dimension list is displayed");
		}else{
			setStatusTest("fail", "Baseline Dimension list is NOT displayed");
		}
		TestLogger.info("9. Expected: User CAN see/do btn Edit, Delete");
		if(!baselineDimension.isFirstSkillDisplayed()){
			System.out.println("In case : NO DATA");
			TestLogger.info("10. User CANNOT see/do btn Edit, Create, Delete, Clone");
			if(!baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Edit");
			}else{
				setStatusTest("fail", "User CAN see btn Edit");
			}
			if(!baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CANNOT see icon Delete");
			}else{
				setStatusTest("fail", "User CAN see icon Delete");
			}
			if(!baselineDimension.isBtnAddClickable()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineDimension.isLinkAddSkillDisplayed()){
				setStatusTest("pass", "User CANNOT see link Add Skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Add Skill to Baseline");
			}
			if(!baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineDimension.isLinkCloneBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see link Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see link Clone Baseline");
			}
			if(!baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}else{
			System.out.println("In case : HAVE DATA");
			if(baselineDimension.isBtnEditClickable()){
				setStatusTest("pass", "User CAN see btn Edit");
			}else{
				setStatusTest("fail", "User CANNOT see btn Edit");
			}
			if(baselineDimension.isIconDeleteDisplayed()){
				setStatusTest("pass", "User CAN see icon Delete");
			}else{
				setStatusTest("fail", "User CANNOT see icon Delete");
			}
			TestLogger.info("10. User CANNOT see/do btn Create, Clone");
			if(!baselineDimension.isBtnAddAfterEditClickable()){
				setStatusTest("pass", "User CANNOT see btn Create baseline");
			}else{
				setStatusTest("fail", "User CAN see btn Create baseline");
			}
			if(!baselineDimension.isItemAddSkillToBaselineDisplayed()){
				setStatusTest("pass", "User CANNOT see item add skill to Baseline");
			}else{
				setStatusTest("fail", "User CAN see item add skill to Baseline");
			}
			if(!baselineDimension.isItemCloneDisplayed()){
				setStatusTest("pass", "User CANNOT see item Clone Baseline");
			}else{
				setStatusTest("fail", "User CAN see item Clone Baseline");
			}
		}
	}
	
	@Test (priority = 23, enabled = true)
	public void TT25073(){
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list + Create + Clone");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnViewBaselineListDimension();
		cloneForm.clickONbtnCreateBaselinesDimension();
		cloneForm.clickONbtnEditBaselinesDimension();
		cloneForm.clickONbtnDeleteBaselinesDimension();
		cloneForm.clickONBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CANNOT see/do Baseline subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User CANNOT see/do Baseline link on Control board");
		if(!controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CAN see/do Baseline link on Control Board");
		}
		TestLogger.info("Paste URL of baseline >> Expected: 403 page");
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Baseline/Index");
		if(baseline.isPage403Displayed()){
			setStatusTest("pass", "403 page is displayed");
		}else{
			setStatusTest("fail", "403 page is NOT displayed");
		}
	}
	
	@Test (priority = 24, enabled = true)
	public void TT25072() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Function Set");
		controlBoard.clickLblFunctionSet();
		if (functionSet.isLblFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Access to Function Set");
		} else {
			setStatusTest("fail", "Not Access to Function Set");
		}
		
		TestLogger.info("3. Update Function Set|Job Level | View Dimension baseline list + Create + Clone");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabTalent();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		for(int i=0; i<= 4; i++){
			cloneForm.clickBtnCollapse();
		}
		cloneForm.clickOFFBtnRadioPostionBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickOFFbtnRadioJobBaseline();
		cloneForm.clickBtn2ndCollapse();
		cloneForm.clickONbtnViewBaselineListDimension();
		cloneForm.clickONbtnCreateBaselinesDimension();
		cloneForm.clickONbtnEditBaselinesDimension();
		cloneForm.clickONbtnDeleteBaselinesDimension();
		cloneForm.clickONBtnCloneBaselinesDimension();
		cloneForm.fillTxtDescription(DataManager.FunctionSet);
		cloneForm.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
		}
		TestLogger.info("4. Logout >> Login with account User");
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		if (loginScreen.isLblWelcomeToDisplayed() == true) {
			setStatusTest("pass", "Logout Successfully!");
		} else {
			setStatusTest("fail", "Logout Fail!");
		}
		
		loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. User CAN see/do Baseline subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkBaselineOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Baseline link on Control board");
		if(controlBoard.isLblBaseLineDisplayed()){
			setStatusTest("pass", "User CAN see/do Baseline link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Baseline link on Control Board");
		}
		TestLogger.info("7. Access Baseline section");
		controlBoard.clickLblBaseLine();
		TestLogger.info("Expected: user can view baseline for 1 tab: Dimension");
		if(!baseline.isTabPositionDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Position");
		}else{
			setStatusTest("fail", "User CAN view tab Position");
		}
		if(!baseline.isTabJobDisplayed()){
			setStatusTest("pass", "User CANNOT view tab Job");
		}else{
			setStatusTest("fail", "User CAN view tab Job");
		}
		if(baseline.isTabDimensionDisplayed()){
			setStatusTest("pass", "User CAN view tab Dimension");
		}else{
			setStatusTest("fail", "User CANNOT view tab Dimension");
		}
		TestLogger.info("8. Select a category");
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Dimension list is displayed");
		}else{
			setStatusTest("fail", "Baseline Dimension list is NOT displayed");
		}
		
		TestLogger.info("Expected: user CAN add skill to baseline successfully");
		if(baselineDimension.isLblViewBaselineDisplayed() == true)
		{
			baselineDimension.clickBtnEdit();
			baselineDimension.clickIconDelete();
			baselineDimension.clickBtnSave();
			form_BaselineUpdateConfirmation_Dimension.clickBtnSave();
		}
		
		TestLogger.info("9. Click on 'Add Skill' hyperlink"); 
		baselineDimension.clickBtnAddSkill();
		baselineDimension.clickItemSkill();
		if (formAddUpdateSkillToBaselineDimension.isLblAddSkillToBaseLineDisplayed()) {
			setStatusTest("pass", "Open Add Skill To Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill To Baseline popup");
		}
		TestLogger.info("10. Select Caterogy Technical & Skill Reading");
		formAddUpdateSkillToBaselineDimension.inputData(DataManager.Baseline1,DataManager.Skill1);
		TestLogger.info("11. Select Skill Level 3");
		formAddUpdateSkillToBaselineDimension.clickRadiobtnL3();
		TestLogger.info("12. Click on Add button");
		formAddUpdateSkillToBaselineDimension.clickBtnAdd();
		if (baselineDimension.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "System saves the skills to baseline and redirects to Preview baseline");
		} else {
			setStatusTest("fail", "NOT System saves the skills to baseline and redirects to Preview baseline");
		}
		TestLogger.info("13. Double click on Save button");
		baselineDimension.clickDoubleBtnSave();
		Thread.sleep(2500);
		String afterCreate = baselineDimension.getTextBtnFirstCollapse();
		if(!afterCreate.equals("")){
			setStatusTest("pass", "Function create works normally");
		}else{
			setStatusTest("fail", "Function create NOT work normally");
		}
		
		TestLogger.info("Expected: User can edit skill level");
		baselineDimension.clickBtnEdit();
		baselineDimension.clickLinkSkillL1();
		Thread.sleep(3000);
		if (formAddUpdateSkillToBaselineDimension.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Access to Update Skill to Baseline popup");
		} else {
			setStatusTest("fail", "NOT Access to Update Skill to Baseline popup");
		}
		
		TestLogger.info("14. Update Skill from Level 1 to Level 2"); 
		
		formAddUpdateSkillToBaselineDimension.clickRadiobtnL2();
		
		TestLogger.info("Expect : User CAN see/do: " + "Update Skill Success");
		
		if (formAddUpdateSkillToBaselineDimension.isCheckSetKeyDisplayed() == false) {
			setStatusTest("pass", "Update Skill Success");
		} else {
			setStatusTest("fail", "Update Skill NOT Success");
		}
		
		TestLogger.info("15. Set key"); 
				
		formAddUpdateSkillToBaselineDimension.clickBtnSetKey();
		
		TestLogger.info("Expect : User CAN see/do:\r\n"
				+ "1. System marks selected behavior as important\r\n"
				+ "2. Check & key icon change to green");
		
		if (formAddUpdateSkillToBaselineDimension.isCheckSetKeyDisplayed() == true) {
			setStatusTest("pass", "System marks selected behavior as important");
		} else {
			setStatusTest("fail", "NOT System marks selected behavior as important");
		}
		
		if (formAddUpdateSkillToBaselineDimension.isCheckBehaviorDisplayed() == true) {
			setStatusTest("pass", "Check & key icon change to green");
		} else {
			setStatusTest("fail", "NOT Check & key NOT icon change to green");
		}
		
		TestLogger.info("16. Click on Update button"); 
		
		formAddUpdateSkillToBaselineDimension.clickBtnAdd();
		
		TestLogger.info("Expect : User CAN see/do: " + "System changes level to level 3 and redirects to Preview Baseline screen");
		
		if (formAddUpdateSkillToBaselineDimension.isLblAddSkillToBaseLineDisplayed() == false) {
			setStatusTest("pass", "System changes level to level 2 and redirects to Preview Baseline screen");
		} else {
			setStatusTest("fail", "NOT System changes level to level 2 and redirects to Preview Baseline screen");
		}
		baselineDimension.clickBtnSave();
		form_BaselineUpdateConfirmation_Dimension.clickBtnSave();
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg update success");
		} else {
			setStatusTest("fail", "NOT Displays msg update success");
		}
		
		TestLogger.info("Expected: User can delete skill successfully");
		baselineDimension.clickBtnEdit();
		baselineDimension.clickIconDelete();
		baselineDimension.clickBtnSave();
		form_BaselineUpdateConfirmation_Dimension.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg delete success");
		} else {
			setStatusTest("fail", "NOT Displays msg delete success");
		}
		driver.navigate().refresh();
		baselineDimension.fillTxtSearchDimension(DataManager.BalinseDimension);
		if(baselineDimension.isLblBaselineNameDisplayed()){
			setStatusTest("pass", "Baseline Dimension list is displayed");
		}else{
			setStatusTest("fail", "Baseline Dimension list is NOT displayed");
		}
		String afterDelete = baselineDimension.getTextBtnFirstCollapse();
		if(afterDelete.equals("")){
			setStatusTest("pass", "User CAN delete skill normally");
		}else{
			setStatusTest("pass", "User CANNOT delete skill normally");
		}
		
		TestLogger.info("Expected: User can clone skill successfully");
		baselineDimension.clickBtnAddSkill();
		baselineDimension.clickItemClone();
		if(formCloneBaselineDimension.isTitleCloneDisplayed()){
			setStatusTest("pass", "Open form clone successfully");
		}else{
			setStatusTest("fail", "Open form clone NOT successfully");
		}
		TestLogger.info("Select Dimension = Business Unit");
		formCloneBaselineDimension.selectDimension("Business Unit");
		TestLogger.info("Select Business Unit = [BA]");
		formCloneBaselineDimension.selectBusinessUnit("[BA] [^]");
		formCloneBaselineDimension.clickBtnClone();
		formCloneBaselineDimension.clickBtnSaveInPreview();
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg success");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg clone success");
		} else {
			setStatusTest("fail", "NOT Displays msg clone success");
		}
		String afterClone = baselineDimension.getTextBtnFirstCollapse();
		System.out.println(afterClone);
		if(!afterClone.equals("")){
			setStatusTest("pass", "User CAN clone skill normally");
		}else{
			setStatusTest("pass", "User CANNOT clone skill normally");
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
