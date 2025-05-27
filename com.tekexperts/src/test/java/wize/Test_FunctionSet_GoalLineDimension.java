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
import wize.pages.Clone_Form_EditFunctionSet;
import wize.pages.ControlBoard;
import wize.pages.Form_EditClone_GoalLineDimension;
import wize.pages.Form_CreateBusinessUnit;
import wize.pages.Form_Create_DimensionGoalLine;
import wize.pages.Form_GoalLineDimensionDetail;
import wize.pages.FunctionSet;
import wize.pages.GoalLine;
import wize.pages.LoginScreen;
import wize.pages.Organization_BusinessUnit;

public class Test_FunctionSet_GoalLineDimension extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	GoalLine goalLineList;
	Form_Create_DimensionGoalLine createDimensionGoalLine;
	Organization_BusinessUnit businessUnit;
	Form_CreateBusinessUnit createBusinessUnit;
	Form_GoalLineDimensionDetail detailDimensionGoalLine;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet cloneForm;	
	Form_EditClone_GoalLineDimension duplicateDimensionForm;
	
	
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
		functionSet = new FunctionSet(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		duplicateDimensionForm = new Form_EditClone_GoalLineDimension(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
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

	@Test (priority = 1, enabled = true)
	public void TT23267(){
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | NO Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnRadioOrganization();
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
		TestLogger.info("5. CANNOT see link GOALLINE from Control board ");
		if (!controlBoard.isLblGoalLineDisplayed()) {
			setStatusTest("pass", "CANNOT see link GOALLINE");
		} else {
			setStatusTest("fail", "CAN see link GOALLINE");
		}
	}
	
	@Test (priority = 2, enabled = true)
	public void TT23269() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | Full Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("7. User CAN create goal line dimension");
		goalLineList.clickLinkCreateGoal();
		String goalName = DataManager.Test + TienIch.taoRandomSo(4);
		createDimensionGoalLine.createFinancialType(goalName);
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(goalName);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "CAN see data table");
		}else{
			setStatusTest("fail", "CANNOT see data table");
		}
		TestLogger.info("Expected: User CAN see btn Create, btn Delete, btn Edit, btn Clone, view detail");
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CAN see btn Create goal line");
		}else{
			setStatusTest("fail", "CANNOT see btn Create goal line");
		}
		if(goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CAN see icon Delete goal line");
		}else{
			setStatusTest("fail", "CANNOT see icon Delete goal line");
		}
		if(goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CAN see icon Edit goal line");
		}else{
			setStatusTest("fail", "CANNOT see icon Edit goal line");
		}
		TestLogger.info("8. User CAN view detail of goal line dimension");
		Thread.sleep(1000);
		goalLineList.clickLinkFirstGoal();
		if(detailDimensionGoalLine.isTitleDetailDisplayed()){
			setStatusTest("pass", "Detail popup is displayed");
		}else{
			setStatusTest("fail", "Detail popup is NOT displayed");
		}
		Thread.sleep(1000);
		detailDimensionGoalLine.clickIconClose();
		TestLogger.info("9. User CAN duplicate goal line");
		Thread.sleep(1000);
		goalLineList.clickIconDuplicate();
		if(duplicateDimensionForm.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form clone is displayed");
		}else{
			setStatusTest("fail", "Form clone is NOT displayed");
		}
		Thread.sleep(1000);
		duplicateDimensionForm.fillGoalName(goalName + "a");
		duplicateDimensionForm.clickBtnSave();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(goalName + "a");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Clone goal line dimension successfully");
		}else{
			setStatusTest("fail", "Clone goal line dimension NOT successfully");
		}
		TestLogger.info("10. User CAN edit goal line");
		Thread.sleep(2000);
		goalLineList.clickIconEdit();
		if(duplicateDimensionForm.isTitleEditDisplayed()){
			setStatusTest("pass", "Form edit is displayed");
		}else{
			setStatusTest("fail", "Form edit is NOT displayed");
		}
		Thread.sleep(1000);
		duplicateDimensionForm.fillGoalName(goalName + "b");
		duplicateDimensionForm.clickBtnSave();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(goalName + "b");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Edit goal line dimension successfully");
		}else{
			setStatusTest("fail", "Edit goal line dimension NOT successfully");
		}
		TestLogger.info("11. User CAN delete goal line");
		goalLineList.deleteAllGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(goalName + "b");
		if(!goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Delete goal line dimension successfully");
		}else{
			setStatusTest("fail", "Delete goal line dimension NOT successfully");
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void TT23272_TT23274() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + DETAIL Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("User CAN see data table, view detail of goal line dimension");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "CAN see data table");
		}else{
			setStatusTest("fail", "CANNOT see data table");
		}
		goalLineList.clickLinkFirstGoal();
		if(detailDimensionGoalLine.isTitleDetailDisplayed()){
			setStatusTest("pass", "Detail popup is displayed");
		}else{
			setStatusTest("fail", "Detail popup is NOT displayed");
		}
		Thread.sleep(1000);
		detailDimensionGoalLine.clickIconClose();
		TestLogger.info("User CANNOT see Create, edit, delete button goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see icon Edit goal line");
		}else{
			setStatusTest("fail", "CAN see icon Edit goal line");
		}
	}
	
	@Test (priority = 4, enabled = true)
	public void TT23273() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("User CAN see data table");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "CAN see data table");
		}else{
			setStatusTest("fail", "CANNOT see data table");
		}
		TestLogger.info("User CANNOT see Create, edit, delete button, view detail of goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see icon Edit goal line");
		}else{
			setStatusTest("fail", "CAN see icon Edit goal line");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
	}
	
	@Test (priority = 5, enabled = true)
	public void TT23275() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + CREATE Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
		cloneForm.clickONbtnCreateDimensionGoals();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("7. User CAN create goal line dimension");
		if(goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CAN see btn Create goal line");
		}else{
			setStatusTest("fail", "CANNOT see btn Create goal line");
		}
		goalLineList.clickLinkCreateGoal();
		String goalName = DataManager.Test + TienIch.taoRandomSo(4);
		createDimensionGoalLine.createFinancialType(goalName);
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(goalName);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "User CAN create successfully");
		}else{
			setStatusTest("fail", "User CAN create successfully");
		}
		TestLogger.info("Expected: User CANNOT see edit, delete button, view detail of goal line dimension");
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see icon Edit goal line");
		}else{
			setStatusTest("fail", "CAN see icon Edit goal line");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
	}
	
	@Test (priority = 6, enabled = true)
	public void TT23276() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + EDIT Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
		cloneForm.clickONbtnEditDimensionGoals();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("7. User CAN edit goal line dimension");
		if(goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CAN see icon Edit goal line");
		}else{
			setStatusTest("fail", "CANNOT see icon Edit goal line");
		}
		goalLineList.fillSearchGoalName(DataManager.Test);
		Thread.sleep(2000);
		goalLineList.clickIconEditNoLink();
		if(duplicateDimensionForm.isTitleEditDisplayed()){
			setStatusTest("pass", "Form edit is displayed");
		}else{
			setStatusTest("fail", "Form edit is NOT displayed");
		}
		Thread.sleep(1000);
		duplicateDimensionForm.fillGoalName(DataManager.Test + "b");
		duplicateDimensionForm.clickBtnSave();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test + "b");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Edit goal line dimension successfully");
		}else{
			setStatusTest("fail", "Edit goal line dimension NOT successfully");
		}
		TestLogger.info("Expected: User CANNOT see create, delete button, view detail of goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void TT23277() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + DUPLICATE Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
		cloneForm.clickONbtnDuplicateDimensionGoals();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("7. User CAN duplicate goal line dimension");
		if(goalLineList.isIconDuplicateDisplayed()){
			setStatusTest("pass", "CAN see icon Duplicate goal line");
		}else{
			setStatusTest("fail", "CANNOT see icon Duplicate goal line");
		}
		goalLineList.fillSearchGoalName(DataManager.Test);
		Thread.sleep(2000);
		goalLineList.clickIconDuplicateNoLink();
		if(duplicateDimensionForm.isTitleDuplicateDisplayed()){
			setStatusTest("pass", "Form clone is displayed");
		}else{
			setStatusTest("fail", "Form clone is NOT displayed");
		}
		Thread.sleep(1000);
		duplicateDimensionForm.fillGoalName(DataManager.Test + "a");
		duplicateDimensionForm.clickBtnSave();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test + "a");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Duplicate goal line dimension successfully");
		}else{
			setStatusTest("fail", "Duplicate goal line dimension NOT successfully");
		}
		TestLogger.info("Expected: User CANNOT see create, edit, delete button, view detail of goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see btn Edit goal line");
		}else{
			setStatusTest("fail", "CAN see btn Edit goal line");
		}
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
	}
	
	@Test (priority = 8, enabled = true)
	public void TT23279() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + CLONE Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
		cloneForm.clickONbtnCloneDimensionGoalLines();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("User can Clone goal line from one dimension to another");
		if(goalLineList.isLinkCloneGoalDisplayed()){
			setStatusTest("pass", "Link Clone is displayed");
		}else{
			setStatusTest("fail", "Link Clone is NOT displayed");
		}
		goalLineList.clickLinkCloneGoal();
		if(duplicateDimensionForm.isTitleCloneDisplayed()){
			setStatusTest("pass", "Form clone is displayed");
		}else{
			setStatusTest("fail", "Form clone is NOT displayed");
		}
		duplicateDimensionForm.selectCloneDimension();
		duplicateDimensionForm.selectCloneBU();
		String gName = duplicateDimensionForm.getGoalLineName();
		duplicateDimensionForm.clickBtnClone();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(gName);
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Clone goal line dimension to another successfully");
		}else{
			setStatusTest("fail", "Clone goal line dimension to another NOT successfully");
		}
		TestLogger.info("Expected: User CANNOT see create, edit, delete button, view detail of goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see btn Edit goal line");
		}else{
			setStatusTest("fail", "CAN see btn Edit goal line");
		}
		if(!goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CANNOT see icon Delete goal line");
		}else{
			setStatusTest("fail", "CAN see icon Delete goal line");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
	}
	
	@Test (priority = 9, enabled = true)
	public void TT23278() throws InterruptedException{
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
		TestLogger.info("3. Update Function Set| Goalline Dimension Management | VIEW LIST + DELETE Permission ");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabControlBoard();
		cloneForm.clickSubTabControlBoardTalent();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickONbtnViewListDimensionGoalLine();
		cloneForm.clickONbtnDeleteDimensionGoals();
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
		TestLogger.info("5. Access to GOALLINE");
		controlBoard.clickLblGoalLine();
		if (goalLineList.isBreadcrumbDisplayed()) {
			setStatusTest("pass", "CAN access to Goal line");
		} else {
			setStatusTest("fail", "CANNOT access to Goal line");
		}
		TestLogger.info("6. Click Tab Dimension");
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
			createBusinessUnit.fillAbbreviation("abbre");
			createBusinessUnit.clickBtnSave();
			TestLogger.info("Expect : User CAN see/do: " + "Business Unit created successfully");
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Business Unit created successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Business Unit created successfully");
			}
		}
		goalLineList.clickLinkSecondDimension();
		TestLogger.info("Expected: User CAN see data table, btn Delete");
		if(goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "User CAN see data table");
		}else{
			setStatusTest("fail", "User CANNOT see data table");
		}
		if(goalLineList.isIconDeleteGoalDisplayed()){
			setStatusTest("pass", "CAN see icon Delete goal line");
		}else{
			setStatusTest("fail", "CANNOT see icon Delete goal line");
		}
		TestLogger.info("Expected: User CANNOT see create, edit, clone button, view detail of goal line dimension");
		if(!goalLineList.isBtnCreateGoalDisplayed()){
			setStatusTest("pass", "CANNOT see btn Create goal line");
		}else{
			setStatusTest("fail", "CAN see btn Create goal line");
		}
		if(!goalLineList.isIconEditDisplayed()){
			setStatusTest("pass", "CANNOT see btn Edit goal line");
		}else{
			setStatusTest("fail", "CAN see btn Edit goal line");
		}
		if(!goalLineList.isLinkCloneGoalDisplayed()){
			setStatusTest("pass", "CANNOT see link Clone goal line from one dimension to another");
		}else{
			setStatusTest("fail", "CAN see link Clone goal line from one dimension to another");
		}
		if(!goalLineList.isLinkFirstGoalClickable()){
			setStatusTest("pass", "Detail popup is NOT displayed");
		}else{
			setStatusTest("fail", "Detail popup is displayed");
		}
		TestLogger.info("7. Delete all goal lines");
		goalLineList.fillSearchGoalName(DataManager.Test);
		goalLineList.deleteAllGoal();
		if(goalLineList.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Successful message is displayed");
		}else{
			setStatusTest("fail", "Successful message is NOT displayed");
		}
		goalLineList.fillSearchGoalName(DataManager.Test);
		if(!goalLineList.isLinkFirstGoalDisplayed()){
			setStatusTest("pass", "Delete goal line dimension successfully");
		}else{
			setStatusTest("fail", "Delete goal line dimension NOT successfully");
		}
	}
	
	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.quit();
	}
}
