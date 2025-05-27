package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditFunctionSet extends WebActions {

	public Form_EditFunctionSet(WebDriver driver) {
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
	By tabDashBoard = By.xpath("(//form[@id='frmDetailFunctionSet']//a)[1]");
	By tabAssessment = By.xpath("(//form[@id='frmDetailFunctionSet']//a)[2]");
	By tabControlBoardTalent = By.xpath("(//form[@id='frmDetailFunctionSet']//a)[3]");
	By tabSystemSettings = By.xpath("(//form[@id='frmDetailFunctionSet']//a)[4]");
	By tabTalentManagement = By.xpath("(//form[@id='frmDetailFunctionSet']//a)[5]");
	By tabLearningAndDevelopment= By.xpath("(//form[@id='frmDetailFunctionSet']//a)[6]");
	
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
	
	public void clickTabControlBoardTalent()
	{
		waitFluentWait(tabControlBoardTalent);
		click(tabControlBoardTalent);
	}
	
	public void clickTabTalentManagement()
	{
		waitFluentWait(tabTalentManagement);
		click(tabTalentManagement);
	}
	
	public void clickTabSystemSettings()
	{
		waitFluentWait(tabSystemSettings);
		click(tabSystemSettings);
	}
	
	public void clicktabLearningAndDevelopment()
	{
		waitFluentWait(tabLearningAndDevelopment);
		click(tabLearningAndDevelopment);
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
		String result = driver.findElement(cboxCustomization).getAttribute("checked");
		if (result==null)
		{
			click(cboxCustomization);
			if(checkBtnYesAvailble()== true)
			{
				clickBtnYes();
			}
		}
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
		String result = driver.findElement(cboxSubCustomization).getAttribute("checked");
		if (result==null)
		{
			click(cboxSubCustomization);
			if(checkBtnYesAvailble()== true)
			{
				clickBtnYes();
			}
		}
		
	}
	
	//Dashboard >> Dashboard Views
	By subTabDashboardViews = By.xpath("(//ul[@id='subModuleList']//a)[2]");
	
	public void clickSubTabDashboardViews()
	{
		waitFluentWait(subTabDashboardViews);
		click(subTabDashboardViews);
	}
	
	By btnViewFrontlineManagerDashboard = By.xpath("//input[@id='IsActive-204']");
	By btnViewSkillAssessmentDashboard = By.xpath("//input[@id='IsActive-205']");
			
	By viewFrontlineManagerDashboard = By.xpath("//label[@for='IsActive-204']");
	By viewSkillAssessmentDashboard = By.xpath("//label[@for='IsActive-205']");
	
	public void clickOFFBtnViewFrontlineManagerDashboard()
	{
		String result = driver.findElement(btnViewFrontlineManagerDashboard).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewFrontlineManagerDashboard);
		 }
	}
	
	
	public void clickONBtnViewFrontlineManagerDashboard()
	{
		String result = driver.findElement(btnViewFrontlineManagerDashboard).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewFrontlineManagerDashboard);
		 }
	}
	
	public void clickOFFBtnViewSkillAssessmentDashboard()
	{
		String result = driver.findElement(btnViewSkillAssessmentDashboard).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewSkillAssessmentDashboard);
		 }
	}
	
	
	public void clickONBtnViewSkillAssessmentDashboard()
	{
		String result = driver.findElement(btnViewSkillAssessmentDashboard).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewSkillAssessmentDashboard);
		 }
	}
	
	//Assessment >> QuestionPool
	By subTabQuestionPool = By.xpath("(//ul[@id='subModuleList']//a)[1]");
	
	public void clickSubTabQuestionPool()
	{
		waitFluentWait(subTabQuestionPool);
		click(subTabQuestionPool);
	}
	
	By btnViewQuestionList = By.xpath("//input[@id='IsActive-4']");
	By btnManageQuestionCategory = By.xpath("//input[@id='IsActive-5']");
	By btnCreateQuestion = By.xpath("//input[@id='IsActive-6']");
	By btnViewQuestionContent = By.xpath("//input[@id='IsActive-7']");
	By btnDeleteQuestion = By.xpath("//input[@id='IsActive-8']");
	By btnRejectQuestion  = By.xpath("//input[@id='IsActive-9']");
	By btnMoveQuestion  = By.xpath("//input[@id='IsActive-10']");
	By btnViewTrainingMaterial   = By.xpath("//input[@id='IsActive-11']");
	
	By viewQuestionList = By.xpath("//label[@for='IsActive-4']");
	By manageQuestionCategory = By.xpath("//label[@for='IsActive-5']");
	By createQuestion = By.xpath("//label[@for='IsActive-6']");
	By viewQuestionContent = By.xpath("//label[@for='IsActive-7']");
	By deleteQuestion = By.xpath("//label[@for='IsActive-8']");
	By rejectQuestion  = By.xpath("//label[@for='IsActive-9']");
	By moveQuestion  = By.xpath("//label[@for='IsActive-10']");
	By viewTrainingMaterial   = By.xpath("//label[@for='IsActive-11']");
	
	
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
	

	public void clickOFFbtnViewTrainingMaterial()
	{
		String result = driver.findElement(btnViewTrainingMaterial).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewTrainingMaterial);
		 }
	}
	
	public void clickONbtnViewTrainingMaterial()
	{
		String result = driver.findElement(btnViewTrainingMaterial).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewTrainingMaterial);
		 }
	}
	
	//Assessment >> Assessment - Settings >> General settings
	By subTabAssessmentSettings = By.xpath("(//ul[@id='subModuleList']//a)[2]");
	By btnRadioGeneralSettings = By.xpath("//input[@id='IsActive-13']");
	By btnViewAssessmentList = By.xpath("//input[@id='IsActive-14']");
	By btnManageAssessmentCategory = By.xpath("//input[@id='IsActive-15']");
	By btnCreateAssessment = By.xpath("//input[@id='IsActive-16']");
	By btnEditAssessmentSettings = By.xpath("//input[@id='IsActive-17']");
	By btnDeleteAssessment = By.xpath("//input[@id='IsActive-18']");
	
	By radioGeneralSettings = By.xpath("//label[@for='IsActive-13']");
	By viewAssessmentList = By.xpath("//label[@for='IsActive-14']");
	By manageAssessmentCategory = By.xpath("//label[@for='IsActive-15']");
	By createAssessment = By.xpath("//label[@for='IsActive-16']");
	By editAssessmentSettings = By.xpath("//label[@for='IsActive-17']");
	By deleteAssessment = By.xpath("//label[@for='IsActive-18']");
	
	public void clickSubTabAssessmentSettings()
	{
		waitFluentWait(subTabAssessmentSettings);
		click(subTabAssessmentSettings);
	}
	
	
	
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
	By btnRadioAssessmentSchedule = By.xpath("//input[@id='IsActive-19']");
	By btnViewSchedulelist = By.xpath("//input[@id='IsActive-20']");
	By btnCreateTestSchedule  = By.xpath("//input[@id='IsActive-21']");
	By btnEditTestSchedule = By.xpath("//input[@id='IsActive-22']");
	By btnCancelTestSchedule  = By.xpath("//input[@id='IsActive-23']");
	By btnAssignAttendee = By.xpath("//input[@id='IsActive-24']");
	By btnRemoveAttendee = By.xpath("//input[@id='IsActive-25']");
	By btnViewTestReportTestSchedule = By.xpath("//input[@id='IsActive-26']");
	By btnViewAttendeeListTestSchedule = By.xpath("//input[@id='IsActive-27']");
	
	By radioAssessmentSchedule = By.xpath("//label[@for='IsActive-19']");
	By viewSchedulelist = By.xpath("//label[@for'=IsActive-20']");
	By createTestSchedule  = By.xpath("//label[@for='IsActive-21']");
	By editTestSchedule = By.xpath("//label[@for='IsActive-22']");
	By cancelTestSchedule  = By.xpath("//label[@for='IsActive-23']");
	By assignAttendee = By.xpath("//label[@for='IsActive-24']");
	By removeAttendee = By.xpath("//label[@for='IsActive-25']");
	By viewTestReportTestSchedule = By.xpath("//label[@for='IsActive-26']");
	By viewAttendeeListTestSchedule = By.xpath("//label[@for='IsActive-27']");
	
	
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
	By btnRadioAttendeelist  = By.xpath("//input[@id='IsActive-28']");
	By btViewAttendeeList = By.xpath("//input[@id='IsActive-29']");
	By btnViewAssessmentReportAttendeeList  = By.xpath("//input[@id='IsActive-30']");
	
	By radioAttendeelist  = By.xpath("//label[@for='IsActive-28']");
	By viewAttendeeList = By.xpath("//label[@for='IsActive-29']");
	By viewAssessmentReportAttendeeList  = By.xpath("//label[@for='IsActive-30']");
	
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
	
	//Assessment >> Assessment - Learner >> Test Library
	By subTabAssessmentLearner = By.xpath("(//ul[@id='subModuleList']//a)[3]");
	By btnRadioTestLibrary = By.xpath("//input[@id='IsActive-32']");
	By btnViewTestLibrary = By.xpath("//input[@id='IsActive-33']");
	
	By radioTestLibrary = By.xpath("//label[@for='IsActive-32']");
	By viewTestLibrary = By.xpath("//label[@for='IsActive-33']");
	
	public void clickSubTabAssessmentLearner()
	{
		waitFluentWait(subTabAssessmentLearner);
		click(subTabAssessmentLearner);
	}
	
	public void clickOFFbtnRadioTestLibrary()
	{
		String result = driver.findElement(btnRadioTestLibrary).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioTestLibrary);
		 }
	}
	
	public void clickONbtnRadioTestLibrary()
	{
		String result = driver.findElement(btnRadioTestLibrary).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioTestLibrary);
		 }
	}
	
	

	public void clickOFFbtnViewTestLibrary()
	{
		String result = driver.findElement(btnViewTestLibrary).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewTestLibrary);
		 }
	}
	
	public void clickONbtnViewTestLibrary()
	{
		String result = driver.findElement(btnViewTestLibrary).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewTestLibrary);
		 }
	}
		
	//Assessment >> Assessment - Learner >> My Test
	By btnRadioMyTest = By.xpath("//input[@id='IsActive-34']");
	By btnViewMyTest = By.xpath("//input[@id='IsActive-35']");
	
	By radioMyTest = By.xpath("//label[@for='IsActive-34']");
	By viewMyTest = By.xpath("//label[@for='IsActive-35']");
	
	public void clickOFFbtnRadioMyTest()
	{
		String result = driver.findElement(btnRadioMyTest).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyTest);
		 }
	}
	
	public void clickONbtnRadioMyTest()
	{
		String result = driver.findElement(btnRadioMyTest).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyTest);
		 }
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
	

	//Talent Management >> Talent - Job
	By btnViewJobList = By.xpath("//input[@id='IsActive-38']");
	By btnViewJobdetail  = By.xpath("//input[@id='IsActive-39']");
	By btnCreateJob  = By.xpath("//input[@id='IsActive-40']");
	By btnEditJob = By.xpath("//input[@id='IsActive-41']");
	By btnDeleteJob  = By.xpath("//input[@id='IsActive-42']");
	
	By viewJobList = By.xpath("//label[@for='IsActive-38']");
	By viewJobdetail  = By.xpath("//label[@for='IsActive-39']");
	By createJob  = By.xpath("//label[@for='IsActive-40']");
	By editJob = By.xpath("//label[@for='IsActive-41']");
	By deleteJob  = By.xpath("//label[@for='IsActive-42']");
	
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
	
	//Talent Management >> Talent - Job Level
	By subTabTalentJobLevel = By.xpath("(//ul[@id='subModuleList']//a)[2]");
	By btnViewJobLevelList = By.xpath("//input[@id='IsActive-44']");
	By btnViewJobLevelDetails  = By.xpath("//input[@id='IsActive-45']");
	By btnCreateJobLevel  = By.xpath("//input[@id='IsActive-46']");
	By btnEditJobLevel = By.xpath("//input[@id='IsActive-47']");
	By btnDeleteJobLevel = By.xpath("//input[@id='IsActive-48']");
	
	By viewJobLevelList = By.xpath("//label[@for='IsActive-44']");
	By viewJobLevelDetails  = By.xpath("//label[@for='IsActive-45']");
	By createJobLevel  = By.xpath("//label[@for='IsActive-46']");
	By editJobLevel = By.xpath("//label[@for='IsActive-47']");
	By deleteJobLevel = By.xpath("//label[@for='IsActive-48']");
	
	public void clickSubTabTalentJobLevel()
	{
		waitFluentWait(subTabTalentJobLevel);
		click(subTabTalentJobLevel);
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
	
	//Talent Management >> Talent - Position
	By subTabTalentPosition = By.xpath("(//ul[@id='subModuleList']//a)[3]");
	By btnViewPositionList = By.xpath("//input[@id='IsActive-50']");
	By btnViewPositionDetails  = By.xpath("//input[@id='IsActive-51']");
	By btnCreatePositions  = By.xpath("//input[@id='IsActive-52']");
	By btnEditPositions = By.xpath("//input[@id='IsActive-53']");
	By btnDeletePositions = By.xpath("//input[@id='IsActive-54']");
	
	By viewPositionList = By.xpath("//label[@for='IsActive-50']");
	By viewPositionDetails  = By.xpath("//label[@for='IsActive-51']");
	By createPositions  = By.xpath("//label[@for='IsActive-52']");
	By editPositions = By.xpath("//label[@for='IsActive-53']");
	By deletePositions = By.xpath("//label[@for='IsActive-54']");
	
	public void clickSubTabTalentPosition()
	{
		waitFluentWait(subTabTalentPosition);
		click(subTabTalentPosition);
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
	By subTabTalentBaseline = By.xpath("(//ul[@id='subModuleList']//a)[4]");
	
	By btnRadioPostionBaseline = By.xpath("//input[@id='IsActive-208']");
	By btnViewBaselineListPosition = By.xpath("//input[@id='IsActive-211']");
	By btnCreateBaselinesPosition  = By.xpath("//input[@id='IsActive-212']");
	By btnEditBaselinesPosition = By.xpath("//input[@id='IsActive-213']");
	By btnDeleteBaselinesPosition = By.xpath("//input[@id='IsActive-214']");
	By btnCloneBaselinesPosition = By.xpath("//input[@id='IsActive-215']");
	By btnInheritBaselinesPosition = By.xpath("//input[@id='IsActive-216']");
	
	By radioPostionBaseline = By.xpath("//label[@for='IsActive-208']");
	By viewBaselineListPosition = By.xpath("//label[@for='IsActive-211']");
	By createBaselinesPosition = By.xpath("//label[@for='IsActive-212']");
	By editBaselinesPosition = By.xpath("//label[@for='IsActive-213']");
	By deleteBaselinesPosition = By.xpath("//label[@for='IsActive-214']");
	By cloneBaselinesPosition = By.xpath("//label[@for='IsActive-215']");
	By inheritBaselinesPosition = By.xpath("//label[@for='IsActive-216']");
	
	public void clickSubTabTalentBaseline()
	{
		waitFluentWait(subTabTalentBaseline);
		click(subTabTalentBaseline);
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
			 click(deleteBaselinesPosition);
		 }
	}
	
	public void clickONBtnInheritBaselinesPosition()
	{
		String result = driver.findElement(btnInheritBaselinesPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteBaselinesPosition);
		 }
	}
	
	//Talent Management >> Talent - Goal Line Job
	
	By btnRadioJobGoalLine = By.xpath("//input[@id='IsActive-232']");
	By btnViewListJobGoalLine = By.xpath("//input[@id='IsActive-242']");
	By btnViewDetailJobGoalLine = By.xpath("//input[@id='IsActive-243']");
	By btnCreateJobGoals  = By.xpath("//input[@id='IsActive-244']");
	By btnEditJobGoals = By.xpath("//input[@id='IsActive-245']");
	By btnDuplicateJobGoals = By.xpath("//input[@id='IsActive-246']");
	By btnDeleteJobGoals = By.xpath("//input[@id='IsActive-247']");
	By btnCloneJobGoalLines = By.xpath("//input[@id='IsActive-248']");
		
	By radioJobGoalLine = By.xpath("//label[@for='IsActive-232']");
	By viewListJobGoalLine = By.xpath("//label[@for='IsActive-242']");
	By viewDetailJobGoalLine = By.xpath("//label[@for='IsActive-243']");
	By createJobGoals = By.xpath("//label[@for='IsActive-244']");
	By editJobGoals = By.xpath("//label[@for='IsActive-245']");
	By duplicateJobGoals = By.xpath("//label[@for='IsActive-246']");
	By deleteJobGoals = By.xpath("//label[@for='IsActive-247']");
	By cloneJobGoalLines = By.xpath("//label[@for='IsActive-248']");
	
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
	
		//Talent Management >> Talent - Goal Line Dimension
		
		By btnRadioDimensionBaseline = By.xpath("//input[@id='IsActive-210']");
		By btnViewBaselineListDimension = By.xpath("//input[@id='IsActive-222']");
		By btnCreateBaselinesDimension  = By.xpath("//input[@id='IsActive-223']");
		By btnEditBaselinesDimension = By.xpath("//input[@id='IsActive-224']");
		By btnDeleteBaselinesDimension = By.xpath("//input[@id='IsActive-225']");
		By btnCloneBaselinesDimension = By.xpath("//input[@id='IsActive-226']");
				
		By radioDimensionBaseline = By.xpath("//label[@for='IsActive-210']");
		By viewBaselineListDimension = By.xpath("//label[@for='IsActive-222']");
		By createBaselinesDimension = By.xpath("//label[@for='IsActive-223']");
		By editBaselinesDimension = By.xpath("//label[@for='IsActive-224']");
		By deleteBaselinesDimension = By.xpath("//label[@for='IsActive-225']");
		By cloneBaselinesDimension = By.xpath("//label[@for='IsActive-226']");
		
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
						 click(createBaselinesJob);
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
	
				//Talent Management >> Talent - Goal Position
				By subTabTalentGoalLine = By.xpath("(//ul[@id='subModuleList']//a)[5]");
				
				By btnRadioPostionGoalLine = By.xpath("//input[@id='IsActive-231']");
				By btnViewListPositionGoalLine = By.xpath("//input[@id='IsActive-234']");
				By btnViewDetailPositionGoalDetails = By.xpath("//input[@id='IsActive-235']");
				By btnCreatePositionGoals  = By.xpath("//input[@id='IsActive-236']");
				By btnEditPositionGoals = By.xpath("//input[@id='IsActive-237']");
				By btnDuplicatePositionGoals = By.xpath("//input[@id='IsActive-238']");
				By btnDeletePositionGoals = By.xpath("//input[@id='IsActive-239']");
				By btnClonePositionGoalLine = By.xpath("//input[@id='IsActive-240']");
				By btnInheritPositionGoalLine = By.xpath("//input[@id='IsActive-241']");
				
				By viewListPositionGoalLine = By.xpath("//label[@for='IsActive-231']");
				By viewDetailPositionGoalDetails = By.xpath("//label[@for='IsActive-234']");
				By createPositionGoals = By.xpath("//label[@for='IsActive-236']");
				By editPositionGoals = By.xpath("//label[@for='IsActive-237']");
				By duplicatePositionGoals = By.xpath("//label[@for='IsActive-238']");
				By deletePositionGoals = By.xpath("//label[@for='IsActive-239']");
				By clonePositionGoalLine = By.xpath("//label[@for='IsActive-240']");
				By inheritPositionGoalLine = By.xpath("//label[@for='IsActive-241']");
				
				public void clickSubTabTalentGoalLine()
				{
					waitFluentWait(subTabTalentGoalLine);
					click(subTabTalentGoalLine);
				}

				public void clickOFFbtnRadioPostionGoalLine()
				{
					String result = driver.findElement(btnRadioPostionGoalLine).getAttribute("checked");
					 if (result!=null)
					 {
						 click(viewListPositionGoalLine);
					 }
				}
				
				public void clickONbtnRadioPostionGoalLine()
				{
					String result = driver.findElement(btnRadioPostionGoalLine).getAttribute("checked");
					 if (result==null)
					 {
						 click(viewListPositionGoalLine);
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
				
				//Talent Management >> Talent - Baseline Job
				
				By btnRadioJobBaseline = By.xpath("//input[@id='IsActive-209']");
					By btnViewBaselineListJob = By.xpath("//input[@id='IsActive-217']");
					By btnCreateBaselinesJob  = By.xpath("//input[@id='IsActive-218']");
					By btnEditBaselinesJob = By.xpath("//input[@id='IsActive-219']");
					By btnDeleteBaselinesJob = By.xpath("//input[@id='IsActive-220']");
					By btnCloneBaselinesJob = By.xpath("//input[@id='IsActive-221']");
				
					By radioJobBaseline = By.xpath("//label[@for='IsActive-209']");
					By viewBaselineListJob = By.xpath("//label[@for='IsActive-217']");
					By createBaselinesJob = By.xpath("//label[@for='IsActive-218']");
					By editBaselinesJob = By.xpath("//label[@for='IsActive-219']");
					By deleteBaselinesJob = By.xpath("//label[@for='IsActive-220']");
					By cloneBaselinesJob = By.xpath("//label[@for='IsActive-221']");
				
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
					
		//Talent Management >> Talent - Baseline Dimension
				
		By btnRadioDimensionGoalLine = By.xpath("//input[@id='IsActive-233']");
		By btnViewListDimensionGoalLine = By.xpath("//input[@id='IsActive-249']");
		By btnViewDetailDimensionGoalLineList  = By.xpath("//input[@id='IsActive-250']");
		By btnCreateDimensionGoals = By.xpath("//input[@id='IsActive-251']");
		By btnEditDimensionGoals = By.xpath("//input[@id='IsActive-252']");
		By btnDuplicateDimensionGoals = By.xpath("//input[@id='IsActive-253']");
		By btnDeleteDimensionGoals = By.xpath("//input[@id='IsActive-254']");
		By btnCloneDimensionGoalLines = By.xpath("//input[@id='IsActive-255']");
							
		By radioDimensionGoalLine = By.xpath("//label[@for='IsActive-233']");
		By viewListDimensionGoalLine = By.xpath("//label[@for='IsActive-249']");
		By viewDetailDimensionGoalLineList = By.xpath("//label[@for='IsActive-250']");
		By createDimensionGoals = By.xpath("//label[@for='IsActive-251']");
		By editDimensionGoals = By.xpath("//label[@for='IsActive-252']");
		By duplicateDimensionGoals = By.xpath("//label[@for='IsActive-253']");
		By deleteDimensionGoals = By.xpath("//label[@for='IsActive-254']");
		By cloneDimensionGoalLines = By.xpath("//label[@for='IsActive-255']");
					
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
							
	//Control Board - System Settings >> Organization
	By btnViewDimensionList = By.xpath("//input[@id='IsActive-62']");
	By btnCreateDimension  = By.xpath("//input[@id='IsActive-63']");
	By btnEditDimension = By.xpath("//input[@id='IsActive-64']");
	By btnDeleteDimension = By.xpath("//input[@id='IsActive-65']");
	
	By viewDimensionList = By.xpath("//label[@for='IsActive-62']");
	By createDimension  = By.xpath("//label[@for='IsActive-63']");
	By editDimension = By.xpath("//label[@for='IsActive-64']");
	By deleteDimension = By.xpath("//label[@for='IsActive-65']");
	
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
	
	//Control Board - System Settings >> Organization
	By subTabContentManagement = By.xpath("(//ul[@id='subModuleList']//a)[2]");
	By btnViewWelcomeLetter = By.xpath("//input[@id='IsActive-160']");
	By btnEditWelcomeLetter = By.xpath("//input[@id='IsActive-161']");
							
	By viewWelcomeLetter = By.xpath("//label[@for='IsActive-160']");
	By editWelcomeLetter  = By.xpath("//label[@for='IsActive-161']");
							
	public void clickSubTabContentManagement()
	{
		waitFluentWait(subTabContentManagement);
		click(subTabContentManagement);
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
	
	//Control Board - System Settings >> Skill
	By subTabSkill = By.xpath("(//ul[@id='subModuleList']//a)[3]");
	By btnViewSkills = By.xpath("//input[@id='IsActive-67']");
	By btnCreateSkills  = By.xpath("//input[@id='IsActive-68']");
	By btnEditSkills = By.xpath("//input[@id='IsActive-69']");
	By btnDeleteSkills = By.xpath("//input[@id='IsActive-70']");
	By btnManageSkillCategory = By.xpath("//input[@id='IsActive-71']");
	
	By viewSkills = By.xpath("//label[@for='IsActive-67']");
	By createSkills  = By.xpath("//label[@for='IsActive-68']");
	By editSkills = By.xpath("//label[@for='IsActive-69']");
	By deleteSkills = By.xpath("//label[@for='IsActive-70']");
	By manageSkillCategory = By.xpath("//label[@for='IsActive-71']");
	
	public void clickSubTabSkill()
	{
		waitFluentWait(subTabSkill);
		click(subTabSkill);
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
		
	public void clickOFFbtnDeleteSkills()
	{
		String result = driver.findElement(btnDeleteSkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(deleteSkills);
		 }
	}
	
	public void clickONbtnDeleteSkills()
	{
		String result = driver.findElement(btnDeleteSkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(deleteSkills);
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
	By subTabGeneralSettings = By.xpath("(//ul[@id='subModuleList']//a)[4]");
	By btnViewGeneralSettings = By.xpath("//input[@id='IsActive-154']");
	By btnUpdateSystemDimensions = By.xpath("//input[@id='IsActive-73']");
	By btnUpdateSystemSkillLevel =  By.xpath("//input[@id='IsActive-74']");	
	By btnViewUserDefinedValues = By.xpath("//input[@id='IsActive-157']");
	By btnUpdateUserDefinedValues = By.xpath("//input[@id='IsActive-158']");
	By btnUpdateLearningURL =  By.xpath("//input[@id='IsActive-162']");	
	
	
	By viewGeneralSettings = By.xpath("//label[@for='IsActive-154']");
	By updateSystemDimensions = By.xpath("//label[@for='IsActive-73']");
	By updateSystemSkillLevel =  By.xpath("//label[@for='IsActive-74']");	
	By viewUserDefinedValues = By.xpath("//label[@for='IsActive-157']");
	By updateUserDefinedValues = By.xpath("//label[@for='IsActive-158']");
	By updateLearningURL =  By.xpath("//label[@for='IsActive-162']");
	
	public void clickSubTabGeneralSettings()
	{
		waitFluentWait(subTabGeneralSettings);
		click(subTabGeneralSettings);
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
	
	
	//Control Board - System Settings >> Security Profile
	By subTabSecurityProfile = By.xpath("(//ul[@id='subModuleList']//a)[5]");
	By btnViewSecurityProfile = By.xpath("//input[@id='IsActive-76']");
	By btnViewSecurityProfileDetail  = By.xpath("//input[@id='IsActive-77']");
	By btnCreateSecurityProfile = By.xpath("//input[@id='IsActive-78']");
	By btnEditSecurityProfile = By.xpath("//input[@id='IsActive-79']");
	By btnDeleteSecurityProfile = By.xpath("//input[@id='IsActive-80']");
	
	By viewSecurityProfile = By.xpath("//label[@for='IsActive-76']");
	By viewSecurityProfileDetail  = By.xpath("//label[@for='IsActive-77']");
	By createSecurityProfile = By.xpath("//label[@for='IsActive-78']");
	By editSecurityProfile = By.xpath("//label[@for='IsActive-79']");
	By deleteSecurityProfile = By.xpath("//label[@for='IsActive-80']");
	
	public void clickSubTabSecurityProfile()
	{
		waitFluentWait(subTabSecurityProfile);
		click(subTabSecurityProfile);
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
	
	//Control Board - System Settings >> Role
	By subTabRole = By.xpath("(//ul[@id='subModuleList']//a)[6]");
	By btnViewRole = By.xpath("//input[@id='IsActive-82']");
	By btnViewRoleDetail  = By.xpath("//input[@id='IsActive-83']");
	By btnCreateRole = By.xpath("//input[@id='IsActive-84']");
	By btnEditRole = By.xpath("//input[@id='IsActive-85']");
	By btnDeleteRole = By.xpath("//input[@id='IsActive-86']");
	
	By viewRole = By.xpath("//label[@for='IsActive-82']");
	By viewRoleDetail  = By.xpath("//label[@for='IsActive-83']");
	By createRole = By.xpath("//label[@for='IsActive-84']");
	By editRole = By.xpath("//label[@for='IsActive-85']");
	By deleteRole = By.xpath("//label[@for='IsActive-86']");
	
	public void clickSubTabRole()
	{
		waitFluentWait(subTabRole);
		click(subTabRole);
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
	By subTabFunctionSet = By.xpath("(//ul[@id='subModuleList']//a)[7]");
	By btnViewFunctionSet = By.xpath("//input[@id='IsActive-68']");
	By btnViewFunctionSetDetail  = By.xpath("//input[@id='IsActive-69']");
	By btnCreateFunctionSet = By.xpath("//input[@id='IsActive-70']");
	By btnEditFunctionSet = By.xpath("//input[@id='IsActive-71']");
	By btnDeleteFunctionSet = By.xpath("//input[@id='IsActive-72']");
	
	By viewFunctionSet = By.xpath("//label[@for='IsActive-68']");
	By viewFunctionSetDetail  = By.xpath("//label[@for='IsActive-69']");
	By createFunctionSet = By.xpath("//label[@for='IsActive-70']");
	By editFunctionSet = By.xpath("//label[@for='IsActive-71']");
	By deleteFunctionSet = By.xpath("//label[@for='IsActive-72']");
	
	public void clickSubTabFunctionSet()
	{
		waitFluentWait(subTabFunctionSet);
		click(subTabFunctionSet);
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
	By subTabEmployee = By.xpath("(//ul[@id='subModuleList']//a)[1]");
	
	By btnRadioEmployeeList = By.xpath("//input[@id='IsActive-165']");
	By btnViewmEployeeList = By.xpath("//input[@id='IsActive-170']");
	By btnViewOrganizationChartEmployee = By.xpath("//input[@id='IsActive-171']");
	By btnAddNewEmployee = By.xpath("//input[@id='IsActive-172']");
		
	By radioEmployeeList = By.xpath("//label[@for='IsActive-165']");
	By viewmEployeeList = By.xpath("//label[@for='IsActive-170']");
	By viewOrganizationChartEmployee = By.xpath("//label[@for='IsActive-171']");
	By addNewEmployee = By.xpath("//label[@for='IsActive-172']");
	
	By btnRadioPersonal = By.xpath("//input[@id='IsActive-166']");
	By btnViewProfile = By.xpath("//input[@id='IsActive-173']");
	By btnEditProfile = By.xpath("//input[@id='IsActive-174']");
	By btnViewContact = By.xpath("//input[@id='IsActive-175']");
	By btnViewAddress = By.xpath("//input[@id='IsActive-176']");
	By btnViewIdentificationDocuments = By.xpath("//input[@id='IsActive-177']");
	By btnViewEducation = By.xpath("//input[@id='IsActive-178']");
	By btnManageContact = By.xpath("//input[@id='IsActive-179']");
	By btnManageAddress = By.xpath("//input[@id='IsActive-180']");
	By btnManageIdentificationDocuments = By.xpath("//input[@id='IsActive-181']");
	By btnManageEducation = By.xpath("//input[@id='IsActive-182']");
	
	By radioPersonal = By.xpath("//label[@for='IsActive-166']");
	By viewProfile = By.xpath("//label[@for='IsActive-173']");
	By editProfile = By.xpath("//label[@for='IsActive-174']");
	By viewContact = By.xpath("//label[@for='IsActive-175']");
	By viewAddress = By.xpath("//label[@for='IsActive-176']");
	By viewIdentificationDocuments = By.xpath("//label[@for='IsActive-177']");
	By viewEducation = By.xpath("//label[@for='IsActive-178']");
	By manageContact = By.xpath("//label[@for='IsActive-179']");
	By manageAddress = By.xpath("//label[@for='IsActive-180']");
	By manageIdentificationDocuments = By.xpath("//label[@for='IsActive-181']");
	By manageEducation = By.xpath("//label[@for='IsActive-182']");
	
	By btnRadioContract = By.xpath("//input[@id='IsActive-167']");
	By btnViewEmployment = By.xpath("//input[@id='IsActive-183']");
	By btnManageEmployment = By.xpath("//input[@id='IsActive-184']");
	By btnViewWorkPermit = By.xpath("//input[@id='IsActive-185']");
	By btnManageWorkPermit = By.xpath("//input[@id='IsActive-186']");
	By btnViewContractInfo = By.xpath("//input[@id='IsActive-256']");
	By btnUpdateContractInfo = By.xpath("//input[@id='IsActive-257']");
		
	By radioContract = By.xpath("//label[@for='IsActive-167']");
	By viewEmployment = By.xpath("//label[@for='IsActive-183']");
	By manageEmployment = By.xpath("//label[@for='IsActive-184']");
	By viewWorkPermit = By.xpath("//label[@for='IsActive-185']");
	By manageWorkPermit = By.xpath("//label[@for='IsActive-186']");
	By viewContractInfo = By.xpath("//label[@for='IsActive-256']");
	By updateContractInfo = By.xpath("//label[@for='IsActive-257']");
	
	By btnRadioPositionTalent = By.xpath("//input[@id='IsActive-168']");
	By btnViewPositionHistoryList = By.xpath("//input[@id='IsActive-187']");
	By btnViewPositionAssignmentDetails = By.xpath("//input[@id='IsActive-188']");
	By btnAssignPositiontoEmployee = By.xpath("//input[@id='IsActive-189']");
	By btnUpdatePositiontoEmployeeAssignment = By.xpath("//input[@id='IsActive-190']");
	By btnDeletePositiontoEmployeeAssignment = By.xpath("//input[@id='IsActive-191']");
	
	By radioPositionTalent = By.xpath("//label[@for='IsActive-168']");
	By viewPositionHistoryList = By.xpath("//label[@for='IsActive-187']");
	By viewPositionAssignmentDetails = By.xpath("//label[@for='IsActive-188']");
	By assignPositiontoEmployee = By.xpath("//label[@for='IsActive-189']");
	By updatePositiontoEmployeeAssignment = By.xpath("//label[@for='IsActive-190']");
	By deletePositiontoEmployeeAssignment = By.xpath("//label[@for='IsActive-191']");
	
	By btnRadioOrganizationChart = By.xpath("//input[@id='IsActive-169']");
	By btnViewOrganizationChart = By.xpath("//input[@id='IsActive-192']");

	By radioOrganizationChart = By.xpath("//label[@for='IsActive-169']");
	By viewOrganizationChart = By.xpath("//label[@for='IsActive-192']");
	
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
	
	
	public void clickOFFBtnViewmEployeeList()
	{
		String result = driver.findElement(btnViewmEployeeList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewmEployeeList);
		 }
	}
	
	public void clickONBtnViewmEployeeList()
	{
		String result = driver.findElement(btnViewmEployeeList).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewmEployeeList);
		 }
	}
	
	public void clickOFFBtnViewOrganizationChartEmployee()
	{
		String result = driver.findElement(btnViewOrganizationChartEmployee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewOrganizationChartEmployee);
		 }
	}
	
	public void clickONBtnViewOrganizationChartEmployee()
	{
		String result = driver.findElement(btnViewOrganizationChartEmployee).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewOrganizationChartEmployee);
		 }
	}
	
	public void clickOFFBtnAddNewEmployee()
	{
		String result = driver.findElement(btnAddNewEmployee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(addNewEmployee);
		 }
	}
	
	public void clickONBtnAddNewEmployee()
	{
		String result = driver.findElement(btnAddNewEmployee).getAttribute("checked");
		 if (result==null)
		 {
			 click(addNewEmployee);
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
	
	public void clickONB6tnViewEducation()
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
	
	public void clickOFFBtnViewEmployment()
	{
		String result = driver.findElement(btnViewEmployment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewEmployment);
		 }
	}
	
	public void clickONBtnViewEmployment()
	{
		String result = driver.findElement(btnViewEmployment).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewEmployment);
		 }
	}
	
	public void clickOFFBtnManageEmployment()
	{
		String result = driver.findElement(btnManageEmployment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(manageEmployment);
		 }
	}
	
	public void clickONBtnManageEmployment()
	{
		String result = driver.findElement(btnManageEmployment).getAttribute("checked");
		 if (result==null)
		 {
			 click(manageEmployment);
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
	
	public void clickOFFBtnUpdateContractInfo()
	{
		String result = driver.findElement(btnUpdateContractInfo).getAttribute("checked");
		 if (result!=null)
		 {
			 click(updateContractInfo);
		 }
	}
	
	public void clickONBtnUpdateContractInfo()
	{
		String result = driver.findElement(btnUpdateContractInfo).getAttribute("checked");
		 if (result==null)
		 {
			 click(updateContractInfo);
		 }
	}
	
	public void clickOFFBtnRadioPositionTalent()
	{
		String result = driver.findElement(btnRadioPositionTalent).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioPositionTalent);
		 }
	}
	
	public void clickONBtnRadioPositionTalent()
	{
		String result = driver.findElement(btnRadioPositionTalent).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioPositionTalent);
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
	
	//Talent Management >> Talent
	By subTabTalent = By.xpath("(//ul[@id='subModuleList']//a)[2]");
		
	By btnRadioCompetency = By.xpath("//input[@id='IsActive-228']");
	By btnViewTeamCompetency = By.xpath("//input[@id='IsActive-229']");
	
	By radioCompetency = By.xpath("//label[@for='IsActive-228']");
	By viewTeamCompetency = By.xpath("//label[@for='IsActive-229']");
	
	public void clickSubTabTalent()
	{
		waitFluentWait(subTabTalent);
		click(subTabTalent);
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
	
	//Control Board - System Settings >> User
		By subTabUser = By.xpath("(//ul[@id='subModuleList']//a)[8]");
		By btnViewUser = By.xpath("//input[@id='IsActive-94']");
		By btnViewUserDetail  = By.xpath("//input[@id='IsActive-95']");
		By btnCreateUser = By.xpath("//input[@id='IsActive-96']");
		By btnEditUser = By.xpath("//input[@id='IsActive-97']");
		By btnDeleteUser = By.xpath("//input[@id='IsActive-98']");
		By btnImportUser = By.xpath("//input[@id='IsActive-99']");
		By btnLockUnlockUser = By.xpath("//input[@id='IsActive-100']");
		By btnActiveInactiveUser  = By.xpath("//input[@id='IsActive-101']");
		
		By viewUser = By.xpath("//label[@for='IsActive-94']");
		By viewUserDetail  = By.xpath("//label[@for='IsActive-95']");
		By createUser = By.xpath("//label[@for='IsActive-96']");
		By editUser = By.xpath("//label[@for='IsActive-97']");
		By deleteUser = By.xpath("//label[@for='IsActive-98']");
		By importUser = By.xpath("//label[@for='IsActive-99']");
		By lockUnlockUser = By.xpath("//label[@for='IsActive-100']");
		By activeInactiveUser  = By.xpath("//label[@for='IsActive-101']");
		
		public void clickSubTabUser()
		{
			waitFluentWait(subTabUser);
			click(subTabUser);
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
		
		public void clickOFFbtnDeleteUser()
		{
			String result = driver.findElement(btnDeleteUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(deleteUser);
			 }
		}
		
		public void clickONbtnDeleteUser()
		{
			String result = driver.findElement(btnDeleteUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(deleteUser);
			 }
		}
		
		
		
		public void clickOFFbtnImportUser()
		{
			String result = driver.findElement(btnImportUser).getAttribute("checked");
			 if (result!=null)
			 {
				 click(importUser);
			 }
		}
		
		public void clickONbtnImportUser()
		{
			String result = driver.findElement(btnImportUser).getAttribute("checked");
			 if (result==null)
			 {
				 click(importUser);
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
	By subTabLearningContentPool = By.xpath("(//ul[@id='subModuleList']//a)[1]");
	By btnViewContentList = By.xpath("//input[@id='IsActive-195'][@name='onoffswitch']");
	By btnManageContentCategory = By.xpath("//input[@id='IsActive-196']");
	By btnCreateContent = By.xpath("//input[@id='IsActive-197']");
	By btnViewContentDetail = By.xpath("//input[@id='IsActive-198']");
	By btnDeleteContent = By.xpath("//input[@id='IsActive-199']");
	By btnRejectContent = By.xpath("//input[@id='IsActive-200']");
	By btnMarkUnmarkAsMicrolearning = By.xpath("//input[@id='IsActive-201']");
	By btnEditContent = By.xpath("//input[@id='IsActive-202']");
	
	By viewContentList = By.xpath("//label[@for='IsActive-195']");
	By manageContentList = By.xpath("//label[@for='IsActive-196']");
	By createContent = By.xpath("//label[@for='IsActive-197']");
	By viewContentDetail = By.xpath("//label[@for='IsActive-198']");
	By deleteContent = By.xpath("//label[@for='IsActive-199']");
	By rejectContent = By.xpath("//label[@for='IsActive-200']");
	By markUnmarkAsMicrolearning = By.xpath("//label[@for='IsActive-201']");
	By editContent = By.xpath("//label[@for='IsActive-202']");
	
	public void clickSubTabLearningContentPool(){
		waitFluentWait(subTabLearningContentPool);
		click(subTabLearningContentPool);
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
	
	/*//My Space >> Employee Data >> Personal
	By btnRadioMyPersonal  = By.xpath("//input[@id='IsActive-104']");
	By btnViewProfile = By.xpath("//input[@id='IsActive-105']");
	By btnEditProfile = By.xpath("//input[@id='IsActive-106']");
	By btnViewContact = By.xpath("//input[@id='IsActive-107']");
	By btnViewAddress = By.xpath("//input[@id='IsActive-108']");
	By btnViewIdentificationDocuments = By.xpath("//input[@id='IsActive-109']");
	By btnViewEmployment = By.xpath("//input[@id='IsActive-110']");
	By btnViewWorkPermit = By.xpath("//input[@id='IsActive-111']");
	By btnViewEducation = By.xpath("//input[@id='IsActive-112']");
	By btnEditContact = By.xpath("//input[@id='IsActive-113']");
	By btnEditAddress = By.xpath("//input[@id='IsActive-114']");
	By btnEditIdentificationDocuments = By.xpath("//input[@id='IsActive-115']");
	By btnEditWorkPermit = By.xpath("//input[@id='IsActive-116']");
	By btnEditEducation = By.xpath("//input[@id='IsActive-117']");
	
	By radioMyPersonal  = By.xpath("//label[@for='IsActive-104']");
	By viewProfile = By.xpath("//label[@for='IsActive-105']");
	By editProfile = By.xpath("//label[@for='IsActive-106']");
	By viewContact = By.xpath("//label[@for='IsActive-107']");
	By viewAddress = By.xpath("//label[@for='IsActive-108']");
	By viewIdentificationDocuments = By.xpath("//label[@for='IsActive-109']");
	By viewEmployment = By.xpath("//label[@for='IsActive-110']");
	By viewWorkPermit = By.xpath("//label[@for='IsActive-111']");
	By viewEducation = By.xpath("//label[@for='IsActive-112']");
	By editContact = By.xpath("//label[@for='IsActive-113']");
	By editAddress = By.xpath("//label[@for='IsActive-114']");
	By editIdentificationDocuments = By.xpath("//label[@for='IsActive-115']");
	By editWorkPermit = By.xpath("//label[@for='IsActive-116']");
	By editEducation = By.xpath("//label[@for='IsActive-117']");
	
	
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
	
	public void clickOFFbtnViewProfile()
	{
		String result = driver.findElement(btnViewProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewProfile);
		 }
	}
	
	public void clickONbtnViewProfile()
	{
		String result = driver.findElement(btnViewProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewProfile);
		 }
	}
	

	public void clickOFFbtnEditProfile()
	{
		String result = driver.findElement(btnEditProfile).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editProfile);
		 }
	}
	
	public void clickONbtnEditProfile()
	{
		String result = driver.findElement(btnEditProfile).getAttribute("checked");
		 if (result==null)
		 {
			 click(editProfile);
		 }
	}

	public void clickOFFbtnViewContact()
	{
		String result = driver.findElement(btnViewContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewContact);
		 }
	}
	
	public void clickONbtnViewContact()
	{
		String result = driver.findElement(btnViewContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewContact);
		 }
	}
	
	public void clickOFFbtnViewAddress()
	{
		String result = driver.findElement(btnViewAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewAddress);
		 }
	}
	
	public void clickONbtnViewAddress()
	{
		String result = driver.findElement(btnViewAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewAddress);
		 }
	}
	
	public void clickOFFbtnViewIdentificationDocuments()
	{
		String result = driver.findElement(btnViewIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewIdentificationDocuments);
		 }
	}
	
	public void clickONbtnViewIdentificationDocuments()
	{
		String result = driver.findElement(btnViewIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewIdentificationDocuments);
		 }
	}
	
	
	
	public void clickOFFbtnViewEmployment()
	{
		String result = driver.findElement(btnViewEmployment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewEmployment);
		 }
	}
	
	public void clickONbtnViewEmployment()
	{
		String result = driver.findElement(btnViewEmployment).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewEmployment);
		 }
	}
	
	public void clickOFFbtnViewWorkPermit()
	{
		String result = driver.findElement(btnViewWorkPermit).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewWorkPermit);
		 }
	}
	
	public void clickONbtnViewWorkPermit()
	{
		String result = driver.findElement(btnViewWorkPermit).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewWorkPermit);
		 }
	}
		
	public void clickOFFbtnViewEducation()
	{
		String result = driver.findElement(btnViewEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewEducation);
		 }
	}
	
	public void clickONbtnViewEducation()
	{
		String result = driver.findElement(btnViewEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewEducation);
		 }
	}
	
	public void clickOFFbtnEditContact()
	{
		String result = driver.findElement(btnEditContact).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editContact);
		 }
	}
	
	public void clickONbtnEditContact()
	{
		String result = driver.findElement(btnEditContact).getAttribute("checked");
		 if (result==null)
		 {
			 click(editContact);
		 }
	}
	
	
	public void clickOFFbtnEditAddress()
	{
		String result = driver.findElement(btnEditAddress).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editAddress);
		 }
	}
	
	public void clickONbtnEditAddress()
	{
		String result = driver.findElement(btnEditAddress).getAttribute("checked");
		 if (result==null)
		 {
			 click(editAddress);
		 }
	}
	

	public void clickOFFbtnEditIdentificationDocuments()
	{
		String result = driver.findElement(btnEditIdentificationDocuments).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editIdentificationDocuments);
		 }
	}
	
	public void clickONbtnEditIdentificationDocuments()
	{
		String result = driver.findElement(btnEditIdentificationDocuments).getAttribute("checked");
		 if (result==null)
		 {
			 click(editIdentificationDocuments);
		 }
	}
	
	public void clickOFFbtnEditWorkPermit()
	{
		String result = driver.findElement(btnEditWorkPermit).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editWorkPermit);
		 }
	}
	
	public void clickONbtnEditWorkPermit()
	{
		String result = driver.findElement(btnEditWorkPermit).getAttribute("checked");
		 if (result==null)
		 {
			 click(editWorkPermit);
		 }
	}
	

	public void clickOFFbtnEditEducation()
	{
		String result = driver.findElement(btnEditEducation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(editEducation);
		 }
	}
	
	public void clickONbtnEditEducation()
	{
		String result = driver.findElement(btnEditEducation).getAttribute("checked");
		 if (result==null)
		 {
			 click(editEducation);
		 }
	}
	
	//My Space >> Employee Data >> Position
	By btnRadioMyPosition  = By.xpath("//input[@id='IsActive-118']");
	By btnViewPositionHistoryDetails = By.xpath("//input[@id='IsActive-119']");
	By btnAssignPositiontoEmployee = By.xpath("//input[@id='IsActive-120']");
	By btnUpdatePositiontoEmployeeAssignment  = By.xpath("//input[@id='IsActive-121']");
	By btnDeletePositiontoEmployeeAssignment = By.xpath("//input[@id='IsActive-122']");
	By btnViewMyPositionList = By.xpath("//input[@id='IsActive-123']");
	

	
	public void clickOFFbtnRadioMyPosition()
	{
		String result = driver.findElement(btnRadioMyPosition).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnRadioMyPosition);
		 }
	}
	
	public void clickONbtnRadioMyPosition()
	{
		String result = driver.findElement(btnRadioMyPosition).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnRadioMyPosition);
		 }
	}
	

	public void clickOFFbtnViewPositionHistoryDetails()
	{
		String result = driver.findElement(btnViewPositionHistoryDetails).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewPositionHistoryDetails);
		 }
	}
	
	public void clickONbtnViewPositionHistoryDetails()
	{
		String result = driver.findElement(btnViewPositionHistoryDetails).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewPositionHistoryDetails);
		 }
	}
	
	
	public void clickOFFbtnAssignPositiontoEmployee()
	{
		String result = driver.findElement(btnAssignPositiontoEmployee).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnAssignPositiontoEmployee);
		 }
	}
	
	public void clickONbtnAssignPositiontoEmployee()
	{
		String result = driver.findElement(btnAssignPositiontoEmployee).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnAssignPositiontoEmployee);
		 }
	}
	
	

	public void clickOFFbtnUpdatePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnUpdatePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnUpdatePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickONbtnUpdatePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnUpdatePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnUpdatePositiontoEmployeeAssignment);
		 }
	}
	
	

	public void clickOFFbtnDeletePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnDeletePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnDeletePositiontoEmployeeAssignment);
		 }
	}
	
	public void clickONbtnDeletePositiontoEmployeeAssignment()
	{
		String result = driver.findElement(btnDeletePositiontoEmployeeAssignment).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnDeletePositiontoEmployeeAssignment);
		 }
	}
	
	
	public void clickOFFbtnViewMyPositionList()
	{
		String result = driver.findElement(btnViewMyPositionList).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewMyPositionList);
		 }
	}
	
	public void clickONbtnViewMyPositionList()
	{
		String result = driver.findElement(btnViewMyPositionList).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewMyPositionList);
		 }
	}
	
	
	//My Space >> Employee Data >> Project
	By btnRadioMyProject  = By.xpath("//input[@id='IsActive-124']");
	By btnViewAssignProject = By.xpath("//input[@id='IsActive-125']");
	
	

	public void clickOFFbtnRadioMyProject()
	{
		String result = driver.findElement(btnRadioMyProject).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnRadioMyProject);
		 }
	}
	
	public void clickONbtnRadioMyProject()
	{
		String result = driver.findElement(btnRadioMyProject).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnRadioMyProject);
		 }
	}
	

	public void clickOFFbtnViewAssignProject()
	{
		String result = driver.findElement(btnViewAssignProject).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewAssignProject);
		 }
	}
	
	public void clickONbtnViewAssignProject()
	{
		String result = driver.findElement(btnViewAssignProject).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewAssignProject);
		 }
	}
	
	//My Space >> Employee Data >> Salary Infomation 
	By btnRadioMySalaryInfomation  = By.xpath("//input[@id='IsActive-126']");
	By btnViewSalaryInformation  = By.xpath("//input[@id='IsActive-127']");
	By subTabEmployeeData = By.xpath("(//ul[@id='subModuleList']//a)[1]");
	
	public void clickSubTabEmployeeData()
	{
		waitFluentWait(subTabEmployeeData);
		click(subTabEmployeeData);
	}
		
	public void clickOFFbtnRadioMySalaryInfomation()
	{
		String result = driver.findElement(btnRadioMySalaryInfomation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnRadioMySalaryInfomation);
		 }
	}
	
	public void clickONbtnRadioMySalaryInfomation()
	{
		String result = driver.findElement(btnRadioMySalaryInfomation).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnRadioMySalaryInfomation);
		 }
	}
	

	public void clickOFFbtnViewSalaryInformation()
	{
		String result = driver.findElement(btnViewSalaryInformation).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewSalaryInformation);
		 }
	}
	
	public void clickONbtnViewSalaryInformation()
	{
		String result = driver.findElement(btnViewSalaryInformation).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewSalaryInformation);
		 }
	}
	
	
	//My Space >> Talent >> My Skills 
	By btnRadioMySkills = By.xpath("//input[@id='IsActive-129']");
	By btnViewMySkills = By.xpath("//input[@id='IsActive-130']");
	By btnAddMySkills = By.xpath("//input[@id='IsActive-131']");
	By subTabTalent = By.xpath("(//ul[@id='subModuleList']//a)[2]");
	
	By radioMySkills = By.xpath("//label[@for='IsActive-129']");
	By viewMySkills = By.xpath("//label[@for='IsActive-130']");
	By addMySkills = By.xpath("//label[@for='IsActive-131']");
	
	public void clickSubTabTalent()
	{
		waitFluentWait(subTabTalent);
		click(subTabTalent);
	}
	

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
	
	
	public void clickOFFbtnAddMySkills()
	{
		String result = driver.findElement(btnAddMySkills).getAttribute("checked");
		 if (result!=null)
		 {
			 click(addMySkills);
		 }
	}
	
	public void clickONbtnAddMySkills()
	{
		String result = driver.findElement(btnAddMySkills).getAttribute("checked");
		 if (result==null)
		 {
			 click(addMySkills);
		 }
	}
	
	//My Space >> Talent >> Learner 360
	By btnRadioMyLearner360  = By.xpath("//input[@id='IsActive-132']");
	By btnViewLearner360 = By.xpath("//input[@id='IsActive-133']");
	
	By radioMyLearner360  = By.xpath("//label[@for='IsActive-132']");
	By viewLearner360 = By.xpath("//label[@for='IsActive-133']");
	
	public void clickOFFbtnRadioMyLearner360()
	{
		String result = driver.findElement(btnRadioMyLearner360).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyLearner360);
		 }
	}
	
	public void clickONbtnRadioMyLearner360()
	{
		String result = driver.findElement(btnRadioMyLearner360).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyLearner360);
		 }
	}
	

	public void clickOFFbtnViewLearner360()
	{
		String result = driver.findElement(btnViewLearner360).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewLearner360);
		 }
	}
	
	public void clickONbtnViewLearner360()
	{
		String result = driver.findElement(btnViewLearner360).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewLearner360);
		 }
	}
	
	//My Space >> Talent >> Career Path
	By btnRadioMyCareerPath  = By.xpath("//input[@id='IsActive-134']");
	By btnViewCareerPath = By.xpath("//input[@id='IsActive-135']");
	By btnAddSuccessionPlan = By.xpath("//input[@id='IsActive-136']");
	
	By radioMyCareerPath  = By.xpath("//label[@for='IsActive-134']");
	By viewCareerPath = By.xpath("//label[@for='IsActive-135']");
	By addSuccessionPlan = By.xpath("//label[@for='IsActive-136']");
	
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
		
	public void clickOFFbtnViewCareerPath()
	{
		String result = driver.findElement(btnViewCareerPath).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewCareerPath);
		 }
	}
	
	public void clickONbtnViewCareerPath()
	{
		String result = driver.findElement(btnViewCareerPath).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewCareerPath);
		 }
	}
	
	public void clickOFFbtnAddSuccessionPlan()
	{
		String result = driver.findElement(btnAddSuccessionPlan).getAttribute("checked");
		 if (result!=null)
		 {
			 click(addSuccessionPlan);
		 }
	}
	
	public void clickONbtnAddSuccessionPlan()
	{
		String result = driver.findElement(btnAddSuccessionPlan).getAttribute("checked");
		 if (result==null)
		 {
			 click(addSuccessionPlan);
		 }
	}
	
	//My Space >> My Contribution >> Questions
	By btnRadioMyQuestionsContribution  = By.xpath("//input[@id='IsActive-138']");
	By btnViewQuestionContribution  = By.xpath("//input[@id='IsActive-139']");
	By btnContributionQuestion  = By.xpath("//input[@id='IsActive-140']");
	By subTabMyContribution = By.xpath("(//ul[@id='subModuleList']//a)[3]");
	
	By radioMyQuestionsContribution  = By.xpath("//label[@for='IsActive-138']");
	By viewQuestionContribution  = By.xpath("//label[@for='IsActive-139']");
	By contributionQuestion  = By.xpath("//label[@for='IsActive-140']");
	
	public void clickSubTabMyContribution()
	{
		waitFluentWait(subTabMyContribution);
		click(subTabMyContribution);
	}
	
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
	By btnRadioMyQuestionsPendingApprovals = By.xpath("//input[@id='IsActive-142']");
	By btnViewQuestionApprovals = By.xpath("//input[@id='IsActive-143']");
	By btnApprovemassApproveQuestions = By.xpath("//input[@id='IsActive-144']");
	By btnRejectmassRejectQuestions = By.xpath("//input[@id='IsActive-145']");
	
	By radioMyQuestionsPendingApprovals = By.xpath("//label[@for='IsActive-142']");
	By viewQuestionApprovals = By.xpath("//label[@for='IsActive-143']");
	By approvemassApproveQuestions = By.xpath("//label[@for='IsActive-144']");
	By rejectmassRejectQuestions = By.xpath("//label[@for='IsActive-145']");	
	
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
	
	//My Space >> Pending Approvals >> Test 
	By btnRadioMyTestPendingApprovals = By.xpath("//input[@id='IsActive-146']");
	By btnViewTestApprovals = By.xpath("//input[@id='IsActive-147']");
	By btnApprovemassApproveTests = By.xpath("//input[@id='IsActive-148']");
	By btnRejectmassRejectTests = By.xpath("//input[@id='IsActive-149']");
	

	public void clickOFFbtnRadioMyTestPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyTestPendingApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnRadioMyTestPendingApprovals);
		 }
	}
	
	public void clickONbtnRadioMyTestPendingApprovals()
	{
		String result = driver.findElement(btnRadioMyTestPendingApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnRadioMyTestPendingApprovals);
		 }
	}
	
	public void clickOFFbtnViewTestApprovals()
	{
		String result = driver.findElement(btnViewTestApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnViewTestApprovals);
		 }
	}
	
	public void clickONbtnViewTestApprovals()
	{
		String result = driver.findElement(btnViewTestApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnViewTestApprovals);
		 }
	}
	
	public void clickOFFbtnApprovemassApproveTests()
	{
		String result = driver.findElement(btnApprovemassApproveTests).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnApprovemassApproveTests);
		 }
	}
	
	public void clickONbtnApprovemassApproveTests()
	{
		String result = driver.findElement(btnApprovemassApproveTests).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnApprovemassApproveTests);
		 }
	}
		
	public void clickOFFbtnRejectmassRejectTests()
	{
		String result = driver.findElement(btnRejectmassRejectTests).getAttribute("checked");
		 if (result!=null)
		 {
			 click(btnRejectmassRejectTests);
		 }
	}
	
	public void clickONbtnRejectmassRejectTests()
	{
		String result = driver.findElement(btnRejectmassRejectTests).getAttribute("checked");
		 if (result==null)
		 {
			 click(btnRejectmassRejectTests);
		 }
	}
	
	//My Space >> Pending Approvals >> Test Results 
	By btnRadioMyTestResults = By.xpath("//input[@id='IsActive-150']");
	By btnViewTestResultApprovals	 = By.xpath("//input[@id='IsActive-151']");
	By btnApprovemassApproveTestResults = By.xpath("//input[@id='IsActive-152']");
	By btnRejectmassRejectTestResults = By.xpath("//input[@id='IsActive-153']");
	By subTabPendingApprovals = By.xpath("(//ul[@id='subModuleList']//a)[4]");
	
	By radioMyTestResults = By.xpath("//label[@for='IsActive-150']");
	By viewTestResultApprovals	 = By.xpath("//label[@for='IsActive-151']");
	By approvemassApproveTestResults = By.xpath("//label[@for='IsActive-152']");
	By rejectmassRejectTestResults = By.xpath("//label[@for='IsActive-153']");
	
	public void clickSubTabPendingApprovals()
	{
		waitFluentWait(subTabPendingApprovals);
		click(subTabPendingApprovals);
	}
	
	public void clickOFFbtnRadioMyTestResults()
	{
		String result = driver.findElement(btnRadioMyTestResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(radioMyTestResults);
		 }
	}
	
	public void clickONbtnRadioMyTestResults()
	{
		String result = driver.findElement(btnRadioMyTestResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(radioMyTestResults);
		 }
	}

	public void clickOFFbtnViewTestResultApprovals()
	{
		String result = driver.findElement(btnViewTestResultApprovals).getAttribute("checked");
		 if (result!=null)
		 {
			 click(viewTestResultApprovals);
		 }
	}
	
	public void clickONbtnViewTestResultApprovals()
	{
		String result = driver.findElement(btnViewTestResultApprovals).getAttribute("checked");
		 if (result==null)
		 {
			 click(viewTestResultApprovals);
		 }
	}
	
	public void clickOFFbtnApprovemassApproveTestResults()
	{
		String result = driver.findElement(btnApprovemassApproveTestResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(approvemassApproveTestResults);
		 }
	}
	
	public void clickONbtnApprovemassApproveTestResults()
	{
		String result = driver.findElement(btnApprovemassApproveTestResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(approvemassApproveTestResults);
		 }
	}

	public void clickOFFbtnRejectmassRejectTestResults()
	{
		String result = driver.findElement(btnRejectmassRejectTestResults).getAttribute("checked");
		 if (result!=null)
		 {
			 click(rejectmassRejectTestResults);
		 }
	}
	
	public void clickONbtnRejectmassRejectTestResults()
	{
		String result = driver.findElement(btnRejectmassRejectTestResults).getAttribute("checked");
		 if (result==null)
		 {
			 click(rejectmassRejectTestResults);
		 }
	}*/
	
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
	
	//Popup Confirm
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'YES')]");
	By btnNo = By.xpath("//button[contains(.,'NO')]");
	
	public boolean isLblConfirmationDisplayed()
	{
		boolean flag = false;
			try {
			if (driver.findElements(lblConfirmation).size() > 0) {
				flag = true;
		}
			} catch (Exception e) {
			return flag;
		}
			return flag;
	}
	
	public boolean checkBtnYesAvailble()
	{
		try {
			if (isElementVisible(btnYes)==true)
			{
				return true;
			}	
	            else
	        {
	          	return false;
	        }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	            return false;
	        }
	}
		    
	public void clickBtnYes()
	{
		waitFluentWait(btnYes);
		click(btnYes);
	}

	
	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}
}
