package wize;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

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
import wize.pages.Form_EditFunctionSet;
import wize.pages.Form_EmployeeDetails;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.TalentManagement;
import wize.pages.TalentManagement_Employee;
import wize.pages.UserManagement;

public class Test_FunctionSet_TalentManagement_Employee extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	
	Form_EmployeeDetails employeeDetais;
	TalentManagement_Employee talentEmployee;
	TalentManagement talent;
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
		
		employeeDetais = new Form_EmployeeDetails(driver);
		talentEmployee = new TalentManagement_Employee(driver);
		talent = new TalentManagement(driver);
		cloneForm = new Clone_Form_EditFunctionSet(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1,enabled = true)
	public void TT_18822() throws InterruptedException {
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
		
		TestLogger.info("3. Update Function Set| Talent Management - Employee | VIEW Only Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		cloneForm.clickTabTalentManagement();
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
		
		TestLogger.info("5. Access to Talent Management");

		controlBoard.clickTabTalentManagement();
		
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "User CAN See/Do: Data table cards");
		
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table cards");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table cards");
		}
		
		TestLogger.info("6. Access to Employee Details");
		
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isTabDataDisplayed() == true) {
			setStatusTest("pass", "Access to Employee Details");
		} else {
			setStatusTest("fail", "NOT Access to Employee Details");
		}
		driver.close();
		
		TestLogger.info("7. Click on icon Table View");
		driver.switchTo().window(parent);	
		talentEmployee.clickBtnTableView();
		
		TestLogger.info("Expect : User CAN see/do: "  + "Table records");
		
		if (talentEmployee.isLinkEmployeeTableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Table records");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Table records");
		}
		
		TestLogger.info("8. Click on employee name");
		
		talentEmployee.clickLinkEmployeeTable();
		
		Set<String> s1=driver.getWindowHandles();

		Iterator<String> I2= s1.iterator();

		while(I2.hasNext())
		{
			String child_window=I2.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isTabDataDisplayed() == true) {
			setStatusTest("pass", "Access to Employee Details");
		} else {
			setStatusTest("fail", "NOT Access to Employee Details");
		}
		driver.close();
		driver.switchTo().window(parent);
}
		
	@Test(priority = 2, enabled = true)
	public void TT25641() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - ORGANIZATION CHART | NO Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnRadioOrganizationChart();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabOrgChartDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Organization Chart");
		} else {
			setStatusTest("fail", "User STILL CAN see Organization Chart");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 3, enabled = true)
	public void TT25640() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - ORGANIZATION CHART | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxViewOnly();
		cloneForm.clickCboxSubViewOnly();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabOrgChartDisplayed() == true) {
			setStatusTest("pass", "User CAN see Organization Chart");
		} else {
			setStatusTest("fail", "User CANNOT see Organization Chart");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 4, enabled = true)
	public void TT25639() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - ORGANIZATION CHART | FULL Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxSubFullPermission();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabOrgChartDisplayed() == true) {
			setStatusTest("pass", "User CAN see Organization Chart");
		} else {
			setStatusTest("fail", "User CANNOT see Organization Chart");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 5, enabled = true)
	public void TT25635() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | NO Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnRadioPosition();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Position sub tab");
		} else {
			setStatusTest("fail", "User STILL CAN see Position sub tab");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 6, enabled = true)
	public void TT25634() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxViewOnly();
		cloneForm.clickCboxSubViewOnly();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see Position sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Position sub tab");
		}
		employeeDetais.clickSubTabPosition();
		TestLogger.info("7. Expected: Can see Data table");
		if (employeeDetais.isFirstLinkClickable() == true) {
			setStatusTest("pass", "User CAN see Data table");
		} else {
			setStatusTest("fail", "User CANNOT see Data table");
		}
		employeeDetais.clickIconClose();
		TestLogger.info("8. Expected: CANNOT see Assign, delete, edit button");
		if (employeeDetais.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Delete button");
		} else {
			setStatusTest("fail", "User CAN see Delete button");
		}
		if (employeeDetais.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Edit button");
		} else {
			setStatusTest("fail", "User CAN see Edit button");
		}
		if (employeeDetais.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Assign button");
		} else {
			setStatusTest("fail", "User CAN see Assign button");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 7, enabled = true)
	public void TT25633() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | FULL Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxSubFullPermission();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see Position sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Position sub tab");
		}
		employeeDetais.clickSubTabPosition();
		talentEmployee.searchPosition(DataManager.Test);
		if(employeeDetais.isFirstLinkDisplayed()){
			employeeDetais.clickBtnDelete();
			employeeDetais.clickYESConfirm();
		}
		TestLogger.info("7. Expected: Can see Data table, Assign, delete, edit button");
		if (employeeDetais.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see Assign button");
		} else {
			setStatusTest("fail", "User CANNOT see Assign button");
		}
		TestLogger.info("8. Click Btn Assign Position");
		employeeDetais.clickBtnAssign();
		if(employeeDetais.isTitleAssignDisplayed()){
			setStatusTest("pass", "Form Assign Position is displayed");
		}else{
			setStatusTest("fail", "Form Assign Position is NOT displayed");
		}
		employeeDetais.fillPosName(DataManager.Test);
		employeeDetais.setStartDate();
		employeeDetais.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "User CAN Assign Position");
		}else{
			setStatusTest("fail", "User CANNOT Assign Position");
		}
		
		if (employeeDetais.isFirstLinkClickable() == true) {
			setStatusTest("pass", "User CAN see Data table");
		} else {
			setStatusTest("fail", "User CANNOT see Data table");
		}
		employeeDetais.clickIconClose();
		if (employeeDetais.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see Delete button");
		} else {
			setStatusTest("fail", "User CANNOT see Delete button");
		}
		if (employeeDetais.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see Edit button");
		}
		talentEmployee.searchPosition(DataManager.Test);
		if(employeeDetais.isFirstLinkDisplayed()){
			employeeDetais.clickBtnEdit();
			employeeDetais.updateStartDate();
			employeeDetais.clickBtnSaveUpdate();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "User CAN update position");
			}else{
				setStatusTest("fail", "User CANNOT update position");
			}
		}
		employeeDetais.clickBtnDelete();
		employeeDetais.clickYESConfirm();
		talentEmployee.searchPosition(DataManager.Test);
		if(!employeeDetais.isFirstLinkDisplayed()){
			setStatusTest("pass", "User CAN delete position");
		}else{
			setStatusTest("fail", "User CANNOT delete position");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 8, enabled = true)
	public void TT25636() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | VIEW + ASSIGN Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickONBtnAssignPositiontoEmployee();
		cloneForm.clickOFFBtnUpdatePositiontoEmployeeAssignment();
		cloneForm.clickOFFBtnDeletePositiontoEmployeeAssignment();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see Position sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Position sub tab");
		}
		employeeDetais.clickSubTabPosition();
		TestLogger.info("7. Expected: Can see Data table, Assign, delete, edit button");
		if (employeeDetais.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see Assign button");
		} else {
			setStatusTest("fail", "User CANNOT see Assign button");
		}
		TestLogger.info("8. Click Btn Assign Position");
		employeeDetais.clickBtnAssign();
		if(employeeDetais.isTitleAssignDisplayed()){
			setStatusTest("pass", "Form Assign Position is displayed");
		}else{
			setStatusTest("fail", "Form Assign Position is NOT displayed");
		}
		employeeDetais.fillPosName(DataManager.Test);
		employeeDetais.setStartDate();
		employeeDetais.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "User CAN Assign Position");
		}else{
			setStatusTest("fail", "User CANNOT Assign Position");
		}
		
		if (employeeDetais.isFirstLinkClickable() == true) {
			setStatusTest("pass", "User CAN see Data table");
		} else {
			setStatusTest("fail", "User CANNOT see Data table");
		}
		employeeDetais.clickIconClose();
		if (employeeDetais.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Delete button");
		} else {
			setStatusTest("fail", "User CAN see Delete button");
		}
		if (employeeDetais.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Edit button");
		} else {
			setStatusTest("fail", "User CAN see Edit button");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 9, enabled = true)
	public void TT25637() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | VIEW + UPDATE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnAssignPositiontoEmployee();
		cloneForm.clickONBtnUpdatePositiontoEmployeeAssignment();
		cloneForm.clickOFFBtnDeletePositiontoEmployeeAssignment();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see Position sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Position sub tab");
		}
		employeeDetais.clickSubTabPosition();
		TestLogger.info("7. Expected: User can update position");
		talentEmployee.searchPosition(DataManager.Test);
		if(employeeDetais.isFirstLinkDisplayed()){
			employeeDetais.clickBtnEdit();
			employeeDetais.fillDescription("New des");
			employeeDetais.clickBtnSave();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "User CAN update position");
			}else{
				setStatusTest("fail", "User CANNOT update position");
			}
		}
		TestLogger.info("8. Expected: User can view position");
		if(employeeDetais.isFirstLinkClickable()){
			setStatusTest("pass", "User CAN view detail position");
		}else{
			setStatusTest("fail", "User CANNOT view detail position");
		}
		employeeDetais.clickIconClose();
		if (employeeDetais.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Assign button");
		} else {
			setStatusTest("fail", "User CAN see Assign button");
		}
		if (employeeDetais.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Delete button");
		} else {
			setStatusTest("fail", "User CAN see Delete button");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 10, enabled = true)
	public void TT25638() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - POSITION | VIEW + DELETE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnAssignPositiontoEmployee();
		cloneForm.clickOFFBtnUpdatePositiontoEmployeeAssignment();
		cloneForm.clickONBtnDeletePositiontoEmployeeAssignment();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see Position sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Position sub tab");
		}
		employeeDetais.clickSubTabPosition();
		TestLogger.info("7. Expected: User can Delete position");
		talentEmployee.searchPosition(DataManager.Test);
		TestLogger.info("8. Expected: User can view position");
		if(employeeDetais.isFirstLinkClickable()){
			setStatusTest("pass", "User CAN view detail position");
		}else{
			setStatusTest("fail", "User CANNOT view detail position");
		}
		employeeDetais.clickIconClose();
		if (employeeDetais.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Assign button");
		} else {
			setStatusTest("fail", "User CAN see Assign button");
		}
		if (employeeDetais.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Edit button");
		} else {
			setStatusTest("fail", "User CAN see Edit button");
		}
		employeeDetais.clickBtnDelete();
		employeeDetais.clickYESConfirm();
		talentEmployee.searchPosition(DataManager.Test);
		if(!employeeDetais.isFirstLinkDisplayed()){
			setStatusTest("pass", "User CAN delete position");
		}else{
			setStatusTest("fail", "User CANNOT delete position");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 11, enabled = true)
	public void TT25630() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - WORK PERMIT | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnViewWorkPermit();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CANNOT see Work Permit section");
		if(!employeeDetais.isLblWorkPermitDisplayed()){
			setStatusTest("pass", "User CANNOT see Work Permit section");
		}else{
			setStatusTest("fail", "User CAN see Work Permit section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 12, enabled = true)
	public void TT25632() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - WORK PERMIT | VIEW + MANAGE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Work Permit section, btn Add, Edit, Delete");
		if(employeeDetais.isLblWorkPermitDisplayed()){
			setStatusTest("pass", "User CAN see Work Permit section");
		}else{
			setStatusTest("fail", "User CANNOT see Work Permit section");
		}
		if(employeeDetais.isBtnAddWorkPermitDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Work Permit");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Work Permit");
		}
		employeeDetais.searchPermitNumber(DataManager.Test);
		if(employeeDetais.isFirstLinkWorkPermitDisplayed()){
			employeeDetais.clickBtnDeleteWorkPermit();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete work permit successfully");
			}else{
				setStatusTest("fail", "Delete work permit NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new work permit >> See success message");
		employeeDetais.clickBtnAddWorkPermit();
		if(employeeDetais.isTxtPermitNumberAddNew()){
			setStatusTest("pass", "Form Add Work Permit is displayed");
		}else{
			setStatusTest("fail", "Form Add Work Permit is NOT displayed");
		}
		employeeDetais.fillPermitNumberAddNew(DataManager.Test);
		employeeDetais.selectCountryAddNew("Angola");
		employeeDetais.setIssueDate();
		employeeDetais.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create work permit successfully");
		}else{
			setStatusTest("fail", "Create work permit NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT work permit");
		employeeDetais.searchPermitNumber(DataManager.Test);
		if(employeeDetais.isBtnEditWorkPermitDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Work Permit");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Work Permit");
		}
		employeeDetais.clickBtnEditWorkPermit();
		employeeDetais.selectCountryEdit("Albania");
		employeeDetais.clickBtnSaveUpdate();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Edit work permit successfully");
		}else{
			setStatusTest("fail", "Edit work permit NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of work permit");
		employeeDetais.clickFirstLinkWorkPermit();
		if(employeeDetais.isTitleWorkPermitDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail work permit");
		}else{
			setStatusTest("fail", "User CANNOT view detail work permit");
		}
		employeeDetais.clickIconCloseWorkPermitDetail();
		TestLogger.info("Expected: User CAN delete work permit");
		if(employeeDetais.isBtnDeleteWorkPermitDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Work Permit");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Work Permit");
		}
		employeeDetais.clickBtnDeleteWorkPermit();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete work permit successfully");
		}else{
			setStatusTest("fail", "Delete work permit NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 13, enabled = true)
	public void TT25631() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - WORK PERMIT | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickONBtnViewWorkPermit();
		cloneForm.clickOFFBtnManageWorkPermit();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Work Permit section");
		if(employeeDetais.isLblWorkPermitDisplayed()){
			setStatusTest("pass", "User CAN see Work Permit section");
		}else{
			setStatusTest("fail", "User CANNOT see Work Permit section");
		}
		TestLogger.info("Expected: User CAN view detail of work permit");
		employeeDetais.clickFirstLinkWorkPermit();
		if(employeeDetais.isTitleWorkPermitDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail work permit");
		}else{
			setStatusTest("fail", "User CANNOT view detail work permit");
		}
		employeeDetais.clickIconCloseWorkPermitDetail();
		TestLogger.info("Expected: User CANNOT see Create, Edit, Delete buttons");
		if(!employeeDetais.isBtnAddWorkPermitClickable()){
			setStatusTest("pass", "User CANNOT see btn Add new work permit");
		}else{
			setStatusTest("fail", "User CAN see btn Add new work permit");
		}
		if(!employeeDetais.isBtnEditWorkPermitDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Edit work permit");
		}else{
			setStatusTest("fail", "User CAN see btn Edit work permit");
		}
		if(!employeeDetais.isBtnDeleteWorkPermitDisplayed()){
			setStatusTest("pass", "User CANNOT see btn Delete work permit");
		}else{
			setStatusTest("fail", "User CAN see btn Delete work permit");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 14, enabled = true)
	public void TT25627() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnViewEmploymentData();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CANNOT see Employment section");
		if(!employeeDetais.isTitleEmploymentDisplayed()){
			setStatusTest("pass", "User CANNOT see Employment section");
		}else{
			setStatusTest("fail", "User CAN see Employment section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 15, enabled = true)
	public void TT25628() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickONBtnViewEmploymentData();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Employment section");
		if(employeeDetais.isTitleEmploymentDisplayed()){
			setStatusTest("pass", "User CAN see Employment section");
		}else{
			setStatusTest("fail", "User CANNOT see Employment section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 15, enabled = true)
	public void TT25625() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnViewContractInfo();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CANNOT see Contract Info section");
		if(!employeeDetais.isContractInfoDisplayed()){
			setStatusTest("pass", "User CANNOT see Contract Info section");
		}else{
			setStatusTest("fail", "User CAN see Contract Info section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 16, enabled = true)
	public void TT25626() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickONBtnViewContractInfo();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Contract Info section");
		if(employeeDetais.isContractInfoDisplayed()){
			setStatusTest("pass", "User CAN see Contract Info section");
		}else{
			setStatusTest("fail", "User CANNOT see Contract Info section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 17, enabled = true)
	public void TT25624() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnViewContract();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CANNOT see Contract section");
		if(!employeeDetais.isTitleContractDisplayed()){
			setStatusTest("pass", "User CANNOT see Employment section");
		}else{
			setStatusTest("fail", "User CAN see Employment section");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 18, enabled = true)
	public void TT25623() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Contract section");
		if(employeeDetais.isTitleContractDisplayed()){
			setStatusTest("pass", "User CAN see Contract section");
		}else{
			setStatusTest("fail", "User CANNOT see Contract section");
		}
		TestLogger.info("8. Expected: User CANNOT see Create, Edit, Delete button");
		if(!employeeDetais.isBtnAddContractClickable()){
			setStatusTest("pass", "User CANNOT see Create contract button");
		}else{
			setStatusTest("fail", "User CAN see Create contract button");
		}
		if(!employeeDetais.isBtnEditEmpPayrollCodeDisplayed()){
			setStatusTest("pass", "User CANNOT see Edit contract button");
		}else{
			setStatusTest("fail", "User CAN see Edit contract button");
		}
		if(!employeeDetais.isBtnDeleteEmpPayrollCodeDisplayed()){
			setStatusTest("pass", "User CANNOT see Delete contract button");
		}else{
			setStatusTest("fail", "User CAN see Delete contract button");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 19, enabled = true)
	public void TT25622() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EMPLOYMENT | FULL Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabContractDisplayed() == true) {
			setStatusTest("pass", "User CAN see Contract sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Contract sub tab");
		}
		employeeDetais.clickSubTabContract();
		TestLogger.info("7. Expected: User CAN see Contract section, btn Add, Edit, Delete");
		if(employeeDetais.isTitleContractDisplayed()){
			setStatusTest("pass", "User CAN see Contract section");
		}else{
			setStatusTest("fail", "User CANNOT see Contract section");
		}
		if(employeeDetais.isBtnAddContractDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Contract");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Contract");
		}
		employeeDetais.searchEmpPayrollCode(DataManager.Test);
		if(employeeDetais.isFirstLinkEmpPayrollCodeDisplayed()){
			employeeDetais.clickBtnDeleteEmpPayrollCode();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete work permit successfully");
			}else{
				setStatusTest("fail", "Delete work permit NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new Contract >> See success message");
		employeeDetais.clickBtnAddContract();
		if(employeeDetais.isTitleAddContractFormDisplayed()){
			setStatusTest("pass", "Form Add Contract is displayed");
		}else{
			setStatusTest("fail", "Form Add Contract is NOT displayed");
		}
		employeeDetais.fillEmpPayrollCode(DataManager.Test);
		employeeDetais.selectPayCurrency();
		employeeDetais.setStartDateCreateContract();
		employeeDetais.selectContractType();
		employeeDetais.clickBtnSaveCreateContract();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create Contract successfully");
		}else{
			setStatusTest("fail", "Create Contract NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT Contract");
		employeeDetais.searchEmpPayrollCode(DataManager.Test);
		if(employeeDetais.isBtnEditEmpPayrollCodeDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Contract");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Contract");
		}
		employeeDetais.clickBtnEditEmpPayrollCode();
		Thread.sleep(1500);
		employeeDetais.setTerminationDateEditContract();
		employeeDetais.clickBtnSaveUpdateContract();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Edit Contract successfully");
		}else{
			setStatusTest("fail", "Edit Contract NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of Contract");
		employeeDetais.clickFirstLinkfirstLinkEmpPayrollCode();
		if(employeeDetais.isTitleContractDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail Contract");
		}else{
			setStatusTest("fail", "User CANNOT view detail Contract");
		}
		employeeDetais.clickIconCloseContractDetail();
		TestLogger.info("Expected: User CAN delete Contract");
		if(employeeDetais.isBtnDeleteEmpPayrollCodeDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Contract");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Contract");
		}
		employeeDetais.clickBtnDeleteEmpPayrollCode();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Delete Contract successfully");
		}else{
			setStatusTest("fail", "Delete Contract NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 20, enabled = true)
	public void TT25607_TT25608() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL | NO Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnRadioPersonal();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPersonalDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see Personal sub tab");
		} else {
			setStatusTest("fail", "User CAN see Personal sub tab");
		}
	}
	
	@Test(priority = 21, enabled = true)
	public void TT25606_TT25609() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL PROFILE | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnEditProfile();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CAN see Personal info");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isPersonalInfoDisplayed() == true) {
				setStatusTest("pass", "User CAN see Personal Info");
			} else {
				setStatusTest("fail", "User CANNOT see Personal Info");
			}
			TestLogger.info("Expected: CANNOT see edit profile button");
			if (employeeDetais.isIconEditProfileClickable() == false) {
				setStatusTest("pass", "User CANNOT see Edit Profile button");
			} else {
				setStatusTest("fail", "User CAN see Edit Profile button");
			}
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 22, enabled = true)
	public void TT25605() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL PROFILE | FULL Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		employeeDetais.clickSubTabPersonal();
		TestLogger.info("Expected: CAN see Personal info, Edit Profile button");
		if (employeeDetais.isPersonalInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see Personal Info");
		} else {
			setStatusTest("fail", "User CANNOT see Personal Info");
		}
		if (employeeDetais.isIconEditProfileDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see Edit Profile button");
		} else {
			setStatusTest("fail", "User CAN see Edit Profile button");
		}
		String oldPersonalEmail = employeeDetais.getPersonalEmail();
		TestLogger.info("7. Open Edit Profile form >> Edit successfully");
		employeeDetais.clickIconEditProfile();
		if(employeeDetais.isTitleEditProfileDisplayed()){
			setStatusTest("pass", "Open Edit Profile form successfully");
		}else{
			setStatusTest("fail", "Open Edit Profile form NOT successfully");
		}
		employeeDetais.fillPersonalEmail("test@test.com");
		employeeDetais.clickBtnSaveEditProfile();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message update successfully");
		}else{
			setStatusTest("fail", "Display message update NOT successfully");
		}
		driver.navigate().refresh();
		String newPersonalEmail = employeeDetais.getPersonalEmail();
		if(!oldPersonalEmail.equals(newPersonalEmail)){
			setStatusTest("pass", "Update successfully");
		}else{
			setStatusTest("fail", "Update NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 23, enabled = true)
	public void TT25612() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - WORK PERMIT | VIEW + MANAGE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPersonalDisplayed() == true) {
			setStatusTest("pass", "User CAN see Personal sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Personal sub tab");
		}
		employeeDetais.clickSubTabPersonal();
		TestLogger.info("7. Expected: User CAN see Personal Contact section, btn Add, Edit, Delete");
		if(employeeDetais.isLblPersonalContactDisplayed()){
			setStatusTest("pass", "User CAN see Personal Contact section");
		}else{
			setStatusTest("fail", "User CANNOT see Personal Contact section");
		}
		if(employeeDetais.isBtnCreatePersonalContactDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Personal Contact");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Personal Contact");
		}
		employeeDetais.searchPersonalContact(DataManager.Test);
		if(employeeDetais.isFirstLinkPersonalContactDisplayed()){
			employeeDetais.clickBtnDeletePersonalContact();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete Personal Contact successfully");
			}else{
				setStatusTest("fail", "Delete Personal Contact NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new Personal Contact >> See success message");
		employeeDetais.clickBtnAddPersonalContact();
		if(employeeDetais.isTxtPersonalContactNameDisplayed()){
			setStatusTest("pass", "Form Add Personal Contact is displayed");
		}else{
			setStatusTest("fail", "Form Add Personal Contact is NOT displayed");
		}
		employeeDetais.fillPersonalContactNameAddNew(DataManager.Test);
		employeeDetais.selectContactRelationshipAddNew();
		employeeDetais.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create Personal Contact successfully");
		}else{
			setStatusTest("fail", "Create Personal Contact NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT Personal Contact");
		employeeDetais.searchPersonalContact(DataManager.Test);
		if(employeeDetais.isBtnEditPersonalContactDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Personal Contact");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Personal Contact");
		}
		employeeDetais.clickBtnEditPersonalContact();
		employeeDetais.fillPersonalContactNameEdit("ab");
		employeeDetais.clickBtnSaveUpdate();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message update successfully");
		}else{
			setStatusTest("fail", "Display message update NOT successfully");
		}
		employeeDetais.searchPersonalContact(DataManager.Test + "ab");
		if(employeeDetais.isFirstLinkPersonalContactDisplayed()){
			setStatusTest("pass", "Edit Personal Contact successfully");
		}else{
			setStatusTest("fail", "Edit Personal Contact NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of Personal Contact");
		employeeDetais.clickFirstLinkPersonalContact();
		if(employeeDetais.isTitlePersonalContactDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail Personal Contact");
		}else{
			setStatusTest("fail", "User CANNOT view detail Personal Contact");
		}
		employeeDetais.clickIconClosePersonalContactDetail();
		TestLogger.info("Expected: User CAN delete Personal Contact");
		if(employeeDetais.isBtnDeletePersonalContactDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Personal Contact");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Personal Contact");
		}
		employeeDetais.clickBtnDeletePersonalContact();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message Delete successfully");
		}else{
			setStatusTest("fail", "Display message Delete successfully");
		}
		employeeDetais.searchPersonalContact(DataManager.Test + "ab");
		if(!employeeDetais.isFirstLinkPersonalContactDisplayed()){
			setStatusTest("pass", "Delete Personal Contact successfully");
		}else{
			setStatusTest("fail", "Delete Personal Contact NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 24, enabled = true)
	public void TT25611() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL PROFILE | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnManageContact();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CAN see list contact");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isLblPersonalContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see Personal Contact list");
			} else {
				setStatusTest("fail", "User CANNOT see Personal Contact list");
			}
			TestLogger.info("Expected: CANNOT see Create, edit, delete button");
			if (employeeDetais.isBtnCreatePersonalContactClickable() == false) {
				setStatusTest("pass", "User CANNOT see Create Personal Contact button");
			} else {
				setStatusTest("fail", "User CAN see Create Personal Contact button");
			}
			if (employeeDetais.isBtnEditPersonalContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Edit Personal Contact button");
			} else {
				setStatusTest("fail", "User CAN see Edit Personal Contact button");
			}
			if (employeeDetais.isBtnDeletePersonalContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Delete Personal Contact button");
			} else {
				setStatusTest("fail", "User CAN see Delete Personal Contact button");
			}
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 25, enabled = true)
	public void TT25621() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - IDENTIFICATION DOCUMENT | VIEW + MANAGE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPersonalDisplayed() == true) {
			setStatusTest("pass", "User CAN see Personal sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Personal sub tab");
		}
		employeeDetais.clickSubTabPersonal();
		TestLogger.info("7. Expected: User CAN see Personal Identification Document section, btn Add, Edit, Delete");
		if(employeeDetais.isLblPersonalDocumentDisplayed()){
			setStatusTest("pass", "User CAN see Personal Identification Document section");
		}else{
			setStatusTest("fail", "User CANNOT see Personal Identification Document section");
		}
		if(employeeDetais.isBtnCreatePersonalDocumentDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Personal Document");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Personal Document");
		}
		employeeDetais.searchPersonalDocumentNumber(DataManager.Test);
		if(employeeDetais.isFirstLinkPersonalDocumentDisplayed()){
			employeeDetais.clickBtnDeletePersonalDocument();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete Personal Document successfully");
			}else{
				setStatusTest("fail", "Delete Personal Document NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new Personal Document >> See success message");
		employeeDetais.clickBtnAddPersonalDocument();
		if(employeeDetais.isTxtPersonalDocumentNumberCreateDisplayed()){
			setStatusTest("pass", "Form Add Personal Document is displayed");
		}else{
			setStatusTest("fail", "Form Add Personal Document is NOT displayed");
		}
		employeeDetais.selectDocumentTypeAddNew();
		employeeDetais.fillPersonalDocumentNumberAddNew(DataManager.Test);
		employeeDetais.selectDocumentCountryAddNew();
		employeeDetais.setDocumentIssueDate();
		employeeDetais.setDocumentExpiryDate();
		employeeDetais.clickBtnSaveCreateDocument();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create Personal Document successfully");
		}else{
			setStatusTest("fail", "Create Personal Document NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT Personal Document");
		employeeDetais.searchPersonalDocumentNumber(DataManager.Test);
		if(employeeDetais.isBtnEditPersonalDocumentDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Personal Document");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Personal Document");
		}
		employeeDetais.clickBtnEditPersonalDocument();
		employeeDetais.fillPersonalDocumentNumberEdit("ab");
		employeeDetais.clickBtnSaveEditDocument();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message update successfully");
		}else{
			setStatusTest("fail", "Display message update NOT successfully");
		}
		employeeDetais.searchPersonalDocumentNumber(DataManager.Test + "ab");
		if(employeeDetais.isFirstLinkPersonalDocumentDisplayed()){
			setStatusTest("pass", "Edit Personal Document successfully");
		}else{
			setStatusTest("fail", "Edit Personal Document NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of Personal Document");
		employeeDetais.clickFirstLinkPersonalDocument();
		if(employeeDetais.isTitlePersonalDocumentDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail Personal Document");
		}else{
			setStatusTest("fail", "User CANNOT view detail Personal Document");
		}
		employeeDetais.clickIconClosePersonalDocumentDetail();
		TestLogger.info("Expected: User CAN delete Personal Document");
		if(employeeDetais.isBtnDeletePersonalDocumentDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Personal Document");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Personal Document");
		}
		employeeDetais.clickBtnDeletePersonalDocument();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message Delete successfully");
		}else{
			setStatusTest("fail", "Display message Delete successfully");
		}
		employeeDetais.searchPersonalDocumentNumber(DataManager.Test + "ab");
		if(!employeeDetais.isFirstLinkPersonalDocumentDisplayed()){
			setStatusTest("pass", "Delete Personal Document successfully");
		}else{
			setStatusTest("fail", "Delete Personal Document NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 26, enabled = true)
	public void TT25620() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL IDENTIFICATION DOCUMENT | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnManageIdentificationDocuments();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CAN see list Document");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isLblPersonalDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see Personal Document list");
			} else {
				setStatusTest("fail", "User CANNOT see Personal Document list");
			}
			TestLogger.info("Expected: CANNOT see Create, edit, delete button");
			if (employeeDetais.isBtnCreatePersonalDocumentClickable() == false) {
				setStatusTest("pass", "User CANNOT see Create Personal Document button");
			} else {
				setStatusTest("fail", "User CAN see Create Personal Document button");
			}
			if (employeeDetais.isBtnEditPersonalDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Edit Personal Document button");
			} else {
				setStatusTest("fail", "User CAN see Edit Personal Document button");
			}
			if (employeeDetais.isBtnDeletePersonalDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Delete Personal Document button");
			} else {
				setStatusTest("fail", "User CAN see Delete Personal Document button");
			}
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 27, enabled = true)
	public void TT25618() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - EDUCATION | VIEW + MANAGE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPersonalDisplayed() == true) {
			setStatusTest("pass", "User CAN see Personal sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Personal sub tab");
		}
		employeeDetais.clickSubTabPersonal();
		TestLogger.info("7. Expected: User CAN see Personal Education section, btn Add, Edit, Delete");
		if(employeeDetais.isLblPersonalEducationDisplayed()){
			setStatusTest("pass", "User CAN see Personal Education section");
		}else{
			setStatusTest("fail", "User CANNOT see Personal Education section");
		}
		if(employeeDetais.isBtnCreatePersonalEducationDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Personal Education");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Personal Education");
		}
		employeeDetais.searchPersonalEducationMajor(DataManager.Test);
		if(employeeDetais.isFirstLinkPersonalEducationDisplayed()){
			employeeDetais.clickBtnDeletePersonalEducation();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete Personal Education successfully");
			}else{
				setStatusTest("fail", "Delete Personal Education NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new Personal Education >> See success message");
		employeeDetais.clickBtnAddPersonalEducation();
		if(employeeDetais.isTxtPersonalEducationUniversityCreateDisplayed()){
			setStatusTest("pass", "Form Add Personal Education is displayed");
		}else{
			setStatusTest("fail", "Form Add Personal Education is NOT displayed");
		}
		employeeDetais.selectEducationLevelAddNew();
		employeeDetais.fillPersonalEducationUniversityAddNew(DataManager.Test);
		employeeDetais.fillPersonalEducationMajorAddNew(DataManager.Test);
		employeeDetais.clickBtnSaveCreateEducation();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create Personal Education successfully");
		}else{
			setStatusTest("fail", "Create Personal Education NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT Personal Education");
		employeeDetais.searchPersonalEducationMajor(DataManager.Test);
		if(employeeDetais.isBtnEditPersonalEducationDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Personal Education");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Personal Education");
		}
		employeeDetais.clickBtnEditPersonalEducation();
		employeeDetais.fillPersonalEducationMajorEdit("ab");
		employeeDetais.clickBtnSaveEditEducation();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message update successfully");
		}else{
			setStatusTest("fail", "Display message update NOT successfully");
		}
		employeeDetais.searchPersonalEducationMajor(DataManager.Test + "ab");
		if(employeeDetais.isFirstLinkPersonalEducationDisplayed()){
			setStatusTest("pass", "Edit Personal Education successfully");
		}else{
			setStatusTest("fail", "Edit Personal Education NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of Personal Education");
		employeeDetais.clickFirstLinkPersonalEducation();
		if(employeeDetais.isTitlePersonalEducationDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail Personal Education");
		}else{
			setStatusTest("fail", "User CANNOT view detail Personal Education");
		}
		employeeDetais.clickIconClosePersonalEducationDetail();
		TestLogger.info("Expected: User CAN delete Personal Education");
		if(employeeDetais.isBtnDeletePersonalEducationDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Personal Education");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Personal Education");
		}
		employeeDetais.clickBtnDeletePersonalEducation();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message Delete successfully");
		}else{
			setStatusTest("fail", "Display message Delete successfully");
		}
		employeeDetais.searchPersonalEducationMajor(DataManager.Test + "ab");
		if(!employeeDetais.isFirstLinkPersonalEducationDisplayed()){
			setStatusTest("pass", "Delete Personal Education successfully");
		}else{
			setStatusTest("fail", "Delete Personal Education NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 28, enabled = true)
	public void TT25617() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL EDUCATION | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnManageEducation();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CAN see list Education");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isLblPersonalEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see Personal Education list");
			} else {
				setStatusTest("fail", "User CANNOT see Personal Education list");
			}
			TestLogger.info("Expected: CANNOT see Create, edit, delete button");
			if (employeeDetais.isBtnCreatePersonalEducationClickable() == false) {
				setStatusTest("pass", "User CANNOT see Create Personal Education button");
			} else {
				setStatusTest("fail", "User CAN see Create Personal Education button");
			}
			if (employeeDetais.isBtnEditPersonalEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Edit Personal Education button");
			} else {
				setStatusTest("fail", "User CAN see Edit Personal Education button");
			}
			if (employeeDetais.isBtnDeletePersonalEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Delete Personal Education button");
			} else {
				setStatusTest("fail", "User CAN see Delete Personal Education button");
			}
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 29, enabled = true)
	public void TT25615() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - ADDRESS | VIEW + MANAGE Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		if (employeeDetais.isSubTabPersonalDisplayed() == true) {
			setStatusTest("pass", "User CAN see Personal sub tab");
		} else {
			setStatusTest("fail", "User CANNOT see Personal sub tab");
		}
		employeeDetais.clickSubTabPersonal();
		TestLogger.info("7. Expected: User CAN see Personal Address section, btn Add, Edit, Delete");
		if(employeeDetais.isLblPersonalAddressDisplayed()){
			setStatusTest("pass", "User CAN see Personal Address section");
		}else{
			setStatusTest("fail", "User CANNOT see Personal Address section");
		}
		if(employeeDetais.isBtnCreatePersonalAddressDisplayed()){
			setStatusTest("pass", "User CAN see btn Add new Personal Address");
		}else{
			setStatusTest("fail", "User CANNOT see btn Add new Personal Address");
		}
		employeeDetais.searchPersonalAddressStreet(DataManager.Test);
		if(employeeDetais.isFirstLinkPersonalAddressDisplayed()){
			employeeDetais.clickBtnDeletePersonalAddress();
			employeeDetais.clickYESConfirm();
			if(DataManager.isMsgSuccessDisplayed()){
				setStatusTest("pass", "Delete Personal Address successfully");
			}else{
				setStatusTest("fail", "Delete Personal Address NOT successfully");
			}
		}
		TestLogger.info("Expected: User can add new Personal Address >> See success message");
		employeeDetais.clickBtnAddPersonalAddress();
		if(employeeDetais.isTxtPersonalAddressZipCreateDisplayed()){
			setStatusTest("pass", "Form Add Personal Address is displayed");
		}else{
			setStatusTest("fail", "Form Add Personal Address is NOT displayed");
		}
		employeeDetais.selectAddressTypeAddNew();
		employeeDetais.fillPersonalAddressZipAddNew(TienIch.taoRandomSo(4));
		employeeDetais.fillPersonalAddressStreetAddNew(DataManager.Test);
		employeeDetais.fillPersonalAddressCityAddNew(DataManager.Test);
		employeeDetais.fillPersonalAddressStateAddNew(TienIch.taoRandomSo(4));
		employeeDetais.selectAddressCountryAddNew();
		employeeDetais.clickBtnSaveCreateAddress();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Create Personal Address successfully");
		}else{
			setStatusTest("fail", "Create Personal Address NOT successfully");
		}
		TestLogger.info("Expected: User can EDIT Personal Address");
		employeeDetais.searchPersonalAddressStreet(DataManager.Test);
		if(employeeDetais.isBtnEditPersonalAddressDisplayed()){
			setStatusTest("pass", "User CAN see btn Edit Personal Address");
		}else{
			setStatusTest("fail", "User CANNOT see btn Edit Personal Address");
		}
		employeeDetais.clickBtnEditPersonalAddress();
		employeeDetais.fillPersonalAddressStreetEdit("ab");
		employeeDetais.clickBtnSaveEditAddress();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message update successfully");
		}else{
			setStatusTest("fail", "Display message update NOT successfully");
		}
		employeeDetais.searchPersonalAddressStreet(DataManager.Test + "ab");
		if(employeeDetais.isFirstLinkPersonalAddressDisplayed()){
			setStatusTest("pass", "Edit Personal Address successfully");
		}else{
			setStatusTest("fail", "Edit Personal Address NOT successfully");
		}
		TestLogger.info("Expected: User CAN view detail of Personal Address");
		employeeDetais.clickFirstLinkPersonalAddress();
		if(employeeDetais.isTitlePersonalAddressDetailDisplayed()){
			setStatusTest("pass", "User CAN view detail Personal Address");
		}else{
			setStatusTest("fail", "User CANNOT view detail Personal Address");
		}
		employeeDetais.clickIconClosePersonalAddressDetail();
		TestLogger.info("Expected: User CAN delete Personal Address");
		if(employeeDetais.isBtnDeletePersonalAddressDisplayed()){
			setStatusTest("pass", "User CAN see btn Delete Personal Address");
		}else{
			setStatusTest("fail", "User CANNOT see btn Delete Personal Address");
		}
		employeeDetais.clickBtnDeletePersonalAddress();
		employeeDetais.clickYESConfirm();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Display message Delete successfully");
		}else{
			setStatusTest("fail", "Display message Delete successfully");
		}
		employeeDetais.searchPersonalAddressStreet(DataManager.Test + "ab");
		if(!employeeDetais.isFirstLinkPersonalAddressDisplayed()){
			setStatusTest("pass", "Delete Personal Address successfully");
		}else{
			setStatusTest("fail", "Delete Personal Address NOT successfully");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 30, enabled = true)
	public void TT25614() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL ADDRESS | VIEW ONLY Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnManageAddress();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CAN see list Address");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isLblPersonalAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see Personal Address list");
			} else {
				setStatusTest("fail", "User CANNOT see Personal Address list");
			}
			TestLogger.info("Expected: CANNOT see Create, edit, delete button");
			if (employeeDetais.isBtnCreatePersonalAddressClickable() == false) {
				setStatusTest("pass", "User CANNOT see Create Personal Address button");
			} else {
				setStatusTest("fail", "User CAN see Create Personal Address button");
			}
			if (employeeDetais.isBtnEditPersonalAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Edit Personal Address button");
			} else {
				setStatusTest("fail", "User CAN see Edit Personal Address button");
			}
			if (employeeDetais.isBtnDeletePersonalAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Delete Personal Address button");
			} else {
				setStatusTest("fail", "User CAN see Delete Personal Address button");
			}
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 31, enabled = true)
	public void TT25613_TT25610_TT25616_TT25619() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL DOCUMENT + EDUCATION + CONTACT + ADDRESS | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickONBtnRadioEmployeeList();
		cloneForm.clickONbtnRadioData();
		cloneForm.clickOFFBtnViewContact();
		cloneForm.clickOFFBtnViewAddress();
		cloneForm.clickOFFBtnViewEducation();
		cloneForm.clickOFFBtnViewIdentificationDocuments();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("6. Open view employee detail");
		talentEmployee.clickIconDots();
		talentEmployee.clickItemView();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		TestLogger.info("Expected: CANNOT see list Education, Identification Document, Contact ,Address");
		if(employeeDetais.isSubTabPersonalDisplayed()){
			employeeDetais.clickSubTabPersonal();
			if (employeeDetais.isLblPersonalAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Personal Address list");
			} else {
				setStatusTest("fail", "User CAN see Personal Address list");
			}
			if (employeeDetais.isLblPersonalContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Personal Contact list");
			} else {
				setStatusTest("fail", "User CAN see Personal Contact list");
			}
			if (employeeDetais.isLblPersonalDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Personal Document list");
			} else {
				setStatusTest("fail", "User CAN see Personal Document list");
			}
			if (employeeDetais.isLblPersonalEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see Personal Education list");
			} else {
				setStatusTest("fail", "User CAN see Personal Education list");
			}
			
		}else{
			System.out.println("CANNOT see sub tab Personal");
		}
		driver.close();
		driver.switchTo().window(parent);
	}
	
	@Test(priority = 32, enabled = true)
	public void TT25604() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL DOCUMENT + EDUCATION + CONTACT + ADDRESS | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
		cloneForm.clickCboxFullPermission();
		cloneForm.clickCboxCustomization();
		cloneForm.clickCboxSubCustomization();
		cloneForm.clickOFFBtnRadioEmployeeList();
		cloneForm.clickSubTabPerformanceGrowth();
		cloneForm.clickONBtnRadioGoalChecking();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("Expected: CANNOT see Employee tab");
		if(!talent.isTabEmployeeDisplayed()){
			setStatusTest("pass", "CANNOT see Employee tab");
		}else{
			setStatusTest("fail", "CAN see Employee tab");
		}
	}
	
	@Test(priority = 33, enabled = true)
	public void TT25603_TT25602() throws InterruptedException {
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
		TestLogger.info("3. Update Function Set| Talent Management - DATA - PERSONAL DOCUMENT + EDUCATION + CONTACT + ADDRESS | NO VIEW Permission");
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		if (cloneForm.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		cloneForm.clickTabTalentManagement();
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
		
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailUser, PropertyManager.PASSWORD);
		if (controlBoard.isAvatarDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		TestLogger.info("5. Access to Talent Management");
		controlBoard.clickTabTalentManagement();
		TestLogger.info("Expected: CAN see Employee tab");
		if(talent.isTabEmployeeDisplayed()){
			setStatusTest("pass", "CAN see Employee tab");
		}else{
			setStatusTest("fail", "CANNOT see Employee tab");
		}
		TestLogger.info("Expected: CAN see Employee data table, btnCardView, tableView");
		if(talentEmployee.isLinkEmployeeCardDisplayed()){
			setStatusTest("pass", "CAN see data table");
		}else{
			setStatusTest("fail", "CANNOT see data table");
		}
		if(talentEmployee.isBtnCardViewDisplayed()){
			setStatusTest("pass", "CAN see btn card view");
		}else{
			setStatusTest("fail", "CANNOT see btn card view");
		}
		if(talentEmployee.isBtnTableViewDisplayed()){
			setStatusTest("pass", "CAN see btn table view");
		}else{
			setStatusTest("fail", "CANNOT see btn table view");
		}
		if(!talentEmployee.isBtnAddEmployeeDisplayed()){
			setStatusTest("pass", "CANNOT see btn Add employee");
		}else{
			setStatusTest("fail", "CAN see btn Add employee");
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
