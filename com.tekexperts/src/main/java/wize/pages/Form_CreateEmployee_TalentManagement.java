package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Ulties.TestLogger;
import controller.WebActions;

public class Form_CreateEmployee_TalentManagement extends WebActions{

	public Form_CreateEmployee_TalentManagement(WebDriver driver) {
		super(driver);
	}

	By titleCreateEmployeeProfile = By.xpath("//div[@id='create-employee']//h4");
	By iconX = By.xpath("//div[@id='create-employee']//button[@title='Close']");
	By btnCancel = By.xpath("//div[@id='create-employee']//button[@id='cancelEmployee']");
	By btnSaveCreateNew = By.xpath("//div[@id='create-employee']//button[@id='saveCreateNew']");
	By btnSave = By.xpath("//div[@id='create-employee']//button[@id='saveEmployee']");
	
	By txtFirstName = By.xpath("//input[@id='firstName']");
	By txtMiddleName = By.xpath("//input[@id='middleName']");
	By txtLastName = By.xpath("//input[@id='lastName']");
	
	By drpGender = By.xpath("//span[@aria-owns='gender_listbox']");
	By firstItemGender = By.xpath("//div[@id='gender-list']//li[2]");
	
	By drpTitle = By.xpath("//span[@aria-owns='title_listbox']");
	By firstItemTitle = By.xpath("//div[@id='title-list']//li[2]");
	By drpCountryOfWork = By.xpath("//span[@aria-owns='countryOfWork_listbox']");
	By drpCountryOfResident = By.xpath("//span[@aria-owns='countryOfResidence_listbox']");
	
	By drpMobilePhone = By.xpath("(//div[@aria-owns='country-listbox'])[1]");
	By txtMobilePhone = By.xpath("//input[@id='mobilePhone']");
	By drpHomePhone = By.xpath("(//div[@aria-owns='country-listbox'])[2]");
	By txtHomePhone = By.xpath("//input[@id='homePhone']");
	
	By txtCompanyEmailAccount = By.xpath("//input[@id='companyEmail']");
	By drpEmploymentStatus = By.xpath("//span[@aria-owns='status_listbox']");
	By secondItemStatus = By.xpath("//div[@id='status-list']//li[2]");
	
	By txtPersonalEmailAccount = By.xpath("//input[@id='personalEmail']");
	By drpDefaultSProfile = By.xpath("//span[@aria-owns='securityProfile_listbox']");
	By secondItemSProfile = By.xpath("//div[@id='securityProfile-list']//li[2]");
	
	By txtPositionName = By.xpath("(//div[@id='divPosition'])[1]");
	By firstItemPosition = By.xpath("//ul[@id='positionList_listbox']/li[1]");
	
	By iconCalendarStartDate = By.xpath("//span[@aria-controls='startDate_dateview']/span");
	By todayCalendar = By.xpath("//a[@class='k-link k-nav-today']");
	By btnPrimary = By.xpath("//input[@id='primary']");
	By btnAutoCreate = By.xpath("//input[@id='autoCreateUser']");
	public void fillFirstName(String fName){
		waitFluentWait(txtFirstName);
		ClickElementAndType(txtFirstName, fName);
	}
	public void fillMiddleName(String mName){
		waitFluentWait(txtMiddleName);
		ClickElementAndType(txtMiddleName, mName);
	}
	public void fillLastName(String lName){
		waitFluentWait(txtLastName);
		ClickElementAndType(txtLastName, lName);
	}
	public void setBirthdayOriginal(String birth)
	{
		if(!birth.equals("")){
			String[] birthday = birth.split("-");
			String month = birthday[1];
			int month1 = Integer.parseInt(month)-1;
			month = String.valueOf(month1);
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("var datepicker = $('#birthday').data('kendoDatePicker'); datepicker.value(new Date(" + birthday[0] + "," +  month + "," + birthday[2] + ")); datepicker.trigger('change');");
		}
	}
	
	public void selectGender(){
		waitFluentWait(drpGender);
		click(drpGender);
		sleep(1);
		waitFluentWait(firstItemGender);
		click(firstItemGender);
	}
	
