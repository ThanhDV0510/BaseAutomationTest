package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditClone_GoalLineDimension extends WebActions{

	public Form_EditClone_GoalLineDimension(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By titleDuplicate = By.xpath("//div[@id='create-goal']//h4[contains(.,'Duplicate Goal')]");
	public boolean isTitleDuplicateDisplayed(){
		boolean flag = isWebElementDisplayed(titleDuplicate);
		return flag;
	}
	
	By txtGoalName = By.xpath("//input[@id='txtGoalName']");
	public void fillGoalName(String name){
		waitFluentWait(txtGoalName);
		goTextOnNoEnter(txtGoalName, name);
	}
	
	By btnSave = By.xpath("(//button[@class='btn btn-primary'])[3]");
	public void clickBtnSave(){
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	By titleEdit = By.xpath("//div[@id='create-goal']//h4[contains(.,'Edit Goal')]");
	public boolean isTitleEditDisplayed(){
		boolean flag = isWebElementDisplayed(titleEdit);
		return flag;
	}
	
	// form clone from one dimension to another
	By titleClone = By.xpath("//div[@id='clone-dimension-goal-line-form']//h5[@class='modal-title']");
	public boolean isTitleCloneDisplayed(){
		boolean flag = isWebElementDisplayed(titleClone);
		return flag;
	}
	
	public void selectCloneDimension(){
		By drpDimension = By.xpath("//div[@role='listbox']");
		By selectedDimension = By.xpath("(//ul[@id='ddlDimensionGoalLine_listbox']/li)[1]");
		waitFluentWait(drpDimension);
		click(drpDimension);
		sleep(1);
		waitFluentWait(selectedDimension);
		click(selectedDimension);
	}
	
	public void selectCloneBU(){
		By drpBU = By.xpath("(//div[@role='listbox'])[2]");
		By selectedBU = By.xpath("(//ul[@id='ddlDimensionValue_listbox']/li)[1]");
		waitFluentWait(drpBU);
		click(drpBU);
		sleep(1);
		waitFluentWait(selectedBU);
		click(selectedBU);
	}
	
	public void clickBtnClone(){
		By btnClone = By.xpath("(//button[@title='Clone selected goals'])[2]");
		waitFluentWait(btnClone);
		click(btnClone);
	}
	
	public String getGoalLineName(){
		By goalName = By.xpath("(//div[@id='data-clone-dimension-goal-line']//td[1]/span)[1]");
		String name = getText(goalName);
		return name;
	}
}
