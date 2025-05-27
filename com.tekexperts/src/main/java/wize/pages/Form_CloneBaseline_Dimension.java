package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CloneBaseline_Dimension extends WebActions{

	public Form_CloneBaseline_Dimension(WebDriver driver) {
		super(driver);
	}

	By lbClonelBaseline = By.xpath("//div[@id='clone-dimension-baseline']//h5[@class='modal-title']");
	
	By drplistClone = By.xpath("(//div[@id='clone-dimension-baseline']//div[2]/div/div/div/div/div[1])[1]");
	By itemCloneFirst = By.xpath("(//ul[@id='ddlDimension_listbox']//li[1])[1]");
	
	By drplistClone2 = By.xpath("(//div[@id='clone-dimension-baseline']//div[2]/div/div/div/div/div[1])[2]");
	By itemCloneFirst2 = By.xpath("(//ul[@id='ddlDimensionBaseLine_listbox']//li[1])[1]");
	By lblBaseline = By.xpath("(//div[@id='clone-job-baseline']//h3)[1]");
	
	By iconX = By.xpath("//div[@id='clone-form']/div/div[1]//button");
	By btnClone= By.xpath("(//button[@id='cloneBaseLine'])");
	By btnCancel = By.xpath("//div[@id='clone-dimension-baseline']//div[3]/button[1]");
	By btnSaveInPreview = By.xpath("//div[@id='preview-dimension-baseline']//button[@class='btn btn-primary']");
	
	public boolean isTitleCloneDisplayed(){
		boolean flag = isWebElementDisplayed(lbClonelBaseline);
		return flag;
	}
	
	public void clickBtnCancel(){
		sleep(1);
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnSaveInPreview(){
		sleep(2);
		waitFluentWait(btnSaveInPreview);
		click(btnSaveInPreview);
	}
	
	public void clickIconX(){
		sleep(1);
		waitFluentWait(iconX);
		click(iconX);
	}
	
	public void clickBtnClone(){
		sleep(3);
		waitFluentWait(btnClone);
		click(btnClone);
	}
	
	public void selectDimension(String dimensionName){
		sleep(1.5);
		waitFluentWait(drplistClone);
		ClickElementAndType(drplistClone, dimensionName);
		waitFluentWait(itemCloneFirst);
		sleep(2);
		click(itemCloneFirst);
	}
	
	public void selectBusinessUnit(String bu){
		sleep(2);
		waitFluentWait(drplistClone2);
		ClickElementAndType(drplistClone2, bu);
		waitFluentWait(itemCloneFirst2);
		sleep(2);
		click(itemCloneFirst2);
	}
}
