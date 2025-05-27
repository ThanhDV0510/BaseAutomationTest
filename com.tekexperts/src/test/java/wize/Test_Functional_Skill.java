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
import wize.pages.Form_Create_Skill_DefineLevel;
import wize.pages.Form_Create_Skill_Information;
import wize.pages.Form_Create_Skill_PreviewFinish;
import wize.pages.Form_Edit_Skill_DefineLevel;
import wize.pages.Form_Edit_Skill_Information;
import wize.pages.Form_Edit_Skill_PreviewFinish;
import wize.pages.LoginScreen;
import wize.pages.SkillList;

public class Test_Functional_Skill extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	SkillList skillList;
	Form_Create_Skill_Information createSkillInformation;
	Form_Create_Skill_DefineLevel createDefineLevel;
	Form_Create_Skill_PreviewFinish createPreviewFinish;
	Form_Edit_Skill_Information editSkillInformation;
	Form_Edit_Skill_DefineLevel editDefineLevel;
	Form_Edit_Skill_PreviewFinish editPreviewFinish;
				
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		skillList = new SkillList(driver);
		createSkillInformation = new Form_Create_Skill_Information(driver);
		createDefineLevel = new Form_Create_Skill_DefineLevel(driver);
		createPreviewFinish = new Form_Create_Skill_PreviewFinish(driver);
		editSkillInformation = new Form_Edit_Skill_Information(driver);
		editDefineLevel = new Form_Edit_Skill_DefineLevel(driver);
		editPreviewFinish = new Form_Edit_Skill_PreviewFinish(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_15019() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Skill");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "Not Access to Skill");
		}
		
		TestLogger.info("3. Click on icon Add Category >>  Input data less than or equal 250 characters >> Click on Save icon");
		
		skillList.clickBtnAddCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "Blank text box is display");
		} else {
			setStatusTest("fail", "Blank text box is NOT display");
		}
		
		skillList.fillCategoryName(DataManager.SkillCategory_TT_15019);
		skillList.clickIconSaveCategory();

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
		}
		
		TestLogger.info("4. Check < category name> in list");
		
		skillList.searchCategory(DataManager.SkillCategory_TT_15019);
				
		TestLogger.info("Expect : User CAN see/do: " + "The < category > is displayed");
		
		if(skillList.isFirtItemCategoryDisplayed() == true)
		{
			setStatusTest("pass", "The < category > is displayed");
		}
		else
		{
			setStatusTest("fail", "The < category > NOT is displayed");
		}
}

	@Test(priority = 2)

	public void TT_15021() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Skill");

		controlBoard.clickLblSkill();
		
		if (skillList.isLblSkillListDisplayed() == true) {
			setStatusTest("pass", "Access to Skill");
		} else {
			setStatusTest("fail", "Not Access to Skill");
		}
		
		TestLogger.info("3. Click on icon Add Category >>  Input data less than or equal 250 characters >> Click on X icon");
		
		skillList.clickBtnAddCategory();
		
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "Blank text box is display");
		} else {
			setStatusTest("fail", "Blank text box is NOT display");
		}
		
		skillList.fillCategoryName(DataManager.CategoryName);
		skillList.clickIconCancelCategory();

		if (skillList.isTxtCategoryNameDisplayed() == false) {
			setStatusTest("pass", "The text box is hidden");
		} else {
			setStatusTest("fail", "The text box is NOT hidden");
		}
		
		TestLogger.info("4. Check < category name> in list");
		
		skillList.searchCategory1(DataManager.CategoryName);
				
		TestLogger.info("Expect : User CAN see/do: " + "The < category > is not displayed");
		
		if(skillList.isLinkClickHereCategoryDisplayed() == true)
		{
			setStatusTest("pass", "The < category > is NOT displayed");
		}
		else
		{
			setStatusTest("fail", "The < category > is displayed");
		}
	}
	
	@Test(priority = 3)

	public void TT_15022() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
			
			TestLogger.info("3. Click on icon Edit Category >>  Input data less than or equal 250 characters >> Click on X icon");
			
			skillList.searchCategory1(DataManager.FunctionSet);
			Thread.sleep(1500);
			skillList.clickIconEditCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "<category name> is displayed");
			} else {
				setStatusTest("fail", "<category name> is NOT displayed");
			}
			
			skillList.clickIconCancelCategory();
			
			TestLogger.info("Expect : User CAN see/do: " + "The text box is hidden");

			if (skillList.isTxtCategoryNameDisplayed() == false) {
				setStatusTest("pass", "The text box is hidden");
			} else {
				setStatusTest("fail", "The text box is NOT hidden");
			}
	}
	
	@Test(priority = 4)

	public void TT_15020() throws InterruptedException {
	TestLogger.info("1. Login with account.");
	loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
		setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Skill");

		controlBoard.clickLblSkill();
				
		if (skillList.isLblSkillListDisplayed() == true) {
		setStatusTest("pass", "Access to Skill");
		} else {
		setStatusTest("fail", "Not Access to Skill");
		}
				
		TestLogger.info("3. Click on icon Edit Category >>  Input data less than or equal 250 characters >> Update category");
		
		skillList.searchCategory(DataManager.SkillCategory_TT_15019);
		Thread.sleep(1500);
		skillList.clickIconEditCategory();
				
		if (skillList.isTxtCategoryNameDisplayed() == true) {
			setStatusTest("pass", "< category name> is displayed");
		} else {
		setStatusTest("fail", "< category name> is NOT displayed");
		}
				
		skillList.clickIconSaveCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "Skill category updated success");
		
		if (skillList.isTxtCategoryNameDisplayed() == false) {
			setStatusTest("pass","Skill category updated success");
		} else {
			setStatusTest("fail","Skill category updated NOT success");
		}

}
	
	@Test(priority = 5)

	public void TT_15023() throws InterruptedException {
	TestLogger.info("1. Login with account.");
	loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

	if (controlBoard.isLblControlBoardDisplayed() == true) {
	setStatusTest("pass", "Login Successfully!");
		} else {
		setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("2. Access to Skill");

		controlBoard.clickLblSkill();
				
		if (skillList.isLblSkillListDisplayed() == true) {
		setStatusTest("pass", "Access to Skill");
		} else {
		setStatusTest("fail", "Not Access to Skill");
		}
				
		TestLogger.info("3. Select category not does not have skill >> Click on Delete icon of the category");
		
		skillList.searchCategory(DataManager.SkillCategory_TT_15019);
		Thread.sleep(1500);
		skillList.clickIconDeleteCategory();
			
		TestLogger.info("Expect : User CAN see/do: " + "Skill category deleted success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Display message: " +  "Skil category deleted successfully");
		} else {
			setStatusTest("fail","NOT Display message: " + "Skil category deleted successfully");
		}
}
	
	@Test(priority = 6)

	public void TT_15187() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
			
			TestLogger.info("3. Create Category >> Access to New Category");
			
			skillList.clickBtnAddCategory();
			
			if (skillList.isTxtCategoryNameDisplayed() == true) {
				setStatusTest("pass", "Blank text box is display");
			} else {
				setStatusTest("fail", "Blank text box is NOT display");
			}
			
			skillList.fillCategoryName(DataManager.SkillCategory_TT_15187);
			skillList.clickIconSaveCategory();

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill category created sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Skill category created sucessfully");
			}
			
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("4. Input data to Title field >> Click on Next button");
						
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15187,DataManager.FunctionSet);
			createSkillInformation.clickBtnNext();
			
			if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
			
			TestLogger.info("5. Click on Next button in Define Level tab");
			
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			TestLogger.info("6. Click on Back button in Preview & Finish tab");
			
			createPreviewFinish.clickBtnBack();
			
			if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Back to Define Level tab");
			} else {
				setStatusTest("fail","NOT Back to Define Level tab");
			}
			
			TestLogger.info("7. Click on Back button in Define Level tab");
			
			createDefineLevel.clickBtnBack();
			
			if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
				setStatusTest("pass","Back to Skill Information tab");
			} else {
				setStatusTest("fail","NOT Back to Skill Information tab");
			}
	}
	
	@Test(priority = 7)

	public void TT_15186() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill >> Access to Category >> Click on Next button");

			controlBoard.clickLblSkill();	
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
			
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			createSkillInformation.clickBtnNext();
			
			if (createSkillInformation.isLblMandatoryDisplayed() == true) {
				setStatusTest("pass", "Mandatory field message is displayed");
			} else {
				setStatusTest("fail","Mandatory field message is NOT displayed");
			}
	}
	
	@Test(priority = 8)

	public void TT_15181() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill >> Access to Category >> Click on Cancel button");

			controlBoard.clickLblSkill();	
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
			
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			createSkillInformation.clickBtnCancel();
			
			if (createSkillInformation.isTabSkillInformationDisplayed() == true) {
				setStatusTest("pass", "Skill Information tab is hidden");
			} else {
				setStatusTest("fail","Skill Information tab is NOT hidden");
			}
	}
	
	@Test(priority = 9)

	public void TT_15025() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("4. Input data to Title field >> Click on Next button");
			
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15025,DataManager.FunctionSet);
			createSkillInformation.clickBtnNext();
			
			if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
			
			TestLogger.info("5. Click on Next button in Define Level tab");
			
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			TestLogger.info("6. Click on Save button");
			
			createPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}
	
	@Test(priority = 10)

	public void TT_15087() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("4. Input data to Title field(has domain knowledge) >> Click on Next button");
			
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15087,DataManager.FunctionSet);
						
			createSkillInformation.clickIconPlusDomain();
			createSkillInformation.fillDomainName(DataManager.Functional);
			
			if (createSkillInformation.isLblDomainKnowledgeDisplayed() == true) {
				setStatusTest("pass","Add Domain Knowledge Success");
			} else {
				setStatusTest("fail","Add Domain Knowledge NOT Success");
			}
			
			createSkillInformation.clickBtnNext();
			
			if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
						
			TestLogger.info("5. Click on Next button in Define Level tab");
			
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			TestLogger.info("6. Click on Save button");
			
			createPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}
	
	@Test(priority = 11)

	public void TT_15089() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("4. Input data to Title field(has behavior) >> Click on Next button");
						
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15089,DataManager.FunctionSet);
						
			createSkillInformation.clickIconPlusBehavior();
			createSkillInformation.fillBehavior(DataManager.Functional);
			
			if (createSkillInformation.isLblBehaviorForDomainDisplayed() == true) {
				setStatusTest("pass","Add Behaviors Success");
			} else {
				setStatusTest("fail","Add Behaviors NOT Success");
			}
			
			createSkillInformation.clickBtnNext();
			
			if (createDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
						
			TestLogger.info("5. Click on Next button in Define Level tab");
			
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			TestLogger.info("6. Click on Save button");
			
			createPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}
	
	@Test(priority = 12)

	public void TT_15093() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("4. Input data to Title field(has domain(s) and behavior(s)) >> Click on Next button");
			
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15093,DataManager.FunctionSet);
						
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
						
			TestLogger.info("5. Click on Next button in Define Level tab");
			
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			TestLogger.info("6. Click on Save button");
			
			createPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}
	
	@Test(priority = 13)

	public void TT_15111() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("3. Input data to Title field(has domain(s) and behavior(s)) >> Click on Next button");
					
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15111,DataManager.FunctionSet);
						
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
			
			createSkillInformation.fillBehaviorForDomain("Testing Behaviors");
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
						
			TestLogger.info("4. Select a level by ticked on  max radio button of level >> Click on Edit icon next to max radio button");
			
			createDefineLevel.clickBtnRadioL1();
			createDefineLevel.clickIconEditL1();
			
			if (createDefineLevel.isLblBehaviorPopupDisplayed() == true) {
				setStatusTest("pass","Open Behaviors popup");
			} else {
				setStatusTest("fail","NOT Open Behaviors popup");
			}
					
			TestLogger.info("5. Select  Experience >> Click > icon of < domain name> >> Tick on check box(es) of behavior(s) >> Click on Save button");
			
			createDefineLevel.selectMonth();
			createDefineLevel.selectYear();
			createDefineLevel.tickOnBehavior();
			
			if (createDefineLevel.isLblTotalDisplayed() == true) {
				setStatusTest("pass","Tick on check box(es) of behavior(s) Success");
			} else {
				setStatusTest("fail","Tick on check box(es) of behavior(s) NOT Success");
			}
			
			createDefineLevel.clickBtnSave();
			createDefineLevel.clickLblLevel1();
			
			if (createDefineLevel.isLblBehaviorDisplayed() == true) {
				setStatusTest("pass","Update Behavior Success");
			} else {
				setStatusTest("fail","Update Behavior NOT Success");
			}
			
			TestLogger.info("6. Click on Next button in Define Level tab >> Verify at Level View tab");
						
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			createPreviewFinish.clickLblLevel();
			
			if (createPreviewFinish.isLblYearMonthDisplayed() == true) {
				setStatusTest("pass","Displays level from 1 to level selected at before step (eg: 5) and <number> year(s) <number> month(s)");
			} else {
				setStatusTest("fail","NOT Displays level from 1 to level selected at before step (eg: 5) and <number> year(s) <number> month(s)");
			}
			
			
			TestLogger.info("7. Click on Domain View tab >> Click on > of domain");
			
			createPreviewFinish.clickTabDomainView();
		
			if (createPreviewFinish.isTabDomainViewDisplayed() == true) {
				setStatusTest("pass","Displays Domain Name & Level Cover label");
			} else {
				setStatusTest("fail","NOT Displays Domain Name & Level Cover label");
			}
			
			createPreviewFinish.clickLblDomainName();
			
			if (createPreviewFinish.isLblLevelCoverDisplayed() == true) {
				setStatusTest("pass","Displays behavior and < number of level>");
			} else {
				setStatusTest("fail","NOT Displays behavior and < number of level>");
			}
						
			TestLogger.info("8. Click on Save button");
			
			createPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}
	
	@Test(priority = 14)

	public void TT_15133() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Skill");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
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
			
			TestLogger.info("3. Input data to Title field(has domain(s) and behavior(s)) >> Click on Next button");
					
			createSkillInformation.fillSkillName(DataManager.SkillName_TT_15133,DataManager.FunctionSet);
						
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
			
			createSkillInformation.fillBehaviorForDomain("Testing Behaviors");
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
						
			TestLogger.info("4. Select a level by ticked on  max radio button of level >> Click on Edit icon next to max radio button");
			
			createDefineLevel.clickBtnRadioL1();
			createDefineLevel.clickIconEditL1();
			
			if (createDefineLevel.isLblBehaviorPopupDisplayed() == true) {
				setStatusTest("pass","Open Behaviors popup");
			} else {
				setStatusTest("fail","NOT Open Behaviors popup");
			}
					
			TestLogger.info("5. Select Experience >> Click > icon of < domain name> >> Tick on check box(es) of behavior(s) >> Click on Save button");
			
			createDefineLevel.selectMonth();
			createDefineLevel.selectYear();
			createDefineLevel.tickOnBehavior();
			
			if (createDefineLevel.isLblTotalDisplayed() == true) {
				setStatusTest("pass","Tick on check box(es) of behavior(s) Success");
			} else {
				setStatusTest("fail","Tick on check box(es) of behavior(s) NOT Success");
			}
			
			createDefineLevel.clickBtnSave();
			createDefineLevel.clickLblLevel1();
			
			if (createDefineLevel.isLblBehaviorDisplayed() == true) {
				setStatusTest("pass","Update Behavior Success");
			} else {
				setStatusTest("fail","Update Behavior NOT Success");
			}
			
			TestLogger.info("6. Click on Next button in Define Level tab >> Verify at Level View tab");
						
			createDefineLevel.clickBtnNext();
			
			if (createPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
			
			createPreviewFinish.clickLblLevel();
			
			if (createPreviewFinish.isLblYearMonthDisplayed() == true) {
				setStatusTest("pass","Displays level from 1 to level selected at before step (eg: 5) and <number> year(s) <number> month(s)");
			} else {
				setStatusTest("fail","NOT Displays level from 1 to level selected at before step (eg: 5) and <number> year(s) <number> month(s)");
			}
			
			
			TestLogger.info("7. Click on Domain View tab >> Click on > of domain");
			
			createPreviewFinish.clickTabDomainView();
		
			if (createPreviewFinish.isTabDomainViewDisplayed() == true) {
				setStatusTest("pass","Displays Domain Name & Level Cover label");
			} else {
				setStatusTest("fail","NOT Displays Domain Name & Level Cover label");
			}
			
			createPreviewFinish.clickLblDomainName();
			
			if (createPreviewFinish.isLblLevelCoverDisplayed() == true) {
				setStatusTest("pass","Displays behavior and < number of level>");
			} else {
				setStatusTest("fail","NOT Displays behavior and < number of level>");
			}
						
			TestLogger.info("8. Click on Save and create new button");
			
			createPreviewFinish.clickBtnSaveNCreate();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill created successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill created successfully.");
			}
}

	@Test(priority = 15)

	public void TT_15194() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent -> Skill >> Select category has skill >> Select a skill ");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
			skillList.clickFirtItemCategory();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass","Open Skill List");
			} else {
				setStatusTest("fail","NOT Open Skill List");
			}
			
			skillList.clickItemFirstSkill();
						
			if (skillList.isLblSkillDetailsDisplayed() == true) {
				setStatusTest("pass","Display Skill Details tab");
			} else {
				setStatusTest("fail","NOT Display Skill Details tab");
			}
			
			TestLogger.info("3. Click on Edit icon at the top right corner");
			
			skillList.clickBtnEdit();
			
			if (editSkillInformation.isTabSkillInformationDisplayed() == true) {
				setStatusTest("pass","Display Skill Information tab");
			} else {
				setStatusTest("fail","NOT Display Skill Information tab");
			}
			
			TestLogger.info("4. Edit data in Skill Information tab >> Click on Next button");
			Thread.sleep(1500);
			editSkillInformation.fillDescription("change des");
			editSkillInformation.clickBtnNext();
			
			if (editDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
						
			TestLogger.info("5. Edit data in Define Level tab >> Click on Next button");
						
			editDefineLevel.clickBtnNext();
			
			if (editPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
									
			TestLogger.info("6. Click on Cancel button");
			
			editPreviewFinish.clickBtnCancel();
			Thread.sleep(2000);
			if (skillList.isLblSkillDetailsDisplayed() == true) {
				setStatusTest("pass","Skill Details page is displayed");
			} else {
				setStatusTest("fail","Skill Details page is NOT displayed");
			}
}

	@Test(priority = 16)

	public void TT_15191() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}

			TestLogger.info("2. Access to Talent -> Skill >> Select category has skill >> Select a skill ");

			controlBoard.clickLblSkill();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass", "Access to Skill");
			} else {
				setStatusTest("fail", "Not Access to Skill");
			}
					
			skillList.searchCategory(DataManager.SkillCategory_TT_15187);
			Thread.sleep(1500);
			skillList.clickFirtItemCategory();
			
			if (skillList.isLblSkillListDisplayed() == true) {
				setStatusTest("pass","Open Skill List");
			} else {
				setStatusTest("fail","NOT Open Skill List");
			}
			
			skillList.clickItemFirstSkill();
						
			if (skillList.isLblSkillDetailsDisplayed() == true) {
				setStatusTest("pass","Display Skill Details tab");
			} else {
				setStatusTest("fail","NOT Display Skill Details tab");
			}
			
			TestLogger.info("3. Click on Edit icon at the top right corner");
			
			skillList.clickBtnEdit();
			
			if (editSkillInformation.isTabSkillInformationDisplayed() == true) {
				setStatusTest("pass","Display Skill Information tab");
			} else {
				setStatusTest("fail","NOT Display Skill Information tab");
			}
			
			TestLogger.info("4. Edit data in Skill Information tab >> Click on Next button");
			editSkillInformation.fillDescription("change des");
			editSkillInformation.clickBtnNext();
			
			if (editDefineLevel.isTabDefineLevelDisplayed() == true) {
				setStatusTest("pass","Displays Define Level tab");
			} else {
				setStatusTest("fail","NOT Display Define Level tab");
			}
						
			TestLogger.info("5. Edit data in Define Level tab >> Click on Next button");
						
			editDefineLevel.clickBtnNext();
			
			if (editPreviewFinish.isTabPreviewDisplayed() == true) {
				setStatusTest("pass","Displays Preview & Finish tab");
			} else {
				setStatusTest("fail","NOT Display Preview & Finish tab");
			}
									
			TestLogger.info("6. Click on Save button");
			
			editPreviewFinish.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Skill updated successfully.");
			} else {
				setStatusTest("fail"," NOT Displays msg: " + "Skill updated successfully.");
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
