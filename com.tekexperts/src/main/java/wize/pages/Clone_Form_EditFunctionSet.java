package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Clone_Form_EditFunctionSet extends WebActions {

	public Clone_Form_EditFunctionSet(WebDriver driver) {
		super(driver);
     }

	By lblEditFunctionSet = By.id("label-detail-function-set");
	By txtDescription = By.id("Description");
	
	public boolean isLblEditFunctionSetDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditFunctionSet).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillTxtDescription(String Description)
	{
		waitFluentWait(txtDescription);
		goTextOnNoEnter(txtDescription, Description);
	}

	//Tab
	By tabDashBoard = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[1]");
	By tabLibrary = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[2]");
	By tabAssessment = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[3]");
	By tabTalentManagement = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[4]");
	By tabControlBoard = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[5]");
	By tabMySpace = By.xpath("(//form[@id='frmDetailFunctionSet']//span[2])[6]");
	
	public void clickTabDashBoard()
	{
		waitFluentWait(tabDashBoard);
		click(tabDashBoard);
	}
	
	public void clickTabAssessment()
	{
		waitFluentWait(tabAssessment);
		click(tabAssessment);
	}
	
	public void clickTabLibrary()
	{
		waitFluentWait(tabLibrary);
		click(tabLibrary);
	}
	
	public void clickTabTalentManagement()
	{
		waitFluentWait(tabTalentManagement);
		click(tabTalentManagement);
	}
	
	public void clickTabControlBoard()
	{
		waitFluentWait(tabControlBoard);
		click(tabControlBoard);
	}
	
	public void clickTabMySpace()
	{
		waitFluentWait(tabMySpace);
		click(tabMySpace);
	}
	
	//Check Box
	By cboxFullPermission = By.id("fullPermission");
	By cboxViewOnly = By.id("viewOnly");
	By cboxCustomization = By.id("customization");
	
	public void clickCboxFullPermission()
	{
		waitFluentWait(cboxFullPermission);
		click(cboxFullPermission);
	}
	
	public void clickCboxViewOnly()
	{
		waitFluentWait(cboxViewOnly);
		click(cboxViewOnly);
	}
	
	public void clickCboxCustomization()
	{
		waitFluentWait(cboxCustomization);
		click(cboxCustomization);
	}
	
	//Sub Check Box
	By cboxSubFullPermission = By.id("subFullPermission");
	By cboxSubViewOnly = By.id("subViewOnly");
	By cboxSubCustomization = By.id("subCustomization");
	By txtSearchPermission = By.xpath("(//div[@id='permission-treelist']//input)[1]");
	
	public void fillSearchPermission(String SearchPermission)
	{
		waitFluentWait(txtSearchPermission);
		ClickElementAndType(txtSearchPermission, SearchPermission);
	}
	
	public void clickCboxSubFullPermission()
	{
		waitFluentWait(cboxSubFullPermission);
		click(cboxSubFullPermission);
	}
	
	public void clickCboxSubViewOnly()
	{
		waitFluentWait(cboxSubViewOnly);
		click(cboxSubViewOnly);
	}
	
	public void clickCboxSubCustomization()
	{
		waitFluentWait(cboxSubCustomization);
		click(cboxSubCustomization);	
	}
	
	//Dashboard >> My Skill Gap, Front-line Manager, Skill Assessment
	By subTabMySkillGap = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[1]");
	By subTabFrontLineManager = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[2]");
	By subTabSkillAssessment = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[3]");
	
	public void clickSubTabMySkillGap()
	{
		waitFluentWait(subTabMySkillGap);
		click(subTabMySkillGap);
	}
	public void clickSubTabFrontLineManager()
	{
		waitFluentWait(subTabFrontLineManager);
		click(subTabFrontLineManager);
	}
	public void clickSubTabSkillAssessment()
	{
		waitFluentWait(subTabSkillAssessment);
		click(subTabSkillAssessment);
	}
	By btnViewMySkillGap = By.xpath("//input[@id='IsActive-3']");
	By btnViewFrontlineManager = By.xpath("//input[@id='IsActive-5']");
	By btnViewSkillAssessment = By.xpath("//input[@id='IsActive-7']");

	By viewMySkillGap = By.xpath("//label[@for='IsActive-3']");
	By viewFrontlineManager = By.xpath("//label[@for='IsActive-5']");
	By viewSkillAssessment = By.xpath("//label[@for='IsActive-7']");
	
	public void clickOFFBtnViewMySkillGap()
	{
		String result = driver.findElement(btnViewMySkillGap).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMySkillGap);
		 }
	}
	
	
	public void clickONBtnViewMySkillGap()
	{
		String result = driver.findElement(btnViewMySkillGap).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMySkillGap);
		 }
	}
	
	public void clickOFFBtnViewFrontlineManager()
	{
		String result = driver.findElement(btnViewFrontlineManager).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewFrontlineManager);
		 }
	}
	
	
	public void clickONBtnViewFrontlineManager()
	{
		String result = driver.findElement(btnViewFrontlineManager).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewFrontlineManager);
		 }
	}
	
	public void clickOFFBtnViewSkillAssessment()
	{
		String result = driver.findElement(btnViewSkillAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSkillAssessment);
		 }
	}
	
	
	public void clickONBtnViewSkillAssessment()
	{
		String result = driver.findElement(btnViewSkillAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSkillAssessment);
		 }
	}
	
	// Library >> Learning Library
	By subTabLearningLibrary = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[1]");
	By subTabMyLearning = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[2]");
	
	public void clickSubTabLearningLibrary()
	{
		waitFluentWait(subTabLearningLibrary);
		click(subTabLearningLibrary);
	}
	
	public void clickSubTabMyLearning()
	{
		waitFluentWait(subTabMyLearning);
		click(subTabMyLearning);
	}
	
	By btnViewLearningLibrary = By.xpath("//input[@id='IsActive-199']");
	By btnViewMyLearning = By.xpath("//input[@id='IsActive-201']");
	By viewLearningLibrary = By.xpath("//label[@for='IsActive-199']");
	By viewMyLearning = By.xpath("//label[@for='IsActive-201']");
	
	public void clickOFFbtnViewLearningLibrary()
	{
		String result = driver.findElement(btnViewLearningLibrary).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewLearningLibrary);
		 }
	}
	
	
	public void clickONbtnViewLearningLibrary()
	{
		String result = driver.findElement(btnViewLearningLibrary).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewLearningLibrary);
		 }
	}
	
	public void clickOFFbtnViewMyLearning()
	{
		String result = driver.findElement(btnViewMyLearning).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyLearning);
		 }
	}
	
	
	public void clickONbtnViewMyLearning()
	{
		String result = driver.findElement(btnViewMyLearning).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyLearning);
		 }
	}
	
	//Control Board - Learning & Development >> QuestionPool
	By subTabSystem = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[1]");
	By subTabLearningDevelopment = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[3]");
	
	public void clickSubTabLearningDevelopment()
	{
		waitFluentWait(subTabLearningDevelopment);
		click(subTabLearningDevelopment);
	}
	
	public void clickSubTabSystem()
	{
		waitFluentWait(subTabSystem);
		click(subTabSystem);
	}
	
	By btnRadioQuestionpool = By.xpath("//input[@id='IsActive-158']");
	By btnViewQuestionList = By.xpath("//input[@id='IsActive-159']");
	By btnManageQuestionCategory = By.xpath("//input[@id='IsActive-160']");
	By btnCreateQuestion = By.xpath("//input[@id='IsActive-161']");
	By btnViewQuestionContent = By.xpath("//input[@id='IsActive-162']");
	By btnDeleteQuestion = By.xpath("//input[@id='IsActive-163']");
	By btnRejectQuestion = By.xpath("//input[@id='IsActive-164']");
	By btnMoveQuestion = By.xpath("//input[@id='IsActive-165']");
	By btnEditQuestion = By.xpath("//input[@id='IsActive-167']");
	
	By radioQuestionPool = By.xpath("//label[@for='IsActive-158']");
	By viewQuestionList = By.xpath("//label[@for='IsActive-159']");
	By manageQuestionCategory = By.xpath("//label[@for='IsActive-160']");
	By createQuestion = By.xpath("//label[@for='IsActive-161']");
	By viewQuestionContent = By.xpath("//label[@for='IsActive-162']");
	By deleteQuestion = By.xpath("//label[@for='IsActive-163']");
	By rejectQuestion = By.xpath("//label[@for='IsActive-164']");
	By moveQuestion = By.xpath("//label[@for='IsActive-165']");
	By editQuestion = By.xpath("//label[@for='IsActive-167']");
	
	public void clickOFFbtnRadioQuestionPool()
	{
		String result = driver.findElement(btnRadioQuestionpool).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioQuestionPool);
		 }
	}
	
	
	public void clickONbtnRadioQuestionPool()
	{
		String result = driver.findElement(btnRadioQuestionpool).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioQuestionPool);
		 }
	}
	
	public void clickOFFbtnViewQuestionList()
	{
		String result = driver.findElement(btnViewQuestionList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewQuestionList);
		 }
	}
	
	
	public void clickONbtnViewQuestionList()
	{
		String result = driver.findElement(btnViewQuestionList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewQuestionList);
		 }
	}
	
	public void clickOFFbtnManageQuestionCategory()
	{
		String result = driver.findElement(btnManageQuestionCategory).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageQuestionCategory);
		 }
	}
	
	
	public void clickONbtnManageQuestionCategory()
	{
		String result = driver.findElement(btnManageQuestionCategory).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageQuestionCategory);
		 }
	}
	
	

	public void clickOFFbtnCreateQuestion()
	{
		String result = driver.findElement(btnCreateQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createQuestion);
		 }
	}
	
	
	public void clickONbtnCreateQuestion()
	{
		String result = driver.findElement(btnCreateQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(createQuestion);
		 }
	}
	

	public void clickOFFbtnViewQuestionContent()
	{
		String result = driver.findElement(btnViewQuestionContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewQuestionContent);
		 }
	}
	
	public void clickONbtnViewQuestionContent()
	{
		String result = driver.findElement(btnViewQuestionContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewQuestionContent);
		 }
	}
	
	public void clickOFFbtnDeleteQuestion()
	{
		String result = driver.findElement(btnDeleteQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteQuestion);
		 }
	}
	
	public void clickONbtnDeleteQuestion()
	{
		String result = driver.findElement(btnDeleteQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteQuestion);
		 }
	}
	

	public void clickOFFbtnRejectQuestion()
	{
		String result = driver.findElement(btnRejectQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectQuestion);
		 }
	}
	
	public void clickONbtnRejectQuestion()
	{
		String result = driver.findElement(btnRejectQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectQuestion);
		 }
	}
	
	public void clickOFFbtnMoveQuestion()
	{
		String result = driver.findElement(btnMoveQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(moveQuestion);
		 }
	}
	
	public void clickONbtnMoveQuestion()
	{
		String result = driver.findElement(btnMoveQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(moveQuestion);
		 }
	}
	

	public void clickOFFbtnEditQuestion()
	{
		String result = driver.findElement(btnEditQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editQuestion);
		 }
	}
	
	public void clickONbtnEditQuestion()
	{
		String result = driver.findElement(btnEditQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(editQuestion);
		 }
	}
	
	//Assessment >> Assessment - Settings >> General settings
	By btnRadioAssessment = By.xpath("//input[@id='IsActive-168']");
	By btnRadioAssessmentGeneralSettings = By.xpath("//input[@id='IsActive-169']");
	By btnViewAssessmentList = By.xpath("//input[@id='IsActive-170']");
	By btnManageAssessmentCategory = By.xpath("//input[@id='IsActive-171']");
	By btnCreateAssessment = By.xpath("//input[@id='IsActive-172']");
	By btnEditAssessmentSettings = By.xpath("//input[@id='IsActive-173']");
	By btnDeleteAssessment = By.xpath("//input[@id='IsActive-174']");
	
	By radioAssessment = By.xpath("//label[@for='IsActive-168']");
	By radioAssessmentGeneralSettings = By.xpath("//label[@for='IsActive-169']");
	By viewAssessmentList = By.xpath("//label[@for='IsActive-170']");
	By manageAssessmentCategory = By.xpath("//label[@for='IsActive-171']");
	By createAssessment = By.xpath("//label[@for='IsActive-172']");
	By editAssessmentSettings = By.xpath("//label[@for='IsActive-173']");
	By deleteAssessment = By.xpath("//label[@for='IsActive-174']");
	
	public void clickOFFbtnRadioAssessment()
	{
		String result = driver.findElement(btnRadioAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioAssessment);
		 }
	}
	
	public void clickONbtnRadioAssessment()
	{
		String result = driver.findElement(btnRadioAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioAssessment);
		 }
	}
	
	public void clickOFFbtnRadioAssessmentGeneralSettings()
	{
		String result = driver.findElement(btnRadioAssessmentGeneralSettings).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioAssessmentGeneralSettings);
		 }
	}
	
	public void clickONbtnRadioAssessmentGeneralSettings()
	{
		String result = driver.findElement(btnRadioAssessmentGeneralSettings).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioAssessmentGeneralSettings);
		 }
	}

	public void clickOFFbtnViewAssessmentList()
	{
		String result = driver.findElement(btnViewAssessmentList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAssessmentList);
		 }
	}
	
	public void clickONbtnViewAssessmentList()
	{
		String result = driver.findElement(btnViewAssessmentList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAssessmentList);
		 }
	}
	
	

	public void clickOFFbtnManageAssessmentCategory()
	{
		String result = driver.findElement(btnManageAssessmentCategory).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageAssessmentCategory);
		 }
	}
	
	public void clickONbtnManageAssessmentCategory()
	{
		String result = driver.findElement(btnManageAssessmentCategory).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageAssessmentCategory);
		 }
	}
	
	
	
	public void clickOFFbtnCreateAssessment()
	{
		String result = driver.findElement(btnCreateAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createAssessment);
		 }
	}
	
	public void clickONbtnCreateAssessment()
	{
		String result = driver.findElement(btnCreateAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(createAssessment);
		 }
	}
	

	
	public void clickOFFBtnEditAssessmentSettings()
	{
		String result = driver.findElement(btnEditAssessmentSettings).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editAssessmentSettings);
		 }
	}
	
	public void clickONBtnEditAssessmentSettings()
	{
		String result = driver.findElement(btnEditAssessmentSettings).getAttribute("checked");
		 if (result==null)
		 {
			 click(editAssessmentSettings);
		 }
	}
	
	
	public void clickOFFBbtnDeleteAssessment()
	{
		String result = driver.findElement(btnDeleteAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteAssessment);
		 }
	}
	
	public void clickONbtnDeleteAssessment()
	{
		String result = driver.findElement(btnDeleteAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteAssessment);
		 }
	}
	
	//Assessment >> Assessment - Settings >> Assessment schedule
	By btnRadioAssessmentSchedule = By.xpath("//input[@id='IsActive-175']");
	By btnViewSchedulelist = By.xpath("//input[@id='IsActive-176']");
	By btnCreateTestSchedule  = By.xpath("//input[@id='IsActive-177']");
	By btnEditTestSchedule = By.xpath("//input[@id='IsActive-178']");
	By btnCancelTestSchedule  = By.xpath("//input[@id='IsActive-179']");
	By btnAssignAttendee = By.xpath("//input[@id='IsActive-180']");
	By btnRemoveAttendee = By.xpath("//input[@id='IsActive-181']");
	By btnViewTestReportTestSchedule = By.xpath("//input[@id='IsActive-182']");
	By btnViewAttendeeListTestSchedule = By.xpath("//input[@id='IsActive-183']");
	
	By radioAssessmentSchedule = By.xpath("//label[@for='IsActive-175']");
	By viewSchedulelist = By.xpath("//label[@for'=IsActive-176']");
	By createTestSchedule  = By.xpath("//label[@for='IsActive-177']");
	By editTestSchedule = By.xpath("//label[@for='IsActive-178']");
	By cancelTestSchedule  = By.xpath("//label[@for='IsActive-179']");
	By assignAttendee = By.xpath("//label[@for='IsActive-180']");
	By removeAttendee = By.xpath("//label[@for='IsActive-181']");
	By viewTestReportTestSchedule = By.xpath("//label[@for='IsActive-182']");
	By viewAttendeeListTestSchedule = By.xpath("//label[@for='IsActive-183']");
	
	
	public void clickOFFbtnRadioAssessmentSchedule()
	{
		String result = driver.findElement(btnRadioAssessmentSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioAssessmentSchedule);
		 }
	}
	
	public void clickONbtnRadioAssessmentSchedule()
	{
		String result = driver.findElement(btnRadioAssessmentSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioAssessmentSchedule);
		 }
	}

	public void clickOFFbtnViewSchedulelist()
	{
		String result = driver.findElement(btnViewSchedulelist).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSchedulelist);
		 }
	}
	
	public void clickONbtnViewSchedulelist()
	{
		String result = driver.findElement(btnViewSchedulelist).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSchedulelist);
		 }
	}
	
	
	public void clickOFFbtnCreateTestSchedule()
	{
		String result = driver.findElement(btnCreateTestSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createTestSchedule);
		 }
	}
	
	public void clickONbtnCreateTestSchedule()
	{
		String result = driver.findElement(btnCreateTestSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(createTestSchedule);
		 }
	}
	
	
	public void clickOFFbtnEditTestSchedule()
	{
		String result = driver.findElement(btnEditTestSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editTestSchedule);
		 }
	}
	
	public void clickONbtnEditTestSchedule()
	{
		String result = driver.findElement(btnEditTestSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(editTestSchedule);
		 }
	}
	
	
	public void clickOFFbtnCancelTestSchedule()
	{
		String result = driver.findElement(btnCancelTestSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(cancelTestSchedule);
		 }
	}
	
	public void clickONbtnCancelTestSchedule()
	{
		String result = driver.findElement(btnCancelTestSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(cancelTestSchedule);
		 }
	}
	
	
	public void clickOFFbtnAssignAttendee()
	{
		String result = driver.findElement(btnAssignAttendee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(assignAttendee);
		 }
	}
	
	public void clickONbtnAssignAttendee()
	{
		String result = driver.findElement(btnAssignAttendee).getAttribute("checked");
		 if (result==null)
		 {
			 click(assignAttendee);
		 }
	}
	
	
	
	public void clickOFFbtnRemoveAttendee()
	{
		String result = driver.findElement(btnRemoveAttendee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(removeAttendee);
		 }
	}
	
	public void clickONbtnRemoveAttendee()
	{
		String result = driver.findElement(btnRemoveAttendee).getAttribute("checked");
		 if (result==null)
		 {
			 click(removeAttendee);
		 }
	}
	
	
	public void clickOFFbtnViewTestReportTestSchedule()
	{
		String result = driver.findElement(btnViewTestReportTestSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewTestReportTestSchedule);
		 }
	}
	
	public void clickONbtnViewTestReportTestSchedule()
	{
		String result = driver.findElement(btnViewTestReportTestSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewTestReportTestSchedule);
		 }
	}
	
	
	public void clickOFFBtnViewAttendeeListTestSchedule()
	{
		String result = driver.findElement(btnViewAttendeeListTestSchedule).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAttendeeListTestSchedule);
		 }
	}
	
	public void clickONBtnViewAttendeeListTestSchedule()
	{
		String result = driver.findElement(btnViewAttendeeListTestSchedule).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAttendeeListTestSchedule);
		 }
	}
	
	
	
	//Assessment >> Assessment - Settings >> Attendee list 
	By btnRadioAttendeelist  = By.xpath("//input[@id='IsActive-184']");
	By btViewAttendeeList = By.xpath("//input[@id='IsActive-185']");
	By btnViewAssessmentReportAttendeeList  = By.xpath("//input[@id='IsActive-186']");
	
	By radioAttendeelist  = By.xpath("//label[@for='IsActive-184']");
	By viewAttendeeList = By.xpath("//label[@for='IsActive-185']");
	By viewAssessmentReportAttendeeList  = By.xpath("//label[@for='IsActive-186']");
	
	public void clickOFFbtnRadioAttendeelist()
	{
		String result = driver.findElement(btnRadioAttendeelist).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioAttendeelist);
		 }
	}
	
	public void clickONbtnRadioAttendeelist()
	{
		String result = driver.findElement(btnRadioAttendeelist).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioAttendeelist);
		 }
	}
	
	public void clickOFFbtViewAttendeeList()
	{
		String result = driver.findElement(btViewAttendeeList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAttendeeList);
		 }
	}
	
	public void clickONbtViewAttendeeList()
	{
		String result = driver.findElement(btViewAttendeeList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAttendeeList);
		 }
	}
	
	
	public void clickOFFbtnViewAssessmentReportAttendeeList()
	{
		String result = driver.findElement(btnViewAssessmentReportAttendeeList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAssessmentReportAttendeeList);
		 }
	}
	
	public void clickONbtnViewAssessmentReportAttendeeList()
	{
		String result = driver.findElement(btnViewAssessmentReportAttendeeList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAssessmentReportAttendeeList);
		 }
	}
	
	//Assessment >> Assessment Library
	By subTabAssessmentLibrary = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[1]");
	By btnViewAssessmentLibrary = By.xpath("//input[@id='IsActive-10']");
	By viewAssessmentLibrary = By.xpath("//label[@for='IsActive-10']");
	
	public void clickSubTabAssessmentLibrary()
	{
		waitFluentWait(subTabAssessmentLibrary);
		click(subTabAssessmentLibrary);
	}

	public void clickOFFbtnViewTestLibrary()
	{
		String result = driver.findElement(btnViewAssessmentLibrary).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAssessmentLibrary);
		 }
	}
	
	public void clickONbtnViewTestLibrary()
	{
		String result = driver.findElement(btnViewAssessmentLibrary).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAssessmentLibrary);
		 }
	}
		
	//Assessment >> My Assessment
	By subTabMyAssessment = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[2]");
	By btnViewMyTest = By.xpath("//input[@id='IsActive-35']");
	By viewMyTest = By.xpath("//label[@for='IsActive-35']");
	
	public void clickSubTabMyAssessment()
	{
		waitFluentWait(subTabMyAssessment);
		click(subTabMyAssessment);
	}
	
	public void clickOFFbtnViewMyTest()
	{
		String result = driver.findElement(btnViewMyTest).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyTest);
		 }
	}
	
	public void clickONbtnViewMyTest()
	{
		String result = driver.findElement(btnViewMyTest).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyTest);
		 }
	}
	

	//Control Board - Talent >> Job
	By btnRadioJob = By.xpath("//input[@id='IsActive-88']");
	By btnViewJobList = By.xpath("//input[@id='IsActive-89']");
	By btnViewJobdetail  = By.xpath("//input[@id='IsActive-90']");
	By btnCreateJob  = By.xpath("//input[@id='IsActive-91']");
	By btnEditJob = By.xpath("//input[@id='IsActive-92']");
	By btnDeleteJob  = By.xpath("//input[@id='IsActive-93']");
	
	By radioJob = By.xpath("//label[@for='IsActive-88']");
	By viewJobList = By.xpath("//label[@for='IsActive-89']");
	By viewJobdetail  = By.xpath("//label[@for='IsActive-90']");
	By createJob  = By.xpath("//label[@for='IsActive-91']");
	By editJob = By.xpath("//label[@for='IsActive-92']");
	By deleteJob  = By.xpath("//label[@for='IsActive-93']");
	
	public void clickOFFbtnRadioJob()
	{
		String result = driver.findElement(btnRadioJob).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioJob);
		 }
	}
	
	public void clickONbtnRadioJob()
	{
		String result = driver.findElement(btnRadioJob).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioJob);
		 }
	}
	
	public void clickOFFbtnViewJobList()
	{
		String result = driver.findElement(btnViewJobList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewJobList);
		 }
	}
	
	public void clickONbtnViewJobList()
	{
		String result = driver.findElement(btnViewJobList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewJobList);
		 }
	}
	
	public void clickOFFbtnViewJobdetail()
	{
		String result = driver.findElement(btnViewJobdetail).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewJobdetail);
		 }
	}
	
	public void clickONbtnViewJobdetail()
	{
		String result = driver.findElement(btnViewJobdetail).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewJobdetail);
		 }
	}

	public void clickOFFbtnCreateJob()
	{
		String result = driver.findElement(btnCreateJob).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createJob);
		 }
	}
	
	public void clickONbtnCreateJob()
	{
		String result = driver.findElement(btnCreateJob).getAttribute("checked");
		 if (result==null)
		 {
			 click(createJob);
		 }
	}
	
	
	public void clickOFFbtnEditJob()
	{
		String result = driver.findElement(btnEditJob).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editJob);
		 }
	}
	
	public void clickONbtnEditJob()
	{
		String result = driver.findElement(btnEditJob).getAttribute("checked");
		 if (result==null)
		 {
			 click(editJob);
		 }
	}
	
	
	public void clickOFFbtnDeleteJob()
	{
		String result = driver.findElement(btnDeleteJob).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteJob);
		 }
	}
	
	public void clickONbtnDeleteJob()
	{
		String result = driver.findElement(btnDeleteJob).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteJob);
		 }
	}
	
	//Talent Management >> Talent >> Job Level
	By btnRadioJobLevel = By.xpath("//input[@id='IsActive-94']");
	By btnViewJobLevelList = By.xpath("//input[@id='IsActive-95']");
	By btnViewJobLevelDetails  = By.xpath("//input[@id='IsActive-96']");
	By btnCreateJobLevel  = By.xpath("//input[@id='IsActive-97']");
	By btnEditJobLevel = By.xpath("//input[@id='IsActive-98']");
	By btnDeleteJobLevel = By.xpath("//input[@id='IsActive-99']");
	
	By radioJobLevel = By.xpath("//label[@for='IsActive-94']");
	By viewJobLevelList = By.xpath("//label[@for='IsActive-95']");
	By viewJobLevelDetails  = By.xpath("//label[@for='IsActive-96']");
	By createJobLevel  = By.xpath("//label[@for='IsActive-97']");
	By editJobLevel = By.xpath("//label[@for='IsActive-98']");
	By deleteJobLevel = By.xpath("//label[@for='IsActive-99']");
	
	public void clickOFFbtnRadioJobLevel()
	{
		String result = driver.findElement(btnRadioJobLevel).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioJobLevel);
		 }
	}
	
	public void clickONbtnRadioJobLevel()
	{
		String result = driver.findElement(btnRadioJobLevel).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioJobLevel);
		 }
	}

	public void clickOFFbtnViewJobLevelList()
	{
		String result = driver.findElement(btnViewJobLevelList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewJobLevelList);
		 }
	}
	
	public void clickONbtnViewJobLevelList()
	{
		String result = driver.findElement(btnViewJobLevelList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewJobLevelList);
		 }
	}
	
	
	public void clickOFFbtnViewJobLevelDetails()
	{
		String result = driver.findElement(btnViewJobLevelDetails).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewJobLevelDetails);
		 }
	}
	
	public void clickONbtnViewJobLevelDetails()
	{
		String result = driver.findElement(btnViewJobLevelDetails).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewJobLevelDetails);
		 }
	}
	
	
	public void clickOFFbtnCreateJobLevel()
	{
		String result = driver.findElement(btnCreateJobLevel).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createJobLevel);
		 }
	}
	
	public void clickONbtnCreateJobLevel()
	{
		String result = driver.findElement(btnCreateJobLevel).getAttribute("checked");
		 if (result==null)
		 {
			 click(createJobLevel);
		 }
	}
	
	public void clickOFFbtnEditJobLevel()
	{
		String result = driver.findElement(btnEditJobLevel).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editJobLevel);
		 }
	}
	
	public void clickONbtnEditJobLevel()
	{
		String result = driver.findElement(btnEditJobLevel).getAttribute("checked");
		 if (result==null)
		 {
			 click(editJobLevel);
		 }
	}
	
	
	public void clickOFFbtnDeleteJobLevel()
	{
		String result = driver.findElement(btnDeleteJobLevel).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteJobLevel);
		 }
	}
	
	public void clickONbtnDeleteJobLevel()
	{
		String result = driver.findElement(btnDeleteJobLevel).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteJobLevel);
		 }
	}
	
	//Talent Management >> Talent > Position
	By btnRadioPositionList = By.xpath("//input[@id='IsActive-100']");
	By btnViewPositionList = By.xpath("//input[@id='IsActive-101']");
	By btnViewPositionDetails  = By.xpath("//input[@id='IsActive-102']");
	By btnCreatePositions  = By.xpath("//input[@id='IsActive-103']");
	By btnEditPositions = By.xpath("//input[@id='IsActive-104']");
	By btnDeletePositions = By.xpath("//input[@id='IsActive-105']");
	
	By radioPositionList = By.xpath("//label[@for='IsActive-100']");
	By viewPositionList = By.xpath("//label[@for='IsActive-101']");
	By viewPositionDetails  = By.xpath("//label[@for='IsActive-102']");
	By createPositions  = By.xpath("//label[@for='IsActive-103']");
	By editPositions = By.xpath("//label[@for='IsActive-104']");
	By deletePositions = By.xpath("//label[@for='IsActive-105']");
	
	public void clickOFFbtnRadioPositionList()
	{
		String result = driver.findElement(btnRadioPositionList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioPositionList);
		 }
	}
	
	public void clickONbtnRadioPositionList()
	{
		String result = driver.findElement(btnRadioPositionList).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioPositionList);
		 }
	}
	

	public void clickOFFbtnViewPositionList()
	{
		String result = driver.findElement(btnViewPositionList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewPositionList);
		 }
	}
	
	public void clickONbtnViewPositionList()
	{
		String result = driver.findElement(btnViewPositionList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewPositionList);
		 }
	}
	
	
	public void clickOFFbtnViewPositionDetails()
	{
		String result = driver.findElement(btnViewPositionDetails).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewPositionDetails);
		 }
	}
	
	public void clickONbtnViewPositionDetails()
	{
		String result = driver.findElement(btnViewPositionDetails).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewPositionDetails);
		 }
	}
	
	public void clickOFFbtnCreatePositions()
	{
		String result = driver.findElement(btnCreatePositions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createPositions);
		 }
	}
	
	public void clickONbtnCreatePositions()
	{
		String result = driver.findElement(btnCreatePositions).getAttribute("checked");
		 if (result==null)
		 {
			 click(createPositions);
		 }
	}
	

	public void clickOFFbtnEditPositions()
	{
		String result = driver.findElement(btnEditPositions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editPositions);
		 }
	}
	
	public void clickONbtnEditPositions()
	{
		String result = driver.findElement(btnEditPositions).getAttribute("checked");
		 if (result==null)
		 {
			 click(editPositions);
		 }
	}
	
	
	public void clickOFFbtnDeletePositions()
	{
		String result = driver.findElement(btnDeletePositions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deletePositions);
		 }
	}
	
	public void clickONbtnDeletePositions()
	{
		String result = driver.findElement(btnDeletePositions).getAttribute("checked");
		 if (result==null)
		 {
			 click(deletePositions);
		 }
	}
	
	//Talent Management >> Talent - Baseline Position
	By btnRadioBaseline = By.xpath("//input[@id='IsActive-111']");
	By btnRadioPostionBaseline = By.xpath("//input[@id='IsActive-112']");
	By btnViewBaselineListPosition = By.xpath("//input[@id='IsActive-113']");
	By btnCreateBaselinesPosition  = By.xpath("//input[@id='IsActive-114']");
	By btnEditBaselinesPosition = By.xpath("//input[@id='IsActive-115']");
	By btnDeleteBaselinesPosition = By.xpath("//input[@id='IsActive-116']");
	By btnCloneBaselinesPosition = By.xpath("//input[@id='IsActive-117']");
	By btnInheritBaselinesPosition = By.xpath("//input[@id='IsActive-118']");
	
	By radioBaseline = By.xpath("//label[@for='IsActive-111']");
	By radioPostionBaseline = By.xpath("//label[@for='IsActive-112']");
	By viewBaselineListPosition = By.xpath("//label[@for='IsActive-113']");
	By createBaselinesPosition = By.xpath("//label[@for='IsActive-114']");
	By editBaselinesPosition = By.xpath("//label[@for='IsActive-115']");
	By deleteBaselinesPosition = By.xpath("//label[@for='IsActive-116']");
	By cloneBaselinesPosition = By.xpath("//label[@for='IsActive-117']");
	By inheritBaselinesPosition = By.xpath("//label[@for='IsActive-118']");
	
	public void clickOFFBtnRadioBaseline()
	{
		String result = driver.findElement(btnRadioBaseline).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioBaseline);
		 }
	}
	
	public void clickONBtnRadioBaseline()
	{
		String result = driver.findElement(btnRadioBaseline).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioBaseline);
		 }
	}

	public void clickOFFBtnRadioPostionBaseline()
	{
		String result = driver.findElement(btnRadioPostionBaseline).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioPostionBaseline);
		 }
	}
	
	public void clickONBtnRadioPostionBaseline()
	{
		String result = driver.findElement(btnRadioPostionBaseline).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioPostionBaseline);
		 }
	}

	public void clickOFFbtnViewBaselineListPosition()
	{
		String result = driver.findElement(btnViewBaselineListPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewBaselineListPosition);
		 }
	}
	
	public void clickONbtnViewBaselineListPosition()
	{
		String result = driver.findElement(btnViewBaselineListPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewBaselineListPosition);
		 }
	}
	
	public void clickOFFbtnCreateBaselinesPosition()
	{
		String result = driver.findElement(btnCreateBaselinesPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createBaselinesPosition);
		 }
	}
	
	public void clickONbtnCreateBaselinesPosition()
	{
		String result = driver.findElement(btnCreateBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(createBaselinesPosition);
		 }
	}
	

	public void clickOFFbtnEditBaselinesPosition()
	{
		String result = driver.findElement(btnEditBaselinesPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editBaselinesPosition);
		 }
	}
	
	public void clickONbtnEditBaselinesPosition()
	{
		String result = driver.findElement(btnEditBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(editBaselinesPosition);
		 }
	}
	
		
	public void clickOFFbtnDeleteBaselinesPosition()
	{
		String result = driver.findElement(btnDeleteBaselinesPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteBaselinesPosition);
		 }
	}
	
	public void clickONbtnDeleteBaselinesPosition()
	{
		String result = driver.findElement(btnDeleteBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteBaselinesPosition);
		 }
	}
	
	public void clickOFFBtnCloneBaselinesPosition()
	{
		String result = driver.findElement(btnCloneBaselinesPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(cloneBaselinesPosition);
		 }
	}
	
	public void clickONBtnCloneBaselinesPosition()
	{
		String result = driver.findElement(btnCloneBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(cloneBaselinesPosition);
		 }
	}
	
	public void clickOFFBtnInheritBaselinesPosition()
	{
		String result = driver.findElement(btnInheritBaselinesPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(inheritBaselinesPosition);
		 }
	}
	
	public void clickONBtnInheritBaselinesPosition()
	{
		String result = driver.findElement(btnInheritBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(inheritBaselinesPosition);
		 }
	}
	
	//Control board >> Talent - Goal Line Job
	
	By btnRadioJobGoalLine = By.xpath("//input[@id='IsActive-141']");
	By btnViewListJobGoalLine = By.xpath("//input[@id='IsActive-142']");
	By btnViewDetailJobGoalLine = By.xpath("//input[@id='IsActive-143']");
	By btnCreateJobGoals  = By.xpath("//input[@id='IsActive-144']");
	By btnEditJobGoals = By.xpath("//input[@id='IsActive-145']");
	By btnDuplicateJobGoals = By.xpath("//input[@id='IsActive-146']");
	By btnDeleteJobGoals = By.xpath("//input[@id='IsActive-147']");
	By btnCloneJobGoalLines = By.xpath("//input[@id='IsActive-148']");
		
	By radioJobGoalLine = By.xpath("//label[@for='IsActive-141']");
	By viewListJobGoalLine = By.xpath("//label[@for='IsActive-142']");
	By viewDetailJobGoalLine = By.xpath("//label[@for='IsActive-143']");
	By createJobGoals = By.xpath("//label[@for='IsActive-144']");
	By editJobGoals = By.xpath("//label[@for='IsActive-145']");
	By duplicateJobGoals = By.xpath("//label[@for='IsActive-146']");
	By deleteJobGoals = By.xpath("//label[@for='IsActive-147']");
	By cloneJobGoalLines = By.xpath("//label[@for='IsActive-148']");
	
		public void clickOFFbtnRadioJobGoalLine()
		{
			String result = driver.findElement(btnRadioJobGoalLine).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioJobGoalLine);
			 }
		}
		
		public void clickONbtnRadioJobGoalLine()
		{
			String result = driver.findElement(btnRadioJobGoalLine).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioJobGoalLine);
			 }
		}
		
		public void clickOFFbtnViewListJobGoalLine()
		{
			String result = driver.findElement(btnViewListJobGoalLine).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewListJobGoalLine);
			 }
		}
		
		public void clickONbtnViewListJobGoalLine()
		{
			String result = driver.findElement(btnViewListJobGoalLine).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewListJobGoalLine);
			 }
		}
		
		public void clickOFFbtnViewDetailJobGoalLine()
		{
			String result = driver.findElement(btnViewDetailJobGoalLine).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewDetailJobGoalLine);
			 }
		}
		
		public void clickONbtnViewDetailJobGoalLine()
		{
			String result = driver.findElement(btnViewDetailJobGoalLine).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewDetailJobGoalLine);
			 }
		}
		
		public void clickOFFbtnCreateJobGoals()
		{
			String result = driver.findElement(btnCreateJobGoals).getAttribute("checked");
			 if (result!=null)
			 {
				 click(createJobGoals);
			 }
		}
		
		public void clickONbtnCreateJobGoals()
		{
			String result = driver.findElement(btnCreateJobGoals).getAttribute("checked");
			 if (result==null)
			 {
				 click(createJobGoals);
			 }
		}
		
			
		public void clickOFFbtnEditJobGoals()
		{
			String result = driver.findElement(btnEditJobGoals).getAttribute("checked");
			 if (result!=null)
			 {
				 click(editJobGoals);
			 }
		}
		
		public void clickONbtnEditJobGoals()
		{
			String result = driver.findElement(btnEditJobGoals).getAttribute("checked");
			 if (result==null)
			 {
				 click(editJobGoals);
			 }
		}
		
		public void clickOFFbtnDeleteJobGoals()
		{
			String result = driver.findElement(btnDeleteJobGoals).getAttribute("checked");
			 if (result!=null)
			 {
				 click(deleteJobGoals);
			 }
		}
		
		public void clickONbtnDeleteJobGoals()
		{
			String result = driver.findElement(btnDeleteJobGoals).getAttribute("checked");
			 if (result==null)
			 {
				 click(deleteJobGoals);
			 }
		}
		
		public void clickOFFbtnCloneJobGoalLines()
		{
			String result = driver.findElement(btnCloneJobGoalLines).getAttribute("checked");
			 if (result!=null)
			 {
				 click(cloneJobGoalLines);
			 }
		}
		
		public void clickONbtnCloneJobGoalLines()
		{
			String result = driver.findElement(btnCloneJobGoalLines).getAttribute("checked");
			 if (result==null)
			 {
				 click(cloneJobGoalLines);
			 }
		}
		
		public void clickOFFbtnDuplicateJobGoals()
		{
			String result = driver.findElement(btnDuplicateJobGoals).getAttribute("checked");
			 if (result!=null)
			 {
				 click(duplicateJobGoals);
			 }
		}
		
		public void clickONbtnDuplicateJobGoals()
		{
			String result = driver.findElement(btnDuplicateJobGoals).getAttribute("checked");
			 if (result==null)
			 {
				 click(duplicateJobGoals);
			 }
		}
	
		//Control board >> Talent - BaseLine Dimension
		
		By btnRadioDimensionBaseline = By.xpath("//input[@id='IsActive-125']");
		By btnViewBaselineListDimension = By.xpath("//input[@id='IsActive-126']");
		By btnCreateBaselinesDimension  = By.xpath("//input[@id='IsActive-127']");
		By btnEditBaselinesDimension = By.xpath("//input[@id='IsActive-128']");
		By btnDeleteBaselinesDimension = By.xpath("//input[@id='IsActive-129']");
		By btnCloneBaselinesDimension = By.xpath("//input[@id='IsActive-130']");
				
		By radioDimensionBaseline = By.xpath("//label[@for='IsActive-125']");
		By viewBaselineListDimension = By.xpath("//label[@for='IsActive-126']");
		By createBaselinesDimension = By.xpath("//label[@for='IsActive-127']");
		By editBaselinesDimension = By.xpath("//label[@for='IsActive-128']");
		By deleteBaselinesDimension = By.xpath("//label[@for='IsActive-129']");
		By cloneBaselinesDimension = By.xpath("//label[@for='IsActive-130']");
		
		public void clickOFFbtnRadioDimensionBaseline()
		{
			String result = driver.findElement(btnRadioDimensionBaseline).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioDimensionBaseline);
			 }
		}
		
		public void clickONbtnRadioDimensionBaseline()
		{
			String result = driver.findElement(btnRadioDimensionBaseline).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioDimensionBaseline);
			 }
		}
		
				public void clickOFFbtnViewBaselineListDimension()
				{
					String result = driver.findElement(btnViewBaselineListDimension).getAttribute("checked");
					 if (result!=null)
					 {
						 click(viewBaselineListDimension);
					 }
				}
				
				public void clickONbtnViewBaselineListDimension()
				{
					String result = driver.findElement(btnViewBaselineListDimension).getAttribute("checked");
					 if (result==null)
					 {
						 click(viewBaselineListDimension);
					 }
				}
				
				public void clickOFFbtnCreateBaselinesDimension()
				{
					String result = driver.findElement(btnCreateBaselinesDimension).getAttribute("checked");
					 if (result!=null)
					 {
						 click(createBaselinesDimension);
					 }
				}
				
				public void clickONbtnCreateBaselinesDimension()
				{
					String result = driver.findElement(btnCreateBaselinesDimension).getAttribute("checked");
					 if (result==null)
					 {
						 click(createBaselinesDimension);
					 }
				}
				

				public void clickOFFbtnEditBaselinesDimension()
				{
					String result = driver.findElement(btnEditBaselinesDimension).getAttribute("checked");
					 if (result!=null)
					 {
						 click(editBaselinesDimension);
					 }
				}
				
				public void clickONbtnEditBaselinesDimension()
				{
					String result = driver.findElement(btnEditBaselinesDimension).getAttribute("checked");
					 if (result==null)
					 {
						 click(editBaselinesDimension);
					 }
				}
				
					
				public void clickOFFbtnDeleteBaselinesDimension()
				{
					String result = driver.findElement(btnDeleteBaselinesDimension).getAttribute("checked");
					 if (result!=null)
					 {
						 click(deleteBaselinesDimension);
					 }
				}
				
				public void clickONbtnDeleteBaselinesDimension()
				{
					String result = driver.findElement(btnDeleteBaselinesDimension).getAttribute("checked");
					 if (result==null)
					 {
						 click(deleteBaselinesDimension);
					 }
				}
				
				public void clickOFFBtnCloneBaselinesDimension()
				{
					String result = driver.findElement(btnCloneBaselinesDimension).getAttribute("checked");
					 if (result!=null)
					 {
						 click(cloneBaselinesDimension);
					 }
				}
				
				public void clickONBtnCloneBaselinesDimension()
				{
					String result = driver.findElement(btnCloneBaselinesDimension).getAttribute("checked");
					 if (result==null)
					 {
						 click(cloneBaselinesDimension);
					 }
				}
	
				//Control board >> Talent - Goal Position
				By btnRadioGoalLine = By.xpath("//input[@id='IsActive-131']");
				By btnRadioPostionGoalLine = By.xpath("//input[@id='IsActive-132']");
				By btnViewListPositionGoalLine = By.xpath("//input[@id='IsActive-133']");
				By btnViewDetailPositionGoalDetails = By.xpath("//input[@id='IsActive-134']");
				By btnCreatePositionGoals  = By.xpath("//input[@id='IsActive-135']");
				By btnEditPositionGoals = By.xpath("//input[@id='IsActive-136']");
				By btnDuplicatePositionGoals = By.xpath("//input[@id='IsActive-137']");
				By btnDeletePositionGoals = By.xpath("//input[@id='IsActive-138']");
				By btnClonePositionGoalLine = By.xpath("//input[@id='IsActive-139']");
				By btnInheritPositionGoalLine = By.xpath("//input[@id='IsActive-140']");
				
				By radioGoalLine = By.xpath("//label[@for='IsActive-131']");
				By radioPostionGoalLine = By.xpath("//label[@for='IsActive-132']");
				By viewListPositionGoalLine = By.xpath("//label[@for='IsActive-133']");
				By viewDetailPositionGoalDetails = By.xpath("//label[@for='IsActive-134']");
				By createPositionGoals = By.xpath("//label[@for='IsActive-135']");
				By editPositionGoals = By.xpath("//label[@for='IsActive-136']");
				By duplicatePositionGoals = By.xpath("//label[@for='IsActive-137']");
				By deletePositionGoals = By.xpath("//label[@for='IsActive-138']");
				By clonePositionGoalLine = By.xpath("//label[@for='IsActive-139']");
				By inheritPositionGoalLine = By.xpath("//label[@for='IsActive-140']");
				
				public void clickOFFbtnRadioGoalLine()
				{
					String result = driver.findElement(btnRadioGoalLine).getAttribute("checked");
					 if (result!=null)
					 {
						 click(radioGoalLine);
					 }
				}
				
				public void clickONbtnRadioGoalLine()
				{
					String result = driver.findElement(btnRadioGoalLine).getAttribute("checked");
					 if (result==null)
					 {
						 click(radioGoalLine);
					 }
				}

				public void clickOFFbtnRadioPostionGoalLine()
				{
					String result = driver.findElement(btnRadioPostionGoalLine).getAttribute("checked");
					 if (result!=null)
					 {
						 click(radioPostionGoalLine);
					 }
				}
				
				public void clickONbtnRadioPostionGoalLine()
				{
					String result = driver.findElement(btnRadioPostionGoalLine).getAttribute("checked");
					 if (result==null)
					 {
						 click(radioPostionGoalLine);
					 }
				}

				public void clickOFFbtnViewDetailPositionGoalDetails()
				{
					String result = driver.findElement(btnViewDetailPositionGoalDetails).getAttribute("checked");
					 if (result!=null)
					 {
						 click(viewDetailPositionGoalDetails);
					 }
				}
				
				public void clickONbtnViewDetailPositionGoalDetails()
				{
					String result = driver.findElement(btnViewDetailPositionGoalDetails).getAttribute("checked");
					 if (result==null)
					 {
						 click(viewDetailPositionGoalDetails);
					 }
				}
				
				public void clickOFFbtnClonePositionGoalLine()
				{
					String result = driver.findElement(btnClonePositionGoalLine).getAttribute("checked");
					 if (result!=null)
					 {
						 click(clonePositionGoalLine);
					 }
				}
				
				public void clickONbtnClonePositionGoalLine()
				{
					String result = driver.findElement(btnClonePositionGoalLine).getAttribute("checked");
					 if (result==null)
					 {
						 click(clonePositionGoalLine);
					 }
				}
				

				public void clickOFFbtnCreatePositionGoals()
				{
					String result = driver.findElement(btnCreatePositionGoals).getAttribute("checked");
					 if (result!=null)
					 {
						 click(createPositionGoals);
					 }
				}
				
				public void clickONbtnCreatePositionGoals()
				{
					String result = driver.findElement(btnCreatePositionGoals).getAttribute("checked");
					 if (result==null)
					 {
						 click(createPositionGoals);
					 }
				}
				
					
				public void clickOFFbtnEditPositionGoals()
				{
					String result = driver.findElement(btnEditPositionGoals).getAttribute("checked");
					 if (result!=null)
					 {
						 click(editPositionGoals);
					 }
				}
				
				public void clickONbtnEditPositionGoals()
				{
					String result = driver.findElement(btnEditPositionGoals).getAttribute("checked");
					 if (result==null)
					 {
						 click(editPositionGoals);
					 }
				}
				
				public void clickOFFbtnDeletePositionGoals()
				{
					String result = driver.findElement(btnDeletePositionGoals).getAttribute("checked");
					 if (result!=null)
					 {
						 click(deletePositionGoals);
					 }
				}
				
				public void clickONbtnDeletePositionGoals()
				{
					String result = driver.findElement(btnDeletePositionGoals).getAttribute("checked");
					 if (result==null)
					 {
						 click(deletePositionGoals);
					 }
				}
				
				public void clickOFFbtnDuplicatePositionGoals()
				{
					String result = driver.findElement(btnDuplicatePositionGoals).getAttribute("checked");
					 if (result!=null)
					 {
						 click(duplicatePositionGoals);
					 }
				}
				
				public void clickONbtnDuplicatePositionGoals()
				{
					String result = driver.findElement(btnDuplicatePositionGoals).getAttribute("checked");
					 if (result==null)
					 {
						 click(duplicatePositionGoals);
					 }
				}
				
				public void clickOFFbtnInheritPositionGoalLine()
				{
					String result = driver.findElement(btnInheritPositionGoalLine).getAttribute("checked");
					 if (result!=null)
					 {
						 click(inheritPositionGoalLine);
					 }
				}
				
				public void clickONbtnInheritPositionGoalLine()
				{
					String result = driver.findElement(btnInheritPositionGoalLine).getAttribute("checked");
					 if (result==null)
					 {
						 click(inheritPositionGoalLine);
					 }
				}
				
				//Control board >> Talent - Baseline Job
				
				By btnRadioJobBaseline = By.xpath("//input[@id='IsActive-119']");
					By btnViewBaselineListJob = By.xpath("//input[@id='IsActive-120']");
					By btnCreateBaselinesJob  = By.xpath("//input[@id='IsActive-121']");
					By btnEditBaselinesJob = By.xpath("//input[@id='IsActive-122']");
					By btnDeleteBaselinesJob = By.xpath("//input[@id='IsActive-123']");
					By btnCloneBaselinesJob = By.xpath("//input[@id='IsActive-124']");
				
					By radioJobBaseline = By.xpath("//label[@for='IsActive-119']");
					By viewBaselineListJob = By.xpath("//label[@for='IsActive-120']");
					By createBaselinesJob = By.xpath("//label[@for='IsActive-121']");
					By editBaselinesJob = By.xpath("//label[@for='IsActive-122']");
					By deleteBaselinesJob = By.xpath("//label[@for='IsActive-123']");
					By cloneBaselinesJob = By.xpath("//label[@for='IsActive-124']");
				
					public void clickOFFbtnRadioJobBaseline()
					{
						String result = driver.findElement(btnRadioJobBaseline).getAttribute("checked");
						 if (result!=null)
						 {
							 click(radioJobBaseline);
						 }
					}
					
					public void clickONbtnRadioJobBaseline()
					{
						String result = driver.findElement(btnRadioJobBaseline).getAttribute("checked");
						 if (result==null)
						 {
							 click(radioJobBaseline);
						 }
					}
					
					public void clickOFFbtnViewBaselineListJob()
					{
						String result = driver.findElement(btnViewBaselineListJob).getAttribute("checked");
						 if (result!=null)
						 {
							 click(viewBaselineListJob);
						 }
					}
					
					public void clickONbtnViewBaselineListJob()
					{
						String result = driver.findElement(btnViewBaselineListJob).getAttribute("checked");
						 if (result==null)
						 {
							 click(viewBaselineListJob);
						 }
					}
					
					public void clickOFFbtnCreateBaselinesJob()
					{
						String result = driver.findElement(btnCreateBaselinesJob).getAttribute("checked");
						 if (result!=null)
						 {
							 click(createBaselinesJob);
						 }
					}
					
					public void clickONbtnCreateBaselinesJob()
					{
						String result = driver.findElement(btnCreateBaselinesJob).getAttribute("checked");
						 if (result==null)
						 {
							 click(createBaselinesJob);
						 }
					}
					

					public void clickOFFbtnEditBaselinesJob()
					{
						String result = driver.findElement(btnEditBaselinesJob).getAttribute("checked");
						 if (result!=null)
						 {
							 click(editBaselinesJob);
						 }
					}
					
					public void clickONbtnEditBaselinesJob()
					{
						String result = driver.findElement(btnEditBaselinesJob).getAttribute("checked");
						 if (result==null)
						 {
							 click(editBaselinesJob);
						 }
					}
					
						
					public void clickOFFbtnDeleteBaselinesJob()
					{
						String result = driver.findElement(btnDeleteBaselinesJob).getAttribute("checked");
						 if (result!=null)
						 {
							 click(deleteBaselinesJob);
						 }
					}
					
					public void clickONbtnDeleteBaselinesJob()
					{
						String result = driver.findElement(btnDeleteBaselinesJob).getAttribute("checked");
						 if (result==null)
						 {
							 click(deleteBaselinesJob);
						 }
					}
					
					public void clickOFFBtnCloneBaselinesJob()
					{
						String result = driver.findElement(btnCloneBaselinesJob).getAttribute("checked");
						 if (result!=null)
						 {
							 click(cloneBaselinesJob);
						 }
					}
					
					public void clickONBtnCloneBaselinesJob()
					{
						String result = driver.findElement(btnCloneBaselinesJob).getAttribute("checked");
						 if (result==null)
						 {
							 click(cloneBaselinesJob);
						 }
					}
					
		//Control board >> Talent - GoalLine Dimension
				
		By btnRadioDimensionGoalLine = By.xpath("//input[@id='IsActive-149']");
		By btnViewListDimensionGoalLine = By.xpath("//input[@id='IsActive-150']");
		By btnViewDetailDimensionGoalLineList  = By.xpath("//input[@id='IsActive-151']");
		By btnCreateDimensionGoals = By.xpath("//input[@id='IsActive-152']");
		By btnEditDimensionGoals = By.xpath("//input[@id='IsActive-153']");
		By btnDuplicateDimensionGoals = By.xpath("//input[@id='IsActive-154']");
		By btnDeleteDimensionGoals = By.xpath("//input[@id='IsActive-155']");
		By btnCloneDimensionGoalLines = By.xpath("//input[@id='IsActive-156']");
							
		By radioDimensionGoalLine = By.xpath("//label[@for='IsActive-149']");
		By viewListDimensionGoalLine = By.xpath("//label[@for='IsActive-150']");
		By viewDetailDimensionGoalLineList = By.xpath("//label[@for='IsActive-151']");
		By createDimensionGoals = By.xpath("//label[@for='IsActive-152']");
		By editDimensionGoals = By.xpath("//label[@for='IsActive-153']");
		By duplicateDimensionGoals = By.xpath("//label[@for='IsActive-154']");
		By deleteDimensionGoals = By.xpath("//label[@for='IsActive-155']");
		By cloneDimensionGoalLines = By.xpath("//label[@for='IsActive-156']");
					
		public void clickOFFbtnRadioDimensionGoalLine()
		{
			String result = driver.findElement(btnRadioDimensionGoalLine).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioDimensionGoalLine);
			 }
		}
		
		public void clickONbtnRadioDimensionGoalLine()
		{
			String result = driver.findElement(btnRadioDimensionGoalLine).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioDimensionGoalLine);
			 }
		}

		public void clickOFFbtnViewListDimensionGoalLine()
		{
			String result = driver.findElement(btnViewListDimensionGoalLine).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewListDimensionGoalLine);
		 }
	}
	
	public void clickONbtnViewListDimensionGoalLine()
	{
		String result = driver.findElement(btnViewListDimensionGoalLine).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewListDimensionGoalLine);
		 }
	}
	
	public void clickOFFbtnViewDetailDimensionGoalLineList()
	{
		String result = driver.findElement(btnViewDetailDimensionGoalLineList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewDetailDimensionGoalLineList);
		 }
	}
	
	public void clickONbtnViewDetailDimensionGoalLineList()
	{
		String result = driver.findElement(btnViewDetailDimensionGoalLineList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewDetailDimensionGoalLineList);
		 }
	}
	

	public void clickOFFbtnCreateDimensionGoals()
	{
		String result = driver.findElement(btnCreateDimensionGoals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createDimensionGoals);
		 }
	}
	
	public void clickONbtnCreateDimensionGoals()
	{
		String result = driver.findElement(btnCreateDimensionGoals).getAttribute("checked");
		 if (result==null)
		 {
			 click(createDimensionGoals);
		 }
	}
	
		
	public void clickOFFbtnEditDimensionGoals()
	{
		String result = driver.findElement(btnEditDimensionGoals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editDimensionGoals);
		 }
	}
	
	public void clickONbtnEditDimensionGoals()
	{
		String result = driver.findElement(btnEditDimensionGoals).getAttribute("checked");
		 if (result==null)
		 {
			 click(editDimensionGoals);
		 }
	}
	
	public void clickOFFbtnDuplicateDimensionGoals()
	{
		String result = driver.findElement(btnDuplicateDimensionGoals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(duplicateDimensionGoals);
		 }
	}
	
	public void clickONbtnDuplicateDimensionGoals()
	{
		String result = driver.findElement(btnDuplicateDimensionGoals).getAttribute("checked");
		 if (result==null)
		 {
			 click(duplicateDimensionGoals);
		 }
	}
	
	public void clickOFFbtnDeleteDimensionGoals()
	{
		String result = driver.findElement(btnDeleteDimensionGoals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteDimensionGoals);
		 }
	}
	
	public void clickONbtnDeleteDimensionGoals()
	{
		String result = driver.findElement(btnDeleteDimensionGoals).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteDimensionGoals);
		 }
	}
	
	public void clickOFFbtnCloneDimensionGoalLines()
	{
		String result = driver.findElement(btnCloneDimensionGoalLines).getAttribute("checked");
		 if (result!=null)
		 {
			 click(cloneDimensionGoalLines);
		 }
	}
	
	public void clickONbtnCloneDimensionGoalLines()
	{
		String result = driver.findElement(btnCloneDimensionGoalLines).getAttribute("checked");
		 if (result==null)
		 {
			 click(cloneDimensionGoalLines);
		 }
	}
							
	//Control Board - Talent >> Organization
	By btnRadioOrganization = By.xpath("//input[@id='IsActive-83']");
	By btnViewDimensionList = By.xpath("//input[@id='IsActive-84']");
	By btnCreateDimension  = By.xpath("//input[@id='IsActive-85']");
	By btnEditDimension = By.xpath("//input[@id='IsActive-86']");
	By btnDeleteDimension = By.xpath("//input[@id='IsActive-87']");
	
	By radioOrganization = By.xpath("//label[@for='IsActive-83']");
	By viewDimensionList = By.xpath("//label[@for='IsActive-84']");
	By createDimension  = By.xpath("//label[@for='IsActive-85']");
	By editDimension = By.xpath("//label[@for='IsActive-86']");
	By deleteDimension = By.xpath("//label[@for='IsActive-87']");
	
	public void clickOFFbtnRadioOrganization()
	{
		String result = driver.findElement(btnRadioOrganization).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioOrganization);
		 }
	}
	
	public void clickONbtnRadioOrganization()
	{
		String result = driver.findElement(btnRadioOrganization).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioOrganization);
		 }
	}	
	
	public void clickOFFbtnViewDimensionList()
	{
		String result = driver.findElement(btnViewDimensionList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewDimensionList);
		 }
	}
	
	public void clickONbtnViewDimensionList()
	{
		String result = driver.findElement(btnViewDimensionList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewDimensionList);
		 }
	}	
	
	public void clickOFFbtnCreateDimension()
	{
		String result = driver.findElement(btnCreateDimension).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createDimension);
		 }
	}
	
	public void clickONbtnCreateDimension()
	{
		String result = driver.findElement(btnCreateDimension).getAttribute("checked");
		 if (result==null)
		 {
			 click(createDimension);
		 }
	}

	
	public void clickOFFbtnEditDimension()
	{
		String result = driver.findElement(btnEditDimension).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editDimension);
		 }
	}
	
	public void clickONbtnEditDimension()
	{
		String result = driver.findElement(btnEditDimension).getAttribute("checked");
		 if (result==null)
		 {
			 click(editDimension);
		 }
	}

	
	public void clickOFFbtnDeleteDimension()
	{
		String result = driver.findElement(btnDeleteDimension).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteDimension);
		 }
	}
	
	public void clickONbtnDeleteDimension()
	{
		String result = driver.findElement(btnDeleteDimension).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteDimension);
		 }
	}
	
	//Control Board - System >> Content Management
	By btnRadioContentManagement =  By.xpath("//label[@for='IsActive-79']");
	By btnViewWelcomeLetter = By.xpath("//input[@id='IsActive-80']");
	By btnEditWelcomeLetter = By.xpath("//input[@id='IsActive-81']");
							
	By radioContentManagement = By.xpath("//label[@for='IsActive-79']");
	By viewWelcomeLetter = By.xpath("//label[@for='IsActive-80']");
	By editWelcomeLetter  = By.xpath("//label[@for='IsActive-81']");
							
	public void clickOFFBtnRadioWelcomeLetter()
	{
		String result = driver.findElement(btnRadioContentManagement).getAttribute("checked");
		if (result!=null)
		{
			click(radioContentManagement);
		}
	}
					
	public void clickONBtnRadioWelcomeLetter()
	{
		String result = driver.findElement(btnRadioContentManagement).getAttribute("checked");
		if (result==null)
		{
			click(radioContentManagement);
		}
	}
					
	public void clickOFFBtnViewWelcomeLetter()
	{
		String result = driver.findElement(btnViewWelcomeLetter).getAttribute("checked");
		if (result!=null)
		{
			click(viewWelcomeLetter);
		}
	}
					
	public void clickONBtnViewWelcomeLetter()
	{
		String result = driver.findElement(btnViewWelcomeLetter).getAttribute("checked");
		if (result==null)
		{
			click(viewWelcomeLetter);
		}
	}	
		
	public void clickOFFBtnEditWelcomeLetter()
	{
		String result = driver.findElement(btnEditWelcomeLetter).getAttribute("checked");
		if (result!=null)
		{
			click(editWelcomeLetter);
		}
	}
					
	public void clickONBtnEditWelcomeLetter()
	{
		String result = driver.findElement(btnEditWelcomeLetter).getAttribute("checked");
		if (result==null)
		{
			click(editWelcomeLetter);
		}
	}
	
	//Control Board - Talent >> Skill
	By btnRadioSkills = By.xpath("//input[@id='IsActive-106']");
	By btnViewSkills = By.xpath("//input[@id='IsActive-107']");
	By btnCreateSkills  = By.xpath("//input[@id='IsActive-108']");
	By btnEditSkills = By.xpath("//input[@id='IsActive-109']");
	By btnManageSkillCategory = By.xpath("//input[@id='IsActive-110']");
	
	By radioSkills = By.xpath("//label[@for='IsActive-106']");
	By viewSkills = By.xpath("//label[@for='IsActive-107']");
	By createSkills  = By.xpath("//label[@for='IsActive-108']");
	By editSkills = By.xpath("//label[@for='IsActive-109']");
	By manageSkillCategory = By.xpath("//label[@for='IsActive-110']");
	
	public void clickOFFbtnRadioSkills()
	{
		String result = driver.findElement(btnRadioSkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioSkills);
		 }
	}
	
	public void clickONbtnRadioSkills()
	{
		String result = driver.findElement(btnRadioSkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioSkills);
		 }
	}
	
	
	public void clickOFFbtnViewSkills()
	{
		String result = driver.findElement(btnViewSkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSkills);
		 }
	}
	
	public void clickONbtnViewSkills()
	{
		String result = driver.findElement(btnViewSkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSkills);
		 }
	}
	
	
	public void clickOFFbtnCreateSkills()
	{
		String result = driver.findElement(btnCreateSkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createSkills);
		 }
	}
	
	public void clickONbtnCreateSkills()
	{
		String result = driver.findElement(btnCreateSkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(createSkills);
		 }
	}
	
	
	public void clickOFFbtnEditSkills()
	{
		String result = driver.findElement(btnEditSkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editSkills);
		 }
	}
	
	public void clickONbtnEditSkills()
	{
		String result = driver.findElement(btnEditSkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(editSkills);
		 }
	}
		
	public void clickOFFbtnManageSkillCategory()
	{
		String result = driver.findElement(btnManageSkillCategory).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageSkillCategory);
		 }
	}
	
	public void clickONbtnManageSkillCategory()
	{
		String result = driver.findElement(btnManageSkillCategory).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageSkillCategory);
		 }
	}
	
	//Control Board - System Settings >> General Settings
	By btnRadioGeneralSettings = By.xpath("//input[@id='IsActive-47']");
	By btnViewGeneralSettings = By.xpath("//input[@id='IsActive-48']");
	By btnUpdateSystemDimensions = By.xpath("//input[@id='IsActive-49']");
	By btnUpdateSystemSkillLevel =  By.xpath("//input[@id='IsActive-50']");	
	By btnViewUserDefinedValues = By.xpath("//input[@id='IsActive-51']");
	By btnUpdateUserDefinedValues = By.xpath("//input[@id='IsActive-52']");
	By btnUpdateLearningURL =  By.xpath("//input[@id='IsActive-53']");	
	
	By radioGeneralSettings = By.xpath("//label[@for='IsActive-47']");
	By viewGeneralSettings = By.xpath("//label[@for='IsActive-48']");
	By updateSystemDimensions = By.xpath("//label[@for='IsActive-49']");
	By updateSystemSkillLevel =  By.xpath("//label[@for='IsActive-50']");	
	By viewUserDefinedValues = By.xpath("//label[@for='IsActive-51']");
	By updateUserDefinedValues = By.xpath("//label[@for='IsActive-52']");
	By updateLearningURL =  By.xpath("//label[@for='IsActive-53']");
	
	public void clickOFFbtnRadioGeneralSettings()
	{
		String result = driver.findElement(btnRadioGeneralSettings).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioGeneralSettings);
		 }
	}
	
	public void clickONbtnRadioGeneralSettings()
	{
		String result = driver.findElement(btnRadioGeneralSettings).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioGeneralSettings);
		 }
	}
	
	public void clickOFFbtnViewGeneralSettings()
	{
		String result = driver.findElement(btnViewGeneralSettings).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewGeneralSettings);
		 }
	}
	
	public void clickONbtnViewGeneralSettings()
	{
		String result = driver.findElement(btnViewGeneralSettings).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewGeneralSettings);
		 }
	}
	
	

	public void clickOFFbtnUpdateSystemDimensions()
	{
		String result = driver.findElement(btnUpdateSystemDimensions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateSystemDimensions);
		 }
	}
	
	public void clickONbtnUpdateSystemDimensions()
	{
		String result = driver.findElement(btnUpdateSystemDimensions).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateSystemDimensions);
		 }
	}
	
	
	public void clickOFFbtnUpdateSystemSkillLevel()
	{
		String result = driver.findElement(btnUpdateSystemSkillLevel).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateSystemSkillLevel);
		 }
	}
	
	public void clickONbtnUpdateSystemSkillLevel()
	{
		String result = driver.findElement(btnUpdateSystemSkillLevel).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateSystemSkillLevel);
		 }
	}
	
	public void clickOFFbtnViewUserDefinedValues()
	{
		String result = driver.findElement(btnViewUserDefinedValues).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewUserDefinedValues);
		 }
	}
	
	public void clickONbtnViewUserDefinedValues()
	{
		String result = driver.findElement(btnViewUserDefinedValues).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewUserDefinedValues);
		 }
	}
	
	public void clickOFFbtnUpdateUserDefinedValues()
	{
		String result = driver.findElement(btnUpdateUserDefinedValues).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateUserDefinedValues);
		 }
	}
	
	public void clickONbtnUpdateUserDefinedValues()
	{
		String result = driver.findElement(btnUpdateUserDefinedValues).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateUserDefinedValues);
		 }
	}
	
	public void clickOFFbtnUpdateLearningURL()
	{
		String result = driver.findElement(btnUpdateLearningURL).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateLearningURL);
		 }
	}
	
	public void clickONbtnUpdateLearningURL()
	{
		String result = driver.findElement(btnUpdateLearningURL).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateLearningURL);
		 }
	}
	
	
	//Control Board - System  >> Security Profile
	By btnRadioSecurityProfile = By.xpath("//input[@id='IsActive-73']");
	By btnViewSecurityProfile = By.xpath("//input[@id='IsActive-74']");
	By btnViewSecurityProfileDetail  = By.xpath("//input[@id='IsActive-75']");
	By btnCreateSecurityProfile = By.xpath("//input[@id='IsActive-76']");
	By btnEditSecurityProfile = By.xpath("//input[@id='IsActive-77']");
	By btnDeleteSecurityProfile = By.xpath("//input[@id='IsActive-78']");
	
	By radioSecurityProfile = By.xpath("//label[@for='IsActive-73']");
	By viewSecurityProfile = By.xpath("//label[@for='IsActive-74']");
	By viewSecurityProfileDetail  = By.xpath("//label[@for='IsActive-75']");
	By createSecurityProfile = By.xpath("//label[@for='IsActive-76']");
	By editSecurityProfile = By.xpath("//label[@for='IsActive-77']");
	By deleteSecurityProfile = By.xpath("//label[@for='IsActive-78']");
	
	public void clickOFFbtnRadioSecurityProfile()
	{
		String result = driver.findElement(btnRadioSecurityProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioSecurityProfile);
		 }
	}
	
	public void clickONbtnRadioSecurityProfile()
	{
		String result = driver.findElement(btnRadioSecurityProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioSecurityProfile);
		 }
	}
	
	
	public void clickOFFbtnViewSecurityProfile()
	{
		String result = driver.findElement(btnViewSecurityProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSecurityProfile);
		 }
	}
	
	public void clickONbtnViewSecurityProfile()
	{
		String result = driver.findElement(btnViewSecurityProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSecurityProfile);
		 }
	}
	
	public void clickOFFbtnViewSecurityProfileDetail()
	{
		String result = driver.findElement(btnViewSecurityProfileDetail).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSecurityProfileDetail);
		 }
	}
	
	public void clickONbtnViewSecurityProfileDetail()
	{
		String result = driver.findElement(btnViewSecurityProfileDetail).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSecurityProfileDetail);
		 }
	}
		
	public void clickOFFbtnCreateSecurityProfile()
	{
		String result = driver.findElement(btnCreateSecurityProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createSecurityProfile);
		 }
	}
	
	public void clickONbtnCreateSecurityProfile()
	{
		String result = driver.findElement(btnCreateSecurityProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(createSecurityProfile);
		 }
	}
	
	public void clickOFFbtnEditSecurityProfile()
	{
		String result = driver.findElement(btnEditSecurityProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editSecurityProfile);
		 }
	}
	
	public void clickONbtnEditSecurityProfile()
	{
		String result = driver.findElement(btnEditSecurityProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(editSecurityProfile);
		 }
	}
	
	public void clickOFFbtnDeleteSecurityProfile()
	{
		String result = driver.findElement(btnDeleteSecurityProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteSecurityProfile);
		 }
	}
	
	public void clickONbtnDeleteSecurityProfile()
	{
		String result = driver.findElement(btnDeleteSecurityProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteSecurityProfile);
		 }
	}
	
	//Control Board - System  >> Role
	By btnRadioRole = By.xpath("//input[@id='IsActive-61']");
	By btnViewRole = By.xpath("//input[@id='IsActive-62']");
	By btnViewRoleDetail  = By.xpath("//input[@id='IsActive-63']");
	By btnCreateRole = By.xpath("//input[@id='IsActive-64']");
	By btnEditRole = By.xpath("//input[@id='IsActive-65']");
	By btnDeleteRole = By.xpath("//input[@id='IsActive-66']");
	
	By radioRole = By.xpath("//label[@for='IsActive-61']");
	By viewRole = By.xpath("//label[@for='IsActive-62']");
	By viewRoleDetail  = By.xpath("//label[@for='IsActive-63']");
	By createRole = By.xpath("//label[@for='IsActive-64']");
	By editRole = By.xpath("//label[@for='IsActive-65']");
	By deleteRole = By.xpath("//label[@for='IsActive-66']");
	
	public void clickOFFbtnRadioRole()
	{
		String result = driver.findElement(btnRadioRole).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioRole);
		 }
	}
	
	public void clickONbtnRadioRole()
	{
		String result = driver.findElement(btnRadioRole).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioRole);
		 }
	}
	
	public void clickOFFbtnViewRole()
	{
		String result = driver.findElement(btnViewRole).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewRole);
		 }
	}
	
	public void clickONbtnViewRole()
	{
		String result = driver.findElement(btnViewRole).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewRole);
		 }
	}
	
	
	public void clickOFFbtnViewRoleDetail()
	{
		String result = driver.findElement(btnViewRoleDetail).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewRoleDetail);
		 }
	}
	
	public void clickONbtnViewRoleDetail()
	{
		String result = driver.findElement(btnViewRoleDetail).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewRoleDetail);
		 }
	}
	
	
	public void clickOFFbtnCreateRole()
	{
		String result = driver.findElement(btnCreateRole).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createRole);
		 }
	}
	
	public void clickONbtnCreateRole()
	{
		String result = driver.findElement(btnCreateRole).getAttribute("checked");
		 if (result==null)
		 {
			 click(createRole);
		 }
	}
	
	public void clickOFFbtnEditRole()
	{
		String result = driver.findElement(btnEditRole).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editRole);
		 }
	}
	
	public void clickONbtnEditRole()
	{
		String result = driver.findElement(btnEditRole).getAttribute("checked");
		 if (result==null)
		 {
			 click(editRole);
		 }
	}
	
	
	public void clickOFFbtnDeleteRole()
	{
		String result = driver.findElement(btnDeleteRole).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteRole);
		 }
	}
	
	public void clickONbtnDeleteRole()
	{
		String result = driver.findElement(btnDeleteRole).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteRole);
		 }
	}
	
	//Control Board - System Settings >> Function Set
	By btnRadioFunctionSet = By.xpath("//input[@id='IsActive-67']");
	By btnViewFunctionSet = By.xpath("//input[@id='IsActive-68']");
	By btnViewFunctionSetDetail  = By.xpath("//input[@id='IsActive-69']");
	By btnCreateFunctionSet = By.xpath("//input[@id='IsActive-70']");
	By btnEditFunctionSet = By.xpath("//input[@id='IsActive-71']");
	By btnDeleteFunctionSet = By.xpath("//input[@id='IsActive-72']");
	
	By radioFunctionSet = By.xpath("//label[@for='IsActive-67']");
	By viewFunctionSet = By.xpath("//label[@for='IsActive-68']");
	By viewFunctionSetDetail  = By.xpath("//label[@for='IsActive-69']");
	By createFunctionSet = By.xpath("//label[@for='IsActive-70']");
	By editFunctionSet = By.xpath("//label[@for='IsActive-71']");
	By deleteFunctionSet = By.xpath("//label[@for='IsActive-72']");
	
	public void clickOFFbtnRadioFunctionSet()
	{
		String result = driver.findElement(btnRadioFunctionSet).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioFunctionSet);
		 }
	}
	
	public void clickONbtnRadioFunctionSet()
	{
		String result = driver.findElement(btnRadioFunctionSet).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioFunctionSet);
		 }
	}
	

	public void clickOFFbtnViewFunctionSet()
	{
		String result = driver.findElement(btnViewFunctionSet).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewFunctionSet);
		 }
	}
	
	public void clickONbtnViewFunctionSet()
	{
		String result = driver.findElement(btnViewFunctionSet).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewFunctionSet);
		 }
	}
	
	public void clickOFFbtnViewFunctionSetDetail()
	{
		String result = driver.findElement(btnViewFunctionSetDetail).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewFunctionSetDetail);
		 }
	}
	
	public void clickONbtnViewFunctionSetDetail()
	{
		String result = driver.findElement(btnViewFunctionSetDetail).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewFunctionSetDetail);
		 }
	}

	public void clickOFFbtnCreateFunctionSet()
	{
		String result = driver.findElement(btnCreateFunctionSet).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createFunctionSet);
		 }
	}
	
	public void clickONbtnCreateFunctionSet()
	{
		String result = driver.findElement(btnCreateFunctionSet).getAttribute("checked");
		 if (result==null)
		 {
			 click(createFunctionSet);
		 }
	}

	public void clickOFFbtnEditFunctionSet()
	{
		String result = driver.findElement(btnEditFunctionSet).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editFunctionSet);
		 }
	}
	
	public void clickONbtnEditFunctionSet()
	{
		String result = driver.findElement(btnEditFunctionSet).getAttribute("checked");
		 if (result==null)
		 {
			 click(editFunctionSet);
		 }
	}
	
	public void clickOFFbtnDeleteFunctionSet()
	{
		String result = driver.findElement(btnDeleteFunctionSet).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteFunctionSet);
		 }
	}
	
	public void clickONbtnDeleteFunctionSet()
	{
		String result = driver.findElement(btnDeleteFunctionSet).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteFunctionSet);
		 }
	}
	
	//Talent Management >> Employee
	By subTabEmployee = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[1]");
	
	By btnRadioEmployeeList = By.xpath("//input[@id='IsActive-15']");
	By btnViewmEployeeList = By.xpath("//input[@id='IsActive-16']");
		
	By radioEmployeeList = By.xpath("//label[@for='IsActive-15']");
	By viewmEployeeList = By.xpath("//label[@for='IsActive-16']");
	
	By btnRadioData = By.xpath("//input[@id='IsActive-17']");
	By radioData = By.xpath("//label[@for='IsActive-17']");
	
	By btnRadioPersonal = By.xpath("//input[@id='IsActive-18']");
	By btnViewProfile = By.xpath("//input[@id='IsActive-19']");
	By btnEditProfile = By.xpath("//input[@id='IsActive-263']");
	By btnViewContact = By.xpath("//input[@id='IsActive-20']");
	By btnManageContact = By.xpath("//input[@id='IsActive-21']");
	By btnViewAddress = By.xpath("//input[@id='IsActive-22']");
	By btnManageAddress = By.xpath("//input[@id='IsActive-23']");
	By btnViewEducation = By.xpath("//input[@id='IsActive-24']");
	By btnManageEducation = By.xpath("//input[@id='IsActive-25']");
	By btnViewIdentificationDocuments = By.xpath("//input[@id='IsActive-26']");
	By btnManageIdentificationDocuments = By.xpath("//input[@id='IsActive-27']");
	
	By radioPersonal = By.xpath("//label[@for='IsActive-18']");
	By viewProfile = By.xpath("//label[@for='IsActive-19']");
	By editProfile = By.xpath("//label[@for='IsActive-263']");
	By viewContact = By.xpath("//label[@for='IsActive-20']");
	By manageContact = By.xpath("//label[@for='IsActive-21']");
	By viewAddress = By.xpath("//label[@for='IsActive-22']");
	By manageAddress = By.xpath("//label[@for='IsActive-23']");
	By viewEducation = By.xpath("//label[@for='IsActive-24']");
	By manageEducation = By.xpath("//label[@for='IsActive-25']");
	By viewIdentificationDocuments = By.xpath("//label[@for='IsActive-26']");
	By manageIdentificationDocuments = By.xpath("//label[@for='IsActive-27']");
	
	
	By btnRadioContract = By.xpath("//input[@id='IsActive-28']");
	By btnViewContract = By.xpath("//input[@id='IsActive-29']");
	By btnManageContract = By.xpath("//input[@id='IsActive-30']");
	By btnViewWorkPermit = By.xpath("//input[@id='IsActive-31']");
	By btnManageWorkPermit = By.xpath("//input[@id='IsActive-32']");
	By btnViewEmploymentData = By.xpath("//input[@id='IsActive-202']");
	By btnViewContractInfo = By.xpath("//input[@id='IsActive-33']");
		
	By radioContract = By.xpath("//label[@for='IsActive-28']");
	By viewContract = By.xpath("//label[@for='IsActive-29']");
	By manageContract = By.xpath("//label[@for='IsActive-30']");
	By viewWorkPermit = By.xpath("//label[@for='IsActive-31']");
	By manageWorkPermit = By.xpath("//label[@for='IsActive-32']");
	By viewEmploymentData = By.xpath("//label[@for='IsActive-202']");
	By viewContractInfo = By.xpath("//label[@for='IsActive-33']");
	
	By btnRadioPosition = By.xpath("//input[@id='IsActive-34']");
	By btnViewPositionHistoryList = By.xpath("//input[@id='IsActive-35']");
	By btnViewPositionAssignmentDetails = By.xpath("//input[@id='IsActive-36']");
	By btnAssignPositiontoEmployee = By.xpath("//input[@id='IsActive-37']");
	By btnUpdatePositiontoEmployeeAssignment = By.xpath("//input[@id='IsActive-38']");
	By btnDeletePositiontoEmployeeAssignment = By.xpath("//input[@id='IsActive-39']");
	
	By radioPosition = By.xpath("//label[@for='IsActive-34']");
	By viewPositionHistoryList = By.xpath("//label[@for='IsActive-35']");
	By viewPositionAssignmentDetails = By.xpath("//label[@for='IsActive-36']");
	By assignPositiontoEmployee = By.xpath("//label[@for='IsActive-37']");
	By updatePositiontoEmployeeAssignment = By.xpath("//label[@for='IsActive-38']");
	By deletePositiontoEmployeeAssignment = By.xpath("//label[@for='IsActive-39']");
	
	By btnRadioOrganizationChart = By.xpath("//input[@id='IsActive-40']");
	By btnViewOrganizationChart = By.xpath("//input[@id='IsActive-41']");

	By radioOrganizationChart = By.xpath("//label[@for='IsActive-40']");
	By viewOrganizationChart = By.xpath("//label[@for='IsActive-41']");
	
	public void clickSubTabEmployee()
	{
		waitFluentWait(subTabEmployee);
		click(subTabEmployee);
	}
	
	public void clickOFFBtnRadioEmployeeList()
	{
		String result = driver.findElement(btnRadioEmployeeList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioEmployeeList);
		 }
	}
	
	public void clickONBtnRadioEmployeeList()
	{
		String result = driver.findElement(btnRadioEmployeeList).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioEmployeeList);
		 }
	}
	
	
	public void clickOFFBtnViewEmployeeList()
	{
		String result = driver.findElement(btnViewmEployeeList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewmEployeeList);
		 }
	}
	
	public void clickONBtnViewEmployeeList()
	{
		String result = driver.findElement(btnViewmEployeeList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewmEployeeList);
		 }
	}
	
	
	public void clickOFFbtnRadioData()
	{
		String result = driver.findElement(btnRadioData).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioData);
		 }
	}
	
	public void clickONbtnRadioData()
	{
		String result = driver.findElement(btnRadioData).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioData);
		 }
	}
	
	public void clickOFFBtnRadioPersonal()
	{
		String result = driver.findElement(btnRadioPersonal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioPersonal);
		 }
	}
	
	public void clickONBtnRadioPersonal()
	{
		String result = driver.findElement(btnRadioPersonal).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioPersonal);
		 }
	}
	
	
	
	public void clickOFFBtnViewProfile()
	{
		String result = driver.findElement(btnViewProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewProfile);
		 }
	}
	
	public void clickONBtnViewProfile()
	{
		String result = driver.findElement(btnViewProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewProfile);
		 }
	}
	
	public void clickOFFBtnEditProfile()
	{
		String result = driver.findElement(btnEditProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editProfile);
		 }
	}
	
	public void clickONBtnEditProfile()
	{
		String result = driver.findElement(btnEditProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(editProfile);
		 }
	}

	public void clickOFFBtnViewContact()
	{
		String result = driver.findElement(btnViewContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContact);
		 }
	}
	
	public void clickONBtnViewContact()
	{
		String result = driver.findElement(btnViewContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContact);
		 }
	}
	
	public void clickOFFBtnViewAddress()
	{
		String result = driver.findElement(btnViewAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAddress);
		 }
	}
	
	public void clickONBtnViewAddress()
	{
		String result = driver.findElement(btnViewAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAddress);
		 }
	}
	
	public void clickOFFBtnViewIdentificationDocuments()
	{
		String result = driver.findElement(btnViewIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewIdentificationDocuments);
		 }
	}
	
	public void clickONBtnViewIdentificationDocuments()
	{
		String result = driver.findElement(btnViewIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewIdentificationDocuments);
		 }
	}
	
	public void clickOFFBtnViewEducation()
	{
		String result = driver.findElement(btnViewEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewEducation);
		 }
	}
	
	public void clickONBtnViewEducation()
	{
		String result = driver.findElement(btnViewEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewEducation);
		 }
	}
	
	public void clickOFFBtnManageContact()
	{
		String result = driver.findElement(btnManageContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageContact);
		 }
	}
	
	public void clickONBtnManageContact()
	{
		String result = driver.findElement(btnManageContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageContact);
		 }
	}
	
	public void clickOFFBtnManageAddress()
	{
		String result = driver.findElement(btnManageAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageAddress);
		 }
	}
	
	public void clickONBtnManageAddress()
	{
		String result = driver.findElement(btnManageAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageAddress);
		 }
	}
	
	public void clickOFFBtnManageIdentificationDocuments()
	{
		String result = driver.findElement(btnManageIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageIdentificationDocuments);
		 }
	}
	
	public void clickONBtnManageIdentificationDocuments()
	{
		String result = driver.findElement(btnManageIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageIdentificationDocuments);
		 }
	}
	
	public void clickOFFBtnManageEducation()
	{
		String result = driver.findElement(btnManageEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageEducation);
		 }
	}
	
	public void clickONBtnManageEducation()
	{
		String result = driver.findElement(btnManageEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageEducation);
		 }
	}
	
	public void clickOFFBtnRadioContract()
	{
		String result = driver.findElement(btnRadioContract).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioContract);
		 }
	}
	
	public void clickONBtnRadioContract()
	{
		String result = driver.findElement(btnRadioContract).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioContract);
		 }
	}
	
	public void clickOFFBtnViewContract()
	{
		String result = driver.findElement(btnViewContract).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContract);
		 }
	}
	
	public void clickONBtnViewContract()
	{
		String result = driver.findElement(btnViewContract).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContract);
		 }
	}
	
	public void clickOFFBtnManageContract()
	{
		String result = driver.findElement(btnManageContract).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageContract);
		 }
	}
	
	public void clickONBtnManageContract()
	{
		String result = driver.findElement(btnManageContract).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageContract);
		 }
	}
	
	public void clickOFFBtnViewWorkPermit()
	{
		String result = driver.findElement(btnViewWorkPermit).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewWorkPermit);
		 }
	}
	
	public void clickONBtnViewWorkPermit()
	{
		String result = driver.findElement(btnViewWorkPermit).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewWorkPermit);
		 }
	}
	
	public void clickOFFBtnManageWorkPermit()
	{
		String result = driver.findElement(btnManageWorkPermit).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageWorkPermit);
		 }
	}
	
	public void clickONBtnManageWorkPermit()
	{
		String result = driver.findElement(btnManageWorkPermit).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageWorkPermit);
		 }
	}
	
	public void clickOFFBtnViewEmploymentData()
	{
		String result = driver.findElement(btnViewEmploymentData).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewEmploymentData);
		 }
	}
	
	public void clickONBtnViewEmploymentData()
	{
		String result = driver.findElement(btnViewEmploymentData).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewEmploymentData);
		 }
	}
	
	public void clickOFFBtnViewContractInfo()
	{
		String result = driver.findElement(btnViewContractInfo).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContractInfo);
		 }
	}
	
	public void clickONBtnViewContractInfo()
	{
		String result = driver.findElement(btnViewContractInfo).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContractInfo);
		 }
	}
	
	public void clickOFFBtnRadioPosition()
	{
		String result = driver.findElement(btnRadioPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioPosition);
		 }
	}
	
	public void clickONBtnRadioPosition()
	{
		String result = driver.findElement(btnRadioPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioPosition);
		 }
	}
	
	public void clickOFFBtnViewPositionHistoryList()
	{
		String result = driver.findElement(btnViewPositionHistoryList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewPositionHistoryList);
		 }
	}
	
	public void clickONBtnViewPositionHistoryList()
	{
		String result = driver.findElement(btnViewPositionHistoryList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewPositionHistoryList);
		 }
	}
	
	public void clickOFFBtnViewPositionAssignmentDetails()
	{
		String result = driver.findElement(btnViewPositionAssignmentDetails).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewPositionAssignmentDetails);
		 }
	}
	
	public void clickONBtnViewPositionAssignmentDetails()
	{
		String result = driver.findElement(btnViewPositionAssignmentDetails).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewPositionAssignmentDetails);
		 }
	}
	
	public void clickOFFBtnAssignPositiontoEmployee()
	{
		String result = driver.findElement(btnAssignPositiontoEmployee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(assignPositiontoEmployee);
		 }
	}
	
	public void clickONBtnAssignPositiontoEmployee()
	{
		String result = driver.findElement(btnAssignPositiontoEmployee).getAttribute("checked");
		 if (result==null)
		 {
			 click(assignPositiontoEmployee);
		 }
	}
	
	public void clickOFFBtnUpdatePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnUpdatePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updatePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickONBtnUpdatePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnUpdatePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result==null)
		 {
			 click(updatePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickOFFBtnDeletePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnDeletePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deletePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickONBtnDeletePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnDeletePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result==null)
		 {
			 click(deletePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickOFFBtnRadioOrganizationChart()
	{
		String result = driver.findElement(btnRadioOrganizationChart).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioOrganizationChart);
		 }
	}
	
	public void clickONBtnRadioOrganizationChart()
	{
		String result = driver.findElement(btnRadioOrganizationChart).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioOrganizationChart);
		 }
	}
	
	public void clickOFFBtnViewOrganizationChart()
	{
		String result = driver.findElement(btnViewOrganizationChart).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewOrganizationChart);
		 }
	}
	
	public void clickONBtnViewOrganizationChart()
	{
		String result = driver.findElement(btnViewOrganizationChart).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewOrganizationChart);
		 }
	}
	
	//Talent Management >> Performance Growth
	By subTabPerformanceGrowth = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[2]");
	
	By btnRadioGoalChecking = By.xpath("//input[@id='IsActive-254']");
	By btnViewGoal = By.xpath("//input[@id='IsActive-255']");
	By btnCreateGoal = By.xpath("//input[@id='IsActive-256']");
	By btnEditGoal = By.xpath("//input[@id='IsActive-257']");
	By btnDeleteGoal = By.xpath("//input[@id='IsActive-258']");
	By btnUpdateActualGoal = By.xpath("//input[@id='IsActive-259']");
	By btnApprovePendingGoal = By.xpath("//input[@id='IsActive-260']");
	
	By radioGoalChecking = By.xpath("//label[@for='IsActive-254']");
	By viewGoal = By.xpath("//label[@for='IsActive-255']");
	By createGoal = By.xpath("//label[@for='IsActive-256']");
	By editGoal = By.xpath("//label[@for='IsActive-257']");
	By deleteGoal = By.xpath("//label[@for='IsActive-258']");
	By updateActualGoal = By.xpath("//label[@for='IsActive-259']");
	By approvePendingGoal = By.xpath("//label[@for='IsActive-260']");

	public void clickSubTabPerformanceGrowth()
	{
		waitFluentWait(subTabPerformanceGrowth);
		click(subTabPerformanceGrowth);
	}
	public void clickOFFBtnRadioGoalChecking()
	{
		String result = driver.findElement(btnRadioGoalChecking).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioGoalChecking);
		 }
	}
	public void clickONBtnRadioGoalChecking()
	{
		String result = driver.findElement(btnRadioGoalChecking).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioGoalChecking);
		 }
	}
	public void clickOFFBtnViewGoal()
	{
		String result = driver.findElement(btnViewGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewGoal);
		 }
	}
	public void clickONBtnViewGoal()
	{
		String result = driver.findElement(btnViewGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewGoal);
		 }
	}
	public void clickOFFBtnCreateGoal()
	{
		String result = driver.findElement(btnCreateGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createGoal);
		 }
	}
	public void clickONBtnCreateGoal()
	{
		String result = driver.findElement(btnCreateGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(createGoal);
		 }
	}
	public void clickOFFBtnEditGoal()
	{
		String result = driver.findElement(btnEditGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editGoal);
		 }
	}
	public void clickONBtnEditGoal()
	{
		String result = driver.findElement(btnEditGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(editGoal);
		 }
	}
	public void clickOFFBtnDeleteGoal()
	{
		String result = driver.findElement(btnDeleteGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteGoal);
		 }
	}
	public void clickONBtnDeleteGoal()
	{
		String result = driver.findElement(btnDeleteGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteGoal);
		 }
	}
	public void clickOFFBtnUpdateActualGoal()
	{
		String result = driver.findElement(btnUpdateActualGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateActualGoal);
		 }
	}
	public void clickONBtnUpdateActualGoal()
	{
		String result = driver.findElement(btnUpdateActualGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateActualGoal);
		 }
	}
	public void clickOFFBtnApprovePendingGoal()
	{
		String result = driver.findElement(btnApprovePendingGoal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(approvePendingGoal);
		 }
	}
	public void clickONBtnApprovePendingGoal()
	{
		String result = driver.findElement(btnApprovePendingGoal).getAttribute("checked");
		 if (result==null)
		 {
			 click(approvePendingGoal);
		 }
	}
	
	//Talent Management >> Talent
	By subTabTalent = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[3]");
	By subTabControlBoardTalent = By.xpath("(//div[@id='tabstripSubModuleDetail']//span[2])[2]");	
	By btnRadioCompetency = By.xpath("//input[@id='IsActive-43']");
	By btnViewTeamCompetency = By.xpath("//input[@id='IsActive-44']");
	
	By radioCompetency = By.xpath("//label[@for='IsActive-43']");
	By viewTeamCompetency = By.xpath("//label[@for='IsActive-44']");
	
	public void clickSubTabTalent()
	{
		waitFluentWait(subTabTalent);
		click(subTabTalent);
	}
	
	public void clickSubTabControlBoardTalent()
	{
		waitFluentWait(subTabControlBoardTalent);
		click(subTabControlBoardTalent);
	}

	public void clickOFFBtnRadioCompetency()
	{
		String result = driver.findElement(btnRadioCompetency).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioCompetency);
		 }
	}
	
	public void clickONBtnRadioCompetency()
	{
		String result = driver.findElement(btnRadioCompetency).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioCompetency);
		 }
	}
	
	
	public void clickOFFBtnViewTeamCompetency()
	{
		String result = driver.findElement(btnViewTeamCompetency).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewTeamCompetency);
		 }
	}
	
	public void clickONBtnViewTeamCompetency()
	{
		String result = driver.findElement(btnViewTeamCompetency).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewTeamCompetency);
		 }
	}
	
	//Control Board - System >> User
		By btnRadioUser = By.xpath("//input[@id='IsActive-54']");
		By btnViewUser = By.xpath("//input[@id='IsActive-55']");
		By btnViewUserDetail  = By.xpath("//input[@id='IsActive-56']");
		By btnCreateUser = By.xpath("//input[@id='IsActive-57']");
		By btnEditUser = By.xpath("//input[@id='IsActive-58']");
		By btnLockUnlockUser = By.xpath("//input[@id='IsActive-59']");
		By btnActiveInactiveUser  = By.xpath("//input[@id='IsActive-60']");
		
		By radioUser = By.xpath("//label[@for='IsActive-54']");
		By viewUser = By.xpath("//label[@for='IsActive-55']");
		By viewUserDetail  = By.xpath("//label[@for='IsActive-56']");
		By createUser = By.xpath("//label[@for='IsActive-57']");
		By editUser = By.xpath("//label[@for='IsActive-58']");
		By lockUnlockUser = By.xpath("//label[@for='IsActive-59']");
		By activeInactiveUser  = By.xpath("//label[@for='IsActive-60']");

		public void clickOFFbtnRadioUser()
		{
			String result = driver.findElement(btnRadioUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioUser);
			 }
		}
		
		public void clickONbtnRadioUser()
		{
			String result = driver.findElement(btnRadioUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioUser);
			 }
		}
		
		public void clickOFFbtnViewUser()
		{
			String result = driver.findElement(btnViewUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewUser);
			 }
		}
		
		public void clickONbtnViewUser()
		{
			String result = driver.findElement(btnViewUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewUser);
			 }
		}
		
		
		public void clickOFFbtnViewUserDetail()
		{
			String result = driver.findElement(btnViewUserDetail).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewUserDetail);
			 }
		}
		
		public void clickONbtnViewUserDetail()
		{
			String result = driver.findElement(btnViewUserDetail).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewUserDetail);
			 }
		}
		
		public void clickOFFbtnCreateUser()
		{
			String result = driver.findElement(btnCreateUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(createUser);
			 }
		}
		
		public void clickONbtnCreateUser()
		{
			String result = driver.findElement(btnCreateUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(createUser);
			 }
		}
		
		public void clickOFFbtnEditUser()
		{
			String result = driver.findElement(btnEditUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(editUser);
			 }
		}
		
		public void clickONbtnEditUser()
		{
			String result = driver.findElement(btnEditUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(editUser);
			 }
		}
		
		public void clickOFFbtnLockUnlockUser()
		{
			String result = driver.findElement(btnLockUnlockUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(lockUnlockUser);
			 }
		}
		
		public void clickONbtnLockUnlockUser()
		{
			String result = driver.findElement(btnLockUnlockUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(lockUnlockUser);
			 }
		}
		
		
		public void clickOFFbtnActiveInactiveUser()
		{
			String result = driver.findElement(btnActiveInactiveUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(activeInactiveUser);
			 }
		}
		
		public void clickONbtnActiveInactiveUser()
		{
			String result = driver.findElement(btnActiveInactiveUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(activeInactiveUser);
			 }
		}
		
	// Learning And Development >> Learning Content Pool
	By btnRadioLearningContentPool = By.xpath("//input[@id='IsActive-195'][@name='onoffswitch']");
	By btnViewContentList = By.xpath("//input[@id='IsActive-195'][@name='onoffswitch']");
	By btnManageContentCategory = By.xpath("//input[@id='IsActive-196']");
	By btnCreateContent = By.xpath("//input[@id='IsActive-197']");
	By btnViewContentDetail = By.xpath("//input[@id='IsActive-198']");
	By btnDeleteContent = By.xpath("//input[@id='IsActive-199']");
	By btnRejectContent = By.xpath("//input[@id='IsActive-200']");
	By btnMarkUnmarkAsMicrolearning = By.xpath("//input[@id='IsActive-201']");
	By btnEditContent = By.xpath("//input[@id='IsActive-202']");
	By btnPublishContent = By.xpath("//input[@id='IsActive-202']");
	
	By radioLearningContentPool = By.xpath("//label[@for='IsActive-195']");
	By viewContentList = By.xpath("//label[@for='IsActive-195']");
	By manageContentList = By.xpath("//label[@for='IsActive-196']");
	By createContent = By.xpath("//label[@for='IsActive-197']");
	By viewContentDetail = By.xpath("//label[@for='IsActive-198']");
	By deleteContent = By.xpath("//label[@for='IsActive-199']");
	By rejectContent = By.xpath("//label[@for='IsActive-200']");
	By markUnmarkAsMicrolearning = By.xpath("//label[@for='IsActive-201']");
	By editContent = By.xpath("//label[@for='IsActive-202']");
	By publishContent = By.xpath("//label[@for='IsActive-202']");
	
	public void clickOFFbtnRadioLearningContentPool()
	{
		String result = driver.findElement(btnRadioLearningContentPool).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioLearningContentPool);
		 }
	}
	
	public void clickONbtnRadioLearningContentPool()
	{
		String result = driver.findElement(btnRadioLearningContentPool).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioLearningContentPool);
		 }
	}
	
	public void clickOFFBtnViewContentList()
	{
		String result = driver.findElement(btnViewContentList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContentList);
		 }
	}
	
	public void clickONBtnViewContentList()
	{
		String result = driver.findElement(btnViewContentList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContentList);
		 }
	}
	
	public void clickOFFBtnManageContentCategory()
	{
		String result = driver.findElement(btnManageContentCategory).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageContentList);
		 }
	}
	
	public void clickONBtnManageContentCategory()
	{
		String result = driver.findElement(btnManageContentCategory).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageContentList);
		 }
	}
	
	public void clickOFFBtnCreateContent()
	{
		String result = driver.findElement(btnCreateContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(createContent);
		 }
	}
	
	public void clickONBtnCreateContent()
	{
		String result = driver.findElement(btnCreateContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(createContent);
		 }
	}
	
	public void clickOFFBtnViewContentDetail()
	{
		String result = driver.findElement(btnViewContentDetail).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContentDetail);
		 }
	}
	
	public void clickONBtnViewContentDetail()
	{
		String result = driver.findElement(btnViewContentDetail).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContentDetail);
		 }
	}
	
	public void clickOFFBtnDeleteContent()
	{
		String result = driver.findElement(btnDeleteContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteContent);
		 }
	}
	
	public void clickONBtnDeleteContent()
	{
		String result = driver.findElement(btnDeleteContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteContent);
		 }
	}
	
	public void clickOFFBtnRejectContent()
	{
		String result = driver.findElement(btnRejectContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectContent);
		 }
	}
	
	public void clickONBtnRejectContent()
	{
		String result = driver.findElement(btnRejectContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectContent);
		 }
	}
	
	public void clickOFFBtnMarkUnmarkAsMicrolearning()
	{
		String result = driver.findElement(btnMarkUnmarkAsMicrolearning).getAttribute("checked");
		 if (result!=null)
		 {
			 click(markUnmarkAsMicrolearning);
		 }
	}
	
	public void clickONBtnMarkUnmarkAsMicrolearning()
	{
		String result = driver.findElement(btnMarkUnmarkAsMicrolearning).getAttribute("checked");
		 if (result==null)
		 {
			 click(markUnmarkAsMicrolearning);
		 }
	}
	
	public void clickOFFBtnEditContent()
	{
		String result = driver.findElement(btnEditContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editContent);
		 }
	}
	
	public void clickONBtnEditContent()
	{
		String result = driver.findElement(btnEditContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnEditContent);
		 }
	}
	
	public void clickOFFbtnPublishContent()
	{
		String result = driver.findElement(btnPublishContent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(publishContent);
		 }
	}
	
	public void clickONbtnPublishContent()
	{
		String result = driver.findElement(btnPublishContent).getAttribute("checked");
		 if (result==null)
		 {
			 click(publishContent);
		 }
	}
	
	//My Space
	By subTabMyTalent = By.xpath("(//div[@id='tabstripSubModuleDetail']//li)[1]");
	By subTabMyData = By.xpath("(//div[@id='tabstripSubModuleDetail']//li)[3]");
	By subTabMyContribution = By.xpath("(//div[@id='tabstripSubModuleDetail']//li)[4]");
	By subTabPendingforApproval = By.xpath("(//div[@id='tabstripSubModuleDetail']//li)[5]");
	
	public void clickSubTabMyTalent()
	{
		waitFluentWait(subTabMyTalent);
		click(subTabMyTalent);
	}
	
	public void clickSubTabMyData()
	{
		waitFluentWait(subTabMyData);
		click(subTabMyData);
	}
	
	public void clickSubTabMyContribution()
	{
		waitFluentWait(subTabMyContribution);
		click(subTabMyContribution);
	}
	
	public void clickSubTabPendingforApproval()
	{
		waitFluentWait(subTabPendingforApproval);
		click(subTabPendingforApproval);
	}
	
	//My Skill 360	
	By btnRadioMySkill360  = By.xpath("//input[@id='IsActive-209']");
	By btnViewMySkill360 = By.xpath("//input[@id='IsActive-220']");
	By btnKeepLearning= By.xpath("//input[@id='IsActive-221']");
	
	By radioMySkill360  = By.xpath("//label[@for='IsActive-209']");
	By viewMySkill360 = By.xpath("//label[@for='IsActive-220']");
	By viewKeepLearning = By.xpath("//label[@for='IsActive-221']");
	
	public void clickOFFbtnRadioMySkill360()
	{
		String result = driver.findElement(btnRadioMySkill360).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMySkill360);
		 }
	}
	
	public void clickONbtnRadioMySkill360()
	{
		String result = driver.findElement(btnRadioMySkill360).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMySkill360);
		 }
	}
	

	public void clickOFFbtnMyViewSkill360()
	{
		String result = driver.findElement(btnViewMySkill360).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMySkill360);
		 }
	}
	
	public void clickONbtnViewMySkill360()
	{
		String result = driver.findElement(btnKeepLearning).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewKeepLearning);
		 }
	}
	
	public void clickOFFbtnKeepLearning()
	{
		String result = driver.findElement(btnKeepLearning).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewKeepLearning);
		 }
	}
	
	public void clickONbtnKeepLearning()
	{
		String result = driver.findElement(btnViewMySkill360).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMySkill360);
		 }
	}
	
	//My Skill
	By btnRadioMySkills = By.xpath("//input[@id='IsActive-210']");
	By btnViewMySkills = By.xpath("//input[@id='IsActive-222']");
		
	By radioMySkills = By.xpath("//label[@for='IsActive-210']");
	By viewMySkills = By.xpath("//label[@for='IsActive-222']");	

	public void clickOFFbtnRadioMySkills()
	{
		String result = driver.findElement(btnRadioMySkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMySkills);
		 }
	}
	
	public void clickONbtnRadioMySkills()
	{
		String result = driver.findElement(btnRadioMySkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMySkills);
		 }
	}
	
	
	public void clickOFFbtnViewMySkills()
	{
		String result = driver.findElement(btnViewMySkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMySkills);
		 }
	}
	
	public void clickONbtnViewMySkills()
	{
		String result = driver.findElement(btnViewMySkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMySkills);
		 }
	}
	
	//My Career Path
	By btnRadioMyCareerPath = By.xpath("//input[@id='IsActive-211']");
	By btnViewMyCareerPath  = By.xpath("//input[@id='IsActive-223']");
	By btnCareerKeepLearning = By.xpath("//input[@id='IsActive-224']");
	By btnManagePersonalCareerPath = By.xpath("//input[@id='IsActive-225']");
		
	By radioMyCareerPath = By.xpath("//label[@for='IsActive-211']");
	By myCareerPath  = By.xpath("//label[@for='IsActive-223']");	
	By careerKeepLearning = By.xpath("//label[@for='IsActive-224']");	
	By managePersonalCareerPath = By.xpath("//label[@for='IsActive-225']");	
	
	public void clickOFFbtnRadioMyCareerPath()
	{
		String result = driver.findElement(btnRadioMyCareerPath).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyCareerPath);
		 }
	}
	
	public void clickONbtnRadioMyCareerPath()
	{
		String result = driver.findElement(btnRadioMyCareerPath).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyCareerPath);
		 }
	}
	
	public void clickOFFbtnViewMyCareerPath()
	{
		String result = driver.findElement(btnViewMyCareerPath).getAttribute("checked");
		 if (result!=null)
		 {
			 click(myCareerPath);
		 }
	}
	
	public void clickONbtnViewMyCareerPath()
	{
		String result = driver.findElement(btnViewMyCareerPath).getAttribute("checked");
		 if (result==null)
		 {
			 click(myCareerPath);
		 }
	}
	
	public void clickOFFbtnCareerKeepLearning()
	{
		String result = driver.findElement(btnCareerKeepLearning).getAttribute("checked");
		 if (result!=null)
		 {
			 click(careerKeepLearning);
		 }
	}
	
	public void clickONbtnCareerKeepLearning()
	{
		String result = driver.findElement(btnCareerKeepLearning).getAttribute("checked");
		 if (result==null)
		 {
			 click(careerKeepLearning);
		 }
	}
	
	public void clickOFFbtnManagePersonalCareerPath()
	{
		String result = driver.findElement(btnManagePersonalCareerPath).getAttribute("checked");
		 if (result!=null)
		 {
			 click(managePersonalCareerPath);
		 }
	}
	
	public void clickONbtnManagePersonalCareerPath()
	{
		String result = driver.findElement(btnManagePersonalCareerPath).getAttribute("checked");
		 if (result==null)
		 {
			 click(managePersonalCareerPath);
		 }
	}
	
	//My Data - Personal Data
	By btnRadioMyPersonal  = By.xpath("//input[@id='IsActive-212']");
	
	By btnViewMyProfile = By.xpath("//input[@id='IsActive-226']");
	By btnEditMyProfile = By.xpath("//input[@id='IsActive-227']");
	
	
	By btnViewMyAddress = By.xpath("//input[@id='IsActive-228']");
	By btnManageMyAddress = By.xpath("//input[@id='IsActive-229']");
	
	By btnViewMyIdentificationDocuments = By.xpath("//input[@id='IsActive-230']");
	By btnManageMyIdentificationDocuments = By.xpath("//input[@id='IsActive-231']");
	
	By btnViewMyEducation = By.xpath("//input[@id='IsActive-232']");
	By btnManageMyEducation = By.xpath("//input[@id='IsActive-233']");
		
	By btnViewMyContact = By.xpath("//input[@id='IsActive-234']");
	By btnManageMyContact = By.xpath("//input[@id='IsActive-235']");
	
	By radioMyPersonal  = By.xpath("//label[@for='IsActive-212']");
	
	By viewMyProfile = By.xpath("//label[@for='IsActive-226']");
	By editMyProfile = By.xpath("//label[@for='IsActive-227']");
	
	By viewMyAddress = By.xpath("//label[@for='IsActive-228']");
	By manageMyAddress = By.xpath("//label[@for='IsActive-229']");
	
	By viewMyEducation = By.xpath("//label[@for='IsActive-230']");
	By manageMyEducation = By.xpath("//label[@for='IsActive-231']");
	
	By viewMyContact = By.xpath("//label[@for='IsActive-232']");
	By manageMyContact = By.xpath("//label[@for='IsActive-233']");
		
	By viewMyIdentificationDocuments = By.xpath("//label[@for='IsActive-234']");
	By manageMyIdentificationDocuments = By.xpath("//label[@for='IsActive-235']");
		
	public void clickOFFBtnRadioMyPersonal()
	{
		String result = driver.findElement(btnRadioMyPersonal).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyPersonal);
		 }
	}
	
	public void clickONBtnRadioMyPersonal()
	{
		String result = driver.findElement(btnRadioMyPersonal).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyPersonal);
		 }
	}
	
	public void clickOFFbtnViewMyProfile()
	{
		String result = driver.findElement(btnViewMyProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyProfile);
		 }
	}
	
	public void clickONbtnViewMyProfile()
	{
		String result = driver.findElement(btnViewMyProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyProfile);
		 }
	}
	

	public void clickOFFbtnEditMyProfile()
	{
		String result = driver.findElement(btnEditMyProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editMyProfile);
		 }
	}
	
	public void clickONbtnEditMyProfile()
	{
		String result = driver.findElement(btnEditMyProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(editMyProfile);
		 }
	}

	public void clickOFFbtnViewMyContact()
	{
		String result = driver.findElement(btnViewMyContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyContact);
		 }
	}
	
	public void clickONbtnViewMyContact()
	{
		String result = driver.findElement(btnViewMyContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyContact);
		 }
	}
	
	public void clickOFFbtnViewMyAddress()
	{
		String result = driver.findElement(btnViewMyAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyAddress);
		 }
	}
	
	public void clickONbtnViewMyAddress()
	{
		String result = driver.findElement(btnViewMyAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyAddress);
		 }
	}
	
	public void clickOFFbtnViewMyIdentificationDocuments()
	{
		String result = driver.findElement(btnViewMyIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyIdentificationDocuments);
		 }
	}
	
	public void clickONbtnViewMyIdentificationDocuments()
	{
		String result = driver.findElement(btnViewMyIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyIdentificationDocuments);
		 }
	}
	
	public void clickOFFbtnViewMyEducation()
	{
		String result = driver.findElement(btnViewMyEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyEducation);
		 }
	}
	
	public void clickONbtnViewMyEducation()
	{
		String result = driver.findElement(btnViewMyEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyEducation);
		 }
	}
	
	public void clickOFFbtnManageMyContact()
	{
		String result = driver.findElement(btnManageMyContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageMyContact);
		 }
	}
	
	public void clickONbtnManageMyContact()
	{
		String result = driver.findElement(btnManageMyContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageMyContact);
		 }
	}
	
	public void clickOFFbtnManageMyAddress()
	{
		String result = driver.findElement(btnManageMyAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageMyAddress);
		 }
	}
	
	public void clickONbtnManageMyAddress()
	{
		String result = driver.findElement(btnManageMyAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageMyAddress);
		 }
	}
	

	public void clickOFFbtnManageMyIdentificationDocuments()
	{
		String result = driver.findElement(btnManageMyIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageMyIdentificationDocuments);
		 }
	}
	
	public void clickONbtnManageMyIdentificationDocuments()
	{
		String result = driver.findElement(btnManageMyIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageMyIdentificationDocuments);
		 }
	}
	
	public void clickOFFbtnManageMyEducation()
	{
		String result = driver.findElement(btnManageMyEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageMyEducation);
		 }
	}
	
	public void clickONbtnManageMyEducation()
	{
		String result = driver.findElement(btnManageMyEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageMyEducation);
		 }
	}
	
	//My Talent >> Contract
	By btnRadioMyContract = By.xpath("//input[@id='IsActive-213']");
	By btnViewMyEmployment = By.xpath("//input[@id='IsActive-236']");
	By btnViewMyWorkPermit = By.xpath("//input[@id='IsActive-237']");
	
	By radioMyContract = By.xpath("//label[@for='IsActive-213']");
	By viewMyEmployment = By.xpath("//label[@for='IsActive-236']");
	By viewMyWorkPermit = By.xpath("//label[@for='IsActive-237']");
	
	public void clickOFFbtnRadioMyContract()
	{
		String result = driver.findElement(btnRadioMyContract).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyContract);
		 }
	}
	
	public void clickONbtnRadioMyContract()
	{
		String result = driver.findElement(btnRadioMyContract).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyContract);
		 }
	}
		
	public void clickOFFbtnViewMyEmployment()
	{
		String result = driver.findElement(btnViewMyEmployment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyEmployment);
		 }
	}
	
	public void clickONbtnViewMyEmployment()
	{
		String result = driver.findElement(btnViewMyEmployment).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyEmployment);
		 }
	}
	
	public void clickOFFbtnViewMyWorkPermit()
	{
		String result = driver.findElement(btnViewMyWorkPermit).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewMyWorkPermit);
		 }
	}
	
	public void clickONbtnMyViewWorkPermit()
	{
		String result = driver.findElement(btnViewMyWorkPermit).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewMyWorkPermit);
		 }
	}
	
	//My Talent >> Position Data
		By btnRadioMyPositionData = By.xpath("//input[@id='IsActive-214']");
		By btnViewMyPositionHistoryDetails = By.xpath("//input[@id='IsActive-238']");
		
		By radioMyPositionData = By.xpath("//label[@for='IsActive-214']");
		By viewMyPositionHistoryDetails = By.xpath("//label[@for='IsActive-238']");
			
		public void clickOFFbtnRadioMyPositionData()
		{
			String result = driver.findElement(btnRadioMyPositionData).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioMyPositionData);
			 }
		}
		
		public void clickONbtnRadioMyPositionData()
		{
			String result = driver.findElement(btnRadioMyPositionData).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioMyPositionData);
			 }
		}
			
		public void clickOFFbtnViewMyPositionHistoryDetails()
		{
			String result = driver.findElement(btnViewMyPositionHistoryDetails).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewMyPositionHistoryDetails);
			 }
		}
		
		public void clickONbtnViewMyPositionHistoryDetails()
		{
			String result = driver.findElement(btnViewMyPositionHistoryDetails).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewMyPositionHistoryDetails);
			 }
		}
		
		//My Talent >> Organization Chart
		By btnRadioMyOrganizationChart = By.xpath("//input[@id='IsActive-215']");
		By btnViewMyOrganizationChart = By.xpath("//input[@id='IsActive-239']");
				
		By radioMyOrganizationChart = By.xpath("//label[@for='IsActive-215']");
		By viewMyOrganizationOhart = By.xpath("//label[@for='IsActive-239']");
				
		public void clickOFFbtnRadioMyOrganizationChart()
		{
			String result = driver.findElement(btnRadioMyOrganizationChart).getAttribute("checked");
			 if (result!=null)
			 {
				 click(radioMyOrganizationChart);
			 }
		}
		
		public void clickONbtnRadioMyOrganizationChart()
		{
			String result = driver.findElement(btnRadioMyOrganizationChart).getAttribute("checked");
			 if (result==null)
			 {
				 click(radioMyOrganizationChart);
			 }
		}
			
		public void clickOFFbtnViewMyOrganizationChart()
		{
			String result = driver.findElement(btnViewMyOrganizationChart).getAttribute("checked");
			 if (result!=null)
			 {
				 click(viewMyOrganizationOhart);
			 }
		}
		
		public void clickONbtnViewMyOrganizationChart()
		{
			String result = driver.findElement(btnViewMyOrganizationChart).getAttribute("checked");
			 if (result==null)
			 {
				 click(viewMyOrganizationOhart);
			 }
		}
			
	//My Space >> My Contribution >> Questions
	By btnRadioMyQuestionsContribution  = By.xpath("//input[@id='IsActive-216']");
	By btnViewQuestionContribution  = By.xpath("//input[@id='IsActive-240']");
	By btnContributionQuestion  = By.xpath("//input[@id='IsActive-241']");
	
	By radioMyQuestionsContribution  = By.xpath("//label[@for='IsActive-216']");
	By viewQuestionContribution  = By.xpath("//label[@for='IsActive-240']");
	By contributionQuestion  = By.xpath("//label[@for='IsActive-241']");
		
	public void clickOFFbtnRadioMyQuestionsContribution()
	{
		String result = driver.findElement(btnRadioMyQuestionsContribution).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyQuestionsContribution);
		 }
	}
	
	public void clickONbtnRadioMyQuestionsContribution()
	{
		String result = driver.findElement(btnRadioMyQuestionsContribution).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyQuestionsContribution);
		 }
	}
	
	
	public void clickOFFbtnViewQuestionContribution()
	{
		String result = driver.findElement(btnViewQuestionContribution).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewQuestionContribution);
		 }
	}
	
	public void clickONbtnViewQuestionContribution()
	{
		String result = driver.findElement(btnViewQuestionContribution).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewQuestionContribution);
		 }
	}
	
	public void clickOFFbtnContributionQuestion()
	{
		String result = driver.findElement(btnContributionQuestion).getAttribute("checked");
		 if (result!=null)
		 {
			 click(contributionQuestion);
		 }
	}
	
	public void clickONbtnContributionQuestion()
	{
		String result = driver.findElement(btnContributionQuestion).getAttribute("checked");
		 if (result==null)
		 {
			 click(contributionQuestion);
		 }
	}
	
	
	//My Space >> Pending Approvals >> Questions
	By btnRadioMyQuestionsPendingApprovals = By.xpath("//input[@id='IsActive-217']");
	By btnViewQuestionApprovals = By.xpath("//input[@id='IsActive-242']");
	By btnApprovemassApproveQuestions = By.xpath("//input[@id='IsActive-243']");
	By btnRejectmassRejectQuestions = By.xpath("//input[@id='IsActive-244']");
	
	By radioMyQuestionsPendingApprovals = By.xpath("//label[@for='IsActive-217']");
	By viewQuestionApprovals = By.xpath("//label[@for='IsActive-242']");
	By approvemassApproveQuestions = By.xpath("//label[@for='IsActive-243']");
	By rejectmassRejectQuestions = By.xpath("//label[@for='IsActive-244']");	
	
	public void clickOFFbtnRadioMyQuestionsPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyQuestionsPendingApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyQuestionsPendingApprovals);
		 }
	}
	
	public void clickONbtnRadioMyQuestionsPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyQuestionsPendingApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyQuestionsPendingApprovals);
		 }
	}
	
	public void clickOFFbtnViewQuestionApprovals()
	{
		String result = driver.findElement(btnViewQuestionApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewQuestionApprovals);
		 }
	}
	
	public void clickONbtnViewQuestionApprovals()
	{
		String result = driver.findElement(btnViewQuestionApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewQuestionApprovals);
		 }
	}

	public void clickOFFbtnApprovemassApproveQuestions()
	{
		String result = driver.findElement(btnApprovemassApproveQuestions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(approvemassApproveQuestions);
		 }
	}
	
	public void clickONbtnApprovemassApproveQuestions()
	{
		String result = driver.findElement(btnApprovemassApproveQuestions).getAttribute("checked");
		 if (result==null)
		 {
			 click(approvemassApproveQuestions);
		 }
	}
	
	public void clickOFFbtnRejectmassRejectQuestions()
	{
		String result = driver.findElement(btnRejectmassRejectQuestions).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectmassRejectQuestions);
		 }
	}
	
	public void clickONbtnRejectmassRejectQuestions()
	{
		String result = driver.findElement(btnRejectmassRejectQuestions).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectmassRejectQuestions);
		 }
	}
	
	//My Space >> Pending Approvals >> Assessment 
	By btnRadioMyAssessmentPendingApprovals = By.xpath("//input[@id='IsActive-218']");
	By btnViewAssessmentApprovals = By.xpath("//input[@id='IsActive-245']");
	By btnApproveMassAssessment = By.xpath("//input[@id='IsActive-246']");
	By btnRejectMassAssessment = By.xpath("//input[@id='IsActive-247']");
	
	By radioMyAssessmentPendingApprovals = By.xpath("//label[@for='IsActive-218']");
	By viewAssessmentApprovals = By.xpath("//label[@for='IsActive-245']");
	By approveMassAssessment = By.xpath("//label[@for='IsActive-246']");
	By rejectMassAssessment = By.xpath("//label[@for='IsActive-247']");
	

	public void clickOFFbtnRadioMyAssessmentPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyAssessmentPendingApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyAssessmentPendingApprovals);
		 }
	}
	
	public void clickONbtnRadioMyAssessmentPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyAssessmentPendingApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyAssessmentPendingApprovals);
		 }
	}
	
	public void clickOFFbtnViewAssessmentApprovals()
	{
		String result = driver.findElement(btnViewAssessmentApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewAssessmentApprovals);
		 }
	}
	
	public void clickONbtnViewAssessmentApprovals()
	{
		String result = driver.findElement(btnViewAssessmentApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewAssessmentApprovals);
		 }
	}
	
	public void clickOFFbtnApproveMassAssessment()
	{
		String result = driver.findElement(btnApproveMassAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(approveMassAssessment);
		 }
	}
	
	public void clickONbtnApproveMassAssessment()
	{
		String result = driver.findElement(btnApproveMassAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(approveMassAssessment);
		 }
	}
		
	public void clickOFFbtnRejectMassAssessment()
	{
		String result = driver.findElement(btnRejectMassAssessment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectMassAssessment);
		 }
	}
	
	public void clickONbtnRejectMassAssessment()
	{
		String result = driver.findElement(btnRejectMassAssessment).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectMassAssessment);
		 }
	}
	
	//My Space >> Pending Approvals >> Assessment Result
	By btnRadioMyAssessmentResults = By.xpath("//input[@id='IsActive-219']");
	By btnViewAssessmentResultApprovals	 = By.xpath("//input[@id='IsActive-248']");
	By btnApprovemassApproveAssessmentResults = By.xpath("//input[@id='IsActive-249']");
	By btnRejectmassRejectAssessmentResults = By.xpath("//input[@id='IsActive-250']");
	
	By radioMyAssessmentResults = By.xpath("//label[@for='IsActive-219']");
	By viewAssessmentResultApprovals	 = By.xpath("//label[@for='IsActive-248']");
	By approvemassApproveAssessmentResults = By.xpath("//label[@for='IsActive-249']");
	By rejectmassRejectAssessmentResults = By.xpath("//label[@for='IsActive-250']");
	
	public void clickOFFbtnRadioMyAssessmentResults()
	{
		String result = driver.findElement(btnRadioMyAssessmentResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyAssessmentResults);
		 }
	}
	
	public void clickONbtnRadioMyAssessmentResults()
	{
		String result = driver.findElement(btnRadioMyAssessmentResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyAssessmentResults);
		 }
	}

	public void clickOFFbtnViewAssessmentResultApprovals()
	{
		String result = driver.findElement(btnViewAssessmentResultApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAssessmentResultApprovals);
		 }
	}
	
	public void clickONbtnViewAssessmentResultApprovals()
	{
		String result = driver.findElement(btnViewAssessmentResultApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAssessmentResultApprovals);
		 }
	}
	
	public void clickOFFbtnApprovemassApproveAssessmentResults()
	{
		String result = driver.findElement(btnApprovemassApproveAssessmentResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(approvemassApproveAssessmentResults);
		 }
	}
	
	public void clickONbtnApprovemassApproveAssessmentResults()
	{
		String result = driver.findElement(btnApprovemassApproveAssessmentResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(approvemassApproveAssessmentResults);
		 }
	}

	public void clickOFFbtnRejectmassRejectAssessmentResults()
	{
		String result = driver.findElement(btnRejectmassRejectAssessmentResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectmassRejectAssessmentResults);
		 }
	}
	
	public void clickONbtnRejectmassRejectAssessmentResults()
	{
		String result = driver.findElement(btnRejectmassRejectAssessmentResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectmassRejectAssessmentResults);
		 }
	}
	
	//Button	
	By btnCancel = By.id("btnCancel");
	By btnSave = By.id("btnSave");
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	By btnCollapse = By.xpath("(//span[@title='Collapse'])[1]");
	By btnCollapse2 = By.xpath("(//span[@title='Collapse'])[2]");
	public void clickBtnCollapse()
	{
		waitFluentWait(btnCollapse);
		click(btnCollapse);
	}
	
	public void clickBtn2ndCollapse()
	{
		waitFluentWait(btnCollapse2);
		click(btnCollapse2);
	}
}
