package pages;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;
//Descip action in page

public class EditCustomerPagePO extends AbstractPage {
	WebDriver driver;

	public EditCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public boolean marquee() {
		waitForElementVisible(driver, HomePageUI.MARQUEE_TEXT);
		return isControlDisplayed(driver, HomePageUI.MARQUEE_TEXT);
	}

}
