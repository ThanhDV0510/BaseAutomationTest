package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class LandingPage extends WebActions {

	public LandingPage(WebDriver driver) {
		super(driver);
     }
	
	By tabMyPersonalProfile = By.xpath("(//div[@id='main']//span)[1]");
	By tabMyDashboard = By.xpath("(//div[@id='main']//span)[2]");
	By tabMyAssessment = By.xpath("(//div[@id='main']//span)[3]");
	By tabMySkillMap = By.xpath("(//div[@id='main']//span)[4]");
	By tabMyCareerPath = By.xpath("(//div[@id='main']//span)[5]");
	By tabMyContribution = By.xpath("(//div[@id='main']//span)[6]");
	
	public void clickTabMyPersonalProfile()
	{
		waitFluentWait(tabMyPersonalProfile);
		click(tabMyPersonalProfile);
		sleep(3);
	}
	
	public void clickTabMyDashboard()
	{
		waitFluentWait(tabMyDashboard);
		click(tabMyDashboard);
		sleep(3);
	}
	
	public void clickTabMyAssessment()
	{
		waitFluentWait(tabMyAssessment);
		click(tabMyAssessment);
		sleep(3);
	}
	
	public void clickTabMySkillMap()
	{
		waitFluentWait(tabMySkillMap);
		click(tabMySkillMap);
		sleep(3);
	}
	
	public void clickTabMyCareerPath()
	{
		waitFluentWait(tabMyCareerPath);
		click(tabMyCareerPath);
		sleep(3);
	}
	
	public void clickTabMyContribution()
	{
		waitFluentWait(tabMyContribution);
		click(tabMyContribution);
		sleep(3);
	}
	
	By lblMyPersonalProfile = By.xpath("(//section[@id='my-personal-profile']//b)[2]");
	By btnViewMyProfile = By.xpath("//section[@id='my-personal-profile']//a");
	
	public boolean isLblMyPersonalProfileDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyPersonalProfile).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnViewMyProfile()
	{
		waitFluentWait(btnViewMyProfile);
		click(btnViewMyProfile);
		sleep(3);
	}
	
	By lblMyDashboard = By.xpath("//section[@id='my-dashboard']//b");
	By btnViewMyDashboard = By.xpath("//section[@id='my-dashboard']//a");
	
	public boolean isLblMyDashboardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyDashboard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnViewMyDashboard()
	{
		waitFluentWait(btnViewMyDashboard);
		click(btnViewMyDashboard);
		sleep(3);
	}
	
	By lblMyAssessments = By.xpath("//section[@id='my-assessments']//b");
	By btnCompleteAnAssessment = By.xpath("//section[@id='my-assessments']//a");
	
	public boolean isLblMyAssessmentsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyAssessments).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCompleteAnAssessment()
	{
		waitFluentWait(btnCompleteAnAssessment);
		click(btnCompleteAnAssessment);
		sleep(3);
	}
	
	By lblMySkillMap = By.xpath("//section[@id='my-skills-map']//b");
	By btnViewMySkill360 = By.xpath("//section[@id='my-skills-map']//div[2]/div//a[1]");
	By btnViewMySkill = By.xpath("//section[@id='my-skills-map']//div[2]/div//a[2]");
	
	public boolean isLblMySkillMapDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMySkillMap).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnViewMySkill360()
	{
		waitFluentWait(btnViewMySkill360);
		click(btnViewMySkill360);
		sleep(3);
	}
	
	public void clickBtnViewMySkill()
	{
		waitFluentWait(btnViewMySkill);
		click(btnViewMySkill);
		sleep(3);
	}
	
	By lblMyCareerPath = By.xpath("//section[@id='my-career-path']//b");
	By btnViewMyCareerPath = By.xpath("//section[@id='my-career-path']//a");
	
	public boolean isLblMyCareerPathDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyCareerPath).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnViewMyCareerPath()
	{
		waitFluentWait(btnViewMyCareerPath);
		click(btnViewMyCareerPath);
		sleep(3);
	}
	
	By lblMyContribution = By.xpath("//section[@id='my-contribution']//b");
	By btnContributeQuestion = By.xpath("//section[@id='my-contribution']//a");
	
	public boolean isLblMyContributionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyContribution).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnContributeQuestion()
	{
		waitFluentWait(btnContributeQuestion);
		click(btnContributeQuestion);
		sleep(3);
	}
	
	By btnArrowDown = By.id("switch-slide");
	
	public void clickBtnArrowDown()
	{
		waitFluentWait(btnArrowDown);
		click(btnArrowDown);
	}
}