	public void selectGenderOriginal(String gender){
		if(!gender.equals("")){
			By selectedGender = By.xpath("//div[@id='gender-list']//li[contains(., '" + gender + "')]");
			waitFluentWait(drpGender);
			click(drpGender);
			sleep(1);
			waitFluentWait(selectedGender);
			click(selectedGender);
		}
	}
	public void selectTitle(){
		waitFluentWait(drpTitle);
		click(drpTitle);
		sleep(1);
		waitFluentWait(firstItemTitle);
		click(firstItemTitle);
	}
	public void selectTitleOriginal(String title){
		if(!title.equals("")){
			By selectedTitle = By.xpath("(//div[@id='title-list']//li[contains(., '" + title + "')])[1]");
			waitFluentWait(drpTitle);
			click(drpTitle);
			sleep(1);
			waitFluentWait(selectedTitle);
			click(selectedTitle);
		}
	}
	public void selectCountryOfWork(String countryWork){
		if(!countryWork.equals("")){
			By selectedCountry = By.xpath("//ul[@id='countryOfWork_listbox']//li[contains(., '" + countryWork + "')]");
			waitFluentWait(drpCountryOfWork);
			click(drpCountryOfWork);
			sleep(1);
			waitFluentWait(selectedCountry);
			click(selectedCountry);
		}
	}
	public void selectCountryOfResidence(String countryRes){
		if(!countryRes.equals("")){
			By selectedCountry = By.xpath("//ul[@id='countryOfResidence_listbox']//li[contains(., '" + countryRes + "')]");
			waitFluentWait(drpCountryOfResident);
			click(drpCountryOfResident);
			sleep(1);
			waitFluentWait(selectedCountry);
			click(selectedCountry);
		}
	}
	public void selectMobilePhone(String phone){
		if(!phone.equals("")){
			By areaMobilePhone = By.xpath("(//div[@aria-owns='country-listbox'])[1]");
			By txtMobilePhone = By.xpath("//input[@id='mobilePhone']");
			String[] p = phone.split("-");
			String areaCode = p[0].replace("(", "");
			String areaCode1 = areaCode.replace(")", "");
			String finalCode = areaCode1.trim();
			By selectedAreaMobilePhone = By.xpath("(//ul[@id='country-listbox']//span[@class='iti__dial-code'][contains(.,'" + finalCode + "')])[1]");
			waitFluentWait(areaMobilePhone);
			click(areaMobilePhone);
			sleep(1);
			try {
				waitFluentWait(selectedAreaMobilePhone);
				click(selectedAreaMobilePhone);
				waitFluentWait(txtMobilePhone);
				ClickElementAndType(txtMobilePhone, p[1]);
			} catch (Exception e) {
				e.printStackTrace();
				TestLogger.info("CANNOT SET MOBILEPHONE");
			} 
		}
	}
	public void selectHomePhone(String phone){
		if(!phone.equals("")){
			By areaHomePhone = By.xpath("(//div[@aria-owns='country-listbox'])[2]");
			By txtHomePhone = By.xpath("//input[@id='homePhone']");
			String[] p = phone.split("-");
			String areaCode = p[0].replace("(", "");
			String areaCode1 = areaCode.replace(")", "");
			String finalCode = areaCode1.trim();
			By selectedAreaHomePhone = By.xpath("((//div[@class='form-group'])[4]//span[@class='iti__dial-code'][contains(.,'" + finalCode + "')])[1]");
			waitFluentWait(areaHomePhone);
			click(areaHomePhone);
			sleep(1);
			try {
				waitFluentWait(selectedAreaHomePhone);
				click(selectedAreaHomePhone);
				waitFluentWait(txtHomePhone);
				ClickElementAndType(txtHomePhone, p[1]);
			} catch (Exception e) {
				e.printStackTrace();
				TestLogger.info("CANNOT SET HOMEPHONE");
			} 
		}
	}
	
	public void setEmployeeCode(String empCode){
		By txtEmpCode = By.xpath("(//input[contains(@data-bind,'value: createEmployeeVM.employeeInfo.employeeCode')])[1]");
		if(isWebElementClickable(txtEmpCode)){
			waitFluentWait(txtEmpCode);
			ClickElementAndType(txtEmpCode, empCode);
		}else{
			System.out.println("Employee Code is not EDITABLE");
		}
	}
	public void fillCompanyEmail(String email){
		waitFluentWait(txtCompanyEmailAccount);
		ClickElementAndType(txtCompanyEmailAccount, email);
	}
	public void selectEmploymentStatus(){
		waitFluentWait(drpEmploymentStatus);
		click(drpEmploymentStatus);
		sleep(1);
		waitFluentWait(secondItemStatus);
		click(secondItemStatus);
	}
	public void selectEmploymentStatusOriginal(String stt){
		if(!stt.equals("")){
			By selectedStatus = By.xpath("//div[@id='status-list']//li[contains(.,'" + stt + "')]");
			waitFluentWait(drpEmploymentStatus);
			click(drpEmploymentStatus);
			sleep(1);
			waitFluentWait(selectedStatus);
			click(selectedStatus);
		}
	}
	public void fillPersonalEmail(String email){
		waitFluentWait(txtPersonalEmailAccount);
		ClickElementAndType(txtPersonalEmailAccount, email);
	}
	public void selectSecurityProfile(){
		waitFluentWait(drpDefaultSProfile);
		click(drpDefaultSProfile);
		sleep(1);
		waitFluentWait(secondItemSProfile);
		click(secondItemSProfile);
	}
	
