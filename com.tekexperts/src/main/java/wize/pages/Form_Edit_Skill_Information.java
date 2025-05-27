package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Edit_Skill_Information extends WebActions {

	public Form_Edit_Skill_Information(WebDriver driver) {
		super(driver);
     }
	
	By tabSkillInformation = By.id("step1");
	By txtSkillName = By.xpath("(//div[@id='step1Content']//input[@id='name'])[2]");
	By txtSkillName14755 = By.xpath("(//div[@id='step1Content']//input[@id='name'])[1]");
	By txtDescription = By.xpath("(//div[@id='step1Content']//input[@id='Description'])[2]");
	By txtDescription14755 = By.xpath("(//div[@id='step1Content']//input[@id='Description'])[1]");
	By lblMandatory = By.xpath("(//div[@id='step1Content']//input[@id='name_validationMessage'])[2]");
	
	public boolean isTabSkillInformationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabSkillInformation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblMandatoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblMandatory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillSkillName(String skillname,String description)
	{
		waitFluentWait(txtSkillName);
		ClickElementAndType(txtSkillName, skillname);
		fillDescription(description);
	}
	
	public void fillSkillNameEdit(String skillname)
	{
		waitFluentWait(txtSkillName);
		ClickElementAndType(txtSkillName, skillname);
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		driver.findElement(txtDescription).clear();
		ClickElementAndType(txtDescription, description);
	}
	
	public void fillDescription14755(String description)
	{
		waitFluentWait(txtDescription14755);
		driver.findElement(txtDescription14755).clear();
		ClickElementAndType(txtDescription14755, description);
	}
	
	By iconPlusDomain = By.id("btn-create-domain-knowledge");
	By txtDomainName = By.id("domainKnowledgeName");
	By iconSaveDomain = By.id("btn-save-domain-knowledge");
	By iconCancelDomain = By.id("btn-cancel-domain-knowledge");
	By lblDomain = By.xpath("(//div[@id='domainBehaviorList']//button)[1]");
	By btnAddBehaviorForDomain = By.xpath("(//div[@id='domainBehaviorList']//div[2]/a)[1]");
	By txtBehaviorForDomain = By.xpath("//div[@id='frm-create-behavior']//input");
	By iconSaveBehaviorForDomain = By.xpath("//div[@id='frm-create-behavior']//a[@title='Save']");
	By iconCancelBehaviorForDomain = By.xpath("//div[@id='frm-create-behavior']//a[@title='Cancel']");
	By lblDomainKnowledge = By.xpath("(//div[@id='domainKnowledge-behavior-block']//label)[1]");
	By lblBehaviorForDomain = By.xpath("(//div[@id='domainKnowledge-behavior-block']//li)[1]");
	
	public boolean isLblDomainKnowledgeDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblDomainKnowledge).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblBehaviorForDomainDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblBehaviorForDomain).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTxtBehaviorForDomainDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtBehaviorForDomain).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconPlusDomain()
	{
		waitFluentWait(iconPlusDomain);
		click(iconPlusDomain);
	}
	
	public void clickLblDomain()
	{
		waitFluentWait(lblDomain);
		click(lblDomain);
	}
	
	public void fillDomainName(String DomainName)
	{
		waitFluentWait(txtDomainName);
		ClickElementAndType(txtDomainName, DomainName);
		clickIconSaveDomain();
	}
	
	public void clickIconSaveDomain()
	{
		waitFluentWait(iconSaveDomain);
		click(iconSaveDomain);
	}
	
	public void clickIconCancelDomain()
	{
		waitFluentWait(iconCancelDomain);
		click(iconCancelDomain);
	}
	
	public void clickBtnAddBehaviorForDomain()
	{
		waitFluentWait(btnAddBehaviorForDomain);
		click(btnAddBehaviorForDomain);
	}
	
	public void fillBehaviorForDomain(String BehaviorForDomain)
	{
		waitFluentWait(txtBehaviorForDomain);
		ClickElementAndType(txtBehaviorForDomain, BehaviorForDomain);
	}
	
	public void clickIconSaveBehaviorForDomain()
	{
		waitFluentWait(iconSaveBehaviorForDomain);
		click(iconSaveBehaviorForDomain);
	}
	
	public void clickIconCancelBehaviorForDomain()
	{
		waitFluentWait(iconCancelBehaviorForDomain);
		click(iconCancelBehaviorForDomain);
	}
	
	By iconPlusBehavior = By.id("btn-create-behavior");
	By txtBehavior = By.id("behaviorName");
	By iconSaveBehavior = By.id("btn-save-behavior");
	By iconCancelBehavior = By.id("btn-cancel-behavior");
	
	public void clickIconPlusBehavior()
	{
		waitFluentWait(iconPlusBehavior);
		click(iconPlusBehavior);
	}
		
	public void fillBehavior(String Behavior)
	{
		waitFluentWait(txtBehavior);
		ClickElementAndType(txtBehavior, Behavior);
		clickIconSaveBehavior();
	}
	
	public void clickIconSaveBehavior()
	{
		waitFluentWait(iconSaveBehavior);
		click(iconSaveBehavior);
	}
	
	public void clickIconCancelBehavior()
	{
		waitFluentWait(iconCancelBehavior);
		click(iconCancelBehavior);
	}
		
	By btnCancel = By.xpath("(//div[@id='buttonStep1']//button[1])[2]");
	By btnCancel14755 = By.xpath("(//div[@id='buttonStep1']//button[1])[1]");
	By btnNext = By.xpath("(//div[@id='buttonStep1']/button[@class='btn btn-primary'])[2]");
	By btnNext14755 = By.xpath("(//div[@id='buttonStep1']/button[@class='btn btn-primary'])[1]");
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
		
	public void clickBtnNext()
	{
		waitFluentWait(btnNext);
		click(btnNext);
	}
	
	public void clickBtnNext14755()
	{
		waitFluentWait(btnNext14755);
		click(btnNext14755);
	}
	
}
