package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Ulties.DataManager;
import controller.WebActions;

public class LearningContentPool extends WebActions{
	public LearningContentPool(WebDriver driver) {
		super(driver);
	}
	
	By breadcrumbLearningContentPool = By.xpath("(//div[@id='main']//li)[2]");
	By lblCategory = By.xpath("//section[@id='category-section']//h6");
	By categoryAll = By.xpath("//span[@class='item-question-pool-category'][contains(.,'All')]");
	By btnCreateCategory = By.xpath("//button[@data-target-box='#create-category']");
	By txtSearchCategory = By.id("searchText");
	By firstCategory = By.xpath("//div[@id='category-list-treelist']//span[4]");
	By childCategory = By.xpath("//div[@id='category-list-treelist']//span[5]");
	By lblNoDataSearchCategory = By.xpath("(//div[@id='category-list-treelist']//span[1])[2]");
	By iconEditCategory = By.id("action-edit");
	By iconEditChildCategory = By.xpath("(//a[@id='action-edit'])[2]");
	By iconDeleteCategory = By.id("action-delete");
	By iconDots = By.xpath("(//div[@id='category-list-treelist']//i)[1]");
	By iconDotsChild = By.xpath("(//div[@id='category-list-treelist']//i)[4]");
	By iconRemoveSearchCategory = By.xpath("(//section[@id='category-section']//span[1])[2]");
	By lblLearningContent = By.xpath("//div[@id='question-pool-main-div']//h3");
	By txtSearchLearningContent = By.xpath("//input[@aria-label='Learning Content']");
	By iconSearchCategory = By.xpath("//button[@class='btn btn-secondary']");
	By suggestBoxNoData = By.xpath("//div[@id='searchText-list']/div[@class='k-nodata']/div");
	By suggestBoxResult = By.xpath("//div[@class='k-list-scroller']/ul[@id='searchText_listbox']/li");
	By firstLinkResult = By.xpath("(//a[@class='text open-slide view-content-detail'])[1]");
	By btnCreateContent = By.xpath("//button[@title='Create Content']");
	
