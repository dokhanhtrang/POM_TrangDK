package pages;

import org.openqa.selenium.WebDriver;
import bankguru.NewCustomerUI;
import commons.AbstractPage;

public class NewCustomerPO extends AbstractPage {
	WebDriver driver;

	public NewCustomerPO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputToCustomerName(String cusName) {
		waitForElementPresence(driver, NewCustomerUI.CUSTOMERNAME_TXT);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMERNAME_TXT, cusName);
	}

	public void inputEmptyCustomerName() {
		waitForElementPresence(driver, NewCustomerUI.CUSTOMERNAME_TXT);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMERNAME_TXT, "");
	}
	public void inputNumbericCustomerName() {
		waitForElementPresence(driver, NewCustomerUI.CUSTOMERNAME_TXT);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMERNAME_TXT, "12");
	}
	public void inputScharCustomerName() {
		waitForElementPresence(driver, NewCustomerUI.CUSTOMERNAME_TXT);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMERNAME_TXT, "@");
	}
	public void inputSpaceFCustomerName() {
		waitForElementPresence(driver, NewCustomerUI.CUSTOMERNAME_TXT);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMERNAME_TXT, " ");
	}

	public void clickOut() {
		clickToElement(driver, NewCustomerUI.CLICKOUT_LBL);
		if (isControlDisplayed(driver, NewCustomerUI.CUSTOMERNAME_BLANK_TXT) == true) {
			System.out.println("Pass case customer name musnt blank");
		}
		else if (isControlDisplayed(driver, NewCustomerUI.CUSTOMERNAME_NUMBERIC_TXT) == true) {
			System.out.println("Pass case customer name isnt number ");
		}
		else if (isControlDisplayed(driver, NewCustomerUI.CUSTOMERNAME_SCHAR_TXT) == true) {
			System.out.println("Pass case customer name cannot input special character");
		}
		else if (isControlDisplayed(driver, NewCustomerUI.CUSTOMERNAME_SPACEF_TXT) == true) {
			System.out.println("Pass case customer cannot start from Space");
		}
		;
	}

	public void checkFGender() {
		waitForElementPresence(driver, NewCustomerUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, NewCustomerUI.GENDER_FEMALE_RADIO);
	}

	public void checkMGender() {
		waitForElementPresence(driver, NewCustomerUI.GENDER_MALE_RADIO);
		clickToElement(driver, NewCustomerUI.GENDER_MALE_RADIO);
	}

	public void inputToDOB(String dob) {
		waitForElementPresence(driver, NewCustomerUI.DATE_OF_BIRTH_TXT);
		sendKeyToElement(driver, NewCustomerUI.DATE_OF_BIRTH_TXT, dob);
	}

	public void inputToAdd(String add) {
		waitForElementPresence(driver, NewCustomerUI.ADDRESS_TXT);
		sendKeyToElement(driver, NewCustomerUI.ADDRESS_TXT, add);
	}

	public void inputToCity(String city) {
		waitForElementPresence(driver, NewCustomerUI.CITY_TXT);
		sendKeyToElement(driver, NewCustomerUI.CITY_TXT, city);
	}

	public void inputToState(String state) {
		waitForElementPresence(driver, NewCustomerUI.STATE_TXT);
		sendKeyToElement(driver, NewCustomerUI.STATE_TXT, state);
	}

	public void inputToPIN(String pin) {
		waitForElementPresence(driver, NewCustomerUI.PIN_TXT);
		sendKeyToElement(driver, NewCustomerUI.PIN_TXT, pin);
	}

	public void inputToEmail(String email) {
		waitForElementPresence(driver, NewCustomerUI.EMAIL_TXT);
		sendKeyToElement(driver, NewCustomerUI.EMAIL_TXT, email);
	}

	public void inputToPhoneNo(String phoneNo) {
		waitForElementPresence(driver, NewCustomerUI.MOBILE_PHONE_TXT);
		sendKeyToElement(driver, NewCustomerUI.MOBILE_PHONE_TXT, phoneNo);
	}

	public void inputToPassword(String pass) {
		waitForElementPresence(driver, NewCustomerUI.PASSWORD_TXT);
		sendKeyToElement(driver, NewCustomerUI.PASSWORD_TXT, pass);
	}

	public void clickToSubmitBtn() {
		waitForElementPresence(driver, NewCustomerUI.SUBMIT_BTN);
		clickToElement(driver, NewCustomerUI.SUBMIT_BTN);
	}

	public void clickToResetBtn() {
		waitForElementPresence(driver, NewCustomerUI.RESET_BTN);
		clickToElement(driver, NewCustomerUI.RESET_BTN);
	}

	public String getCustomerIdInfor() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_ID_LBL);
		return getTextElement(driver, NewCustomerUI.CUSTOMER_ID_LBL);
	}

}
