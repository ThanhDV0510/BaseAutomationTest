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

public class Test_Functional_Assessment_AttendeeTab extends TestManager{
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
	public void TT20526_TT20527_TT20528_TT20529_TT20531_TT20532_TT20534_TT20535_TT20536(){
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
		
		TestLogger.info("4. Click on Attendee tab");
		scheduleAttendeeTab.clickTabAttendee();
		if(scheduleAttendeeTab.isTabAttendeeSelected()){
			setStatusTest("pass", "Attendee tab is selected");
		}else{
			setStatusTest("pass", "Attendee tab is NOT selected");
		}
		
		TestLogger.info("5. Click on Schedule name");
		TestLogger.info("Expected: show schedule detail slide");
		scheduleAttendeeTab.attendee_searchScheduleName(scheduleName);
//		scheduleAttendeeTab.attendee_searchScheduleName("ScheduleManually3537");
		scheduleAttendeeTab.clickAttendee_firstLinkScheduleName();
		if(scheduleAttendeeTab.isTitleScheduleDetailDisplayed()){
			setStatusTest("pass", "Schedule detail form is opened \n TT20526 is PASSED");
		}else{
			setStatusTest("fail", "Schedule detail form is NOT opened \n TT20526 is FAILED");
		}
		scheduleAttendeeTab.clickIconXCloseScheduleDetail();
		TestLogger.info("6. Verify full name");
		if(scheduleAttendeeTab.compareFullName()){
			setStatusTest("pass", "Full name attendee is correct \n TT20527 is PASSED");
		}else{
			setStatusTest("fail", "Full name attendee is NOT correct \n TT20527 is FAILED");
		}
		scheduleAttendeeTab.clickAttendee_firstLinkAssessmentName();
		TestLogger.info("7. Click assessment name => Expected: open assessment detail slide");
		if(scheduleAttendeeTab.isTitleAssessmentDetailDisplayed()){
			setStatusTest("pass", "Assessment detail is opened \n TT20528 is PASSED");
		}else{
			setStatusTest("fail", "Assessment detail is NOT opened \n TT20528 is FAILED");
		}
		scheduleAttendeeTab.clickIconXCloseAssessmentDetail();
		TestLogger.info("8. Verify assessment name");
		if(scheduleAttendeeTab.compare_attendee_assessmentName(assessmentName)){
			setStatusTest("pass", "Assessment name is correct \n TT20529 is PASSED");
		}else{
			setStatusTest("fail", "Assessment name is NOT correct \n TT20529 is FAILED");
		}
		
		TestLogger.info("9. Click on Assessment tab from Attendee tab");
		scheduleAttendeeTab.clickTabAssessment();
		if(scheduleAttendeeTab.isTabAssessmentSelected()){
			setStatusTest("pass", "Assessment tab is selected \n TT20531 is PASSED");
		}else{
			setStatusTest("pass", "Assessment tab is NOT selected \n TT20531 is FAILED");
		}
		TestLogger.info("10. Click on Schedule tab from Attendee tab");
		scheduleAttendeeTab.clickTabAttendee();
		if(scheduleAttendeeTab.isTabAttendeeSelected()){
			setStatusTest("pass", "Back to Attendee tab successfully");
		}else{
			setStatusTest("pass", "Back to Attendee tab NOT successfully");
		}
		scheduleAttendeeTab.clickTabSchedule();
		if(scheduleAttendeeTab.isTabScheduleSelected()){
			setStatusTest("pass", "Schedule tab is selected \n TT20532 is PASSED");
		}else{
			setStatusTest("pass", "Schedule tab is NOT selected \n TT20532 is FAILED");
		}
		scheduleAttendeeTab.clickTabAttendee();
		if(scheduleAttendeeTab.isTabAttendeeSelected()){
			setStatusTest("pass", "Back to Attendee tab successfully");
		}else{
			setStatusTest("pass", "Back to Attendee tab NOT successfully");
		}
		scheduleAttendeeTab.attendee_searchScheduleName("ScheduleManually3537");
		TestLogger.info("11. Verify email attendee");
		if(scheduleAttendeeTab.compare_attendee_Email()){
			setStatusTest("pass", "Email attendee is correct \n TT20534 is PASSED");
		}else{
			setStatusTest("fail", "Email name attendee is NOT correct \n TT20534 is FAILED");
		}
		TestLogger.info("12. Verify position attendee");
		if(scheduleAttendeeTab.compare_attendee_Position()){
			setStatusTest("pass", "Position attendee is correct \n TT20535 is PASSED");
		}else{
			setStatusTest("fail", "Position name attendee is NOT correct \n TT20535 is FAILED");
		}
		TestLogger.info("13. Verify status of assessment");
		if(scheduleAttendeeTab.compare_attendee_Status()){
			setStatusTest("pass", "Status of assessment is correct");
		}else{
			setStatusTest("fail", "Status of assessment is NOT correct");
		}
		TestLogger.info("14. Expected: 12 options in dropdown status filter");
		scheduleAttendeeTab.click_attendeeDrpStatus();
		if(scheduleAttendeeTab.attendee_isListStatusCorrect()){
			setStatusTest("pass", "12 options in filter status \n TT20536 is PASSED");
		}else{
			setStatusTest("fail", "NOT 12 options in filter status \n TT20536 is FAILED");
		}
		scheduleAttendeeTab.click_attendeeDrpStatus();
	}
	
