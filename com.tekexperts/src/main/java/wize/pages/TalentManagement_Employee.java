package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TalentManagement_Employee extends WebActions {

	public TalentManagement_Employee(WebDriver driver) {
		super(driver);
     }
	
	By labelEmployeeManagement = By.xpath("(//div[@id='customPageEmployeeManagement']//h5)[1]");
	
	public boolean isLabelEmployeeManagementDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(labelEmployeeManagement).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	By iconDots = By.xpath("(//div[@id='talent-management-page']//i)[1]");
	By itemView = By.xpath("(//div[@id='talent-management-page']//span)[3]");
	By btnCardView = By.id("employee-listview");
	By linkEmployeeCard = By.xpath("(//div[@id='talent-management-page']//h6)[1]");
	By btnTableView = By.id("employee-gridview");
	By linkEmployeeTable = By.xpath("(//div[@id='employee-list-grid']//a[@target='_blank'])[1]");
	
	public void clickLinkEmployeeCard()
	{
		waitFluentWait(linkEmployeeCard);
		click(linkEmployeeCard);
	}
	
	public boolean isBtnCardViewDisplayed(){
		boolean flag = isWebElementDisplayed(btnCardView);
		return flag;
	}
	public boolean isBtnTableViewDisplayed(){
		boolean flag = isWebElementDisplayed(btnTableView);
		return flag;
	}
	
	public boolean isLinkEmployeeCardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkEmployeeCard).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkEmployeeTable()
	{
		waitFluentWait(linkEmployeeTable);
		click(linkEmployeeTable);
	}
	
	public boolean isLinkEmployeeTableDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkEmployeeTable).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconDots()
	{
		waitFluentWait(iconDots);
		click(iconDots);
	}
	
	public boolean isIconDotsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDots).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickItemView()
	{
		waitFluentWait(itemView);
		click(itemView);
	}
	
	public void clickBtnCardView()
	{
		waitFluentWait(btnCardView);
		click(btnCardView);
	}
	
	public void clickBtnTableView()
	{
		waitFluentWait(btnTableView);
		click(btnTableView);
	}
	
	By btnFilter = By.xpath("//div[@id='customPageEmployeeManagement']//button[@data-target-box='#create-filter']");
	By btnAddEmployee = By.xpath("//div[@id='customPageEmployeeManagement']//button[@data-bind='events:{click: createEmployee}']");
	
	public void clickBtnFilter()
	{
		waitFluentWait(btnFilter);
		click(btnFilter);
	}
	
	public boolean isBtnAddEmployeeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddEmployee).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAddEmployee()
	{
		waitFluentWait(btnAddEmployee);
		click(btnAddEmployee);
	}
	By txtSearchPosition = By.xpath("//div[@id='position-grid-mode']//input[@aria-label='Position']");
	public void searchPosition(String search){
		waitFluentWait(txtSearchPosition);
		goTextOn(txtSearchPosition, search);
		sleep(4);
		clickTitlePosition();
	}
	By titlePosition = By.xpath("//div[@id='employeePosition']//h5[@title='Position']");
	public void clickTitlePosition(){
		waitFluentWait(titlePosition);
		click(titlePosition);
	}
}
