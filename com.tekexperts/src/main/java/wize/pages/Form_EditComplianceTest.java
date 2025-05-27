package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditComplianceTest extends WebActions {

	public Form_EditComplianceTest(WebDriver driver) {
		super(driver);
     }

	By lblCreateAdaptiveTest = By.xpath("//h4[contains(.,'Create Adaptive Test')]");
	
	public boolean isLblCreateAdaptiveTestProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCreateAdaptiveTest).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Basic information
	By txtTitle = By.id("titleInformation");
	By drplistCategory = By.xpath("(//span[@class='k-icon k-i-arrow-60-down'])[10]");
	By txtDescription = By.xpath("//*[@id=\"step1Content\"]/div/div[1]/div[2]/div/table/tbody/tr[2]/td/iframe");
		
	public boolean isTxtTitleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtTitle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillDescription(String description)
	{
		waitFluentWait(txtDescription);
		ClickElementAndType(txtDescription, description);
		sleep(3);
	}
	
	public void fillTitle(String title)
	{
		waitFluentWait(txtTitle);
		ClickElementAndType(txtTitle, title);
	}
	
	public void fillCategory(String category)
	{
		waitFluentWait(drplistCategory);
		ClickElementAndType(drplistCategory, category);
	}
	
	By btnNextInfo = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.nextStep }'])[1]");
	By btnCancelInfo = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.cancelForm }'])[1]");
	
	public void clickBtnNextInfo()
	{
		waitFluentWait(btnNextInfo);
		click(btnNextInfo);
	}
	
	public void clickBtnCancelInfo()
	{
		waitFluentWait(btnCancelInfo);
		click(btnCancelInfo);
	}
	
	//Testing Settings
	
	By lblRestriction = By.xpath("(//label[contains(.,'Restriction')])[1]");
	
	public boolean isLblRestrictionDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblRestriction).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By drplistRestriction = By.xpath("//span[@aria-owns='ddlRestriction_listbox']");
	By itemApprovalRequested = By.xpath("(//ul[@id='ddlRestriction_listbox'])/li[1]");
	By itemManuallyAssigned = By.xpath("(//ul[@id='ddlRestriction_listbox'])/li[2]");
	By itemPublic = By.xpath("(//ul[@id='ddlRestriction_listbox'])/li[3]");
	
	public void clickDrplistRestriction()
	{
		waitFluentWait(drplistRestriction);
		click(drplistRestriction);
	}
	
	public void clickItemApprovalRequested()
	{
		waitFluentWait(itemApprovalRequested);
		click(itemApprovalRequested);
	}
	
	public void clickItemManuallyAssigned()
	{
		waitFluentWait(itemManuallyAssigned);
		click(itemManuallyAssigned);
	}
	
	public void clickItemPublic()
	{
		waitFluentWait(itemPublic);
		click(itemPublic);
	}
	
	By drplistCompletionTime = By.xpath("//span[@aria-owns='ddlCompletionTime_listbox']");
	By itemCUnlimited = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[1]");
	By itemC15 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[2]");
	By itemC20 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[3]");
	By itemC25 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[4]");
	By itemC30 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[5]");
	By itemC35 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[6]");
	By itemC40 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[7]");
	By itemC45 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[8]");
	By itemC50 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[9]");
	By itemC55 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[10]");
	By itemC60 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[11]");
	By itemC65 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[12]");
	By itemC70 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[13]");
	By itemC75 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[14]");
	By itemC80 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[15]");
	By itemC85 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[16]");
	By itemC90 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[17]");
	By itemC95 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[18]");
	By itemC100 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[19]");
	By itemC105 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[20]");
	By itemC110 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[21]");
	By itemC115 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[22]");
	By itemC120 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[23]");
	By itemC125 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[24]");
	By itemC130 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[25]");
	By itemC135 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[26]");
	By itemC140 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[27]");
	By itemC145 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[28]");
	By itemC150 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[29]");
	By itemC155 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[30]");
	By itemC160 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[31]");
	By itemC165 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[32]");
	By itemC170 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[33]");
	By itemC175 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[34]");
	By itemC180 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[35]");
	By itemC185 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[36]");
	By itemC190 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[37]");
	By itemC195 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[38]");
	By itemC200 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[39]");
	By itemC205 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[40]");
	By itemC210 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[41]");
	By itemC215 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[42]");
	By itemC220 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[43]");
	By itemC225 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[44]");
	By itemC230 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[45]");
	By itemC235 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[46]");
	By itemC240 = By.xpath("(//ul[@id='ddlCompletionTime_listbox'])/li[47]");
		
	public void clickDrplistCompletionTime()
	{
		waitFluentWait(drplistCompletionTime);
		click(drplistCompletionTime);
	}
	
	public void clickItemCUnlimited()
	{
		waitFluentWait(itemCUnlimited);
		click(itemCUnlimited);
	}
	
	public void clickItemC15()
	{
		waitFluentWait(itemC15);
		click(itemC15);
	}
	
	public void clickItemC20()
	{
		waitFluentWait(itemC20);
		click(itemC20);
	}
	
	public void clickItemC25()
	{
		waitFluentWait(itemC25);
		click(itemC25);
	}
	
	public void clickItemC30()
	{
		waitFluentWait(itemC30);
		click(itemC30);
	}
	
	public void clickItemC35()
	{
		waitFluentWait(itemC35);
		click(itemC35);
	}
	
	public void clickItemC40()
	{
		waitFluentWait(itemC40);
		click(itemC40);
	}
	
	public void clickItemC45()
	{
		waitFluentWait(itemC45);
		click(itemC45);
	}
	
	public void clickItemC50()
	{
		waitFluentWait(itemC50);
		click(itemC50);
	}
	
	public void clickItemC55()
	{
		waitFluentWait(itemC55);
		click(itemC55);
	}
	
	public void clickItemC60()
	{
		waitFluentWait(itemC60);
		click(itemC60);
	}
	
	public void clickItemC65()
	{
		waitFluentWait(itemC65);
		click(itemC65);
	}
	
	public void clickItemC70()
	{
		waitFluentWait(itemC70);
		click(itemC70);
	}
	
	public void clickItemC75()
	{
		waitFluentWait(itemC75);
		click(itemC75);
	}
	
	public void clickItemC80()
	{
		waitFluentWait(itemC80);
		click(itemC80);
	}
	
	public void clickItemC85()
	{
		waitFluentWait(itemC85);
		click(itemC85);
	}
	
	public void clickItemC90()
	{
		waitFluentWait(itemC90);
		click(itemC90);
	}
	
	public void clickItemC95()
	{
		waitFluentWait(itemC95);
		click(itemC95);
	}
	
	public void clickItemC100()
	{
		waitFluentWait(itemC100);
		click(itemC100);
	}
	
	public void clickItemC105()
	{
		waitFluentWait(itemC105);
		click(itemC105);
	}
	
	public void clickItemC110()
	{
		waitFluentWait(itemC110);
		click(itemC110);
	}
	
	public void clickItemC115()
	{
		waitFluentWait(itemC115);
		click(itemC115);
	}
	
	public void clickItemC120()
	{
		waitFluentWait(itemC120);
		click(itemC120);
	}
	
	public void clickItemC125()
	{
		waitFluentWait(itemC125);
		click(itemC125);
	}
	
	public void clickItemC130()
	{
		waitFluentWait(itemC130);
		click(itemC130);
	}
	
	public void clickItemC135()
	{
		waitFluentWait(itemC135);
		click(itemC135);
	}
	
	public void clickItemC140()
	{
		waitFluentWait(itemC140);
		click(itemC140);
	}
	
	public void clickItemC145()
	{
		waitFluentWait(itemC145);
		click(itemC145);
	}
	
	public void clickItemC150()
	{
		waitFluentWait(itemC150);
		click(itemC150);
	}
	
	public void clickItemC155()
	{
		waitFluentWait(itemC155);
		click(itemC155);
	}
	
	public void clickItemC160()
	{
		waitFluentWait(itemC160);
		click(itemC160);
	}
	
	public void clickItemC165()
	{
		waitFluentWait(itemC165);
		click(itemC165);
	}
	
	public void clickItemC170()
	{
		waitFluentWait(itemC170);
		click(itemC170);
	}
	
	public void clickItemC175()
	{
		waitFluentWait(itemC175);
		click(itemC175);
	}
	
	public void clickItemC180()
	{
		waitFluentWait(itemC180);
		click(itemC180);
	}
	public void clickItemC185()
	{
		waitFluentWait(itemC185);
		click(itemC185);
	}
	
	public void clickItemC190()
	{
		waitFluentWait(itemC190);
		click(itemC190);
	}
	public void clickItemC195()
	{
		waitFluentWait(itemC195);
		click(itemC195);
	}
	
	public void clickItemC200()
	{
		waitFluentWait(itemC200);
		click(itemC200);
	}
	public void clickItemC205()
	{
		waitFluentWait(itemC205);
		click(itemC205);
	}
	
	public void clickItemC210()
	{
		waitFluentWait(itemC210);
		click(itemC210);
	}
	public void clickItemC215()
	{
		waitFluentWait(itemC215);
		click(itemC215);
	}
	
	public void clickItemC220()
	{
		waitFluentWait(itemC220);
		click(itemC220);
	}
	public void clickItemC225()
	{
		waitFluentWait(itemC225);
		click(itemC225);
	}
	
	public void clickItemC230()
	{
		waitFluentWait(itemC230);
		click(itemC230);
	}
	public void clickItemC235()
	{
		waitFluentWait(itemC235);
		click(itemC235);
	}
	
	public void clickItemC240()
	{
		waitFluentWait(itemC240);
		click(itemC240);
	}
	
	By drplistMarginTime = By.xpath("//span[@aria-owns='ddlMarginTime_listbox']");
	By itemM0 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[1]");
	By itemM5 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[2]");
	By itemM10 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[3]");
	By itemM15 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[4]");
	By itemM20 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[5]");
	By itemM25 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[6]");
	By itemM30 = By.xpath("(//ul[@id='ddlMarginTime_listbox'])/li[7]");
	
	public void clickDrplistMarginTime()
	{
		waitFluentWait(drplistMarginTime);
		click(drplistMarginTime);
	}
	
	public void clickItemM0()
	{
		waitFluentWait(itemM0);
		click(itemM0);
	}
	
	public void clickItemM5()
	{
		waitFluentWait(itemM5);
		click(itemM5);
	}
	
	public void clickItemM10()
	{
		waitFluentWait(itemM10);
		click(itemM10);
	}
	
	public void clickItemM15()
	{
		waitFluentWait(itemM15);
		click(itemM15);
	}
	
	public void clickItemM20()
	{
		waitFluentWait(itemM20);
		click(itemM20);
	}
	
	public void clickItemM25()
	{
		waitFluentWait(itemM25);
		click(itemM25);
	}
	
	public void clickItemM30()
	{
		waitFluentWait(itemM30);
		click(itemM30);
	}
	
	By drplistPassingScore = By.xpath("//span[@aria-owns='ddlPassingScore_listbox']");
	By itemNone = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[1]");
	By itemP0 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[2]");
	By itemP5 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[3]");
	By itemP10 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[4]");
	By itemP15 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[5]");
	By itemP20 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[6]");
	By itemP25 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[7]");
	By itemP30 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[8]");
	By itemP35 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[9]");
	By itemP40 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[10]");
	By itemP45 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[11]");
	By itemP50 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[12]");
	By itemP55 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[13]");
	By itemP60 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[14]");
	By itemP65 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[15]");
	By itemP70 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[16]");
	By itemP75 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[17]");
	By itemP80 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[18]");
	By itemP85 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[19]");
	By itemP90 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[20]");
	By itemP95 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[21]");
	By itemP100 = By.xpath("(//ul[@id='ddlPassingScore_listbox'])/li[22]");
	
	public void clickDrplistPassingScore()
	{
		waitFluentWait(drplistPassingScore);
		click(drplistPassingScore);
	}
	
	public void clickItemNone()
	{
		waitFluentWait(itemNone);
		click(itemNone);
	}
	
	public void clickItemP0()
	{
		waitFluentWait(itemP0);
		click(itemP0);
	}
	
	public void clickItemP5()
	{
		waitFluentWait(itemP5);
		click(itemP5);
	}
	
	public void clickItemP10()
	{
		waitFluentWait(itemP10);
		click(itemP10);
	}
	
	public void clickItemP15()
	{
		waitFluentWait(itemP15);
		click(itemP15);
	}
	
	public void clickItemP20()
	{
		waitFluentWait(itemP20);
		click(itemP20);
	}
	
	public void clickItemP25()
	{
		waitFluentWait(itemP25);
		click(itemP25);
	}
	
	public void clickItemP30()
	{
		waitFluentWait(itemP30);
		click(itemP30);
	}
	
	public void clickItemP35()
	{
		waitFluentWait(itemP35);
		click(itemP35);
	}
	
	public void clickItemP40()
	{
		waitFluentWait(itemP40);
		click(itemP40);
	}
	
	public void clickItemP45()
	{
		waitFluentWait(itemP45);
		click(itemP45);
	}
	
	public void clickItemP50()
	{
		waitFluentWait(itemP50);
		click(itemP50);
	}
	
	public void clickItemP55()
	{
		waitFluentWait(itemP55);
		click(itemP55);
	}
	
	public void clickItemP60()
	{
		waitFluentWait(itemP60);
		click(itemP60);
	}
	
	public void clickItemP65()
	{
		waitFluentWait(itemP65);
		click(itemP65);
	}
	
	public void clickItemP70()
	{
		waitFluentWait(itemP70);
		click(itemP70);
	}
	
	public void clickItemP75()
	{
		waitFluentWait(itemP75);
		click(itemP75);
	}
	
	public void clickItemP80()
	{
		waitFluentWait(itemP80);
		click(itemP80);
	}
	
	public void clickItemP85()
	{
		waitFluentWait(itemP85);
		click(itemP85);
	}
	
	public void clickItemP90()
	{
		waitFluentWait(itemP90);
		click(itemP90);
	}
	
	public void clickItemP95()
	{
		waitFluentWait(itemP95);
		click(itemP95);
	}
	
	public void clickItemP100()
	{
		waitFluentWait(itemP100);
		click(itemP100);
	}
	
	By btnRadioTestSettings = By.xpath("//input[@data-bind='checked: createComplianceTestViewModel.complianceTestModel.testsettingtryagain, disabled: createComplianceTestViewModel.disableControl.tryagainswitch, events:{change: createComplianceTestViewModel.change}']");
	By drplistTimes = By.xpath("//span[@aria-owns='ddlTime_listbox']");
	By itemTUnlimited = By.xpath("(//ul[@id='ddlTime_listbox'])/li[1]");
	By itemT1 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[2]");
	By itemT2 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[3]");
	By itemT3 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[4]");
	By itemT4 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[5]");
	By itemT5 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[6]");
	By itemT6 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[7]");
	By itemT7 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[8]");
	By itemT8 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[9]");
	By itemT9 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[10]");
	By itemT10 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[11]");
	By itemT11 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[12]");
	By itemT12 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[13]");
	By itemT13 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[14]");
	By itemT14 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[15]");
	By itemT15 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[16]");
	By itemT16 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[17]");
	By itemT17 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[18]");
	By itemT18 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[19]");
	By itemT19 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[20]");
	By itemT20 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[21]");
	By itemT21 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[22]");
	By itemT22 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[23]");
	By itemT23 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[24]");
	By itemT24 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[25]");
	By itemT25 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[26]");
	By itemT26 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[27]");
	By itemT27 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[28]");
	By itemT28 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[29]");
	By itemT29 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[30]");
	By itemT30 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[31]");
	By itemT31 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[32]");
	By itemT32 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[33]");
	By itemT33 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[34]");
	By itemT34 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[35]");
	By itemT35 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[36]");
	By itemT36 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[37]");
	By itemT37 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[38]");
	By itemT38 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[39]");
	By itemT39 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[40]");
	By itemT40 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[41]");
	By itemT41 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[42]");
	By itemT42 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[43]");
	By itemT43 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[44]");
	By itemT44 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[45]");
	By itemT45 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[46]");
	By itemT46 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[47]");
	By itemT47 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[48]");
	By itemT48 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[49]");
	By itemT49 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[50]");
	By itemT50 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[51]");
	By itemT51 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[52]");
	By itemT52 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[53]");
	By itemT53 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[54]");
	By itemT54 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[55]");
	By itemT55 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[56]");
	By itemT56 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[57]");
	By itemT57 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[58]");
	By itemT58 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[59]");
	By itemT59 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[60]");
	By itemT60 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[61]");
	By itemT61 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[62]");
	By itemT62 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[63]");
	By itemT63 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[64]");
	By itemT64 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[65]");
	By itemT65 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[66]");
	By itemT66 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[67]");
	By itemT67 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[68]");
	By itemT68 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[69]");
	By itemT69 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[70]");
	By itemT70 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[71]");
	By itemT71 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[72]");
	By itemT72 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[73]");
	By itemT73 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[74]");
	By itemT74 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[75]");
	By itemT75 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[76]");
	By itemT76 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[77]");
	By itemT77 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[78]");
	By itemT78 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[79]");
	By itemT79 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[80]");
	By itemT80 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[81]");
	By itemT81 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[82]");
	By itemT82 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[83]");
	By itemT83 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[84]");
	By itemT84 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[85]");
	By itemT85 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[86]");
	By itemT86 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[87]");
	By itemT87 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[88]");
	By itemT88 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[89]");
	By itemT89 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[90]");
	By itemT90 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[91]");
	By itemT91 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[92]");
	By itemT92 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[93]");
	By itemT93 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[94]");
	By itemT94 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[95]");
	By itemT95 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[96]");
	By itemT96 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[97]");
	By itemT97 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[98]");
	By itemT98 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[99]");
	By itemT99 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[100]");
	By itemT100 = By.xpath("(//ul[@id='ddlTime_listbox'])/li[101]");

	public void clickBtnRadioTestSettings()
	{
		waitFluentWait(btnRadioTestSettings);
		click(btnRadioTestSettings);
	}
	
	public void clickDrplistTimes()
	{
		waitFluentWait(drplistTimes);
		click(drplistTimes);
	}
	
	public void clickItemTUnlimited()
	{
		waitFluentWait(itemTUnlimited);
		click(itemTUnlimited);
	}
	
	public void clickItemT1()
	{
		waitFluentWait(itemT1);
		click(itemT1);
	}
	
	public void clickItemT2()
	{
		waitFluentWait(itemT2);
		click(itemT2);
	}
	
	public void clickItemT3()
	{
		waitFluentWait(itemT3);
		click(itemT3);
	}
	
	public void clickItemT4()
	{
		waitFluentWait(itemT4);
		click(itemT4);
	}
	public void clickItemT5()
	{
		waitFluentWait(itemT5);
		click(itemT5);
	}
	
	public void clickItemT6()
	{
		waitFluentWait(itemT6);
		click(itemT6);
	}
	public void clickItemT7()
	{
		waitFluentWait(itemT7);
		click(itemT7);
	}
	
	public void clickItemT8()
	{
		waitFluentWait(itemT8);
		click(itemT8);
	}
	public void clickItemT9()
	{
		waitFluentWait(itemT9);
		click(itemT9);
	}
	
	public void clickItemT10()
	{
		waitFluentWait(itemT10);
		click(itemT10);
	}
	
	public void clickItemT11()
	{
		waitFluentWait(itemT11);
		click(itemT11);
	}
	
	public void clickItemT12()
	{
		waitFluentWait(itemT12);
		click(itemT12);
	}
	
	public void clickItemT13()
	{
		waitFluentWait(itemT13);
		click(itemT13);
	}
	
	public void clickItemT14()
	{
		waitFluentWait(itemT14);
		click(itemT14);
	}
	public void clickItemT15()
	{
		waitFluentWait(itemT15);
		click(itemT15);
	}
	
	public void clickItemT16()
	{
		waitFluentWait(itemT16);
		click(itemT16);
	}
	public void clickItemT17()
	{
		waitFluentWait(itemT17);
		click(itemT17);
	}
	
	public void clickItemT18()
	{
		waitFluentWait(itemT18);
		click(itemT18);
	}
	public void clickItemT19()
	{
		waitFluentWait(itemT19);
		click(itemT19);
	}
	
	public void clickItemT20()
	{
		waitFluentWait(itemT20);
		click(itemT20);
	}
	
	public void clickItemT21()
	{
		waitFluentWait(itemT21);
		click(itemT21);
	}
	
	public void clickItemT22()
	{
		waitFluentWait(itemT22);
		click(itemT22);
	}
	
	public void clickItemT23()
	{
		waitFluentWait(itemT23);
		click(itemT23);
	}
	
	public void clickItemT24()
	{
		waitFluentWait(itemT24);
		click(itemT24);
	}
	public void clickItemT25()
	{
		waitFluentWait(itemT25);
		click(itemT25);
	}
	
	public void clickItemT26()
	{
		waitFluentWait(itemT26);
		click(itemT26);
	}
	public void clickItemT27()
	{
		waitFluentWait(itemT27);
		click(itemT27);
	}
	
	public void clickItemT28()
	{
		waitFluentWait(itemT28);
		click(itemT28);
	}
	public void clickItemT29()
	{
		waitFluentWait(itemT29);
		click(itemT29);
	}
	
	public void clickItemT30()
	{
		waitFluentWait(itemT30);
		click(itemT30);
	}
	public void clickItemT31()
	{
		waitFluentWait(itemT31);
		click(itemT31);
	}
	
	public void clickItemT32()
	{
		waitFluentWait(itemT32);
		click(itemT32);
	}
	
	public void clickItemT33()
	{
		waitFluentWait(itemT33);
		click(itemT33);
	}
	
	public void clickItemT34()
	{
		waitFluentWait(itemT34);
		click(itemT34);
	}
	public void clickItemT35()
	{
		waitFluentWait(itemT35);
		click(itemT35);
	}
	
	public void clickItemT36()
	{
		waitFluentWait(itemT36);
		click(itemT36);
	}
	public void clickItemT37()
	{
		waitFluentWait(itemT37);
		click(itemT37);
	}
	
	public void clickItemT38()
	{
		waitFluentWait(itemT38);
		click(itemT38);
	}
	public void clickItemT39()
	{
		waitFluentWait(itemT39);
		click(itemT39);
	}
	
	public void clickItemT40()
	{
		waitFluentWait(itemT40);
		click(itemT40);
	}
	public void clickItemT41()
	{
		waitFluentWait(itemT41);
		click(itemT41);
	}
	
	public void clickItemT42()
	{
		waitFluentWait(itemT42);
		click(itemT42);
	}
	
	public void clickItemT43()
	{
		waitFluentWait(itemT43);
		click(itemT43);
	}
	
	public void clickItemT44()
	{
		waitFluentWait(itemT44);
		click(itemT44);
	}
	public void clickItemT45()
	{
		waitFluentWait(itemT45);
		click(itemT45);
	}
	
	public void clickItemT46()
	{
		waitFluentWait(itemT46);
		click(itemT46);
	}
	public void clickItemT47()
	{
		waitFluentWait(itemT47);
		click(itemT47);
	}
	
	public void clickItemT48()
	{
		waitFluentWait(itemT48);
		click(itemT48);
	}
	public void clickItemT49()
	{
		waitFluentWait(itemT49);
		click(itemT49);
	}
	
	public void clickItemT50()
	{
		waitFluentWait(itemT50);
		click(itemT50);
	}
	public void clickItemT51()
	{
		waitFluentWait(itemT51);
		click(itemT51);
	}
	
	public void clickItemT52()
	{
		waitFluentWait(itemT52);
		click(itemT52);
	}
	
	public void clickItemT53()
	{
		waitFluentWait(itemT53);
		click(itemT53);
	}
	
	public void clickItemT54()
	{
		waitFluentWait(itemT54);
		click(itemT54);
	}
	public void clickItemT55()
	{
		waitFluentWait(itemT55);
		click(itemT55);
	}
	
	public void clickItemT56()
	{
		waitFluentWait(itemT56);
		click(itemT56);
	}
	public void clickItemT57()
	{
		waitFluentWait(itemT57);
		click(itemT57);
	}
	
	public void clickItemT58()
	{
		waitFluentWait(itemT58);
		click(itemT58);
	}
	public void clickItemT59()
	{
		waitFluentWait(itemT59);
		click(itemT59);
	}
	
	public void clickItemT60()
	{
		waitFluentWait(itemT60);
		click(itemT60);
	}
	public void clickItemT61()
	{
		waitFluentWait(itemT61);
		click(itemT61);
	}
	
	public void clickItemT62()
	{
		waitFluentWait(itemT62);
		click(itemT62);
	}
	
	public void clickItemT63()
	{
		waitFluentWait(itemT63);
		click(itemT63);
	}
	
	public void clickItemT64()
	{
		waitFluentWait(itemT64);
		click(itemT64);
	}
	public void clickItemT65()
	{
		waitFluentWait(itemT65);
		click(itemT65);
	}
	
	public void clickItemT66()
	{
		waitFluentWait(itemT66);
		click(itemT66);
	}
	public void clickItemT67()
	{
		waitFluentWait(itemT67);
		click(itemT67);
	}
	
	public void clickItemT68()
	{
		waitFluentWait(itemT68);
		click(itemT68);
	}
	public void clickItemT69()
	{
		waitFluentWait(itemT69);
		click(itemT69);
	}
	
	public void clickItemT70()
	{
		waitFluentWait(itemT70);
		click(itemT70);
	}
	public void clickItemT71()
	{
		waitFluentWait(itemT71);
		click(itemT71);
	}
	
	public void clickItemT72()
	{
		waitFluentWait(itemT72);
		click(itemT72);
	}
	
	public void clickItemT73()
	{
		waitFluentWait(itemT73);
		click(itemT73);
	}
	
	public void clickItemT74()
	{
		waitFluentWait(itemT74);
		click(itemT74);
	}
	public void clickItemT75()
	{
		waitFluentWait(itemT75);
		click(itemT75);
	}
	
	public void clickItemT76()
	{
		waitFluentWait(itemT76);
		click(itemT76);
	}
	public void clickItemT77()
	{
		waitFluentWait(itemT77);
		click(itemT77);
	}
	
	public void clickItemT78()
	{
		waitFluentWait(itemT78);
		click(itemT78);
	}
	public void clickItemT79()
	{
		waitFluentWait(itemT79);
		click(itemT79);
	}
	
	public void clickItemT80()
	{
		waitFluentWait(itemT80);
		click(itemT80);
	}
	public void clickItemT81()
	{
		waitFluentWait(itemT81);
		click(itemT1);
	}
	
	public void clickItemT82()
	{
		waitFluentWait(itemT82);
		click(itemT82);
	}
	
	public void clickItemT83()
	{
		waitFluentWait(itemT83);
		click(itemT83);
	}
	
	public void clickItemT84()
	{
		waitFluentWait(itemT84);
		click(itemT84);
	}
	public void clickItemT85()
	{
		waitFluentWait(itemT85);
		click(itemT85);
	}
	
	public void clickItemT86()
	{
		waitFluentWait(itemT86);
		click(itemT86);
	}
	public void clickItemT87()
	{
		waitFluentWait(itemT87);
		click(itemT87);
	}
	
	public void clickItemT88()
	{
		waitFluentWait(itemT88);
		click(itemT88);
	}
	public void clickItemT89()
	{
		waitFluentWait(itemT89);
		click(itemT89);
	}
	
	public void clickItemT900()
	{
		waitFluentWait(itemT90);
		click(itemT90);
	}
	
	public void clickItemT91()
	{
		waitFluentWait(itemT91);
		click(itemT91);
	}
	
	public void clickItemT92()
	{
		waitFluentWait(itemT92);
		click(itemT92);
	}
	
	public void clickItemT93()
	{
		waitFluentWait(itemT93);
		click(itemT93);
	}
	
	public void clickItemT94()
	{
		waitFluentWait(itemT94);
		click(itemT94);
	}
	public void clickItemT95()
	{
		waitFluentWait(itemT95);
		click(itemT95);
	}
	
	public void clickItemT96()
	{
		waitFluentWait(itemT96);
		click(itemT96);
	}
	public void clickItemT97()
	{
		waitFluentWait(itemT97);
		click(itemT97);
	}
	
	public void clickItemT98()
	{
		waitFluentWait(itemT98);
		click(itemT98);
	}
	public void clickItemT99()
	{
		waitFluentWait(itemT99);
		click(itemT99);
	}
	
	public void clickItemT100()
	{
		waitFluentWait(itemT100);
		click(itemT100);
	}
	
	By drplistInterval = By.xpath("//span[@aria-owns='ddlInterval_listbox']");
	By item0Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[1]");
	By item1Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[2]");
	By item2Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[3]");
	By item3Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[4]");
	By item4Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[5]");
	By item5Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[6]");
	By item6Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[7]");
	By item7Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[8]");
	By item8Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[9]");
	By item9Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[10]");
	By item10Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[11]");
	By item11Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[12]");
	By item12Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[13]");
	By item13Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[14]");
	By item14Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[15]");
	By item15Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[16]");
	By item16Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[17]");
	By item17Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[18]");
	By item18Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[19]");
	By item19Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[20]");
	By item20Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[21]");
	By item21Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[22]");
	By item22Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[23]");
	By item23Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[24]");
	By item24Motnh = By.xpath("(//ul[@id='ddlInterval_listbox'])/li[25]");
	
	public void clickDrplistInterval()
	{
		waitFluentWait(drplistInterval);
		click(drplistInterval);
	}
	
	public void clickItem0Motnh()
	{
		waitFluentWait(item0Motnh);
		click(item0Motnh);
	}
	
	public void clickItem1Motnh()
	{
		waitFluentWait(item1Motnh);
		click(item1Motnh);
	}
	
	public void clickItem2Motnh()
	{
		waitFluentWait(item2Motnh);
		click(item2Motnh);
	}
	
	public void clickItem3Motnh()
	{
		waitFluentWait(item3Motnh);
		click(item3Motnh);
	}
		
	public void clickItem4Motnh()
	{
		waitFluentWait(item4Motnh);
		click(item4Motnh);
	}
	
	public void clickItem5Motnh()
	{
		waitFluentWait(item5Motnh);
		click(item5Motnh);
	}
	
	public void clickItem6Motnh()
	{
		waitFluentWait(item6Motnh);
		click(item6Motnh);
	}
	
	public void clickItem7Motnh()
	{
		waitFluentWait(item7Motnh);
		click(item7Motnh);
	}

	public void clickItem8Motnh()
	{
		waitFluentWait(item8Motnh);
		click(item8Motnh);
	}
	
	public void clickItem9Motnh()
	{
		waitFluentWait(item9Motnh);
		click(item9Motnh);
	}
	
	public void clickItem10Motnh()
	{
		waitFluentWait(item10Motnh);
		click(item10Motnh);
	}
	
	public void clickItem11Motnh()
	{
		waitFluentWait(item11Motnh);
		click(item11Motnh);
	}
	
	public void clickItem12Motnh()
	{
		waitFluentWait(item12Motnh);
		click(item12Motnh);
	}
	
	public void clickItem13Motnh()
	{
		waitFluentWait(item13Motnh);
		click(item13Motnh);
	}
		
	public void clickItem14Motnh()
	{
		waitFluentWait(item14Motnh);
		click(item14Motnh);
	}
	
	public void clickItem15Motnh()
	{
		waitFluentWait(item15Motnh);
		click(item15Motnh);
	}
	
	public void clickItem16Motnh()
	{
		waitFluentWait(item16Motnh);
		click(item16Motnh);
	}
	
	public void clickItem17Motnh()
	{
		waitFluentWait(item17Motnh);
		click(item17Motnh);
	}

	public void clickItem18Motnh()
	{
		waitFluentWait(item18Motnh);
		click(item18Motnh);
	}
	
	public void clickItem19Motnh()
	{
		waitFluentWait(item19Motnh);
		click(item19Motnh);
	}
	
	public void clickItem20Motnh()
	{
		waitFluentWait(item20Motnh);
		click(item20Motnh);
	}
	
	public void clickItem21Motnh()
	{
		waitFluentWait(item21Motnh);
		click(item21Motnh);
	}
	
	public void clickItem22Motnh()
	{
		waitFluentWait(item22Motnh);
		click(item22Motnh);
	}
	
	public void clickItem23Motnh()
	{
		waitFluentWait(item23Motnh);
		click(item23Motnh);
	}
		
	public void clickItem24Motnh()
	{
		waitFluentWait(item24Motnh);
		click(item24Motnh);
	}
	
	By btnRadioShuffleQuestion = By.xpath("//input[@data-bind='checked: createComplianceTestViewModel.complianceTestModel.shuffleQuestion']");
	By btnRadioShuffleAnswer = By.xpath("//input[@data-bind='checked: createComplianceTestViewModel.complianceTestModel.shuffleAnswer']");
	
	public void clickBtnRadioShuffleQuestion()
	{
		waitFluentWait(btnRadioShuffleQuestion);
		click(btnRadioShuffleQuestion);
	}
		
	public void clickBtnRadioShuffleAnswer()
	{
		waitFluentWait(btnRadioShuffleAnswer);
		click(btnRadioShuffleAnswer);
	}
	
	By btnNextTesting = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.nextStep }'])[2]");
	By btnCancelTesting = By.xpath("(//button[contains(@data-bind,'events:{ click: createComplianceTestViewModel.cancelForm }')])[2]");
	By btnBackTesting = By.xpath("(//button[contains(@data-bind,'events:{ click: createComplianceTestViewModel.prevStep }')])[1]");
		
	public void clickBtnBackTesting()
	{
		waitFluentWait(btnBackTesting);
		click(btnBackTesting);
	}
	
	public void clickBtnNextTesting()
	{
		waitFluentWait(btnNextTesting);
		click(btnNextTesting);
	}
	
	public void clickBtnCancelTesting()
	{
		waitFluentWait(btnCancelTesting);
		click(btnCancelTesting);
	}
	
	//Question
	
	By linkClickHere = By.xpath("(//a[@data-bind='events:{click: importQuestion}'])[1]");
	By btnAddQuestion = By.xpath("(//button[@title='Add questions'])[1]");
	
	public boolean isLinkClickHereDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkClickHere).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkClickHere()
	{
		waitFluentWait(linkClickHere);
		click(linkClickHere);
	}
	
	public void clickBtnAddQuestion()
	{
		waitFluentWait(btnAddQuestion);
		click(btnAddQuestion);
	}
	
	By btnSave = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.saveAsOfficial}, disabled: createComplianceTestViewModel.isDisabledSaveOfficial'])");
	By btnSaveAsTrial = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.saveAsTrial}, disabled: createComplianceTestViewModel.isDisabledSave, visible: createComplianceTestViewModel.isManuallyAssigned'])");
	By btnCancelQuestion = By.xpath("(//button[@data-bind='events:{ click: createComplianceTestViewModel.cancelForm }'])[3]");
	By btnBackQuestion = By.xpath("(//button[contains(@data-bind,'events:{ click: createComplianceTestViewModel.prevStep }')])[2]");
		
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnSaveAsTrial()
	{
		waitFluentWait(btnSaveAsTrial);
		click(btnSaveAsTrial);
	}
	
	public void clickBtnCancelQuestion()
	{
		waitFluentWait(btnCancelQuestion);
		click(btnCancelQuestion);
	}
	
	public void clickBtnBackQuestion()
	{
		waitFluentWait(btnBackQuestion);
		click(btnBackQuestion);
	}
	
	By lblImportQuestion = By.xpath("(//h5[contains(.,'Import Question')])[1]");
	By txtSearchCategoryImport = By.id("searchTextCategory");
	By itemSearchFirstImport = By.xpath("(//ul[@id='searchTextCategory_listbox'])/li[1]");
	By itemFirstImport = By.xpath("(//td[contains(.,'Testing Automation')])[1]");
	By txtSearchQuestionImport = By.xpath("//input[@aria-label='Question']");
	By cboxAllImport = By.xpath("(//label[@class='k-checkbox-label k-no-text'])[3]");
	By cboxFirstImport = By.xpath("(//label[@class='k-checkbox-label k-no-text'])[4]");
	
	public boolean isLblImportQuestionProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblImportQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void searchCategoryImport(String categoryImport)
	{
		waitFluentWait(txtSearchCategoryImport);
		ClickElementAndType(txtSearchCategoryImport, categoryImport);
		waitFluentWait(itemSearchFirstImport);
		click(itemSearchFirstImport);
		waitFluentWait(itemFirstImport);
		click(itemFirstImport);
	}
	
	public void searchQuestionImport(String QuestionImport)
	{
		waitFluentWait(txtSearchQuestionImport);
		goTextOn(txtSearchQuestionImport, QuestionImport);
		click(lblImportQuestion);
	}
	
	public void clickCboxAllImport()
	{
		waitFluentWait(cboxAllImport);
		click(cboxAllImport);
	}
	
	public void clickCboxFirstImport()
	{
		waitFluentWait(cboxFirstImport);
		click(cboxFirstImport);
	}
	
	By btnSaveImport = By.xpath("//button[contains(@data-bind,'events:{click: importQuestionViewModel.confirmImportQuestion},disabled: importQuestionViewModel.isDisableSave')]");
	By btnCancelImport = By.xpath("(//button[contains(@data-bind,'events:{click: importQuestionViewModel.cancelImportQuestion}')])[2]");

	public void clickBtnSaveImport()
	{
		waitFluentWait(btnSaveImport);
		click(btnSaveImport);
	}
	
	public void clickBtnCancelImport()
	{
		waitFluentWait(btnCancelImport);
		click(btnCancelImport);
	}
	
	By lblPreview = By.xpath("(//h5[contains(.,'Preview Question')])[1]");
	By iconDelete1 = By.xpath("(//button[@data-bind='events: {click: deleteQuestion}, visible: isEdit'])[1]");
	By iconReplace = By.xpath("(//a[@data-bind='events: {click: importChangeQuestionViewModel.init}, visible: isEdit'])[1]");
	
	public boolean isLblPreviewlDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblPreview).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconDelete1()
	{
		waitFluentWait(iconDelete1);
		click(iconDelete1);
	}
	
	public void clickIconReplace()
	{
		waitFluentWait(iconReplace);
		click(iconReplace);
	}
	
	By lblReplaceQuestion = By.xpath("(//h5[contains(.,'Replace Question')])[1]");
	By txtSearchCategoryReplace = By.id("searchTextChangeQuestion");
	By itemSearchFirstReplace = By.xpath("(//ul[@id='searchTextChangeQuestion_listbox'])/li[1]");
	By itemFirstReplace = By.xpath("(//span[contains(.,'Testing Automation')])[4]");
	By txtSearchQuestionReplace = By.xpath("(//input[@aria-label='Question'])[2]");
	By cboxFirstReplace = By.xpath("(//*[@id='radioSelectQuestion'])[1]");
	
	public boolean isLblReplaceQuestionProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblReplaceQuestion).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void searchCategoryReplace(String categoryReplace)
	{
		waitFluentWait(txtSearchCategoryReplace);
		ClickElementAndType(txtSearchCategoryReplace, categoryReplace);
		waitFluentWait(itemSearchFirstReplace);
		click(itemSearchFirstReplace);
		waitFluentWait(itemFirstReplace);
		click(itemFirstReplace);
	}
	
	public void searchQuestionReplace(String QuestionReplace)
	{
		waitFluentWait(txtSearchQuestionReplace);
		goTextOn(txtSearchQuestionReplace, QuestionReplace);
		click(lblReplaceQuestion);
	}
	
	public void clickCboxFirstReplace()
	{
		waitFluentWait(cboxFirstReplace);
		click(cboxFirstReplace);
	}
	
	By btnSaveReplace = By.id("btnSaveReplaceQuestion");
	By btnCancelReplace = By.id("btnCancelReplaceQuestion");
	
	public void clickBtnSaveReplace()
	{
		waitFluentWait(btnSaveReplace);
		click(btnSaveReplace);
	}
	
	public void clickBtnCancelReplace()
	{
		waitFluentWait(btnCancelReplace);
		click(btnCancelReplace);
	}
	
}
