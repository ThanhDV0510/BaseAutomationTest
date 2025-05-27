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
import wize.pages.Form_Create_Skill_DefineLevel;
import wize.pages.Form_Create_Skill_Information;
import wize.pages.Form_Create_Skill_PreviewFinish;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditUser;
import wize.pages.Form_Edit_Skill_DefineLevel;
import wize.pages.Form_Edit_Skill_Information;
import wize.pages.Form_Edit_Skill_PreviewFinish;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.SkillList;
import wize.pages.UserManagement;

public class Test_FunctionSet_Skills extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	SkillList skillList;
	Form_Create_Skill_Information createSkillInformation;
	Form_Create_Skill_DefineLevel createDefineLevel;
	Form_Create_Skill_PreviewFinish createPreviewFinish;
	Form_Edit_Skill_Information editSkillInformation;
	Form_Edit_Skill_DefineLevel editDefineLevel;
	Form_Edit_Skill_PreviewFinish editPreviewFinish;
	Clone_Form_EditFunctionSet cloneForm;
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		skillList = new SkillList(driver);
		createSkillInformation = new Form_Create_Skill_Information(driver);
		createDefineLevel = new Form_Create_Skill_DefineLevel(driver);
		createPreviewFinish = new Form_Create_Skill_PreviewFinish(driver);
		editSkillInformation = new Form_Edit_Skill_Information(driver);
		editDefineLevel = new Form_Edit_Skill_DefineLevel(driver);
		editPreviewFinish = new Form_Edit_Skill_PreviewFinish(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = false)

	public void TT25130_TT25131_TT25137() throws InterruptedException {

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
		
		TestLogger.info("3. Update Function Set|Skills | Full Permission ");
		
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
		TestLogger.info("5. User CAN see/do Skill subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkSkillOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Skill link on Control board");
		if(controlBoard.isLblSkillDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill link on Control Board");
		}
		TestLogger.info("7. Access to Skills >> Create New Caterogy");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "Access to Skills ");
		} else {
			setStatusTest("fail", "Not Access to Skills ");
		}
		
		skillList.searchCategory1(DataManager.Functional);
		if(skillList.isLinkClickHereCategoryDisplayed() == true)
		{
			skillList.clickBtnAddCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "Blank text box is display");
			} else {
				setStatusTest("fail", "Blank text box is NOT display");
			}
			
			skillList.fillCategoryName(DataManager.Functional);
			skillList.clickIconSaveCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
			}
						
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Category\r\n" 
					+ "2. Button Create Category\r\n"
					+ "3. Icon Edit Category\r\n"
					+ "4. Icon Delete Category");
			
			if (skillList. isLblSkillDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
		
			if (skillList.isBtnAddCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
			}
			
			if (skillList.isIconEditCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
			}
			
			if (skillList.isIconDeleteCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
			}
		}
		else
		{
			skillList.clickIconDeleteCategory();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category deleted sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category deleted sucessfully");
			}
			
			skillList.clickBtnAddCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "Blank text box is display");
			} else {
				setStatusTest("fail", "Blank text box is NOT display");
			}
			
			skillList.fillCategoryName(DataManager.Functional);
			skillList.clickIconSaveCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Category\r\n" 
					+ "2. Button Create Category\r\n"
					+ "3. Icon Edit Category\r\n"
					+ "4. Icon Delete Category");
			
			if (skillList. isLblSkillDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
		
			if (skillList.isBtnAddCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
			}
			
			if (skillList.isIconEditCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
			}
			
			if (skillList.isIconDeleteCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
			}
		}
				
		TestLogger.info("8. Update Category");
		
		skillList.clickIconEditCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "< category name> is displayed");
		} else {
		setStatusTest("fail", "< category name> is NOT displayed");
		}
				
		skillList.clickIconSaveCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == false) {
			setStatusTest("pass","Skill category updated success");
		} else {
			setStatusTest("fail","Skill category updated NOT success");
		}
		
		TestLogger.info("9. Delete Category");
		
		skillList.clickIconDeleteCategory();
						
		TestLogger.info("Expect : User CAN see/do: " + "Skill category deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Skill category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Skill category deleted successfully");
		}
	
		TestLogger.info("10. Create New Skill");
	
		skillList.clickIconRemoveCategory();
		skillList.clickBtnAddCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "Blank text box is display");
		} else {
			setStatusTest("fail", "Blank text box is NOT display");
		}
		
		skillList.fillCategoryName(DataManager.SkillCategory_TT_14737);
		skillList.clickIconSaveCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
		}
		
		skillList.searchCategory(DataManager.SkillCategory_TT_14737);
		skillList.clickFirtItemCategory();
		
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass","Open Skill List");
		} else {
			setStatusTest("fail","NOT Open Skill List");
		}
		
		skillList.clickBtnAddSkill();
			
		if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
				
		createSkillInformation.fillSkillName(DataManager.SkillName_TT_14737,DataManager.FunctionSet);
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
		
		TestLogger.info("Expect : User CAN see/do: " + "Skill created successfully.");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Skill\r\n"
				+ "2. Button Create Skill\r\n"
				+ "3. Button Edit Skill");
				
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Skill");
		}
					
		if (skillList.isBtnAddSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Skill");
		}
						
		if (skillList.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Edit Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Edit Skill");
		}
		
		TestLogger.info("11. Update Skill");
		
		skillList.clickBtnEdit();
		
		if (editSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
		
		editSkillInformation.fillDescription("change des");	
		editSkillInformation.clickBtnNext();
		
		if (editDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
	
		editDefineLevel.clickBtnNext();
		
		if (editPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
		
		editPreviewFinish.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Skill updated successfully.");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill updated successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill updated successfully.");
		}
		TestLogger.info("12. Click icon Control Board >> CAN Access Skill via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Skill/Index");
		if(!controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CAN access Skill list");
		}else{
			setStatusTest("fail", "User CANNOT access Skill list");
		}
	}
		
	@Test(priority = 2, enabled = false)

	public void TT25128_TT25129_TT25140() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | NO VIEW Permission");
		
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
		cloneForm.clickONbtnRadioOrganization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewSkills();
		cloneForm.clickOFFbtnCreateSkills();
		cloneForm.clickOFFbtnEditSkills();
		cloneForm.clickOFFbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Skills in Control Board");
		
		if (controlBoard.isLblSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Skills in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Skills in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Skill subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkSkillOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Skill sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Skill sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Skill via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Skill/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Skill list");
		}else{
			setStatusTest("fail", "User CAN access Skill list");
		}
	}
	
	@Test(priority = 3, enabled = false)

	public void TT25135() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | View & Create Permission");
		
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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSkills();
		cloneForm.clickONbtnCreateSkills();
		cloneForm.clickOFFbtnEditSkills();
		cloneForm.clickOFFbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills >> Create New Skills ");

		controlBoard.clickLblSkill();
