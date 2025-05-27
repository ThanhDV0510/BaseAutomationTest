package wize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class GoalLine extends WebActions{

	public GoalLine(WebDriver driver) {
		super(driver);
	}
	
	By breadcrumb = By.xpath("//li[@class='breadcrumb-item active']");
	By tabJob = By.id("job-goal");
	By searchJob = By.id("search");
	By linkFirstJob = By.xpath("(//div[@id='goal-tabstrip-1']//li)[1]");
	By searchGoalName = By.xpath("//input[@aria-label='Goal Name']");
	By linkFirstGoal = By.xpath("(//a[@class='text view-goal-detail'])[1]");
	By firstGoal = By.xpath("(//div[@id='goal-line-grid']//td/span)[1]");
	By iconDuplicate = By.xpath("(//a[@id='action-duplicate'])[1]");
	By iconEdit = By.xpath("(//a[@id='action-edit'])[1]");
	By btnCreateGoal = By.xpath("//div[@class='dropdown']/a");
	By linkCreateGoal = By.xpath("//button[@id='createGoal']");
	By linkCloneGoal = By.xpath("//button[@id='cloneGoal']");
	By linkInheritGoal = By.xpath("//button[@id='inheritGoal']");
	By ckbAll = By.xpath("//label[@title='Select current page']");
	By btnDeleteAll = By.xpath("//button[@title='Delete Goals']");
	By btnYes = By.xpath("//button[@class='k-button k-primary']");
	By btnNo = By.xpath("//button[@class='k-button']");
	By msgSuccess = By.xpath("//div[contains(@class,'alert-text')]");
	By tabDimension = By.id("dimension-goal");
	By linkSecondDimension = By.xpath("(//table[@role='treegrid']//span[3])[1]");
	By noDataSuggestion = By.xpath("//div[@class='k-animation-container']/div/div[2]/div");
	By tabPosition = By.id("position-goal");
	
	public boolean isBreadcrumbDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(breadcrumb).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isNoDataSuggestionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(noDataSuggestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateGoalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateGoal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnDeleteAllDisplayed(){
		boolean flag = isWebElementDisplayed(btnDeleteAll);
		return flag;
	}
	public boolean isIconDeleteGoalDisplayed(){
		boolean flag = isWebElementDisplayed(iconDeleteGoal);
		return flag;
	}
	public boolean isIconEditDisplayed(){
		boolean flag = isWebElementDisplayed(iconEdit);
		return flag;
	}
	
	public void clickIconEdit(){
		moveHoverElement(driver.findElement(linkFirstGoal));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	public void clickIconEditNoLink(){
		moveHoverElement(driver.findElement(firstGoal));
		waitFluentWait(iconEdit);
		click(iconEdit);
	}
	
	public void clickTabJob()
	{
		waitFluentWait(tabJob);
		click(tabJob);
	}
	
	public void fillSearchJob(String searchjob)
	{
		waitFluentWait(searchJob);
		goTextOn(searchJob, searchjob);
		sleep(2);	
	}
	
	public void clickTabDimension()
	{
		waitFluentWait(tabDimension);
		click(tabDimension);
	}
	
	public void fillSearchDimension(String search)
	{
		waitFluentWait(searchJob);
		goTextOn(searchJob, search);
		sleep(2);	
	}
	
	public void clickTabPosition()
	{
		waitFluentWait(tabPosition);
		click(tabPosition);
	}
	
	public void fillSearchPosition(String search)
	{
		waitFluentWait(searchJob);
		goTextOn(searchJob, search);
		sleep(2);	
	}
	
	public void fillSearchGoalName(String search)
	{
		waitFluentWait(searchGoalName);
		goTextOn(searchGoalName, search);
		sleep(2);	
	}
	
	public boolean isLinkFirstJobDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkFirstJob).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstJob()
	{
		waitFluentWait(linkFirstJob);
		click(linkFirstJob);
	}
	
	public boolean isLinkSecondDimensionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkSecondDimension).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkSecondDimension()
	{
		waitFluentWait(linkSecondDimension);
		click(linkSecondDimension);
	}
	public boolean isIconDuplicateDisplayed(){
		boolean flag = isWebElementDisplayed(iconDuplicate);
		return flag;
	}
	
	public void clickIconDuplicate()
	{
		moveHoverElement(driver.findElement(linkFirstGoal));
		waitFluentWait(iconDuplicate);
		click(iconDuplicate);
	}
	
	public void clickIconDuplicateNoLink()
	{
		moveHoverElement(driver.findElement(firstGoal));
		waitFluentWait(iconDuplicate);
		click(iconDuplicate);
	}
	
	public void clickLinkCreateGoal(){
		waitFluentWait(btnCreateGoal);
		click(btnCreateGoal);
		waitFluentWait(linkCreateGoal);
		click(linkCreateGoal);
	}
	
	public void clickLinkCloneGoal(){
		waitFluentWait(btnCreateGoal);
		click(btnCreateGoal);
		waitFluentWait(linkCloneGoal);
		click(linkCloneGoal);
	}
	
	public boolean isLinkCloneGoalDisplayed(){
		boolean flag = isWebElementDisplayed(linkCloneGoal);
		return flag;
	}
	
	public void clickLinkinheritGoal(){
		waitFluentWait(btnCreateGoal);
		click(btnCreateGoal);
		waitFluentWait(linkInheritGoal);
		click(linkInheritGoal);
	}
	
	public boolean isLinkFirstGoalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstGoal).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkFirstGoal()
	{
		waitFluentWait(linkFirstGoal);
		click(linkFirstGoal);
	}
	
	public boolean isLinkFirstGoalClickable(){
		boolean flag = isWebElementClickable(linkFirstGoal);
		return flag;
	}
	
	public void deleteAllGoal(){
		waitFluentWait(ckbAll);
		click(ckbAll);
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
		waitFluentWait(btnYes);
		click(btnYes);
	}
	
	By btnYesDeleteAll = By.xpath("(//button[@class='k-button k-primary'])[3]");
	public void deleteAllGoal2ndTime(){
		waitFluentWait(ckbAll);
		click(ckbAll);
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
		waitFluentWait(btnYesDeleteAll);
		click(btnYesDeleteAll);
	}
	
	public boolean compareTextPopupDeleteGoal(){
		boolean flag = false;
		selectCkbFirstGoal();
		selectCkbSecondGoal();
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
		String contentMsg = driver.findElement(By.xpath("(//div[@id='dialogBoxDeleteGoalLine'])[1]")).getText();
		try {
			if(contentMsg.equals("Are you sure you want to delete selected goals? If you continue, data will be lost permanently and cannot be recovered.")){
				flag = true;
				waitFluentWait(btnNo);
				click(btnNo);
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void cancelDeleteAllGoal(){
		waitFluentWait(ckbAll);
		click(ckbAll);
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
		waitFluentWait(btnNo);
		click(btnNo);
	}
	
	public void delete2Goals(){
		waitFluentWait(btnDeleteAll);
		click(btnDeleteAll);
		waitFluentWait(By.xpath("(//button[@class='k-button k-primary'])[2]"));
		click(By.xpath("(//button[@class='k-button k-primary'])[2]"));
	}
	
	public boolean isMsgSuccessDisplayed(){
		boolean flag = false;
		try {
			if (driver.findElements(msgSuccess).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public String getMsgSuccess(){
		String msg = "";
		try {
			msg = driver.findElement(msgSuccess).getText();
		} catch (Exception e) {
			return msg;
		}
		return msg;
	}
	
	public int getTotalGoalInTable(){
		List<WebElement> lst = driver.findElements(By.xpath("(//a[@class='text view-goal-detail'])"));
		int total = lst.size();
		return total;
	}
	
	By ckbFirstGoalInTable = By.xpath("(//div[@id='goal-line-grid']//label[@title='Select this goal'])[1]");
	By ckbSecondGoalInTable = By.xpath("(//div[@id='goal-line-grid']//label[@title='Select this goal'])[2]");
	public void selectCkbFirstGoal(){
		waitFluentWait(ckbFirstGoalInTable);
		click(ckbFirstGoalInTable);
	}
	public void selectCkbSecondGoal(){
		waitFluentWait(ckbSecondGoalInTable);
		click(ckbSecondGoalInTable);
	}
	
	By iconDeleteGoal = By.xpath("(//a[@id='action-delete'])[1]");
	public void clickIconDeleteGoal(){
		waitFluentWait(linkFirstGoal);
		moveHoverElement(driver.findElement(linkFirstGoal));
		click(iconDeleteGoal);
	}
	public void clickIconDeleteGoalNoLink(){
		waitFluentWait(firstGoal);
		moveHoverElement(driver.findElement(firstGoal));
		click(iconDeleteGoal);
	}
	
	public boolean compareTextPopupDeleteFirstGoal(){
		boolean flag = false;
		clickIconDeleteGoal();
		String contentMsg = driver.findElement(By.xpath("(//div[@id='dialogBoxDeleteGoalLine'])[1]")).getText();
		try {
			if(contentMsg.equals("Are you sure you want to delete selected goal? If you continue, data will be lost permanently and cannot be recovered.")){
				flag = true;
				waitFluentWait(btnNo);
				click(btnNo);
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void cancelDeleteFirstGoal(){
		clickIconDeleteGoal();
		waitFluentWait(btnNo);
		click(btnNo);
	}
	
	public void deleteFirstGoal(){
		clickIconDeleteGoal();
		waitFluentWait(By.xpath("(//button[@class='k-button k-primary'])[2]"));
		click(By.xpath("(//button[@class='k-button k-primary'])[2]"));
	}
}
