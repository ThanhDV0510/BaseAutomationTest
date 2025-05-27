package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class PendingForApproval_Assessment extends WebActions {

	public PendingForApproval_Assessment(WebDriver _driver) {
		super(_driver);
	}

	By lblPendingForApproval = By.xpath("//h5[contains(.,'Question Pending for Approval')]");
	
	public boolean isLblPendingForApprovalDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPendingForApproval).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLblAprrove()
	{
		ClickElement(lblPendingForApproval);
	}
	
	By btnRejectAll = By.xpath("(//button[@title = 'Reject question'])[1]");
	By btnApproveAll = By.xpath("(//button[@title = 'Approve question'])[1]");
	
	public void clickBtnRejectAll()
	{
		waitFluentWait(btnRejectAll);
		click(btnRejectAll);
	}
	
	public void clickBtnApproveAll()
	{
		waitFluentWait(btnApproveAll);
		click(btnApproveAll);
	}
	
	By txtSearchQuestion = By.xpath("(//div[@id='pending-for-approval-test']/section/div/div/div/div/table/thead/tr/th/span/span/span/input)[1]");
	By linkFirstQuestion = By.xpath("//div[@id='pending-test-grid']/div[2]/table/tbody/tr[1]/td[2]/a");
	By iconFirstReject = By.xpath("(//div[@id='pending-test-grid']/div[2]/table/tbody/tr/td[8]/button[@title='Reject assessment request'])[1]");
	By iconFirtApprove = By.xpath("(//div[@id='pending-test-grid']/div[2]/table/tbody/tr/td[8]/button[@title='Approve assessment request'])[1]");
	
	public void searchQuestion(String question)
	{
		waitFluentWait(txtSearchQuestion);
		goTextOn(txtSearchQuestion, question);
	}
	
	public void clickLinkFirstQuestion()
	{
		waitFluentWait(linkFirstQuestion);
		click(linkFirstQuestion);
	}
	
	public void clickIconFirstReject()
	{
		waitFluentWait(iconFirstReject);
		click(iconFirstReject);
	}
	
	public void clickIconFirstApprove()
	{
		waitFluentWait(iconFirtApprove);
		click(iconFirtApprove);
		sleep(3);
	}
	
	By cboxAll = By.xpath("//label[@for='check-all']");
	By cboxSingle = By.xpath("(//label[@title='Select'])[1]");
	
	public boolean isCboxSingleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(cboxSingle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickCboxAll()
	{
		waitFluentWait(cboxAll);
		click(cboxAll);
	}
	
	public void clickCboxSingle()
	{
		waitFluentWait(cboxSingle);
		click(cboxSingle);
	}
	
	
	//Form Reject confirmation
	By lblRejectConfirmation = By.xpath("(//h5[@class='modal-title'][contains(.,'Reject confirmation')])[1]");
	By txtRejectReason = By.xpath("(//input[contains(@id,'txtMassRejectPendingTestReason')])[1]");
		
	By iconXReject = By.xpath("(//button[@data-bind='events: {click: gridVM.closeRejectConfirmationModal}'])[1]");
	By btnCancelReject = By.id("btnMassRejectClose");
	By btnSaveReject = By.xpath("(//button[@id='btnMassRejectTestSave'])[1]");
	
	public boolean isLblRejectConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblRejectConfirmation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillRejectReason(String rejectreason)
	{
		waitFluentWait(txtRejectReason);
		ClickElementAndType(txtRejectReason, rejectreason);
	}
	
	public void clickIconXReject()
	{
		waitFluentWait(iconXReject);
		click(iconXReject);
	}
	
	public void clickBtnCancelReject()
	{
		waitFluentWait(btnCancelReject);
		click(btnCancelReject);
	}
	
	public void clickBtnSaveReject()
	{
		waitFluentWait(btnSaveReject);
		click(btnSaveReject);
	}
	
	public void rejectQuestion(String rejectreason)
	{
		fillRejectReason(rejectreason);
		clickBtnSaveReject();
	}
	
	//Form Approve confirmation
	By lbApproveConfirmation = By.xpath("(//h5[@class='modal-title'][contains(.,'Approve confirmation')])[1]");
	
	public boolean isLbApproveConfirmationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lbApproveConfirmation).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By droplistQuestionPool = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[4]/preceding::div[1]");
	By itemTraining = By.xpath("(//*[@id='select-pool-multiselect_listbox'])/li[1]");
	By itemKnowledgeCheck = By.xpath("(//*[@id='select-pool-multiselect_listbox'])/li[2]");
	By itemCompetency = By.xpath("(//*[@id='select-pool-multiselect_listbox'])/li[3]");
	By itemCompliance = By.xpath("(//*[@id='select-pool-multiselect_listbox'])/li[4]");
	By iconRemovePool = By.xpath("//span[@aria-label='delete']");
	
	public boolean isIconRemovePoolDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconRemovePool).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickDroplistQuestionPool()
	{
		waitFluentWait(droplistQuestionPool);
		click(droplistQuestionPool);
	}
	
	public void clickItemTraining()
	{
		waitFluentWait(itemTraining);
		click(itemTraining);
	}
	
	public void clickItemKnowledgeCheck()
	{
		waitFluentWait(itemKnowledgeCheck);
		click(itemKnowledgeCheck);
	}
	
	public void clickItemCompetency()
	{
		waitFluentWait(itemCompetency);
		click(itemCompetency);
	}
	
	public void clickItemCompliance()
	{
		waitFluentWait(itemCompliance);
		click(itemCompliance);
	}
	
	By txtSkill = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skill#Competency'])[4]/following::div[3]");
	By btnRadioSkillL1 = By.xpath("(//input[@name='radio12'])[1]");
	By lblTestAutomation1 = By.xpath("//ul[@id='dllCreateSkillCompetencyApprove_listbox']");
	
	public void selectSkillStage1(String skillcompetency)
	{
		waitFluentWait(txtSkill);
		ClickElementAndType(txtSkill, skillcompetency);
		sleep(5);
		moveHoverElement(driver.findElement(lblTestAutomation1));
		sleep(3);
		ClickElement(btnRadioSkillL1);
	}
	
	By iconXAprove = By.xpath("(//i[contains(@class,'icon icon-cross2')])[28]");
	By btnCancelApprove = By.id("btnMassApproveClose");
	By btnSaveApprove = By.id("btnMassApproveSave");
	By btnYes=By.xpath("(//button[contains(.,'Yes')])[1]");
	
	public void clickIconXAprove()
	{
		waitFluentWait(iconXAprove);
		click(iconXAprove);
	}
	
	public void clickBtnCancelApprove()
	{
		waitFluentWait(btnCancelApprove);
		click(btnCancelApprove);
	}
	
	public void clickBtnSaveApprove()
	{
		waitFluentWait(btnSaveApprove);
		click(btnSaveApprove);
	}
	public void clickBtnYes()
	{
		waitFluentWait(btnYes);
		click(btnYes);
	}
	public void aprroveQuestion(String skillcompetency)
	{
		clickDroplistQuestionPool();
		clickItemTraining();
		sleep(2);
		clickBtnSaveApprove();
	}
}