	public boolean isFirstItemPositionDisplayed(){
		boolean flag = isWebElementDisplayed(firstItemPosition);
		return flag;
	}
	public void selectPositionName(String positionName){
		waitFluentWait(txtPositionName);
		ClickElementAndType(txtPositionName, positionName);
		sleep(2);
		if(isFirstItemPositionDisplayed()){
			waitFluentWait(firstItemPosition);
			click(firstItemPosition);
			sleep(3);
		}
		else{
			ClickElementAndType(txtPositionName, Keys.chord(Keys.CONTROL, "a"));
			ClickElementAndTypeKeys(txtPositionName, Keys.BACK_SPACE);
			ClickElementAndType(txtPositionName, "test DP");
			sleep(2);
			waitFluentWait(firstItemPosition);
			click(firstItemPosition);
			sleep(3);
			clickBtnSave();
		}
	}
	
	public void selectPositionNameOriginal(String positionName){
		if(!positionName.equals("")){
			waitFluentWait(txtPositionName);
			ClickElementAndType(txtPositionName, positionName);
			sleep(2);
			if(isFirstItemPositionDisplayed()){
				waitFluentWait(firstItemPosition);
				click(firstItemPosition);
				sleep(3);
			}
		}
	}
	public void setStartDateOriginal(String date)
	{
		if(!date.equals("")){
			String[] startDate = date.split("-");
			String month = startDate[1];
			int month1 = Integer.parseInt(month)-1;
			month = String.valueOf(month1);
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("var datepicker = $('#startDate').data('kendoDatePicker'); datepicker.value(new Date(" + startDate[0] + "," +  month + "," + startDate[2] + ")); datepicker.trigger('change');");
		}
	}
	public void setEndDateOriginal(String date)
	{
		if(!date.equals("")){
			String[] endDate = date.split("-");
			String month = endDate[1];
			int month1 = Integer.parseInt(month)-1;
			month = String.valueOf(month1);
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("var datepicker = $('#endDate').data('kendoDatePicker'); datepicker.value(new Date(" + endDate[0] + "," +  month + "," + endDate[2] + ")); datepicker.trigger('change');");
		}
	}
	public boolean isStartDateDisplayed(){
		boolean flag = driver.findElement(iconCalendarStartDate).isDisplayed();
		return flag;
	}
	
	public void selectStartDate(){
		sleep(2);
		waitFluentWait(iconCalendarStartDate);
		click(iconCalendarStartDate);
		sleep(1);
		waitFluentWait(todayCalendar);
		click(todayCalendar);
		sleep(2);
	}
	
	By drpStartReason = By.xpath("//span[@aria-owns='startReason_listbox']");
	public void selectStartReasonOriginal(String reason){
		if(!reason.equals("")){
			By selectedStartReason = By.xpath("//ul[@id='startReason_listbox']//li/span[@title='" + reason + "']");
			waitFluentWait(drpStartReason);
			click(drpStartReason);
			sleep(1);
			waitFluentWait(selectedStartReason);
			click(selectedStartReason);
		}
	}
	public boolean isStartReasonDisplayed(){
		boolean flag = isWebElementClickable(drpStartReason);
		if(flag){
			waitFluentWait(drpStartReason);
			click(drpStartReason);
		}
		return flag;
	}
	public void setPrimary(String pri){
		scrollToElement(driver.findElement(btnPrimary));
		if(pri.equalsIgnoreCase("YES")){
			waitFluentWait(btnPrimary);	
			ClickElement(btnPrimary);
		}
	}
	public void setAutoCreate(String auto){
		scrollToElement(driver.findElement(btnAutoCreate));
		if(auto.equalsIgnoreCase("NO")){
			waitFluentWait(btnAutoCreate);	
			ClickElement(btnAutoCreate);
		}
	}
	
	public void inputFullData(String fName,String mName,String lName,String email1, String email2,String positionName){
		fillFirstName(fName);
		fillMiddleName(mName);
		fillLastName(lName);
		selectGender();
		selectTitle();
		fillCompanyEmail(email1);
		selectEmploymentStatus();
		fillPersonalEmail(email2);
		selectPositionName(positionName);
		selectStartDate();
//		setPrimary();
		clickBtnSaveCreateNew();
	}
	
