package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EmployeeDetails extends WebActions {

	public Form_EmployeeDetails(WebDriver driver) {
		super(driver);
     }
	
	By lblEmployeeDetails = By.xpath("(//div[@id='employee-detail-box']//h4)[1]");
		
	public boolean isLblEmployeeDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployeeDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
					
	By iconClose = By.xpath("//div[@id='position-assignment-details']//button[@title='Close']");
	
	public void clickIconClose()
	{
		sleep(2.5);
		waitFluentWait(iconClose);
		click(iconClose);
	}
	
	By tabData = By.xpath("(//div[@id='emp-space-tabstrip']//a)[1]");
	public boolean isTabDataDisplayed(){
		boolean flag = isWebElementDisplayed(tabData);
		return flag;
	}
	By subTabPersonal = By.xpath("//li[@id='empData-tabstrip-personal']//a");
	By subTabContract= By.xpath("//li[@id='empData-tabstrip-contract']//a");
	By subTabPosition = By.xpath("//li[@id='empData-tabstrip-position']//a");
	By subTabOrgChart = By.xpath("//li[@id='empData-tabstrip-orgChart']//a");
	public boolean isSubTabPersonalDisplayed(){
		boolean flag = isWebElementDisplayed(subTabPersonal);
		return flag;
	}
	public boolean isSubTabContractDisplayed(){
		boolean flag = isWebElementDisplayed(subTabContract);
		return flag;
	}
	public boolean isSubTabPositionDisplayed(){
		boolean flag = isWebElementDisplayed(subTabPosition);
		return flag;
	}
	public boolean isSubTabOrgChartDisplayed(){
		boolean flag = isWebElementDisplayed(subTabOrgChart);
		return flag;
	}
	public void clickSubTabPersonal(){
		waitFluentWait(subTabPersonal);
		click(subTabPersonal);
	}
	public void clickSubTabContract(){
		waitFluentWait(subTabContract);
		click(subTabContract);
	}
	public void clickSubTabPosition(){
		waitFluentWait(subTabPosition);
		click(subTabPosition);
	}
	public void clickSubTabOrgChart(){
		waitFluentWait(subTabOrgChart);
		click(subTabOrgChart);
	}
	
	// tab Position
	By titlePosition = By.xpath("//div[@id='employeePosition']//h5[@title='Position']");
	public boolean isTitlePositionDisplayed(){
		boolean flag = isWebElementDisplayed(titlePosition);
		return flag;
	}
	public void clickTitlePosition(){
		waitFluentWait(titlePosition);
		click(titlePosition);
	}
	
	By btnAssign = By.xpath("//div[@id='employeePosition']//button[@title='Assign Position']");
	public boolean isBtnAssignDisplayed(){
		boolean flag = isWebElementDisplayed(btnAssign);
		return flag;
	}
	public void clickBtnAssign(){
		waitFluentWait(btnAssign);
		click(btnAssign);
		sleep(3);
	}
	By btnDelete = By.xpath("(//div[@id='position-grid-mode']//a[@title='Delete'])[1]");
	public boolean isBtnDeleteDisplayed(){
		boolean flag = isWebElementDisplayed(btnDelete);
		return flag;
	}
	public void clickBtnDelete(){
		waitFluentWait(btnDelete);
		moveHoverElement(driver.findElement(firstLinkPosition));
		click(btnDelete);
	}
	public void clickYESConfirm(){
		By btnYES = By.xpath("//button[contains(.,'YES')]");
		waitFluentWait(btnYES);
		click(btnYES);
		sleep(1.5);
	}
	public void clickNOConfirm(){
		By btnNO = By.xpath("//button[contains(.,'NO')]");
		waitFluentWait(btnNO);
		click(btnNO);
	}
	By btnEdit = By.xpath("(//div[@id='position-grid-mode']//a[@title='Edit'])[1]");
	public boolean isBtnEditDisplayed(){
		boolean flag = isWebElementDisplayed(btnEdit);
		return flag;
	}
	public void clickBtnEdit(){
		waitFluentWait(btnEdit);
		moveHoverElement(driver.findElement(firstLinkPosition));
		click(btnEdit);
	}
	By firstLinkPosition = By.xpath("(//div[@id='position-grid-mode']//a[@class='text open-slide view-position-assignment-detail'])[1]");
	public boolean isFirstLinkClickable(){
		boolean flag = isWebElementClickable(firstLinkPosition);
		return flag;
	}
	public boolean isFirstLinkDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkPosition);
		return flag;
	}
	// form Assign Position
	By titleAssign = By.xpath("//div[@id='assign-position']//h4");
	public boolean isTitleAssignDisplayed(){
		boolean flag = isWebElementDisplayed(titleAssign);
		return flag;
	}
	By txtPosName = By.xpath("//div[@id='divPosition']/div/div");
	public void fillPosName(String posName){
		By firstItemName = By.xpath("//ul[@id='ddlPosition_listbox']/li[1]");
		waitFluentWait(txtPosName);
		ClickElementAndType(txtPosName, posName);
		sleep(1);
		waitFluentWait(firstItemName);
		click(firstItemName);
	}
	public void setStartDate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#assign-startDate').data('kendoDatePicker'); datepicker.value(new Date('2020,08,04')); datepicker.trigger('change');");
	}
	public void clickBtnSave(){
		By btnSave = By.xpath("(//div[@class='section-footer']/button[contains(.,'Save')])[2]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	// form Update Position
	public void updateStartDate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#startDateUpdate').data('kendoDatePicker'); datepicker.value(new Date('2020,08,03')); datepicker.trigger('change');");
	}
	public void clickBtnSaveUpdate(){
		By btnSave = By.xpath("(//div[@class='section-footer']/button[contains(.,'Save')])[3]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	By txtDescription = By.xpath("//textarea[@id='txtDescription']");
	public void fillDescription(String des){
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, des);
	}
	
	// work permit
	By btnAddWorkPermit = By.xpath("//div[@id='heading-Personal-Work-Permit']//button[@title='Add work permit']");
	public boolean isBtnAddWorkPermitDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddWorkPermit);
		return flag;
	}
	public boolean isBtnAddWorkPermitClickable(){
		boolean flag = isWebElementClickable(btnAddWorkPermit);
		return flag;
	}
	public void clickBtnAddWorkPermit(){
		waitFluentWait(btnAddWorkPermit);
		click(btnAddWorkPermit);
	}
	
	By lblWorkPermit = By.xpath("//div[@id='heading-Personal-Work-Permit']//button[@aria-controls='collapse-Personal-Work-Permit']");
	public boolean isLblWorkPermitDisplayed(){
		boolean flag = isWebElementDisplayed(lblWorkPermit);
		return flag;
	}
	public void clickLblAddWorkPermit(){
		waitFluentWait(lblWorkPermit);
		click(lblWorkPermit);
	}
	By txtPermitNumber = By.xpath("//input[@data-text-field='permitNumber']");
	public void searchPermitNumber(String search){
		waitFluentWait(txtPermitNumber);
		goTextOn(txtPermitNumber, search);
		sleep(3);
		clickSubTabContract();
	}
	By firstLinkWorkPermit = By.xpath("(//a[@class='text detail-workpermit'])[1]");
	public boolean isFirstLinkWorkPermitDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkWorkPermit);
		return flag;
	}
	public void clickFirstLinkWorkPermit(){
		waitFluentWait(firstLinkWorkPermit);
		click(firstLinkWorkPermit);
	}
	By btnDeleteWorkPermit = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-workpermit']");
	public boolean isBtnDeleteWorkPermitDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeleteWorkPermit);
		return flag;
	}
	public void clickBtnDeleteWorkPermit(){
		waitFluentWait(firstLinkWorkPermit);
		moveHoverElement(driver.findElement(firstLinkWorkPermit));
		waitFluentWait(btnDeleteWorkPermit);
		click(btnDeleteWorkPermit);
	}
	By btnEditWorkPermit = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-workpermit']");
	public boolean isBtnEditWorkPermitDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditWorkPermit);
		return flag;
	}
	public void clickBtnEditWorkPermit(){
		waitFluentWait(firstLinkWorkPermit);
		moveHoverElement(driver.findElement(firstLinkWorkPermit));
		waitFluentWait(btnEditWorkPermit);
		click(btnEditWorkPermit);
	}
	By txtPermitNoAddNewWorkPermit = By.xpath("//input[@id='permitNumberCreate']");
	public boolean isTxtPermitNumberAddNew(){
		boolean flag = isWebElementDisplayed(txtPermitNoAddNewWorkPermit);
		return flag;
	}
	public void fillPermitNumberAddNew(String no){
		waitFluentWait(txtPermitNoAddNewWorkPermit);
		ClickElementAndType(txtPermitNoAddNewWorkPermit, no);
	}
	public void selectCountryAddNew(String country){
		By drpCountryAddNew = By.xpath("//span[@aria-owns='issuingCountryCreate_listbox']");
		By selectedCountry = By.xpath("(//span[@title='" + country + "'])[1]");
		waitFluentWait(drpCountryAddNew);
		click(drpCountryAddNew);
		sleep(1);
		waitFluentWait(selectedCountry);
		click(selectedCountry);
	}
	public void setIssueDate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#issueDateCreate').data('kendoDatePicker'); datepicker.value(new Date('2020,08,04')); datepicker.trigger('change');");
	}
	public void selectCountryEdit(String country){
		By drpCountryEdit = By.xpath("//span[@aria-owns='issuingCountryEdit_listbox']");
		By selectedCountry = By.xpath("(//span[@title='" + country + "'])[2]");
		waitFluentWait(drpCountryEdit);
		click(drpCountryEdit);
		sleep(1);
		waitFluentWait(selectedCountry);
		click(selectedCountry);
	}
	public boolean isTitleWorkPermitDetailDisplayed(){
		By titleWorkPermitDetail = By.xpath("(//div[@id='edit-workPermits-info']//h4[@class='section-title'])[2]");
		boolean flag = isWebElementDisplayed(titleWorkPermitDetail);
		return flag;
	}
	By iconCloseWorkPermitDetail = By.xpath("(//div[@id='edit-workPermits-info']//button[@title='Close'])[2]");
	public void clickIconCloseWorkPermitDetail(){
		waitFluentWait(iconCloseWorkPermitDetail);
		click(iconCloseWorkPermitDetail);
	}
	
	// employment section
	By titleEmployment = By.xpath("//div[@id='heading-Personal-employment-1']//button[@aria-controls='collapse-Personal-employment-1']");
	public boolean isTitleEmploymentDisplayed(){
		boolean flag = isWebElementDisplayed(titleEmployment);
		return flag;
	}
	
	// contract info (left panel)
	public boolean isContractInfoDisplayed(){
		By lblEmpStatus = By.xpath("(//div[@class='text-icon-block contract-info']//span)[1]");
		By lblJoinedDate = By.xpath("(//div[@class='text-icon-block contract-info']//span)[2]");
		By lblProject = By.xpath("(//div[@class='text-icon-block contract-info']//span)[3]");
		By lblSite = By.xpath("(//div[@class='text-icon-block contract-info']//span)[4]");
		By lblPrimaryPosition = By.xpath("(//div[@class='text-icon-block contract-info']//span)[5]");
		By lblWorkLocation = By.xpath("(//div[@class='text-icon-block contract-info']//span)[6]");
		
		boolean flag = false;
		try {
			if(!isWebElementDisplayed(lblEmpStatus)&&!isWebElementDisplayed(lblJoinedDate)&&!isWebElementDisplayed(lblProject)&&!isWebElementDisplayed(lblSite)&&!isWebElementDisplayed(lblPrimaryPosition)&&!isWebElementDisplayed(lblWorkLocation)){
				flag = false;
			}else{
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	// contract section
	By titleContract = By.xpath("//div[@id='heading-Personal-employment']//button[@aria-controls='collapse-Personal-employment']");
	public boolean isTitleContractDisplayed(){
		boolean flag = isWebElementDisplayed(titleContract);
		return flag;
	}
	By txtEmpPayrollCode = By.xpath("//input[@data-text-field='employeePayrollCode']");
	public void searchEmpPayrollCode(String search){
		waitFluentWait(txtEmpPayrollCode);
		goTextOn(txtEmpPayrollCode, search);
		sleep(3);
		clickSubTabContract();
	}
	By firstLinkEmpPayrollCode = By.xpath("(//a[@class='text detail-employment'])[1]");
	public boolean isFirstLinkEmpPayrollCodeDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkEmpPayrollCode);
		return flag;
	}
	public void clickFirstLinkfirstLinkEmpPayrollCode(){
		waitFluentWait(firstLinkEmpPayrollCode);
		click(firstLinkEmpPayrollCode);
	}
	By btnDeleteEmpPayrollCode = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-employment']");
	public boolean isBtnDeleteEmpPayrollCodeDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeleteEmpPayrollCode);
		return flag;
	}
	public void clickBtnDeleteEmpPayrollCode(){
		waitFluentWait(firstLinkEmpPayrollCode);
		moveHoverElement(driver.findElement(firstLinkEmpPayrollCode));
		waitFluentWait(btnDeleteEmpPayrollCode);
		click(btnDeleteEmpPayrollCode);
	}
	By btnEditEmpPayrollCode = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-employment']");
	public boolean isBtnEditEmpPayrollCodeDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditEmpPayrollCode);
		return flag;
	}
	public void clickBtnEditEmpPayrollCode(){
		waitFluentWait(firstLinkEmpPayrollCode);
		moveHoverElement(driver.findElement(firstLinkEmpPayrollCode));
		waitFluentWait(btnEditEmpPayrollCode);
		click(btnEditEmpPayrollCode);
	}
	By btnAddContract = By.xpath("//div[@id='heading-Personal-employment']//button[@title='Add Contract']");
	public boolean isBtnAddContractDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddContract);
		return flag;
	}
	public boolean isBtnAddContractClickable(){
		boolean flag = isWebElementClickable(btnAddContract);
		return flag;
	}
	public void clickBtnAddContract(){
		waitFluentWait(btnAddContract);
		click(btnAddContract);
	}
	// add Contract form
	By titleAddContractForm = By.xpath("//div[@id='add-employment-info']//h4");
	public boolean isTitleAddContractFormDisplayed(){
		boolean flag = isWebElementDisplayed(titleAddContractForm);
		return flag;
	}
	By iconCloseAddContractForm = By.xpath("//div[@id='add-employment-info']//button[@title='Close']");
	public void clickIconCloseAddContractForm(){
		waitFluentWait(iconCloseAddContractForm);
		click(iconCloseAddContractForm);
	}
	public void fillEmpPayrollCode(String code){
		By txtPayrollCode = By.xpath("//input[@id='employeePayrollCodeCreate']");
		waitFluentWait(txtPayrollCode);
		ClickElementAndType(txtPayrollCode, code);
	}
	public void selectPayCurrency(){
		By drpPayCurrency = By.xpath("//span[@aria-owns='payCurrencyCreate_listbox']");
		By firstCurrency = By.xpath("(//ul[@id='payCurrencyCreate_listbox']//li)[1]");
		waitFluentWait(drpPayCurrency);
		click(drpPayCurrency);
		sleep(1);
		waitFluentWait(firstCurrency);
		click(firstCurrency);
	}
	public void setStartDateCreateContract(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#startDateCreate').data('kendoDatePicker'); datepicker.value(new Date('2020,08,04')); datepicker.trigger('change');");
	}
	public void setTerminationDateEditContract(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#terminationDateEdit').data('kendoDatePicker'); datepicker.value(new Date('2020,11,04')); datepicker.trigger('change');");
	}
	public void selectContractType(){
		By drpContractType = By.xpath("//span[@aria-owns='contractTypeCreate_listbox']");
		By firstContractType = By.xpath("(//ul[@id='contractTypeCreate_listbox']//li)[1]");
		waitFluentWait(drpContractType);
		click(drpContractType);
		sleep(1);
		waitFluentWait(firstContractType);
		click(firstContractType);
	}
	By titleContractDetails = By.xpath("//div[@id='edit-employment-info']//h4");
	public boolean isTitleContractDetailDisplayed(){
		boolean flag = isWebElementDisplayed(titleContractDetails);
		return flag;
	}
	By iconCloseContractDetail = By.xpath("//div[@id='edit-employment-info']//button[@title='Close']");
	public void clickIconCloseContractDetail(){
		waitFluentWait(iconCloseContractDetail);
		click(iconCloseContractDetail);
	}
	public void clickBtnSaveCreateContract(){
		By btnSave = By.xpath("(//div[@class='section-footer']/button[contains(.,'Save')])[5]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	public void clickBtnSaveUpdateContract(){
		By btnSave = By.xpath("(//div[@class='section-footer']/button[contains(.,'Save')])[6]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	
	// personal info (left panel)
	public boolean isPersonalInfoDisplayed(){
		By iconMobile = By.xpath("(//div[@class='text-icon-block']//span)[1]");
		By iconPhone = By.xpath("(//div[@class='text-icon-block']//span)[3]");
		By iconBirthday = By.xpath("(//div[@class='text-icon-block']//span)[5]");
		By iconEmail = By.xpath("(//div[@class='text-icon-block']//span)[7]");
		By iconHome = By.xpath("(//div[@class='text-icon-block']//span)[11]");
		By iconLocation = By.xpath("(//div[@class='text-icon-block']//span)[13]");
		
		boolean flag = false;
		try {
			if(!isWebElementDisplayed(iconMobile)&&!isWebElementDisplayed(iconPhone)&&!isWebElementDisplayed(iconBirthday)&&!isWebElementDisplayed(iconEmail)&&!isWebElementDisplayed(iconHome)&&!isWebElementDisplayed(iconLocation)){
				flag = false;
			}else{
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	By iconEditProfile = By.xpath("//button[@title='Edit profile']");
	public boolean isIconEditProfileClickable(){
		boolean flag = isWebElementClickable(iconEditProfile);
		return flag;
	}
	public boolean isIconEditProfileDisplayed(){
		boolean flag = isWebElementDisplayed(iconEditProfile);
		return flag;
	}
	public void clickIconEditProfile(){
		waitFluentWait(iconEditProfile);
		click(iconEditProfile);
	}
	public void fillPersonalEmail(String email){
		By txtPersonalEmail = By.xpath("//input[@id='personalEmail']");
		if(driver.findElement(txtPersonalEmail).getText().equals("")){
			waitFluentWait(txtPersonalEmail);
			ClickElementAndType(txtPersonalEmail, email);
		}else{
			waitFluentWait(txtPersonalEmail);
			ClickElementAndType(txtPersonalEmail, "a");
		}
	}
	public boolean isTitleEditProfileDisplayed(){
		By titleEditProfile = By.xpath("//div[@id='edit-profile']//h4");
		boolean flag = isWebElementDisplayed(titleEditProfile);
		return flag;
	}
	public void clickBtnSaveEditProfile(){
		By btnSave = By.xpath("(//div[@class='section-footer']/button[contains(.,'Save')])[13]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	public String getPersonalEmail(){
		By personalEmail = By.xpath("(//div[@class='text-icon-block']//span)[10]");
		String email = getText(personalEmail);
		return email;
	}
	
	// personal contact
	By lblPersonalContact = By.xpath("//div[@id='heading-Personal-Contact-Info']//button[@aria-controls='collapse-Personal-Contact-Info']");
	public boolean isLblPersonalContactDisplayed(){
		boolean flag = isWebElementDisplayed(lblPersonalContact);
		return flag;
	}
	By btnAddPersonalContact = By.xpath("//div[@id='heading-Personal-Contact-Info']//button[@title='Add contact']");
	public boolean isBtnCreatePersonalContactClickable(){
		boolean flag = isWebElementClickable(btnAddPersonalContact);
		return flag;
	}
	public boolean isBtnCreatePersonalContactDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddPersonalContact);
		return flag;
	}
	public void clickBtnAddPersonalContact(){
		waitFluentWait(btnAddPersonalContact);
		click(btnAddPersonalContact);
	}
	By txtPersonalContact = By.xpath("//input[@data-text-field='fullName']");
	public void searchPersonalContact(String search){
		waitFluentWait(txtPersonalContact);
		goTextOn(txtPersonalContact, search);
		sleep(3);
		clickSubTabPersonal();
	}
	By firstLinkPersonalContact = By.xpath("(//a[@class='text detail-contact'])[1]");
	public boolean isFirstLinkPersonalContactDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkPersonalContact);
		return flag;
	}
	public void clickFirstLinkPersonalContact(){
		waitFluentWait(firstLinkPersonalContact);
		click(firstLinkPersonalContact);
	}
	By btnDeletePersonalContact = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-contact']");
	public boolean isBtnDeletePersonalContactDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeletePersonalContact);
		return flag;
	}
	public void clickBtnDeletePersonalContact(){
		waitFluentWait(firstLinkPersonalContact);
		moveHoverElement(driver.findElement(firstLinkPersonalContact));
		waitFluentWait(btnDeletePersonalContact);
		click(btnDeletePersonalContact);
	}
	By btnEditPersonalContact = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-contact']");
	public boolean isBtnEditPersonalContactDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditPersonalContact);
		return flag;
	}
	public void clickBtnEditPersonalContact(){
		waitFluentWait(firstLinkPersonalContact);
		moveHoverElement(driver.findElement(firstLinkPersonalContact));
		waitFluentWait(btnEditPersonalContact);
		click(btnEditPersonalContact);
	}
	By txtPersonalContactName = By.xpath("//input[@id='contactPersonNameCreate']");
	public boolean isTxtPersonalContactNameDisplayed(){
		boolean flag = isWebElementDisplayed(txtPersonalContactName);
		return flag;
	}
	public void fillPersonalContactNameAddNew(String name){
		waitFluentWait(txtPersonalContactName);
		ClickElementAndType(txtPersonalContactName, name);
	}
	public void selectContactRelationshipAddNew(){
		By drpRelationshipAddNew = By.xpath("//span[@aria-owns='contactRelationship_listbox']");
		By selectedRelationship = By.xpath("(//ul[@id='contactRelationship_listbox']/li)[1]");
		waitFluentWait(drpRelationshipAddNew);
		click(drpRelationshipAddNew);
		sleep(1);
		waitFluentWait(selectedRelationship);
		click(selectedRelationship);
	}
	public boolean isTitlePersonalContactDetailDisplayed(){
		By titlePersonalContactDetail = By.xpath("//div[@id='detail-contact-info']//h4");
		boolean flag = isWebElementDisplayed(titlePersonalContactDetail);
		return flag;
	}
	By iconClosePersonalContactDetail = By.xpath("(//div[@id='detail-contact-info']//button[@title='Close'])");
	public void clickIconClosePersonalContactDetail(){
		waitFluentWait(iconClosePersonalContactDetail);
		click(iconClosePersonalContactDetail);
	}
	By txtPersonalContactNameEdit = By.xpath("//input[@id='contactPersonName']");
	public void fillPersonalContactNameEdit(String name){
		waitFluentWait(txtPersonalContactNameEdit);
		ClickElementAndType(txtPersonalContactNameEdit, name);
	}
	
	// personal identify document
	By lblPersonalDocument = By.xpath("//div[@id='heading-Employee-Identification-Doc']//button[@aria-controls='collapse-Employee-Identification-Doc']");
	public boolean isLblPersonalDocumentDisplayed(){
		boolean flag = isWebElementDisplayed(lblPersonalDocument);
		return flag;
	}
	By btnAddPersonalDocument = By.xpath("//div[@id='heading-Employee-Identification-Doc']//button[@title='Add identification document']");
	public boolean isBtnCreatePersonalDocumentClickable(){
		boolean flag = isWebElementClickable(btnAddPersonalDocument);
		return flag;
	}
	public boolean isBtnCreatePersonalDocumentDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddPersonalDocument);
		return flag;
	}
	public void clickBtnAddPersonalDocument(){
		waitFluentWait(btnAddPersonalDocument);
		click(btnAddPersonalDocument);
	}
	By txtPersonalDocumentNumber = By.xpath("//input[@data-text-field='number']");
	public void searchPersonalDocumentNumber(String search){
		waitFluentWait(txtPersonalDocumentNumber);
		goTextOn(txtPersonalDocumentNumber, search);
		sleep(3);
		clickSubTabPersonal();
	}
	By firstLinkPersonalDocument = By.xpath("(//a[@class='text detail-identification-doc'])[1]");
	public boolean isFirstLinkPersonalDocumentDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkPersonalDocument);
		return flag;
	}
	public void clickFirstLinkPersonalDocument(){
		waitFluentWait(firstLinkPersonalDocument);
		click(firstLinkPersonalDocument);
	}
	By btnDeletePersonalDocument = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-identification-doc']");
	public boolean isBtnDeletePersonalDocumentDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeletePersonalDocument);
		return flag;
	}
	public void clickBtnDeletePersonalDocument(){
		waitFluentWait(firstLinkPersonalDocument);
		moveHoverElement(driver.findElement(firstLinkPersonalDocument));
		waitFluentWait(btnDeletePersonalDocument);
		click(btnDeletePersonalDocument);
	}
	By btnEditPersonalDocument = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-identification-doc']");
	public boolean isBtnEditPersonalDocumentDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditPersonalDocument);
		return flag;
	}
	public void clickBtnEditPersonalDocument(){
		waitFluentWait(firstLinkPersonalDocument);
		moveHoverElement(driver.findElement(firstLinkPersonalDocument));
		waitFluentWait(btnEditPersonalDocument);
		click(btnEditPersonalDocument);
	}
	By txtPersonalDocumentNumberCreate = By.xpath("//input[@id='idDocCreateNumber']");
	public boolean isTxtPersonalDocumentNumberCreateDisplayed(){
		boolean flag = isWebElementDisplayed(txtPersonalDocumentNumberCreate);
		return flag;
	}
	public void fillPersonalDocumentNumberAddNew(String name){
		waitFluentWait(txtPersonalDocumentNumberCreate);
		ClickElementAndType(txtPersonalDocumentNumberCreate, name);
	}
	public void selectDocumentTypeAddNew(){
		By drpTypeAddNew = By.xpath("//span[@aria-owns='idDocCreateType_listbox']");
		By selectedType = By.xpath("(//ul[@id='idDocCreateType_listbox']/li)[1]");
		waitFluentWait(drpTypeAddNew);
		click(drpTypeAddNew);
		sleep(1);
		waitFluentWait(selectedType);
		click(selectedType);
	}
	public void selectDocumentCountryAddNew(){
		By drpCountryAddNew = By.xpath("//span[@aria-owns='idDocCreateCountry_listbox']");
		By selectedCountry = By.xpath("(//ul[@id='idDocCreateCountry_listbox']/li)[1]");
		waitFluentWait(drpCountryAddNew);
		click(drpCountryAddNew);
		sleep(1);
		waitFluentWait(selectedCountry);
		click(selectedCountry);
	}
	public void setDocumentIssueDate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#idDocCreateIssueDate').data('kendoDatePicker'); datepicker.value(new Date('2020,08,04')); datepicker.trigger('change');");
	}
	public void setDocumentExpiryDate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("var datepicker = $('#idDocCreateExpiryDate').data('kendoDatePicker'); datepicker.value(new Date('2020,11,04')); datepicker.trigger('change');");
	}
	public boolean isTitlePersonalDocumentDetailDisplayed(){
		By titlePersonalDocumentDetail = By.xpath("//div[@id='detail-identification-doc-info']//h4");
		boolean flag = isWebElementDisplayed(titlePersonalDocumentDetail);
		return flag;
	}
	By iconClosePersonalDocumentDetail = By.xpath("(//div[@id='detail-identification-doc-info']//button[@title='Close'])");
	public void clickIconClosePersonalDocumentDetail(){
		waitFluentWait(iconClosePersonalDocumentDetail);
		click(iconClosePersonalDocumentDetail);
	}
	By txtPersonalDocumentNumberEdit = By.xpath("//input[@id='idDocEditNumber']");
	public void fillPersonalDocumentNumberEdit(String name){
		waitFluentWait(txtPersonalDocumentNumberEdit);
		ClickElementAndType(txtPersonalDocumentNumberEdit, name);
	}
	public void clickBtnSaveCreateDocument(){
		By btnSave = By.xpath("//button[@id='saveIdentificationDocCreate']");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	public void clickBtnSaveEditDocument(){
		By btnSave = By.xpath("//button[@id='saveIdentificationDocEdit']");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	
	// personal education
	By lblPersonalEducation = By.xpath("//div[@id='heading-Personal-Education']//button[@aria-controls='collapse-Personal-Education']");
	public boolean isLblPersonalEducationDisplayed(){
		boolean flag = isWebElementDisplayed(lblPersonalEducation);
		return flag;
	}
	By btnAddPersonalEducation = By.xpath("//div[@id='heading-Personal-Education']//button[@title='Add education']");
	public boolean isBtnCreatePersonalEducationClickable(){
		boolean flag = isWebElementClickable(btnAddPersonalEducation);
		return flag;
	}
	public boolean isBtnCreatePersonalEducationDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddPersonalEducation);
		return flag;
	}
	public void clickBtnAddPersonalEducation(){
		waitFluentWait(btnAddPersonalEducation);
		click(btnAddPersonalEducation);
	}
	By txtPersonalEducationMajor = By.xpath("//input[@data-text-field='major']");
	public void searchPersonalEducationMajor(String search){
		waitFluentWait(txtPersonalEducationMajor);
		goTextOn(txtPersonalEducationMajor, search);
		sleep(3);
		clickSubTabPersonal();
	}
	By firstLinkPersonalEducation = By.xpath("(//a[@class='text detail-education'])[1]");
	public boolean isFirstLinkPersonalEducationDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkPersonalEducation);
		return flag;
	}
	public void clickFirstLinkPersonalEducation(){
		waitFluentWait(firstLinkPersonalEducation);
		click(firstLinkPersonalEducation);
	}
	By btnDeletePersonalEducation = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-education']");
	public boolean isBtnDeletePersonalEducationDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeletePersonalEducation);
		return flag;
	}
	public void clickBtnDeletePersonalEducation(){
		waitFluentWait(firstLinkPersonalEducation);
		moveHoverElement(driver.findElement(firstLinkPersonalEducation));
		waitFluentWait(btnDeletePersonalEducation);
		click(btnDeletePersonalEducation);
	}
	By btnEditPersonalEducation = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-education']");
	public boolean isBtnEditPersonalEducationDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditPersonalEducation);
		return flag;
	}
	public void clickBtnEditPersonalEducation(){
		waitFluentWait(firstLinkPersonalEducation);
		moveHoverElement(driver.findElement(firstLinkPersonalEducation));
		waitFluentWait(btnEditPersonalEducation);
		click(btnEditPersonalEducation);
	}
	By txtPersonalEducationUniversityCreate = By.xpath("//input[@id='instituteCreate']");
	public boolean isTxtPersonalEducationUniversityCreateDisplayed(){
		boolean flag = isWebElementDisplayed(txtPersonalEducationUniversityCreate);
		return flag;
	}
	public void fillPersonalEducationUniversityAddNew(String uni){
		waitFluentWait(txtPersonalEducationUniversityCreate);
		ClickElementAndType(txtPersonalEducationUniversityCreate, uni);
	}
	By txtPersonalEducationMajorCreate = By.xpath("//input[@id='majorCreate']");
	public void fillPersonalEducationMajorAddNew(String major){
		waitFluentWait(txtPersonalEducationMajorCreate);
		ClickElementAndType(txtPersonalEducationMajorCreate, major);
	}
	public void selectEducationLevelAddNew(){
		By drpLevelAddNew = By.xpath("//span[@aria-owns='levelCreate_listbox']");
		By selectedLevel = By.xpath("(//ul[@id='levelCreate_listbox']/li)[1]");
		waitFluentWait(drpLevelAddNew);
		click(drpLevelAddNew);
		sleep(1);
		waitFluentWait(selectedLevel);
		click(selectedLevel);
	}
	public boolean isTitlePersonalEducationDetailDisplayed(){
		By titlePersonalEducationDetail = By.xpath("//div[@id='edit-education-info']//h4");
		boolean flag = isWebElementDisplayed(titlePersonalEducationDetail);
		return flag;
	}
	By iconClosePersonalEducationDetail = By.xpath("(//div[@id='edit-education-info']//button[@title='Close'])");
	public void clickIconClosePersonalEducationDetail(){
		waitFluentWait(iconClosePersonalEducationDetail);
		click(iconClosePersonalEducationDetail);
	}
	By txtPersonalEducationMajorEdit = By.xpath("(//input[@name='Major'])[2]");
	public void fillPersonalEducationMajorEdit(String major){
		waitFluentWait(txtPersonalEducationMajorEdit);
		ClickElementAndType(txtPersonalEducationMajorEdit, major);
	}
	public void clickBtnSaveCreateEducation(){
		By btnSave = By.xpath("(//button[@id='saveEducation'])[1]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	public void clickBtnSaveEditEducation(){
		By btnSave = By.xpath("(//button[@id='saveEducation'])[2]");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	
	// personal address
	By lblPersonalAddress = By.xpath("//div[@id='heading-Personal-address']//button[@aria-controls='collapse-Personal-address']");
	public boolean isLblPersonalAddressDisplayed(){
		boolean flag = isWebElementDisplayed(lblPersonalAddress);
		return flag;
	}
	By btnAddPersonalAddress = By.xpath("//div[@id='heading-Personal-address']//button[@title='Add address']");
	public boolean isBtnCreatePersonalAddressClickable(){
		boolean flag = isWebElementClickable(btnAddPersonalAddress);
		return flag;
	}
	public boolean isBtnCreatePersonalAddressDisplayed(){
		boolean flag = isWebElementDisplayed(btnAddPersonalAddress);
		return flag;
	}
	public void clickBtnAddPersonalAddress(){
		waitFluentWait(btnAddPersonalAddress);
		click(btnAddPersonalAddress);
	}
	By txtPersonalAddressStreet = By.xpath("//input[@data-text-field='street']");
	public void searchPersonalAddressStreet(String search){
		waitFluentWait(txtPersonalAddressStreet);
		goTextOn(txtPersonalAddressStreet, search);
		sleep(3);
		clickSubTabPersonal();
	}
	By firstLinkPersonalAddress = By.xpath("(//a[@class='text detail-address'])[1]");
	public boolean isFirstLinkPersonalAddressDisplayed(){
		boolean flag = isWebElementDisplayed(firstLinkPersonalAddress);
		return flag;
	}
	public void clickFirstLinkPersonalAddress(){
		waitFluentWait(firstLinkPersonalAddress);
		click(firstLinkPersonalAddress);
	}
	By btnDeletePersonalAddress = By.xpath("//a[@title='Delete'][@class='k-button k-button-icontext k-grid-delete delete-address']");
	public boolean isBtnDeletePersonalAddressDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeletePersonalAddress);
		return flag;
	}
	public void clickBtnDeletePersonalAddress(){
		waitFluentWait(firstLinkPersonalAddress);
		moveHoverElement(driver.findElement(firstLinkPersonalAddress));
		waitFluentWait(btnDeletePersonalAddress);
		click(btnDeletePersonalAddress);
	}
	By btnEditPersonalAddress = By.xpath("//a[@title='Edit'][@class='k-button k-button-icontext k-grid-edituser edit-address']");
	public boolean isBtnEditPersonalAddressDisplayed(){
		boolean flag = isWebElementDisplayed(btnEditPersonalAddress);
		return flag;
	}
	public void clickBtnEditPersonalAddress(){
		waitFluentWait(firstLinkPersonalAddress);
		moveHoverElement(driver.findElement(firstLinkPersonalAddress));
		waitFluentWait(btnEditPersonalAddress);
		click(btnEditPersonalAddress);
	}
	By txtPersonalAddressZipCreate = By.xpath("//input[@id='postalCodeCreate']");
	public boolean isTxtPersonalAddressZipCreateDisplayed(){
		boolean flag = isWebElementDisplayed(txtPersonalAddressZipCreate);
		return flag;
	}
	public void fillPersonalAddressZipAddNew(String zip){
		waitFluentWait(txtPersonalAddressZipCreate);
		ClickElementAndType(txtPersonalAddressZipCreate, zip);
	}
	By txtPersonalAddressStreetCreate = By.xpath("//input[@id='streetCreate']");
	public void fillPersonalAddressStreetAddNew(String str){
		waitFluentWait(txtPersonalAddressStreetCreate);
		ClickElementAndType(txtPersonalAddressStreetCreate, str);
	}
	By txtPersonalAddressCityCreate = By.xpath("//input[@id='cityCreate']");
	public void fillPersonalAddressCityAddNew(String city){
		waitFluentWait(txtPersonalAddressCityCreate);
		ClickElementAndType(txtPersonalAddressCityCreate, city);
	}
	By txtPersonalAddressStateCreate = By.xpath("//input[@id='stateCreate']");
	public void fillPersonalAddressStateAddNew(String state){
		waitFluentWait(txtPersonalAddressStateCreate);
		ClickElementAndType(txtPersonalAddressStateCreate, state);
	}
	public void selectAddressTypeAddNew(){
		By drpTypeAddNew = By.xpath("//span[@aria-owns='typeCreate_listbox']");
		By selectedType = By.xpath("(//ul[@id='typeCreate_listbox']/li)[1]");
		waitFluentWait(drpTypeAddNew);
		click(drpTypeAddNew);
		sleep(1);
		waitFluentWait(selectedType);
		click(selectedType);
	}
	public void selectAddressCountryAddNew(){
		By drpCountryAddNew = By.xpath("//span[@aria-owns='countryCodeCreate_listbox']");
		By selectedCountry = By.xpath("(//ul[@id='countryCodeCreate_listbox']/li)[1]");
		waitFluentWait(drpCountryAddNew);
		click(drpCountryAddNew);
		sleep(1);
		waitFluentWait(selectedCountry);
		click(selectedCountry);
	}
	public boolean isTitlePersonalAddressDetailDisplayed(){
		By titlePersonalAddressDetail = By.xpath("//div[@id='edit-address-info']//h4");
		boolean flag = isWebElementDisplayed(titlePersonalAddressDetail);
		return flag;
	}
	By iconClosePersonalAddressDetail = By.xpath("(//div[@id='edit-address-info']//button[@title='Close'])");
	public void clickIconClosePersonalAddressDetail(){
		waitFluentWait(iconClosePersonalAddressDetail);
		click(iconClosePersonalAddressDetail);
	}
	By txtPersonalAddressStreetEdit = By.xpath("//input[@id='streetEdit']");
	public void fillPersonalAddressStreetEdit(String str){
		waitFluentWait(txtPersonalAddressStreetEdit);
		ClickElementAndType(txtPersonalAddressStreetEdit, str);
	}
	public void clickBtnSaveCreateAddress(){
		By btnSave = By.xpath("//button[@id='saveAddressTTM']");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
	public void clickBtnSaveEditAddress(){
		By btnSave = By.xpath("//button[@id='saveAddress']");
		waitFluentWait(btnSave);
		click(btnSave);
		sleep(2);
	}
}
