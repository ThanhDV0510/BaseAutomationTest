package wize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.DataManager;
import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import controller.WebDriversManager;
import wize.pages.ControlBoard;
import wize.pages.Form_CreatePosition;
import wize.pages.Form_EditPosition;
import wize.pages.Form_PositionDetails;
import wize.pages.LoginScreen;
import wize.pages.PositionList;

public class Test_Functional_PositionList extends TestManager {
	LoginScreen loginScreen;
	WebDriver driver;
	PropertyManager propertyManager;
	ControlBoard controlBoard;
	PositionList positionList;
	Form_PositionDetails formPositionDetails;
	Form_CreatePosition formCreatePosition;
	Form_EditPosition formEditPosition;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		loginScreen = new LoginScreen(driver);
		controlBoard = new ControlBoard(driver);
		positionList = new PositionList(driver);
		formPositionDetails = new Form_PositionDetails(driver);
		formCreatePosition = new Form_CreatePosition(driver);
		formEditPosition = new Form_EditPosition(driver);
		loginScreen.moLinkWeb(propertyManager.getURL_LnD());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1, enabled = false)

	public void TT_13187() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on icon Add >> Input all required fields >> Click on button Save");

		positionList.fillSearchPosition(DataManager.Functional);

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.deletePosition();

			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			// formCreatePosition.inputDataFunction("manager","Developer","Not
			// to be used","DP_VNM","10001-Product Owner","10002-Product
			// Owner","Engineer L1","Professional","11494");
			formCreatePosition.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Saves created Position to Position list\r\n" + "3. Redirects to Position List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			if (positionList.isLinkFirstPostionDisplayed() == true) {
				setStatusTest("pass", "Saves created Position to Position list");
			} else {
				setStatusTest("fail", "Not Saves created Position to Position list");
			}

			if (positionList.isLblPostionListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Position List");
			} else {
				setStatusTest("fail", "Not Redirects to Position List");
			}
		} else {
			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			// formCreatePosition.inputDataFunction("manager","Developer","Not
			// to be used","DP_VNM","10001-Product Owner","10002-Product
			// Owner","Engineer L1","Professional","11494");
			formCreatePosition.clickBtnSave();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Saves created Position to Position list\r\n" + "3. Redirects to Position List");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			if (positionList.isLinkFirstPostionDisplayed() == true) {
				setStatusTest("pass", "Saves created Position to Position list");
			} else {
				setStatusTest("fail", "Not Saves created Position to Position list");
			}

			if (positionList.isLblPostionListDisplayed() == true) {
				setStatusTest("pass", "Redirects to Position List");
			} else {
				setStatusTest("fail", "Not Redirects to Position List");
			}
		}

	}

	@Test(priority = 2, enabled = false)

	public void TT_13190() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on icon Add >> Input all required fields >> Click on button Save");

		positionList.fillSearchPosition(DataManager.Functional);

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.deletePosition();

			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		} else {
			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		}

	}

	@Test(priority = 3, enabled = false)

	public void TT_13334() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on link position >> Click on button Edit");

		positionList.fillSearchPosition(DataManager.Functional);
		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.deletePosition();

			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		} else {
			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		}
		positionList.clickLinkFirstPostion();
		formPositionDetails.clickIconEdit();

		if (formEditPosition.isLblEditPositionDisplayed() == true) {
			setStatusTest("pass", "Open Edit Position popup");
		} else {
			setStatusTest("fail", "Not Open Create Position popup");
		}

		TestLogger.info("4. Update data >> Click on button Save");
		formEditPosition.fillPositionName(DataManager.Functional);
		formEditPosition.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position updated successfully\r\n"
				+ "2. Saves updated Position to Position list\r\n" + "3. Redirects to Position List");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Position updated successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Position updated successfully");
		}

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			setStatusTest("pass", "Saves updated Position to Position list");
		} else {
			setStatusTest("fail", "Not Saves updated Position to Position list");
		}

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Redirects to Position List");
		} else {
			setStatusTest("fail", "Not Redirects to Position List");
		}

	}

	@Test(priority = 4, enabled = false)

	public void TT_14260() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on button Edit");

		positionList.fillSearchPosition(DataManager.Functional);
		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.deletePosition();

			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		} else {
			positionList.clickBtnCreate();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Open Create Position popup");
			} else {
				setStatusTest("fail", "Not Open Create Position popup");
			}

			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSavenCreateNew();

			TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position created successfully\r\n"
					+ "2. Entire forms display as default, no data is inputted");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position created successfully");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position created successfully");
			}

			formCreatePosition.clickBtnCancel();

			if (formCreatePosition.isLblCreatePositionDisplayed() == true) {
				setStatusTest("pass", "Entire forms display as default, no data is inputted");
			} else {
				setStatusTest("fail", "Not Entire forms display as default, no data is inputted");
			}
		}
		positionList.clickIconEdit();

		if (formEditPosition.isLblEditPositionDisplayed() == true) {
			setStatusTest("pass", "Open Edit Position popup");
		} else {
			setStatusTest("fail", "Not Open Create Position popup");
		}

		TestLogger.info("4. Update data >> Click on button Save");
		formEditPosition.fillPositionName(DataManager.Functional);
		formEditPosition.clickBtnSave();

		TestLogger.info("Expect : User CAN see/do: \r\n" + "1. Position updated successfully\r\n"
				+ "2. Saves updated Position to Position list\r\n" + "3. Redirects to Position List");

		if (DataManager.isMsgSuccessDisplayed() == true) {
			setStatusTest("pass", "System displays msg: " + "Position updated successfully");
		} else {
			setStatusTest("fail", "System NOT displays msg: " + "Position updated successfully");
		}

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			setStatusTest("pass", "Saves updated Position to Position list");
		} else {
			setStatusTest("fail", "Not Saves updated Position to Position list");
		}

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Redirects to Position List");
		} else {
			setStatusTest("fail", "Not Redirects to Position List");
		}

	}

	@Test(priority = 5, enabled = false)

	public void TT_12996() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on any Position >> Click on Delete button >> Click on Yes button");

		positionList.fillSearchPosition(DataManager.Functional);

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.clickLinkFirstPostion();
			formPositionDetails.clickIconDelete();

			if (positionList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				positionList.clickBtnYes();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully.");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position deleted successfully.");
			}

		} else {
			positionList.clickBtnCreate();
			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSave();
			positionList.fillSearchPosition(DataManager.Functional);
			positionList.clickLinkFirstPostion();
			formPositionDetails.clickIconDelete();

			if (positionList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				positionList.clickBtnYes();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully.");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position deleted successfully.");
			}
		}
	}

	@Test(priority = 6, enabled = false)

	public void TT_12987() throws InterruptedException {
		TestLogger.info("1. Login with account.");

		loginScreen.SignInWith(PropertyManager.EmailAdmin, PropertyManager.PASSWORD);

		if (controlBoard.isLblControlBoardDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Access to Position List");

		controlBoard.clickLblPosition();

		if (positionList.isLblPostionListDisplayed() == true) {
			setStatusTest("pass", "Access to Position List");
		} else {
			setStatusTest("fail", "Not Access to Position List");
		}

		TestLogger.info("3. Click on Delete button >> Click on Yes button");

		positionList.fillSearchPosition(DataManager.Functional);

		if (positionList.isLinkFirstPostionDisplayed() == true) {
			positionList.clickIconDelete();

			if (positionList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				positionList.clickBtnYes();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully.");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position deleted successfully.");
			}

		} else {
			positionList.clickBtnCreate();
			formCreatePosition.inputData(DataManager.Functional, DataManager.Test, DataManager.Test);
			formCreatePosition.clickBtnSave();
			positionList.clickLinkFirstPostion();
			formPositionDetails.clickIconDelete();

			if (positionList.isLblConfirmationDisplayed() == true) {
				setStatusTest("pass", "Open Comfirm popup");
				positionList.clickBtnYes();
			} else {
				setStatusTest("fail", "Not Open Comfirm popup");
			}

			TestLogger.info("Expect : User CAN see/do: " + "Position deleted successfully.");

			if (DataManager.isMsgSuccessDisplayed() == true) {
				setStatusTest("pass", "System displays msg: " + "Position deleted successfully.");
			} else {
				setStatusTest("fail", "System NOT displays msg: " + "Position deleted successfully.");
			}
		}
	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		if (controlBoard.isAvatarDisplayed() == true) {
			controlBoard.logout();
		}

		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
