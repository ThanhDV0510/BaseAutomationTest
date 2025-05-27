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
import wize.pages.EmployeeData;
import wize.pages.EmployeeData_Data;
import wize.pages.EmployeeData_Personal;
import wize.pages.Form_Data_AddAddress;
import wize.pages.Form_Data_AddContact;
import wize.pages.Form_Data_AddEducation;
import wize.pages.Form_Data_AddIDDocument;
import wize.pages.Form_Data_AddressDetails;
import wize.pages.Form_Data_EditAddress;
import wize.pages.Form_Data_EditContact;
import wize.pages.Form_Data_EditEducation;
import wize.pages.Form_Data_EditIDDocument;
import wize.pages.Form_Data_EducationDetails;
import wize.pages.Form_Data_FilterEmployee;
import wize.pages.Form_Data_IDDocumentDetails;
import wize.pages.Form_Data_ViewContact;
import wize.pages.Form_EditSecurityProfile;
import wize.pages.LoginScreen;
import wize.pages.SecurityProfile;
import wize.pages.TalentManagement;
import wize.pages.TalentManagement_Employee;

public class Test_Function_TalentManagement_Data_Personal extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	
	SecurityProfile securityProfile;
	Form_EditSecurityProfile editSecurityProfile;

	TalentManagement_Employee talentEmployee;
	TalentManagement talent;
	EmployeeData employeeData;
	EmployeeData_Personal personal;
	EmployeeData_Data tabData;
	
	Form_Data_AddContact addContact;
	Form_Data_EditContact editContact;
	Form_Data_ViewContact viewContact;
	
	Form_Data_AddAddress addAddress;
	Form_Data_AddressDetails addressDetails;
	Form_Data_EditAddress editAddress;
	
	Form_Data_AddEducation addEducation;
	Form_Data_EditEducation editEducation;
	Form_Data_EducationDetails educationDetails;
	
	Form_Data_AddIDDocument addIDDocument;
	Form_Data_EditIDDocument editIDDocument;
	Form_Data_IDDocumentDetails iDDocumentDetails;
	
	Form_Data_FilterEmployee filterEmployee;
	
	String security = "Test SP";
	String DP = "123-ABC";
		
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
	
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		
		talentEmployee = new TalentManagement_Employee(driver);
		talent = new TalentManagement(driver);
		
		securityProfile = new SecurityProfile(driver);
		editSecurityProfile = new Form_EditSecurityProfile(driver);
		
		talentEmployee = new TalentManagement_Employee(driver);
		talent = new TalentManagement(driver);
		employeeData = new EmployeeData(driver);
		personal = new EmployeeData_Personal(driver);
		tabData = new EmployeeData_Data(driver);
		
		addContact = new Form_Data_AddContact(driver);
		editContact = new Form_Data_EditContact(driver);
		viewContact = new Form_Data_ViewContact(driver);
	
		addAddress = new Form_Data_AddAddress(driver);
		addressDetails = new Form_Data_AddressDetails(driver);
		editAddress = new Form_Data_EditAddress(driver);
				
		addEducation = new Form_Data_AddEducation(driver);
		editEducation = new Form_Data_EditEducation(driver);
		educationDetails = new Form_Data_EducationDetails(driver);
		
		addIDDocument = new Form_Data_AddIDDocument(driver);
		editIDDocument = new Form_Data_EditIDDocument(driver);
		iDDocumentDetails = new Form_Data_IDDocumentDetails(driver);
		
		filterEmployee = new Form_Data_FilterEmployee(driver);
	
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_23585_TT_23583_TT_23580_TT_23582() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Security Profile");

		controlBoard.clickLblSecurityProfile();
		
		if (securityProfile.isLblSecurityProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Security Profile");
		} else {
			setStatusTest("fail", "Not Access to Security Profile");
		}
		
		TestLogger.info("3. Update Data Privacy ");
		
		securityProfile.fillSearch(security);
		securityProfile.clickIconEdit();
		
		if (editSecurityProfile.isLblEditSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Edit Security Profile popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Security Profile popup");
		}
		
		editSecurityProfile.clickTabDataPrivacy();
		editSecurityProfile.selectAdditonal(DP);
		editSecurityProfile.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass","Displays msg: " + "Security Profile updated sucessfully");
		} else {
			setStatusTest("fail","NOT Displays msg: " + "Security Profile updated sucessfully");
		}
		
		TestLogger.info("4. Access to Talent Management >> Employee Data >> Personal");

		controlBoard.clickTabTalentManagement();
		
		if (talent.isTabEmployeeDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		
		talent.clickTabEmployee();
		talentEmployee.clickBtnFilter();
		
		if (filterEmployee.isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Access to Filter popup");
		} else {
			setStatusTest("fail", "Not Access to Filter popup");
		}
		
		filterEmployee.fillTxtKeyword(DataManager.FilterEmployee);
		filterEmployee.clickBtnApply();
		
		if (talentEmployee.isLinkEmployeeCardDisplayed() == true) {
			setStatusTest("pass", "Filter Successful");
		} else {
			setStatusTest("fail", "Filter Fail");
		}
		
		talentEmployee.clickLinkEmployeeCard();
		
		if (employeeData.isLblEmployeeSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to Employee Details");
		} else {
			setStatusTest("fail", "NOT Access to Employee Details");
		}
		
		employeeData.clickTabData();
		tabData.clickTabPersonal();
		
		if (personal.isLblProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Personal Tab");
		} else {
			setStatusTest("fail", "NOT Access to Personal Tab");
		}
		
		TestLogger.info("5. Click on Add button >> Click on Close button");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.clickBtnClose();
		
		TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close window.");
		
		if (personal.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Discard all changes, close window.");
		} else {
			setStatusTest("fail", "NOT Discard all changes, close window.");
		}
		
		TestLogger.info("6. Click on Add button >> Click on Cancel button");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close window.");
		
		if (personal.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Discard all changes, close window.");
		} else {
			setStatusTest("fail", "NOT Discard all changes, close window.");
		}
		
		TestLogger.info("7. Click on Add button >> Click on Save button");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.selectType();
		addIDDocument.fillTxtNumber(DataManager.moreThan250);
		addIDDocument.selectCountry();
		addIDDocument.selectIssueDate();
		addIDDocument.selectExpiryDate();
		addIDDocument.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Identification Document created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Identification Document created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Identification Document created successfully");
		}
		
		personal.clickBtnDeleteIDDocument();
		
		if(personal.isLblConfirmationDisplayed() == true)
		{
			personal.clickBtnYesID();
		}
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Deletes success");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Deletes success");
		}
		
		TestLogger.info("8. Click on Add button >> Click on Save&Create New button");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.selectType();
		addIDDocument.fillTxtNumber(DataManager.moreThan250);
		addIDDocument.selectCountry();
		addIDDocument.selectIssueDate();
		addIDDocument.selectExpiryDate();
		addIDDocument.clickBtnSavenCreateNew();
		
		TestLogger.info("Expect : User CAN see/do: " + "Identification Document created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Identification Document created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Identification Document created successfully");
		}
		
		addIDDocument.clickBtnClose();
		
		personal.clickBtnDeleteIDDocument();
		
		if(personal.isLblConfirmationDisplayed() == true)
		{
			personal.clickBtnYesID();
		}
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Deletes success");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Deletes success");
		}
	}
	
	@Test(priority = 2)

	public void TT_23602_TT_23604_TT_23600() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Talent Management >> Employee Data >> Personal");

		controlBoard.clickTabTalentManagement();
		
		if (talent.isTabEmployeeDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		
		talent.clickTabEmployee();
		talentEmployee.clickBtnFilter();
		
		if (filterEmployee.isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Access to Filter popup");
		} else {
			setStatusTest("fail", "Not Access to Filter popup");
		}
		
		filterEmployee.fillTxtKeyword(DataManager.FilterEmployee);
		filterEmployee.clickBtnApply();
		
		if (talentEmployee.isLinkEmployeeCardDisplayed() == true) {
			setStatusTest("pass", "Filter Successful");
		} else {
			setStatusTest("fail", "Filter Fail");
		}
		
		talentEmployee.clickLinkEmployeeCard();
		
		if (employeeData.isLblEmployeeSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to Employee Details");
		} else {
			setStatusTest("fail", "NOT Access to Employee Details");
		}
		
		employeeData.clickTabData();
		tabData.clickTabPersonal();
		
		if (personal.isLblProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Personal Tab");
		} else {
			setStatusTest("fail", "NOT Access to Personal Tab");
		}
		
		TestLogger.info("3. Add ID Document");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.selectType();
		addIDDocument.fillTxtNumber(DataManager.moreThan250);
		addIDDocument.selectCountry();
		addIDDocument.selectIssueDate();
		addIDDocument.selectExpiryDate();
		addIDDocument.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Identification Document created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Identification Document created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Identification Document created successfully");
		}
		
		TestLogger.info("4. Click on Edit button >> Click on Close button");
		
		personal.clickBtnEditIDDocument();
		
		if (editIDDocument.isLblEditIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Edit ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Edit ID Document popup");
		}
		
		editIDDocument.clickBtnClose();
		
		TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close window.");
		
		if (personal.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Discard all changes, close window.");
		} else {
			setStatusTest("fail", "NOT Discard all changes, close window.");
		}
		
		TestLogger.info("5. Click on Edit button >> Click on Cancel button");
		
		personal.clickBtnEditIDDocument();
		
		if (editIDDocument.isLblEditIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Edit ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Edit ID Document popup");
		}
		
		editIDDocument.clickBtnCancel();
		
		TestLogger.info("Expect : User CAN see/do: " + "Discard all changes, close window.");
		
		if (personal.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Discard all changes, close window.");
		} else {
			setStatusTest("fail", "NOT Discard all changes, close window.");
		}
		
		TestLogger.info("6. Click on Edit button >> Click on Save button");
		
		personal.clickBtnEditIDDocument();
		
		if (editIDDocument.isLblEditIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Edit ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Edit ID Document popup");
		}
		
		editIDDocument.fillTxtNumber(DataManager.FunctionSet);
		editIDDocument.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Identification Document updated successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Identification Document updated successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Identification Document updated successfully");
		}
		
		personal.clickBtnDeleteIDDocument();
		
		if(personal.isLblConfirmationDisplayed() == true)
		{
			personal.clickBtnYesID();
		}
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Deletes success");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Deletes success");
		}
	}

	@Test(priority = 3)
	
	public void TT_23605_TT_23629_TT_23606() throws InterruptedException {
		TestLogger.info("1. Login with account Admin");
	
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Access to Talent Management >> Employee Data >> Personal");
	
		controlBoard.clickTabTalentManagement();
		
		if (talent.isTabEmployeeDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		
		talent.clickTabEmployee();
		talentEmployee.clickBtnFilter();
		
		if (filterEmployee.isLblFilterDisplayed() == true) {
			setStatusTest("pass", "Access to Filter popup");
		} else {
			setStatusTest("fail", "Not Access to Filter popup");
		}
		
		filterEmployee.fillTxtKeyword(DataManager.FilterEmployee);
		filterEmployee.clickBtnApply();
		
		if (talentEmployee.isLinkEmployeeCardDisplayed() == true) {
			setStatusTest("pass", "Filter Successful");
		} else {
			setStatusTest("fail", "Filter Fail");
		}
		
		talentEmployee.clickLinkEmployeeCard();
		
		if (employeeData.isLblEmployeeSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to Employee Details");
		} else {
			setStatusTest("fail", "NOT Access to Employee Details");
		}
		
		employeeData.clickTabData();
		tabData.clickTabPersonal();
		
		if (personal.isLblProfileDisplayed() == true) {
			setStatusTest("pass", "Access to Personal Tab");
		} else {
			setStatusTest("fail", "NOT Access to Personal Tab");
		}
		
		TestLogger.info("3. Add ID Document");
		
		personal.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access to Add ID Document popup");
		} else {
			setStatusTest("fail", "NOT Access to Add ID Document popup");
		}
		
		addIDDocument.selectType();
		addIDDocument.fillTxtNumber(DataManager.moreThan250);
		addIDDocument.selectCountry();
		addIDDocument.selectIssueDate();
		addIDDocument.selectExpiryDate();
		addIDDocument.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Identification Document created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Identification Document created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Identification Document created successfully");
		}
		
		TestLogger.info("4. Click on Delete button >> Click on NO button");
		
		personal.clickBtnDeleteIDDocument();
		
		if (personal.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Access to Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Access to Confirmation popup");
		}
		
		personal.clickBtnNoID();
		
		TestLogger.info("Expect : User CAN see/do: " + "Close the dialogue");
		
		if (personal.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Close the dialogue");
		} else {
			setStatusTest("fail", "NOT Close the dialogue");
		}
		
		TestLogger.info("5. Click on Delete button");
		
		personal.clickBtnDeleteIDDocument();
		
		TestLogger.info("Expect : User CAN see/do: " + "Access to Confirmation popup");
		
		if (personal.isLblConfirmationDisplayed() == true) {
			setStatusTest("pass", "Access to Confirmation popup");
		} else {
			setStatusTest("fail", "NOT Access to Confirmation popup");
		}
		
		personal.clickBtnNoID();
		
		TestLogger.info("6. Click on Delete button >> Click on Yes button");
				
		personal.clickBtnDeleteIDDocument();
		
		if(personal.isLblConfirmationDisplayed() == true)
		{
			personal.clickBtnYesID();
		}
		
		TestLogger.info("Expect : User CAN see/do: " + "Deletes success");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Deletes success");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Deletes success");
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
