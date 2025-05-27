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
import wize.pages.Baseline_AddPosition;
import wize.pages.Baseline_Position;
import wize.pages.Baseline_UpdatePosition;
import wize.pages.ControlBoard;
import wize.pages.Form_Add_Update_SkillToBaseline_Job;
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_CreateFunctionSet;
import wize.pages.Form_CreateJob;
import wize.pages.Form_CreateJobLevel;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_CreateProduct;
import wize.pages.Form_CreateQuestion;
import wize.pages.Form_CreateRole;
import wize.pages.Form_CreateSecurityProfile;
import wize.pages.Form_Create_Skill_DefineLevel;
import wize.pages.Form_Create_Skill_Information;
import wize.pages.Form_Create_Skill_PreviewFinish;
import wize.pages.Form_EditBusinessUnit;
import wize.pages.Form_EditJob;
import wize.pages.Form_EditPosition;
import wize.pages.Form_EditProduct;
import wize.pages.Form_EditUser;
import wize.pages.Form_Edit_Skill_DefineLevel;
import wize.pages.Form_Edit_Skill_Information;
import wize.pages.Form_Edit_Skill_PreviewFinish;
import wize.pages.Form_JobDetails;
import wize.pages.Form_PositionDetails;
import wize.pages.Form_QuestionDetails;
import wize.pages.Form_UpdateSkillToBaseline_Position;
import wize.pages.FunctionSet;
import wize.pages.GeneralSettings;
import wize.pages.GeneralSettings_Organization;
import wize.pages.JobLevelList;
import wize.pages.JobList;
import wize.pages.LoginScreen;
import wize.pages.Organization;
import wize.pages.Organization_BusinessUnit;
import wize.pages.Organization_Product;
import wize.pages.PositionList;
import wize.pages.QuestionPool;
import wize.pages.RoleManagement;
import wize.pages.SecurityProfile;
import wize.pages.SkillList;
import wize.pages.UserManagement;

