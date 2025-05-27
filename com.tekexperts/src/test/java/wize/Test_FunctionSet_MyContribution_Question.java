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
import wize.pages.Form_CreateMyQuestion;
import wize.pages.Form_EditUser;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.MyContribution;
import wize.pages.MyContribution_Question;
import wize.pages.MyData;
import wize.pages.MySpace;
import wize.pages.UserManagement;

public class Test_FunctionSet_MyContribution_Question extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;
		
	MySpace mySapce;
	MyData myData;
	MyContribution_Question question;
	MyContribution myContribution;
	Form_CreateMyQuestion createMyQuestion;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
	
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Clone_Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		
		mySapce = new MySpace(driver);
		myData = new MyData(driver);
		question = new MyContribution_Question(driver);
		myContribution = new MyContribution(driver);
		createMyQuestion = new Form_CreateMyQuestion(driver);
	
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25520() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Contribution - Question | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabMySpace();
		editFunctionSet.clickSubTabMyTalent();
		editFunctionSet.clickCboxFullPermission();
		editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
		editFunctionSet.clickBtnSave();
		
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
		
		TestLogger.info("5. Access to My Space tab");

		controlBoard.clickTabMySpace();
		
		if (mySapce.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("6. Access My Contribution sub-tab");
		
		mySapce.clickTabMyContribution();
		
		if (myContribution.isTabQuestionDisplayed() == true) {
			setStatusTest("pass", "Access My Contribution sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Contribution sub-tab");
		}

		TestLogger.info("7. Access to Question");
			
		myContribution.clickTabQuestion();
		
		if (question.isLblMyQuestionDisplayed() == true) {
			setStatusTest("pass", "Access Question");
		} else {
			setStatusTest("fail", "Not Access Question");
		}
		
		TestLogger.info("8. Create question success");
		
		question.clickBtnCreateQuestion();
		question.clickItemSingleChoice();
		
		if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access Create Question");
		} else {
			setStatusTest("fail", "Not Access Create Question");
		}
		
		createMyQuestion.selectComletionTime();
		createMyQuestion.clickBtnAssignToMe();
		createMyQuestion.fillQuestionText(DataManager.CreateFunctionSet);
		createMyQuestion.fillInputAnswerSingleChoice(DataManager.CreateFunctionSet);
		createMyQuestion.clickBtnRadio1();
		createMyQuestion.clickIconSave1();
		createMyQuestion.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add Create Success");
		} else {
			setStatusTest("fail", "Add Create Fail");
		}
		
		question.searchQuestion(DataManager.CreateFunctionSet);
				
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Data table\r\n" 
				+ "2. Create button\r\n"
				+ "3. Edit button\r\n"
				+ "4. Delete button\r\n"
				+ "5. Submit button");
		
		if (question.isLinkQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table");
		}
		
		if (question.isBtnCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create button");
		}
		
		if (question.isIconEditFirstItemDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
		}
		
		if (question.isBtnDeleteAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete button");
		}
						
		if (question.isBtnSubmitAllDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Submit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Submit button");
		}
		
		TestLogger.info("9. Update question success");
		
		question.clickIconEditFirstItem();
		
		if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access Update Question");
		} else {
			setStatusTest("fail", "Not Access Update Question");
		}
		
		createMyQuestion.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update question Success");
		} else {
			setStatusTest("fail", "Update question Fail");
		}
		
		TestLogger.info("10. Delete question success");
		
		question.clickIconDeleteFirstItem();;
		
		if(question.isLblConfirmationDisplayed() == true)
		{
			question.clickBtnYes();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete question Success");
			} else {
				setStatusTest("fail", "Delete question Fail");
			}
		}
		
		TestLogger.info("11. Create question success");
		
		question.clickBtnCreateQuestion();
		question.clickItemSingleChoice();
		
		if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access Create Question");
		} else {
			setStatusTest("fail", "Not Access Create Question");
		}
		
		createMyQuestion.selectComletionTime();
		createMyQuestion.clickBtnAssignToMe();
		createMyQuestion.fillQuestionText(DataManager.CreateFunctionSet);
		createMyQuestion.fillInputAnswerSingleChoice(DataManager.CreateFunctionSet);
		createMyQuestion.clickBtnRadio1();
		createMyQuestion.clickIconSave1();
		createMyQuestion.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add More areer Path Success");
		} else {
			setStatusTest("fail", "Add More areer Path Fail");
		}
				
		TestLogger.info("12. Submit question success");
		
		question.searchQuestion(DataManager.CreateFunctionSet);		
		question.clickIconSubmitFirstItem();
		
		if(question.isLblConfirmationDisplayed() == true)
		{
			question.clickBtnSubmit();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Submit question Success");
			} else {
				setStatusTest("fail", "Submit question Fail");
			}
		}
}
	
	@Test(priority = 2)
	
		public void TT_25521() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Contribution - Question | View Only Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxViewOnly();
			editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
			editFunctionSet.clickBtnSave();
			
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
			
			TestLogger.info("5. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySapce.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Contribution sub-tab");
			
			mySapce.clickTabMyContribution();
			
			if (myContribution.isTabQuestionDisplayed() == true) {
				setStatusTest("pass", "Access My Contribution sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Contribution sub-tab");
			}
	
			TestLogger.info("7. Access to Question");
				
			myContribution.clickTabQuestion();
			
			if (question.isLblMyQuestionDisplayed() == true) {
				setStatusTest("pass", "Access Question");
			} else {
				setStatusTest("fail", "Not Access Question");
			}
								
			TestLogger.info("Expect : User CAN see/do: " + "Data table");
			
			if (question.isLinkQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Data table");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create button\r\n"
					+ "2. Edit button\r\n"
					+ "3. Delete button\r\n"
					+ "4. Submit button");
			
			if (question.isBtnCreateQuestionDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create button");
			}
			
			if (question.isIconEditFirstItemDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit button");
			}
			
			if (question.isBtnDeleteAllDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete button");
			}
							
			if (question.isBtnSubmitAllDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Submit button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Submit button");
			}
}

	@Test(priority = 3)
	
		public void TT_25522() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Contribution - Question | NO Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
			editFunctionSet.clickBtnSave();
			
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
			
			TestLogger.info("5. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySapce.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("Expect : User CANNOT see/do: "  + "My Cotribution tab");
			
			if (mySapce.isTabMyContributionDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "My Cotribution tab");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "My Cotribution tab");
			}
}

	@Test(priority = 4)
	
		public void TT_25523() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Contribution - Question | View + Contribute Question Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyTalent();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewQuestionContribution();
			editFunctionSet.clickONbtnContributionQuestion();
			editFunctionSet.fillTxtDescription(DataManager.FunctionSet);
			editFunctionSet.clickBtnSave();
			
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
			
			TestLogger.info("5. Access to My Space tab");
	
			controlBoard.clickTabMySpace();
			
			if (mySapce.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Contribution sub-tab");
			
			mySapce.clickTabMyContribution();
			
			if (myContribution.isTabQuestionDisplayed() == true) {
				setStatusTest("pass", "Access My Contribution sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Contribution sub-tab");
			}
	
			TestLogger.info("7. Access to Question");
				
			myContribution.clickTabQuestion();
			
			if (question.isLblMyQuestionDisplayed() == true) {
				setStatusTest("pass", "Access Question");
			} else {
				setStatusTest("fail", "Not Access Question");
			}
			
			TestLogger.info("8. Create question success");
			
			question.clickBtnCreateQuestion();
			question.clickItemSingleChoice();
			
			if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "Access Create Question");
			} else {
				setStatusTest("fail", "Not Access Create Question");
			}
			
			createMyQuestion.selectComletionTime();
			createMyQuestion.clickBtnAssignToMe();
			createMyQuestion.fillQuestionText(DataManager.CreateFunctionSet);
			createMyQuestion.fillInputAnswerSingleChoice(DataManager.CreateFunctionSet);
			createMyQuestion.clickBtnRadio1();
			createMyQuestion.clickIconSave1();
			createMyQuestion.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add Create Success");
			} else {
				setStatusTest("fail", "Add Create Fail");
			}
			
			question.searchQuestion(DataManager.CreateFunctionSet);
					
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Data table\r\n" 
					+ "2. Create button\r\n"
					+ "3. Edit button\r\n"
					+ "4. Delete button\r\n"
					+ "5. Submit button");
			
			if (question.isLinkQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Data table");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Data table");
			}
			
			if (question.isBtnCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create button");
			}
			
			if (question.isIconEditFirstItemDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit button");
			}
			
			if (question.isBtnDeleteAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete button");
			}
							
			if (question.isBtnSubmitAllDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Submit button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Submit button");
			}
			
			TestLogger.info("9. Update question success");
			
			question.clickIconEditFirstItem();
			
			if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "Access Update Question");
			} else {
				setStatusTest("fail", "Not Access Update Question");
			}
			
			createMyQuestion.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update question Success");
			} else {
				setStatusTest("fail", "Update question Fail");
			}
			
			TestLogger.info("10. Delete question success");
			
			question.clickIconDeleteFirstItem();;
			
			if(question.isLblConfirmationDisplayed() == true)
			{
				question.clickBtnYes();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Delete question Success");
				} else {
					setStatusTest("fail", "Delete question Fail");
				}
			}
			
			TestLogger.info("11. Create question success");
			
			question.clickBtnCreateQuestion();
			question.clickItemSingleChoice();
			
			if (createMyQuestion.isLblCreateQuestionDisplayed() == true) {
				setStatusTest("pass", "Access Create Question");
			} else {
				setStatusTest("fail", "Not Access Create Question");
			}
			
			createMyQuestion.selectComletionTime();
			createMyQuestion.clickBtnAssignToMe();
			createMyQuestion.fillQuestionText(DataManager.CreateFunctionSet);
			createMyQuestion.fillInputAnswerSingleChoice(DataManager.CreateFunctionSet);
			createMyQuestion.clickBtnRadio1();
			createMyQuestion.clickIconSave1();
			createMyQuestion.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add More areer Path Success");
			} else {
				setStatusTest("fail", "Add More areer Path Fail");
			}
					
			TestLogger.info("12. Submit question success");
			
			question.searchQuestion(DataManager.CreateFunctionSet);		
			question.clickIconSubmitFirstItem();
			
			if(question.isLblConfirmationDisplayed() == true)
			{
				question.clickBtnSubmit();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Submit question Success");
				} else {
					setStatusTest("fail", "Submit question Fail");
				}
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
