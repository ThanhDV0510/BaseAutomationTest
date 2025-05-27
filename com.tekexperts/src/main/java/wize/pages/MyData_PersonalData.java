package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyData_PersonalData extends WebActions {

	public MyData_PersonalData(WebDriver driver) {
		super(driver);
     }
	
	By lblProfile = By.xpath("(//div[@id='Employee-Data-tabstrip-1']//h5)[1]");
	
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
	
	By btnEditProfile = By.xpath("//button[@title='Edit profile']");
	
	public boolean isBtnEditProfileDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEditProfile).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnEditProfile()
	{
		sleep(3);
		click(btnEditProfile);
		sleep(3);
	}	
	
	//Other Contact
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
		sleep(3);
		click(btnAddContact);
		sleep(3);
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
		sleep(3);
		click(linkContact);
		sleep(3);
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
		moveHoverElement(driver.findElement(linkContact));
		sleep(3);
		click(btnEditContact);
		sleep(3);
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
		moveHoverElement(driver.findElement(linkContact));
		sleep(3);
		click(btnDeleteContact);
		sleep(3);
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
		sleep(3);
		click(btnAddAddress);
		sleep(3);
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
			sleep(3);
			click(linkAddress);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkAddress));
			sleep(3);
			click(btnEditAddress);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkAddress));
			sleep(3);
			click(btnDeleteAddress);
			sleep(3);
		}
		
		//IDDocument
		By lblIDDocument = By.xpath("//div[@id='heading-Personal-Identification-Doc']//h3");
		By btnAddIDDocument = By.xpath("(//div[@id='heading-Personal-Identification-Doc']//button)[2]");
		By linkIDDocument = By.xpath("(//div[@id='personal-data-identificationDoc-grid']//td//a)[1]");
		By btnDeleteIDDocument = By.xpath("(//div[@id='personal-data-identificationDoc-grid']//td[7]//a)[1]");
		By btnEditIDDocument = By.xpath("(//div[@id='personal-data-identificationDoc-grid']//td[7]//a)[2]");
				
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
			sleep(3);
			click(btnAddIDDocument);
			sleep(3);
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
			sleep(3);
			click(linkIDDocument);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkIDDocument));
			sleep(3);
			click(btnEditIDDocument);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkIDDocument));
			sleep(3);
			click(btnDeleteIDDocument);
			sleep(3);
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
			sleep(3);
			click(btnAddEducation);
			sleep(3);
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
			sleep(3);
			click(linkEducation);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkEducation));
			sleep(3);
			click(btnEditEducation);
			sleep(3);
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
			moveHoverElement(driver.findElement(linkEducation));
			sleep(3);
			click(btnDeleteEducation);
			sleep(3);
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
		
		By btnYesContact = By.xpath("(//button[contains(.,'YES')])[4]");
		By btnNoContact = By.xpath("(//button[contains(.,'NO')])[4]");		
		
		public void clickBtnYesContact()
		{
			sleep(3);
			click(btnYesContact);
		}

		public void clickBtnNoContact()
		{
			sleep(3);
			click(btnNoContact);
		}

		By btnYesAddress = By.xpath("(//button[contains(.,'YES')])[1]");
		By btnNoAddress = By.xpath("(//button[contains(.,'NO')])[1]");		
		
		public void clickBtnYesAddress()
		{
			sleep(3);
			click(btnYesAddress);
		}

		public void clickBtnNoAddress()
		{
			sleep(3);
			click(btnNoAddress);
		}
		
		By btnYesID = By.xpath("(//button[contains(.,'YES')])[3]");
		By btnNoID = By.xpath("(//button[contains(.,'NO')])[4]");		
		
		public void clickBtnYesID()
		{
			sleep(3);
			click(btnYesID);
		}

		public void clickBtnNoID()
		{
			sleep(3);
			click(btnNoID);
		}
		
		By btnYesEducation = By.xpath("(//button[contains(.,'YES')])[2]");
		By btnNoEducation = By.xpath("(//button[contains(.,'NO')])[2]");
				
		public void clickBtnYesEducation()
		{
			sleep(3);;
			click(btnYesEducation);
		}

		public void clickBtnNoEducation()
		{
			sleep(3);
			click(btnNoEducation);
		}
}