public class CreateNew_DataTest extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	JobList jobList;
	Form_JobDetails formJobDetails;
	Form_CreateJob formCreateJob;
	Form_EditJob formEditJob;
	JobLevelList jobLevelList;
	Form_CreateJobLevel formCreateJobLevel;
	SkillList skillList;
	Form_Create_Skill_Information createSkillInformation;
	Form_Create_Skill_DefineLevel createDefineLevel;
	Form_Create_Skill_PreviewFinish createPreviewFinish;
	Form_Edit_Skill_Information editSkillInformation;
	Form_Edit_Skill_DefineLevel editDefineLevel;
	Form_Edit_Skill_PreviewFinish editPreviewFinish;
	GeneralSettings generalSettings;
	GeneralSettings_Organization generalSettingsOrganization;
	PositionList positionList;
	Form_PositionDetails formPositionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;
	FunctionSet functionSet;
	Form_CreateFunctionSet createFunctionSet;
	SecurityProfile securityProfile;
	Form_CreateSecurityProfile createSecurityProfile;
	RoleManagement roleManagement;
	Form_CreateRole createRole;
	Organization organization;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_EditBusinessUnit editBusinessUnit;
	Organization_Product product;
	Form_CreateProduct createProduct;
	Form_EditProduct editProduct;
	QuestionPool questionPool;
	Form_CreateQuestion formCreateQuestion;
	Form_QuestionDetails formQuestionDetails;
	Form_Add_Update_SkillToBaseline_Job formAddSkillToBaseline;
	Form_UpdateSkillToBaseline_Position formUpdateSkillToBaseline;
	Baseline_AddPosition baselineAddPosition;
	Baseline_UpdatePosition baselineUpdatePosition;
	Baseline_Position baselinePosition;
	Form_EditUser editUser;
	UserManagement userManagement;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		jobList = new JobList(driver);
		formJobDetails = new Form_JobDetails(driver);
		formCreateJob = new Form_CreateJob(driver);
		formEditJob = new Form_EditJob(driver);
		jobLevelList = new JobLevelList(driver);
		formCreateJobLevel = new Form_CreateJobLevel(driver);
		skillList = new SkillList(driver);
		createSkillInformation = new Form_Create_Skill_Information(driver);
		createDefineLevel = new Form_Create_Skill_DefineLevel(driver);
		createPreviewFinish = new Form_Create_Skill_PreviewFinish(driver);
		editSkillInformation = new Form_Edit_Skill_Information(driver);
		editDefineLevel = new Form_Edit_Skill_DefineLevel(driver);
		editPreviewFinish = new Form_Edit_Skill_PreviewFinish(driver);
		generalSettings = new GeneralSettings(driver);
		generalSettingsOrganization = new GeneralSettings_Organization(driver);
		positionList = new PositionList(driver);
		formPositionDetails = new Form_PositionDetails(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		formEditPosition = new Form_EditPosition(driver);
		functionSet = new FunctionSet(driver);
		createFunctionSet = new Form_CreateFunctionSet(driver);
		securityProfile = new SecurityProfile(driver);
		createSecurityProfile = new Form_CreateSecurityProfile(driver); 
		roleManagement = new RoleManagement(driver);
		createRole = new Form_CreateRole(driver);
		organization = new Organization(driver);
		businessUnit = new Organization_BusinessUnit(driver);
		createBusinessUnit = new Form_CreateBusinessUnit(driver);
		editBusinessUnit = new Form_EditBusinessUnit(driver);
		product = new Organization_Product(driver);
		createProduct = new Form_CreateProduct(driver);
		editProduct = new Form_EditProduct(driver);
		questionPool = new QuestionPool(driver);
		formCreateQuestion = new Form_CreateQuestion(driver);
		formQuestionDetails = new Form_QuestionDetails(driver);
		formAddSkillToBaseline = new Form_Add_Update_SkillToBaseline_Job(driver);
		formUpdateSkillToBaseline = new Form_UpdateSkillToBaseline_Position(driver);
		baselineAddPosition = new Baseline_AddPosition(driver);
		baselineUpdatePosition = new Baseline_UpdatePosition(driver);
		baselinePosition = new Baseline_Position(driver);
		editUser = new Form_EditUser(driver);
		userManagement = new UserManagement(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = false)

	public void Create_DataTest_For_JobLevel() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Job Level List");

		controlBoard.clickLblJobLevel();
		
		if (jobLevelList.isLblJobLevelListDisplayed() == true) {
			setStatusTest("pass", "Access to Job Level List");
		} else {
			setStatusTest("fail", "Not Access to Job Level List");
		}
		
		TestLogger.info("3. Create Job Level");
		
		jobLevelList.clickBtnCreate();
		
		if (formCreateJobLevel.isLblCreateJobLevelDisplayed() == true) {
			setStatusTest("pass", "Open Create Job Level popup");
		} else {
			setStatusTest("fail", "Not Open Create Job Level popup");
		}
		
		formCreateJobLevel.fillJobLevel(DataManager.Test);
		formCreateJobLevel.fillDescription(DataManager.Test);
		formCreateJobLevel.clickBtnSave();
	
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job Level created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job Level created successfully");
		}
	}
	
	@Test(priority = 2, enabled = false)
	
	public void Create_DataTest_For_Job() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");
	
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Job List");
	
		controlBoard.clickLblJob();
		
		if (jobList.isLblJobListDisplayed() == true) {
			setStatusTest("pass", "Access to Job List");
		} else {
			setStatusTest("fail", "Not Access to Job List");
		}
		
		TestLogger.info("3. Create Data");
		
		jobList.clickBtnCreate();
		
		if (formCreateJob.isLblCreateJobDisplayed() == true) {
			setStatusTest("pass", "Open Create Job popup");
		} else {
			setStatusTest("fail", "Not Open Create Job popup");
		}
		
		formCreateJob.inputData(DataManager.Test,DataManager.Test,DataManager.Test);
		formCreateJob.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Job created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Job created successfully");
		}
	}

	@Test(priority = 3, enabled = false)

	public void Create_DataTest_For_GereralSettings_Ogranzation() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Genaral Setting >> Organization");

		controlBoard.clickLblGeneralSettings();
		
		if (generalSettings.isLblGeneralSettingsDisplayed() == true) {
			setStatusTest("pass", "Access to Genaral Setting");
		} else {
			setStatusTest("fail", "Not Access to Genaral Setting");
		}
		
		generalSettings.clickSubMenuOrganization();
		
		TestLogger.info("3. Update");
		
		if(generalSettingsOrganization.isBtnDeactiveDisplayed()== true)
		{
			generalSettingsOrganization.clickBtnRadio();
			generalSettingsOrganization.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Success");
			} else {
				setStatusTest("fail", "Update NOT Success");
			}
		}
		else
		{
			if (controlBoard.isAvatarDisplayed() == true) {
				controlBoard.logout();
			}
		}
	}
	
	@Test(priority = 4, enabled = false)

	public void Create_DataTest_FunctionSet() throws InterruptedException {
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
		
		TestLogger.info("3. Create Function Set");
		
		functionSet.clickBtnAddFunctionSet();
		
		if (createFunctionSet.isLblCreateFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Create Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Create Function Set popup");
		}
		
		createFunctionSet.fillName(DataManager.FunctionSet);
		createFunctionSet.fillDescription(DataManager.FunctionSet);
		createFunctionSet.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Function Set created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Function Set created sucessfully");
		}
		
		TestLogger.info("4. Access to Role Management");

		loginScreen.clickIconControlBoard();
		controlBoard.clickLblRole();
		
		if (roleManagement.isLblRoleManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Role Management ");
		} else {
			setStatusTest("fail", "Not Access to Role Management ");
		}
		
		TestLogger.info("5. Create Role");
		
		roleManagement.clickBtnAdd();
		
		if (createRole.isLblCreateRolelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createRole.fillRoleName(DataManager.FunctionSet);
		createRole.fillSearchFSName(DataManager.FunctionSet);
		createRole.clickBtnRadio();
		createRole.clickBtnSave();
	
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Role Management created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Role Management created successfully");
		}
		
		TestLogger.info("6. Access to Security Profile ");

		loginScreen.clickIconControlBoard();
		controlBoard.clickLblSecurityProfile();
		
		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile ");
		} else {
			setStatusTest("fail", "Not Access to Security Profile ");
		}
		
		TestLogger.info("7. Create SECURITY PROFILE");
		
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.fillSPName(DataManager.FunctionSet);
		createSecurityProfile.fillDescription(DataManager.FunctionSet);
		createSecurityProfile.fillSearchRolename(DataManager.FunctionSet);
		createSecurityProfile.clickBtnRadio();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		
		TestLogger.info("8. Assign function set for Account User");
		
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblUser();
		
		if (userManagement.isLblUserManagementDisplayed() == true) 
		{
			setStatusTest("pass", "Access to USER MANAGEMENT");
		} else 
		{
			setStatusTest("fail", "NOT Access to USER MANAGEMENT");
		}
		
		userManagement.openEditPopup(PropertyManager.EmailUser);
		editUser.updateFunctionSet(DataManager.FunctionSet);
		editUser.clickBtnSave();
				
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "User updated sucessfully");
		} 
		else 
		{
			setStatusTest("fail","NOT Displays msg: " + "User updated sucessfully");
		}	
	}
	
	@Test(priority = 5, enabled = false)

	public void Create_DataTest_Organization() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Organization");

		controlBoard.clickLblOrganization();
		
		if (businessUnit.isLblBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Access to Organization");
		} else {
			setStatusTest("fail", "Not Access to Organization");
		}
		
		TestLogger.info("3. Create Organization");
		
		businessUnit.clickBtnAdd();
		
		if (createBusinessUnit.isLblCreateBusinessUnitDisplayed() == true) {
			setStatusTest("pass", "Open Create Business Unit popup");
		} else {
			setStatusTest("fail", "NOT Open Create Business Unit popup");
		}
		
		createBusinessUnit.fillName(DataManager.Test);
		createBusinessUnit.fillDescription(DataManager.Test);
		createBusinessUnit.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Business Unit created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Business Unit created sucessfully");
		}
		
		TestLogger.info("4. Create PRODUCT LIST");
		
		organization.clickMenuProduct();
		
		if (product.isLblProductListDisplayed() == true) {
			setStatusTest("pass", "Access to PRODUCT LIST");
		} else {
			setStatusTest("fail", "Not Access to PRODUCT LIST");
		}
		
		product.clickBtnAddProduct();
		
		if (createProduct.isLblCreateProductDisplayed() == true) {
			setStatusTest("pass", "Access to Create Product popup");
		} else {
			setStatusTest("fail", "Not Access to Create Product popup");
		}
		
		createProduct.createProduct(DataManager.Test, DataManager.Test);
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Product created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Product created sucessfully");
		}
	}
	
	@Test(priority = 6, enabled = false)

	public void Create_DataTest_For_QuestionPoolAndMyContribution() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Skill");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillDetailsDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "Not Access to Skill");
		}
		
		TestLogger.info("3. Create Category");
		
		skillList.clickBtnAddCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "Blank text box is display");
		} else {
			setStatusTest("fail", "Blank text box is NOT display");
		}
		
		skillList.fillCategoryName("Automation Question Pool 1");
		skillList.clickIconSaveCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill category 'Automation Question Pool 1' created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Skill category 'Automation Question Pool 1' created sucessfully");
		}
		
		skillList.clickBtnAddCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "Blank text box is display");
		} else {
			setStatusTest("fail", "Blank text box is NOT display");
		}
		
		skillList.fillCategoryName(DataManager.Baseline2);
		skillList.clickIconSaveCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill category 'Automation Question Pool 2' created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Skill category 'Automation Question Pool 2' created sucessfully");
		}
		
		TestLogger.info("4. Create Test Automation 1 has linked behaviors");
		
		skillList.searchCategory("Automation Question Pool 1");
		skillList.clickFirtItemCategory();
		
		skillList.clickBtnAddSkill();
		
		if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
		
		createSkillInformation.fillSkillName(DataManager.Skill1,DataManager.FunctionSet);
		
		createSkillInformation.clickIconPlusDomain();
		createSkillInformation.fillDomainName(DataManager.Domain);
		
		if (createSkillInformation.isLblDomainKnowledgeDisplayed() == true) {
			setStatusTest("pass","Add Domain Knowledge Success");
		} else {
			setStatusTest("fail","Add Domain Knowledge NOT Success");
		}
		
		createSkillInformation.clickLblDomain();
		createSkillInformation.clickBtnAddBehaviorForDomain();
		
		if (createSkillInformation.isTxtBehaviorForDomainDisplayed() == true) {
			setStatusTest("pass","Open Add Behaviors for Domain Knowledge");
		} else {
			setStatusTest("fail","NOT Open Add Behaviors for Domain Knowledge");
		}
		
		createSkillInformation.fillBehaviorForDomain(DataManager.Behaviors);
		createSkillInformation.clickIconSaveBehaviorForDomain();
		
		if (createSkillInformation.isLblBehaviorForDomainDisplayed() == true) {
			setStatusTest("pass","Add Behaviors for Domain Knowledge Success");
		} else {
			setStatusTest("fail","Add Behaviors for Domain Knowledge NOT Success");
		}
		
		createSkillInformation.clickBtnNext();
		
		if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
							
		createDefineLevel.clickBtnNext();
		
		if (createPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
	
		createPreviewFinish.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("5. Create Test Automation 2 NO has linked behaviors");
		
		skillList.clickIconRemoveCategory();
		skillList.searchCategory(DataManager.Baseline1);
		skillList.clickFirtItemCategory();
		
		skillList.clickBtnAddSkill();
		createSkillInformation.fillSkillName(DataManager.Skill2,DataManager.FunctionSet);
		createSkillInformation.clickBtnNext();
		
		if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
	
		createDefineLevel.clickBtnNext();
		
		if (createPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
		
		createPreviewFinish.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("6. Create Test Automation 3 NO has linked behaviors");
		
		skillList.searchCategory(DataManager.Baseline1);
		skillList.clickFirtItemCategory();
		
		skillList.clickBtnAddSkill();
		createSkillInformation.fillSkillName(DataManager.Skill3,DataManager.FunctionSet);
		createSkillInformation.clickBtnNext();
		
		if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
	
		createDefineLevel.clickBtnNext();
		
		if (createPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
		
		createPreviewFinish.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("7. Create Test 1 NO has linked behaviors");
		
		skillList.clickIconRemoveCategory();
		skillList.searchCategory(DataManager.Baseline2);
		skillList.clickFirtItemCategory();
		
		skillList.clickBtnAddSkill();
		createSkillInformation.fillSkillName(DataManager.Skill4,DataManager.FunctionSet);
		createSkillInformation.clickBtnNext();
		
		if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
	
		createDefineLevel.clickBtnNext();
		
		if (createPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
		
		createPreviewFinish.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
	}
	
	@Test(priority = 7, enabled = true)

	public void Create_DataTest_Assessment() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Skill >> Create Assessment Skill Test has linked behaviors");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "Not Access to Skill");
		}
			
		skillList.searchCategory(DataManager.Baseline2);
		skillList.clickFirtItemCategory();
		
		skillList.clickBtnAddSkill();
		
		if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
		Thread.sleep(3500);
		createSkillInformation.fillSkillName(DataManager.Assessment,DataManager.Assessment);
		
		createSkillInformation.clickIconPlusDomain();
		createSkillInformation.fillDomainName(DataManager.Domain);
		
		if (createSkillInformation.isLblDomainKnowledgeDisplayed() == true) {
			setStatusTest("pass","Add Domain Knowledge Success");
		} else {
			setStatusTest("fail","Add Domain Knowledge NOT Success");
		}
		
		createSkillInformation.clickLblDomain();
		createSkillInformation.clickBtnAddBehaviorForDomain();
		
		if (createSkillInformation.isTxtBehaviorForDomainDisplayed() == true) {
			setStatusTest("pass","Open Add Behaviors for Domain Knowledge");
		} else {
			setStatusTest("fail","NOT Open Add Behaviors for Domain Knowledge");
		}
		
		createSkillInformation.fillBehaviorForDomain(DataManager.Behaviors);
		createSkillInformation.clickIconSaveBehaviorForDomain();
		
		if (createSkillInformation.isLblBehaviorForDomainDisplayed() == true) {
			setStatusTest("pass","Add Behaviors for Domain Knowledge Success");
		} else {
			setStatusTest("fail","Add Behaviors for Domain Knowledge NOT Success");
		}
		
		createSkillInformation.clickBtnNext();
		
		if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
						
		createDefineLevel.clickIconEditL1();
		
		if (createDefineLevel.isLblBehaviorPopupDisplayed() == true) {
			setStatusTest("pass","Displays Behavior popup");
		} else {
			setStatusTest("fail","NOT Display Behavior popup");
		}
		
		createDefineLevel.selectMonth();
		createDefineLevel.selectYear();
		createDefineLevel.tickOnBehavior();
		createDefineLevel.clickBtnSave();
		
		createDefineLevel.clickBtnNext();
		
		if (createPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
	
		createPreviewFinish.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("3. Access to Position List >> Create new position");

		loginScreen.clickIconControlBoard();
		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}
		
		positionList.clickBtnCreate();
		
		if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
			setStatusTest("pass", "Open Create Position popup");
		} else {
			setStatusTest("fail", "Not Open Create Position popup");
		}
		
		formCreatePosition.inputData(DataManager.Assessment,DataManager.Test,DataManager.Test);
		formCreatePosition.clickBtnSave();
		
		TestLogger.info("4. Access to Baseline >> Add Skill to baseline");

		loginScreen.clickIconControlBoard();
		controlBoard.clickLblBaseLine();
		
		if (baselinePosition.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Access to Talent-Baseline");
		} else {
			setStatusTest("fail", "Not Access to Talent-Baseline");
		}  
		
		baselinePosition.fillTxtSearchPostion(DataManager.Assessment);
		baselineAddPosition.clickBtnAddSkill();
		
		if (formAddSkillToBaseline.isLblAddSkillToBaseLineDisplayed() == true) {
			setStatusTest("pass", "Open Add Skill to Baseline popup");
		} else {
			setStatusTest("fail", "Not Open Add Skill to Baseline popup");
		}
		
		formAddSkillToBaseline.inputData(DataManager.Baseline2,DataManager.Assessment);
		formAddSkillToBaseline.clickBtnAdd();
		
		if (baselinePosition.isLblBaselineNameDisplayed() == true) {
			setStatusTest("pass", "Add Skill to Baseline Successful");
		} else {
			setStatusTest("fail", "Add Skill to Baseline NOT Successful");
		}
		
		baselineUpdatePosition.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System display M013: [Baseline updated successfully.]Label Baseline");
		} else {
			setStatusTest("fail", "System display M013: [Baseline updated successfully.]Label Baseline");
		}		
		
		TestLogger.info("5. Access to Question Pool >> Create New Category >> Create Question Pool for Skill Test");

		loginScreen.clickIconControlBoard();
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
				
		questionPool.createCategory(DataManager.Assessment, PropertyManager.EmailAdmin);
		questionPool.fillSearchCategory(DataManager.Assessment);
		questionPool.clickFirstCategory();
	
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Question screen ");
		} else {
			setStatusTest("fail", "Not Access to Question screen");
		}
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompetency();
		
		formCreateQuestion.fillQuestionText(DataManager.Assessment);
		
		formCreateQuestion.selectSkill(DataManager.Assessment);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.Assessment);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		//question 2
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompetency();
		
		formCreateQuestion.fillQuestionText(DataManager.Assessment1);
		
		formCreateQuestion.selectSkill(DataManager.Assessment);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.Assessment1);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		TestLogger.info("6. Create Question for Compliance");
		
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.fillQuestionText(DataManager.AssessmentCompliance);
		
		formCreateQuestion.selectSkill(DataManager.Assessment);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.AssessmentCompliance);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
		
		//question 2
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();

		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		
		formCreateQuestion.clickDrplistCompletionTime();
		formCreateQuestion.clickItem1();
		
		formCreateQuestion.clickBtnAssignToMe();
		
		formCreateQuestion.clickDrplistPool();
		formCreateQuestion.clickItemCompliance();
		
		formCreateQuestion.fillQuestionText(DataManager.AssessmentCompliance1);
		
		formCreateQuestion.selectSkill(DataManager.Assessment);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswer(DataManager.AssessmentCompliance1);
		formCreateQuestion.clickBtnRadio1();
		formCreateQuestion.clickIconSave1();
	
		if (formCreateQuestion.isIconEdit1Displayed() == true) {
			setStatusTest("pass", "Add anwser success");
		} else {
			setStatusTest("fail", "Add anwser NOT success");
		}
		
		formCreateQuestion.clickBtnSave();
		
		TestLogger.info("User CAN see/do: " + "Question created successfully.");
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question created successfully.");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question created successfully.");
		}
	}
	
	@Test(priority = 8, enabled = false)

	public void Create_DataTest_For_Position() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position");

		controlBoard.clickLblPosition();
		
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position");
		} else {
			setStatusTest("fail", "Not Access to Position");
		}
		
		TestLogger.info("3. Create Business Unit");
		
		positionList.clickBtnCreate();
		
		if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
			setStatusTest("pass", "Open Create Position popup");
		} else {
			setStatusTest("fail", "Not Open Create Position popup");
		}
		
		formCreatePosition.inputData(DataManager.Test,DataManager.Test,DataManager.Test);
		formCreatePosition.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Position created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
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
