package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class FrontLineManager extends WebActions {

	public FrontLineManager(WebDriver driver) {
		super(driver);
     }
	
	By lblMyTeamPositionFit = By.xpath("(//div[@id='my-system-view-tabstrip-01']//div//h5)[1]");
	By lblTopPercentageFit = By.xpath("(//div[@id='my-system-view-tabstrip-01']//div//h5)[8]");
	By lblBottomPercentageFit = By.xpath("(//div[@id='my-system-view-tabstrip-01']//div//h5)[10]");
	By lblTopSkillAvgValue = By.xpath("(//div[@id='my-system-view-tabstrip-01']//div//h5)[4]");
	By lblBottomSkillAvgValue = By.xpath("(//div[@id='my-system-view-tabstrip-01']//div//h5)[6]");
	
	public boolean isLblMyTeamPositionFitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMyTeamPositionFit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblTopPercentageFitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTopPercentageFit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblBottomPercentageFitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBottomPercentageFit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblTopSkillAvgValueDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblTopSkillAvgValue).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblBottomSkillAvgValueDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBottomSkillAvgValue).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}	
	
	By txtSubmission = By.xpath("//div[@id='global-filter-form']/div[2]/ul//label");
	By lblAttemptPerSkill = By.xpath("(//div[@class='dashboard-blocks']//h5)[1]");
	By lblMatchScorePerCompetency = By.xpath("(//div[@class='dashboard-blocks']//h5)[3]");
	By lblAttemptAVGScorePerUser = By.xpath("(//div[@class='dashboard-blocks']//h5)[5]");
	By lblAttemptAVGScorePerUnit = By.xpath("(//div[@class='dashboard-blocks']//h5)[9]");
	By lblScoreDistribution = By.xpath("(//div[@class='dashboard-blocks']//h5)[7]");
	
	public boolean isTxtSubmissionDisplayed(){
		boolean flag = isWebElementDisplayed(txtSubmission);
		return flag;
	}
	
	public boolean islblAttemptPerSkillDisplayed(){
		boolean flag = isWebElementDisplayed(lblAttemptPerSkill);
		return flag;
	}
	
	public boolean islblMatchScorePerCompetencyDisplayed(){
		boolean flag = isWebElementDisplayed(lblMatchScorePerCompetency);
		return flag;
	}
	
	public boolean islblAttemptAVGScorePerUserDisplayed(){
		boolean flag = isWebElementDisplayed(lblAttemptAVGScorePerUser);
		return flag;
	}
	
	public boolean islblAttemptAVGScorePerUnitDisplayed(){
		boolean flag = isWebElementDisplayed(lblAttemptAVGScorePerUnit);
		return flag;
	}
	
	public boolean islblScoreDistributionDisplayed(){
		boolean flag = isWebElementDisplayed(lblScoreDistribution);
		return flag;
	}
}
