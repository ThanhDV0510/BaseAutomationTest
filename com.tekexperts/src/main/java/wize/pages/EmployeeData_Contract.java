package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeData_Contract extends WebActions {

	public EmployeeData_Contract(WebDriver driver) {
		super(driver);
     }
	
	By lblContractInfo = By.xpath("(//div[@id='employeeContract']//h5)[1]");
	
	public boolean isLblContractInfoDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContractInfo).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Employment
	By lblEmployment = By.xpath("//div[@id='heading-Personal-employment']//h3");
	By btnAddEmployment = By.xpath("(//div[@id='heading-Personal-employment']//button)[2]");
	By linkEmployment = By.xpath("(//div[@id='employment-grid']//td//a)[1]");
	By btnEditEmployment = By.xpath("(//div[@id='employment-grid']//td[7]//a)[1]");
	By btnDeleteEmployment = By.xpath("(//div[@id='employment-grid']//td[7]//a)[2]");
	
	public boolean isLblEmploymentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddEmploymentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddEmployment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAddEmployment()
	{
		waitFluentWait(btnAddEmployment);
		click(btnAddEmployment);
	}
	
	public boolean isLinkEmploymentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkEmployment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkEmployment()
	{
		waitFluentWait(linkEmployment);
		click(linkEmployment);
	}
	
	public boolean isBtnEditEmploymentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEditEmployment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnEditEmployment()
	{
		waitFluentWait(btnEditEmployment);
		click(btnEditEmployment);
	}
	
	public boolean isBnDeleteEmploymentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteEmployment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDeleteEmployment()
	{
		waitFluentWait(btnDeleteEmployment);
		click(btnDeleteEmployment);
	}
	
	//WorkPermit
	By lblWorkPermit = By.xpath("//div[@id='heading-Personal-Work-Permit']//h3");
	By btnAddWorkPermit = By.xpath("(//div[@id='heading-Personal-Work-Permit']//button)[2]");
	By linkWorkPermit = By.xpath("(//div[@id='personal-data-workPermits-grid']//td//a)[1]");
	By btnEditWorkPermit = By.xpath("(//div[@id='personal-data-workPermits-grid']//td[5]//a)[1]");
	By btnDeleteWorkPermit = By.xpath("(//div[@id='personal-data-workPermits-grid']//td[5]//a)[2]");
		
	public boolean isLblWorkPermitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblWorkPermit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
			
	public boolean isBtnAddWorkPermitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddWorkPermit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnAddWorkPermit()
	{
		waitFluentWait(btnAddWorkPermit);
		click(btnAddWorkPermit);
	}
		
	public boolean isLinkWorkPermitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkWorkPermit).size() > 0) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickLinkWorkPermit()
		{
			waitFluentWait(linkWorkPermit);
			click(linkWorkPermit);
		}
		
		public boolean isBtnEditWorkPermitDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnEditWorkPermit).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnEditWorkPermit()
		{
			waitFluentWait(btnEditWorkPermit);
			click(btnEditWorkPermit);
		}
		
		public boolean isBnDeleteWorkPermitDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnDeleteWorkPermit).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnDeleteWorkPermit()
		{
			waitFluentWait(btnDeleteWorkPermit);
			click(btnDeleteWorkPermit);
		}
}
