package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.DashBoard;
import wize.pages.LandingPage;
import wize.pages.LoginScreen;
import wize.pages.MyAssessment;
import wize.pages.MyContribution_Question;
import wize.pages.MyData;
import wize.pages.MyData_PersonalData;
import wize.pages.MySpace;
import wize.pages.MyTalent;
import wize.pages.MyTalent_MyCareerPath;
import wize.pages.MyTalent_MySkill;
import wize.pages.MyTalent_MySkill360;

public class Test_Functional_LandingPage extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;

	MySpace mySpace;
	MyData myData;
	MyData_PersonalData myDataPersonalData;
	MyTalent myTalent;
	MyTalent_MySkill360 mySkill360;
	MyTalent_MySkill mySkill;
	MyTalent_MyCareerPath myCareerPath;
	MyContribution_Question myQuestion;
	DashBoard dashBoard;
	MyAssessment myAssessment;
	LandingPage landingPage;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		mySpace = new MySpace(driver);
		myAssessment = new MyAssessment(driver);
		myDataPersonalData = new MyData_PersonalData(driver);
		myData = new MyData(driver);
		myTalent = new MyTalent(driver);
		mySkill360 = new MyTalent_MySkill360(driver);
		mySkill = new MyTalent_MySkill(driver);
		myCareerPath = new MyTalent_MyCareerPath(driver);
		myQuestion = new MyContribution_Question(driver);
		dashBoard = new DashBoard(driver);
		landingPage = new LandingPage(driver);
		
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());
		
	}

	@Test(priority = 1)
	
	public void TT_17142_TT_17140_TT_17141() throws InterruptedException {
		TestLogger.info("1. Login with account.");
	
		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
	
		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}
	
		TestLogger.info("2. Click on Wize logo");
	
		controlBoard.clickLogo();
		
		TestLogger.info("Expect : User CAN see/do: " + "System navigates to the Landing page");
		
		if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
			setStatusTest("pass", "System navigates to the Landing page");
		} else {
			setStatusTest("fail", "System NOT navigates to the Landing page");
		}
		
		TestLogger.info("3. Click on the downward arrow");
		
		TestLogger.info("Expect : User CAN see/do: " + "System scrolles down 1 session");
		
		if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY PERSONAL PROFILE label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY PERSONAL PROFILE label");
		}
		
		landingPage.clickBtnArrowDown();
		
		if (landingPage.isLblMyDashboardDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY DASHBOARD label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY DASHBOARD label");
		}
		
		landingPage.clickBtnArrowDown();
		
		if (landingPage.isLblMyAssessmentsDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY ASSESSMENTS label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY ASSESSMENTS label");
		}
		
		landingPage.clickBtnArrowDown();
		
		if (landingPage.isLblMySkillMapDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY SKILL MAP label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY SKILL MAP label");
		}
		
		landingPage.clickBtnArrowDown();
		
		if (landingPage.isLblMyCareerPathDisplayed()== true) {
			setStatusTest("pass", "User CAN see: MY CAREER PATH label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY CAREER PATH label");
		}
		
		landingPage.clickBtnArrowDown();
		
		if (landingPage.isLblMyContributionDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY CONTRIBUTION label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY CONTRIBUTION label");
		}
		
		TestLogger.info("4. Click on the Upward arrow");
		
		TestLogger.info("Expect : User CAN see/do: " + "System scrolles back to top");
		
		landingPage.clickBtnArrowDown();
				
		if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
			setStatusTest("pass", "User CAN see: MY PERSONAL PROFILE label");
		} else {
			setStatusTest("fail", "User CANNOT see: MY PERSONAL PROFILE label");
		}
}

	@Test(priority = 2)
		
		public void TT_17131_TT_17126_TT_17127_TT_17128_TT_17129_TT_17130() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Click on Wize logo");
		
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			TestLogger.info("3. In Top menu: click on 'My Dashboard'");
			
			landingPage.clickTabMyDashboard();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Dashboard session");
						
			if (landingPage.isLblMyDashboardDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY DASHBOARD label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY DASHBOARD label");
			}
			
			TestLogger.info("4. In Top menu: click on 'My Assessment'");
			
			landingPage.clickTabMyAssessment();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Assessment session");
						
			if (landingPage.isLblMyAssessmentsDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY ASSESSMENTS label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY ASSESSMENTS label");
			}
			
			TestLogger.info("5. In Top menu: click on 'My Skill Map'");
			
			landingPage.clickTabMySkillMap();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Skill Map session");	
			
			if (landingPage.isLblMySkillMapDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY SKILL MAP label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY SKILL MAP label");
			}
			
			TestLogger.info("6. In Top menu: click on 'My Career Path");
			
			landingPage.clickTabMyCareerPath();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Career Path session");	
			
			if (landingPage.isLblMyCareerPathDisplayed()== true) {
				setStatusTest("pass", "User CAN see: MY CAREER PATH label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY CAREER PATH label");
			}
			
			TestLogger.info("7. In Top menu: click on 'My Contribution");
			
			landingPage.clickTabMyContribution();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Contribution session");
			
			if (landingPage.isLblMyContributionDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY CONTRIBUTION label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY CONTRIBUTION label");
			}
			
			TestLogger.info("8. In Top menu: click on 'My Personal Profile");
			
			landingPage.clickTabMyPersonalProfile();
			
			TestLogger.info("Expect : User CAN see/do: " + "System scrolles down to the My Personal Profile session");
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY Personal Profile label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY Personal Profile	label");
			}
	}

	@Test(priority = 3)
		
		public void TT_17133_TT_17134_TT_17135_TT_17136_TT_17137_TT_17138_TT_17139() throws InterruptedException {
			TestLogger.info("1. Login with account.");
		
			loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);
		
			if (controlBoard.isLblControlBoardDisplayed() == true) {
				setStatusTest("pass", "Login Successfully!");
			} else {
				setStatusTest("fail", "Login Fail!");
			}
		
			TestLogger.info("2. Click on Wize logo");
		
			controlBoard.clickLogo();
			
			TestLogger.info("Expect : User CAN see/do: " + "System navigates to the Landing page");
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			TestLogger.info("3. Click on button View My Profile");
	
			landingPage.clickBtnViewMyProfile();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to My Space > My Data >Personal");
					
			if (myDataPersonalData.isLblProfileDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to My Space > My Data >Personal");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to My Space > My Data >Personal");
			}
			
			TestLogger.info("4. Click on button View My Dashboard");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMyDashboard();
			
			if (landingPage.isLblMyDashboardDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY DASHBOARD label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY DASHBOARD label");
			}
			
			landingPage.clickBtnViewMyDashboard();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to Dashboard (1st view on the list)");
					
			if (dashBoard.isTabMySkillDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to Dashboard (1st view on the list)");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to Dashboard (1st view on the list)");
			}
			
			TestLogger.info("5. Click on button Complete an Assessment");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMyAssessment();
			
			if (landingPage.isLblMyAssessmentsDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY Assessment label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY Assessment label");
			}
			
			landingPage.clickBtnCompleteAnAssessment();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to Assessment > My Assessment");
					
			if (myAssessment.isLblApprovalDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to Assessment > My Assessment");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to Assessment > My Assessment");
			}
			
			TestLogger.info("6. Click on button View Skill 360");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMySkillMap();
			
			if (landingPage.isLblMySkillMapDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY SKILL MAP label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY SKILL MAP label");
			}
			
			landingPage.clickBtnViewMySkill360();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to My Space > My Talent > My Skill 360");
					
			if (mySkill360.isLblMyCompetencyDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to My Space > My Talent > My Skill 360");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to My Space > My Talent > My Skill 360");
			}
			
			TestLogger.info("7. Click on button View Skill");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMySkillMap();
			
			if (landingPage.isLblMySkillMapDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY SKILL MAP label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY SKILL MAP label");
			}
			
			landingPage.clickBtnViewMySkill();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to My Space > My Talent > My Skill");
					
			if (mySkill360.isLblMyCompetencyDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to My Space > My Talent > My Skill");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to My Space > My Talent > My Skill");
			}
			
			TestLogger.info("8. Click on button View Career Path");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMyCareerPath();
			
			if (landingPage.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY Career Path label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY Career Path label");
			}
			
			landingPage.clickBtnViewMyCareerPath();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to My Space > My Talent > My Career Path");
					
			if (myCareerPath.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to My Space > My Talent > My Career Path");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to My Space > My Talent > My Career Path");
			}
			
			TestLogger.info("9. Click on button Contribute Question");
			
			controlBoard.clickLogo();
			
			if (landingPage.isLblMyPersonalProfileDisplayed() == true) {
				setStatusTest("pass", "System navigates to the Landing page");
			} else {
				setStatusTest("fail", "System NOT navigates to the Landing page");
			}
			
			landingPage.clickTabMyContribution();
			
			if (landingPage.isLblMyCareerPathDisplayed() == true) {
				setStatusTest("pass", "User CAN see: MY Contribute label");
			} else {
				setStatusTest("fail", "User CANNOT see: MY Contribute label");
			}
			
			landingPage.clickBtnContributeQuestion();
			
			TestLogger.info("Expect : User CAN see/do: " + "System accesses to My Space > My Contribution > Question");
					
			if (myQuestion.isLblMyQuestionDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do: " + "System accesses to My Space > My Contribution > Question");
			} else {
				setStatusTest("fail", "User CANNOT see/do: " + "System accesses to My Space > My Contribution > Question");
			}
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
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
		driver.close();
	}
}