	public boolean isBreadcrumbDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(breadcrumbLearningContentPool).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isFolderAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(categoryAll).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconRemoveSearchCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconRemoveSearchCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	} 
	
	public boolean isLblLearningContentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblLearningContent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconEditCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconEditCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconDeleteCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconDeleteCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateContentDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreateContent).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconSearchCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(iconSearchCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isNoDataDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(suggestBoxNoData).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isCategoryResultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(suggestBoxResult).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkSuggestionBox1Character(){
		boolean flag = false;
		try {
			waitFluentWait(txtSearchCategory);
			driver.findElement(txtSearchCategory).clear();
			driver.findElement(txtSearchCategory).sendKeys("c");
			sleep(3);
			if(!isCategoryResultDisplayed() && !isNoDataDisplayed()){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkSuggestionBox2InvalidCharacters(){
		boolean flag = false;
		try {
			waitFluentWait(txtSearchCategory);
			driver.findElement(txtSearchCategory).clear();
			driver.findElement(txtSearchCategory).sendKeys("XXX auto");
			sleep(3);
			if(isNoDataDisplayed() && driver.findElement(suggestBoxNoData).getText().equals("NO DATA FOUND.")){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkSuggestionBox2ValidCharacters(){
		boolean flag = false;
		try {
			waitFluentWait(txtSearchCategory);
			driver.findElement(txtSearchCategory).clear();
			driver.findElement(txtSearchCategory).sendKeys(DataManager.LearningContent);
			sleep(3);
			if(isCategoryResultDisplayed()){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkTooltipCreateCategory(String tooltip){
		boolean flag = false;
		waitFluentWait(btnCreateCategory);
		try {
			if(driver.findElement(btnCreateCategory).getAttribute("title").equals(tooltip)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkTooltipDeleteCategory(String tooltip){
		boolean flag = false;
		waitFluentWait(iconDeleteCategory);
		try {
			if(driver.findElement(iconDeleteCategory).getAttribute("title").equals(tooltip)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkTooltipEditCategory(String tooltip){
		boolean flag = false;
		waitFluentWait(iconEditCategory);
		try {
			if(driver.findElement(iconEditCategory).getAttribute("title").equals(tooltip)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean checkPlaceHolderSearchCategoryFiled(String placeholder){
		boolean flag = false;
		waitFluentWait(txtSearchCategory);
		try {
			if(driver.findElement(txtSearchCategory).getAttribute("placeholder").equals(placeholder)){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean islblNoDataSearchCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblNoDataSearchCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSearchCleared()
	{
		boolean flag = false;
		clickIconRemoveCategory();
		try {
			if (driver.findElement(txtSearchCategory).getText().equals("")) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void selectSuggestionBox()
	{
		waitFluentWait(txtSearchCategory);
		driver.findElement(txtSearchCategory).clear();
		driver.findElement(txtSearchCategory).sendKeys("Ch");
		waitFluentWait(suggestBoxResult);
		click(suggestBoxResult);
		sleep(1);
	}
	
	public void clickBtnCreateCategory()
	{
		waitFluentWait(btnCreateCategory);
		click(btnCreateCategory);
		sleep(2);
	}
	
	public void clickIconEditCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconEditCategory);
		click(iconEditCategory);
	}
	
	public void clickIconEditChildCategory()
	{
		moveHoverElement(driver.findElement(childCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDotsChild));
		waitFluentWait(iconEditChildCategory);
		click(iconEditChildCategory);
	}
	
	public void clickIconDeleteCategory()
	{
		moveHoverElement(driver.findElement(firstCategory));
		sleep(1);
		moveHoverElement(driver.findElement(iconDots));
		waitFluentWait(iconDeleteCategory);
		click(iconDeleteCategory);
	}
	
	public boolean checkConfirmDeletePopupContent(){
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath("//div[@id='dialogBoxCategory']")).getText().equals("Are you sure you want to delete the selected category? If you continue, Learning contents belong to category will be moved to the nearest parent category.")) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By rowCategory = By.xpath("//div[@id='category-list-treelist']//tbody/tr[1]");
	public boolean isCategoryAllSelected(){
		boolean flag = false;
		waitFluentWait(itemAll);
		try {
			if(driver.findElement(rowCategory).getAttribute("aria-selected") != null){
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void fillSearchCategoryFast(String searchcategory)
	{
		waitFluentWait(txtSearchCategory);
		ClickElementAndType(txtSearchCategory, searchcategory);
	}
	
	public void fillSearchCategory(String searchcategory)
	{
		waitFluentWait(txtSearchCategory);
		goTextOn(txtSearchCategory, searchcategory);
	}

	public void clickFirstCategory()
	{
		waitFluentWait(firstCategory);
		click(firstCategory);
	}
	
	public void selectCategory(String searchcategory)
	{
		fillSearchCategory(searchcategory);
		clickFirstCategory();
	}
	
	public boolean isFirstCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(firstCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isChildCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(childCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//Create Category Popup
		By lblCreateCategory = By.xpath("//h4[@title='Create Category']");
		By drplistParentCategory = By.xpath("(//form[@id='create-Category-form']//span)[1]");
		By itemAll = By.xpath("(//ul[@id='CreateParentId_listbox']/li)[1]");
		By txtCategoryName = By.id("createName");
		By drplistUser = By.xpath("//form[@id='create-Category-form']/div[4]//div[1]");
		By itemUser = By.xpath("//*[@id='CreateApproversUsers-list']//li[1]");
		By btnSave = By.id("saveCategory");
		By btnCancel = By.xpath("//button[@id='cancelCategory'][1]");
		By btnXcategory = By.xpath("//div[@id='create-category-box']//button[@title='Close']");
		
		
		public boolean isLblCreateCategoryDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(lblCreateCategory).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickIconRemoveCategory()
		{
			moveHoverElement(driver.findElement(txtSearchCategory));
			waitFluentWait(iconRemoveSearchCategory);
			click(iconRemoveSearchCategory);
		}
		
		public void clickLblCreateCategory()
		{
			waitFluentWait(lblCreateCategory);
			click(lblCreateCategory);
		}
		
		public void selectParentCategoryAll()
		{
			waitFluentWait(drplistParentCategory);
			ClickElement(drplistParentCategory);
			sleep(5);
			click(itemAll);
		}
		
		By parent_category = By.xpath("//input[@aria-owns='CreateParentId_listbox']");
		public void selectParentCategory(String parent)
		{
			waitFluentWait(drplistParentCategory);
			ClickElement(drplistParentCategory);
			sleep(5);
			goTextOn(parent_category, parent);
		}
		
		public void clickBtnSave()
		{
			waitFluentWait(btnSave);
			click(btnSave);
		}
		
		public void clickBtnCancel()
		{
			waitFluentWait(btnCancel);
			click(btnCancel);
		}
		
		public void clickBtnClose()
		{
			waitFluentWait(btnXcategory);
			click(btnXcategory);
		}
		
		public boolean isBtnSaveDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnSave).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnCancelDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnCancel).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnCloseDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnXcategory).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnSaveEnable()
		{
			boolean flag = false;
			try {
				if (driver.findElement(btnSave).isEnabled()) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isBtnCancelEnable()
		{
			boolean flag = false;
			try {
				if (driver.findElement(btnCancel).isEnabled()) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void fillCategoryName(String categoryname)
		{
			waitFluentWait(txtCategoryName);
			ClickElementAndType(txtCategoryName, categoryname);
		}
		
		public void clearInputCategoryName(){
			driver.findElement(txtCategoryName).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.findElement(txtCategoryName).sendKeys(Keys.BACK_SPACE);
		}
		
		public void selectUser(String user)
		{
			waitFluentWait(drplistUser);
			ClickElementAndType(drplistUser, user);
			sleep(5);
			click(itemUser);
			sleep(1);
		}
		
		public boolean _19314_instead(){
			waitFluentWait(drplistUser);
			ClickElementAndType(drplistUser, "inte-aaron.jimenez@tek-experts.com");
			sleep(5);
			boolean flag = false;
			try {
				if (isItemUserDisplayed()) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isItemUserDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(itemUser).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
			
		public void createCategory(String categoryname,String user)
		{
			clickBtnCreateCategory();
			selectParentCategoryAll();
			fillCategoryName(categoryname);
			selectUser(user);
			clickBtnSave();
		}
		
		public void createChildCategory(String categoryname,String user)
		{
			clickBtnCreateCategory();
			selectParentCategory(DataManager.LearningContent);
			fillCategoryName(categoryname);
			selectUser(user);
			clickBtnSave();
		}
		
		//Edit Category Popup
		By txtUpdateCategoryName = By.id("EditName");
		By iconRemove = By.xpath("(//ul[@id='EditApproversUsers_taglist']//span)[5]");
		
		public void fillUpdateCategoryName(String Updatecategoryname)
		{
			waitFluentWait(txtUpdateCategoryName);
			ClickElementAndType(txtUpdateCategoryName, Updatecategoryname);
		}
		
		public void clickIconRemove()
		{
			waitFluentWait(iconRemove);
			click(iconRemove);
		}
		
		By iconExpand = By.xpath("//span[@title='Expand']");
		By iconCollapse = By.xpath("(//span[@title='Collapse'])[2]");
		
		public void clickExpandCategory()
		{
			waitFluentWait(iconExpand);
			click(iconExpand);
		}
		
		public void clickCollapseCategory()
		{
			waitFluentWait(iconCollapse);
			click(iconCollapse);
		}
		
		public boolean isIconExpandDisplayed(){
			boolean flag = false;
			try {
				if (driver.findElements(iconExpand).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public boolean isIconCollapseDisplayed(){
			boolean flag = false;
			try {
				if (driver.findElements(iconCollapse).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		//Popup Confirm Delete
		By lblConfirmation = By.xpath("//span[contains(.,'Confirmation')]");

		By btnYesAll = By.xpath("(//button[contains(.,'YES')])[2]");
		By btnYesSignle = By.xpath("(//button[contains(.,'YES')])[2]");
		By btnYesCategory = By.xpath("(//button[contains(.,'YES')])[1]");

		By btnNo = By.xpath("//button[contains(.,'NO')]");
		By msgSuccess = By.xpath("//div[contains(@class,'alert-text')]");
		public void clickBtnYesCategory()
		{
			waitFluentWait(btnYesCategory);
			click(btnYesCategory);
		}
		
		public boolean isMsgSuccessDisplayed(){
			boolean flag = false;
			try {
				if (driver.findElements(msgSuccess).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		// LCP = Learning Content Pool
		public void searchLCP(String search){
			waitFluentWait(txtSearchLearningContent);
			ClickElementAndType(txtSearchLearningContent, search);
		}
		
		public void clickFirstLinkResult(){
			waitFluentWait(firstLinkResult);
			click(firstLinkResult);
		}
		
		public int countCharacter(By by){
			System.out.println(driver.findElement(by).getText());
			int no = driver.findElement(by).getText().length();
			return no;
		}
		
		public String getTextFirstItemCategory(){
			String catName = "";
			try {
				catName = driver.findElement(firstCategory).getText();
			} catch (Exception e) {
				return "No data";
			}
			return catName;
		}
		
		public String getTextChildItemCategory(){
			String catName = "";
			try {
				catName = driver.findElement(childCategory).getText();
			} catch (Exception e) {
				return "No data";
			}
			return catName;
		}
		
		public String getTextMsgSuccess(){
			String msg = "";
			try {
				msg = driver.findElement(msgSuccess).getText();
			} catch (Exception e) {
				return "No data";
			}
			return msg;
		}
}
