package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.DataManager;
import Ulties.ImageCotainer;
import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import controller.ScreenController;
import controller.WebDriversManager;
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
import wize.pages.Form_CreateQuestion;
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EditUser;
import wize.pages.Form_QuestionDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.QuestionPool;
import wize.pages.UserManagement;

public class Test_FunctionSet_QuestionPool extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
	QuestionPool questionPool;
	Form_CreateQuestion formCreateQuestion;
	Form_QuestionDetails formQuestionDetails;
	Clone_Form_EditFunctionSet cloneForm;
	ImageCotainer imageCotainer;
	Screen screen;
	ScreenController s;
	
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
		questionPool = new QuestionPool(driver);
		formCreateQuestion = new Form_CreateQuestion(driver);
		formQuestionDetails = new Form_QuestionDetails(driver);
		imageCotainer = new ImageCotainer();
		screen = new Screen();
		s = new ScreenController(screen);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = true)

	public void TT_14616() throws InterruptedException {
		TestLogger.info("1. Login with account.");

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
		
		TestLogger.info("3. Update Function Set|Question Pool | Full Permission ");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
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
		
		TestLogger.info("5. Access to Question Pool >> Create New Category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.Functional);
		
		if(questionPool.isFirstCategoryDisplayed() == true)
		{
				
			questionPool.clickIconDeleteCategory();
			questionPool.clickBtnYesCategory();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category deleted successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category deleted successfully");
			}
			
			questionPool.clickBtnCreateCategory();
			
			if (questionPool.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Access to Create Category");
			} else {
				setStatusTest("fail", "Not Access to Create Category");
			}
			
			questionPool.selectParentCategory();
			questionPool.fillCategoryName(DataManager.Functional);
			questionPool.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category created successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category created successfully");
			}
		}
		else
		{
			questionPool.clickBtnCreateCategory();
			
			if (questionPool.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Access to Create Category");
			} else {
				setStatusTest("fail", "Not Access to Create Category");
			}
			
			questionPool.selectParentCategory();
			questionPool.fillCategoryName(DataManager.Functional);
			questionPool.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category created successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category created successfully");
			}
		}
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (questionPool.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Update Category ");
		
		questionPool.clickIconEditCategory();
		
		if (questionPool.isLblEditCategoryDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Category");
		} else {
			setStatusTest("fail", "Not Access to Edit Category");
		}

		questionPool.fillUpdateCategoryName("1");
		questionPool.clickBtnSaveUpdateCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question Category updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question Category updated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question Category updated successfully");
		}
		
		TestLogger.info("7. Delete Category ");
		
		questionPool.clickIconDeleteCategory();
		questionPool.clickBtnYesCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question Category deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question Category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question Category deleted successfully");
		}
		
		questionPool.clickIconRemoveCategory();
		
		TestLogger.info("8. Access to Question Screen");
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		if(questionPool.isFirstCategoryDisplayed() == true)
		{				
			questionPool.clickFirstCategory();
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "Open Question screen");
			} else {
				setStatusTest("fail", "Not Open Question screen");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Question Pool \r\n" 
					+ "2. Button Create\r\n"
					+ "3. Button Delete\r\n"
					+ "4. Button Reject\r\n"
					+ "5. Button Move");
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
			}
			
			if (questionPool.isBtnCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
			}
			
			if (questionPool.isBtnDeleteAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
			}
			
			if (questionPool.isBtnRejectAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Reject");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Reject");
			}
			
			if (questionPool.isBtnMoveQuestionAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Move");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Move");
			}
		}
		else
		{
			questionPool.clickBtnCreateCategory();
			
			if (questionPool.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Access to Create Category");
			} else {
				setStatusTest("fail", "Not Access to Create Category");
			}
			
			questionPool.selectParentCategory();
			questionPool.fillCategoryName(DataManager.FunctionSet);
			questionPool.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category created successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category created successfully");
			}
			
			questionPool.clickFirstCategory();
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "Open Question screen");
			} else {
				setStatusTest("fail", "Not Open Question screen");
			}
			
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Question Pool \r\n" 
					+ "2. Button Create\r\n"
					+ "3. Button Delete\r\n"
					+ "4. Button Reject\r\n"
					+ "5. Button Move");
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
			}
			
			if (questionPool.isBtnCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Create");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
			}
			
			if (questionPool.isBtnDeleteAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
			}
			
			if (questionPool.isBtnRejectAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Reject");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Reject");
			}
			
			if (questionPool.isBtnMoveQuestionAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Move");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Move");
			}
		}
		
		TestLogger.info("9. Create New Question");
		
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
		
		formCreateQuestion.fillQuestionText(DataManager.Question_TT_14616);
		
		formCreateQuestion.selectSkill(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
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
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Reject\r\n"
				+ "3. Icon Move");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconRejectFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Reject");
		}
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Move");
		}
		
		TestLogger.info("10. Move Question");
		
		questionPool.fillSearchQuestion(DataManager.Question_TT_14616);
		questionPool.clickLinkFirstQuestion();
		
		if (formQuestionDetails.isLblQuestionDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Question Details");
		} else {
			setStatusTest("fail", "Not Open Question Details");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Icon Delete Detail\r\n" 
				+ "2. Icon Reject Detail\r\n"
				+ "3. Icon Move Detail");
		
		if (formQuestionDetails.isIconDeleteDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Detail");
		}
		
		if (formQuestionDetails.isIconRejectsDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Reject Detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Reject Detail");
		}
		
		if (formQuestionDetails.isIconMoveDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Move Detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Move Detail");
		}
		
		formQuestionDetails.clickIconMove();
		
		if (questionPool.isLblMoveQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Move Question");
		} else {
			setStatusTest("fail", "Not Open Move Question");
		}
		
		questionPool.moveQuestion();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question(s) have been moved to new pool(s)");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question(s) have been moved to new pool(s)");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question(s) have been moved to new pool(s)");
		}
		
		TestLogger.info("11. Reject Question");
	
		questionPool.clickIconRejectFirstItem();
		
		if (questionPool.isLblRejectConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Reject Confirmation popup");
		} else {
			setStatusTest("fail", "Not Open Reject Confirmation popup");
		}
		
		questionPool.rejectConfirmation(DataManager.FunctionSet);
			
		TestLogger.info("Expect : User CAN see/do: " + "Question(s) have been rejected successfully Delete");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question(s) have been rejected successfully Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question(s) have been rejected successfully");
		}
		
		TestLogger.info("12. Create New Question");
		
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
		
		formCreateQuestion.fillQuestionText(DataManager.Question_TT_14616);
		
		formCreateQuestion.selectSkill(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}		
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
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
		
		TestLogger.info("13. Delete Question");
		
		questionPool.fillSearchQuestion(DataManager.Question_TT_14616);
		questionPool.clickIconDeleteFirstItem();
		questionPool.clickBtnYesSignle();

		Thread.sleep(1000);
		
		TestLogger.info("User CAN see/do: " + "Question deleted successfully");
		
		if(DataManager.isMsgSuccessDisplayed() == true)
		{
			setStatusTest("pass", "Displays msg: " + "Question deleted successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Displays msg: " + "Question deleted successfully");
		}
		
	}
		
	@Test(priority = 2, enabled = true)

	public void TT_14621() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | NO Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewAssessmentList();
		cloneForm.clickOFFbtnViewQuestionList();
		cloneForm.clickOFFbtnManageQuestionCategory();
		cloneForm.clickOFFbtnCreateQuestion();
		cloneForm.clickOFFbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickOFFbtnRejectQuestion();
		cloneForm.clickOFFbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access to Question Pool ");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "hyperlink Question Pool in Control Board");
		
		if (controlBoard.isLblQuestionPoolDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "hyperlink Question Pool in Control Board");
		} else {
			setStatusTest("fail", "User SILL CAN see/do: " + "hyperlink Question Pool in Control Board");
		}
}
	@Test(priority = 3, enabled = true)

	public void TT_14628() throws InterruptedException {
		TestLogger.info("1. Login with account.");

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
		
		TestLogger.info("3. Update Function Set|Question Pool | View & Manage Category Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.clickONbtnManageQuestionCategory();
		cloneForm.clickOFFbtnCreateQuestion();
		cloneForm.clickOFFbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickOFFbtnRejectQuestion();
		cloneForm.clickOFFbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access to Question Pool >> Create New Category");

		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.Functional);
		
		if(questionPool.isFirstCategoryDisplayed() == true)
		{
				
			questionPool.clickIconDeleteCategory();
			questionPool.clickBtnYesCategory();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category deleted successfully");
			}
			
			questionPool.clickBtnCreateCategory();
			
			if (questionPool.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Access to Create Category");
			} else {
				setStatusTest("fail", "Not Access to Create Category");
			}
			
			questionPool.selectParentCategory();
			questionPool.fillCategoryName(DataManager.Functional);
			questionPool.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category created successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category created successfully");
			}
		}
		else
		{
			questionPool.clickBtnCreateCategory();
			
			if (questionPool.isLblCreateCategoryDisplayed() == true) {
				setStatusTest("pass", "Access to Create Category");
			} else {
				setStatusTest("fail", "Not Access to Create Category");
			}
			
			questionPool.selectParentCategory();
			questionPool.fillCategoryName(DataManager.Functional);
			questionPool.clickBtnSave();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category created successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category created successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category created successfully");
			}
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Category\r\n" 
				+ "2. Button Create Category\r\n"
				+ "3. Icon Edit Category\r\n"
				+ "4. Icon Delete Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
	
		if (questionPool.isBtnCreateCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Question Pool");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create\r\n"
				+ "2. Button Delete\r\n"
				+ "3. Button Reject\r\n"
				+ "4. Button Move");
				
		if (questionPool.isBtnCreateQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
		}
		
		if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
		}
		
		TestLogger.info("7. Update Category ");
		
		questionPool.clickIconEditCategory();
		
		if (questionPool.isLblEditCategoryDisplayed() == true) {
			setStatusTest("pass", "Access to Edit Category");
		} else {
			setStatusTest("fail", "Not Access to Edit Category");
		}

		questionPool.fillUpdateCategoryName("1");
		questionPool.clickBtnSaveUpdateCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question Category updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question Category updated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question Category updated successfully");
		}
		
		TestLogger.info("8. Delete Category ");
		
		questionPool.clickIconDeleteCategory();
		questionPool.clickBtnYesCategory();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question Category deleted successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question Category deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question Category deleted successfully");
		}
	}
	
	@Test(priority = 4, enabled = true)

	public void TT_14637() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | View & Create Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.clickOFFbtnManageQuestionCategory();
		cloneForm.clickONbtnCreateQuestion();
		cloneForm.clickOFFbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickOFFbtnRejectQuestion();
		cloneForm.clickOFFbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access Question Pool >> Select a category");
		
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
	
		if (questionPool.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
		
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Question Pool \r\n" 
				+ "2. Button Create");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
		
		if (questionPool.isBtnCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Create");
		}
				
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n"
				+ "2. Button Reject\r\n"
				+ "3. Button Move");
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
		}
		
		if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
		}
		
		TestLogger.info("7. Create New Question");
		
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
		
		formCreateQuestion.fillQuestionText(DataManager.FunctionSet);
		
		formCreateQuestion.selectSkill(DataManager.Skill1);
		
		if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
		{
			setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
		}
		else
		{
			setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
		}
		
		formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
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
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Reject\r\n"
				+ "3. Icon Move");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconRejectFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject");
		}
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move");
		}
		
		TestLogger.info("8. Open Question Details");
	
		TestLogger.info("Expect : User CANNOT see/do: " + "Open Question Detail");
		
		if (questionPool.isLinkFirstQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Open Question Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Open Question Detail");
		}
		
}
	
	@Test(priority = 5, enabled = true)

	public void TT_14617() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | View Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
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
		
		TestLogger.info("5. Access Question Pool >> Select a category");
		
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
	
		if (questionPool.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
			
		TestLogger.info("Expect : User CAN see/do: " + "List of Question Pool");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
					
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n"
				+ "2. Button Reject\r\n"
				+ "3. Button Move\r\n"
				+ "4. Button Create");
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
		}
		
		if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
		}
		
		if (questionPool.isBtnCreateQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("7. Check control Action");
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Reject\r\n"
				+ "3. Icon Move");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconRejectFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject");
		}
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move");
		}
		
		TestLogger.info("8. Open Question Details");
	
		TestLogger.info("Expect : User CAN see/do: " + "Open Question Detail");
		
		if (questionPool.isLinkFirstQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Open Question Detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Open Question Detail");
		}
		
		questionPool.clickLinkFirstQuestion();
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Delete Detail");
		if(!formQuestionDetails.isIconDeleteDetailDisplayed()){
			setStatusTest("pass", "User CANNOT see/do icon delete in detail form");
		}else{
			setStatusTest("fail", "User STILL CAN see/do icon delete in detail form");
		}
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Edit Detail");
		if(!formQuestionDetails.isIconEditDetailDisplayed()){
			setStatusTest("pass", "User CANNOT see/do icon edit in detail form");
		}else{
			setStatusTest("fail", "User STILL CAN see/do icon edit in detail form");
		}
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Move Detail");
		if(!formQuestionDetails.isIconMoveDetailDisplayed()){
			setStatusTest("pass", "User CANNOT see/do icon move in detail form");
		}else{
			setStatusTest("fail", "User STILL CAN see/do icon move in detail form");
		}
		TestLogger.info("Expect : User CANNOT see/do: " + "Icon Reject Detail");
		if(!formQuestionDetails.isIconRejectsDetailDisplayed()){
			setStatusTest("pass", "User CANNOT see/do icon reject in detail form");
		}else{
			setStatusTest("fail", "User STILL CAN see/do icon reject in detail form");
		}
}
	
	@Test(priority = 6, enabled = true)

	public void TT_14665() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | View & View Question Content Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.clickOFFbtnManageQuestionCategory();
		cloneForm.clickOFFbtnCreateQuestion();
		cloneForm.clickONbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickOFFbtnRejectQuestion();
		cloneForm.clickOFFbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access Question Pool >> Select a category");
		
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
	
		if (questionPool.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
			
		TestLogger.info("Expect : User CAN see/do: " + "List of Question Pool");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
					
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n"
				+ "2. Button Reject\r\n"
				+ "3. Button Move\r\n"
				+ "4. Button Create");
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
		}
		
		if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
		}
		
		if (questionPool.isBtnCreateQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("7. Check control Action");
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Reject\r\n"
				+ "3. Icon Move");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconRejectFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject");
		}
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move");
		}
		
		TestLogger.info("8. Open Question Details");
	
		questionPool.clickLinkFirstQuestion();
		
		if (formQuestionDetails.isLblQuestionDetailsDisplayed() == true) {
			setStatusTest("pass", "Open Question Details");
		} else {
			setStatusTest("fail", "Not Open Question Details");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete Detail\r\n" 
				+ "2. Icon Reject Detail\r\n"
				+ "3. Icon Move Detail");
		
		if (formQuestionDetails.isIconDeleteDetailDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Detail");
		}
		
		if (formQuestionDetails.isIconRejectsDetailDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject Detail");
		}
		
		if (formQuestionDetails.isIconMoveDetailDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Move Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move Detail");
		}
		
		formQuestionDetails.clickIconX();
}
	
	@Test(priority = 8, enabled = true)

	public void TT_14668() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | View & Move Question Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.clickOFFbtnManageQuestionCategory();
		cloneForm.clickOFFbtnCreateQuestion();
		cloneForm.clickOFFbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickOFFbtnRejectQuestion();
		cloneForm.clickONbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access Question Pool >> Select a category");
		
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
	
		if (questionPool.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Question Pool\r\n"
				+ "2. Button Move");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
					
		if (questionPool.isBtnMoveQuestionAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Move");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n"
				+ "2. Button Reject\r\n"
				+ "3. Button Create");
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
		}
		
		if (questionPool.isBtnCreateQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("7. Check control Action");
		
		TestLogger.info("Expect : User CAN see/do: "  + "Icon Move");
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Move");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Reject");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconRejectFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject");
		}
		
		TestLogger.info("8. Open Question Details");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Open Question Detail");
		
		if (questionPool.isLinkFirstQuestionClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Open Question Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Open Question Detail");
		}
		
		TestLogger.info("9. Move Question");
				
		questionPool.clickIconMoveQuestionFirstItemNoClickable();
		
		if (questionPool.isLblMoveQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Move Question");
		} else {
			setStatusTest("fail", "Not Open Move Question");
		}
		
		questionPool.moveQuestion();
		
		TestLogger.info("Expect : User CAN see/do: " + "Question(s) have been moved to new pool(s)");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question(s) have been moved to new pool(s)");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question(s) have been moved to new pool(s)");
		}
}
	
	@Test(priority = 9, enabled = true)

	public void TT_14667() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set|Question Pool | View & Reject Question Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabLearningDevelopment();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		
		cloneForm.clickONbtnViewQuestionList();
		cloneForm.clickOFFbtnManageQuestionCategory();
		cloneForm.clickOFFbtnCreateQuestion();
		cloneForm.clickOFFbtnViewQuestionContent();
		cloneForm.clickOFFbtnDeleteQuestion();
		cloneForm.clickONbtnRejectQuestion();
		cloneForm.clickOFFbtnMoveQuestion();
		cloneForm.clickOFFbtnEditQuestion();
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
		
		TestLogger.info("5. Access Question Pool >> Select a category");
		
		controlBoard.clickLblQuestionPool();
		
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		
		questionPool.fillSearchCategory(DataManager.FunctionSet);
		
		TestLogger.info("Expect : User CAN see/do: " + "List of Category");
		
		if (questionPool. isLblCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Create Category\r\n"
				+ "2. Icon Edit Category\r\n"
				+ "3. Icon Delete Category");
	
		if (questionPool.isBtnCreateCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
		}
		
		if (questionPool.isIconEditCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
		}
		
		if (questionPool.isIconDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
		}
		
		TestLogger.info("6. Access to Question Screen");
		
		questionPool.clickFirstCategory();
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "Open Question screen");
		} else {
			setStatusTest("fail", "Not Open Question screen");
		}
			
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. List of Question Pool\r\n"
				+ "2. Button Reject");
		
		if (questionPool.isLblQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
		}
		
		if (questionPool.isBtnRejectAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Reject");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Reject");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Button Delete\r\n"
				+ "2. Button Move\r\n"
				+ "3. Button Create");
		
		if (questionPool.isBtnDeleteAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Delete");
		}
		
		if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
		}
		
		if (questionPool.isBtnCreateQuestionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
		}
		
		TestLogger.info("7. Check control Action");
		
		TestLogger.info("Expect : User CAN see/do: "  + "Icon Reject");
		
		if (questionPool.isIconRejectFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Icon Reject");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Icon Reject");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: \r\n" 
				+ "1. Icon Delete\r\n" 
				+ "2. Icon Move");
		
		if (questionPool.isIconDeleteFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete");
		}
		
		if (questionPool.isIconMoveQuestionFirstItemDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Icon Move");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move");
		}
		
		TestLogger.info("8. Open Question Details");
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Open Question Detail");
		
		if (questionPool.isLinkFirstQuestionClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Open Question Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Open Question Detail");
		}
		
		TestLogger.info("9. Reject Question");
			
		questionPool.clickIconRejectFirstItemNoClickable();
		
		if (questionPool.isLblRejectConfirmationDisplayed() == true) {
			setStatusTest("pass", "Open Reject Confirmation popup");
		} else {
			setStatusTest("fail", "Not Open Reject Confirmation popup");
		}
		
		questionPool.rejectConfirmation(DataManager.FunctionSet);
			
		TestLogger.info("Expect : User CAN see/do: " + "Question(s) have been rejected successfully Delete");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Question(s) have been rejected successfully Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Question(s) have been rejected successfully");
		}
}

	@Test(priority = 10, enabled = true)
	
		public void TT_14666() throws InterruptedException {
			/*TestLogger.info("1. Login with account Admin");
	
			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
			
			TestLogger.info("2. Access Question Pool >> Select a category");
			
			controlBoard.clickLblQuestionPool();
			
			if (questionPool.isLblQuestionPoolDisplayed() == true) {
				setStatusTest("pass", "Access to Question Pool");
			} else {
				setStatusTest("fail", "Not Access to Question Pool");
			}
			
			questionPool.fillSearchCategory(DataManager.FunctionSet);
			questionPool.clickFirstCategory();
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "Open Question screen");
			} else {
				setStatusTest("fail", "Not Open Question screen");
			}
			
			TestLogger.info("3. Create New Question");
			
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
			
			formCreateQuestion.fillQuestionText(DataManager.FunctionSet);
			
			formCreateQuestion.selectSkill(DataManager.Skill1);
			
			if(formCreateQuestion.isLblDomainKnowleadgeDisplayed() == true)
			{
				setStatusTest("pass", "Displays < skill name + level > has linked behaviors");
			}
			else
			{
				setStatusTest("fail", "Displays < skill name + level > without linked behaviors");
			}
			
			formCreateQuestion.fillInputAnswerSingleChoice(DataManager.FunctionSet);
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
	
			TestLogger.info("4. Access to Function Set");
	
			controlBoard.clickIconControlBoard();
			controlBoard.clickLblFunctionSet();
			
			if (functionSet.isLblFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Access to Function Set");
			} else {
				setStatusTest("fail", "Not Access to Function Set");
			}
			
			TestLogger.info("5. Update Function Set|Question Pool | View & Delete Question Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			cloneForm.clickTabControlBoard();
			cloneForm.clickSubTabLearningDevelopment();
			cloneForm.clickCboxCustomization();
			cloneForm.clickCboxSubCustomization();
			
			cloneForm.clickONbtnViewQuestionList();
			cloneForm.clickOFFbtnManageQuestionCategory();
			cloneForm.clickOFFbtnCreateQuestion();
			cloneForm.clickOFFbtnViewQuestionContent();
			cloneForm.clickONbtnDeleteQuestion();
			cloneForm.clickOFFbtnRejectQuestion();
			cloneForm.clickOFFbtnMoveQuestion();
			cloneForm.clickOFFbtnEditQuestion();
			cloneForm.fillTxtDescription(DataManager.FunctionSet);
			cloneForm.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass","Displays msg: " + "Function Set updated sucessfully");
			} else {
				setStatusTest("fail","NOT Displays msg: " + "Function Set updated sucessfully");
			}
					
			TestLogger.info("6. Logout >> Login with account User");
	
			if (controlBoard.isAvatarDisplayed() == true) {
				controlBoard.logout();
			}
			
			if (loginScreen.isLblWelcomeToDisplayed() == true) {
				setStatusTest("pass", "Logout Successfully!");
			} else {
				setStatusTest("fail", "Logout Fail!");
			}*/
			
			loginScreen.SignInWith(PropertyManager.EmailUser, PropertyManager.PASSWORD);
	
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
			
			TestLogger.info("7. Access Question Pool >> Select a category");
			
			controlBoard.clickLblQuestionPool();
			
			if (questionPool.isLblQuestionPoolDisplayed() == true) {
				setStatusTest("pass", "Access to Question Pool");
			} else {
				setStatusTest("fail", "Not Access to Question Pool");
			}
			
			questionPool.fillSearchCategory(DataManager.FunctionSet);
			
			/*TestLogger.info("Expect : User CAN see/do: " + "List of Category");
			
			if (questionPool. isLblCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Button Create Category\r\n"
					+ "2. Icon Edit Category\r\n"
					+ "3. Icon Delete Category");
		
			if (questionPool.isBtnCreateCategoryDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Create Category");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Create Category");
			}
			
			if (questionPool.isIconEditCategoryDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Edit Category");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Edit Category");
			}
			
			if (questionPool.isIconDeleteCategoryDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Delete Category");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Delete Category");
			}*/
					
			TestLogger.info("8. Access to Question Screen");
			
			questionPool.clickFirstCategory();
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "Open Question screen");
			} else {
				setStatusTest("fail", "Not Open Question screen");
			}
				
			/*TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. List of Question Pool\r\n"
					+ "2. Button Delete");
			
			if (questionPool.isLblQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Question Pool ");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Question Pool ");
			}
			
			if (questionPool.isBtnDeleteAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Button Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Button Delete");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Button Reject\r\n"
					+ "2. Button Move\r\n"
					+ "3. Button Create");
			
			if (questionPool.isBtnRejectAllDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Reject");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Reject");
			}
			
			if (questionPool.isBtnMoveQuestionAllDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Move");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Move");
			}
			
			if (questionPool.isBtnCreateQuestionDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Button Create");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Button Create");
			}
			
			TestLogger.info("9. Check control Action");
			
			TestLogger.info("Expect : User CAN see/do: "  + "Icon Delete");
			
			if (questionPool.isIconDeleteFirstItemDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Icon Delete");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Icon Delete");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Icon Reject\r\n" 
					+ "2. Icon Move");
			
			if (questionPool.isIconRejectFirstItemDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Reject");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Reject");
			}
			
			if (questionPool.isIconMoveQuestionFirstItemDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Icon Move");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Icon Move");
			}*/
			
			TestLogger.info("10. Open Question Details");
			
			TestLogger.info("Expect : User CANNOT see/do: " + "Open Question Detail");
			
			if (questionPool.isLinkFirstQuestionClickable() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Open Question Detail");
			} else {
				setStatusTest("fail", "User STILL CAN see/do: " + "Open Question Detail");
			}

			TestLogger.info("11. Delete Question");
			
			questionPool.clickIconDeleteFirstItemNoClickable();
			questionPool.clickBtnYesAll();
			
			TestLogger.info("User CAN see/do: " + "Question deleted successfully");
			
			if(DataManager.isMsgSuccessDisplayed() == true)
			{
				setStatusTest("pass", "Displays msg: " + "Question deleted successfully");
			}
			else
			{
				setStatusTest("fail", "NOT Displays msg: " + "Question deleted successfully");
			}
			
			TestLogger.info("12. Delete Category");
			
			if (controlBoard.isAvatarDisplayed() == true) {
				controlBoard.logout();
			}
			
			if (loginScreen.isLblWelcomeToDisplayed() == true) {
				setStatusTest("pass", "Logout Successfully!");
			} else {
				setStatusTest("fail", "Logout Fail!");
			}
			
			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
			
			controlBoard.clickLblQuestionPool();
			
			if (questionPool.isLblQuestionPoolDisplayed() == true) {
				setStatusTest("pass", "Access to Question Pool");
			} else {
				setStatusTest("fail", "Not Access to Question Pool");
			}
			
			questionPool.fillSearchCategory(DataManager.FunctionSet);
			
			TestLogger.info("Expect : User CAN see/do: " + "List of Category");
			
			if (questionPool. isLblCategoryDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "List of Category");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "List of Category");
			}
			
			questionPool.clickIconDeleteCategory();
			questionPool.clickBtnYesCategory();
			
			TestLogger.info("Expect : User CAN see/do: " + "Question Category deleted successfully");
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Question Category deleted successfully");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Question Category deleted successfully");
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
