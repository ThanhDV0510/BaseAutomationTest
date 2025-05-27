package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeData_Personal extends WebActions {

	public EmployeeData_Personal(WebDriver driver) {
		super(driver);
     }
	
	By lblProfile = By.xpath("(//div[@id='employeePersonal']//h5)[1]");
	
	public boolean isLblProfileDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Contact
	By lblContact = By.xpath("//div[@id='heading-Personal-Contact-Info']//h3");
	By btnAddContact = By.xpath("(//div[@id='heading-Personal-Contact-Info']//button)[2]");
	By linkContact = By.xpath("(//div[@id='personal-data-contact-info-grid']//td//a)[1]");
	By btnEditContact = By.xpath("(//div[@id='personal-data-contact-info-grid']//td[6]//a)[2]");
	By btnDeleteContact = By.xpath("(//div[@id='personal-data-contact-info-grid']//td[6]//a)[1]");
	
	public boolean isLblContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAddContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAddContact()
	{
		waitFluentWait(btnAddContact);
		click(btnAddContact);
		sleep(0.5);
	}
	
	public boolean isLinkContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkContact()
	{
		waitFluentWait(linkContact);
		click(linkContact);
		sleep(0.5);
	}
	
	public boolean isBtnEditContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEditContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnEditContact()
	{
		waitFluentWait(btnEditContact);
		click(btnEditContact);
		sleep(0.5);
	}
	
	public boolean isBnDeleteContactDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteContact).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnDeleteContact()
	{
		waitFluentWait(btnDeleteContact);
		click(btnDeleteContact);
		sleep(0.5);
	}
	
	//Address
	By lblAddress = By.xpath("//div[@id='heading-Personal-address']//h3");
	By btnAddAddress = By.xpath("(//div[@id='heading-Personal-address']//button)[2]");
	By linkAddress = By.xpath("(//div[@id='personal-data-address-grid']//td//a)[1]");
	By btnEditAddress = By.xpath("(//div[@id='personal-data-address-grid']//td[7]//a)[2]");
	By btnDeleteAddress = By.xpath("(//div[@id='personal-data-address-grid']//td[7]//a)[1]");
		
	public boolean isLblAddressDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblAddress).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
			
	public boolean isBtnAddAddressDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddAddress).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	public void clickBtnAddAddress()
	{
		waitFluentWait(btnAddAddress);
		click(btnAddAddress);
		sleep(0.5);
	}
		
	public boolean isLinkAddressDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkAddress).size() > 0) {
				flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickLinkAddress()
		{
			waitFluentWait(linkAddress);
			click(linkAddress);
			sleep(0.5);
		}
		
		public boolean isBtnEditAddressDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnEditAddress).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnEditAddress()
		{
			waitFluentWait(btnEditAddress);
			click(btnEditAddress);
			sleep(0.5);
		}
		
		public boolean isBnDeleteAddressDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnDeleteAddress).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnDeleteAddress()
		{
			waitFluentWait(btnDeleteAddress);
			click(btnDeleteAddress);
			sleep(0.5);
		}
		
		//IDDocument
		By lblIDDocument = By.xpath("//div[@id='heading-Employee-Identification-Doc']//h3");
		By btnAddIDDocument = By.xpath("(//div[@id='heading-Employee-Identification-Doc']//button)[2]");
		By linkIDDocument = By.xpath("(//div[@id='employee-identificationDoc-grid']//td//a)[1]");
		By btnEditIDDocument = By.xpath("(//div[@id='employee-identificationDoc-grid']//td[7]//a)[2]");
		By btnDeleteIDDocument = By.xpath("(//div[@id='employee-identificationDoc-grid']//td[7]//a)[1]");
		
		public boolean isLblIDDocumentDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(lblIDDocument).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnAddIDDocumentDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnAddIDDocument).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnAddIDDocument()
		{
			waitFluentWait(btnAddIDDocument);
			click(btnAddIDDocument);
			sleep(0.5);
		}
		
		public boolean isLinkIDDocumentDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(linkIDDocument).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickLinkIDDocument()
		{
			waitFluentWait(linkIDDocument);
			click(linkIDDocument);
			sleep(0.5);
		}
		
		public boolean isBtnEditIDDocumentDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnEditIDDocument).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnEditIDDocument()
		{
			waitFluentWait(btnEditIDDocument);
			click(btnEditIDDocument);
			sleep(0.5);
		}
		
		public boolean isBnDeleteIDDocumentDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnDeleteIDDocument).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnDeleteIDDocument()
		{
			waitFluentWait(btnDeleteIDDocument);
			click(btnDeleteIDDocument);
			sleep(0.5);
		}
		
		//Education
		By lblEducation = By.xpath("//div[@id='heading-Personal-Education']//h3");
		By btnAddEducation = By.xpath("(//div[@id='heading-Personal-Education']//button)[2]");
		By linkEducation = By.xpath("(//div[@id='personal-data-education-grid']//td//a)[1]");
		By btnEditEducation = By.xpath("(//div[@id='personal-data-education-grid']//td[5]//a)[2]");
		By btnDeleteEducation = By.xpath("(//div[@id='personal-data-education-grid']//td[5]//a)[1]");
		
		public boolean isLblEducationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(lblEducation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnAddEducationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnAddEducation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnAddEducation()
		{
			waitFluentWait(btnAddEducation);
			click(btnAddEducation);
			sleep(0.5);
		}
		
		public boolean isLinkEducationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(linkEducation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickLinkEducation()
		{
			waitFluentWait(linkEducation);
			click(linkEducation);
			sleep(0.5);
		}
		
		public boolean isBtnEditEducationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnEditEducation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnEditEducation()
		{
			waitFluentWait(btnEditEducation);
			click(btnEditEducation);
			sleep(0.5);
		}
		
		public boolean isBnDeleteEducationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnDeleteEducation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickBtnDeleteEducation()
		{
			waitFluentWait(btnDeleteEducation);
			click(btnDeleteEducation);
			sleep(0.5);
		}
		
		//Popup Confirm Delete
		By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
		
		public boolean isLblConfirmationDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(lblConfirmation).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		By btnYesContact = By.xpath("(//button[contains(.,'YES')])[3]");
		By btnNoContact = By.xpath("(//button[contains(.,'NO')])[3]");
				
		
		public void clickBtnYesContact()
		{
			waitFluentWait(btnYesContact);
			click(btnYesContact);
		}

		public void clickBtnNoContact()
		{
			waitFluentWait(btnNoContact);
			click(btnNoContact);
		}

		By btnYesAddress = By.xpath("(//button[contains(.,'YES')])[2]");
		By btnNoAddress = By.xpath("(//button[contains(.,'NO')])[2]");
				
		
		public void clickBtnYesAddress()
		{
			waitFluentWait(btnYesAddress);
			click(btnYesAddress);
		}

		public void clickBtnNoAddress()
		{
			waitFluentWait(btnNoAddress);
			click(btnNoAddress);
		}
		
		By btnYesID = By.xpath("(//button[contains(.,'YES')])[1]");
		By btnNoID = By.xpath("(//button[contains(.,'NO')])[1]");
				
		
		public void clickBtnYesID()
		{
			waitFluentWait(btnYesID);
			click(btnYesID);
		}

		public void clickBtnNoID()
		{
			waitFluentWait(btnNoID);
			click(btnNoID);
		}
		
		By btnYesEducation = By.xpath("(//button[contains(.,'YES')])[4]");
		By btnNoEducation = By.xpath("(//button[contains(.,'NO')])[4]");
				
		
		public void clickBtnYesEducation()
		{
			waitFluentWait(btnYesEducation);
			click(btnYesEducation);
		}

		public void clickBtnNoEducation()
		{
			waitFluentWait(btnNoEducation);
			click(btnNoEducation);
		}
}
