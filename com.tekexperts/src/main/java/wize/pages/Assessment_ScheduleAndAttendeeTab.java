package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Ulties.PropertyManager;
import controller.WebActions;

public class Assessment_ScheduleAndAttendeeTab extends WebActions{

	public Assessment_ScheduleAndAttendeeTab(WebDriver driver) {
		super(driver);
	}

	By tabAssessment = By.xpath("(//div[@id='buttonTab']/button)[1]");
	By tabSchedule = By.xpath("(//div[@id='buttonTab']/button)[2]");
	By tabAttendee = By.xpath("(//div[@id='buttonTab']/button)[3]");
	By titleScheduleDetail = By.xpath("//div[@id='view-test-schedule']//h4");
	By iconXCloseScheduleDetail = By.xpath("//div[@id='view-test-schedule']//button[@data-bind='events:{click: testSettingScheduleViewViewModel.closeClick}']");
	By firstLinkSchedule = By.xpath("(//div[@id='schedule-tab-grid']//a[@class='text view-detail'])[1]"); 
	By firstLinkAssessment = By.xpath("(//div[@id='schedule-tab-grid']//a[@class='text open-slide link-test-name'])[1]");
	By titleAssessmentDetail = By.xpath("//div[@id='skillTestDetail']//h4");
	By iconXCloseAssessmentDetail = By.xpath("//div[@id='skillTestDetail']//button[@title='Close']"); 
	
	public void clickTabAssessment(){
		waitFluentWait(tabAssessment);
		click(tabAssessment);
	}
	
	public void clickTabSchedule(){
		waitFluentWait(tabSchedule);
		click(tabSchedule);
	}
	
	public void clickTabAttendee(){
		waitFluentWait(tabAttendee);
		click(tabAttendee);
	}
	
	public void clickIconXCloseScheduleDetail(){
		waitFluentWait(iconXCloseScheduleDetail);
		click(iconXCloseScheduleDetail);
	}
	
	public void clickIconXCloseAssessmentDetail(){
		sleep(1.5);
		waitFluentWait(iconXCloseAssessmentDetail);
		click(iconXCloseAssessmentDetail);
	}
	
	public void clickFirstLinkSchedule(){
		waitFluentWait(firstLinkSchedule);
		click(firstLinkSchedule);
	}
	
	public boolean isFirstLinkScheduleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstLinkSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickFirstLinkAssessment(){
		waitFluentWait(firstLinkAssessment);
		click(firstLinkAssessment);
	}
	
