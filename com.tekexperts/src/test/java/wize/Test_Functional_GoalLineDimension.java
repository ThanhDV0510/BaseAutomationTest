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
import Ulties.TienIch;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_Create_DimensionGoalLine;
import wize.pages.Form_GoalLineDimensionDetail;
import wize.pages.GoalLine;
import wize.pages.LoginScreen;
import wize.pages.Organization_BusinessUnit;

public class Test_Functional_GoalLineDimension extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	GoalLine goalLineList;
	Form_Create_DimensionGoalLine createDimensionGoalLine;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_GoalLineDimensionDetail detailDimensionGoalLine;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		goalLineList = new GoalLine(driver);
		createDimensionGoalLine = new Form_Create_DimensionGoalLine(driver);
		businessUnit = new Organization_BusinessUnit(driver);
		createBusinessUnit = new Form_CreateBusinessUnit(driver);
		detailDimensionGoalLine = new Form_GoalLineDimensionDetail(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)
	public void TT_22610() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Dimension");
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		if(!goalLineList.isLinkSecondDimensionDisplayed()){
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblOrganization();
			businessUnit.clickBtnAdd();
			
			if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
				setStatusTest("pass", "Open Create popup");
			} else {
				setStatusTest("fail", "Not Open Create popup");
			}
			
			createBusinessUnit.fillName(DataManager.Test);
			createBusinessUnit.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("4. Click Create Goal >> Input nothing");
		goalLineList.clickLinkCreateGoal();
		TestLogger.info("5. Click Close form create Goal");
		createDimensionGoalLine.clickBtnCancelCreate();
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "Form create is closed");
		}else{
			setStatusTest("fail", "Form create is NOT closed");
		}
		TestLogger.info("6. Click Create Goal >> Input goal name");
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.fillGoalName(DataManager.Test);
		TestLogger.info("7. Click Close form create Goal");
		createDimensionGoalLine.clickBtnCancelCreate();
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "Form create is closed");
		}else{
			setStatusTest("fail", "Form create is NOT closed");
		}
	}
	
	@Test (priority = 2,enabled = true)
	public void TT_22612(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Dimension");
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("4. Click Create Goal >> Input nothing >> Click btn Save and Create New");
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Checklist");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateChecklist()){
			setStatusTest("pass", "Mandatory field message is displayed below Checklist");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Checklist");
		}
		TestLogger.info("Step 1 is PASSED");
		// start step 2
		createDimensionGoalLine.clickRadioDuration();
		createDimensionGoalLine.createFinancialTypeAndCreateNew();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 2 is PASSED");
		
		// start step 3
		TestLogger.info("Fill data with specific date");
		createDimensionGoalLine.fillGoalName("a");
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 3 is PASSED");
		
		// start step 4
		TestLogger.info("Fill data with Repeat");
		createDimensionGoalLine.fillGoalName("b");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 4 is PASSED");
		
		// start step 5
		TestLogger.info("Fill data with Repeat >> Ends = After");
		createDimensionGoalLine.fillGoalName("c");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioAfter();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 5 is PASSED");
		
		// start step 6
		TestLogger.info("Fill data with Repeat >> Ends = On date");
		createDimensionGoalLine.fillGoalName("d");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioON();
		createDimensionGoalLine.setCalendarONDate();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 6 is PASSED");
		
		// start step 7
		TestLogger.info("Fill data with Finalcial = OFF, Time limit = Duration");
		createDimensionGoalLine.fillGoalName("e");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.fillDuration();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 7 is PASSED");
		
		// start step 8
		TestLogger.info("Fill data with specific date");
		createDimensionGoalLine.fillGoalName("f");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 8 is PASSED");
		
		// start step 9
		TestLogger.info("Fill data with Repeat");
		createDimensionGoalLine.fillGoalName("g");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 9 is PASSED");
		
		// start step 10
		TestLogger.info("Fill data with Repeat >> Ends = After");
		createDimensionGoalLine.fillGoalName("h");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioAfter();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 10 is PASSED");
		
		// start step 11
		TestLogger.info("Fill data with Repeat >> Ends = On date");
		createDimensionGoalLine.fillGoalName("i");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioON();
		createDimensionGoalLine.setCalendarONDate();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveAndCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveAndCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 11 is PASSED");
		createDimensionGoalLine.clickBtnCancelCreate();
		goalLineList.deleteAllGoal();
	}
	
	@Test (priority = 3,enabled = true)
	public void TT_22614(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Goal Line screen");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		
		TestLogger.info("3. Click Tab Dimension");
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("4. Click Create Goal >> Input nothing >> Click btn Save and Create New");
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Goal End Date + Checklist");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateEndDate()){
			setStatusTest("pass", "Mandatory field message is displayed below End Date");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below End Date");
		}
		if(createDimensionGoalLine.validateChecklist()){
			setStatusTest("pass", "Mandatory field message is displayed below Checklist");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Checklist");
		}
		TestLogger.info("Step 1 is PASSED");
		// start step 2
		createDimensionGoalLine.clickRadioDuration();
		createDimensionGoalLine.createFinancialTypeAndCreateNew();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 2 is PASSED");
		
		// start step 3
		TestLogger.info("Fill data with specific date");
		createDimensionGoalLine.fillGoalName("k");
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 3 is PASSED");
		
		// start step 4
		TestLogger.info("Fill data with Repeat");
		createDimensionGoalLine.fillGoalName("l");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 4 is PASSED");
		
		// start step 5
		TestLogger.info("Fill data with Repeat >> Ends = After");
		createDimensionGoalLine.fillGoalName("m");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioAfter();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 5 is PASSED");
		
		// start step 6
		TestLogger.info("Fill data with Repeat >> Ends = On date");
		createDimensionGoalLine.fillGoalName("n");
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioON();
		createDimensionGoalLine.setCalendarONDate();
		createDimensionGoalLine.fillTarget();
		createDimensionGoalLine.selectFormat();
		createDimensionGoalLine.selectMetrics();
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 6 is PASSED");
		
		// start step 7
		TestLogger.info("Fill data with Finalcial = OFF, Time limit = Duration");
		createDimensionGoalLine.fillGoalName("o");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.fillDuration();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 7 is PASSED");
		
		// start step 8
		TestLogger.info("Fill data with specific date");
		createDimensionGoalLine.fillGoalName("p");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioSpecificDates();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 8 is PASSED");
		
		// start step 9
		TestLogger.info("Fill data with Repeat");
		createDimensionGoalLine.fillGoalName("q");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 9 is PASSED");
		
		// start step 10
		TestLogger.info("Fill data with Repeat >> Ends = After");
		createDimensionGoalLine.fillGoalName("r");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioAfter();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 10 is PASSED");
		
		// start step 11
		TestLogger.info("Fill data with Repeat >> Ends = On date");
		createDimensionGoalLine.fillGoalName("s");
		createDimensionGoalLine.switchToNonFinancialType();
		createDimensionGoalLine.clickRadioRepeat();
		createDimensionGoalLine.setCalendarEndDate();
		createDimensionGoalLine.selectRepeatEveryYear();
		createDimensionGoalLine.clickRadioON();
		createDimensionGoalLine.setCalendarONDate();
		createDimensionGoalLine.fillChecklist("desc");
		createDimensionGoalLine.clickBtnSaveCreate();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.clickBtnSaveCreate();
		TestLogger.info("Expected: show mandatory field \nGoal name + Duration + Target + Format + Metrics");
		if(createDimensionGoalLine.validateGoalName()){
			setStatusTest("pass", "Mandatory field message is displayed below Goal Name");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Goal Name");
		}
		if(createDimensionGoalLine.validateDuration()){
			setStatusTest("pass", "Mandatory field message is displayed below Duration");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Duration");
		}
		if(createDimensionGoalLine.validateTarget()){
			setStatusTest("pass", "Mandatory field message is displayed below Target");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Target");
		}
		if(createDimensionGoalLine.validateFormat()){
			setStatusTest("pass", "Mandatory field message is displayed below Format");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Format");
		}
		if(createDimensionGoalLine.validateMetrics()){
			setStatusTest("pass", "Mandatory field message is displayed below Metrics");
		}else{
			setStatusTest("fail", "Mandatory field message is NOT displayed below Metrics");
		}
		TestLogger.info("Step 11 is PASSED");
	}
	
	@Test (priority = 4,enabled = true)
	public void TT_23513(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access Goal Line >> Dimension tab >> Click btn Bulk Delete");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("Expected: content message is correct as requirement AND Select NO on delete popup");
		if(goalLineList.compareTextPopupDeleteGoal()){
			setStatusTest("pass", "Content message on popup is correct");
		}else{
			setStatusTest("fail", "Content message on popup is NOT correct");
		}
		try {
			goalLineList.clickLinkCreateGoal();
			createDimensionGoalLine.clickBtnCancelCreate();
			setStatusTest("pass", "Deletion popup is closed");
		} catch (Exception e) {
			setStatusTest("fail", "Deletion popup is NOT closed");
		}
		TestLogger.info("4. Select YES on delete popup");
		TestLogger.info("Expected: selected goals are deleted from table");
		goalLineList.delete2Goals();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete successfully");
		}else{
			setStatusTest("fail", "Delete NOT successfully");
		}
	}
	
	@Test (priority = 5,enabled = true)
	public void TT_23527(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access Goal Line >> Dimension tab >> Click icon delete of the first item in talbe");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("Expected: content message is correct as requirement AND Select NO on delete popup");
		if(goalLineList.compareTextPopupDeleteFirstGoal()){
			setStatusTest("pass", "Content message on popup is correct");
		}else{
			setStatusTest("fail", "Content message on popup is NOT correct");
		}
		try {
			goalLineList.clickLinkCreateGoal();
			createDimensionGoalLine.clickBtnCancelCreate();
			setStatusTest("pass", "Deletion popup is closed");
		} catch (Exception e) {
			setStatusTest("fail", "Deletion popup is NOT closed");
		}
		TestLogger.info("4. Select YES on delete popup");
		TestLogger.info("Expected: selected goals are deleted from table");
		goalLineList.deleteFirstGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete successfully");
		}else{
			setStatusTest("fail", "Delete NOT successfully");
		}
	}
	
	@Test (priority = 6,enabled = true)
	public void TT_23532(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access Goal Line >> Dimension tab >> Click Detail of first item in table");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()){
			setStatusTest("pass", "Access to Goal Line list");
		} else {
			setStatusTest("fail", "Not Access to Goal Line list");
		}
		goalLineList.clickTabDimension();
		goalLineList.fillSearchJob(DataManager.Test);
		goalLineList.clickLinkSecondDimension();
		goalLineList.clickLinkCreateGoal();
		createDimensionGoalLine.createFinancialType(DataManager.Test + TienIch.taoRandomSo(4));
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.clickLinkFirstGoal();
		if(detailDimensionGoalLine.isTitleDetailDisplayed()){
			setStatusTest("pass", "Detail popup is displayed");
		}else{
			setStatusTest("fail", "Detail popup is NOT displayed");
		}
		detailDimensionGoalLine.clickIconDelete();
		
		TestLogger.info("Expected: content message is correct as requirement AND Select NO on delete popup");
		if(detailDimensionGoalLine.compareTextPopupDeleteFirstGoal()){
			setStatusTest("pass", "Content message on popup is correct");
		}else{
			setStatusTest("fail", "Content message on popup is NOT correct");
		}
		detailDimensionGoalLine.clickIconClose();
		try {
			goalLineList.clickLinkCreateGoal();
			createDimensionGoalLine.clickBtnCancelCreate();
			setStatusTest("pass", "Deletion popup is closed");
		} catch (Exception e) {
			setStatusTest("fail", "Deletion popup is NOT closed");
		}
		TestLogger.info("4. Select YES on delete popup");
		TestLogger.info("Expected: selected goals are deleted from table");
		goalLineList.clickLinkFirstGoal();
		detailDimensionGoalLine.clickIconDelete();
		detailDimensionGoalLine.deleteFirstGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete successfully");
		}else{
			setStatusTest("fail", "Delete NOT successfully");
		}
		goalLineList.deleteAllGoal2ndTime();
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
