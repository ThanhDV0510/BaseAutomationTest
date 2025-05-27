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
import wize.pages.Assessment;
import wize.pages.AssessmentSchedule;
import wize.pages.Assessment_ScheduleAndAttendeeTab;
import wize.pages.AttendeeList_TestSchedule;
import wize.pages.ControlBoard;
import wize.pages.Form_AssignAttendee;
import wize.pages.Form_CreateSkillTest;
import wize.pages.Form_CreateTestSchedule;
import wize.pages.LoginScreen;

public class Test_Functional_Assessment_ScheduleTab extends TestManager{
	String assessmentName = DataManager.ManuallyAssign1;
	String scheduleName = DataManager.ScheduleManually1;
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	Assessment assessment;
	Assessment_ScheduleAndAttendeeTab scheduleAttendeeTab;
	Form_AssignAttendee assignAttendee;
	Form_CreateSkillTest createSkillTest;
	AssessmentSchedule assessmentSchedule;
	Form_CreateTestSchedule createTestSchedule;
	AttendeeList_TestSchedule attendeeListSchedule;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		assessment = new Assessment(driver);
		scheduleAttendeeTab = new Assessment_ScheduleAndAttendeeTab(driver);
		assignAttendee = new Form_AssignAttendee(driver);
		createSkillTest = new Form_CreateSkillTest(driver);
		assessmentSchedule = new AssessmentSchedule(driver);
		createTestSchedule = new Form_CreateTestSchedule(driver);
		attendeeListSchedule = new AttendeeList_TestSchedule(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@Test (priority = 0, enabled = true)
	public void createManuallyAssignAssessment(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Assesment >> Select a Category");

		controlBoard.clickLblAssessment();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}		
		
		assessment.fillSearchCategory(DataManager.FunctionSet);

		assessment.clickFirstCategory();
			
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		
		TestLogger.info("3. Open create Skill Test >> Input data on Basic Information tab");
		
		assessment.clickBtnCreateAssessment();
		assessment.clickItemSkillTest();
		
		if (createSkillTest.isLblCreateSkillTestDisplayed() == true) {
			setStatusTest("pass", "Access to Create Skill Test");
		} else {
			setStatusTest("fail", "Not Access to Create Skill Test");
		}	
		
		createSkillTest.fillTitle(assessmentName);
		createSkillTest.fillDescription(DataManager.ManuallyAssign1);
		createSkillTest.fillCategory("t");
	
		if (createSkillTest.isBtnThumbnailDisplayed() == true) {
			setStatusTest("pass", "Import Success");
		} else {
			setStatusTest("fail", "Import NOT Success");
		}
		
		TestLogger.info("4. Next to Testing settings tab >> Input data");
		
		createSkillTest.clickBtnNextInfo();
		
		if (createSkillTest.isLblRestrictionDisplayed() == true) {
			setStatusTest("pass", "Access to Testing settings tab");
		} else {
			setStatusTest("fail", "Not Access to Testing settings tab");
		}	

		createSkillTest.clickBtnRadioAssessmentSettings();
		
		TestLogger.info("5. Next to Question tab >> Input data on Question tab >> Click on button Save");
		
		createSkillTest.clickBtnNextTesting();;
		
		if (createSkillTest.isblAssessmentByDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
		
		createSkillTest.clickDrplistDimensionValue(DataManager.Assessment);
		createSkillTest.clickItemDimensionValue();
		
		createSkillTest.clickIconAddQuestion();
		
		if (createSkillTest.isLblImportQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Question tab");
		} else {
			setStatusTest("fail", "Not Access to Question tab");
		}
				
		createSkillTest.clickCboxAll();
		createSkillTest.clickBtnSaveImport();
		
		if (createSkillTest.isIconDelete1Displayed() == true) {
			setStatusTest("pass", "Add Question Success");
		} else {
			setStatusTest("fail", "Add Question Fail");
		}
		
		createSkillTest.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Skill Test created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Skill Test created successfully");
		}	
		
		TestLogger.info("6. Create test schedule");
		
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Test Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Test Schedule");
		}
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Test Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Test Schedule popup");
		}	
			
		createTestSchedule.fillScheduleName(scheduleName);
		createTestSchedule.clickIconStartDate();
		createTestSchedule.clickItemTodayStartDate();
		createTestSchedule.setScheduleEndDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Test schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Test schedule created successfully");
		}	

		TestLogger.info("7.  Access to Attende List >> Assign Employee to Schedule");
		
		assessmentSchedule.clickIconLinkAttendee();
		
		if (attendeeListSchedule.isLblAttendeeListDisplayed() == true) {
			setStatusTest("pass", "Access to Attende List");
		} else {
			setStatusTest("fail", "Not Access to Attende List");
		}
		
		attendeeListSchedule.clickBtnAssignmentUser();
		
		if (assignAttendee.isLblAssignAttendeeDisplayed() == true) {
			setStatusTest("pass", "Access to Assgin Attendee popup");
		} else {
			setStatusTest("fail", "Not Access to Assgin Attendee popup");
		}
		
		assignAttendee.fillSearch(PropertyManager.fullNameAdmin1);
		assignAttendee.clickCboxAllLeft();
		assignAttendee.clickBtnMove();
		assignAttendee.clickBtnAssign();
			
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User added to schedule successfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "User added to schedule successfully");
		}
	}
	
	@Test (priority = 1, enabled = true)
	public void TT_20464_TT_20466(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}	
		
		TestLogger.info("3. Create New Caterogy or Access to a Category");
		
		assessment.fillSearchCategory(DataManager.FunctionSet);
		if(assessment.isFirstCategoryDisplayed() == true) 
		{
			assessment.clickFirstCategory();
			
			if (assessment.isLblAssessmentDisplayed() == true) {
				setStatusTest("pass","Open Test screen");
			} else {
				setStatusTest("fail","NOT Open Test screen");
			}
		}
		else
		{
			assessment.clickBtnCreateCategory();
				
			if (assessment.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Open Create Category popup");
			} else {
				setStatusTest("fail", "NOT Open Create Category popup");
			}
				
			assessment.fillCategoryName("DataManager.FunctionSet");
			assessment.clickBtnSaveCreate();
				
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Test category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Test category created sucessfully");
			}
			assessment.fillSearchCategory("DataManager.FunctionSet");
			assessment.clickFirstCategory();
		}
		
		TestLogger.info("4. Click on Schedule tab");
		scheduleAttendeeTab.clickTabSchedule();
		if(scheduleAttendeeTab.isTabScheduleSelected()){
			setStatusTest("pass", "Schedule tab is selected");
		}else{
			setStatusTest("pass", "Schedule tab is NOT selected");
		}
		TestLogger.info("5. Click on Assessment tab from Schedule tab");
		scheduleAttendeeTab.clickTabAssessment();
		if(scheduleAttendeeTab.isTabAssessmentSelected()){
			setStatusTest("pass", "Assessment tab is selected");
		}else{
			setStatusTest("pass", "Assessment tab is NOT selected");
		}
		TestLogger.info("6. Click on Attendee tab from Schedule tab");
		scheduleAttendeeTab.clickTabSchedule();
		if(scheduleAttendeeTab.isTabScheduleSelected()){
			setStatusTest("pass", "Back to Schedule tab successfully");
		}else{
			setStatusTest("pass", "Back to Schedule tab NOT successfully");
		}
		scheduleAttendeeTab.clickTabAttendee();
		if(scheduleAttendeeTab.isTabAttendeeSelected()){
			setStatusTest("pass", "Attendee tab is selected");
		}else{
			setStatusTest("pass", "Attendee tab is NOT selected");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT_20469(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
		
		TestLogger.info("3. Access to a Category >> Select tab Schedule");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		scheduleAttendeeTab.clickTabSchedule();
		
		TestLogger.info("4. Click on schedule name >> Open schedule detail slide");
		scheduleAttendeeTab.searchScheduleName(scheduleName);
		scheduleAttendeeTab.clickFirstLinkSchedule();
		if(scheduleAttendeeTab.isTitleScheduleDetailDisplayed()){
			setStatusTest("pass", "Schedule detail slide is displayed");
		}else{
			setStatusTest("fail", "Schedule detail slide is NOT displayed");
		}
		scheduleAttendeeTab.clickIconXCloseScheduleDetail();
	}
	
	@Test (priority = 3, enabled = true)
	public void TT_20470_TT_20472_TT_20474_TT_20476_TT_20513(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
		
		TestLogger.info("3. Access to a Category >> Select tab Schedule");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		scheduleAttendeeTab.clickTabSchedule();
		
		TestLogger.info("4. Compare schedule name with corresponding assessment name");
		scheduleAttendeeTab.searchScheduleName(scheduleName);
//		scheduleAttendeeTab.searchScheduleName("ScheduleManually5775");
		if(scheduleAttendeeTab.getAssessmentName().equals(assessmentName)){
			setStatusTest("pass", "Assessment name is correct with schedule name \n TT20470 is PASSED");
		}else{
			setStatusTest("fail", "Assessment name is NOT correct with schedule name \n TT20470 is FAILED");
		}
		TestLogger.info("5. Click on Assessment name >> Open assessment detail");
		scheduleAttendeeTab.clickFirstLinkAssessment();
		if(scheduleAttendeeTab.isTitleAssessmentDetailDisplayed()){
			setStatusTest("pass", "Assessment detail is displayed \n TT20472 is PASSED");
		}else{
			setStatusTest("fail", "Assessment detail is NOT displayed \n TT20472 is FAILED");
		}
		scheduleAttendeeTab.clickIconXCloseAssessmentDetail();
		TestLogger.info("6. Validate format of Start Date");
		TestLogger.info("Expected: DD Mon YYYY");
		System.out.println(scheduleAttendeeTab.getStartDate());
		if(scheduleAttendeeTab.checkFormatStartDate(scheduleAttendeeTab.getStartDate())){
			setStatusTest("pass", "Start Date format is correct");
		}else{
			setStatusTest("fail", "Start Date format is NOT correct");
		}
		TestLogger.info("7. Click icon calendar start date");
		TestLogger.info("Expected: date picker is opened");
		scheduleAttendeeTab.clickIconCalendarStartDate();
		if(scheduleAttendeeTab.isTodayStartDateDisplayed()){
			setStatusTest("pass", "Date picker is displayed");
		}else{
			setStatusTest("fail", "Date picker is NOT displayed");
		}
		TestLogger.info("8. Filter start date = Today");
		TestLogger.info("Expected: show all schedules start date = today");
		scheduleAttendeeTab.clickTodayStartDate();
		if(scheduleAttendeeTab.isFirstLinkScheduleDisplayed()){
			setStatusTest("pass", "Filter by start date is correct \n TT20474 is PASSED");
		}else{
			setStatusTest("fail", "Filter by start date is NOT correct \n TT20474 is PASSED");
		}
		scheduleAttendeeTab.clickClearStartDate();
		TestLogger.info("9. Validate format of End Date");
		TestLogger.info("Expected: DD Mon YYYY");
		System.out.println(scheduleAttendeeTab.getEndDate());
		if(scheduleAttendeeTab.checkFormatEndDate(scheduleAttendeeTab.getEndDate())){
			setStatusTest("pass", "End Date format is correct");
		}else{
			setStatusTest("fail", "End Date format is NOT correct");
		}
		TestLogger.info("10. Filter end date");
		TestLogger.info("Expected: show all schedules end date = 31 Jan 2021");
		scheduleAttendeeTab.filterEndDate();
		if(scheduleAttendeeTab.isFirstLinkScheduleDisplayed()){
			setStatusTest("pass", "Filter by End date is correct \n TT20476 is PASSED");
		}else{
			setStatusTest("fail", "Filter by End date is NOT correct \n TT20476 is PASSED");
		}
		scheduleAttendeeTab.clickClearEndDate();
		TestLogger.info("11. Click icon calendar End date");
		TestLogger.info("Expected: date picker is opened");
		scheduleAttendeeTab.clickIconCalendarEndDate();
		if(scheduleAttendeeTab.isTodayEndDateDisplayed()){
			setStatusTest("pass", "Date picker is displayed");
		}else{
			setStatusTest("fail", "Date picker is NOT displayed");
		}
		scheduleAttendeeTab.clickTodayEndDate();
		scheduleAttendeeTab.clickClearEndDate();
		TestLogger.info("12. Click number of attendee column");
		TestLogger.info("Expected: number of attendee is a hyperlink");
		scheduleAttendeeTab.clickIconLinkFirstViewAttendeeList();
		if(scheduleAttendeeTab.isTitleAttendeeListDisplayed()){
			setStatusTest("pass", "Attendee list is displayed \n TT20513 is PASSED");
		}else{
			setStatusTest("fail", "Attendee list is NOT displayed \n TT20513 is FAILED");
		}
		scheduleAttendeeTab.clickCloseAttendeeList();
		scheduleAttendeeTab.filterAttendee();
		if(scheduleAttendeeTab.isFirstLinkAssessmentDisplayed()){
			setStatusTest("pass", "Filter attendee works correctly \n TT20477 is PASSED");
		}else{
			setStatusTest("fail", "Filter attendee NOT work correctly \n TT20477 is FAILED");
		}
	}
	
	@Test (priority = 4, enabled = true)
	public void TT_20514_TT20517_TT_20520(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
		
		TestLogger.info("3. Access to a Category >> Select tab Schedule");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		scheduleAttendeeTab.clickTabSchedule();
		
		TestLogger.info("4. Compare schedule status with corresponding schedule name");
		scheduleAttendeeTab.searchScheduleName(scheduleName);
//		scheduleAttendeeTab.searchScheduleName("ScheduleManually5584");
		TestLogger.info("Expected: schedule has status = In Progress");
		if(scheduleAttendeeTab.getFirstScheduleStatus().equals("In Progress")){
			setStatusTest("pass", "Status == In Progress");
		}else{
			setStatusTest("fail", "Status != In Progress");
		}
		TestLogger.info("5. Check list value in Status dropdown");
		TestLogger.info("Expected: 6 options");
		scheduleAttendeeTab.clickDrpStatus();
		if(scheduleAttendeeTab.isListStatusCorrect()){
			setStatusTest("pass", "6 options in filter status \n TT20514 is PASSED");
		}else{
			setStatusTest("fail", "NOT 6 options in filter status \n TT20514 is FAILED");
		}
		scheduleAttendeeTab.clickDrpStatus();
		TestLogger.info("6. Click on Edit icon");
		TestLogger.info("Expected: open Edit schedule slide");
		if(scheduleAttendeeTab.compareTooltipEditIcon()){
			setStatusTest("pass", "Tooltip Icon Edit is correct");
		}else{
			setStatusTest("fail", "Tooltip Icon Edit is NOT correct");
		}
		scheduleAttendeeTab.clickIconLinkFirstEdit();
		if(scheduleAttendeeTab.isBtnSaveEditScheduleDisplayed()){
			setStatusTest("pass", "Edit schedule form is opened \n TT20517 is PASSED");
		}else{
			setStatusTest("fail", "Edit schedule form is NOT opened \n TT20517 is FAILED");
		}
		scheduleAttendeeTab.clickBtnCancelEditSchedule();
		System.out.println("======================");
		TestLogger.info("7. Click on Assign Attendee icon");
		TestLogger.info("Expected: open Assign Attendee popup");
		if(scheduleAttendeeTab.compareTooltipAssignAttendeeIcon()){
			setStatusTest("pass", "Tooltip Icon Assign Attendee is correct");
		}else{
			setStatusTest("fail", "Tooltip Icon Assign Attendee is NOT correct");
		}
		scheduleAttendeeTab.clickIconLinkFirstAssignAttendee();
		if(scheduleAttendeeTab.isBtnFilterAssignDisplayed()){
			setStatusTest("pass", "Assign Attendee popup is opened \n TT20520 is PASSED");
		}else{
			setStatusTest("fail", "Assign Attendee popup is NOT opened \n TT20520 is FAILED");
		}
		scheduleAttendeeTab.clickBtnCancelPopupAssign();
	}
	
	@Test (priority = 5, enabled = true)
	public void TT_20516_TT_20563(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
		
		TestLogger.info("3. Access to a Category >> Select tab Schedule");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		scheduleAttendeeTab.clickTabSchedule();
		
		scheduleAttendeeTab.searchScheduleName(scheduleName);
//		scheduleAttendeeTab.searchScheduleName("ScheduleManually5584");
		TestLogger.info("4. Click on Cancel icon");
		TestLogger.info("Expected: open confirmation deletion popup");
		if(scheduleAttendeeTab.compareTooltipCancelIcon()){
			setStatusTest("pass", "Tooltip Icon Cancel is correct");
		}else{
			setStatusTest("fail", "Tooltip Icon Cancel is NOT correct");
		}
		scheduleAttendeeTab.clickIconLinkFirstCancel();
		if(scheduleAttendeeTab.compareConfirmationPopupContent()){
			setStatusTest("pass", "Content confirmation deletion popup is correct");
		}else{
			setStatusTest("fail", "Content confirmation deletion popup is NOT correct");
		}
		TestLogger.info("5. click NO on confirmation popup");
		scheduleAttendeeTab.clickBtnNOCancelSchedule();
		TestLogger.info("6. click YES on confirmation popup");
		TestLogger.info("Expected: schedule status change to Cancelled");
		scheduleAttendeeTab.clickIconLinkFirstCancel();
		scheduleAttendeeTab.clickBtnYESCancelSchedule();
		scheduleAttendeeTab.searchScheduleName(scheduleName);
//		scheduleAttendeeTab.searchScheduleName("ScheduleManually5584");
		if(scheduleAttendeeTab.getFirstScheduleStatus().equals("Cancelled")){
			setStatusTest("pass", "Schedule status is changed to Cancelled successfully \n TT20516 is PASSED");
		}else{
			setStatusTest("fail", "Schedule status is NOT changed to Cancelled \n TT20516 is FAILED");
		}
		TestLogger.info("Expected: can NOT see create new assessment button");
		if(!assessment.isBtnCreateAssessmentEnabled()){
			setStatusTest("pass", "Btn Create new assessment is hidden");
		}else{
			setStatusTest("fail", "Btn Create new assessment is NOT hidden");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT_20515(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Assessment");
		controlBoard.clickLblAssessment();
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Assessment");
		} else {
			setStatusTest("fail", "Not Access to Assessment");
		}
		
		TestLogger.info("3. Create test schedule");
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Test Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Test Schedule");
		}
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Test Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Test Schedule popup");
		}	
			
		createTestSchedule.fillScheduleName(scheduleName+1);
		createTestSchedule.clickIconStartDate();
		createTestSchedule.clickItemTodayStartDate();
		createTestSchedule.setScheduleEndDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Test schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Test schedule created successfully");
		}	
		createTestSchedule.clickBtnCloseSlideSchedule();
		TestLogger.info("4. Access to a Category >> Select tab Schedule");
		scheduleAttendeeTab.clickTabSchedule();
		scheduleAttendeeTab.searchScheduleName(scheduleName+1);
