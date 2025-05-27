package InteractExcel;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import controller.ExcelControllerXLSX;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.Form_CreateEmployee_TalentManagement;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_CreateQuestion;
import wize.pages.LoginScreen;
import wize.pages.PositionList;
import wize.pages.QuestionPool;
import wize.pages.TalentManagement_Employee;

public class CreateEmployee extends TestManager{
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	ExcelControllerXLSX excelXLSX;
	public XSSFSheet sheet;
	public XSSFWorkbook wb;
	public XSSFRow row;
	TalentManagement_Employee talentEmployee;
	Form_CreateEmployee_TalentManagement createEmployee;
	QuestionPool questionPool;
	Form_CreateQuestion formCreateQuestion;
	PositionList positionList;
	Form_CreatePosition formCreatePosition;
	
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() throws InterruptedException {
		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		talentEmployee = new TalentManagement_Employee(driver);
		createEmployee = new Form_CreateEmployee_TalentManagement(driver);
		excelXLSX = new ExcelControllerXLSX();
		questionPool = new QuestionPool(driver);
		formCreateQuestion = new Form_CreateQuestion(driver);
		positionList = new PositionList(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
		System.out.println("Time start: " + java.time.LocalTime.now());
	}
	
	@Test (priority = 1, enabled = false)
	public void createEmployeeFromExcel() throws InterruptedException, IOException{
		TestLogger.info("Read file excel");
		String _employeeID, _firstName, _middleName, _lastName, _site, _unit, _division, _department, _roleLevel, _jobTitle, _reportToManager, _managerEmail, _tekEmail, _teamDivision, _positionName;
	
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent Management screen");
		controlBoard.clickTabTalentManagement();
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		TestLogger.info("3. Click btn Add Employee");
		talentEmployee.clickBtnAddEmployee();
		try {
			wb = excelXLSX.getExcelFile("Azure APTS Wize User Upload v.3.xlsx");
			sheet = wb.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFCell cell = sheet.getRow(i).getCell(0);
				_firstName = sheet.getRow(i).getCell(1).getStringCellValue();
				_middleName = sheet.getRow(i).getCell(2).getStringCellValue();
				_lastName = sheet.getRow(i).getCell(3).getStringCellValue();
				_site = sheet.getRow(i).getCell(4).getStringCellValue();
				_unit = sheet.getRow(i).getCell(5).getStringCellValue();
				_division = sheet.getRow(i).getCell(6).getStringCellValue();
				_department = sheet.getRow(i).getCell(7).getStringCellValue();
				_roleLevel = sheet.getRow(i).getCell(8).getStringCellValue();
				_jobTitle = sheet.getRow(i).getCell(9).getStringCellValue();
				_reportToManager = sheet.getRow(i).getCell(10).getStringCellValue();
				_managerEmail = sheet.getRow(i).getCell(11).getStringCellValue();
				_tekEmail = TienIch.taoRandomSo(4) + sheet.getRow(i).getCell(12).getStringCellValue();
				_teamDivision = sheet.getRow(i).getCell(13).getStringCellValue();
				_positionName = sheet.getRow(i).getCell(14).getStringCellValue();
						
				if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					int emp = (int)sheet.getRow(i).getCell(0).getNumericCellValue();
					_employeeID = new Integer(emp).toString();
				}else{
					_employeeID = sheet.getRow(i).getCell(0).getStringCellValue();
				}
				TestLogger.info("Employee profile " + i);
				createEmployee.inputFullData(_firstName, _middleName, _lastName, _tekEmail, "home" + TienIch.taoRandomSo(4) + "@home.com", _positionName);
				if(DataManager.isMsgSuccessDisplayed()){
					TestLogger.info("Create employee " + i + " successfully");
				}else{
					TestLogger.info("Create employee " + i + " Unsuccessfully");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
	
	@Test (priority = 2, enabled = false)
	public void createEmployeeFromExcelWithLog() throws InterruptedException, IOException{
		TestLogger.info("Read file excel");
		String _firstName, _middleName, _lastName, _birthday, _gender, _title, _countryOfWork, _countryOfResidence, _mobilePhone, _homePhone, _companyEmail, _employmentStatus, _personalEmail, _positionName,_startDate,_endDate,_startReason,_primary,_autoCreate,_empCode;
	
		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Talent Management screen");
		controlBoard.clickTabTalentManagement();
		if (talentEmployee.isLabelEmployeeManagementDisplayed() == true) {
			setStatusTest("pass", "Access to Talent Management");
		} else {
			setStatusTest("fail", "Not Access to Talent Management");
		}
		TestLogger.info("3. Click btn Add Employee");
		talentEmployee.clickBtnAddEmployee();
		try {
			wb = excelXLSX.getExcelFile("Create_New_User_29-Jul-2020.xlsx");
			sheet = wb.getSheetAt(0);
			CellStyle wrapStyle = wb.createCellStyle();
			wrapStyle.setWrapText(true);
			System.out.println("Total rows: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				_firstName = sheet.getRow(i).getCell(0).getStringCellValue();
				_middleName = sheet.getRow(i).getCell(1).getStringCellValue();
				_lastName = sheet.getRow(i).getCell(2).getStringCellValue();
				if (sheet.getRow(i).getCell(3).getCellTypeEnum() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(3))) {
			            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            _birthday = dateFormat.format(sheet.getRow(i).getCell(3).getDateCellValue());
			        } else {
			            int _birth = (int)sheet.getRow(i).getCell(3).getNumericCellValue();
						_birthday = new Integer(_birth).toString();
			        }
				}else{
					_birthday = sheet.getRow(i).getCell(3).getStringCellValue();
				}
				_gender = sheet.getRow(i).getCell(4).getStringCellValue().trim();
				_title = sheet.getRow(i).getCell(5).getStringCellValue().trim();
				_countryOfWork = sheet.getRow(i).getCell(6).getStringCellValue().trim();
				_countryOfResidence = sheet.getRow(i).getCell(7).getStringCellValue().trim();
				_mobilePhone = sheet.getRow(i).getCell(8).getStringCellValue().trim();
				_homePhone = sheet.getRow(i).getCell(9).getStringCellValue().trim();
				_companyEmail = TienIch.taoRandomSo(4) + sheet.getRow(i).getCell(10).getStringCellValue().trim();
//				_companyEmail = sheet.getRow(i).getCell(10).getStringCellValue().trim();
				_employmentStatus = sheet.getRow(i).getCell(11).getStringCellValue().trim();
				_personalEmail = TienIch.taoRandomSo(4) + sheet.getRow(i).getCell(12).getStringCellValue().trim();
//				_personalEmail = sheet.getRow(i).getCell(12).getStringCellValue().trim();
				_positionName = sheet.getRow(i).getCell(13).getStringCellValue().trim();
				if (sheet.getRow(i).getCell(14).getCellTypeEnum() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(14))) {
			            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            _startDate = dateFormat.format(sheet.getRow(i).getCell(14).getDateCellValue());
			        } else {
			            int _date = (int)sheet.getRow(i).getCell(14).getNumericCellValue();
			            _startDate = new Integer(_date).toString();
			        }
				}else{
					_startDate = sheet.getRow(i).getCell(14).getStringCellValue();
				}
				if (sheet.getRow(i).getCell(15).getCellTypeEnum() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(15))) {
			            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            _endDate = dateFormat.format(sheet.getRow(i).getCell(15).getDateCellValue());
			        } else {
			            int _date = (int)sheet.getRow(i).getCell(15).getNumericCellValue();
			            _endDate = new Integer(_date).toString();
			        }
				}else{
					_endDate = sheet.getRow(i).getCell(15).getStringCellValue();
				}
				_startReason = sheet.getRow(i).getCell(16).getStringCellValue().trim();
				_primary = sheet.getRow(i).getCell(17).getStringCellValue();
				_autoCreate = sheet.getRow(i).getCell(18).getStringCellValue();
				if (sheet.getRow(i).getCell(19).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(19).getNumericCellValue();
					_empCode = new Integer(_code).toString();
				}else{
					_empCode = sheet.getRow(i).getCell(19).getStringCellValue();
				}
				TestLogger.info("Employee profile " + i);
				createEmployee.inputFullDataOriginal(_firstName, _middleName, _lastName,_birthday, _gender,_title,_countryOfWork,_countryOfResidence,_mobilePhone,_homePhone,_empCode,_companyEmail,_employmentStatus,_personalEmail,_positionName,_startDate,_endDate,_startReason,_primary,_autoCreate);
				Cell cellResult = sheet.getRow(i).getCell(20);
				Cell cellReason = sheet.getRow(i).getCell(21);
				if(cellResult!= null && cellResult.getCellTypeEnum() != CellType.BLANK){
					cellResult.setCellType(CellType.BLANK);
				}
				if(cellReason!= null && cellReason.getCellTypeEnum() != CellType.BLANK){
					cellReason.setCellType(CellType.BLANK);
				}
				if(DataManager.isMsgSuccessDisplayed() && DataManager.getMsgSuccess().equals("Employee created successfully.")){
					TestLogger.info("Create employee " + i + " successfully");
					excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "PASSED");
					excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, DataManager.getMsgSuccess());
					System.out.println("Write successfully to excel file");
				}else if(DataManager.isMsgSuccessDisplayed() && !DataManager.getMsgSuccess().equals("Employee created successfully.")) {
					TestLogger.info("Create employee " + i + " Unsuccessfully");
					excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
					excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, DataManager.getMsgSuccess());
					System.out.println("Write successfully to excel file");
					createEmployee.clickBtnCancel();
					Thread.sleep(1000);
					talentEmployee.clickBtnAddEmployee();
				}else if(!DataManager.isMsgSuccessDisplayed()){
					if(createEmployee.isMsgFirstNameDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking first name validation");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, "First name: " + createEmployee.getMsgFirstName());
					}
					if(createEmployee.isMsgLastNameDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking last name validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Last name: " + createEmployee.getMsgLastName());
					}
					if(createEmployee.isMsgGenderDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Gender validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Gender: " + createEmployee.getMsgGender());
					}
					if(createEmployee.isMsgTitleDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Title validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Title: " + createEmployee.getMsgTitle());
					}
					if(createEmployee.isMsgCompanyEmailDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking company email validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Company email: " + createEmployee.getMsgCompanyEmail());
					}
					if(createEmployee.isMsgEmpStatusDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Employee status validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Employee status: " + createEmployee.getMsgEmpStatus());
					}
					if(createEmployee.isMsgPersonalemailDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Personal email validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Personal email: " + createEmployee.getMsgPersonalemail());
					}
					if(createEmployee.isMsgPositionNameDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Position validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
						excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Position name: " + createEmployee.getMsgPositionName());
					}
					if(createEmployee.isMsgStartDateDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Start Date validation");
						String oldContent = sheet.getRow(i).getCell(21).getStringCellValue();
						if(!createEmployee.getMsgStartDate().equals("")){
							excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 20, "FAILED");
							excelXLSX.writeToCell("Create_New_User_29-Jul-2020.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 21, oldContent + "\r\n" + "Start Date: " + createEmployee.getMsgStartDate());
						}
					}
					System.out.println("Write successfully to excel file");
					createEmployee.clickBtnCancel();
					Thread.sleep(1000);
					talentEmployee.clickBtnAddEmployee();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
	
	@Test (priority = 3, enabled = false)
	public void createSingleChoiceQuestion() throws IOException{
		TestLogger.info("Read file excel");
		int count = 1;
		int countAnswer = 0;
		String _category = "", _completionTime = "", _creator = "", _assessmentGroup = "", _tips = "", _questionText = "", _answer = "", _correctAnswer = "", _skillName = "", _skillLevel = "", _behavior = "";

		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Question Pool >> Select any category");
		controlBoard.clickLblQuestionPool();
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		TestLogger.info("3. Select category");
		questionPool.clickFirstCategory();
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("4. Click  on Create Question icon >> select Single choice option ");
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemSingleChoice();
		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		try {
			wb = excelXLSX.getExcelFile("Import question template.xlsx");
			sheet = wb.getSheetAt(1);
			System.out.println("Total row: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if(count == 1){
					_category = sheet.getRow(i).getCell(0).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
						int compTime = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
						_completionTime = new Integer(compTime).toString();
					}else{
						_completionTime = sheet.getRow(i).getCell(1).getStringCellValue().trim();
					}
					_creator = sheet.getRow(i).getCell(2).getStringCellValue().trim();
					_assessmentGroup = sheet.getRow(i).getCell(3).getStringCellValue();
					_tips = sheet.getRow(i).getCell(4).getStringCellValue();
					_questionText = sheet.getRow(i).getCell(5).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(6).getCellTypeEnum() == CellType.NUMERIC) {
						int ans = (int)sheet.getRow(i).getCell(6).getNumericCellValue();
						_answer = new Integer(ans).toString();
					}else{
						_answer = sheet.getRow(i).getCell(6).getStringCellValue().trim();
					}
					_correctAnswer = sheet.getRow(i).getCell(7).getStringCellValue();
					_skillName = sheet.getRow(i).getCell(8).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(9).getCellTypeEnum() == CellType.NUMERIC) {
						int sLevel = (int)sheet.getRow(i).getCell(9).getNumericCellValue();
						_skillLevel = new Integer(sLevel).toString();
					}else{
						_skillLevel = sheet.getRow(i).getCell(9).getStringCellValue();
					}
					_behavior = sheet.getRow(i).getCell(10).getStringCellValue().trim();
					countAnswer = 0;
					TestLogger.info("Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Instruction, Question text, Answer.");
					if(!_category.equals("")){
						formCreateQuestion.selectCategory(_category);
					}
					if(!_completionTime.equals("")){
						formCreateQuestion.clickDrplistCompletionTime();
						formCreateQuestion.selectCompletionTime(Integer.parseInt(_completionTime));
					}
					if(!_creator.equals("")){
						formCreateQuestion.fillAuthor(_creator);
					}
					if(!_assessmentGroup.equals("")){
						formCreateQuestion.clickDrplistPool();
						String[] arrAGroup = _assessmentGroup.split(",");
						for (String _group : arrAGroup){
							formCreateQuestion.selectPool(_group.trim());
						}
					}
					formCreateQuestion.fillInstruction(_tips);
					formCreateQuestion.fillQuestionText(sheet.getRow(i).getCell(5).getStringCellValue());
					if(!_skillName.equals("") && !_skillLevel.equals("")){
						formCreateQuestion.selectSkillAndLevelSingleChoice(_skillName, Integer.parseInt(_skillLevel), _behavior);
					}
					formCreateQuestion.clickBtnQuestionInformation();
				}
				if(_questionText.equals(sheet.getRow(i).getCell(5).getStringCellValue().trim()) && !sheet.getRow(i).getCell(5).getStringCellValue().equals("")){
					formCreateQuestion.clickBtnAddAnswer();
					countAnswer++;
					if (sheet.getRow(i).getCell(6).getCellTypeEnum() == CellType.NUMERIC) {
						if(sheet.getRow(i).getCell(6).getNumericCellValue() % 1 == 0){
							int ans = (int)sheet.getRow(i).getCell(6).getNumericCellValue();
							_answer = new Integer(ans).toString();
						}else{
							float ans1 = (float)sheet.getRow(i).getCell(6).getNumericCellValue();
							_answer = new Float(ans1).toString();
						}					
					}else{
						_answer = sheet.getRow(i).getCell(6).getStringCellValue().trim();
					}
					switch (countAnswer) {
					case 1:
						formCreateQuestion.fillInputAnswerSingleChoice1(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio1();
						}
						formCreateQuestion.clickIconSave1();
					
						if (formCreateQuestion.isIconEdit1Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 2:
						formCreateQuestion.fillInputAnswerSingleChoice2(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio2();
						}
						formCreateQuestion.clickIconSave2();
					
						if (formCreateQuestion.isIconEdit2Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 3:
						formCreateQuestion.fillInputAnswerSingleChoice3(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio3();
						}
						formCreateQuestion.clickIconSave3();
					
						if (formCreateQuestion.isIconEdit3Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 4:
						formCreateQuestion.fillInputAnswerSingleChoice4(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio4();
						}
						formCreateQuestion.clickIconSave4();
					
						if (formCreateQuestion.isIconEdit4Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 5:
						formCreateQuestion.fillInputAnswerSingleChoice5(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio5();
						}
						formCreateQuestion.clickIconSave5();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 6:
						formCreateQuestion.fillInputAnswerSingleChoice6(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio6();
						}
						formCreateQuestion.clickIconSave6();
					
						if (formCreateQuestion.isIconEdit6Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 7:
						formCreateQuestion.fillInputAnswerSingleChoice7(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio7();
						}
						formCreateQuestion.clickIconSave7();
					
						if (formCreateQuestion.isIconEdit7Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 8:
						formCreateQuestion.fillInputAnswerSingleChoice8(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio8();
						}
						formCreateQuestion.clickIconSave8();
					
						if (formCreateQuestion.isIconEdit8Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 9:
						formCreateQuestion.fillInputAnswerSingleChoice9(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio9();
						}
						formCreateQuestion.clickIconSave9();
					
						if (formCreateQuestion.isIconEdit9Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 10:
						formCreateQuestion.fillInputAnswerSingleChoice10(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio10();
						}
						formCreateQuestion.clickIconSave10();
					
						if (formCreateQuestion.isIconEdit10Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 11:
						formCreateQuestion.fillInputAnswerSingleChoice11(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio11();
						}
						formCreateQuestion.clickIconSave11();
					
						if (formCreateQuestion.isIconEdit11Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 12:
						formCreateQuestion.fillInputAnswerSingleChoice12(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio12();
						}
						formCreateQuestion.clickIconSave12();
					
						if (formCreateQuestion.isIconEdit12Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 13:
						formCreateQuestion.fillInputAnswerSingleChoice13(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio13();
						}
						formCreateQuestion.clickIconSave13();
					
						if (formCreateQuestion.isIconEdit13Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 14:
						formCreateQuestion.fillInputAnswerSingleChoice14(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio14();
						}
						formCreateQuestion.clickIconSave14();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 15:
						formCreateQuestion.fillInputAnswerSingleChoice15(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio15();
						}
						formCreateQuestion.clickIconSave15();
					
						if (formCreateQuestion.isIconEdit15Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					default:
						System.out.println("***Maximum is 15 answers for 1 single choice question***");
						break;
					}
					count = 0;
				}else{
					count = 1;
					formCreateQuestion.clickBtnSavenCreateNew();
					Thread.sleep(3000);
					Cell cellResult = sheet.getRow(i).getCell(11);
					Cell cellReason = sheet.getRow(i).getCell(12);
					if(cellResult!= null && cellResult.getCellTypeEnum() != CellType.BLANK){
						cellResult.setCellType(CellType.BLANK);
					}
					if(cellReason!= null && cellReason.getCellTypeEnum() != CellType.BLANK){
						cellReason.setCellType(CellType.BLANK);
					}
					if(cellResult==null){
						try {
							cellResult = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellResult = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(cellReason==null){
						try {
							cellReason = sheet.getRow(i).getCell(12,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellReason = sheet.getRow(i).getCell(12,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(DataManager.isMsgSuccessDisplayed() && DataManager.getMsgSuccess().equals("Question created successfully.")){
						TestLogger.info("Create Question successfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "PASSED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
					}else if(DataManager.isMsgSuccessDisplayed() && !DataManager.getMsgSuccess().equals("Question created successfully.")) {
						TestLogger.info("Create employee " + i + " Unsuccessfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
						createEmployee.clickBtnCancel();
						Thread.sleep(1000);
						talentEmployee.clickBtnAddEmployee();
					}else if(!DataManager.isMsgSuccessDisplayed()){
						formCreateQuestion.clickBtnQuestionInformation();
						if(formCreateQuestion.isMsgCompTimeDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Completion time validation");
							if(!formCreateQuestion.getMsgCompTime().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, "Completion Time: " + formCreateQuestion.getMsgCompTime());
							}
						}
						if(formCreateQuestion.isMsgCreatorDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Creator validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgCreator().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, oldContent + "\r\n" + "Creator: " + formCreateQuestion.getMsgCreator());
							}
						}
						if(formCreateQuestion.isMsgAssessmentGroupDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Assessment Group validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgAssessmentGroup().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, oldContent + "\r\n" + "Assessment Group: " + formCreateQuestion.getMsgAssessmentGroup());
							}
						}
						if(formCreateQuestion.isMsgQuestionTextDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Question text validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgQuesText().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, oldContent + "\r\n" + "Question Text: " + formCreateQuestion.getMsgQuesText());
							}
						}
						if(formCreateQuestion.isMsgSkillLevelDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Skill Level validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgSkillLevel().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, oldContent + "\r\n" + "Skill Level: " + formCreateQuestion.getMsgSkillLevel());
							}
						}
						if(formCreateQuestion.isMsgAnswerDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Answer validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgAnswer().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(1).getSheetName(), i, 12, oldContent + "\r\n" + "Answer: " + formCreateQuestion.getMsgAnswer());
							}
						}
						System.out.println("Write to file successfully");
						formCreateQuestion.clickBtnCancel();
						questionPool.clickBtnCreateQuestion();
						questionPool.clickItemSingleChoice();
						if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
							setStatusTest("pass", "Access to Create Question");
						} else {
							setStatusTest("fail", "Not Access to Create Question");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
		
	@Test (priority = 4, enabled = false)
	public void createMultiChoiceQuestion() throws IOException{
		TestLogger.info("Read file excel");
		int count = 1;
		int countAnswer = 0;
		String _category = "", _completionTime = "", _creator = "", _assessmentGroup = "", _tips = "", _questionText = "", _answer = "", _correctAnswer = "", _skillName = "", _skillLevel = "", _behavior = "";

		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Question Pool >> Select any category");
		controlBoard.clickLblQuestionPool();
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		TestLogger.info("3. Select category");
		questionPool.clickFirstCategory();
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("4. Click  on Create Question icon >> select Multiple choice option ");
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemMultipleChoice();
		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		try {
			wb = excelXLSX.getExcelFile("Import question template.xlsx");
			sheet = wb.getSheetAt(2);
			System.out.println("Total row: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if(count == 1){
					_category = sheet.getRow(i).getCell(0).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
						int compTime = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
						_completionTime = new Integer(compTime).toString();
					}else{
						_completionTime = sheet.getRow(i).getCell(1).getStringCellValue();
					}
					_creator = sheet.getRow(i).getCell(2).getStringCellValue().trim();
					_assessmentGroup = sheet.getRow(i).getCell(3).getStringCellValue();
					_tips = sheet.getRow(i).getCell(4).getStringCellValue();
					_questionText = sheet.getRow(i).getCell(5).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(6).getCellTypeEnum() == CellType.NUMERIC) {
						int ans = (int)sheet.getRow(i).getCell(6).getNumericCellValue();
						_answer = new Integer(ans).toString();
					}else{
						_answer = sheet.getRow(i).getCell(6).getStringCellValue().trim();
					}
					_correctAnswer = sheet.getRow(i).getCell(7).getStringCellValue();
					_skillName = sheet.getRow(i).getCell(8).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(9).getCellTypeEnum() == CellType.NUMERIC) {
						int sLevel = (int)sheet.getRow(i).getCell(9).getNumericCellValue();
						_skillLevel = new Integer(sLevel).toString();
					}else{
						_skillLevel = sheet.getRow(i).getCell(9).getStringCellValue();
					}
					_behavior = sheet.getRow(i).getCell(10).getStringCellValue().trim();
					countAnswer = 0;
					TestLogger.info("Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Instruction, Question text, Answer.");
					
					if(!_category.equals("")){
						formCreateQuestion.selectCategory(_category);
					}
					if(!_completionTime.equals("")){
						formCreateQuestion.clickDrplistCompletionTime();
						formCreateQuestion.selectCompletionTime(Integer.parseInt(_completionTime));
					}
					if(!_creator.equals("")){
						formCreateQuestion.fillAuthor(_creator);
					}
					if(!_assessmentGroup.equals("")){
						formCreateQuestion.clickDrplistPool();
						String[] arrAGroup = _assessmentGroup.split(",");
						for (String _group : arrAGroup){
							formCreateQuestion.selectPool(_group.trim());
						}
					}
					formCreateQuestion.fillInstruction(_tips);
					formCreateQuestion.fillQuestionText(sheet.getRow(i).getCell(5).getStringCellValue());
					if(!_skillName.equals("") && !_skillLevel.equals("")){
						formCreateQuestion.selectSkillAndLevelSingleChoice(_skillName, Integer.parseInt(_skillLevel), _behavior);
					}
					formCreateQuestion.clickBtnQuestionInformation();
				}
				if(_questionText.equals(sheet.getRow(i).getCell(5).getStringCellValue()) && !sheet.getRow(i).getCell(5).getStringCellValue().equals("")){
					formCreateQuestion.clickBtnAddAnswer();
					countAnswer++;
					if (sheet.getRow(i).getCell(6).getCellTypeEnum() == CellType.NUMERIC) {
						if(sheet.getRow(i).getCell(6).getNumericCellValue() % 1 == 0){
							int ans = (int)sheet.getRow(i).getCell(6).getNumericCellValue();
							_answer = new Integer(ans).toString();
						}else{
							float ans1 = (float)sheet.getRow(i).getCell(6).getNumericCellValue();
							_answer = new Float(ans1).toString();
						}					
					}else{
						_answer = sheet.getRow(i).getCell(6).getStringCellValue().trim();
					}
					switch (countAnswer) {
					case 1:
						formCreateQuestion.fillInputAnswerSingleChoice1(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio1();
						}
						formCreateQuestion.clickIconSave1();
					
						if (formCreateQuestion.isIconEdit1Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 2:
						formCreateQuestion.fillInputAnswerSingleChoice2(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio2();
						}
						formCreateQuestion.clickIconSave2();
					
						if (formCreateQuestion.isIconEdit2Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 3:
						formCreateQuestion.fillInputAnswerSingleChoice3(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio3();
						}
						formCreateQuestion.clickIconSave3();
					
						if (formCreateQuestion.isIconEdit3Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 4:
						formCreateQuestion.fillInputAnswerSingleChoice4(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio4();
						}
						formCreateQuestion.clickIconSave4();
					
						if (formCreateQuestion.isIconEdit4Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 5:
						formCreateQuestion.fillInputAnswerSingleChoice5(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio5();
						}
						formCreateQuestion.clickIconSave5();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 6:
						formCreateQuestion.fillInputAnswerSingleChoice6(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio6();
						}
						formCreateQuestion.clickIconSave6();
					
						if (formCreateQuestion.isIconEdit6Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 7:
						formCreateQuestion.fillInputAnswerSingleChoice7(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio7();
						}
						formCreateQuestion.clickIconSave7();
					
						if (formCreateQuestion.isIconEdit7Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 8:
						formCreateQuestion.fillInputAnswerSingleChoice8(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio8();
						}
						formCreateQuestion.clickIconSave8();
					
						if (formCreateQuestion.isIconEdit8Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 9:
						formCreateQuestion.fillInputAnswerSingleChoice9(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio9();
						}
						formCreateQuestion.clickIconSave9();
					
						if (formCreateQuestion.isIconEdit9Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 10:
						formCreateQuestion.fillInputAnswerSingleChoice10(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio10();
						}
						formCreateQuestion.clickIconSave10();
					
						if (formCreateQuestion.isIconEdit10Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 11:
						formCreateQuestion.fillInputAnswerSingleChoice11(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio11();
						}
						formCreateQuestion.clickIconSave11();
					
						if (formCreateQuestion.isIconEdit11Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 12:
						formCreateQuestion.fillInputAnswerSingleChoice12(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio12();
						}
						formCreateQuestion.clickIconSave12();
					
						if (formCreateQuestion.isIconEdit12Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 13:
						formCreateQuestion.fillInputAnswerSingleChoice13(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio13();
						}
						formCreateQuestion.clickIconSave13();
					
						if (formCreateQuestion.isIconEdit13Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 14:
						formCreateQuestion.fillInputAnswerSingleChoice14(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio14();
						}
						formCreateQuestion.clickIconSave14();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 15:
						formCreateQuestion.fillInputAnswerSingleChoice15(_answer);
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio15();
						}
						formCreateQuestion.clickIconSave15();
					
						if (formCreateQuestion.isIconEdit15Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					default:
						System.out.println("***Maximum is 15 answers for 1 multiple choice question***");
						break;
					}
					count = 0;
				}else{
					count = 1;
					formCreateQuestion.clickBtnSavenCreateNew();
					Thread.sleep(3000);
					Cell cellResult = sheet.getRow(i).getCell(11);
					Cell cellReason = sheet.getRow(i).getCell(12);
					if(cellResult!= null && cellResult.getCellTypeEnum() != CellType.BLANK){
						cellResult.setCellType(CellType.BLANK);
					}
					if(cellReason!= null && cellReason.getCellTypeEnum() != CellType.BLANK){
						cellReason.setCellType(CellType.BLANK);
					}
					if(cellResult==null){
						try {
							cellResult = sheet.getRow(i).getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellResult = sheet.getRow(i).getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(cellReason==null){
						try {
							cellReason = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellReason = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(DataManager.isMsgSuccessDisplayed() && DataManager.getMsgSuccess().equals("Question created successfully.")){
						TestLogger.info("Create Question successfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "PASSED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
					}else if(DataManager.isMsgSuccessDisplayed() && !DataManager.getMsgSuccess().equals("Question created successfully.")) {
						TestLogger.info("Create employee " + i + " Unsuccessfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
						createEmployee.clickBtnCancel();
						Thread.sleep(1000);
						talentEmployee.clickBtnAddEmployee();
					}else if(!DataManager.isMsgSuccessDisplayed()){
						formCreateQuestion.clickBtnQuestionInformation();
						if(formCreateQuestion.isMsgCompTimeDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Completion time validation");
							if(!formCreateQuestion.getMsgCompTime().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, "Completion Time: " + formCreateQuestion.getMsgCompTime());
							}
						}
						if(formCreateQuestion.isMsgCreatorDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Creator validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgCreator().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, oldContent + "\r\n" + "Creator: " + formCreateQuestion.getMsgCreator());
							}
						}
						if(formCreateQuestion.isMsgAssessmentGroupDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Assessment Group validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgAssessmentGroup().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, oldContent + "\r\n" + "Assessment Group: " + formCreateQuestion.getMsgAssessmentGroup());
							}
						}
						if(formCreateQuestion.isMsgQuestionTextDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Question text validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgQuesText().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, oldContent + "\r\n" + "Question Text: " + formCreateQuestion.getMsgQuesText());
							}
						}
						if(formCreateQuestion.isMsgSkillLevelDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Skill Level validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgSkillLevel().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, oldContent + "\r\n" + "Skill Level: " + formCreateQuestion.getMsgSkillLevel());
							}
						}
						if(formCreateQuestion.isMsgAnswerDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Answer validation");
							String oldContent = sheet.getRow(i).getCell(12).getStringCellValue();
							if(!formCreateQuestion.getMsgAnswer().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 11, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(2).getSheetName(), i, 12, oldContent + "\r\n" + "Answer: " + formCreateQuestion.getMsgAnswer());
							}
						}
						System.out.println("Write to file successfully");
						formCreateQuestion.clickBtnCancel();
						questionPool.clickBtnCreateQuestion();
						questionPool.clickItemSingleChoice();
						if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
							setStatusTest("pass", "Access to Create Question");
						} else {
							setStatusTest("fail", "Not Access to Create Question");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
	
	
	@Test (priority = 5, enabled = false)
	public void createTrueFalseQuestion() throws IOException{
		TestLogger.info("Read file excel");
		String _category = "", _completionTime = "", _creator = "", _assessmentGroup = "", _tips = "", _questionText = "", _correctAnswer = "", _skillName = "", _skillLevel = "", _behavior = "";

		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Question Pool >> Select any category");
		controlBoard.clickLblQuestionPool();
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		TestLogger.info("3. Select category");
		questionPool.clickFirstCategory();
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("4. Click  on Create Question icon >> select True/False choice option ");
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemTrueFalse();
		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		try {
			wb = excelXLSX.getExcelFile("Import question template.xlsx");
			sheet = wb.getSheetAt(3);
			System.out.println("Total row: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					_category = sheet.getRow(i).getCell(0).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
						int compTime = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
						_completionTime = new Integer(compTime).toString();
					}else{
						_completionTime = sheet.getRow(i).getCell(1).getStringCellValue();
					}
					_creator = sheet.getRow(i).getCell(2).getStringCellValue().trim();
					_assessmentGroup = sheet.getRow(i).getCell(3).getStringCellValue();
					_tips = sheet.getRow(i).getCell(4).getStringCellValue();
					_questionText = sheet.getRow(i).getCell(5).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(6).getCellTypeEnum() == CellType.BOOLEAN) {
						boolean sLevel = sheet.getRow(i).getCell(6).getBooleanCellValue();
						_correctAnswer = new Boolean(sLevel).toString();
					}else{
						_correctAnswer = sheet.getRow(i).getCell(6).getStringCellValue();
					}
					_skillName = sheet.getRow(i).getCell(7).getStringCellValue().trim();
					if (sheet.getRow(i).getCell(8).getCellTypeEnum() == CellType.NUMERIC) {
						int sLevel = (int)sheet.getRow(i).getCell(8).getNumericCellValue();
						_skillLevel = new Integer(sLevel).toString();
					}else{
						_skillLevel = sheet.getRow(i).getCell(8).getStringCellValue();
					}
					_behavior = sheet.getRow(i).getCell(9).getStringCellValue().trim();
					TestLogger.info("Input/select data to mandatory fields: Type, Category, Completion Time (min), Author, Instruction, Question text, Answer.");
					if(!_category.equals("")){
						formCreateQuestion.selectCategory(_category);
					}
					if(!_completionTime.equals("")){
						formCreateQuestion.clickDrplistCompletionTime();
						formCreateQuestion.selectCompletionTime(Integer.parseInt(_completionTime));
					}
					if(!_creator.equals("")){
						formCreateQuestion.fillAuthor(_creator);
					}
					if(!_assessmentGroup.equals("")){
						formCreateQuestion.clickDrplistPool();
						String[] arrAGroup = _assessmentGroup.split(",");
						for (String _group : arrAGroup){
							formCreateQuestion.selectPool(_group.trim());
						}
					}
					formCreateQuestion.fillInstruction(_tips);
					formCreateQuestion.fillQuestionText(_questionText);
					if(!_skillName.equals("") && !_skillLevel.equals("")){
						formCreateQuestion.selectSkillAndLevelSingleChoice(_skillName, Integer.parseInt(_skillLevel), _behavior);
					}
					formCreateQuestion.clickBtnQuestionInformation();
					formCreateQuestion.selectAnswerTrueFalse(_correctAnswer);
					formCreateQuestion.clickBtnSavenCreateNew();
					Thread.sleep(3000);
					
					Cell cellResult = sheet.getRow(i).getCell(10);
					Cell cellReason = sheet.getRow(i).getCell(11);
					if(cellResult!= null && cellResult.getCellTypeEnum() != CellType.BLANK){
						cellResult.setCellType(CellType.BLANK);
					}
					if(cellReason!= null && cellReason.getCellTypeEnum() != CellType.BLANK){
						cellReason.setCellType(CellType.BLANK);
					}
					if(cellResult==null){
						try {
							cellResult = sheet.getRow(i).getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellResult = sheet.getRow(i).getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(cellReason==null){
						try {
							cellReason = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						} catch (Exception e) {
							cellReason = sheet.getRow(i).getCell(11,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						}
					}
					if(DataManager.isMsgSuccessDisplayed() && DataManager.getMsgSuccess().equals("Question created successfully.")){
						TestLogger.info("Create Question successfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "PASSED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
					}else if(DataManager.isMsgSuccessDisplayed() && !DataManager.getMsgSuccess().equals("Question created successfully.")) {
						TestLogger.info("Create employee " + i + " Unsuccessfully");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
						excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, DataManager.getMsgSuccess());
						System.out.println("Write successfully to excel file");
						createEmployee.clickBtnCancel();
						Thread.sleep(1000);
						talentEmployee.clickBtnAddEmployee();
					}else if(!DataManager.isMsgSuccessDisplayed()){
						formCreateQuestion.clickBtnQuestionInformation();
						if(formCreateQuestion.isMsgCompTimeDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Completion time validation");
							if(!formCreateQuestion.getMsgCompTime().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, "Completion Time: " + formCreateQuestion.getMsgCompTime());
							}
						}
						if(formCreateQuestion.isMsgCreatorDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Creator validation");
							String oldContent = sheet.getRow(i).getCell(11).getStringCellValue();
							if(!formCreateQuestion.getMsgCreator().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, oldContent + "\r\n" + "Creator: " + formCreateQuestion.getMsgCreator());
							}
						}
						if(formCreateQuestion.isMsgAssessmentGroupDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Assessment Group validation");
							String oldContent = sheet.getRow(i).getCell(11).getStringCellValue();
							if(!formCreateQuestion.getMsgAssessmentGroup().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, oldContent + "\r\n" + "Assessment Group: " + formCreateQuestion.getMsgAssessmentGroup());
							}
						}
						if(formCreateQuestion.isMsgQuestionTextDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Question text validation");
							String oldContent = sheet.getRow(i).getCell(11).getStringCellValue();
							if(!formCreateQuestion.getMsgQuesText().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, oldContent + "\r\n" + "Question Text: " + formCreateQuestion.getMsgQuesText());
							}
						}
						if(formCreateQuestion.isMsgSkillLevelDisplayed()){
							System.out.println("-------------------------------");
							System.out.println("Checking Skill Level validation");
							String oldContent = sheet.getRow(i).getCell(11).getStringCellValue();
							if(!formCreateQuestion.getMsgSkillLevel().equals("")){
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 10, "FAILED");
								excelXLSX.writeToCell("Import question template.xlsx", sheet, wb.getSheetAt(3).getSheetName(), i, 11, oldContent + "\r\n" + "Skill Level: " + formCreateQuestion.getMsgSkillLevel());
							}
						}
						System.out.println("Write to file successfully");
						formCreateQuestion.clickBtnCancel();
						questionPool.clickBtnCreateQuestion();
						questionPool.clickItemTrueFalse();
						if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
							setStatusTest("pass", "Access to Create Question");
						} else {
							setStatusTest("fail", "Not Access to Create Question");
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
	
	@Test (priority = 6, enabled = false)
	public void createScenarioQuestion() throws IOException{
		TestLogger.info("Read file excel");
		int count = 1;
		int countAnswer = 0;
		String _category = "", _completionTime = "", _creator = "", _assessmentGroup = "",_product = "", _case = "", _tips = "", _questionText = "", _stageType = "", _stageName = "",_answer = "", _correctAnswer = "", _skillName = "", _skillLevel = "", _behavior = "";

		TestLogger.info("1. Login with account.");
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
		
		TestLogger.info("2. Access to Question Pool >> Select any category");
		controlBoard.clickLblQuestionPool();
		if (questionPool.isLblQuestionPoolDisplayed() == true) {
			setStatusTest("pass", "Access to Question Pool");
		} else {
			setStatusTest("fail", "Not Access to Question Pool");
		}
		TestLogger.info("3. Select category");
		questionPool.clickFirstCategory();
		if (questionPool.isFirstCategoryDisplayed() == true) {
			setStatusTest("pass", "Select category success");
		} else {
			setStatusTest("fail", "Select category NOT success");
		}
		
		TestLogger.info("4. Click  on Create Question icon >> select Single choice option ");
		questionPool.clickBtnCreateQuestion();
		questionPool.clickItemScenario();
		if (formCreateQuestion.isLblCreateQuestionDisplayed() == true) {
			setStatusTest("pass", "Access to Create Question");
		} else {
			setStatusTest("fail", "Not Access to Create Question");
		}
		try {
			wb = excelXLSX.getExcelFile("Import question template.xlsx");
			sheet = wb.getSheetAt(4);
			System.out.println("Total row: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if(count == 1){
					_category = sheet.getRow(i).getCell(0).getStringCellValue();
					if (sheet.getRow(i).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
						int compTime = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
						_completionTime = new Integer(compTime).toString();
					}else{
						_completionTime = sheet.getRow(i).getCell(1).getStringCellValue();
					}
					_creator = sheet.getRow(i).getCell(2).getStringCellValue();
					_assessmentGroup = sheet.getRow(i).getCell(3).getStringCellValue();
					_product = sheet.getRow(i).getCell(4).getStringCellValue();
					_case = sheet.getRow(i).getCell(5).getStringCellValue();
					_tips = sheet.getRow(i).getCell(6).getStringCellValue();
					_questionText = sheet.getRow(i).getCell(7).getStringCellValue();
					_stageType = sheet.getRow(i).getCell(8).getStringCellValue();
					_stageName = sheet.getRow(i).getCell(9).getStringCellValue();
					_answer = sheet.getRow(i).getCell(10).getStringCellValue();
					_correctAnswer = sheet.getRow(i).getCell(11).getStringCellValue();
					_skillName = sheet.getRow(i).getCell(12).getStringCellValue();
					if (sheet.getRow(i).getCell(13).getCellTypeEnum() == CellType.NUMERIC) {
						int sLevel = (int)sheet.getRow(i).getCell(13).getNumericCellValue();
						_skillLevel = new Integer(sLevel).toString();
					}else{
						_skillLevel = sheet.getRow(i).getCell(13).getStringCellValue();
					}
					_behavior = sheet.getRow(i).getCell(14).getStringCellValue();
					countAnswer = 0;
					TestLogger.info("Input/select data to mandatory fields: Category, Completion Time (min), Author, Assessment Group, Instruction, Question text, Answer.");
					
					formCreateQuestion.selectCategory(_category);
					formCreateQuestion.clickDrplistCompletionTime();
					formCreateQuestion.selectCompletionTime(Integer.parseInt(_completionTime));
					formCreateQuestion.fillAuthor(_creator);
					formCreateQuestion.clickDrplistPool();
					String[] arrAGroup = _assessmentGroup.split(",");
					for (String _group : arrAGroup){
						formCreateQuestion.selectPool(_group.trim());
					}
					formCreateQuestion.selectProduct(_product);
					formCreateQuestion.fillCase(_case);
					formCreateQuestion.fillInstruction(_tips);
					formCreateQuestion.fillQuestionText(sheet.getRow(i).getCell(5).getStringCellValue());
					formCreateQuestion.clickBtnQuestionInformation();
				}
				if(_questionText.equals(sheet.getRow(i).getCell(7).getStringCellValue())){
					formCreateQuestion.clickBtnAddAnswerStage1();
					formCreateQuestion.selectTypeStage1(sheet.getRow(i).getCell(8).getStringCellValue());
					countAnswer++;
					switch (countAnswer) {
					case 1:
						formCreateQuestion.fillStage(sheet.getRow(i).getCell(9).getStringCellValue());
						formCreateQuestion.clickBtnSaveStage1();
						if (formCreateQuestion.isIconEdit1Displayed() == true) {
							setStatusTest("pass", "Add Stage Name success");
						} else {
							setStatusTest("fail", "Add Stage Name NOT success");
						}
						
						formCreateQuestion.fillInputAnswer(sheet.getRow(i).getCell(10).getStringCellValue());
						if(sheet.getRow(i).getCell(11).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadioAnswerStage1();
						}
						formCreateQuestion.clickBtnSaveAnswerStage1();
						if (formCreateQuestion.isIconEdit1Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 2:
						formCreateQuestion.fillInputAnswer2(sheet.getRow(i).getCell(10).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio2();
						}
						formCreateQuestion.clickIconSave2();
					
						if (formCreateQuestion.isIconEdit2Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 3:
						formCreateQuestion.fillInputAnswerSingleChoice3(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio3();
						}
						formCreateQuestion.clickIconSave3();
					
						if (formCreateQuestion.isIconEdit3Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 4:
						formCreateQuestion.fillInputAnswerSingleChoice4(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio4();
						}
						formCreateQuestion.clickIconSave4();
					
						if (formCreateQuestion.isIconEdit4Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 5:
						formCreateQuestion.fillInputAnswerSingleChoice5(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio5();
						}
						formCreateQuestion.clickIconSave5();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 6:
						formCreateQuestion.fillInputAnswerSingleChoice6(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio6();
						}
						formCreateQuestion.clickIconSave6();
					
						if (formCreateQuestion.isIconEdit6Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 7:
						formCreateQuestion.fillInputAnswerSingleChoice7(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio7();
						}
						formCreateQuestion.clickIconSave7();
					
						if (formCreateQuestion.isIconEdit7Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 8:
						formCreateQuestion.fillInputAnswerSingleChoice8(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio8();
						}
						formCreateQuestion.clickIconSave8();
					
						if (formCreateQuestion.isIconEdit8Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 9:
						formCreateQuestion.fillInputAnswerSingleChoice9(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio9();
						}
						formCreateQuestion.clickIconSave9();
					
						if (formCreateQuestion.isIconEdit9Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 10:
						formCreateQuestion.fillInputAnswerSingleChoice10(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio10();
						}
						formCreateQuestion.clickIconSave10();
					
						if (formCreateQuestion.isIconEdit10Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 11:
						formCreateQuestion.fillInputAnswerSingleChoice11(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio11();
						}
						formCreateQuestion.clickIconSave11();
					
						if (formCreateQuestion.isIconEdit11Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 12:
						formCreateQuestion.fillInputAnswerSingleChoice12(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio12();
						}
						formCreateQuestion.clickIconSave12();
					
						if (formCreateQuestion.isIconEdit12Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 13:
						formCreateQuestion.fillInputAnswerSingleChoice13(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio13();
						}
						formCreateQuestion.clickIconSave13();
					
						if (formCreateQuestion.isIconEdit13Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 14:
						formCreateQuestion.fillInputAnswerSingleChoice14(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio14();
						}
						formCreateQuestion.clickIconSave14();
					
						if (formCreateQuestion.isIconEdit5Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					case 15:
						formCreateQuestion.fillInputAnswerSingleChoice15(sheet.getRow(i).getCell(6).getStringCellValue());
						if(sheet.getRow(i).getCell(7).getStringCellValue().equals("Yes")){
							formCreateQuestion.clickBtnRadio15();
						}
						formCreateQuestion.clickIconSave15();
					
						if (formCreateQuestion.isIconEdit15Displayed() == true) {
							setStatusTest("pass", "Add anwser success");
						} else {
							setStatusTest("fail", "Add anwser NOT success");
						}
						break;
					default:
						System.out.println("***Maximum is 15 answers for 1 single choice question***");
						break;
					}
					count = 0;
				}else{
					count = 1;
					formCreateQuestion.clickBtnSavenCreateNew();
					Thread.sleep(3000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
	}
	
	@Test (priority = 7, enabled = true)
	public void createPositionFull() throws InterruptedException, IOException {
		TestLogger.info("1. Login with account.");
		String _posType,_posName,_sttDate,_posStt,_job,_jobLevel,_site,_unit,_BU,_reportPrimary,_reportSecondary,_careerJob,_careerJobLevel,_careerPos;
		loginScreen.SignInWithoutControlBoard(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		TestLogger.info("2. Access to Position List");
		driver.navigate().to("https://wize-integration-tekdev.azurewebsites.net/Position/Index");
		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}
		TestLogger.info("3. Click on icon Add >> Input all required fields >> Click on button Save");
		try {
			wb = excelXLSX.getExcelFile("Create_New_Position.xlsx");
			sheet = wb.getSheetAt(0);
			CellStyle wrapStyle = wb.createCellStyle();
			wrapStyle.setWrapText(true);
			System.out.println("Total rows: " + (sheet.getLastRowNum()+1));
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				_posType = sheet.getRow(i).getCell(0).getStringCellValue().trim();
				if (sheet.getRow(i).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
					_posName = new Integer(_code).toString();
				}else{
					_posName = sheet.getRow(i).getCell(1).getStringCellValue().trim();
				}
				if (sheet.getRow(i).getCell(2).getCellTypeEnum() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(2))) {
			            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            _sttDate = dateFormat.format(sheet.getRow(i).getCell(2).getDateCellValue());
			        } else {
			            int _birth = (int)sheet.getRow(i).getCell(2).getNumericCellValue();
			            _sttDate = new Integer(_birth).toString();
			        }
				}else{
					_sttDate = sheet.getRow(i).getCell(2).getStringCellValue().trim();
				}
				_posStt = sheet.getRow(i).getCell(3).getStringCellValue().trim();
				if (sheet.getRow(i).getCell(4).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(4).getNumericCellValue();
					_job = new Integer(_code).toString();
				}else{
					_job = sheet.getRow(i).getCell(4).getStringCellValue().trim();
				}
				if (sheet.getRow(i).getCell(5).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(5).getNumericCellValue();
					_jobLevel = new Integer(_code).toString();
				}else{
					_jobLevel = sheet.getRow(i).getCell(5).getStringCellValue().trim();
				}
				_site = sheet.getRow(i).getCell(6).getStringCellValue().trim();
				_unit = sheet.getRow(i).getCell(7).getStringCellValue().trim();
				_BU = sheet.getRow(i).getCell(8).getStringCellValue().trim();
				_reportPrimary = sheet.getRow(i).getCell(9).getStringCellValue().trim();
				_reportSecondary = sheet.getRow(i).getCell(10).getStringCellValue().trim();
				if (sheet.getRow(i).getCell(11).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(11).getNumericCellValue();
					_careerJob = new Integer(_code).toString();
				}else{
					_careerJob = sheet.getRow(i).getCell(11).getStringCellValue().trim();
				}
				if (sheet.getRow(i).getCell(12).getCellTypeEnum() == CellType.NUMERIC) {
					int _code = (int)sheet.getRow(i).getCell(12).getNumericCellValue();
					_careerJobLevel = new Integer(_code).toString();
				}else{
					_careerJobLevel = sheet.getRow(i).getCell(12).getStringCellValue().trim();
				}
				_careerPos = sheet.getRow(i).getCell(13).getStringCellValue().trim();
				positionList.fillSearchPosition(_posName);
				if (positionList.isLinkFirstPostionDisplayed() == true) {
					positionList.deletePosition();
				}
				positionList.clickBtnCreate();
				if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
					setStatusTest("pass", "Open Create Position popup");
				} else {
					setStatusTest("fail", "Not Open Create Position popup");
				}
				formCreatePosition.inputDataFunction(_posType,_posName,_sttDate,_posStt,_job,_jobLevel,_site,_unit,_BU,_reportPrimary,_reportSecondary,_careerJob,_careerJobLevel,_careerPos);
				formCreatePosition.clickBtnSave();
				Cell cellResult = sheet.getRow(i).getCell(14);
				Cell cellReason = sheet.getRow(i).getCell(15);
				if(cellResult!= null && cellResult.getCellTypeEnum() != CellType.BLANK){
					cellResult.setCellType(CellType.BLANK);
				}
				if(cellReason!= null && cellReason.getCellTypeEnum() != CellType.BLANK){
					cellReason.setCellType(CellType.BLANK);
				}
				TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
						+ "2. Saves created Position to Position list\r\n" + "3. Redirects to Position List");
				if (formCreatePosition.isMsgSuccessDisplayed() == true) {
					TestLogger.info("Create position " + i + " successfully");
					System.out.println("Msg: " + formCreatePosition.getMsgSuccess());
					excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "PASSED");
					excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, formCreatePosition.getMsgSuccess());
					System.out.println("Write successfully to excel file");
					formCreatePosition.clickBtnNoConfirmation();
					driver.navigate().refresh();
					Thread.sleep(3000);
					positionList.fillSearchPosition(_posName);
					if (positionList.isLinkFirstPostionDisplayed() == true) {
						setStatusTest("pass", "Saves created Position to Position list");
					} else {
						setStatusTest("fail", "Not Saves created Position to Position list");
					}
					if (positionList.isLblPostionListDisplayed() == true) {
						setStatusTest("pass", "Redirects to Position List");
					} else {
						setStatusTest("fail", "Not Redirects to Position List");
					}
				} else {
					if(formCreatePosition.isMsgPositionNameDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Position Name validation");
						if(!formCreatePosition.getMsgPositionName().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, "Position Name: " + formCreatePosition.getMsgPositionName());
						}
					}
					if(formCreatePosition.isMsgJobDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Job validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgJob().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Job: " + formCreatePosition.getMsgJob());
						}
					}
					if(formCreatePosition.isMsgJobLevelDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Job Level validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgJobLevel().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Job Level: " + formCreatePosition.getMsgJobLevel());
						}
					}
					if(formCreatePosition.isMsgSiteDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Site validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgSite().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Site: " + formCreatePosition.getMsgSite());
						}
					}
					if(formCreatePosition.isMsgUnitDepartmentDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Unit Department validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgUnitDepartment().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Unit Department: " + formCreatePosition.getMsgUnitDepartment());
						}
					}
					if(formCreatePosition.isMsgBUDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Business Unit validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgBU().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Business Unit: " + formCreatePosition.getMsgBU());
						}
					}
					if(formCreatePosition.isMsgDimensionsDepartmentDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Dimensions Department validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgDimensionDepartment().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Dimensions Department: " + formCreatePosition.getMsgDimensionDepartment());
						}
					}
					if(formCreatePosition.isMsgCareerPositionDisplayed()){
						System.out.println("-------------------------------");
						System.out.println("Checking Career Position validation");
						String oldContent = sheet.getRow(i).getCell(15).getStringCellValue();
						if(!formCreatePosition.getMsgCareerPosition().equals("")){
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 14, "FAILED");
							excelXLSX.writeToCell("Create_New_Position.xlsx", sheet, wb.getSheetAt(0).getSheetName(), i, 15, oldContent + "\r\n" + "Career Position: " + formCreatePosition.getMsgCareerPosition());
						}
					}
					System.out.println("Write successfully to excel file");
					formCreatePosition.clickBtnCancel();
					Thread.sleep(1000);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wb != null){
				wb.close();
			}
		}
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}
		System.out.println("Time finish case: " + java.time.LocalTime.now());
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");
	}

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.quit();
	}
}