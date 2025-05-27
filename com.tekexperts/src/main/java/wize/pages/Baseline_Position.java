package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Baseline_Position extends WebActions {

	public Baseline_Position(WebDriver driver) {
		super(driver);
     }
	
	By txtSearchPostion = By.id("searchPosition");
	By itemFirst = By.xpath("//ul[@id='searchPosition_listbox']//li[1]");
	By firtItemPosition = By.xpath("//ul[@id='baselinePositionListView']//li[1]");
	
	public boolean isFirtItemPositionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firtItemPosition).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickFirtItemPosition()
	{
		waitFluentWait(firtItemPosition);
		clickByJavaScript(firtItemPosition);
	}
	
	public void fillTxtSearchPostion(String searchposition)
	{
		waitFluentWait(txtSearchPostion);
		ClickElementAndType(txtSearchPostion, searchposition);
		sleep(2);
		waitFluentWait(itemFirst);
		click(itemFirst);
		sleep(2);
		clickFirtItemPosition();
		sleep(2);
	}
	
	By lblBaselineName = By.xpath("(//h3[@class='section-title text-uppercase'])[2]");
	By lblViewBaseline = By.xpath("(//div[@id='htmlTabCode']//section[2]/div[4]//h3)[1]");
	
	public boolean isLblBaselineNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBaselineName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblViewBaselineDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblViewBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By btnCreateNewBaseline = By.xpath("(//div[@id='positionBaseline-screen']//a[@title='Click to add new baseline'])[1]");
	By btnEditBaseline = By.xpath("(//div[@id='positionBaseline-screen']//button[@title='Edit'])");
	By linkAddSkill = By.xpath("//div[@class='announcement-body']//a[@title='Add skill to baseline']");
	By linkInheritBaseline = By.xpath("//div[@class='announcement-body']//a[@title='Inherit skill from another baseline']");
	By linkCloneBaseline = By.xpath("//div[@class='announcement-body']//a[@title='Clone baseline from another position']");
	
	public boolean isBtnCreateBaselineClickable(){
		boolean flag = isWebElementClickable(btnCreateNewBaseline);
		return flag;
	}
	
	public boolean isBtnEditBaselineClickable(){
		boolean flag = isWebElementClickable(btnEditBaseline);
		return flag;
	}
	
	public boolean isLinkCloneClickable(){
		boolean flag = isWebElementClickable(linkCloneBaseline);
		return flag;
	}
	public boolean isLinkAddSkillClickable(){
		boolean flag = isWebElementClickable(linkAddSkill);
		return flag;
	}
	public boolean isLinkInheritClickable(){
		boolean flag = isWebElementClickable(linkInheritBaseline);
		return flag;
	}
	
	public boolean isBtnCreateBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateNewBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnEditBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(btnEditBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkAddSkillDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkAddSkill).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkInheritBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkInheritBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkCloneBaselineDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(linkCloneBaseline).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreateBaseline(){
		waitFluentWait(btnCreateNewBaseline);
		click(btnCreateNewBaseline);
	}
	public void clickBtnEditBaseline(){
		waitFluentWait(btnEditBaseline);
		click(btnEditBaseline);
	}
	public void clickLinkAddSkill(){
		waitFluentWait(linkAddSkill);
		click(linkAddSkill);
	}
	public void clickLinkInheritBaseline(){
		waitFluentWait(linkInheritBaseline);
		click(linkInheritBaseline);
	}
	public void clickLinkCloneBaseline(){
		waitFluentWait(linkCloneBaseline);
		click(linkCloneBaseline);
	}
	By btnFirstCollapse = By.xpath("(//div[@id='accordion-azure-baseline-1']//button[@class='btn btn-md'])[1]");
	public String getTextBtnFirstCollapse(){
		String text = "";
		try {
			text = driver.findElement(btnFirstCollapse).getAttribute("title");
		} catch (Exception e) {
			return text;
		}
		return text;
	}
}
