package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditAdaptiveTest extends WebActions {

	public Form_EditAdaptiveTest(WebDriver driver) {
		super(driver);
     }

	By lblEditAdaptiveTest = By.xpath("//h4[contains(@data-bind,'text: updateAdaptiveTestViewModel.titleAdaptiveTest')]");
	
	public boolean isLblEditAdaptiveTestProfilelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblEditAdaptiveTest).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Basic information
	By txtTitle = By.id("updateAdaptiveTestTitle");
	By drplistCategory = By.xpath("//span[@aria-owns='updateAdaptiveTestCategory_listbox']");
	By txtDescription = By.xpath("//*[@id=\"tabAdaptiveTestBasicInformation-update\"]/div/div[1]/div[2]/div/table/tbody/tr[2]/td/iframe");
	By btnThumbnail = By.xpath("//a[@data-bind='events:{click: updateAdaptiveTestViewModel.changeThumbnailClick}']");
		
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
	
	public boolean isBtnThumbnailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnThumbnail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnThumbnail()
	{
		waitFluentWait(btnThumbnail);
		click(btnThumbnail);
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
		click(lblEditAdaptiveTest);
	}
	
	By btnNext = By.id("btnUpdateComplianceTestNext");
	By btnCancel = By.id("btnUpdateComplianceTestCancel");
	By btnSave = By.id("btnUpdateComplianceTestSave");
	By btnBack = By.id("btnUpdateComplianceTestBack");
	
	public void clickBtnSave()
	{
		waitFluentWait(btnSave);
		click(btnSave);
	}
	
	public void clickBtnNext()
	{
		waitFluentWait(btnNext);
		click(btnNext);
	}
	
	public void clickBtnCancel()
	{
		waitFluentWait(btnCancel);
		click(btnCancel);
	}
	
	public void clickBtnBack()
	{
		waitFluentWait(btnBack);
		click(btnBack);
	}
	
	//Testing Settings
	
	By lblRestriction = By.xpath("(//label[contains(.,'Restriction')])[8]");
	
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
	
	By btnRadioVariable = By.xpath("//input[@data-bind='checked: updateAdaptiveTestViewModel.setDefault,events: {change: updateAdaptiveTestViewModel.changeVariableSwitch}']");
	By drplistVariable = By.xpath("//span[@aria-owns='ddlvariableUpdate-adaptive_listbox']");
	By item03 = By.xpath("(//ul[@id='ddlvariableUpdate-adaptive_listbox'])/li[1]");
	By item04 = By.xpath("(//ul[@id='ddlvariableUpdate-adaptive_listbox'])/li[2]");
	
	public void clickBtnRadiobtnRadioVariable()
	{
		waitFluentWait(btnRadioVariable);
		click(btnRadioVariable);
	}
	
	public void clickDrplistVariable()
	{
		waitFluentWait(drplistVariable);
		click(drplistVariable);
	}
	
	public void clickItem03()
	{
		waitFluentWait(item03);
		click(item03);
	}
	
	public void clickItem04()
	{
		waitFluentWait(item04);
		click(item04);
	}
	
	By btnRadioFixed = By.xpath("//input[@data-bind='checked: updateAdaptiveTestViewModel.setDefault, events:{change: updateAdaptiveTestViewModel.changeNumberOfQuestionSwitch}']");
	
	public void clickBtnRadioFixed()
	{
		waitFluentWait(btnRadioFixed);
		click(btnRadioFixed);
	}
	
	By btnSwitchTestSettings = By.xpath("//*[@id='tabAdaptiveTestSetting-Update']/div[2]/div[1]/ul/li/div/div/label/input");
	By drplistTimes = By.xpath("//span[@aria-owns='ddlTimeUpdate-Adaptive_listbox']");
	By itemTUnlimited = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[1]");
	By itemT1 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[2]");
	By itemT2 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[3]");
	By itemT3 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[4]");
	By itemT4 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[5]");
	By itemT5 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[6]");
	By itemT6 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[7]");
	By itemT7 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[8]");
	By itemT8 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[9]");
	By itemT9 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[10]");
	By itemT10 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[11]");
	By itemT11 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[12]");
	By itemT12 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[13]");
	By itemT13 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[14]");
	By itemT14 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[15]");
	By itemT15 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[16]");
	By itemT16 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[17]");
	By itemT17 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[18]");
	By itemT18 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[19]");
	By itemT19 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[20]");
	By itemT20 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[21]");
	By itemT21 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[22]");
	By itemT22 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[23]");
	By itemT23 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[24]");
	By itemT24 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[25]");
	By itemT25 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[26]");
	By itemT26 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[27]");
	By itemT27 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[28]");
	By itemT28 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[29]");
	By itemT29 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[30]");
	By itemT30 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[31]");
	By itemT31 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[32]");
	By itemT32 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[33]");
	By itemT33 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[34]");
	By itemT34 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[35]");
	By itemT35 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[36]");
	By itemT36 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[37]");
	By itemT37 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[38]");
	By itemT38 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[39]");
	By itemT39 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[40]");
	By itemT40 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[41]");
	By itemT41 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[42]");
	By itemT42 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[43]");
	By itemT43 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[44]");
	By itemT44 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[45]");
	By itemT45 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[46]");
	By itemT46 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[47]");
	By itemT47 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[48]");
	By itemT48 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[49]");
	By itemT49 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[50]");
	By itemT50 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[51]");
	By itemT51 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[52]");
	By itemT52 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[53]");
	By itemT53 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[54]");
	By itemT54 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[55]");
	By itemT55 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[56]");
	By itemT56 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[57]");
	By itemT57 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[58]");
	By itemT58 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[59]");
	By itemT59 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[60]");
	By itemT60 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[61]");
	By itemT61 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[62]");
	By itemT62 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[63]");
	By itemT63 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[64]");
	By itemT64 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[65]");
	By itemT65 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[66]");
	By itemT66 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[67]");
	By itemT67 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[68]");
	By itemT68 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[69]");
	By itemT69 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[70]");
	By itemT70 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[71]");
	By itemT71 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[72]");
	By itemT72 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[73]");
	By itemT73 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[74]");
	By itemT74 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[75]");
	By itemT75 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[76]");
	By itemT76 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[77]");
	By itemT77 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[78]");
	By itemT78 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[79]");
	By itemT79 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[80]");
	By itemT80 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[81]");
	By itemT81 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[82]");
	By itemT82 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[83]");
	By itemT83 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[84]");
	By itemT84 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[85]");
	By itemT85 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[86]");
	By itemT86 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[87]");
	By itemT87 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[88]");
	By itemT88 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[89]");
	By itemT89 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[90]");
	By itemT90 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[91]");
	By itemT91 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[92]");
	By itemT92 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[93]");
	By itemT93 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[94]");
	By itemT94 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[95]");
	By itemT95 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[96]");
	By itemT96 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[97]");
	By itemT97 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[98]");
	By itemT98 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[99]");
	By itemT99 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[100]");
	By itemT100 = By.xpath("(//ul[@id='ddlTimeUpdate-Adaptive_listbox'])/li[101]");

	public void clickBtnSwitchTestSettings()
	{
		waitFluentWait(btnSwitchTestSettings);
		click(btnSwitchTestSettings);
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
	
	By drplistInterval = By.xpath("//span[@aria-owns='ddlIntervalUpdate-Adaptive_listbox']");
	By item0Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[1]");
	By item1Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[2]");
	By item2Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[3]");
	By item3Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[4]");
	By item4Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[5]");
	By item5Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[6]");
	By item6Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[7]");
	By item7Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[8]");
	By item8Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[9]");
	By item9Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[10]");
	By item10Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[11]");
	By item11Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[12]");
	By item12Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[13]");
	By item13Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[14]");
	By item14Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[15]");
	By item15Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[16]");
	By item16Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[17]");
	By item17Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[18]");
	By item18Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[19]");
	By item19Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[20]");
	By item20Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[21]");
	By item21Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[22]");
	By item22Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[32]");
	By item23Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[24]");
	By item24Motnh = By.xpath("(//ul[@id='ddlIntervalUpdate-Adaptive_listbox'])/li[25]");
	
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
		
	By cboxSkillLevelResult = By.xpath("//input[contains(@data-bind,'checked: createAdaptiveTestViewModel.adaptiveTestModel.skillLevelResultAttendeeView')]");
	By cboxTestResult = By.xpath("//input[contains(@data-bind,'checked: createAdaptiveTestViewModel.adaptiveTestModel.testResultAttendeeView')]");
	
	public void clickCboxSkillLevelResult()
	{
		waitFluentWait(cboxSkillLevelResult);
		click(cboxSkillLevelResult);
	}
	
	public void clickCboxTestResult()
	{
		waitFluentWait(cboxTestResult);
		click(cboxTestResult);
	}
	
	//Question
	
	By lblQuestionPool = By.xpath("(//label[contains(.,'Question Pool*')])[1]");
	
	public boolean isLblQuestionPoolDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblQuestionPool).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By drplistQuestionPool1 = By.xpath("(//div[contains(@role,'listbox')])[2]");
	By itemCompetency1 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool0_listbox']/li)[1]");
	By itemCompliance1 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool0_listbox']/li)[2]");
	By itemKnowlegdeCheck1 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool0_listbox']/li)[3]");
	By itemTraining1 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool0_listbox']/li)[4]");
	
	public void clickDrplistQuestionPool1()
	{
		waitFluentWait(drplistQuestionPool1);
		click(drplistQuestionPool1);
	}
	
	public void clickItemCompetency1()
	{
		waitFluentWait(itemCompetency1);
		click(itemCompetency1);
	}
	
	public void clickItemCompliance1()
	{
		waitFluentWait(itemCompliance1);
		click(itemCompliance1);
	}
	
	public void clickItemKnowlegdeCheck1()
	{
		waitFluentWait(itemKnowlegdeCheck1);
		click(itemKnowlegdeCheck1);
	}
	
	public void clickItemTraining1()
	{
		waitFluentWait(itemTraining1);
		click(itemTraining1);
	}
	
	By drplistSkill1 = By.xpath("(//div[contains(@role,'listbox')])[3]");
	By itemSkill1 = By.xpath("//li[contains(.,'Test Automation 1')]");
	By btnAddQuestion1 = By.xpath("(//button[@data-bind='click: updateAdaptiveTestViewModel.plusQuestion'])[1]");
	
	public void clickDrplistSkill1(String skill)
	{
		waitFluentWait(drplistSkill1);
		ClickElementAndType(drplistSkill1, skill);
	}
	
	public void clickItemSkill1()
	{
		waitFluentWait(itemSkill1);
		click(itemSkill1);
	}
	
	public void clickBtnAddQuestion1()
	{
		waitFluentWait(btnAddQuestion1);
		click(btnAddQuestion1);
	}
	
	By drplistQuestionPool2 = By.xpath("(//div[contains(@role,'listbox')])[4]");
	By itemCompetency2 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool1_listbox']/li)[1]");
	By itemCompliance2 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool1_listbox']/li)[2]");
	By itemKnowlegdeCheck2 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool1_listbox']/li)[3]");
	By itemTraining2 = By.xpath("(//ul[@id='ddlUpdateAdaptiveQuestionPool1_listbox']/li)[4]");
	
	public void clickDrplistQuestionPool2()
	{
		waitFluentWait(drplistQuestionPool2);
		click(drplistQuestionPool2);
	}
	
	public void clickItemCompetency2()
	{
		waitFluentWait(itemCompetency2);
		click(itemCompetency2);
	}
	
	public void clickItemCompliance2()
	{
		waitFluentWait(itemCompliance2);
		click(itemCompliance2);
	}
	
	public void clickItemKnowlegdeCheck2()
	{
		waitFluentWait(itemKnowlegdeCheck2);
		click(itemKnowlegdeCheck2);
	}
	
	public void clickItemTraining2()
	{
		waitFluentWait(itemTraining2);
		click(itemTraining2);
	}
	
	By drplistSkill2 = By.xpath("(//div[contains(@role,'listbox')])[5]");
	By itemSkill2 = By.xpath("//li[contains(.,'Test Automation 2')]");
	By btnAddQuestion2 = By.xpath("(//button[@data-bind='click: updateAdaptiveTestViewModel.plusQuestion'])[2]");
	By btnRemoveQuestion2 = By.xpath("(//button[@data-bind='click: updateAdaptiveTestViewModel.minusQuestion'])[2]");
	
	public void clickDrplistSkill2(String skill)
	{
		waitFluentWait(drplistSkill2);
		ClickElementAndType(drplistSkill2, skill);
	}
	
	public void clickItemSkill2()
	{
		waitFluentWait(itemSkill2);
		click(itemSkill2);
	}
	
	public void clickBtnAddQuestion2()
	{
		waitFluentWait(btnAddQuestion2);
		click(btnAddQuestion2);
	}
	
	public void clickBtnRemoveQuestion2()
	{
		waitFluentWait(btnRemoveQuestion2);
		click(btnRemoveQuestion2);
	}
	
	public boolean isBtnAddQuestion2lDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAddQuestion2).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnRemoveQuestion2lDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnRemoveQuestion2).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Popup Confirm
	By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By btnNo = By.xpath("//button[contains(.,'No')]");
			
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
			
	public void clickBtnYes()
	{
		waitFluentWait(btnYes);
		click(btnYes);
	}

	public void clickBtnNo()
	{
		waitFluentWait(btnNo);
		click(btnNo);
	}
		
}
