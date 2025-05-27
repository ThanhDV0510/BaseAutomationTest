package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Create_LearningContent extends WebActions{

	public Form_Create_LearningContent(WebDriver driver) {
		super(driver);
	}
	
	By lblCreateLearningContent = By.xpath("//div[@id='create-learning-content']//h4");
	By iconX = By.xpath("//div[@id='create-learning-content']//button[@class='btn btn-icon close-slide']");
	By btnCancelCreate = By.xpath("//div[@class='section-footer']/button[@id='btnCancelCreateLearing']");
	By btnSaveCreate = By.xpath("//div[@class='section-footer']/button[@id='btnSaveCreateLearning']");
	By thumbnail = By.xpath("//div[@class='drop-zone-content text-center']//button[@class='btn btn-primary']");
	
	
	
}
