package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ControlBoard extends WebActions {

	public ControlBoard(WebDriver driver) {
		super(driver);
	}
	
	By lblControlBoard = By.id("label-control-board");
	
	By logo = By.id("link-home");
	
	By lblGeneralSettings = By.id("link-general-setting");
	By lblUser = By.id("link-manage-users");
	By lblRole = By.id("link-manage-roles");
	By lblFunctionSet = By.id("link-manage-function-sets");
	By lblSecurityProfile = By.id("link-manage-security-profiles");
	By lblContentManagement = By.id("link-content-manage");
	
	By lblOrganization = By.id("link-manage-oranization");
	By lblJob = By.id("link-manage-job");
	By lblJobLevel = By.id("link-manage-job-level");
	By lblPosition = By.id("link-manage-position");
	By lblSkill = By.id("link-manage-skill");
	By lblBaseLine = By.id("link-manage-baseline");
	By lblGoalLine = By.id("link-manage-goalline");
	By lblQuestionPool = By.id("link-manage-question");
	By lblAssessment = By.id("link-manager-assessment");
	By lblLearningContent = By.id("link-learning-content");
	
	static By iconControlBoard = By.id("link-control-board");
	
	public boolean isLblContentManagementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContentManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblContentManagement()
	{
		waitFluentWait(lblContentManagement);
		click(lblContentManagement);
	}
	
	public boolean isIconControlBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconControlBoard).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblRoleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblRole).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLogo()
	{
		waitFluentWait(logo);
		click(logo);
	}
	
	public void clickLblRole()
	{
		waitFluentWait(lblRole);
		click(lblRole);
		sleep(3);
	}
	
	public boolean isAvatarDisplayed()
	{
		boolean flag = false;
		try {
			sleep(1);
			if (driver.findElements(avatar).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isLblControlBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblControlBoard).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblGeneralSettingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblGeneralSettings).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblGeneralSettings()
	{
		waitFluentWait(lblGeneralSettings);
		click(lblGeneralSettings);
		sleep(3);
	}
	
	public boolean isLblSecurityProfileDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSecurityProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblSecurityProfile()
	{
		waitFluentWait(lblSecurityProfile);
		click(lblSecurityProfile);
		sleep(3);
	}
	
	public boolean isLblOrganizationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblOrganization).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblOrganization()
	{
		waitFluentWait(lblOrganization);
		click(lblOrganization);
		sleep(3);
	}
	
	public boolean isLblAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblAssessment()
	{
		waitFluentWait(lblAssessment);
		click(lblAssessment);
		sleep(3);
	}
	
	public void clickLblLearningContent()
	{
		waitFluentWait(lblLearningContent);
		click(lblLearningContent);
		sleep(3);
	}
	
	public boolean isLblLearningContentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblLearningContent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblSkillDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblSkill()
	{
		waitFluentWait(lblSkill);
		click(lblSkill);
		sleep(3);
	}
	
	public boolean isLblFunctionSetDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblFunctionSet).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblFunctionSet()
	{
		waitFluentWait(lblFunctionSet);
		click(lblFunctionSet);
		sleep(3);
	}
				
	public boolean isLblUserDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblUser).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblUser()
	{
		waitFluentWait(lblUser);
		click(lblUser);
		sleep(3);
	}
	
	public void clickLblPosition()
	{
		waitFluentWait(lblPosition);
		click(lblPosition);
		sleep(5);
	}
	
	public boolean isLblPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblGoalLine()
	{
		waitFluentWait(lblGoalLine);
		click(lblGoalLine);
		sleep(5);
	}
	
	public boolean isLblGoalLineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblGoalLine).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblQuestionPoolDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestionPool).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public void clickLblQuestionPool()
	{
		waitFluentWait(lblQuestionPool);
		click(lblQuestionPool);
		sleep(3);
	}
		
	public void clickLblBaseLine()
	{
		waitFluentWait(lblBaseLine);
		click(lblBaseLine);
		sleep(3);
	}

		
	public boolean isLblBaseLineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaseLine).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblJobLevel()
	{
		waitFluentWait(lblJobLevel);
		click(lblJobLevel);
		sleep(3);
	}
		
	public boolean isLblJobLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJobLevel).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblJob()
	{
		waitFluentWait(lblJob);
		click(lblJob);
		sleep(3);
	}
		
	public boolean isLblJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By tabMySpace = By.id("link-my-space");
	By tabDashBoard = By.id("link-dashboard");
	By tabAssessment = By.id("link-assessment-library");
	By tabTalentManagement = By.id("link-manage-talent");
	
	public void clickTabMySpace()
	{
		waitFluentWait(tabMySpace);
		click(tabMySpace);
		sleep(3);
	}
		
	public boolean isTabMySpaceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabMySpace).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabDashBoard()
	{
		waitFluentWait(tabDashBoard);
		click(tabDashBoard);
		sleep(3);
	}
		
	public boolean isTabDashBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabDashBoard).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabAssessment()
	{
		waitFluentWait(tabAssessment);
		click(tabAssessment);
		sleep(3);
	}
		
	public boolean isTabAssessmentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAssessment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabTalentManagement()
	{
		waitFluentWait(tabTalentManagement);
		click(tabTalentManagement);
		sleep(3);
	}
		
	public boolean isTabTalentManagementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabTalentManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconControlBoard()
	{
		waitFluentWait(iconControlBoard); 
		click(iconControlBoard);
	}
	
	//Logout
	By avatar = By.xpath("//span[@class='avatar']");
	By btnLogout = By.id("btnLogout");
	By btnSetting = By.xpath("//a[@title='Setting']");
	By btnSwitchProfile = By.xpath("//button[@data-bind='events:{click: openSwitchProfile}']");
		
	public void logout() {
		sleep(1);
		click(avatar);
		sleep(1);
		click(btnLogout);
		sleep(1);
	}
	
	public void clickBtnSetting()
	{
		waitFluentWait(btnSetting);
		click(btnSetting);
	}
	
	public void clickBtnSwitchProfile()
	{
		waitFluentWait(btnSwitchProfile);
		click(btnSwitchProfile);
	}
	
	public void hoverIconControlBoardSystem(){
		sleep(3);
		waitFluentWait(iconControlBoard);
		moveHoverElement(driver.findElement(iconControlBoard));
		sleep(1);
		waitFluentWait(linkSystemOnIconControlboard);
		moveHoverElement(driver.findElement(linkSystemOnIconControlboard));
	}
	
	public void hoverIconControlBoardTalent(){
		sleep(3);
		waitFluentWait(iconControlBoard);
		moveHoverElement(driver.findElement(iconControlBoard));
		sleep(1);
		waitFluentWait(linkTalentOnIconControlboard);
		moveHoverElement(driver.findElement(linkTalentOnIconControlboard));
	}
	
	public void hoverIconControlBoardLearningDevelopment(){
		sleep(3);
		waitFluentWait(iconControlBoard);
		moveHoverElement(driver.findElement(iconControlBoard));
		sleep(1);
		waitFluentWait(linkLearningDevelopmentOnIconControlboard);
		moveHoverElement(driver.findElement(linkLearningDevelopmentOnIconControlboard));
	}
	
	By linkSystemOnIconControlboard = By.xpath("//li[@id='link-control-board_system']/a");
	By linkTalentOnIconControlboard = By.xpath("//li[@id='link-control-board_talent']/a");
	By linkLearningDevelopmentOnIconControlboard = By.xpath("//li[@id='link-control-board_learning-development']/a");
	By subLinkGeneralSettingsOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'General Settings')]");
	By subLinkUserOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'User')]");
	By subLinkRoleOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'Role')]");
	By subLinkFunctionSetOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'Function Set')]");
	By subLinkSecurityProfileOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'Security Profile')]");
	By subLinkContentManagementOnIconControlBoard = By.xpath("//li[@id='link-control-board_system']//a[contains(.,'Content Management')]");
	
	public boolean isSubLinkGeneralSettingsOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkGeneralSettingsOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkUserOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkUserOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkRoleOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkRoleOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkFunctionSetOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkFunctionSetOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkSecurityProfileOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkSecurityProfileOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkContentManagementOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkSystemOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkContentManagementOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubLinkGeneralSettingsOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkGeneralSettingsOnIconControlBoard);
		click(subLinkGeneralSettingsOnIconControlBoard);
	}
	public void clickSubLinkUserOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkUserOnIconControlBoard);
		click(subLinkUserOnIconControlBoard);
	}
	public void clickSubLinkRoleOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkRoleOnIconControlBoard);
		click(subLinkRoleOnIconControlBoard);
	}
	public void clickSubLinkFunctionSetOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkFunctionSetOnIconControlBoard);
		click(subLinkFunctionSetOnIconControlBoard);
	}
	public void clickSubLinkSecurityProfileOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkSecurityProfileOnIconControlBoard);
		click(subLinkSecurityProfileOnIconControlBoard);
	}
	public void clickSubLinkContentManagementOnIconControlBoard(){
		hoverIconControlBoardSystem();
		waitFluentWait(subLinkContentManagementOnIconControlBoard);
		click(subLinkContentManagementOnIconControlBoard);
	}
	
	By subLinkOrganizationOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[contains(.,'Organization')]");
	By subLinkJobOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[text()='Job']");
	By subLinkJobLevelOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[text()='Job Level']");
	By subLinkPositionOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[contains(.,'Position')]");
	By subLinkSkillOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[contains(.,'Skill')]");
	By subLinkBaselineOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[contains(.,'Baseline')]");
	By subLinkGoalLineOnIconControlBoard = By.xpath("//li[@id='link-control-board_talent']//a[contains(.,'Goal Line')]");
	
	public boolean isSubLinkOrganizationOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkOrganizationOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubLinkJobOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkJobOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkJobLevelOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkJobLevelOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkPositionOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkPositionOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkSkillOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkSkillOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkBaselineOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkBaselineOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkGoalLineOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkGoalLineOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubLinkOrganizationOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkOrganizationOnIconControlBoard);
		click(subLinkOrganizationOnIconControlBoard);
	}
	public void clickSubLinkJobOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkJobOnIconControlBoard);
		click(subLinkJobOnIconControlBoard);
	}
	public void clickSubLinkjobLevelOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkJobLevelOnIconControlBoard);
		click(subLinkJobLevelOnIconControlBoard);
	}
	public void clickSubLinkPositionOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkPositionOnIconControlBoard);
		click(subLinkPositionOnIconControlBoard);
	}
	public void clickSubLinkSkillOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkSkillOnIconControlBoard);
		click(subLinkSkillOnIconControlBoard);
	}
	public void clickSubLinkBaselineOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkBaselineOnIconControlBoard);
		click(subLinkBaselineOnIconControlBoard);
	}
	public void clickSubLinkGoalLineOnIconControlBoard(){
		hoverIconControlBoardTalent();
		waitFluentWait(subLinkGoalLineOnIconControlBoard);
		click(subLinkGoalLineOnIconControlBoard);
	}
	
	
	By subLinkQuestionPoolOnIconControlBoard = By.xpath("//li[@id='link-control-board_learning-development']//a[text()='Question Pool']");
	By subLinkAssessmentOnIconControlBoard = By.xpath("//li[@id='link-control-board_learning-development']//a[text()='Assessment']");
	By subLinkLearningContentPoolOnIconControlBoard = By.xpath("//li[@id='link-control-board_learning-development']//a[text()='Learning Content Pool']");
	
	public boolean isSubLinkQuestionPoolOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkQuestionPoolOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkAssessmentOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkAssessmentOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isSubLinkLearningContentPoolOnIconControlBoardDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkTalentOnIconControlboard).size() > 0){
				if (driver.findElements(subLinkLearningContentPoolOnIconControlBoard).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubLinkQuestionPoolOnIconControlBoard(){
		hoverIconControlBoardLearningDevelopment();
		waitFluentWait(subLinkQuestionPoolOnIconControlBoard);
		click(subLinkQuestionPoolOnIconControlBoard);
	}
	public void clickSubLinkAssessmentOnIconControlBoard(){
		hoverIconControlBoardLearningDevelopment();
		waitFluentWait(subLinkAssessmentOnIconControlBoard);
		click(subLinkAssessmentOnIconControlBoard);
	}
	public void clickSubLinkLearningContentOnIconControlBoard(){
		hoverIconControlBoardLearningDevelopment();
		waitFluentWait(subLinkLearningContentPoolOnIconControlBoard);
		click(subLinkLearningContentPoolOnIconControlBoard);
	}
	
	By page403 = By.xpath("//h5[contains(.,'Authentication Failed')]");
	public boolean isPage403Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(page403).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By linkDashboardOnMenu = By.xpath("//li[@id='link-dashboard']/a");
	By sublinkMySkillGapOnMenu = By.xpath("//li[@id='link-dashboard_my-skill-gap']/a");
	By sublinkFrontlineManagerOnMenu = By.xpath("//li[@id='link-dashboard_front-line-manager']/a");
	By sublinkSkillAssessmentOnMenu = By.xpath("//li[@id='link-dashboard_skill-assessment']/a");
	By sublinkManagerOnMenu = By.xpath("//li[@id='link-dashboard_manager']/a");
	
	public boolean isLinkDashboardDisplayed(){
		boolean flag = isWebElementDisplayed(linkDashboardOnMenu);
		return flag;
	}
	
	public boolean isSublinkMySkillGapOnMenuDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkDashboardOnMenu).size() > 0){
				if (driver.findElements(sublinkMySkillGapOnMenu).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSublinkFrontlineManagerOnMenuDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkDashboardOnMenu).size() > 0){
				if (driver.findElements(sublinkFrontlineManagerOnMenu).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSublinkSkillAssessmentOnMenuDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkDashboardOnMenu).size() > 0){
				if (driver.findElements(sublinkSkillAssessmentOnMenu).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSublinkManagerOnMenuDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkDashboardOnMenu).size() > 0){
				if (driver.findElements(sublinkManagerOnMenu).size() > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSublinkMySkillGapOnMenu(){
		sleep(1);
		waitFluentWait(linkDashboardOnMenu);
		moveHoverElement(driver.findElement(sublinkMySkillGapOnMenu));
		waitFluentWait(sublinkMySkillGapOnMenu);
		click(sublinkMySkillGapOnMenu);
	}
	
	public void clickSublinkFrontlineManagerOnMenu(){
		sleep(1);
		waitFluentWait(linkDashboardOnMenu);
		moveHoverElement(driver.findElement(linkDashboardOnMenu));
		waitFluentWait(sublinkFrontlineManagerOnMenu);
		click(sublinkFrontlineManagerOnMenu);
	}
	
	public void clickSublinkSkillAssessmentOnMenu(){
		sleep(1);
		waitFluentWait(linkDashboardOnMenu);
		moveHoverElement(driver.findElement(linkDashboardOnMenu));
		waitFluentWait(sublinkSkillAssessmentOnMenu);
		click(sublinkSkillAssessmentOnMenu);
	}
	
	public void clickSublinkManagerOnMenu(){
		sleep(1);
		waitFluentWait(linkDashboardOnMenu);
		moveHoverElement(driver.findElement(linkDashboardOnMenu));
		waitFluentWait(sublinkManagerOnMenu);
		click(sublinkManagerOnMenu);
	}
}
