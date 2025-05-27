package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreatePosition extends WebActions {

	public Form_CreatePosition(WebDriver driver) {
		super(driver);
     }

	By lblCreatePosition = By.id("label-create-position");
	
	By drplistDimension = By.id("(//div[@id='add-position']//section//form//div/div/div/div)[1]");
	By itemBusinessUnit = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Business Unit')]");
	By itemCountry = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Country')]");
	By itemProduct = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Product')]");
	By itemProject = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Project')]");
	By itemRegion = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Region')]");
	By itemSite = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Site')]");
	By itemTeam = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Team')]");
	By itemUnitDepartment = By.xpath("//ul[@id='dimension_listbox']//li[contains(.,'Unit/Department')]");

	By drplistUnit = By.xpath("//div[@id='divUnit']/div/span");
	By txtSearchUnit = By.xpath("(//div[@id='ddlUnit-list']/span/input)");
	By txtSearchUnitTurn2 = By.xpath("(//div[@id='ddlUnit-list']/span/input)[2]");
	By txtSearchUnitTurn3 = By.xpath("(//div[@id='ddlUnit-list']/span/input)[3]");
	By firstItemUnit = By.xpath("(//ul[@id='ddlUnit_listbox']/li)[1]");
	By firstItemUnitTurn2 = By.xpath("(//ul[@id='ddlUnit_listbox']/li[1])[2]");
	By firstItemUnitTurn3 = By.xpath("(//ul[@id='ddlUnit_listbox']/li[1])[3]");
			
	By drplistJob = By.id("ddlJob");
	By txtSearchJob = By.xpath("//div[@id='ddlJob-list']/span/input");
	By firstItemJob = By.xpath("(//ul[@id='ddlJob_listbox']/li)[1]");
	
	By drplistLevel = By.id("ddlJobLevel");
	By firstItemLevel = By.xpath("//ul[@id='ddlJobLevel_listbox']/li[1]");
		
	By txtPositionName = By.id("txtPositionName");
	
	By btnCancel = By.id("btn-cancel");
	By btnSavenCreateNew = By.id("btn-save-create-new");
	By btnSave = By.id("btn-save");
		
	public boolean isLblCreatePositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreatePosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectDimension()
    {
	   sleep(3);
	   driver.findElement(By.xpath("(//div[@id='add-position']//section//form//div/div/div/div)[1]")).click();
       waitFluentWait(itemBusinessUnit);
       click(itemBusinessUnit);
       sleep(2);
       click(lblCreatePosition);
    }

	public void selectUnit(String search,By txtSearch, By firstBU)
	{
		if(!search.equals("")){
			waitFluentWait(drplistUnit);
			click(drplistUnit);
			sleep(3);
			ClickElementAndType(txtSearch, search);
			sleep(2);
		    driver.findElement(firstBU).click();
		}
	}
	
	By drplistSite = By.xpath("//div[@id='divSite']/div/span");
	public void selectSite(String search)
	{
		if(!search.equals("")){
			By txtSearchSite = By.xpath("(//div[@id='ddlSite-list']/span/input)");
			By firstItemSite = By.xpath("(//ul[@id='ddlSite_listbox']/li)[1]");
			waitFluentWait(drplistSite);
			click(drplistSite);
			sleep(3);
			ClickElementAndType(txtSearchSite, search);
			sleep(2);
		    driver.findElement(firstItemSite).click();
		}
	}
	
	By drplistBusinessUnit = By.xpath("//div[@id='divBusinessUnit']/div/span");
	public void selectBusinessUnit(String search)
	{
		if(!search.equals("")){
			By txtSearchBusinessUnit = By.xpath("(//div[@id='ddlBusinessUnit-list']/span/input)");
			By firstItemBusinessUnit = By.xpath("(//ul[@id='ddlBusinessUnit_listbox']/li)[1]");
			waitFluentWait(drplistBusinessUnit);
			click(drplistBusinessUnit);
			sleep(3);
			ClickElementAndType(txtSearchBusinessUnit, search);
			sleep(2);
		    driver.findElement(firstItemBusinessUnit).click();
		}
	}
	
	public void selectSiteUnit(String searchSite,String searchUnit){
		By drplistSite = By.xpath("//div[@id='divSite']/div/span");
		By txtSearchSite = By.xpath("(//div[@id='ddlSite-list']/span/input)");
		By firstItemSite = By.xpath("(//ul[@id='ddlSite_listbox']/li)[1]");
		By drplistUnit = By.xpath("//div[@id='divUnit']/div/span");
		By txtSearchUnit = By.xpath("(//div[@id='ddlUnit-list']/span/input)[1]");
		By firstItemUnit = By.xpath("(//ul[@id='ddlUnit_listbox']/li[1])[1]");
		if(!searchSite.equals("")){
			waitFluentWait(drplistSite);
			click(drplistSite);
			sleep(3);
			ClickElementAndType(txtSearchSite, searchSite);
			sleep(2);
		    driver.findElement(firstItemSite).click();
		}
		if(!searchUnit.equals("")){
			waitFluentWait(drplistUnit);
			click(drplistUnit);
			sleep(3);
			ClickElementAndType(txtSearchUnit, searchUnit);
			sleep(2);
		    driver.findElement(firstItemUnit).click();
		}
	}
	
	public void selectJob(String search)
	{
		if(!search.equals("")){
			waitFluentWait(drplistJob);
			clickByJavaScript(drplistJob);
			sleep(3);
			ClickElementAndType(txtSearchJob, search);
			sleep(2);
			waitFluentWait(firstItemJob);
			click(firstItemJob);
		}
	}
	
	public void selectLevel()
	{
		waitFluentWait(drplistLevel);
		clickByJavaScript(drplistLevel);
		waitFluentWait(firstItemLevel);
		click(firstItemLevel);
	}
	
	public void fillPositionName(String positionname)
	{
		if(!positionname.equals("")){
			waitFluentWait(txtPositionName);
			goTextOn(txtPositionName, positionname);
		}
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnSavenCreateNew()
	{
		waitFluentWait(btnSavenCreateNew);
		click(btnSavenCreateNew);
		sleep(3);
	}
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
		
	public void inputData(String positionname,String search,String search1)
	{
		fillPositionName(positionname);
//		selectDimension();
		selectJob(search);
		selectLevel();
		selectUnit(search1,txtSearchUnit,firstItemUnit);
	}
	public void inputDataFunction(String type,String positionname,String cDate,String posStt,String job,String joblevel,String searchSite,String searchUnit, String searchBU,String reportPri,String reportSec,String careerJob,String careerJobLevel,String careerPosition)
	{
		selectPositionType(type);
		fillPositionName(positionname);
		setCreatedDate(cDate);
		selectPosStatus(posStt);
		selectJob(job);
		sleep(2);
		selectJobLevel(joblevel);
		if(searchSite.equals("") && searchBU.equals("") && !searchUnit.equals("")){
			selectUnit(searchUnit,txtSearchUnit,firstItemUnit);
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,1);
			selectCareerPathJobLevel(careerJobLevel,1);
			selectCareerPathPosition(careerPosition,1);
		}else if(searchUnit.equals("") && searchBU.equals("") && !searchSite.equals("")){
			selectSite(searchSite);
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,3);
			selectCareerPathJobLevel(careerJobLevel,2);
			selectCareerPathPosition(careerPosition,2);
		}else if(searchSite.equals("") && searchUnit.equals("") && !searchBU.equals("")){
			selectBusinessUnit(searchBU);
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,1);
			selectCareerPathJobLevel(careerJobLevel,1);
			selectCareerPathPosition(careerPosition,1);
		}else if(!searchSite.equals("") && !searchUnit.equals("") && searchBU.equals("")){
			selectSiteUnit(searchSite, searchUnit);
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,1);
			selectCareerPathJobLevel(careerJobLevel,1);
			selectCareerPathPosition(careerPosition,1);
		}else if(searchSite.equals("") && searchUnit.equals("") && searchBU.equals("") && isWebElementDisplayed(drplistSite) && !isWebElementDisplayed(drplistUnit) && !isWebElementDisplayed(drplistBusinessUnit)){
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,3);
			selectCareerPathJobLevel(careerJobLevel,2);
			selectCareerPathPosition(careerPosition,2);
		}else{
			selectReportPrimary(reportPri);
			selectReportSecondary(reportSec);
			selectCareerPathJob(careerJob,1);
			selectCareerPathJobLevel(careerJobLevel,1);
			selectCareerPathPosition(careerPosition,1);
		}
	}
	
	public void inputDataTurn2(String positionname,String search,String search1)
	{
		fillPositionName(positionname);
		selectJob(search);
		selectLevel();
		selectUnit(search1,txtSearchUnitTurn2,firstItemUnitTurn2);
	}
	
	public void inputDataTurn3(String positionname,String search,String search1)
	{
		fillPositionName(positionname);
		selectJob(search);
		selectLevel();
		selectUnit(search1,txtSearchUnitTurn3,firstItemUnitTurn3);
	}
	
	By txtReportToPersonPrimary = By.xpath("//div[@id='divReportPrimary']");
	By firstItemReportPrimary = By.xpath("(//ul[@id='ddlReportPrimary_listbox']/li)[1]"); 
	By txtReportToPersonSecondary = By.xpath("//div[@id='divReportSecondary']");
	By firstItemReportSecondary = By.xpath("(//ul[@id='ddlReportSecondary_listbox']/li)[1]");
	public boolean isFirstItemReportPrimaryDisplayed(){
		boolean flag = isWebElementDisplayed(firstItemReportPrimary);
		return flag;
	}
	public boolean isFirstItemReportSecondaryDisplayed(){
		boolean flag = isWebElementDisplayed(firstItemReportSecondary);
		return flag;
	}
	public void selectReportPrimary(String positionName){
		if(!positionName.equals("")){
			waitFluentWait(txtReportToPersonPrimary);
			ClickElementAndType(txtReportToPersonPrimary, positionName);
			sleep(2);
			if(isFirstItemReportPrimaryDisplayed()){
				waitFluentWait(firstItemReportPrimary);
				click(firstItemReportPrimary);
				sleep(3);
			}
		}
	}
	public void selectReportSecondary(String positionName){
		if(!positionName.equals("")){
			waitFluentWait(txtReportToPersonSecondary);
			ClickElementAndType(txtReportToPersonSecondary, positionName);
			sleep(2);
			if(isFirstItemReportPrimaryDisplayed()){
				waitFluentWait(firstItemReportSecondary);
				click(firstItemReportSecondary);
				sleep(3);
			}
		}
	}
	public void selectCareerPathJob(String job, int unit){
		By drpCareerPathJob = By.xpath("((//ul[@data-template='careerPathTemplate'])[2]//span[@role='listbox'])[1]");
		By txtCareerPathJobSearch = By.xpath("(//span[@class='k-list-filter']//input[contains(@aria-owns,'job')])[" + unit + "]");
		By firstItemCareerPathJob = By.xpath("//span[@title='" + job + "']");
		if(!job.equals("")){
			scrollToElement(driver.findElement(drpCareerPathJob));
			waitFluentWait(drpCareerPathJob);
			click(drpCareerPathJob);
			sleep(1);
			waitFluentWait(txtCareerPathJobSearch);
			ClickElementAndType(txtCareerPathJobSearch, job);
			waitFluentWait(firstItemCareerPathJob);
			click(firstItemCareerPathJob);
		}
	}
	public void selectCareerPathJobLevel(String jobLevel, int unit){
		By drpCareerPathJobLevel = By.xpath("((//ul[@data-template='careerPathTemplate'])[2]//span[@role='listbox'])[2]");
		By txtCareerPathJobLevelSearch = By.xpath("(//span[@class='k-list-filter']//input[contains(@aria-owns,'jobLevel')])[" + unit + "]");
		By firstItemCareerPathJobLevel = By.xpath("//span[@title='" + jobLevel + "']");
		if(!jobLevel.equals("")){
			waitFluentWait(drpCareerPathJobLevel);
			click(drpCareerPathJobLevel);
			sleep(1);
			waitFluentWait(txtCareerPathJobLevelSearch);
			ClickElementAndType(txtCareerPathJobLevelSearch, jobLevel);
			waitFluentWait(firstItemCareerPathJobLevel);
			click(firstItemCareerPathJobLevel);
		}
	}
	public void selectCareerPathPosition(String pos, int unit){
		By drpCareerPathPosition = By.xpath("((//ul[@data-template='careerPathTemplate'])[2]//span[@role='listbox'])[3]");
		By txtCareerPathPositionSearch = By.xpath("(//span[@class='k-list-filter']//input[contains(@aria-owns,'position')])[" + unit + "]");
		By firstItemCareerPathPosition = By.xpath("//span[@title='" + pos + "']");
		if(!pos.equals("")){
			waitFluentWait(drpCareerPathPosition);
			click(drpCareerPathPosition);
			sleep(1);
			waitFluentWait(txtCareerPathPositionSearch);
			ClickElementAndType(txtCareerPathPositionSearch, pos);
			waitFluentWait(firstItemCareerPathPosition);
			click(firstItemCareerPathPosition);
		}
	}
	public void selectPositionType(String type){
		By drpPosType = By.xpath("//span[@aria-owns='positionType_listbox']");
		By itemEmployee = By.xpath("//ul[@id='positionType_listbox']/li[1]");
		By itemManager = By.xpath("//ul[@id='positionType_listbox']/li[2]");
		if(!type.equals("")){
			waitFluentWait(drpPosType);
			click(drpPosType);
			sleep(1);
			if(type.equalsIgnoreCase("Employee")){
				waitFluentWait(itemEmployee);
				click(itemEmployee);
			}else if(type.equalsIgnoreCase("Manager")){
				waitFluentWait(itemManager);
				click(itemManager);
			}else{
				System.out.println("Please provide correct Position Type");
			}
		}
	}
	public void setCreatedDate(String createdDate)
	{
		if(!createdDate.equals("")){
			String[] setDate = createdDate.split("-");
			String month = setDate[1];
			int month1 = Integer.parseInt(month)-1;
			month = String.valueOf(month1);
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("var datepicker = $('#positionDate').data('kendoDatePicker'); datepicker.value(new Date(" + setDate[0] + "," +  month + "," + setDate[2] + ")); datepicker.trigger('change');");
		}
	}
	public void selectPosStatus(String stt){
		By drpPosStatus = By.xpath("//span[@aria-owns='ddlPositionStatus_listbox']");
		By itemActiveVacant = By.xpath("//ul[@id='ddlPositionStatus_listbox']/li[1]");
		By itemFrozen = By.xpath("//ul[@id='ddlPositionStatus_listbox']/li[2]");
		By itemInActive = By.xpath("//ul[@id='ddlPositionStatus_listbox']/li[3]");
		if(!stt.equals("")){
			waitFluentWait(drpPosStatus);
			click(drpPosStatus);
			sleep(1);
			if(stt.equalsIgnoreCase("Active-Vacant")){
				waitFluentWait(itemActiveVacant);
				click(itemActiveVacant);
			}else if(stt.equalsIgnoreCase("Frozen")){
				waitFluentWait(itemFrozen);
				click(itemFrozen);
			}else if(stt.equalsIgnoreCase("In-Active")){
				waitFluentWait(itemInActive);
				click(itemInActive);
			}else{
				System.out.println("Please provide correct Position Status");
			}
		}
	}
	public void selectJobLevel(String jobLevel)
	{
		By txtSearchJobLevel = By.xpath("//input[@aria-owns='ddlJobLevel_listbox']");
		if(!jobLevel.equals("")){
			waitFluentWait(drplistLevel);
			clickByJavaScript(drplistLevel);
			waitFluentWait(txtSearchJobLevel);
			ClickElementAndType(txtSearchJobLevel, jobLevel);
			sleep(1.5);
			waitFluentWait(firstItemLevel);
			click(firstItemLevel);
		}
	}
	By msgSuccess = By.xpath("(//div[@id='dialogCreateBox']//b)[1]");
	public boolean isMsgSuccessDisplayed(){
		boolean flag = isWebElementDisplayed(msgSuccess);
		return flag;
	}
	public String getMsgSuccess(){
		String msg = driver.findElement(msgSuccess).getText();
		return msg;
	}
	By btnYesConfirmation = By.xpath("//div[@class='k-dialog-buttongroup k-dialog-button-layout-normal']//button[1]");
	By btnNoConfirmation = By.xpath("//div[@class='k-dialog-buttongroup k-dialog-button-layout-normal']//button[2]");
	public void clickBtnYesConfirmation(){
		waitFluentWait(btnYesConfirmation);
		click(btnYesConfirmation);
	}
	public void clickBtnNoConfirmation(){
		waitFluentWait(btnNoConfirmation);
		click(btnNoConfirmation);
	}
	By msgPositionName = By.xpath("//span[@id='PositionName_validationMessage']");
	By msgJob = By.xpath("//span[@id='ddlJob_validationMessage']");
	By msgJobLevel = By.xpath("//span[@id='ddlJobLevel_validationMessage']");
	By msgSite = By.xpath("//span[@id='ddlSite_validationMessage']");
	By msgUnitDepartment = By.xpath("//span[@id='ddlUnit_validationMessage']");
	By msgBU = By.xpath("//span[@id='ddlBusinessUnit_validationMessage']");
	By msgDimensionDepartment = By.xpath("//span[@id='dimension_validationMessage']");
	By msgCareerPosition = By.xpath("(//span[contains(@id,'position')])[1]");
	
	public boolean isMsgPositionNameDisplayed(){
		boolean flag = isWebElementDisplayed(msgPositionName);
		return flag;
	}
	public boolean isMsgJobDisplayed(){
		boolean flag = isWebElementDisplayed(msgJob);
		return flag;
	}
	public boolean isMsgJobLevelDisplayed(){
		boolean flag = isWebElementDisplayed(msgJobLevel);
		return flag;
	}
	public boolean isMsgSiteDisplayed(){
		boolean flag = isWebElementDisplayed(msgSite);
		return flag;
	}
	public boolean isMsgUnitDepartmentDisplayed(){
		boolean flag = isWebElementDisplayed(msgUnitDepartment);
		return flag;
	}
	public boolean isMsgBUDisplayed(){
		boolean flag = isWebElementDisplayed(msgBU);
		return flag;
	}
	public boolean isMsgDimensionsDepartmentDisplayed(){
		boolean flag = isWebElementDisplayed(msgDimensionDepartment);
		return flag;
	}
	public boolean isMsgCareerPositionDisplayed(){
		boolean flag = isWebElementDisplayed(msgCareerPosition);
		return flag;
	}
	public String getMsgPositionName(){
		String msg = "";
		try {
			msg = driver.findElement(msgPositionName).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgJob(){
		String msg = "";
		try {
			msg = driver.findElement(msgJob).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgJobLevel(){
		String msg = "";
		try {
			msg = driver.findElement(msgJobLevel).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgSite(){
		String msg = "";
		try {
			msg = driver.findElement(msgSite).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgUnitDepartment(){
		String msg = "";
		try {
			msg = driver.findElement(msgUnitDepartment).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgDimensionDepartment(){
		String msg = "";
		try {
			msg = driver.findElement(msgDimensionDepartment).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgBU(){
		String msg = "";
		try {
			msg = driver.findElement(msgBU).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	public String getMsgCareerPosition(){
		String msg = "";
		try {
			msg = driver.findElement(msgCareerPosition).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
}