	public void inputFullDataOriginal(String fName,String mName,String lName,String birthday,String gender,String title,String countryWork, String countryRes,String mobilePhone, String homePhone,String empCode,String email1,String stt, String email2,String positionName,String startDate,String endDate,String startReason,String primary,String autoCreate){
		fillFirstName(fName);
		fillMiddleName(mName);
		fillLastName(lName);
		setBirthdayOriginal(birthday);
		selectGenderOriginal(gender);
		selectTitleOriginal(title);
		selectCountryOfWork(countryWork);
		selectCountryOfResidence(countryRes);
		selectMobilePhone(mobilePhone);
		selectHomePhone(homePhone);
		setEmployeeCode(empCode);
		fillCompanyEmail(email1);
		selectEmploymentStatusOriginal(stt);
		fillPersonalEmail(email2);
		selectPositionNameOriginal(positionName);
		clickBtnSave();
		if(isStartReasonDisplayed()){
			setStartDateOriginal(startDate);
			setEndDateOriginal(endDate);
			selectStartReasonOriginal(startReason);
			setPrimary(primary);
			setAutoCreate(autoCreate);
		}
		clickBtnSaveCreateNew();
	}
	
	public void clickBtnSave(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	public void clickBtnSaveCreateNew(){
		waitFluentWait(btnSaveCreateNew);
		click(btnSaveCreateNew);
	}
	public void clickBtnCancel(){
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	By msgFirstName = By.xpath("//span[@id='firstName_validationMessage']");
	By msgLastName = By.xpath("//span[@id='lastName_validationMessage']");
	By msgGender = By.xpath("//span[@id='gender_validationMessage']");
	By msgTitle = By.xpath("//span[@id='title_validationMessage']");
	By msgCompanyEmail = By.xpath("//span[@id='companyEmail_validationMessage']");
	By msgEmpStatus = By.xpath("//span[@id='status_validationMessage']");
	By msgPersonalemail = By.xpath("//span[@id='personalEmail_validationMessage']");
	By msgPositionName = By.xpath("//span[@id='positionList_validationMessage']");
	By msgStartDate = By.xpath("//span[@id='startDate_validationMessage']");
	
	public boolean isMsgFirstNameDisplayed(){
		boolean flag = isWebElementDisplayed(msgFirstName);
		return flag;
	}
	
	public boolean isMsgLastNameDisplayed(){
		boolean flag = isWebElementDisplayed(msgLastName);
		return flag;
	}
	public boolean isMsgGenderDisplayed(){
		boolean flag = isWebElementDisplayed(msgGender);
		return flag;
	}
	public boolean isMsgTitleDisplayed(){
		boolean flag = isWebElementDisplayed(msgTitle);
		return flag;
	}
	
	public boolean isMsgCompanyEmailDisplayed(){
		boolean flag = isWebElementDisplayed(msgCompanyEmail);
		return flag;
	}
	
	public boolean isMsgEmpStatusDisplayed(){
		boolean flag = isWebElementDisplayed(msgEmpStatus);
		return flag;
	}
	
	public boolean isMsgPersonalemailDisplayed(){
		boolean flag = isWebElementDisplayed(msgPersonalemail);
		return flag;
	}
	
	public boolean isMsgPositionNameDisplayed(){
		boolean flag = isWebElementDisplayed(msgPositionName);
		return flag;
	}
	
	public boolean isMsgStartDateDisplayed(){
		boolean flag = isWebElementDisplayed(msgStartDate);
		return flag;
	}
	
	public String getMsgFirstName(){
		String msg = driver.findElement(msgFirstName).getText();
		return msg;
	}
	public String getMsgLastName(){
		String msg = driver.findElement(msgLastName).getText();
		return msg;
	}
	public String getMsgGender(){
		String msg = driver.findElement(msgGender).getText();
		return msg;
	}
	public String getMsgTitle(){
		String msg = driver.findElement(msgTitle).getText();
		return msg;
	}
	public String getMsgCompanyEmail(){
		String msg = driver.findElement(msgCompanyEmail).getText();
		return msg;
	}
	public String getMsgEmpStatus(){
		String msg = driver.findElement(msgEmpStatus).getText();
		return msg;
	}
	public String getMsgPersonalemail(){
		String msg = driver.findElement(msgPersonalemail).getText();
		return msg;
	}
	public String getMsgPositionName(){
		String msg = driver.findElement(msgPositionName).getText();
		return msg;
	}
	public String getMsgStartDate(){
		String msg = driver.findElement(msgStartDate).getText();
		return msg;
	}
}
