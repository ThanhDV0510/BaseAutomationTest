package Ulties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class DataManager extends WebActions {

	public DataManager(WebDriver _driver) {
		super(_driver);
	}
	public static String lessThan250 = "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing some more words";
	public static String equal250 = "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing some more words1";
	public static String moreThan250 = "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing some more words123";
	public static String LearningContent = "Testing Automation Learning Content";
	public static String LearningContent_child = "Testing Automation Learning Content child";
	public static String FunctionSet = "Testing Automation";
	public static String CreateFunctionSet = FunctionSet + TienIch.taoRandomSo(4);
	public static String Functional = "1 Test Automation";
	public static String Test = "Test Automation";
	public static String BalinseJob = "Automation Baseline Job";
	public static String BalinseDimension = "Automation Baseline Dimension";
	public static String Assessment = "Assessment Skill Test";
	public static String Assessment1 = "Assessment Skill Test 1";
	
	public static String AssessmentCompliance = "Assessment Compliance Test";
	public static String AssessmentCompliance1 = "Assessment Compliance Test 1";
	
	public static String Baseline1 = "Automation Question Pool 1";
	public static String Baseline2 = "Automation Question Pool 2";
	
	public static String Domain = "Testing Domain Knowledge";
	public static String Behaviors = "Testing Behaviors";
	
	public static String Skill1 = "Test Automation 1";
	public static String Skill2 = "Test Automation 2";
	public static String Skill3 = "Test Automation 3";
	public static String Skill4 = "Test 1";
	public static String Skill5 = "Test 2";
	
	public static String CategoryName = FunctionSet + TienIch.taoRandomSo(4);
	public static String SkillCategory_TT_15019 = FunctionSet + TienIch.taoRandomSo(4);
	public static String SkillCategory_TT_15187 = FunctionSet + TienIch.taoRandomSo(4);
	
	public static String SkillName_TT_14737 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15187 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15025 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15087 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15089 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15093 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15111 = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_15133 = "Skill Level" + TienIch.taoRandomSo(4);
	
	public static String SkillCategory_TT_14737 = FunctionSet + TienIch.taoRandomSo(4);
	public static String ApproveRequestedTest = "Skill Level" + TienIch.taoRandomSo(4);
	public static String SkillName_TT_14745 = "Skill Level" + TienIch.taoRandomSo(4);
	
	public static String Assessment_TT_16433 = "Assessment" + TienIch.taoRandomSo(4);
	public static String Assessment_TT_16436 = "Assessment" + TienIch.taoRandomSo(4);
	public static String Assessment_TT_16450 = "Assessment" + TienIch.taoRandomSo(4);
	public static String Assessment_TT_16504 = "Assessment" + TienIch.taoRandomSo(4);
	public static String Schedule_TT_16450 = "Schedule" + TienIch.taoRandomSo(4);
	public static String Schedule_TT_16452 = "Schedule" + TienIch.taoRandomSo(4);
	
	public static String Question_TT_14616 = FunctionSet + TienIch.taoRandomSo(3);
	
	public static String ManuallyAssign1 = "ManuallyAssign" + TienIch.taoRandomSo(4);
	public static String ManuallyAssign2 = "ManuallyAssign" + TienIch.taoRandomSo(4);
	public static String ManuallyAssign3 = "ManuallyAssign" + TienIch.taoRandomSo(4);
	public static String ManuallyAssign4 = "ManuallyAssign" + TienIch.taoRandomSo(4);
	public static String ScheduleManually1 = "ScheduleManually" + TienIch.taoRandomSo(4);
	public static String ScheduleManually2 = "ScheduleManually" + TienIch.taoRandomSo(4);
	public static String ScheduleManually3 = "ScheduleManually" + TienIch.taoRandomSo(4);
		
	public static String PublicTest1 = "PublicTest" + TienIch.taoRandomSo(4);
	public static String PublicTest2 = "PublicTest" + TienIch.taoRandomSo(4);
	public static String PublicTest3 = "PublicTest" + TienIch.taoRandomSo(4);
	public static String PublicTestL4 = "PublicTest" + TienIch.taoRandomSo(4);
	
	public static String ApproveTest1 = "ApproveTest" + TienIch.taoRandomSo(4);
	public static String ApproveTest2 = "ApproveTest" + TienIch.taoRandomSo(4);
	public static String ApproveTest3 = "ApproveTest" + TienIch.taoRandomSo(4);
	public static String ApproveTest4 = "ApproveTest" + TienIch.taoRandomSo(4);

	public static String FilterEmployee = "Cuong Manh Nguyen";
	public static String GoallineJob = "GoalLineJob";
	
	public static String LearningURL = "https://www.google.com.vn";
	
	public static String MobilePhone = "0981234567";

//	static By msgSuccess = By.xpath("//div[@class='icon icon-checkmark-circle']");
	static By msgSuccess = By.xpath("//div[@class='alert-text']");
	public static boolean isMsgSuccessDisplayed()
	{
		boolean flag = false;
		try {
			Thread.sleep(500);
			if (driver.findElements(msgSuccess).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public static String getMsgSuccess(){
		String msg = driver.findElement(msgSuccess).getText();
		return msg;
	}
}