//		scheduleAttendeeTab.searchScheduleName("tuesday2");
		TestLogger.info("5. Check with schedule has status = In Progress");
		TestLogger.info("Expected: display 4 icons Cancel, Edit, Assign Attendee, View Attendee list");
		if(scheduleAttendeeTab.isIconLinkFirstCancelDisplayed()){
			setStatusTest("pass", "Icon Cancel is displayed");
		}else{
			setStatusTest("fail", "Icon Cancel is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstEditDisplayed()){
			setStatusTest("pass", "Icon Edit is displayed");
		}else{
			setStatusTest("fail", "Icon Edit is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstAssignAttendeeDisplayed()){
			setStatusTest("pass", "Icon Assign Attendee is displayed");
		}else{
			setStatusTest("fail", "Icon Assign Attendee is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstViewAttendeeListDisplayed()){
			setStatusTest("pass", "Icon View Attendee List is displayed");
		}else{
			setStatusTest("fail", "Icon View Attendee List is NOT displayed");
		}
		TestLogger.info("6. Check with schedule has status = Cancelled");
		TestLogger.info("Expected: only display view attendee list icon");
		scheduleAttendeeTab.clickIconLinkFirstCancel();
		scheduleAttendeeTab.clickBtnYESCancelSchedule();
		if(!scheduleAttendeeTab.isIconCancelEnable()){
			setStatusTest("pass", "Icon Cancel is NOT displayed");
		}else{
			setStatusTest("fail", "Icon Cancel is displayed");
		}
		if(!scheduleAttendeeTab.isIconEditEnable()){
			setStatusTest("pass", "Icon Edit is NOT displayed");
		}else{
			setStatusTest("fail", "Icon Edit is displayed");
		}
		if(!scheduleAttendeeTab.isIconAssignEnable()){
			setStatusTest("pass", "Icon Assign Attendee is NOT displayed");
		}else{
			setStatusTest("fail", "Icon Assign Attendee is displayed");
		}
		if(scheduleAttendeeTab.isIconAttendeeListEnable()){
			setStatusTest("pass", "Icon View Attendee List is displayed");
		}else{
			setStatusTest("fail", "Icon View Attendee List is NOT displayed");
		}
		
		TestLogger.info("7. Create schedule with status = scheduled");
		scheduleAttendeeTab.clickCloseAttendeeList();
		scheduleAttendeeTab.clickTabAssessment();
		assessment.clickIconScheduleFirstItem();
		
		if (assessmentSchedule.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass", "Access to Test Schedule");
		} else {
			setStatusTest("fail", "NOT Access to Test Schedule");
		}
		
		assessmentSchedule.clickBtnAdd();
		
		if (createTestSchedule.isLblCreateScheduleDisplayed() == true) {
			setStatusTest("pass", "Open Create Test Schedule popup");
		} else {
			setStatusTest("fail", "Not Open Create Test Schedule popup");
		}	
			
		createTestSchedule.fillScheduleName("Future2");
		createTestSchedule.setScheduleStartDate();
		createTestSchedule.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " +  "Test schedule created successfully");
		} else {
			setStatusTest("fail","NOT displays msg: " +  "Test schedule created successfully");
		}	
		createTestSchedule.clickBtnCloseSlideSchedule();
		scheduleAttendeeTab.clickTabSchedule();
		scheduleAttendeeTab.searchScheduleName("Future2");
		TestLogger.info("Expected: display 4 icons Cancel, Edit, Assign Attendee, View Attendee list");
		if(scheduleAttendeeTab.isIconLinkFirstCancelDisplayed()){
			setStatusTest("pass", "Icon Cancel is displayed");
		}else{
			setStatusTest("fail", "Icon Cancel is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstEditDisplayed()){
			setStatusTest("pass", "Icon Edit is displayed");
		}else{
			setStatusTest("fail", "Icon Edit is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstAssignAttendeeDisplayed()){
			setStatusTest("pass", "Icon Assign Attendee is displayed");
		}else{
			setStatusTest("fail", "Icon Assign Attendee is NOT displayed");
		}
		if(scheduleAttendeeTab.isIconLinkFirstViewAttendeeListDisplayed()){
			setStatusTest("pass", "Icon View Attendee List is displayed");
		}else{
			setStatusTest("fail", "Icon View Attendee List is NOT displayed");
		}
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
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