	@Test (priority = 2, enabled = true)
	public void TT20538_TT20567(){
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
		
		TestLogger.info("3. Access to a Category");
		
		assessment.fillSearchCategory(DataManager.FunctionSet);
		assessment.clickFirstCategory();
		
		if (assessment.isLblAssessmentDisplayed() == true) {
			setStatusTest("pass","Open Test screen");
		} else {
			setStatusTest("fail","NOT Open Test screen");
		}
		TestLogger.info("4. Click on Attendee tab");
		scheduleAttendeeTab.clickTabAttendee();
		if(scheduleAttendeeTab.isTabAttendeeSelected()){
			setStatusTest("pass", "Attendee tab is selected");
		}else{
			setStatusTest("pass", "Attendee tab is NOT selected");
		}
		TestLogger.info("5. Filter with status = Completed");
		TestLogger.info("Expected: show icon View Result and open View Result page");
//		scheduleAttendeeTab.attendee_clickBtnClearFilterScheduleName();
		scheduleAttendeeTab.attendee_filterStatus("Completed");
		if(scheduleAttendeeTab.attendee_isFirstAssessmentDisplayed()){
			if(scheduleAttendeeTab.attendee_isIconViewResultDisplay()){
				if(scheduleAttendeeTab.isStatusViewResultDisplayed()){
					setStatusTest("pass", "Icon view result is displayed and works");
					scheduleAttendeeTab.clickIconCloseViewResult();
				}else{
					setStatusTest("fail", "Icon view result is NOT displayed or NOT work");
				}
			}else{
				setStatusTest("fail", "Icon view result is NOT displayed \n TT20538 is FAILED");
			}
		}else{
			System.out.println("No record for status = COMPLETED. SKIPPED TT20538");
		}
		scheduleAttendeeTab.attendee_clickBtnClearFilterStatus();
		TestLogger.info("6. Filter with status = Schedule");
		TestLogger.info("Expected: NOT show icon View Result");
		scheduleAttendeeTab.attendee_filterStatus("Scheduled");
		if(!scheduleAttendeeTab.attendee_isIconViewResultDisplay()){
			setStatusTest("pass", "Icon view result is NOT displayed with Scheduled status \n TT20538 is PASSED");
		}else{
			setStatusTest("pass", "Icon view result is displayed with Scheduled status \n TT20538 is FAILED");
		}
		scheduleAttendeeTab.attendee_clickBtnClearFilterStatus();
		TestLogger.info("7. Check display of Create Assessment Button");
		TestLogger.info("Expected: Create assessment button is hidden");
		if(!scheduleAttendeeTab.attendee_isBtnCreateAssessmentDisplay()){
			setStatusTest("pass", "Btn Create Assessment is NOT displayed \n TT20567 is PASSED");
		}else{
			setStatusTest("fail", "Btn Create Assessment is displayed \n TT20567 is FAILED");
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
