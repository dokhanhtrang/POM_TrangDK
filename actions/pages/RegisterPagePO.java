package pages;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;

import bankguru.RegisterPageUI;
import commons.AbstractPage;

//Descip action in page

public class RegisterPagePO extends AbstractPage {
	WebDriver driver;

	public RegisterPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputToEmailIDdTxt(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TXT);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TXT, email);
	}
	public String getEmailInfo(String value) {
		return getTextElement(driver, value);
	}

	public void clickToSubmitBtn() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
	}

	public String getUserIdInfor() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordInfor() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPagePO openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
	}

}