//		skillList.searchCategory("Testing Automation4691");
		skillList.searchCategory(DataManager.SkillCategory_TT_14737);
		skillList.clickFirtItemCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (skillList. isLblSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
			
		if (skillList.isBtnAddCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (skillList.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (skillList.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		skillList.clickBtnAddSkill();
			
		if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
		
		
		createSkillInformation.fillSkillName(DataManager.SkillName_TT_14745,DataManager.FunctionSet);
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
		
		TestLogger.info("Expect : User CAN see/do: " + "Skill created successfully.");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill created successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Skill\r\n"
				+ "2. Button Create Skill");
				
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Skill");
		}
					
		if (skillList.isBtnAddSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Skill");
		}
								
		TestLogger.info("Expect : User CANNOT see/do: "  + "Button Edit Skill");
									
		if (skillList.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Edit Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Edit Skill");
		}
}
	
	@Test(priority = 4, enabled = false)

	public void TT25132_TT25133_TT25134() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | View Only Permission");
		
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
		
		TestLogger.info("5. User CAN see/do Skill subtab on icon menu Control board >> Talent ");
		if(controlBoard.isSubLinkSkillOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("6. User can see/do Skill link on Control board");
		if(controlBoard.isLblSkillDisplayed()){
			setStatusTest("pass", "User CAN see/do Skill link on Control Board");
		}else{
			setStatusTest("fail", "User CANNOT see/do Skill link on Control Board");
		}
		TestLogger.info("7. Access to Skills >> Open a Caterogy");

		controlBoard.clickLblSkill();
		skillList.searchCategory(DataManager.SkillCategory_TT_14737);
//		skillList.searchCategory("Testing Automation4691");
		skillList.clickFirtItemCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (skillList. isLblSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
			
		if (skillList.isBtnAddCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (skillList.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (skillList.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("8. Open a skill");
		
		skillList.clickItemFirstSkill();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Skill");
				
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Skill");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Skill\r\n"
				+ "2. Button Edit Skill");
									
		if (skillList.isBtnAddSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Skill");
		}
						
		if (skillList.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Edit Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Edit Skill");
		}
		TestLogger.info("9. Click icon Control Board >> CAN Access Skill via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Skill/Index");
		if(!controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CAN access Skill list");
		}else{
			setStatusTest("fail", "User CANNOT access Skill list");
		}
	}
	
	@Test(priority = 5, enabled = false)

	public void TT25136() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | View & Update Permission");
		
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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSkills();
		cloneForm.clickOFFbtnCreateSkills();
		cloneForm.clickONbtnEditSkills();
		cloneForm.clickOFFbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills >> Open a Caterogy");

		controlBoard.clickLblSkill();
		skillList.searchCategory(DataManager.SkillCategory_TT_14737);
//		skillList.searchCategory("Testing Automation4691");
		skillList.clickFirtItemCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (skillList. isLblSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
			
		if (skillList.isBtnAddCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (skillList.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (skillList.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
			
		TestLogger.info("6. Update Skill");
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Skill\r\n"
				+ "2. Button Edit Skill");
				
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Skill");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: " + "Button Create Skill");
															
		if (skillList.isBtnAddSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Skill");
		}
		
		skillList.clickItemFirstSkill();
		
		if (skillList.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Edit Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Edit Skill");
		}
		
		skillList.clickBtnEdit();
		
		if (editSkillInformation.isTabSkillInformationDisplayed() == true) {
			setStatusTest("pass","Display Skill Information tab");
		} else {
			setStatusTest("fail","NOT Display Skill Information tab");
		}
		Thread.sleep(2000);
		editSkillInformation.fillDescription14755("new description");
		editSkillInformation.clickBtnNext14755();
		
		if (editDefineLevel.isTabDefineLevelDisplayed() == true) {
			setStatusTest("pass","Displays Define Level tab");
		} else {
			setStatusTest("fail","NOT Display Define Level tab");
		}
	
		editDefineLevel.clickBtnNext14755();
		
		if (editPreviewFinish.isTabPreviewDisplayed() == true) {
			setStatusTest("pass","Displays Preview & Finish tab");
		} else {
			setStatusTest("fail","NOT Display Preview & Finish tab");
		}
		
		editPreviewFinish.clickBtnSave14755();
		
		TestLogger.info("Expect : User CAN see/do: " + "Skill updated successfully.");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill updated successfully.");
		} else {
			setStatusTest("fail"," NOT Displays msg: " + "Skill updated successfully.");
		}
}
	
	@Test(priority = 6, enabled = false)

	public void TT_14765() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | View & Delete Permission");
		
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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSkills();
		cloneForm.clickOFFbtnCreateSkills();
		cloneForm.clickOFFbtnEditSkills();
		cloneForm.clickOFFbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills >> Open a Caterogy");

		controlBoard.clickLblSkill();
		skillList.searchCategory(DataManager.SkillCategory_TT_14737);
//		skillList.searchCategory("Testing Automation4691");
		skillList.clickFirtItemCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (skillList. isLblSkillDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
			
		if (skillList.isBtnAddCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (skillList.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (skillList.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Open a skill");
		
		skillList.clickItemFirstSkill();
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Skill");
				
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Skill");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Skill");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Skill\r\n"
				+ "2. Button Edit Skill");
									
		if (skillList.isBtnAddSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Skill");
		}
						
		if (skillList.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Edit Skill");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Edit Skill");
		}
}
	
	@Test(priority = 7, enabled = false)

	public void TT_14771() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | View & Manage Skill Category Permission");
		
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
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickONbtnViewSkills();
		cloneForm.clickOFFbtnCreateSkills();
		cloneForm.clickOFFbtnEditSkills();
		cloneForm.clickONbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills >> Create New Caterogy");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "Access to Skills ");
		} else {
			setStatusTest("fail", "Not Access to Skills ");
		}
		
		skillList.searchCategory1(DataManager.Functional);
		if(skillList.isLinkClickHereCategoryDisplayed() == true)
		{
				
			skillList.clickBtnAddCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "Blank text box is display");
			} else {
				setStatusTest("fail", "Blank text box is NOT display");
			}
			
			skillList.fillCategoryName(DataManager.Functional);
			skillList.clickIconSaveCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Category\r\n" 
					+ "2. Button Create Category\r\n"
					+ "3. Icon Edit Category\r\n"
					+ "4. Icon Delete Category");
			
			if (skillList. isLblSkillDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
		
			if (skillList.isBtnAddCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
			}
			
			if (skillList.isIconEditCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
			}
			
			if (skillList.isIconDeleteCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
			}
			
			skillList.clickFirtItemCategory();
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Button Create Skill\r\n"
					+ "2. Button Edit Skill");
										
			if (skillList.isBtnAddSkillDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Create Skill");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Skill");
			}
							
			if (skillList.isBtnEditDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Edit Skill");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Edit Skill");
			}
		}
		else
		{
			skillList.clickIconDeleteCategory();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category deleted sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category deleted sucessfully");
			}
			
			skillList.clickBtnAddCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "Blank text box is display");
			} else {
				setStatusTest("fail", "Blank text box is NOT display");
			}
			
			skillList.fillCategoryName(DataManager.Functional);
			skillList.clickIconSaveCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
			}
						
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Category\r\n" 
					+ "2. Button Create Category\r\n"
					+ "3. Icon Edit Category\r\n"
					+ "4. Icon Delete Category");
			
			if (skillList. isLblSkillDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
		
			if (skillList.isBtnAddCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
			}
			
			if (skillList.isIconEditCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
			}
			
			if (skillList.isIconDeleteCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
			}
			
			skillList.clickFirtItemCategory();
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Button Create Skill\r\n"
					+ "2. Button Edit Skill");
										
			if (skillList.isBtnAddSkillDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Create Skill");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Skill");
			}
							
			if (skillList.isBtnEditDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Edit Skill");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Edit Skill");
			}
		}
		
		TestLogger.info("6. Update Category");
		
		skillList.clickIconEditCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "< category name> is displayed");
		} else {
		setStatusTest("fail", "< category name> is NOT displayed");
		}
				
		skillList.clickIconSaveCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == false) {
			setStatusTest("pass","Skill category updated success");
		} else {
			setStatusTest("fail","Skill category updated NOT success");
		}
		
		TestLogger.info("7. Delete Category");
		
		skillList.clickIconDeleteCategory();
						
		TestLogger.info("Expect : User CAN see/do: " + "Skill category deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Skill category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Skill category deleted successfully");
		}
	}

	@Test(priority = 8, enabled = false)

	public void TT25138() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | NO VIEW Permission");
		
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
		cloneForm.clickONbtnRadioOrganization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewSkills();
		cloneForm.clickONbtnCreateSkills();
		cloneForm.clickONbtnEditSkills();
		cloneForm.clickOFFbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Skills in Control Board");
		
		if (controlBoard.isLblSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Skills in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Skills in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Skill subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkSkillOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Skill sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Skill sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Skill via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Skill/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Skill list");
		}else{
			setStatusTest("fail", "User CAN access Skill list");
		}
	}
	
	@Test(priority = 8, enabled = true)

	public void TT25139() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Skills | NO VIEW Permission");
		
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
		cloneForm.clickONbtnRadioOrganization();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickBtnCollapse();
		cloneForm.clickOFFbtnViewSkills();
		cloneForm.clickOFFbtnCreateSkills();
		cloneForm.clickOFFbtnEditSkills();
		cloneForm.clickONbtnManageSkillCategory();
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
		
		TestLogger.info("5. Access to Skills ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Skills in Control Board");
		
		if (controlBoard.isLblSkillDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Skills in Control Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "hyperlink Skills in Control Board");
		}
		TestLogger.info("6. User CANNOT see/do Skill subtab on icon menu Control board >> Talent ");
		if(!controlBoard.isSubLinkSkillOnIconControlBoardDisplayed()){
			setStatusTest("pass", "User CANNOT see/do Skill sublink on icon menu Control board >> Talent");
		}else{
			setStatusTest("fail", "User CAN see/do Skill sublink on icon menu Control board >> Talent");
		}
		TestLogger.info("7. Click icon Control Board >> CANNOT Access Skill via URL");
		loginScreen.clickIconControlBoard();
		loginScreen.moLinkWeb(propertyManager.getURL_LnD() + "Skill/Index");
		if(controlBoard.isPage403Displayed()){
			setStatusTest("pass", "User CANNOT access Skill list");
		}else{
			setStatusTest("fail", "User CAN access Skill list");
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