	public boolean isFirstLinkAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstLinkAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabAssessmentSelected(){
		boolean flag = false;
		try {
			if(driver.findElement(tabAssessment).getAttribute("class").equals("btn btn-primary")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabScheduleSelected(){
		boolean flag = false;
		try {
			if(driver.findElement(tabSchedule).getAttribute("class").equals("btn btn-primary")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabAttendeeSelected(){
		boolean flag = false;
		try {
			if(driver.findElement(tabAttendee).getAttribute("class").equals("btn btn-primary")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTitleScheduleDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleScheduleDetail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTitleAssessmentDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleAssessmentDetail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By txtSearchScheduleName = By.xpath("//div[@id='schedule-tab-grid']//input[@aria-label='Schedule Name']");
	public void searchScheduleName(String search){
		waitFluentWait(txtSearchScheduleName);
		click(txtSearchScheduleName);
		goTextOn(txtSearchScheduleName, search);
		sleep(2);
	}	
	
	public String getAssessmentName(){
		String assessmentName = "";
		try {
			if(driver.findElement(firstLinkAssessment).getText() != null){
				assessmentName = driver.findElement(firstLinkAssessment).getText();
			}
		} catch (Exception e) {
			return assessmentName;
		}
		return assessmentName;
	}
	
	By iconCalendarStartDate = By.xpath("//span[@data-field='startDate']//span[@role='button']");
	By todayStartDate = By.xpath("(//a[@class='k-link k-nav-today'])[1]");
	By startDateTable = By.xpath("(//div[@id='schedule-tab-grid']//td[4])[1]");
	By iconCalendarEndDate = By.xpath("//span[@data-field='endDate']//span[@role='button']");
	By todayEndDate = By.xpath("(//a[@class='k-link k-nav-today'])[2]");
	By endDateTable = By.xpath("(//div[@id='schedule-tab-grid']//td[5])[1]");
	By txtEndDate = By.xpath("//input[@aria-label='End Date'][1]");
	By titleAttendeeList = By.xpath("//section[@id='sectionStatistic']//h4/span/span");
	By btnCloseAttendeeList = By.xpath("//div[@id='assessement-trainee-schedule']//button[@class='btn btn-icon close-slide']");
	By firstScheduleStatus = By.xpath("(//div[@id='schedule-tab-grid']//td[7]/span)[1]");
	By drpStatus = By.xpath("(//span[@data-field='statusCode']//span[@aria-label='select'])[1]");
	By iconLinkFirstCancelSchedule = By.xpath("(//a[@title='Cancel'])[1]");
	By iconLinkFirstEditSchedule = By.xpath("(//a[@title='Edit Schedule'])[1]");
	By iconLinkFirstAssignAttendee = By.xpath("(//a[@title='Assign Attendee'])[1]");
	By iconLinkFirstViewAttendeeList = By.xpath("(//a[@id='link-attendee'])[1]");
	
	public void filterAttendee(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var attendee = $(" + '"' + "#schedule-tab-grid tr.k-filter-row input[data-role='numerictextbox']" + '"' + ").data('kendoNumericTextBox'); attendee.value(1); attendee.trigger('change');");
	}
	
	public void clickCloseAttendeeList(){
		waitFluentWait(btnCloseAttendeeList);
		click(btnCloseAttendeeList);
	}
	
	public boolean isIconLinkFirstCancelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconLinkFirstCancelSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconLinkFirstCancel(){
		moveHoverElement(driver.findElement(firstLinkSchedule));
		sleep(1);
		waitFluentWait(iconLinkFirstCancelSchedule);
		click(iconLinkFirstCancelSchedule);
		sleep(2);
	}
	
	public boolean isIconLinkFirstEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconLinkFirstEditSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconLinkFirstEdit(){
		moveHoverElement(driver.findElement(firstLinkSchedule));
		sleep(1);
		waitFluentWait(iconLinkFirstEditSchedule);
		click(iconLinkFirstEditSchedule);
		sleep(2);
	}
	
	public boolean isIconLinkFirstAssignAttendeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconLinkFirstAssignAttendee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconLinkFirstAssignAttendee(){
		moveHoverElement(driver.findElement(firstLinkSchedule));
		sleep(1);
		waitFluentWait(iconLinkFirstAssignAttendee);
		click(iconLinkFirstAssignAttendee);
		sleep(2);
	}
	
	public boolean isIconLinkFirstViewAttendeeListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconLinkFirstViewAttendeeList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconCancelEnable(){
		boolean flag = false;
		try {
			click(iconLinkFirstCancelSchedule);
			flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEditEnable(){
		boolean flag = false;
		try { 
			click(iconLinkFirstEditSchedule);
			flag = true;
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconAssignEnable(){
		boolean flag = false;
		try { 
			click(iconLinkFirstAssignAttendee);
			flag = true;
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconAttendeeListEnable(){
		boolean flag = false;
		try { 
			click(iconLinkFirstViewAttendeeList);
			flag = true;
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconLinkFirstViewAttendeeList(){
		moveHoverElement(driver.findElement(firstLinkSchedule));
		sleep(1);
		waitFluentWait(iconLinkFirstViewAttendeeList);
		click(iconLinkFirstViewAttendeeList);
		sleep(2);
	}
	
	public boolean isTitleAttendeeListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(titleAttendeeList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public String getFirstScheduleStatus(){
		String sttSchedule = "";
		try {
			if(driver.findElement(firstScheduleStatus).getText() != null){
				sttSchedule = driver.findElement(firstScheduleStatus).getText();
			}
		} catch (Exception e) {
			return sttSchedule;
		}
		return sttSchedule;
	}
	
	public String getStartDate(){
		String sDate = "";
		try {
			if(driver.findElement(startDateTable).getText() != null){
				sDate = driver.findElement(startDateTable).getText();
			}
		} catch (Exception e) {
			return sDate;
		}
		return sDate;
	}
	public boolean checkFormatStartDate(String date){
		boolean checkFormat;
		if (date.matches("([0-9]{2}) ([A-Z]{1})([a-z]{2}) ([0-9]{4})"))
		    checkFormat=true;
		else
		   checkFormat=false;
		return checkFormat;
	}
	
	public void clickIconCalendarStartDate(){
		waitFluentWait(iconCalendarStartDate);
		click(iconCalendarStartDate);
	}
	
	public boolean isTodayStartDateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(todayStartDate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTodayStartDate(){
		waitFluentWait(todayStartDate);
		click(todayStartDate);
		sleep(2);
	}
	
	public String getEndDate(){
		String sDate = "";
		try {
			if(driver.findElement(endDateTable).getText() != null){
				sDate = driver.findElement(endDateTable).getText();
			}
		} catch (Exception e) {
			return sDate;
		}
		return sDate;
	}
	public boolean checkFormatEndDate(String date){
		boolean checkFormat;
		if (date.matches("([0-9]{2}) ([A-Z]{1})([a-z]{2}) ([0-9]{4})"))
		    checkFormat=true;
		else
		   checkFormat=false;
		return checkFormat;
	}
	
	public void clickIconCalendarEndDate(){
		waitFluentWait(iconCalendarEndDate);
		click(iconCalendarEndDate);
	}
	
	public boolean isTodayEndDateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(todayEndDate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTodayEndDate(){
		waitFluentWait(todayEndDate);
		click(todayEndDate);
		sleep(2);
	}
	
	public void filterEndDate(){
		waitFluentWait(txtEndDate);
		goTextOn(txtEndDate, "31 Jan 2021");
		sleep(2);
	}
	
	By btnClearStartDate = By.xpath("(//span[@data-field='startDate']//button[@title='Clear'])[1]");
	By btnClearEndDate = By.xpath("(//span[@data-field='endDate']//button[@title='Clear'])[1]");
	public void clickClearStartDate(){
		waitFluentWait(btnClearStartDate);
		click(btnClearStartDate);
		sleep(2);
	}
	public void clickClearEndDate(){
		waitFluentWait(btnClearEndDate);
		click(btnClearEndDate);
		sleep(2);
	}
	
	
	public boolean isListStatusCorrect(){
		boolean flag = false;
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='k-animation-container']//ul[@data-role='staticlist'])[3]/li"));
		String stt1 = list.get(0).getText();
		String stt2 = list.get(1).getText();
		String stt3 = list.get(2).getText();
		String stt4 = list.get(3).getText();
		String stt5 = list.get(4).getText();
		String stt6 = list.get(5).getText();
		try {
			if(list.size() == 6){
				if(stt1.equals("Cancelled") && stt2.equals("Completed") && stt3.equals("Failed") && stt4.equals("In Progress") && stt5.equals("Scheduled") && stt6.equals("Under Review")){
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickDrpStatus(){
		waitFluentWait(drpStatus);
		click(drpStatus);
		sleep(1);
	}
	
	public String getTooltipEditIcon(){
		String tooltip = "";
		try {
			if(driver.findElement(iconLinkFirstEditSchedule).getAttribute("title") != null){
				tooltip = driver.findElement(iconLinkFirstEditSchedule).getAttribute("title");
			}
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
	
	public boolean compareTooltipEditIcon(){
		boolean flag = false;
		try {
			if(getTooltipEditIcon().equals("Edit Schedule")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public String getTooltipCancelIcon(){
		String tooltip = "";
		try {
			if(driver.findElement(iconLinkFirstCancelSchedule).getAttribute("title") != null){
				tooltip = driver.findElement(iconLinkFirstCancelSchedule).getAttribute("title");
			}
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
	
	public boolean compareTooltipCancelIcon(){
		boolean flag = false;
		try {
			if(getTooltipCancelIcon().equals("Cancel")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public String getTooltipAssignAttendeeIcon(){
		String tooltip = "";
		try {
			if(driver.findElement(iconLinkFirstAssignAttendee).getAttribute("title") != null){
				tooltip = driver.findElement(iconLinkFirstAssignAttendee).getAttribute("title");
			}
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
	
	public boolean compareTooltipAssignAttendeeIcon(){
		boolean flag = false;
		try {
			if(getTooltipAssignAttendeeIcon().equals("Assign Attendee")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public String getTooltipViewAttendeeListIcon(){
		String tooltip = "";
		try {
			if(driver.findElement(iconLinkFirstViewAttendeeList).getAttribute("title") != null){
				tooltip = driver.findElement(iconLinkFirstViewAttendeeList).getAttribute("title");
			}
		} catch (Exception e) {
			return tooltip;
		}
		return tooltip;
	}
	
	public boolean compareTooltipViewAttendeeListIcon(){
		boolean flag = false;
		try {
			if(getTooltipViewAttendeeListIcon().equals("Assign Attendee")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnSaveEditSchedule = By.id("btnScheduleEditSave");
	By btnCancelEditSchedule = By.id("btnScheduleEditCancel");
	public boolean isBtnSaveEditScheduleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnSaveEditSchedule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickBtnCancelEditSchedule(){
		waitFluentWait(btnCancelEditSchedule);
		click(btnCancelEditSchedule);
	}
	
	By btnFilterPopupAssign = By.xpath("//button[contains(.,'Filter')]");
	By btnCancelPopupAssign = By.xpath("(//div[@class='modal-footer']/button[1])[9]");
	public boolean isBtnFilterAssignDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnFilterPopupAssign).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickBtnCancelPopupAssign(){
		waitFluentWait(btnCancelPopupAssign);
		click(btnCancelPopupAssign);
	}
	
	By confirmContentPopup = By.xpath("//div[@id='dialogCancelSchedule']");
	public String getConfirmationPopupContent(){
		String content = "";
		try {
			if(driver.findElement(confirmContentPopup).getText() != null){
				content = driver.findElement(confirmContentPopup).getText();
			}
		} catch (Exception e) {
			return content;
		}
		return content;
	}
	
	public boolean compareConfirmationPopupContent(){
		boolean flag = false;
		try {
			if(getConfirmationPopupContent().equals("Are you sure you want to cancel the selected schedule? Please be informed that your action is irreversible.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnNoConfirmationCancelSchedule = By.xpath("//button[contains(.,'NO')]");
	By btnYesConfirmationCancelSchedule = By.xpath("//button[contains(.,'YES')]");
	public void clickBtnNOCancelSchedule(){
		waitFluentWait(btnNoConfirmationCancelSchedule);
		click(btnNoConfirmationCancelSchedule);
	}
	public void clickBtnYESCancelSchedule(){
		waitFluentWait(btnYesConfirmationCancelSchedule);
		click(btnYesConfirmationCancelSchedule);
		sleep(2.5);
	}
	
	// Define element of Attendee tab
	By attendee_firstLinkScheduleName = By.xpath("(//div[@id='attendee-tab-grid']//a[@class='text view-detail'])[1]");
	By attendee_firstLinkAssessmentName = By.xpath("(//div[@id='attendee-tab-grid']//a[@class='text open-slide link-test-name'])[1]");
	By attendee_firstFullName = By.xpath("(//div[@id='attendee-tab-grid']//span[@class='user-name'])[1]");
	By attendee_txtSearchScheduleName = By.xpath("//div[@id='attendee-tab-grid']//input[@aria-label='Schedule Name']");
	By attendee_firstEmail = By.xpath("(//div[@id='attendee-tab-grid']//td[6]/span)[1]");
	By attendee_firstPosition = By.xpath("(//div[@id='attendee-tab-grid']//td[7]/span)[1]");
	By attendee_firstStatus = By.xpath("(//div[@id='attendee-tab-grid']//td[8]/span)[1]");
	
	public void clickAttendee_firstLinkScheduleName(){
		waitFluentWait(attendee_firstLinkScheduleName);
		click(attendee_firstLinkScheduleName);
	}
	
	public void clickAttendee_firstLinkAssessmentName(){
		waitFluentWait(attendee_firstLinkAssessmentName);
		click(attendee_firstLinkAssessmentName);
	}
	
	public String attendee_getFullName(){
		String fullName = getTextWebElement(attendee_firstFullName);
		return fullName;
	}
	
	public String attendee_getAssessmentName(){
		String assName = getTextWebElement(attendee_firstLinkAssessmentName);
		return assName;
	}
	
	public String attendee_getEmailAttendee(){
		String email = getTextWebElement(attendee_firstEmail);
		return email;
	}
	
	public String attendee_getPosition(){
		String position = getTextWebElement(attendee_firstPosition);
		return position;
	}
	
	public String attendee_getStatus(){
		String stt = getTextWebElement(attendee_firstStatus);
		return stt;
	}
	
	public boolean compareFullName(){
		boolean flag = false;
		try {
			if(attendee_getFullName().equals(PropertyManager.fullNameAdmin1)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void attendee_searchScheduleName(String search){
		waitFluentWait(attendee_txtSearchScheduleName);
		click(attendee_txtSearchScheduleName);
		goTextOn(attendee_txtSearchScheduleName, search);
		sleep(2);
	}
	
	public boolean compare_attendee_assessmentName(String assessmentName){
		boolean flag = false;
		try {
			if(attendee_getAssessmentName().equals(assessmentName)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean compare_attendee_Email(){
		boolean flag = false;
		try {
			if(attendee_getEmailAttendee().equals(PropertyManager.EmailAdmin1)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean compare_attendee_Position(){
		boolean flag = false;
		try {
			if(attendee_getPosition().equals(PropertyManager.primaryPosition)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean compare_attendee_Status(){
		boolean flag = false;
		try {
			if(attendee_getStatus().equals("Scheduled")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By attendee_drpStatus = By.xpath("//span[@data-field='statusCode']//div[@role='listbox']");
	
	public void click_attendeeDrpStatus(){
		waitFluentWait(attendee_drpStatus); 
		click(attendee_drpStatus);
		sleep(1.5);
	}
	public boolean attendee_isListStatusCorrect(){
		boolean flag = false;
		String stt1, stt2, stt3, stt4, stt5, stt6, stt7, stt8, stt9, stt10, stt11, stt12;
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='k-animation-container']//ul[@data-role='staticlist'])[3]/li"));
		System.out.println(list.size());
		stt1 = list.get(0).getText();
		stt2 = list.get(1).getText();
		stt3 = list.get(2).getText();
		stt4 = list.get(3).getText();
		stt5 = list.get(4).getText();
		stt6 = list.get(5).getText();
		stt7 = list.get(6).getText();
		stt8 = list.get(7).getText();
		stt9 = list.get(8).getText();
		stt10 = list.get(9).getText();
		stt11 = list.get(10).getText();
		stt12 = list.get(11).getText();
		try {
			if(list.size() == 12){
				if(stt1.equals("Approved") && stt2.equals("Cancelled") && stt3.equals("Completed") && stt4.equals("Expired") && stt5.equals("Incomplete") && stt6.equals("In Progress") && stt7.equals("Interrupted") && stt8.equals("Paused") && stt9.equals("Pending for Approval") && stt10.equals("Rejected") && stt11.equals("Scheduled") && stt12.equals("Under Review")){
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By attendee_txtFilterStatus = By.xpath("(//div[@id='attendee-tab-grid']//input[@aria-label='Status'])[1]");
	By attendee_iconViewResult = By.xpath("(//div[@id='attendee-tab-grid']//a[@title='View Assessment Report'])[1]");
	By attendee_firstAssessment = By.xpath("(//div[@id='attendee-tab-grid']//a[@class='text open-slide link-test-name'])[1]");
	
	public void attendee_filterStatus(String value){
		waitFluentWait(attendee_txtFilterStatus);
		click(attendee_txtFilterStatus);
		goTextOn(attendee_txtFilterStatus, value);
		sleep(2);
	}
	
	public boolean attendee_isIconViewResultDisplay(){
		boolean flag = isWebElementClickable(attendee_iconViewResult);
		return flag;
	}
	
	public boolean attendee_isFirstAssessmentDisplayed(){
		boolean flag = isWebElementDisplayed(attendee_firstAssessment);
		return flag;
	}
	
	By statusViewResult = By.xpath("//h3[contains(.,'COMPLETED!')]");
	By iconCloseViewResult = By.xpath("//button[@data-bind='click:skillTestResultVM.closeSkillTestReport']");
	By attendee_btnClearFilterScheduleName = By.xpath("(//span[@data-field='scheduleName']//button[@title='Clear'])[1]");
	By attendee_btnClearStatus = By.xpath("(//span[@data-field='statusCode']//span[@title='Clear'])[1]");
	public boolean isStatusViewResultDisplayed(){
		boolean flag = isWebElementDisplayed(statusViewResult);
		return flag;
	}
	public void clickIconCloseViewResult(){
		waitFluentWait(iconCloseViewResult);
		click(iconCloseViewResult);
	}
	public void attendee_clickBtnClearFilterScheduleName(){
		waitFluentWait(attendee_btnClearFilterScheduleName);
		click(attendee_btnClearFilterScheduleName);
	}
	public void attendee_clickBtnClearFilterStatus(){
		waitFluentWait(attendee_btnClearStatus);
		click(attendee_btnClearStatus);
	}
	
	By btnCreateAssessment = By.xpath("(//div[@id='testSetting-viewmodel']//a/i[@class='icon icon-plus3'])[2]");
	public boolean attendee_isBtnCreateAssessmentDisplay(){
		boolean flag = isWebElementClickable(btnCreateAssessment);
		return flag;
	}
}
