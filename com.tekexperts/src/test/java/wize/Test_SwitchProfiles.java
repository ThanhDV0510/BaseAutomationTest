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
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_SwitchProfiles;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;

public class Test_SwitchProfiles extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	Form_SwitchProfiles switchProfile;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {
		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
		switchProfile = new Form_SwitchProfiles(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)
	public void TT_17605() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Open Switch Profile button");
		switchProfile.clickBtnSwitchProfile();
		if(switchProfile.isPopupDisplayed()){
			setStatusTest("Pass", "Open popup Switch Security Profile successfully");
		}else{
			setStatusTest("Fail", "Could not open popup Switch Security Profile");
		}
		
		TestLogger.info("3. Switch to other Profile");
		boolean tempProfileStatus = switchProfile.getStatusProfile1();
		boolean tempCrownStatus = switchProfile.getStatusCrown1();
		switchProfile.changeProfile();
		if(controlBoard.isLblControlBoardDisplayed()){
			setStatusTest("Pass", "Click Save successfully");
		}else{
			setStatusTest("Fail", "Could not click Save");
		}
		
		controlBoard.logout();
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		switchProfile.clickBtnSwitchProfile();
		Thread.sleep(2000);
		if(tempProfileStatus == switchProfile.getStatusProfile1() && tempCrownStatus == switchProfile.getStatusCrown1()){
			setStatusTest("Pass", "Status and crown of profile 1 were not changed!");
		}else{
			setStatusTest("Fail", "Status or crown of profile 1 was changed!");
		}
		driver.navigate().refresh();
	}
	
	@Test(priority = 2, enabled = true)
	public void TT_17606() throws InterruptedException{
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Open Switch Profile button");
		switchProfile.clickBtnSwitchProfile();
		if(switchProfile.isPopupDisplayed()){
			setStatusTest("Pass", "Open popup Switch Security Profile successfully");
		}else{
			setStatusTest("Fail", "Could not open popup Switch Security Profile");
		}
		
		TestLogger.info("3. Switch to other Profile and other default login");
		boolean tempProfileStatus = switchProfile.getStatusProfile1();
		boolean tempCrownStatus = switchProfile.getStatusCrown1();
		switchProfile.changeProfileAndCrown();
		if(controlBoard.isLblControlBoardDisplayed()){
			setStatusTest("Pass", "Click Save successfully");
		}else{
			setStatusTest("Fail", "Could not click Save");
		}
		
		controlBoard.logout();
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		switchProfile.clickBtnSwitchProfile();
		Thread.sleep(2000);
		if(tempProfileStatus != switchProfile.getStatusProfile1() && tempCrownStatus != switchProfile.getStatusCrown1()){
			setStatusTest("Pass", "Status and crown of profile 1 were changed!");
		}else{
			setStatusTest("Fail", "Status or crown of profile 1 was not changed!");
		}
		driver.navigate().refresh();
	}
	
	@Test(priority = 3, enabled = true)
	public void TT_17596() throws InterruptedException{
		boolean isDBoard, isQPool, isAList, isMAssessment, isLibrary, isJList, isJLevel, isPosition, isBLine, isDimenList, isSkill, isSettings, isSProfile, isRole,isFSet,isUser = false; 
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Open Switch Profile button");
		switchProfile.clickBtnSwitchProfile();
		if(switchProfile.isPopupDisplayed()){
			setStatusTest("Pass", "Open popup Switch Security Profile successfully");
		}else{
			setStatusTest("Fail", "Could not open popup Switch Security Profile");
		}
		
		TestLogger.info("3. Switch to full permission Profile");
		boolean tempProfileStatus = switchProfile.getStatusProfile1();
		if(tempProfileStatus == true){
			setStatusTest("Pass", "Green icon and crown icon is right");
		}else{
			switchProfile.changeProfileAndCrown();
			setStatusTest("Pass", "Change to full permisison successfully");
			Thread.sleep(2000);
		}
		isDBoard = switchProfile.isDashboardAccessible();
		isQPool = switchProfile.isQuestionPoolAccessible();
		isAList = switchProfile.isAssessmentListAccessible();
		isMAssessment = switchProfile.isMyAssessmentAccessible();
		isLibrary = switchProfile.isLibraryAccessible();
		isJList = switchProfile.isJobListAccessible();
		isJLevel = switchProfile.isJobLevelAccessible();
		isPosition = switchProfile.isPositionAccessible();
		isBLine = switchProfile.isBaselineAccessible();
		isDimenList = switchProfile.isDimenstionListAccessible();
		isSkill = switchProfile.isSkillAccessible();
		isSettings = switchProfile.isGeneralSettingsAccessible();
		isSProfile = switchProfile.isSecurityProfileAccessible();
		isRole = switchProfile.isRoleAccessible();
		isFSet = switchProfile.isFunctionSetAccessible();
		isUser = switchProfile.isUserAccessible();
		System.out.println("Dasboard: " + isDBoard);
		System.out.println("Question pool: " + isQPool);
		System.out.println("My Assessment: " + isMAssessment);
		System.out.println("Assessment Library: " + isLibrary);
		System.out.println("Job List: " + isJList);
		System.out.println("Job Level: " + isJLevel);
		System.out.println("Position list: " + isPosition);
		System.out.println("Baseline: " + isBLine);
		System.out.println("Dimension list: " + isDimenList);
		System.out.println("Skill list: " + isSkill);
		System.out.println("General Settings: " + isSettings);
		System.out.println("Security Profile: " + isSProfile);
		System.out.println("Role list: " + isRole);
		System.out.println("Function set list: " + isFSet);
		System.out.println("User list: " + isUser);
		if(isDBoard && isQPool && isAList && isMAssessment && isLibrary && isJList && isJLevel && isPosition && isBLine && isDimenList && isSkill && isSettings && isSProfile && isRole && isFSet && isUser){
			setStatusTest("Pass", "User can access all pages normally");
		}else{
			setStatusTest("Fail", "User can not access some pages");
		}
	}
	
	@Test(priority = 4, enabled = true)
	public void TT_17603() throws InterruptedException{
		boolean isDBoard, isQPool, isAList, isMAssessment, isLibrary, isJList, isJLevel, isPosition, isBLine, isDimenList, isSkill, isSettings, isSProfile, isRole,isFSet,isUser = false; 
		TestLogger.info("1. Login with account Admin");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Update Function Set|Security Profile | Not accessible to Question Pool ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clickTabAssessment();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewQuestionList();
		
		TestLogger.info("4. Update Function Set|Security Profile | Accessible to Assessment list");
		editFunctionSet.clickSubTabAssessmentSettings();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickONbtnRadioGeneralSettings();
		editFunctionSet.clickONbtnViewAssessmentList();
		
		TestLogger.info("5. Update Function Set|Security Profile | Accessible to Assessment Library and My Assessment");
		editFunctionSet.clickSubTabAssessmentLearner();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickONbtnRadioTestLibrary();
		editFunctionSet.clickONbtnViewTestLibrary();
		editFunctionSet.clickONbtnRadioMyTest();
		editFunctionSet.clickONbtnViewMyTest();
		
		TestLogger.info("6. Update Function Set|Security Profile | Not accessible to Job list");
		editFunctionSet.clickTabControlBoardTalent();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewJobList();
		
		TestLogger.info("7. Update Function Set|Security Profile | Not accessible to Job Level list");
		editFunctionSet.clickSubTabTalentJobLevel();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewJobLevelList();
		
		TestLogger.info("8. Update Function Set|Security Profile | Not accessible to Position list");
		editFunctionSet.clickSubTabTalentPosition();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewPositionList();
		
		TestLogger.info("9. Update Function Set|Security Profile | Accessible to Baseline list");
		editFunctionSet.clickSubTabTalentBaseline();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickONBtnRadioPostionBaseline();
		editFunctionSet.clickONbtnViewBaselineListPosition();
		
		TestLogger.info("10. Update Function Set|Security Profile | Not accessible to Dimension list");
		editFunctionSet.clickTabSystemSettings();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewDimensionList();
		
		TestLogger.info("11. Update Function Set|Security Profile | Not accessible to Skill list");
		editFunctionSet.clickSubTabSkill();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewSkills();
		
		TestLogger.info("12. Update Function Set|Security Profile | Not accessible to General Settings list");
		editFunctionSet.clickSubTabGeneralSettings();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewGeneralSettings();
		
		TestLogger.info("13. Update Function Set|Security Profile | Not accessible to Security Profiles list");
		editFunctionSet.clickSubTabSecurityProfile();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewSecurityProfile();
		
		TestLogger.info("14. Update Function Set|Security Profile | Not accessible to Security Profiles list");
		editFunctionSet.clickSubTabRole();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewRole();
		
		TestLogger.info("15. Update Function Set|Security Profile | Not accessible to Function Set list");
		editFunctionSet.clickSubTabFunctionSet();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewFunctionSet();
		
		TestLogger.info("16. Update Function Set|Security Profile | Not accessible to Users list");
		editFunctionSet.clickSubTabUser();
		editFunctionSet.clickCboxSubCustomization();
		editFunctionSet.clickOFFbtnViewUser();
		editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
		editFunctionSet.clickBtnSave();
		
		TestLogger.info("17. Open Switch Profile button");
		switchProfile.clickBtnSwitchProfile();
		if(switchProfile.isPopupDisplayed()){
			setStatusTest("Pass", "Open popup Switch Security Profile successfully");
		}else{
			setStatusTest("Fail", "Could not open popup Switch Security Profile");
		}
		
		TestLogger.info("18. Switch to Only view permission Profile");
		Thread.sleep(2000);
		boolean tempProfileStatus = switchProfile.getStatusProfile1();
		if(tempProfileStatus == true){
			switchProfile.changeProfile();
			setStatusTest("Pass", "Change to Only view permisison successfully");
			Thread.sleep(3000);
		}else{
			setStatusTest("Pass", "Green icon and crown icon is right");
		}
		isDBoard = switchProfile.isDashboardAccessible();
		isQPool = switchProfile.isQuestionPoolAccessible();
		isAList = switchProfile.isAssessmentListAccessible();
		isMAssessment = switchProfile.isMyAssessmentAccessible();
		isLibrary = switchProfile.isLibraryAccessible();
		isJList = switchProfile.isJobListAccessible();
		isJLevel = switchProfile.isJobLevelAccessible();
		isPosition = switchProfile.isPositionAccessible();
		isBLine = switchProfile.isBaselineAccessible();
		isDimenList = switchProfile.isDimenstionListAccessible();
		isSkill = switchProfile.isSkillAccessible();
		isSettings = switchProfile.isGeneralSettingsAccessible();
		isSProfile = switchProfile.isSecurityProfileAccessible();
		isRole = switchProfile.isRoleAccessible();
		isFSet = switchProfile.isFunctionSetAccessible();
		isUser = switchProfile.isUserAccessible();
		System.out.println("Dasboard: " + isDBoard);
		System.out.println("Question pool: " + isQPool);
		System.out.println("Assessment list: " + isAList);
		System.out.println("My Assessment: " + isMAssessment);
		System.out.println("Assessment Library: " + isLibrary);
		System.out.println("Job List: " + isJList);
		System.out.println("Job Level: " + isJLevel);
		System.out.println("Position list: " + isPosition);
		System.out.println("Baseline: " + isBLine);
		System.out.println("Dimension list: " + isDimenList);
		System.out.println("Skill list: " + isSkill);
		System.out.println("General Settings: " + isSettings);
		System.out.println("Security Profile: " + isSProfile);
		System.out.println("Role list: " + isRole);
		System.out.println("Function set list: " + isFSet);
		System.out.println("User list: " + isUser);
		if(isDBoard && !isQPool && isAList && isMAssessment && isLibrary && !isJList && !isJLevel && !isPosition && isBLine && !isDimenList && !isSkill && !isSettings && !isSProfile && !isRole && !isFSet && !isUser){
			setStatusTest("Pass", "User only can access Assessment list, My Assessment, Assessment Library normally");
		}else{
			setStatusTest("Fail", "User only can access Assessment list, My Assessment, Assessment Library normally");
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
