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
import wize.pages.Form_Data_AddAddress;
import wize.pages.Form_Data_AddContact;
import wize.pages.Form_Data_AddEducation;
import wize.pages.Form_Data_AddressDetails;
import wize.pages.Form_Data_EditAddress;
import wize.pages.Form_Data_EditContact;
import wize.pages.Form_Data_EditEducation;
import wize.pages.Form_Data_EditProfile;
import wize.pages.Form_Data_EducationDetails;
import wize.pages.Form_Data_FilterEmployee;
import wize.pages.Form_Data_IDDocumentDetails;
import wize.pages.Form_Data_ViewContact;
import wize.pages.Form_EditUser;
import wize.pages.Form_MyData_AddIDDocument;
import wize.pages.Form_MyData_EditIDDocument;
import wize.pages.FunctionSet;
import wize.pages.LoginScreen;
import wize.pages.MyData;
import wize.pages.MyData_PersonalData;
import wize.pages.MySpace;
import wize.pages.UserManagement;

public class Test_FunctionSet_MyData_PersonalData extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	FunctionSet functionSet;
	Clone_Form_EditFunctionSet editFunctionSet;
	UserManagement userManagement;
	Form_EditUser editUser;

	MySpace mySpace;
	MyData myData;
	MyData_PersonalData personalData;
	
	Form_Data_EditProfile editProfile;
	
	Form_Data_AddContact addContact;
	Form_Data_EditContact editContact;
	Form_Data_ViewContact viewContact;
	
	Form_Data_AddAddress addAddress;
	Form_Data_AddressDetails addressDetails;
	Form_Data_EditAddress editAddress;
	
	Form_Data_AddEducation addEducation;
	Form_Data_EditEducation editEducation;
	Form_Data_EducationDetails educationDetails;
	
	Form_MyData_AddIDDocument addIDDocument;
	Form_MyData_EditIDDocument editIDDocument;
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
		
		functionSet = new FunctionSet(driver);
		editFunctionSet = new Clone_Form_EditFunctionSet(driver);
		userManagement = new UserManagement(driver);
		editUser = new Form_EditUser(driver);
		
		mySpace = new MySpace(driver);
		personalData = new MyData_PersonalData(driver);
		myData = new MyData(driver);
		
		editProfile = new Form_Data_EditProfile(driver);
		
		addContact = new Form_Data_AddContact(driver);
		editContact = new Form_Data_EditContact(driver);
		viewContact = new Form_Data_ViewContact(driver);
	
		addAddress = new Form_Data_AddAddress(driver);
		addressDetails = new Form_Data_AddressDetails(driver);
		editAddress = new Form_Data_EditAddress(driver);
				
		addEducation = new Form_Data_AddEducation(driver);
		editEducation = new Form_Data_EditEducation(driver);
		educationDetails = new Form_Data_EducationDetails(driver);
		
		addIDDocument = new Form_MyData_AddIDDocument(driver);
		editIDDocument = new Form_MyData_EditIDDocument(driver);
		iDDocumentDetails = new Form_Data_IDDocumentDetails(driver);
		
		filterEmployee = new Form_Data_FilterEmployee(driver);
	
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1)

	public void TT_25490() throws InterruptedException {
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
				
		TestLogger.info("3. Update Function Set| My Data - Personal Data | Full Permission");
		
		functionSet.fillSearchName(DataManager.FunctionSet);
		functionSet.clickIconEdit();
		
		if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
			setStatusTest("pass", "Open Edit Function Set popup");
		} else {
			setStatusTest("fail", "NOT Open Edit Function Set popup");
		}
		
		editFunctionSet.clickTabMySpace();
		editFunctionSet.clickSubTabMyData();
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
		
		if (mySpace.isLblNameSpaceDisplayed() == true) {
			setStatusTest("pass", "Access to My Space tab");
		} else {
			setStatusTest("fail", "Not Access to My Space tab");
		}
				
		TestLogger.info("6. Access My Data sub-tab");
		
		mySpace.clickTabMyData();
		
		if (myData.isSubTabPersonalDataDisplayed() == true) {
			setStatusTest("pass", "Access My Data sub-tab");
		} else {
			setStatusTest("fail", "Not Access My Data sub-tab");
		}

		TestLogger.info("7. Access to Personal Data Path");
			
		myData.clickSubTabPersonalData();
		
		if (personalData.isLblProfileDisplayed() == true) {
			setStatusTest("pass", "Access Personal Data Path");
		} else {
			setStatusTest("fail", "Not Access Personal Data Path");
		}
		
		TestLogger.info("8. Update Profile");
		
		personalData.clickBtnEditProfile();
		
		if (editProfile.isLblEditProfileDisplayed() == true) {
			setStatusTest("pass", "Access Edit Profile popup");
		} else {
			setStatusTest("fail", "Not Access Edit Profile popup");
		}
			
		editProfile.fillTxtMobilePhone(DataManager.MobilePhone);
		editProfile.clickBtnSave();
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update Profile Success");
		} else {
			setStatusTest("fail", "Update Profile Fail");
		}
					
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Profile block\r\n" 
				+ "2. Edit Profile button");
		
		if (personalData.isLblProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Profile block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Profile block");
		}
		
		if (personalData.isBtnEditProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit Profile button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit Profile button");
		}
				
		TestLogger.info("9. Create Address");
		
		personalData.clickBtnAddAddress();
		
		if (addAddress.isLblAddAddressDisplayed() == true) {
			setStatusTest("pass", "Access Add Address");
		} else {
			setStatusTest("fail", "Not Access Add Address");
		}
		
		addAddress.fillTxtStreet(DataManager.FunctionSet);
		addAddress.fillTxtCity(DataManager.FunctionSet);
		addAddress.fillTxtState(DataManager.MobilePhone);
		addAddress.selectDrplistCountry();
		addAddress.clickBtnSaveMy();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add Address Success");
		} else {
			setStatusTest("fail", "Add Address Fail");
		}
				 
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Address block\r\n" 
				+ "2. Create Address button\r\n"
				+ "3. Edit Address button\r\n"
				+ "4. Delete Address button");
		
		if (personalData.isLblAddressDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Address block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Address block");
		}
		
		if (personalData.isBtnAddAddressDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create Address button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create Address button");
		}
		
		if (personalData.isBtnEditAddressDisplayed()== true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit Address button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit Address button");
		}
		
		if (personalData.isBnDeleteAddressDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete Address button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete Address button");
		}
		
		TestLogger.info("10. Update Address");
		
		personalData.clickBtnEditAddress();
		editAddress.fillTxtStreet(DataManager.FunctionSet);
		editAddress.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update Address Success");
		} else {
			setStatusTest("fail", "Update Address Fail");
		}
		
		TestLogger.info("11. Delete Address");
		
		personalData.clickBtnDeleteAddress();
			
		if(personalData.isLblConfirmationDisplayed() == true)
		{
			personalData.clickBtnYesAddress();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete Address Success");
			} else {
				setStatusTest("fail", "Delete Address Fail");
			}
		}	
		
		TestLogger.info("12. Create Education");
		
		personalData.clickBtnAddEducation();
		
		if (addEducation.isLblAddEducationDisplayed() == true) {
			setStatusTest("pass", "Access Add Education");
		} else {
			setStatusTest("fail", "Not Access Add Education");
		}
		
		addEducation.selectLevel();
		addEducation.fillTxtInstitute(DataManager.FunctionSet);
		addEducation.fillTxtMajor(DataManager.FunctionSet);
		addEducation.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add Education Success");
		} else {
			setStatusTest("fail", "Add Education Fail");
		}
				 
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Education block\r\n" 
				+ "2. Create Education button\r\n"
				+ "3. Edit Education button\r\n"
				+ "4. Delete Education button");
		
		if (personalData.isLblEducationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Education block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Education block");
		}
		
		if (personalData.isBtnAddEducationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create Education button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create Education button");
		}
		
		if (personalData.isBtnEditEducationDisplayed()== true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit Education button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit Education button");
		}
		
		if (personalData.isBnDeleteEducationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete Education button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete Education button");
		}
		
		TestLogger.info("13. Update Education");
		
		personalData.clickBtnEditEducation();
		editEducation.fillTxtInstitute(DataManager.Functional);
		editEducation.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update Education Success");
		} else {
			setStatusTest("fail", "Update Education Fail");
		}
		
		TestLogger.info("14. Delete Education");
		
		personalData.clickBtnDeleteEducation();
			
		if(personalData.isLblConfirmationDisplayed() == true)
		{
			personalData.clickBtnYesEducation();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete Education Success");
			} else {
				setStatusTest("fail", "Delete Education Fail");
			}
		}
		
		TestLogger.info("15. Create Identification Document");
		
		personalData.clickBtnAddIDDocument();
		
		if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "Access Add Other Contact");
		} else {
			setStatusTest("fail", "Not Access Add Other Contact");
		}
		
		addIDDocument.selectType();
		addIDDocument.fillTxtNumber(DataManager.FunctionSet);
		addIDDocument.selectCountry();
		addIDDocument.selectIssueDate();
		addIDDocument.selectExpiryDate();
		addIDDocument.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add Other Contact Success");
		} else {
			setStatusTest("fail", "Add Other Contact Fail");
		}
				 
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. IDDocument block\r\n" 
				+ "2. Create IDDocument button\r\n"
				+ "3. Edit IDDocument button\r\n"
				+ "4. Delete IDDocument button");
		
		if (personalData.isLblIDDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "IDDocument block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "IDDocument block");
		}
		
		if (personalData.isBtnAddIDDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create IDDocument button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create IDDocument button");
		}
		
		if (personalData.isBtnEditIDDocumentDisplayed()== true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit IDDocument button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit IDDocument button");
		}
		
		if (personalData.isBnDeleteIDDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete IDDocument button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete IDDocument button");
		}
		
		TestLogger.info("16. Update IDDocument");
		
		personalData.clickBtnEditIDDocument();
		editIDDocument.fillTxtNumber(DataManager.FunctionSet);
		editIDDocument.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update IDDocument Success");
		} else {
			setStatusTest("fail", "Update IDDocument Fail");
		}
		
		TestLogger.info("17. Delete IDDocument");
		
		personalData.clickBtnDeleteIDDocument();
			
		if(personalData.isLblConfirmationDisplayed() == true)
		{
			personalData.clickBtnYesID();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete IDDocument Success");
			} else {
				setStatusTest("fail", "Delete IDDocument Fail");
			}
		}
		
		TestLogger.info("18. Create Other Contact");
		
		personalData.clickBtnAddContact();
		
		if (addContact.isLblAddContactDisplayed() == true) {
			setStatusTest("pass", "Access Add Other Contact");
		} else {
			setStatusTest("fail", "Not Access Add Other Contact");
		}
		
		addContact.fillTxtName(DataManager.FunctionSet);
		addContact.selectRelationship();
		addContact.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Add Other Contact Success");
		} else {
			setStatusTest("fail", "Add Other Contact Fail");
		}
				 
		TestLogger.info("Expect : User CAN see/do: \r\n" 
				+ "1. Contact block\r\n" 
				+ "2. Create Contact button\r\n"
				+ "3. Edit Contact button\r\n"
				+ "4. Delete Contact button");
		
		if (personalData.isLblContactDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Contact block");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Contact block");
		}
		
		if (personalData.isBtnAddContactDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Create Contact button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Create Contact button");
		}
		
		if (personalData.isBtnEditContactDisplayed()== true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit Contact button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Edit Contact button");
		}
		
		if (personalData.isBnDeleteContactDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete Contact button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete Contact button");
		}
		
		TestLogger.info("19. Update Contact");
		
		personalData.clickBtnEditContact();
		editContact.fillTxtName(DataManager.FunctionSet);
		editContact.clickBtnSave();
		
		if(DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Update Contact Success");
		} else {
			setStatusTest("fail", "Update Contact Fail");
		}
		
		TestLogger.info("20. Delete Contact");
		
		personalData.clickBtnDeleteContact();
			
		if(personalData.isLblConfirmationDisplayed() == true)
		{
			personalData.clickBtnYesContact();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Delete Contact Success");
			} else {
				setStatusTest("fail", "Delete Contact Fail");
			}
		}
}
	
	@Test(priority = 2)
	
		public void TT_25491() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Only Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
			
			TestLogger.info("8. Check Profile");
						
			TestLogger.info("Expect : User CAN see/do: " + "Edit Profile button");
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Profile block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Profile block");
			}
				
			TestLogger.info("Expect : User CANNOT see/do: " + "Edit Profile button");
			
			if (personalData.isBtnEditProfileDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Profile button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Profile button");
			}
		
			TestLogger.info("9. Check Address");
								 
			TestLogger.info("Expect : User CAN see/do: " + "Address block");
			
			if (personalData.isLblAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Address block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Address block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Address button\r\n"
					+ "2. Edit Address button\r\n"
					+ "3. Delete Address button");
			
			if (personalData.isBtnAddAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Address button");
			}
			
			if (personalData.isBtnEditAddressDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Address button");
			}
			
			if (personalData.isBnDeleteAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Address button");
			}
				
			TestLogger.info("10. Check Education");
							 
			TestLogger.info("Expect : User CAN see/do: " + "Education block");
			
			if (personalData.isLblEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Education block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Education block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Education button\r\n"
					+ "2. Edit Education button\r\n"
					+ "3. Delete Education button");
			
			if (personalData.isBtnAddEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Education button");
			}
			
			if (personalData.isBtnEditEducationDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Education button");
			}
			
			if (personalData.isBnDeleteEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Education button");
			}
			
			TestLogger.info("11. Check Identification Document");
			
			TestLogger.info("Expect : User CAN see/do: "  + "IDDocument block");
			
			if (personalData.isLblIDDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "IDDocument block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "IDDocument block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create IDDocument button\r\n"
					+ "2. Edit IDDocument button\r\n"
					+ "3. Delete IDDocument button");
			
			if (personalData.isBtnAddIDDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create IDDocument button");
			}
			
			if (personalData.isBtnEditIDDocumentDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit IDDocument button");
			}
			
			if (personalData.isBnDeleteIDDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete IDDocument button");
			}
						
			TestLogger.info("12. Check Other Contact");
								 
			TestLogger.info("Expect : User CAN see/do: " + "Contact block");
			
			if (personalData.isLblContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Contact block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Contact block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Contact button\r\n"
					+ "2. Edit Contact button\r\n"
					+ "3. Delete Contact button");
			
			if (personalData.isBtnAddContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Contact button");
			}
			
			if (personalData.isBtnEditContactDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Contact button");
			}
			
			if (personalData.isBnDeleteContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Contact button");
			}
	}

	@Test(priority = 3)
	
		public void TT_25492() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: " + "Personal Data");
			
			if (myData.isSubTabPersonalDataDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Personal Data");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Personal Data");
			}
					
	}

	@Test(priority = 4)
	
		public void TT_25494() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Profile Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyProfile();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
								
			TestLogger.info("Expect : User CAN see/do: " + "Profile block");
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Profile block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Profile block");
			}
			
			TestLogger.info("Expect : User CAN see/do: " + "Edit Profile button");
			
			if (personalData.isBtnEditProfileDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Profile button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Profile button");
			}
	}

	@Test(priority = 5)
	
		public void TT_25495() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Profile + Edit Profile Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONBtnViewProfile();
			editFunctionSet.clickONbtnEditMyProfile();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
			
			TestLogger.info("8. Update Profile");
			
			personalData.clickBtnEditProfile();
			
			if (editProfile.isLblEditProfileDisplayed() == true) {
				setStatusTest("pass", "Access Edit Profile popup");
			} else {
				setStatusTest("fail", "Not Access Edit Profile popup");
			}
				
			editProfile.fillTxtMobilePhone(DataManager.MobilePhone);
			editProfile.clickBtnSave();
			
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Profile Success");
			} else {
				setStatusTest("fail", "Update Profile Fail");
			}
						
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Profile block\r\n" 
					+ "2. Edit Profile button");
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Profile block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Profile block");
			}
			
			if (personalData.isBtnEditProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit Profile button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit Profile button");
			}
	}

	@Test(priority = 6)
	
		public void TT_25497() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Address");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyAddress();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
									 
			TestLogger.info("Expect : User CAN see/do: " + "Address block");
			
			if (personalData.isLblAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Address block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Address block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Address button\r\n"
					+ "2. Edit Address button\r\n"
					+ "3. Delete Address button");
			
			if (personalData.isBtnAddAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Address button");
			}
			
			if (personalData.isBtnEditAddressDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Address button");
			}
			
			if (personalData.isBnDeleteAddressDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Address button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Address button");
			}
	}

	@Test(priority = 7)
	
		public void TT_25498() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Address + Manage Address Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyAddress();
			editFunctionSet.clickONbtnManageMyAddress();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
					
			TestLogger.info("8. Create Address");
			
			personalData.clickBtnAddAddress();
			
			if (addAddress.isLblAddAddressDisplayed() == true) {
				setStatusTest("pass", "Access Add Address");
			} else {
				setStatusTest("fail", "Not Access Add Address");
			}
			
			addAddress.fillTxtStreet(DataManager.FunctionSet);
			addAddress.fillTxtCity(DataManager.FunctionSet);
			addAddress.fillTxtState(DataManager.MobilePhone);
			addAddress.selectDrplistCountry();
			addAddress.clickBtnSaveMy();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add Address Success");
			} else {
				setStatusTest("fail", "Add Address Fail");
			}
					 
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Address block\r\n" 
					+ "2. Create Address button\r\n"
					+ "3. Edit Address button\r\n"
					+ "4. Delete Address button");
			
			if (personalData.isLblAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Address block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Address block");
			}
			
			if (personalData.isBtnAddAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create Address button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create Address button");
			}
			
			if (personalData.isBtnEditAddressDisplayed()== true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit Address button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit Address button");
			}
			
			if (personalData.isBnDeleteAddressDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete Address button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete Address button");
			}
			
			TestLogger.info("9. Update Address");
			
			personalData.clickBtnEditAddress();
			editAddress.fillTxtStreet(DataManager.FunctionSet);
			editAddress.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Address Success");
			} else {
				setStatusTest("fail", "Update Address Fail");
			}
			
			TestLogger.info("10. Delete Address");
			
			personalData.clickBtnDeleteAddress();
				
			if(personalData.isLblConfirmationDisplayed() == true)
			{
				personalData.clickBtnYesAddress();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Delete Address Success");
				} else {
					setStatusTest("fail", "Delete Address Fail");
				}
			}	
}
		
	@Test(priority = 8)
	
		public void TT_25500() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Education Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyEducation();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
							 
			TestLogger.info("Expect : User CAN see/do: " + "Education block");
			
			if (personalData.isLblEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Education block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Education block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Education button\r\n"
					+ "2. Edit Education button\r\n"
					+ "3. Delete Education button");
			
			if (personalData.isBtnAddEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Education button");
			}
			
			if (personalData.isBtnEditEducationDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Education button");
			}
			
			if (personalData.isBnDeleteEducationDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Education button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Education button");
			}
	}

	@Test(priority = 9)
	
		public void TT_25501() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Education + Manage Education Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyEducation();
			editFunctionSet.clickONbtnManageMyEducation();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
						
			TestLogger.info("8. Create Education");
			
			personalData.clickBtnAddEducation();
			
			if (addEducation.isLblAddEducationDisplayed() == true) {
				setStatusTest("pass", "Access Add Education");
			} else {
				setStatusTest("fail", "Not Access Add Education");
			}
			
			addEducation.selectLevel();
			addEducation.fillTxtInstitute(DataManager.FunctionSet);
			addEducation.fillTxtMajor(DataManager.FunctionSet);
			addEducation.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add Education Success");
			} else {
				setStatusTest("fail", "Add Education Fail");
			}
					 
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Education block\r\n" 
					+ "2. Create Education button\r\n"
					+ "3. Edit Education button\r\n"
					+ "4. Delete Education button");
			
			if (personalData.isLblEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Education block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Education block");
			}
			
			if (personalData.isBtnAddEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create Education button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create Education button");
			}
			
			if (personalData.isBtnEditEducationDisplayed()== true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit Education button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit Education button");
			}
			
			if (personalData.isBnDeleteEducationDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete Education button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete Education button");
			}
			
			TestLogger.info("9. Update Education");
			
			personalData.clickBtnEditEducation();
			editEducation.fillTxtInstitute(DataManager.Functional);
			editEducation.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Education Success");
			} else {
				setStatusTest("fail", "Update Education Fail");
			}
			
			TestLogger.info("10. Delete Education");
			
			personalData.clickBtnDeleteEducation();
				
			if(personalData.isLblConfirmationDisplayed() == true)
			{
				personalData.clickBtnYesEducation();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Delete Education Success");
				} else {
					setStatusTest("fail", "Delete Education Fail");
				}
			}
}

	@Test(priority = 10)
	
		public void TT_25503() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Identification Documents Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyIdentificationDocuments();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
					 
			TestLogger.info("Expect : User CAN see/do: " + "IDDocument block");
			
			if (personalData.isLblIDDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "IDDocument block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "IDDocument block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create IDDocument button\r\n"
					+ "2. Edit IDDocument button\r\n"
					+ "3. Delete IDDocument button");
			
			if (personalData.isBtnAddIDDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Create IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create IDDocument button");
			}
			
			if (personalData.isBtnEditIDDocumentDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit IDDocument button");
			}
			
			if (personalData.isBnDeleteIDDocumentDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete IDDocument button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete IDDocument button");
			}
	}

		@Test(priority = 11)
	
		public void TT_25504() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Identification Documents + Manage Identification Documents Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyIdentificationDocuments();
			editFunctionSet.clickONbtnManageMyIdentificationDocuments();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
			
			TestLogger.info("8. Create Identification Document");
			
			personalData.clickBtnAddIDDocument();
			
			if (addIDDocument.isLblAddIDDocumentDisplayed() == true) {
				setStatusTest("pass", "Access Add Other Contact");
			} else {
				setStatusTest("fail", "Not Access Add Other Contact");
			}
			
			addIDDocument.selectType();
			addIDDocument.fillTxtNumber(DataManager.FunctionSet);
			addIDDocument.selectCountry();
			addIDDocument.selectIssueDate();
			addIDDocument.selectExpiryDate();
			addIDDocument.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add Other Contact Success");
			} else {
				setStatusTest("fail", "Add Other Contact Fail");
			}
					 
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. IDDocument block\r\n" 
					+ "2. Create IDDocument button\r\n"
					+ "3. Edit IDDocument button\r\n"
					+ "4. Delete IDDocument button");
			
			if (personalData.isLblIDDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "IDDocument block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "IDDocument block");
			}
			
			if (personalData.isBtnAddIDDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create IDDocument button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create IDDocument button");
			}
			
			if (personalData.isBtnEditIDDocumentDisplayed()== true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit IDDocument button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit IDDocument button");
			}
			
			if (personalData.isBnDeleteIDDocumentDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete IDDocument button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete IDDocument button");
			}
			
			TestLogger.info("9. Update IDDocument");
			
			personalData.clickBtnEditIDDocument();
			editIDDocument.fillTxtNumber(DataManager.FunctionSet);
			editIDDocument.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update IDDocument Success");
			} else {
				setStatusTest("fail", "Update IDDocument Fail");
			}
			
			TestLogger.info("10. Delete IDDocument");
			
			personalData.clickBtnDeleteIDDocument();
				
			if(personalData.isLblConfirmationDisplayed() == true)
			{
				personalData.clickBtnYesID();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Delete IDDocument Success");
				} else {
					setStatusTest("fail", "Delete IDDocument Fail");
				}
			}
}

	@Test(priority = 12)
	
		public void TT_25506() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Contact Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyContact();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
							 
			TestLogger.info("Expect : User CAN see/do: " + "Contact block");
			
			if (personalData.isLblContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Contact block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Contact block");
			}
			
			TestLogger.info("Expect : User CANNOT see/do: \r\n" 
					+ "1. Create Contact button\r\n"
					+ "2. Edit Contact button\r\n"
					+ "3. Delete Contact button");
			
			if (personalData.isBtnAddContactDisplayed() == false) {
				setStatusTest("pass", "User CAN see/do: " + "Create Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Create Contact button");
			}
			
			if (personalData.isBtnEditContactDisplayed()== false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Edit Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Edit Contact button");
			}
			
			if (personalData.isBnDeleteContactDisplayed() == false) {
				setStatusTest("pass", "User CANNOT see/do: " + "Delete Contact button");
			} else {
				setStatusTest("fail", "User CAN see/do: " + "Delete Contact button");
			}
}

	@Test(priority = 13)
	
		public void TT_25507() throws InterruptedException {
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
					
			TestLogger.info("3. Update Function Set| My Data - Personal Data | View Contact + Manage Contact Permission");
			
			functionSet.fillSearchName(DataManager.FunctionSet);
			functionSet.clickIconEdit();
			
			if (editFunctionSet.isLblEditFunctionSetDisplayed() == true) {
				setStatusTest("pass", "Open Edit Function Set popup");
			} else {
				setStatusTest("fail", "NOT Open Edit Function Set popup");
			}
			
			editFunctionSet.clickTabMySpace();
			editFunctionSet.clickSubTabMyData();
			editFunctionSet.clickCboxCustomization();
			editFunctionSet.clickONbtnViewMyContact();
			editFunctionSet.clickONbtnManageMyContact();
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
			
			if (mySpace.isLblNameSpaceDisplayed() == true) {
				setStatusTest("pass", "Access to My Space tab");
			} else {
				setStatusTest("fail", "Not Access to My Space tab");
			}
					
			TestLogger.info("6. Access My Data sub-tab");
			
			mySpace.clickTabMyData();
			
			if (myData.isSubTabPersonalDataDisplayed() == true) {
				setStatusTest("pass", "Access My Data sub-tab");
			} else {
				setStatusTest("fail", "Not Access My Data sub-tab");
			}
	
			TestLogger.info("7. Access to Personal Data Path");
				
			myData.clickSubTabPersonalData();
			
			if (personalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "Access Personal Data Path");
			} else {
				setStatusTest("fail", "Not Access Personal Data Path");
			}
			
			TestLogger.info("8. Create Other Contact");
			
			personalData.clickBtnAddContact();
			
			if (addContact.isLblAddContactDisplayed() == true) {
				setStatusTest("pass", "Access Add Other Contact");
			} else {
				setStatusTest("fail", "Not Access Add Other Contact");
			}
			
			addContact.fillTxtName(DataManager.FunctionSet);
			addContact.selectRelationship();
			addContact.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Add Other Contact Success");
			} else {
				setStatusTest("fail", "Add Other Contact Fail");
			}
					 
			TestLogger.info("Expect : User CAN see/do: \r\n" 
					+ "1. Contact block\r\n" 
					+ "2. Create Contact button\r\n"
					+ "3. Edit Contact button\r\n"
					+ "4. Delete Contact button");
			
			if (personalData.isLblContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Contact block");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Contact block");
			}
			
			if (personalData.isBtnAddContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Create Contact button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Create Contact button");
			}
			
			if (personalData.isBtnEditContactDisplayed()== true) {
				setStatusTest("pass", "User CAN see/do: " + "Edit Contact button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Edit Contact button");
			}
			
			if (personalData.isBnDeleteContactDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "Delete Contact button");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "Delete Contact button");
			}
			
			TestLogger.info("9. Update Contact");
			
			personalData.clickBtnEditContact();
			editContact.fillTxtName(DataManager.FunctionSet);
			editContact.clickBtnSave();
			
			if(DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Update Contact Success");
			} else {
				setStatusTest("fail", "Update Contact Fail");
			}
			
			TestLogger.info("10. Delete Contact");
			
			personalData.clickBtnDeleteContact();
				
			if(personalData.isLblConfirmationDisplayed() == true)
			{
				personalData.clickBtnYesContact();
				
				if(DataManager.isMsgSuccessDisplayed() == true) {
					setStatusTest("pass", "Delete Contact Success");
				} else {
					setStatusTest("fail", "Delete Contact Fail");
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
