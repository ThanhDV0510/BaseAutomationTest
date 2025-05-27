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
import wize.pages.Form_CreateCategory_LearningContentPool;
import wize.pages.Form_EditCategory_LearningContentPool;
import wize.pages.Form_EditFunctionSet;
import wize.pages.FunctionSet;
import wize.pages.LearningContentPool;
import wize.pages.LoginScreen;
import wize.pages.UserManagement;

public class Test_Functional_LearningContent extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	LearningContentPool learningContentPool;
	Form_CreateCategory_LearningContentPool createCategoryLCP;
	UserManagement userManagement;
	Form_EditCategory_LearningContentPool editCategoryLCP;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		learningContentPool = new LearningContentPool(driver);
		createCategoryLCP = new Form_CreateCategory_LearningContentPool(driver);
		userManagement = new UserManagement(driver);
		editCategoryLCP = new Form_EditCategory_LearningContentPool(driver);
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)
	public void TT_19248_TT_19250(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Check folder All is displayed");
		if(learningContentPool.isFolderAllDisplayed()){
			setStatusTest("pass", "Folder All is displayed properly");
		} else {
			setStatusTest("fail", "Folder All is NOT displayed properly");
		}
		
		TestLogger.info("4. Check tooltip button Create Category");
		if(learningContentPool.checkTooltipCreateCategory("Create Category")){
			setStatusTest("pass", "Tooltip of Create Category is correct");
		}else{
			setStatusTest("fail", "Tooltip of Create Category is NOT correct");
		}
		
		TestLogger.info("5. Prepare test category data");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
			learningContentPool.clickBtnYesCategory();
			if(learningContentPool.isMsgSuccessDisplayed()){
				System.out.println("Category is deleted successfully");
			}else{
				System.out.println("Category is NOT deleted successfully");
			}
		}
	}
	
	@Test(priority = 2, enabled = true)
	public void TT_19251(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Check place holder of search category field");
		if(learningContentPool.checkPlaceHolderSearchCategoryFiled("Search ...")){
			setStatusTest("pass", "Placeholder text is correct");
		} else {
			setStatusTest("fail", "Placeholder text is NOT correct");
		}
		
		TestLogger.info("4. Check icon search category is displayed");
		if(learningContentPool.isIconSearchCategoryDisplayed()){
			setStatusTest("pass", "Icon search category is displayed");
		}else{
			setStatusTest("fail", "Icon search category is NOT displayed");
		}
		
		TestLogger.info("5. Check suggestion box when searching by 1 character");
		if(learningContentPool.checkSuggestionBox1Character()){
			setStatusTest("pass", "Suggestion box is not displayed");
		}else{
			setStatusTest("fail", "Suggestion box is NOT displayed");
		}
		
		TestLogger.info("6. Check suggestion box when searching by 2 invalid characters");
		if(learningContentPool.checkSuggestionBox2InvalidCharacters()){
			setStatusTest("pass", "Suggestion box NO DATA FOUND is displayed");
		}else{
			setStatusTest("fail", "Suggestion box NO DATA FOUND is NOT displayed");
		}
		
		TestLogger.info("7. Check suggestion box when searching by 2 valid characters");
		if(learningContentPool.checkSuggestionBox2ValidCharacters()){
			setStatusTest("pass", "Suggestion box with result is correct");
		}else{
			setStatusTest("fail", "Suggestion box with result is NOT correct");
		}
		
		TestLogger.info("8. Select result in suggestion box");
		learningContentPool.selectSuggestionBox();
		if(learningContentPool.isFirstCategoryDisplayed() && learningContentPool.isIconRemoveSearchCategoryDisplayed()){
			setStatusTest("pass", "Selected category in suggestion box and icon Remove are displayed correctly");
		}else{
			setStatusTest("fail", "Selected category in suggestion box and icon Remove are NOT displayed correctly");
		}
		
		TestLogger.info("9. Clear search");
		learningContentPool.clickIconRemoveCategory();
		if(learningContentPool.isSearchCleared()){
			setStatusTest("pass", "Search field is clear");
		}else{
			setStatusTest("fail", "Search field is not clear");
		}
	}
	
	@Test(priority = 3, enabled = true)
	public void TT_19261_TT_19269(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
			learningContentPool.clickBtnYesCategory();
		}
		TestLogger.info("3. Create Parent and Child category");
		learningContentPool.createCategory(DataManager.LearningContent, PropertyManager.EmailAdmin1);
		learningContentPool.createChildCategory(DataManager.LearningContent_child, PropertyManager.EmailAdmin1);
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickFirstCategory();
		
		TestLogger.info("4. Hover on any Category and check tooltip of 'Delete' and 'Edit' icon");
		if(learningContentPool.checkTooltipDeleteCategory("Delete")){
			setStatusTest("pass", "Tooltip of Delete icon is correct");
		}else{
			setStatusTest("fail", "Tooltip of Delete icon is NOT correct");
		}
		if(learningContentPool.checkTooltipEditCategory("Edit")){
			setStatusTest("pass", "Tooltip of Edit icon is correct");
		}else{
			setStatusTest("fail", "Tooltip of Edit icon is NOT correct");
		}
		
		TestLogger.info("5. Click Expand and Collapse Category");
		learningContentPool.clickExpandCategory();
		if(learningContentPool.isIconCollapseDisplayed()){
			setStatusTest("pass", "Expand category successfully");
		}else{
			setStatusTest("fail", "Expand category NOT successfully");
		}
		learningContentPool.clickCollapseCategory();
		if(learningContentPool.isIconExpandDisplayed()){
			setStatusTest("pass", "Collapse category successfully");
		}else{
			setStatusTest("fail", "Collapse category NOT successfully");
		}
		
		TestLogger.info("6. Click X icon to close create category form");
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.clickBtnClose();
		if(!learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Close create category form successfully");
		}else{
			setStatusTest("fail", "Close create category form NOT successfully");
		}
	}
	
	@Test(priority = 4, enabled = true)
	public void TT_19272(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Click btn Add new category");
		learningContentPool.clickBtnCreateCategory();
		
		if(learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Form Create Category is opened");
		}else{
			setStatusTest("fail", "Form Create Category is not opened");
		}
		
		TestLogger.info("4. Count amount of items in Perent Category field");
		System.out.println("Total existed category is: " + createCategoryLCP.countTotalParentCategory());
		if(createCategoryLCP.countTotalParentCategory() > 0){
			setStatusTest("pass", "Display all existed Categories");
		}else{
			setStatusTest("fail", "Not Display any existed Categories");
		}
		
		TestLogger.info("5. Input invalid data to search in Parent Category field");
		createCategoryLCP.fillParentCategoryNameInvalid("I have no data");
		if(createCategoryLCP.isLblNoDataSearchParentDisplayed()){
			setStatusTest("pass", "NO DATA FOUND is displayed");
		}else{
			setStatusTest("fail", "NO DATA FOUND is not displayed");
		}
		
		TestLogger.info("6. Input valid data to search in Parent Category field");
		createCategoryLCP.fillParentCategoryNameValid(DataManager.LearningContent);
		if(createCategoryLCP.isFirstParentCategoryDisplayed()){
			setStatusTest("pass", "Displayed search result correctly");
		}else{
			setStatusTest("fail", "NOT displayed search result");
		}
		createCategoryLCP.clickFirstParentCategory();
		if(createCategoryLCP.getTextSelectedParentCategory().equals(DataManager.LearningContent)){
			setStatusTest("pass", "Select search result correctly");
		}else{
			setStatusTest("fail", "NOT select search result");
		}
	}
	
	@Test(priority = 5, enabled = true)
	public void TT_19275_TT_19277() throws InterruptedException{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		// ensure category is already existed
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		if(!learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.createCategory(DataManager.LearningContent, PropertyManager.EmailAdmin1);
		}
		System.out.println("Created new category");
		learningContentPool.clickIconRemoveCategory();
		
		TestLogger.info("3. Create category with existed name");
		learningContentPool.createCategory(DataManager.LearningContent, PropertyManager.EmailAdmin1);
		if(createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Error Message Name is displayed");
		}else{
			setStatusTest("fail", "Error Message Name is NOT displayed");
		}
		if(createCategoryLCP.getTextErrorMsgCategoryName().equals("Category name already exists.")){
			setStatusTest("pass", "Error Message Content Name is correct");
		}else{
			setStatusTest("fail", "Error Message Content Name is NOT correct");
		}
		
		TestLogger.info("4. Check mandatory message");
		learningContentPool.clearInputCategoryName();
		learningContentPool.clickBtnSave();
		if(createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Error Message Name is displayed");
		}else{
			setStatusTest("fail", "Error Message Name is NOT displayed");
		}
		System.out.println(createCategoryLCP.getTextErrorMsgCategoryName());
		if(createCategoryLCP.getTextErrorMsgCategoryName().equals("Mandatory field.")){
			setStatusTest("pass", "Error Message Content Name is correct");
		}else{
			setStatusTest("fail", "Error Message Content Name is NOT correct");
		}
	}
	
	@Test(priority = 6, enabled = true)
	public void TT_19279(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Click btn Add new category");
		learningContentPool.clickBtnCreateCategory();
		
		if(learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Form Create Category is opened");
		}else{
			setStatusTest("fail", "Form Create Category is not opened");
		}
		
		TestLogger.info("4. Fill category name less than 250 characters");
		learningContentPool.fillCategoryName(DataManager.lessThan250);
		learningContentPool.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("5. User DO NOT see error message in Category Name field.");
		if(!createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input less than 250 characters OK");
		}else{
			setStatusTest("fail", "Input less than 250 characters NOT OK");
		}
		TestLogger.info("6. Fill category name equal to 250 characters");
		learningContentPool.clearInputCategoryName();
		learningContentPool.fillCategoryName(DataManager.equal250);
		learningContentPool.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("7. User DO NOT see error message in Category Name field.");
		if(!createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input equal to 250 characters OK");
		}else{
			setStatusTest("fail", "Input equal to 250 characters NOT OK");
		}
		TestLogger.info("8. Fill category name more than 250 characters");
		learningContentPool.clearInputCategoryName();
		learningContentPool.fillCategoryName(DataManager.moreThan250);
		learningContentPool.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("9. User DO NOT see error message in Category Name field. (auto truncated from 250th character)");
		if(!createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input more than 250 characters OK");
		}else{
			setStatusTest("fail", "Input more than 250 characters NOT OK");
		}
		learningContentPool.clickBtnCancel();
	}
	
	@Test(priority = 7, enabled = true)
	public void TT_19299_TT_19304_TT_19306() throws InterruptedException{
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Click btn Add new category");
		learningContentPool.clickBtnCreateCategory();
		
		if(learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Form Create Category is opened");
		}else{
			setStatusTest("fail", "Form Create Category is not opened");
		}
		
		TestLogger.info("4. Select an user");
		learningContentPool.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("Expected: selected email and avatar are displayed");
		if(createCategoryLCP.isEmailUserDisplayed() && createCategoryLCP.isAvatarUserDisplayed()){
			setStatusTest("pass", "Selected email and avatar are displayed properly");
		}else{
			setStatusTest("fail", "Selected email and avatar are NOT displayed properly");
		}
		TestLogger.info("5. Compare email");
		if(createCategoryLCP.getEmail().equals(PropertyManager.EmailAdmin1)){
			setStatusTest("pass", "Selected email is correct");
		}else{
			setStatusTest("fail", "Selected email is NOT correct");
		}
		TestLogger.info("6. Click icon remove user");
		createCategoryLCP.clickIconDeleteUser();
		TestLogger.info("Expected: selected email is not displayed");
		if(!createCategoryLCP.isEmailUserDisplayed()){
			setStatusTest("pass", "Selected email is removed successfully");
		}else{
			setStatusTest("fail", "Selected email is NOT removed successfully");
		}
		
		TestLogger.info("7. Check btn Save displayed and enable");
		if(learningContentPool.isBtnSaveDisplayed() && learningContentPool.isBtnSaveEnable()){
			setStatusTest("pass", "Btn Save is displayed and enable");
		}else{
			setStatusTest("fail", "Btn Save is NOT displayed or enable");
		}
		
		TestLogger.info("8. Click button Cancel");
		if(learningContentPool.isBtnCancelDisplayed() && learningContentPool.isBtnCancelEnable()){
			setStatusTest("pass", "Btn Cancel is displayed and enable");
		}else{
			setStatusTest("fail", "Btn Cancel is NOT displayed or enable");
		}
		learningContentPool.clickBtnCancel();
		Thread.sleep(1000);
		if(learningContentPool.isBtnCreateContentDisplayed()){
			setStatusTest("pass", "Form Create Category is closed");
		}else{
			setStatusTest("fail", "Form Create Category is not closed");
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void TT_19307(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		// remove category if existed
		String cateName = DataManager.LearningContent;
		learningContentPool.fillSearchCategory(cateName);
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
			learningContentPool.clickBtnYesCategory();
		}
		
		TestLogger.info("3. Click btn Add new category");
		learningContentPool.clickBtnCreateCategory();
		
		if(learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Form Create Category is opened");
		}else{
			setStatusTest("fail", "Form Create Category is not opened");
		}
		
		TestLogger.info("4. Fill category name without parent category");
		learningContentPool.fillCategoryName(cateName);
		TestLogger.info("5. Select and assign an user for category");
		learningContentPool.selectUser(PropertyManager.EmailAdmin1);
		learningContentPool.clickBtnSave();
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Success message is displayed");
		}else{
			setStatusTest("fail", "Success message is NOT displayed");
		}
		
		TestLogger.info("6. Search created category");
		learningContentPool.fillSearchCategory(cateName);
		if(learningContentPool.isFirstCategoryDisplayed()){
			setStatusTest("pass", "Created category is displayed correctly");
		}else{
			setStatusTest("fail", "Created category is NOT displayed correctly");
		}
	}
	
	@Test (priority = 9, enabled = true)
	public void TT_19308(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Click btn Add new category again");
		
		TestLogger.info("4. select parent category as created category above, fill category name");
		learningContentPool.createChildCategory(DataManager.LearningContent_child, PropertyManager.EmailAdmin1);
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Success message is displayed");
		}else{
			setStatusTest("fail", "Success message is NOT displayed");
		}
		
		TestLogger.info("5. search created category name");
		learningContentPool.fillSearchCategory(DataManager.LearningContent_child);
		if(learningContentPool.isChildCategoryDisplayed()){
			setStatusTest("pass", "Child category is created successfully");
		}else{
			setStatusTest("fail", "Child category is NOT created successfully");
		}
	}
	
	@Test (priority = 10, enabled = true)
	public void TT_19309(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Prepare data 5 level");
		TestLogger.info("4. Create category level 1");
		learningContentPool.createCategory("Auto level 1", PropertyManager.EmailAdmin1);
		TestLogger.info("5. Create category level 2");
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.selectParentCategory("Auto level 1");
		learningContentPool.fillCategoryName("Auto level 2");
		learningContentPool.clickBtnSave();
		TestLogger.info("6. Create category level 3");
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.selectParentCategory("Auto level 2");
		learningContentPool.fillCategoryName("Auto level 3");
		learningContentPool.clickBtnSave();
		TestLogger.info("7. Create category level 4");
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.selectParentCategory("Auto level 3");
		learningContentPool.fillCategoryName("Auto level 4");
		learningContentPool.clickBtnSave();
		TestLogger.info("8. Create category level 5");
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.selectParentCategory("Auto level 4");
		learningContentPool.fillCategoryName("Auto level 5");
		learningContentPool.clickBtnSave();
		
		TestLogger.info("9. Create category level 6");
		learningContentPool.clickBtnCreateCategory();
		createCategoryLCP.fillParentCategoryNameInvalid("Auto level 5");
		TestLogger.info("10. Search parent category with category level 5");
		TestLogger.info("Expected: Not display category level 5");
		if(createCategoryLCP.isLblNoDataSearchParentDisplayed()){
			setStatusTest("pass", "NO DATA FOUND is displayed");
		}else{
			setStatusTest("fail", "NO DATA FOUND is not displayed");
		}
		learningContentPool.clickBtnCancel();
		
		learningContentPool.fillSearchCategory("Auto level 1");
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
			learningContentPool.clickBtnYesCategory();
		}
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete category successfully");
		}else{
			setStatusTest("fail", "Delete category NOT successfully");
		}
		learningContentPool.fillSearchCategory("Auto level 5");
		if(learningContentPool.isFirstCategoryDisplayed()){
			setStatusTest("pass", "Auto level 1 -> 5 categories is deleted");
		}else{
			setStatusTest("fail", "Auto level 1 -5 categories is NOT deleted");
		}
		
	}
	
	@Test(priority = 11, enabled = true)
	public void TT_19314_instead(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Deactivate an user.");
		controlBoard.clickLblUser();
		if(userManagement.isLblUserManagementDisplayed()){
			setStatusTest("pass", "Access User Management successfully");
		}else{
			setStatusTest("fail", "Access User Management NOT successfully");
		}
		userManagement.fillFilterEmail("inte-aaron.jimenez@tek-experts.com");
		if(userManagement.isBtnChangeStatusFirstUserDisplayed()){
			setStatusTest("pass", "filter successfully");
		}else{
			setStatusTest("fail", "can not filter");
		}
		userManagement.deactivateFirstUser();
		
		TestLogger.info("3. Click btn Add new category");
		userManagement.clickIconControlBoard();
		controlBoard.clickLblLearningContent();
		learningContentPool.clickBtnCreateCategory();
		
		if(learningContentPool.isLblCreateCategoryDisplayed()){
			setStatusTest("pass", "Form Create Category is opened");
		}else{
			setStatusTest("fail", "Form Create Category is not opened");
		}
		
		TestLogger.info("4. Input inactive user");
		TestLogger.info("Expected: can not see inactive user");
		if(!learningContentPool._19314_instead()){
			setStatusTest("pass", "can not see inactive user");
		}else{
			setStatusTest("pass", "still can see inactive user");
		}
		
		TestLogger.info("2. Deactivate an user.");
		userManagement.clickIconControlBoard();
		controlBoard.clickLblUser();
		if(userManagement.isLblUserManagementDisplayed()){
			setStatusTest("pass", "Access User Management successfully");
		}else{
			setStatusTest("fail", "Access User Management NOT successfully");
		}
		userManagement.fillFilterEmail("inte-aaron.jimenez@tek-experts.com");
		if(userManagement.isBtnChangeStatusFirstUserDisplayed()){
			setStatusTest("pass", "filter successfully");
		}else{
			setStatusTest("fail", "can not filter");
		}
		userManagement.activateFirstUser();
	}
	
	@Test (priority = 12, enabled = true)
	public void TT_19320(){
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");

		controlBoard.clickLblLearningContent();
		
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Prepare test category data");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		if(!learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.createCategory(DataManager.LearningContent, PropertyManager.EmailAdmin1);
			if(learningContentPool.isMsgSuccessDisplayed()){
				System.out.println("Category is created successfully");
			}else{
				System.out.println("Category is NOT created successfully");
			}
			learningContentPool.fillSearchCategory(DataManager.LearningContent);
		}
		TestLogger.info("4. Click icon Edit category");
		learningContentPool.clickIconEditCategory();
		if(editCategoryLCP.isLblEditCategoryDisplayed()){
			setStatusTest("pass", "Form Edit Category is displayed");
		}else{
			setStatusTest("fail", "Form Edit Category is NOT displayed");
		}
		TestLogger.info("5. Click iconX");
		TestLogger.info("Expected: close slide");
		editCategoryLCP.clickIconX();
		if(learningContentPool.isBtnCreateContentDisplayed()){
			setStatusTest("pass", "Edit slide is closed");
		}else{
			setStatusTest("fail", "Edit slide is NOT closed");
		}
	}
	
	@Test (priority = 13, enabled = true)
	public void TT_19322(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Click icon Edit category");
		learningContentPool.clickIconEditCategory();
		if(editCategoryLCP.isLblEditCategoryDisplayed()){
			setStatusTest("pass", "Form Edit Category is displayed");
		}else{
			setStatusTest("fail", "Form Edit Category is NOT displayed");
		}
		
		TestLogger.info("4. Count amount of items in Perent Category field");
		System.out.println("Total existed category is: " + editCategoryLCP.countTotalParentCategory());
		if(editCategoryLCP.countTotalParentCategory() > 0){
			setStatusTest("pass", "Display all existed Categories");
		}else{
			setStatusTest("fail", "Not Display any existed Categories");
		}
		
		TestLogger.info("5. Input invalid data to search in Parent Category field");
		editCategoryLCP.fillParentCategoryNameInvalid("I have no data");
		if(editCategoryLCP.isLblNoDataSearchParentDisplayed()){
			setStatusTest("pass", "NO DATA FOUND is displayed");
		}else{
			setStatusTest("fail", "NO DATA FOUND is not displayed");
		}
		
		TestLogger.info("6. Input valid data to search in Parent Category field");
		editCategoryLCP.fillParentCategoryNameValid(DataManager.LearningContent);
		if(editCategoryLCP.isFirstParentCategoryDisplayed()){
			setStatusTest("pass", "Displayed search result correctly");
		}else{
			setStatusTest("fail", "NOT displayed search result");
		}
		editCategoryLCP.clickFirstParentCategory();
		if(editCategoryLCP.getTextSelectedParentCategory().equals(DataManager.LearningContent)){
			setStatusTest("pass", "Select search result correctly");
		}else{
			setStatusTest("fail", "NOT select search result");
		}
	}
	
	@Test (priority = 14, enabled = true)
	public void TT_19328_TT19329(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		// ensure category is already existed
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		if(!learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.createCategory(DataManager.LearningContent, PropertyManager.EmailAdmin1);
		}
		System.out.println("Created new category");
		learningContentPool.clickIconRemoveCategory();
		
		TestLogger.info("3. Edit category with existed name");
		learningContentPool.clickIconEditCategory();
		editCategoryLCP.clearInputCategoryName();
		editCategoryLCP.fillCategoryName(DataManager.LearningContent);
		editCategoryLCP.selectUser(PropertyManager.EmailAdmin1);
		if(editCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Error Message Name is displayed");
		}else{
			setStatusTest("fail", "Error Message Name is NOT displayed");
		}
		if(editCategoryLCP.getTextErrorMsgCategoryName().equals("Category name already exists.")){
			setStatusTest("pass", "Error Message Content Name is correct");
		}else{
			setStatusTest("fail", "Error Message Content Name is NOT correct");
		}
		TestLogger.info("4. Check mandatory message");
		editCategoryLCP.clearInputCategoryName();
		editCategoryLCP.clickBtnSave();
		if(createCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Error Message Name is displayed");
		}else{
			setStatusTest("fail", "Error Message Name is NOT displayed");
		}
		if(createCategoryLCP.getTextErrorMsgCategoryName().equals("Mandatory field.")){
			setStatusTest("pass", "Error Message Content Name is correct");
		}else{
			setStatusTest("fail", "Error Message Content Name is NOT correct");
		}
	}
	
	@Test (priority = 15, enabled = true)
	public void TT_19330(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Open edit category form");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickIconEditCategory();
		
		TestLogger.info("4. Fill category name less than 250 characters");
		editCategoryLCP.clearInputCategoryName();
		editCategoryLCP.fillCategoryName(DataManager.lessThan250);
		editCategoryLCP.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("5. User DO NOT see error message in Category Name field.");
		if(!editCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input less than 250 characters OK");
		}else{
			setStatusTest("fail", "Input less than 250 characters NOT OK");
		}
		TestLogger.info("6. Fill category name equal to 250 characters");
		editCategoryLCP.clearInputCategoryName();
		editCategoryLCP.fillCategoryName(DataManager.equal250);
		editCategoryLCP.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("7. User DO NOT see error message in Category Name field.");
		if(!editCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input equal to 250 characters OK");
		}else{
			setStatusTest("fail", "Input equal to 250 characters NOT OK");
		}
		TestLogger.info("8. Fill category name more than 250 characters");
		editCategoryLCP.clearInputCategoryName();
		editCategoryLCP.fillCategoryName(DataManager.moreThan250);
		editCategoryLCP.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("9. User DO NOT see error message in Category Name field. (auto truncated from 250th character)");
		if(!editCategoryLCP.isErrMsgCategoryNameDisplayed()){
			setStatusTest("pass", "Input more than 250 characters OK");
		}else{
			setStatusTest("fail", "Input more than 250 characters NOT OK");
		}
		editCategoryLCP.clickBtnCancel();
	}
	
	@Test (priority = 16, enabled = true)
	public void TT_19331_TT_19356_TT_19332() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Open edit category form");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickIconEditCategory();
		
		TestLogger.info("4. Select an user");
		editCategoryLCP.deleteAllAssignedUser();
		editCategoryLCP.selectUser(PropertyManager.EmailAdmin1);
		TestLogger.info("Expected: selected email and avatar are displayed");
		if(editCategoryLCP.isEmailUserDisplayed() && editCategoryLCP.isAvatarUserDisplayed()){
			setStatusTest("pass", "Selected email and avatar are displayed properly");
		}else{
			setStatusTest("fail", "Selected email and avatar are NOT displayed properly");
		}
		TestLogger.info("5. Compare email");
		if(editCategoryLCP.getEmail().equals(PropertyManager.EmailAdmin1)){
			setStatusTest("pass", "Selected email is correct");
		}else{
			setStatusTest("fail", "Selected email is NOT correct");
		}
		
		TestLogger.info("6. TT19356 - Check btn Save displayed and enable");
		if(editCategoryLCP.isBtnSaveDisplayed() && editCategoryLCP.isBtnSaveEnable()){
			setStatusTest("pass", "Btn Save is displayed and enable");
		}else{
			setStatusTest("fail", "Btn Save is NOT displayed or enable");
		}
		
		TestLogger.info("7. TT19332 - Click button Cancel");
		if(editCategoryLCP.isBtnCancelDisplayed() && editCategoryLCP.isBtnCancelEnable()){
			setStatusTest("pass", "Btn Cancel is displayed and enable");
		}else{
			setStatusTest("fail", "Btn Cancel is NOT displayed or enable");
		}
		editCategoryLCP.clickBtnCancel();
		Thread.sleep(1000);
		if(learningContentPool.isBtnCreateContentDisplayed()){
			setStatusTest("pass", "Form Create Category is closed");
		}else{
			setStatusTest("fail", "Form Create Category is not closed");
		}
	}
	
	@Test (priority = 17, enabled = true)
	public void TT_19357(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Open edit category form");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickIconEditCategory();
		
		TestLogger.info("4. Select blank parent category");
		editCategoryLCP.selectItemBlank();
		TestLogger.info("5. Click Save button");
		editCategoryLCP.clickBtnSave();
		if (learningContentPool.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Save successfully");
		} else {
			setStatusTest("fail", "NOT save successfully");
		}
		TestLogger.info("6. Search edited category");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		TestLogger.info("7. Expected: searched category is displayed under category All");
		if(learningContentPool.isFirstCategoryDisplayed() && learningContentPool.getTextFirstItemCategory().equals(DataManager.LearningContent)){
			setStatusTest("pass", "Blank parent category is displayed correctly");
		}else{
			setStatusTest("fail", "Blank parent category is NOT displayed correctly");
		}
	}
	
	@Test (priority = 18, enabled = true)
	public void TT_19360(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Open edit category form ");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickIconEditCategory();
		
		TestLogger.info("4. Select a random parent category ");
		editCategoryLCP.selectSecondParentCategory();
		editCategoryLCP.clickBtnSave();
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Category is updated successfully");
		}else{
			setStatusTest("fail", "Category is NOT updated successfully");
		}
		
		TestLogger.info("5. Search edited category");
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		TestLogger.info("6. Expected: edited category is under another category");
		learningContentPool.clickExpandCategory();
		if(learningContentPool.isChildCategoryDisplayed() && learningContentPool.getTextChildItemCategory().equals(DataManager.LearningContent)){
			setStatusTest("pass", "Edited category is displayed under another one");
		}else{
			setStatusTest("fail", "Edited category is NOT displayed under another one");
		}
		
		TestLogger.info("7. Back data to default");
		learningContentPool.clickIconEditChildCategory();
		editCategoryLCP.selectParentCategoryAll();
		editCategoryLCP.clickBtnSave();
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Category is back to default successfully");
		}else{
			setStatusTest("fail", "Category is back to default successfully");
		}
	}
	
	@Test (priority = 19, enabled = true)
	public void TT_19364(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Prepare data 5 level");
		learningContentPool.fillSearchCategory("Auto level 5");
		if(!learningContentPool.isFirstCategoryDisplayed()){
			TestLogger.info("4. Create category level 1");
			learningContentPool.createCategory("Auto level 1", PropertyManager.EmailAdmin1);
			TestLogger.info("5. Create category level 2");
			learningContentPool.clickBtnCreateCategory();
			learningContentPool.selectParentCategory("Auto level 1");
			learningContentPool.fillCategoryName("Auto level 2");
			learningContentPool.clickBtnSave();
			TestLogger.info("6. Create category level 3");
			learningContentPool.clickBtnCreateCategory();
			learningContentPool.selectParentCategory("Auto level 2");
			learningContentPool.fillCategoryName("Auto level 3");
			learningContentPool.clickBtnSave();
			TestLogger.info("7. Create category level 4");
			learningContentPool.clickBtnCreateCategory();
			learningContentPool.selectParentCategory("Auto level 3");
			learningContentPool.fillCategoryName("Auto level 4");
			learningContentPool.clickBtnSave();
			TestLogger.info("8. Create category level 5");
			learningContentPool.clickBtnCreateCategory();
			learningContentPool.selectParentCategory("Auto level 4");
			learningContentPool.fillCategoryName("Auto level 5");
			learningContentPool.clickBtnSave();
			TestLogger.info("9. Clear search");
			if(learningContentPool.isSearchCleared()){
				setStatusTest("pass", "Search field is clear");
			}else{
				setStatusTest("fail", "Search field is not clear");
			}
		}
		learningContentPool.fillSearchCategory(DataManager.LearningContent);
		learningContentPool.clickIconEditCategory();
		TestLogger.info("10. Search parent category with category level 5");
		TestLogger.info("Expected: Error message displays when selecting level 5");
		editCategoryLCP.selectParentCategory("Auto level 5");
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Error message is displayed");
		}else{
			setStatusTest("fail", "Error message is not displayed");
		}
		editCategoryLCP.clickBtnCancel();
		
		learningContentPool.fillSearchCategory("Auto level 1");
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
			learningContentPool.clickBtnYesCategory();
		}
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete category successfully");
		}else{
			setStatusTest("fail", "Delete category NOT successfully");
		}
	}
	
	@Test (priority = 20, enabled = true)
	public void TT_19407_TT19413(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		
		TestLogger.info("3. Create category level 1");
		learningContentPool.createCategory("Auto deleted lv1", PropertyManager.EmailAdmin1);
		learningContentPool.fillSearchCategory("Auto deleted lv1");
		TestLogger.info("4. Delete category level 1 single");
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
		}
		if(learningContentPool.checkConfirmDeletePopupContent()){
			setStatusTest("pass", "Popup confirm content is correct");
		}else{
			setStatusTest("fail", "Popup confirm content is NOT correct");
		}
		learningContentPool.clickBtnYesCategory();
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete category successfully");
		}else{
			setStatusTest("fail", "Delete category NOT successfully");
		}
		if(learningContentPool.isSearchCleared()){
			setStatusTest("pass", "Search field is clear");
		}else{
			setStatusTest("fail", "Search field is not clear");
		}
		TestLogger.info("Expected: Category All is auto selected");
		if(learningContentPool.isCategoryAllSelected()){
			setStatusTest("pass", "Category All is auto-selected successfully");
		}else{
			setStatusTest("fail", "Category All is NOT auto-selected");
		}
		TestLogger.info("6. Create category level 2");
		learningContentPool.createCategory("Auto deleted lv1", PropertyManager.EmailAdmin1);
		learningContentPool.clickBtnCreateCategory();
		learningContentPool.selectParentCategory("Auto deleted lv1");
		learningContentPool.fillCategoryName("Auto deleted lv2");
		learningContentPool.clickBtnSave();
		learningContentPool.fillSearchCategory("Auto deleted lv1");
		TestLogger.info("7. Delete category level 1 has child category");
		if(learningContentPool.isFirstCategoryDisplayed()){
			learningContentPool.clickIconDeleteCategory();
		}
		if(learningContentPool.checkConfirmDeletePopupContent()){
			setStatusTest("pass", "Popup confirm content is correct");
		}else{
			setStatusTest("fail", "Popup confirm content is NOT correct");
		}
		learningContentPool.clickBtnYesCategory();
		if(learningContentPool.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete category successfully");
		}else{
			setStatusTest("fail", "Delete category NOT successfully");
		}
		if(learningContentPool.isSearchCleared()){
			setStatusTest("pass", "Search field is clear");
		}else{
			setStatusTest("fail", "Search field is not clear");
		}
		TestLogger.info("Expected: Category All is auto selected");
		if(learningContentPool.isCategoryAllSelected()){
			setStatusTest("pass", "Category All is auto-selected successfully");
		}else{
			setStatusTest("fail", "Category All is NOT auto-selected");
		}
	}
	
	@Test (priority = 21, enabled = true)
	public void TT_19429_Case1() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Update Function Set| Learning And Development | View Content List = ON only");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clicktabLearningAndDevelopment();
		editFunctionSet.clickSubTabLearningContentPool();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		
		editFunctionSet.clickONBtnViewContentList();
		editFunctionSet.clickOFFBtnManageContentCategory();
		editFunctionSet.clickOFFBtnCreateContent();
		editFunctionSet.clickOFFBtnViewContentDetail();
		editFunctionSet.clickOFFBtnDeleteContent();
		editFunctionSet.clickOFFBtnRejectContent();
		editFunctionSet.clickOFFBtnMarkUnmarkAsMicrolearning();
		editFunctionSet.clickOFFBtnEditContent();
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
		TestLogger.info("5. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		TestLogger.info("Expect : User CAN see/do: " + "Category list");
		if(learningContentPool.isFirstCategoryDisplayed()){
			setStatusTest("pass", "User CAN see Category list");
		}else{
			setStatusTest("fail", "User CANNOT see Category list");
		}
		TestLogger.info("Expect : User CANNOT see/do: " + "icon Create/ Edit/ Delete category");
		if(!learningContentPool.isBtnCreateCategoryDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Create category");
		}else{
			setStatusTest("fail", "User CAN see btn Create category");
		}
		if(!learningContentPool.isIconEditCategoryDisplayed()){
			setStatusTest("pass", "User CANNOT see icon Edit category");
		}else{
			setStatusTest("fail", "User CAN see icon Edit category");
		}
		if(!learningContentPool.isIconDeleteCategoryDisplayed()){
			setStatusTest("pass", "User CANNOT see icon Delete category");
		}else{
			setStatusTest("fail", "User CAN see icon Delete category");
		}
	}
	
	@Test (priority = 22, enabled = true)
	public void TT_19429_Case2() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Update Function Set| Learning And Development | OFF all permissions");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clicktabLearningAndDevelopment();
		editFunctionSet.clickSubTabLearningContentPool();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		
		editFunctionSet.clickOFFBtnViewContentList();
		editFunctionSet.clickOFFBtnManageContentCategory();
		editFunctionSet.clickOFFBtnCreateContent();
		editFunctionSet.clickOFFBtnViewContentDetail();
		editFunctionSet.clickOFFBtnDeleteContent();
		editFunctionSet.clickOFFBtnRejectContent();
		editFunctionSet.clickOFFBtnMarkUnmarkAsMicrolearning();
		editFunctionSet.clickOFFBtnEditContent();
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
		TestLogger.info("5. Chek link Learning Content Pool in Control Board");
		TestLogger.info("Expected: User CANNOT see Learning Content Pool");
		if(!controlBoard.isLblLearningContentDisplayed()){
			setStatusTest("pass", "User CANNOT see Learning Content Pool");
		}else{
			setStatusTest("fail", "User CAN see Learning Content Pool");
		}
	}
	
	@Test (priority = 23, enabled = true)
	public void TT_19431_Case1() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Update Function Set| Learning And Development | View Content List = ON only");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clicktabLearningAndDevelopment();
		editFunctionSet.clickSubTabLearningContentPool();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		
		editFunctionSet.clickONBtnViewContentList();
		editFunctionSet.clickONBtnManageContentCategory();
		editFunctionSet.clickOFFBtnCreateContent();
		editFunctionSet.clickOFFBtnViewContentDetail();
		editFunctionSet.clickOFFBtnDeleteContent();
		editFunctionSet.clickOFFBtnRejectContent();
		editFunctionSet.clickOFFBtnMarkUnmarkAsMicrolearning();
		editFunctionSet.clickOFFBtnEditContent();
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
		TestLogger.info("5. Access to Learning Content Pool");
		controlBoard.clickLblLearningContent();
		if (learningContentPool.isBreadcrumbDisplayed() == true) {
			setStatusTest("pass", "Access to Learning Content Pool");
		} else {
			setStatusTest("fail", "Not Access to Learning Content Pool");
		}
		TestLogger.info("Expect : User CAN see/do: " + "Category list");
		if(learningContentPool.isFirstCategoryDisplayed()){
			setStatusTest("pass", "User CAN see Category list");
		}else{
			setStatusTest("fail", "User CANNOT see Category list");
		}
		TestLogger.info("Expect : User CAN see/do: " + "icon Create/ Edit/ Delete category");
		if(learningContentPool.isBtnCreateCategoryDisplayed()){
			setStatusTest("pass", "User CAN see btn Create category");
		}else{
			setStatusTest("fail", "User CANNOT see btn Create category");
		}
		if(learningContentPool.isIconEditCategoryDisplayed()){
			setStatusTest("pass", "User CAN see icon Edit category");
		}else{
			setStatusTest("fail", "User CANNOT see icon Edit category");
		}
		if(learningContentPool.isIconDeleteCategoryDisplayed()){
			setStatusTest("pass", "User CAN see icon Delete category");
		}else{
			setStatusTest("fail", "User CANNOT see icon Delete category");
		}
	}
	
	@Test (priority = 24, enabled = true)
	public void TT_19431_Case2() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
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
		
		TestLogger.info("3. Update Function Set| Learning And Development | OFF all permissions");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		editFunctionSet.clicktabLearningAndDevelopment();
		editFunctionSet.clickSubTabLearningContentPool();
		editFunctionSet.clickCboxCustomization();
		editFunctionSet.clickCboxSubCustomization();
		
		editFunctionSet.clickOFFBtnViewContentList();
		editFunctionSet.clickONBtnManageContentCategory();
		editFunctionSet.clickOFFBtnCreateContent();
		editFunctionSet.clickOFFBtnViewContentDetail();
		editFunctionSet.clickOFFBtnDeleteContent();
		editFunctionSet.clickOFFBtnRejectContent();
		editFunctionSet.clickOFFBtnMarkUnmarkAsMicrolearning();
		editFunctionSet.clickOFFBtnEditContent();
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
		TestLogger.info("5. Chek link Learning Content Pool in Control Board");
		TestLogger.info("Expected: User CANNOT see Learning Content Pool");
		if(!controlBoard.isLblLearningContentDisplayed()){
			setStatusTest("pass", "User CANNOT see Learning Content Pool");
		}else{
			setStatusTest("fail", "User CAN see Learning Content Pool");
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
