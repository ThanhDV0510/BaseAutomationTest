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
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
import wize.pages.DashBoard;
import wize.pages.Form_EditFunctionSet;
import wize.pages.FrontLineManager;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;

public class Test_FunctionSet_FrontlineManager_SkillAssessment extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	Clone_Form_EditFunctionSet cloneForm;
	DashBoard db;
	FrontLineManager frontLine;
	
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
		db = new  DashBoard(driver);
		frontLine = new FrontLineManager(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test (priority = 1, enabled = true)
	public void TT25554(){
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
		
		TestLogger.info("3. Update Function Set| Front-line Manager | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabFrontLineManager();
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
		TestLogger.info("5. User CAN see/do Frontline Manager sublink on menu Dashboard");
		if(controlBoard.isSublinkFrontlineManagerOnMenuDisplayed()){
			setStatusTest("pass", "User CAN see/do Frontline Manager sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CANNOT see/do Frontline Manager sublink on menu Dashboard");
		}
		controlBoard.clickSublinkFrontlineManagerOnMenu();
		if(db.isTabFrontLineManagerDisplayed() == true){
			setStatusTest("Pass", "Display tab Front line Manager successfully");
		}else{
			setStatusTest("Pass", "Can not display tab Front line Manager");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. MY TEAM - POSITION FIT\r\n" 
				+ "2. TOP PERCENTAGE FIT\r\n"
				+ "3. BOTTOM PERCENTAGE FIT\r\n"
				+ "4. TOP SKILL AVERAGE VALUE\r\n"
				+ "5. BOTTOM SKILL AVERAGE VALUE");
		
		if (frontLine.isLblMyTeamPositionFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "MY TEAM - POSITION FI");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "MY TEAM - POSITION FI");
		}
		
		if (frontLine.isLblTopPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP PERCENTAGE FIT");
		}
		
		if (frontLine.isLblBottomPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM PERCENTAGE FIT");
		}
		
		if (frontLine.isLblTopSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP SKILL AVERAGE VALUE");
		}
		
		if (frontLine.isLblBottomSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT25555(){
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
		
		TestLogger.info("3. Update Function Set| Front-line Manager | View Only Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabFrontLineManager();
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
		TestLogger.info("5. User CAN see/do Frontline Manager sublink on menu Dashboard");
		if(controlBoard.isSublinkFrontlineManagerOnMenuDisplayed()){
			setStatusTest("pass", "User CAN see/do Frontline Manager sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CANNOT see/do Frontline Manager sublink on menu Dashboard");
		}
		controlBoard.clickSublinkFrontlineManagerOnMenu();
		if(db.isTabFrontLineManagerDisplayed() == true){
			setStatusTest("Pass", "Display tab Front line Manager successfully");
		}else{
			setStatusTest("Pass", "Can not display tab Front line Manager");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. MY TEAM - POSITION FIT\r\n" 
				+ "2. TOP PERCENTAGE FIT\r\n"
				+ "3. BOTTOM PERCENTAGE FIT\r\n"
				+ "4. TOP SKILL AVERAGE VALUE\r\n"
				+ "5. BOTTOM SKILL AVERAGE VALUE");
		
		if (frontLine.isLblMyTeamPositionFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "MY TEAM - POSITION FI");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "MY TEAM - POSITION FI");
		}
		
		if (frontLine.isLblTopPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP PERCENTAGE FIT");
		}
		
		if (frontLine.isLblBottomPercentageFitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM PERCENTAGE FIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM PERCENTAGE FIT");
		}
		
		if (frontLine.isLblTopSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "TOP SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "TOP SKILL AVERAGE VALUE");
		}
		
		if (frontLine.isLblBottomSkillAvgValueDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "BOTTOM SKILL AVERAGE VALUE");
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void TT25556(){
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
		
		TestLogger.info("3. Update Function Set| Front-line Manager | NO Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabFrontLineManager();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnViewFrontlineManager();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		TestLogger.info("5. User CANNOT see/do Frontline Manager sublink on menu Dashboard");
		if(!controlBoard.isSublinkFrontlineManagerOnMenuDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Frontline Manager sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CAN see/do Frontline Manager sublink on menu Dashboard");
		}
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "dashboard/index?id=2");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Frontline Manager screen");
		}else{
			setStatusTest("fail", "User CAN access Frontline Manager screen");
		}
	}
	
	@Test (priority = 4, enabled = true)
	public void TT25557(){
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
		
		TestLogger.info("3. Update Function Set| Skill Assessment | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabSkillAssessment();
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
		TestLogger.info("5. User CAN see/do Skill Assessment sublink on menu Dashboard");
		if(controlBoard.isSublinkSkillAssessmentOnMenuDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill Assessment sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill Assessment sublink on menu Dashboard");
		}
		controlBoard.clickSublinkSkillAssessmentOnMenu();
		if(db.isTabSkillAssessmentDisplayed() == true){
			setStatusTest("Pass", "Display tab Skill Assessment successfully");
		}else{
			setStatusTest("Pass", "Can not display tab Skill Assessment ");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Submission Date\r\n" 
				+ "2. ATTEMPT PER SKILL ASSESSMENT\r\n"
				+ "3. SKILL ASSESSMENT MATCH SCORE PER COMPETENCY\r\n"
				+ "4. ATTEMPT AVERAGE SCORE PER USER\r\n"
				+ "5. ATTEMPT AVERAGE SCORE PER UNIT\r\n"
				+ "6. SCORE DISTRIBUTION PER SKILL AND LEVEL");
		
		if (frontLine.isTxtSubmissionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Submission Date");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Submission Date");
		}
		
		if (frontLine.islblAttemptPerSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT PER SKILL ASSESSMENT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT PER SKILL ASSESSMENT");
		}
		
		if (frontLine.islblMatchScorePerCompetencyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "SKILL ASSESSMENT MATCH SCORE PER COMPETENCY");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "SKILL ASSESSMENT MATCH SCORE PER COMPETENCY");
		}
		
		if (frontLine.islblAttemptAVGScorePerUserDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT AVERAGE SCORE PER USER");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT AVERAGE SCORE PER USER");
		}
		
		if (frontLine.islblAttemptAVGScorePerUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT AVERAGE SCORE PER UNIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT AVERAGE SCORE PER UNIT");
		}
		
		if (frontLine.islblScoreDistributionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "SCORE DISTRIBUTION PER SKILL AND LEVEL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "SCORE DISTRIBUTION PER SKILL AND LEVEL");
		}
	}
	
	@Test (priority = 5, enabled = true)
	public void TT25558(){
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
		
		TestLogger.info("3. Update Function Set| Skill Assessment | View Only permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabSkillAssessment();
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
		TestLogger.info("5. User CAN see/do Skill Assessment sublink on menu Dashboard");
		if(controlBoard.isSublinkSkillAssessmentOnMenuDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill Assessment sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill Assessment sublink on menu Dashboard");
		}
		controlBoard.clickSublinkSkillAssessmentOnMenu();
		if(db.isTabSkillAssessmentDisplayed() == true){
			setStatusTest("Pass", "Display tab Skill Assessment  successfully");
		}else{
			setStatusTest("Pass", "Can not display tab Skill Assessment");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Submission Date\r\n" 
				+ "2. ATTEMPT PER SKILL ASSESSMENT\r\n"
				+ "3. SKILL ASSESSMENT MATCH SCORE PER COMPETENCY\r\n"
				+ "4. ATTEMPT AVERAGE SCORE PER USER\r\n"
				+ "5. ATTEMPT AVERAGE SCORE PER UNIT\r\n"
				+ "6. SCORE DISTRIBUTION PER SKILL AND LEVEL");
		
		if (frontLine.isTxtSubmissionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Submission Date");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Submission Date");
		}
		
		if (frontLine.islblAttemptPerSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT PER SKILL ASSESSMENT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT PER SKILL ASSESSMENT");
		}
		
		if (frontLine.islblMatchScorePerCompetencyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "SKILL ASSESSMENT MATCH SCORE PER COMPETENCY");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "SKILL ASSESSMENT MATCH SCORE PER COMPETENCY");
		}
		
		if (frontLine.islblAttemptAVGScorePerUserDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT AVERAGE SCORE PER USER");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT AVERAGE SCORE PER USER");
		}
		
		if (frontLine.islblAttemptAVGScorePerUnitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "ATTEMPT AVERAGE SCORE PER UNIT");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "ATTEMPT AVERAGE SCORE PER UNIT");
		}
		
		if (frontLine.islblScoreDistributionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "SCORE DISTRIBUTION PER SKILL AND LEVEL");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "SCORE DISTRIBUTION PER SKILL AND LEVEL");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT25559(){
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
		
		TestLogger.info("3. Update Function Set| Skill Assessment | NO Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabSkillAssessment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnViewSkillAssessment();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		TestLogger.info("5. User CANNOT see/do Skill Assessment sublink on menu Dashboard");
		if(!controlBoard.isSublinkSkillAssessmentOnMenuDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Skill Assessment sublink on menu Dashboard");
		}else{
			setStatusTest("fail", "User CAN see/do Skill Assessment sublink on menu Dashboard");
		}
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "dashboard/index?id=3");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Skill Assessment");
		}else{
			setStatusTest("fail", "User CAN access Skill Assessment");
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void TT25560(){
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
		
		TestLogger.info("3. Update Function Set| My Skill Gap + Frontline Manager + Skill Assessment | NO Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabDashBoard();
		cloneForm.clickSubTabMySkillGap();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnViewMySkillGap();
		cloneForm.clickSubTabFrontLineManager();
		cloneForm.clickOFFBtnViewFrontlineManager();
		cloneForm.clickSubTabSkillAssessment();
		cloneForm.clickOFFBtnViewSkillAssessment();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		TestLogger.info("5. User CANNOT see/do Dashboard link on menu Dashboard");
		if(!controlBoard.isLinkDashboardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Dashboard link on menu Dashboard");
		}else{
			setStatusTest("fail", "User CAN see/do Dashboard link on menu Dashboard");
		}
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "dashboard/index?id=1");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access My Skill Gap");
		}else{
			setStatusTest("fail", "User CAN access My Skill Gap");
		}
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "dashboard/index?id=2");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Frontline Manager screen");
		}else{
			setStatusTest("fail", "User CAN access Frontline Manager screen");
		}
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "dashboard/index?id=3");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Skill Assessment");
		}else{
			setStatusTest("fail", "User CAN access Skill Assessment");
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
