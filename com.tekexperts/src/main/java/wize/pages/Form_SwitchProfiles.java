package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_SwitchProfiles extends WebActions{
	public Form_SwitchProfiles(WebDriver driver) {
		super(driver);
     }

	By avatar = By.xpath("//span[@class='avatar']");
	By btnSwitchProfile = By.xpath("//button[@data-bind='events:{click: openSwitchProfile}']");
	By profile_1 = By.xpath("(//input[@type='radio'])[1]");
	By profile_2 = By.xpath("(//input[@type='radio'])[2]");
	By crown_1 = By.xpath("(//button[@data-id='id'])[1]");
	By crown_2 = By.xpath("(//button[@data-id='id'])[2]");
	By lblSwithc = By.xpath("//h5[contains(text(),'Switch Security Profile')]");
	By btnSave = By.xpath("//div[@id='Switch-Security-Profile']//button[@class='btn btn-primary'][contains(text(),'Save')]");
	
	String urlDashboard = "https://wize5ypmt3tnj4iw4.azurewebsites.net/dashboard/index?id=1";
	By verifiedDashboard = By.xpath("//h5[contains(.,'DIMENSION')]");
	String urlQuestionPool = "https://wize5ypmt3tnj4iw4.azurewebsites.net/QuestionPool/Index";
	By verifiedQuestionPool = By.xpath("//li[contains(.,'LEARNING & DEVELOPMENT - QUESTION POOL')]");
	String urlMyAssessment = "https://wize5ypmt3tnj4iw4.azurewebsites.net/AssessmentLibrary/Index?tabcode=2";
	By verifiedMyAssessment = By.xpath("//span[contains(.,'My Assessment')]");
	String urlAssessmentList = "https://wize5ypmt3tnj4iw4.azurewebsites.net/AssessmentSetting/Index";
	By verifiedAssessmentList = By.xpath("//li[contains(.,'LEARNING & DEVELOPMENT - ASSESSMENT')]");
	String urlLibrary = "https://wize5ypmt3tnj4iw4.azurewebsites.net/AssessmentLibrary/Index?tabcode=1";
	By verifiedLibrary = By.xpath("//span[contains(.,'Assessment Library')]");
	String urlJobList = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Job/Index";
	By verifiedJobList = By.xpath("//li[contains(.,'Talent - Job')]");
	String urlJobLevel = "https://wize5ypmt3tnj4iw4.azurewebsites.net/JobLevel/Index";
	By verifiedJobLevel = By.xpath("//li[contains(.,'TALENT - JOB LEVEL')]");
	String urlPosition = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Position/Index";
	By verifiedPosition = By.xpath("//li[contains(.,'TALENT - POSITION')]");
	String urlBaseline = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Baseline/Index";
	By verifiedBaseline = By.xpath("//li[contains(.,'TALENT - BASELINE MANAGEMENT')]");
	String urlDimensionList = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Organization/Index";
	By verifiedDimensionList = By.xpath("//li[contains(.,'Talent - Organization')]");
	String urlSkill = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Skill/Index";
	By verifiedSkill = By.xpath("//li[contains(.,'Talent - Skill')]");
	String urlGeneralSettings = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Configuration";
	By verifiedGeneralSettings = By.xpath("//li[contains(.,'System - General Settings')]");
	String urlSecurityProfile = "https://wize5ypmt3tnj4iw4.azurewebsites.net/SecurityProfile/Index";
	By verifiedSecurityProfile = By.xpath("//li[contains(.,'Security Profile')]");
	String urlRole = "https://wize5ypmt3tnj4iw4.azurewebsites.net/Role/Index";
	By verifiedRole = By.xpath("//li[contains(.,'System - Role')]");
	String urlFunctionSet = "https://wize5ypmt3tnj4iw4.azurewebsites.net/FunctionSet/Index";
	By verifiedFunctionSet = By.xpath("//li[contains(.,'System - Function Set')]");
	String urlUser = "https://wize5ypmt3tnj4iw4.azurewebsites.net/User/Index";
	By verifiedUser = By.xpath("//li[contains(.,'System - User')]");
	
	public void clickBtnSwitchProfile()
	{
		waitFluentWait(avatar);
		click(avatar);
		waitFluentWait(btnSwitchProfile);
		click(btnSwitchProfile);
	}
	
	public boolean isProfileChecked(By profile_xpath){
		boolean flag = false;
		try {
			if(driver.findElement(profile_xpath).getAttribute("checked") != null){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean getStatusProfile1(){
		boolean temp = false;
		try {
			if(isProfileChecked(profile_1)){
				System.out.println("Profile 1 is checked ");
				temp = true;
			}
		} catch (Exception e) {
			System.out.println("Profile 1 is un-checked ");
			return temp;
		}
		return temp;
	}
	
	public boolean isCrownChecked(By crown_xpath){
		boolean flag = false;
		try {
			if(driver.findElement(crown_xpath).getAttribute("class").equals("btn btn-xs btn-icon text-warning")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean getStatusCrown1(){
		boolean temp = false;
		try {
			if(isCrownChecked(crown_1)){
				System.out.println("Crown 1 is checked ");
				temp = true;
			}
		} catch (Exception e) {
			System.out.println("Crown 1 is un-checked ");
			return temp;
		}
		return temp;
	}
	
	public void changeProfile(){
		waitFluentWait(profile_1);
		if(isProfileChecked(profile_1)){
			click(profile_2);
		}else{
			click(profile_1);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSave();
	}
	
	public void changeCrown(){
		waitFluentWait(crown_1);
		if(isCrownChecked(crown_1)){
			click(crown_2);
		}else{
			click(crown_1);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSave();
	}
	
	public void changeProfileAndCrown() throws InterruptedException{
		waitFluentWait(profile_1);
		if(isProfileChecked(profile_1)){
			click(profile_2);
		}else{
			click(profile_1);
		}
		Thread.sleep(2000);
		waitFluentWait(crown_1);
		if(isCrownChecked(crown_1)){
			click(crown_2);
		}else{
			click(crown_1);
		}
		Thread.sleep(2000);
		clickSave();
	}
	
	public boolean isPopupDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(lblSwithc).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSave(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public boolean isElementDisplayed(By element){
		boolean flag = false;
		try {
			if (driver.findElements(element).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isDashboardAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlDashboard);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedDashboard)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isQuestionPoolAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlQuestionPool);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedQuestionPool)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMyAssessmentAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlMyAssessment);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedMyAssessment)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLibraryAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlLibrary);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedLibrary)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isJobListAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlJobList);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedJobList)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isJobLevelAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlJobLevel);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedJobLevel)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isPositionAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlPosition);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedPosition)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBaselineAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlBaseline);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedBaseline)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isDimenstionListAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlDimensionList);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedDimensionList)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSkillAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlSkill);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedSkill)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isGeneralSettingsAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlGeneralSettings);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedGeneralSettings)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSecurityProfileAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlSecurityProfile);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedSecurityProfile)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isRoleAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlRole);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedRole)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isFunctionSetAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlFunctionSet);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedFunctionSet)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isUserAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlUser);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedUser)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isAssessmentListAccessible() throws InterruptedException{
		boolean flag = false;
		driver.navigate().to(urlAssessmentList);
		Thread.sleep(3000);
		try {
			if (isElementDisplayed(verifiedAssessmentList)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
