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
import wize.pages.Form_CloneSecurityProfile;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_CreateSecurityProfile;
import wize.pages.Form_SecurityProfileDetail;
import wize.pages.LoginScreen;
import wize.pages.PositionList;
import wize.pages.SecurityProfile;

public class Test_Functional_SecuirtyProfile extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	SecurityProfile securityProfile;
	Form_CreateSecurityProfile createSecurityProfile;
	PositionList positionList;
	Form_CreatePosition createPosition;
	Form_CloneSecurityProfile cloneSP;
	Form_SecurityProfileDetail detailSP;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		securityProfile = new SecurityProfile(driver);
		createSecurityProfile = new Form_CreateSecurityProfile(driver);
		positionList = new PositionList(driver);
		createPosition = new Form_CreatePosition(driver);
		cloneSP = new Form_CloneSecurityProfile(driver);
		detailSP = new Form_SecurityProfileDetail(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}
	
	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}
	
	@Test(priority = 1, enabled = true)
	public void TT_19338() throws InterruptedException{
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Position screen");
		controlBoard.clickLblPosition();
		if (positionList.isLblPostionListDisplayed()) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}
		
		TestLogger.info("3. Create 3 New Positions");
		positionList.fillSearchPosition("autopos");
		while(positionList.isLinkFirstPostionDisplayed()){
			positionList.deletePosition();
			Thread.sleep(1500);
		}
		positionList.clickBtnCreate();
		if(createPosition.isLblCreatePositionDisplayed()){
			setStatusTest("pass", "Form Create Position is displayed");
		}else{
			setStatusTest("fail", "Form Create Position is NOT displayed");
		}
		
		createPosition.inputData("autopos1",DataManager.Test,DataManager.Test);
		createPosition.clickBtnSavenCreateNew();
		createPosition.inputDataTurn2("autopos2",DataManager.Test,DataManager.Test);
		createPosition.clickBtnSavenCreateNew();
		createPosition.inputDataTurn3("autopos3",DataManager.Test,DataManager.Test);
		createPosition.clickBtnSave();
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Position created successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
		}
		TestLogger.info("4. Access to Security Profile screen");
		controlBoard.clickIconControlBoard();
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		TestLogger.info("5. Create New Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		
		TestLogger.info("6. Search created security profile");
		securityProfile.fillSearch("Deleted Automation");
		TestLogger.info("7. Clone from created security profile");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form Clone Security Profile is displayed");
		}else{
			setStatusTest("fail", "Form Clone Security Profile is NOT displayed");
		}
		TestLogger.info("8. Compare data from tab Data Privacy");
		cloneSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(cloneSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(cloneSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(cloneSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(cloneSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		cloneSP.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Clone successfully");
		}else{
			setStatusTest("fail", "Clone NOT successfully");
		}
		TestLogger.info("9. View detail of Clone Security Profile");
		securityProfile.fillSearch("Copy of Deleted Automation");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("10. Compare data from tab Data Privacy");
		detailSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(detailSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(detailSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(detailSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(detailSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		detailSP.clickBtnClose();
		securityProfile.fillSearch("Copy of Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
	}
	
	@Test(priority = 2, enabled = true)
	public void TT_19339(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create New Security Profile");
		securityProfile.fillSearch("ZDeleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("ZDeleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.clickBtnSave();
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		
		TestLogger.info("4. Clone from Create Form from created security profile");
		securityProfile.clickBtnAdd();
		createSecurityProfile.inputData("ZDeleted Automation1", DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.selectCloneFrom();
		createSecurityProfile.clickTabDataPrivacy();
		TestLogger.info("Expected: FilterByOrganization1 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization1Displayed()){
			setStatusTest("pass", "FilterByOrganization1 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization1 HAS value");
		}
		TestLogger.info("Expected: Site do not have value");
		if(!createSecurityProfile.isValueSiteDisplayed()){
			setStatusTest("pass", "Site do not have value");
		}else{
			setStatusTest("fail", "Site HAS value");
		}
		TestLogger.info("Expected: FilterByOrganization2 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization2Displayed()){
			setStatusTest("pass", "FilterByOrganization2 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization2 HAS value");
		}
		TestLogger.info("Expected: Status do not have value");
		if(!createSecurityProfile.isValueStatusDisplayed()){
			setStatusTest("pass", "Status do not have value");
		}else{
			setStatusTest("fail", "Status HAS value");
		}
		TestLogger.info("Expected: LinkToPostion do not have value");
		if(!createSecurityProfile.isValueLinkToPositionDisplayed()){
			setStatusTest("pass", "LinkToPostion do not have value");
		}else{
			setStatusTest("fail", "LinkToPostion HAS value");
		}
		TestLogger.info("Expected: AdditionalPosition do not have value");
		if(!createSecurityProfile.isValueAdditionalPositionDisplayed()){
			setStatusTest("pass", "AdditionalPosition do not have value");
		}else{
			setStatusTest("fail", "AdditionalPosition HAS value");
		}
		TestLogger.info("Expected: ExceptionalPosition do not have value");
		if(!createSecurityProfile.isValueExpectionalPositionDisplayed()){
			setStatusTest("pass", "ExceptionalPosition do not have value");
		}else{
			setStatusTest("fail", "ExceptionalPosition HAS value");
		}
		createSecurityProfile.clickBtnSave();
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		TestLogger.info("5. View detail of Clone Security Profile");
		securityProfile.fillSearch("ZDeleted Automation1");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("6. Check data from tab Data Privacy");
		detailSP.clickTabDataPrivacy();
		if(detailSP.isAnnoucementDisplayed()){
			setStatusTest("pass", "No Data Privacy is displayed");
		}else{
			setStatusTest("fail", "No Data Privacy is NOT displayed");
		}
	}
	
	@Test(priority = 3, enabled = true)
	public void TT_19340(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create New Security Profile");
		securityProfile.clickBtnAdd();
		createSecurityProfile.inputData("ZDeleted Automation2", DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.selectCloneFrom();
		createSecurityProfile.clickTabDataPrivacy();
		TestLogger.info("Expected: FilterByOrganization1 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization1Displayed()){
			setStatusTest("pass", "FilterByOrganization1 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization1 HAS value");
		}
		TestLogger.info("Expected: Site do not have value");
		if(!createSecurityProfile.isValueSiteDisplayed()){
			setStatusTest("pass", "Site do not have value");
		}else{
			setStatusTest("fail", "Site HAS value");
		}
		TestLogger.info("Expected: FilterByOrganization2 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization2Displayed()){
			setStatusTest("pass", "FilterByOrganization2 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization2 HAS value");
		}
		TestLogger.info("Expected: Status do not have value");
		if(!createSecurityProfile.isValueStatusDisplayed()){
			setStatusTest("pass", "Status do not have value");
		}else{
			setStatusTest("fail", "Status HAS value");
		}
		TestLogger.info("Expected: LinkToPostion do not have value");
		if(!createSecurityProfile.isValueLinkToPositionDisplayed()){
			setStatusTest("pass", "LinkToPostion do not have value");
		}else{
			setStatusTest("fail", "LinkToPostion HAS value");
		}
		TestLogger.info("Expected: AdditionalPosition do not have value");
		if(!createSecurityProfile.isValueAdditionalPositionDisplayed()){
			setStatusTest("pass", "AdditionalPosition do not have value");
		}else{
			setStatusTest("fail", "AdditionalPosition HAS value");
		}
		TestLogger.info("Expected: ExceptionalPosition do not have value");
		if(!createSecurityProfile.isValueExpectionalPositionDisplayed()){
			setStatusTest("pass", "ExceptionalPosition do not have value");
		}else{
			setStatusTest("fail", "ExceptionalPosition HAS value");
		}
		createSecurityProfile.clickBtnSavenCreateNew();
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		TestLogger.info("Expected: Form Create is still opened");
		if(createSecurityProfile.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form created security profile is still opened");
		}else{
			setStatusTest("fail", "Form created security profile is NOT opened");
		}
		TestLogger.info("4. Check Data Privacy tab data is clear");
		createSecurityProfile.clickTabDataPrivacy();
		TestLogger.info("Expected: FilterByOrganization1 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization1Displayed()){
			setStatusTest("pass", "FilterByOrganization1 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization1 HAS value");
		}
		TestLogger.info("Expected: Site do not have value");
		if(!createSecurityProfile.isValueSiteDisplayed()){
			setStatusTest("pass", "Site do not have value");
		}else{
			setStatusTest("fail", "Site HAS value");
		}
		TestLogger.info("Expected: FilterByOrganization2 do not have value");
		if(!createSecurityProfile.isValueFilterByOrganization2Displayed()){
			setStatusTest("pass", "FilterByOrganization2 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization2 HAS value");
		}
		TestLogger.info("Expected: Status do not have value");
		if(!createSecurityProfile.isValueStatusDisplayed()){
			setStatusTest("pass", "Status do not have value");
		}else{
			setStatusTest("fail", "Status HAS value");
		}
		TestLogger.info("Expected: LinkToPostion do not have value");
		if(!createSecurityProfile.isValueLinkToPositionDisplayed()){
			setStatusTest("pass", "LinkToPostion do not have value");
		}else{
			setStatusTest("fail", "LinkToPostion HAS value");
		}
		TestLogger.info("Expected: AdditionalPosition do not have value");
		if(!createSecurityProfile.isValueAdditionalPositionDisplayed()){
			setStatusTest("pass", "AdditionalPosition do not have value");
		}else{
			setStatusTest("fail", "AdditionalPosition HAS value");
		}
		TestLogger.info("Expected: ExceptionalPosition do not have value");
		if(!createSecurityProfile.isValueExpectionalPositionDisplayed()){
			setStatusTest("pass", "ExceptionalPosition do not have value");
		}else{
			setStatusTest("fail", "ExceptionalPosition HAS value");
		}
		TestLogger.info("5. Click Cancel button");
		createSecurityProfile.clickBtnCancel();
		if(securityProfile.isBtnAddDisplayed()){
			setStatusTest("pass", "Create Form is closed");
		}else{
			setStatusTest("fail", "Create Form is NOT closed");
		}
		TestLogger.info("6. View detail of Clone Security Profile");
		securityProfile.fillSearch("ZDeleted Automation2");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("7. Compare data from tab Data Privacy");
		detailSP.clickTabDataPrivacy();
		if(detailSP.isAnnoucementDisplayed()){
			setStatusTest("pass", "No Data Privacy is displayed");
		}else{
			setStatusTest("fail", "No Data Privacy is NOT displayed");
		}
		detailSP.clickBtnClose();
	}
	
	@Test(priority = 4, enabled = true)
	public void TT_19341_TT_19342(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Click btn Add new security Profile >> Select clone from a random security profile >> Open tab Data Privacy");
		securityProfile.clickBtnAdd();
		createSecurityProfile.inputData("Deleted Automation3", DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.selectCloneFrom();
		createSecurityProfile.clickTabDataPrivacy();
		TestLogger.info("5. Click btn Preview Employee list");
		createSecurityProfile.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (createSecurityProfile.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly  \n TT19342 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		createSecurityProfile.clickBtnClosePreview();
		createSecurityProfile.clickBtnCancel();
		
		securityProfile.clickBtnAdd();
		createSecurityProfile.inputData("Deleted Automation3", DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.selectCloneFrom();
		createSecurityProfile.clickTabDataPrivacy();
		System.out.println(createSecurityProfile.isRemoveDisplayed());
		createSecurityProfile.clickRemoveFilter();
		createSecurityProfile.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (createSecurityProfile.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly \n TT19341 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		createSecurityProfile.clickBtnClosePreview();
		createSecurityProfile.clickBtnCancel();
	}
	
	@Test(priority = 5, enabled = true)
	public void TT_19343(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Click btn Add new security Profile >> Select clone from a random security profile >> Open tab Data Privacy");
		securityProfile.clickBtnAdd();
		createSecurityProfile.inputData("Deleted Automation3", DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.selectCloneFrom();
		createSecurityProfile.clickTabDataPrivacy();
		TestLogger.info("5. Click btn Preview Employee list");
		createSecurityProfile.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (createSecurityProfile.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly  \n TT19343 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		createSecurityProfile.clickBtnClosePreview();
		createSecurityProfile.clickBtnSave();
		TestLogger.info("6. View detail of Clone Security Profile");
		securityProfile.fillSearch("Deleted Automation3");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("7. Preview employee list from View Detail");
		detailSP.clickTabDataPrivacy();
		detailSP.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (detailSP.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly  \n TT19343 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		detailSP.clickBtnClosePreview();
		detailSP.clickBtnClose();
		securityProfile.fillSearch("Deleted Automation3");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
	}
	
	@Test(priority = 6, enabled = true)
	public void TT_19348(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Open Clone form");
		securityProfile.fillSearch("Deleted Automation");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass","Clone Form is opened");
		}else{
			setStatusTest("fail","Clone Form is NOT opened");
		}
		TestLogger.info("5. Open tab Data Privacy >> Expected: data is auto-filled");
		cloneSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(cloneSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(cloneSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(cloneSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(cloneSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		cloneSP.selectBlankClone();
		cloneSP.clickTabDataPrivacy();
		TestLogger.info("Expected: FilterByOrganization1 do not have value");
		if(!cloneSP.isValueFilterByOrganization1Displayed()){
			setStatusTest("pass", "FilterByOrganization1 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization1 HAS value");
		}
		TestLogger.info("Expected: Site do not have value");
		if(!cloneSP.isValueSiteDisplayed()){
			setStatusTest("pass", "Site do not have value");
		}else{
			setStatusTest("fail", "Site HAS value");
		}
		TestLogger.info("Expected: FilterByOrganization2 do not have value");
		if(!cloneSP.isValueFilterByOrganization2Displayed()){
			setStatusTest("pass", "FilterByOrganization2 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization2 HAS value");
		}
		TestLogger.info("Expected: Status do not have value");
		if(!cloneSP.isValueStatusDisplayed()){
			setStatusTest("pass", "Status do not have value");
		}else{
			setStatusTest("fail", "Status HAS value");
		}
		TestLogger.info("Expected: LinkToPostion do not have value");
		if(!cloneSP.isValueLinkToPositionDisplayed()){
			setStatusTest("pass", "LinkToPostion do not have value");
		}else{
			setStatusTest("fail", "LinkToPostion HAS value");
		}
		TestLogger.info("Expected: AdditionalPosition do not have value");
		if(!cloneSP.isValueAdditionalPositionDisplayed()){
			setStatusTest("pass", "AdditionalPosition do not have value");
		}else{
			setStatusTest("fail", "AdditionalPosition HAS value");
		}
		TestLogger.info("Expected: ExceptionalPosition do not have value");
		if(!cloneSP.isValueExpectionalPositionDisplayed()){
			setStatusTest("pass", "ExceptionalPosition do not have value");
		}else{
			setStatusTest("fail", "ExceptionalPosition HAS value");
		}
	}
	
	@Test(priority = 7, enabled = true)
	public void TT_19349(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Open Clone form");
		securityProfile.fillSearch("Deleted Automation");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form Clone Security Profile is displayed");
		}else{
			setStatusTest("fail", "Form Clone Security Profile is NOT displayed");
		}
		cloneSP.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Clone successfully");
		}else{
			setStatusTest("fail", "Clone NOT successfully");
		}
		TestLogger.info("9. View detail of Clone Security Profile");
		securityProfile.fillSearch("Copy of Deleted Automation");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("10. Compare data from tab Data Privacy");
		detailSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(detailSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(detailSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(detailSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(detailSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		detailSP.clickBtnClose();
		securityProfile.fillSearch("Copy of Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void TT_19350(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Open Clone form");
		securityProfile.fillSearch("Deleted Automation");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form Clone Security Profile is displayed");
		}else{
			setStatusTest("fail", "Form Clone Security Profile is NOT displayed");
		}
		cloneSP.clickTabDataPrivacy();
		TestLogger.info("Expected: FilterByOrganization1 do not have value");
		if(!cloneSP.isValueFilterByOrganization1Displayed()){
			setStatusTest("pass", "FilterByOrganization1 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization1 HAS value");
		}
		TestLogger.info("Expected: Site do not have value");
		if(!cloneSP.isValueSiteDisplayed()){
			setStatusTest("pass", "Site do not have value");
		}else{
			setStatusTest("fail", "Site HAS value");
		}
		TestLogger.info("Expected: FilterByOrganization2 do not have value");
		if(!cloneSP.isValueFilterByOrganization2Displayed()){
			setStatusTest("pass", "FilterByOrganization2 do not have value");
		}else{
			setStatusTest("fail", "FilterByOrganization2 HAS value");
		}
		TestLogger.info("Expected: Status do not have value");
		if(!cloneSP.isValueStatusDisplayed()){
			setStatusTest("pass", "Status do not have value");
		}else{
			setStatusTest("fail", "Status HAS value");
		}
		TestLogger.info("Expected: LinkToPostion do not have value");
		if(!cloneSP.isValueLinkToPositionDisplayed()){
			setStatusTest("pass", "LinkToPostion do not have value");
		}else{
			setStatusTest("fail", "LinkToPostion HAS value");
		}
		TestLogger.info("Expected: AdditionalPosition do not have value");
		if(!cloneSP.isValueAdditionalPositionDisplayed()){
			setStatusTest("pass", "AdditionalPosition do not have value");
		}else{
			setStatusTest("fail", "AdditionalPosition HAS value");
		}
		TestLogger.info("Expected: ExceptionalPosition do not have value");
		if(!cloneSP.isValueExpectionalPositionDisplayed()){
			setStatusTest("pass", "ExceptionalPosition do not have value");
		}else{
			setStatusTest("fail", "ExceptionalPosition HAS value");
		}
		cloneSP.clickBtnSave();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Clone successfully");
		}else{
			setStatusTest("fail", "Clone NOT successfully");
		}
		TestLogger.info("9. View detail of Clone Security Profile");
		securityProfile.fillSearch("Copy of Deleted Automation");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		detailSP.clickTabDataPrivacy();
		TestLogger.info("Expected: No data privacy is displayed");
		if(detailSP.isAnnoucementDisplayed()){
			setStatusTest("pass", "No data privacy is displayed");
		}else{
			setStatusTest("fail", "No data privacy is NOT displayed");
		}
		detailSP.clickBtnClose();
		securityProfile.fillSearch("Copy of Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
	}
	
	@Test(priority = 9, enabled = true)
	public void TT_19351(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("6. Search created security profile");
		securityProfile.fillSearch("Deleted Automation");
		TestLogger.info("7. Clone from created security profile");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form Clone Security Profile is displayed");
		}else{
			setStatusTest("fail", "Form Clone Security Profile is NOT displayed");
		}
		TestLogger.info("8. Compare data from tab Data Privacy");
		cloneSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(cloneSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(cloneSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(cloneSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(cloneSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(cloneSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		cloneSP.clickBtnSavenCreateNew();
		if(DataManager.isMsgSuccessDisplayed()){
			setStatusTest("pass", "Clone successfully");
		}else{
			setStatusTest("fail", "Clone NOT successfully");
		}
		cloneSP.clickBtnCancel();
		TestLogger.info("9. View detail of Clone Security Profile");
		securityProfile.fillSearch("Copy of Deleted Automation");
		securityProfile.clickItemFirst();
		if(detailSP.isLblSecurityProfilelDetailDisplayed()){
			setStatusTest("pass", "Security Profile is displayed");
		}else{
			setStatusTest("fail", "Security Profile is NOT displayed");
		}
		TestLogger.info("10. Compare data from tab Data Privacy");
		detailSP.clickTabDataPrivacy();
		TestLogger.info("Expected: Filter 1 = Site");
		if(detailSP.isFilterOrganization1Correct()){
			setStatusTest("pass", "Filter 1 = Site");
		}else{
			setStatusTest("fail", "Filter 1 != Site");
		}
		TestLogger.info("Expected: Site = VNM");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Site = VNM");
		}else{
			setStatusTest("fail", "Site != VNM");
		}
		TestLogger.info("Expected: Filter 2 = Status");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Filter 2 = Status");
		}else{
			setStatusTest("fail", "Filter 2 != Status");
		}
		TestLogger.info("Expected: Status = Active-filled");
		if(detailSP.isSiteCorrect()){
			setStatusTest("pass", "Status = Active-filled");
		}else{
			setStatusTest("fail", "Status != Active-filled");
		}
		TestLogger.info("Expected: Link to Position");
		if(detailSP.isLinkToPositionCorrect()){
			setStatusTest("pass", "Link to Position is correct");
		}else{
			setStatusTest("fail", "Link to Position is NOT correct");
		}
		if(detailSP.isAdditionalPositionCorrect()){
			setStatusTest("pass", "Additional Position is correct");
		}else{
			setStatusTest("fail", "Additional Position is NOT correct");
		}
		if(detailSP.isExceptionalPositionCorrect()){
			setStatusTest("pass", "Exceptional Position is correct");
		}else{
			setStatusTest("fail", "Exceptional Position is NOT correct");
		}
		detailSP.clickBtnClose();
		securityProfile.fillSearch("Copy of Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
	}
	
	@Test (priority = 10, enabled = true)
	public void TT_19352_TT_19353_TT_19354(){
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin1, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Security Profile screen");
		controlBoard.clickLblSecurityProfile();
		if(securityProfile.isLblSecurityProfileDisplayed()){
			setStatusTest("pass", "Access to Security Profile");
		}else{
			setStatusTest("fail", "CANNOT Access to Security Profile");
		}
		
		TestLogger.info("3. Create new Security Profile");
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
			}
		}
		securityProfile.clickBtnAdd();
		
		if (createSecurityProfile.isLblCreateSecurityProfilelDisplayed() == true) {
			setStatusTest("pass", "Open Create popup");
		} else {
			setStatusTest("fail", "Not Open Create popup");
		}
		
		createSecurityProfile.inputData("Deleted Automation",DataManager.Test,DataManager.FunctionSet);
		createSecurityProfile.inputPrivacy();
		createSecurityProfile.clickBtnSave();
		
		TestLogger.info("Expect : User CAN see/do: " + "Security Profile created successfully");
		
		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg: " + "Security Profile created successfully");
		} else {
			setStatusTest("fail", "NOT Displays msg: " + "Security Profile created successfully");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestLogger.info("4. Search created security profile");
		securityProfile.fillSearch("Deleted Automation");
		TestLogger.info("5. Clone from created security profile");
		securityProfile.clickIconClone();
		if(cloneSP.isLblCreateSecurityProfilelDisplayed()){
			setStatusTest("pass", "Form Clone Security Profile is displayed");
		}else{
			setStatusTest("fail", "Form Clone Security Profile is NOT displayed");
		}
		TestLogger.info("6. Click btn Preview Employee list");
		cloneSP.clickTabDataPrivacy();
		cloneSP.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (cloneSP.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly  \n TT19353 + TT19354 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		cloneSP.clickBtnClosePreview();
		cloneSP.clickBtnCancel();
		
		securityProfile.clickIconClone();
		cloneSP.clickTabDataPrivacy();
		cloneSP.clickRemoveFilter();
		cloneSP.clickBtnPreviewEmpList();
		TestLogger.info("Expected: At least an employee is displayed");
		if (cloneSP.isItemFullNameDisplayed() == true) {
			setStatusTest("pass", "An employee is displayed correctly \n TT19352 is PASSED");
		} else {
			setStatusTest("fail", "An employee is NOT displayed correctly");
		}
		cloneSP.clickBtnClosePreview();
		cloneSP.clickBtnCancel();
		securityProfile.fillSearch("Deleted Automation");
		if(securityProfile.isItemFirstDisplayed() == true)
		{
			securityProfile.clickCboxAll();
			securityProfile.clickBtnDeleteAll();
						
			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "Displays msg: " + "Security Profile deleted successfully");
			} else {
				setStatusTest("fail", "NOT Displays msg: " + "Security Profile deleted successfully");
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
		driver.quit();
	}
}
