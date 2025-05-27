package wize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class LoginScreen extends WebActions {

	By lblWelcomeTo = By.id("header");
	By txtEmail = By.id("email");
	By txtPassword = By.id("password");
	By btnLogin = By.id("frmLoginSubmit");
	By iconControlBoard = By.id("link-control-board");

	public LoginScreen(WebDriver driver) {
		super(driver);
        phongToCuaSoTrinhDuyet();
	}

	public boolean isLblWelcomeToDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblWelcomeTo).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconControlBoard()
	{
		waitFluentWait(iconControlBoard);
		click(iconControlBoard);
	}
	
	public void fillEmail(String email) {
		waitFluentWait(txtEmail);
		ClickElementAndType(txtEmail, email);
	}

	public void fillPassword(String password) {
		waitFluentWait(txtPassword);
		ClickElementAndType(txtPassword, password);
	}

	public void clickButtonSignin() {
		waitFluentWait(btnLogin);
		click(btnLogin);
	}
	
	public void SignInWith(String Email, String Password) {
		fillEmail(Email);
		fillPassword(Password);
		clickButtonSignin();
		sleep(6);
		waitFluentWait(iconControlBoard);
		clickIconControlBoard();
	}
	
	public void SignInWithoutControlBoard(String Email, String Password) {
		fillEmail(Email);
		fillPassword(Password);
		clickButtonSignin();
		sleep(6);
	}

}
